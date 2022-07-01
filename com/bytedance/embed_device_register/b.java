package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.embedapplog.IOaidObserver;
import java.util.Map;
import org.json.JSONObject;

public final class b {
  private static final String a;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.class.getSimpleName());
    stringBuilder.append("#");
    a = stringBuilder.toString();
  }
  
  public static String a(SharedPreferences paramSharedPreferences) {
    long l = SystemClock.elapsedRealtime();
    String str = a.a(paramSharedPreferences);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("getCdid takes ");
    stringBuilder.append(SystemClock.elapsedRealtime() - l);
    stringBuilder.append(" ms");
    c.a("TrackerDr", stringBuilder.toString());
    return str;
  }
  
  public static String a(JSONObject paramJSONObject) {
    String str = null;
    if (paramJSONObject != null)
      str = paramJSONObject.optString("id", null); 
    return str;
  }
  
  public static void a(Context paramContext, SharedPreferences paramSharedPreferences) {
    g.a(paramContext, paramSharedPreferences);
  }
  
  public static void a(IOaidObserver paramIOaidObserver) {
    g.a(paramIOaidObserver);
  }
  
  public static Map<String, String> b(Context paramContext, SharedPreferences paramSharedPreferences) {
    long l = SystemClock.elapsedRealtime();
    Map<String, String> map = g.b(paramContext, paramSharedPreferences);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("getOaid takes ");
    stringBuilder.append(SystemClock.elapsedRealtime() - l);
    stringBuilder.append(" ms");
    c.a("TrackerDr", stringBuilder.toString());
    return map;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */