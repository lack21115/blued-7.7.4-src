package com.blued.android.module.location.utils;

import android.content.SharedPreferences;

public class LocationCacheUtils {
  private static SharedPreferences a;
  
  public static String a() {
    return j().getString("city", "");
  }
  
  public static void a(double paramDouble) {
    SharedPreferences.Editor editor = j().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editor.putString("longitude", stringBuilder.toString()).apply();
  }
  
  public static void a(String paramString) {
    j().edit().putString("city", paramString).apply();
  }
  
  public static void a(boolean paramBoolean) {
    j().edit().putBoolean("fixed_google_bug_154855417", paramBoolean).apply();
  }
  
  public static String b() {
    return j().getString("province", "");
  }
  
  public static void b(double paramDouble) {
    SharedPreferences.Editor editor = j().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editor.putString("latitude", stringBuilder.toString()).apply();
  }
  
  public static void b(String paramString) {
    SharedPreferences.Editor editor = j().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    editor.putString("province", stringBuilder.toString()).apply();
  }
  
  public static void b(boolean paramBoolean) {
    j().edit().putBoolean("is_Google_PlayServices_Available", paramBoolean).apply();
  }
  
  public static String c() {
    return j().getString("longitude", "0");
  }
  
  public static void c(double paramDouble) {
    double d = paramDouble;
    if (paramDouble == Double.MIN_VALUE)
      d = 0.0D; 
    SharedPreferences.Editor editor = j().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d);
    stringBuilder.append("");
    editor.putString("map_longitude", stringBuilder.toString()).apply();
  }
  
  public static void c(String paramString) {
    j().edit().putString("adress", paramString).apply();
  }
  
  public static String d() {
    return j().getString("latitude", "0");
  }
  
  public static void d(double paramDouble) {
    double d = paramDouble;
    if (paramDouble == Double.MIN_VALUE)
      d = 0.0D; 
    SharedPreferences.Editor editor = j().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d);
    stringBuilder.append("");
    editor.putString("map_latitude", stringBuilder.toString()).apply();
  }
  
  public static String e() {
    return j().getString("map_longitude", "0");
  }
  
  public static String f() {
    return j().getString("map_latitude", "0");
  }
  
  public static String g() {
    return j().getString("adress", "");
  }
  
  public static boolean h() {
    return j().getBoolean("fixed_google_bug_154855417", false);
  }
  
  public static boolean i() {
    return j().getBoolean("is_Google_PlayServices_Available", true);
  }
  
  private static SharedPreferences j() {
    if (a == null)
      a = AppUtils.a().getSharedPreferences("module_location_config", 0); 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\LocationCacheUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */