package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.base.RemoteService;
import com.huawei.hms.support.api.push.utils.CommFun;
import com.huawei.hms.support.api.push.utils.common.ReceiverThreadPoolExecutor;
import com.huawei.hms.support.api.push.utils.common.base.BaseUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver extends BroadcastReceiver {
  public static final String TAG = "PushReceiver";
  
  public static JSONObject getDataMsg(Intent paramIntent) {
    JSONObject jSONObject1 = getMsgJson(paramIntent.getByteArrayExtra("msg_data"));
    JSONObject jSONObject2 = getMsgContentJson(jSONObject1);
    String str = JsonUtil.getString(jSONObject2, "data", null);
    if (CommFun.isOldMsg(jSONObject2, getPsContentJson(jSONObject2), str))
      return jSONObject1; 
    if (TextUtils.isEmpty(str))
      return null; 
    try {
      return new JSONObject(str);
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public static JSONObject getMsgContentJson(JSONObject paramJSONObject) {
    return (paramJSONObject != null) ? paramJSONObject.optJSONObject("msgContent") : null;
  }
  
  public static JSONObject getMsgJson(byte[] paramArrayOfbyte) {
    try {
      return new JSONObject(BaseUtil.byte2Str(paramArrayOfbyte));
    } catch (JSONException jSONException) {
      HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
      return null;
    } 
  }
  
  public static JSONObject getPsContentJson(JSONObject paramJSONObject) {
    return (paramJSONObject != null) ? paramJSONObject.optJSONObject("psContent") : null;
  }
  
  private void handlePushMessageEvent(Context paramContext, Intent paramIntent) {
    try {
      if (paramIntent.hasExtra("msg_data")) {
        ReceiverThreadPoolExecutor.getInstance().execute(new PushMessageThread(paramContext, paramIntent));
        return;
      } 
      HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
      return;
    } catch (RuntimeException runtimeException) {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
      return;
    } catch (Exception exception) {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
      return;
    } 
  }
  
  private void handlePushTokenEvent(Context paramContext, Intent paramIntent) {
    try {
      if (paramIntent.hasExtra("device_token")) {
        ReceiverThreadPoolExecutor.getInstance().execute(new PushTokenThread(paramContext, paramIntent));
        return;
      } 
      HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
      return;
    } catch (RuntimeException runtimeException) {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
      return;
    } catch (Exception exception) {
      HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
      return;
    } 
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent != null) {
      if (paramContext == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("push receive broadcast message, Intent:");
      stringBuilder.append(paramIntent.getAction());
      stringBuilder.append(" pkgName:");
      stringBuilder.append(paramContext.getPackageName());
      HMSLog.i("PushReceiver", stringBuilder.toString());
      try {
        paramIntent.getStringExtra("TestIntent");
        String str = paramIntent.getAction();
        if (ResourceLoaderUtil.getmContext() == null)
          ResourceLoaderUtil.setmContext(paramContext.getApplicationContext()); 
        if ("com.huawei.android.push.intent.REGISTRATION".equals(str)) {
          handlePushTokenEvent(paramContext, paramIntent);
          return;
        } 
        if ("com.huawei.android.push.intent.RECEIVE".equals(str)) {
          handlePushMessageEvent(paramContext, paramIntent);
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("message can't be recognised:");
        stringBuilder1.append(paramIntent.toUri(0));
        HMSLog.i("PushReceiver", stringBuilder1.toString());
        return;
      } catch (Exception exception) {
        HMSLog.e("PushReceiver", "intent has some error");
      } 
    } 
  }
  
  public static interface BoundKey {
    public static final String DEVICE_TOKEN_KEY = "deviceToken";
  }
  
  public static class PushMessageThread implements Runnable {
    public static final String INPUT_TYPE = "inputType";
    
    public static final int MESSAGE_PROXY_TYPE_DEFAULT = -1;
    
    public static final String MODULENAME = "moduleName";
    
    public static final String MODULE_NAME_PUSH = "Push";
    
    public static final String MSGID = "msgId";
    
    public static final String MSGTYPE = "msgType";
    
    public static final int MSGTYPE_DELIVERY = 1;
    
    public static final int MSG_FROM_BROADCAST = 1;
    
    public static final String MSG_ID_STR = "msgIdStr";
    
    public static final String STATUS = "status";
    
    public static final String TRANS_ID = "transactionId";
    
    public Context context;
    
    public Intent intent;
    
    public PushMessageThread(Context param1Context, Intent param1Intent) {
      this.context = param1Context;
      this.intent = param1Intent;
    }
    
    public void run() {
      Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
      intent.setPackage(this.intent.getPackage());
      JSONObject jSONObject = PushReceiver.getDataMsg(this.intent);
      String str = JsonUtil.getString(jSONObject, "moduleName", "");
      int k = JsonUtil.getInt(jSONObject, "msgType", 0);
      int j = JsonUtil.getInt(jSONObject, "status", 0);
      int i = j;
      if (ErrorEnum.SUCCESS.getInternalCode() != j)
        i = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode(); 
      Bundle bundle = new Bundle();
      if ("Push".equals(str) && k == 1) {
        bundle.putString("message_type", "delivery");
        bundle.putString("message_id", JsonUtil.getString(jSONObject, "msgId", ""));
        bundle.putInt("error", i);
        bundle.putString("transaction_id", JsonUtil.getString(jSONObject, "transactionId", ""));
      } else {
        if (this.intent.getExtras() != null)
          bundle.putAll(this.intent.getExtras()); 
        bundle.putString("message_type", "received_message");
        bundle.putString("message_id", this.intent.getStringExtra("msgIdStr"));
        bundle.putByteArray("message_body", this.intent.getByteArrayExtra("msg_data"));
        bundle.putString("device_token", BaseUtil.byte2Str(this.intent.getByteArrayExtra("device_token")));
        bundle.putInt("inputType", 1);
        bundle.putInt("message_proxy_type", this.intent.getIntExtra("message_proxy_type", -1));
      } 
      if ((new RemoteService()).startMsgService(this.context, bundle, intent)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("receive ");
        stringBuilder1.append(this.intent.getAction());
        stringBuilder1.append(" and start service success");
        HMSLog.i("PushReceiver", stringBuilder1.toString());
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("receive ");
      stringBuilder.append(this.intent.getAction());
      stringBuilder.append(" and start service failed");
      HMSLog.e("PushReceiver", stringBuilder.toString());
    }
  }
  
  public static class PushTokenThread implements Runnable {
    public Context context;
    
    public Intent intent;
    
    public PushTokenThread(Context param1Context, Intent param1Intent) {
      this.context = param1Context;
      this.intent = param1Intent;
    }
    
    public void run() {
      try {
        byte[] arrayOfByte = this.intent.getByteArrayExtra("device_token");
        if (arrayOfByte == null || arrayOfByte.length == 0) {
          HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("receive a push token: ");
        stringBuilder.append(this.context.getPackageName());
        HMSLog.i("PushReceiver", stringBuilder.toString());
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.intent.getPackage());
        Bundle bundle = new Bundle();
        bundle.putString("message_type", "new_token");
        bundle.putString("device_token", BaseUtil.byte2Str(arrayOfByte));
        bundle.putString("transaction_id", this.intent.getStringExtra("transaction_id"));
        bundle.putString("subjectId", this.intent.getStringExtra("subjectId"));
        bundle.putInt("error", this.intent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
        bundle.putString("belongId", this.intent.getStringExtra("belongId"));
        if (!(new RemoteService()).startMsgService(this.context, bundle, intent)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("receive ");
          stringBuilder1.append(this.intent.getAction());
          stringBuilder1.append(" and start service failed");
          HMSLog.e("PushReceiver", stringBuilder1.toString());
          return;
        } 
        return;
      } catch (RejectedExecutionException rejectedExecutionException) {
        HMSLog.e("PushReceiver", "execute task error");
        return;
      } catch (Exception exception) {
        HMSLog.e("PushReceiver", "handle push token error");
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */