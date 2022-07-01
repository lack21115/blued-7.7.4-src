package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask {
  private static final int CORE_POOL_SIZE = 0;
  
  private static final int CPU_COUNT = 0;
  
  private static final int MAXIMUM_POOL_SIZE = 0;
  
  public static final Executor SERIAL_EXECUTOR;
  
  public static final Executor THREAD_POOL_EXECUTOR;
  
  private static volatile Executor sDefaultExecutor;
  
  private static AsyncTask$InternalHandler sHandler;
  
  private static final BlockingQueue sPoolWorkQueue;
  
  private static final ThreadFactory sThreadFactory;
  
  public final AtomicBoolean mCancelled;
  
  public final FutureTask mFuture;
  
  private final Handler mHandler;
  
  private volatile AsyncTask$Status mStatus;
  
  private final AtomicBoolean mTaskInvoked;
  
  private final AsyncTask$WorkerRunnable mWorker;
  
  static {
    Runtime.getRuntime();
    throw new VerifyError("bad dex opcode");
  }
  
  public AsyncTask() {
    this(null);
  }
  
  private AsyncTask(Looper paramLooper) {
    Handler handler;
    this.mStatus = AsyncTask$Status.PENDING;
    this.mCancelled = new AtomicBoolean();
    this.mTaskInvoked = new AtomicBoolean();
    if (paramLooper == null || paramLooper == Looper.getMainLooper()) {
      handler = getMainHandler();
    } else {
      handler = new Handler((Looper)handler);
    } 
    this.mHandler = handler;
    this.mWorker = new AsyncTask$2(this);
    this.mFuture = new AsyncTask$NamedFutureTask(this, this.mWorker);
  }
  
  private static Handler getMainHandler() {
    // Byte code:
    //   0: ldc org/chromium/base/AsyncTask
    //   2: monitorenter
    //   3: getstatic org/chromium/base/AsyncTask.sHandler : Lorg/chromium/base/AsyncTask$InternalHandler;
    //   6: ifnonnull -> 22
    //   9: new org/chromium/base/AsyncTask$InternalHandler
    //   12: dup
    //   13: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   16: invokespecial <init> : (Landroid/os/Looper;)V
    //   19: putstatic org/chromium/base/AsyncTask.sHandler : Lorg/chromium/base/AsyncTask$InternalHandler;
    //   22: getstatic org/chromium/base/AsyncTask.sHandler : Lorg/chromium/base/AsyncTask$InternalHandler;
    //   25: astore_0
    //   26: ldc org/chromium/base/AsyncTask
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc org/chromium/base/AsyncTask
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	29	31	finally
    //   32	35	31	finally
  }
  
  protected static void onProgressUpdate$1b4f7664() {}
  
  private Object postResult(Object paramObject) {
    this.mHandler.obtainMessage(1, new AsyncTask$AsyncTaskResult(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  public final boolean cancel(boolean paramBoolean) {
    this.mCancelled.set(true);
    return this.mFuture.cancel(paramBoolean);
  }
  
  public abstract Object doInBackground$42af7916();
  
  public final AsyncTask execute(Object... paramVarArgs) {
    return executeOnExecutor(sDefaultExecutor, paramVarArgs);
  }
  
  public final AsyncTask executeOnExecutor(Executor paramExecutor, Object... paramVarArgs) {
    if (this.mStatus != AsyncTask$Status.PENDING) {
      switch (AsyncTask$3.$SwitchMap$org$chromium$base$AsyncTask$Status[this.mStatus.ordinal()]) {
        default:
          this.mStatus = AsyncTask$Status.RUNNING;
          paramExecutor.execute(this.mFuture);
          return this;
        case 2:
          throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        case 1:
          break;
      } 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    } 
  }
  
  public void onPostExecute(Object paramObject) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */