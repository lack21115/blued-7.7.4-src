package com.google.android.gms.dynamite;

import android.content.Context;

final class zzb implements DynamiteModule.VersionPolicy.zzb {
  public final int zza(Context paramContext, String paramString) {
    return DynamiteModule.getLocalVersion(paramContext, paramString);
  }
  
  public final int zza(Context paramContext, String paramString, boolean paramBoolean) throws DynamiteModule.LoadingException {
    return DynamiteModule.zza(paramContext, paramString, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamite\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */