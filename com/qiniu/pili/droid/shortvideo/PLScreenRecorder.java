package com.qiniu.pili.droid.shortvideo;

import android.app.Activity;
import android.content.Intent;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.g;

public final class PLScreenRecorder {
  public static final int REQUEST_CODE = 2008;
  
  private g mScreenRecorderCore;
  
  public PLScreenRecorder(Activity paramActivity) {
    this.mScreenRecorderCore = new g(paramActivity);
  }
  
  public void inputAudioFrame(byte[] paramArrayOfbyte, long paramLong) {
    this.mScreenRecorderCore.a(paramArrayOfbyte, paramLong);
  }
  
  public boolean isRecording() {
    return this.mScreenRecorderCore.d();
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    return this.mScreenRecorderCore.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean prepare(PLScreenRecorderSetting paramPLScreenRecorderSetting, PLMicrophoneSetting paramPLMicrophoneSetting) {
    return this.mScreenRecorderCore.a(paramPLScreenRecorderSetting, paramPLMicrophoneSetting);
  }
  
  public void requestScreenRecord() {
    this.mScreenRecorderCore.a();
  }
  
  public void setAudioFrameListener(PLAudioFrameListener paramPLAudioFrameListener) {
    this.mScreenRecorderCore.a(paramPLAudioFrameListener);
  }
  
  public void setRecordStateListener(PLScreenRecordStateListener paramPLScreenRecordStateListener) {
    this.mScreenRecorderCore.a(paramPLScreenRecordStateListener);
  }
  
  public void start() {
    this.mScreenRecorderCore.b();
    QosManager.a().a(this.mScreenRecorderCore.e());
  }
  
  public void stop() {
    this.mScreenRecorderCore.c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLScreenRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */