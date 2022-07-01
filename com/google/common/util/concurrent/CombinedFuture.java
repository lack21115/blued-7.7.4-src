package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class CombinedFuture<V> extends AggregateFuture<Object, V> {
  private CombinedFutureInterruptibleTask<?> a;
  
  void a() {
    CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.a;
    if (combinedFutureInterruptibleTask != null)
      combinedFutureInterruptibleTask.e(); 
  }
  
  void a(int paramInt, @NullableDecl Object paramObject) {}
  
  void a(AggregateFuture.ReleaseResourcesReason paramReleaseResourcesReason) {
    super.a(paramReleaseResourcesReason);
    if (paramReleaseResourcesReason == AggregateFuture.ReleaseResourcesReason.a)
      this.a = null; 
  }
  
  protected void interruptTask() {
    CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.a;
    if (combinedFutureInterruptibleTask != null)
      combinedFutureInterruptibleTask.f(); 
  }
  
  final class AsyncCallableInterruptibleTask extends CombinedFutureInterruptibleTask<ListenableFuture<V>> {
    private final AsyncCallable<V> d;
    
    ListenableFuture<V> a() throws Exception {
      this.b = false;
      return (ListenableFuture<V>)Preconditions.a(this.d.a(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.d);
    }
    
    void a(ListenableFuture<V> param1ListenableFuture) {
      this.a.setFuture(param1ListenableFuture);
    }
    
    String b() {
      return this.d.toString();
    }
  }
  
  final class CallableInterruptibleTask extends CombinedFutureInterruptibleTask<V> {
    private final Callable<V> d;
    
    void a(V param1V) {
      this.a.set(param1V);
    }
    
    String b() {
      return this.d.toString();
    }
    
    V c() throws Exception {
      this.b = false;
      return this.d.call();
    }
  }
  
  abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
    private final Executor a;
    
    boolean b;
    
    abstract void a(T param1T);
    
    final void a(T param1T, Throwable param1Throwable) {
      CombinedFuture.a(this.c, (CombinedFutureInterruptibleTask)null);
      if (param1Throwable != null) {
        if (param1Throwable instanceof java.util.concurrent.ExecutionException) {
          this.c.setException(param1Throwable.getCause());
          return;
        } 
        if (param1Throwable instanceof java.util.concurrent.CancellationException) {
          this.c.cancel(false);
          return;
        } 
        this.c.setException(param1Throwable);
        return;
      } 
      a(param1T);
    }
    
    final boolean d() {
      return this.c.isDone();
    }
    
    final void e() {
      try {
        this.a.execute(this);
        return;
      } catch (RejectedExecutionException rejectedExecutionException) {
        if (this.b)
          this.c.setException(rejectedExecutionException); 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\CombinedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */