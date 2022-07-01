package com.blued.android.module.live_china.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

public class LivePreferencesUtils {
  private static SharedPreferences a;
  
  public static SharedPreferences a() {
    if (a == null) {
      Application application;
      if (AppInfo.d() != null) {
        Context context = AppInfo.d();
      } else {
        application = AppUtils.a();
      } 
      a = PreferenceManager.getDefaultSharedPreferences((Context)application);
    } 
    return a;
  }
  
  public static void a(long paramLong) {
    SharedPreferences.Editor editor = a().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_upload_timer_is_done_time");
    editor.putLong(stringBuilder.toString(), paramLong).apply();
  }
  
  public static void a(boolean paramBoolean) {
    SharedPreferences.Editor editor = a().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_enter_room");
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static long b() {
    SharedPreferences sharedPreferences = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_upload_timer_is_done_time");
    return sharedPreferences.getLong(stringBuilder.toString(), 0L);
  }
  
  public static void b(boolean paramBoolean) {
    SharedPreferences.Editor editor = a().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_blind_date_room");
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static void c(boolean paramBoolean) {
    SharedPreferences.Editor editor = a().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_show_big_photo");
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static boolean c() {
    SharedPreferences sharedPreferences = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_enter_room");
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static void d(boolean paramBoolean) {
    SharedPreferences.Editor editor = a().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_scroll_guide");
    editor.putBoolean(stringBuilder.toString(), paramBoolean).apply();
  }
  
  public static boolean d() {
    SharedPreferences sharedPreferences = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_blind_date_room");
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static boolean e() {
    SharedPreferences sharedPreferences = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_show_big_photo");
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  public static boolean f() {
    SharedPreferences sharedPreferences = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().f());
    stringBuilder.append("live_scroll_guide");
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\LivePreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */