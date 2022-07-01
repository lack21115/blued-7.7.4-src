package com.qiniu.pili.droid.shortvideo;

import android.net.Uri;

public class PLImageRotateSetting {
  private Uri mBackgroundImageUri;
  
  private long mCircleTimeMs = 10000L;
  
  private int mRotateImageHeight = 100;
  
  private Uri mRotateImageUri;
  
  private int mRotateImageWidth = 100;
  
  public Uri getBackgroundImageUri() {
    return this.mBackgroundImageUri;
  }
  
  public long getCircleTimeMs() {
    return this.mCircleTimeMs;
  }
  
  public int getRotateImageHeight() {
    return this.mRotateImageHeight;
  }
  
  public Uri getRotateImageUri() {
    return this.mRotateImageUri;
  }
  
  public int getRotateImageWidth() {
    return this.mRotateImageWidth;
  }
  
  public PLImageRotateSetting setBackgroundImageUri(Uri paramUri) {
    this.mBackgroundImageUri = paramUri;
    return this;
  }
  
  public PLImageRotateSetting setCircleTimeMs(long paramLong) {
    this.mCircleTimeMs = paramLong;
    return this;
  }
  
  public PLImageRotateSetting setRotateImageHeight(int paramInt) {
    this.mRotateImageHeight = paramInt;
    return this;
  }
  
  public PLImageRotateSetting setRotateImageUri(Uri paramUri) {
    this.mRotateImageUri = paramUri;
    return this;
  }
  
  public PLImageRotateSetting setRotateImageWidth(int paramInt) {
    this.mRotateImageWidth = paramInt;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLImageRotateSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */