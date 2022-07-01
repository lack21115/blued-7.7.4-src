package com.amap.api.mapcore2d;

import com.amap.api.maps2d.model.LatLng;

public class ci {
  static double a = 3.141592653589793D;
  
  public static double a(double paramDouble1, double paramDouble2) {
    return Math.cos(paramDouble2 / 100000.0D) * paramDouble1 / 18000.0D + Math.sin(paramDouble1 / 100000.0D) * paramDouble2 / 9000.0D;
  }
  
  public static LatLng a(LatLng paramLatLng) {
    return (paramLatLng == null) ? null : cj.a(c(paramLatLng.longitude, paramLatLng.latitude));
  }
  
  public static double b(double paramDouble1, double paramDouble2) {
    return Math.sin(paramDouble2 / 100000.0D) * paramDouble1 / 18000.0D + Math.cos(paramDouble1 / 100000.0D) * paramDouble2 / 9000.0D;
  }
  
  private static LatLng c(double paramDouble1, double paramDouble2) {
    double d1 = ((long)(paramDouble1 * 100000.0D) % 36000000L);
    paramDouble1 = ((long)(paramDouble2 * 100000.0D) % 36000000L);
    int i = (int)(-a(d1, paramDouble1) + d1);
    int j = (int)(-b(d1, paramDouble1) + paramDouble1);
    double d2 = i;
    paramDouble2 = j;
    d2 = -a(d2, paramDouble2);
    j = 1;
    if (d1 > 0.0D) {
      i = 1;
    } else {
      i = -1;
    } 
    d1 = (int)(d2 + d1 + i);
    paramDouble2 = -b(d1, paramDouble2);
    if (paramDouble1 > 0.0D) {
      i = j;
    } else {
      i = -1;
    } 
    i = (int)(paramDouble2 + paramDouble1 + i);
    paramDouble1 = d1 / 100000.0D;
    return new LatLng(i / 100000.0D, paramDouble1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */