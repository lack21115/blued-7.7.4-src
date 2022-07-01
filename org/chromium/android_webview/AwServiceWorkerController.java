package org.chromium.android_webview;

import android.content.Context;

public final class AwServiceWorkerController {
  private AwBrowserContext mBrowserContext;
  
  AwContentsBackgroundThreadClient mServiceWorkerBackgroundThreadClient;
  
  AwServiceWorkerClient mServiceWorkerClient;
  
  private AwContentsIoThreadClient mServiceWorkerIoThreadClient;
  
  public AwServiceWorkerSettings mServiceWorkerSettings;
  
  public AwServiceWorkerController(Context paramContext, AwBrowserContext paramAwBrowserContext) {
    this.mServiceWorkerSettings = new AwServiceWorkerSettings(paramContext);
    this.mBrowserContext = paramAwBrowserContext;
  }
  
  public final void setServiceWorkerClient(AwServiceWorkerClient paramAwServiceWorkerClient) {
    this.mServiceWorkerClient = paramAwServiceWorkerClient;
    if (paramAwServiceWorkerClient != null) {
      this.mServiceWorkerBackgroundThreadClient = new AwServiceWorkerController$ServiceWorkerBackgroundThreadClientImpl(this, (byte)0);
      this.mServiceWorkerIoThreadClient = new AwServiceWorkerController$ServiceWorkerIoThreadClientImpl(this, (byte)0);
      AwContentsStatics.setServiceWorkerIoThreadClient(this.mServiceWorkerIoThreadClient, this.mBrowserContext);
      return;
    } 
    this.mServiceWorkerBackgroundThreadClient = null;
    this.mServiceWorkerIoThreadClient = null;
    AwContentsStatics.setServiceWorkerIoThreadClient(null, this.mBrowserContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwServiceWorkerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */