package org.chromium.support_lib_glue;

import org.chromium.android_webview.AwServiceWorkerSettings;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;

final class SupportLibServiceWorkerSettingsAdapter implements ServiceWorkerWebSettingsBoundaryInterface {
  AwServiceWorkerSettings mAwServiceWorkerSettings;
  
  SupportLibServiceWorkerSettingsAdapter(AwServiceWorkerSettings paramAwServiceWorkerSettings) {
    this.mAwServiceWorkerSettings = paramAwServiceWorkerSettings;
  }
  
  public final boolean getAllowContentAccess() {
    return this.mAwServiceWorkerSettings.getAllowContentAccess();
  }
  
  public final boolean getAllowFileAccess() {
    return this.mAwServiceWorkerSettings.getAllowFileAccess();
  }
  
  public final boolean getBlockNetworkLoads() {
    return this.mAwServiceWorkerSettings.getBlockNetworkLoads();
  }
  
  public final int getCacheMode() {
    return this.mAwServiceWorkerSettings.getCacheMode();
  }
  
  public final void setAllowContentAccess(boolean paramBoolean) {
    this.mAwServiceWorkerSettings.setAllowContentAccess(paramBoolean);
  }
  
  public final void setAllowFileAccess(boolean paramBoolean) {
    this.mAwServiceWorkerSettings.setAllowFileAccess(paramBoolean);
  }
  
  public final void setBlockNetworkLoads(boolean paramBoolean) {
    this.mAwServiceWorkerSettings.setBlockNetworkLoads(paramBoolean);
  }
  
  public final void setCacheMode(int paramInt) {
    this.mAwServiceWorkerSettings.setCacheMode(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibServiceWorkerSettingsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */