package com.soft.blued.push.hms;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.huawei.hms.push.SendException;
import com.soft.blued.push.PushManager;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.Arrays;

public class HwPushService extends HmsMessageService {
  private void a(RemoteMessage paramRemoteMessage) {
    Log.d("PushDemoLog", "Start new Job processing.");
  }
  
  private void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sending token to server. token:");
    stringBuilder.append(paramString);
    Log.i("PushDemoLog", stringBuilder.toString());
    Logger.c("PushDemoLog", new Object[] { paramString });
    stringBuilder = new StringBuilder();
    stringBuilder.append("HWPUSH:");
    stringBuilder.append(paramString);
    String str = stringBuilder.toString();
    BluedPreferences.X(paramString);
    PushManager.a().a(str);
  }
  
  private void b(RemoteMessage paramRemoteMessage) {
    Log.d("PushDemoLog", "Processing now.");
  }
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {
    Log.i("PushDemoLog", "onMessageReceived is called");
    if (paramRemoteMessage == null) {
      Log.e("PushDemoLog", "Received message entity is null!");
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("getCollapseKey: ");
    stringBuilder1.append(paramRemoteMessage.getCollapseKey());
    stringBuilder1.append("\n getData: ");
    stringBuilder1.append(paramRemoteMessage.getData());
    stringBuilder1.append("\n getFrom: ");
    stringBuilder1.append(paramRemoteMessage.getFrom());
    stringBuilder1.append("\n getTo: ");
    stringBuilder1.append(paramRemoteMessage.getTo());
    stringBuilder1.append("\n getMessageId: ");
    stringBuilder1.append(paramRemoteMessage.getMessageId());
    stringBuilder1.append("\n getOriginalUrgency: ");
    stringBuilder1.append(paramRemoteMessage.getOriginalUrgency());
    stringBuilder1.append("\n getUrgency: ");
    stringBuilder1.append(paramRemoteMessage.getUrgency());
    stringBuilder1.append("\n getSendTime: ");
    stringBuilder1.append(paramRemoteMessage.getSentTime());
    stringBuilder1.append("\n getMessageType: ");
    stringBuilder1.append(paramRemoteMessage.getMessageType());
    stringBuilder1.append("\n getTtl: ");
    stringBuilder1.append(paramRemoteMessage.getTtl());
    Log.i("PushDemoLog", stringBuilder1.toString());
    RemoteMessage.Notification notification = paramRemoteMessage.getNotification();
    if (notification != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\n getImageUrl: ");
      stringBuilder.append(notification.getImageUrl());
      stringBuilder.append("\n getTitle: ");
      stringBuilder.append(notification.getTitle());
      stringBuilder.append("\n getTitleLocalizationKey: ");
      stringBuilder.append(notification.getTitleLocalizationKey());
      stringBuilder.append("\n getTitleLocalizationArgs: ");
      stringBuilder.append(Arrays.toString((Object[])notification.getTitleLocalizationArgs()));
      stringBuilder.append("\n getBody: ");
      stringBuilder.append(notification.getBody());
      stringBuilder.append("\n getBodyLocalizationKey: ");
      stringBuilder.append(notification.getBodyLocalizationKey());
      stringBuilder.append("\n getBodyLocalizationArgs: ");
      stringBuilder.append(Arrays.toString((Object[])notification.getBodyLocalizationArgs()));
      stringBuilder.append("\n getIcon: ");
      stringBuilder.append(notification.getIcon());
      stringBuilder.append("\n getSound: ");
      stringBuilder.append(notification.getSound());
      stringBuilder.append("\n getTag: ");
      stringBuilder.append(notification.getTag());
      stringBuilder.append("\n getColor: ");
      stringBuilder.append(notification.getColor());
      stringBuilder.append("\n getClickAction: ");
      stringBuilder.append(notification.getClickAction());
      stringBuilder.append("\n getChannelId: ");
      stringBuilder.append(notification.getChannelId());
      stringBuilder.append("\n getLink: ");
      stringBuilder.append(notification.getLink());
      stringBuilder.append("\n getNotifyId: ");
      stringBuilder.append(notification.getNotifyId());
      Log.i("PushDemoLog", stringBuilder.toString());
    } 
    Intent intent = new Intent();
    intent.setAction("com.huawei.codelabpush.action");
    intent.putExtra("method", "onMessageReceived");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("onMessageReceived called, message id:");
    stringBuilder2.append(paramRemoteMessage.getMessageId());
    stringBuilder2.append(", payload data:");
    stringBuilder2.append(paramRemoteMessage.getData());
    intent.putExtra("msg", stringBuilder2.toString());
    sendBroadcast(intent);
    if (Boolean.valueOf(false).booleanValue()) {
      a(paramRemoteMessage);
      return;
    } 
    b(paramRemoteMessage);
  }
  
  public void onMessageSent(String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("onMessageSent called, Message id:");
    stringBuilder1.append(paramString);
    Log.i("PushDemoLog", stringBuilder1.toString());
    Intent intent = new Intent();
    intent.setAction("com.huawei.codelabpush.action");
    intent.putExtra("method", "onMessageSent");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("onMessageSent called, Message id:");
    stringBuilder2.append(paramString);
    intent.putExtra("msg", stringBuilder2.toString());
    sendBroadcast(intent);
  }
  
  public void onNewToken(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("received refresh token:");
    stringBuilder.append(paramString);
    Log.e("PushDemoLog", stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString) && Build.MANUFACTURER.toLowerCase().equals("huawei"))
      a(paramString); 
  }
  
  public void onSendError(String paramString, Exception paramException) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("onSendError called, message id:");
    stringBuilder1.append(paramString);
    stringBuilder1.append(", ErrCode:");
    SendException sendException = (SendException)paramException;
    stringBuilder1.append(sendException.getErrorCode());
    stringBuilder1.append(", description:");
    stringBuilder1.append(paramException.getMessage());
    Log.i("PushDemoLog", stringBuilder1.toString());
    Intent intent = new Intent();
    intent.setAction("com.huawei.codelabpush.action");
    intent.putExtra("method", "onSendError");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("onSendError called, message id:");
    stringBuilder2.append(paramString);
    stringBuilder2.append(", ErrCode:");
    stringBuilder2.append(sendException.getErrorCode());
    stringBuilder2.append(", description:");
    stringBuilder2.append(paramException.getMessage());
    intent.putExtra("msg", stringBuilder2.toString());
    sendBroadcast(intent);
  }
  
  public void onTokenError(Exception paramException) {
    super.onTokenError(paramException);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\hms\HwPushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */