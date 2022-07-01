package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;

public final class e extends c {
  public final Message a(Context paramContext, int paramInt, Intent paramIntent) {
    if (4103 == paramInt) {
      Message message = a(paramIntent);
      PushManager.a(paramContext, (SptDataMessage)message, "push_transmit");
      return message;
    } 
    return null;
  }
  
  public final Message a(Intent paramIntent) {
    try {
      SptDataMessage sptDataMessage = new SptDataMessage();
      sptDataMessage.d(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("messageID"))));
      sptDataMessage.e(CryptoUtil.b(paramIntent.getStringExtra("taskID")));
      sptDataMessage.f(CryptoUtil.b(paramIntent.getStringExtra("appPackage")));
      sptDataMessage.b(CryptoUtil.b(paramIntent.getStringExtra("content")));
      sptDataMessage.c(CryptoUtil.b(paramIntent.getStringExtra("description")));
      sptDataMessage.d(CryptoUtil.b(paramIntent.getStringExtra("appID")));
      sptDataMessage.a(CryptoUtil.b(paramIntent.getStringExtra("globalID")));
      return (Message)sptDataMessage;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("OnHandleIntent--");
      stringBuilder.append(exception.getMessage());
      LogUtil.a(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */