package com.amap.api.mapcore2d;

import android.location.Location;
import com.amap.api.maps2d.LocationSource;

class d implements LocationSource.OnLocationChangedListener {
  Location a;
  
  private y b;
  
  d(y paramy) {
    this.b = paramy;
  }
  
  public void onLocationChanged(Location paramLocation) {
    this.a = paramLocation;
    try {
      if (this.b.isMyLocationEnabled())
        return; 
    } finally {
      paramLocation = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */