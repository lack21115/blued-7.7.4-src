package com.amap.api.mapcore2d;

import com.amap.api.maps2d.model.LatLng;
import java.math.BigDecimal;

public class cg {
  private static double a(double paramDouble) {
    return Math.sin(paramDouble * 3000.0D * 0.017453292519943295D) * 2.0E-5D;
  }
  
  private static double a(double paramDouble, int paramInt) {
    return (new BigDecimal(paramDouble)).setScale(paramInt, 4).doubleValue();
  }
  
  private static ch a(double paramDouble1, double paramDouble2) {
    ch ch = new ch();
    double d1 = Math.cos(b(paramDouble1) + Math.atan2(paramDouble2, paramDouble1));
    double d2 = a(paramDouble2);
    double d4 = paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2;
    double d3 = Math.sqrt(d4);
    paramDouble1 = Math.sin(b(paramDouble1) + Math.atan2(paramDouble2, paramDouble1));
    paramDouble2 = a(paramDouble2);
    d4 = Math.sqrt(d4);
    ch.a = a(d1 * (d2 + d3) + 0.0065D, 8);
    ch.b = a(paramDouble1 * (paramDouble2 + d4) + 0.006D, 8);
    return ch;
  }
  
  private static LatLng a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    ch ch1 = new ch();
    paramDouble3 = paramDouble1 - paramDouble3;
    paramDouble4 = paramDouble2 - paramDouble4;
    ch ch2 = a(paramDouble3, paramDouble4);
    ch1.a = a(paramDouble1 + paramDouble3 - ch2.a, 8);
    ch1.b = a(paramDouble2 + paramDouble4 - ch2.b, 8);
    return new LatLng(ch1.b, ch1.a);
  }
  
  public static LatLng a(LatLng paramLatLng) {
    return (paramLatLng != null) ? b(paramLatLng) : null;
  }
  
  private static LatLng a(LatLng paramLatLng, int paramInt) {
    LatLng latLng = null;
    int i = 0;
    double d1 = 0.006401062D;
    double d2 = 0.0060424805D;
    while (i < paramInt) {
      latLng = a(paramLatLng.longitude, paramLatLng.latitude, d1, d2);
      d1 = paramLatLng.longitude - latLng.longitude;
      d2 = paramLatLng.latitude - latLng.latitude;
      i++;
    } 
    return latLng;
  }
  
  private static double b(double paramDouble) {
    return Math.cos(paramDouble * 3000.0D * 0.017453292519943295D) * 3.0E-6D;
  }
  
  private static LatLng b(LatLng paramLatLng) {
    return a(paramLatLng, 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */