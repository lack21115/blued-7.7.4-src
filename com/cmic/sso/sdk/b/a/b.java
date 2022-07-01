package com.cmic.sso.sdk.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class b extends f {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("version", this.a);
      jSONObject.put("apptype", this.b);
      jSONObject.put("phone_ID", this.c);
      jSONObject.put("certflag", this.d);
      jSONObject.put("sdkversion", this.e);
      jSONObject.put("appid", this.f);
      jSONObject.put("expandparams", this.g);
      jSONObject.put("sign", this.h);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(this.e);
    stringBuilder.append(this.f);
    stringBuilder.append("iYm0HAnkxQtpvN44");
    return n(stringBuilder.toString()).toLowerCase();
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public void c(String paramString) {
    this.c = paramString;
  }
  
  public void d(String paramString) {
    this.d = paramString;
  }
  
  public void e(String paramString) {
    this.e = paramString;
  }
  
  public void f(String paramString) {
    this.f = paramString;
  }
  
  public void g(String paramString) {
    this.h = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */