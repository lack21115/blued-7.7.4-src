package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor implements ExecutorService {
  private static final long a = TimeUnit.SECONDS.toMillis(10L);
  
  private static volatile int b;
  
  private final ExecutorService c;
  
  GlideExecutor(ExecutorService paramExecutorService) {
    this.c = paramExecutorService;
  }
  
  public static Builder a() {
    return (new Builder(true)).a(1).a("disk-cache");
  }
  
  public static GlideExecutor b() {
    return a().a();
  }
  
  public static Builder c() {
    return (new Builder(false)).a(h()).a("source");
  }
  
  public static GlideExecutor d() {
    return c().a();
  }
  
  public static GlideExecutor e() {
    return new GlideExecutor(new ThreadPoolExecutor(0, 2147483647, a, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.d, false)));
  }
  
  public static Builder f() {
    boolean bool;
    if (h() >= 4) {
      bool = true;
    } else {
      bool = true;
    } 
    return (new Builder(true)).a(bool).a("animation");
  }
  
  public static GlideExecutor g() {
    return f().a();
  }
  
  public static int h() {
    if (b == 0)
      b = Math.min(4, RuntimeCompat.a()); 
    return b;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.c.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(Runnable paramRunnable) {
    this.c.execute(paramRunnable);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection) throws InterruptedException {
    return this.c.invokeAll(paramCollection);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.c.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection) throws InterruptedException, ExecutionException {
    return this.c.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return this.c.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown() {
    return this.c.isShutdown();
  }
  
  public boolean isTerminated() {
    return this.c.isTerminated();
  }
  
  public void shutdown() {
    this.c.shutdown();
  }
  
  public List<Runnable> shutdownNow() {
    return this.c.shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable) {
    return this.c.submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT) {
    return this.c.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable) {
    return this.c.submit(paramCallable);
  }
  
  public String toString() {
    return this.c.toString();
  }
  
  public static final class Builder {
    private final boolean a;
    
    private int b;
    
    private int c;
    
    private GlideExecutor.UncaughtThrowableStrategy d = GlideExecutor.UncaughtThrowableStrategy.d;
    
    private String e;
    
    private long f;
    
    Builder(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public Builder a(int param1Int) {
      this.b = param1Int;
      this.c = param1Int;
      return this;
    }
    
    public Builder a(String param1String) {
      this.e = param1String;
      return this;
    }
    
    public GlideExecutor a() {
      if (!TextUtils.isEmpty(this.e)) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), new GlideExecutor.DefaultThreadFactory(this.e, this.d, this.a));
        if (this.f != 0L)
          threadPoolExecutor.allowCoreThreadTimeOut(true); 
        return new GlideExecutor(threadPoolExecutor);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Name must be non-null and non-empty, but given: ");
      stringBuilder.append(this.e);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
  }
  
  static final class DefaultThreadFactory implements ThreadFactory {
    final GlideExecutor.UncaughtThrowableStrategy a;
    
    final boolean b;
    
    private final String c;
    
    private int d;
    
    DefaultThreadFactory(String param1String, GlideExecutor.UncaughtThrowableStrategy param1UncaughtThrowableStrategy, boolean param1Boolean) {
      this.c = param1String;
      this.a = param1UncaughtThrowableStrategy;
      this.b = param1Boolean;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial <init> : ()V
      //   9: astore_2
      //   10: aload_2
      //   11: ldc 'glide-'
      //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: pop
      //   17: aload_2
      //   18: aload_0
      //   19: getfield c : Ljava/lang/String;
      //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: pop
      //   26: aload_2
      //   27: ldc '-thread-'
      //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: pop
      //   33: aload_2
      //   34: aload_0
      //   35: getfield d : I
      //   38: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   41: pop
      //   42: new com/bumptech/glide/load/engine/executor/GlideExecutor$DefaultThreadFactory$1
      //   45: dup
      //   46: aload_0
      //   47: aload_1
      //   48: aload_2
      //   49: invokevirtual toString : ()Ljava/lang/String;
      //   52: invokespecial <init> : (Lcom/bumptech/glide/load/engine/executor/GlideExecutor$DefaultThreadFactory;Ljava/lang/Runnable;Ljava/lang/String;)V
      //   55: astore_1
      //   56: aload_0
      //   57: aload_0
      //   58: getfield d : I
      //   61: iconst_1
      //   62: iadd
      //   63: putfield d : I
      //   66: aload_0
      //   67: monitorexit
      //   68: aload_1
      //   69: areturn
      //   70: astore_1
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_1
      //   74: athrow
      // Exception table:
      //   from	to	target	type
      //   2	66	70	finally
    }
  }
  
  class null extends Thread {
    null(GlideExecutor this$0, Runnable param1Runnable, String param1String) {
      super(param1Runnable, param1String);
    }
    
    public void run() {
      Process.setThreadPriority(9);
      if (this.a.b)
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder()).detectNetwork().penaltyDeath().build()); 
      try {
        return;
      } finally {
        Exception exception = null;
        this.a.a.a(exception);
      } 
    }
  }
  
  public static interface UncaughtThrowableStrategy {
    public static final UncaughtThrowableStrategy a = new UncaughtThrowableStrategy() {
        public void a(Throwable param2Throwable) {}
      };
    
    public static final UncaughtThrowableStrategy b = new UncaughtThrowableStrategy() {
        public void a(Throwable param2Throwable) {
          if (param2Throwable != null && Log.isLoggable("GlideExecutor", 6))
            Log.e("GlideExecutor", "Request threw uncaught throwable", param2Throwable); 
        }
      };
    
    public static final UncaughtThrowableStrategy c = new UncaughtThrowableStrategy() {
        public void a(Throwable param2Throwable) {
          if (param2Throwable == null)
            return; 
          throw new RuntimeException("Request threw uncaught throwable", param2Throwable);
        }
      };
    
    public static final UncaughtThrowableStrategy d = b;
    
    void a(Throwable param1Throwable);
  }
  
  class null implements UncaughtThrowableStrategy {
    public void a(Throwable param1Throwable) {}
  }
  
  class null implements UncaughtThrowableStrategy {
    public void a(Throwable param1Throwable) {
      if (param1Throwable != null && Log.isLoggable("GlideExecutor", 6))
        Log.e("GlideExecutor", "Request threw uncaught throwable", param1Throwable); 
    }
  }
  
  class null implements UncaughtThrowableStrategy {
    public void a(Throwable param1Throwable) {
      if (param1Throwable == null)
        return; 
      throw new RuntimeException("Request threw uncaught throwable", param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\executor\GlideExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */