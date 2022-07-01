package com.android.webview.chromium;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import java.util.List;
import org.chromium.android_webview.AwDevToolsServer;
import org.chromium.base.Callback;
import org.chromium.base.ThreadUtils;

public final class SharedStatics {
  private AwDevToolsServer mDevToolsServer;
  
  public static Uri getSafeBrowsingPrivacyPolicyUrl() {
    return (Uri)ThreadUtils.runOnUiThreadBlockingNoException(SharedStatics$$Lambda$4.$instance);
  }
  
  public static void initSafeBrowsing(Context paramContext, Callback paramCallback) {
    ThreadUtils.runOnUiThread(new SharedStatics$$Lambda$2(paramContext, paramCallback));
  }
  
  public static void setSafeBrowsingWhitelist(List paramList, Callback paramCallback) {
    ThreadUtils.runOnUiThread(new SharedStatics$$Lambda$3(paramList, paramCallback));
  }
  
  public final void setWebContentsDebuggingEnabledUnconditionally(boolean paramBoolean) {
    if (Looper.myLooper() == ThreadUtils.getUiThreadLooper()) {
      if (this.mDevToolsServer == null) {
        if (!paramBoolean)
          return; 
        this.mDevToolsServer = new AwDevToolsServer();
      } 
      AwDevToolsServer awDevToolsServer = this.mDevToolsServer;
      awDevToolsServer.nativeSetRemoteDebuggingEnabled(awDevToolsServer.mNativeDevToolsServer, paramBoolean);
      return;
    } 
    throw new RuntimeException("Toggling of Web Contents Debugging must be done on the UI thread");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\SharedStatics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */