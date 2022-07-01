package org.chromium.media;

import android.media.projection.MediaProjection;

final class ScreenCapture$MediaProjectionCallback extends MediaProjection.Callback {
  private ScreenCapture$MediaProjectionCallback() {}
  
  public final void onStop() {
    ScreenCapture.access$900(ScreenCapture.this, ScreenCapture$CaptureState.STOPPED);
    ScreenCapture.access$1002(ScreenCapture.this, null);
    if (ScreenCapture.access$1100(ScreenCapture.this) == null)
      return; 
    ScreenCapture.access$1100(ScreenCapture.this).release();
    ScreenCapture.access$1102(ScreenCapture.this, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\ScreenCapture$MediaProjectionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */