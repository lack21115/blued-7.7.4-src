package com.blued.android.framework.pool;

import android.os.Build;
import android.util.Log;
import com.blued.android.core.AppInfo;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadManager {
  private static ThreadManager a;
  
  private static final Long b = Long.valueOf(10L);
  
  private ThreadPoolExecutor c;
  
  private ExecutorService d;
  
  private ExecutorService e;
  
  private ThreadManager() {
    byte b1;
    byte b2;
    if (Runtime.getRuntime().availableProcessors() > 4) {
      b1 = Runtime.getRuntime().availableProcessors();
      b2 = Runtime.getRuntime().availableProcessors();
      b1 >>= 1;
    } else if (Build.VERSION.SDK_INT >= 26) {
      b1 = 4;
      b2 = 8;
    } else {
      b1 = 2;
      b2 = 4;
    } 
    try {
      this.c = new ThreadPoolExecutor(b1, b2, b.longValue(), TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>(20, new Comparator<Runnable>(this) {
              public int a(Runnable param1Runnable1, Runnable param1Runnable2) {
                int i;
                int j;
                if (param1Runnable1 instanceof ThreadExecutor) {
                  i = ((ThreadExecutor)param1Runnable1).getThreadPriority().ordinal();
                } else {
                  i = ThreadPriority.b.ordinal();
                } 
                if (param1Runnable2 instanceof ThreadExecutor) {
                  j = ((ThreadExecutor)param1Runnable2).getThreadPriority().ordinal();
                } else {
                  j = ThreadPriority.b.ordinal();
                } 
                return (i > j) ? -1 : ((i == j) ? 0 : 1);
              }
            }), new DefaultThreadFactory(), new RejectedExecutionHandler(this) {
            public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
              if (AppInfo.m()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("rejectedExecution: ");
                stringBuilder.append(param1Runnable.toString());
                Log.i("ThreadManager", stringBuilder.toString());
              } 
            }
          });
      this.c.allowCoreThreadTimeOut(true);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    this.d = new ThreadPoolExecutor(1, 2, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DefaultThreadFactory());
    this.e = new ThreadPoolExecutor(1, 2, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DefaultThreadFactory());
  }
  
  public static ThreadManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/pool/ThreadManager.a : Lcom/blued/android/framework/pool/ThreadManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/framework/pool/ThreadManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/pool/ThreadManager.a : Lcom/blued/android/framework/pool/ThreadManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/framework/pool/ThreadManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/pool/ThreadManager.a : Lcom/blued/android/framework/pool/ThreadManager;
    //   25: ldc com/blued/android/framework/pool/ThreadManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/framework/pool/ThreadManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/framework/pool/ThreadManager.a : Lcom/blued/android/framework/pool/ThreadManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(ThreadExecutor paramThreadExecutor) {
    if (paramThreadExecutor != null) {
      ThreadPoolExecutor threadPoolExecutor = this.c;
      if (threadPoolExecutor != null)
        threadPoolExecutor.execute(paramThreadExecutor); 
    } 
  }
  
  public void a(Runnable paramRunnable) {
    if (paramRunnable != null) {
      ExecutorService executorService = this.d;
      if (executorService != null)
        executorService.execute(paramRunnable); 
    } 
  }
  
  public void b(Runnable paramRunnable) {
    if (paramRunnable != null) {
      ExecutorService executorService = this.e;
      if (executorService != null)
        executorService.execute(paramRunnable); 
    } 
  }
  
  static class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    
    private final ThreadGroup b;
    
    private final AtomicInteger c;
    
    private final String d;
    
    DefaultThreadFactory() {
      ThreadGroup threadGroup;
      this.c = new AtomicInteger(1);
      SecurityManager securityManager = System.getSecurityManager();
      if (securityManager != null) {
        threadGroup = securityManager.getThreadGroup();
      } else {
        threadGroup = Thread.currentThread().getThreadGroup();
      } 
      this.b = threadGroup;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("blued-");
      stringBuilder.append(a.getAndIncrement());
      stringBuilder.append("-pool-");
      this.d = stringBuilder.toString();
    }
    
    public Thread newThread(Runnable param1Runnable) {
      ThreadGroup threadGroup = this.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d);
      stringBuilder.append(this.c.getAndIncrement());
      param1Runnable = new Thread(threadGroup, param1Runnable, stringBuilder.toString(), 0L);
      if (param1Runnable.isDaemon())
        param1Runnable.setDaemon(false); 
      if (param1Runnable.getPriority() != 5)
        param1Runnable.setPriority(5); 
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\pool\ThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */