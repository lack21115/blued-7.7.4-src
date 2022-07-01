package com.soft.blued.ui.msg;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.blued.android.core.AppInfo;

public class MsgPreferences {
  public static SharedPreferences a;
  
  public static String b = "MSG_FILTER_NEW_MSG_GUIDE";
  
  public static void a() {
    d().edit().putBoolean(b, false).commit();
  }
  
  public static void a(String paramString) {
    d().edit().putString("chat_recent_photos", paramString).apply();
  }
  
  public static String b() {
    return d().getString("chat_recent_photos", "");
  }
  
  public static void c() {
    d().edit().putBoolean("chat_recent_photos_guide", false).apply();
  }
  
  private static SharedPreferences d() {
    if (a == null)
      a = PreferenceManager.getDefaultSharedPreferences(AppInfo.d()); 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */