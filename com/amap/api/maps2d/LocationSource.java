package com.amap.api.maps2d;

import android.location.Location;

public interface LocationSource {
  void activate(OnLocationChangedListener paramOnLocationChangedListener);
  
  void deactivate();
  
  public static interface OnLocationChangedListener {
    void onLocationChanged(Location param1Location);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\LocationSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */