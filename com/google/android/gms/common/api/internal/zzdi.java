package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

final class zzdi implements Runnable {
  zzdi(zzdh paramzzdh, Result paramResult) {}
  
  public final void run() {
    Exception exception;
    try {
      BasePendingResult.zzfvb.set(Boolean.valueOf(true));
      PendingResult pendingResult = this.zzgbp.zzgbh.onSuccess$1e5d55c();
      this.zzgbp.zzgbm.sendMessage(this.zzgbp.zzgbm.obtainMessage(0, pendingResult));
      BasePendingResult.zzfvb.set(Boolean.valueOf(false));
      GoogleApiClient googleApiClient1 = this.zzgbp.zzfve.get();
      if (googleApiClient1 != null)
        googleApiClient1.zzb(this.zzgbp); 
      return;
    } catch (RuntimeException runtimeException) {
      this.zzgbp.zzgbm.sendMessage(this.zzgbp.zzgbm.obtainMessage(1, runtimeException));
      BasePendingResult.zzfvb.set(Boolean.valueOf(false));
      GoogleApiClient googleApiClient1 = this.zzgbp.zzfve.get();
      if (googleApiClient1 != null)
        googleApiClient1.zzb(this.zzgbp); 
      return;
    } finally {}
    BasePendingResult.zzfvb.set(Boolean.valueOf(false));
    GoogleApiClient googleApiClient = this.zzgbp.zzfve.get();
    if (googleApiClient != null)
      googleApiClient.zzb(this.zzgbp); 
    throw exception;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */