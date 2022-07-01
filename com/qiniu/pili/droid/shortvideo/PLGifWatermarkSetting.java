package com.qiniu.pili.droid.shortvideo;

public class PLGifWatermarkSetting {
  private int mAlpha = 255;
  
  private long mDurationMs;
  
  private String mFilePath;
  
  private float mHeight;
  
  private int mRotation;
  
  private long mStartTimeMs;
  
  private float mWidth;
  
  private float mX;
  
  private float mY;
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof PLGifWatermarkSetting;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.mFilePath.equals(paramObject.getFilePath())) {
      bool = bool1;
      if (this.mAlpha == paramObject.getAlpha()) {
        bool = bool1;
        if (this.mX == paramObject.getX()) {
          bool = bool1;
          if (this.mY == paramObject.getY()) {
            bool = bool1;
            if (this.mWidth == paramObject.getWidth()) {
              bool = bool1;
              if (this.mHeight == paramObject.getHeight()) {
                bool = bool1;
                if (this.mStartTimeMs == paramObject.getStartTimeMs()) {
                  bool = bool1;
                  if (this.mDurationMs == paramObject.getDurationMs())
                    bool = true; 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  public int getAlpha() {
    return this.mAlpha;
  }
  
  public long getDurationMs() {
    return this.mDurationMs;
  }
  
  public String getFilePath() {
    return this.mFilePath;
  }
  
  public float getHeight() {
    return this.mHeight;
  }
  
  public int getRotation() {
    return this.mRotation;
  }
  
  public long getStartTimeMs() {
    return this.mStartTimeMs;
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
  
  public int hashCode() {
    return super.hashCode();
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
  
  public void setDisplayPeriod(long paramLong1, long paramLong2) {
    this.mStartTimeMs = paramLong1;
    this.mDurationMs = paramLong2;
  }
  
  public void setFilePath(String paramString) {
    this.mFilePath = paramString;
  }
  
  public void setPosition(float paramFloat1, float paramFloat2) {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }
  
  public void setRotation(int paramInt) {
    this.mRotation = paramInt;
  }
  
  public void setSize(float paramFloat1, float paramFloat2) {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLGifWatermarkSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */