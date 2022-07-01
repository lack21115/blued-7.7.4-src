package org.chromium.android_webview;

import org.chromium.base.ThreadUtils;
import org.chromium.base.memory.MemoryPressureMonitor;

final class AwBrowserContext$1 implements AwContentsLifecycleNotifier$Observer {
  public final void onFirstWebViewCreated() {
    MemoryPressureMonitor memoryPressureMonitor = MemoryPressureMonitor.INSTANCE;
    ThreadUtils.assertOnUiThread();
    if (!memoryPressureMonitor.mPollingEnabled) {
      memoryPressureMonitor.mPollingEnabled = true;
      if (!memoryPressureMonitor.mIsInsideThrottlingInterval)
        memoryPressureMonitor.reportCurrentPressure(); 
    } 
  }
  
  public final void onLastWebViewDestroyed() {
    MemoryPressureMonitor memoryPressureMonitor = MemoryPressureMonitor.INSTANCE;
    ThreadUtils.assertOnUiThread();
    if (memoryPressureMonitor.mPollingEnabled)
      memoryPressureMonitor.mPollingEnabled = false; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwBrowserContext$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */