package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {
  static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
    public final void addListener(Runnable param1Runnable, Executor param1Executor) {
      super.addListener(param1Runnable, param1Executor);
    }
    
    public final boolean cancel(boolean param1Boolean) {
      return super.cancel(param1Boolean);
    }
    
    public final V get() throws InterruptedException, ExecutionException {
      return super.get();
    }
    
    public final V get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
      return super.get(param1Long, param1TimeUnit);
    }
    
    public final boolean isCancelled() {
      return super.isCancelled();
    }
    
    public final boolean isDone() {
      return super.isDone();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\FluentFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */