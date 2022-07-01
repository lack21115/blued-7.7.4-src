package org.chromium.android_webview.services;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.chromium.base.CommandLine;
import org.chromium.components.minidump_uploader.util.CrashReportingPermissionManager;

final class AwMinidumpUploaderDelegate$1 implements CrashReportingPermissionManager {
  public final boolean isClientInMetricsSample() {
    return true;
  }
  
  public final boolean isNetworkAvailableForCrashUploads() {
    ConnectivityManager connectivityManager = AwMinidumpUploaderDelegate.this.mConnectivityManager;
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    return (networkInfo != null) ? (!networkInfo.isConnected() ? false : (!connectivityManager.isActiveNetworkMetered())) : false;
  }
  
  public final boolean isUploadEnabledForTests() {
    return CommandLine.getInstance().hasSwitch("enable-crash-reporter-for-testing");
  }
  
  public final boolean isUsageAndCrashReportingPermittedByUser() {
    return AwMinidumpUploaderDelegate.this.mPermittedByUser;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\AwMinidumpUploaderDelegate$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */