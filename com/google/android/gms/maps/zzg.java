package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.model.Marker;

final class zzg extends zzi {
  zzg(GoogleMap paramGoogleMap, GoogleMap.InfoWindowAdapter paramInfoWindowAdapter) {}
  
  public final IObjectWrapper zzh(zzt paramzzt) {
    return ObjectWrapper.wrap(this.zzo.getInfoWindow(new Marker(paramzzt)));
  }
  
  public final IObjectWrapper zzi(zzt paramzzt) {
    return ObjectWrapper.wrap(this.zzo.getInfoContents(new Marker(paramzzt)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */