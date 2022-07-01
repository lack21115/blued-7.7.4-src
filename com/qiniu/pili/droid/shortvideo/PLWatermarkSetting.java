package com.qiniu.pili.droid.shortvideo;

import android.graphics.Bitmap;

public class PLWatermarkSetting {
  private int mAlpha = 255;
  
  private Bitmap mBitmap;
  
  private float mHeight;
  
  private int mResourceId;
  
  private float mWidth;
  
  private float mX;
  
  private float mY;
  
  public static PLWatermarkSetting fromSetting(PLWatermarkSetting paramPLWatermarkSetting) {
    PLWatermarkSetting pLWatermarkSetting = new PLWatermarkSetting();
    pLWatermarkSetting.setAlpha(paramPLWatermarkSetting.mAlpha);
    pLWatermarkSetting.setBitmap(paramPLWatermarkSetting.mBitmap);
    pLWatermarkSetting.setPosition(paramPLWatermarkSetting.mX, paramPLWatermarkSetting.mY);
    pLWatermarkSetting.setResourceId(paramPLWatermarkSetting.mResourceId);
    pLWatermarkSetting.setSize(paramPLWatermarkSetting.mWidth, paramPLWatermarkSetting.mHeight);
    return pLWatermarkSetting;
  }
  
  public int getAlpha() {
    return this.mAlpha;
  }
  
  public Bitmap getBitmap() {
    return this.mBitmap;
  }
  
  public float getHeight() {
    return this.mHeight;
  }
  
  public int getResourceId() {
    return this.mResourceId;
  }
  
  public float getWidth() {
    return this.mWidth;
  }
  
  public float getX() {
    return this.mX;
  }
  
  public float getY() {
    return this.mY;
  }
  
  public void setAlpha(int paramInt) {
    if (paramInt >= 0 && paramInt <= 255) {
      this.mAlpha = paramInt;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alpha value should be [0...255]:");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setBitmap(Bitmap paramBitmap) {
    this.mBitmap = paramBitmap;
  }
  
  public void setPosition(float paramFloat1, float paramFloat2) {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }
  
  public void setResourceId(int paramInt) {
    this.mResourceId = paramInt;
  }
  
  public void setSize(float paramFloat1, float paramFloat2) {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLWatermarkSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */