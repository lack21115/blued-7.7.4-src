package com.qiniu.pili.droid.shortvideo;

import android.graphics.Rect;

public class PLVideoMixItem {
  private PLDisplayMode mDisplayMode = PLDisplayMode.FULL;
  
  private boolean mLooping;
  
  private int mStartTimeMs;
  
  private String mVideoPath;
  
  private Rect mVideoRect;
  
  private float mVolume = 1.0F;
  
  public PLDisplayMode getDisplayMode() {
    return this.mDisplayMode;
  }
  
  public int getStartTimeMs() {
    return this.mStartTimeMs;
  }
  
  public String getVideoPath() {
    return this.mVideoPath;
  }
  
  public Rect getVideoRect() {
    return this.mVideoRect;
  }
  
  public float getVolume() {
    return this.mVolume;
  }
  
  public boolean isLooping() {
    return this.mLooping;
  }
  
  public PLVideoMixItem setDisplayMode(PLDisplayMode paramPLDisplayMode) {
    this.mDisplayMode = paramPLDisplayMode;
    return this;
  }
  
  public PLVideoMixItem setLooping(boolean paramBoolean) {
    this.mLooping = paramBoolean;
    return this;
  }
  
  public PLVideoMixItem setStartTimeMs(int paramInt) {
    this.mStartTimeMs = paramInt;
    return this;
  }
  
  public PLVideoMixItem setVideoPath(String paramString) {
    this.mVideoPath = paramString;
    return this;
  }
  
  public PLVideoMixItem setVideoRect(Rect paramRect) {
    this.mVideoRect = paramRect;
    return this;
  }
  
  public PLVideoMixItem setVolume(float paramFloat) {
    this.mVolume = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoMixItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */