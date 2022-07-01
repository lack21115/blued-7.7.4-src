package com.sina.weibo.sdk.call;

public class Position {
  private float mLatitude;
  
  private float mLongitude;
  
  private boolean mOffset;
  
  public Position(float paramFloat1, float paramFloat2) {
    this.mLongitude = paramFloat1;
    this.mLatitude = paramFloat2;
    this.mOffset = true;
  }
  
  public Position(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    this.mLongitude = paramFloat1;
    this.mLatitude = paramFloat2;
    this.mOffset = paramBoolean;
  }
  
  boolean checkValid() {
    if (!Float.isNaN(this.mLongitude)) {
      float f = this.mLongitude;
      if (f >= -180.0F) {
        if (f > 180.0F)
          return false; 
        if (!Float.isNaN(this.mLatitude)) {
          f = this.mLatitude;
          if (f >= -180.0F)
            return !(f > 180.0F); 
        } 
      } 
    } 
    return false;
  }
  
  public float getLatitude() {
    return this.mLatitude;
  }
  
  public float getLongitude() {
    return this.mLongitude;
  }
  
  public String getStrLatitude() {
    return String.valueOf(this.mLatitude);
  }
  
  public String getStrLongitude() {
    return String.valueOf(this.mLongitude);
  }
  
  public String getStrOffset() {
    return this.mOffset ? "1" : "0";
  }
  
  public boolean isOffset() {
    return this.mOffset;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\call\Position.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */