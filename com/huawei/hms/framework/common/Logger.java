package com.huawei.hms.framework.common;

import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.IllegalFormatException;

public class Logger {
  private static final boolean DEBUG = false;
  
  private static final int MAX_STACK_DEEP_LENGTH = 20;
  
  private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
  
  private static final String SPLIT = "|";
  
  private static final String TAG = "NetworkKit_Logger";
  
  private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
  
  private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
  
  private static ExtLogger extLogger;
  
  private static boolean println = true;
  
  private static String complexAppTag(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NetworkSdk_");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private static String complexMsg(String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getCallMethodInfo(paramInt));
      stringBuilder.append("|");
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    return getCallMethodInfo(paramInt);
  }
  
  private static String complexTag(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NetworkKit_");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static void d(String paramString, Object paramObject) {
    println(3, paramString, paramObject);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs) {
    println(3, paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString, Object paramObject) {
    println(6, paramString, paramObject);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {
    if (isAPPLoggable(6))
      extLogger.e(complexAppTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable)); 
    if (println)
      Log.e(complexTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable)); 
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs) {
    println(6, paramString1, paramString2, paramVarArgs);
  }
  
  private static void extLogPrintln(int paramInt, String paramString1, String paramString2) {
    if (paramInt != 2) {
      if (paramInt != 3) {
        if (paramInt != 4) {
          if (paramInt != 5) {
            if (paramInt != 6)
              return; 
            extLogger.e(paramString1, paramString2);
            return;
          } 
          extLogger.w(paramString1, paramString2);
          return;
        } 
        extLogger.i(paramString1, paramString2);
        return;
      } 
      extLogger.d(paramString1, paramString2);
      return;
    } 
    extLogger.v(paramString1, paramString2);
  }
  
  private static String getCallMethodInfo(int paramInt) {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement.length > paramInt) {
      StackTraceElement stackTraceElement = arrayOfStackTraceElement[paramInt];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Thread.currentThread().getName());
      stringBuilder.append("|");
      stringBuilder.append(stackTraceElement.getFileName());
      stringBuilder.append("|");
      stringBuilder.append(stackTraceElement.getClassName());
      stringBuilder.append("|");
      stringBuilder.append(stackTraceElement.getMethodName());
      stringBuilder.append("|");
      stringBuilder.append(stackTraceElement.getLineNumber());
      return stringBuilder.toString();
    } 
    return "";
  }
  
  private static Throwable getNewThrowable(Throwable paramThrowable) {
    if (isLoggable(3))
      return paramThrowable; 
    if (paramThrowable == null)
      return null; 
    ThrowableWrapper throwableWrapper = new ThrowableWrapper(paramThrowable);
    Throwable throwable = paramThrowable.getCause();
    for (paramThrowable = throwableWrapper; throwable != null; paramThrowable = throwableWrapper1) {
      ThrowableWrapper throwableWrapper1 = new ThrowableWrapper(throwable);
      paramThrowable.setCause(throwableWrapper1);
      throwable = throwable.getCause();
    } 
    return throwableWrapper;
  }
  
  public static void i(String paramString, Object paramObject) {
    println(4, paramString, paramObject);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs) {
    println(4, paramString1, paramString2, paramVarArgs);
  }
  
  public static boolean isAPPLoggable(int paramInt) {
    return (extLogger != null) ? Log.isLoggable("NetworkSdk_", paramInt) : false;
  }
  
  public static boolean isLoggable(int paramInt) {
    return Log.isLoggable("NetworkKit_", paramInt);
  }
  
  private static int logPrintln(int paramInt, String paramString1, String paramString2) {
    if (isAPPLoggable(paramInt))
      extLogPrintln(paramInt, complexAppTag(paramString1), complexMsg(paramString2, 7)); 
    return println ? Log.println(paramInt, complexTag(paramString1), complexMsg(paramString2, 7)) : 1;
  }
  
  public static void println(int paramInt, String paramString, Object paramObject) {
    if (paramInt < 3)
      return; 
    if (isLoggable(paramInt)) {
      if (paramObject == null) {
        paramObject = "null";
      } else {
        paramObject = paramObject.toString();
      } 
      logPrintln(paramInt, paramString, (String)paramObject);
    } 
  }
  
  public static void println(int paramInt, String paramString1, String paramString2, Object... paramVarArgs) {
    if (paramInt < 3)
      return; 
    if (paramString2 == null) {
      Log.w("NetworkKit_Logger", "format is null, not log");
      return;
    } 
    try {
      if (isLoggable(paramInt)) {
        logPrintln(paramInt, paramString1, StringUtils.format(paramString2, paramVarArgs));
        return;
      } 
    } catch (IllegalFormatException illegalFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("log format error");
      stringBuilder.append(paramString2);
      w("NetworkKit_Logger", stringBuilder.toString(), illegalFormatException);
    } 
  }
  
  public static void setExtLogger(ExtLogger paramExtLogger, boolean paramBoolean) {
    extLogger = paramExtLogger;
    println = paramBoolean;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("logger = ");
    stringBuilder.append(paramExtLogger);
    stringBuilder.append(paramBoolean);
    i("NetworkKit_Logger", stringBuilder.toString());
  }
  
  public static void v(String paramString, Object paramObject) {
    println(2, paramString, paramObject);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs) {
    println(2, paramString1, paramString2, paramVarArgs);
  }
  
  public static void w(String paramString, Object paramObject) {
    println(5, paramString, paramObject);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable) {
    if (isAPPLoggable(5))
      extLogger.w(complexAppTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable)); 
    if (println)
      Log.w(complexTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable)); 
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs) {
    println(5, paramString1, paramString2, paramVarArgs);
  }
  
  static class ThrowableWrapper extends Throwable {
    private static final long serialVersionUID = 7129050843360571879L;
    
    private String message;
    
    private Throwable ownerThrowable;
    
    private Throwable thisCause;
    
    private ThrowableWrapper(Throwable param1Throwable) {
      byte b;
      this.ownerThrowable = param1Throwable;
      StackTraceElement[] arrayOfStackTraceElement = param1Throwable.getStackTrace();
      if (param1Throwable instanceof java.io.IOException || param1Throwable instanceof org.json.JSONException) {
        b = 8;
      } else {
        b = 20;
      } 
      if (arrayOfStackTraceElement.length > b) {
        setStackTrace(Arrays.<StackTraceElement>copyOf(arrayOfStackTraceElement, b));
      } else {
        setStackTrace(arrayOfStackTraceElement);
      } 
      setMessage(StringUtils.anonymizeMessage(param1Throwable.getMessage()));
    }
    
    private void setCause(Throwable param1Throwable) {
      this.thisCause = param1Throwable;
    }
    
    public Throwable getCause() {
      Throwable throwable2 = this.thisCause;
      Throwable throwable1 = throwable2;
      if (throwable2 == this)
        throwable1 = null; 
      return throwable1;
    }
    
    public String getMessage() {
      return this.message;
    }
    
    public void setMessage(String param1String) {
      this.message = param1String;
    }
    
    public String toString() {
      Throwable throwable = this.ownerThrowable;
      if (throwable == null)
        return ""; 
      String str2 = throwable.getClass().getName();
      String str1 = str2;
      if (this.message != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(": ");
        str1 = stringBuilder1.toString();
        if (this.message.startsWith(str1))
          return this.message; 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str1);
        stringBuilder2.append(this.message);
        str1 = stringBuilder2.toString();
      } 
      return str1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */