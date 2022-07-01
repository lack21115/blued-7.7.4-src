package org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class PackageUtils {
  public static int getPackageVersion(Context paramContext, String paramString) {
    PackageManager packageManager = paramContext.getPackageManager();
    int i = -1;
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 0);
      if (packageInfo != null)
        i = packageInfo.versionCode; 
      return i;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\PackageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */