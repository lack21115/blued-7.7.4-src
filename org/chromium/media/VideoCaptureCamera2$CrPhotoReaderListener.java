package org.chromium.media;

import android.media.Image;
import android.media.ImageReader;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.nio.ByteBuffer;
import org.chromium.base.Log;

final class VideoCaptureCamera2$CrPhotoReaderListener implements ImageReader.OnImageAvailableListener {
  private final long mCallbackId;
  
  VideoCaptureCamera2$CrPhotoReaderListener(long paramLong) {
    this.mCallbackId = paramLong;
  }
  
  private static byte[] readCapturedData(Image paramImage) {
    try {
      return paramImage.getPlanes()[0].getBuffer().array();
    } catch (UnsupportedOperationException unsupportedOperationException) {
      ByteBuffer byteBuffer = paramImage.getPlanes()[0].getBuffer();
      byte[] arrayOfByte = new byte[byteBuffer.remaining()];
      try {
        return arrayOfByte;
      } finally {
        byteBuffer = null;
      } 
    } finally {}
    return null;
  }
  
  public final void onImageAvailable(ImageReader paramImageReader) {
    try {
      Image image = paramImageReader.acquireLatestImage();
      ImageReader imageReader = null;
      if (image != null) {
        paramImageReader = imageReader;
        try {
          if (image.getFormat() == 256) {
            paramImageReader = imageReader;
            byte[] arrayOfByte = readCapturedData(image);
            paramImageReader = imageReader;
            VideoCaptureCamera2.this.nativeOnPhotoTaken(VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid, this.mCallbackId, arrayOfByte);
            if (image != null)
              image.close(); 
            if (VideoCaptureCamera2.access$200(VideoCaptureCamera2.this))
              return; 
            VideoCaptureCamera2.this.nativeOnError(VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid, "Error restarting preview");
            return;
          } 
          paramImageReader = imageReader;
          Log.e("VideoCapture", "Unexpected image format: %d", new Object[] { Integer.valueOf(image.getFormat()) });
          paramImageReader = imageReader;
          throw new IllegalStateException();
        } catch (Throwable throwable2) {
          Throwable throwable1 = throwable2;
          throw throwable2;
        } finally {}
      } else {
        paramImageReader = imageReader;
        throw new IllegalStateException();
      } 
      if (image != null)
        if (paramImageReader != null) {
          try {
            image.close();
          } catch (Throwable throwable) {
            ThrowableExtension.addSuppressed((Throwable)paramImageReader, throwable);
          } 
        } else {
          throwable.close();
        }  
      throw imageReader;
    } catch (IllegalStateException illegalStateException) {
      VideoCaptureCamera2.access$500(VideoCaptureCamera2.this, this.mCallbackId);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CrPhotoReaderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */