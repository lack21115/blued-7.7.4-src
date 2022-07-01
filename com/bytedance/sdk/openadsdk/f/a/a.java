package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import org.json.JSONObject;

public class a extends d<a> {
  private JSONObject a = new JSONObject();
  
  public a a(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString) && paramObject != null)
      try {
        return this;
      } finally {
        paramString = null;
      }  
    return this;
  }
  
  public JSONObject a() {
    JSONObject jSONObject = super.a();
    try {
      JSONObject jSONObject1;
      String str = jSONObject.optString("event_extra", null);
      if (TextUtils.isEmpty(str)) {
        jSONObject1 = new JSONObject();
      } else {
        jSONObject1 = new JSONObject((String)jSONObject1);
      } 
      jSONObject1.put("dns_info", this.a);
      jSONObject.put("event_extra", jSONObject1.toString());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */