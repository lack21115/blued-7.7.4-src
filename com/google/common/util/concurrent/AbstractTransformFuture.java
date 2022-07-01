package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
  @NullableDecl
  ListenableFuture<? extends I> a;
  
  @NullableDecl
  F b;
  
  AbstractTransformFuture(ListenableFuture<? extends I> paramListenableFuture, F paramF) {
    this.a = (ListenableFuture<? extends I>)Preconditions.a(paramListenableFuture);
    this.b = (F)Preconditions.a(paramF);
  }
  
  static <I, O> ListenableFuture<O> a(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor) {
    Preconditions.a(paramFunction);
    TransformFuture<I, O> transformFuture = new TransformFuture<I, O>(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(transformFuture, MoreExecutors.a(paramExecutor, transformFuture));
    return transformFuture;
  }
  
  @NullableDecl
  abstract T a(F paramF, @NullableDecl I paramI) throws Exception;
  
  abstract void a(@NullableDecl T paramT);
  
  protected final void afterDone() {
    maybePropagateCancellationTo(this.a);
    this.a = null;
    this.b = null;
  }
  
  protected String pendingToString() {
    String str1;
    StringBuilder stringBuilder;
    ListenableFuture<? extends I> listenableFuture = this.a;
    F f = this.b;
    String str2 = super.pendingToString();
    if (listenableFuture != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("inputFuture=[");
      stringBuilder1.append(listenableFuture);
      stringBuilder1.append("], ");
      str1 = stringBuilder1.toString();
    } else {
      str1 = "";
    } 
    if (f != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("function=[");
      stringBuilder.append(f);
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    if (stringBuilder != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append((String)stringBuilder);
      return stringBuilder1.toString();
    } 
    return null;
  }
  
  public final void run() {
    boolean bool1;
    ListenableFuture<? extends I> listenableFuture = this.a;
    F f = this.b;
    boolean bool3 = isCancelled();
    boolean bool2 = true;
    if (listenableFuture == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (f != null)
      bool2 = false; 
    if (bool3 | bool1 | bool2)
      return; 
    this.a = null;
    if (listenableFuture.isCancelled()) {
      setFuture(listenableFuture);
      return;
    } 
    try {
      listenableFuture = Futures.a((Future)listenableFuture);
      try {
        f = (F)a(f, (I)listenableFuture);
        this.b = null;
        return;
      } finally {
        f = null;
      } 
    } catch (CancellationException cancellationException) {
      cancel(false);
      return;
    } catch (ExecutionException executionException) {
      setException(executionException.getCause());
      return;
    } catch (RuntimeException runtimeException) {
      setException(runtimeException);
      return;
    } catch (Error error) {
      setException(error);
      return;
    } 
  }
  
  static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
    ListenableFuture<? extends O> a(AsyncFunction<? super I, ? extends O> param1AsyncFunction, @NullableDecl I param1I) throws Exception {
      ListenableFuture<? extends O> listenableFuture = param1AsyncFunction.a(param1I);
      Preconditions.a(listenableFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", param1AsyncFunction);
      return listenableFuture;
    }
    
    void a(ListenableFuture<? extends O> param1ListenableFuture) {
      setFuture(param1ListenableFuture);
    }
  }
  
  static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
    TransformFuture(ListenableFuture<? extends I> param1ListenableFuture, Function<? super I, ? extends O> param1Function) {
      super(param1ListenableFuture, param1Function);
    }
    
    @NullableDecl
    O a(Function<? super I, ? extends O> param1Function, @NullableDecl I param1I) {
      return (O)param1Function.f(param1I);
    }
    
    void a(@NullableDecl O param1O) {
      set(param1O);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractTransformFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */