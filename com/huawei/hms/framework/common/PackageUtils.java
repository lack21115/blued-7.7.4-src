package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;

public class PackageUtils {
  private static final String TAG = "PackageUtils";
  
  public static String getVersionName(Context paramContext) {
    if (paramContext == null)
      return ""; 
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      return (packageManager.getPackageInfo(paramContext.getPackageName(), 16384)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Logger.w("PackageUtils", "", (Throwable)nameNotFoundException);
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\PackageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */