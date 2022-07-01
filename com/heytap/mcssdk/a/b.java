package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;

public final class b extends c {
  public final Message a(Context paramContext, int paramInt, Intent paramIntent) {
    return (4105 == paramInt) ? a(paramIntent) : null;
  }
  
  public final Message a(Intent paramIntent) {
    try {
      CommandMessage commandMessage = new CommandMessage();
      commandMessage.a(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("command"))));
      commandMessage.b(Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("code"))));
      commandMessage.c(CryptoUtil.b(paramIntent.getStringExtra("content")));
      commandMessage.a(CryptoUtil.b(paramIntent.getStringExtra("appKey")));
      commandMessage.b(CryptoUtil.b(paramIntent.getStringExtra("appSecret")));
      commandMessage.f(CryptoUtil.b(paramIntent.getStringExtra("appPackage")));
      StringBuilder stringBuilder = new StringBuilder("OnHandleIntent-message:");
      stringBuilder.append(commandMessage.toString());
      LogUtil.a(stringBuilder.toString());
      return (Message)commandMessage;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("OnHandleIntent--");
      stringBuilder.append(exception.getMessage());
      LogUtil.a(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */