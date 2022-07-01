package com.amap.api.maps2d.model;

public class MyTrafficStyle {
  private int a = -16735735;
  
  private int b = -35576;
  
  private int c = -1441006;
  
  private int d = -7208950;
  
  public int getCongestedColor() {
    return this.c;
  }
  
  public int getSeriousCongestedColor() {
    return this.d;
  }
  
  public int getSlowColor() {
    return this.b;
  }
  
  public int getSmoothColor() {
    return this.a;
  }
  
  public void setCongestedColor(int paramInt) {
    this.c = paramInt;
  }
  
  public void setSeriousCongestedColor(int paramInt) {
    this.d = paramInt;
  }
  
  public void setSlowColor(int paramInt) {
    this.b = paramInt;
  }
  
  public void setSmoothColor(int paramInt) {
    this.a = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\MyTrafficStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */