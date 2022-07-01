package com.qiniu.pili.droid.streaming;

import android.hardware.Camera;
import java.util.List;

public interface StreamingSessionListener {
  int onPreviewFpsSelected(List<int[]> paramList);
  
  Camera.Size onPreviewSizeSelected(List<Camera.Size> paramList);
  
  boolean onRecordAudioFailedHandled(int paramInt);
  
  boolean onRestartStreamingHandled(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\StreamingSessionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */