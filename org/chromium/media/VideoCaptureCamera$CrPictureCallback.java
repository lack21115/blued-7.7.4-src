package org.chromium.media;

import android.hardware.Camera;
import org.chromium.base.Log;

final class VideoCaptureCamera$CrPictureCallback implements Camera.PictureCallback {
  private VideoCaptureCamera$CrPictureCallback() {}
  
  public final void onPictureTaken(byte[] paramArrayOfbyte, Camera paramCamera) {
    try {
      VideoCaptureCamera.access$200(VideoCaptureCamera.this).flatten();
      paramCamera.setParameters(VideoCaptureCamera.access$200(VideoCaptureCamera.this));
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder("onPictureTaken, setParameters() ");
      stringBuilder.append(runtimeException);
      Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
    } 
    try {
      paramCamera.startPreview();
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder("onPictureTaken, startPreview() ");
      stringBuilder.append(runtimeException);
      Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
    } 
    synchronized (VideoCaptureCamera.access$000(VideoCaptureCamera.this)) {
      if (VideoCaptureCamera.access$100(VideoCaptureCamera.this) != 0L)
        VideoCaptureCamera.this.nativeOnPhotoTaken(VideoCaptureCamera.this.mNativeVideoCaptureDeviceAndroid, VideoCaptureCamera.access$100(VideoCaptureCamera.this), paramArrayOfbyte); 
      VideoCaptureCamera.access$102(VideoCaptureCamera.this, 0L);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera$CrPictureCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */