package org.chromium.media;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import org.chromium.base.Log;

final class VideoCaptureCamera2$CrPhotoSessionListener extends CameraCaptureSession.StateCallback {
  private final long mCallbackId;
  
  private final ImageReader mImageReader;
  
  private final CaptureRequest mPhotoRequest;
  
  VideoCaptureCamera2$CrPhotoSessionListener(ImageReader paramImageReader, CaptureRequest paramCaptureRequest, long paramLong) {
    this.mImageReader = paramImageReader;
    this.mPhotoRequest = paramCaptureRequest;
    this.mCallbackId = paramLong;
  }
  
  public final void onClosed(CameraCaptureSession paramCameraCaptureSession) {
    this.mImageReader.close();
  }
  
  public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession) {
    Log.e("VideoCapture", "failed configuring capture session", new Object[0]);
    VideoCaptureCamera2.access$500(VideoCaptureCamera2.this, this.mCallbackId);
  }
  
  public final void onConfigured(CameraCaptureSession paramCameraCaptureSession) {
    try {
      paramCameraCaptureSession.capture(this.mPhotoRequest, null, null);
      return;
    } catch (CameraAccessException cameraAccessException) {
      Log.e("VideoCapture", "capture() CameraAccessException", new Object[] { cameraAccessException });
      VideoCaptureCamera2.access$500(VideoCaptureCamera2.this, this.mCallbackId);
      return;
    } catch (IllegalStateException illegalStateException) {
      Log.e("VideoCapture", "capture() IllegalStateException", new Object[] { illegalStateException });
      VideoCaptureCamera2.access$500(VideoCaptureCamera2.this, this.mCallbackId);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CrPhotoSessionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */