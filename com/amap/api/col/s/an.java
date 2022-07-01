package com.amap.api.col.s;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class an {
  private static volatile an c;
  
  private BlockingQueue<Runnable> a = new LinkedBlockingQueue<Runnable>();
  
  private ExecutorService b = null;
  
  private an() {
    int i = Runtime.getRuntime().availableProcessors();
    this.b = new ThreadPoolExecutor(i, i * 2, 1L, TimeUnit.SECONDS, this.a, new ThreadPoolExecutor.AbortPolicy());
  }
  
  public static an a() {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   3: ifnonnull -> 37
    //   6: ldc com/amap/api/col/s/an
    //   8: monitorenter
    //   9: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   12: ifnonnull -> 25
    //   15: new com/amap/api/col/s/an
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   25: ldc com/amap/api/col/s/an
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/amap/api/col/s/an
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static void b() {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   3: ifnull -> 48
    //   6: ldc com/amap/api/col/s/an
    //   8: monitorenter
    //   9: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   12: ifnull -> 38
    //   15: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   18: getfield b : Ljava/util/concurrent/ExecutorService;
    //   21: invokeinterface shutdownNow : ()Ljava/util/List;
    //   26: pop
    //   27: getstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   30: aconst_null
    //   31: putfield b : Ljava/util/concurrent/ExecutorService;
    //   34: aconst_null
    //   35: putstatic com/amap/api/col/s/an.c : Lcom/amap/api/col/s/an;
    //   38: ldc com/amap/api/col/s/an
    //   40: monitorexit
    //   41: return
    //   42: astore_0
    //   43: ldc com/amap/api/col/s/an
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: return
    // Exception table:
    //   from	to	target	type
    //   9	38	42	finally
    //   38	41	42	finally
    //   43	46	42	finally
  }
  
  public final void a(Runnable paramRunnable) {
    ExecutorService executorService = this.b;
    if (executorService != null)
      executorService.execute(paramRunnable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */