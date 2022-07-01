package com.amap.api.mapcore2d;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

public final class gb {
  public static Inner_3dMap_location a;
  
  fz b = null;
  
  private static AMapLocationClientOption a(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
    aMapLocationClientOption.setInterval(paramInner_3dMap_locationOption.getInterval());
    AMapLocationClientOption.AMapLocationMode aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    int i = null.a[paramInner_3dMap_locationOption.getLocationMode().ordinal()];
    if (i != 1) {
      if (i != 2) {
        aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
      } else {
        aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
      } 
    } else {
      aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
    } 
    aMapLocationClientOption.setLocationMode(aMapLocationMode);
    aMapLocationClientOption.setOnceLocation(paramInner_3dMap_locationOption.isOnceLocation());
    aMapLocationClientOption.setNeedAddress(paramInner_3dMap_locationOption.isNeedAddress());
    return aMapLocationClientOption;
  }
  
  public static Inner_3dMap_location a(AMapLocation paramAMapLocation) {
    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
    if (paramAMapLocation != null)
      try {
        inner_3dMap_location.setLatitude(paramAMapLocation.getLatitude());
        inner_3dMap_location.setLongitude(paramAMapLocation.getLongitude());
        inner_3dMap_location.setAccuracy(paramAMapLocation.getAccuracy());
        inner_3dMap_location.setBearing(paramAMapLocation.getBearing());
        inner_3dMap_location.setAltitude(paramAMapLocation.getAltitude());
        inner_3dMap_location.setProvider(paramAMapLocation.getProvider());
        inner_3dMap_location.setSpeed(paramAMapLocation.getSpeed());
        inner_3dMap_location.setTime(paramAMapLocation.getTime());
        inner_3dMap_location.setErrorCode(paramAMapLocation.getErrorCode());
        inner_3dMap_location.setErrorInfo(paramAMapLocation.getErrorInfo());
        inner_3dMap_location.setLocationType(paramAMapLocation.getLocationType());
        inner_3dMap_location.setLocationDetail(paramAMapLocation.getLocationDetail());
        inner_3dMap_location.setProvince(paramAMapLocation.getProvince());
        inner_3dMap_location.setCity(paramAMapLocation.getCity());
        inner_3dMap_location.setCityCode(paramAMapLocation.getCityCode());
        inner_3dMap_location.setCountry(paramAMapLocation.getCountry());
        inner_3dMap_location.setDistrict(paramAMapLocation.getDistrict());
        inner_3dMap_location.setAddress(paramAMapLocation.getAddress());
        inner_3dMap_location.setAdCode(paramAMapLocation.getAdCode());
        inner_3dMap_location.setExtras(paramAMapLocation.getExtras());
        return inner_3dMap_location;
      } finally {
        paramAMapLocation = null;
      }  
    return inner_3dMap_location;
  }
  
  public static void a(Object paramObject, Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    if (paramObject == null)
      return; 
    AMapLocationClientOption aMapLocationClientOption = a(paramInner_3dMap_locationOption);
    ((AMapLocationClient)paramObject).setLocationOption(aMapLocationClientOption);
  }
  
  public final void a(Object paramObject, Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    if (this.b == null)
      this.b = new fz(); 
    this.b.a(paramInner_3dMap_locationListener);
    ((AMapLocationClient)paramObject).setLocationListener(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */