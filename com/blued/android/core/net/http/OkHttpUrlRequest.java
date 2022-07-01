package com.blued.android.core.net.http;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.utils.Log;
import com.qiniu.android.dns.DnsManager;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class OkHttpUrlRequest {
  private long a;
  
  private Callback a(HttpResponseHandler<?> paramHttpResponseHandler) {
    return new Callback(this, paramHttpResponseHandler) {
        public void onFailure(Call param1Call, IOException param1IOException) {
          if (this.a != null) {
            HttpUrl httpUrl = param1Call.a().a();
            OkHttpUrlRequest.a(this.b, httpUrl, null, this.a);
            this.a.sendFailureMessage(httpUrl.toString(), param1IOException, StatusCode.a(param1IOException), null);
            this.a.sendFinishMessage();
            OkHttpUrlRequest.a(this.b, null);
          } 
        }
        
        public void onResponse(Call param1Call, Response param1Response) {
          if (this.a != null) {
            HttpUrl httpUrl = param1Call.a().a();
            String str = httpUrl.toString();
            if (param1Response == null) {
              OkHttpUrlRequest.a(this.b, httpUrl, null, this.a);
              this.a.sendFailureMessage(str, new Exception("response is null!"), -1001, null);
            } else {
              OkHttpUrlRequest.a(this.b, httpUrl, param1Response.a().a(), this.a);
              if (HttpManager.c()) {
                Handshake handshake = param1Response.f();
                if (handshake != null) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("onResponse() tlsVersion=");
                  stringBuilder.append(handshake.a());
                  stringBuilder.append(", cipherSuite=");
                  stringBuilder.append(param1Response.f().b().toString());
                  Log.c("HttpManager", stringBuilder.toString());
                } 
              } 
              int i = param1Response.c();
              if (param1Response.h() == null) {
                this.a.sendFailureMessage(str, new Exception("response body is null!"), i, null);
              } else {
                String str1;
                HttpResponseHandler httpResponseHandler = this.a;
                if (httpResponseHandler instanceof StringHttpResponseHandler) {
                  StringHttpResponseHandler stringHttpResponseHandler = (StringHttpResponseHandler)httpResponseHandler;
                  str1 = "";
                  try {
                    String str2 = param1Response.h().g();
                    str1 = str2;
                    if (param1Response.d()) {
                      str1 = str2;
                      stringHttpResponseHandler.sendSuccessMessage(str, i, str2);
                    } else {
                      str1 = str2;
                      StringBuilder stringBuilder = new StringBuilder();
                      str1 = str2;
                      stringBuilder.append("response is not successful! Response:");
                      str1 = str2;
                      stringBuilder.append(str2);
                      str1 = str2;
                      stringHttpResponseHandler.sendFailureMessage(str, new Exception(stringBuilder.toString()), i, str2);
                    } 
                  } catch (IOException iOException) {
                    iOException.printStackTrace();
                    int j = i;
                    if (i == 0)
                      j = StatusCode.a(iOException); 
                    stringHttpResponseHandler.sendFailureMessage(str, iOException, j, str1);
                  } 
                } else {
                  str1.sendResponseMessage(str, param1Response);
                } 
              } 
            } 
            this.a.sendFinishMessage();
          } 
          OkHttpUrlRequest.a(this.b, param1Response);
        }
      };
  }
  
  private static RequestBody a(MediaType paramMediaType, File paramFile, HttpResponseHandler<?> paramHttpResponseHandler) {
    return new RequestBody(paramMediaType, paramFile, paramHttpResponseHandler) {
        public long contentLength() {
          return this.b.length();
        }
        
        public MediaType contentType() {
          return this.a;
        }
        
        public void writeTo(BufferedSink param1BufferedSink) throws IOException {
          try {
            long l2 = contentLength();
            long l1 = 0L;
            int i = -1;
            Source source = Okio.source(this.b);
            Buffer buffer = new Buffer();
            while (true) {
              long l = source.read(buffer, 2048L);
              if (l != -1L) {
                param1BufferedSink.write(buffer, l);
                l = l1 + l;
                l1 = l;
                if (this.c != null) {
                  int j = (int)((float)l * 100.0F / (float)l2);
                  l1 = l;
                  if (j != i) {
                    this.c.sendProgressMessage(j, (int)l2);
                    i = j;
                    l1 = l;
                  } 
                } 
                continue;
              } 
              break;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
        }
      };
  }
  
  private void a(HttpUrl paramHttpUrl1, HttpUrl paramHttpUrl2, HttpResponseHandler paramHttpResponseHandler) {
    if (paramHttpUrl2 != null) {
      String str = paramHttpUrl2.f();
      if (DnsManager.validIP(str)) {
        paramHttpResponseHandler.setServerIP(str);
        return;
      } 
    } 
    if (HttpManager.d() != null) {
      String[] arrayOfString = HttpManager.d().queryFromCache(paramHttpUrl1.f());
      if (arrayOfString != null && arrayOfString.length > 0)
        paramHttpResponseHandler.setServerIP(arrayOfString[0]); 
    } 
  }
  
  private void a(Response paramResponse) {
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder("request take time:");
      stringBuilder.append(System.currentTimeMillis() - this.a);
      if (paramResponse != null) {
        stringBuilder.append(" / real take time:");
        stringBuilder.append(paramResponse.o() - paramResponse.n());
        Request request = paramResponse.a();
        if (request != null && request.a() != null) {
          stringBuilder.append(" [");
          stringBuilder.append(paramResponse.a().a().toString());
          stringBuilder.append("]");
        } 
      } 
      Log.a("HttpManager", stringBuilder.toString());
    } 
  }
  
  private RequestBody b(HttpRequestWrapper paramHttpRequestWrapper) {
    FormBody.Builder builder;
    RequestParams requestParams = paramHttpRequestWrapper.c();
    if (requestParams == null)
      return RequestBody.create(null, ""); 
    if (requestParams.e != null)
      return RequestBody.create(MediaType.b("application/json"), requestParams.e); 
    if (requestParams.f != null) {
      builder = new FormBody.Builder();
      for (Map.Entry<String, String> entry : requestParams.f.entrySet())
        builder.a((String)entry.getKey(), (String)entry.getValue()); 
      return (RequestBody)builder.a();
    } 
    if (requestParams.g != null)
      return RequestBody.create(MediaType.b("application/octet-stream"), requestParams.g); 
    if (!TextUtils.isEmpty(requestParams.c)) {
      MultipartBody.Builder builder1 = (new MultipartBody.Builder()).a(MultipartBody.e);
      for (Map.Entry<String, String> entry : requestParams.a.entrySet())
        builder1.a((String)entry.getKey(), (String)entry.getValue()); 
      File file = new File(requestParams.c);
      RequestBody requestBody = a(MediaType.b("image/jpeg"), file, builder.d());
      if (TextUtils.isEmpty(requestParams.b)) {
        builder1.a(file.getName(), file.getName(), requestBody);
      } else {
        builder1.a(requestParams.b, file.getName(), requestBody);
      } 
      return (RequestBody)builder1.a();
    } 
    if (requestParams.a != null) {
      builder = new FormBody.Builder();
      for (Map.Entry<String, String> entry : requestParams.a.entrySet())
        builder.a((String)entry.getKey(), (String)entry.getValue()); 
      return (RequestBody)builder.a();
    } 
    return RequestBody.create(null, "");
  }
  
  public Call a(HttpRequestWrapper paramHttpRequestWrapper) {
    if (HttpManager.c())
      Log.a("HttpManager", "use okhttp to execute"); 
    HttpResponseHandler<?> httpResponseHandler = paramHttpRequestWrapper.d();
    if (httpResponseHandler != null)
      httpResponseHandler.sendStartMessage(); 
    this.a = System.currentTimeMillis();
    String str = paramHttpRequestWrapper.k();
    try {
      Request.Builder builder = new Request.Builder();
      HttpRequestWrapper.HttpType httpType = paramHttpRequestWrapper.a();
      int i = null.a[httpType.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i == 4)
              builder.c(); 
          } else {
            builder.c(b(paramHttpRequestWrapper));
          } 
        } else {
          builder.a(b(paramHttpRequestWrapper));
        } 
      } else {
        builder.a();
      } 
      builder.a(str);
      Map map = paramHttpRequestWrapper.f();
      if (map != null && map.size() > 0)
        for (Map.Entry entry : map.entrySet())
          builder.b((String)entry.getKey(), (String)entry.getValue());  
      Call call = OkHttpUtils.a.a(builder.d());
      Callback callback = a(httpResponseHandler);
      boolean bool = paramHttpRequestWrapper.h();
      if (bool)
        try {
          callback.onResponse(call, call.b());
          return call;
        } catch (IOException iOException) {
          callback.onFailure(call, iOException);
          return call;
        }  
      call.a(callback);
      return call;
    } catch (Exception exception) {
      exception.printStackTrace();
      if (httpResponseHandler != null) {
        httpResponseHandler.sendFailureMessage(str, exception, -2001, null);
        httpResponseHandler.sendFinishMessage();
      } 
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\OkHttpUrlRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */