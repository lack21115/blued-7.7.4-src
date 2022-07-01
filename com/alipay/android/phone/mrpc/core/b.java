package com.alipay.android.phone.mrpc.core;

import android.net.SSLCertificateSocketFactory;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class b implements HttpClient {
  public static long a = 160L;
  
  private static String[] b = new String[] { "text/", "application/xml", "application/json" };
  
  private static final HttpRequestInterceptor c = new c();
  
  private final HttpClient d;
  
  private RuntimeException e = new IllegalStateException("AndroidHttpClient created and never closed");
  
  private volatile b f;
  
  private b(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
    this.d = (HttpClient)new d(this, paramClientConnectionManager, paramHttpParams);
  }
  
  public static b a(String paramString) {
    BasicHttpParams basicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUseExpectContinue((HttpParams)basicHttpParams, false);
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)basicHttpParams, true);
    HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 30000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 8192);
    HttpClientParams.setRedirecting((HttpParams)basicHttpParams, true);
    HttpClientParams.setAuthenticating((HttpParams)basicHttpParams, false);
    HttpProtocolParams.setUserAgent((HttpParams)basicHttpParams, paramString);
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
    schemeRegistry.register(new Scheme("https", (SocketFactory)SSLCertificateSocketFactory.getHttpSocketFactory(30000, null), 443));
    ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry);
    ConnManagerParams.setTimeout((HttpParams)basicHttpParams, 60000L);
    ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)basicHttpParams, (ConnPerRoute)new ConnPerRouteBean(10));
    ConnManagerParams.setMaxTotalConnections((HttpParams)basicHttpParams, 50);
    Security.setProperty("networkaddress.cache.ttl", "-1");
    HttpsURLConnection.setDefaultHostnameVerifier((HostnameVerifier)SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    return new b((ClientConnectionManager)threadSafeClientConnManager, (HttpParams)basicHttpParams);
  }
  
  public static InputStream a(HttpEntity paramHttpEntity) {
    InputStream inputStream = paramHttpEntity.getContent();
    if (inputStream == null)
      return inputStream; 
    Header header = paramHttpEntity.getContentEncoding();
    if (header == null)
      return inputStream; 
    String str = header.getValue();
    return (str == null) ? inputStream : (str.contains("gzip") ? new GZIPInputStream(inputStream) : inputStream);
  }
  
  public static AbstractHttpEntity a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length < a)
      return (AbstractHttpEntity)new ByteArrayEntity(paramArrayOfbyte); 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
    gZIPOutputStream.write(paramArrayOfbyte);
    gZIPOutputStream.close();
    ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
    byteArrayEntity.setContentEncoding("gzip");
    StringBuilder stringBuilder = new StringBuilder("gzip size:");
    stringBuilder.append(paramArrayOfbyte.length);
    stringBuilder.append("->");
    stringBuilder.append(byteArrayEntity.getContentLength());
    return (AbstractHttpEntity)byteArrayEntity;
  }
  
  public static void a(HttpRequest paramHttpRequest) {
    paramHttpRequest.addHeader("Accept-Encoding", "gzip");
  }
  
  public static long b(String paramString) {
    return k.a(paramString);
  }
  
  public static void b(HttpRequest paramHttpRequest) {
    paramHttpRequest.addHeader("Connection", "Keep-Alive");
  }
  
  private static boolean b(HttpUriRequest paramHttpUriRequest) {
    Header[] arrayOfHeader2 = paramHttpUriRequest.getHeaders("content-encoding");
    if (arrayOfHeader2 != null) {
      int j = arrayOfHeader2.length;
      for (int i = 0; i < j; i++) {
        if ("gzip".equalsIgnoreCase(arrayOfHeader2[i].getValue()))
          return true; 
      } 
    } 
    Header[] arrayOfHeader1 = paramHttpUriRequest.getHeaders("content-type");
    if (arrayOfHeader1 != null) {
      int j = arrayOfHeader1.length;
      for (int i = 0; i < j; i++) {
        Header header = arrayOfHeader1[i];
        for (String str : b) {
          if (header.getValue().startsWith(str))
            return false; 
        } 
      } 
    } 
    return true;
  }
  
  public final void a(HttpRequestRetryHandler paramHttpRequestRetryHandler) {
    ((DefaultHttpClient)this.d).setHttpRequestRetryHandler(paramHttpRequestRetryHandler);
  }
  
  public final <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler) {
    return (T)this.d.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public final <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) {
    return (T)this.d.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public final <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler) {
    return (T)this.d.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public final <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) {
    return (T)this.d.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest) {
    return this.d.execute(paramHttpHost, paramHttpRequest);
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
    return this.d.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest) {
    return this.d.execute(paramHttpUriRequest);
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) {
    return this.d.execute(paramHttpUriRequest, paramHttpContext);
  }
  
  public final ClientConnectionManager getConnectionManager() {
    return this.d.getConnectionManager();
  }
  
  public final HttpParams getParams() {
    return this.d.getParams();
  }
  
  final class a implements HttpRequestInterceptor {
    private a(b this$0) {}
    
    public final void process(HttpRequest param1HttpRequest, HttpContext param1HttpContext) {
      b.b b1 = b.a(this.a);
      if (b1 != null && b.b.a(b1) && param1HttpRequest instanceof HttpUriRequest)
        b.b.a(b1, b.a((HttpUriRequest)param1HttpRequest)); 
    }
  }
  
  static final class b {
    private final String a;
    
    private final int b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */