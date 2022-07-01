package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {
  public boolean cancel(boolean paramBoolean) {
    return d().cancel(paramBoolean);
  }
  
  protected abstract Future<? extends V> d();
  
  public V get() throws InterruptedException, ExecutionException {
    return d().get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return d().get(paramLong, paramTimeUnit);
  }
  
  public boolean isCancelled() {
    return d().isCancelled();
  }
  
  public boolean isDone() {
    return d().isDone();
  }
  
  public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */