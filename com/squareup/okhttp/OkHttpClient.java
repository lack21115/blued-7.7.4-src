package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.CookieHandler;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class OkHttpClient implements Cloneable {
  private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  
  private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList((Object[])new Protocol[] { Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1 });
  
  private static SSLSocketFactory defaultSslSocketFactory;
  
  private Authenticator authenticator;
  
  private Cache cache;
  
  private CertificatePinner certificatePinner;
  
  private int connectTimeout;
  
  private ConnectionPool connectionPool;
  
  private List<ConnectionSpec> connectionSpecs;
  
  private CookieHandler cookieHandler;
  
  private Dispatcher dispatcher;
  
  private Dns dns;
  
  private boolean followRedirects;
  
  private boolean followSslRedirects;
  
  private HostnameVerifier hostnameVerifier;
  
  private final List<Interceptor> interceptors;
  
  private InternalCache internalCache;
  
  private final List<Interceptor> networkInterceptors;
  
  private List<Protocol> protocols;
  
  private Proxy proxy;
  
  private ProxySelector proxySelector;
  
  private int readTimeout;
  
  private boolean retryOnConnectionFailure;
  
  private final RouteDatabase routeDatabase;
  
  private SocketFactory socketFactory;
  
  private SSLSocketFactory sslSocketFactory;
  
  private int writeTimeout;
  
  static {
    DEFAULT_CONNECTION_SPECS = Util.immutableList((Object[])new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT });
    Internal.instance = new Internal() {
        public void addLenient(Headers.Builder param1Builder, String param1String) {
          param1Builder.addLenient(param1String);
        }
        
        public void addLenient(Headers.Builder param1Builder, String param1String1, String param1String2) {
          param1Builder.addLenient(param1String1, param1String2);
        }
        
        public void apply(ConnectionSpec param1ConnectionSpec, SSLSocket param1SSLSocket, boolean param1Boolean) {
          param1ConnectionSpec.apply(param1SSLSocket, param1Boolean);
        }
        
        public StreamAllocation callEngineGetStreamAllocation(Call param1Call) {
          return param1Call.engine.streamAllocation;
        }
        
        public void callEnqueue(Call param1Call, Callback param1Callback, boolean param1Boolean) {
          param1Call.enqueue(param1Callback, param1Boolean);
        }
        
        public boolean connectionBecameIdle(ConnectionPool param1ConnectionPool, RealConnection param1RealConnection) {
          return param1ConnectionPool.connectionBecameIdle(param1RealConnection);
        }
        
        public RealConnection get(ConnectionPool param1ConnectionPool, Address param1Address, StreamAllocation param1StreamAllocation) {
          return param1ConnectionPool.get(param1Address, param1StreamAllocation);
        }
        
        public HttpUrl getHttpUrlChecked(String param1String) throws MalformedURLException, UnknownHostException {
          return HttpUrl.getChecked(param1String);
        }
        
        public InternalCache internalCache(OkHttpClient param1OkHttpClient) {
          return param1OkHttpClient.internalCache();
        }
        
        public void put(ConnectionPool param1ConnectionPool, RealConnection param1RealConnection) {
          param1ConnectionPool.put(param1RealConnection);
        }
        
        public RouteDatabase routeDatabase(ConnectionPool param1ConnectionPool) {
          return param1ConnectionPool.routeDatabase;
        }
        
        public void setCache(OkHttpClient param1OkHttpClient, InternalCache param1InternalCache) {
          param1OkHttpClient.setInternalCache(param1InternalCache);
        }
      };
  }
  
  public OkHttpClient() {
    this.interceptors = new ArrayList<Interceptor>();
    this.networkInterceptors = new ArrayList<Interceptor>();
    this.followSslRedirects = true;
    this.followRedirects = true;
    this.retryOnConnectionFailure = true;
    this.connectTimeout = 10000;
    this.readTimeout = 10000;
    this.writeTimeout = 10000;
    this.routeDatabase = new RouteDatabase();
    this.dispatcher = new Dispatcher();
  }
  
  private OkHttpClient(OkHttpClient paramOkHttpClient) {
    InternalCache internalCache;
    this.interceptors = new ArrayList<Interceptor>();
    this.networkInterceptors = new ArrayList<Interceptor>();
    this.followSslRedirects = true;
    this.followRedirects = true;
    this.retryOnConnectionFailure = true;
    this.connectTimeout = 10000;
    this.readTimeout = 10000;
    this.writeTimeout = 10000;
    this.routeDatabase = paramOkHttpClient.routeDatabase;
    this.dispatcher = paramOkHttpClient.dispatcher;
    this.proxy = paramOkHttpClient.proxy;
    this.protocols = paramOkHttpClient.protocols;
    this.connectionSpecs = paramOkHttpClient.connectionSpecs;
    this.interceptors.addAll(paramOkHttpClient.interceptors);
    this.networkInterceptors.addAll(paramOkHttpClient.networkInterceptors);
    this.proxySelector = paramOkHttpClient.proxySelector;
    this.cookieHandler = paramOkHttpClient.cookieHandler;
    this.cache = paramOkHttpClient.cache;
    Cache cache = this.cache;
    if (cache != null) {
      internalCache = cache.internalCache;
    } else {
      internalCache = paramOkHttpClient.internalCache;
    } 
    this.internalCache = internalCache;
    this.socketFactory = paramOkHttpClient.socketFactory;
    this.sslSocketFactory = paramOkHttpClient.sslSocketFactory;
    this.hostnameVerifier = paramOkHttpClient.hostnameVerifier;
    this.certificatePinner = paramOkHttpClient.certificatePinner;
    this.authenticator = paramOkHttpClient.authenticator;
    this.connectionPool = paramOkHttpClient.connectionPool;
    this.dns = paramOkHttpClient.dns;
    this.followSslRedirects = paramOkHttpClient.followSslRedirects;
    this.followRedirects = paramOkHttpClient.followRedirects;
    this.retryOnConnectionFailure = paramOkHttpClient.retryOnConnectionFailure;
    this.connectTimeout = paramOkHttpClient.connectTimeout;
    this.readTimeout = paramOkHttpClient.readTimeout;
    this.writeTimeout = paramOkHttpClient.writeTimeout;
  }
  
  private SSLSocketFactory getDefaultSSLSocketFactory() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/squareup/okhttp/OkHttpClient.defaultSslSocketFactory : Ljavax/net/ssl/SSLSocketFactory;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull -> 41
    //   10: ldc 'TLS'
    //   12: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   15: astore_1
    //   16: aload_1
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual init : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   23: aload_1
    //   24: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   27: putstatic com/squareup/okhttp/OkHttpClient.defaultSslSocketFactory : Ljavax/net/ssl/SSLSocketFactory;
    //   30: goto -> 41
    //   33: new java/lang/AssertionError
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: athrow
    //   41: getstatic com/squareup/okhttp/OkHttpClient.defaultSslSocketFactory : Ljavax/net/ssl/SSLSocketFactory;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: goto -> 33
    // Exception table:
    //   from	to	target	type
    //   2	6	49	finally
    //   10	30	54	java/security/GeneralSecurityException
    //   10	30	49	finally
    //   33	41	49	finally
    //   41	45	49	finally
  }
  
  public OkHttpClient cancel(Object paramObject) {
    getDispatcher().cancel(paramObject);
    return this;
  }
  
  public OkHttpClient clone() {
    return new OkHttpClient(this);
  }
  
  OkHttpClient copyWithDefaults() {
    OkHttpClient okHttpClient = new OkHttpClient(this);
    if (okHttpClient.proxySelector == null)
      okHttpClient.proxySelector = ProxySelector.getDefault(); 
    if (okHttpClient.cookieHandler == null)
      okHttpClient.cookieHandler = CookieHandler.getDefault(); 
    if (okHttpClient.socketFactory == null)
      okHttpClient.socketFactory = SocketFactory.getDefault(); 
    if (okHttpClient.sslSocketFactory == null)
      okHttpClient.sslSocketFactory = getDefaultSSLSocketFactory(); 
    if (okHttpClient.hostnameVerifier == null)
      okHttpClient.hostnameVerifier = (HostnameVerifier)OkHostnameVerifier.INSTANCE; 
    if (okHttpClient.certificatePinner == null)
      okHttpClient.certificatePinner = CertificatePinner.DEFAULT; 
    if (okHttpClient.authenticator == null)
      okHttpClient.authenticator = AuthenticatorAdapter.INSTANCE; 
    if (okHttpClient.connectionPool == null)
      okHttpClient.connectionPool = ConnectionPool.getDefault(); 
    if (okHttpClient.protocols == null)
      okHttpClient.protocols = DEFAULT_PROTOCOLS; 
    if (okHttpClient.connectionSpecs == null)
      okHttpClient.connectionSpecs = DEFAULT_CONNECTION_SPECS; 
    if (okHttpClient.dns == null)
      okHttpClient.dns = Dns.SYSTEM; 
    return okHttpClient;
  }
  
  public Authenticator getAuthenticator() {
    return this.authenticator;
  }
  
  public Cache getCache() {
    return this.cache;
  }
  
  public CertificatePinner getCertificatePinner() {
    return this.certificatePinner;
  }
  
  public int getConnectTimeout() {
    return this.connectTimeout;
  }
  
  public ConnectionPool getConnectionPool() {
    return this.connectionPool;
  }
  
  public List<ConnectionSpec> getConnectionSpecs() {
    return this.connectionSpecs;
  }
  
  public CookieHandler getCookieHandler() {
    return this.cookieHandler;
  }
  
  public Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  
  public Dns getDns() {
    return this.dns;
  }
  
  public boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public boolean getFollowSslRedirects() {
    return this.followSslRedirects;
  }
  
  public HostnameVerifier getHostnameVerifier() {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> getProtocols() {
    return this.protocols;
  }
  
  public Proxy getProxy() {
    return this.proxy;
  }
  
  public ProxySelector getProxySelector() {
    return this.proxySelector;
  }
  
  public int getReadTimeout() {
    return this.readTimeout;
  }
  
  public boolean getRetryOnConnectionFailure() {
    return this.retryOnConnectionFailure;
  }
  
  public SocketFactory getSocketFactory() {
    return this.socketFactory;
  }
  
  public SSLSocketFactory getSslSocketFactory() {
    return this.sslSocketFactory;
  }
  
  public int getWriteTimeout() {
    return this.writeTimeout;
  }
  
  public List<Interceptor> interceptors() {
    return this.interceptors;
  }
  
  InternalCache internalCache() {
    return this.internalCache;
  }
  
  public List<Interceptor> networkInterceptors() {
    return this.networkInterceptors;
  }
  
  public Call newCall(Request paramRequest) {
    return new Call(this, paramRequest);
  }
  
  RouteDatabase routeDatabase() {
    return this.routeDatabase;
  }
  
  public OkHttpClient setAuthenticator(Authenticator paramAuthenticator) {
    this.authenticator = paramAuthenticator;
    return this;
  }
  
  public OkHttpClient setCache(Cache paramCache) {
    this.cache = paramCache;
    this.internalCache = null;
    return this;
  }
  
  public OkHttpClient setCertificatePinner(CertificatePinner paramCertificatePinner) {
    this.certificatePinner = paramCertificatePinner;
    return this;
  }
  
  public void setConnectTimeout(long paramLong, TimeUnit paramTimeUnit) {
    int i = paramLong cmp 0L;
    if (i >= 0) {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong <= 2147483647L) {
          if (paramLong != 0L || i <= 0) {
            this.connectTimeout = (int)paramLong;
            return;
          } 
          throw new IllegalArgumentException("Timeout too small.");
        } 
        throw new IllegalArgumentException("Timeout too large.");
      } 
      throw new IllegalArgumentException("unit == null");
    } 
    throw new IllegalArgumentException("timeout < 0");
  }
  
  public OkHttpClient setConnectionPool(ConnectionPool paramConnectionPool) {
    this.connectionPool = paramConnectionPool;
    return this;
  }
  
  public OkHttpClient setConnectionSpecs(List<ConnectionSpec> paramList) {
    this.connectionSpecs = Util.immutableList(paramList);
    return this;
  }
  
  public OkHttpClient setCookieHandler(CookieHandler paramCookieHandler) {
    this.cookieHandler = paramCookieHandler;
    return this;
  }
  
  public OkHttpClient setDispatcher(Dispatcher paramDispatcher) {
    if (paramDispatcher != null) {
      this.dispatcher = paramDispatcher;
      return this;
    } 
    throw new IllegalArgumentException("dispatcher == null");
  }
  
  public OkHttpClient setDns(Dns paramDns) {
    this.dns = paramDns;
    return this;
  }
  
  public void setFollowRedirects(boolean paramBoolean) {
    this.followRedirects = paramBoolean;
  }
  
  public OkHttpClient setFollowSslRedirects(boolean paramBoolean) {
    this.followSslRedirects = paramBoolean;
    return this;
  }
  
  public OkHttpClient setHostnameVerifier(HostnameVerifier paramHostnameVerifier) {
    this.hostnameVerifier = paramHostnameVerifier;
    return this;
  }
  
  void setInternalCache(InternalCache paramInternalCache) {
    this.internalCache = paramInternalCache;
    this.cache = null;
  }
  
  public OkHttpClient setProtocols(List<Protocol> paramList) {
    paramList = Util.immutableList(paramList);
    if (paramList.contains(Protocol.HTTP_1_1)) {
      if (!paramList.contains(Protocol.HTTP_1_0)) {
        if (!paramList.contains(null)) {
          this.protocols = Util.immutableList(paramList);
          return this;
        } 
        throw new IllegalArgumentException("protocols must not contain null");
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("protocols must not contain http/1.0: ");
      stringBuilder1.append(paramList);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("protocols doesn't contain http/1.1: ");
    stringBuilder.append(paramList);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public OkHttpClient setProxy(Proxy paramProxy) {
    this.proxy = paramProxy;
    return this;
  }
  
  public OkHttpClient setProxySelector(ProxySelector paramProxySelector) {
    this.proxySelector = paramProxySelector;
    return this;
  }
  
  public void setReadTimeout(long paramLong, TimeUnit paramTimeUnit) {
    int i = paramLong cmp 0L;
    if (i >= 0) {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong <= 2147483647L) {
          if (paramLong != 0L || i <= 0) {
            this.readTimeout = (int)paramLong;
            return;
          } 
          throw new IllegalArgumentException("Timeout too small.");
        } 
        throw new IllegalArgumentException("Timeout too large.");
      } 
      throw new IllegalArgumentException("unit == null");
    } 
    throw new IllegalArgumentException("timeout < 0");
  }
  
  public void setRetryOnConnectionFailure(boolean paramBoolean) {
    this.retryOnConnectionFailure = paramBoolean;
  }
  
  public OkHttpClient setSocketFactory(SocketFactory paramSocketFactory) {
    this.socketFactory = paramSocketFactory;
    return this;
  }
  
  public OkHttpClient setSslSocketFactory(SSLSocketFactory paramSSLSocketFactory) {
    this.sslSocketFactory = paramSSLSocketFactory;
    return this;
  }
  
  public void setWriteTimeout(long paramLong, TimeUnit paramTimeUnit) {
    int i = paramLong cmp 0L;
    if (i >= 0) {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong <= 2147483647L) {
          if (paramLong != 0L || i <= 0) {
            this.writeTimeout = (int)paramLong;
            return;
          } 
          throw new IllegalArgumentException("Timeout too small.");
        } 
        throw new IllegalArgumentException("Timeout too large.");
      } 
      throw new IllegalArgumentException("unit == null");
    } 
    throw new IllegalArgumentException("timeout < 0");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\OkHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */