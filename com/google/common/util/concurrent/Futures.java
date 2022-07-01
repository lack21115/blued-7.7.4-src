package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Futures extends GwtFuturesCatchingSpecialization {
  public static <V> ListenableFuture<V> a() {
    return new ImmediateFuture.ImmediateCancelledFuture<V>();
  }
  
  public static <I, O> ListenableFuture<O> a(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor) {
    return AbstractTransformFuture.a(paramListenableFuture, paramFunction, paramExecutor);
  }
  
  public static <V> ListenableFuture<V> a(@NullableDecl V paramV) {
    return (paramV == null) ? ImmediateFuture.a : new ImmediateFuture<V>(paramV);
  }
  
  public static <V> ListenableFuture<V> a(Throwable paramThrowable) {
    Preconditions.a(paramThrowable);
    return new ImmediateFuture.ImmediateFailedFuture<V>(paramThrowable);
  }
  
  public static <V> V a(Future<V> paramFuture) throws ExecutionException {
    Preconditions.b(paramFuture.isDone(), "Future was expected to be done: %s", paramFuture);
    return Uninterruptibles.a(paramFuture);
  }
  
  static final class CallbackListener<V> implements Runnable {
    final Future<V> a;
    
    final FutureCallback<? super V> b;
    
    public void run() {
      Future<V> future = this.a;
      if (future instanceof InternalFutureFailureAccess) {
        Throwable throwable = InternalFutures.a((InternalFutureFailureAccess)future);
        if (throwable != null) {
          this.b.a(throwable);
          return;
        } 
      } 
      try {
        future = Futures.a((Future)this.a);
        this.b.a((V)future);
        return;
      } catch (ExecutionException executionException) {
        this.b.a(executionException.getCause());
        return;
      } catch (RuntimeException runtimeException) {
        this.b.a(runtimeException);
        return;
      } catch (Error error) {
        this.b.a(error);
        return;
      } 
    }
    
    public String toString() {
      return MoreObjects.a(this).a(this.b).toString();
    }
  }
  
  public static final class FutureCombiner<V> {}
  
  class null implements Callable<Void> {
    public Void a() throws Exception {
      this.a.run();
      return null;
    }
  }
  
  static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
    private Futures.InCompletionOrderState<T> a;
    
    protected void afterDone() {
      this.a = null;
    }
    
    public boolean cancel(boolean param1Boolean) {
      Futures.InCompletionOrderState<T> inCompletionOrderState = this.a;
      if (super.cancel(param1Boolean)) {
        Futures.InCompletionOrderState.a(inCompletionOrderState, param1Boolean);
        return true;
      } 
      return false;
    }
    
    protected String pendingToString() {
      Futures.InCompletionOrderState<T> inCompletionOrderState = this.a;
      if (inCompletionOrderState != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inputCount=[");
        stringBuilder.append((Futures.InCompletionOrderState.a(inCompletionOrderState)).length);
        stringBuilder.append("], remaining=[");
        stringBuilder.append(Futures.InCompletionOrderState.b(inCompletionOrderState).get());
        stringBuilder.append("]");
        return stringBuilder.toString();
      } 
      return null;
    }
  }
  
  static final class InCompletionOrderState<T> {
    private boolean a;
    
    private boolean b;
    
    private final AtomicInteger c;
    
    private final ListenableFuture<? extends T>[] d;
    
    private volatile int e;
    
    private void a() {
      if (this.c.decrementAndGet() == 0 && this.a)
        for (ListenableFuture<? extends T> listenableFuture : this.d) {
          if (listenableFuture != null)
            listenableFuture.cancel(this.b); 
        }  
    }
    
    private void a(ImmutableList<AbstractFuture<T>> param1ImmutableList, int param1Int) {
      ListenableFuture<? extends T>[] arrayOfListenableFuture = this.d;
      ListenableFuture<? extends T> listenableFuture = arrayOfListenableFuture[param1Int];
      arrayOfListenableFuture[param1Int] = null;
      for (param1Int = this.e; param1Int < param1ImmutableList.size(); param1Int++) {
        if (((AbstractFuture<T>)param1ImmutableList.get(param1Int)).setFuture(listenableFuture)) {
          a();
          this.e = param1Int + 1;
          return;
        } 
      } 
      this.e = param1ImmutableList.size();
    }
    
    private void a(boolean param1Boolean) {
      this.a = true;
      if (!param1Boolean)
        this.b = false; 
      a();
    }
  }
  
  static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
    private ListenableFuture<V> a;
    
    protected void afterDone() {
      this.a = null;
    }
    
    protected String pendingToString() {
      ListenableFuture<V> listenableFuture = this.a;
      if (listenableFuture != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delegate=[");
        stringBuilder.append(listenableFuture);
        stringBuilder.append("]");
        return stringBuilder.toString();
      } 
      return null;
    }
    
    public void run() {
      ListenableFuture<V> listenableFuture = this.a;
      if (listenableFuture != null)
        setFuture(listenableFuture); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Futures.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */