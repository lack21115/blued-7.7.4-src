package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zzq implements Runnable {
  private final zzp zzfux;
  
  zzq(zzo paramzzo, zzp paramzzp) {
    this.zzfux = paramzzp;
  }
  
  public final void run() {
    Dialog dialog;
    if (!this.zzfuy.mStarted)
      return; 
    ConnectionResult connectionResult = this.zzfux.zzfuw;
    if (connectionResult.hasResolution()) {
      this.zzfuy.zzgam.startActivityForResult(GoogleApiActivity.zza((Context)this.zzfuy.getActivity(), connectionResult.zzekd, this.zzfux.zzfuv, false), 1);
      return;
    } 
    if (this.zzfuy.zzftg.isUserResolvableError(connectionResult.zzcc)) {
      GoogleApiAvailability.zza$454b2131(this.zzfuy.getActivity(), this.zzfuy.zzgam, connectionResult.zzcc, this.zzfuy);
      return;
    } 
    if (connectionResult.zzcc == 18) {
      dialog = GoogleApiAvailability.zza(this.zzfuy.getActivity(), this.zzfuy);
      GoogleApiAvailability.zza(this.zzfuy.getActivity().getApplicationContext(), new zzr(this, dialog));
      return;
    } 
    this.zzfuy.zza((ConnectionResult)dialog, this.zzfux.zzfuv);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */