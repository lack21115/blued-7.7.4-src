package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
  public static Executor a = Executors.newCachedThreadPool();
  
  private final Set<LottieListener<T>> b = new LinkedHashSet<LottieListener<T>>(1);
  
  private final Set<LottieListener<Throwable>> c = new LinkedHashSet<LottieListener<Throwable>>(1);
  
  private final Handler d = new Handler(Looper.getMainLooper());
  
  private volatile LottieResult<T> e = null;
  
  public LottieTask(Callable<LottieResult<T>> paramCallable) {
    this(paramCallable, false);
  }
  
  LottieTask(Callable<LottieResult<T>> paramCallable, boolean paramBoolean) {
    if (paramBoolean)
      try {
        return;
      } finally {
        paramCallable = null;
        a(new LottieResult<T>((Throwable)paramCallable));
      }  
    a.execute(new LottieFutureTask(this, paramCallable));
  }
  
  private void a() {
    this.d.post(new Runnable(this) {
          public void run() {
            if (LottieTask.a(this.a) == null)
              return; 
            LottieResult lottieResult = LottieTask.a(this.a);
            if (lottieResult.a() != null) {
              LottieTask.a(this.a, lottieResult.a());
              return;
            } 
            LottieTask.a(this.a, lottieResult.b());
          }
        });
  }
  
  private void a(LottieResult<T> paramLottieResult) {
    if (this.e == null) {
      this.e = paramLottieResult;
      a();
      return;
    } 
    throw new IllegalStateException("A task may only be set once.");
  }
  
  private void a(T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: aload_0
    //   7: getfield b : Ljava/util/Set;
    //   10: invokespecial <init> : (Ljava/util/Collection;)V
    //   13: invokeinterface iterator : ()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface hasNext : ()Z
    //   25: ifeq -> 46
    //   28: aload_2
    //   29: invokeinterface next : ()Ljava/lang/Object;
    //   34: checkcast com/airbnb/lottie/LottieListener
    //   37: aload_1
    //   38: invokeinterface a : (Ljava/lang/Object;)V
    //   43: goto -> 19
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	49	finally
    //   19	43	49	finally
  }
  
  private void a(Throwable paramThrowable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: aload_0
    //   7: getfield c : Ljava/util/Set;
    //   10: invokespecial <init> : (Ljava/util/Collection;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokeinterface isEmpty : ()Z
    //   20: ifeq -> 32
    //   23: ldc 'Lottie encountered an error but no failure listener was added:'
    //   25: aload_1
    //   26: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_2
    //   33: invokeinterface iterator : ()Ljava/util/Iterator;
    //   38: astore_2
    //   39: aload_2
    //   40: invokeinterface hasNext : ()Z
    //   45: ifeq -> 66
    //   48: aload_2
    //   49: invokeinterface next : ()Ljava/lang/Object;
    //   54: checkcast com/airbnb/lottie/LottieListener
    //   57: aload_1
    //   58: invokeinterface a : (Ljava/lang/Object;)V
    //   63: goto -> 39
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	69	finally
    //   32	39	69	finally
    //   39	63	69	finally
  }
  
  public LottieTask<T> a(LottieListener<T> paramLottieListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Lcom/airbnb/lottie/LottieResult;
    //   6: ifnull -> 32
    //   9: aload_0
    //   10: getfield e : Lcom/airbnb/lottie/LottieResult;
    //   13: invokevirtual a : ()Ljava/lang/Object;
    //   16: ifnull -> 32
    //   19: aload_1
    //   20: aload_0
    //   21: getfield e : Lcom/airbnb/lottie/LottieResult;
    //   24: invokevirtual a : ()Ljava/lang/Object;
    //   27: invokeinterface a : (Ljava/lang/Object;)V
    //   32: aload_0
    //   33: getfield b : Ljava/util/Set;
    //   36: aload_1
    //   37: invokeinterface add : (Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	47	finally
    //   32	43	47	finally
  }
  
  public LottieTask<T> b(LottieListener<T> paramLottieListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally
  }
  
  public LottieTask<T> c(LottieListener<Throwable> paramLottieListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Lcom/airbnb/lottie/LottieResult;
    //   6: ifnull -> 32
    //   9: aload_0
    //   10: getfield e : Lcom/airbnb/lottie/LottieResult;
    //   13: invokevirtual b : ()Ljava/lang/Throwable;
    //   16: ifnull -> 32
    //   19: aload_1
    //   20: aload_0
    //   21: getfield e : Lcom/airbnb/lottie/LottieResult;
    //   24: invokevirtual b : ()Ljava/lang/Throwable;
    //   27: invokeinterface a : (Ljava/lang/Object;)V
    //   32: aload_0
    //   33: getfield c : Ljava/util/Set;
    //   36: aload_1
    //   37: invokeinterface add : (Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	47	finally
    //   32	43	47	finally
  }
  
  public LottieTask<T> d(LottieListener<Throwable> paramLottieListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally
  }
  
  class LottieFutureTask extends FutureTask<LottieResult<T>> {
    LottieFutureTask(LottieTask this$0, Callable<LottieResult<T>> param1Callable) {
      super(param1Callable);
    }
    
    protected void done() {
      if (isCancelled())
        return; 
      try {
        LottieTask.a(this.a, get());
        return;
      } catch (InterruptedException interruptedException) {
      
      } catch (ExecutionException executionException) {}
      LottieTask.a(this.a, new LottieResult(executionException));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\LottieTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */