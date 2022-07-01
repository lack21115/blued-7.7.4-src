package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MojoException;

public abstract class Interface$AbstractProxy implements Interface$Proxy {
  public final Interface$AbstractProxy$HandlerImpl mHandler;
  
  public Interface$AbstractProxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    this.mHandler = new Interface$AbstractProxy$HandlerImpl(paramCore, paramMessageReceiverWithResponder);
  }
  
  public void close() {
    this.mHandler.close();
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    this.mHandler.onConnectionError(paramMojoException);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Interface$AbstractProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */