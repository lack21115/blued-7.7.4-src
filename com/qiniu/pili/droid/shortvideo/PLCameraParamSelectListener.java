package com.qiniu.pili.droid.shortvideo;

import android.hardware.Camera;
import java.util.List;

public interface PLCameraParamSelectListener {
  String onFocusModeSelected(List<String> paramList);
  
  int[] onPreviewFpsSelected(List<int[]> paramList);
  
  Camera.Size onPreviewSizeSelected(List<Camera.Size> paramList);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLCameraParamSelectListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */