package org.chromium.content.browser.input;

import org.chromium.base.ThreadUtils;

public final class ImeUtils {
  static void checkCondition(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new AssertionError();
  }
  
  static void checkOnUiThread() {
    if (ThreadUtils.runningOnUiThread())
      return; 
    throw new AssertionError("Should be on UI thread.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ImeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */