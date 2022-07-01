package com.amap.api.maps2d.model;

public class NaviPara {
  @Deprecated
  public static final int DRIVING_AVOID_CONGESTION = 4;
  
  @Deprecated
  public static final int DRIVING_DEFAULT = 0;
  
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY = 3;
  
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
  
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
  
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
  
  @Deprecated
  public static final int DRIVING_SAVE_MONEY = 1;
  
  @Deprecated
  public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
  
  @Deprecated
  public static final int DRIVING_SHORT_DISTANCE = 2;
  
  private int a = 0;
  
  private LatLng b;
  
  public int getNaviStyle() {
    return this.a;
  }
  
  public LatLng getTargetPoint() {
    return this.b;
  }
  
  public void setNaviStyle(int paramInt) {
    if (paramInt >= 0 && paramInt < 9)
      this.a = paramInt; 
  }
  
  public void setTargetPoint(LatLng paramLatLng) {
    this.b = paramLatLng;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\NaviPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */