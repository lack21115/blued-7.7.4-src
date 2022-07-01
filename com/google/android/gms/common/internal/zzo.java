package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class zzo extends zze {
  public zzo(zzd paramzzd, int paramInt) {
    super(paramzzd, paramInt, null);
  }
  
  protected final boolean zzama() {
    this.zzgfk.zzgew.zzf(ConnectionResult.zzfqt);
    return true;
  }
  
  protected final void zzj(ConnectionResult paramConnectionResult) {
    this.zzgfk.zzgew.zzf(paramConnectionResult);
    this.zzgfk.onConnectionFailed(paramConnectionResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */