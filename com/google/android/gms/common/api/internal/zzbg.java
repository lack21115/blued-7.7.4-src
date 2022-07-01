package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zzbg extends zzby {
  private WeakReference zzfyv;
  
  zzbg(zzba paramzzba) {
    this.zzfyv = new WeakReference<zzba>(paramzzba);
  }
  
  public final void zzaio() {
    zzba zzba = this.zzfyv.get();
    if (zzba == null)
      return; 
    zzba.zza(zzba);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */