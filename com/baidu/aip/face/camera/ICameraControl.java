package com.baidu.aip.face.camera;

import android.graphics.Rect;
import android.view.View;
import com.baidu.aip.face.PreviewView;

public interface ICameraControl<T> {
  public static final int CAMERA_FACING_BACK = 0;
  
  public static final int CAMERA_FACING_FRONT = 1;
  
  public static final int CAMERA_USB = 2;
  
  public static final int FLASH_MODE_AUTO = 2;
  
  public static final int FLASH_MODE_OFF = 0;
  
  public static final int FLASH_MODE_TORCH = 1;
  
  View getDisplayView();
  
  int getFlashMode();
  
  Rect getPreviewFrame();
  
  PreviewView getPreviewView();
  
  void pause();
  
  void refreshPermission();
  
  void resume();
  
  void setCameraFacing(int paramInt);
  
  void setDisplayOrientation(int paramInt);
  
  void setOnFrameListener(OnFrameListener paramOnFrameListener);
  
  void setPermissionCallback(PermissionCallback paramPermissionCallback);
  
  void setPreferredPreviewSize(int paramInt1, int paramInt2);
  
  void setPreviewView(PreviewView paramPreviewView);
  
  void start();
  
  void stop();
  
  public static @interface CameraFacing {}
  
  public static @interface FlashMode {}
  
  public static interface OnFrameListener<T> {
    void onPreviewFrame(T param1T, int param1Int1, int param1Int2, int param1Int3);
  }
  
  public static interface OnTakePictureCallback {
    void onPictureTaken(byte[] param1ArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\camera\ICameraControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */