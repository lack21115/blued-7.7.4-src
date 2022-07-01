package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.Watcher;

public class Connector implements HandleOwner, MessageReceiver {
  ConnectionErrorHandler mErrorHandler;
  
  public MessageReceiver mIncomingMessageReceiver;
  
  private final MessagePipeHandle mMessagePipeHandle;
  
  private final Watcher mWatcher;
  
  private final Connector$WatcherCallback mWatcherCallback = new Connector$WatcherCallback(this, (byte)0);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public Connector(MessagePipeHandle paramMessagePipeHandle) {
    this(paramMessagePipeHandle, BindingsHelper.getWatcherForHandle((Handle)paramMessagePipeHandle));
  }
  
  public Connector(MessagePipeHandle paramMessagePipeHandle, Watcher paramWatcher) {
    this.mMessagePipeHandle = paramMessagePipeHandle;
    this.mWatcher = paramWatcher;
  }
  
  private void cancelIfActive() {
    this.mWatcher.cancel();
    this.mWatcher.destroy();
  }
  
  private void onError(MojoException paramMojoException) {
    close();
    if (this.mErrorHandler != null)
      this.mErrorHandler.onConnectionError(paramMojoException); 
  }
  
  private static ResultAnd readAndDispatchMessage(MessagePipeHandle paramMessagePipeHandle, MessageReceiver paramMessageReceiver) {
    ResultAnd resultAnd = paramMessagePipeHandle.readMessage(MessagePipeHandle.ReadFlags.NONE);
    if (resultAnd.mMojoResult != 0)
      return new ResultAnd(resultAnd.mMojoResult, Boolean.valueOf(false)); 
    MessagePipeHandle.ReadMessageResult readMessageResult = (MessagePipeHandle.ReadMessageResult)resultAnd.mValue;
    assert false;
    throw new AssertionError();
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      this.mMessagePipeHandle.writeMessage(paramMessage.mBuffer, paramMessage.mHandles, MessagePipeHandle.WriteFlags.NONE);
      return true;
    } catch (MojoException mojoException) {
      onError(mojoException);
      return false;
    } 
  }
  
  public void close() {
    cancelIfActive();
    this.mMessagePipeHandle.close();
    if (this.mIncomingMessageReceiver != null) {
      MessageReceiver messageReceiver = this.mIncomingMessageReceiver;
      this.mIncomingMessageReceiver = null;
      messageReceiver.close();
    } 
  }
  
  public final MessagePipeHandle passHandle() {
    cancelIfActive();
    MessagePipeHandle messagePipeHandle = this.mMessagePipeHandle.pass();
    if (this.mIncomingMessageReceiver != null)
      this.mIncomingMessageReceiver.close(); 
    return messagePipeHandle;
  }
  
  public final void start() {
    this.mWatcher.start((Handle)this.mMessagePipeHandle, Core.HandleSignals.READABLE, this.mWatcherCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Connector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */