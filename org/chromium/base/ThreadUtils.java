package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.chromium.base.annotations.CalledByNative;

public class ThreadUtils {
  private static final Object sLock;
  
  private static boolean sThreadAssertsDisabled;
  
  private static Handler sUiThreadHandler;
  
  private static boolean sWillOverride;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void assertOnBackgroundThread() {
    if (sThreadAssertsDisabled)
      return; 
    assert false;
  }
  
  public static void assertOnUiThread() {
    if (sThreadAssertsDisabled)
      return; 
    assert false;
  }
  
  private static Handler getUiThreadHandler() {
    synchronized (sLock) {
      if (sUiThreadHandler == null)
        if (!sWillOverride) {
          sUiThreadHandler = new Handler(Looper.getMainLooper());
        } else {
          throw new RuntimeException("Did not yet override the UI thread");
        }  
      return sUiThreadHandler;
    } 
  }
  
  public static Looper getUiThreadLooper() {
    return getUiThreadHandler().getLooper();
  }
  
  @CalledByNative
  private static boolean isThreadPriorityAudio(int paramInt) {
    return (Process.getThreadPriority(paramInt) == -16);
  }
  
  private static FutureTask postOnUiThread(FutureTask paramFutureTask) {
    getUiThreadHandler().post(paramFutureTask);
    return paramFutureTask;
  }
  
  public static void postOnUiThread(Runnable paramRunnable) {
    getUiThreadHandler().post(paramRunnable);
  }
  
  public static void postOnUiThreadDelayed(Runnable paramRunnable, long paramLong) {
    getUiThreadHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public static FutureTask runOnUiThread(FutureTask paramFutureTask) {
    if (runningOnUiThread()) {
      paramFutureTask.run();
      return paramFutureTask;
    } 
    postOnUiThread(paramFutureTask);
    return paramFutureTask;
  }
  
  public static void runOnUiThread(Runnable paramRunnable) {
    if (runningOnUiThread()) {
      paramRunnable.run();
      return;
    } 
    getUiThreadHandler().post(paramRunnable);
  }
  
  private static Object runOnUiThreadBlocking(Callable<?> paramCallable) {
    FutureTask<FutureTask> futureTask = new FutureTask(paramCallable);
    runOnUiThread(futureTask);
    try {
      return futureTask.get();
    } catch (InterruptedException interruptedException) {
      throw new RuntimeException("Interrupted waiting for callable", interruptedException);
    } 
  }
  
  public static void runOnUiThreadBlocking(Runnable paramRunnable) {
    if (runningOnUiThread()) {
      paramRunnable.run();
      return;
    } 
    paramRunnable = new FutureTask(paramRunnable, null);
    postOnUiThread((FutureTask)paramRunnable);
    try {
      paramRunnable.get();
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Exception occurred while waiting for runnable", exception);
    } 
  }
  
  public static Object runOnUiThreadBlockingNoException(Callable paramCallable) {
    try {
      return runOnUiThreadBlocking(paramCallable);
    } catch (ExecutionException executionException) {
      throw new RuntimeException("Error occurred waiting for callable", executionException);
    } 
  }
  
  public static boolean runningOnUiThread() {
    return (getUiThreadHandler().getLooper() == Looper.myLooper());
  }
  
  @CalledByNative
  public static void setThreadPriorityAudio(int paramInt) {
    Process.setThreadPriority(paramInt, -16);
  }
  
  public static void setUiThread(Looper paramLooper) {
    // Byte code:
    //   0: getstatic org/chromium/base/ThreadUtils.sLock : Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull -> 17
    //   10: aconst_null
    //   11: putstatic org/chromium/base/ThreadUtils.sUiThreadHandler : Landroid/os/Handler;
    //   14: aload_1
    //   15: monitorexit
    //   16: return
    //   17: getstatic org/chromium/base/ThreadUtils.sUiThreadHandler : Landroid/os/Handler;
    //   20: ifnull -> 97
    //   23: getstatic org/chromium/base/ThreadUtils.sUiThreadHandler : Landroid/os/Handler;
    //   26: invokevirtual getLooper : ()Landroid/os/Looper;
    //   29: aload_0
    //   30: if_acmpne -> 36
    //   33: goto -> 97
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: ldc 'UI thread looper is already set to '
    //   42: invokespecial <init> : (Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: getstatic org/chromium/base/ThreadUtils.sUiThreadHandler : Landroid/os/Handler;
    //   50: invokevirtual getLooper : ()Landroid/os/Looper;
    //   53: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc ' (Main thread looper is '
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   68: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: ldc '), cannot set to new looper '
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: aload_0
    //   81: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: new java/lang/RuntimeException
    //   88: dup
    //   89: aload_2
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: invokespecial <init> : (Ljava/lang/String;)V
    //   96: athrow
    //   97: new android/os/Handler
    //   100: dup
    //   101: aload_0
    //   102: invokespecial <init> : (Landroid/os/Looper;)V
    //   105: putstatic org/chromium/base/ThreadUtils.sUiThreadHandler : Landroid/os/Handler;
    //   108: aload_1
    //   109: monitorexit
    //   110: return
    //   111: aload_1
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    //   115: astore_0
    //   116: goto -> 111
    // Exception table:
    //   from	to	target	type
    //   10	16	115	finally
    //   17	33	115	finally
    //   36	97	115	finally
    //   97	110	115	finally
    //   111	113	115	finally
  }
  
  public static void setWillOverrideUiThread() {
    synchronized (sLock) {
      sWillOverride = true;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */