package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public final class JdkFutureAdapters {
  static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    private static final ThreadFactory a = (new ThreadFactoryBuilder()).a(true).a("ListenableFutureAdapter-thread-%d").a();
    
    private static final Executor b = Executors.newCachedThreadPool(a);
    
    private final Executor c;
    
    private final ExecutionList d;
    
    private final AtomicBoolean e;
    
    private final Future<V> f;
    
    public void addListener(Runnable param1Runnable, Executor param1Executor) {
      this.d.a(param1Runnable, param1Executor);
      if (this.e.compareAndSet(false, true)) {
        if (this.f.isDone()) {
          this.d.a();
          return;
        } 
        this.c.execute(new Runnable(this) {
              public void run() {
                try {
                  Uninterruptibles.a(JdkFutureAdapters.ListenableFutureAdapter.a(this.a));
                } finally {
                  Exception exception;
                } 
                JdkFutureAdapters.ListenableFutureAdapter.b(this.a).a();
              }
            });
      } 
    }
    
    protected Future<V> d() {
      return this.f;
    }
  }
  
  class null implements Runnable {
    null(JdkFutureAdapters this$0) {}
    
    public void run() {
      try {
        Uninterruptibles.a(JdkFutureAdapters.ListenableFutureAdapter.a(this.a));
      } finally {
        Exception exception;
      } 
      JdkFutureAdapters.ListenableFutureAdapter.b(this.a).a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\JdkFutureAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */