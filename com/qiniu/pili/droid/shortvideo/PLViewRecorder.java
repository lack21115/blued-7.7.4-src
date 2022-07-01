package com.qiniu.pili.droid.shortvideo;

import android.content.res.AssetFileDescriptor;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.t;

public final class PLViewRecorder {
  private t mViewRecorderCore = new t();
  
  public boolean beginSection() {
    return beginSection(null);
  }
  
  public boolean beginSection(String paramString) {
    QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
    QosManager.a().a(QosManager.KeyPoint.record_section);
    return this.mViewRecorderCore.a(paramString);
  }
  
  public void cancelConcat() {
    this.mViewRecorderCore.o();
  }
  
  public void concatSections(PLVideoSaveListener paramPLVideoSaveListener) {
    this.mViewRecorderCore.a(paramPLVideoSaveListener);
  }
  
  public boolean deleteAllSections() {
    return this.mViewRecorderCore.n();
  }
  
  public boolean deleteLastSection() {
    return this.mViewRecorderCore.m();
  }
  
  public void destroy() {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean) {
    this.mViewRecorderCore.b(paramBoolean);
  }
  
  public boolean endSection() {
    QosManager.a().a(this.mViewRecorderCore.h());
    return this.mViewRecorderCore.c();
  }
  
  public long getCurrentSectionDurationMs() {
    return this.mViewRecorderCore.u();
  }
  
  public int getMusicPosition() {
    return this.mViewRecorderCore.p();
  }
  
  public void mute(boolean paramBoolean) {
    this.mViewRecorderCore.a(paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_mute);
  }
  
  public void pause() {
    this.mViewRecorderCore.k();
  }
  
  public void prepare(View paramView, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    this.mViewRecorderCore.a(paramView, paramPLMicrophoneSetting, paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
  }
  
  public void resume() {
    this.mViewRecorderCore.j();
  }
  
  public final void setAudioFrameListener(PLAudioFrameListener paramPLAudioFrameListener) {
    this.mViewRecorderCore.a(paramPLAudioFrameListener);
  }
  
  public void setMusicAsset(AssetFileDescriptor paramAssetFileDescriptor) {
    this.mViewRecorderCore.a(paramAssetFileDescriptor);
    QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
  }
  
  public void setMusicFile(String paramString) {
    this.mViewRecorderCore.b(paramString);
    QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
  }
  
  public void setMusicPosition(int paramInt) {
    this.mViewRecorderCore.a(paramInt);
  }
  
  public void setRecordSpeed(double paramDouble) {
    this.mViewRecorderCore.a(paramDouble);
    QosManager.a().a(QosManager.KeyPoint.record_speed);
  }
  
  public final void setRecordStateListener(PLRecordStateListener paramPLRecordStateListener) {
    this.mViewRecorderCore.a(paramPLRecordStateListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLViewRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */