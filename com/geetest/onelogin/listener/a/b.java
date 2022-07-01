package com.geetest.onelogin.listener.a;

import android.os.Build;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.i.c;
import com.geetest.onelogin.j.c;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  public static JSONObject a(d paramd) {
    JSONObject jSONObject = new JSONObject();
    paramd.setPreTokenSuccess(true);
    paramd.setPreTokenValidate(true);
    String str = paramd.getProcessId();
    try {
      jSONObject.put("msg", paramd.getMessage());
      jSONObject.put("number", paramd.getNumber());
      jSONObject.put("operator", paramd.getOpBean().a());
      jSONObject.put("status", 200);
      jSONObject.put("clienttype", "1");
      jSONObject.put("accessCode", paramd.getAccessCode());
      jSONObject.put("process_id", str);
      jSONObject.put("sdk", "2.1.4.1");
      jSONObject.put("app_id", paramd.getAppId());
      jSONObject.put("expire_time", paramd.getExpireTime());
      jSONObject.put("release", Build.VERSION.RELEASE);
      jSONObject.put("model", Build.MODEL);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    paramd.setStartTime(System.currentTimeMillis() / 1000L);
    if (com.geetest.onelogin.f.b.w().k()) {
      com.geetest.onelogin.f.b.w().a((paramd.getExpireTime() * 1000));
    } else {
      c.a(paramd);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPreGetTokenSuccess jsonObject=");
    stringBuilder.append(jSONObject);
    c.a(stringBuilder.toString());
    return jSONObject;
  }
  
  public static JSONObject b(d paramd) {
    JSONObject jSONObject = new JSONObject();
    paramd.setPreTokenSuccess(false);
    paramd.setRequestTokenSuccess(true);
    String str = paramd.getProcessId();
    try {
      jSONObject.put("msg", paramd.getMessage());
      jSONObject.put("operator", paramd.getOpBean().a());
      jSONObject.put("status", 200);
      jSONObject.put("clienttype", "1");
      jSONObject.put("token", paramd.getToken());
      jSONObject.put("authcode", paramd.getGwAuth());
      jSONObject.put("process_id", str);
      jSONObject.put("sdk", "2.1.4.1");
      jSONObject.put("app_id", paramd.getAppId());
      jSONObject.put("release", Build.VERSION.RELEASE);
      jSONObject.put("model", Build.MODEL);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    c.b(paramd, "0", null);
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\listener\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */