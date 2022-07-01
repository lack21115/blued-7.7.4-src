package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.openadsdk.utils.t;
import org.json.JSONObject;

public class b {
  private String a;
  
  private String b;
  
  private String c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private String g;
  
  public String a() {
    return this.g;
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(String paramString) {
    this.g = paramString;
  }
  
  public String b() {
    return this.a;
  }
  
  public void b(int paramInt) {
    this.e = paramInt;
  }
  
  public void b(String paramString) {
    this.a = paramString;
  }
  
  public String c() {
    return this.b;
  }
  
  public void c(int paramInt) {
    this.f = paramInt;
  }
  
  public void c(String paramString) {
    this.b = paramString;
  }
  
  public String d() {
    return this.c;
  }
  
  public void d(String paramString) {
    this.c = paramString;
  }
  
  public int e() {
    return this.d;
  }
  
  public int f() {
    return this.e;
  }
  
  public int g() {
    return this.f;
  }
  
  public JSONObject h() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("app_name", c());
      jSONObject.put("app_size", g());
      jSONObject.put("comment_num", f());
      jSONObject.put("download_url", b());
      jSONObject.put("package_name", d());
      jSONObject.put("score", e());
      return jSONObject;
    } catch (Exception exception) {
      t.b(exception.toString());
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */