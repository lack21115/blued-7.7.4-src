package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;

public class UIUtil {
  public static Activity getActiveActivity(Activity paramActivity, Context paramContext) {
    StringBuilder stringBuilder;
    if (isBackground(paramContext)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("isBackground");
      stringBuilder.append(isBackground(paramContext));
      HMSLog.i("UIUtil", stringBuilder.toString());
      return null;
    } 
    if (stringBuilder == null || stringBuilder.isFinishing()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("activity is ");
      stringBuilder1.append(stringBuilder);
      stringBuilder1.append("activity isFinishing is ");
      stringBuilder1.append(stringBuilder.isFinishing());
      HMSLog.i("UIUtil", stringBuilder1.toString());
      return ActivityMgr.INST.getCurrentActivity();
    } 
    return (Activity)stringBuilder;
  }
  
  public static String getProcessName(Context paramContext, int paramInt) {
    if (paramContext == null)
      return ""; 
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    if (activityManager != null) {
      List list = activityManager.getRunningAppProcesses();
      if (list != null)
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
          if (runningAppProcessInfo.pid == paramInt)
            return runningAppProcessInfo.processName; 
        }  
    } 
    return "";
  }
  
  public static boolean isActivityFullscreen(Activity paramActivity) {
    return (((paramActivity.getWindow().getAttributes()).flags & 0x400) == 1024);
  }
  
  public static boolean isBackground(Context paramContext) {
    boolean bool2 = true;
    if (paramContext == null)
      return true; 
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    KeyguardManager keyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
    boolean bool1 = bool2;
    if (activityManager != null) {
      if (keyguardManager == null)
        return true; 
      List list = activityManager.getRunningAppProcesses();
      if (list == null)
        return true; 
      String str = getProcessName(paramContext, Process.myPid());
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = list.iterator();
      while (true) {
        bool1 = bool2;
        if (iterator.hasNext()) {
          ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
          if (TextUtils.equals(runningAppProcessInfo.processName, str)) {
            boolean bool;
            boolean bool3;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("appProcess.importance is ");
            stringBuilder.append(runningAppProcessInfo.importance);
            HMSLog.i("UIUtil", stringBuilder.toString());
            if (runningAppProcessInfo.importance == 100) {
              bool = true;
            } else {
              bool = false;
            } 
            if (Build.VERSION.SDK_INT > 22) {
              bool3 = keyguardManager.isDeviceLocked();
            } else {
              bool3 = keyguardManager.inKeyguardRestrictedInputMode();
            } 
            stringBuilder = new StringBuilder();
            stringBuilder.append("isForground is ");
            stringBuilder.append(bool);
            stringBuilder.append("***  isLockedState is ");
            stringBuilder.append(bool3);
            HMSLog.i("UIUtil", stringBuilder.toString());
            bool1 = bool2;
            if (bool) {
              if (bool3)
                return true; 
              bool1 = false;
            } 
            break;
          } 
          continue;
        } 
        break;
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\UIUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */