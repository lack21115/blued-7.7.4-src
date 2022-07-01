package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.d;

public class PLExternalMediaRecorder {
  private d mExternalMediaRecorderCore;
  
  public PLExternalMediaRecorder(Context paramContext) {
    this.mExternalMediaRecorderCore = new d(paramContext);
  }
  
  public void inputAudioFrame(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    this.mExternalMediaRecorderCore.a(paramArrayOfbyte, paramInt, paramLong);
  }
  
  public void inputVideoFrame(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    this.mExternalMediaRecorderCore.a(paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public boolean isRecording() {
    return this.mExternalMediaRecorderCore.c();
  }
  
  public boolean prepare(PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    return this.mExternalMediaRecorderCore.a(paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
  }
  
  public void setRecordStateListener(PLExternalRecordStateListener paramPLExternalRecordStateListener) {
    this.mExternalMediaRecorderCore.a(paramPLExternalRecordStateListener);
  }
  
  public void start() {
    this.mExternalMediaRecorderCore.a();
    QosManager.a().a(QosManager.KeyPoint.record_external_media);
    QosManager.a().a(this.mExternalMediaRecorderCore.d());
  }
  
  public void stop() {
    this.mExternalMediaRecorderCore.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLExternalMediaRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */