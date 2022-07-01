package com.bytedance.sdk.openadsdk.utils;

import android.util.Log;

public class t {
  private static boolean a = false;
  
  private static int b = 4;
  
  public static void a(int paramInt) {
    b = paramInt;
  }
  
  public static void a(String paramString) {
    if (!c())
      return; 
    b("Logger", paramString);
  }
  
  public static void a(String paramString1, String paramString2) {
    if (!c())
      return; 
    if (paramString2 == null)
      return; 
    if (b <= 2)
      Log.v(paramString1, paramString2); 
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (!c())
      return; 
    if (paramString2 == null && paramThrowable == null)
      return; 
    if (b <= 3)
      Log.d(paramString1, paramString2, paramThrowable); 
  }
  
  public static boolean a() {
    return (b <= 3);
  }
  
  public static void b() {
    a = true;
    a(3);
  }
  
  public static void b(String paramString) {
    if (!c())
      return; 
    e("Logger", paramString);
  }
  
  public static void b(String paramString1, String paramString2) {
    if (!c())
      return; 
    if (paramString2 == null)
      return; 
    if (b <= 3)
      Log.d(paramString1, paramString2); 
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable) {
    if (!c())
      return; 
    if (paramString2 == null && paramThrowable == null)
      return; 
    if (b <= 5)
      Log.w(paramString1, paramString2, paramThrowable); 
  }
  
  public static void c(String paramString1, String paramString2) {
    if (!c())
      return; 
    if (paramString2 == null)
      return; 
    if (b <= 4)
      Log.i(paramString1, paramString2); 
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable) {
    if (!c())
      return; 
    if (paramString2 == null && paramThrowable == null)
      return; 
    if (b <= 6)
      Log.e(paramString1, paramString2, paramThrowable); 
  }
  
  public static boolean c() {
    return a;
  }
  
  public static void d(String paramString1, String paramString2) {
    if (!c())
      return; 
    if (paramString2 == null)
      return; 
    if (b <= 5)
      Log.w(paramString1, paramString2); 
  }
  
  public static void e(String paramString1, String paramString2) {
    if (!c())
      return; 
    if (paramString2 == null)
      return; 
    if (b <= 6)
      Log.e(paramString1, paramString2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */