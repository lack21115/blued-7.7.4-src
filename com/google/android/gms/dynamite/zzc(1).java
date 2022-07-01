package com.google.android.gms.dynamite;

import android.content.Context;

final class zzc implements DynamiteModule.VersionPolicy {
  public final DynamiteModule.VersionPolicy.zza zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zzb paramzzb) throws DynamiteModule.LoadingException {
    DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
    zza.zzb = paramzzb.zza(paramContext, paramString, false);
    if (zza.zzb == 0) {
      zza.zzc = 0;
      return zza;
    } 
    zza.zzc = 1;
    return zza;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamite\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */