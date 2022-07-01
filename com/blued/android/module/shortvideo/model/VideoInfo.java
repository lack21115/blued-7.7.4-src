package com.blued.android.module.shortvideo.model;

public class VideoInfo {
  public long mDuration;
  
  public boolean mFullScreen;
  
  public String mVideoUrl;
  
  public VideoInfo(String paramString, boolean paramBoolean, long paramLong) {
    this.mVideoUrl = paramString;
    this.mFullScreen = paramBoolean;
    this.mDuration = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\VideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */