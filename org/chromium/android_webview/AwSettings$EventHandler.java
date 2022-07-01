package org.chromium.android_webview;

import android.os.Handler;

public final class AwSettings$EventHandler {
  Handler mHandler;
  
  private boolean mSynchronizationPending;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void runOnUiThreadBlockingAndLocked(Runnable paramRunnable) {
    assert false;
    throw new AssertionError();
  }
  
  public final void updateWebkitPreferencesLocked() {
    runOnUiThreadBlockingAndLocked(new AwSettings$EventHandler$$Lambda$0(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwSettings$EventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */