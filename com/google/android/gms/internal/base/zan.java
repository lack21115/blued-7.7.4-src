package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zan implements zam {
  private zan() {}
  
  public final ExecutorService zaa(int paramInt1, int paramInt2) {
    return zaa(4, Executors.defaultThreadFactory(), paramInt2);
  }
  
  public final ExecutorService zaa(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2) {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(paramInt1, paramInt1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), paramThreadFactory);
    threadPoolExecutor.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(threadPoolExecutor);
  }
  
  public final ExecutorService zaa(ThreadFactory paramThreadFactory, int paramInt) {
    return zaa(1, paramThreadFactory, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\base\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */