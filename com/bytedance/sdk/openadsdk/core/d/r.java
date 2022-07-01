package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;

public class r {
  private int a;
  
  private int b;
  
  private long c;
  
  private double d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private int k = 0;
  
  private int l = 0;
  
  public int a() {
    return this.a;
  }
  
  public void a(double paramDouble) {
    this.d = paramDouble;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(long paramLong) {
    this.c = paramLong;
  }
  
  public void a(String paramString) {
    this.e = paramString;
  }
  
  public int b() {
    return this.b;
  }
  
  public void b(int paramInt) {
    this.b = paramInt;
  }
  
  public void b(String paramString) {
    this.f = paramString;
  }
  
  public long c() {
    return this.c;
  }
  
  public void c(int paramInt) {
    this.k = paramInt;
  }
  
  public void c(String paramString) {
    this.g = paramString;
  }
  
  public double d() {
    return this.d;
  }
  
  public void d(int paramInt) {
    this.l = paramInt;
  }
  
  public void d(String paramString) {
    this.h = paramString;
  }
  
  public String e() {
    return this.e;
  }
  
  public void e(String paramString) {
    this.i = paramString;
  }
  
  public String f() {
    return this.f;
  }
  
  public void f(String paramString) {
    this.j = paramString;
  }
  
  public String g() {
    return this.g;
  }
  
  public String h() {
    return this.h;
  }
  
  public String i() {
    return this.i;
  }
  
  public String j() {
    return this.j;
  }
  
  public JSONObject k() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("cover_height", a());
      jSONObject.put("cover_url", f());
      jSONObject.put("cover_width", b());
      jSONObject.put("endcard", h());
      jSONObject.put("file_hash", j());
      jSONObject.put("resolution", e());
      jSONObject.put("size", c());
      jSONObject.put("video_duration", d());
      jSONObject.put("video_url", g());
      jSONObject.put("playable_download_url", i());
      jSONObject.put("if_playable_loading_show", l());
      jSONObject.put("remove_loading_page_type", m());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public int l() {
    return this.k;
  }
  
  public int m() {
    return this.l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */