package com.google.android.gms.dynamite;

import android.content.Context;

final class zzf implements DynamiteModule$zzd {
  public final zzj zza(Context paramContext, String paramString, zzi paramzzi) {
    zzj zzj = new zzj();
    zzj.zzhds = paramzzi.zzx(paramContext, paramString);
    zzj.zzhdt = paramzzi.zzc(paramContext, paramString, true);
    if (zzj.zzhds == 0 && zzj.zzhdt == 0) {
      boolean bool = false;
      zzj.zzhdu = bool;
      return zzj;
    } 
    if (zzj.zzhdt >= zzj.zzhds) {
      zzj.zzhdu = 1;
      return zzj;
    } 
    byte b = -1;
    zzj.zzhdu = b;
    return zzj;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\dynamite\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */