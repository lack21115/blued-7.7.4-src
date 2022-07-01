package org.chromium.android_webview;

import android.graphics.Canvas;
import android.graphics.Picture;
import java.io.OutputStream;

class AwPicture extends Picture {
  private long mNativeAwPicture;
  
  AwPicture(long paramLong) {
    this.mNativeAwPicture = paramLong;
    new CleanupReference(this, new AwPicture$DestroyRunnable(paramLong, (byte)0));
  }
  
  private static native void nativeDestroy(long paramLong);
  
  private native void nativeDraw(long paramLong, Canvas paramCanvas);
  
  private native int nativeGetHeight(long paramLong);
  
  private native int nativeGetWidth(long paramLong);
  
  private static void unsupportedOperation() {
    throw new IllegalStateException("Unsupported in AwPicture");
  }
  
  public Canvas beginRecording(int paramInt1, int paramInt2) {
    unsupportedOperation();
    return null;
  }
  
  public void draw(Canvas paramCanvas) {
    nativeDraw(this.mNativeAwPicture, paramCanvas);
  }
  
  public void endRecording() {}
  
  public int getHeight() {
    return nativeGetHeight(this.mNativeAwPicture);
  }
  
  public int getWidth() {
    return nativeGetWidth(this.mNativeAwPicture);
  }
  
  public void writeToStream(OutputStream paramOutputStream) {
    unsupportedOperation();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwPicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */