package org.chromium.mojo.system.impl;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.mojo.system.RunLoop;

class BaseRunLoop implements RunLoop {
  private final CoreImpl mCore;
  
  private long mRunLoopID;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private native long nativeCreateBaseRunLoop();
  
  private native void nativeDeleteMessageLoop(long paramLong);
  
  private native void nativePostDelayedTask(long paramLong1, Runnable paramRunnable, long paramLong2);
  
  private native void nativeQuit();
  
  private native void nativeRun();
  
  private native void nativeRunUntilIdle();
  
  @CalledByNative
  private static void runRunnable(Runnable paramRunnable) {
    paramRunnable.run();
  }
  
  public void close() {
    if (this.mRunLoopID == 0L)
      return; 
    assert false;
    throw new AssertionError("Only the current run loop can be closed");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\BaseRunLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */