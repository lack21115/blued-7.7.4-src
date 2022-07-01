package com.autonavi.amap.mapcore2d;

public interface Inner_3dMap_locationManagerBase {
  void destroy();
  
  Inner_3dMap_location getLastKnownLocation();
  
  void setLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener);
  
  void setLocationOption(Inner_3dMap_locationOption paramInner_3dMap_locationOption);
  
  void startLocation();
  
  void stopLocation();
  
  void unRegisterLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\autonavi\amap\mapcore2d\Inner_3dMap_locationManagerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */