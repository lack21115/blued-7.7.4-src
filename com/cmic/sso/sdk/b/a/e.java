package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("authPageOut", this.b);
      jSONObject.put("authPageIn", this.a);
      jSONObject.put("authClickSuccess", this.d);
      jSONObject.put("timeOnAuthPage", this.e);
      jSONObject.put("authClickFailed", this.c);
      jSONObject.put("authPrivacyState", this.f);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public void c(String paramString) {
    this.d = paramString;
  }
  
  public void d(String paramString) {
    this.e = paramString;
  }
  
  public void e(String paramString) {
    this.a = paramString;
  }
  
  public void f(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */