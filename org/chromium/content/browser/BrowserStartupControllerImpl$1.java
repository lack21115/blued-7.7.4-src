package org.chromium.content.browser;

import android.os.Handler;
import org.chromium.base.ThreadUtils;

final class BrowserStartupControllerImpl$1 implements Runnable {
  public final void run() {
    BrowserStartupControllerImpl browserStartupControllerImpl = BrowserStartupControllerImpl.this;
    BrowserStartupControllerImpl$1$1 browserStartupControllerImpl$1$1 = new BrowserStartupControllerImpl$1$1(this);
    ThreadUtils.assertOnUiThread();
    if (browserStartupControllerImpl.mFullBrowserStartupDone) {
      (new Handler()).post(new BrowserStartupControllerImpl$4(browserStartupControllerImpl, browserStartupControllerImpl$1$1));
      return;
    } 
    browserStartupControllerImpl.mAsyncStartupCallbacks.add(browserStartupControllerImpl$1$1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BrowserStartupControllerImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */