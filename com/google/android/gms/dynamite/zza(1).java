package com.google.android.gms.dynamite;

import android.content.Context;

final class zza implements DynamiteModule.VersionPolicy {
  public final DynamiteModule.VersionPolicy.zza zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zzb paramzzb) throws DynamiteModule.LoadingException {
    DynamiteModule.VersionPolicy.zza zza1 = new DynamiteModule.VersionPolicy.zza();
    zza1.zzb = paramzzb.zza(paramContext, paramString, true);
    if (zza1.zzb != 0) {
      zza1.zzc = 1;
      return zza1;
    } 
    zza1.zza = paramzzb.zza(paramContext, paramString);
    if (zza1.zza != 0)
      zza1.zzc = -1; 
    return zza1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamite\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */