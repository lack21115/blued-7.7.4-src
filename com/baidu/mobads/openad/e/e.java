package com.baidu.mobads.openad.e;

import android.util.Log;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class e {
  private static final Map<Integer, Map<Integer, ExecutorService>> a = new ConcurrentHashMap<Integer, Map<Integer, ExecutorService>>();
  
  private static final Map<c, TimerTask> b = new ConcurrentHashMap<c, TimerTask>();
  
  private static final Map<ExecutorService, List<c>> c = new ConcurrentHashMap<ExecutorService, List<c>>();
  
  private static final int d = Runtime.getRuntime().availableProcessors();
  
  private static final Timer e = new Timer();
  
  private static Executor f;
  
  private static ExecutorService a(int paramInt) {
    return a(paramInt, 5);
  }
  
  private static ExecutorService a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: ldc com/baidu/mobads/openad/e/e
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/openad/e/e.a : Ljava/util/Map;
    //   6: iload_0
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast java/util/Map
    //   18: astore #4
    //   20: aload #4
    //   22: ifnonnull -> 68
    //   25: new java/util/concurrent/ConcurrentHashMap
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore_3
    //   33: iload_0
    //   34: iload_1
    //   35: invokestatic a : (II)Ljava/util/concurrent/ExecutorService;
    //   38: astore_2
    //   39: aload_3
    //   40: iload_1
    //   41: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   44: aload_2
    //   45: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: getstatic com/baidu/mobads/openad/e/e.a : Ljava/util/Map;
    //   54: iload_0
    //   55: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   58: aload_3
    //   59: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: goto -> 108
    //   68: aload #4
    //   70: iload_1
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast java/util/concurrent/ExecutorService
    //   82: astore_3
    //   83: aload_3
    //   84: astore_2
    //   85: aload_3
    //   86: ifnonnull -> 108
    //   89: iload_0
    //   90: iload_1
    //   91: invokestatic a : (II)Ljava/util/concurrent/ExecutorService;
    //   94: astore_2
    //   95: aload #4
    //   97: iload_1
    //   98: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   101: aload_2
    //   102: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: ldc com/baidu/mobads/openad/e/e
    //   110: monitorexit
    //   111: aload_2
    //   112: areturn
    //   113: astore_2
    //   114: ldc com/baidu/mobads/openad/e/e
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	113	finally
    //   25	65	113	finally
    //   68	83	113	finally
    //   89	108	113	finally
  }
  
  public static <T> void a(c<T> paramc) {
    a(a(-8), paramc);
  }
  
  private static <T> void a(ExecutorService paramExecutorService, c<T> paramc) {
    paramExecutorService.execute(paramc);
    b(paramExecutorService, paramc);
  }
  
  private static <T> void b(ExecutorService paramExecutorService, c<T> paramc) {
    List<c> list2 = c.get(paramExecutorService);
    List<c> list1 = list2;
    if (list2 == null) {
      list1 = new CopyOnWriteArrayList();
      c.put(paramExecutorService, list1);
    } 
    list1.add(paramc);
  }
  
  private static Executor c() {
    if (f == null)
      f = new f(); 
    return f;
  }
  
  private static void c(c paramc) {
    TimerTask timerTask = b.get(paramc);
    if (timerTask != null) {
      b.remove(paramc);
      timerTask.cancel();
    } 
  }
  
  static final class a extends LinkedBlockingQueue<Runnable> {
    private volatile e.d a;
    
    private int b = Integer.MAX_VALUE;
    
    public boolean a(Runnable param1Runnable) {
      return (this.b <= size() && this.a != null && this.a.getPoolSize() < this.a.getMaximumPoolSize()) ? false : super.offer(param1Runnable);
    }
  }
  
  public static abstract class b<T> extends c<T> {
    public void a(Throwable param1Throwable) {
      Log.e("ThreadUtils", "onFail: ", param1Throwable);
    }
  }
  
  public static abstract class c<T> implements Runnable {
    private static final Object a = "";
    
    private volatile int b = 0;
    
    private volatile boolean c;
    
    private volatile Thread d;
    
    private Executor e;
    
    private Executor b() {
      Executor executor2 = this.e;
      Executor executor1 = executor2;
      if (executor2 == null)
        executor1 = e.b(); 
      return executor1;
    }
    
    public abstract T a();
    
    public abstract void a(T param1T);
    
    public abstract void a(Throwable param1Throwable);
    
    public void run() {
      if (this.b != 0)
        return; 
      synchronized (a) {
        this.d = Thread.currentThread();
        try {
          null = a();
          if (this.b != 0)
            return; 
          return;
        } catch (InterruptedException interruptedException) {
          return;
        } finally {
          null = null;
          if (this.b != 0)
            return; 
          this.b = 3;
        } 
        return;
      } 
    }
  }
  
  static final class d extends ThreadPoolExecutor {
    private final AtomicInteger a = new AtomicInteger();
    
    private e.a b;
    
    d(int param1Int1, int param1Int2, long param1Long, TimeUnit param1TimeUnit, e.a param1a, ThreadFactory param1ThreadFactory) {
      super(param1Int1, param1Int2, param1Long, param1TimeUnit, param1a, param1ThreadFactory);
      e.a.a(param1a, this);
      this.b = param1a;
    }
    
    private static ExecutorService b(int param1Int1, int param1Int2) {
      if (param1Int1 != -8) {
        if (param1Int1 != -4) {
          if (param1Int1 != -2) {
            if (param1Int1 != -1) {
              TimeUnit timeUnit = TimeUnit.MILLISECONDS;
              e.a a1 = new e.a();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("fixed(");
              stringBuilder.append(param1Int1);
              stringBuilder.append(")");
              return new d(param1Int1, param1Int1, 0L, timeUnit, a1, new e.e(stringBuilder.toString(), param1Int2));
            } 
            return new d(1, 1, 0L, TimeUnit.MILLISECONDS, new e.a(), new e.e("single", param1Int2));
          } 
          return new d(0, 128, 60L, TimeUnit.SECONDS, new e.a(), new e.e("cached", param1Int2));
        } 
        return new d(0, e.a() * 2 + 1, 30L, TimeUnit.SECONDS, new e.a(), new e.e("io", param1Int2));
      } 
      return new d(e.a() + 1, e.a() * 2 + 1, 30L, TimeUnit.SECONDS, new e.a(), new e.e("cpu", param1Int2));
    }
    
    protected void afterExecute(Runnable param1Runnable, Throwable param1Throwable) {
      this.a.decrementAndGet();
      super.afterExecute(param1Runnable, param1Throwable);
    }
    
    public void execute(Runnable param1Runnable) {
      if (isShutdown())
        return; 
      this.a.incrementAndGet();
      try {
        return;
      } catch (RejectedExecutionException rejectedExecutionException) {
        return;
      } finally {
        param1Runnable = null;
        this.a.decrementAndGet();
      } 
    }
  }
  
  static final class e extends AtomicLong implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    
    private final String b;
    
    private final int c;
    
    private final boolean d;
    
    e(String param1String, int param1Int) {
      this(param1String, param1Int, false);
    }
    
    e(String param1String, int param1Int, boolean param1Boolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append("-pool-");
      stringBuilder.append(a.getAndIncrement());
      stringBuilder.append("-thread-");
      this.b = stringBuilder.toString();
      this.c = param1Int;
      this.d = param1Boolean;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(getAndIncrement());
      param1Runnable = new j(this, param1Runnable, stringBuilder.toString());
      param1Runnable.setDaemon(this.d);
      param1Runnable.setUncaughtExceptionHandler(new k(this));
      param1Runnable.setPriority(this.c);
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */