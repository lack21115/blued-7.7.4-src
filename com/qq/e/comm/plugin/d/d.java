package com.qq.e.comm.plugin.d;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

public class d {
  public static NotificationManager a(Context paramContext) {
    NotificationManager notificationManager2 = null;
    NotificationManager notificationManager1 = notificationManager2;
    if (paramContext != null) {
      NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
      notificationManager1 = notificationManager2;
      if (notificationManager != null) {
        if (Build.VERSION.SDK_INT >= 26) {
          ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
          if (applicationInfo != null && applicationInfo.targetSdkVersion >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("TencentAdNetCH1", "TencentAdNetCH1", 2);
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            notificationManager.createNotificationChannel(notificationChannel);
          } 
        } 
        notificationManager1 = notificationManager;
      } 
    } 
    return notificationManager1;
  }
  
  public static void a(Context paramContext, Notification.Builder paramBuilder) {
    if (Build.VERSION.SDK_INT >= 26 && paramBuilder != null && paramContext != null && paramContext.getApplicationInfo() != null && (paramContext.getApplicationInfo()).targetSdkVersion >= 26)
      paramBuilder.setChannelId("TencentAdNetCH1"); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */