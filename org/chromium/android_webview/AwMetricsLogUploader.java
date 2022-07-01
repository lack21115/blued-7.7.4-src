package org.chromium.android_webview;

import org.chromium.base.annotations.CalledByNative;

public class AwMetricsLogUploader {
  @CalledByNative
  public static void uploadLog(byte[] paramArrayOfbyte) {
    PlatformServiceBridge.getInstance();
    PlatformServiceBridge.logMetrics$25e06fc();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwMetricsLogUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */