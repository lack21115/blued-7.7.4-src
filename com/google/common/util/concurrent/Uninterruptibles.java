package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Uninterruptibles {
  public static <V> V a(Future<V> paramFuture) throws ExecutionException {
    boolean bool = false;
    while (true) {
      try {
        return paramFuture.get();
      } catch (InterruptedException interruptedException) {
      
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  public static <V> V a(Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit) throws ExecutionException, TimeoutException {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try {
      long l1 = paramTimeUnit.toNanos(paramLong);
      bool1 = bool3;
      long l2 = System.nanoTime();
      paramLong = l1;
      while (true) {
        bool1 = bool2;
        try {
          paramTimeUnit = (TimeUnit)paramFuture.get(paramLong, TimeUnit.NANOSECONDS);
          return (V)paramTimeUnit;
        } catch (InterruptedException interruptedException) {
          bool1 = true;
          bool2 = true;
          paramLong = System.nanoTime();
          paramLong = l2 + l1 - paramLong;
        } 
      } 
    } finally {
      if (bool1)
        Thread.currentThread().interrupt(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Uninterruptibles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */