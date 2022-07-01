package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;
import com.qq.e.comm.managers.GDTADManager;

public class av {
  public static void a(String paramString, int paramInt) {
    SharedPreferences.Editor editor = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).edit();
    editor.putInt(paramString, paramInt);
    editor.apply();
  }
  
  public static void a(String paramString, long paramLong) {
    SharedPreferences.Editor editor = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).edit();
    editor.putLong(paramString, paramLong);
    editor.apply();
  }
  
  public static void a(String paramString1, String paramString2) {
    SharedPreferences.Editor editor = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).edit();
    editor.putString(paramString1, paramString2);
    editor.apply();
  }
  
  public static int b(String paramString, int paramInt) {
    return GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).getInt(paramString, paramInt);
  }
  
  public static long b(String paramString, long paramLong) {
    return GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).getLong(paramString, paramLong);
  }
  
  public static String b(String paramString1, String paramString2) {
    return GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).getString(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */