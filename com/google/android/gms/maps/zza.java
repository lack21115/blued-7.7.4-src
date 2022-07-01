package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.IndoorBuilding;

final class zza extends zzaa {
  zza(GoogleMap paramGoogleMap, GoogleMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener) {}
  
  public final void onIndoorBuildingFocused() {
    this.zzi.onIndoorBuildingFocused();
  }
  
  public final void zza(zzn paramzzn) {
    this.zzi.onIndoorLevelActivated(new IndoorBuilding(paramzzn));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */