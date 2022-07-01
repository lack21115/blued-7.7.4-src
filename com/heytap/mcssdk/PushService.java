package com.heytap.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.LogUtil;

public class PushService extends Service implements MessageCallback {
  public void a(Context paramContext, AppMessage paramAppMessage) {}
  
  public void a(Context paramContext, CommandMessage paramCommandMessage) {
    StringBuilder stringBuilder = new StringBuilder("mcssdk-processMessage:");
    stringBuilder.append(paramCommandMessage.a());
    LogUtil.a(stringBuilder.toString());
    PushParseHelper.a(getApplicationContext(), paramCommandMessage, PushManager.a());
  }
  
  public void a(Context paramContext, SptDataMessage paramSptDataMessage) {}
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    PushParseHelper.a(getApplicationContext(), paramIntent, this);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */