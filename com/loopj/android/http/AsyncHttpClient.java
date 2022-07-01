package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient {
  public static final int DEFAULT_MAX_CONNECTIONS = 10;
  
  public static final int DEFAULT_MAX_RETRIES = 5;
  
  public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
  
  public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
  
  public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
  
  public static final String ENCODING_GZIP = "gzip";
  
  public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
  
  public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
  
  public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
  
  public static final String HEADER_CONTENT_RANGE = "Content-Range";
  
  public static final String HEADER_CONTENT_TYPE = "Content-Type";
  
  public static final String LOG_TAG = "AsyncHttpClient";
  
  private final Map<String, String> clientHeaderMap;
  
  private int connectTimeout = 10000;
  
  private final DefaultHttpClient httpClient;
  
  private final HttpContext httpContext;
  
  private boolean isUrlEncodingEnabled = true;
  
  private int maxConnections = 10;
  
  private final Map<Context, List<RequestHandle>> requestMap;
  
  private int responseTimeout = 10000;
  
  private ExecutorService threadPool;
  
  public AsyncHttpClient() {
    this(false, 80, 443);
  }
  
  public AsyncHttpClient(int paramInt) {
    this(false, paramInt, 443);
  }
  
  public AsyncHttpClient(int paramInt1, int paramInt2) {
    this(false, paramInt1, paramInt2);
  }
  
  public AsyncHttpClient(SchemeRegistry paramSchemeRegistry) {
    BasicHttpParams basicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout((HttpParams)basicHttpParams, this.connectTimeout);
    ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)basicHttpParams, (ConnPerRoute)new ConnPerRouteBean(this.maxConnections));
    ConnManagerParams.setMaxTotalConnections((HttpParams)basicHttpParams, 10);
    HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, this.responseTimeout);
    HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, this.connectTimeout);
    HttpConnectionParams.setTcpNoDelay((HttpParams)basicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 8192);
    HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
    ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager((HttpParams)basicHttpParams, paramSchemeRegistry);
    this.threadPool = getDefaultThreadPool();
    this.requestMap = Collections.synchronizedMap(new WeakHashMap<Context, List<RequestHandle>>());
    this.clientHeaderMap = new HashMap<String, String>();
    this.httpContext = (HttpContext)new SyncBasicHttpContext((HttpContext)new BasicHttpContext());
    this.httpClient = new DefaultHttpClient((ClientConnectionManager)threadSafeClientConnManager, (HttpParams)basicHttpParams);
    this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
          public void process(HttpRequest param1HttpRequest, HttpContext param1HttpContext) {
            if (!param1HttpRequest.containsHeader("Accept-Encoding"))
              param1HttpRequest.addHeader("Accept-Encoding", "gzip"); 
            for (String str : AsyncHttpClient.this.clientHeaderMap.keySet()) {
              if (param1HttpRequest.containsHeader(str)) {
                Header header = param1HttpRequest.getFirstHeader(str);
                Log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[] { str, AsyncHttpClient.access$000(this.this$0).get(str), header.getName(), header.getValue() }));
                param1HttpRequest.removeHeader(header);
              } 
              param1HttpRequest.addHeader(str, (String)AsyncHttpClient.this.clientHeaderMap.get(str));
            } 
          }
        });
    this.httpClient.addResponseInterceptor(new HttpResponseInterceptor() {
          public void process(HttpResponse param1HttpResponse, HttpContext param1HttpContext) {
            HttpEntity httpEntity = param1HttpResponse.getEntity();
            if (httpEntity == null)
              return; 
            Header header = httpEntity.getContentEncoding();
            if (header != null) {
              HeaderElement[] arrayOfHeaderElement = header.getElements();
              int j = arrayOfHeaderElement.length;
              for (int i = 0; i < j; i++) {
                if (arrayOfHeaderElement[i].getName().equalsIgnoreCase("gzip")) {
                  param1HttpResponse.setEntity((HttpEntity)new AsyncHttpClient.InflatingEntity(httpEntity));
                  return;
                } 
              } 
            } 
          }
        });
    this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
          public void process(HttpRequest param1HttpRequest, HttpContext param1HttpContext) throws HttpException, IOException {
            AuthState authState = (AuthState)param1HttpContext.getAttribute("http.auth.target-scope");
            CredentialsProvider credentialsProvider = (CredentialsProvider)param1HttpContext.getAttribute("http.auth.credentials-provider");
            HttpHost httpHost = (HttpHost)param1HttpContext.getAttribute("http.target_host");
            if (authState.getAuthScheme() == null) {
              Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()));
              if (credentials != null) {
                authState.setAuthScheme((AuthScheme)new BasicScheme());
                authState.setCredentials(credentials);
              } 
            } 
          }
        }0);
    this.httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
  }
  
  public AsyncHttpClient(boolean paramBoolean, int paramInt1, int paramInt2) {
    this(getDefaultSchemeRegistry(paramBoolean, paramInt1, paramInt2));
  }
  
  private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, HttpEntity paramHttpEntity) {
    if (paramHttpEntity != null)
      paramHttpEntityEnclosingRequestBase.setEntity(paramHttpEntity); 
    return paramHttpEntityEnclosingRequestBase;
  }
  
  public static void allowRetryExceptionClass(Class<?> paramClass) {
    if (paramClass != null)
      RetryHandler.addClassToWhitelist(paramClass); 
  }
  
  public static void blockRetryExceptionClass(Class<?> paramClass) {
    if (paramClass != null)
      RetryHandler.addClassToBlacklist(paramClass); 
  }
  
  public static void endEntityViaReflection(HttpEntity paramHttpEntity) {
    if (paramHttpEntity instanceof HttpEntityWrapper) {
      Field field = null;
      try {
        Field[] arrayOfField = HttpEntityWrapper.class.getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        while (true) {
          Field field1 = field;
          if (i < j) {
            field1 = arrayOfField[i];
            if (!field1.getName().equals("wrappedEntity")) {
              i++;
              continue;
            } 
          } 
          return;
        } 
      } finally {
        paramHttpEntity = null;
      } 
    } 
  }
  
  private static SchemeRegistry getDefaultSchemeRegistry(boolean paramBoolean, int paramInt1, int paramInt2) {
    SSLSocketFactory sSLSocketFactory;
    if (paramBoolean)
      Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates."); 
    int i = paramInt1;
    if (paramInt1 < 1) {
      i = 80;
      Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
    } 
    paramInt1 = paramInt2;
    if (paramInt2 < 1) {
      paramInt1 = 443;
      Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
    } 
    if (paramBoolean) {
      sSLSocketFactory = MySSLSocketFactory.getFixedSocketFactory();
    } else {
      sSLSocketFactory = SSLSocketFactory.getSocketFactory();
    } 
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), i));
    schemeRegistry.register(new Scheme("https", (SocketFactory)sSLSocketFactory, paramInt1));
    return schemeRegistry;
  }
  
  public static String getUrlWithQueryString(boolean paramBoolean, String paramString, RequestParams paramRequestParams) {
    if (paramString == null)
      return null; 
    String str = paramString;
    if (paramBoolean)
      str = paramString.replace(" ", "%20"); 
    paramString = str;
    if (paramRequestParams != null) {
      String str1 = paramRequestParams.getParamString().trim();
      paramString = str;
      if (!str1.equals("")) {
        String str2 = "?";
        paramString = str;
        if (!str1.equals("?")) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str);
          paramString = str2;
          if (str.contains("?"))
            paramString = "&"; 
          stringBuilder2.append(paramString);
          paramString = stringBuilder2.toString();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString);
          stringBuilder1.append(str1);
          paramString = stringBuilder1.toString();
        } 
      } 
    } 
    return paramString;
  }
  
  public static boolean isInputStreamGZIPCompressed(PushbackInputStream paramPushbackInputStream) throws IOException {
    boolean bool2 = false;
    if (paramPushbackInputStream == null)
      return false; 
    byte[] arrayOfByte = new byte[2];
    int i = paramPushbackInputStream.read(arrayOfByte);
    paramPushbackInputStream.unread(arrayOfByte);
    byte b1 = arrayOfByte[0];
    byte b2 = arrayOfByte[1];
    boolean bool1 = bool2;
    if (i == 2) {
      bool1 = bool2;
      if (35615 == (b1 & 0xFF | b2 << 8 & 0xFF00))
        bool1 = true; 
    } 
    return bool1;
  }
  
  private HttpEntity paramsToEntity(RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    if (paramRequestParams != null)
      try {
        return paramRequestParams.getEntity(paramResponseHandlerInterface);
      } catch (IOException iOException) {
        if (paramResponseHandlerInterface != null) {
          paramResponseHandlerInterface.sendFailureMessage(0, null, null, iOException);
          return null;
        } 
        iOException.printStackTrace();
      }  
    return null;
  }
  
  public static void silentCloseInputStream(InputStream paramInputStream) {
    if (paramInputStream != null)
      try {
        paramInputStream.close();
        return;
      } catch (IOException iOException) {
        Log.w("AsyncHttpClient", "Cannot close input stream", iOException);
      }  
  }
  
  public static void silentCloseOutputStream(OutputStream paramOutputStream) {
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (IOException iOException) {
        Log.w("AsyncHttpClient", "Cannot close output stream", iOException);
      }  
  }
  
  public void addHeader(String paramString1, String paramString2) {
    this.clientHeaderMap.put(paramString1, paramString2);
  }
  
  public void cancelAllRequests(boolean paramBoolean) {
    for (List<RequestHandle> list : this.requestMap.values()) {
      if (list != null) {
        Iterator<RequestHandle> iterator = list.iterator();
        while (iterator.hasNext())
          ((RequestHandle)iterator.next()).cancel(paramBoolean); 
      } 
    } 
    this.requestMap.clear();
  }
  
  public void cancelRequests(final Context context, final boolean mayInterruptIfRunning) {
    if (context == null) {
      Log.e("AsyncHttpClient", "Passed null Context to cancelRequests");
      return;
    } 
    Runnable runnable = new Runnable() {
        public void run() {
          List list = (List)AsyncHttpClient.this.requestMap.get(context);
          if (list != null) {
            Iterator<RequestHandle> iterator = list.iterator();
            while (iterator.hasNext())
              ((RequestHandle)iterator.next()).cancel(mayInterruptIfRunning); 
            AsyncHttpClient.this.requestMap.remove(context);
          } 
        }
      };
    if (Looper.myLooper() == Looper.getMainLooper()) {
      (new Thread(runnable)).start();
      return;
    } 
    runnable.run();
  }
  
  @Deprecated
  public void clearBasicAuth() {
    clearCredentialsProvider();
  }
  
  public void clearCredentialsProvider() {
    this.httpClient.getCredentialsProvider().clear();
  }
  
  public RequestHandle delete(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpDelete httpDelete = new HttpDelete(URI.create(paramString).normalize());
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpDelete, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpDelete httpDelete = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    if (paramArrayOfHeader != null)
      httpDelete.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpDelete, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(Context paramContext, String paramString, Header[] paramArrayOfHeader, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpDelete httpDelete = new HttpDelete(URI.create(paramString).normalize());
    if (paramArrayOfHeader != null)
      httpDelete.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpDelete, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return delete(null, paramString, paramResponseHandlerInterface);
  }
  
  public RequestHandle get(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams)), null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return get(paramContext, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle get(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpGet httpGet = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    if (paramArrayOfHeader != null)
      httpGet.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpGet, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return get(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle get(String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return get(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public int getConnectTimeout() {
    return this.connectTimeout;
  }
  
  protected ExecutorService getDefaultThreadPool() {
    return Executors.newCachedThreadPool();
  }
  
  public HttpClient getHttpClient() {
    return (HttpClient)this.httpClient;
  }
  
  public HttpContext getHttpContext() {
    return this.httpContext;
  }
  
  public int getMaxConnections() {
    return this.maxConnections;
  }
  
  public int getResponseTimeout() {
    return this.responseTimeout;
  }
  
  public ExecutorService getThreadPool() {
    return this.threadPool;
  }
  
  public int getTimeout() {
    return this.connectTimeout;
  }
  
  public RequestHandle head(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams)), null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle head(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return head(paramContext, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle head(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpHead httpHead = new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    if (paramArrayOfHeader != null)
      httpHead.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpHead, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle head(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return head(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle head(String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return head(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public boolean isUrlEncodingEnabled() {
    return this.isUrlEncodingEnabled;
  }
  
  protected AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext) {
    return new AsyncHttpRequest((AbstractHttpClient)paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramResponseHandlerInterface);
  }
  
  public RequestHandle post(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return post(paramContext, paramString, paramsToEntity(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface) {
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)addEntityToRequestBase((HttpEntityEnclosingRequestBase)new HttpPost(URI.create(paramString1).normalize()), paramHttpEntity), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, RequestParams paramRequestParams, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpPost httpPost = new HttpPost(URI.create(paramString1).normalize());
    if (paramRequestParams != null)
      httpPost.setEntity(paramsToEntity(paramRequestParams, paramResponseHandlerInterface)); 
    if (paramArrayOfHeader != null)
      httpPost.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpPost, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = addEntityToRequestBase((HttpEntityEnclosingRequestBase)new HttpPost(URI.create(paramString1).normalize()), paramHttpEntity);
    if (paramArrayOfHeader != null)
      httpEntityEnclosingRequestBase.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpEntityEnclosingRequestBase, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return post(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle post(String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return post(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle put(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return put(paramContext, paramString, paramsToEntity(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }
  
  public RequestHandle put(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface) {
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)addEntityToRequestBase((HttpEntityEnclosingRequestBase)new HttpPut(URI.create(paramString1).normalize()), paramHttpEntity), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle put(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface) {
    HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = addEntityToRequestBase((HttpEntityEnclosingRequestBase)new HttpPut(URI.create(paramString1).normalize()), paramHttpEntity);
    if (paramArrayOfHeader != null)
      httpEntityEnclosingRequestBase.setHeaders(paramArrayOfHeader); 
    return sendRequest(this.httpClient, this.httpContext, (HttpUriRequest)httpEntityEnclosingRequestBase, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle put(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface) {
    return put(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle put(String paramString, ResponseHandlerInterface paramResponseHandlerInterface) {
    return put(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public void removeAllHeaders() {
    this.clientHeaderMap.clear();
  }
  
  public void removeHeader(String paramString) {
    this.clientHeaderMap.remove(paramString);
  }
  
  protected RequestHandle sendRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext) {
    // Byte code:
    //   0: aload_3
    //   1: ifnull -> 283
    //   4: aload #5
    //   6: ifnull -> 272
    //   9: aload #5
    //   11: invokeinterface getUseSynchronousMode : ()Z
    //   16: ifne -> 261
    //   19: aload #4
    //   21: ifnull -> 63
    //   24: aload_3
    //   25: instanceof org/apache/http/client/methods/HttpEntityEnclosingRequestBase
    //   28: ifeq -> 53
    //   31: aload_3
    //   32: checkcast org/apache/http/client/methods/HttpEntityEnclosingRequestBase
    //   35: invokevirtual getEntity : ()Lorg/apache/http/HttpEntity;
    //   38: ifnull -> 53
    //   41: ldc 'AsyncHttpClient'
    //   43: ldc_w 'Passed contentType will be ignored because HttpEntity sets content type'
    //   46: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: goto -> 63
    //   53: aload_3
    //   54: ldc 'Content-Type'
    //   56: aload #4
    //   58: invokeinterface setHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload #5
    //   65: aload_3
    //   66: invokeinterface getAllHeaders : ()[Lorg/apache/http/Header;
    //   71: invokeinterface setRequestHeaders : ([Lorg/apache/http/Header;)V
    //   76: aload #5
    //   78: aload_3
    //   79: invokeinterface getURI : ()Ljava/net/URI;
    //   84: invokeinterface setRequestURI : (Ljava/net/URI;)V
    //   89: aload_0
    //   90: aload_1
    //   91: aload_2
    //   92: aload_3
    //   93: aload #4
    //   95: aload #5
    //   97: aload #6
    //   99: invokevirtual newAsyncHttpRequest : (Lorg/apache/http/impl/client/DefaultHttpClient;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/client/methods/HttpUriRequest;Ljava/lang/String;Lcom/loopj/android/http/ResponseHandlerInterface;Landroid/content/Context;)Lcom/loopj/android/http/AsyncHttpRequest;
    //   102: astore_1
    //   103: aload_0
    //   104: getfield threadPool : Ljava/util/concurrent/ExecutorService;
    //   107: aload_1
    //   108: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   113: pop
    //   114: new com/loopj/android/http/RequestHandle
    //   117: dup
    //   118: aload_1
    //   119: invokespecial <init> : (Lcom/loopj/android/http/AsyncHttpRequest;)V
    //   122: astore #4
    //   124: aload #6
    //   126: ifnull -> 258
    //   129: aload_0
    //   130: getfield requestMap : Ljava/util/Map;
    //   133: aload #6
    //   135: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast java/util/List
    //   143: astore_2
    //   144: aload_0
    //   145: getfield requestMap : Ljava/util/Map;
    //   148: astore #7
    //   150: aload #7
    //   152: monitorenter
    //   153: aload_2
    //   154: astore_1
    //   155: aload_2
    //   156: ifnonnull -> 183
    //   159: new java/util/LinkedList
    //   162: dup
    //   163: invokespecial <init> : ()V
    //   166: invokestatic synchronizedList : (Ljava/util/List;)Ljava/util/List;
    //   169: astore_1
    //   170: aload_0
    //   171: getfield requestMap : Ljava/util/Map;
    //   174: aload #6
    //   176: aload_1
    //   177: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: aload #7
    //   185: monitorexit
    //   186: aload #5
    //   188: instanceof com/loopj/android/http/RangeFileAsyncHttpResponseHandler
    //   191: ifeq -> 203
    //   194: aload #5
    //   196: checkcast com/loopj/android/http/RangeFileAsyncHttpResponseHandler
    //   199: aload_3
    //   200: invokevirtual updateRequestHeaders : (Lorg/apache/http/client/methods/HttpUriRequest;)V
    //   203: aload_1
    //   204: aload #4
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: aload_1
    //   213: invokeinterface iterator : ()Ljava/util/Iterator;
    //   218: astore_1
    //   219: aload_1
    //   220: invokeinterface hasNext : ()Z
    //   225: ifeq -> 258
    //   228: aload_1
    //   229: invokeinterface next : ()Ljava/lang/Object;
    //   234: checkcast com/loopj/android/http/RequestHandle
    //   237: invokevirtual shouldBeGarbageCollected : ()Z
    //   240: ifeq -> 219
    //   243: aload_1
    //   244: invokeinterface remove : ()V
    //   249: goto -> 219
    //   252: astore_1
    //   253: aload #7
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    //   258: aload #4
    //   260: areturn
    //   261: new java/lang/IllegalArgumentException
    //   264: dup
    //   265: ldc_w 'Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.'
    //   268: invokespecial <init> : (Ljava/lang/String;)V
    //   271: athrow
    //   272: new java/lang/IllegalArgumentException
    //   275: dup
    //   276: ldc_w 'ResponseHandler must not be null'
    //   279: invokespecial <init> : (Ljava/lang/String;)V
    //   282: athrow
    //   283: new java/lang/IllegalArgumentException
    //   286: dup
    //   287: ldc_w 'HttpUriRequest must not be null'
    //   290: invokespecial <init> : (Ljava/lang/String;)V
    //   293: athrow
    // Exception table:
    //   from	to	target	type
    //   159	183	252	finally
    //   183	186	252	finally
    //   253	256	252	finally
  }
  
  public void setAuthenticationPreemptive(boolean paramBoolean) {
    if (paramBoolean) {
      this.httpClient.addRequestInterceptor(new PreemtiveAuthorizationHttpRequestInterceptor(), 0);
      return;
    } 
    this.httpClient.removeRequestInterceptorByClass(PreemtiveAuthorizationHttpRequestInterceptor.class);
  }
  
  public void setBasicAuth(String paramString1, String paramString2) {
    setBasicAuth(paramString1, paramString2, false);
  }
  
  public void setBasicAuth(String paramString1, String paramString2, AuthScope paramAuthScope) {
    setBasicAuth(paramString1, paramString2, paramAuthScope, false);
  }
  
  public void setBasicAuth(String paramString1, String paramString2, AuthScope paramAuthScope, boolean paramBoolean) {
    setCredentials(paramAuthScope, (Credentials)new UsernamePasswordCredentials(paramString1, paramString2));
    setAuthenticationPreemptive(paramBoolean);
  }
  
  public void setBasicAuth(String paramString1, String paramString2, boolean paramBoolean) {
    setBasicAuth(paramString1, paramString2, null, paramBoolean);
  }
  
  public void setConnectTimeout(int paramInt) {
    int i = paramInt;
    if (paramInt < 1000)
      i = 10000; 
    this.connectTimeout = i;
    HttpParams httpParams = this.httpClient.getParams();
    ConnManagerParams.setTimeout(httpParams, this.connectTimeout);
    HttpConnectionParams.setConnectionTimeout(httpParams, this.connectTimeout);
  }
  
  public void setCookieStore(CookieStore paramCookieStore) {
    this.httpContext.setAttribute("http.cookie-store", paramCookieStore);
  }
  
  public void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials) {
    if (paramCredentials == null) {
      Log.d("AsyncHttpClient", "Provided credentials are null, not setting");
      return;
    } 
    CredentialsProvider credentialsProvider = this.httpClient.getCredentialsProvider();
    AuthScope authScope = paramAuthScope;
    if (paramAuthScope == null)
      authScope = AuthScope.ANY; 
    credentialsProvider.setCredentials(authScope, paramCredentials);
  }
  
  public void setEnableRedirects(boolean paramBoolean) {
    setEnableRedirects(paramBoolean, paramBoolean, paramBoolean);
  }
  
  public void setEnableRedirects(boolean paramBoolean1, boolean paramBoolean2) {
    setEnableRedirects(paramBoolean1, paramBoolean2, true);
  }
  
  public void setEnableRedirects(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    this.httpClient.getParams().setBooleanParameter("http.protocol.reject-relative-redirect", paramBoolean2 ^ true);
    this.httpClient.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", paramBoolean3);
    this.httpClient.setRedirectHandler((RedirectHandler)new MyRedirectHandler(paramBoolean1));
  }
  
  public void setMaxConnections(int paramInt) {
    int i = paramInt;
    if (paramInt < 1)
      i = 10; 
    this.maxConnections = i;
    ConnManagerParams.setMaxConnectionsPerRoute(this.httpClient.getParams(), (ConnPerRoute)new ConnPerRouteBean(this.maxConnections));
  }
  
  public void setMaxRetriesAndTimeout(int paramInt1, int paramInt2) {
    this.httpClient.setHttpRequestRetryHandler(new RetryHandler(paramInt1, paramInt2));
  }
  
  public void setProxy(String paramString, int paramInt) {
    HttpHost httpHost = new HttpHost(paramString, paramInt);
    this.httpClient.getParams().setParameter("http.route.default-proxy", httpHost);
  }
  
  public void setProxy(String paramString1, int paramInt, String paramString2, String paramString3) {
    this.httpClient.getCredentialsProvider().setCredentials(new AuthScope(paramString1, paramInt), (Credentials)new UsernamePasswordCredentials(paramString2, paramString3));
    HttpHost httpHost = new HttpHost(paramString1, paramInt);
    this.httpClient.getParams().setParameter("http.route.default-proxy", httpHost);
  }
  
  public void setRedirectHandler(RedirectHandler paramRedirectHandler) {
    this.httpClient.setRedirectHandler(paramRedirectHandler);
  }
  
  public void setResponseTimeout(int paramInt) {
    int i = paramInt;
    if (paramInt < 1000)
      i = 10000; 
    this.responseTimeout = i;
    HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), this.responseTimeout);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory) {
    this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", (SocketFactory)paramSSLSocketFactory, 443));
  }
  
  public void setThreadPool(ExecutorService paramExecutorService) {
    this.threadPool = paramExecutorService;
  }
  
  public void setTimeout(int paramInt) {
    int i = paramInt;
    if (paramInt < 1000)
      i = 10000; 
    setConnectTimeout(i);
    setResponseTimeout(i);
  }
  
  public void setURLEncodingEnabled(boolean paramBoolean) {
    this.isUrlEncodingEnabled = paramBoolean;
  }
  
  public void setUserAgent(String paramString) {
    HttpProtocolParams.setUserAgent(this.httpClient.getParams(), paramString);
  }
  
  static class InflatingEntity extends HttpEntityWrapper {
    GZIPInputStream gzippedStream;
    
    PushbackInputStream pushbackStream;
    
    InputStream wrappedStream;
    
    public InflatingEntity(HttpEntity param1HttpEntity) {
      super(param1HttpEntity);
    }
    
    public void consumeContent() throws IOException {
      AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
      AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
      AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
      super.consumeContent();
    }
    
    public InputStream getContent() throws IOException {
      this.wrappedStream = this.wrappedEntity.getContent();
      this.pushbackStream = new PushbackInputStream(this.wrappedStream, 2);
      if (AsyncHttpClient.isInputStreamGZIPCompressed(this.pushbackStream)) {
        this.gzippedStream = new GZIPInputStream(this.pushbackStream);
        return this.gzippedStream;
      } 
      return this.pushbackStream;
    }
    
    public long getContentLength() {
      return (this.wrappedEntity == null) ? 0L : this.wrappedEntity.getContentLength();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\AsyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */