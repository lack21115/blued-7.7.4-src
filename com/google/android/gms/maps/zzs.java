package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.zzbc;
import com.google.android.gms.maps.model.PointOfInterest;

final class zzs extends zzbc {
  zzs(GoogleMap paramGoogleMap, GoogleMap.OnPoiClickListener paramOnPoiClickListener) {}
  
  public final void zza(PointOfInterest paramPointOfInterest) throws RemoteException {
    this.zzaa.onPoiClick(paramPointOfInterest);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */