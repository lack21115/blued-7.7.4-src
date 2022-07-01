package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

public class UploadInfo {
  private int a = 1;
  
  private String b;
  
  private LatLonPoint c;
  
  public int getCoordType() {
    return this.a;
  }
  
  public LatLonPoint getPoint() {
    return this.c;
  }
  
  public String getUserID() {
    return this.b;
  }
  
  public void setCoordType(int paramInt) {
    if (paramInt != 0 && paramInt != 1) {
      this.a = 1;
      return;
    } 
    this.a = paramInt;
  }
  
  public void setPoint(LatLonPoint paramLatLonPoint) {
    this.c = paramLatLonPoint;
  }
  
  public void setUserID(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\nearby\UploadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */