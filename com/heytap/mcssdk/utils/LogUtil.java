package com.heytap.mcssdk.utils;

import android.util.Log;

public class LogUtil {
  private static String a = "MCS";
  
  private static boolean b = false;
  
  private static boolean c = false;
  
  private static boolean d = true;
  
  private static boolean e = true;
  
  private static boolean f = true;
  
  private static String g = "-->";
  
  private static boolean h = true;
  
  public static void a(String paramString) {
    if (d && h) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(g);
      stringBuilder.append(paramString);
      Log.d("mcssdk---", stringBuilder.toString());
    } 
  }
  
  public static void a(String paramString, Throwable paramThrowable) {
    if (f)
      Log.e(paramString, paramThrowable.toString()); 
  }
  
  public static void b(String paramString) {
    if (f && h) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(g);
      stringBuilder.append(paramString);
      Log.e("mcssdk---", stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssd\\utils\LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */