package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsEnhance {
  public static ExecutorService newSingleThreadExecutor(ThreadFactory paramThreadFactory) {
    return new FinalizableDelegatedExecutorService(new ThreadPoolExcutorEnhance(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), paramThreadFactory));
  }
  
  static class DelegatedExecutorService extends AbstractExecutorService {
    private final ExecutorService e;
    
    DelegatedExecutorService(ExecutorService param1ExecutorService) {
      this.e = param1ExecutorService;
    }
    
    public boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) {
      return this.e.awaitTermination(param1Long, param1TimeUnit);
    }
    
    public void execute(Runnable param1Runnable) {
      this.e.execute(param1Runnable);
    }
    
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> param1Collection) {
      return this.e.invokeAll(param1Collection);
    }
    
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> param1Collection, long param1Long, TimeUnit param1TimeUnit) {
      return this.e.invokeAll(param1Collection, param1Long, param1TimeUnit);
    }
    
    public <T> T invokeAny(Collection<? extends Callable<T>> param1Collection) {
      return this.e.invokeAny(param1Collection);
    }
    
    public <T> T invokeAny(Collection<? extends Callable<T>> param1Collection, long param1Long, TimeUnit param1TimeUnit) {
      return this.e.invokeAny(param1Collection, param1Long, param1TimeUnit);
    }
    
    public boolean isShutdown() {
      return this.e.isShutdown();
    }
    
    public boolean isTerminated() {
      return this.e.isTerminated();
    }
    
    public void shutdown() {
      this.e.shutdown();
    }
    
    public List<Runnable> shutdownNow() {
      return this.e.shutdownNow();
    }
    
    public Future<?> submit(Runnable param1Runnable) {
      return this.e.submit(param1Runnable);
    }
    
    public <T> Future<T> submit(Runnable param1Runnable, T param1T) {
      return this.e.submit(param1Runnable, param1T);
    }
    
    public <T> Future<T> submit(Callable<T> param1Callable) {
      return this.e.submit(param1Callable);
    }
  }
  
  static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
    FinalizableDelegatedExecutorService(ExecutorService param1ExecutorService) {
      super(param1ExecutorService);
    }
    
    protected void finalize() {
      shutdown();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ExecutorsEnhance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */