package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class HiAnalyticsBase {
  protected static Map<String, String> getMapForBi(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return (Map)hashMap; 
      String[] arrayOfString = paramString.split("\\.");
      if (arrayOfString.length >= 2) {
        paramString = arrayOfString[0];
        String str = arrayOfString[1];
        hashMap.put("service", paramString);
        hashMap.put("apiName", str);
        hashMap.put("package", paramContext.getPackageName());
        hashMap.put("baseVersion", "5.0.4.301");
        hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
      } 
    } 
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\hianalytics\HiAnalyticsBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */