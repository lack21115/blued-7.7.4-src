package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.wrappers.Wrappers;

public class ClientLibraryUtils {
  public static int getClientVersion(Context paramContext, String paramString) {
    PackageInfo packageInfo = zzb(paramContext, paramString);
    if (packageInfo != null) {
      if (packageInfo.applicationInfo == null)
        return -1; 
      Bundle bundle = packageInfo.applicationInfo.metaData;
      return (bundle == null) ? -1 : bundle.getInt("com.google.android.gms.version", -1);
    } 
    return -1;
  }
  
  public static boolean isPackageSide() {
    return false;
  }
  
  public static boolean zza(Context paramContext, String paramString) {
    "com.google.android.gms".equals(paramString);
    try {
      int i = (Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0)).flags;
      return ((i & 0x200000) != 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  private static PackageInfo zzb(Context paramContext, String paramString) {
    try {
      return Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\ClientLibraryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */