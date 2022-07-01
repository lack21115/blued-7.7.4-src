package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

abstract class ThrowUncaughtException {
  @CalledByNative
  private static void post() {
    ThreadUtils.postOnUiThread(new ThrowUncaughtException$1());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ThrowUncaughtException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */