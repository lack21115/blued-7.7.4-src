package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.model.RuntimeRemoteException;

final class zzm implements LocationSource.OnLocationChangedListener {
  zzm(zzl paramzzl, zzah paramzzah) {}
  
  public final void onLocationChanged(Location paramLocation) {
    try {
      this.zzu.zza(paramLocation);
      return;
    } catch (RemoteException remoteException) {
      throw new RuntimeRemoteException(remoteException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */