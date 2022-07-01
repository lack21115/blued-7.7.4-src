package org.chromium.content.browser.input;

import android.view.View;
import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;

final class ThreadedInputConnectionFactory$2 implements Runnable {
  public final void run() {
    ThreadedInputConnectionFactory threadedInputConnectionFactory = ThreadedInputConnectionFactory.this;
    View view = view;
    ThreadedInputConnectionFactory$CheckInvalidator threadedInputConnectionFactory$CheckInvalidator = checkInvalidator;
    int i = retry;
    if (threadedInputConnectionFactory.mInputMethodManagerWrapper.isActive(threadedInputConnectionFactory.mProxyView)) {
      RecordHistogram.recordEnumeratedHistogram("InputMethod.RegisterProxyView", 0, 4);
      return;
    } 
    if (i > 0) {
      threadedInputConnectionFactory.postCheckRegisterResultOnUiThread(view, threadedInputConnectionFactory$CheckInvalidator, i - 1);
      return;
    } 
    ImeUtils.checkOnUiThread();
    if (!threadedInputConnectionFactory$CheckInvalidator.mInvalid) {
      Log.w("cr_Ime", "onRegisterProxyViewFailure", new Object[0]);
      RecordHistogram.recordEnumeratedHistogram("InputMethod.RegisterProxyView", 1, 4);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnectionFactory$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */