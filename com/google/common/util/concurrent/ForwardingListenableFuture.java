package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
  protected abstract ListenableFuture<? extends V> a();
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    a().addListener(paramRunnable, paramExecutor);
  }
  
  public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
    private final ListenableFuture<V> a;
    
    protected SimpleForwardingListenableFuture(ListenableFuture<V> param1ListenableFuture) {
      this.a = (ListenableFuture<V>)Preconditions.a(param1ListenableFuture);
    }
    
    protected final ListenableFuture<V> a() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingListenableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */