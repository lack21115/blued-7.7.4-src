package com.blued.android.chat.grpc.backup;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.utils.ChatLog;
import java.io.Serializable;
import java.util.List;

public class MsgBackupService extends Service {
  public static final String INTENT_KEY_CONTENT = "CONTENT";
  
  public static final String INTENT_KEY_FILE_PATH = "FILE_PATH";
  
  public static final String INTENT_KEY_ICON_RES_ID = "ICON_RES_ID";
  
  public static final String INTENT_KEY_IS_RESTORE = "IS_RESTORE";
  
  public static final String INTENT_KEY_NOTIFY_ID = "NOTIFY_ID";
  
  public static final String INTENT_KEY_SELECTED_SESSION_ID = "SELECTED_SESSION_ID";
  
  public static final String INTENT_KEY_SUCCEED_MSG = "SUCCEED_MSG";
  
  public static final String INTENT_KEY_TITLE = "TITLE";
  
  public static final String INTENT_KEY_UPLOAD_SERVICE_CLASS = "UPLOAD_SERVICE_CLASS";
  
  private static volatile boolean isRunning = false;
  
  private String content;
  
  private String filePath;
  
  private Handler handler = new Handler(Looper.getMainLooper());
  
  private int iconResId;
  
  private boolean isRestore;
  
  private int notificationId;
  
  private List<Long> selectedSessionIds;
  
  private String succeedMsg;
  
  private String title;
  
  private Class uploadServiceClass;
  
  private Notification createForegroundNotification() {
    NotificationManager notificationManager = (NotificationManager)getSystemService("notification");
    if (Build.VERSION.SDK_INT >= 26) {
      NotificationChannel notificationChannel = new NotificationChannel("msg_backup", "Foreground_Service", 4);
      notificationChannel.setDescription("msg_backup");
      notificationChannel.enableLights(true);
      notificationChannel.setLightColor(-65536);
      notificationChannel.setVibrationPattern(new long[] { 0L, 0L, 0L, 0L });
      notificationChannel.enableVibration(false);
      if (notificationManager != null)
        notificationManager.createNotificationChannel(notificationChannel); 
    } 
    NotificationCompat.Builder builder = new NotificationCompat.Builder((Context)this, "msg_backup");
    builder.setSmallIcon(this.iconResId);
    builder.setContentTitle(this.title);
    builder.setContentText(this.content);
    builder.setWhen(System.currentTimeMillis());
    return builder.build();
  }
  
  public static boolean isRunning() {
    return isRunning;
  }
  
  public static void startMsgBackupService(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, List<Long> paramList, Class paramClass) {
    Intent intent = new Intent();
    intent.putExtra("NOTIFY_ID", paramInt1);
    intent.putExtra("ICON_RES_ID", paramInt2);
    intent.putExtra("TITLE", paramString1);
    intent.putExtra("CONTENT", paramString2);
    intent.putExtra("SUCCEED_MSG", paramString3);
    intent.putExtra("FILE_PATH", paramString4);
    intent.putExtra("IS_RESTORE", false);
    intent.putExtra("SELECTED_SESSION_ID", (Serializable)paramList);
    intent.putExtra("UPLOAD_SERVICE_CLASS", paramClass);
    intent.setClass(paramContext, MsgBackupService.class);
    paramContext.startService(intent);
  }
  
  public static void startMsgRestoreService(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {
    Intent intent = new Intent();
    intent.putExtra("NOTIFY_ID", paramInt1);
    intent.putExtra("ICON_RES_ID", paramInt2);
    intent.putExtra("TITLE", paramString1);
    intent.putExtra("CONTENT", paramString2);
    intent.putExtra("SUCCEED_MSG", paramString3);
    intent.putExtra("FILE_PATH", paramString4);
    intent.putExtra("IS_RESTORE", true);
    intent.setClass(paramContext, MsgBackupService.class);
    paramContext.startService(intent);
  }
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onDestroy() {
    super.onDestroy();
    isRunning = false;
    stopForeground(true);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    isRunning = true;
    this.notificationId = paramIntent.getIntExtra("NOTIFY_ID", 0);
    this.iconResId = paramIntent.getIntExtra("ICON_RES_ID", 0);
    this.title = paramIntent.getStringExtra("TITLE");
    this.content = paramIntent.getStringExtra("CONTENT");
    this.succeedMsg = paramIntent.getStringExtra("SUCCEED_MSG");
    this.filePath = paramIntent.getStringExtra("FILE_PATH");
    this.isRestore = paramIntent.getBooleanExtra("IS_RESTORE", false);
    this.selectedSessionIds = (List<Long>)paramIntent.getSerializableExtra("SELECTED_SESSION_ID");
    this.uploadServiceClass = (Class)paramIntent.getSerializableExtra("UPLOAD_SERVICE_CLASS");
    if (this.isRestore) {
      MsgBackupManager.getInstance().restoreMsgDb(this.filePath, new MsgBackupManager.ReserveListener() {
            public void onError(final String message) {
              MsgBackupService.this.handler.post(new Runnable() {
                    public void run() {
                      Toast.makeText((Context)MsgBackupService.this, message, 1).show();
                    }
                  });
              MsgBackupService.this.stopSelf();
            }
            
            public void onReserveSucceed(String param1String) {}
            
            public void onRestoreSucceed() {
              if (!TextUtils.isEmpty(MsgBackupService.this.succeedMsg))
                MsgBackupService.this.handler.post(new Runnable() {
                      public void run() {
                        MsgBackupService msgBackupService = MsgBackupService.this;
                        Toast.makeText((Context)msgBackupService, msgBackupService.succeedMsg, 0).show();
                      }
                    }); 
              MsgBackupService.this.stopSelf();
            }
            
            public void onStart() {
              Notification notification = MsgBackupService.this.createForegroundNotification();
              notification.flags |= 0x20;
              MsgBackupService msgBackupService = MsgBackupService.this;
              msgBackupService.startForeground(msgBackupService.notificationId, notification);
            }
          });
      return 1;
    } 
    if (ChatManager.debug) {
      List<Long> list = this.selectedSessionIds;
      if (list != null)
        for (Long long_ : list) {
          String str = MsgBackupService.class.getSimpleName();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("selectedSessionIds===");
          stringBuilder.append(long_);
          ChatLog.d(str, stringBuilder.toString());
        }  
    } 
    MsgBackupManager.getInstance().reserveMsgDb(this.filePath, this.selectedSessionIds, new MsgBackupManager.ReserveListener() {
          public void onError(final String message) {
            MsgBackupService.this.handler.post(new Runnable() {
                  public void run() {
                    Toast.makeText((Context)MsgBackupService.this, message, 1).show();
                  }
                });
            MsgBackupService.this.stopSelf();
          }
          
          public void onReserveSucceed(String param1String) {
            if (MsgBackupService.this.uploadServiceClass != null) {
              Intent intent = new Intent();
              intent.putExtra("FILE_PATH", param1String);
              MsgBackupService msgBackupService = MsgBackupService.this;
              intent.setClass((Context)msgBackupService, msgBackupService.uploadServiceClass);
              MsgBackupService.this.startService(intent);
            } else if (!TextUtils.isEmpty(MsgBackupService.this.succeedMsg)) {
              MsgBackupService.this.handler.post(new Runnable() {
                    public void run() {
                      MsgBackupService msgBackupService = MsgBackupService.this;
                      Toast.makeText((Context)msgBackupService, msgBackupService.succeedMsg, 0).show();
                    }
                  });
            } 
            MsgBackupService.this.stopSelf();
          }
          
          public void onRestoreSucceed() {}
          
          public void onStart() {}
        });
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\backup\MsgBackupService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */