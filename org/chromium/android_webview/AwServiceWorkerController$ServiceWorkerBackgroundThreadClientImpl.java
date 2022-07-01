package org.chromium.android_webview;

final class AwServiceWorkerController$ServiceWorkerBackgroundThreadClientImpl extends AwContentsBackgroundThreadClient {
  private AwServiceWorkerController$ServiceWorkerBackgroundThreadClientImpl() {}
  
  public final AwWebResourceResponse shouldInterceptRequest(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest) {
    return AwServiceWorkerController.this.mServiceWorkerClient.shouldInterceptRequest(paramAwContentsClient$AwWebResourceRequest);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwServiceWorkerController$ServiceWorkerBackgroundThreadClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */