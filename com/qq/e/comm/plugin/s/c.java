package com.qq.e.comm.plugin.s;

import org.json.JSONObject;

public class c {
  int a;
  
  String b;
  
  String c;
  
  String d;
  
  String e;
  
  public c(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optInt("type");
    this.b = paramJSONObject.optString("cta_txt");
    this.c = paramJSONObject.optString("form_url");
    this.d = paramJSONObject.optString("consult_url");
    this.e = paramJSONObject.optString("tel");
  }
  
  public int a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public String c() {
    return this.c;
  }
  
  public String d() {
    return this.d;
  }
  
  public String e() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */