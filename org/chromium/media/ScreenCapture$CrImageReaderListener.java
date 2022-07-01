package org.chromium.media;

import android.media.Image;
import android.media.ImageReader;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import org.chromium.base.Log;

final class ScreenCapture$CrImageReaderListener implements ImageReader.OnImageAvailableListener {
  private ScreenCapture$CrImageReaderListener() {}
  
  public final void onImageAvailable(ImageReader paramImageReader) {
    synchronized (ScreenCapture.access$000(ScreenCapture.this)) {
      if (ScreenCapture.access$100(ScreenCapture.this) != ScreenCapture$CaptureState.STARTED) {
        Log.e("cr_ScreenCapture", "Get captured frame in unexpected state.", new Object[0]);
        return;
      } 
      if (ScreenCapture.access$200(ScreenCapture.this)) {
        ScreenCapture.access$300(ScreenCapture.this);
        ScreenCapture.access$400(ScreenCapture.this);
        return;
      } 
      try {
        Image image = paramImageReader.acquireLatestImage();
        Object object = null;
        if (image == null) {
          if (image != null)
            image.close(); 
          return;
        } 
        null = object;
        try {
          StringBuilder stringBuilder1;
          if (paramImageReader.getWidth() == image.getWidth()) {
            null = object;
            if (paramImageReader.getHeight() == image.getHeight()) {
              null = object;
              int i = image.getFormat();
              if (i != 1) {
                if (i == 35) {
                  null = object;
                  if ((image.getPlanes()).length == 3) {
                    null = object;
                    ScreenCapture.access$700(ScreenCapture.this, ScreenCapture.access$500(ScreenCapture.this), image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), image.getPlanes()[1].getBuffer(), image.getPlanes()[2].getBuffer(), image.getPlanes()[1].getRowStride(), image.getPlanes()[1].getPixelStride(), (image.getCropRect()).left, (image.getCropRect()).top, image.getCropRect().width(), image.getCropRect().height(), image.getTimestamp());
                  } else {
                    null = object;
                    stringBuilder1 = new StringBuilder("Unexpected image planes for YUV_420_888 format: ");
                    null = object;
                    stringBuilder1.append((image.getPlanes()).length);
                    null = object;
                    Log.e("cr_ScreenCapture", stringBuilder1.toString(), new Object[0]);
                    null = object;
                    throw new IllegalStateException();
                  } 
                } else {
                  null = object;
                  stringBuilder1 = new StringBuilder("Unexpected image format: ");
                  null = object;
                  stringBuilder1.append(image.getFormat());
                  null = object;
                  Log.e("cr_ScreenCapture", stringBuilder1.toString(), new Object[0]);
                  null = object;
                  throw new IllegalStateException();
                } 
              } else {
                null = object;
                if ((image.getPlanes()).length == 1) {
                  null = object;
                  ScreenCapture.access$600(ScreenCapture.this, ScreenCapture.access$500(ScreenCapture.this), image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), (image.getCropRect()).left, (image.getCropRect()).top, image.getCropRect().width(), image.getCropRect().height(), image.getTimestamp());
                } else {
                  null = object;
                  stringBuilder1 = new StringBuilder("Unexpected image planes for RGBA_8888 format: ");
                  null = object;
                  stringBuilder1.append((image.getPlanes()).length);
                  null = object;
                  Log.e("cr_ScreenCapture", stringBuilder1.toString(), new Object[0]);
                  null = object;
                  throw new IllegalStateException();
                } 
              } 
              if (image != null) {
                image.close();
                return;
              } 
              return;
            } 
          } 
          null = object;
          StringBuilder stringBuilder2 = new StringBuilder("ImageReader size (");
          null = object;
          stringBuilder2.append(stringBuilder1.getWidth());
          null = object;
          stringBuilder2.append("x");
          null = object;
          stringBuilder2.append(stringBuilder1.getHeight());
          null = object;
          stringBuilder2.append(") did not match Image size (");
          null = object;
          stringBuilder2.append(image.getWidth());
          null = object;
          stringBuilder2.append("x");
          null = object;
          stringBuilder2.append(image.getHeight());
          null = object;
          stringBuilder2.append(")");
          null = object;
          Log.e("cr_ScreenCapture", stringBuilder2.toString(), new Object[0]);
          null = object;
          throw new IllegalStateException();
        } catch (Throwable throwable) {
          null = throwable;
          throw throwable;
        } finally {}
        if (image != null)
          if (null != null) {
            try {
              image.close();
            } catch (Throwable throwable) {
              ThrowableExtension.addSuppressed((Throwable)null, throwable);
            } 
          } else {
            image.close();
          }  
        throw paramImageReader;
      } catch (IllegalStateException illegalStateException) {
        null = new StringBuilder("acquireLatestImage():");
        null.append(illegalStateException);
        Log.e("cr_ScreenCapture", null.toString(), new Object[0]);
        return;
      } catch (UnsupportedOperationException unsupportedOperationException) {
        null = new StringBuilder("acquireLatestImage():");
        null.append(unsupportedOperationException);
        Log.i("cr_ScreenCapture", null.toString(), new Object[0]);
        if (ScreenCapture.access$800(ScreenCapture.this) == 35) {
          ScreenCapture.access$802(ScreenCapture.this, 1);
          ScreenCapture.access$300(ScreenCapture.this);
          ScreenCapture.access$400(ScreenCapture.this);
        } 
        return;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\ScreenCapture$CrImageReaderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */