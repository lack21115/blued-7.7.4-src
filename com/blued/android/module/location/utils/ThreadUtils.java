package com.blued.android.module.location.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtils {
  private static ExecutorService a = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DefaultThreadFactory());
  
  private static final Handler b = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable) {
    if (a()) {
      paramRunnable.run();
      return;
    } 
    b.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong) {
    b.postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean a() {
    return (Looper.getMainLooper() == Looper.myLooper());
  }
  
  public static void b(Runnable paramRunnable) {
    if (b()) {
      paramRunnable.run();
      return;
    } 
    a.execute(paramRunnable);
  }
  
  public static boolean b() {
    return a() ^ true;
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
      stringBuilder.append("module-");
      stringBuilder.append(a.getAndIncrement());
      stringBuilder.append("-location-");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */