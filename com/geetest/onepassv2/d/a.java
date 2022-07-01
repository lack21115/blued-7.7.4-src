package com.geetest.onepassv2.d;

import com.geetest.onelogin.j.h;
import com.geetest.onepassv2.f.d;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static JSONObject a(com.geetest.onepassv2.a.a parama) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("process_id", parama.B());
      jSONObject.put("accesscode", parama.r());
      jSONObject.put("phone", parama.t());
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getTokenSuccess JSON 构造错误: ");
      stringBuilder.append(jSONException.toString());
      h.c(stringBuilder.toString());
    } 
    h.b("getTokenSuccess JSON 构造成功");
    d.a("0", null, parama);
    return jSONObject;
  }
  
  public static JSONObject a(String paramString) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("error_data", paramString);
      return jSONObject;
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setGOPMetaData JSON构造错误: ");
      stringBuilder.append(jSONException.toString());
      h.c(stringBuilder.toString());
      return jSONObject;
    } 
  }
  
  public static JSONObject a(String paramString, JSONObject paramJSONObject, com.geetest.onepassv2.a.a parama) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("process_id", parama.B());
      jSONObject.put("code", paramString);
      jSONObject.put("custom_id", parama.A());
      jSONObject.put("metadata", paramJSONObject);
      jSONObject.put("real_op", parama.u());
      jSONObject.put("op", parama.C());
      jSONObject.put("clienttype", "1");
      jSONObject.put("sdk", "2.1.4.1");
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("getTokenSuccess JSON 构造错误: ");
      stringBuilder1.append(jSONException.toString());
      h.c(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getTokenFail JSON 构造成功: ");
    stringBuilder.append(jSONObject.toString());
    h.b(stringBuilder.toString());
    d.a(paramString, paramJSONObject, parama);
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */