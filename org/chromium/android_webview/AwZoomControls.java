package org.chromium.android_webview;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ZoomButtonsController;

public final class AwZoomControls {
  AwContents mAwContents;
  
  ZoomButtonsController mZoomButtonsController;
  
  AwZoomControls(AwContents paramAwContents) {
    this.mAwContents = paramAwContents;
  }
  
  @SuppressLint({"RtlHardcoded"})
  final ZoomButtonsController getZoomController() {
    if (this.mZoomButtonsController == null && this.mAwContents.mSettings.shouldDisplayZoomControls()) {
      this.mZoomButtonsController = new ZoomButtonsController((View)this.mAwContents.mContainerView);
      this.mZoomButtonsController.setOnZoomListener(new AwZoomControls$ZoomListener(this, (byte)0));
      ViewGroup.LayoutParams layoutParams = this.mZoomButtonsController.getZoomControls().getLayoutParams();
      if (layoutParams instanceof FrameLayout.LayoutParams)
        ((FrameLayout.LayoutParams)layoutParams).gravity = 5; 
    } 
    return this.mZoomButtonsController;
  }
  
  public final void invokeZoomPicker() {
    ZoomButtonsController zoomButtonsController = getZoomController();
    if (zoomButtonsController != null)
      zoomButtonsController.setVisible(true); 
  }
  
  public final void updateZoomControls() {
    ZoomButtonsController zoomButtonsController = getZoomController();
    if (zoomButtonsController == null)
      return; 
    boolean bool1 = this.mAwContents.canZoomIn();
    boolean bool2 = this.mAwContents.canZoomOut();
    if (!bool1 && !bool2) {
      zoomButtonsController.getZoomControls().setVisibility(8);
      return;
    } 
    zoomButtonsController.setZoomInEnabled(bool1);
    zoomButtonsController.setZoomOutEnabled(bool2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwZoomControls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */