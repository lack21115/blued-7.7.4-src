package com.bytedance.sdk.openadsdk;

public class TTLocation {
  private double a = 0.0D;
  
  private double b = 0.0D;
  
  public TTLocation(double paramDouble1, double paramDouble2) {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public double getLatitude() {
    return this.a;
  }
  
  public double getLongitude() {
    return this.b;
  }
  
  public void setLatitude(double paramDouble) {
    this.a = paramDouble;
  }
  
  public void setLongitude(double paramDouble) {
    this.b = paramDouble;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */