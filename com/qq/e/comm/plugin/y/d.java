package com.qq.e.comm.plugin.y;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
  private JSONObject a;
  
  public d() {
    this(new JSONObject());
  }
  
  public d(JSONObject paramJSONObject) {
    this.a = paramJSONObject;
  }
  
  public d a(String paramString, Object paramObject) {
    if (TextUtils.isEmpty(paramString))
      return this; 
    try {
      this.a.putOpt(paramString, paramObject);
      return this;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return this;
    } 
  }
  
  public JSONObject a() {
    JSONObject jSONObject = this.a;
    return (jSONObject == null || jSONObject.length() <= 0) ? null : this.a;
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */