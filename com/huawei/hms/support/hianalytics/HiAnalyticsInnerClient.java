package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class HiAnalyticsInnerClient extends HiAnalyticsBase {
  public static void reportEntryClient(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    Map<String, String> map = getMapForBi(paramContext, paramString1);
    map.put("appid", paramString2);
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3))
      str = TransactionIdCreater.getId(paramString2, paramString1); 
    map.put("transId", str);
    map.put("direction", "req");
    if (!TextUtils.isEmpty(paramString4))
      map.put("version", HiAnalyticsUtil.versionCodeToName(paramString4)); 
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_API_CALLED", map);
  }
  
  public static void reportEntryExit(Context paramContext, ResponseHeader paramResponseHeader, String paramString) {
    HiAnalyticsUtil.getInstance();
    Map<String, String> map = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    map.put("direction", "rsp");
    if (!TextUtils.isEmpty(paramString))
      map.put("version", HiAnalyticsUtil.versionCodeToName(paramString)); 
    map.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_API_CALLED", map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\hianalytics\HiAnalyticsInnerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */