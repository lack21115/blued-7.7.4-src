package com.qiniu.android.http;

import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public final class Client {
  public static final String ContentTypeHeader = "Content-Type";
  
  public static final String DefaultMime = "application/octet-stream";
  
  public static final String FormMime = "application/x-www-form-urlencoded";
  
  public static final String JsonMime = "application/json";
  
  private final UrlConverter converter;
  
  private OkHttpClient httpClient;
  
  public Client() {
    this(null, 10, 30, null, null);
  }
  
  public Client(ProxyConfiguration paramProxyConfiguration, int paramInt1, int paramInt2, UrlConverter paramUrlConverter, Dns paramDns) {
    this.converter = paramUrlConverter;
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if (paramProxyConfiguration != null) {
      builder.a(paramProxyConfiguration.proxy());
      if (paramProxyConfiguration.user != null && paramProxyConfiguration.password != null)
        builder.a(paramProxyConfiguration.authenticator()); 
    } 
    builder.a(new Dns() {
          public List<InetAddress> lookup(String param1String) throws UnknownHostException {
            List<InetAddress> list = DnsPrefetcher.getDnsPrefetcher().getInetAddressByHost(param1String);
            return (list != null) ? list : Dns.a.lookup(param1String);
          }
        });
    builder.a().add(new Interceptor() {
          public Response intercept(Interceptor.Chain param1Chain) throws IOException {
            String str;
            Request request = param1Chain.a();
            long l1 = System.currentTimeMillis();
            Response response = param1Chain.a(request);
            long l2 = System.currentTimeMillis();
            Client.ResponseTag responseTag = (Client.ResponseTag)request.e();
            try {
              str = param1Chain.b().a().getRemoteSocketAddress().toString();
            } catch (Exception exception) {
              exception.printStackTrace();
              str = "";
            } 
            responseTag.ip = str;
            responseTag.duration = l2 - l1;
            return response;
          }
        });
    builder.a(HttpEventListener.FACTORY);
    builder.a(paramInt1, TimeUnit.SECONDS);
    builder.b(paramInt2, TimeUnit.SECONDS);
    builder.c(0L, TimeUnit.SECONDS);
    this.httpClient = builder.b();
  }
  
  private void asyncMultipartPost(LogHandler paramLogHandler, String paramString1, StringMap paramStringMap, UpToken paramUpToken, long paramLong, ProgressHandler paramProgressHandler, String paramString2, RequestBody paramRequestBody, CompletionHandler paramCompletionHandler, CancellationHandler paramCancellationHandler) {
    // Byte code:
    //   0: aload_0
    //   1: getfield converter : Lcom/qiniu/android/http/UrlConverter;
    //   4: astore #12
    //   6: aload #12
    //   8: ifnull -> 23
    //   11: aload #12
    //   13: aload_2
    //   14: invokeinterface convert : (Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_2
    //   20: goto -> 23
    //   23: new com/qiniu/android/http/MultipartBody$Builder
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore #12
    //   32: aload #12
    //   34: ldc 'file'
    //   36: aload #8
    //   38: aload #9
    //   40: invokevirtual addFormDataPart : (Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lcom/qiniu/android/http/MultipartBody$Builder;
    //   43: pop
    //   44: aload_3
    //   45: new com/qiniu/android/http/Client$6
    //   48: dup
    //   49: aload_0
    //   50: aload #12
    //   52: invokespecial <init> : (Lcom/qiniu/android/http/Client;Lcom/qiniu/android/http/MultipartBody$Builder;)V
    //   55: invokevirtual forEach : (Lcom/qiniu/android/utils/StringMap$Consumer;)V
    //   58: aload #12
    //   60: ldc 'multipart/form-data'
    //   62: invokestatic b : (Ljava/lang/String;)Lokhttp3/MediaType;
    //   65: invokevirtual setType : (Lokhttp3/MediaType;)Lcom/qiniu/android/http/MultipartBody$Builder;
    //   68: pop
    //   69: aload #12
    //   71: invokevirtual build : ()Lcom/qiniu/android/http/MultipartBody;
    //   74: astore #8
    //   76: aload #7
    //   78: ifnonnull -> 89
    //   81: aload #8
    //   83: astore_3
    //   84: aload #11
    //   86: ifnull -> 105
    //   89: new com/qiniu/android/http/CountingRequestBody
    //   92: dup
    //   93: aload #8
    //   95: aload #7
    //   97: lload #5
    //   99: aload #11
    //   101: invokespecial <init> : (Lokhttp3/RequestBody;Lcom/qiniu/android/http/ProgressHandler;JLcom/qiniu/android/http/CancellationHandler;)V
    //   104: astore_3
    //   105: aload_0
    //   106: aload_1
    //   107: new okhttp3/Request$Builder
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: aload_2
    //   115: invokevirtual a : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   118: aload_3
    //   119: invokevirtual a : (Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   122: aconst_null
    //   123: aload #4
    //   125: lload #5
    //   127: aload #10
    //   129: invokevirtual asyncSend : (Lcom/qiniu/android/collect/LogHandler;Lokhttp3/Request$Builder;Lcom/qiniu/android/utils/StringMap;Lcom/qiniu/android/storage/UpToken;JLcom/qiniu/android/http/CompletionHandler;)V
    //   132: return
  }
  
  private static JSONObject buildJsonResp(byte[] paramArrayOfbyte) throws Exception {
    String str = new String(paramArrayOfbyte, "utf-8");
    return StringUtils.isNullOrEmpty(str) ? new JSONObject() : new JSONObject(str);
  }
  
  private static ResponseInfo buildResponseInfo(LogHandler paramLogHandler, Response paramResponse, String paramString, long paramLong1, UpToken paramUpToken, long paramLong2) {
    String str2;
    String str3;
    byte[] arrayOfByte;
    int i = paramResponse.c();
    String str1 = paramResponse.a("X-Reqid");
    JSONObject jSONObject2 = null;
    JSONObject jSONObject1 = null;
    if (str1 == null) {
      str3 = null;
    } else {
      str3 = str1.trim().split(",")[0];
    } 
    try {
      arrayOfByte = paramResponse.h().e();
      str2 = null;
    } catch (IOException iOException) {
      str2 = iOException.getMessage();
      arrayOfByte = null;
    } 
    if (ctype(paramResponse).equals("application/json") && arrayOfByte != null) {
      try {
        JSONObject jSONObject = buildJsonResp(arrayOfByte);
        jSONObject1 = jSONObject;
        jSONObject2 = jSONObject;
        str1 = str2;
        if (paramResponse.c() != 200) {
          jSONObject1 = jSONObject;
          str1 = jSONObject.optString("error", new String(arrayOfByte, "utf-8"));
          jSONObject2 = jSONObject;
        } 
      } catch (Exception exception) {
        jSONObject2 = jSONObject1;
        str1 = str2;
        if (paramResponse.c() < 300) {
          str1 = exception.getMessage();
          jSONObject2 = jSONObject1;
        } 
      } 
    } else if (exception == null) {
      str1 = "null body";
    } else {
      str1 = new String((byte[])exception);
    } 
    HttpUrl httpUrl = paramResponse.a().a();
    return ResponseInfo.create(paramLogHandler, jSONObject2, i, str3, paramResponse.a("X-Log"), via(paramResponse), httpUrl.f(), httpUrl.h(), paramString, httpUrl.g(), paramLong1, getContentLength(paramResponse), str1, paramUpToken, paramLong2);
  }
  
  private static String ctype(Response paramResponse) {
    MediaType mediaType = paramResponse.h().a();
    if (mediaType == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(mediaType.a());
    stringBuilder.append("/");
    stringBuilder.append(mediaType.b());
    return stringBuilder.toString();
  }
  
  private static long getContentLength(Response paramResponse) {
    try {
      return (requestBody == null) ? 0L : requestBody.contentLength();
    } finally {
      paramResponse = null;
    } 
  }
  
  private static void onRet(LogHandler paramLogHandler, Response paramResponse, String paramString, long paramLong1, UpToken paramUpToken, long paramLong2, final CompletionHandler complete) {
    AsyncRun.runInMain(new Runnable() {
          public void run() {
            CompletionHandler completionHandler = complete;
            ResponseInfo responseInfo = info;
            completionHandler.complete(responseInfo, responseInfo.response);
          }
        });
  }
  
  private ResponseInfo send(LogHandler paramLogHandler, final Request.Builder requestBuilder, StringMap paramStringMap) {
    if (paramStringMap != null)
      paramStringMap.forEach(new StringMap.Consumer() {
            public void accept(String param1String, Object param1Object) {
              requestBuilder.a(param1String, param1Object.toString());
            }
          }); 
    requestBuilder.a("User-Agent", UserAgent.instance().getUa(""));
    System.currentTimeMillis();
    ResponseTag responseTag = new ResponseTag();
    responseTag.logHandler = paramLogHandler;
    Request request = requestBuilder.a(responseTag).d();
    try {
      Response response = this.httpClient.a(request).b();
      return buildResponseInfo(paramLogHandler, response, responseTag.ip, responseTag.duration, UpToken.NULL, 0L);
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return ResponseInfo.create(paramLogHandler, null, -1, "", "", "", request.a().f(), request.a().h(), responseTag.ip, request.a().g(), responseTag.duration, -1L, iOException.getMessage(), UpToken.NULL, 0L);
    } 
  }
  
  private ResponseInfo syncMultipartPost(LogHandler paramLogHandler, String paramString1, StringMap paramStringMap, UpToken paramUpToken, long paramLong, String paramString2, RequestBody paramRequestBody) {
    final MultipartBody.Builder mb = new MultipartBody.Builder();
    builder.addFormDataPart("file", paramString2, paramRequestBody);
    paramStringMap.forEach(new StringMap.Consumer() {
          public void accept(String param1String, Object param1Object) {
            mb.addFormDataPart(param1String, param1Object.toString());
          }
        });
    builder.setType(MediaType.b("multipart/form-data"));
    MultipartBody multipartBody = builder.build();
    return syncSend(paramLogHandler, (new Request.Builder()).a(paramString1).a(multipartBody), null, paramUpToken, paramLong);
  }
  
  private static String via(Response paramResponse) {
    String str2 = paramResponse.a("X-Via", "");
    if (!str2.equals(""))
      return str2; 
    str2 = paramResponse.a("X-Px", "");
    if (!str2.equals(""))
      return str2; 
    String str1 = paramResponse.a("Fw-Via", "");
    if (!str1.equals(""));
    return str1;
  }
  
  public void asyncGet(LogHandler paramLogHandler, String paramString, StringMap paramStringMap, UpToken paramUpToken, CompletionHandler paramCompletionHandler) {
    asyncSend(paramLogHandler, (new Request.Builder()).a().a(paramString), paramStringMap, paramUpToken, 0L, paramCompletionHandler);
  }
  
  public void asyncMultipartPost(LogHandler paramLogHandler, String paramString, PostArgs paramPostArgs, UpToken paramUpToken, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, CancellationHandler paramCancellationHandler) {
    long l;
    RequestBody requestBody;
    if (paramPostArgs.file != null) {
      requestBody = RequestBody.create(MediaType.b(paramPostArgs.mimeType), paramPostArgs.file);
      l = paramPostArgs.file.length();
    } else {
      requestBody = RequestBody.create(MediaType.b(paramPostArgs.mimeType), paramPostArgs.data);
      l = paramPostArgs.data.length;
    } 
    asyncMultipartPost(paramLogHandler, paramString, paramPostArgs.params, paramUpToken, l, paramProgressHandler, paramPostArgs.fileName, requestBody, paramCompletionHandler, paramCancellationHandler);
  }
  
  public void asyncPost(LogHandler paramLogHandler, String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, StringMap paramStringMap, UpToken paramUpToken, long paramLong, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, CancellationHandler paramCancellationHandler) {
    // Byte code:
    //   0: aload_0
    //   1: getfield converter : Lcom/qiniu/android/http/UrlConverter;
    //   4: astore #13
    //   6: aload #13
    //   8: ifnull -> 24
    //   11: aload #13
    //   13: aload_2
    //   14: invokeinterface convert : (Ljava/lang/String;)Ljava/lang/String;
    //   19: astore #13
    //   21: goto -> 27
    //   24: aload_2
    //   25: astore #13
    //   27: aload_3
    //   28: ifnull -> 90
    //   31: aload_3
    //   32: arraylength
    //   33: ifle -> 90
    //   36: ldc 'application/octet-stream'
    //   38: invokestatic b : (Ljava/lang/String;)Lokhttp3/MediaType;
    //   41: astore #14
    //   43: aload #14
    //   45: astore_2
    //   46: aload #6
    //   48: ifnull -> 77
    //   51: aload #6
    //   53: ldc 'Content-Type'
    //   55: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   58: astore #15
    //   60: aload #14
    //   62: astore_2
    //   63: aload #15
    //   65: ifnull -> 77
    //   68: aload #15
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokestatic b : (Ljava/lang/String;)Lokhttp3/MediaType;
    //   76: astore_2
    //   77: aload_2
    //   78: aload_3
    //   79: iload #4
    //   81: iload #5
    //   83: invokestatic create : (Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;
    //   86: astore_2
    //   87: goto -> 98
    //   90: aconst_null
    //   91: iconst_0
    //   92: newarray byte
    //   94: invokestatic create : (Lokhttp3/MediaType;[B)Lokhttp3/RequestBody;
    //   97: astore_2
    //   98: aload #10
    //   100: ifnonnull -> 110
    //   103: aload_2
    //   104: astore_3
    //   105: aload #12
    //   107: ifnull -> 125
    //   110: new com/qiniu/android/http/CountingRequestBody
    //   113: dup
    //   114: aload_2
    //   115: aload #10
    //   117: lload #8
    //   119: aload #12
    //   121: invokespecial <init> : (Lokhttp3/RequestBody;Lcom/qiniu/android/http/ProgressHandler;JLcom/qiniu/android/http/CancellationHandler;)V
    //   124: astore_3
    //   125: aload_0
    //   126: aload_1
    //   127: new okhttp3/Request$Builder
    //   130: dup
    //   131: invokespecial <init> : ()V
    //   134: aload #13
    //   136: invokevirtual a : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   139: aload_3
    //   140: invokevirtual a : (Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   143: aload #6
    //   145: aload #7
    //   147: lload #8
    //   149: aload #11
    //   151: invokevirtual asyncSend : (Lcom/qiniu/android/collect/LogHandler;Lokhttp3/Request$Builder;Lcom/qiniu/android/utils/StringMap;Lcom/qiniu/android/storage/UpToken;JLcom/qiniu/android/http/CompletionHandler;)V
    //   154: return
  }
  
  public void asyncPost(LogHandler paramLogHandler, String paramString, byte[] paramArrayOfbyte, StringMap paramStringMap, UpToken paramUpToken, long paramLong, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    asyncPost(paramLogHandler, paramString, paramArrayOfbyte, 0, paramArrayOfbyte.length, paramStringMap, paramUpToken, paramLong, paramProgressHandler, paramCompletionHandler, (CancellationHandler)paramUpCancellationSignal);
  }
  
  public void asyncSend(final LogHandler logHandler, final Request.Builder requestBuilder, StringMap paramStringMap, final UpToken upToken, final long totalSize, final CompletionHandler complete) {
    if (paramStringMap != null)
      paramStringMap.forEach(new StringMap.Consumer() {
            public void accept(String param1String, Object param1Object) {
              requestBuilder.a(param1String, param1Object.toString());
            }
          }); 
    if (upToken != null) {
      requestBuilder.a("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
    } else {
      requestBuilder.a("User-Agent", UserAgent.instance().getUa("pandora"));
    } 
    final ResponseTag tag = new ResponseTag();
    responseTag.logHandler = logHandler;
    this.httpClient.a(requestBuilder.a(responseTag).d()).a(new Callback() {
          public void onFailure(Call param1Call, IOException param1IOException) {
            byte b;
            param1IOException.printStackTrace();
            String str = param1IOException.getMessage();
            if (param1IOException instanceof CancellationHandler.CancellationException) {
              b = -2;
            } else if (param1IOException instanceof UnknownHostException) {
              b = -1003;
            } else if (str != null && str.indexOf("Broken pipe") == 0) {
              b = -1005;
            } else if (param1IOException instanceof java.net.SocketTimeoutException) {
              b = -1001;
            } else if (param1IOException instanceof java.net.ConnectException) {
              b = -1004;
            } else {
              b = -1;
            } 
            HttpUrl httpUrl = param1Call.a().a();
            ResponseInfo responseInfo = ResponseInfo.create(logHandler, null, b, "", "", "", httpUrl.f(), httpUrl.h(), "", httpUrl.g(), tag.duration, -1L, param1IOException.getMessage(), upToken, totalSize);
            complete.complete(responseInfo, null);
          }
          
          public void onResponse(Call param1Call, Response param1Response) throws IOException {
            Client.ResponseTag responseTag = (Client.ResponseTag)param1Response.a().e();
            Client.onRet(logHandler, param1Response, responseTag.ip, responseTag.duration, upToken, totalSize, complete);
          }
        });
  }
  
  public ResponseInfo syncGet(LogHandler paramLogHandler, String paramString, StringMap paramStringMap) {
    return send(paramLogHandler, (new Request.Builder()).a().a(paramString), paramStringMap);
  }
  
  public ResponseInfo syncMultipartPost(LogHandler paramLogHandler, String paramString, PostArgs paramPostArgs, UpToken paramUpToken) {
    long l;
    RequestBody requestBody;
    if (paramPostArgs.file != null) {
      requestBody = RequestBody.create(MediaType.b(paramPostArgs.mimeType), paramPostArgs.file);
      l = paramPostArgs.file.length();
    } else {
      requestBody = RequestBody.create(MediaType.b(paramPostArgs.mimeType), paramPostArgs.data);
      l = paramPostArgs.data.length;
    } 
    return syncMultipartPost(paramLogHandler, paramString, paramPostArgs.params, paramUpToken, l, paramPostArgs.fileName, requestBody);
  }
  
  public ResponseInfo syncSend(LogHandler paramLogHandler, final Request.Builder requestBuilder, StringMap paramStringMap, UpToken paramUpToken, long paramLong) {
    byte b;
    if (paramStringMap != null)
      paramStringMap.forEach(new StringMap.Consumer() {
            public void accept(String param1String, Object param1Object) {
              requestBuilder.a(param1String, param1Object.toString());
            }
          }); 
    requestBuilder.a("User-Agent", UserAgent.instance().getUa(paramUpToken.accessKey));
    ResponseTag responseTag = new ResponseTag();
    responseTag.logHandler = paramLogHandler;
    try {
      Request request = requestBuilder.a(responseTag).d();
      try {
        return buildResponseInfo(paramLogHandler, this.httpClient.a(request).b(), responseTag.ip, responseTag.duration, paramUpToken, paramLong);
      } catch (Exception null) {}
    } catch (Exception exception) {
      paramStringMap = null;
    } 
    exception.printStackTrace();
    String str = exception.getMessage();
    if (exception instanceof UnknownHostException) {
      b = -1003;
    } else if (str != null && str.indexOf("Broken pipe") == 0) {
      b = -1005;
    } else if (exception instanceof java.net.SocketTimeoutException) {
      b = -1001;
    } else if (exception instanceof java.net.ConnectException) {
      b = -1004;
    } else {
      b = -1;
    } 
    HttpUrl httpUrl = paramStringMap.a();
    return ResponseInfo.create(paramLogHandler, null, b, "", "", "", httpUrl.f(), httpUrl.h(), "", httpUrl.g(), 0L, 0L, exception.getMessage(), paramUpToken, paramLong);
  }
  
  public static class ResponseTag {
    public long duration = -1L;
    
    public String ip = "";
    
    public LogHandler logHandler = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */