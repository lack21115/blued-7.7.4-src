package com.soft.blued.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;

public class NotificationHelper {
  private static final long[] a = new long[] { 200L, 200L, 200L, 200L };
  
  private Context b;
  
  private NotificationManager c;
  
  private NotificationManager a() {
    if (this.c == null)
      this.c = (NotificationManager)this.b.getSystemService("notification"); 
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\NotificationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */