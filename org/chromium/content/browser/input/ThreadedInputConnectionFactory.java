package org.chromium.content.browser.input;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

public final class ThreadedInputConnectionFactory implements ChromiumBaseInputConnection$Factory {
  ThreadedInputConnectionFactory$CheckInvalidator mCheckInvalidator;
  
  final InputMethodManagerWrapper mInputMethodManagerWrapper;
  
  ThreadedInputConnectionProxyView mProxyView;
  
  private boolean mReentrantTriggering;
  
  private ThreadedInputConnection mThreadedInputConnection;
  
  boolean mTriggerDelayedOnCreateInputConnection;
  
  ThreadedInputConnectionFactory(InputMethodManagerWrapper paramInputMethodManagerWrapper) {
    this.mInputMethodManagerWrapper = paramInputMethodManagerWrapper;
    new InputMethodUma();
    this.mTriggerDelayedOnCreateInputConnection = true;
  }
  
  public final void onViewAttachedToWindow() {
    if (this.mProxyView != null) {
      ThreadedInputConnectionProxyView threadedInputConnectionProxyView = this.mProxyView;
      threadedInputConnectionProxyView.mWindowToken.set(threadedInputConnectionProxyView.mContainerView.getWindowToken());
      threadedInputConnectionProxyView.mRootView.set(threadedInputConnectionProxyView.mContainerView.getRootView());
    } 
  }
  
  public final void onViewDetachedFromWindow() {
    if (this.mCheckInvalidator != null)
      this.mCheckInvalidator.invalidate(); 
    if (this.mProxyView != null) {
      ThreadedInputConnectionProxyView threadedInputConnectionProxyView = this.mProxyView;
      threadedInputConnectionProxyView.mWindowToken.set(null);
      threadedInputConnectionProxyView.mRootView.set(null);
    } 
  }
  
  public final void onViewFocusChanged(boolean paramBoolean) {
    if (!paramBoolean && this.mCheckInvalidator != null)
      this.mCheckInvalidator.invalidate(); 
    if (this.mProxyView != null)
      this.mProxyView.mFocused.set(paramBoolean); 
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    if (!paramBoolean && this.mCheckInvalidator != null)
      this.mCheckInvalidator.invalidate(); 
    if (this.mProxyView != null)
      this.mProxyView.mWindowFocused.set(paramBoolean); 
  }
  
  final void postCheckRegisterResultOnUiThread(View paramView, ThreadedInputConnectionFactory$CheckInvalidator paramThreadedInputConnectionFactory$CheckInvalidator, int paramInt) {
    Handler handler = paramView.getHandler();
    if (handler == null)
      return; 
    handler.post(new ThreadedInputConnectionFactory$2(this, paramView, paramThreadedInputConnectionFactory$CheckInvalidator, paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnectionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */