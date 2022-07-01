package com.datavisor.vangogh.f;

import android.content.Context;
import com.datavisor.vangogh.e.b.a;

public class b {
  public static String a(Context paramContext) {
    return a.a(paramContext, "DVSPOVERALLEXCEPTION");
  }
  
  public static void a(String paramString, Context paramContext) {
    a(paramString, paramContext, "DVSPNETEXCEPTION");
  }
  
  private static void a(String paramString1, Context paramContext, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static void a(String paramString, Throwable paramThrowable, Context paramContext) {
    a(paramString, paramThrowable, paramContext, "DVSPOVERALLEXCEPTION");
  }
  
  private static void a(String paramString1, Throwable paramThrowable, Context paramContext, String paramString2) {
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      if (!f.a(paramString1)) {
        stringBuilder2.append(paramString1);
        stringBuilder2.append('\n');
      } 
      stringBuilder2.append(paramThrowable.toString());
      for (StackTraceElement stackTraceElement : paramThrowable.getStackTrace()) {
        stringBuilder2.append('\n');
        stringBuilder2.append(stackTraceElement.toString());
      } 
      stringBuilder2.append('\n');
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("tt: ");
      stringBuilder1.append(System.currentTimeMillis());
      stringBuilder2.append(stringBuilder1.toString());
      String str = stringBuilder2.toString();
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static String b(Context paramContext) {
    return a.a(paramContext, "DVSPNETEXCEPTION");
  }
  
  public static void b(String paramString, Throwable paramThrowable, Context paramContext) {
    a(paramString, paramThrowable, paramContext, "DVSPNETEXCEPTION");
  }
  
  public static void c(Context paramContext) {
    a.e(paramContext, "DVSPOVERALLEXCEPTION");
    a.e(paramContext, "DVSPNETEXCEPTION");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */