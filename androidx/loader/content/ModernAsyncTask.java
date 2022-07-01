package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
  public static final Executor THREAD_POOL_EXECUTOR;
  
  private static final ThreadFactory a = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public Thread newThread(Runnable param1Runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModernAsyncTask #");
        stringBuilder.append(this.a.getAndIncrement());
        return new Thread(param1Runnable, stringBuilder.toString());
      }
    };
  
  private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue<Runnable>(10);
  
  private static InternalHandler e;
  
  private static volatile Executor f;
  
  final AtomicBoolean c = new AtomicBoolean();
  
  final AtomicBoolean d = new AtomicBoolean();
  
  private final WorkerRunnable<Params, Result> g = new WorkerRunnable<Params, Result>(this) {
      public Result call() throws Exception {
        this.a.d.set(true);
        Object object2 = null;
        Object object1 = object2;
        try {
          Process.setThreadPriority(10);
          object1 = object2;
          object2 = this.a.a((Object[])this.b);
          object1 = object2;
          Binder.flushPendingCommands();
          return (Result)object2;
        } finally {
          object2 = null;
        } 
      }
    };
  
  private final FutureTask<Result> h = new FutureTask<Result>(this, this.g) {
      protected void done() {
        try {
          Result result = get();
          return;
        } catch (InterruptedException interruptedException) {
          return;
        } catch (ExecutionException executionException) {
          throw new RuntimeException("An error occurred while executing doInBackground()", executionException.getCause());
        } catch (CancellationException cancellationException) {
          return;
        } finally {
          Exception exception = null;
        } 
      }
    };
  
  private volatile Status i = Status.PENDING;
  
  static {
    THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
    f = THREAD_POOL_EXECUTOR;
  }
  
  private static Handler c() {
    // Byte code:
    //   0: ldc androidx/loader/content/ModernAsyncTask
    //   2: monitorenter
    //   3: getstatic androidx/loader/content/ModernAsyncTask.e : Landroidx/loader/content/ModernAsyncTask$InternalHandler;
    //   6: ifnonnull -> 19
    //   9: new androidx/loader/content/ModernAsyncTask$InternalHandler
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic androidx/loader/content/ModernAsyncTask.e : Landroidx/loader/content/ModernAsyncTask$InternalHandler;
    //   19: getstatic androidx/loader/content/ModernAsyncTask.e : Landroidx/loader/content/ModernAsyncTask$InternalHandler;
    //   22: astore_0
    //   23: ldc androidx/loader/content/ModernAsyncTask
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc androidx/loader/content/ModernAsyncTask
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	26	28	finally
    //   29	32	28	finally
  }
  
  public static void execute(Runnable paramRunnable) {
    f.execute(paramRunnable);
  }
  
  public static void setDefaultExecutor(Executor paramExecutor) {
    f = paramExecutor;
  }
  
  protected abstract Result a(Params... paramVarArgs);
  
  protected void a() {}
  
  protected void a(Result paramResult) {}
  
  protected void b() {}
  
  protected void b(Result paramResult) {
    b();
  }
  
  protected void b(Progress... paramVarArgs) {}
  
  void c(Result paramResult) {
    if (!this.d.get())
      d(paramResult); 
  }
  
  public final boolean cancel(boolean paramBoolean) {
    this.c.set(true);
    return this.h.cancel(paramBoolean);
  }
  
  Result d(Result paramResult) {
    c().obtainMessage(1, new AsyncTaskResult(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  void e(Result paramResult) {
    if (isCancelled()) {
      b(paramResult);
    } else {
      a(paramResult);
    } 
    this.i = Status.FINISHED;
  }
  
  public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramVarArgs) {
    return executeOnExecutor(f, paramVarArgs);
  }
  
  public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs) {
    if (this.i != Status.PENDING) {
      int i = null.a[this.i.ordinal()];
      if (i != 1) {
        if (i != 2)
          throw new IllegalStateException("We should never reach this state"); 
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
      } 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    } 
    this.i = Status.RUNNING;
    a();
    this.g.b = paramVarArgs;
    paramExecutor.execute(this.h);
    return this;
  }
  
  public final Result get() throws InterruptedException, ExecutionException {
    return this.h.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return this.h.get(paramLong, paramTimeUnit);
  }
  
  public final Status getStatus() {
    return this.i;
  }
  
  public final boolean isCancelled() {
    return this.c.get();
  }
  
  static class AsyncTaskResult<Data> {
    final ModernAsyncTask a;
    
    final Data[] b;
    
    AsyncTaskResult(ModernAsyncTask param1ModernAsyncTask, Data... param1VarArgs) {
      this.a = param1ModernAsyncTask;
      this.b = param1VarArgs;
    }
  }
  
  static class InternalHandler extends Handler {
    InternalHandler() {
      super(Looper.getMainLooper());
    }
    
    public void handleMessage(Message param1Message) {
      ModernAsyncTask.AsyncTaskResult asyncTaskResult = (ModernAsyncTask.AsyncTaskResult)param1Message.obj;
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2)
          return; 
        asyncTaskResult.a.b((Object[])asyncTaskResult.b);
        return;
      } 
      asyncTaskResult.a.e(asyncTaskResult.b[0]);
    }
  }
  
  public enum Status {
    FINISHED, PENDING, RUNNING;
    
    static {
    
    }
  }
  
  static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
    Params[] b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\loader\content\ModernAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */