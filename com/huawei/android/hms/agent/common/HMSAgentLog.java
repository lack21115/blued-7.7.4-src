package com.huawei.android.hms.agent.common;

import com.soft.blued.utils.Logger;

public final class HMSAgentLog {
  private static final int PRINT_STACK_COUTN = 2;
  
  private static final int START_STACK_INDEX = 4;
  
  private static IHMSAgentLogCallback logCallback;
  
  private static void appendStack(StringBuilder paramStringBuilder) {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 4) {
      for (int i = Math.min(arrayOfStackTraceElement.length - 1, 6); i >= 4; i--) {
        if (arrayOfStackTraceElement[i] != null) {
          String str2 = arrayOfStackTraceElement[i].getFileName();
          String str1 = str2;
          if (str2 != null) {
            int j = str2.indexOf('.');
            str1 = str2;
            if (j > 0)
              str1 = str2.substring(0, j); 
          } 
          paramStringBuilder.append(str1);
          paramStringBuilder.append('(');
          paramStringBuilder.append(arrayOfStackTraceElement[i].getLineNumber());
          paramStringBuilder.append(")");
          paramStringBuilder.append("->");
        } 
      } 
      paramStringBuilder.append(arrayOfStackTraceElement[4].getMethodName());
    } 
    paramStringBuilder.append('\n');
  }
  
  public static void d(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    appendStack(stringBuilder);
    stringBuilder.append(paramString);
    IHMSAgentLogCallback iHMSAgentLogCallback = logCallback;
    if (iHMSAgentLogCallback != null) {
      iHMSAgentLogCallback.logD("HMSAgent", stringBuilder.toString());
      return;
    } 
    Logger.c("HMSAgent", new Object[] { stringBuilder.toString() });
  }
  
  public static void e(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    appendStack(stringBuilder);
    stringBuilder.append(paramString);
    IHMSAgentLogCallback iHMSAgentLogCallback = logCallback;
    if (iHMSAgentLogCallback != null) {
      iHMSAgentLogCallback.logE("HMSAgent", stringBuilder.toString());
      return;
    } 
    Logger.e("HMSAgent", new Object[] { stringBuilder.toString() });
  }
  
  public static void i(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    appendStack(stringBuilder);
    stringBuilder.append(paramString);
    IHMSAgentLogCallback iHMSAgentLogCallback = logCallback;
    if (iHMSAgentLogCallback != null) {
      iHMSAgentLogCallback.logI("HMSAgent", stringBuilder.toString());
      return;
    } 
    Logger.b("HMSAgent", new Object[] { stringBuilder.toString() });
  }
  
  public static void setHMSAgentLogCallback(IHMSAgentLogCallback paramIHMSAgentLogCallback) {
    logCallback = paramIHMSAgentLogCallback;
  }
  
  public static void v(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    appendStack(stringBuilder);
    stringBuilder.append(paramString);
    IHMSAgentLogCallback iHMSAgentLogCallback = logCallback;
    if (iHMSAgentLogCallback != null) {
      iHMSAgentLogCallback.logV("HMSAgent", stringBuilder.toString());
      return;
    } 
    Logger.a("HMSAgent", new Object[] { stringBuilder.toString() });
  }
  
  public static void w(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    appendStack(stringBuilder);
    stringBuilder.append(paramString);
    IHMSAgentLogCallback iHMSAgentLogCallback = logCallback;
    if (iHMSAgentLogCallback != null) {
      iHMSAgentLogCallback.logW("HMSAgent", stringBuilder.toString());
      return;
    } 
    Logger.d("HMSAgent", new Object[] { stringBuilder.toString() });
  }
  
  public static interface IHMSAgentLogCallback {
    void logD(String param1String1, String param1String2);
    
    void logE(String param1String1, String param1String2);
    
    void logI(String param1String1, String param1String2);
    
    void logV(String param1String1, String param1String2);
    
    void logW(String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\HMSAgentLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */