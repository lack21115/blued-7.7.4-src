package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;

public class d {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final JSONObject d;
  
  private final String e;
  
  public d(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
    this(paramString1, paramString2, paramString3, paramJSONObject, null);
  }
  
  public d(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramJSONObject;
    this.e = paramString4;
  }
  
  public String a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public String c() {
    return this.c;
  }
  
  public JSONObject d() {
    return this.d;
  }
  
  public String e() {
    return this.e;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GDTJsRequest [service=");
    stringBuilder.append(this.a);
    stringBuilder.append(", action=");
    stringBuilder.append(this.b);
    stringBuilder.append(", callbackId=");
    stringBuilder.append(this.c);
    stringBuilder.append(", paraObj=");
    stringBuilder.append(this.d);
    stringBuilder.append(", multiActionPara:");
    stringBuilder.append(this.e);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */