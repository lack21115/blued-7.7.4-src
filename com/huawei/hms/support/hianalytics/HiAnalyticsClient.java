package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class HiAnalyticsClient extends HiAnalyticsBase {
  @Deprecated
  public static String reportEntry(Context paramContext, String paramString) {
    return reportEntry(paramContext, paramString, Util.getAppId(paramContext), 0);
  }
  
  public static String reportEntry(Context paramContext, String paramString, int paramInt) {
    return reportEntry(paramContext, paramString, Util.getAppId(paramContext), paramInt);
  }
  
  public static String reportEntry(Context paramContext, String paramString1, String paramString2, int paramInt) {
    String str = TransactionIdCreater.getId(paramString2, paramString1);
    Map<String, String> map = getMapForBi(paramContext, paramString1);
    map.put("appid", paramString2);
    map.put("transId", str);
    map.put("direction", "req");
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramInt)));
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_KIT_API_CALLED", map);
    return str;
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2) {
    reportExit(paramContext, paramString1, paramString2, Util.getAppId(paramContext), paramInt1, paramInt2, 0);
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
    reportExit(paramContext, paramString1, paramString2, Util.getAppId(paramContext), paramInt1, paramInt2, paramInt3);
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3) {
    Map<String, String> map = getMapForBi(paramContext, paramString1);
    map.put("appid", paramString3);
    map.put("transId", paramString2);
    map.put("direction", "rsp");
    map.put("statusCode", String.valueOf(paramInt1));
    map.put("result", String.valueOf(paramInt2));
    map.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramInt3)));
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_KIT_API_CALLED", map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\hianalytics\HiAnalyticsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */