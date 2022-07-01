package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;

public class e {
  public static WebView a(Activity paramActivity, Context paramContext) {
    if (Build.VERSION.SDK_INT >= 28) {
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = null;
      try {
        Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      } finally {
        paramContext = null;
        System.out.println("proxy add data error");
      } 
    } 
    return new WebView((Context)paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */