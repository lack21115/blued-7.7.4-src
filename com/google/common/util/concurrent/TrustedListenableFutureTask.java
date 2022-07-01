package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
  private volatile InterruptibleTask<?> a;
  
  TrustedListenableFutureTask(Callable<V> paramCallable) {
    this.a = new TrustedFutureInterruptibleTask(this, paramCallable);
  }
  
  static <V> TrustedListenableFutureTask<V> a(Runnable paramRunnable, @NullableDecl V paramV) {
    return new TrustedListenableFutureTask<V>(Executors.callable(paramRunnable, paramV));
  }
  
  static <V> TrustedListenableFutureTask<V> a(Callable<V> paramCallable) {
    return new TrustedListenableFutureTask<V>(paramCallable);
  }
  
  protected void afterDone() {
    super.afterDone();
    if (wasInterrupted()) {
      InterruptibleTask<?> interruptibleTask = this.a;
      if (interruptibleTask != null)
        interruptibleTask.f(); 
    } 
    this.a = null;
  }
  
  protected String pendingToString() {
    InterruptibleTask<?> interruptibleTask = this.a;
    if (interruptibleTask != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("task=[");
      stringBuilder.append(interruptibleTask);
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    return super.pendingToString();
  }
  
  public void run() {
    InterruptibleTask<?> interruptibleTask = this.a;
    if (interruptibleTask != null)
      interruptibleTask.run(); 
    this.a = null;
  }
  
  final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
    private final AsyncCallable<V> b;
    
    ListenableFuture<V> a() throws Exception {
      return (ListenableFuture<V>)Preconditions.a(this.b.a(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.b);
    }
    
    void a(ListenableFuture<V> param1ListenableFuture, Throwable param1Throwable) {
      if (param1Throwable == null) {
        this.a.setFuture(param1ListenableFuture);
        return;
      } 
      this.a.setException(param1Throwable);
    }
    
    String b() {
      return this.b.toString();
    }
    
    final boolean d() {
      return this.a.isDone();
    }
  }
  
  final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
    private final Callable<V> b;
    
    TrustedFutureInterruptibleTask(TrustedListenableFutureTask this$0, Callable<V> param1Callable) {
      this.b = (Callable<V>)Preconditions.a(param1Callable);
    }
    
    void a(V param1V, Throwable param1Throwable) {
      if (param1Throwable == null) {
        this.a.set(param1V);
        return;
      } 
      this.a.setException(param1Throwable);
    }
    
    String b() {
      return this.b.toString();
    }
    
    V c() throws Exception {
      return this.b.call();
    }
    
    final boolean d() {
      return this.a.isDone();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\TrustedListenableFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */