package com.amap.api.mapcore2d;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;

public final class fz implements AMapLocationListener {
  public Inner_3dMap_locationListener a = null;
  
  public final void a(Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    this.a = paramInner_3dMap_locationListener;
  }
  
  public final void onLocationChanged(AMapLocation paramAMapLocation) {
    try {
      Inner_3dMap_location inner_3dMap_location = gb.a(paramAMapLocation);
      return;
    } finally {
      paramAMapLocation = null;
      gu.a((Throwable)paramAMapLocation, "LocationListener", "onLocationChanged");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */