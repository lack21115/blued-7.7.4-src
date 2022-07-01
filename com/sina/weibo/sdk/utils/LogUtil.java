package com.sina.weibo.sdk.utils;

import android.util.Log;

public class LogUtil {
  public static boolean sIsLogEnable = false;
  
  public static void d(String paramString1, String paramString2) {
    if (sIsLogEnable) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(stackTraceElement.getFileName()));
      stringBuilder2.append("(");
      stringBuilder2.append(stackTraceElement.getLineNumber());
      stringBuilder2.append(") ");
      stringBuilder2.append(stackTraceElement.getMethodName());
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(stringBuilder2.toString()));
      stringBuilder1.append(": ");
      stringBuilder1.append(paramString2);
      Log.d(paramString1, stringBuilder1.toString());
    } 
  }
  
  public static void disableLog() {
    sIsLogEnable = false;
  }
  
  public static void e(String paramString1, String paramString2) {
    if (sIsLogEnable) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(stackTraceElement.getFileName()));
      stringBuilder2.append("(");
      stringBuilder2.append(stackTraceElement.getLineNumber());
      stringBuilder2.append(") ");
      stringBuilder2.append(stackTraceElement.getMethodName());
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(stringBuilder2.toString()));
      stringBuilder1.append(": ");
      stringBuilder1.append(paramString2);
      Log.e(paramString1, stringBuilder1.toString());
    } 
  }
  
  public static void enableLog() {
    sIsLogEnable = true;
  }
  
  public static String getStackTraceMsg() {
    StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(stackTraceElement.getFileName()));
    stringBuilder.append("(");
    stringBuilder.append(stackTraceElement.getLineNumber());
    stringBuilder.append(") ");
    stringBuilder.append(stackTraceElement.getMethodName());
    return stringBuilder.toString();
  }
  
  public static void i(String paramString1, String paramString2) {
    if (sIsLogEnable) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(stackTraceElement.getFileName()));
      stringBuilder2.append("(");
      stringBuilder2.append(stackTraceElement.getLineNumber());
      stringBuilder2.append(") ");
      stringBuilder2.append(stackTraceElement.getMethodName());
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(stringBuilder2.toString()));
      stringBuilder1.append(": ");
      stringBuilder1.append(paramString2);
      Log.i(paramString1, stringBuilder1.toString());
    } 
  }
  
  public static void v(String paramString1, String paramString2) {
    if (sIsLogEnable) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(stackTraceElement.getFileName()));
      stringBuilder2.append("(");
      stringBuilder2.append(stackTraceElement.getLineNumber());
      stringBuilder2.append(") ");
      stringBuilder2.append(stackTraceElement.getMethodName());
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(stringBuilder2.toString()));
      stringBuilder1.append(": ");
      stringBuilder1.append(paramString2);
      Log.v(paramString1, stringBuilder1.toString());
    } 
  }
  
  public static void w(String paramString1, String paramString2) {
    if (sIsLogEnable) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(stackTraceElement.getFileName()));
      stringBuilder2.append("(");
      stringBuilder2.append(stackTraceElement.getLineNumber());
      stringBuilder2.append(") ");
      stringBuilder2.append(stackTraceElement.getMethodName());
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(stringBuilder2.toString()));
      stringBuilder1.append(": ");
      stringBuilder1.append(paramString2);
      Log.w(paramString1, stringBuilder1.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */