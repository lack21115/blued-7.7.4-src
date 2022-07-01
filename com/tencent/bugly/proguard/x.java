package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

public final class x {
  public static String a = "CrashReport";
  
  public static boolean b = false;
  
  private static String c = "CrashReportInfo";
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs) {
    String str;
    if (!b)
      return false; 
    if (paramString == null) {
      str = "null";
    } else {
      str = paramString;
      if (paramVarArgs != null)
        if (paramVarArgs.length == 0) {
          str = paramString;
        } else {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }  
    } 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 5)
              return false; 
            Log.i(c, str);
            return true;
          } 
          Log.e(a, str);
          return true;
        } 
        Log.w(a, str);
        return true;
      } 
      Log.d(a, str);
      return true;
    } 
    Log.i(a, str);
    return true;
  }
  
  public static boolean a(Class paramClass, String paramString, Object... paramVarArgs) {
    return a(0, String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString }), paramVarArgs);
  }
  
  public static boolean a(String paramString, Object... paramVarArgs) {
    return a(0, paramString, paramVarArgs);
  }
  
  public static boolean a(Throwable paramThrowable) {
    return !b ? false : a(2, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean b(Class paramClass, String paramString, Object... paramVarArgs) {
    return a(1, String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString }), paramVarArgs);
  }
  
  public static boolean b(String paramString, Object... paramVarArgs) {
    return a(5, paramString, paramVarArgs);
  }
  
  public static boolean b(Throwable paramThrowable) {
    return !b ? false : a(3, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean c(String paramString, Object... paramVarArgs) {
    return a(1, paramString, paramVarArgs);
  }
  
  public static boolean d(String paramString, Object... paramVarArgs) {
    return a(2, paramString, paramVarArgs);
  }
  
  public static boolean e(String paramString, Object... paramVarArgs) {
    return a(3, paramString, paramVarArgs);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */