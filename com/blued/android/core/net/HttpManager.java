package com.blued.android.core.net;

import android.content.Context;
import com.blued.android.core.net.http.OkHttpUtils;
import com.blued.android.core.net.http.ssl.HttpsIPAccessUtils;
import com.blued.android.core.utils.Log;
import com.qiniu.android.dns.DnsManager;
import java.util.List;

public class HttpManager {
  private static HttpManager b;
  
  public final Builder a;
  
  private HttpManager(Builder paramBuilder) {
    this.a = paramBuilder;
    HttpsIPAccessUtils.a(Builder.a(paramBuilder));
    OkHttpUtils.a();
  }
  
  public static HttpRequestWrapper a(String paramString) {
    return a(paramString, null);
  }
  
  public static HttpRequestWrapper a(String paramString, HttpResponseHandler<?> paramHttpResponseHandler) {
    return a(paramString, paramHttpResponseHandler, null);
  }
  
  public static HttpRequestWrapper a(String paramString, HttpResponseHandler<?> paramHttpResponseHandler, IRequestHost paramIRequestHost) {
    if (Builder.b(b.a)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get(), url: ");
      stringBuilder.append(paramString);
      Log.a("HttpManager", stringBuilder.toString());
    } 
    HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(HttpRequestWrapper.HttpType.a, paramString);
    httpRequestWrapper.a(paramHttpResponseHandler).a(paramIRequestHost);
    return httpRequestWrapper;
  }
  
  public static HttpRequestWrapper a(String paramString1, String paramString2, String paramString3, HttpResponseHandler<?> paramHttpResponseHandler) {
    if (Builder.b(b.a)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("upload(), url: ");
      stringBuilder.append(paramString1);
      stringBuilder.append(", uploadFilePath: ");
      stringBuilder.append(paramString2);
      Log.a("HttpManager", stringBuilder.toString());
    } 
    HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(HttpRequestWrapper.HttpType.b, paramString1);
    httpRequestWrapper.a(paramHttpResponseHandler).a(paramString2, paramString3);
    return httpRequestWrapper;
  }
  
  public static void a(IRequestHost paramIRequestHost) {
    if (paramIRequestHost != null) {
      if (Builder.b(b.a))
        Log.a("HttpManager", "cancelRequests(), activeHolder hashCode: "); 
      OkHttpUtils.a(paramIRequestHost);
    } 
  }
  
  public static boolean a() {
    return !(b == null);
  }
  
  public static HttpManager b() {
    return b;
  }
  
  public static HttpRequestWrapper b(String paramString) {
    return b(paramString, null);
  }
  
  public static HttpRequestWrapper b(String paramString, HttpResponseHandler<?> paramHttpResponseHandler) {
    return b(paramString, paramHttpResponseHandler, null);
  }
  
  public static HttpRequestWrapper b(String paramString, HttpResponseHandler<?> paramHttpResponseHandler, IRequestHost paramIRequestHost) {
    if (Builder.b(b.a)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("post(), url: ");
      stringBuilder.append(paramString);
      Log.a("HttpManager", stringBuilder.toString());
    } 
    HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(HttpRequestWrapper.HttpType.b, paramString);
    httpRequestWrapper.a(paramHttpResponseHandler).a(paramIRequestHost);
    return httpRequestWrapper;
  }
  
  public static boolean c() {
    return Builder.b(b.a);
  }
  
  public static DnsManager d() {
    return Builder.c(b.a);
  }
  
  public static boolean e() {
    return Builder.d(b.a);
  }
  
  protected void a(HttpRequestWrapper paramHttpRequestWrapper) {
    if (paramHttpRequestWrapper != null)
      OkHttpUtils.a(paramHttpRequestWrapper); 
  }
  
  public static class Builder {
    private Context a;
    
    private boolean b = false;
    
    private DnsManager c = null;
    
    private boolean d = true;
    
    private boolean e = false;
    
    private List<String> f = null;
    
    public Builder(Context param1Context) {
      this.a = param1Context;
    }
    
    public Builder a(DnsManager param1DnsManager) {
      return a(param1DnsManager, false, false);
    }
    
    public Builder a(DnsManager param1DnsManager, boolean param1Boolean1, boolean param1Boolean2) {
      this.c = param1DnsManager;
      this.d = param1Boolean1;
      this.e = param1Boolean2;
      return this;
    }
    
    public Builder a(boolean param1Boolean) {
      this.b = param1Boolean;
      return this;
    }
    
    public HttpManager a() {
      if (HttpManager.f() == null) {
        HttpManager.a(new HttpManager(this));
        return HttpManager.f();
      } 
      throw new RuntimeException("HttpManager has been inited");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\HttpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */