package com.qiniu.pili.droid.shortvideo;

import android.content.res.AssetFileDescriptor;
import android.opengl.GLSurfaceView;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.m;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.util.List;

public class PLShortVideoEditor {
  private PLVideoEditSetting mEditSetting;
  
  private m mShortVideoEditorCore;
  
  public PLShortVideoEditor(GLSurfaceView paramGLSurfaceView) {
    this.mShortVideoEditorCore = new m(paramGLSurfaceView);
    QosManager.a().a(QosManager.KeyPoint.editor_init);
  }
  
  public PLShortVideoEditor(GLSurfaceView paramGLSurfaceView, PLVideoEditSetting paramPLVideoEditSetting) {
    this.mEditSetting = paramPLVideoEditSetting;
    this.mShortVideoEditorCore = new m(paramGLSurfaceView, paramPLVideoEditSetting);
    QosManager.a().a(QosManager.KeyPoint.editor_init);
  }
  
  public void addGifWatermark(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    this.mShortVideoEditorCore.a(paramPLGifWatermarkSetting);
    QosManager.a().a(QosManager.KeyPoint.edit_image);
  }
  
  public void addImageView(PLImageView paramPLImageView) {
    this.mShortVideoEditorCore.a(paramPLImageView);
    QosManager.a().a(QosManager.KeyPoint.edit_image);
  }
  
  public void addMixAudioFile(PLMixAudioFile paramPLMixAudioFile) {
    this.mShortVideoEditorCore.b(paramPLMixAudioFile);
    QosManager.a().a(QosManager.KeyPoint.edit_audio_mix);
  }
  
  public void addPaintView(PLPaintView paramPLPaintView) {
    this.mShortVideoEditorCore.a(paramPLPaintView);
    QosManager.a().a(QosManager.KeyPoint.edit_paint);
  }
  
  public void addTextView(PLTextView paramPLTextView) {
    this.mShortVideoEditorCore.a(paramPLTextView);
    QosManager.a().a(QosManager.KeyPoint.edit_text);
  }
  
  public void cancelSave() {
    this.mShortVideoEditorCore.h();
  }
  
  public int getAudioMixFileDuration() {
    return this.mShortVideoEditorCore.f();
  }
  
  public PLBuiltinFilter[] getBuiltinFilterList() {
    return this.mShortVideoEditorCore.e();
  }
  
  public int getCurrentPosition() {
    return this.mShortVideoEditorCore.b();
  }
  
  public long getDurationMs() {
    PLVideoEditSetting pLVideoEditSetting = this.mEditSetting;
    return (pLVideoEditSetting != null) ? g.a(pLVideoEditSetting.getSourceFilepath()) : -1L;
  }
  
  public void muteOriginAudio(boolean paramBoolean) {
    this.mShortVideoEditorCore.c(paramBoolean);
  }
  
  public void pausePlayback() {
    this.mShortVideoEditorCore.c();
  }
  
  public void removeGifWatermark(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    this.mShortVideoEditorCore.b(paramPLGifWatermarkSetting);
  }
  
  public void removeImageView(PLImageView paramPLImageView) {
    this.mShortVideoEditorCore.b(paramPLImageView);
  }
  
  public void removeMixAudioFile(PLMixAudioFile paramPLMixAudioFile) {
    this.mShortVideoEditorCore.a(paramPLMixAudioFile);
  }
  
  public void removePaintView(PLPaintView paramPLPaintView) {
    this.mShortVideoEditorCore.b(paramPLPaintView);
  }
  
  public void removeTextView(PLTextView paramPLTextView) {
    this.mShortVideoEditorCore.b(paramPLTextView);
  }
  
  public void resumePlayback() {
    this.mShortVideoEditorCore.a();
  }
  
  public void save() {
    save(null);
  }
  
  public void save(PLVideoFilterListener paramPLVideoFilterListener) {
    save(paramPLVideoFilterListener, false);
  }
  
  public void save(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    QosManager.a().a(this.mShortVideoEditorCore.i());
    this.mShortVideoEditorCore.b(paramPLVideoFilterListener, paramBoolean);
  }
  
  public void seekTo(int paramInt) {
    this.mShortVideoEditorCore.a(paramInt);
  }
  
  public void setAudioMixAsset(AssetFileDescriptor paramAssetFileDescriptor) {
    this.mShortVideoEditorCore.a(paramAssetFileDescriptor);
    QosManager.a().a(QosManager.KeyPoint.edit_audio_mix);
  }
  
  public void setAudioMixFile(String paramString) {
    this.mShortVideoEditorCore.a(paramString);
    QosManager.a().a(QosManager.KeyPoint.edit_audio_mix);
  }
  
  public void setAudioMixFileRange(long paramLong1, long paramLong2) {
    this.mShortVideoEditorCore.b(paramLong1, paramLong2);
  }
  
  public void setAudioMixLooping(boolean paramBoolean) {
    this.mShortVideoEditorCore.b(paramBoolean);
  }
  
  public void setAudioMixVolume(float paramFloat1, float paramFloat2) {
    this.mShortVideoEditorCore.a(paramFloat1, paramFloat2);
  }
  
  public void setBuiltinFilter(String paramString) {
    this.mShortVideoEditorCore.a(paramString, true);
    QosManager.a().a(QosManager.KeyPoint.edit_filter);
  }
  
  public void setDisplayMode(PLDisplayMode paramPLDisplayMode) {
    this.mShortVideoEditorCore.a(paramPLDisplayMode);
  }
  
  public void setEffectPlugin(PLEffectPlugin paramPLEffectPlugin) {
    this.mShortVideoEditorCore.a(paramPLEffectPlugin);
  }
  
  public void setExternalFilter(String paramString) {
    this.mShortVideoEditorCore.a(paramString, false);
    QosManager.a().a(QosManager.KeyPoint.edit_filter);
  }
  
  public void setMVEffect(String paramString1, String paramString2) {
    this.mShortVideoEditorCore.a(paramString1, paramString2);
    QosManager.a().a(QosManager.KeyPoint.edit_mv);
  }
  
  public void setPlaybackLoop(boolean paramBoolean) {
    this.mShortVideoEditorCore.a(paramBoolean);
  }
  
  public void setRotation(int paramInt) {
    this.mShortVideoEditorCore.b(paramInt);
    QosManager.a().a(QosManager.KeyPoint.edit_rotate);
  }
  
  public void setSpeed(double paramDouble) {
    this.mShortVideoEditorCore.a(paramDouble);
    QosManager.a().a(QosManager.KeyPoint.edit_speed);
  }
  
  public void setSpeed(double paramDouble, boolean paramBoolean) {
    this.mShortVideoEditorCore.a(paramDouble, paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.edit_speed);
  }
  
  public void setSpeedTimeRanges(List<PLSpeedTimeRange> paramList) {
    this.mShortVideoEditorCore.a(paramList);
    QosManager.a().a(QosManager.KeyPoint.edit_speed);
  }
  
  public void setVideoEditSetting(PLVideoEditSetting paramPLVideoEditSetting) {
    this.mEditSetting = paramPLVideoEditSetting;
    this.mShortVideoEditorCore.a(paramPLVideoEditSetting);
  }
  
  public void setVideoEncodeSetting(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.mShortVideoEditorCore.a(paramPLVideoEncodeSetting);
  }
  
  public void setVideoPlayerListener(PLVideoPlayerListener paramPLVideoPlayerListener) {
    this.mShortVideoEditorCore.a(paramPLVideoPlayerListener);
  }
  
  public void setVideoRange(long paramLong1, long paramLong2) {
    this.mShortVideoEditorCore.a(paramLong1, paramLong2);
  }
  
  public void setVideoSaveListener(PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoEditorCore.a(paramPLVideoSaveListener);
  }
  
  public void setViewTimeline(View paramView, long paramLong1, long paramLong2) {
    this.mShortVideoEditorCore.a(paramView, paramLong1, paramLong2);
  }
  
  public void setWatermark(PLWatermarkSetting paramPLWatermarkSetting) {
    this.mShortVideoEditorCore.a(paramPLWatermarkSetting);
    QosManager.a().a(QosManager.KeyPoint.edit_watermark);
  }
  
  public void startPlayback() {
    startPlayback(null);
  }
  
  public void startPlayback(PLVideoFilterListener paramPLVideoFilterListener) {
    startPlayback(paramPLVideoFilterListener, false);
  }
  
  public void startPlayback(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    this.mShortVideoEditorCore.a(paramPLVideoFilterListener, paramBoolean);
    QosManager.a().a(QosManager.KeyPoint.edit_preview);
  }
  
  public void stopPlayback() {
    this.mShortVideoEditorCore.d();
  }
  
  public void updateGifWatermark(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    this.mShortVideoEditorCore.c(paramPLGifWatermarkSetting);
  }
  
  public void updatePreviewWatermark(PLWatermarkSetting paramPLWatermarkSetting) {
    this.mShortVideoEditorCore.c(paramPLWatermarkSetting);
  }
  
  public void updateSaveWatermark(PLWatermarkSetting paramPLWatermarkSetting) {
    this.mShortVideoEditorCore.b(paramPLWatermarkSetting);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */