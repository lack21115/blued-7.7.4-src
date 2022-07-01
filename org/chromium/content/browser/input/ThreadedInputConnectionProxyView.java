package org.chromium.content.browser.input;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.base.ThreadUtils;

public final class ThreadedInputConnectionProxyView extends View {
  final View mContainerView;
  
  final ThreadedInputConnectionFactory mFactory;
  
  final AtomicBoolean mFocused = new AtomicBoolean();
  
  private final Handler mImeThreadHandler;
  
  final AtomicReference mRootView = new AtomicReference();
  
  final AtomicBoolean mWindowFocused = new AtomicBoolean();
  
  final AtomicReference mWindowToken = new AtomicReference();
  
  ThreadedInputConnectionProxyView(Context paramContext, Handler paramHandler, View paramView, ThreadedInputConnectionFactory paramThreadedInputConnectionFactory) {
    super(paramContext);
    this.mImeThreadHandler = paramHandler;
    this.mContainerView = paramView;
    setFocusable(true);
    setFocusableInTouchMode(true);
    setVisibility(0);
    this.mFocused.set(this.mContainerView.hasFocus());
    this.mWindowFocused.set(this.mContainerView.hasWindowFocus());
    this.mWindowToken.set(this.mContainerView.getWindowToken());
    this.mRootView.set(this.mContainerView.getRootView());
    this.mFactory = paramThreadedInputConnectionFactory;
  }
  
  public final boolean checkInputConnectionProxy(View paramView) {
    return (this.mContainerView == paramView);
  }
  
  public final Handler getHandler() {
    return this.mImeThreadHandler;
  }
  
  public final View getRootView() {
    return this.mWindowFocused.get() ? this.mRootView.get() : null;
  }
  
  public final IBinder getWindowToken() {
    return this.mWindowToken.get();
  }
  
  public final boolean hasWindowFocus() {
    return this.mWindowFocused.get();
  }
  
  public final boolean isFocused() {
    return this.mFocused.get();
  }
  
  public final boolean onCheckIsTextEditor() {
    return true;
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return (InputConnection)ThreadUtils.runOnUiThreadBlockingNoException(new ThreadedInputConnectionProxyView$$Lambda$0(this, paramEditorInfo));
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnectionProxyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */