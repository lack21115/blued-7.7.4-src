package org.chromium.android_webview.services;

import android.net.ConnectivityManager;
import java.io.File;
import org.chromium.android_webview.PlatformServiceBridge;
import org.chromium.base.ContextUtils;
import org.chromium.components.minidump_uploader.MinidumpUploaderDelegate;
import org.chromium.components.minidump_uploader.util.CrashReportingPermissionManager;

public final class AwMinidumpUploaderDelegate implements MinidumpUploaderDelegate {
  final ConnectivityManager mConnectivityManager = (ConnectivityManager)ContextUtils.sApplicationContext.getSystemService("connectivity");
  
  boolean mPermittedByUser = false;
  
  public final CrashReportingPermissionManager createCrashReportingPermissionManager() {
    return new AwMinidumpUploaderDelegate$1(this);
  }
  
  public final File getCrashParentDir() {
    return CrashReceiverService.getWebViewCrashDir();
  }
  
  public final void prepareToUploadMinidumps(Runnable paramRunnable) {
    PlatformServiceBridge.getInstance();
    PlatformServiceBridge.queryMetricsSetting(new AwMinidumpUploaderDelegate$$Lambda$0(this, paramRunnable));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\AwMinidumpUploaderDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */