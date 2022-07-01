package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder {
  private String a = null;
  
  private Boolean b = null;
  
  private Integer c = null;
  
  private Thread.UncaughtExceptionHandler d = null;
  
  private ThreadFactory e = null;
  
  private static ThreadFactory a(ThreadFactoryBuilder paramThreadFactoryBuilder) {
    AtomicLong atomicLong;
    String str = paramThreadFactoryBuilder.a;
    Boolean bool = paramThreadFactoryBuilder.b;
    Integer integer = paramThreadFactoryBuilder.c;
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = paramThreadFactoryBuilder.d;
    ThreadFactory threadFactory = paramThreadFactoryBuilder.e;
    if (threadFactory == null)
      threadFactory = Executors.defaultThreadFactory(); 
    if (str != null) {
      atomicLong = new AtomicLong(0L);
    } else {
      atomicLong = null;
    } 
    return new ThreadFactory(threadFactory, str, atomicLong, bool, integer, uncaughtExceptionHandler) {
        public Thread newThread(Runnable param1Runnable) {
          param1Runnable = this.a.newThread(param1Runnable);
          String str = this.b;
          if (str != null)
            param1Runnable.setName(ThreadFactoryBuilder.a(str, new Object[] { Long.valueOf(this.c.getAndIncrement()) })); 
          Boolean bool = this.d;
          if (bool != null)
            param1Runnable.setDaemon(bool.booleanValue()); 
          Integer integer = this.e;
          if (integer != null)
            param1Runnable.setPriority(integer.intValue()); 
          Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f;
          if (uncaughtExceptionHandler != null)
            param1Runnable.setUncaughtExceptionHandler(uncaughtExceptionHandler); 
          return (Thread)param1Runnable;
        }
      };
  }
  
  private static String b(String paramString, Object... paramVarArgs) {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public ThreadFactoryBuilder a(String paramString) {
    b(paramString, new Object[] { Integer.valueOf(0) });
    this.a = paramString;
    return this;
  }
  
  public ThreadFactoryBuilder a(boolean paramBoolean) {
    this.b = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  @CheckReturnValue
  public ThreadFactory a() {
    return a(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ThreadFactoryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */