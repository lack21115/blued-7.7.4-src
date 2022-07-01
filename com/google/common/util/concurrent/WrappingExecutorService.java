package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class WrappingExecutorService implements ExecutorService {
  private final ExecutorService a;
  
  private <T> ImmutableList<Callable<T>> a(Collection<? extends Callable<T>> paramCollection) {
    ImmutableList.Builder builder = ImmutableList.g();
    Iterator<? extends Callable<T>> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      builder.c(a(iterator.next())); 
    return builder.a();
  }
  
  protected Runnable a(Runnable paramRunnable) {
    return new Runnable(this, a(Executors.callable(paramRunnable, null))) {
        public void run() {
          try {
            this.a.call();
            return;
          } catch (Exception exception) {
            Throwables.a(exception);
            throw new RuntimeException(exception);
          } 
        }
      };
  }
  
  protected abstract <T> Callable<T> a(Callable<T> paramCallable);
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.a.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public final void execute(Runnable paramRunnable) {
    this.a.execute(a(paramRunnable));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection) throws InterruptedException {
    return this.a.invokeAll((Collection<? extends Callable<T>>)a(paramCollection));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.a.invokeAll((Collection<? extends Callable<T>>)a(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection) throws InterruptedException, ExecutionException {
    return this.a.invokeAny((Collection<? extends Callable<T>>)a(paramCollection));
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return this.a.invokeAny((Collection<? extends Callable<T>>)a(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final boolean isShutdown() {
    return this.a.isShutdown();
  }
  
  public final boolean isTerminated() {
    return this.a.isTerminated();
  }
  
  public final void shutdown() {
    this.a.shutdown();
  }
  
  public final List<Runnable> shutdownNow() {
    return this.a.shutdownNow();
  }
  
  public final Future<?> submit(Runnable paramRunnable) {
    return this.a.submit(a(paramRunnable));
  }
  
  public final <T> Future<T> submit(Runnable paramRunnable, T paramT) {
    return this.a.submit(a(paramRunnable), paramT);
  }
  
  public final <T> Future<T> submit(Callable<T> paramCallable) {
    return this.a.submit(a((Callable<T>)Preconditions.a(paramCallable)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\WrappingExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */