package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

public class j extends a {
  public long h;
  
  long i;
  
  public a a(Cursor paramCursor) {
    h.a(null);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    h.a(null);
  }
  
  protected void a(JSONObject paramJSONObject) {
    h.a(null);
  }
  
  protected String[] a() {
    return null;
  }
  
  protected a b(JSONObject paramJSONObject) {
    h.a(null);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("local_time_ms", this.a);
    jSONObject.put("tea_event_index", this.b);
    jSONObject.put("session_id", this.c);
    jSONObject.put("stop_timestamp", this.i);
    jSONObject.put("duration", this.h / 1000L);
    jSONObject.put("datetime", this.g);
    if (!TextUtils.isEmpty(this.e))
      jSONObject.put("ab_version", this.e); 
    if (!TextUtils.isEmpty(this.f))
      jSONObject.put("ab_sdk_version", this.f); 
    return jSONObject;
  }
  
  String d() {
    return "terminate";
  }
  
  protected String h() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.h());
    stringBuilder.append(" duration:");
    stringBuilder.append(this.h);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */