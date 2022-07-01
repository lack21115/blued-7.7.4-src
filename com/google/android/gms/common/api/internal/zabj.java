package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class zabj implements Runnable {
  zabj(GoogleApiManager.zab paramzab, ConnectionResult paramConnectionResult) {}
  
  public final void run() {
    GoogleApiManager.zaa zaa = (GoogleApiManager.zaa)GoogleApiManager.zak(this.zab.zaa).get(GoogleApiManager.zab.zaa(this.zab));
    if (zaa == null)
      return; 
    if (this.zaa.isSuccess()) {
      GoogleApiManager.zab.zaa(this.zab, true);
      if (GoogleApiManager.zab.zab(this.zab).requiresSignIn()) {
        GoogleApiManager.zab.zac(this.zab);
        return;
      } 
      try {
        GoogleApiManager.zab.zab(this.zab).getRemoteService(null, GoogleApiManager.zab.zab(this.zab).getScopesForConnectionlessNonSignIn());
        return;
      } catch (SecurityException securityException) {
        Log.e("GoogleApiManager", "Failed to get service from broker. ", securityException);
        GoogleApiManager.zab.zab(this.zab).disconnect("Failed to get service from broker.");
        zaa.onConnectionFailed(new ConnectionResult(10));
        return;
      } 
    } 
    zaa.onConnectionFailed(this.zaa);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zabj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */