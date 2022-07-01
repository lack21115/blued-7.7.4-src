package org.chromium.media;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import org.chromium.base.Log;

final class VideoCaptureCamera2$CrPreviewSessionListener extends CameraCaptureSession.StateCallback {
  private final CaptureRequest mPreviewRequest;
  
  VideoCaptureCamera2$CrPreviewSessionListener(CaptureRequest paramCaptureRequest) {
    this.mPreviewRequest = paramCaptureRequest;
  }
  
  public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession) {
    VideoCaptureCamera2.access$100(VideoCaptureCamera2.this, VideoCaptureCamera2$CameraState.STOPPED);
    VideoCaptureCamera2.this.nativeOnError(VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid, "Camera session configuration error");
  }
  
  public final void onConfigured(CameraCaptureSession paramCameraCaptureSession) {
    VideoCaptureCamera2.access$302(VideoCaptureCamera2.this, paramCameraCaptureSession);
    try {
      VideoCaptureCamera2.access$300(VideoCaptureCamera2.this).setRepeatingRequest(this.mPreviewRequest, new VideoCaptureCamera2$CrPreviewSessionListener$1(this), null);
      VideoCaptureCamera2.this.nativeOnStarted(VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid);
      VideoCaptureCamera2.access$100(VideoCaptureCamera2.this, VideoCaptureCamera2$CameraState.STARTED);
      return;
    } catch (CameraAccessException|SecurityException|IllegalStateException|IllegalArgumentException cameraAccessException) {
      Log.e("VideoCapture", "setRepeatingRequest: ", new Object[] { cameraAccessException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CrPreviewSessionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */