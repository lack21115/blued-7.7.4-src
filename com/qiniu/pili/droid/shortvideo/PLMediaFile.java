package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.f;

public class PLMediaFile {
  private f mMediaFile;
  
  public PLMediaFile(String paramString) {
    this.mMediaFile = new f(paramString);
  }
  
  public int getAudioChannels() {
    return this.mMediaFile.n();
  }
  
  public int getAudioSampleRate() {
    return this.mMediaFile.o();
  }
  
  public long getDurationMs() {
    return this.mMediaFile.g();
  }
  
  public String getFilepath() {
    return this.mMediaFile.b();
  }
  
  public int getVideoBitrate() {
    return this.mMediaFile.k();
  }
  
  public PLVideoFrame getVideoFrameByIndex(int paramInt, boolean paramBoolean) {
    return this.mMediaFile.a(paramInt, paramBoolean);
  }
  
  public PLVideoFrame getVideoFrameByIndex(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
    return this.mMediaFile.a(paramInt1, paramBoolean, paramInt2, paramInt3);
  }
  
  public PLVideoFrame getVideoFrameByTime(long paramLong, boolean paramBoolean) {
    return this.mMediaFile.a(paramLong, paramBoolean);
  }
  
  public PLVideoFrame getVideoFrameByTime(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2) {
    return this.mMediaFile.a(paramLong, paramBoolean, paramInt1, paramInt2);
  }
  
  public int getVideoFrameCount(boolean paramBoolean) {
    return this.mMediaFile.a(paramBoolean);
  }
  
  public int getVideoFrameRate() {
    return this.mMediaFile.j();
  }
  
  public int getVideoHeight() {
    return this.mMediaFile.i();
  }
  
  public int getVideoIFrameInterval() {
    return this.mMediaFile.l();
  }
  
  public int getVideoRotation() {
    return this.mMediaFile.m();
  }
  
  public int getVideoWidth() {
    return this.mMediaFile.h();
  }
  
  public boolean hasAudio() {
    return (this.mMediaFile.f() != null);
  }
  
  public boolean hasVideo() {
    return (this.mMediaFile.e() != null);
  }
  
  public void release() {
    this.mMediaFile.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLMediaFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */