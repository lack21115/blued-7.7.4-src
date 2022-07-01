package com.geetest.onelogin.f;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class a {
  private static Context a;
  
  public static Context a() {
    if (a == null)
      try {
        Class<?> clazz = Class.forName("android.app.ActivityThread");
        Object object = clazz.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(clazz, new Object[0]);
      } finally {
        Exception exception = null;
      }  
    return a;
  }
  
  private static String a(int paramInt) {
    BufferedReader bufferedReader;
    try {
      bufferedReader = (BufferedReader)new StringBuilder();
      bufferedReader.append("/proc/");
      bufferedReader.append(paramInt);
      bufferedReader.append("/cmdline");
      BufferedReader bufferedReader1 = new BufferedReader(new FileReader(bufferedReader.toString()));
    } finally {
      null = null;
    } 
    try {
      null.printStackTrace();
      return null;
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {
          iOException1.printStackTrace();
        }  
    } 
  }
  
  public static void a(Context paramContext) {
    if (paramContext == null) {
      a = a();
      return;
    } 
    a = paramContext.getApplicationContext();
  }
  
  public static void b() {
    a = null;
  }
  
  public static boolean c() {
    String str1 = a.getPackageName();
    String str2 = a(Process.myPid());
    return (TextUtils.isEmpty(str2) || str2.equals(str1));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */