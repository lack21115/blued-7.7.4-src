package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TTAdSdk {
  private static AtomicBoolean a = new AtomicBoolean(false);
  
  private static void a(Context paramContext, TTAdConfig paramTTAdConfig) {
    if (paramTTAdConfig.getHttpStack() != null)
      e.a(paramTTAdConfig.getHttpStack()); 
    l.a = paramTTAdConfig.isAsyncInit();
    l.b = paramTTAdConfig.getCustomController();
    if (paramTTAdConfig.isDebug())
      t.b(); 
    TTAdManager tTAdManager = TTAdManagerFactory.getInstance(paramContext, paramTTAdConfig.isSupportMultiProcess());
    if (paramTTAdConfig.isDebug())
      tTAdManager.openDebugMode(); 
    tTAdManager.setAppId(paramTTAdConfig.getAppId()).setName(paramTTAdConfig.getAppName()).setPaid(paramTTAdConfig.isPaid()).setKeywords(paramTTAdConfig.getKeywords()).setData(paramTTAdConfig.getData()).setTitleBarTheme(paramTTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(paramTTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(paramTTAdConfig.isAllowShowPageWhenScreenLock()).setDirectDownloadNetworkType(paramTTAdConfig.getDirectDownloadNetworkType()).isUseTextureView(paramTTAdConfig.isUseTextureView()).setTTDownloadEventLogger(paramTTAdConfig.getTTDownloadEventLogger()).setNeedClearTaskReset(paramTTAdConfig.getNeedClearTaskReset()).setTTSecAbs(paramTTAdConfig.getTTSecAbs()).setCustomController(paramTTAdConfig.getCustomController());
    try {
      return;
    } finally {
      tTAdManager = null;
    } 
  }
  
  public static TTAdManager getAdManager() {
    return TTAdManagerFactory.a();
  }
  
  public static TTAdManager init(Context paramContext, TTAdConfig paramTTAdConfig) {
    y.a(paramContext, "Context is null, please check.");
    y.a(paramTTAdConfig, "TTAdConfig is null, please check.");
    if (!a.get()) {
      a(paramContext, paramTTAdConfig);
      a.set(true);
    } 
    return getAdManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */