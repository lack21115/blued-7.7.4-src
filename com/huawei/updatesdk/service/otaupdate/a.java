package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

public abstract class a {
  public static void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver) {
    if (paramBroadcastReceiver != null) {
      if (paramContext == null)
        return; 
      try {
        paramContext.unregisterReceiver(paramBroadcastReceiver);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unregisterReceiver error:");
        stringBuilder.append(illegalArgumentException.toString());
        com.huawei.updatesdk.a.a.b.a.a.a.b("ActivityUtil", stringBuilder.toString());
      } 
    } 
  }
  
  public static void a(Context paramContext, IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver) {
    if (paramIntentFilter != null) {
      if (paramBroadcastReceiver == null)
        return; 
      if (a(paramContext))
        return; 
      try {
        paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("registerReceiver error:");
        stringBuilder.append(illegalArgumentException.toString());
        com.huawei.updatesdk.a.a.b.a.a.a.b("ActivityUtil", stringBuilder.toString());
      } 
    } 
  }
  
  public static boolean a(Context paramContext) {
    if (paramContext == null)
      return true; 
    if (paramContext instanceof Activity) {
      Activity activity = (Activity)paramContext;
      if (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("activity has bean finished, cannot instance:");
        stringBuilder.append(activity);
        com.huawei.updatesdk.a.a.b.a.a.a.b("ActivityUtil", stringBuilder.toString());
        return true;
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */