package com.soft.blued.view.tip;

import android.app.Notification;
import android.app.NotificationManager;
import com.blued.android.core.AppInfo;
import java.util.concurrent.atomic.AtomicLong;

public class CommonNotification {
  public static String a;
  
  private static CommonNotification b;
  
  private static AtomicLong e = new AtomicLong(0L);
  
  private Notification c;
  
  private String d = "Blued";
  
  static {
    a = "notification_from_tab";
  }
  
  public CommonNotification() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AppInfo.d().getResources().getString(2131755304));
    stringBuilder.append(AppInfo.d().getResources().getString(2131755505));
    this.d = stringBuilder.toString();
    this.c = new Notification(2131231104, this.d, System.currentTimeMillis());
  }
  
  public static void a() {
    try {
      ((NotificationManager)AppInfo.d().getSystemService("notification")).cancelAll();
      return;
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\CommonNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */