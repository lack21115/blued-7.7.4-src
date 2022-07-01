package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class ImmediateFuture<V> implements ListenableFuture<V> {
  static final ListenableFuture<?> a = new ImmediateFuture(null);
  
  private static final Logger b = Logger.getLogger(ImmediateFuture.class.getName());
  
  @NullableDecl
  private final V c;
  
  ImmediateFuture(@NullableDecl V paramV) {
    this.c = paramV;
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    Preconditions.a(paramRunnable, "Runnable was null.");
    Preconditions.a(paramExecutor, "Executor was null.");
    try {
      paramExecutor.execute(paramRunnable);
      return;
    } catch (RuntimeException runtimeException) {
      Logger logger = b;
      Level level = Level.SEVERE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RuntimeException while executing runnable ");
      stringBuilder.append(paramRunnable);
      stringBuilder.append(" with executor ");
      stringBuilder.append(paramExecutor);
      logger.log(level, stringBuilder.toString(), runtimeException);
      return;
    } 
  }
  
  public boolean cancel(boolean paramBoolean) {
    return false;
  }
  
  public V get() {
    return this.c;
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit) throws ExecutionException {
    Preconditions.a(paramTimeUnit);
    return get();
  }
  
  public boolean isCancelled() {
    return false;
  }
  
  public boolean isDone() {
    return true;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[status=SUCCESS, result=[");
    stringBuilder.append(this.c);
    stringBuilder.append("]]");
    return stringBuilder.toString();
  }
  
  static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
    ImmediateCancelledFuture() {
      cancel(false);
    }
  }
  
  static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
    ImmediateFailedFuture(Throwable param1Throwable) {
      setException(param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ImmediateFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */