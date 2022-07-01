package com.squareup.okhttp.internal.io;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.CertificateChainCleaner;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection implements Connection {
  private static SSLSocketFactory lastSslSocketFactory;
  
  private static TrustRootIndex lastTrustRootIndex;
  
  public final List<Reference<StreamAllocation>> allocations = new ArrayList<Reference<StreamAllocation>>();
  
  public volatile FramedConnection framedConnection;
  
  private Handshake handshake;
  
  public long idleAtNanos = Long.MAX_VALUE;
  
  public boolean noNewStreams;
  
  private Protocol protocol;
  
  private Socket rawSocket;
  
  private final Route route;
  
  public BufferedSink sink;
  
  public Socket socket;
  
  public BufferedSource source;
  
  public int streamCount;
  
  public RealConnection(Route paramRoute) {
    this.route = paramRoute;
  }
  
  private void connectSocket(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    this.rawSocket.setSoTimeout(paramInt2);
    try {
      Platform.get().connectSocket(this.rawSocket, this.route.getSocketAddress(), paramInt1);
      this.source = Okio.buffer(Okio.source(this.rawSocket));
      this.sink = Okio.buffer(Okio.sink(this.rawSocket));
      if (this.route.getAddress().getSslSocketFactory() != null) {
        connectTls(paramInt2, paramInt3, paramConnectionSpecSelector);
      } else {
        this.protocol = Protocol.HTTP_1_1;
        this.socket = this.rawSocket;
      } 
      if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
        this.socket.setSoTimeout(0);
        FramedConnection framedConnection = (new FramedConnection.Builder(true)).socket(this.socket, this.route.getAddress().url().host(), this.source, this.sink).protocol(this.protocol).build();
        framedConnection.sendConnectionPreface();
        this.framedConnection = framedConnection;
      } 
      return;
    } catch (ConnectException connectException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to connect to ");
      stringBuilder.append(this.route.getSocketAddress());
      throw new ConnectException(stringBuilder.toString());
    } 
  }
  
  private void connectTls(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    if (this.route.requiresTunnel())
      createTunnel(paramInt1, paramInt2); 
    Address address = this.route.getAddress();
    SSLSocketFactory sSLSocketFactory = address.getSslSocketFactory();
    Handshake handshake = null;
    ConnectionSpec connectionSpec = null;
    ConnectionSpecSelector connectionSpecSelector2 = null;
    try {
      SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(this.rawSocket, address.getUriHost(), address.getUriPort(), true);
      try {
        connectionSpec = paramConnectionSpecSelector.configureSecureSocket(sSLSocket);
        if (connectionSpec.supportsTlsExtensions())
          Platform.get().configureTlsExtensions(sSLSocket, address.getUriHost(), address.getProtocols()); 
        sSLSocket.startHandshake();
        handshake = Handshake.get(sSLSocket.getSession());
        if (address.getHostnameVerifier().verify(address.getUriHost(), sSLSocket.getSession())) {
          String str;
          Protocol protocol;
          if (address.getCertificatePinner() != CertificatePinner.DEFAULT) {
            List list = (new CertificateChainCleaner(trustRootIndex(address.getSslSocketFactory()))).clean(handshake.peerCertificates());
            address.getCertificatePinner().check(address.getUriHost(), list);
          } 
          paramConnectionSpecSelector = connectionSpecSelector2;
          if (connectionSpec.supportsTlsExtensions())
            str = Platform.get().getSelectedProtocol(sSLSocket); 
          this.socket = sSLSocket;
          this.source = Okio.buffer(Okio.source(this.socket));
          this.sink = Okio.buffer(Okio.sink(this.socket));
          this.handshake = handshake;
          if (str != null) {
            protocol = Protocol.get(str);
          } else {
            protocol = Protocol.HTTP_1_1;
          } 
          this.protocol = protocol;
          return;
        } 
        X509Certificate x509Certificate = handshake.peerCertificates().get(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hostname ");
        stringBuilder.append(address.getUriHost());
        stringBuilder.append(" not verified:");
        stringBuilder.append("\n    certificate: ");
        stringBuilder.append(CertificatePinner.pin(x509Certificate));
        stringBuilder.append("\n    DN: ");
        stringBuilder.append(x509Certificate.getSubjectDN().getName());
        stringBuilder.append("\n    subjectAltNames: ");
        stringBuilder.append(OkHostnameVerifier.allSubjectAltNames(x509Certificate));
        throw new SSLPeerUnverifiedException(stringBuilder.toString());
      } catch (AssertionError assertionError1) {
        SSLSocket sSLSocket1 = sSLSocket;
      } finally {
        AssertionError assertionError1;
        paramConnectionSpecSelector = null;
      } 
    } catch (AssertionError assertionError) {
      ConnectionSpec connectionSpec1 = connectionSpec;
    } finally {}
    ConnectionSpecSelector connectionSpecSelector1 = paramConnectionSpecSelector;
    if (Util.isAndroidGetsocknameError(assertionError)) {
      connectionSpecSelector1 = paramConnectionSpecSelector;
      throw new IOException(assertionError);
    } 
    connectionSpecSelector1 = paramConnectionSpecSelector;
    throw assertionError;
  }
  
  private void createTunnel(int paramInt1, int paramInt2) throws IOException {
    Request request = createTunnelRequest();
    HttpUrl httpUrl = request.httpUrl();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CONNECT ");
    stringBuilder.append(httpUrl.host());
    stringBuilder.append(":");
    stringBuilder.append(httpUrl.port());
    stringBuilder.append(" HTTP/1.1");
    String str = stringBuilder.toString();
    while (true) {
      Http1xStream http1xStream = new Http1xStream(null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      http1xStream.writeRequest(request.headers(), str);
      http1xStream.finishRequest();
      Response response = http1xStream.readResponse().request(request).build();
      long l2 = OkHeaders.contentLength(response);
      long l1 = l2;
      if (l2 == -1L)
        l1 = 0L; 
      Source source = http1xStream.newFixedLengthSource(l1);
      Util.skipAll(source, 2147483647, TimeUnit.MILLISECONDS);
      source.close();
      int i = response.code();
      if (i != 200) {
        Request request1;
        if (i == 407) {
          request1 = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), response, this.route.getProxy());
          if (request1 != null)
            continue; 
          throw new IOException("Failed to authenticate with proxy");
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected response code for CONNECT: ");
        stringBuilder1.append(request1.code());
        throw new IOException(stringBuilder1.toString());
      } 
      if (this.source.buffer().exhausted() && this.sink.buffer().exhausted())
        return; 
      throw new IOException("TLS tunnel buffered too many bytes!");
    } 
  }
  
  private Request createTunnelRequest() throws IOException {
    return (new Request.Builder()).url(this.route.getAddress().url()).header("Host", Util.hostHeader(this.route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  private static TrustRootIndex trustRootIndex(SSLSocketFactory paramSSLSocketFactory) {
    // Byte code:
    //   0: ldc com/squareup/okhttp/internal/io/RealConnection
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic com/squareup/okhttp/internal/io/RealConnection.lastSslSocketFactory : Ljavax/net/ssl/SSLSocketFactory;
    //   7: if_acmpeq -> 32
    //   10: invokestatic get : ()Lcom/squareup/okhttp/internal/Platform;
    //   13: aload_0
    //   14: invokevirtual trustManager : (Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;
    //   17: astore_1
    //   18: invokestatic get : ()Lcom/squareup/okhttp/internal/Platform;
    //   21: aload_1
    //   22: invokevirtual trustRootIndex : (Ljavax/net/ssl/X509TrustManager;)Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   25: putstatic com/squareup/okhttp/internal/io/RealConnection.lastTrustRootIndex : Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   28: aload_0
    //   29: putstatic com/squareup/okhttp/internal/io/RealConnection.lastSslSocketFactory : Ljavax/net/ssl/SSLSocketFactory;
    //   32: getstatic com/squareup/okhttp/internal/io/RealConnection.lastTrustRootIndex : Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   35: astore_0
    //   36: ldc com/squareup/okhttp/internal/io/RealConnection
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: astore_0
    //   42: ldc com/squareup/okhttp/internal/io/RealConnection
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	41	finally
    //   32	36	41	finally
  }
  
  public int allocationLimit() {
    FramedConnection framedConnection = this.framedConnection;
    return (framedConnection != null) ? framedConnection.maxConcurrentStreams() : 1;
  }
  
  public void cancel() {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, List<ConnectionSpec> paramList, boolean paramBoolean) throws RouteException {
    if (this.protocol == null) {
      RouteException routeException;
      ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(paramList);
      Proxy proxy = this.route.getProxy();
      Address address = this.route.getAddress();
      if (this.route.getAddress().getSslSocketFactory() != null || paramList.contains(ConnectionSpec.CLEARTEXT)) {
        paramList = null;
        while (this.protocol == null) {
          try {
            Socket socket;
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
              socket = address.getSocketFactory().createSocket();
            } else {
              socket = new Socket(proxy);
            } 
            this.rawSocket = socket;
            connectSocket(paramInt1, paramInt2, paramInt3, connectionSpecSelector);
          } catch (IOException iOException) {
            Util.closeQuietly(this.socket);
            Util.closeQuietly(this.rawSocket);
            this.socket = null;
            this.rawSocket = null;
            this.source = null;
            this.sink = null;
            this.handshake = null;
            this.protocol = null;
            if (paramList == null) {
              routeException = new RouteException(iOException);
            } else {
              routeException.addConnectException(iOException);
            } 
            if (paramBoolean && connectionSpecSelector.connectionFailed(iOException))
              continue; 
            throw routeException;
          } 
        } 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CLEARTEXT communication not supported: ");
      stringBuilder.append(routeException);
      throw new RouteException(new UnknownServiceException(stringBuilder.toString()));
    } 
    throw new IllegalStateException("already connected");
  }
  
  public Handshake getHandshake() {
    return this.handshake;
  }
  
  public Protocol getProtocol() {
    Protocol protocol = this.protocol;
    return (protocol != null) ? protocol : Protocol.HTTP_1_1;
  }
  
  public Route getRoute() {
    return this.route;
  }
  
  public Socket getSocket() {
    return this.socket;
  }
  
  boolean isConnected() {
    return (this.protocol != null);
  }
  
  public boolean isHealthy(boolean paramBoolean) {
    if (!this.socket.isClosed() && !this.socket.isInputShutdown()) {
      if (this.socket.isOutputShutdown())
        return false; 
      if (this.framedConnection != null)
        return true; 
      if (paramBoolean)
        try {
          int i = this.socket.getSoTimeout();
          try {
            this.socket.setSoTimeout(1);
            paramBoolean = this.source.exhausted();
            if (paramBoolean)
              return false; 
            return true;
          } finally {
            this.socket.setSoTimeout(i);
          } 
        } catch (SocketTimeoutException socketTimeoutException) {
          return true;
        } catch (IOException iOException) {
          return false;
        }  
      return true;
    } 
    return false;
  }
  
  public boolean isMultiplexed() {
    return (this.framedConnection != null);
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Connection{");
    stringBuilder.append(this.route.getAddress().url().host());
    stringBuilder.append(":");
    stringBuilder.append(this.route.getAddress().url().port());
    stringBuilder.append(", proxy=");
    stringBuilder.append(this.route.getProxy());
    stringBuilder.append(" hostAddress=");
    stringBuilder.append(this.route.getSocketAddress());
    stringBuilder.append(" cipherSuite=");
    Handshake handshake = this.handshake;
    if (handshake != null) {
      str = handshake.cipherSuite();
    } else {
      str = "none";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" protocol=");
    stringBuilder.append(this.protocol);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\io\RealConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */