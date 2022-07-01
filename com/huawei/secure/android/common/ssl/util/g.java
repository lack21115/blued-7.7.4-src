package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

public class g {
  private static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SecurityComp10105302: ");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2) {}
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.e(a(paramString1), paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2) {
    Log.i(a(paramString1), paramString2);
  }
  
  public static void c(String paramString1, String paramString2) {
    Log.w(a(paramString1), paramString2);
  }
  
  public static void d(String paramString1, String paramString2) {
    Log.e(a(paramString1), paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */