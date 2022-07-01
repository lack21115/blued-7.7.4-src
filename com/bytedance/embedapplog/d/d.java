package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.h;
import java.util.Iterator;
import org.json.JSONObject;

public class d extends a {
  private String h;
  
  private String i;
  
  public d(String paramString, JSONObject paramJSONObject) {
    this.i = paramString;
    this.h = paramJSONObject.toString();
  }
  
  public a a(Cursor paramCursor) {
    this.a = paramCursor.getLong(0);
    this.b = paramCursor.getLong(1);
    this.c = paramCursor.getString(2);
    this.d = paramCursor.getString(3);
    this.h = paramCursor.getString(4);
    this.i = paramCursor.getString(5);
    return this;
  }
  
  protected void a(ContentValues paramContentValues) {
    paramContentValues.put("local_time_ms", Long.valueOf(this.a));
    paramContentValues.put("tea_event_index", Long.valueOf(this.b));
    paramContentValues.put("session_id", this.c);
    paramContentValues.put("user_unique_id", this.d);
    paramContentValues.put("params", this.h);
    paramContentValues.put("log_type", this.i);
  }
  
  protected void a(JSONObject paramJSONObject) {
    paramJSONObject.put("local_time_ms", this.a);
    paramJSONObject.put("tea_event_index", this.b);
    paramJSONObject.put("session_id", this.c);
    paramJSONObject.put("user_unique_id", this.d);
    paramJSONObject.put("params", this.h);
    paramJSONObject.put("log_type", this.i);
  }
  
  protected String[] a() {
    return new String[] { 
        "local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "params", "varchar", 
        "log_type", "varchar" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    this.a = paramJSONObject.optLong("local_time_ms", 0L);
    this.b = paramJSONObject.optLong("tea_event_index", 0L);
    this.c = paramJSONObject.optString("session_id", null);
    this.d = paramJSONObject.optString("user_unique_id", null);
    this.h = paramJSONObject.optString("params", null);
    this.i = paramJSONObject.optString("log_type", null);
    return this;
  }
  
  protected JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("local_time_ms", this.a);
    jSONObject.put("tea_event_index", this.b);
    jSONObject.put("session_id", this.c);
    if (!TextUtils.isEmpty(this.d))
      jSONObject.put("user_unique_id", this.d); 
    jSONObject.put("log_type", this.i);
    try {
      JSONObject jSONObject1 = new JSONObject(this.h);
      Iterator<String> iterator = jSONObject1.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        Object object = jSONObject1.get(str);
        if (jSONObject.opt(str) != null)
          h.b("misc事件存在重复的key", null); 
        jSONObject.put(str, object);
      } 
    } catch (Exception exception) {
      h.c("解析 event misc 失败", exception);
    } 
    return jSONObject;
  }
  
  String d() {
    return "event_misc";
  }
  
  protected String h() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("param:");
    stringBuilder.append(this.h);
    stringBuilder.append(" logType:");
    stringBuilder.append(this.i);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */