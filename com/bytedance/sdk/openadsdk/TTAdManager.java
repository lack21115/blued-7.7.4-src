package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

public interface TTAdManager {
  TTAdNative createAdNative(Context paramContext);
  
  @Deprecated
  TTGlobalAppDownloadController getGlobalAppDownloadController(Context paramContext);
  
  String getSDKVersion();
  
  @Deprecated
  TTAdManager isUseTextureView(boolean paramBoolean);
  
  boolean onlyVerityPlayable(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4);
  
  @Deprecated
  TTAdManager openDebugMode();
  
  void requestPermissionIfNecessary(Context paramContext);
  
  @Deprecated
  TTAdManager setAllowLandingPageShowWhenScreenLock(boolean paramBoolean);
  
  @Deprecated
  TTAdManager setAllowShowNotifiFromSDK(boolean paramBoolean);
  
  @Deprecated
  TTAdManager setAppId(String paramString);
  
  @Deprecated
  TTAdManager setCustomController(TTCustomController paramTTCustomController);
  
  @Deprecated
  TTAdManager setData(String paramString);
  
  @Deprecated
  TTAdManager setDirectDownloadNetworkType(int... paramVarArgs);
  
  @Deprecated
  TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener);
  
  @Deprecated
  TTAdManager setKeywords(String paramString);
  
  @Deprecated
  TTAdManager setName(String paramString);
  
  @Deprecated
  TTAdManager setNeedClearTaskReset(String[] paramArrayOfString);
  
  @Deprecated
  TTAdManager setPaid(boolean paramBoolean);
  
  @Deprecated
  TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger paramTTDownloadEventLogger);
  
  @Deprecated
  TTAdManager setTTSecAbs(TTSecAbs paramTTSecAbs);
  
  @Deprecated
  TTAdManager setTitleBarTheme(int paramInt);
  
  boolean tryShowInstallDialogWhenExit(Context paramContext, ExitInstallListener paramExitInstallListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */