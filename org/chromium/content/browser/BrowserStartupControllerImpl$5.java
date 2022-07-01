package org.chromium.content.browser;

import org.chromium.base.CommandLine;
import org.chromium.ui.base.DeviceFormFactor;

final class BrowserStartupControllerImpl$5 implements Runnable {
  public final void run() {
    if (!BrowserStartupControllerImpl.access$600(BrowserStartupControllerImpl.this)) {
      if (!DeviceFormFactor.isTablet())
        CommandLine.getInstance().appendSwitch("use-mobile-user-agent"); 
      BrowserStartupControllerImpl.access$700(singleProcess);
      BrowserStartupControllerImpl.access$602(BrowserStartupControllerImpl.this, true);
    } 
    if (completionCallback != null)
      completionCallback.run(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BrowserStartupControllerImpl$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */