package com.tencent.ijk.media.player.pragma;

import android.util.Log;
import java.util.Locale;

public class DebugLog {
  public static final boolean ENABLE_DEBUG = true;
  
  public static final boolean ENABLE_ERROR = true;
  
  public static final boolean ENABLE_INFO = true;
  
  public static final boolean ENABLE_VERBOSE = true;
  
  public static final boolean ENABLE_WARN = true;
  
  public static void d(String paramString1, String paramString2) {
    Log.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void dfmt(String paramString1, String paramString2, Object... paramVarArgs) {
    Log.d(paramString1, String.format(Locale.US, paramString2, paramVarArgs));
  }
  
  public static void e(String paramString1, String paramString2) {
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void efmt(String paramString1, String paramString2, Object... paramVarArgs) {
    Log.e(paramString1, String.format(Locale.US, paramString2, paramVarArgs));
  }
  
  public static void i(String paramString1, String paramString2) {
    Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void ifmt(String paramString1, String paramString2, Object... paramVarArgs) {
    Log.i(paramString1, String.format(Locale.US, paramString2, paramVarArgs));
  }
  
  public static void printCause(Throwable paramThrowable) {
    Throwable throwable = paramThrowable.getCause();
    if (throwable != null)
      paramThrowable = throwable; 
    printStackTrace(paramThrowable);
  }
  
  public static void printStackTrace(Throwable paramThrowable) {
    paramThrowable.printStackTrace();
  }
  
  public static void v(String paramString1, String paramString2) {
    Log.v(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void vfmt(String paramString1, String paramString2, Object... paramVarArgs) {
    Log.v(paramString1, String.format(Locale.US, paramString2, paramVarArgs));
  }
  
  public static void w(String paramString1, String paramString2) {
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable) {
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void wfmt(String paramString1, String paramString2, Object... paramVarArgs) {
    Log.w(paramString1, String.format(Locale.US, paramString2, paramVarArgs));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\pragma\DebugLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */