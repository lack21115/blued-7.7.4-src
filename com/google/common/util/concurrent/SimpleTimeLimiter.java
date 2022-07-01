package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class SimpleTimeLimiter implements TimeLimiter {
  private final ExecutorService a;
  
  private <T> T a(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean) throws Exception {
    Preconditions.a(paramCallable);
    Preconditions.a(paramTimeUnit);
    a(paramLong);
    Future<T> future = this.a.submit(paramCallable);
    if (paramBoolean)
      try {
        return future.get(paramLong, paramTimeUnit);
      } catch (InterruptedException interruptedException) {
        future.cancel(true);
        throw interruptedException;
      } catch (ExecutionException executionException) {
        throw b(executionException, true);
      } catch (TimeoutException null) {
        executionException.cancel(true);
        throw new UncheckedTimeoutException(null);
      }  
    return (T)Uninterruptibles.a((Future<TimeoutException>)executionException, paramLong, (TimeUnit)null);
  }
  
  private static void a(long paramLong) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "timeout must be positive: %s", paramLong);
  }
  
  private static Exception b(Exception paramException, boolean paramBoolean) throws Exception {
    Throwable throwable = paramException.getCause();
    if (throwable != null) {
      if (paramBoolean)
        throwable.setStackTrace((StackTraceElement[])ObjectArrays.a((Object[])throwable.getStackTrace(), (Object[])paramException.getStackTrace(), StackTraceElement.class)); 
      if (!(throwable instanceof Exception)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw paramException;
      } 
      throw (Exception)throwable;
    } 
    throw paramException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\SimpleTimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */