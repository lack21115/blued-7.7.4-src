package org.chromium.content.browser.androidoverlay;

import android.view.Surface;

public interface DialogOverlayCore$Host {
  void enforceClose();
  
  void onOverlayDestroyed();
  
  void onSurfaceReady(Surface paramSurface);
  
  void waitForClose();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayCore$Host.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */