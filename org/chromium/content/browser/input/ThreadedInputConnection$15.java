package org.chromium.content.browser.input;

import android.view.KeyEvent;

final class ThreadedInputConnection$15 implements Runnable {
  public final void run() {
    if (ThreadedInputConnection.access$900(ThreadedInputConnection.this, event))
      return; 
    ThreadedInputConnection.access$100(ThreadedInputConnection.this).sendKeyEvent(event);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$15.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */