package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class zzm implements zzj {
  public zzm(zzd paramzzd) {}
  
  public final void zzf(ConnectionResult paramConnectionResult) {
    if (paramConnectionResult.isSuccess()) {
      this.zzgfk.zza((zzan)null, this.zzgfk.zzaly());
      return;
    } 
    if (zzd.zzg(this.zzgfk) != null)
      zzd.zzg(this.zzgfk).onConnectionFailed(paramConnectionResult); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */