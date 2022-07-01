package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;

public class bg {
  private static bg a;
  
  private static SharedPreferences b;
  
  public static bg a() {
    if (a == null)
      a = new bg(); 
    return a;
  }
  
  public static String a(String paramString) {
    return b.getString(paramString, null);
  }
  
  public static String a(String paramString1, String paramString2) {
    return b.getString(paramString1, paramString2);
  }
  
  public static void a(Context paramContext) {
    a = new bg();
    b = paramContext.getSharedPreferences("amap_preferences", 0);
  }
  
  public static boolean a(String paramString, boolean paramBoolean) {
    return b.getBoolean(paramString, paramBoolean);
  }
  
  public static void b(String paramString, boolean paramBoolean) {
    SharedPreferences sharedPreferences = b;
    if (sharedPreferences != null)
      sharedPreferences.edit().putBoolean(paramString, paramBoolean).commit(); 
  }
  
  public int a(String paramString, int paramInt) {
    return b.getInt(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt) {
    SharedPreferences.Editor editor = b.edit();
    editor.putInt(paramString, paramInt);
    editor.commit();
  }
  
  public void b(String paramString1, String paramString2) {
    SharedPreferences.Editor editor = b.edit();
    editor.putString(paramString1, paramString2);
    editor.commit();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */