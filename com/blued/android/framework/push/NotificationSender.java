package com.blued.android.framework.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.blued.android.core.AppInfo;

public class NotificationSender {
  public static final String a = NotificationSender.class.getSimpleName();
  
  private static NotificationSender b;
  
  private NotificationManager c;
  
  private NotificationManager a(NotificationChannel paramNotificationChannel) {
    if (this.c == null)
      this.c = (NotificationManager)AppInfo.d().getSystemService("notification"); 
    if (Build.VERSION.SDK_INT >= 26) {
      NotificationManager notificationManager = this.c;
      if (notificationManager != null && paramNotificationChannel != null)
        notificationManager.createNotificationChannel(paramNotificationChannel); 
    } 
    return this.c;
  }
  
  public static NotificationSender a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/push/NotificationSender.b : Lcom/blued/android/framework/push/NotificationSender;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/framework/push/NotificationSender
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/push/NotificationSender.b : Lcom/blued/android/framework/push/NotificationSender;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/framework/push/NotificationSender
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/push/NotificationSender.b : Lcom/blued/android/framework/push/NotificationSender;
    //   25: ldc com/blued/android/framework/push/NotificationSender
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/framework/push/NotificationSender
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/framework/push/NotificationSender.b : Lcom/blued/android/framework/push/NotificationSender;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private NotificationChannel b(NotificationModel paramNotificationModel) {
    NotificationChannel notificationChannel = new NotificationChannel("blued", "Blued", 4);
    notificationChannel.enableVibration(false);
    notificationChannel.setSound(null, null);
    if (paramNotificationModel.getRemindEnable()) {
      NotificationChannel notificationChannel1;
      if (paramNotificationModel.getShakeEnable() && paramNotificationModel.getVoiceEnable()) {
        notificationChannel = new NotificationChannel("blued.sound.vibrate", "Blued", 4);
        if (paramNotificationModel.getInnerVoiceEnable()) {
          notificationChannel = new NotificationChannel("blued.bSound.vibrate", "Blued", 4);
          notificationChannel.setSound(paramNotificationModel.getSoundFileUri(), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        } 
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[] { 0L, 100L, 200L, 300L });
        return notificationChannel;
      } 
      if (paramNotificationModel.getShakeEnable()) {
        notificationChannel1 = new NotificationChannel("blued.vibrate", "Blued", 4);
        notificationChannel1.setSound(null, null);
        notificationChannel1.enableVibration(true);
        notificationChannel1.setVibrationPattern(new long[] { 0L, 100L, 200L, 300L });
        return notificationChannel1;
      } 
      if (notificationChannel1.getVoiceEnable()) {
        if (notificationChannel1.getInnerVoiceEnable()) {
          notificationChannel = new NotificationChannel("blued.bSound", "Blued", 4);
          notificationChannel.setSound(notificationChannel1.getSoundFileUri(), null);
          return notificationChannel;
        } 
        return new NotificationChannel("blued.sound", "Blued", 4);
      } 
    } 
    return notificationChannel;
  }
  
  public void a(int paramInt) {
    a((NotificationChannel)null).cancel(paramInt);
  }
  
  public void a(NotificationModel paramNotificationModel) {
    NotificationChannel notificationChannel;
    int i = paramNotificationModel.getIconResId();
    long l = System.currentTimeMillis();
    Intent intent = paramNotificationModel.getIntent();
    PendingIntent pendingIntent = PendingIntent.getActivity(AppInfo.d(), 134217728, intent, 134217728);
    if (paramNotificationModel.intent_flag == 1)
      pendingIntent = PendingIntent.getBroadcast(AppInfo.d(), 134217728, intent, 134217728); 
    NotificationCompat.Builder builder = (new NotificationCompat.Builder(AppInfo.d())).setSmallIcon(i).setTicker(paramNotificationModel.getTickerText()).setWhen(l).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(paramNotificationModel.getContentTitle()).setContentText(paramNotificationModel.getContentText());
    if (paramNotificationModel.getBitmap() != null) {
      builder.setLargeIcon(paramNotificationModel.getBitmap());
    } else if (paramNotificationModel.getBitmapDef() != null) {
      builder.setLargeIcon(paramNotificationModel.getBitmapDef());
    } 
    pendingIntent = null;
    if (Build.VERSION.SDK_INT >= 26) {
      notificationChannel = b(paramNotificationModel);
      builder.setChannelId(notificationChannel.getId());
    } 
    if (paramNotificationModel.getStyle() != null) {
      builder.setStyle(paramNotificationModel.getStyle());
      builder.setVisibility(1);
      builder.setPriority(0);
    } 
    Notification notification = builder.build();
    if (paramNotificationModel.getRemindEnable())
      if (paramNotificationModel.getShakeEnable() && paramNotificationModel.getVoiceEnable()) {
        if (paramNotificationModel.getInnerVoiceEnable()) {
          notification.sound = paramNotificationModel.getSoundFileUri();
        } else {
          notification.defaults = 1;
        } 
        notification.defaults |= 0x2;
      } else if (paramNotificationModel.getShakeEnable()) {
        notification.defaults |= 0x2;
      } else if (paramNotificationModel.getVoiceEnable()) {
        if (paramNotificationModel.getInnerVoiceEnable()) {
          notification.sound = paramNotificationModel.getSoundFileUri();
        } else {
          notification.defaults = 1;
        } 
      }  
    notification.defaults |= 0x4;
    notification.flags |= 0x10;
    notification.flags |= 0x1;
    try {
      a(notificationChannel).notify(paramNotificationModel.getId(), notification);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\push\NotificationSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */