package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.internal.zzau;
import com.google.android.gms.maps.model.Marker;

final class zzc extends zzau {
  zzc(GoogleMap paramGoogleMap, GoogleMap.OnMarkerDragListener paramOnMarkerDragListener) {}
  
  public final void zzb(zzt paramzzt) {
    this.zzk.onMarkerDragStart(new Marker(paramzzt));
  }
  
  public final void zzc(zzt paramzzt) {
    this.zzk.onMarkerDragEnd(new Marker(paramzzt));
  }
  
  public final void zzd(zzt paramzzt) {
    this.zzk.onMarkerDrag(new Marker(paramzzt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */