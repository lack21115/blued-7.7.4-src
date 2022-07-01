package org.chromium.mojo.bindings;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.Watcher;

@SuppressLint({"UseSparseArrays"})
public class RouterImpl implements Router {
  final Connector mConnector;
  
  private final Executor mExecutor;
  
  private MessageReceiverWithResponder mIncomingMessageReceiver;
  
  private long mNextRequestId = 1L;
  
  private Map mResponders = new HashMap<Object, Object>();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public RouterImpl(MessagePipeHandle paramMessagePipeHandle) {
    this(paramMessagePipeHandle, BindingsHelper.getWatcherForHandle((Handle)paramMessagePipeHandle));
  }
  
  private RouterImpl(MessagePipeHandle paramMessagePipeHandle, Watcher paramWatcher) {
    this.mConnector = new Connector(paramMessagePipeHandle, paramWatcher);
    this.mConnector.mIncomingMessageReceiver = new RouterImpl$HandleIncomingMessageThunk(this, (byte)0);
    Core core = paramMessagePipeHandle.getCore();
    if (core != null) {
      this.mExecutor = ExecutorFactory.getExecutorForCurrentThread(core);
      return;
    } 
    this.mExecutor = null;
  }
  
  public final boolean accept(Message paramMessage) {
    return this.mConnector.accept(paramMessage);
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    paramMessage = paramMessage.asServiceMessage();
    assert false;
    throw new AssertionError();
  }
  
  public void close() {
    this.mConnector.close();
  }
  
  public final void setErrorHandler(ConnectionErrorHandler paramConnectionErrorHandler) {
    this.mConnector.mErrorHandler = paramConnectionErrorHandler;
  }
  
  public final void setIncomingMessageReceiver(MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    this.mIncomingMessageReceiver = paramMessageReceiverWithResponder;
  }
  
  public final void start() {
    this.mConnector.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\RouterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */