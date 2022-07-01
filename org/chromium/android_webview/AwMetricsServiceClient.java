package org.chromium.android_webview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.chromium.base.Log;
import org.chromium.base.PathUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class AwMetricsServiceClient {
  private static byte[] sClientId;
  
  private static Object sClientIdLock = new Object();
  
  private static boolean sIsClientReady;
  
  private static boolean sShouldEnable;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static byte[] getPreloadedClientId() {
    synchronized (sClientIdLock) {
      return sClientId;
    } 
  }
  
  private static boolean isAppOptedOut(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return (applicationInfo.metaData == null) ? false : applicationInfo.metaData.getBoolean("android.webkit.WebView.MetricsOptOut");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("AwMetricsServiceCli-", "App could not find itself by package name!", new Object[0]);
      return true;
    } 
  }
  
  @CalledByNative
  public static void nativeInitialized() {
    ThreadUtils.assertOnUiThread();
    sIsClientReady = true;
    if (sShouldEnable)
      nativeSetHaveMetricsConsent(true); 
  }
  
  public static native void nativeSetHaveMetricsConsent(boolean paramBoolean);
  
  public static void preloadClientId() {
    File file = new File(PathUtils.getDataDirectory(), "metrics_guid");
    if (file.exists()) {
      if (file.length() != 36L)
        return; 
      try {
        null = readFixedLengthFile(file, 36);
        synchronized (sClientIdLock) {
          sClientId = null;
          return;
        } 
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder("Failed to pre-load GUID file ");
        stringBuilder.append(file);
        stringBuilder.append(" - ");
        stringBuilder.append(iOException.getMessage());
        Log.e("AwMetricsServiceCli-", stringBuilder.toString(), new Object[0]);
        return;
      } 
    } 
  }
  
  private static byte[] readFixedLengthFile(File paramFile, int paramInt) {
    if (paramFile.length() == paramInt) {
      Exception exception;
      try {
        FileInputStream fileInputStream = new FileInputStream(paramFile);
      } finally {
        exception = null;
      } 
      if (paramFile != null)
        paramFile.close(); 
      throw exception;
    } 
    StringBuilder stringBuilder = new StringBuilder("File is not of expected length ");
    stringBuilder.append(paramInt);
    throw new IOException(stringBuilder.toString());
  }
  
  public static void setConsentSetting(Context paramContext, boolean paramBoolean) {
    ThreadUtils.assertOnUiThread();
    if (paramBoolean) {
      if (isAppOptedOut(paramContext))
        return; 
      sShouldEnable = true;
      if (sIsClientReady)
        nativeSetHaveMetricsConsent(true); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwMetricsServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */