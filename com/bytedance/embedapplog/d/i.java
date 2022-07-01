package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.util.g;
import org.json.JSONObject;

public class i extends a {
  static String h = "succEvent";
  
  public int i;
  
  private String j;
  
  private int k;
  
  private String l;
  
  private int m;
  
  private long n;
  
  i() {}
  
  public i(String paramString1, String paramString2, int paramInt) {
    this.k = 1;
    this.i = AppLog.getSuccRate();
    this.j = paramString1;
    this.l = paramString2;
    this.m = paramInt;
    this.n = g.a();
  }
  
  public a a(Cursor paramCursor) {
    this.a = paramCursor.getLong(0);
    this.b = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.d = paramCursor.getString(3);
    this.j = paramCursor.getString(4);
    this.k = paramCursor.getInt(5);
    this.i = paramCursor.getInt(6);
    this.l = paramCursor.getString(7);
    this.m = paramCursor.getInt(8);
    this.n = paramCursor.getLong(9);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    paramContentValues.put("local_time_ms", Long.valueOf(this.a));
    paramContentValues.put("tea_event_index", Long.valueOf(this.b));
    paramContentValues.put("session_id", this.c);
    paramContentValues.put("user_unique_id", this.d);
    paramContentValues.put("event_name", this.j);
    paramContentValues.put("is_monitor", Integer.valueOf(this.k));
    paramContentValues.put("bav_monitor_rate", Integer.valueOf(this.i));
    paramContentValues.put("monitor_status", this.l);
    paramContentValues.put("monitor_num", Integer.valueOf(this.m));
    paramContentValues.put("date", Long.valueOf(this.n));
  }
  
  protected void a(JSONObject paramJSONObject) {
    paramJSONObject.put("local_time_ms", this.a);
    paramJSONObject.put("tea_event_index", this.b);
    paramJSONObject.put("session_id", this.c);
    paramJSONObject.put("user_unique_id", this.d);
    paramJSONObject.put("event_name", this.j);
    paramJSONObject.put("is_monitor", this.k);
    paramJSONObject.put("bav_monitor_rate", this.i);
    paramJSONObject.put("monitor_status", this.l);
    paramJSONObject.put("monitor_num", this.m);
    paramJSONObject.put("date", this.n);
  }
  
  protected String[] a() {
    return new String[] { 
        "local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event_name", "varchar", 
        "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", "date", "integer" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optLong("local_time_ms", 0L);
    this.b = paramJSONObject.optLong("tea_event_index", 0L);
    this.c = paramJSONObject.optString("session_id", null);
    this.d = paramJSONObject.optString("user_unique_id", null);
    this.j = paramJSONObject.optString("event_name", null);
    this.k = paramJSONObject.optInt("is_monitor", 0);
    this.i = paramJSONObject.optInt("bav_monitor_rate", 0);
    this.l = paramJSONObject.optString("monitor_status", null);
    this.m = paramJSONObject.optInt("monitor_num", 0);
    this.n = paramJSONObject.optLong("date", 0L);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("event_name", this.j);
    jSONObject.put("is_monitor", this.k);
    jSONObject.put("bav_monitor_rate", this.i);
    jSONObject.put("monitor_status", this.l);
    jSONObject.put("monitor_num", this.m);
    return jSONObject;
  }
  
  String d() {
    return h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */