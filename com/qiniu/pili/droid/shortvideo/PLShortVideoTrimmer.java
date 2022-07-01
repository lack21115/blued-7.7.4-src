package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.r;

public class PLShortVideoTrimmer {
  private PLMediaFile mMediaFile;
  
  private r mShortVideoTrimmerCore;
  
  public PLShortVideoTrimmer(Context paramContext, String paramString1, String paramString2) {
    this.mMediaFile = new PLMediaFile(paramString1);
    this.mShortVideoTrimmerCore = new r(paramContext, paramString1, paramString2);
    QosManager.a().a(QosManager.KeyPoint.trim_init);
  }
  
  public void cancelTrim() {
    this.mShortVideoTrimmerCore.a();
  }
  
  public void destroy() {
    this.mMediaFile.release();
    this.mShortVideoTrimmerCore.b();
  }
  
  @Deprecated
  public long getSrcDurationMs() {
    return this.mMediaFile.getDurationMs();
  }
  
  @Deprecated
  public PLVideoFrame getVideoFrameByIndex(int paramInt, boolean paramBoolean) {
    return this.mMediaFile.getVideoFrameByIndex(paramInt, paramBoolean);
  }
  
  @Deprecated
  public PLVideoFrame getVideoFrameByIndex(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
    return this.mMediaFile.getVideoFrameByIndex(paramInt1, paramBoolean, paramInt2, paramInt3);
  }
  
  @Deprecated
  public PLVideoFrame getVideoFrameByTime(long paramLong, boolean paramBoolean) {
    return this.mMediaFile.getVideoFrameByTime(paramLong, paramBoolean);
  }
  
  @Deprecated
  public PLVideoFrame getVideoFrameByTime(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2) {
    return this.mMediaFile.getVideoFrameByTime(paramLong, paramBoolean, paramInt1, paramInt2);
  }
  
  @Deprecated
  public int getVideoFrameCount(boolean paramBoolean) {
    return this.mMediaFile.getVideoFrameCount(paramBoolean);
  }
  
  public void setSpeed(double paramDouble) {
    this.mShortVideoTrimmerCore.a(paramDouble);
  }
  
  public void trim(long paramLong1, long paramLong2, TRIM_MODE paramTRIM_MODE, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoTrimmerCore.a(paramLong1, paramLong2, paramTRIM_MODE, paramPLVideoSaveListener);
    QosManager.a().a(this.mShortVideoTrimmerCore.c());
    QosManager.a().a(QosManager.KeyPoint.trim_video);
  }
  
  public void trim(long paramLong1, long paramLong2, PLVideoSaveListener paramPLVideoSaveListener) {
    trim(paramLong1, paramLong2, TRIM_MODE.ACCURATE, paramPLVideoSaveListener);
  }
  
  public enum TRIM_MODE {
    ACCURATE, FAST;
    
    static {
      $VALUES = new TRIM_MODE[] { FAST, ACCURATE };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoTrimmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */