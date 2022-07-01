package com.bytedance.sdk.openadsdk.i;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class e {
  private static final int a = Runtime.getRuntime().availableProcessors();
  
  private static final int b;
  
  private static final int c;
  
  private static final int d;
  
  private static final PriorityBlockingQueue<Runnable> e = new PriorityBlockingQueue<Runnable>();
  
  private static final PriorityBlockingQueue<Runnable> f = new PriorityBlockingQueue<Runnable>();
  
  private static final PriorityBlockingQueue<Runnable> g = new PriorityBlockingQueue<Runnable>();
  
  private static final ArrayBlockingQueue<Runnable> h = new ArrayBlockingQueue<Runnable>(4);
  
  public static ThreadPoolExecutor a() {
    return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, e, new d(5, "tt-api-thread-"), f());
  }
  
  public static ThreadPoolExecutor b() {
    return new ThreadPoolExecutor(2, c, 5L, TimeUnit.SECONDS, f, new d(5, "tt-background-thread-"), f());
  }
  
  public static ScheduledExecutorService c() {
    return Executors.newSingleThreadScheduledExecutor(new d(1, "tt-delay-thread-"));
  }
  
  public static ThreadPoolExecutor d() {
    return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, g, new d(5, "tt-aidl-thread-"), f());
  }
  
  public static ThreadPoolExecutor e() {
    return new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, h, new d(5, "tt-file-log-upload-thread-"), f());
  }
  
  public static RejectedExecutionHandler f() {
    return new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {}
      };
  }
  
  static {
    int i = a;
    if (i / 2 + 1 < 4) {
      i = 4;
    } else {
      i = i / 2 + 1;
    } 
    b = i;
    i = a;
    if (i / 2 + 1 < 4) {
      i = 4;
    } else {
      i = i / 2 + 1;
    } 
    c = i;
    i = a;
    if (i / 2 + 1 > 4) {
      i = 4;
    } else {
      i = i / 2 + 1;
    } 
    d = i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */