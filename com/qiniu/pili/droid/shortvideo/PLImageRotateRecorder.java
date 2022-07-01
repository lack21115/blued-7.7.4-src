package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.f;

public final class PLImageRotateRecorder {
  private f mImageRotateRecorderCore = new f();
  
  public boolean beginSection() {
    return beginSection(null);
  }
  
  public boolean beginSection(String paramString) {
    QosManager.a().a(this.mImageRotateRecorderCore.h());
    QosManager.a().a(QosManager.KeyPoint.record_image_rotate);
    QosManager.a().a(QosManager.KeyPoint.record_section);
    return this.mImageRotateRecorderCore.a(paramString);
  }
  
  public void cancelConcat() {
    this.mImageRotateRecorderCore.o();
  }
  
  public void concatSections(PLVideoSaveListener paramPLVideoSaveListener) {
    this.mImageRotateRecorderCore.a(paramPLVideoSaveListener);
  }
  
  public boolean deleteAllSections() {
    return this.mImageRotateRecorderCore.n();
  }
  
  public boolean deleteLastSection() {
    return this.mImageRotateRecorderCore.m();
  }
  
  public void destroy() {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean) {
    this.mImageRotateRecorderCore.b(paramBoolean);
  }
  
  public boolean endSection() {
    QosManager.a().a(this.mImageRotateRecorderCore.h());
    return this.mImageRotateRecorderCore.c();
  }
  
  public int getMusicPosition() {
    return this.mImageRotateRecorderCore.p();
  }
  
  public void mute(boolean paramBoolean) {
    this.mImageRotateRecorderCore.a(paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_mute);
  }
  
  public void pause() {
    this.mImageRotateRecorderCore.k();
  }
  
  public void prepare(Context paramContext, PLImageRotateSetting paramPLImageRotateSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    this.mImageRotateRecorderCore.a(paramContext, paramPLImageRotateSetting, paramPLMicrophoneSetting, paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
    QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
  }
  
  public void resume() {
    this.mImageRotateRecorderCore.j();
  }
  
  public final void setAudioFrameListener(PLAudioFrameListener paramPLAudioFrameListener) {
    this.mImageRotateRecorderCore.a(paramPLAudioFrameListener);
  }
  
  public void setMusicAsset(AssetFileDescriptor paramAssetFileDescriptor) {
    this.mImageRotateRecorderCore.a(paramAssetFileDescriptor);
    QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
  }
  
  public void setMusicFile(String paramString) {
    this.mImageRotateRecorderCore.b(paramString);
    QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
  }
  
  public void setMusicPosition(int paramInt) {
    this.mImageRotateRecorderCore.a(paramInt);
  }
  
  public void setRecordSpeed(double paramDouble) {
    this.mImageRotateRecorderCore.a(paramDouble);
    QosManager.a().a(QosManager.KeyPoint.record_speed);
  }
  
  public final void setRecordStateListener(PLRecordStateListener paramPLRecordStateListener) {
    this.mImageRotateRecorderCore.a(paramPLRecordStateListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLImageRotateRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */