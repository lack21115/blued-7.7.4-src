package com.google.android.gms.internal.common;

import android.content.Context;
import android.os.Build;

public final class zzm {
  private static volatile boolean zza = zza() ^ true;
  
  private static boolean zzb = false;
  
  public static Context zza(Context paramContext) {
    return paramContext.isDeviceProtectedStorage() ? paramContext : paramContext.createDeviceProtectedStorageContext();
  }
  
  public static boolean zza() {
    return (Build.VERSION.SDK_INT >= 24);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\common\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */