package com.blued.android.module.live.base.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.blued.android.core.AppInfo;

public class LiveBasePreferences {
  public static SharedPreferences a;
  
  public static SharedPreferences a() {
    if (a == null)
      a = PreferenceManager.getDefaultSharedPreferences(AppInfo.d()); 
    return a;
  }
  
  public static String a(String paramString) {
    return a().getString("pay_token", paramString);
  }
  
  public static void b(String paramString) {
    a().edit().putString("pay_token", paramString).commit();
  }
  
  public static boolean b() {
    return a().getBoolean("first_charge", false);
  }
  
  public static String c() {
    return a().getString("LIVE_MUSIC_SEARCH_HISTORY", "");
  }
  
  public static void c(String paramString) {
    a().edit().putString("LIVE_MUSIC_SEARCH_HISTORY", paramString).apply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\LiveBasePreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */