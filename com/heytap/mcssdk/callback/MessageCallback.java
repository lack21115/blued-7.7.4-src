package com.heytap.mcssdk.callback;

import android.content.Context;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.SptDataMessage;

public interface MessageCallback {
  void a(Context paramContext, AppMessage paramAppMessage);
  
  void a(Context paramContext, CommandMessage paramCommandMessage);
  
  void a(Context paramContext, SptDataMessage paramSptDataMessage);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\callback\MessageCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */