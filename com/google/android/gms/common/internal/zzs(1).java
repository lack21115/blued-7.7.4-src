package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzs {
  private static Object zza = new Object();
  
  private static boolean zzb;
  
  private static String zzc;
  
  private static int zzd;
  
  public static String zza(Context paramContext) {
    zzc(paramContext);
    return zzc;
  }
  
  public static int zzb(Context paramContext) {
    zzc(paramContext);
    return zzd;
  }
  
  private static void zzc(Context paramContext) {
    synchronized (zza) {
      if (zzb)
        return; 
      zzb = true;
      String str = paramContext.getPackageName();
      PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(paramContext);
      try {
        Bundle bundle = (packageManagerWrapper.getApplicationInfo(str, 128)).metaData;
        if (bundle == null)
          return; 
        zzc = bundle.getString("com.google.app.id");
        zzd = bundle.getInt("com.google.android.gms.version");
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)nameNotFoundException);
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */