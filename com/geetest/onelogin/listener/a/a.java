package com.geetest.onelogin.listener.a;

import android.os.Build;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.b.b;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.i.c;
import com.geetest.onelogin.j.c;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static JSONObject a(String paramString) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put(b.f, paramString);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public static JSONObject a(String paramString, d paramd, JSONObject paramJSONObject) {
    JSONObject jSONObject = e(paramString, paramd, paramJSONObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPreTokenFail code=");
    stringBuilder.append(paramString);
    c.a(stringBuilder.toString());
    if (b.w().j()) {
      c.b(paramd, paramString, paramJSONObject);
    } else {
      c.a(paramd, paramString, paramJSONObject);
    } 
    if (b.w().k())
      b.w().a(180000L); 
    return jSONObject;
  }
  
  public static JSONObject b(String paramString, d paramd, JSONObject paramJSONObject) {
    JSONObject jSONObject = e(paramString, paramd, paramJSONObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onOpenAuthFail code=");
    stringBuilder.append(paramString);
    c.a(stringBuilder.toString());
    if (!paramString.equals(com.geetest.onelogin.b.a.b))
      c.b(paramd, paramString, paramJSONObject); 
    return jSONObject;
  }
  
  public static JSONObject c(String paramString, d paramd, JSONObject paramJSONObject) {
    JSONObject jSONObject = e(paramString, paramd, paramJSONObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onOpenAuthFail code=");
    stringBuilder.append(paramString);
    c.a(stringBuilder.toString());
    if (!paramString.equals(com.geetest.onelogin.b.a.b))
      c.b(paramd, paramString, paramJSONObject); 
    if (b.w().k())
      b.w().a(180000L); 
    return jSONObject;
  }
  
  public static JSONObject d(String paramString, d paramd, JSONObject paramJSONObject) {
    JSONObject jSONObject = e(paramString, paramd, paramJSONObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onRequestTokenFail code=");
    stringBuilder.append(paramString);
    c.a(stringBuilder.toString());
    if (!paramString.equals("-20303") && !paramString.equals("-20302") && !paramString.equals("-20301") && !paramString.equals(com.geetest.onelogin.b.a.b))
      c.b(paramd, paramString, paramJSONObject); 
    return jSONObject;
  }
  
  private static JSONObject e(String paramString, d paramd, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put(b.a, paramString);
      jSONObject.put(b.c, paramd.getProcessId());
      jSONObject.put(b.d, paramJSONObject);
      String str = b.b;
      if (paramd.getOpBean() != null) {
        paramString = paramd.getOpBean().a();
      } else {
        paramString = paramd.getOperator();
      } 
      jSONObject.put(str, paramString);
      jSONObject.put("clienttype", "1");
      jSONObject.put("sdk", "2.1.4.1");
      jSONObject.put(b.e, paramd.getMessage());
      jSONObject.put("status", 500);
      jSONObject.put("app_id", paramd.getAppId());
      jSONObject.put("release", Build.VERSION.RELEASE);
      jSONObject.put("model", Build.MODEL);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\listener\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */