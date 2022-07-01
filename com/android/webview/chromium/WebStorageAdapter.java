package com.android.webview.chromium;

import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import org.chromium.android_webview.AwQuotaManagerBridge;
import org.chromium.base.ThreadUtils;

final class WebStorageAdapter extends WebStorage {
  private final WebViewChromiumFactoryProvider mFactory;
  
  private final AwQuotaManagerBridge mQuotaManagerBridge;
  
  WebStorageAdapter(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider, AwQuotaManagerBridge paramAwQuotaManagerBridge) {
    this.mFactory = paramWebViewChromiumFactoryProvider;
    this.mQuotaManagerBridge = paramAwQuotaManagerBridge;
  }
  
  private static boolean checkNeedsPost() {
    return !ThreadUtils.runningOnUiThread();
  }
  
  public final void deleteAllData() {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebStorageAdapter$6(this));
      return;
    } 
    this.mQuotaManagerBridge.deleteAllData();
  }
  
  public final void deleteOrigin(String paramString) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebStorageAdapter$5(this, paramString));
      return;
    } 
    this.mQuotaManagerBridge.deleteOrigin(paramString);
  }
  
  public final void getOrigins(ValueCallback paramValueCallback) {
    WebStorageAdapter$1 webStorageAdapter$1 = new WebStorageAdapter$1(paramValueCallback);
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebStorageAdapter$2(this, webStorageAdapter$1));
      return;
    } 
    this.mQuotaManagerBridge.getOrigins(webStorageAdapter$1);
  }
  
  public final void getQuotaForOrigin(String paramString, ValueCallback paramValueCallback) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebStorageAdapter$4(this, paramString, paramValueCallback));
      return;
    } 
    this.mQuotaManagerBridge.getQuotaForOrigin(paramString, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public final void getUsageForOrigin(String paramString, ValueCallback paramValueCallback) {
    if (checkNeedsPost()) {
      this.mFactory.addTask(new WebStorageAdapter$3(this, paramString, paramValueCallback));
      return;
    } 
    this.mQuotaManagerBridge.getUsageForOrigin(paramString, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public final void setQuotaForOrigin(String paramString, long paramLong) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebStorageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */