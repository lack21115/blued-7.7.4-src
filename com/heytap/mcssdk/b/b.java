package com.heytap.mcssdk.b;

import android.content.Context;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;

public final class b implements c {
  public final void a(Context paramContext, Message paramMessage, MessageCallback paramMessageCallback) {
    if (paramMessage == null)
      return; 
    if (paramMessage.b() == 4105) {
      CommandMessage commandMessage = (CommandMessage)paramMessage;
      if (paramMessageCallback != null)
        paramMessageCallback.a(paramContext, commandMessage); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */