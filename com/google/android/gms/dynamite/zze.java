package com.google.android.gms.dynamite;

import android.content.Context;

final class zze implements DynamiteModule$zzd {
  public final zzj zza(Context paramContext, String paramString, zzi paramzzi) {
    int i;
    zzj zzj = new zzj();
    zzj.zzhds = paramzzi.zzx(paramContext, paramString);
    if (zzj.zzhds != 0) {
      i = paramzzi.zzc(paramContext, paramString, false);
    } else {
      i = paramzzi.zzc(paramContext, paramString, true);
    } 
    zzj.zzhdt = i;
    if (zzj.zzhds == 0 && zzj.zzhdt == 0) {
      zzj.zzhdu = 0;
      return zzj;
    } 
    if (zzj.zzhds >= zzj.zzhdt) {
      zzj.zzhdu = -1;
      return zzj;
    } 
    zzj.zzhdu = 1;
    return zzj;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\dynamite\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */