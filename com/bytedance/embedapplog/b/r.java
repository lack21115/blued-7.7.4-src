package com.bytedance.embedapplog.b;

import android.content.SharedPreferences;
import org.json.JSONObject;

class r extends c {
  private final h e;
  
  r(h paramh) {
    super(true, false, false);
    this.e = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    SharedPreferences sharedPreferences = this.e.d();
    String str1 = sharedPreferences.getString("install_id", null);
    String str2 = sharedPreferences.getString("device_id", null);
    String str3 = sharedPreferences.getString("ssid", null);
    i.a(paramJSONObject, "install_id", str1);
    i.a(paramJSONObject, "device_id", str2);
    i.a(paramJSONObject, "ssid", str3);
    long l1 = 0L;
    long l2 = sharedPreferences.getLong("register_time", 0L);
    if ((!i.e(str1) || !i.e(str2)) && l2 != 0L) {
      sharedPreferences.edit().putLong("register_time", 0L).apply();
    } else {
      l1 = l2;
    } 
    paramJSONObject.put("register_time", l1);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */