package com.alibaba.mtl.log.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;

public class b {
  private static String ae = "";
  
  private static String b;
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return ""; 
    int i = Process.myPid();
    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses()) {
      if (runningAppProcessInfo.pid == i)
        return runningAppProcessInfo.processName; 
    } 
    return null;
  }
  
  public static boolean b(Context paramContext) {
    if (paramContext == null)
      return false; 
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
      String str = paramContext.getPackageName();
      return false;
    } finally {
      paramContext = null;
    } 
  }
  
  public static String getAppkey() {
    return b;
  }
  
  public static String j() {
    Context context = a.getContext();
    String str = "";
    if (context == null)
      return ""; 
    try {
      String str1 = a.getContext().getSharedPreferences("UTCommon", 0).getString("_lun", "");
      if (!TextUtils.isEmpty(str1))
        str = new String(c.decode(str1.getBytes(), 2), "UTF-8"); 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String k() {
    Context context = a.getContext();
    String str = "";
    if (context == null)
      return ""; 
    try {
      String str1 = a.getContext().getSharedPreferences("UTCommon", 0).getString("_luid", "");
      if (!TextUtils.isEmpty(str1))
        str = new String(c.decode(str1.getBytes(), 2), "UTF-8"); 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String l() {
    return ae;
  }
  
  public static String m() {
    return "";
  }
  
  public static String n() {
    return "";
  }
  
  public static void n(String paramString) {
    i.a("AppInfoUtil", new Object[] { "[setChannle]", paramString });
    if (!TextUtils.isEmpty(paramString)) {
      int i = paramString.indexOf("@");
      if (i == -1) {
        ae = paramString;
        return;
      } 
      ae = paramString.substring(0, i);
    } 
  }
  
  public static void o(String paramString) {
    i.a("AppInfoUtil", new Object[] { "set Appkey:", paramString });
    b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */