package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;

public class e {
  public static void a(Context paramContext, String paramString, PushSelfShowMessage paramPushSelfShowMessage) {
    PushBaseAnalytics pushBaseAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
    if (pushBaseAnalytics == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("msgId", paramPushSelfShowMessage.getMsgId());
    bundle.putString("sdkVer", String.valueOf(50004300));
    bundle.putString("pkgName", paramContext.getPackageName());
    bundle.putString("aaid", HmsInstanceId.getInstance(paramContext).getId());
    PushProxy pushProxy = ProxyCenter.getProxy();
    if (pushProxy != null)
      bundle.putString("proxyType", pushProxy.getProxyType()); 
    bundle.putString("analyticInfo", paramPushSelfShowMessage.getAnalyticInfo());
    pushBaseAnalytics.report(paramContext, paramString, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    PushBaseAnalytics pushBaseAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
    if (pushBaseAnalytics == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("msgId", paramString1);
    bundle.putString("sdkVer", String.valueOf(50004300));
    bundle.putString("pkgName", paramContext.getPackageName());
    bundle.putString("aaid", HmsInstanceId.getInstance(paramContext).getId());
    PushProxy pushProxy = ProxyCenter.getProxy();
    if (pushProxy != null)
      bundle.putString("proxyType", pushProxy.getProxyType()); 
    pushBaseAnalytics.report(paramContext, paramString2, bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */