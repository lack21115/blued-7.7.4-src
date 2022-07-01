package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.q;

public class PLShortVideoTranscoder {
  private PLMediaFile mMediaFile;
  
  private q mShortVideoTranscoderCore;
  
  public PLShortVideoTranscoder(Context paramContext, String paramString1, String paramString2) {
    this.mMediaFile = new PLMediaFile(paramString1);
    this.mShortVideoTranscoderCore = new q(paramContext, paramString1, paramString2);
  }
  
  public void cancelTranscode() {
    this.mShortVideoTranscoderCore.a();
  }
  
  @Deprecated
  public int getSrcBitrate() {
    return this.mMediaFile.getVideoBitrate();
  }
  
  @Deprecated
  public long getSrcDurationMs() {
    return this.mMediaFile.getDurationMs();
  }
  
  @Deprecated
  public int getSrcHeight() {
    return this.mMediaFile.getVideoHeight();
  }
  
  @Deprecated
  public int getSrcWidth() {
    return this.mMediaFile.getVideoWidth();
  }
  
  public void setClipArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mShortVideoTranscoderCore.a(paramInt1, paramInt2, paramInt3, paramInt4);
    QosManager.a().a(QosManager.KeyPoint.transcode_clip_video);
  }
  
  public void setMaxFrameRate(int paramInt) {
    this.mShortVideoTranscoderCore.b(paramInt);
  }
  
  public void setMixAudioFile(String paramString, long paramLong1, long paramLong2, boolean paramBoolean) {
    this.mShortVideoTranscoderCore.a(paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  public void setWatermark(PLWatermarkSetting paramPLWatermarkSetting) {
    this.mShortVideoTranscoderCore.a(paramPLWatermarkSetting);
  }
  
  public boolean transcode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PLVideoSaveListener paramPLVideoSaveListener) {
    QosManager.a().a(QosManager.KeyPoint.transcode_rotate);
    QosManager.a().a(this.mShortVideoTranscoderCore.b());
    return this.mShortVideoTranscoderCore.a(paramInt1, paramInt2, paramInt3, paramInt4, paramPLVideoSaveListener);
  }
  
  public boolean transcode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, PLVideoSaveListener paramPLVideoSaveListener) {
    if (paramBoolean)
      QosManager.a().a(QosManager.KeyPoint.reverse_video); 
    QosManager.a().a(this.mShortVideoTranscoderCore.b());
    return this.mShortVideoTranscoderCore.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramPLVideoSaveListener);
  }
  
  public boolean transcode(int paramInt1, int paramInt2, int paramInt3, PLVideoSaveListener paramPLVideoSaveListener) {
    QosManager.a().a(QosManager.KeyPoint.transcode_video);
    QosManager.a().a(this.mShortVideoTranscoderCore.b());
    return this.mShortVideoTranscoderCore.a(paramInt1, paramInt2, paramInt3, paramPLVideoSaveListener);
  }
  
  public boolean transcode(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, PLVideoSaveListener paramPLVideoSaveListener) {
    if (paramBoolean)
      QosManager.a().a(QosManager.KeyPoint.reverse_video); 
    QosManager.a().a(this.mShortVideoTranscoderCore.b());
    return this.mShortVideoTranscoderCore.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramPLVideoSaveListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */