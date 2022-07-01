package com.cmic.sso.sdk.utils;

import android.util.Log;

public class f {
  public static boolean a;
  
  private static final f b = new f();
  
  static {
    a = false;
  }
  
  public static final void a(String paramString1, String paramString2) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CMCC-SDK:");
      stringBuilder.append(paramString2);
      Log.e(paramString1, stringBuilder.toString());
    } 
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static final void b(String paramString1, String paramString2) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CMCC-SDK:");
      stringBuilder.append(paramString2);
      Log.d(paramString1, stringBuilder.toString());
    } 
  }
  
  public static final void c(String paramString1, String paramString2) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CMCC-SDK:");
      stringBuilder.append(paramString2);
      Log.i(paramString1, stringBuilder.toString());
    } 
  }
  
  public static final void d(String paramString1, String paramString2) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(paramString1);
      stringBuilder.append("] : ");
      stringBuilder.append(paramString2);
      Log.d("CMCC-SDK:", stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */