package com.bytedance.sdk.openadsdk.f.a;

import org.json.JSONObject;

public class c extends d<c> {
  private long a;
  
  private long b;
  
  public c a(long paramLong) {
    this.a = paramLong;
    return this;
  }
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    try {
      jSONObject.put("c_process_time", this.a);
      jSONObject.put("s_process_time", this.b);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public c b(long paramLong) {
    this.b = paramLong;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */