package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.core.h;
import com.qiniu.pili.droid.shortvideo.f.b;

public class PLDraft {
  private b mDraft;
  
  PLDraft(b paramb) {
    this.mDraft = paramb;
  }
  
  private boolean isIndexValid(int paramInt) {
    return (paramInt >= 0 && paramInt < this.mDraft.b().size());
  }
  
  public PLAudioEncodeSetting getAudioEncodeSetting() {
    return this.mDraft.f();
  }
  
  public PLCameraSetting getCameraSetting() {
    return this.mDraft.c();
  }
  
  b getDraft() {
    return this.mDraft;
  }
  
  public PLFaceBeautySetting getFaceBeautySetting() {
    return this.mDraft.g();
  }
  
  public PLMicrophoneSetting getMicrophoneSetting() {
    return this.mDraft.d();
  }
  
  public PLRecordSetting getRecordSetting() {
    return this.mDraft.h();
  }
  
  public int getSectionCount() {
    return this.mDraft.b().size();
  }
  
  public long getSectionDuration(int paramInt) {
    return isIndexValid(paramInt) ? ((h)this.mDraft.b().get(paramInt)).e : -1L;
  }
  
  public String getSectionFilePath(int paramInt) {
    return isIndexValid(paramInt) ? ((h)this.mDraft.b().get(paramInt)).a.getAbsolutePath() : null;
  }
  
  public long getSectionStartTime(int paramInt) {
    return isIndexValid(paramInt) ? ((h)this.mDraft.b().get(paramInt)).d : -1L;
  }
  
  public String getTag() {
    return this.mDraft.a();
  }
  
  public PLVideoEncodeSetting getVideoEncodeSetting() {
    return this.mDraft.e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLDraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */