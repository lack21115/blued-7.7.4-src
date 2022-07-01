package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

public class NearbyInfo {
  private String a;
  
  private LatLonPoint b;
  
  private long c;
  
  private int d;
  
  private int e;
  
  public int getDistance() {
    return this.d;
  }
  
  public int getDrivingDistance() {
    return this.e;
  }
  
  public LatLonPoint getPoint() {
    return this.b;
  }
  
  public long getTimeStamp() {
    return this.c;
  }
  
  public String getUserID() {
    return this.a;
  }
  
  public void setDistance(int paramInt) {
    this.d = paramInt;
  }
  
  public void setDrivingDistance(int paramInt) {
    this.e = paramInt;
  }
  
  public void setPoint(LatLonPoint paramLatLonPoint) {
    this.b = paramLatLonPoint;
  }
  
  public void setTimeStamp(long paramLong) {
    this.c = paramLong;
  }
  
  public void setUserID(String paramString) {
    this.a = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\nearby\NearbyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */