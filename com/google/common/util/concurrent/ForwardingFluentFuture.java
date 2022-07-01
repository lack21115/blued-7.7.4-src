package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class ForwardingFluentFuture<V> extends FluentFuture<V> {
  private final ListenableFuture<V> a;
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    this.a.addListener(paramRunnable, paramExecutor);
  }
  
  public boolean cancel(boolean paramBoolean) {
    return this.a.cancel(paramBoolean);
  }
  
  public V get() throws InterruptedException, ExecutionException {
    return this.a.get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return this.a.get(paramLong, paramTimeUnit);
  }
  
  public boolean isCancelled() {
    return this.a.isCancelled();
  }
  
  public boolean isDone() {
    return this.a.isDone();
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingFluentFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */