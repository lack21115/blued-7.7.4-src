package com.blued.android.module.yy_china;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.blued.android.framework.utils.Logger;

public class NotificationService extends Service {
  private NotificationManager a;
  
  private int b = R.string.notification_live_start;
  
  private String a(String paramString1, String paramString2) {
    NotificationChannel notificationChannel = new NotificationChannel(paramString1, paramString2, 0);
    notificationChannel.setLightColor(-16776961);
    notificationChannel.setLockscreenVisibility(0);
    ((NotificationManager)getSystemService("notification")).createNotificationChannel(notificationChannel);
    return paramString1;
  }
  
  private void a() {
    PendingIntent pendingIntent = PendingIntent.getActivity((Context)this, 0, new Intent((Context)this, NotificationService.class), 0);
    if (Build.VERSION.SDK_INT >= 26) {
      notification = (new Notification.Builder((Context)this, a("my_service", "My Background Service"))).setSmallIcon(R.drawable.ic_launcher).setTicker("正在通话").setContentTitle(getText(R.string.notification_live_start)).setContentTitle("正在运行").setContentIntent(pendingIntent).build();
      Logger.c("NotificationService", new Object[] { "显示通知" });
      this.a.notify(this.b, notification);
      startForeground(R.string.notification_live_start, notification);
      return;
    } 
    Notification notification = (new Notification.Builder((Context)this)).setSmallIcon(R.drawable.ic_launcher).setTicker("正在通话").setContentTitle(getText(R.string.notification_live_start)).setContentTitle("正在运行").setContentIntent((PendingIntent)notification).build();
    Logger.c("NotificationService", new Object[] { "显示通知" });
    this.a.notify(this.b, notification);
    startForeground(R.string.notification_live_start, notification);
  }
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onCreate() {
    super.onCreate();
    this.a = (NotificationManager)getSystemService("notification");
    a();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.a.cancel(this.b);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\NotificationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */