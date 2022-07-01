package org.chromium.android_webview;

final class AwServiceWorkerController$ServiceWorkerIoThreadClientImpl extends AwContentsIoThreadClient {
  private AwServiceWorkerController$ServiceWorkerIoThreadClientImpl() {}
  
  public final AwContentsBackgroundThreadClient getBackgroundThreadClient() {
    return AwServiceWorkerController.this.mServiceWorkerBackgroundThreadClient;
  }
  
  public final int getCacheMode() {
    return AwServiceWorkerController.this.mServiceWorkerSettings.getCacheMode();
  }
  
  public final boolean getSafeBrowsingEnabled() {
    return AwSafeBrowsingConfigHelper.sEnabledByManifest;
  }
  
  public final boolean shouldAcceptThirdPartyCookies() {
    return false;
  }
  
  public final boolean shouldBlockContentUrls() {
    return !AwServiceWorkerController.this.mServiceWorkerSettings.getAllowContentAccess();
  }
  
  public final boolean shouldBlockFileUrls() {
    return !AwServiceWorkerController.this.mServiceWorkerSettings.getAllowFileAccess();
  }
  
  public final boolean shouldBlockNetworkLoads() {
    return AwServiceWorkerController.this.mServiceWorkerSettings.getBlockNetworkLoads();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwServiceWorkerController$ServiceWorkerIoThreadClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */