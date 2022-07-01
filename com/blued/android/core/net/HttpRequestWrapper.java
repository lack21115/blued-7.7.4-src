package com.blued.android.core.net;

import com.blued.android.core.net.http.RequestParams;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;

public class HttpRequestWrapper {
  private HttpType a = HttpType.a;
  
  private String b;
  
  private String c;
  
  private RequestParams d;
  
  private Map<String, String> e = new HashMap<String, String>();
  
  private HttpResponseHandler<?> f;
  
  private IRequestHost g = null;
  
  private Call h = null;
  
  private Object i = null;
  
  private boolean j;
  
  private boolean k;
  
  public HttpRequestWrapper(HttpType paramHttpType, String paramString) {
    boolean bool = false;
    this.j = false;
    if (HttpManager.d() != null)
      bool = true; 
    this.k = bool;
    this.a = paramHttpType;
    this.b = paramString;
  }
  
  private RequestParams l() {
    if (this.d == null)
      this.d = new RequestParams(); 
    return this.d;
  }
  
  public HttpType a() {
    return this.a;
  }
  
  public HttpRequestWrapper a(HttpResponseHandler<?> paramHttpResponseHandler) {
    this.f = paramHttpResponseHandler;
    if (this.f == null)
      this.f = new StringHttpResponseHandler(this) {
          public void a(String param1String) {}
        }; 
    paramHttpResponseHandler = this.f;
    if (paramHttpResponseHandler != null)
      paramHttpResponseHandler.setHttpRequestWrapper(this); 
    return this;
  }
  
  public HttpRequestWrapper a(IRequestHost paramIRequestHost) {
    this.g = paramIRequestHost;
    return this;
  }
  
  public HttpRequestWrapper a(String paramString) {
    l().a(paramString);
    this.c = "application/json";
    return this;
  }
  
  public HttpRequestWrapper a(String paramString1, String paramString2) {
    l().b(paramString1, paramString2);
    return this;
  }
  
  public HttpRequestWrapper a(Map<String, String> paramMap) {
    if (paramMap != null) {
      if (paramMap.size() <= 0)
        return this; 
      for (Map.Entry<String, String> entry : paramMap.entrySet())
        b((String)entry.getKey(), (String)entry.getValue()); 
    } 
    return this;
  }
  
  public HttpRequestWrapper a(Call paramCall) {
    this.h = paramCall;
    return this;
  }
  
  public HttpRequestWrapper a(boolean paramBoolean) {
    this.k = paramBoolean;
    return this;
  }
  
  public HttpRequestWrapper b(String paramString1, String paramString2) {
    l().a(paramString1, paramString2);
    return this;
  }
  
  public HttpRequestWrapper b(Map<String, String> paramMap) {
    if (paramMap != null) {
      if (paramMap.size() <= 0)
        return this; 
      this.e.putAll(paramMap);
    } 
    return this;
  }
  
  public String b() {
    return this.b;
  }
  
  public RequestParams c() {
    return this.d;
  }
  
  public HttpResponseHandler<?> d() {
    return this.f;
  }
  
  public IRequestHost e() {
    return this.g;
  }
  
  public Map<String, String> f() {
    return this.e;
  }
  
  public HttpRequestWrapper g() {
    this.j = true;
    return this;
  }
  
  public boolean h() {
    return this.j;
  }
  
  public HttpRequestWrapper i() {
    HttpManager.b().a(this);
    return this;
  }
  
  public void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Lokhttp3/Call;
    //   6: ifnull -> 23
    //   9: aload_0
    //   10: getfield h : Lokhttp3/Call;
    //   13: invokeinterface c : ()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield h : Lokhttp3/Call;
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	26	finally
  }
  
  public String k() {
    String str2 = b();
    String str1 = str2;
    if (a() == HttpType.a) {
      str1 = str2;
      if (c() != null)
        str1 = RequestParams.a(str2, c()); 
    } 
    return str1;
  }
  
  public enum HttpType {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\HttpRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */