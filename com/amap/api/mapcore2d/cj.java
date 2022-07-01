package com.amap.api.mapcore2d;

import com.amap.api.maps2d.model.LatLng;

public class cj {
  public static LatLng a(LatLng paramLatLng) {
    double[] arrayOfDouble;
    if (paramLatLng == null)
      return null; 
    if (cl.a(paramLatLng.latitude, paramLatLng.longitude)) {
      arrayOfDouble = fy.a(paramLatLng.longitude, paramLatLng.latitude);
      return new LatLng(arrayOfDouble[1], arrayOfDouble[0]);
    } 
    return (LatLng)arrayOfDouble;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */