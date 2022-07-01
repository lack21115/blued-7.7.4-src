package com.blued.android.framework.utils;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.utils.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtils {
  static StringBuffer a = new StringBuffer();
  
  public static String b = "LogUtils";
  
  private static boolean c = true;
  
  public static int a(String paramString) {
    return a("", paramString);
  }
  
  public static int a(String paramString1, String paramString2) {
    if (c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e("v"));
      stringBuilder.append(paramString2);
      return Log.d("BluedLog", stringBuilder.toString());
    } 
    return 0;
  }
  
  public static int a(Object... paramVarArgs) {
    return c(c(paramVarArgs));
  }
  
  public static void a(String paramString, Throwable paramThrowable) {
    if (paramThrowable == null)
      return; 
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    String str = stringWriter.toString();
    if (!TextUtils.isEmpty(paramString)) {
      String str1 = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" Catch exception: ");
      stringBuilder.append(str);
      c(str1, stringBuilder.toString());
      return;
    } 
    c(b, str);
  }
  
  public static int b(String paramString) {
    return b("", paramString);
  }
  
  public static int b(String paramString1, String paramString2) {
    if (c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e("d"));
      stringBuilder.append(paramString1);
      stringBuilder.append(" ");
      stringBuilder.append(paramString2);
      return Log.d("BluedLog", stringBuilder.toString());
    } 
    return 0;
  }
  
  public static int b(Object... paramVarArgs) {
    if (paramVarArgs == null) {
      Log.b("tag", "d --> null");
      return -1;
    } 
    StringBuffer stringBuffer = a;
    boolean bool = false;
    stringBuffer.setLength(0);
    int i;
    for (i = 0; i < paramVarArgs.length; i++) {
      stringBuffer = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramVarArgs[i]);
      stringBuilder.append("\n");
      stringBuffer.append(stringBuilder.toString());
    } 
    i = bool;
    if (c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e("d"));
      stringBuilder.append(" ");
      stringBuilder.append(a.toString());
      i = Log.d("BluedLog", stringBuilder.toString());
    } 
    return i;
  }
  
  public static int c(String paramString) {
    return c("", paramString);
  }
  
  public static int c(String paramString1, String paramString2) {
    if (c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e("i"));
      stringBuilder.append(paramString1);
      stringBuilder.append(" ");
      stringBuilder.append(paramString2);
      return Log.d("BluedLog", stringBuilder.toString());
    } 
    return 0;
  }
  
  private static String c(Object... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      Object object = paramVarArgs[i];
      if (object == null) {
        stringBuilder.append("null");
      } else if (object instanceof Intent) {
        stringBuilder.append(((Intent)object).getExtras());
        stringBuilder.append("\n");
      } else if (object instanceof Throwable) {
        stringBuilder.append(Log.getStackTraceString((Throwable)object));
        stringBuilder.append("\n");
      } else {
        stringBuilder.append(object.toString());
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static int d(String paramString) {
    return d("", paramString);
  }
  
  public static int d(String paramString1, String paramString2) {
    if (c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e("e"));
      stringBuilder.append(paramString1);
      stringBuilder.append(" ");
      stringBuilder.append(paramString2);
      return Log.e("BluedLog", stringBuilder.toString());
    } 
    return 0;
  }
  
  private static String e(String paramString) {
    StackTraceElement[] arrayOfStackTraceElement = (new Throwable()).getStackTrace();
    int i = 0;
    while (true) {
      if (i < arrayOfStackTraceElement.length) {
        if (arrayOfStackTraceElement[i].getMethodName().equalsIgnoreCase(paramString)) {
          int j = i + 2;
          if (j < arrayOfStackTraceElement.length) {
            if (arrayOfStackTraceElement[++i].getMethodName().equalsIgnoreCase(paramString)) {
              StackTraceElement stackTraceElement1 = arrayOfStackTraceElement[j];
              break;
            } 
            StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
            break;
          } 
        } 
        i++;
        continue;
      } 
      paramString = null;
      break;
    } 
    if (paramString == null)
      return ""; 
    String str = paramString.getClassName();
    if (str.contains("$")) {
      str = str.substring(str.lastIndexOf(".") + 1, str.indexOf("$"));
    } else {
      str = str.substring(str.lastIndexOf(".") + 1);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("-> ");
    stringBuilder.append(paramString.getMethodName());
    stringBuilder.append("():");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */