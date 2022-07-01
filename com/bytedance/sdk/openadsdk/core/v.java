package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadController;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.h.e;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.h.i;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.utils.ag;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.reflect.Method;

public class v implements TTAdManager {
  String a = "com.union_test.toutiao";
  
  String b = "5001121";
  
  public v a(String paramString) {
    h.c().a(paramString);
    h.a((e)o.i()).a();
    i.a((e)o.h()).c();
    return this;
  }
  
  public v a(boolean paramBoolean) {
    h.c().a(paramBoolean);
    return this;
  }
  
  public v b(String paramString) {
    h.c().b(paramString);
    return this;
  }
  
  public v c(String paramString) {
    h.c().c(paramString);
    return this;
  }
  
  public TTAdNative createAdNative(Context paramContext) {
    h.c().o();
    return new w(paramContext);
  }
  
  public v d(String paramString) {
    h.c().d(paramString);
    return this;
  }
  
  public TTGlobalAppDownloadController getGlobalAppDownloadController(Context paramContext) {
    return null;
  }
  
  public String getSDKVersion() {
    return "2.9.5.6";
  }
  
  public TTAdManager isUseTextureView(boolean paramBoolean) {
    h.c().d(paramBoolean);
    return this;
  }
  
  public boolean onlyVerityPlayable(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
    if (this.a.equals(o.a().getPackageName())) {
      if (!this.b.equals(h.c().e()))
        return false; 
      if (TextUtils.isEmpty(paramString1))
        return false; 
      try {
        Method method = ag.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", new Class[] { String.class, int.class, String.class, String.class, String.class });
      } finally {
        paramString1 = null;
      } 
      return true;
    } 
    return false;
  }
  
  public TTAdManager openDebugMode() {
    t.b();
    a.c();
    return this;
  }
  
  public void requestPermissionIfNecessary(Context paramContext) {
    TTCustomController tTCustomController = h.c().d();
    if (tTCustomController != null) {
      boolean bool1 = tTCustomController.isCanUseLocation();
      boolean bool2 = tTCustomController.isCanUsePhoneState();
      boolean bool3 = tTCustomController.isCanUseWriteExternal();
      if (!bool1 && !bool2 && !bool3)
        return; 
    } 
    Intent intent = new Intent(paramContext, TTDelegateActivity.class);
    intent.addFlags(268435456);
    intent.putExtra("type", 2);
    if (paramContext != null)
      b.a(paramContext, intent, null); 
  }
  
  public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean paramBoolean) {
    h.c().c(paramBoolean);
    return this;
  }
  
  public TTAdManager setAllowShowNotifiFromSDK(boolean paramBoolean) {
    h.c().b(paramBoolean);
    return this;
  }
  
  public TTAdManager setCustomController(TTCustomController paramTTCustomController) {
    h.c().a(paramTTCustomController);
    return this;
  }
  
  public TTAdManager setDirectDownloadNetworkType(int... paramVarArgs) {
    h.c().a(paramVarArgs);
    return this;
  }
  
  public TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener) {
    h.c().a(paramTTGlobalAppDownloadListener);
    return this;
  }
  
  public TTAdManager setNeedClearTaskReset(String[] paramArrayOfString) {
    h.c().a(paramArrayOfString);
    return this;
  }
  
  public TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger paramTTDownloadEventLogger) {
    h.c().a(paramTTDownloadEventLogger);
    return this;
  }
  
  public TTAdManager setTTSecAbs(TTSecAbs paramTTSecAbs) {
    h.c().a(paramTTSecAbs);
    return this;
  }
  
  public TTAdManager setTitleBarTheme(int paramInt) {
    h.c().a(paramInt);
    return this;
  }
  
  public boolean tryShowInstallDialogWhenExit(Context paramContext, ExitInstallListener paramExitInstallListener) {
    return a.a(paramContext, paramExitInstallListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */