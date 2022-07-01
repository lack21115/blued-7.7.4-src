package org.chromium.android_webview;

import android.widget.ZoomButtonsController;

final class AwZoomControls$ZoomListener implements ZoomButtonsController.OnZoomListener {
  private AwZoomControls$ZoomListener() {}
  
  public final void onVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean) {
      AwZoomControls.this.mZoomButtonsController.getZoomControls().setVisibility(0);
      AwZoomControls.this.updateZoomControls();
    } 
  }
  
  public final void onZoom(boolean paramBoolean) {
    if (paramBoolean) {
      AwZoomControls.this.mAwContents.zoomIn();
      return;
    } 
    AwZoomControls.this.mAwContents.zoomOut();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwZoomControls$ZoomListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */