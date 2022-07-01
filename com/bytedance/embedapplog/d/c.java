package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class c extends a {
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private long l;
  
  private long m;
  
  c() {}
  
  public c(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4) {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.l = paramLong1;
    this.m = paramLong2;
    this.k = paramString4;
  }
  
  public a a(Cursor paramCursor) {
    this.a = paramCursor.getLong(0);
    this.b = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.d = paramCursor.getString(3);
    this.h = paramCursor.getString(4);
    this.i = paramCursor.getString(5);
    this.l = paramCursor.getInt(6);
    this.m = paramCursor.getInt(7);
    this.k = paramCursor.getString(8);
    this.j = paramCursor.getString(9);
    this.e = paramCursor.getString(10);
    this.f = paramCursor.getString(11);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    paramContentValues.put("local_time_ms", Long.valueOf(this.a));
    paramContentValues.put("tea_event_index", Long.valueOf(this.b));
    paramContentValues.put("session_id", this.c);
    paramContentValues.put("user_unique_id", this.d);
    paramContentValues.put("category", this.h);
    paramContentValues.put("tag", this.i);
    paramContentValues.put("value", Long.valueOf(this.l));
    paramContentValues.put("ext_value", Long.valueOf(this.m));
    paramContentValues.put("params", this.k);
    paramContentValues.put("label", this.j);
    paramContentValues.put("ab_version", this.e);
    paramContentValues.put("ab_sdk_version", this.f);
  }
  
  protected void a(JSONObject paramJSONObject) {
    paramJSONObject.put("local_time_ms", this.a);
    paramJSONObject.put("tea_event_index", this.b);
    paramJSONObject.put("session_id", this.c);
    paramJSONObject.put("user_unique_id", this.d);
    paramJSONObject.put("category", this.h);
    paramJSONObject.put("tag", this.i);
    paramJSONObject.put("value", this.l);
    paramJSONObject.put("ext_value", this.m);
    paramJSONObject.put("params", this.k);
    paramJSONObject.put("label", this.j);
    paramJSONObject.put("ab_version", this.e);
    paramJSONObject.put("ab_sdk_version", this.f);
  }
  
  protected String[] a() {
    return new String[] { 
        "local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "category", "varchar", 
        "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar", 
        "ab_version", "varchar", "ab_sdk_version", "varchar" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optLong("local_time_ms", 0L);
    this.b = paramJSONObject.optLong("tea_event_index", 0L);
    this.c = paramJSONObject.optString("session_id", null);
    this.d = paramJSONObject.optString("user_unique_id", null);
    this.h = paramJSONObject.optString("category", null);
    this.i = paramJSONObject.optString("tag", null);
    this.l = paramJSONObject.optLong("value", 0L);
    this.m = paramJSONObject.optLong("ext_value", 0L);
    this.k = paramJSONObject.optString("params", null);
    this.j = paramJSONObject.optString("label", null);
    this.e = paramJSONObject.optString("ab_version", null);
    this.f = paramJSONObject.optString("ab_sdk_version", null);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject1;
    if (!TextUtils.isEmpty(this.k)) {
      jSONObject1 = new JSONObject(this.k);
    } else {
      jSONObject1 = null;
    } 
    JSONObject jSONObject2 = jSONObject1;
    if (jSONObject1 == null)
      jSONObject2 = new JSONObject(); 
    jSONObject2.put("local_time_ms", this.a);
    jSONObject2.put("tea_event_index", this.b);
    jSONObject2.put("session_id", this.c);
    if (!TextUtils.isEmpty(this.d))
      jSONObject2.put("user_unique_id", this.d); 
    jSONObject2.put("category", this.h);
    jSONObject2.put("tag", this.i);
    jSONObject2.put("value", this.l);
    jSONObject2.put("ext_value", this.m);
    jSONObject2.put("label", this.j);
    jSONObject2.put("datetime", this.g);
    if (!TextUtils.isEmpty(this.e))
      jSONObject2.put("ab_version", this.e); 
    if (!TextUtils.isEmpty(this.f))
      jSONObject2.put("ab_sdk_version", this.f); 
    return jSONObject2;
  }
  
  String d() {
    return "event";
  }
  
  protected String h() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.i);
    stringBuilder.append(", ");
    stringBuilder.append(this.j);
    return stringBuilder.toString();
  }
  
  public String i() {
    return this.i;
  }
  
  public String j() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */