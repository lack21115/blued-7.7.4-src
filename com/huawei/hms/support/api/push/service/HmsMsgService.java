package com.huawei.hms.support.api.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.c;
import com.huawei.hms.support.api.push.pushselfshow.SelfShow;
import com.huawei.hms.support.api.push.utils.common.NotificationUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService extends Service {
  public static final String TAG = "HmsMsgService";
  
  public static void invokeSelfShow(Context paramContext, Bundle paramBundle) {
    if (!NotificationUtil.areNotificationsEnabled(paramContext)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(" disable display notification.");
      HMSLog.i("HmsMsgService", stringBuilder.toString());
    } 
    Intent intent = new Intent();
    intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
    intent.putExtra("selfshow_info", c.a(paramBundle, "selfshow_info"));
    intent.putExtra("selfshow_token", c.a(paramBundle, "selfshow_token"));
    intent.setPackage(c.c(paramBundle, "push_package"));
    SelfShow.onReceive(paramContext, intent);
    HMSLog.i("HmsMsgService", "invokeSelfShow done");
  }
  
  public static void sendBroadcastToHms(Context paramContext, Bundle paramBundle) {
    try {
      Intent intent = new Intent();
      intent.setAction("com.huawei.android.push.intent.RECEIVE");
      intent.putExtra("msg_data", c.a(paramBundle, "msg_data"));
      intent.putExtra("device_token", c.a(paramBundle, "device_token"));
      intent.putExtra("msgIdStr", c.c(paramBundle, "msgIdStr"));
      intent.setFlags(32);
      intent.setPackage(c.c(paramBundle, "push_package"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(".permission.PROCESS_PUSH_MSG");
      paramContext.sendBroadcast(intent, stringBuilder.toString());
      HMSLog.i("HmsMsgService", "send broadcast passby done");
      return;
    } catch (SecurityException securityException) {
      HMSLog.i("HmsMsgService", "send broadcast SecurityException");
      return;
    } catch (Exception exception) {
      HMSLog.i("HmsMsgService", "send broadcast Exception");
      return;
    } 
  }
  
  public IBinder onBind(Intent paramIntent) {
    HMSLog.i("HmsMsgService", "onBind");
    Messenger messenger = new Messenger(new PushHandler((Context)this));
    stopService(paramIntent);
    return messenger.getBinder();
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 26)
      stopForeground(true); 
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    HMSLog.i("HmsMsgService", "Enter onStartCommand.");
    if (Build.VERSION.SDK_INT >= 26) {
      NotificationChannel notificationChannel = new NotificationChannel("HwPushChannelID", "pushKit", 3);
      notificationChannel.enableVibration(false);
      NotificationManager notificationManager = (NotificationManager)getSystemService("notification");
      if (notificationManager != null)
        notificationManager.createNotificationChannel(notificationChannel); 
      Notification.Builder builder = new Notification.Builder((Context)this, "HwPushChannelID");
      builder.setAutoCancel(true);
      startForeground(1, builder.build());
    } 
    return 2;
  }
  
  public static class PushHandler extends Handler {
    public Context context;
    
    public PushHandler(Context param1Context) {
      this.context = param1Context;
    }
    
    public void handleMessage(Message param1Message) {
      Bundle bundle = param1Message.getData();
      if (Build.VERSION.SDK_INT >= 21) {
        if (Objects.equals(this.context.getApplicationContext().getPackageManager().getNameForUid(param1Message.sendingUid), HMSPackageManager.getInstance(this.context).getHMSPackageName()) && bundle != null)
          if (HMSPackageManager.getInstance(this.context).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED) {
            HMSLog.i("HmsMsgService", "service not start by hms");
          } else {
            HMSLog.i("HmsMsgService", "chose push type");
            if (Objects.equals(c.b(bundle, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
              if (ResourceLoaderUtil.getmContext() == null)
                ResourceLoaderUtil.setmContext(this.context.getApplicationContext()); 
              HMSLog.i("HmsMsgService", "invokeSelfShow");
              HmsMsgService.invokeSelfShow(this.context, bundle);
            } else if (Objects.equals(c.b(bundle, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
              HMSLog.i("HmsMsgService", "sendBroadcastToHms");
              HmsMsgService.sendBroadcastToHms(this.context, bundle);
            } 
          }  
        super.handleMessage(param1Message);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\service\HmsMsgService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */