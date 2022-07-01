package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.Closeable;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine {
  private static final ResponseBody EMPTY_BODY = new ResponseBody() {
      public long contentLength() {
        return 0L;
      }
      
      public MediaType contentType() {
        return null;
      }
      
      public BufferedSource source() {
        return (BufferedSource)new Buffer();
      }
    };
  
  public static final int MAX_FOLLOW_UPS = 20;
  
  public final boolean bufferRequestBody;
  
  private BufferedSink bufferedRequestBody;
  
  private Response cacheResponse;
  
  private CacheStrategy cacheStrategy;
  
  private final boolean callerWritesRequestBody;
  
  final OkHttpClient client;
  
  private final boolean forWebSocket;
  
  private HttpStream httpStream;
  
  private Request networkRequest;
  
  private final Response priorResponse;
  
  private Sink requestBodyOut;
  
  long sentRequestMillis = -1L;
  
  private CacheRequest storeRequest;
  
  public final StreamAllocation streamAllocation;
  
  private boolean transparentGzip;
  
  private final Request userRequest;
  
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse) {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    if (paramStreamAllocation == null)
      paramStreamAllocation = new StreamAllocation(paramOkHttpClient.getConnectionPool(), createAddress(paramOkHttpClient, paramRequest)); 
    this.streamAllocation = paramStreamAllocation;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
  }
  
  private Response cacheWritingResponse(final CacheRequest cacheRequest, Response paramResponse) throws IOException {
    if (cacheRequest == null)
      return paramResponse; 
    Sink sink = cacheRequest.body();
    if (sink == null)
      return paramResponse; 
    Source source = new Source() {
        boolean cacheRequestClosed;
        
        public void close() throws IOException {
          if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            cacheRequest.abort();
          } 
          source.close();
        }
        
        public long read(Buffer param1Buffer, long param1Long) throws IOException {
          try {
            param1Long = source.read(param1Buffer, param1Long);
            if (param1Long == -1L) {
              if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                cacheBody.close();
              } 
              return -1L;
            } 
            param1Buffer.copyTo(cacheBody.buffer(), param1Buffer.size() - param1Long, param1Long);
            cacheBody.emitCompleteSegments();
            return param1Long;
          } catch (IOException iOException) {
            if (!this.cacheRequestClosed) {
              this.cacheRequestClosed = true;
              cacheRequest.abort();
            } 
            throw iOException;
          } 
        }
        
        public Timeout timeout() {
          return source.timeout();
        }
      };
    return paramResponse.newBuilder().body(new RealResponseBody(paramResponse.headers(), Okio.buffer(source))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2) throws IOException {
    Headers.Builder builder = new Headers.Builder();
    int j = paramHeaders1.size();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if ((!"Warning".equalsIgnoreCase(str1) || !str2.startsWith("1")) && (!OkHeaders.isEndToEnd(str1) || paramHeaders2.get(str1) == null))
        builder.add(str1, str2); 
    } 
    j = paramHeaders2.size();
    for (i = bool; i < j; i++) {
      String str = paramHeaders2.name(i);
      if (!"Content-Length".equalsIgnoreCase(str) && OkHeaders.isEndToEnd(str))
        builder.add(str, paramHeaders2.value(i)); 
    } 
    return builder.build();
  }
  
  private HttpStream connect() throws RouteException, RequestException, IOException {
    boolean bool = this.networkRequest.method().equals("GET");
    return this.streamAllocation.newStream(this.client.getConnectTimeout(), this.client.getReadTimeout(), this.client.getWriteTimeout(), this.client.getRetryOnConnectionFailure(), bool ^ true);
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest) {
    SSLSocketFactory sSLSocketFactory1;
    SSLSocketFactory sSLSocketFactory2;
    SSLSocketFactory sSLSocketFactory3;
    if (paramRequest.isHttps()) {
      sSLSocketFactory2 = paramOkHttpClient.getSslSocketFactory();
      sSLSocketFactory1 = (SSLSocketFactory)paramOkHttpClient.getHostnameVerifier();
      CertificatePinner certificatePinner = paramOkHttpClient.getCertificatePinner();
      sSLSocketFactory3 = (SSLSocketFactory)certificatePinner;
    } else {
      SSLSocketFactory sSLSocketFactory = null;
      sSLSocketFactory1 = sSLSocketFactory;
      sSLSocketFactory3 = sSLSocketFactory1;
      sSLSocketFactory2 = sSLSocketFactory;
    } 
    return new Address(paramRequest.httpUrl().host(), paramRequest.httpUrl().port(), paramOkHttpClient.getDns(), paramOkHttpClient.getSocketFactory(), sSLSocketFactory2, (HostnameVerifier)sSLSocketFactory1, (CertificatePinner)sSLSocketFactory3, paramOkHttpClient.getAuthenticator(), paramOkHttpClient.getProxy(), paramOkHttpClient.getProtocols(), paramOkHttpClient.getConnectionSpecs(), paramOkHttpClient.getProxySelector());
  }
  
  public static boolean hasBody(Response paramResponse) {
    if (paramResponse.request().method().equals("HEAD"))
      return false; 
    int i = paramResponse.code();
    return ((i < 100 || i >= 200) && i != 204 && i != 304) ? true : ((OkHeaders.contentLength(paramResponse) == -1L) ? ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))) : true);
  }
  
  private void maybeCache() throws IOException {
    InternalCache internalCache = Internal.instance.internalCache(this.client);
    if (internalCache == null)
      return; 
    if (!CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
      if (HttpMethod.invalidatesCache(this.networkRequest.method()))
        try {
          internalCache.remove(this.networkRequest);
          return;
        } catch (IOException iOException) {
          return;
        }  
      return;
    } 
    this.storeRequest = iOException.put(stripBody(this.userResponse));
  }
  
  private Request networkRequest(Request paramRequest) throws IOException {
    Request.Builder builder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null)
      builder.header("Host", Util.hostHeader(paramRequest.httpUrl())); 
    if (paramRequest.header("Connection") == null)
      builder.header("Connection", "Keep-Alive"); 
    if (paramRequest.header("Accept-Encoding") == null) {
      this.transparentGzip = true;
      builder.header("Accept-Encoding", "gzip");
    } 
    CookieHandler cookieHandler = this.client.getCookieHandler();
    if (cookieHandler != null) {
      Map<String, List<String>> map = OkHeaders.toMultimap(builder.build().headers(), null);
      OkHeaders.addCookies(builder, cookieHandler.get(paramRequest.uri(), map));
    } 
    if (paramRequest.header("User-Agent") == null)
      builder.header("User-Agent", Version.userAgent()); 
    return builder.build();
  }
  
  private Response readNetworkResponse() throws IOException {
    this.httpStream.finishRequest();
    Response response2 = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
    Response response1 = response2;
    if (!this.forWebSocket)
      response1 = response2.newBuilder().body(this.httpStream.openResponseBody(response2)).build(); 
    if ("close".equalsIgnoreCase(response1.request().header("Connection")) || "close".equalsIgnoreCase(response1.header("Connection")))
      this.streamAllocation.noNewStreams(); 
    return response1;
  }
  
  private static Response stripBody(Response paramResponse) {
    Response response = paramResponse;
    if (paramResponse != null) {
      response = paramResponse;
      if (paramResponse.body() != null)
        response = paramResponse.newBuilder().body(null).build(); 
    } 
    return response;
  }
  
  private Response unzip(Response paramResponse) throws IOException {
    Response response = paramResponse;
    if (this.transparentGzip) {
      if (!"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")))
        return paramResponse; 
      if (paramResponse.body() == null)
        return paramResponse; 
      GzipSource gzipSource = new GzipSource((Source)paramResponse.body().source());
      Headers headers = paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
      response = paramResponse.newBuilder().headers(headers).body(new RealResponseBody(headers, Okio.buffer((Source)gzipSource))).build();
    } 
    return response;
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2) {
    if (paramResponse2.code() == 304)
      return true; 
    Date date = paramResponse1.headers().getDate("Last-Modified");
    if (date != null) {
      Date date1 = paramResponse2.headers().getDate("Last-Modified");
      if (date1 != null && date1.getTime() < date.getTime())
        return true; 
    } 
    return false;
  }
  
  public void cancel() {
    this.streamAllocation.cancel();
  }
  
  public StreamAllocation close() {
    BufferedSink bufferedSink = this.bufferedRequestBody;
    if (bufferedSink != null) {
      Util.closeQuietly((Closeable)bufferedSink);
    } else {
      Sink sink = this.requestBodyOut;
      if (sink != null)
        Util.closeQuietly((Closeable)sink); 
    } 
    Response response = this.userResponse;
    if (response != null) {
      Util.closeQuietly((Closeable)response.body());
    } else {
      this.streamAllocation.connectionFailed();
    } 
    return this.streamAllocation;
  }
  
  public Request followUpRequest() throws IOException {
    if (this.userResponse != null) {
      Proxy proxy;
      RealConnection realConnection = this.streamAllocation.connection();
      if (realConnection != null) {
        Route route = realConnection.getRoute();
      } else {
        realConnection = null;
      } 
      if (realConnection != null) {
        proxy = realConnection.getProxy();
      } else {
        proxy = this.client.getProxy();
      } 
      int i = this.userResponse.code();
      String str2 = this.userRequest.method();
      if (i != 307 && i != 308) {
        if (i != 401) {
          if (i != 407) {
            switch (i) {
              default:
                return null;
              case 300:
              case 301:
              case 302:
              case 303:
                break;
            } 
          } else {
            if (proxy.type() != Proxy.Type.HTTP)
              throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy"); 
            return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
          } 
        } else {
          return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
        } 
      } else if (!str2.equals("GET") && !str2.equals("HEAD")) {
        return null;
      } 
      if (!this.client.getFollowRedirects())
        return null; 
      String str1 = this.userResponse.header("Location");
      if (str1 == null)
        return null; 
      HttpUrl httpUrl = this.userRequest.httpUrl().resolve(str1);
      if (httpUrl == null)
        return null; 
      if (!httpUrl.scheme().equals(this.userRequest.httpUrl().scheme()) && !this.client.getFollowSslRedirects())
        return null; 
      Request.Builder builder = this.userRequest.newBuilder();
      if (HttpMethod.permitsRequestBody(str2)) {
        if (HttpMethod.redirectsToGet(str2)) {
          builder.method("GET", null);
        } else {
          builder.method(str2, null);
        } 
        builder.removeHeader("Transfer-Encoding");
        builder.removeHeader("Content-Length");
        builder.removeHeader("Content-Type");
      } 
      if (!sameConnection(httpUrl))
        builder.removeHeader("Authorization"); 
      return builder.url(httpUrl).build();
    } 
    throw new IllegalStateException();
  }
  
  public BufferedSink getBufferedRequestBody() {
    BufferedSink bufferedSink = this.bufferedRequestBody;
    if (bufferedSink != null)
      return bufferedSink; 
    Sink sink = getRequestBody();
    if (sink != null) {
      BufferedSink bufferedSink1 = Okio.buffer(sink);
      this.bufferedRequestBody = bufferedSink1;
      return bufferedSink1;
    } 
    return null;
  }
  
  public Connection getConnection() {
    return (Connection)this.streamAllocation.connection();
  }
  
  public Request getRequest() {
    return this.userRequest;
  }
  
  public Sink getRequestBody() {
    if (this.cacheStrategy != null)
      return this.requestBodyOut; 
    throw new IllegalStateException();
  }
  
  public Response getResponse() {
    Response response = this.userResponse;
    if (response != null)
      return response; 
    throw new IllegalStateException();
  }
  
  public boolean hasResponse() {
    return (this.userResponse != null);
  }
  
  boolean permitsRequestBody(Request paramRequest) {
    return HttpMethod.permitsRequestBody(paramRequest.method());
  }
  
  public void readResponse() throws IOException {
    if (this.userResponse != null)
      return; 
    if (this.networkRequest != null || this.cacheResponse != null) {
      Response response1;
      InternalCache internalCache;
      Request request = this.networkRequest;
      if (request == null)
        return; 
      if (this.forWebSocket) {
        this.httpStream.writeRequestHeaders(request);
        response1 = readNetworkResponse();
      } else if (!this.callerWritesRequestBody) {
        response1 = (new NetworkInterceptorChain(0, (Request)response1)).proceed(this.networkRequest);
      } else {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null && bufferedSink.buffer().size() > 0L)
          this.bufferedRequestBody.emit(); 
        if (this.sentRequestMillis == -1L) {
          if (OkHeaders.contentLength(this.networkRequest) == -1L) {
            Sink sink1 = this.requestBodyOut;
            if (sink1 instanceof RetryableSink) {
              long l = ((RetryableSink)sink1).contentLength();
              this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
            } 
          } 
          this.httpStream.writeRequestHeaders(this.networkRequest);
        } 
        Sink sink = this.requestBodyOut;
        if (sink != null) {
          BufferedSink bufferedSink1 = this.bufferedRequestBody;
          if (bufferedSink1 != null) {
            bufferedSink1.close();
          } else {
            sink.close();
          } 
          sink = this.requestBodyOut;
          if (sink instanceof RetryableSink)
            this.httpStream.writeRequestBody((RetryableSink)sink); 
        } 
        response1 = readNetworkResponse();
      } 
      receiveHeaders(response1.headers());
      Response response2 = this.cacheResponse;
      if (response2 != null) {
        if (validate(response2, response1)) {
          this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), response1.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response1)).build();
          response1.body().close();
          releaseStreamAllocation();
          internalCache = Internal.instance.internalCache(this.client);
          internalCache.trackConditionalCacheHit();
          internalCache.update(this.cacheResponse, stripBody(this.userResponse));
          this.userResponse = unzip(this.userResponse);
          return;
        } 
        Util.closeQuietly((Closeable)this.cacheResponse.body());
      } 
      this.userResponse = internalCache.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)internalCache)).build();
      if (hasBody(this.userResponse)) {
        maybeCache();
        this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
      } 
      return;
    } 
    throw new IllegalStateException("call sendRequest() first!");
  }
  
  public void receiveHeaders(Headers paramHeaders) throws IOException {
    CookieHandler cookieHandler = this.client.getCookieHandler();
    if (cookieHandler != null)
      cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(paramHeaders, null)); 
  }
  
  public HttpEngine recover(RouteException paramRouteException) {
    if (!this.streamAllocation.recover(paramRouteException))
      return null; 
    if (!this.client.getRetryOnConnectionFailure())
      return null; 
    StreamAllocation streamAllocation = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, streamAllocation, (RetryableSink)this.requestBodyOut, this.priorResponse);
  }
  
  public HttpEngine recover(IOException paramIOException) {
    return recover(paramIOException, this.requestBodyOut);
  }
  
  public HttpEngine recover(IOException paramIOException, Sink paramSink) {
    if (!this.streamAllocation.recover(paramIOException, paramSink))
      return null; 
    if (!this.client.getRetryOnConnectionFailure())
      return null; 
    StreamAllocation streamAllocation = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, streamAllocation, (RetryableSink)paramSink, this.priorResponse);
  }
  
  public void releaseStreamAllocation() throws IOException {
    this.streamAllocation.release();
  }
  
  public boolean sameConnection(HttpUrl paramHttpUrl) {
    HttpUrl httpUrl = this.userRequest.httpUrl();
    return (httpUrl.host().equals(paramHttpUrl.host()) && httpUrl.port() == paramHttpUrl.port() && httpUrl.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void sendRequest() throws RequestException, RouteException, IOException {
    if (this.cacheStrategy != null)
      return; 
    if (this.httpStream == null) {
      Response response;
      Request request = networkRequest(this.userRequest);
      InternalCache internalCache = Internal.instance.internalCache(this.client);
      if (internalCache != null) {
        response = internalCache.get(request);
      } else {
        response = null;
      } 
      this.cacheStrategy = (new CacheStrategy.Factory(System.currentTimeMillis(), request, response)).get();
      this.networkRequest = this.cacheStrategy.networkRequest;
      this.cacheResponse = this.cacheStrategy.cacheResponse;
      if (internalCache != null)
        internalCache.trackResponse(this.cacheStrategy); 
      if (response != null && this.cacheResponse == null)
        Util.closeQuietly((Closeable)response.body()); 
      if (this.networkRequest != null) {
        this.httpStream = connect();
        this.httpStream.setHttpEngine(this);
        if (this.callerWritesRequestBody && permitsRequestBody(this.networkRequest) && this.requestBodyOut == null) {
          long l = OkHeaders.contentLength(request);
          if (this.bufferRequestBody) {
            if (l <= 2147483647L) {
              if (l != -1L) {
                this.httpStream.writeRequestHeaders(this.networkRequest);
                this.requestBodyOut = new RetryableSink((int)l);
                return;
              } 
              this.requestBodyOut = new RetryableSink();
              return;
            } 
            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
          } 
          this.httpStream.writeRequestHeaders(this.networkRequest);
          this.requestBodyOut = this.httpStream.createRequestBody(this.networkRequest, l);
          return;
        } 
      } else {
        response = this.cacheResponse;
        if (response != null) {
          this.userResponse = response.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
        } else {
          this.userResponse = (new Response.Builder()).request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
        } 
        this.userResponse = unzip(this.userResponse);
      } 
      return;
    } 
    throw new IllegalStateException();
  }
  
  public void writingRequestHeaders() {
    if (this.sentRequestMillis == -1L) {
      this.sentRequestMillis = System.currentTimeMillis();
      return;
    } 
    throw new IllegalStateException();
  }
  
  class NetworkInterceptorChain implements Interceptor.Chain {
    private int calls;
    
    private final int index;
    
    private final Request request;
    
    NetworkInterceptorChain(int param1Int, Request param1Request) {
      this.index = param1Int;
      this.request = param1Request;
    }
    
    public Connection connection() {
      return (Connection)HttpEngine.this.streamAllocation.connection();
    }
    
    public Response proceed(Request param1Request) throws IOException {
      StringBuilder stringBuilder1;
      Interceptor interceptor;
      this.calls++;
      if (this.index > 0) {
        Interceptor interceptor1 = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
        Address address = connection().getRoute().getAddress();
        if (param1Request.httpUrl().host().equals(address.getUriHost()) && param1Request.httpUrl().port() == address.getUriPort()) {
          if (this.calls > 1) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("network interceptor ");
            stringBuilder1.append(interceptor1);
            stringBuilder1.append(" must call proceed() exactly once");
            throw new IllegalStateException(stringBuilder1.toString());
          } 
        } else {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("network interceptor ");
          stringBuilder1.append(interceptor1);
          stringBuilder1.append(" must retain the same host and port");
          throw new IllegalStateException(stringBuilder1.toString());
        } 
      } 
      if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
        NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, (Request)stringBuilder1);
        interceptor = HttpEngine.this.client.networkInterceptors().get(this.index);
        Response response1 = interceptor.intercept(networkInterceptorChain);
        if (networkInterceptorChain.calls == 1) {
          if (response1 != null)
            return response1; 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("network interceptor ");
          stringBuilder3.append(interceptor);
          stringBuilder3.append(" returned null");
          throw new NullPointerException(stringBuilder3.toString());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("network interceptor ");
        stringBuilder.append(interceptor);
        stringBuilder.append(" must call proceed() exactly once");
        throw new IllegalStateException(stringBuilder.toString());
      } 
      HttpEngine.this.httpStream.writeRequestHeaders((Request)interceptor);
      HttpEngine.access$102(HttpEngine.this, (Request)interceptor);
      if (HttpEngine.this.permitsRequestBody((Request)interceptor) && interceptor.body() != null) {
        BufferedSink bufferedSink = Okio.buffer(HttpEngine.this.httpStream.createRequestBody((Request)interceptor, interceptor.body().contentLength()));
        interceptor.body().writeTo(bufferedSink);
        bufferedSink.close();
      } 
      Response response = HttpEngine.this.readNetworkResponse();
      int i = response.code();
      if ((i != 204 && i != 205) || response.body().contentLength() <= 0L)
        return response; 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("HTTP ");
      stringBuilder2.append(i);
      stringBuilder2.append(" had non-zero Content-Length: ");
      stringBuilder2.append(response.body().contentLength());
      throw new ProtocolException(stringBuilder2.toString());
    }
    
    public Request request() {
      return this.request;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\HttpEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */