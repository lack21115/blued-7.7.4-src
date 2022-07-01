package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class f extends a {
  public int h;
  
  public String i;
  
  boolean j;
  
  volatile boolean k;
  
  public a a(Cursor paramCursor) {
    this.a = paramCursor.getLong(0);
    this.b = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.i = paramCursor.getString(3);
    this.h = paramCursor.getInt(4);
    this.e = paramCursor.getString(5);
    this.f = paramCursor.getString(6);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    paramContentValues.put("local_time_ms", Long.valueOf(this.a));
    paramContentValues.put("tea_event_index", Long.valueOf(this.b));
    paramContentValues.put("session_id", this.c);
    paramContentValues.put("ver_name", this.i);
    paramContentValues.put("ver_code", Integer.valueOf(this.h));
    paramContentValues.put("ab_version", this.e);
    paramContentValues.put("ab_sdk_version", this.f);
  }
  
  protected void a(JSONObject paramJSONObject) {
    paramJSONObject.put("local_time_ms", this.a);
    paramJSONObject.put("tea_event_index", this.b);
    paramJSONObject.put("session_id", this.c);
    paramJSONObject.put("ab_version", this.e);
    paramJSONObject.put("ab_sdk_version", this.f);
  }
  
  protected String[] a() {
    return new String[] { 
        "local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "ver_name", "varchar", "ver_code", "integer", 
        "ab_version", "varchar", "ab_sdk_version", "varchar" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optLong("local_time_ms", 0L);
    this.b = paramJSONObject.optLong("tea_event_index", 0L);
    this.c = paramJSONObject.optString("session_id", null);
    this.e = paramJSONObject.optString("ab_version", null);
    this.f = paramJSONObject.optString("ab_sdk_version", null);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("local_time_ms", this.a);
    jSONObject.put("tea_event_index", this.b);
    jSONObject.put("session_id", this.c);
    boolean bool = this.j;
    if (bool)
      jSONObject.put("is_background", bool); 
    jSONObject.put("datetime", this.g);
    if (!TextUtils.isEmpty(this.e))
      jSONObject.put("ab_version", this.e); 
    if (!TextUtils.isEmpty(this.f))
      jSONObject.put("ab_sdk_version", this.f); 
    return jSONObject;
  }
  
  String d() {
    return "launch";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */