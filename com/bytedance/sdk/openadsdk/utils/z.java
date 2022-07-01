package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class z {
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
  
  public static String a(Context paramContext) {
    String str = a;
    if (!TextUtils.isEmpty(str))
      return str; 
    try {
      int i = Process.myPid();
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (iterator.hasNext()) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
        if (runningAppProcessInfo.pid == i) {
          if (t.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("processName = ");
            stringBuilder.append(runningAppProcessInfo.processName);
            t.b("Process", stringBuilder.toString());
          } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */