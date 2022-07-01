package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzay;

final class zzh extends zzay {
  zzh(GoogleMap paramGoogleMap, GoogleMap.OnMyLocationChangeListener paramOnMyLocationChangeListener) {}
  
  public final void zza(IObjectWrapper paramIObjectWrapper) {
    this.zzp.onMyLocationChange((Location)ObjectWrapper.unwrap(paramIObjectWrapper));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */