package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class Utils {
  public static int a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        return Integer.parseInt(paramString);
      } catch (NumberFormatException numberFormatException) {
        StringBuilder stringBuilder = new StringBuilder("parseInt--NumberFormatException");
        stringBuilder.append(numberFormatException.getMessage());
        LogUtil.b(stringBuilder.toString());
      }  
    return -1;
  }
  
  public static String a(int[] paramArrayOfint) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++)
      stringBuilder.append((char)paramArrayOfint[i]); 
    return stringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, String paramString) {
    try {
      paramContext.getPackageManager().getPackageInfo(paramString, 1);
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder("isExistPackage NameNotFoundException:");
      stringBuilder.append(nameNotFoundException.getMessage());
      LogUtil.b(stringBuilder.toString());
      return false;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString1, 128);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder("isSupportPush NameNotFoundException:");
      stringBuilder.append(nameNotFoundException.getMessage());
      LogUtil.b(stringBuilder.toString());
      nameNotFoundException = null;
    } 
    return (nameNotFoundException != null && ((ApplicationInfo)nameNotFoundException).metaData.getBoolean(paramString2, false));
  }
  
  public static int b(Context paramContext, String paramString) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramString, 0)).versionCode;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("getVersionCode--Exception:");
      stringBuilder.append(exception.getMessage());
      LogUtil.a(stringBuilder.toString());
      return 0;
    } 
  }
  
  public static String c(Context paramContext, String paramString) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramString, 0)).versionName;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("getVersionName--Exception:");
      stringBuilder.append(exception.getMessage());
      LogUtil.a(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssd\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */