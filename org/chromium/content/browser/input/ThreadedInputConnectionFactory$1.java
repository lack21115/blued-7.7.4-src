package org.chromium.content.browser.input;

import android.view.View;

final class ThreadedInputConnectionFactory$1 implements Runnable {
  public final void run() {
    ThreadedInputConnectionFactory.this.mProxyView.onWindowFocusChanged(true);
    ThreadedInputConnectionFactory.this.mInputMethodManagerWrapper.isActive(view);
    ThreadedInputConnectionFactory$LazyHandlerHolder.access$000().post(new ThreadedInputConnectionFactory$1$1(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnectionFactory$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */