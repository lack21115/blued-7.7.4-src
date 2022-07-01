package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsUtils {
  private static final String THREADNAME_HEADER = "NetworkKit_";
  
  public static ThreadFactory createThreadFactory(final String threadName) {
    if (threadName != null && !threadName.trim().isEmpty())
      return new ThreadFactory() {
          private final AtomicInteger threadNumbers = new AtomicInteger(0);
          
          public Thread newThread(Runnable param1Runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NetworkKit_");
            stringBuilder.append(threadName);
            stringBuilder.append("_");
            stringBuilder.append(this.threadNumbers.getAndIncrement());
            return new Thread(param1Runnable, stringBuilder.toString());
          }
        }; 
    throw new NullPointerException("ThreadName is empty");
  }
  
  public static ExecutorService newCachedThreadPool(String paramString) {
    ThreadFactory threadFactory = createThreadFactory(paramString);
    return new ThreadPoolExcutorEnhance(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), threadFactory);
  }
  
  public static ExecutorService newFixedThreadPool(int paramInt, String paramString) {
    ThreadFactory threadFactory = createThreadFactory(paramString);
    return new ThreadPoolExcutorEnhance(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
  }
  
  public static ScheduledExecutorService newScheduledThreadPool(int paramInt, String paramString) {
    return new ScheduledThreadPoolExecutorEnhance(paramInt, createThreadFactory(paramString));
  }
  
  public static ExecutorService newSingleThreadExecutor(String paramString) {
    return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ExecutorsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */