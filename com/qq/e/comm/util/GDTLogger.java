package com.qq.e.comm.util;

import android.util.Log;
import com.qq.e.comm.services.a;

public class GDTLogger {
  public static final boolean DEBUG_ENABLE = false;
  
  public static void d(String paramString) {}
  
  public static void e(String paramString) {
    Log.e("gdt_ad_mob", paramString);
  }
  
  public static void e(String paramString, Throwable paramThrowable) {
    if (paramThrowable == null) {
      Log.e("gdt_ad_mob", paramString);
      return;
    } 
    Log.e("gdt_ad_mob", paramString, paramThrowable);
  }
  
  public static void i(String paramString) {
    Log.i("gdt_ad_mob", paramString);
  }
  
  public static void report(String paramString) {
    report(paramString, null);
  }
  
  public static void report(String paramString, Throwable paramThrowable) {
    e(paramString, paramThrowable);
    a.a();
    a.a(paramString, paramThrowable);
  }
  
  public static void w(String paramString) {
    Log.e("gdt_ad_mob", paramString);
  }
  
  public static void w(String paramString, Throwable paramThrowable) {
    if (paramThrowable == null) {
      Log.w("gdt_ad_mob", paramString);
      return;
    } 
    Log.w("gdt_ad_mob", paramString, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\GDTLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */