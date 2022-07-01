package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;

public final class zzdh extends TransformedResult implements ResultCallback {
  final Object zzfvc;
  
  final WeakReference zzfve;
  
  ResultTransform zzgbh;
  
  zzdh zzgbi;
  
  volatile ResultCallbacks zzgbj;
  
  PendingResult zzgbk;
  
  Status zzgbl;
  
  final zzdj zzgbm;
  
  boolean zzgbn;
  
  private final boolean zzalc() {
    GoogleApiClient googleApiClient = this.zzfve.get();
    return (this.zzgbj != null && googleApiClient != null);
  }
  
  public final void onResult(Result paramResult) {
    synchronized (this.zzfvc) {
      ResultCallbacks resultCallbacks;
      if (paramResult.getStatus().isSuccess()) {
        if (this.zzgbh != null) {
          zzcs.zzajx().submit(new zzdi(this, paramResult));
        } else if (zzalc()) {
          resultCallbacks = this.zzgbj;
        } 
      } else {
        zzd(resultCallbacks.getStatus());
      } 
      return;
    } 
  }
  
  final void zzd(Status paramStatus) {
    synchronized (this.zzfvc) {
      this.zzgbl = paramStatus;
      zzx(this.zzgbl);
      return;
    } 
  }
  
  final void zzx(Status paramStatus) {
    synchronized (this.zzfvc) {
      if (this.zzgbh != null) {
        zzbq.checkNotNull(paramStatus, "onFailure must not return null");
        this.zzgbi.zzd(paramStatus);
      } else if (zzalc()) {
        ResultCallbacks resultCallbacks = this.zzgbj;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */