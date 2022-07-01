package com.blued.android.module.shortvideo.utils;

import android.hardware.Camera;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;

public class StvCameraUtils {
  public static int a(PLCameraSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    return paramCAMERA_FACING_ID.ordinal() % b();
  }
  
  public static PLCameraSetting.CAMERA_FACING_ID a() {
    int i = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
    int j = b();
    if (j != 0)
      i = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal() % j; 
    return (i == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal()) ? PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT : PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
  }
  
  public static PLCameraSetting.CAMERA_FACING_ID a(int paramInt) {
    int i = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
    return (paramInt % b() == i) ? PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT : PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
  }
  
  public static int b() {
    return Camera.getNumberOfCameras();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvCameraUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */