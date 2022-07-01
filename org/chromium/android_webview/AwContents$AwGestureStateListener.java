package org.chromium.android_webview;

import android.os.Message;
import org.chromium.content_public.browser.GestureStateListener;

final class AwContents$AwGestureStateListener implements GestureStateListener {
  private AwContents$AwGestureStateListener() {}
  
  public final void onDestroyed() {}
  
  public final void onFlingStartGesture$255f295() {}
  
  public final void onPinchEnded() {
    AwLayoutSizer awLayoutSizer = AwContents.access$1500(AwContents.this);
    awLayoutSizer.mFreezeLayoutRequests = false;
    if (awLayoutSizer.mFrozenLayoutRequestPending) {
      awLayoutSizer.mFrozenLayoutRequestPending = false;
      awLayoutSizer.mDelegate.requestLayout();
    } 
  }
  
  public final void onPinchStarted() {
    AwLayoutSizer awLayoutSizer = AwContents.access$1500(AwContents.this);
    awLayoutSizer.mFreezeLayoutRequests = true;
    awLayoutSizer.mFrozenLayoutRequestPending = false;
  }
  
  public final void onScaleLimitsChanged$2548a35() {
    AwContents.access$1700(AwContents.this).updateZoomControls();
  }
  
  public final void onScrollEnded$255f295() {}
  
  public final void onScrollOffsetOrExtentChanged$255f295() {
    AwContents.access$1700(AwContents.this).updateZoomControls();
  }
  
  public final void onScrollStarted$255f295() {
    AwContents.access$1700(AwContents.this).invokeZoomPicker();
  }
  
  public final void onScrollUpdateGestureConsumed() {
    ScrollAccessibilityHelper scrollAccessibilityHelper = AwContents.access$1600(AwContents.this);
    if (!scrollAccessibilityHelper.mMsgViewScrolledQueued) {
      scrollAccessibilityHelper.mMsgViewScrolledQueued = true;
      Message message = scrollAccessibilityHelper.mHandler.obtainMessage(1);
      scrollAccessibilityHelper.mHandler.sendMessageDelayed(message, 100L);
    } 
    AwContents.access$1700(AwContents.this).invokeZoomPicker();
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwGestureStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */