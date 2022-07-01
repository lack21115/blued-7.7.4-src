package com.google.common.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
  public ListenableFuture<?> a(Runnable paramRunnable) {
    return (ListenableFuture)super.submit(paramRunnable);
  }
  
  public <T> ListenableFuture<T> a(Runnable paramRunnable, @NullableDecl T paramT) {
    return (ListenableFuture<T>)super.<T>submit(paramRunnable, paramT);
  }
  
  public <T> ListenableFuture<T> a(Callable<T> paramCallable) {
    return (ListenableFuture<T>)super.<T>submit(paramCallable);
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT) {
    return TrustedListenableFutureTask.a(paramRunnable, paramT);
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable) {
    return TrustedListenableFutureTask.a(paramCallable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractListeningExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */