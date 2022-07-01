package com.heytap.mcssdk.b;

import android.content.Context;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.Message;

public final class a implements c {
  public final void a(Context paramContext, Message paramMessage, MessageCallback paramMessageCallback) {
    if (paramMessage == null)
      return; 
    if (paramMessage.b() == 4098) {
      AppMessage appMessage = (AppMessage)paramMessage;
      if (paramMessageCallback != null)
        paramMessageCallback.a(paramContext, appMessage); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */