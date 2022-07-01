package com.bytedance.sdk.adnet.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class g {
  private static String a;
  
  private static String a() {
    Exception exception;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/proc/");
      stringBuilder.append(Process.myPid());
      stringBuilder.append("/cmdline");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(stringBuilder.toString()), "iso-8859-1"));
      return null;
    } finally {
      exception = null;
    } 
    if (exception != null)
      try {
        exception.close();
        return null;
      } catch (Exception exception1) {
        return null;
      }  
  }
  
  public static boolean a(Context paramContext) {
    String str = c(paramContext);
    return (str != null && (str.endsWith(":push") || str.endsWith(":pushservice")));
  }
  
  public static boolean b(Context paramContext) {
    String str = c(paramContext);
    boolean bool2 = false;
    if (str != null && str.contains(":"))
      return false; 
    boolean bool1 = bool2;
    if (str != null) {
      bool1 = bool2;
      if (str.equals(paramContext.getPackageName()))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static String c(Context paramContext) {
    String str = a;
    if (!TextUtils.isEmpty(str))
      return str; 
    try {
      int i = Process.myPid();
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses()) {
        if (runningAppProcessInfo.pid == i) {
          a = runningAppProcessInfo.processName;
          return a;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    a = a();
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */