package com.heytap.mcssdk.b;

import android.content.Context;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.mode.SptDataMessage;

public final class d implements c {
  public final void a(Context paramContext, Message paramMessage, MessageCallback paramMessageCallback) {
    if (paramMessage == null)
      return; 
    if (paramMessage.b() == 4103) {
      SptDataMessage sptDataMessage = (SptDataMessage)paramMessage;
      if (paramMessageCallback != null)
        paramMessageCallback.a(paramContext, sptDataMessage); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */