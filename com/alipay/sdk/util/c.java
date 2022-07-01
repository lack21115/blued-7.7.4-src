package com.alipay.sdk.util;

import com.alipay.sdk.interior.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class c {
  private static Log.ISdkLogCallback a;
  
  private static final String b = "alipaysdk";
  
  public static void a(Log.ISdkLogCallback paramISdkLogCallback) {
    a = paramISdkLogCallback;
  }
  
  private static void a(String paramString) {
    try {
      Log.ISdkLogCallback iSdkLogCallback = a;
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    a(e(paramString1, paramString2));
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    paramString1 = e(paramString1, paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(" ");
    stringBuilder.append(b(paramThrowable));
    a(stringBuilder.toString());
  }
  
  public static void a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return; 
    try {
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  private static String b(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  public static void b(String paramString1, String paramString2) {
    a(e(paramString1, paramString2));
  }
  
  public static void c(String paramString1, String paramString2) {
    a(e(paramString1, paramString2));
  }
  
  public static void d(String paramString1, String paramString2) {
    a(e(paramString1, paramString2));
  }
  
  private static String e(String paramString1, String paramString2) {
    String str = paramString1;
    if (paramString1 == null)
      str = ""; 
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = ""; 
    return String.format("[%s][%s]", new Object[] { str, paramString1 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */