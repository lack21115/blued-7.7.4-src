package com.qq.e.comm.plugin.j.b;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class n<T> implements Future<T> {
  final Callable<T> a;
  
  n(Callable<T> paramCallable) {
    this.a = paramCallable;
  }
  
  public boolean cancel(boolean paramBoolean) {
    return false;
  }
  
  public T get() throws ExecutionException {
    try {
      return this.a.call();
    } catch (Exception exception) {
      throw new ExecutionException(exception);
    } 
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit) throws ExecutionException {
    return get();
  }
  
  public boolean isCancelled() {
    return false;
  }
  
  public boolean isDone() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */