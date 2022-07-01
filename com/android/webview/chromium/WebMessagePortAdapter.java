package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import org.chromium.content_public.browser.MessagePort;

@TargetApi(23)
public final class WebMessagePortAdapter extends WebMessagePort {
  public MessagePort mPort;
  
  public WebMessagePortAdapter(MessagePort paramMessagePort) {
    this.mPort = paramMessagePort;
  }
  
  public static WebMessagePort[] fromMessagePorts(MessagePort[] paramArrayOfMessagePort) {
    if (paramArrayOfMessagePort == null)
      return null; 
    WebMessagePort[] arrayOfWebMessagePort = new WebMessagePort[paramArrayOfMessagePort.length];
    for (int i = 0; i < paramArrayOfMessagePort.length; i++)
      arrayOfWebMessagePort[i] = new WebMessagePortAdapter(paramArrayOfMessagePort[i]); 
    return arrayOfWebMessagePort;
  }
  
  public static MessagePort[] toMessagePorts(WebMessagePort[] paramArrayOfWebMessagePort) {
    if (paramArrayOfWebMessagePort == null)
      return null; 
    MessagePort[] arrayOfMessagePort = new MessagePort[paramArrayOfWebMessagePort.length];
    for (int i = 0; i < paramArrayOfWebMessagePort.length; i++)
      arrayOfMessagePort[i] = ((WebMessagePortAdapter)paramArrayOfWebMessagePort[i]).mPort; 
    return arrayOfMessagePort;
  }
  
  public final void close() {
    this.mPort.close();
  }
  
  public final void postMessage(WebMessage paramWebMessage) {
    this.mPort.postMessage(paramWebMessage.getData(), toMessagePorts(paramWebMessage.getPorts()));
  }
  
  public final void setWebMessageCallback(WebMessagePort.WebMessageCallback paramWebMessageCallback) {
    setWebMessageCallback(paramWebMessageCallback, null);
  }
  
  public final void setWebMessageCallback(WebMessagePort.WebMessageCallback paramWebMessageCallback, Handler paramHandler) {
    this.mPort.setMessageCallback(new WebMessagePortAdapter$1(this, paramWebMessageCallback), paramHandler);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebMessagePortAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */