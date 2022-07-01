package org.chromium.mojo.bindings;

import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;

final class AutoCloseableRouter implements Router {
  private final Exception mAllocationException;
  
  private boolean mClosed;
  
  private final Executor mExecutor;
  
  private final Router mRouter;
  
  public AutoCloseableRouter(Core paramCore, Router paramRouter) {
    this.mRouter = paramRouter;
    this.mExecutor = ExecutorFactory.getExecutorForCurrentThread(paramCore);
    this.mAllocationException = new Exception("AutocloseableRouter allocated at:");
  }
  
  public final boolean accept(Message paramMessage) {
    return this.mRouter.accept(paramMessage);
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    return this.mRouter.acceptWithResponder(paramMessage, paramMessageReceiver);
  }
  
  public final void close() {
    this.mRouter.close();
    this.mClosed = true;
  }
  
  protected final void finalize() {
    if (this.mClosed) {
      super.finalize();
      return;
    } 
    this.mExecutor.execute(new AutoCloseableRouter$1(this));
    throw new IllegalStateException("Warning: Router objects should be explicitly closed when no longer required otherwise you may leak handles.", this.mAllocationException);
  }
  
  public final void setErrorHandler(ConnectionErrorHandler paramConnectionErrorHandler) {
    this.mRouter.setErrorHandler(paramConnectionErrorHandler);
  }
  
  public final void setIncomingMessageReceiver(MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    this.mRouter.setIncomingMessageReceiver(paramMessageReceiverWithResponder);
  }
  
  public final void start() {
    this.mRouter.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\AutoCloseableRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */