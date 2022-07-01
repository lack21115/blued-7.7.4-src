package com.huawei.hms.support.api.push.pushselfshow.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class CommonHandler extends Handler {
  public WeakReference<MessageHandler> mMessageHandler;
  
  public CommonHandler(MessageHandler paramMessageHandler) {
    this.mMessageHandler = new WeakReference<MessageHandler>(paramMessageHandler);
  }
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    MessageHandler messageHandler = this.mMessageHandler.get();
    if (messageHandler != null)
      messageHandler.handleMessage(paramMessage); 
  }
  
  public static interface MessageHandler {
    void handleMessage(Message param1Message);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfsho\\utils\CommonHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */