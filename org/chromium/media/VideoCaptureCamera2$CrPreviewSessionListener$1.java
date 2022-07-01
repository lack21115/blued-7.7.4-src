package org.chromium.media;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;

final class VideoCaptureCamera2$CrPreviewSessionListener$1 extends CameraCaptureSession.CaptureCallback {
  public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult) {
    Long long_ = (Long)paramTotalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
    if (long_ == null)
      return; 
    VideoCaptureCamera2.access$402(this.this$1.this$0, long_.longValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CrPreviewSessionListener$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */