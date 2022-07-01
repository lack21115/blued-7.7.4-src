package com.amap.api.maps2d;

import com.amap.api.mapcore2d.cl;
import com.amap.api.maps2d.model.LatLng;

public class CoordinateConverter {
  private CoordType a = null;
  
  private LatLng b = null;
  
  public static boolean isAMapDataAvailable(double paramDouble1, double paramDouble2) {
    return cl.a(paramDouble1, paramDouble2);
  }
  
  public LatLng convert() {
    if (this.a == null)
      return null; 
    if (this.b == null)
      return null; 
    try {
    
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
    return null;
  }
  
  public CoordinateConverter coord(LatLng paramLatLng) {
    this.b = paramLatLng;
    return this;
  }
  
  public CoordinateConverter from(CoordType paramCoordType) {
    this.a = paramCoordType;
    return this;
  }
  
  public enum CoordType {
    ALIYUN, BAIDU, GOOGLE, GPS, MAPABC, MAPBAR, SOSOMAP;
    
    static {
      ALIYUN = new CoordType("ALIYUN", 4);
      GOOGLE = new CoordType("GOOGLE", 5);
      GPS = new CoordType("GPS", 6);
      a = new CoordType[] { BAIDU, MAPBAR, MAPABC, SOSOMAP, ALIYUN, GOOGLE, GPS };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\CoordinateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */