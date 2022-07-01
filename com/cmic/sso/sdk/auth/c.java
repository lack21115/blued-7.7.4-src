package com.cmic.sso.sdk.auth;

import android.os.Bundle;
import android.util.Log;
import com.cmic.sso.sdk.utils.f;
import org.json.JSONException;
import org.json.JSONObject;

class c {
  public static JSONObject a(String paramString1, String paramString2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("resultCode", paramString1);
      jSONObject.put("resultDesc", paramString2);
      return jSONObject;
    } catch (JSONException jSONException) {
      Log.e("AuthnResult", "JSONException", (Throwable)jSONException);
      return jSONObject;
    } 
  }
  
  static JSONObject a(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject) {
    String str = "0";
    JSONObject jSONObject = new JSONObject();
    try {
      String str1;
      int i = Integer.valueOf(paramBundle.getString("authtype", "0")).intValue();
      int j = paramBundle.getInt("networkType");
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            str1 = "其他";
          } else {
            str = "3";
            str1 = "短信上行";
          } 
        } else if (j == 3) {
          str1 = "WIFI下网关鉴权";
          str = "1";
        } else {
          str1 = "网关鉴权";
          str = "2";
        } 
      } else {
        str = "7";
        str1 = "短信验证码";
      } 
      jSONObject.put("resultCode", paramString1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("");
      jSONObject.put("authType", stringBuilder1.toString());
      jSONObject.put("authTypeDes", str1);
      if ("103000".equals(paramString1)) {
        if (1 == paramBundle.getInt("logintype", 0))
          jSONObject.put("openId", paramBundle.getString("openId")); 
        jSONObject.put("token", paramJSONObject.optString("token"));
      } else {
        jSONObject.put("resultDesc", paramString2);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("返回参数:");
    stringBuilder.append(jSONObject.toString());
    f.b("AuthnResult", stringBuilder.toString());
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\auth\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */