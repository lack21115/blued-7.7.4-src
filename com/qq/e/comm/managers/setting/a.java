package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

final class a extends e {
  a() {}
  
  a(String paramString) {
    super(paramString);
  }
  
  final Object a(String paramString) {
    return this.a.opt(paramString);
  }
  
  final Object a(String paramString1, String paramString2) {
    JSONObject jSONObject = this.a.optJSONObject("ps");
    Object object = null;
    if (jSONObject != null) {
      JSONObject jSONObject1 = jSONObject.optJSONObject(paramString2);
    } else {
      paramString2 = null;
    } 
    if (paramString2 != null)
      object = paramString2.opt(paramString1); 
    return object;
  }
  
  final void a(String paramString, Object paramObject) {
    try {
      this.a.putOpt(paramString, paramObject);
      return;
    } catch (JSONException jSONException) {
      GDTLogger.e("Exception while update setting", (Throwable)jSONException);
      return;
    } 
  }
  
  final void a(String paramString1, Object paramObject, String paramString2) {
    try {
      JSONObject jSONObject2 = this.a.optJSONObject("ps");
      JSONObject jSONObject1 = jSONObject2;
      if (jSONObject2 == null) {
        jSONObject1 = new JSONObject();
        this.a.putOpt("ps", jSONObject1);
      } 
      JSONObject jSONObject3 = jSONObject1.optJSONObject(paramString2);
      jSONObject2 = jSONObject3;
      if (jSONObject3 == null) {
        jSONObject2 = new JSONObject();
        jSONObject1.putOpt(paramString2, jSONObject2);
      } 
      if (paramObject == null) {
        jSONObject2.remove(paramString1);
        return;
      } 
      jSONObject2.putOpt(paramString1, paramObject);
      return;
    } catch (JSONException jSONException) {
      GDTLogger.e("Exception while update setting", (Throwable)jSONException);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\setting\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */