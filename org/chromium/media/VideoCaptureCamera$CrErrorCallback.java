package org.chromium.media;

import android.hardware.Camera;

final class VideoCaptureCamera$CrErrorCallback implements Camera.ErrorCallback {
  private VideoCaptureCamera$CrErrorCallback() {}
  
  public final void onError(int paramInt, Camera paramCamera) {
    VideoCaptureCamera videoCaptureCamera = VideoCaptureCamera.this;
    long l = VideoCaptureCamera.this.mNativeVideoCaptureDeviceAndroid;
    null = new StringBuilder("Error id: ");
    null.append(paramInt);
    videoCaptureCamera.nativeOnError(l, null.toString());
    synchronized (VideoCaptureCamera.access$000(VideoCaptureCamera.this)) {
      if (VideoCaptureCamera.access$100(VideoCaptureCamera.this) == 0L)
        return; 
      VideoCaptureCamera.this.nativeOnPhotoTaken(VideoCaptureCamera.this.mNativeVideoCaptureDeviceAndroid, VideoCaptureCamera.access$100(VideoCaptureCamera.this), new byte[0]);
      VideoCaptureCamera.access$102(VideoCaptureCamera.this, 0L);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera$CrErrorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */