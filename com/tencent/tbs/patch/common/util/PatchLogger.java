package com.tencent.tbs.patch.common.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatchLogger {
  public static final int DEBUG = 2;
  
  public static final int ERROR = 4;
  
  public static final int INFO = 1;
  
  public static final int NONE = -1;
  
  public static final int VERBOSE = 0;
  
  public static final int WARN = 3;
  
  private static int a;
  
  private static Delegate b = new a();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void d(String paramString) {
    d(paramString, null);
  }
  
  public static void d(String paramString, Throwable paramThrowable) {
    log(2, paramString, paramThrowable);
  }
  
  public static void e(String paramString) {
    e(paramString, null);
  }
  
  public static void e(String paramString, Throwable paramThrowable) {
    log(4, paramString, paramThrowable);
  }
  
  public static String getLevelName(int paramInt) {
    switch (paramInt) {
      default:
        return "Unknown";
      case 4:
        return "E";
      case 3:
        return "W";
      case 2:
        return "D";
      case 1:
        return "I";
      case 0:
        break;
    } 
    return "V";
  }
  
  public static String getStackTraceString(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    for (Throwable throwable = paramThrowable; throwable != null; throwable = throwable.getCause()) {
      if (throwable instanceof java.net.UnknownHostException)
        return ""; 
    } 
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    paramThrowable.printStackTrace(printWriter);
    printWriter.flush();
    return stringWriter.toString();
  }
  
  public static void i(String paramString) {
    i(paramString, null);
  }
  
  public static void i(String paramString, Throwable paramThrowable) {
    log(1, paramString, paramThrowable);
  }
  
  public static void log(int paramInt, String paramString, Throwable paramThrowable) {
    Delegate delegate = b;
    if (delegate != null)
      delegate.log(paramInt, paramString, paramThrowable); 
  }
  
  public static void setLevel(int paramInt) {
    a = paramInt;
  }
  
  public static void setOutputDelegate(Delegate paramDelegate) {
    b = paramDelegate;
  }
  
  public static void v(String paramString) {
    v(paramString, null);
  }
  
  public static void v(String paramString, Throwable paramThrowable) {
    log(0, paramString, paramThrowable);
  }
  
  public static void w(String paramString) {
    w(paramString, null);
  }
  
  public static void w(String paramString, Throwable paramThrowable) {
    log(3, paramString, paramThrowable);
  }
  
  public static interface Delegate {
    void log(int param1Int, String param1String, Throwable param1Throwable);
  }
  
  private static class a implements Delegate {
    static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    static {
      throw new VerifyError("bad dex opcode");
    }
    
    private a() {}
    
    public static String a(long param1Long) {
      return a.format(new Date(param1Long));
    }
    
    public void log(int param1Int, String param1String, Throwable param1Throwable) {
      if (param1Int >= PatchLogger.a()) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(PatchLogger.getLevelName(param1Int));
        stringBuilder.append("]");
        stringBuilder.append("[");
        stringBuilder.append(a(System.currentTimeMillis()));
        stringBuilder.append("]: ");
        stringBuilder.append(param1String);
        printStream.println(stringBuilder.toString());
        if (param1Throwable != null)
          param1Throwable.printStackTrace(); 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\commo\\util\PatchLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */