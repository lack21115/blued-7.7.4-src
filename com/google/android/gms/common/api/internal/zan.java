package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

final class zan implements Runnable {
  private final zak zab;
  
  zan(zal paramzal, zak paramzak) {
    this.zab = paramzak;
  }
  
  public final void run() {
    Dialog dialog;
    if (!this.zaa.zaa)
      return; 
    ConnectionResult connectionResult = this.zab.zab();
    if (connectionResult.hasResolution()) {
      this.zaa.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa((Context)this.zaa.getActivity(), (PendingIntent)Preconditions.checkNotNull(connectionResult.getResolution()), this.zab.zaa(), false), 1);
      return;
    } 
    if (this.zaa.zac.isUserResolvableError(connectionResult.getErrorCode())) {
      this.zaa.zac.zaa(this.zaa.getActivity(), this.zaa.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zaa);
      return;
    } 
    if (connectionResult.getErrorCode() == 18) {
      dialog = GoogleApiAvailability.zaa(this.zaa.getActivity(), this.zaa);
      this.zaa.zac.zaa(this.zaa.getActivity().getApplicationContext(), new zam(this, dialog));
      return;
    } 
    this.zaa.zaa((ConnectionResult)dialog, this.zab.zaa());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */