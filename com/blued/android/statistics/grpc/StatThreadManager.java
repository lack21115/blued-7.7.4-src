package com.blued.android.statistics.grpc;

import android.os.Build;
import com.blued.android.statistics.StatConfig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StatThreadManager {
  private static final Long a = Long.valueOf(10L);
  
  private static ThreadPoolExecutor b = null;
  
  private static ExecutorService c = null;
  
  public static void a() {
    byte b1;
    byte b2;
    if (b != null)
      return; 
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
    b = new ThreadPoolExecutor(b1, b2, a.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(30), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
          public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
            if (StatConfig.b())
              StatConfig.a().b(new Object[] { "rejectedExecution:", param1Runnable }); 
          }
        });
    b.allowCoreThreadTimeOut(true);
  }
  
  public static void a(Runnable paramRunnable) {
    if (paramRunnable != null) {
      ThreadPoolExecutor threadPoolExecutor = b;
      if (threadPoolExecutor != null)
        try {
          threadPoolExecutor.execute(paramRunnable);
          return;
        } catch (OutOfMemoryError outOfMemoryError) {
          return;
        }  
    } 
  }
  
  public static ExecutorService b() {
    // Byte code:
    //   0: getstatic com/blued/android/statistics/grpc/StatThreadManager.c : Ljava/util/concurrent/ExecutorService;
    //   3: ifnonnull -> 33
    //   6: ldc java/util/concurrent/ExecutorService
    //   8: monitorenter
    //   9: getstatic com/blued/android/statistics/grpc/StatThreadManager.c : Ljava/util/concurrent/ExecutorService;
    //   12: ifnonnull -> 21
    //   15: invokestatic newSingleThreadExecutor : ()Ljava/util/concurrent/ExecutorService;
    //   18: putstatic com/blued/android/statistics/grpc/StatThreadManager.c : Ljava/util/concurrent/ExecutorService;
    //   21: ldc java/util/concurrent/ExecutorService
    //   23: monitorexit
    //   24: goto -> 33
    //   27: astore_0
    //   28: ldc java/util/concurrent/ExecutorService
    //   30: monitorexit
    //   31: aload_0
    //   32: athrow
    //   33: getstatic com/blued/android/statistics/grpc/StatThreadManager.c : Ljava/util/concurrent/ExecutorService;
    //   36: areturn
    // Exception table:
    //   from	to	target	type
    //   9	21	27	finally
    //   21	24	27	finally
    //   28	31	27	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\StatThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */