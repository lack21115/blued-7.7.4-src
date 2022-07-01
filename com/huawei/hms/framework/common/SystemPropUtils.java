package com.huawei.hms.framework.common;

import android.text.TextUtils;

public class SystemPropUtils {
  private static final String TAG = "SystemPropUtils";
  
  public static String getProperty(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString3)) {
      Logger.w(TAG, "reflect class for method has exception.");
      return paramString4;
    } 
    try {
      Class<?> clazz = Class.forName(paramString3);
      return (String)clazz.getMethod(paramString1, new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString2, paramString4 });
    } catch (Exception exception) {
      Logger.e(TAG, "getProperty catch exception: ", exception);
      return paramString4;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\SystemPropUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */