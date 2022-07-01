package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
  private final ExecutionList a = new ExecutionList();
  
  ListenableFutureTask(Callable<V> paramCallable) {
    super(paramCallable);
  }
  
  public static <V> ListenableFutureTask<V> a(Callable<V> paramCallable) {
    return new ListenableFutureTask<V>(paramCallable);
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    this.a.a(paramRunnable, paramExecutor);
  }
  
  protected void done() {
    this.a.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ListenableFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */