package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

public class p {
  public static long a(Context paramContext) {
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      int i = (packageManager.getPackageInfo("com.huawei.android.pushagent", 0)).versionCode;
      return i;
    } catch (Exception exception) {
      HMSLog.e("CommFun", "get nc versionCode error");
      return -1L;
    } 
  }
  
  public static boolean a() {
    int i = HwBuildEx.VERSION.EMUI_SDK_INT;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Emui Api Level:");
    stringBuilder.append(i);
    HMSLog.d("CommFun", stringBuilder.toString());
    return (i > 0);
  }
  
  public static boolean b(Context paramContext) {
    return (a() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && a(paramContext) < 110001400L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */