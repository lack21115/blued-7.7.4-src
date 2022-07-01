package com.google.common.util.concurrent;

import com.google.common.base.Stopwatch;
import java.util.Locale;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class RateLimiter {
  @NullableDecl
  private volatile Object a;
  
  private Object c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull -> 44
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield a : Ljava/lang/Object;
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_2
    //   19: ifnonnull -> 35
    //   22: new java/lang/Object
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore_1
    //   30: aload_0
    //   31: aload_1
    //   32: putfield a : Ljava/lang/Object;
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: aload_1
    //   45: areturn
    // Exception table:
    //   from	to	target	type
    //   11	16	39	finally
    //   22	35	39	finally
    //   35	37	39	finally
    //   40	42	39	finally
  }
  
  public final double a() {
    synchronized (c()) {
      return b();
    } 
  }
  
  abstract double b();
  
  public String toString() {
    return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[] { Double.valueOf(a()) });
  }
  
  static abstract class SleepingStopwatch {}
  
  static final class null extends SleepingStopwatch {
    final Stopwatch a = Stopwatch.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\RateLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */