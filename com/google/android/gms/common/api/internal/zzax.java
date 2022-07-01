package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzcyp;

final class zzax implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
  private zzax(zzao paramzzao) {}
  
  public final void onConnected(Bundle paramBundle) {
    this.zzfxt.zzfxl.zza((zzcyp)new zzav(this.zzfxt));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.zzfxt.zzfwa.lock();
    try {
      if (this.zzfxt.zzd(paramConnectionResult)) {
        this.zzfxt.zzajn();
        this.zzfxt.zzajl();
      } else {
        this.zzfxt.zze(paramConnectionResult);
      } 
      return;
    } finally {
      this.zzfxt.zzfwa.unlock();
    } 
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */