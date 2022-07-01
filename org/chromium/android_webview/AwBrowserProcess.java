package org.chromium.android_webview;

import android.content.Context;
import android.os.StrictMode;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.nio.channels.FileLock;
import java.util.List;
import org.chromium.android_webview.policy.AwPolicyProvider;
import org.chromium.base.AsyncTask;
import org.chromium.base.BuildInfo;
import org.chromium.base.Callback;
import org.chromium.base.CommandLine;
import org.chromium.base.ContextUtils;
import org.chromium.base.PathUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.ProcessInitException;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.content.browser.ChildProcessCreationParamsImpl;
import org.chromium.content.browser.ChildProcessLauncherHelperImpl;
import org.chromium.policy.CombinedPolicyProvider;

public final class AwBrowserProcess {
  private static FileLock sExclusiveFileLock;
  
  private static String sWebViewPackageName;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void configureChildProcessLauncher() {
    ChildProcessCreationParamsImpl.set(getWebViewPackageName(), true, 4, true, true);
  }
  
  public static String getWebViewPackageName() {
    return (sWebViewPackageName == null) ? "" : sWebViewPackageName;
  }
  
  private static void handleMinidumps(boolean paramBoolean) {
    (new AwBrowserProcess$1(paramBoolean)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, (Object[])new Void[0]);
  }
  
  public static void handleMinidumpsAndSetMetricsConsent(boolean paramBoolean) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwBrowserProcess.handleMinidumpsAndSetMetricsConsent");
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      boolean bool = CommandLine.getInstance().hasSwitch("enable-crash-reporter-for-testing");
      if (bool) {
        throwable1 = throwable2;
        handleMinidumps(true);
      } 
      throwable1 = throwable2;
      PlatformServiceBridge.getInstance();
      throwable1 = throwable2;
      PlatformServiceBridge.queryMetricsSetting(new AwBrowserProcess$$Lambda$2(paramBoolean, bool));
      if (scopedSysTraceEvent != null) {
        $closeResource(null, scopedSysTraceEvent);
        return;
      } 
      return;
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw throwable2;
  }
  
  public static void loadLibrary(String paramString) {
    Exception exception;
    if (paramString == null) {
      PathUtils.setPrivateDataDirectorySuffix("webview", null);
    } else {
      StringBuilder stringBuilder = new StringBuilder("webview_");
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
      PathUtils.setPrivateDataDirectorySuffix(paramString, paramString);
    } 
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      LibraryLoader.getInstance().loadNowOverrideApplicationContext(ContextUtils.sApplicationContext);
      null = LibraryLoader.getInstance();
      synchronized (null.mLock) {
        null.ensureCommandLineSwitchedAlreadyLocked();
        StrictMode.setThreadPolicy(threadPolicy);
        return;
      } 
    } catch (ProcessInitException processInitException) {
      throw new RuntimeException("Cannot load WebView", processInitException);
    } finally {}
    StrictMode.setThreadPolicy(threadPolicy);
    throw exception;
  }
  
  public static void setWebViewPackageName(String paramString) {
    assert false;
    throw new AssertionError();
  }
  
  public static void start() {
    Throwable throwable1;
    Throwable throwable2;
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwBrowserProcess.start");
    StrictMode.ThreadPolicy threadPolicy2 = null;
    StrictMode.ThreadPolicy threadPolicy1 = threadPolicy2;
    try {
      Throwable throwable;
      Context context = ContextUtils.sApplicationContext;
      threadPolicy1 = threadPolicy2;
      ScopedSysTraceEvent scopedSysTraceEvent1 = ScopedSysTraceEvent.scoped("AwBrowserProcess.tryObtainingDataDirLock");
      try {
        boolean bool2;
        boolean bool = BuildInfo.isAtLeastP();
        boolean bool1 = true;
        if (bool && BuildInfo.targetsAtLeastP()) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        threadPolicy1 = StrictMode.allowThreadDiskWrites();
      } catch (Throwable null) {
        try {
          throw throwable;
        } finally {}
      } finally {
        context = null;
      } 
      if (scopedSysTraceEvent1 != null) {
        threadPolicy1 = threadPolicy2;
        $closeResource(throwable, scopedSysTraceEvent1);
      } 
      threadPolicy1 = threadPolicy2;
      throw context;
    } catch (Throwable null) {
      throwable1 = throwable2;
      throw throwable2;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw throwable2;
  }
  
  @CalledByNative
  private static void triggerMinidumpUploading() {
    handleMinidumpsAndSetMetricsConsent(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwBrowserProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */