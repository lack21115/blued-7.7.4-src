package com.bytedance.embedapplog.util;

import android.util.Log;

public class h {
  public static boolean a = false;
  
  public static boolean b = false;
  
  public static void a(String paramString, Throwable paramThrowable) {
    if (b)
      Log.d("TeaLog", paramString, paramThrowable); 
  }
  
  public static void a(Throwable paramThrowable) {
    Log.e("TeaLog", "U SHALL NOT PASS!", paramThrowable);
  }
  
  public static void b(String paramString, Throwable paramThrowable) {
    Log.w("TeaLog", paramString, paramThrowable);
  }
  
  public static void c(String paramString, Throwable paramThrowable) {
    Log.e("TeaLog", paramString, paramThrowable);
  }
  
  public static void d(String paramString, Throwable paramThrowable) {
    Log.i("TeaLog", paramString, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */