package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

public class q {
  public static byte[] a(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 64);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException = null;
    } 
    if (nameNotFoundException != null) {
      Signature[] arrayOfSignature = ((PackageInfo)nameNotFoundException).signatures;
      if (arrayOfSignature != null && arrayOfSignature.length > 0)
        return arrayOfSignature[0].toByteArray(); 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */