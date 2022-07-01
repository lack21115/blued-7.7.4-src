package com.blued.android.core.image.util;

import com.blued.android.core.pool.DefaultThreadFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorUtils {
  private static ConcurrentHashMap<Integer, Future> a = new ConcurrentHashMap<Integer, Future>();
  
  private static ThreadPoolExecutor b = new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), (ThreadFactory)new DefaultThreadFactory("image-http"), new ThreadPoolExecutor.DiscardOldestPolicy());
  
  private static ConcurrentHashMap<Integer, Future> c = new ConcurrentHashMap<Integer, Future>();
  
  private static ThreadPoolExecutor d = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), (ThreadFactory)new DefaultThreadFactory("image-local"), new ThreadPoolExecutor.DiscardOldestPolicy());
  
  public static void a(int paramInt) {
    a(a, paramInt);
    a(c, paramInt);
  }
  
  public static void a(int paramInt, Runnable paramRunnable) {
    if (paramRunnable != null)
      a.put(Integer.valueOf(paramInt), b.submit(paramRunnable)); 
  }
  
  private static void a(ConcurrentHashMap<Integer, Future> paramConcurrentHashMap, int paramInt) {
    Future future = paramConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (future != null)
      future.cancel(false); 
    paramConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public static void b(int paramInt, Runnable paramRunnable) {
    if (paramRunnable != null)
      c.put(Integer.valueOf(paramInt), d.submit(paramRunnable)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imag\\util\ExecutorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */