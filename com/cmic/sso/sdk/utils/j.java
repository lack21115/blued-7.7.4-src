package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class j {
  public static PackageInfo a(Context paramContext) {
    try {
      return e(paramContext).getPackageInfo(paramContext.getPackageName(), 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return null;
    } 
  }
  
  public static String b(Context paramContext) {
    PackageInfo packageInfo = a(paramContext);
    return (packageInfo != null) ? packageInfo.packageName : null;
  }
  
  public static String c(Context paramContext) {
    try {
      PackageManager packageManager = e(paramContext);
      String str2 = (String)packageManager.getApplicationLabel(packageManager.getApplicationInfo(b(paramContext), 0));
      if (str2 != null)
        return str2; 
      PackageInfo packageInfo = a(paramContext);
      if (packageInfo == null)
        return null; 
      int i = packageInfo.applicationInfo.labelRes;
      String str1 = paramContext.getResources().getString(i);
      if (str1 != null)
        return str1; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String d(Context paramContext) {
    PackageInfo packageInfo = a(paramContext);
    if (packageInfo != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b(paramContext));
      stringBuilder.append("&");
      stringBuilder.append(packageInfo.versionName);
      return stringBuilder.toString();
    } 
    return null;
  }
  
  private static PackageManager e(Context paramContext) {
    return paramContext.getPackageManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */