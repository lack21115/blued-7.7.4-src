package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzy implements zzcd {
  private zzy(zzv paramzzv) {}
  
  public final void zzc(ConnectionResult paramConnectionResult) {
    this.zzfwc.zzfwa.lock();
    try {
      this.zzfwc.zzfvy = paramConnectionResult;
      zzv.zzb(this.zzfwc);
      return;
    } finally {
      this.zzfwc.zzfwa.unlock();
    } 
  }
  
  public final void zzf(int paramInt, boolean paramBoolean) {
    this.zzfwc.zzfwa.lock();
    try {
      if (this.zzfwc.zzfvz) {
        this.zzfwc.zzfvz = false;
        zzv.zza(this.zzfwc, paramInt, paramBoolean);
        return;
      } 
      this.zzfwc.zzfvz = true;
      this.zzfwc.zzfvr.onConnectionSuspended(paramInt);
      return;
    } finally {
      this.zzfwc.zzfwa.unlock();
    } 
  }
  
  public final void zzk(Bundle paramBundle) {
    this.zzfwc.zzfwa.lock();
    try {
      this.zzfwc.zzfvy = ConnectionResult.zzfqt;
      zzv.zzb(this.zzfwc);
      return;
    } finally {
      this.zzfwc.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */