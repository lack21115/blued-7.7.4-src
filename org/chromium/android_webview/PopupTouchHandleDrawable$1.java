package org.chromium.android_webview;

import org.chromium.content_public.browser.GestureStateListener;

final class PopupTouchHandleDrawable$1 implements GestureStateListener {
  public final void onDestroyed() {
    PopupTouchHandleDrawable.access$300(PopupTouchHandleDrawable.this);
  }
  
  public final void onFlingStartGesture$255f295() {
    PopupTouchHandleDrawable.access$000(PopupTouchHandleDrawable.this, false);
  }
  
  public final void onPinchEnded() {}
  
  public final void onPinchStarted() {}
  
  public final void onScaleLimitsChanged$2548a35() {}
  
  public final void onScrollEnded$255f295() {
    PopupTouchHandleDrawable.access$000(PopupTouchHandleDrawable.this, false);
  }
  
  public final void onScrollOffsetOrExtentChanged$255f295() {
    PopupTouchHandleDrawable.access$100(PopupTouchHandleDrawable.this);
  }
  
  public final void onScrollStarted$255f295() {
    PopupTouchHandleDrawable.access$000(PopupTouchHandleDrawable.this, true);
  }
  
  public final void onScrollUpdateGestureConsumed() {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    PopupTouchHandleDrawable.access$200(PopupTouchHandleDrawable.this, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\PopupTouchHandleDrawable$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */