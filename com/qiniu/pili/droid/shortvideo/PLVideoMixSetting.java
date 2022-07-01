package com.qiniu.pili.droid.shortvideo;

import android.graphics.Rect;

public class PLVideoMixSetting {
  private String mCameraRecodingCachePath;
  
  private Rect mCameraVideoRect;
  
  private boolean mIsCameraAboveSample;
  
  private PLDisplayMode mSampleDisplayMode = PLDisplayMode.FIT;
  
  private String mSampleVideoPath;
  
  private Rect mSampleVideoRect;
  
  public PLVideoMixSetting(Rect paramRect1, Rect paramRect2, String paramString1, PLDisplayMode paramPLDisplayMode, String paramString2) {
    this(paramRect1, paramRect2, paramString1, paramPLDisplayMode, false, paramString2);
  }
  
  public PLVideoMixSetting(Rect paramRect1, Rect paramRect2, String paramString1, PLDisplayMode paramPLDisplayMode, boolean paramBoolean, String paramString2) {
    this.mCameraVideoRect = paramRect1;
    this.mSampleVideoRect = paramRect2;
    this.mSampleVideoPath = paramString1;
    this.mCameraRecodingCachePath = paramString2;
    this.mSampleDisplayMode = paramPLDisplayMode;
    this.mIsCameraAboveSample = paramBoolean;
  }
  
  public PLVideoMixSetting(Rect paramRect1, Rect paramRect2, String paramString1, String paramString2) {
    this(paramRect1, paramRect2, paramString1, PLDisplayMode.FIT, paramString2);
  }
  
  public String getCameraRecodingCachePath() {
    return this.mCameraRecodingCachePath;
  }
  
  public Rect getCameraVideoRect() {
    return this.mCameraVideoRect;
  }
  
  public PLDisplayMode getSampleDisplayMode() {
    return this.mSampleDisplayMode;
  }
  
  public String getSampleVideoPath() {
    return this.mSampleVideoPath;
  }
  
  public Rect getSampleVideoRect() {
    return this.mSampleVideoRect;
  }
  
  public boolean isCameraAboveSample() {
    return this.mIsCameraAboveSample;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoMixSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */