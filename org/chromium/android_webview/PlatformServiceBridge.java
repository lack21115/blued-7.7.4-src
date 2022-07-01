package org.chromium.android_webview;

import org.chromium.base.Callback;
import org.chromium.base.ThreadUtils;

public abstract class PlatformServiceBridge {
  private static PlatformServiceBridge sInstance;
  
  private static final Object sInstanceLock = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static PlatformServiceBridge getInstance() {
    synchronized (sInstanceLock) {
      if (sInstance == null)
        sInstance = new PlatformServiceBridgeImpl(); 
      return sInstance;
    } 
  }
  
  public static void logMetrics$25e06fc() {}
  
  public static void queryMetricsSetting(Callback paramCallback) {
    ThreadUtils.assertOnUiThread();
    paramCallback.onResult(Boolean.valueOf(false));
  }
  
  public static void querySafeBrowsingUserConsent$c4cc4b1() {}
  
  public static void setSafeBrowsingHandler() {}
  
  public static void warmUpSafeBrowsing$3fc49b33(Callback paramCallback) {
    paramCallback.onResult(Boolean.valueOf(false));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\PlatformServiceBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */