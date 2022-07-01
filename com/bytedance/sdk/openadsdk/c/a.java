package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

public class a implements i {
  public final String a;
  
  public final JSONObject b;
  
  a(String paramString, JSONObject paramJSONObject) {
    this.a = paramString;
    this.b = paramJSONObject;
  }
  
  static a a(Context paramContext, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
    return new a(UUID.randomUUID().toString(), b(paramContext, paramString1, paramString2, paramString3, paramJSONObject));
  }
  
  public static a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      paramString = jSONObject.optString("localId", null);
      return (!TextUtils.isEmpty(paramString) && jSONObject != null) ? new a(paramString, jSONObject) : null;
    } finally {
      paramString = null;
    } 
  }
  
  static a a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject) {
    return new a(UUID.randomUUID().toString(), b(paramString1, paramString2, paramString3, paramLong1, paramLong2, paramJSONObject));
  }
  
  private static JSONObject b(Context paramContext, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("event_ts", System.currentTimeMillis());
      jSONObject.putOpt("tag", paramString1);
      jSONObject.putOpt("label", paramString2);
      jSONObject.putOpt("category", "app_union");
      try {
        jSONObject.putOpt("value", Long.valueOf(Long.parseLong(paramString3)));
      } catch (NumberFormatException numberFormatException) {
        jSONObject.putOpt("value", Long.valueOf(0L));
      } 
      jSONObject.putOpt("is_ad_event", "1");
      jSONObject.putOpt("nt", Integer.valueOf(w.c(paramContext)));
      if (paramJSONObject != null) {
        Iterator<String> iterator = paramJSONObject.keys();
        while (iterator.hasNext()) {
          paramString1 = iterator.next();
          jSONObject.putOpt(paramString1, paramJSONObject.opt(paramString1));
        } 
      } 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private static JSONObject b(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("event_ts", System.currentTimeMillis());
      jSONObject.putOpt("tag", paramString2);
      jSONObject.putOpt("label", paramString3);
      jSONObject.putOpt("category", paramString1);
      jSONObject.putOpt("value", Long.valueOf(paramLong1));
      jSONObject.putOpt("is_ad_event", "1");
      jSONObject.putOpt("ext_value", Long.valueOf(paramLong2));
      if (paramJSONObject != null) {
        Iterator<String> iterator = paramJSONObject.keys();
        while (iterator.hasNext()) {
          paramString2 = iterator.next();
          jSONObject.putOpt(paramString2, paramJSONObject.opt(paramString2));
        } 
      } 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public String a() {
    if (!TextUtils.isEmpty(this.a) && this.b != null) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("localId", this.a);
        jSONObject.put("event", this.b);
      } finally {
        Exception exception;
      } 
      return jSONObject.toString();
    } 
    return null;
  }
  
  public String b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */