package com.qiniu.pili.droid.crash;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.UUID;

public class k {
  private static int a(int paramInt) {
    return (paramInt & 0xFFFF0000) >> 16;
  }
  
  static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.BRAND);
    stringBuilder.append(" ");
    stringBuilder.append(Build.PRODUCT);
    return stringBuilder.toString();
  }
  
  static String a(String paramString) {
    try {
      return paramString.substring(paramString.lastIndexOf("Caused by") + 11).substring(0, paramString.indexOf(":"));
    } catch (Exception exception) {
      return "unknow";
    } 
  }
  
  static String a(Throwable paramThrowable) {
    try {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      while (paramThrowable != null) {
        paramThrowable.printStackTrace(printWriter);
        paramThrowable = paramThrowable.getCause();
      } 
      String str = stringWriter.toString();
      printWriter.close();
      return str;
    } catch (Exception exception) {
      return "unknow";
    } 
  }
  
  private static void a(int paramInt1, StringBuilder paramStringBuilder, String paramString, int paramInt2, char paramChar) {
    boolean bool;
    String str1;
    if (paramInt2 <= 0)
      return; 
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    } 
    String str2 = Integer.toString(paramInt1);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    stringBuilder2.append(" ");
    String str3 = stringBuilder2.toString();
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("/system/bin/logcat");
    arrayList.add("-b");
    arrayList.add(paramString);
    arrayList.add("-d");
    arrayList.add("-v");
    arrayList.add("threadtime");
    arrayList.add("-t");
    if (!bool)
      paramInt2 = (int)(paramInt2 * 1.2D); 
    arrayList.add(Integer.toString(paramInt2));
    if (bool) {
      arrayList.add("--pid");
      arrayList.add(str2);
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("*:");
    stringBuilder1.append(paramChar);
    arrayList.add(stringBuilder1.toString());
    Object[] arrayOfObject = arrayList.toArray();
    paramStringBuilder.append("--------- tail end of log ");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" (");
    paramStringBuilder.append(TextUtils.join(" ", arrayOfObject));
    paramStringBuilder.append(")\n");
    stringBuilder2 = null;
    arrayOfObject = null;
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((new ProcessBuilder(new String[0])).command(arrayList).start().getInputStream()));
      try {
        while (true) {
          str1 = bufferedReader.readLine();
          if (str1 != null) {
            if (bool || str1.contains(str3)) {
              paramStringBuilder.append(str1);
              paramStringBuilder.append("\n");
            } 
            continue;
          } 
          try {
            return;
          } catch (IOException iOException1) {
            return;
          } 
        } 
      } catch (Exception exception) {
        return;
      } finally {
        paramStringBuilder = null;
      } 
      throw paramStringBuilder;
    } catch (Exception exception) {
    
    } finally {
      paramStringBuilder = null;
      paramString = str1;
    } 
    if (iOException != null)
      iOException.close(); 
  }
  
  static void a(Closeable paramCloseable) {
    try {
      paramCloseable.close();
      return;
    } catch (IOException iOException) {
      return;
    } 
  }
  
  static boolean a(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      return applicationInfo.processName.equals(f(paramContext));
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return true;
    } 
  }
  
  static String b() {
    return (Build.VERSION.SDK_INT >= 21) ? TextUtils.join(",", (Object[])Build.SUPPORTED_ABIS) : "unknow";
  }
  
  static String b(Context paramContext) {
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    int i = applicationInfo.labelRes;
    return (i == 0) ? applicationInfo.nonLocalizedLabel.toString() : paramContext.getString(i);
  }
  
  static String b(String paramString) {
    try {
      paramString = paramString.substring(paramString.indexOf("com.qiniu.pili.droid.shortvideo"));
      return paramString.substring(0, paramString.indexOf(")") + 1);
    } catch (Exception exception) {
      return "unknow";
    } 
  }
  
  static String c() {
    int i = Process.myPid();
    StringBuilder stringBuilder = new StringBuilder();
    a(i, stringBuilder, "main", 50, 'D');
    a(i, stringBuilder, "system", 50, 'W');
    a(i, stringBuilder, "events", 50, 'I');
    stringBuilder.append("\n");
    return stringBuilder.toString();
  }
  
  static String c(Context paramContext) {
    String str2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
    String str1 = str2;
    if (str2 == null) {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("plcrash", 0);
      String str = sharedPreferences.getString("deviceId", null);
      str1 = str;
      if (str == null) {
        str1 = UUID.randomUUID().toString().replaceAll("-", "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("deviceId", str1);
        editor.apply();
      } 
    } 
    return str1;
  }
  
  static String c(String paramString) {
    if (paramString == null)
      return "unknow"; 
    try {
      paramString = paramString.substring(paramString.indexOf(":"));
      return paramString.substring(0, paramString.indexOf("."));
    } catch (Exception exception) {
      return "unknow";
    } 
  }
  
  static String d(Context paramContext) {
    ConfigurationInfo configurationInfo = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    return (configurationInfo.reqGlEsVersion != 0) ? String.valueOf(a(configurationInfo.reqGlEsVersion)) : "1";
  }
  
  static String e(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (Exception exception) {
      return "unknow";
    } 
  }
  
  private static String f(Context paramContext) {
    try {
      int i = Process.myPid();
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager != null)
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
          if (runningAppProcessInfo.pid == i)
            return runningAppProcessInfo.processName; 
        }  
    } catch (Exception exception) {}
    return "unknow";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */