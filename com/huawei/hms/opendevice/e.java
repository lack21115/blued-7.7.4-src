package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class e {
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
    grsBaseInfo.setSerCountry(paramString4);
    if (!TextUtils.isEmpty(paramString3))
      grsBaseInfo.setAppName(paramString3); 
    String str = (new GrsClient(paramContext, grsBaseInfo)).synGetGrsUrl(paramString1, paramString2);
    if (TextUtils.isEmpty(str)) {
      HMSLog.i("QueryGrs", "Query Grs base url is empty.");
      return "";
    } 
    HMSLog.i("QueryGrs", "Query Grs base url success.");
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */