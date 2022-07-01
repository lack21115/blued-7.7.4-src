package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import org.chromium.android_webview.AwServiceWorkerController;

@TargetApi(24)
public final class ServiceWorkerControllerAdapter extends ServiceWorkerController {
  private AwServiceWorkerController mAwServiceWorkerController;
  
  public ServiceWorkerControllerAdapter(AwServiceWorkerController paramAwServiceWorkerController) {
    this.mAwServiceWorkerController = paramAwServiceWorkerController;
  }
  
  public final ServiceWorkerWebSettings getServiceWorkerWebSettings() {
    return new ServiceWorkerSettingsAdapter(this.mAwServiceWorkerController.mServiceWorkerSettings);
  }
  
  public final void setServiceWorkerClient(ServiceWorkerClient paramServiceWorkerClient) {
    this.mAwServiceWorkerController.setServiceWorkerClient(new ServiceWorkerClientAdapter(paramServiceWorkerClient));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ServiceWorkerControllerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */