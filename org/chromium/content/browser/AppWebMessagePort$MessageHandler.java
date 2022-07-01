package org.chromium.content.browser;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.chromium.base.Log;
import org.chromium.blink.mojom.TransferableMessage;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo_base.BigBufferUtil;

final class AppWebMessagePort$MessageHandler extends Handler implements MessageReceiver {
  private final MessagePort.MessageCallback mMessageCallback;
  
  public AppWebMessagePort$MessageHandler(Looper paramLooper, MessagePort.MessageCallback paramMessageCallback) {
    super(paramLooper);
    this.mMessageCallback = paramMessageCallback;
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      TransferableMessage transferableMessage = TransferableMessage.deserialize(paramMessage.asServiceMessage().getPayload());
      AppWebMessagePort[] arrayOfAppWebMessagePort = new AppWebMessagePort[transferableMessage.ports.length];
      for (int i = 0; i < arrayOfAppWebMessagePort.length; i++)
        arrayOfAppWebMessagePort[i] = new AppWebMessagePort(transferableMessage.ports[i], (byte)0); 
      AppWebMessagePort$MessageHandler$MessagePortMessage appWebMessagePort$MessageHandler$MessagePortMessage = new AppWebMessagePort$MessageHandler$MessagePortMessage((byte)0);
      appWebMessagePort$MessageHandler$MessagePortMessage.encodedMessage = BigBufferUtil.getBytesFromBigBuffer(transferableMessage.message.encodedMessage);
      appWebMessagePort$MessageHandler$MessagePortMessage.ports = arrayOfAppWebMessagePort;
      sendMessage(obtainMessage(1, appWebMessagePort$MessageHandler$MessagePortMessage));
      return true;
    } catch (DeserializationException deserializationException) {
      Log.w("AppWebMessagePort", "Error deserializing message", new Object[] { deserializationException });
      return false;
    } 
  }
  
  public final void close() {}
  
  public final void handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      AppWebMessagePort$MessageHandler$MessagePortMessage appWebMessagePort$MessageHandler$MessagePortMessage = (AppWebMessagePort$MessageHandler$MessagePortMessage)paramMessage.obj;
      String str = AppWebMessagePort.access$000(appWebMessagePort$MessageHandler$MessagePortMessage.encodedMessage);
      if (str == null) {
        Log.w("AppWebMessagePort", "Undecodable message received, dropping message", new Object[0]);
        return;
      } 
      this.mMessageCallback.onMessage(str, (MessagePort[])appWebMessagePort$MessageHandler$MessagePortMessage.ports);
      return;
    } 
    throw new IllegalStateException("undefined message");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\AppWebMessagePort$MessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */