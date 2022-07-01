package com.amap.api.maps2d;

import com.amap.api.interfaces.MapCameraMessage;

public final class CameraUpdate {
  private MapCameraMessage a;
  
  public CameraUpdate(MapCameraMessage paramMapCameraMessage) {
    this.a = paramMapCameraMessage;
  }
  
  public MapCameraMessage getCameraUpdateFactoryDelegate() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\CameraUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */