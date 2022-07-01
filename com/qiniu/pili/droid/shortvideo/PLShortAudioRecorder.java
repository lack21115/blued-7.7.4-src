package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.j;

public final class PLShortAudioRecorder {
  private j mShortAudioRecorderCore = new j();
  
  public boolean beginSection() {
    return beginSection(null);
  }
  
  public boolean beginSection(String paramString) {
    QosManager.a().a(QosManager.KeyPoint.record_audio_only);
    QosManager.a().a(QosManager.KeyPoint.record_section);
    return this.mShortAudioRecorderCore.a(paramString);
  }
  
  public void cancelConcat() {
    this.mShortAudioRecorderCore.o();
  }
  
  public void concatSections(PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortAudioRecorderCore.a(paramPLVideoSaveListener);
  }
  
  public boolean deleteAllSections() {
    return this.mShortAudioRecorderCore.n();
  }
  
  public boolean deleteLastSection() {
    return this.mShortAudioRecorderCore.m();
  }
  
  public void destroy() {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean) {
    this.mShortAudioRecorderCore.b(paramBoolean);
  }
  
  public boolean endSection() {
    QosManager.a().a(this.mShortAudioRecorderCore.h());
    return this.mShortAudioRecorderCore.c();
  }
  
  public void pause() {
    this.mShortAudioRecorderCore.k();
  }
  
  public void prepare(Context paramContext, PLMicrophoneSetting paramPLMicrophoneSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    this.mShortAudioRecorderCore.a(paramContext, paramPLMicrophoneSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
    QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
  }
  
  public boolean recoverFromDraft(Context paramContext, PLDraft paramPLDraft) {
    QosManager.a().a(QosManager.KeyPoint.draftbox);
    return this.mShortAudioRecorderCore.a(paramContext, paramPLDraft.getDraft());
  }
  
  public void resume() {
    this.mShortAudioRecorderCore.j();
  }
  
  public boolean saveToDraftBox(String paramString) {
    QosManager.a().a(QosManager.KeyPoint.draftbox);
    return this.mShortAudioRecorderCore.c(paramString);
  }
  
  public final void setAudioFrameListener(PLAudioFrameListener paramPLAudioFrameListener) {
    this.mShortAudioRecorderCore.a(paramPLAudioFrameListener);
  }
  
  public final void setRecordStateListener(PLRecordStateListener paramPLRecordStateListener) {
    this.mShortAudioRecorderCore.a(paramPLRecordStateListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortAudioRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */