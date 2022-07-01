package com.blued.android.module.live_china.same;

import android.content.Intent;
import android.util.Log;
import com.blued.android.core.AppInfo;

public class Logger {
  private static boolean a = false;
  
  private static boolean b = false;
  
  private static String a() {
    Thread thread = Thread.currentThread();
    StackTraceElement stackTraceElement = thread.getStackTrace()[6];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("at ");
    stringBuilder.append(stackTraceElement.toString());
    stringBuilder.append(" Thread[");
    stringBuilder.append(thread.getThreadGroup());
    stringBuilder.append(":");
    stringBuilder.append(thread.getName());
    stringBuilder.append(":");
    stringBuilder.append(thread.getId());
    return stringBuilder.toString();
  }
  
  private static String a(Object... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    if (b) {
      stringBuilder.append(a());
      stringBuilder.append("\n");
    } 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      Object object = paramVarArgs[i];
      if (object == null) {
        stringBuilder.append("null");
      } else if (object instanceof com.blued.android.framework.http.parser.BluedEntity) {
        stringBuilder.append(AppInfo.f().toJson(object));
        stringBuilder.append("\n");
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
  
  private static void a(TYPE paramTYPE, String paramString1, String paramString2) {
    int i = null.a[paramTYPE.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            Log.e(paramString1, paramString2);
            return;
          } 
          Log.w(paramString1, paramString2);
          return;
        } 
        Log.d(paramString1, paramString2);
        return;
      } 
      Log.i(paramString1, paramString2);
      return;
    } 
    Log.v(paramString1, paramString2);
  }
  
  private static void a(TYPE paramTYPE, String paramString, Object... paramVarArgs) {
    String str = a(paramVarArgs);
    int i = str.length();
    if (i > 4000) {
      byte b;
      int m = i / 2000;
      if (i % 2000 == 0) {
        b = 0;
      } else {
        b = 1;
      } 
      int j = 0;
      int k = 1;
      while (j < i) {
        int n = j + 2000;
        if (n >= i)
          n = i; 
        a(paramTYPE, paramString, String.format("[%d/%d] %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m + b), str.substring(j, n) }));
        k++;
        j = n;
      } 
    } else {
      a(paramTYPE, paramString, str);
    } 
  }
  
  public static void a(String paramString, Object... paramVarArgs) {
    if (a)
      a(TYPE.a, paramString, paramVarArgs); 
  }
  
  public static void b(String paramString, Object... paramVarArgs) {
    if (a)
      a(TYPE.b, paramString, paramVarArgs); 
  }
  
  public static void c(String paramString, Object... paramVarArgs) {
    if (a)
      a(TYPE.d, paramString, paramVarArgs); 
  }
  
  public static void d(String paramString, Object... paramVarArgs) {
    if (a)
      a(TYPE.e, paramString, paramVarArgs); 
  }
  
  enum TYPE {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */