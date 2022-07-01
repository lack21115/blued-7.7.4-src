package com.google.android.gms.maps;

import android.location.Location;

public interface LocationSource {
  void activate(OnLocationChangedListener paramOnLocationChangedListener);
  
  void deactivate();
  
  public static interface OnLocationChangedListener {
    void onLocationChanged(Location param1Location);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\LocationSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */