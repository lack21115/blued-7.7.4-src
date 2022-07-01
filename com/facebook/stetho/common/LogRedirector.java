package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogRedirector {
  private static volatile Logger sLogger;
  
  public static void d(String paramString1, String paramString2) {
    log(3, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("\n");
    stringBuilder.append(formatThrowable(paramThrowable));
    d(paramString1, stringBuilder.toString());
  }
  
  public static void e(String paramString1, String paramString2) {
    log(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("\n");
    stringBuilder.append(formatThrowable(paramThrowable));
    e(paramString1, stringBuilder.toString());
  }
  
  private static String formatThrowable(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    paramThrowable.printStackTrace();
    printWriter.flush();
    return stringWriter.toString();
  }
  
  public static void i(String paramString1, String paramString2) {
    log(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("\n");
    stringBuilder.append(formatThrowable(paramThrowable));
    i(paramString1, stringBuilder.toString());
  }
  
  public static boolean isLoggable(String paramString, int paramInt) {
    Logger logger = sLogger;
    return (logger != null) ? logger.isLoggable(paramString, paramInt) : Log.isLoggable(paramString, paramInt);
  }
  
  private static void log(int paramInt, String paramString1, String paramString2) {
    Logger logger = sLogger;
    if (logger != null) {
      logger.log(paramInt, paramString1, paramString2);
      return;
    } 
    Log.println(paramInt, paramString1, paramString2);
  }
  
  public static void setLogger(Logger paramLogger) {
    Util.throwIfNull(paramLogger);
    Util.throwIfNotNull(sLogger);
    sLogger = paramLogger;
  }
  
  public static void v(String paramString1, String paramString2) {
    log(2, paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("\n");
    stringBuilder.append(formatThrowable(paramThrowable));
    v(paramString1, stringBuilder.toString());
  }
  
  public static void w(String paramString1, String paramString2) {
    log(5, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("\n");
    stringBuilder.append(formatThrowable(paramThrowable));
    w(paramString1, stringBuilder.toString());
  }
  
  public static interface Logger {
    boolean isLoggable(String param1String, int param1Int);
    
    void log(int param1Int, String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\LogRedirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */