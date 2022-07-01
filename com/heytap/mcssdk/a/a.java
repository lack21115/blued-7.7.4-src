package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;

public final class a extends c {
  public final Message a(Context paramContext, int paramInt, Intent paramIntent) {
    if (4098 == paramInt) {
      Message message = a(paramIntent);
      PushManager.a(paramContext, (AppMessage)message, "push_transmit");
      return message;
    } 
    return null;
  }
  
  public final Message a(Intent paramIntent) {
    try {
      AppMessage appMessage = new AppMessage();
      appMessage.d(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("messageID"))));
      appMessage.e(CryptoUtil.b(paramIntent.getStringExtra("taskID")));
      appMessage.f(CryptoUtil.b(paramIntent.getStringExtra("appPackage")));
      appMessage.a(CryptoUtil.b(paramIntent.getStringExtra("content")));
      appMessage.a(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("balanceTime"))));
      appMessage.a(Long.parseLong(CryptoUtil.b(paramIntent.getStringExtra("startDate"))));
      appMessage.b(Long.parseLong(CryptoUtil.b(paramIntent.getStringExtra("endDate"))));
      appMessage.b(CryptoUtil.b(paramIntent.getStringExtra("timeRanges")));
      appMessage.c(CryptoUtil.b(paramIntent.getStringExtra("title")));
      appMessage.d(CryptoUtil.b(paramIntent.getStringExtra("rule")));
      appMessage.b(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("forcedDelivery"))));
      appMessage.c(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("distinctBycontent"))));
      StringBuilder stringBuilder = new StringBuilder("OnHandleIntent-message:");
      stringBuilder.append(appMessage.toString());
      LogUtil.a(stringBuilder.toString());
      return (Message)appMessage;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("OnHandleIntent--");
      stringBuilder.append(exception.getMessage());
      LogUtil.a(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */