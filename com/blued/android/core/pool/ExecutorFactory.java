package com.blued.android.core.pool;

import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.deque.LinkedBlockingDeque;
import com.blued.android.core.utils.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorFactory {
  private static final String a = ExecutorFactory.class.getSimpleName();
  
  private static ExecutorFactory b;
  
  private static final Long c = Long.valueOf(10L);
  
  private ThreadPoolExecutor d = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, (BlockingQueue<Runnable>)new LinkedBlockingDeque(), new DefaultThreadFactory("data"), new ThreadPoolExecutor.DiscardOldestPolicy(this) {
        public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
          super.rejectedExecution(param1Runnable, param1ThreadPoolExecutor);
          String str = ExecutorFactory.e();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("DataExecutor rejectedExecution(), e:");
          stringBuilder.append(param1ThreadPoolExecutor);
          Log.e(str, stringBuilder.toString());
        }
      });
  
  private ThreadPoolExecutor e = new ThreadPoolExecutor(RecyclingUtils.c(), RecyclingUtils.c(), 0L, TimeUnit.SECONDS, (BlockingQueue<Runnable>)new LinkedBlockingDeque(), new DefaultThreadFactory("Http"), new ThreadPoolExecutor.DiscardOldestPolicy(this) {
        public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
          super.rejectedExecution(param1Runnable, param1ThreadPoolExecutor);
          String str = ExecutorFactory.e();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("HttpExecutor rejectedExecution(), e:");
          stringBuilder.append(param1ThreadPoolExecutor);
          Log.e(str, stringBuilder.toString());
        }
      });
  
  private ThreadPoolExecutor f = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, (BlockingQueue<Runnable>)new LinkedBlockingDeque(), new DefaultThreadFactory("preLoader"), new ThreadPoolExecutor.DiscardOldestPolicy(this) {
        public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
          super.rejectedExecution(param1Runnable, param1ThreadPoolExecutor);
          String str = ExecutorFactory.e();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ImageLoader.prePareExecutor rejectedExecution(), e:");
          stringBuilder.append(param1ThreadPoolExecutor);
          Log.e(str, stringBuilder.toString());
        }
      });
  
  public static ExecutorFactory a() {
    // Byte code:
    //   0: getstatic com/blued/android/core/pool/ExecutorFactory.b : Lcom/blued/android/core/pool/ExecutorFactory;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/core/pool/ExecutorFactory
    //   8: monitorenter
    //   9: getstatic com/blued/android/core/pool/ExecutorFactory.b : Lcom/blued/android/core/pool/ExecutorFactory;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/core/pool/ExecutorFactory
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/core/pool/ExecutorFactory.b : Lcom/blued/android/core/pool/ExecutorFactory;
    //   25: ldc com/blued/android/core/pool/ExecutorFactory
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/core/pool/ExecutorFactory
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/core/pool/ExecutorFactory.b : Lcom/blued/android/core/pool/ExecutorFactory;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public ThreadPoolExecutor b() {
    return this.d;
  }
  
  public ThreadPoolExecutor c() {
    return this.e;
  }
  
  public ThreadPoolExecutor d() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\pool\ExecutorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */