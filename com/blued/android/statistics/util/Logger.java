package com.blued.android.statistics.util;

import android.util.Log;

public class Logger {
  private String a;
  
  public Logger(String paramString) {
    this.a = paramString;
  }
  
  private void a(TYPE paramTYPE, String paramString) {
    int i = null.a[paramTYPE.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            Log.e(this.a, paramString);
            return;
          } 
          Log.w(this.a, paramString);
          return;
        } 
        Log.d(this.a, paramString);
        return;
      } 
      Log.i(this.a, paramString);
      return;
    } 
    Log.v(this.a, paramString);
  }
  
  private void a(TYPE paramTYPE, Object... paramVarArgs) {
    String str = f(paramVarArgs);
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
        a(paramTYPE, String.format("[%d/%d] %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m + b), str.substring(j, n) }));
        k++;
        j = n;
      } 
    } else {
      a(paramTYPE, str);
    } 
  }
  
  private static String f(Object... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      Object object = paramVarArgs[i];
      if (object == null) {
        stringBuilder.append("null");
      } else if (object instanceof Throwable) {
        stringBuilder.append(Log.getStackTraceString((Throwable)object));
        stringBuilder.append("\n");
      } else {
        stringBuilder.append(object.toString());
      } 
    } 
    return stringBuilder.toString();
  }
  
  public void a(Object... paramVarArgs) {
    a(TYPE.a, paramVarArgs);
  }
  
  public void b(Object... paramVarArgs) {
    a(TYPE.b, paramVarArgs);
  }
  
  public void c(Object... paramVarArgs) {
    a(TYPE.c, paramVarArgs);
  }
  
  public void d(Object... paramVarArgs) {
    a(TYPE.d, paramVarArgs);
  }
  
  public void e(Object... paramVarArgs) {
    a(TYPE.e, paramVarArgs);
  }
  
  enum TYPE {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistic\\util\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */