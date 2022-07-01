package com.android.webview.chromium;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebViewFactoryProvider;
import java.util.List;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.android_webview.AwContentsStatics;
import org.chromium.android_webview.AwSettings;
import org.chromium.android_webview.command_line.CommandLineUtil;
import org.chromium.base.ThreadUtils;

class WebViewChromiumFactoryProvider$1 implements WebViewFactoryProvider.Statics {
  public void clearClientCertPreferences(Runnable paramRunnable) {
    ThreadUtils.runOnUiThread(new SharedStatics$$Lambda$0(paramRunnable));
  }
  
  public void enableSlowWholeDocumentDraw() {
    WebViewChromium.enableSlowWholeDocumentDraw();
  }
  
  public String findAddress(String paramString) {
    return AwContentsStatics.findAddress(paramString);
  }
  
  public void freeMemoryForTests() {
    if (ActivityManager.isRunningInTestHarness())
      ThreadUtils.postOnUiThread(SharedStatics$$Lambda$1.$instance); 
  }
  
  public String getDefaultUserAgent(Context paramContext) {
    return AwSettings.getDefaultUserAgent();
  }
  
  public Uri getSafeBrowsingPrivacyPolicyUrl() {
    return SharedStatics.getSafeBrowsingPrivacyPolicyUrl();
  }
  
  public void initSafeBrowsing(Context paramContext, ValueCallback paramValueCallback) {
    SharedStatics.initSafeBrowsing(paramContext, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public Uri[] parseFileChooserResult(int paramInt, Intent paramIntent) {
    return AwContentsClient.parseFileChooserResult(paramInt, paramIntent);
  }
  
  public void setSafeBrowsingWhitelist(List paramList, ValueCallback paramValueCallback) {
    SharedStatics.setSafeBrowsingWhitelist(paramList, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public void setWebContentsDebuggingEnabled(boolean paramBoolean) {
    SharedStatics sharedStatics = sharedStatics;
    if (!CommandLineUtil.isBuildDebuggable())
      sharedStatics.setWebContentsDebuggingEnabledUnconditionally(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumFactoryProvider$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */