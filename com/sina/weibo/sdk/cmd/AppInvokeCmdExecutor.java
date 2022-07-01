package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.SDKNotification;

class AppInvokeCmdExecutor implements CmdExecutor<AppInvokeCmd> {
  private static final int NOTIFICATION_ID = 2;
  
  private static final int SHOW_NOTICIATION = 1;
  
  private Context mContext;
  
  private NotificationHandler mHandler;
  
  public AppInvokeCmdExecutor(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new NotificationHandler(this.mContext.getMainLooper());
  }
  
  private static PendingIntent buildInvokePendingIntent(Context paramContext, AppInvokeCmd paramAppInvokeCmd) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getScheme : ()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual getUrl : ()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual getAppPackage : ()Ljava/lang/String;
    //   15: invokestatic buildOpenSchemeIntent : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull -> 50
    //   23: aload_0
    //   24: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   27: aload_1
    //   28: ldc 65536
    //   30: invokevirtual queryIntentActivities : (Landroid/content/Intent;I)Ljava/util/List;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull -> 50
    //   38: aload_2
    //   39: invokeinterface isEmpty : ()Z
    //   44: ifne -> 50
    //   47: goto -> 52
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_2
    //   54: aload_1
    //   55: ifnonnull -> 63
    //   58: aload_3
    //   59: invokestatic buildOpenUrlIntent : (Ljava/lang/String;)Landroid/content/Intent;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull -> 83
    //   67: aload_2
    //   68: ldc 268435456
    //   70: invokevirtual setFlags : (I)Landroid/content/Intent;
    //   73: pop
    //   74: aload_0
    //   75: iconst_0
    //   76: aload_2
    //   77: ldc 134217728
    //   79: invokestatic getActivity : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   82: areturn
    //   83: aconst_null
    //   84: areturn
  }
  
  private static Intent buildOpenSchemeIntent(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && Uri.parse(paramString1).isHierarchical()) {
      Uri uri = Uri.parse(paramString1);
      Intent intent = new Intent();
      intent.setAction("android.intent.action.VIEW");
      intent.setData(uri);
      intent.setPackage(paramString2);
      return intent;
    } 
    return null;
  }
  
  private static Intent buildOpenUrlIntent(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    Uri uri = Uri.parse(paramString);
    String str = uri.getScheme();
    if (str.equalsIgnoreCase("http") || str.equalsIgnoreCase("https")) {
      Intent intent = new Intent();
      intent.setAction("android.intent.action.VIEW");
      intent.setData(uri);
      return intent;
    } 
    return null;
  }
  
  private static void showNotification(Context paramContext, AppInvokeCmd paramAppInvokeCmd) {
    SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(paramAppInvokeCmd.getNotificationText()).setNotificationPendingIntent(buildInvokePendingIntent(paramContext, paramAppInvokeCmd)).setNotificationTitle(paramAppInvokeCmd.getNotificationTitle()).setTickerText(paramAppInvokeCmd.getNotificationText()).build(paramContext).show(2);
  }
  
  public boolean doExecutor(AppInvokeCmd paramAppInvokeCmd) {
    if (paramAppInvokeCmd == null || TextUtils.isEmpty(paramAppInvokeCmd.getNotificationText()) || TextUtils.isEmpty(paramAppInvokeCmd.getScheme()))
      return false; 
    Message message = this.mHandler.obtainMessage();
    message.what = 1;
    message.obj = paramAppInvokeCmd;
    this.mHandler.sendMessageDelayed(message, paramAppInvokeCmd.getNotificationDelay());
    return true;
  }
  
  class NotificationHandler extends Handler {
    public NotificationHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      if (param1Message.what != 1)
        return; 
      AppInvokeCmdExecutor.showNotification(AppInvokeCmdExecutor.this.mContext, (AppInvokeCmd)param1Message.obj);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\cmd\AppInvokeCmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */