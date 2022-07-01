package com.amap.api.maps2d.model;

public class RoutePara {
  private int a = 0;
  
  private int b = 0;
  
  private LatLng c;
  
  private LatLng d;
  
  private String e;
  
  private String f;
  
  public int getDrivingRouteStyle() {
    return this.a;
  }
  
  public String getEndName() {
    return this.f;
  }
  
  public LatLng getEndPoint() {
    return this.d;
  }
  
  public String getStartName() {
    return this.e;
  }
  
  public LatLng getStartPoint() {
    return this.c;
  }
  
  public int getTransitRouteStyle() {
    return this.b;
  }
  
  public void setDrivingRouteStyle(int paramInt) {
    if (paramInt >= 0 && paramInt < 9)
      this.a = paramInt; 
  }
  
  public void setEndName(String paramString) {
    this.f = paramString;
  }
  
  public void setEndPoint(LatLng paramLatLng) {
    this.d = paramLatLng;
  }
  
  public void setStartName(String paramString) {
    this.e = paramString;
  }
  
  public void setStartPoint(LatLng paramLatLng) {
    this.c = paramLatLng;
  }
  
  public void setTransitRouteStyle(int paramInt) {
    if (paramInt >= 0 && paramInt < 6)
      this.b = paramInt; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\RoutePara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */