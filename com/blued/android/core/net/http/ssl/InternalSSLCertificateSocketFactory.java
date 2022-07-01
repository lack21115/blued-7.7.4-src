package com.blued.android.core.net.http.ssl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLSocketImpl;
import org.conscrypt.SSLClientSessionCache;

public class InternalSSLCertificateSocketFactory extends SSLSocketFactory {
  private static final TrustManager[] a = new TrustManager[] { new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
        
        public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
        
        public X509Certificate[] getAcceptedIssuers() {
          return null;
        }
      } };
  
  private SSLSocketFactory b;
  
  private SSLSocketFactory c;
  
  private TrustManager[] d;
  
  private KeyManager[] e;
  
  private byte[] f;
  
  private byte[] g;
  
  private PrivateKey h;
  
  private final int i;
  
  private final SSLClientSessionCache j;
  
  private final boolean k;
  
  private InternalSSLCertificateSocketFactory(int paramInt, InternalSSLSessionCache paramInternalSSLSessionCache, boolean paramBoolean) {
    Field field2 = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = paramInt;
    this.k = paramBoolean;
    Field field1 = field2;
    if (paramInternalSSLSessionCache != null)
      try {
        field1 = paramInternalSSLSessionCache.getClass().getDeclaredField("mSessionCache");
        field1.setAccessible(true);
        SSLClientSessionCache sSLClientSessionCache = (SSLClientSessionCache)field1.get(paramInternalSSLSessionCache);
      } catch (Exception exception) {
        exception.printStackTrace();
        field1 = field2;
      }  
    this.j = (SSLClientSessionCache)field1;
  }
  
  private SSLSocketFactory a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
    //   6: ifne -> 66
    //   9: aload_0
    //   10: getfield b : Ljavax/net/ssl/SSLSocketFactory;
    //   13: ifnonnull -> 57
    //   16: aload_0
    //   17: getfield k : Z
    //   20: ifeq -> 34
    //   23: ldc 'SSLCertificateSocket'
    //   25: ldc '*** BYPASSING SSL SECURITY CHECKS (socket.relaxsslcheck=yes) ***'
    //   27: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: goto -> 42
    //   34: ldc 'SSLCertificateSocket'
    //   36: ldc 'Bypassing SSL security checks at caller's request'
    //   38: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: aload_0
    //   44: aload_0
    //   45: getfield e : [Ljavax/net/ssl/KeyManager;
    //   48: getstatic com/blued/android/core/net/http/ssl/InternalSSLCertificateSocketFactory.a : [Ljavax/net/ssl/TrustManager;
    //   51: invokespecial a : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;)Ljavax/net/ssl/SSLSocketFactory;
    //   54: putfield b : Ljavax/net/ssl/SSLSocketFactory;
    //   57: aload_0
    //   58: getfield b : Ljavax/net/ssl/SSLSocketFactory;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: aload_0
    //   67: getfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   70: ifnonnull -> 89
    //   73: aload_0
    //   74: aload_0
    //   75: aload_0
    //   76: getfield e : [Ljavax/net/ssl/KeyManager;
    //   79: aload_0
    //   80: getfield d : [Ljavax/net/ssl/TrustManager;
    //   83: invokespecial a : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;)Ljavax/net/ssl/SSLSocketFactory;
    //   86: putfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   89: aload_0
    //   90: getfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	98	finally
    //   34	42	98	finally
    //   42	57	98	finally
    //   57	62	98	finally
    //   66	89	98	finally
    //   89	94	98	finally
  }
  
  public static SSLSocketFactory a(int paramInt, InternalSSLSessionCache paramInternalSSLSessionCache) {
    return new InternalSSLCertificateSocketFactory(paramInt, paramInternalSSLSessionCache, false);
  }
  
  private SSLSocketFactory a(KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager) {
    try {
      if (Conscrypt.isAvailable()) {
        X509TrustManager x509TrustManager = Conscrypt.getDefaultX509TrustManager();
        SSLContext sSLContext = SSLContext.getInstance("TLS", "Conscrypt");
        sSLContext.init(null, new TrustManager[] { x509TrustManager }, null);
        return sSLContext.getSocketFactory();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return (SSLSocketFactory)SSLSocketFactory.getDefault();
  }
  
  private static OpenSSLSocketImpl a(Socket paramSocket) {
    if (paramSocket instanceof OpenSSLSocketImpl)
      return (OpenSSLSocketImpl)paramSocket; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Socket not created by this factory: ");
    stringBuilder.append(paramSocket);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static void a(Socket paramSocket, String paramString) throws IOException {
    if (paramSocket instanceof javax.net.ssl.SSLSocket) {
      paramSocket = paramSocket;
      paramSocket.startHandshake();
      SSLSession sSLSession = paramSocket.getSession();
      if (sSLSession != null) {
        if (HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, sSLSession))
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot verify hostname: ");
        stringBuilder.append(paramString);
        throw new SSLPeerUnverifiedException(stringBuilder.toString());
      } 
      throw new SSLException("Cannot verify SSL socket without session");
    } 
    throw new IllegalArgumentException("Attempt to verify non-SSL socket");
  }
  
  public void a(Socket paramSocket, boolean paramBoolean) {
    a(paramSocket).setUseSessionTickets(paramBoolean);
  }
  
  public void a(SSLContext paramSSLContext, SSLSocketFactory paramSSLSocketFactory) {
    Conscrypt.setClientSessionCache(paramSSLContext, this.j);
    this.b = paramSSLSocketFactory;
  }
  
  public void b(Socket paramSocket, String paramString) {
    a(paramSocket).setHostname(paramString);
  }
  
  public Socket createSocket() throws IOException {
    OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl)a().createSocket();
    openSSLSocketImpl.setNpnProtocols(this.f);
    openSSLSocketImpl.setAlpnProtocols(this.g);
    openSSLSocketImpl.setHandshakeTimeout(this.i);
    openSSLSocketImpl.setChannelIdPrivateKey(this.h);
    return (Socket)openSSLSocketImpl;
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException {
    OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl)a().createSocket(paramString, paramInt);
    openSSLSocketImpl.setNpnProtocols(this.f);
    openSSLSocketImpl.setAlpnProtocols(this.g);
    openSSLSocketImpl.setHandshakeTimeout(this.i);
    openSSLSocketImpl.setChannelIdPrivateKey(this.h);
    if (this.k)
      a((Socket)openSSLSocketImpl, paramString); 
    return (Socket)openSSLSocketImpl;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException {
    OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl)a().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    openSSLSocketImpl.setNpnProtocols(this.f);
    openSSLSocketImpl.setAlpnProtocols(this.g);
    openSSLSocketImpl.setHandshakeTimeout(this.i);
    openSSLSocketImpl.setChannelIdPrivateKey(this.h);
    if (this.k)
      a((Socket)openSSLSocketImpl, paramString); 
    return (Socket)openSSLSocketImpl;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl)a().createSocket(paramInetAddress, paramInt);
    openSSLSocketImpl.setNpnProtocols(this.f);
    openSSLSocketImpl.setAlpnProtocols(this.g);
    openSSLSocketImpl.setHandshakeTimeout(this.i);
    openSSLSocketImpl.setChannelIdPrivateKey(this.h);
    return (Socket)openSSLSocketImpl;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl)a().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    openSSLSocketImpl.setNpnProtocols(this.f);
    openSSLSocketImpl.setAlpnProtocols(this.g);
    openSSLSocketImpl.setHandshakeTimeout(this.i);
    openSSLSocketImpl.setChannelIdPrivateKey(this.h);
    return (Socket)openSSLSocketImpl;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl)a().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    openSSLSocketImpl.setNpnProtocols(this.f);
    openSSLSocketImpl.setAlpnProtocols(this.g);
    openSSLSocketImpl.setHandshakeTimeout(this.i);
    openSSLSocketImpl.setChannelIdPrivateKey(this.h);
    if (this.k)
      a((Socket)openSSLSocketImpl, paramString); 
    return (Socket)openSSLSocketImpl;
  }
  
  public String[] getDefaultCipherSuites() {
    return a().getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites() {
    return a().getSupportedCipherSuites();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\ssl\InternalSSLCertificateSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */