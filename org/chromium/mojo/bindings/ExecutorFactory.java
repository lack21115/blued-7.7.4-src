package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;

class ExecutorFactory {
  private static final ThreadLocal EXECUTORS;
  
  private static final ByteBuffer NOTIFY_BUFFER = null;
  
  static {
    EXECUTORS = new ThreadLocal();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Executor getExecutorForCurrentThread(Core paramCore) {
    Executor executor2 = EXECUTORS.get();
    Executor executor1 = executor2;
    if (executor2 == null) {
      executor1 = new ExecutorFactory$PipedExecutor(paramCore);
      EXECUTORS.set(executor1);
    } 
    return executor1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\ExecutorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */