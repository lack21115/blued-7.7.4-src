package com.qq.e.comm.plugin.r.b;

import org.json.JSONObject;

public class c {
  private String a;
  
  private String b;
  
  private int c;
  
  private int d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private int h;
  
  private int i = -1;
  
  private int j = -1;
  
  private int k = -1;
  
  private boolean l;
  
  private boolean m = false;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private int p = 0;
  
  private boolean q = false;
  
  private boolean r = false;
  
  public c(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optString("name");
    this.b = paramJSONObject.optString("identity");
    this.c = paramJSONObject.optInt("bid");
    this.d = paramJSONObject.optInt("priority");
    this.k = paramJSONObject.optInt("c_priority");
    this.e = paramJSONObject.optString("class_name");
    this.f = paramJSONObject.optString("view_id");
    this.g = paramJSONObject.optString("ext");
    this.h = paramJSONObject.optInt("timeout");
    this.m = paramJSONObject.optBoolean("enable_rt_priority");
    this.n = paramJSONObject.optBoolean("enable_rt_bid");
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public String b() {
    return this.b;
  }
  
  public void b(int paramInt) {
    this.j = paramInt;
  }
  
  public void b(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public int c() {
    return this.c;
  }
  
  public void c(int paramInt) {
    this.p = paramInt;
  }
  
  public void c(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public int d() {
    return this.d;
  }
  
  public void d(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  public String e() {
    return this.e;
  }
  
  public String f() {
    return this.f;
  }
  
  public String g() {
    return this.g;
  }
  
  public int h() {
    return this.h;
  }
  
  public int i() {
    return this.i;
  }
  
  public boolean j() {
    return this.m;
  }
  
  public boolean k() {
    return this.n;
  }
  
  public int l() {
    return this.j;
  }
  
  public boolean m() {
    return this.l;
  }
  
  public int n() {
    return this.k;
  }
  
  public boolean o() {
    return this.o;
  }
  
  public int p() {
    return this.p;
  }
  
  public boolean q() {
    return this.q;
  }
  
  public boolean r() {
    return this.r;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */