package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;

public final class Interface$AbstractProxy$HandlerImpl implements ConnectionErrorHandler, Interface$Proxy$Handler {
  public final Core mCore;
  
  private ConnectionErrorHandler mErrorHandler;
  
  public final MessageReceiverWithResponder mMessageReceiver;
  
  int mVersion;
  
  protected Interface$AbstractProxy$HandlerImpl(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    this.mCore = paramCore;
    this.mMessageReceiver = paramMessageReceiverWithResponder;
  }
  
  public final void close() {
    this.mMessageReceiver.close();
  }
  
  public final int getVersion() {
    return this.mVersion;
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    if (this.mErrorHandler != null)
      this.mErrorHandler.onConnectionError(paramMojoException); 
  }
  
  public final MessagePipeHandle passHandle() {
    return (MessagePipeHandle)((HandleOwner)this.mMessageReceiver).passHandle();
  }
  
  public final void setErrorHandler(ConnectionErrorHandler paramConnectionErrorHandler) {
    this.mErrorHandler = paramConnectionErrorHandler;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Interface$AbstractProxy$HandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */