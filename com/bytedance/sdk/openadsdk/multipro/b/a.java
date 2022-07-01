package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;

public class a {
  public boolean a;
  
  public boolean b;
  
  public boolean c;
  
  public boolean d;
  
  public long e;
  
  public long f;
  
  public long g;
  
  public static a a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    a a1 = new a();
    a1.b(paramJSONObject.optBoolean("isCompleted"));
    a1.c(paramJSONObject.optBoolean("isFromVideoDetailPage"));
    a1.d(paramJSONObject.optBoolean("isFromDetailPage"));
    a1.a(paramJSONObject.optLong("duration"));
    a1.b(paramJSONObject.optLong("totalPlayDuration"));
    a1.c(paramJSONObject.optLong("currentPlayPosition"));
    a1.a(paramJSONObject.optBoolean("isAutoPlay"));
    return a1;
  }
  
  public a a(long paramLong) {
    this.e = paramLong;
    return this;
  }
  
  public a a(boolean paramBoolean) {
    this.d = paramBoolean;
    return this;
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("isCompleted", this.a);
      jSONObject.put("isFromVideoDetailPage", this.b);
      jSONObject.put("isFromDetailPage", this.c);
      jSONObject.put("duration", this.e);
      jSONObject.put("totalPlayDuration", this.f);
      jSONObject.put("currentPlayPosition", this.g);
      jSONObject.put("isAutoPlay", this.d);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public a b(long paramLong) {
    this.f = paramLong;
    return this;
  }
  
  public a b(boolean paramBoolean) {
    this.a = paramBoolean;
    return this;
  }
  
  public a c(long paramLong) {
    this.g = paramLong;
    return this;
  }
  
  public a c(boolean paramBoolean) {
    this.b = paramBoolean;
    return this;
  }
  
  public a d(boolean paramBoolean) {
    this.c = paramBoolean;
    return this;
  }
  
  public static interface a {
    a a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */