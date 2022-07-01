package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.a;

public class HMSLog {
  private static final a a = new a();
  
  private static String a(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 16384);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HMS-");
        stringBuilder.append(packageInfo.versionName);
        stringBuilder.append("(");
        stringBuilder.append(packageInfo.versionCode);
        stringBuilder.append(")");
        return stringBuilder.toString();
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        return "HMS-[unknown-version]";
      }  
    return "HMS-[unknown-version]";
  }
  
  public static void d(String paramString1, String paramString2) {
    a.a(3, paramString1, paramString2);
  }
  
  public static void e(String paramString1, long paramLong, String paramString2) {
    a a1 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(paramLong);
    stringBuilder.append("] ");
    stringBuilder.append(paramString2);
    a1.a(6, paramString1, stringBuilder.toString());
  }
  
  public static void e(String paramString1, long paramLong, String paramString2, Throwable paramThrowable) {
    a a1 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(paramLong);
    stringBuilder.append("] ");
    stringBuilder.append(paramString2);
    a1.a(6, paramString1, stringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2) {
    a.a(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {
    a.a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2) {
    a.a(4, paramString1, paramString2);
  }
  
  public static void init(Context paramContext, int paramInt, String paramString) {
    a.a(paramContext, paramInt, paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("============================================================================");
    stringBuilder.append('\n');
    stringBuilder.append("====== ");
    stringBuilder.append(a(paramContext));
    stringBuilder.append('\n');
    stringBuilder.append("============================================================================");
    a.a(paramString, stringBuilder.toString());
  }
  
  public static boolean isErrorEnable() {
    return a.a(6);
  }
  
  public static boolean isInfoEnable() {
    return a.a(4);
  }
  
  public static boolean isWarnEnable() {
    return a.a(5);
  }
  
  public static void w(String paramString1, String paramString2) {
    a.a(5, paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\log\HMSLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */