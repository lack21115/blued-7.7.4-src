package org.chromium.media;

import android.os.Build;
import org.chromium.base.annotations.CalledByNative;

class VideoCaptureFactory {
  @CalledByNative
  static VideoCapture createVideoCapture(int paramInt, long paramLong) {
    return (VideoCapture)((isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(paramInt)) ? new VideoCaptureCamera2(paramInt, paramLong) : new VideoCaptureCamera(paramInt, paramLong));
  }
  
  @CalledByNative
  static int getCaptureApiType(int paramInt) {
    return isLReleaseOrLater() ? VideoCaptureCamera2.getCaptureApiType(paramInt) : VideoCaptureCamera.getCaptureApiType(paramInt);
  }
  
  @CalledByNative
  static int getCaptureFormatFramerate(VideoCaptureFormat paramVideoCaptureFormat) {
    return paramVideoCaptureFormat.mFramerate;
  }
  
  @CalledByNative
  static int getCaptureFormatHeight(VideoCaptureFormat paramVideoCaptureFormat) {
    return paramVideoCaptureFormat.mHeight;
  }
  
  @CalledByNative
  static int getCaptureFormatPixelFormat(VideoCaptureFormat paramVideoCaptureFormat) {
    return paramVideoCaptureFormat.mPixelFormat;
  }
  
  @CalledByNative
  static int getCaptureFormatWidth(VideoCaptureFormat paramVideoCaptureFormat) {
    return paramVideoCaptureFormat.mWidth;
  }
  
  @CalledByNative
  static String getDeviceName(int paramInt) {
    return (isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(paramInt)) ? VideoCaptureCamera2.getName(paramInt) : VideoCaptureCamera.getName(paramInt);
  }
  
  @CalledByNative
  static VideoCaptureFormat[] getDeviceSupportedFormats(int paramInt) {
    return (isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(paramInt)) ? VideoCaptureCamera2.getDeviceSupportedFormats(paramInt) : VideoCaptureCamera.getDeviceSupportedFormats(paramInt);
  }
  
  @CalledByNative
  static int getFacingMode(int paramInt) {
    return (isLReleaseOrLater() && !VideoCaptureCamera2.isLegacyDevice(paramInt)) ? VideoCaptureCamera2.getFacingMode(paramInt) : VideoCaptureCamera.getFacingMode(paramInt);
  }
  
  @CalledByNative
  static int getNumberOfCameras() {
    return VideoCaptureFactory$ChromiumCameraInfo.access$100();
  }
  
  private static boolean isLReleaseOrLater() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  @CalledByNative
  static boolean isLegacyOrDeprecatedDevice(int paramInt) {
    return (!isLReleaseOrLater() || VideoCaptureCamera2.isLegacyDevice(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */