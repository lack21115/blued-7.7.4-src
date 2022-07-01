package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.e;
import com.huawei.hms.support.api.push.base.RemoteService;
import com.huawei.hms.support.api.push.pushselfshow.SelfShow;
import com.huawei.hms.support.api.push.utils.common.NotificationUtil;
import com.huawei.hms.support.api.push.utils.common.base.PushConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginUtil {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      JSONObject jSONObject1 = new JSONObject();
      JSONObject jSONObject2 = new JSONObject();
      jSONObject1.put("data", paramString);
      jSONObject2.put("msgContent", jSONObject1);
      return jSONObject2.toString();
    } catch (JSONException jSONException) {
      HMSLog.e("PluginUtil", "rebuild message failed");
      return null;
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder;
    HMSLog.i("PluginUtil", "onNotification");
    if (!NotificationUtil.areNotificationsEnabled(paramContext)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(" disable display notification.");
      HMSLog.i("PluginUtil", stringBuilder.toString());
      e.a(paramContext, paramString1, "103");
      return;
    } 
    Intent intent = new Intent();
    intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
    intent.putExtra("selfshow_info", paramString3.getBytes(PushConst.UTF_8));
    intent.putExtra("selfshow_token", stringBuilder.getBytes(PushConst.UTF_8));
    intent.setPackage(paramContext.getPackageName());
    SelfShow.onReceive(paramContext, intent);
    HMSLog.i("PluginUtil", "invokeSelfShow done");
  }
  
  public static boolean a(Context paramContext) {
    Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    label15: while (true) {
      boolean bool = true;
      while (iterator.hasNext()) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
        if (runningAppProcessInfo.processName.equals(paramContext.getPackageName())) {
          int i = runningAppProcessInfo.importance;
          if (i != 100 && i != 200)
            continue label15; 
          bool = false;
        } 
      } 
      return bool;
    } 
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString) {
    boolean bool = true;
    if (TextUtils.equals(paramArrayOfString[1], "0")) {
      if (!a(paramContext)) {
        if (TextUtils.equals(paramArrayOfString[2], "1"))
          return true; 
        bool = false;
      } 
      return bool;
    } 
    return false;
  }
  
  public static boolean onDataMessage(Context paramContext, String paramString1, String paramString2) {
    HMSLog.i("PluginUtil", "onMessageReceived");
    if (TextUtils.isEmpty(paramString2)) {
      HMSLog.i("PluginUtil", "Empty message received");
      return true;
    } 
    e.a(paramContext, paramString1, "102");
    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    intent.setPackage(paramContext.getPackageName());
    Bundle bundle = new Bundle();
    bundle.putString("message_id", paramString1);
    bundle.putByteArray("message_body", paramString2.getBytes(PushConst.UTF_8));
    bundle.putString("message_type", "received_message");
    return (new RemoteService()).startMsgService(paramContext, bundle, intent);
  }
  
  public static void onDataMessageArrived(Context paramContext, String paramString) {
    e.a(paramContext, paramString, "102");
  }
  
  public static boolean onDeletedMessages(Context paramContext) {
    HMSLog.i("PluginUtil", "onDeletedMessages");
    if (paramContext == null)
      return false; 
    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    intent.setPackage(paramContext.getPackageName());
    Bundle bundle = new Bundle();
    bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
    bundle.putString("message_type", "server_deleted_message");
    return (new RemoteService()).startMsgService(paramContext, bundle, intent);
  }
  
  public static void onMessage(Context paramContext, String[] paramArrayOfString) {
    HMSLog.i("PluginUtil", "onMessage");
    if (paramContext != null && paramArrayOfString != null) {
      if (paramArrayOfString.length < 5)
        return; 
      if (ResourceLoaderUtil.getmContext() == null)
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext()); 
      if (a(paramContext, paramArrayOfString)) {
        a(paramContext, paramArrayOfString[0], paramArrayOfString[3], paramArrayOfString[4]);
        return;
      } 
      onDataMessage(paramContext, paramArrayOfString[0], paramArrayOfString[4]);
    } 
  }
  
  public static boolean onNewToken(Context paramContext, String paramString1, String paramString2, ErrorEnum paramErrorEnum) {
    HMSLog.i("PluginUtil", "onNewToken called.");
    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    intent.setPackage(paramContext.getPackageName());
    Bundle bundle = new Bundle();
    bundle.putInt("error", paramErrorEnum.getInternalCode());
    bundle.putString("message_type", "new_token");
    bundle.putString("device_token", paramString1);
    if (TextUtils.equals(paramString2, paramContext.getPackageName())) {
      bundle.putString("subjectId", null);
    } else {
      bundle.putString("subjectId", paramString2);
    } 
    bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
    return (new RemoteService()).startMsgService(paramContext, bundle, intent);
  }
  
  public static void onNotificationArrived(Context paramContext, String paramString) {
    e.a(paramContext, paramString, "100");
  }
  
  public static void onNotificationClicked(Context paramContext, String paramString) {
    e.a(paramContext, paramString, "1");
  }
  
  public static boolean onOldDataMessage(Context paramContext, String paramString1, String paramString2) {
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramContext.getApplicationContext()); 
    return onDataMessage(paramContext, paramString1, a(paramString2));
  }
  
  public static void saveNotifySwitch(Context paramContext, boolean paramBoolean) {
    (new PushPreferences(paramContext, "push_notify_flag")).saveBoolean("notify_msg_enable", paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\utils\PluginUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */