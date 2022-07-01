package org.chromium.android_webview;

import android.os.Handler;
import android.os.Message;
import android.view.View;

final class ScrollAccessibilityHelper$HandlerCallback implements Handler.Callback {
  private View mEventSender;
  
  public ScrollAccessibilityHelper$HandlerCallback(View paramView) {
    this.mEventSender = paramView;
  }
  
  public final boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      ScrollAccessibilityHelper.this.mMsgViewScrolledQueued = false;
      this.mEventSender.sendAccessibilityEvent(4096);
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder("AccessibilityInjector: unhandled message: ");
    stringBuilder.append(paramMessage.what);
    throw new IllegalStateException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ScrollAccessibilityHelper$HandlerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */