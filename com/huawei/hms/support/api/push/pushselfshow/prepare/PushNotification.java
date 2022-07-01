package com.huawei.hms.support.api.push.pushselfshow.prepare;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;
import com.huawei.hms.support.api.push.pushselfshow.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;

public class PushNotification {
  public static final int AUTO_CLEAR_INDEX = 3;
  
  public static final int DELETE_INDEX = 2;
  
  public static int IDX = 0;
  
  public static final int NOTIFY_ID_ARR_LEN = 4;
  
  public static final int NOTIFY_ID_INDEX = 0;
  
  public static final int OPEN_INDEX = 1;
  
  public static final String TAG = "PushSelfShowLog";
  
  public static Notification getBuilderNotification(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, int[] paramArrayOfint) {
    Notification.Builder builder = new Notification.Builder(paramContext);
    if (NotificationUtils.getStyle(paramPushSelfShowMessage) == NotifyStyle.STYLE_BIGTEXT)
      NotificationUtils.initBigTextStyleBuilder(builder, paramPushSelfShowMessage.getBigContent(), paramPushSelfShowMessage); 
    NotificationIconUtil.setSmallIcon(paramContext, builder, paramPushSelfShowMessage);
    setSubText(paramPushSelfShowMessage, builder);
    setTitleContent(paramContext, paramPushSelfShowMessage, builder);
    setLargeIcon(paramContext, paramPushSelfShowMessage, builder);
    setWhen(builder);
    setAutoCancel(paramPushSelfShowMessage, builder);
    setTicker(paramPushSelfShowMessage, builder);
    builder.setContentIntent(getPendingOpenIntent(paramContext, paramPushSelfShowMessage, paramArrayOfint));
    builder.setDeleteIntent(getPendingDeleteIntent(paramContext, paramPushSelfShowMessage, paramArrayOfint));
    if (Build.VERSION.SDK_INT >= 26)
      builder.setChannelId("HwPushChannelID"); 
    setOriginPkgname(paramContext, builder, paramPushSelfShowMessage);
    setNotifyAppName(paramContext, builder, paramPushSelfShowMessage);
    return builder.build();
  }
  
  public static Intent getIntent(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, int[] paramArrayOfint, String paramString, int paramInt) {
    Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    intent.putExtra("selfshow_info", paramPushSelfShowMessage.getMsgData()).putExtra("selfshow_token", paramPushSelfShowMessage.getToken()).putExtra("selfshow_event_id", paramString).putExtra("selfshow_notify_id", paramArrayOfint[0]).putExtra("selfshow_auto_clear_id", paramArrayOfint[3]).setPackage(paramContext.getPackageName()).setFlags(paramInt);
    return intent;
  }
  
  public static PendingIntent getPendingDeleteIntent(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, int[] paramArrayOfint) {
    Intent intent = getIntent(paramContext, paramPushSelfShowMessage, paramArrayOfint, "2", 268435456);
    return PendingIntent.getBroadcast(paramContext, paramArrayOfint[2], intent, 134217728);
  }
  
  public static PendingIntent getPendingOpenIntent(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, int[] paramArrayOfint) {
    Intent intent = getIntent(paramContext, paramPushSelfShowMessage, paramArrayOfint, "1", 268435456);
    return PendingIntent.getBroadcast(paramContext, paramArrayOfint[1], intent, 134217728);
  }
  
  public static void setAutoCancel(PushSelfShowMessage paramPushSelfShowMessage, Notification.Builder paramBuilder) {
    int i = paramPushSelfShowMessage.getAutoCancel();
    boolean bool = true;
    if (i != 1)
      bool = false; 
    paramBuilder.setAutoCancel(bool);
    paramBuilder.setOngoing(false);
  }
  
  public static void setAutoClear(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, int[] paramArrayOfint) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAutoClear time is: ");
    stringBuilder.append(paramPushSelfShowMessage.getAutoClear());
    HMSLog.i("PushSelfShowLog", stringBuilder.toString());
    if (paramPushSelfShowMessage.getAutoClear() <= 0)
      return; 
    setDelayAlarm(paramContext, getIntent(paramContext, paramPushSelfShowMessage, paramArrayOfint, "-1", 32), paramPushSelfShowMessage.getAutoClear(), paramArrayOfint[3]);
  }
  
  public static void setDelayAlarm(Context paramContext, Intent paramIntent, long paramLong, int paramInt) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("enter setDelayAlarm(intent:");
      stringBuilder.append(paramIntent.toURI());
      stringBuilder.append(" interval:");
      stringBuilder.append(paramLong);
      stringBuilder.append("ms, context:");
      stringBuilder.append(paramContext);
      HMSLog.d("PushSelfShowLog", stringBuilder.toString());
      AlarmManager alarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (alarmManager != null) {
        PendingIntent pendingIntent = PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 134217728);
        alarmManager.set(0, System.currentTimeMillis() + paramLong, pendingIntent);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set DelayAlarm error");
      stringBuilder.append(exception.toString());
      HMSLog.w("PushSelfShowLog", stringBuilder.toString());
    } 
  }
  
  public static void setLargeIcon(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, Notification.Builder paramBuilder) {
    Bitmap bitmap = NotificationIconUtil.buildLeftIcon(paramContext, paramPushSelfShowMessage);
    if (bitmap != null)
      paramBuilder.setLargeIcon(bitmap); 
  }
  
  public static void setNotifyAppName(Context paramContext, Notification.Builder paramBuilder, PushSelfShowMessage paramPushSelfShowMessage) {
    if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && CommFun.isCurrentHMS(paramContext)) {
      Bundle bundle = new Bundle();
      String str = paramPushSelfShowMessage.getDispPkgName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("the package name of notification is:");
      stringBuilder.append(str);
      HMSLog.i("PushSelfShowLog", stringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        String str1 = CommFun.getAppName(paramContext, str);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("the app name is:");
        stringBuilder1.append(str1);
        HMSLog.i("PushSelfShowLog", stringBuilder1.toString());
        if (str1 != null)
          bundle.putCharSequence("android.extraAppName", str1); 
      } 
      paramBuilder.setExtras(bundle);
    } 
  }
  
  public static void setOriginPkgname(Context paramContext, Notification.Builder paramBuilder, PushSelfShowMessage paramPushSelfShowMessage) {
    if ("com.huawei.android.pushagent".equals(paramContext.getPackageName())) {
      Bundle bundle = new Bundle();
      String str = paramPushSelfShowMessage.getDispPkgName();
      if (!TextUtils.isEmpty(str)) {
        bundle.putString("hw_origin_sender_package_name", str);
        paramBuilder.setExtras(bundle);
      } 
    } 
  }
  
  public static void setSubText(PushSelfShowMessage paramPushSelfShowMessage, Notification.Builder paramBuilder) {
    String str = paramPushSelfShowMessage.getNotifySummary();
    if (!TextUtils.isEmpty(str))
      paramBuilder.setSubText(str); 
  }
  
  public static void setTicker(PushSelfShowMessage paramPushSelfShowMessage, Notification.Builder paramBuilder) {
    paramBuilder.setTicker(paramPushSelfShowMessage.getTicker());
  }
  
  public static void setTitleContent(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage, Notification.Builder paramBuilder) {
    String str1;
    if (TextUtils.isEmpty(paramPushSelfShowMessage.getNotifyTitle())) {
      int i = (paramContext.getApplicationInfo()).labelRes;
      str1 = paramContext.getResources().getString(i);
    } else {
      str1 = paramPushSelfShowMessage.getNotifyTitle();
    } 
    String str2 = paramPushSelfShowMessage.getContent();
    paramBuilder.setContentTitle(str1);
    paramBuilder.setContentText(str2);
  }
  
  public static void setWhen(Notification.Builder paramBuilder) {
    paramBuilder.setShowWhen(true);
    paramBuilder.setWhen(System.currentTimeMillis());
  }
  
  public static void showNotification(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    // Byte code:
    //   0: ldc com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 660
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: goto -> 660
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #6
    //   23: aload #6
    //   25: ldc_w ' showNotification , the msg id = '
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #6
    //   34: aload_1
    //   35: invokevirtual getMsgId : ()Ljava/lang/String;
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 'PushSelfShowLog'
    //   44: aload #6
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   55: ifne -> 97
    //   58: new java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial <init> : ()V
    //   65: astore #6
    //   67: aload #6
    //   69: aload_0
    //   70: invokevirtual getPackageName : ()Ljava/lang/String;
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #6
    //   79: invokestatic currentTimeMillis : ()J
    //   82: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload #6
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: invokevirtual hashCode : ()I
    //   94: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   97: aload_1
    //   98: invokevirtual getGroup : ()Ljava/lang/String;
    //   101: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   104: ifeq -> 322
    //   107: aload_1
    //   108: invokevirtual getMsgTag : ()Ljava/lang/String;
    //   111: astore #6
    //   113: aload #6
    //   115: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   118: ifne -> 167
    //   121: aload #6
    //   123: invokevirtual hashCode : ()I
    //   126: istore_2
    //   127: aload_1
    //   128: iload_2
    //   129: invokevirtual setNotifyId : (I)V
    //   132: new java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: astore #6
    //   141: aload #6
    //   143: ldc_w 'notification msgTag = '
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload #6
    //   152: iload_2
    //   153: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 'PushSelfShowLog'
    //   159: aload #6
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_1
    //   168: invokevirtual getNotifyId : ()I
    //   171: iconst_m1
    //   172: if_icmpeq -> 275
    //   175: aload_1
    //   176: invokevirtual getNotifyId : ()I
    //   179: istore_3
    //   180: new java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore #6
    //   189: aload #6
    //   191: aload_1
    //   192: invokevirtual getDispPkgName : ()Ljava/lang/String;
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload #6
    //   201: invokestatic currentTimeMillis : ()J
    //   204: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #6
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: invokevirtual hashCode : ()I
    //   216: istore #4
    //   218: iload #4
    //   220: iconst_1
    //   221: iadd
    //   222: istore #5
    //   224: new java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial <init> : ()V
    //   231: astore #6
    //   233: aload #6
    //   235: aload_1
    //   236: invokevirtual getNotifyId : ()I
    //   239: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload #6
    //   245: aload_1
    //   246: invokevirtual getDispPkgName : ()Ljava/lang/String;
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #6
    //   255: aload_0
    //   256: invokevirtual getPackageName : ()Ljava/lang/String;
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload #6
    //   265: invokevirtual toString : ()Ljava/lang/String;
    //   268: invokevirtual hashCode : ()I
    //   271: istore_2
    //   272: goto -> 432
    //   275: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   278: iconst_1
    //   279: iadd
    //   280: istore_3
    //   281: iload_3
    //   282: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   285: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   288: iconst_1
    //   289: iadd
    //   290: istore #4
    //   292: iload #4
    //   294: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   297: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   300: iconst_1
    //   301: iadd
    //   302: istore #5
    //   304: iload #5
    //   306: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   309: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   312: iconst_1
    //   313: iadd
    //   314: istore_2
    //   315: iload_2
    //   316: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   319: goto -> 432
    //   322: new java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial <init> : ()V
    //   329: astore #6
    //   331: aload #6
    //   333: aload_1
    //   334: invokevirtual getGroup : ()Ljava/lang/String;
    //   337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload #6
    //   343: aload_1
    //   344: invokevirtual getDispPkgName : ()Ljava/lang/String;
    //   347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload #6
    //   353: invokevirtual toString : ()Ljava/lang/String;
    //   356: invokevirtual hashCode : ()I
    //   359: istore_3
    //   360: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   363: iconst_1
    //   364: iadd
    //   365: istore #4
    //   367: iload #4
    //   369: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   372: getstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   375: iconst_1
    //   376: iadd
    //   377: istore #5
    //   379: iload #5
    //   381: putstatic com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification.IDX : I
    //   384: new java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial <init> : ()V
    //   391: astore #6
    //   393: aload #6
    //   395: aload_1
    //   396: invokevirtual getGroup : ()Ljava/lang/String;
    //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload #6
    //   405: aload_1
    //   406: invokevirtual getDispPkgName : ()Ljava/lang/String;
    //   409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload #6
    //   415: aload_0
    //   416: invokevirtual getPackageName : ()Ljava/lang/String;
    //   419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload #6
    //   425: invokevirtual toString : ()Ljava/lang/String;
    //   428: invokevirtual hashCode : ()I
    //   431: istore_2
    //   432: new java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: astore #6
    //   441: aload #6
    //   443: ldc_w 'notifyId:'
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload #6
    //   452: iload_3
    //   453: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload #6
    //   459: ldc_w ',openNotifyId:'
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #6
    //   468: iload #4
    //   470: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload #6
    //   476: ldc_w ',delNotifyId:'
    //   479: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload #6
    //   485: iload #5
    //   487: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload #6
    //   493: ldc_w ',alarmNotifyId:'
    //   496: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload #6
    //   502: iload_2
    //   503: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: ldc 'PushSelfShowLog'
    //   509: aload #6
    //   511: invokevirtual toString : ()Ljava/lang/String;
    //   514: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   517: iconst_4
    //   518: newarray int
    //   520: astore #7
    //   522: aload #7
    //   524: iconst_0
    //   525: iload_3
    //   526: iastore
    //   527: aload #7
    //   529: iconst_1
    //   530: iload #4
    //   532: iastore
    //   533: aload #7
    //   535: iconst_2
    //   536: iload #5
    //   538: iastore
    //   539: aload_1
    //   540: invokevirtual getAutoClear : ()I
    //   543: ifle -> 664
    //   546: goto -> 549
    //   549: aload #7
    //   551: iconst_3
    //   552: iload_2
    //   553: iastore
    //   554: aconst_null
    //   555: astore #6
    //   557: invokestatic isSupportLargeIcon : ()Z
    //   560: ifeq -> 572
    //   563: aload_0
    //   564: aload_1
    //   565: aload #7
    //   567: invokestatic getBuilderNotification : (Landroid/content/Context;Lcom/huawei/hms/support/api/push/pushselfshow/entity/PushSelfShowMessage;[I)Landroid/app/Notification;
    //   570: astore #6
    //   572: aload_0
    //   573: ldc_w 'notification'
    //   576: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   579: checkcast android/app/NotificationManager
    //   582: astore #8
    //   584: aload #8
    //   586: ifnull -> 650
    //   589: aload #6
    //   591: ifnull -> 650
    //   594: getstatic android/os/Build$VERSION.SDK_INT : I
    //   597: bipush #26
    //   599: if_icmplt -> 627
    //   602: aload #8
    //   604: new android/app/NotificationChannel
    //   607: dup
    //   608: ldc 'HwPushChannelID'
    //   610: aload_0
    //   611: ldc_w 'hms_push_channel'
    //   614: invokestatic getStringId : (Ljava/lang/String;)I
    //   617: invokevirtual getString : (I)Ljava/lang/String;
    //   620: iconst_3
    //   621: invokespecial <init> : (Ljava/lang/String;Ljava/lang/CharSequence;I)V
    //   624: invokevirtual createNotificationChannel : (Landroid/app/NotificationChannel;)V
    //   627: aload #8
    //   629: iload_3
    //   630: aload #6
    //   632: invokevirtual notify : (ILandroid/app/Notification;)V
    //   635: aload_0
    //   636: aload_1
    //   637: aload #7
    //   639: invokestatic setAutoClear : (Landroid/content/Context;Lcom/huawei/hms/support/api/push/pushselfshow/entity/PushSelfShowMessage;[I)V
    //   642: aload_0
    //   643: ldc_w '100'
    //   646: aload_1
    //   647: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Lcom/huawei/hms/support/api/push/pushselfshow/entity/PushSelfShowMessage;)V
    //   650: ldc com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification
    //   652: monitorexit
    //   653: return
    //   654: astore_0
    //   655: ldc com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification
    //   657: monitorexit
    //   658: aload_0
    //   659: athrow
    //   660: ldc com/huawei/hms/support/api/push/pushselfshow/prepare/PushNotification
    //   662: monitorexit
    //   663: return
    //   664: iconst_0
    //   665: istore_2
    //   666: goto -> 549
    // Exception table:
    //   from	to	target	type
    //   14	97	654	finally
    //   97	167	654	finally
    //   167	218	654	finally
    //   224	272	654	finally
    //   275	319	654	finally
    //   322	432	654	finally
    //   432	522	654	finally
    //   539	546	654	finally
    //   557	572	654	finally
    //   572	584	654	finally
    //   594	627	654	finally
    //   627	650	654	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\prepare\PushNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */