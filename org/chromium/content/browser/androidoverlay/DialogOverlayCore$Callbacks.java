package org.chromium.content.browser.androidoverlay;

import android.view.SurfaceHolder;

final class DialogOverlayCore$Callbacks implements SurfaceHolder.Callback2 {
  private DialogOverlayCore$Callbacks() {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    if (DialogOverlayCore.this.mDialog == null)
      return; 
    if (DialogOverlayCore.this.mHost != null)
      DialogOverlayCore.this.mHost.onSurfaceReady(paramSurfaceHolder.getSurface()); 
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    if (DialogOverlayCore.this.mDialog != null) {
      if (DialogOverlayCore.this.mHost == null)
        return; 
      DialogOverlayCore.this.mHost.onOverlayDestroyed();
      DialogOverlayCore.this.mHost.waitForClose();
      DialogOverlayCore.this.mHost.enforceClose();
      DialogOverlayCore.this.mHost = null;
      return;
    } 
  }
  
  public final void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayCore$Callbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */