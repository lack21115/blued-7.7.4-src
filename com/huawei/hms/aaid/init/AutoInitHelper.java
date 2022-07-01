package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper {
  public static void doAutoInit(Context paramContext) {
    try {
      boolean bool = isAutoInitEnabled(paramContext);
      if (bool) {
        HMSLog.i("AutoInit", "Push init start");
        (new Thread((Runnable)new f(paramContext))).start();
        return;
      } 
    } catch (Exception exception) {
      HMSLog.e("AutoInit", "Push init failed", exception);
    } 
  }
  
  public static boolean isAutoInitEnabled(Context paramContext) {
    i i = i.a(paramContext);
    if (i.containsKey("push_kit_auto_init_enabled"))
      return i.getBoolean("push_kit_auto_init_enabled"); 
    try {
      return (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.getBoolean("push_kit_auto_init_enabled");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  public static void setAutoInitEnabled(Context paramContext, boolean paramBoolean) {
    i i = i.a(paramContext);
    boolean bool = i.getBoolean("push_kit_auto_init_enabled");
    i.saveBoolean("push_kit_auto_init_enabled", paramBoolean);
    if (paramBoolean && !bool)
      doAutoInit(paramContext); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\init\AutoInitHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */