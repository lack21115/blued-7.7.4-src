package com.huawei.hms.support.api.push.pushselfshow;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.e;
import com.huawei.hms.support.api.push.pushselfshow.click.SelfShowType;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;
import com.huawei.hms.support.api.push.pushselfshow.prepare.PushSelfShowThread;
import com.huawei.hms.support.api.push.pushselfshow.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;

public class SelfShow {
  public static final String TAG = "PushSelfShowLog";
  
  public static void handlePushMsg(Context paramContext, Intent paramIntent, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    String str = paramIntent.getStringExtra("selfshow_event_id");
    int i = paramIntent.getIntExtra("selfshow_notify_id", 0);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("get notifyId:");
    stringBuilder2.append(i);
    HMSLog.i("PushSelfShowLog", stringBuilder2.toString());
    PushSelfShowMessage pushSelfShowMessage = new PushSelfShowMessage(paramArrayOfbyte1, paramArrayOfbyte2);
    if (!pushSelfShowMessage.parseMessage()) {
      HMSLog.d("PushSelfShowLog", "parseMessage failed");
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" onReceive the msg id = ");
    stringBuilder1.append(pushSelfShowMessage.getMsgId());
    stringBuilder1.append(",and cmd is");
    stringBuilder1.append(pushSelfShowMessage.getCmd());
    stringBuilder1.append(",and the eventId is ");
    stringBuilder1.append(str);
    HMSLog.i("PushSelfShowLog", stringBuilder1.toString());
    if (str == null) {
      processSelfShowMsg(paramContext, paramIntent, pushSelfShowMessage);
      return;
    } 
    processClickEvent(paramContext, paramIntent, str, pushSelfShowMessage, i);
  }
  
  public static void onReceive(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 95
    //   4: aload_1
    //   5: ifnonnull -> 11
    //   8: goto -> 95
    //   11: aload_1
    //   12: invokevirtual getAction : ()Ljava/lang/String;
    //   15: astore_3
    //   16: ldc 'com.huawei.intent.action.PUSH'
    //   18: aload_3
    //   19: invokevirtual equals : (Ljava/lang/Object;)Z
    //   22: istore_2
    //   23: iload_2
    //   24: ifne -> 49
    //   27: ldc 'com.huawei.push.msg.NOTIFY_MSG'
    //   29: aload_3
    //   30: invokevirtual equals : (Ljava/lang/Object;)Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne -> 49
    //   38: ldc 'com.huawei.intent.action.PUSH_DELAY_NOTIFY'
    //   40: aload_3
    //   41: invokevirtual equals : (Ljava/lang/Object;)Z
    //   44: istore_2
    //   45: iload_2
    //   46: ifeq -> 120
    //   49: aload_1
    //   50: ldc 'selfshow_info'
    //   52: invokevirtual getByteArrayExtra : (Ljava/lang/String;)[B
    //   55: astore_3
    //   56: aload_1
    //   57: ldc 'selfshow_token'
    //   59: invokevirtual getByteArrayExtra : (Ljava/lang/String;)[B
    //   62: astore #4
    //   64: aload_3
    //   65: arraylength
    //   66: ifeq -> 87
    //   69: aload #4
    //   71: arraylength
    //   72: ifne -> 78
    //   75: goto -> 87
    //   78: aload_0
    //   79: aload_1
    //   80: aload_3
    //   81: aload #4
    //   83: invokestatic handlePushMsg : (Landroid/content/Context;Landroid/content/Intent;[B[B)V
    //   86: return
    //   87: ldc 'PushSelfShowLog'
    //   89: ldc 'self show info or token is null.'
    //   91: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   94: return
    //   95: ldc 'PushSelfShowLog'
    //   97: ldc 'enter SelfShowReceiver receiver, context or intent is null'
    //   99: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   102: return
    //   103: ldc 'PushSelfShowLog'
    //   105: ldc 'onReceive Exception.'
    //   107: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   110: return
    //   111: astore_0
    //   112: ldc 'PushSelfShowLog'
    //   114: ldc 'onReceive RuntimeException.'
    //   116: aload_0
    //   117: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: return
    //   121: astore_0
    //   122: goto -> 103
    // Exception table:
    //   from	to	target	type
    //   11	16	111	java/lang/RuntimeException
    //   11	16	121	java/lang/Exception
    //   16	23	111	java/lang/RuntimeException
    //   16	23	121	java/lang/Exception
    //   27	34	111	java/lang/RuntimeException
    //   27	34	121	java/lang/Exception
    //   38	45	111	java/lang/RuntimeException
    //   38	45	121	java/lang/Exception
    //   49	56	111	java/lang/RuntimeException
    //   49	56	121	java/lang/Exception
    //   56	75	111	java/lang/RuntimeException
    //   56	75	121	java/lang/Exception
    //   78	86	111	java/lang/RuntimeException
    //   78	86	121	java/lang/Exception
    //   87	94	111	java/lang/RuntimeException
    //   87	94	121	java/lang/Exception
    //   95	102	111	java/lang/RuntimeException
    //   95	102	121	java/lang/Exception
  }
  
  public static void processClickEvent(Context paramContext, Intent paramIntent, String paramString, PushSelfShowMessage paramPushSelfShowMessage, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("receive a selfshow user handle message eventId = ");
    stringBuilder.append(paramString);
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    if (!"-1".equals(paramString)) {
      CommFun.cancelNotificationAlarm(paramContext, paramIntent);
    } else {
      CommFun.removeNotifiCationById(paramContext, paramInt);
    } 
    if ("1".equals(paramString)) {
      (new SelfShowType(paramContext, paramPushSelfShowMessage)).launchNotify();
      e.a(paramContext, "1", paramPushSelfShowMessage);
      return;
    } 
    if ("2".equals(paramString)) {
      e.a(paramContext, "2", paramPushSelfShowMessage);
      return;
    } 
    HMSLog.d("PushSelfShowLog", "other event");
  }
  
  public static void processSelfShowMsg(Context paramContext, Intent paramIntent, PushSelfShowMessage paramPushSelfShowMessage) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("receive a selfshow message ,the type is");
    stringBuilder.append(paramPushSelfShowMessage.getCmd());
    HMSLog.i("PushSelfShowLog", stringBuilder.toString());
    if (!SelfShowType.supportCmd(paramPushSelfShowMessage.getCmd()))
      return; 
    long l = CommFun.getAPDelayTime(paramPushSelfShowMessage.getAp());
    if (l == 0L) {
      (new PushSelfShowThread(paramContext, paramPushSelfShowMessage)).start();
      return;
    } 
    HMSLog.d("PushSelfShowLog", "waiting ……");
    paramIntent.setPackage(paramContext.getPackageName());
    CommFun.setAPDelayAlarm(paramContext, paramIntent, l);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\SelfShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */