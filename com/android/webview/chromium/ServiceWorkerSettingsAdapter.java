package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.ServiceWorkerWebSettings;
import org.chromium.android_webview.AwServiceWorkerSettings;

@TargetApi(24)
public final class ServiceWorkerSettingsAdapter extends ServiceWorkerWebSettings {
  public AwServiceWorkerSettings mAwServiceWorkerSettings;
  
  public ServiceWorkerSettingsAdapter(AwServiceWorkerSettings paramAwServiceWorkerSettings) {
    this.mAwServiceWorkerSettings = paramAwServiceWorkerSettings;
  }
  
  public final boolean getAllowContentAccess() {
    return this.mAwServiceWorkerSettings.getAllowContentAccess();
  }
  
  public final boolean getAllowFileAccess() {
    return this.mAwServiceWorkerSettings.getAllowFileAccess();
  }
  
  public final boolean getBlockNetworkLoads() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwServiceWorkerSettings : Lorg/chromium/android_webview/AwServiceWorkerSettings;
    //   6: invokevirtual getBlockNetworkLoads : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
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
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwServiceWorkerSettings : Lorg/chromium/android_webview/AwServiceWorkerSettings;
    //   6: iload_1
    //   7: invokevirtual setBlockNetworkLoads : (Z)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public final void setCacheMode(int paramInt) {
    this.mAwServiceWorkerSettings.setCacheMode(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ServiceWorkerSettingsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */