package com.qq.e.comm.plugin.s;

import org.json.JSONObject;

public class e {
  public final JSONObject a;
  
  private final JSONObject b;
  
  public e(JSONObject paramJSONObject) {
    this.b = paramJSONObject;
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("playcfg");
    } 
    this.a = paramJSONObject;
  }
  
  public JSONObject a() {
    return this.b;
  }
  
  public String toString() {
    JSONObject jSONObject = this.b;
    return (jSONObject == null) ? "{}" : jSONObject.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */