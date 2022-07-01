package com.bytedance.tea.crash.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tea.crash.e.a.b;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  protected JSONObject a = new JSONObject();
  
  public a() {}
  
  public a(JSONObject paramJSONObject) {}
  
  public static a a(long paramLong, Context paramContext, Thread paramThread, Throwable paramThrowable) {
    String str;
    long l = paramLong;
    if (paramLong == 0L)
      l = System.currentTimeMillis(); 
    a a1 = new a();
    a1.a("isJava", Integer.valueOf(1));
    a1.a("event_type", "java_crash");
    a1.a("timestamp", Long.valueOf(System.currentTimeMillis()));
    a1.a("data", m.a(paramThrowable));
    a1.a("isOOM", Boolean.valueOf(m.b(paramThrowable)));
    a1.a("crash_time", Long.valueOf(l));
    a1.a("process_name", com.bytedance.tea.crash.g.a.d(paramContext));
    if (!com.bytedance.tea.crash.g.a.b(paramContext))
      a1.a("remote_process", Integer.valueOf(1)); 
    com.bytedance.tea.crash.g.a.a(paramContext, a1.a());
    if (paramThread == null) {
      paramContext = null;
    } else {
      str = paramThread.getName();
    } 
    if (str != null)
      a1.a("crash_thread_name", str); 
    a1.a("all_thread_stacks", m.a(str));
    return a1;
  }
  
  public a a(int paramInt, String paramString) {
    try {
      this.a.put("miniapp_id", paramInt);
      this.a.put("miniapp_version", paramString);
      return this;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return this;
    } 
  }
  
  public a a(long paramLong) {
    try {
      a("start_time", Long.valueOf(paramLong));
      a("app_start_time_readable", (new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())).format(new Date(paramLong)));
      return this;
    } catch (Exception exception) {
      exception.printStackTrace();
      return this;
    } 
  }
  
  public a a(b paramb) {
    a("header", paramb.a());
    return this;
  }
  
  public a a(b paramb) {
    a("activity_trace", paramb.a());
    a("running_tasks", paramb.b());
    return this;
  }
  
  public a a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      a("session_id", paramString); 
    return this;
  }
  
  public a a(List<String> paramList) {
    JSONArray jSONArray = new JSONArray();
    if (paramList == null || paramList.isEmpty()) {
      a("patch_info", jSONArray);
      return this;
    } 
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext())
      jSONArray.put(iterator.next()); 
    a("patch_info", jSONArray);
    return this;
  }
  
  public a a(Map<String, Integer> paramMap) {
    JSONArray jSONArray = new JSONArray();
    if (paramMap == null)
      try {
        this.a.put("plugin_info", jSONArray);
        return this;
      } catch (Exception exception) {
        return this;
      }  
    for (String str : exception.keySet()) {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("package_name", str);
      jSONObject.put("version_code", exception.get(str));
      jSONArray.put(jSONObject);
    } 
    this.a.put("plugin_info", jSONArray);
    return this;
  }
  
  public a a(JSONObject paramJSONObject) {
    a("storage", paramJSONObject);
    return this;
  }
  
  public JSONObject a() {
    return this.a;
  }
  
  public void a(String paramString, Object paramObject) {
    try {
      this.a.put(paramString, paramObject);
      return;
    } catch (Exception exception) {
      j.b(exception);
      return;
    } 
  }
  
  public a b(List<String> paramList) {
    JSONArray jSONArray = new JSONArray();
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext())
      jSONArray.put(iterator.next()); 
    a("logcat", jSONArray);
    return this;
  }
  
  public a b(Map<Integer, String> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      JSONObject jSONObject = new JSONObject();
      for (Integer integer : paramMap.keySet()) {
        try {
          jSONObject.put(String.valueOf(integer), paramMap.get(integer));
        } catch (JSONException jSONException) {
          j.b((Throwable)jSONException);
        } 
      } 
      try {
        this.a.put("sdk_info", jSONObject);
        return this;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    return this;
  }
  
  public a c(Map<? extends String, ? extends String> paramMap) {
    if (paramMap != null) {
      JSONObject jSONObject = new JSONObject();
      for (String str : paramMap.keySet()) {
        try {
          jSONObject.put(str, paramMap.get(str));
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
      } 
      a("filters", jSONObject);
    } 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */