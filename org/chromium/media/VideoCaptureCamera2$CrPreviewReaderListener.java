package org.chromium.media;

import android.media.Image;
import android.media.ImageReader;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import org.chromium.base.Log;

final class VideoCaptureCamera2$CrPreviewReaderListener implements ImageReader.OnImageAvailableListener {
  private VideoCaptureCamera2$CrPreviewReaderListener() {}
  
  public final void onImageAvailable(ImageReader paramImageReader) {
    try {
      Image image = paramImageReader.acquireLatestImage();
      Throwable throwable2 = null;
      if (image == null) {
        if (image != null)
          image.close(); 
        return;
      } 
      Throwable throwable1 = throwable2;
      try {
        if (image.getFormat() == 35) {
          throwable1 = throwable2;
          if ((image.getPlanes()).length == 3) {
            throwable1 = throwable2;
            if (paramImageReader.getWidth() == image.getWidth()) {
              throwable1 = throwable2;
              if (paramImageReader.getHeight() == image.getHeight()) {
                throwable1 = throwable2;
                VideoCaptureCamera2.this.nativeOnI420FrameAvailable(VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid, image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), image.getPlanes()[1].getBuffer(), image.getPlanes()[2].getBuffer(), image.getPlanes()[1].getRowStride(), image.getPlanes()[1].getPixelStride(), image.getWidth(), image.getHeight(), VideoCaptureCamera2.this.getCameraRotation(), image.getTimestamp());
                if (image != null) {
                  image.close();
                  return;
                } 
                return;
              } 
            } 
            throwable1 = throwable2;
            VideoCaptureCamera2 videoCaptureCamera21 = VideoCaptureCamera2.this;
            throwable1 = throwable2;
            long l1 = VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid;
            throwable1 = throwable2;
            StringBuilder stringBuilder1 = new StringBuilder("ImageReader size (");
            throwable1 = throwable2;
            stringBuilder1.append(paramImageReader.getWidth());
            throwable1 = throwable2;
            stringBuilder1.append("x");
            throwable1 = throwable2;
            stringBuilder1.append(paramImageReader.getHeight());
            throwable1 = throwable2;
            stringBuilder1.append(") did not match Image size (");
            throwable1 = throwable2;
            stringBuilder1.append(image.getWidth());
            throwable1 = throwable2;
            stringBuilder1.append("x");
            throwable1 = throwable2;
            stringBuilder1.append(image.getHeight());
            throwable1 = throwable2;
            stringBuilder1.append(")");
            throwable1 = throwable2;
            videoCaptureCamera21.nativeOnError(l1, stringBuilder1.toString());
            throwable1 = throwable2;
            throw new IllegalStateException();
          } 
        } 
        throwable1 = throwable2;
        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
        throwable1 = throwable2;
        long l = VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid;
        throwable1 = throwable2;
        StringBuilder stringBuilder = new StringBuilder("Unexpected image format: ");
        throwable1 = throwable2;
        stringBuilder.append(image.getFormat());
        throwable1 = throwable2;
        stringBuilder.append(" or #planes: ");
        throwable1 = throwable2;
        stringBuilder.append((image.getPlanes()).length);
        throwable1 = throwable2;
        videoCaptureCamera2.nativeOnError(l, stringBuilder.toString());
        throwable1 = throwable2;
        throw new IllegalStateException();
      } catch (Throwable throwable) {
        throwable1 = throwable;
        throw throwable;
      } finally {}
      if (image != null)
        if (throwable1 != null) {
          try {
            image.close();
          } catch (Throwable throwable) {
            ThrowableExtension.addSuppressed(throwable1, throwable);
          } 
        } else {
          image.close();
        }  
      throw paramImageReader;
    } catch (IllegalStateException illegalStateException) {
      Log.e("VideoCapture", "acquireLatestImage():", new Object[] { illegalStateException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CrPreviewReaderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */