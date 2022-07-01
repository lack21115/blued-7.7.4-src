package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.zad;

final class zaam implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
  private zaam(zaaf paramzaaf) {}
  
  public final void onConnected(Bundle paramBundle) {
    if (((ClientSettings)Preconditions.checkNotNull(zaaf.zai(this.zaa))).zae()) {
      zaaf.zac(this.zaa).lock();
      try {
        zad zad = zaaf.zaf(this.zaa);
        if (zad == null)
          return; 
        zad.zaa((zac)new zaak(this.zaa));
        return;
      } finally {
        zaaf.zac(this.zaa).unlock();
      } 
    } 
    ((zad)Preconditions.checkNotNull(zaaf.zaf(this.zaa))).zaa((zac)new zaak(this.zaa));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    zaaf.zac(this.zaa).lock();
    try {
      if (zaaf.zab(this.zaa, paramConnectionResult)) {
        zaaf.zaj(this.zaa);
        zaaf.zak(this.zaa);
      } else {
        zaaf.zaa(this.zaa, paramConnectionResult);
      } 
      return;
    } finally {
      zaaf.zac(this.zaa).unlock();
    } 
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */