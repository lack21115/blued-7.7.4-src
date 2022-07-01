package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService extends Service {
  public static final String PROXY_TYPE = "proxy_type";
  
  public static final String SUBJECT_ID = "subject_id";
  
  public final Messenger a = new Messenger(new a(null));
  
  public final Bundle a(Intent paramIntent) {
    Bundle bundle = new Bundle();
    bundle.putString("message_id", paramIntent.getStringExtra("message_id"));
    bundle.putByteArray("message_body", paramIntent.getByteArrayExtra("message_body"));
    bundle.putString("device_token", paramIntent.getStringExtra("device_token"));
    if (paramIntent.getIntExtra("inputType", -1) == 1)
      bundle.putInt("inputType", 1); 
    return bundle;
  }
  
  public final void a(Intent paramIntent, Bundle paramBundle, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 'device_token'
    //   5: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   8: astore #6
    //   10: aload_0
    //   11: aload #6
    //   13: aload_3
    //   14: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   21: astore #7
    //   23: aload #7
    //   25: invokevirtual getPackageName : ()Ljava/lang/String;
    //   28: astore #8
    //   30: iconst_0
    //   31: istore #4
    //   33: aload #7
    //   35: aload #8
    //   37: iconst_0
    //   38: invokestatic getCacheData : (Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    //   41: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   44: istore #5
    //   46: aload_2
    //   47: invokevirtual isEmpty : ()Z
    //   50: ifeq -> 83
    //   53: iload #5
    //   55: iconst_1
    //   56: ixor
    //   57: ifeq -> 83
    //   60: ldc 'HmsMessageService'
    //   62: ldc 'onNewToken to host app.'
    //   64: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload #6
    //   70: invokevirtual onNewToken : (Ljava/lang/String;)V
    //   73: aload #7
    //   75: aload #7
    //   77: invokevirtual getPackageName : ()Ljava/lang/String;
    //   80: invokestatic deleteCacheData : (Landroid/content/Context;Ljava/lang/String;)V
    //   83: aload_3
    //   84: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   87: ifeq -> 229
    //   90: aload #7
    //   92: invokestatic getSubjectIds : (Landroid/content/Context;)[Ljava/lang/String;
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull -> 200
    //   100: aload_3
    //   101: arraylength
    //   102: ifne -> 108
    //   105: goto -> 200
    //   108: iload #4
    //   110: aload_3
    //   111: arraylength
    //   112: if_icmpge -> 192
    //   115: new android/os/Bundle
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: astore_1
    //   123: aload_1
    //   124: ldc 'subject_id'
    //   126: aload_3
    //   127: iload #4
    //   129: aaload
    //   130: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   133: new java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial <init> : ()V
    //   140: astore_2
    //   141: aload_2
    //   142: ldc 'onNewToken to sub app, subjectId:'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: aload_3
    //   150: iload #4
    //   152: aaload
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 'HmsMessageService'
    //   159: aload_2
    //   160: invokevirtual toString : ()Ljava/lang/String;
    //   163: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: aload #6
    //   169: aload_1
    //   170: invokevirtual onNewToken : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   173: aload_0
    //   174: aload #6
    //   176: aload_3
    //   177: iload #4
    //   179: aaload
    //   180: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload #4
    //   185: iconst_1
    //   186: iadd
    //   187: istore #4
    //   189: goto -> 108
    //   192: aload #7
    //   194: invokestatic clearSubjectIds : (Landroid/content/Context;)V
    //   197: goto -> 266
    //   200: ldc 'HmsMessageService'
    //   202: ldc 'onNewToken to host app with bundle.'
    //   204: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_2
    //   208: ldc 'belongId'
    //   210: aload_1
    //   211: ldc 'belongId'
    //   213: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: aload #6
    //   222: aload_2
    //   223: invokevirtual onNewToken : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   226: aload_0
    //   227: monitorexit
    //   228: return
    //   229: new java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: astore_1
    //   237: aload_1
    //   238: ldc 'onNewToken to sub app, subjectId:'
    //   240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: aload_3
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 'HmsMessageService'
    //   252: aload_1
    //   253: invokevirtual toString : ()Ljava/lang/String;
    //   256: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_0
    //   260: aload #6
    //   262: aload_2
    //   263: invokevirtual onNewToken : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   266: aload_0
    //   267: monitorexit
    //   268: return
    //   269: astore_1
    //   270: aload_0
    //   271: monitorexit
    //   272: aload_1
    //   273: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	269	finally
    //   33	53	269	finally
    //   60	83	269	finally
    //   83	96	269	finally
    //   100	105	269	finally
    //   108	183	269	finally
    //   192	197	269	finally
    //   200	226	269	finally
    //   229	266	269	finally
  }
  
  public final void a(Intent paramIntent, String paramString) {
    int i = paramIntent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
    a("push.onNewToken", paramString, i);
    String str1 = paramIntent.getStringExtra("subjectId");
    String str2 = paramIntent.getStringExtra("message_proxy_type");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("doOnNewToken:transactionId = ");
    stringBuilder2.append(paramString);
    stringBuilder2.append(" , internalCode = ");
    stringBuilder2.append(i);
    stringBuilder2.append(",subjectId:");
    stringBuilder2.append(str1);
    stringBuilder2.append(",proxyType:");
    stringBuilder2.append(str2);
    HMSLog.i("HmsMessageService", stringBuilder2.toString());
    Bundle bundle = new Bundle();
    if (!TextUtils.isEmpty(str1))
      bundle.putString("subject_id", str1); 
    if (!TextUtils.isEmpty(str2))
      bundle.putString("proxy_type", str2); 
    if (i == ErrorEnum.SUCCESS.getInternalCode()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Apply token OnNewToken, subId: ");
      stringBuilder.append(str1);
      HMSLog.i("HmsMessageService", stringBuilder.toString());
      a(paramIntent, bundle, str1);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Apply token failed, subId: ");
    stringBuilder1.append(str1);
    HMSLog.i("HmsMessageService", stringBuilder1.toString());
    a(bundle, str1, i);
  }
  
  public final void a(Bundle paramBundle, String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   6: astore #6
    //   8: aload #6
    //   10: invokevirtual getPackageName : ()Ljava/lang/String;
    //   13: astore #7
    //   15: iconst_0
    //   16: istore #4
    //   18: aload #6
    //   20: aload #7
    //   22: iconst_0
    //   23: invokestatic getCacheData : (Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    //   26: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   29: istore #5
    //   31: aload_1
    //   32: invokevirtual isEmpty : ()Z
    //   35: ifeq -> 74
    //   38: iload #5
    //   40: iconst_1
    //   41: ixor
    //   42: ifeq -> 74
    //   45: ldc 'HmsMessageService'
    //   47: ldc 'onTokenError to host app.'
    //   49: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: new com/huawei/hms/push/BaseException
    //   56: dup
    //   57: iload_3
    //   58: invokespecial <init> : (I)V
    //   61: invokevirtual onTokenError : (Ljava/lang/Exception;)V
    //   64: aload #6
    //   66: aload #6
    //   68: invokevirtual getPackageName : ()Ljava/lang/String;
    //   71: invokestatic deleteCacheData : (Landroid/content/Context;Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   78: ifeq -> 214
    //   81: aload #6
    //   83: invokestatic getSubjectIds : (Landroid/content/Context;)[Ljava/lang/String;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull -> 191
    //   91: aload_2
    //   92: arraylength
    //   93: ifne -> 99
    //   96: goto -> 191
    //   99: iload #4
    //   101: aload_2
    //   102: arraylength
    //   103: if_icmpge -> 183
    //   106: new android/os/Bundle
    //   109: dup
    //   110: invokespecial <init> : ()V
    //   113: astore_1
    //   114: aload_1
    //   115: ldc 'subject_id'
    //   117: aload_2
    //   118: iload #4
    //   120: aaload
    //   121: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   124: new java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial <init> : ()V
    //   131: astore #7
    //   133: aload #7
    //   135: ldc 'onTokenError to sub app, subjectId:'
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload #7
    //   143: aload_2
    //   144: iload #4
    //   146: aaload
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 'HmsMessageService'
    //   153: aload #7
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: new com/huawei/hms/push/BaseException
    //   165: dup
    //   166: iload_3
    //   167: invokespecial <init> : (I)V
    //   170: aload_1
    //   171: invokevirtual onTokenError : (Ljava/lang/Exception;Landroid/os/Bundle;)V
    //   174: iload #4
    //   176: iconst_1
    //   177: iadd
    //   178: istore #4
    //   180: goto -> 99
    //   183: aload #6
    //   185: invokestatic clearSubjectIds : (Landroid/content/Context;)V
    //   188: goto -> 261
    //   191: ldc 'HmsMessageService'
    //   193: ldc 'onTokenError to host app with bundle.'
    //   195: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: new com/huawei/hms/push/BaseException
    //   202: dup
    //   203: iload_3
    //   204: invokespecial <init> : (I)V
    //   207: aload_1
    //   208: invokevirtual onTokenError : (Ljava/lang/Exception;Landroid/os/Bundle;)V
    //   211: aload_0
    //   212: monitorexit
    //   213: return
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore #6
    //   223: aload #6
    //   225: ldc 'onTokenError to sub app, subjectId:'
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #6
    //   233: aload_2
    //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc 'HmsMessageService'
    //   240: aload #6
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_0
    //   249: new com/huawei/hms/push/BaseException
    //   252: dup
    //   253: iload_3
    //   254: invokespecial <init> : (I)V
    //   257: aload_1
    //   258: invokevirtual onTokenError : (Ljava/lang/Exception;Landroid/os/Bundle;)V
    //   261: aload_0
    //   262: monitorexit
    //   263: return
    //   264: astore_1
    //   265: aload_0
    //   266: monitorexit
    //   267: aload_1
    //   268: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	264	finally
    //   18	38	264	finally
    //   45	74	264	finally
    //   74	87	264	finally
    //   91	96	264	finally
    //   99	174	264	finally
    //   183	188	264	finally
    //   191	211	264	finally
    //   214	261	264	finally
  }
  
  public final void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return; 
    Context context = getApplicationContext();
    if (!paramString1.equals(BaseUtils.getLocalToken(context, paramString2))) {
      HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
      BaseUtils.saveToken(context, paramString2, paramString1);
      return;
    } 
    BaseUtils.reportAaidToken(context, paramString1);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt) {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
      str = "null"; 
    PushBiUtil.reportExit(getApplicationContext(), paramString1, str, paramInt);
  }
  
  public final void b(Intent paramIntent) {
    StringBuilder stringBuilder2;
    if (paramIntent == null) {
      HMSLog.e("HmsMessageService", "receive message is null");
      return;
    } 
    String str1 = paramIntent.getStringExtra("message_id");
    String str2 = paramIntent.getStringExtra("message_type");
    String str3 = paramIntent.getStringExtra("transaction_id");
    if ("new_token".equals(str2)) {
      HMSLog.i("HmsMessageService", "onNewToken");
      a(paramIntent, str3);
      return;
    } 
    if ("received_message".equals(str2)) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("onMessageReceived, message id:");
      stringBuilder2.append(str1);
      HMSLog.i("HmsMessageService", stringBuilder2.toString());
      a("push.receiveMessage", str1, ErrorEnum.SUCCESS.getInternalCode());
      doMsgReceived(paramIntent);
      return;
    } 
    if ("sent_message".equals(stringBuilder2)) {
      b(str3, str1);
      return;
    } 
    if ("send_error".equals(stringBuilder2)) {
      b(str3, str1, paramIntent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
      return;
    } 
    if ("delivery".equals(stringBuilder2)) {
      int i = paramIntent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onMessageDelivery, message id:");
      stringBuilder1.append(str1);
      stringBuilder1.append(", status:");
      stringBuilder1.append(i);
      stringBuilder1.append(", transactionId: ");
      stringBuilder1.append(str3);
      HMSLog.i("HmsMessageService", stringBuilder1.toString());
      a("push.deliveryMessage", str3, i);
      onMessageDelivered(str1, new SendException(i));
      return;
    } 
    if ("server_deleted_message".equals(stringBuilder2)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("delete message, message id:");
      stringBuilder1.append(str1);
      HMSLog.i("HmsMessageService", stringBuilder1.toString());
      onDeletedMessages();
      return;
    } 
    if ("batchSent".equals(stringBuilder2)) {
      c((Intent)stringBuilder1);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Receive unknown message: ");
    stringBuilder1.append((String)stringBuilder2);
    HMSLog.e("HmsMessageService", stringBuilder1.toString());
  }
  
  public final void b(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onMessageSent, message id:");
    stringBuilder.append(paramString2);
    stringBuilder.append(", transactionId: ");
    stringBuilder.append(paramString1);
    HMSLog.i("HmsMessageService", stringBuilder.toString());
    a("push.sendMessageRet", paramString1, ErrorEnum.SUCCESS.getInternalCode());
    onMessageSent(paramString2);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSendError, message id:");
    stringBuilder.append(paramString2);
    stringBuilder.append(" error:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", transactionId: ");
    stringBuilder.append(paramString1);
    HMSLog.i("HmsMessageService", stringBuilder.toString());
    a("push.sendMessageRet", paramString1, paramInt);
    onSendError(paramString2, new SendException(paramInt));
  }
  
  public final void c(Intent paramIntent) {
    HMSLog.i("HmsMessageService", "parse batch response.");
    String str = paramIntent.getStringExtra("batchMsgbody");
    if (TextUtils.isEmpty(str))
      return; 
    try {
      JSONArray jSONArray = new JSONArray(str);
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.getJSONObject(i);
        String str1 = jSONObject.optString("transactionId");
        String str2 = jSONObject.optString("msgId");
        int j = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
        if (ErrorEnum.SUCCESS.getInternalCode() == j) {
          b(str1, str2);
        } else {
          b(str1, str2, j);
        } 
      } 
    } catch (JSONException jSONException) {
      HMSLog.w("HmsMessageService", "parse batch response failed.");
    } 
  }
  
  public void doMsgReceived(Intent paramIntent) {
    onMessageReceived(new RemoteMessage(a(paramIntent)));
  }
  
  public IBinder onBind(Intent paramIntent) {
    HMSLog.i("HmsMessageService", "start to bind");
    return this.a.getBinder();
  }
  
  public void onDeletedMessages() {}
  
  public void onDestroy() {
    HMSLog.i("HmsMessageService", "start to destroy");
    super.onDestroy();
  }
  
  public void onMessageDelivered(String paramString, Exception paramException) {}
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onNewToken(String paramString) {}
  
  public void onNewToken(String paramString, Bundle paramBundle) {}
  
  public void onSendError(String paramString, Exception paramException) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start to command , startId = ");
    stringBuilder.append(paramInt2);
    HMSLog.i("HmsMessageService", stringBuilder.toString());
    b(paramIntent);
    return 2;
  }
  
  public void onTokenError(Exception paramException) {}
  
  public void onTokenError(Exception paramException, Bundle paramBundle) {}
  
  public class a extends Handler {
    public a(HmsMessageService this$0) {}
    
    public void handleMessage(Message param1Message) {
      if (param1Message == null) {
        HMSLog.e("HmsMessageService", "receive message is null");
        return;
      } 
      HMSLog.i("HmsMessageService", "handle message start ");
      Bundle bundle = param1Message.getData();
      if (bundle != null) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("inputType", bundle.getInt("inputType", -1));
        HmsMessageService.a(this.a, intent);
      } 
      super.handleMessage(param1Message);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\HmsMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */