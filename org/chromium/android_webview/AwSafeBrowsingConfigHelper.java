package org.chromium.android_webview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import org.chromium.base.CommandLine;
import org.chromium.base.Log;

public final class AwSafeBrowsingConfigHelper {
  static volatile boolean sEnabledByManifest;
  
  static volatile Boolean sSafeBrowsingUserOptIn;
  
  static Boolean getAppOptInPreference(Context paramContext) {
    try {
      ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwSafeBrowsingConfigHelper.getAppOptInPreference");
      Throwable throwable2 = null;
      Throwable throwable1 = throwable2;
      try {
        ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        throwable1 = throwable2;
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null) {
          if (scopedSysTraceEvent != null)
            $closeResource(null, scopedSysTraceEvent); 
          return null;
        } 
        throwable1 = throwable2;
        if (applicationInfo.metaData.containsKey("android.webkit.WebView.EnableSafeBrowsing")) {
          throwable1 = throwable2;
          Boolean bool = Boolean.valueOf(applicationInfo.metaData.getBoolean("android.webkit.WebView.EnableSafeBrowsing"));
        } else {
          applicationInfo = null;
        } 
        if (scopedSysTraceEvent != null)
          $closeResource(null, scopedSysTraceEvent); 
        return (Boolean)applicationInfo;
      } catch (Throwable throwable) {
        throwable1 = throwable;
        throw throwable;
      } finally {}
      if (scopedSysTraceEvent != null)
        $closeResource(throwable1, scopedSysTraceEvent); 
      throw paramContext;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("AwSafeBrowsingConfi-", "App could not find itself by package name!", new Object[0]);
      return Boolean.valueOf(false);
    } 
  }
  
  static boolean isDisabledByCommandLine() {
    Throwable throwable2;
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwSafeBrowsingConfigHelper.isDisabledByCommandLine");
    Throwable throwable1 = null;
    try {
      boolean bool = CommandLine.getInstance().hasSwitch("webview-disable-safebrowsing-support");
      if (scopedSysTraceEvent != null)
        $closeResource(null, scopedSysTraceEvent); 
      return bool;
    } catch (Throwable null) {
      throwable1 = throwable2;
      throw throwable2;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw throwable2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwSafeBrowsingConfigHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */