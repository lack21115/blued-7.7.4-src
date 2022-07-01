package com.baidu.mobads.interfaces.utils;

public interface IXAdLogger {
  public static final int ASSERT = 7;
  
  public static final int DEBUG = 3;
  
  public static final int ERROR = 6;
  
  public static final int INFO = 4;
  
  public static final String TAG = "BaiduXAdSDK";
  
  public static final int UNLOGGABLE = -1;
  
  public static final int VERBOSE = 2;
  
  public static final int WARN = 5;
  
  int d(String paramString);
  
  int d(String paramString1, String paramString2);
  
  int d(String paramString, Throwable paramThrowable);
  
  int d(Throwable paramThrowable);
  
  int d(Object... paramVarArgs);
  
  int e(String paramString);
  
  int e(String paramString, Throwable paramThrowable);
  
  int e(Throwable paramThrowable);
  
  int e(Object... paramVarArgs);
  
  int i(String paramString);
  
  int i(String paramString1, String paramString2);
  
  int i(String paramString, Throwable paramThrowable);
  
  int i(Object... paramVarArgs);
  
  boolean isLoggable(int paramInt);
  
  boolean isLoggable(String paramString, int paramInt);
  
  int w(String paramString);
  
  int w(String paramString, Throwable paramThrowable);
  
  int w(Throwable paramThrowable);
  
  int w(Object... paramVarArgs);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */