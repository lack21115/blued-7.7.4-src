package org.chromium.media;

import android.hardware.camera2.CameraDevice;
import org.chromium.base.Log;

final class VideoCaptureCamera2$CrStateListener extends CameraDevice.StateCallback {
  private VideoCaptureCamera2$CrStateListener() {}
  
  public final void onDisconnected(CameraDevice paramCameraDevice) {
    Log.e("VideoCapture", "cameraDevice was closed unexpectedly", new Object[0]);
    paramCameraDevice.close();
    VideoCaptureCamera2.access$002(VideoCaptureCamera2.this, (CameraDevice)null);
    VideoCaptureCamera2.access$100(VideoCaptureCamera2.this, VideoCaptureCamera2$CameraState.STOPPED);
  }
  
  public final void onError(CameraDevice paramCameraDevice, int paramInt) {
    Log.e("VideoCapture", "cameraDevice encountered an error", new Object[0]);
    paramCameraDevice.close();
    VideoCaptureCamera2.access$002(VideoCaptureCamera2.this, (CameraDevice)null);
    VideoCaptureCamera2.access$100(VideoCaptureCamera2.this, VideoCaptureCamera2$CameraState.STOPPED);
    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
    long l = VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid;
    StringBuilder stringBuilder = new StringBuilder("Camera device error ");
    stringBuilder.append(Integer.toString(paramInt));
    videoCaptureCamera2.nativeOnError(l, stringBuilder.toString());
  }
  
  public final void onOpened(CameraDevice paramCameraDevice) {
    VideoCaptureCamera2.access$002(VideoCaptureCamera2.this, paramCameraDevice);
    VideoCaptureCamera2.access$100(VideoCaptureCamera2.this, VideoCaptureCamera2$CameraState.CONFIGURING);
    if (VideoCaptureCamera2.access$200(VideoCaptureCamera2.this))
      return; 
    VideoCaptureCamera2.access$100(VideoCaptureCamera2.this, VideoCaptureCamera2$CameraState.STOPPED);
    VideoCaptureCamera2.this.nativeOnError(VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid, "Error configuring camera");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CrStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */