package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Iterator;

public class d {
  public static void a(Context paramContext) {
    if (paramContext == null)
      return; 
    a.a(paramContext.getApplicationContext());
    if (Build.VERSION.SDK_INT < 28)
      return; 
    try {
      int i = Process.myPid();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(i);
      String str2 = stringBuilder.toString();
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      String str1 = str2;
      while (iterator.hasNext()) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
        if (runningAppProcessInfo.pid == i)
          str1 = runningAppProcessInfo.processName; 
      } 
      SSWebView.setDataDirectorySuffix(str1);
      return;
    } catch (Exception exception) {
      t.b(exception.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */