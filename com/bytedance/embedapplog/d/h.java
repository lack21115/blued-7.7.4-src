package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class h extends a {
  public long h;
  
  public String i;
  
  public String j;
  
  public int k;
  
  private JSONObject k() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("page_key", this.j);
    jSONObject.put("refer_page_key", this.i);
    jSONObject.put("is_back", this.k);
    return jSONObject;
  }
  
  public a a(Cursor paramCursor) {
    this.a = paramCursor.getLong(0);
    this.b = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.d = paramCursor.getString(3);
    this.j = paramCursor.getString(4);
    this.i = paramCursor.getString(5);
    this.h = paramCursor.getLong(6);
    this.k = paramCursor.getInt(7);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    paramContentValues.put("local_time_ms", Long.valueOf(this.a));
    paramContentValues.put("tea_event_index", Long.valueOf(this.b));
    paramContentValues.put("session_id", this.c);
    paramContentValues.put("user_unique_id", this.d);
    paramContentValues.put("page_key", this.j);
    paramContentValues.put("refer_page_key", this.i);
    paramContentValues.put("duration", Long.valueOf(this.h));
    paramContentValues.put("is_back", Integer.valueOf(this.k));
  }
  
  protected void a(JSONObject paramJSONObject) {
    paramJSONObject.put("page_key", this.j);
    paramJSONObject.put("refer_page_key", this.i);
    paramJSONObject.put("duration", this.h);
    paramJSONObject.put("local_time_ms", this.a);
    paramJSONObject.put("session_id", this.c);
    paramJSONObject.put("tea_event_index", this.b);
    paramJSONObject.put("is_back", this.k);
  }
  
  protected String[] a() {
    return new String[] { 
        "local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "page_key", "varchar", 
        "refer_page_key", "varchar", "duration", "integer", "is_back", "integer" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optLong("local_time_ms", 0L);
    this.b = paramJSONObject.optLong("tea_event_index", 0L);
    this.c = paramJSONObject.optString("session_id", null);
    this.j = paramJSONObject.optString("page_key", null);
    this.i = paramJSONObject.optString("refer_page_key", null);
    this.h = paramJSONObject.optLong("duration", 0L);
    this.k = paramJSONObject.optInt("is_back", 0);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("local_time_ms", this.a);
    jSONObject.put("tea_event_index", this.b);
    jSONObject.put("session_id", this.c);
    if (!TextUtils.isEmpty(this.d))
      jSONObject.put("user_unique_id", this.d); 
    jSONObject.put("event", "bav2b_page");
    jSONObject.put("is_bav", 1);
    jSONObject.put("params", k());
    jSONObject.put("datetime", this.g);
    return jSONObject;
  }
  
  String d() {
    return "page";
  }
  
  protected String h() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.h());
    stringBuilder.append(" name:");
    stringBuilder.append(this.j);
    stringBuilder.append(" duration:");
    stringBuilder.append(this.h);
    return stringBuilder.toString();
  }
  
  public boolean i() {
    return (this.h == -1L);
  }
  
  public boolean j() {
    return this.j.contains(":");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */