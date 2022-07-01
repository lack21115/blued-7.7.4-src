package com.qiniu.pili.droid.shortvideo;

import android.content.res.AssetFileDescriptor;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.p;
import java.util.List;

public final class PLShortVideoRecorder {
  private p mShortVideoCore = new p();
  
  public boolean beginSection() {
    return beginSection(null);
  }
  
  public boolean beginSection(String paramString) {
    QosManager.a().a(QosManager.KeyPoint.record_section);
    return this.mShortVideoCore.a(paramString);
  }
  
  public void cancelConcat() {
    this.mShortVideoCore.o();
  }
  
  public void captureFrame(PLCaptureFrameListener paramPLCaptureFrameListener) {
    captureFrame(paramPLCaptureFrameListener, true);
  }
  
  public void captureFrame(PLCaptureFrameListener paramPLCaptureFrameListener, boolean paramBoolean) {
    this.mShortVideoCore.a(paramPLCaptureFrameListener, paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_capture_frame);
  }
  
  public void concatSections(PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoCore.a(paramPLVideoSaveListener);
  }
  
  public boolean deleteAllSections() {
    return this.mShortVideoCore.n();
  }
  
  public boolean deleteLastSection() {
    return this.mShortVideoCore.m();
  }
  
  public void destroy() {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean) {
    this.mShortVideoCore.b(paramBoolean);
  }
  
  public boolean endSection() {
    QosManager.a().a(this.mShortVideoCore.h());
    return this.mShortVideoCore.c();
  }
  
  public PLBuiltinFilter[] getBuiltinFilterList() {
    return this.mShortVideoCore.u();
  }
  
  public int getMaxExposureCompensation() {
    return this.mShortVideoCore.y();
  }
  
  public int getMinExposureCompensation() {
    return this.mShortVideoCore.z();
  }
  
  public int getMusicPosition() {
    return this.mShortVideoCore.p();
  }
  
  public List<Float> getZooms() {
    return this.mShortVideoCore.A();
  }
  
  public boolean isFlashSupport() {
    return this.mShortVideoCore.x();
  }
  
  public void manualFocus(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mShortVideoCore.b(paramInt1, paramInt2, paramInt3, paramInt4);
    QosManager.a().a(QosManager.KeyPoint.record_focus);
  }
  
  public void mute(boolean paramBoolean) {
    this.mShortVideoCore.a(paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_mute);
  }
  
  public void pause() {
    this.mShortVideoCore.k();
  }
  
  public void prepare(GLSurfaceView paramGLSurfaceView, PLCameraSetting paramPLCameraSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLFaceBeautySetting paramPLFaceBeautySetting, PLRecordSetting paramPLRecordSetting) {
    if (paramPLRecordSetting.IsRecordSpeedVariable())
      paramPLVideoEncodeSetting.setHWCodecEnabled(true); 
    this.mShortVideoCore.a(paramGLSurfaceView, paramPLCameraSetting, paramPLMicrophoneSetting, paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, paramPLFaceBeautySetting, paramPLRecordSetting);
    QosManager.a().a(QosManager.KeyPoint.record_init);
  }
  
  public void prepare(GLSurfaceView paramGLSurfaceView, PLCameraSetting paramPLCameraSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    if (paramPLRecordSetting.IsRecordSpeedVariable())
      paramPLVideoEncodeSetting.setHWCodecEnabled(true); 
    this.mShortVideoCore.a(paramGLSurfaceView, paramPLCameraSetting, paramPLMicrophoneSetting, paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, null, paramPLRecordSetting);
    QosManager.a().a(QosManager.KeyPoint.record_init);
    QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
    QosManager.a().a(QosManager.KeyPoint.record_camera_capture);
  }
  
  public boolean recoverFromDraft(GLSurfaceView paramGLSurfaceView, PLDraft paramPLDraft) {
    QosManager.a().a(QosManager.KeyPoint.draftbox);
    return this.mShortVideoCore.a(paramGLSurfaceView, paramPLDraft.getDraft());
  }
  
  public void resume() {
    this.mShortVideoCore.j();
  }
  
  public boolean saveToDraftBox(String paramString) {
    QosManager.a().a(QosManager.KeyPoint.draftbox);
    return this.mShortVideoCore.c(paramString);
  }
  
  public final void setAudioFrameListener(PLAudioFrameListener paramPLAudioFrameListener) {
    this.mShortVideoCore.a(paramPLAudioFrameListener);
  }
  
  public void setBuiltinFilter(String paramString) {
    this.mShortVideoCore.b(paramString, true);
    QosManager.a().a(QosManager.KeyPoint.record_filter);
  }
  
  public final void setCameraParamSelectListener(PLCameraParamSelectListener paramPLCameraParamSelectListener) {
    this.mShortVideoCore.a(paramPLCameraParamSelectListener);
  }
  
  public final void setCameraPreviewListener(PLCameraPreviewListener paramPLCameraPreviewListener) {
    this.mShortVideoCore.a(paramPLCameraPreviewListener);
    QosManager.a().a(QosManager.KeyPoint.record_preview);
  }
  
  public void setEffectPlugin(PLEffectPlugin paramPLEffectPlugin) {
    this.mShortVideoCore.a(paramPLEffectPlugin);
  }
  
  public void setExposureCompensation(int paramInt) {
    this.mShortVideoCore.c(paramInt);
    QosManager.a().a(QosManager.KeyPoint.record_exposure);
  }
  
  public void setExternalFilter(String paramString) {
    this.mShortVideoCore.b(paramString, false);
    QosManager.a().a(QosManager.KeyPoint.record_filter);
  }
  
  public boolean setFlashEnabled(boolean paramBoolean) {
    QosManager.a().a(QosManager.KeyPoint.record_flash);
    return paramBoolean ? this.mShortVideoCore.v() : this.mShortVideoCore.w();
  }
  
  public void setFocusListener(PLFocusListener paramPLFocusListener) {
    this.mShortVideoCore.a(paramPLFocusListener);
  }
  
  public void setMirrorForEncode(boolean paramBoolean) {
    this.mShortVideoCore.f(paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_mirror);
  }
  
  public void setMirrorForPreview(boolean paramBoolean) {
    this.mShortVideoCore.e(paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_mirror);
  }
  
  public void setMusicAsset(AssetFileDescriptor paramAssetFileDescriptor) {
    this.mShortVideoCore.a(paramAssetFileDescriptor);
    QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
  }
  
  public void setMusicFile(String paramString) {
    this.mShortVideoCore.b(paramString);
    QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
  }
  
  public void setMusicPosition(int paramInt) {
    this.mShortVideoCore.a(paramInt);
  }
  
  public void setRecordSpeed(double paramDouble) {
    this.mShortVideoCore.a(paramDouble);
    QosManager.a().a(QosManager.KeyPoint.record_speed);
  }
  
  public final void setRecordStateListener(PLRecordStateListener paramPLRecordStateListener) {
    this.mShortVideoCore.a(paramPLRecordStateListener);
  }
  
  public void setTextureRotation(int paramInt) {
    this.mShortVideoCore.b(paramInt);
  }
  
  public void setTextureScale(float paramFloat1, float paramFloat2) {
    this.mShortVideoCore.b(paramFloat1, paramFloat2);
  }
  
  public final void setVideoFilterListener(PLVideoFilterListener paramPLVideoFilterListener) {
    setVideoFilterListener(paramPLVideoFilterListener, false);
  }
  
  public final void setVideoFilterListener(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    this.mShortVideoCore.a(paramPLVideoFilterListener, paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_custom_effect);
  }
  
  public void setWatermark(PLWatermarkSetting paramPLWatermarkSetting) {
    this.mShortVideoCore.a(paramPLWatermarkSetting);
    QosManager.a().a(QosManager.KeyPoint.record_watermark);
  }
  
  public void setZoom(float paramFloat) {
    this.mShortVideoCore.a(paramFloat);
    QosManager.a().a(QosManager.KeyPoint.record_zoom);
  }
  
  public void switchCamera() {
    this.mShortVideoCore.B();
    QosManager.a().a(QosManager.KeyPoint.record_switch_camera);
  }
  
  public void switchCamera(PLCameraSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    this.mShortVideoCore.a(paramCAMERA_FACING_ID);
    QosManager.a().a(QosManager.KeyPoint.record_switch_camera);
  }
  
  public void updateFaceBeautySetting(PLFaceBeautySetting paramPLFaceBeautySetting) {
    this.mShortVideoCore.a(paramPLFaceBeautySetting);
    QosManager.a().a(QosManager.KeyPoint.record_beauty);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */