package com.blued.android.module.shortvideo.utils;

public class StvGuideUtils {
  public static boolean a() {
    return StvPreferences.a().b().getBoolean("show_switchcamera_guide", true);
  }
  
  public static void b() {
    StvPreferences.a().b().edit().putBoolean("show_switchcamera_guide", false).commit();
  }
  
  public static boolean c() {
    return StvPreferences.a().b().getBoolean("show_video_auth_guide", true);
  }
  
  public static void d() {
    StvPreferences.a().b().edit().putBoolean("show_video_auth_guide", false).commit();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvGuideUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */