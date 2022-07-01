package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzx implements zzcd {
  private zzx(zzv paramzzv) {}
  
  public final void zzc(ConnectionResult paramConnectionResult) {
    this.zzfwc.zzfwa.lock();
    try {
      this.zzfwc.zzfvx = paramConnectionResult;
      zzv.zzb(this.zzfwc);
      return;
    } finally {
      this.zzfwc.zzfwa.unlock();
    } 
  }
  
  public final void zzf(int paramInt, boolean paramBoolean) {
    this.zzfwc.zzfwa.lock();
    try {
      if (this.zzfwc.zzfvz || this.zzfwc.zzfvy == null || !this.zzfwc.zzfvy.isSuccess()) {
        this.zzfwc.zzfvz = false;
        zzv.zza(this.zzfwc, paramInt, paramBoolean);
        return;
      } 
      this.zzfwc.zzfvz = true;
      this.zzfwc.zzfvs.onConnectionSuspended(paramInt);
      return;
    } finally {
      this.zzfwc.zzfwa.unlock();
    } 
  }
  
  public final void zzk(Bundle paramBundle) {
    this.zzfwc.zzfwa.lock();
    try {
      zzv zzv1 = this.zzfwc;
      if (zzv1.zzfvw == null) {
        zzv1.zzfvw = paramBundle;
      } else if (paramBundle != null) {
        zzv1.zzfvw.putAll(paramBundle);
      } 
      this.zzfwc.zzfvx = ConnectionResult.zzfqt;
      zzv.zzb(this.zzfwc);
      return;
    } finally {
      this.zzfwc.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */