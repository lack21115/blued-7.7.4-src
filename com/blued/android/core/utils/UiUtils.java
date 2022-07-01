package com.blued.android.core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;
import com.blued.android.core.AppMethods;
import java.util.List;

public class UiUtils {
  public static boolean a(Activity paramActivity) {
    return AppMethods.c(17) ? b(paramActivity) : (!(paramActivity == null || paramActivity.isFinishing()));
  }
  
  public static boolean a(Context paramContext) {
    if (!((PowerManager)paramContext.getSystemService("power")).isScreenOn())
      return false; 
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      List list = activityManager.getRunningAppProcesses();
      if (list != null) {
        if (activityManager == null)
          return false; 
        String str = paramContext.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
          if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
            List list1 = activityManager.getRunningTasks(1);
            if (!list1.isEmpty()) {
              ComponentName componentName = ((ActivityManager.RunningTaskInfo)list1.get(0)).topActivity;
              if (componentName != null && componentName.getPackageName().equals(str))
                return true; 
            } 
          } 
        } 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean b(Activity paramActivity) {
    return !(paramActivity == null || paramActivity.isFinishing() || paramActivity.isDestroyed());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\UiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */