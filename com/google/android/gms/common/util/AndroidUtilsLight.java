package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight {
  private static volatile int zza = -1;
  
  @Deprecated
  public static Context getDeviceProtectedStorageContext(Context paramContext) {
    Context context = paramContext;
    if (zzm.zza())
      context = zzm.zza(paramContext); 
    return context;
  }
  
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString) throws PackageManager.NameNotFoundException {
    PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
    if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
      MessageDigest messageDigest = zza("SHA1");
      if (messageDigest != null)
        return messageDigest.digest(packageInfo.signatures[0].toByteArray()); 
    } 
    return null;
  }
  
  public static MessageDigest zza(String paramString) {
    int i = 0;
    while (true) {
      if (i < 2) {
        try {
          MessageDigest messageDigest = MessageDigest.getInstance(paramString);
          if (messageDigest != null)
            return messageDigest; 
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        i++;
        continue;
      } 
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\AndroidUtilsLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */