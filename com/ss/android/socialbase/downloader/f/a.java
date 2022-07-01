package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;

public class a {
  private static int a = 4;
  
  private static a b;
  
  public static void a(int paramInt) {
    a = paramInt;
  }
  
  public static void a(String paramString) {
    b("DownloaderLogger", paramString);
  }
  
  public static void a(String paramString1, String paramString2) {
    if (paramString2 == null)
      return; 
    if (a <= 2)
      Log.v(paramString1, paramString2); 
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (paramString2 == null && paramThrowable == null)
      return; 
    if (a <= 3)
      Log.d(b(paramString1), paramString2, paramThrowable); 
  }
  
  public static boolean a() {
    return (a <= 3);
  }
  
  public static String b(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Downloader-");
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    return "DownloaderLogger";
  }
  
  public static void b(String paramString1, String paramString2) {
    if (paramString2 == null)
      return; 
    if (a <= 3)
      Log.d(b(paramString1), paramString2); 
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable) {
    if (paramString2 == null && paramThrowable == null)
      return; 
    if (a <= 6)
      Log.e(b(paramString1), paramString2, paramThrowable); 
    a a1 = b;
    if (a1 != null)
      a1.a(b(paramString1), paramString2, paramThrowable); 
  }
  
  public static void c(String paramString1, String paramString2) {
    if (paramString2 == null)
      return; 
    if (a <= 4)
      Log.i(b(paramString1), paramString2); 
    a a1 = b;
    if (a1 != null)
      a1.a(b(paramString1), paramString2); 
  }
  
  public static void d(String paramString1, String paramString2) {
    if (paramString2 == null)
      return; 
    if (a <= 5)
      Log.w(b(paramString1), paramString2); 
    a a1 = b;
    if (a1 != null)
      a1.c(b(paramString1), paramString2); 
  }
  
  public static void e(String paramString1, String paramString2) {
    if (paramString2 == null)
      return; 
    if (a <= 6)
      Log.e(b(paramString1), paramString2); 
    a a1 = b;
    if (a1 != null)
      a1.b(b(paramString1), paramString2); 
  }
  
  public static abstract class a {
    public void a(String param1String1, String param1String2) {}
    
    public void a(String param1String1, String param1String2, Throwable param1Throwable) {}
    
    public void b(String param1String1, String param1String2) {}
    
    public void c(String param1String1, String param1String2) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */