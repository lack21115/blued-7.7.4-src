package org.chromium.android_webview;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.memory.MemoryPressureMonitor;

public class AwBrowserContext {
  public Context mApplicationContext;
  
  private AwGeolocationPermissions mGeolocationPermissions;
  
  public AwServiceWorkerController mServiceWorkerController;
  
  private final SharedPreferences mSharedPreferences;
  
  public AwTracingController mTracingController;
  
  public AwBrowserContext(SharedPreferences paramSharedPreferences, Context paramContext) {
    this.mSharedPreferences = paramSharedPreferences;
    this.mApplicationContext = paramContext;
    PlatformServiceBridge.getInstance();
    PlatformServiceBridge.setSafeBrowsingHandler();
    MemoryPressureMonitor memoryPressureMonitor = MemoryPressureMonitor.INSTANCE;
    ThreadUtils.assertOnUiThread();
    ContextUtils.sApplicationContext.registerComponentCallbacks((ComponentCallbacks)new Object(memoryPressureMonitor));
    AwContentsLifecycleNotifier.addObserver(new AwBrowserContext$1());
  }
  
  public final AwGeolocationPermissions getGeolocationPermissions() {
    if (this.mGeolocationPermissions == null)
      this.mGeolocationPermissions = new AwGeolocationPermissions(this.mSharedPreferences); 
    return this.mGeolocationPermissions;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwBrowserContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */