package org.chromium.base;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import org.chromium.base.annotations.CalledByNative;

public class JavaHandlerThread {
  public final HandlerThread mThread;
  
  private Throwable mUnhandledException;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public JavaHandlerThread(String paramString, int paramInt) {
    this.mThread = new HandlerThread(paramString, paramInt);
  }
  
  @CalledByNative
  private static JavaHandlerThread create(String paramString, int paramInt) {
    return new JavaHandlerThread(paramString, paramInt);
  }
  
  @CalledByNative
  private Throwable getUncaughtExceptionIfAny() {
    return this.mUnhandledException;
  }
  
  @CalledByNative
  private boolean isAlive() {
    return this.mThread.isAlive();
  }
  
  @CalledByNative
  private void joinThread() {
    boolean bool = false;
    while (!bool) {
      try {
        this.mThread.join();
        bool = true;
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  @CalledByNative
  private void listenForUncaughtExceptionsForTesting() {
    this.mThread.setUncaughtExceptionHandler(new JavaHandlerThread$3(this));
  }
  
  private native void nativeInitializeThread(long paramLong1, long paramLong2);
  
  private native void nativeOnLooperStopped(long paramLong);
  
  @CalledByNative
  private void quitThreadSafely(long paramLong) {
    (new Handler(this.mThread.getLooper())).post(new JavaHandlerThread$2(this, paramLong));
    if (Build.VERSION.SDK_INT >= 18)
      this.mThread.getLooper().quitSafely(); 
  }
  
  @CalledByNative
  private void startAndInitialize(long paramLong1, long paramLong2) {
    maybeStart();
    (new Handler(this.mThread.getLooper())).post(new JavaHandlerThread$1(this, paramLong1, paramLong2));
  }
  
  public final boolean hasStarted() {
    return (this.mThread.getState() != Thread.State.NEW);
  }
  
  public final void maybeStart() {
    if (hasStarted())
      return; 
    this.mThread.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\JavaHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */