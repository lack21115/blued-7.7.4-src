package com.qq.e.comm.plugin.y;

import org.json.JSONException;
import org.json.JSONObject;

public class c {
  private final JSONObject a = new JSONObject();
  
  public c a(String paramString) {
    try {
      this.a.putOpt("pid", paramString);
      return this;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return this;
    } 
  }
  
  public JSONObject a() {
    return (this.a.length() > 0) ? this.a : null;
  }
  
  public c b(String paramString) {
    try {
      this.a.putOpt("aid", paramString);
      return this;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return this;
    } 
  }
  
  public c c(String paramString) {
    try {
      this.a.putOpt("traceid", paramString);
      return this;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return this;
    } 
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */