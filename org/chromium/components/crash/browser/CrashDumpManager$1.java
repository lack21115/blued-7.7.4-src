package org.chromium.components.crash.browser;

import org.chromium.base.Log;

final class CrashDumpManager$1 implements Runnable {
  public final void run() {
    if (CrashDumpManager.access$000() == null) {
      Log.w("CrashDumpManager", "Ignoring crash observed before a callback was registered...", new Object[0]);
      return;
    } 
    CrashDumpManager.access$000();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\crash\browser\CrashDumpManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */