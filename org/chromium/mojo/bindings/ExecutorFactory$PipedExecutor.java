package org.chromium.mojo.bindings;

import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Watcher;

final class ExecutorFactory$PipedExecutor implements Executor, Watcher.Callback {
  private final Object mLock;
  
  private final List mPendingActions;
  
  private final MessagePipeHandle mReadHandle;
  
  private final Watcher mWatcher;
  
  private final MessagePipeHandle mWriteHandle;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ExecutorFactory$PipedExecutor(Core paramCore) {
    this.mWatcher = paramCore.getWatcher();
    assert false;
    throw new AssertionError();
  }
  
  private boolean readNotifyBufferMessage() {
    try {
      int i = (this.mReadHandle.readMessage(MessagePipeHandle.ReadFlags.NONE)).mMojoResult;
      if (i == 0)
        return true; 
    } catch (MojoException mojoException) {}
    return false;
  }
  
  public final void execute(Runnable paramRunnable) {
    synchronized (this.mLock) {
      if (this.mWriteHandle.isValid()) {
        this.mPendingActions.add(paramRunnable);
        this.mWriteHandle.writeMessage(ExecutorFactory.access$000(), null, MessagePipeHandle.WriteFlags.NONE);
        return;
      } 
      throw new IllegalStateException("Trying to execute an action on a closed executor.");
    } 
  }
  
  public final void onResult(int paramInt) {
    if (paramInt == 0 && readNotifyBufferMessage())
      synchronized (this.mLock) {
        Runnable runnable = this.mPendingActions.remove(0);
        runnable.run();
        return;
      }  
    synchronized (this.mLock) {
      this.mWriteHandle.close();
      this.mPendingActions.clear();
      this.mWatcher.cancel();
      this.mWatcher.destroy();
      this.mReadHandle.close();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\ExecutorFactory$PipedExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */