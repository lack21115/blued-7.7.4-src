package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.n;
import java.util.List;

public final class PLShortVideoMixRecorder {
  private n mShortVideoMixRecorderCore;
  
  public PLShortVideoMixRecorder(Context paramContext) {
    this.mShortVideoMixRecorderCore = new n(paramContext);
  }
  
  public boolean beginSection() {
    return beginSection(null);
  }
  
  public boolean beginSection(String paramString) {
    QosManager.a().a(QosManager.KeyPoint.record_video_mix);
    QosManager.a().a(QosManager.KeyPoint.record_section);
    return this.mShortVideoMixRecorderCore.a(paramString);
  }
  
  public void cancel() {
    this.mShortVideoMixRecorderCore.b();
  }
  
  public boolean deleteAllSections() {
    return this.mShortVideoMixRecorderCore.n();
  }
  
  public boolean deleteLastSection() {
    return this.mShortVideoMixRecorderCore.m();
  }
  
  public void destroy() {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean) {
    this.mShortVideoMixRecorderCore.b(paramBoolean);
  }
  
  public boolean endSection() {
    QosManager.a().a(this.mShortVideoMixRecorderCore.h());
    return this.mShortVideoMixRecorderCore.c();
  }
  
  public PLAudioMixMode getAudioMixMode() {
    return this.mShortVideoMixRecorderCore.a();
  }
  
  public PLBuiltinFilter[] getBuiltinFilterList() {
    return this.mShortVideoMixRecorderCore.u();
  }
  
  public int getMaxExposureCompensation() {
    return this.mShortVideoMixRecorderCore.y();
  }
  
  public int getMinExposureCompensation() {
    return this.mShortVideoMixRecorderCore.z();
  }
  
  public List<Float> getZooms() {
    return this.mShortVideoMixRecorderCore.A();
  }
  
  public boolean isFlashSupport() {
    return this.mShortVideoMixRecorderCore.x();
  }
  
  public void manualFocus(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mShortVideoMixRecorderCore.b(paramInt1, paramInt2, paramInt3, paramInt4);
    QosManager.a().a(QosManager.KeyPoint.record_focus);
  }
  
  public void muteMicrophone(boolean paramBoolean) {
    this.mShortVideoMixRecorderCore.c(paramBoolean);
  }
  
  public void muteSampleVideo(boolean paramBoolean) {
    this.mShortVideoMixRecorderCore.d(paramBoolean);
  }
  
  public void pause() {
    this.mShortVideoMixRecorderCore.k();
  }
  
  public void prepare(GLSurfaceView paramGLSurfaceView1, GLSurfaceView paramGLSurfaceView2, PLVideoMixSetting paramPLVideoMixSetting, PLCameraSetting paramPLCameraSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLFaceBeautySetting paramPLFaceBeautySetting, PLRecordSetting paramPLRecordSetting) {
    if (paramPLRecordSetting.IsRecordSpeedVariable())
      paramPLVideoEncodeSetting.setHWCodecEnabled(true); 
    this.mShortVideoMixRecorderCore.a(paramGLSurfaceView1, paramGLSurfaceView2, paramPLVideoMixSetting, paramPLCameraSetting, paramPLMicrophoneSetting, paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, paramPLFaceBeautySetting, paramPLRecordSetting);
    QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
    QosManager.a().a(QosManager.KeyPoint.record_camera_capture);
  }
  
  public void resume() {
    this.mShortVideoMixRecorderCore.j();
  }
  
  public void save(PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoMixRecorderCore.b(paramPLVideoSaveListener);
  }
  
  public final void setAudioFrameListener(PLAudioFrameListener paramPLAudioFrameListener) {
    this.mShortVideoMixRecorderCore.a(paramPLAudioFrameListener);
  }
  
  public void setAudioMixMode(PLAudioMixMode paramPLAudioMixMode) {
    this.mShortVideoMixRecorderCore.a(paramPLAudioMixMode);
  }
  
  public void setAudioMixVolume(float paramFloat1, float paramFloat2) {
    this.mShortVideoMixRecorderCore.a(paramFloat1, paramFloat2);
  }
  
  public void setBuiltinFilter(String paramString) {
    this.mShortVideoMixRecorderCore.b(paramString, true);
    QosManager.a().a(QosManager.KeyPoint.record_filter);
  }
  
  public final void setCameraParamSelectListener(PLCameraParamSelectListener paramPLCameraParamSelectListener) {
    this.mShortVideoMixRecorderCore.a(paramPLCameraParamSelectListener);
  }
  
  public final void setCameraPreviewListener(PLCameraPreviewListener paramPLCameraPreviewListener) {
    this.mShortVideoMixRecorderCore.a(paramPLCameraPreviewListener);
    QosManager.a().a(QosManager.KeyPoint.record_preview);
  }
  
  public void setExposureCompensation(int paramInt) {
    this.mShortVideoMixRecorderCore.c(paramInt);
    QosManager.a().a(QosManager.KeyPoint.record_exposure);
  }
  
  public void setExternalFilter(String paramString) {
    this.mShortVideoMixRecorderCore.b(paramString, false);
    QosManager.a().a(QosManager.KeyPoint.record_filter);
  }
  
  public boolean setFlashEnabled(boolean paramBoolean) {
    QosManager.a().a(QosManager.KeyPoint.record_flash);
    return paramBoolean ? this.mShortVideoMixRecorderCore.v() : this.mShortVideoMixRecorderCore.w();
  }
  
  public void setFocusListener(PLFocusListener paramPLFocusListener) {
    this.mShortVideoMixRecorderCore.a(paramPLFocusListener);
  }
  
  public final void setRecordStateListener(PLRecordStateListener paramPLRecordStateListener) {
    this.mShortVideoMixRecorderCore.a(paramPLRecordStateListener);
  }
  
  public void setTextureRotation(int paramInt) {
    this.mShortVideoMixRecorderCore.b(paramInt);
  }
  
  public final void setVideoFilterListener(PLVideoFilterListener paramPLVideoFilterListener) {
    setVideoFilterListener(paramPLVideoFilterListener, false);
  }
  
  public final void setVideoFilterListener(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    this.mShortVideoMixRecorderCore.a(paramPLVideoFilterListener, paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.record_custom_effect);
  }
  
  public void setWatermark(PLWatermarkSetting paramPLWatermarkSetting) {
    this.mShortVideoMixRecorderCore.a(paramPLWatermarkSetting);
    QosManager.a().a(QosManager.KeyPoint.record_watermark);
  }
  
  public void setZoom(float paramFloat) {
    this.mShortVideoMixRecorderCore.a(paramFloat);
    QosManager.a().a(QosManager.KeyPoint.record_zoom);
  }
  
  public void switchCamera() {
    this.mShortVideoMixRecorderCore.B();
    QosManager.a().a(QosManager.KeyPoint.record_switch_camera);
  }
  
  public void switchCamera(PLCameraSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    this.mShortVideoMixRecorderCore.a(paramCAMERA_FACING_ID);
  }
  
  public void updateFaceBeautySetting(PLFaceBeautySetting paramPLFaceBeautySetting) {
    this.mShortVideoMixRecorderCore.a(paramPLFaceBeautySetting);
    QosManager.a().a(QosManager.KeyPoint.record_beauty);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoMixRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */