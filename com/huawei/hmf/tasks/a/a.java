package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {
  static final int a;
  
  static final int b;
  
  private static final a c = new a();
  
  private static final int e;
  
  private final Executor d = new a((byte)0);
  
  static {
    int i = Runtime.getRuntime().availableProcessors();
    e = i;
    a = i + 1;
    b = e * 2 + 1;
  }
  
  public static ExecutorService a() {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    threadPoolExecutor.allowCoreThreadTimeOut(true);
    return threadPoolExecutor;
  }
  
  public static Executor b() {
    return c.d;
  }
  
  static final class a implements Executor {
    private a() {}
    
    public final void execute(Runnable param1Runnable) {
      (new Handler(Looper.getMainLooper())).post(param1Runnable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */