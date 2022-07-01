package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

public class a {
  public String a;
  
  public int b = -1;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public static a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    a a1 = new a();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      a1.e = jSONObject.optString("device_plans", null);
      a1.d = jSONObject.optString("real_device_plan", null);
      a1.c = jSONObject.optString("error_msg", null);
      a1.a = jSONObject.optString("anti_plan_type", null);
      String str = jSONObject.optString("error_code");
      return a1;
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  public String a() {
    return b().toString();
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    try {
      paramJSONObject.put("anti_plan_type", this.a);
      paramJSONObject.put("error_code", String.valueOf(this.b));
      paramJSONObject.put("error_msg", this.c);
      paramJSONObject.put("real_device_plan", this.d);
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  public JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    a(jSONObject);
    return jSONObject;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AntiHijackAttempt{anti_plan_type='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", error_code=");
    stringBuilder.append(this.b);
    stringBuilder.append(", error_msg='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", real_device_plan='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", device_plans='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */