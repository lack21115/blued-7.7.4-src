package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractScheduledService implements Service {
  private static final Logger a = Logger.getLogger(AbstractScheduledService.class.getName());
  
  private final AbstractService b = new ServiceDelegate();
  
  protected abstract void a() throws Exception;
  
  protected void b() throws Exception {}
  
  protected void c() throws Exception {}
  
  protected abstract Scheduler d();
  
  public final Service.State e() {
    return this.b.e();
  }
  
  protected String f() {
    return getClass().getSimpleName();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(f());
    stringBuilder.append(" [");
    stringBuilder.append(e());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static abstract class CustomScheduler extends Scheduler {
    protected abstract Schedule a() throws Exception;
    
    class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
      private final Runnable b;
      
      private final ScheduledExecutorService c;
      
      private final AbstractService d;
      
      private final ReentrantLock e;
      
      @NullableDecl
      private Future<Void> f;
      
      public Void a() throws Exception {
        this.b.run();
        c();
        return null;
      }
      
      public void c() {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler;
        //   4: invokevirtual a : ()Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;
        //   7: astore_3
        //   8: aconst_null
        //   9: astore_2
        //   10: aload_0
        //   11: getfield e : Ljava/util/concurrent/locks/ReentrantLock;
        //   14: invokevirtual lock : ()V
        //   17: aload_0
        //   18: getfield f : Ljava/util/concurrent/Future;
        //   21: ifnull -> 38
        //   24: aload_2
        //   25: astore_1
        //   26: aload_0
        //   27: getfield f : Ljava/util/concurrent/Future;
        //   30: invokeinterface isCancelled : ()Z
        //   35: ifne -> 66
        //   38: aload_0
        //   39: aload_0
        //   40: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
        //   43: aload_0
        //   44: aload_3
        //   45: invokestatic a : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)J
        //   48: aload_3
        //   49: invokestatic b : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)Ljava/util/concurrent/TimeUnit;
        //   52: invokeinterface schedule : (Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
        //   57: putfield f : Ljava/util/concurrent/Future;
        //   60: aload_2
        //   61: astore_1
        //   62: goto -> 66
        //   65: astore_1
        //   66: aload_0
        //   67: getfield e : Ljava/util/concurrent/locks/ReentrantLock;
        //   70: invokevirtual unlock : ()V
        //   73: aload_1
        //   74: ifnull -> 85
        //   77: aload_0
        //   78: getfield d : Lcom/google/common/util/concurrent/AbstractService;
        //   81: aload_1
        //   82: invokevirtual a : (Ljava/lang/Throwable;)V
        //   85: return
        //   86: astore_1
        //   87: aload_0
        //   88: getfield d : Lcom/google/common/util/concurrent/AbstractService;
        //   91: aload_1
        //   92: invokevirtual a : (Ljava/lang/Throwable;)V
        //   95: return
        // Exception table:
        //   from	to	target	type
        //   0	8	86	finally
        //   17	24	65	finally
        //   26	38	65	finally
        //   38	60	65	finally
      }
      
      public boolean cancel(boolean param2Boolean) {
        this.e.lock();
        try {
          param2Boolean = this.f.cancel(param2Boolean);
          return param2Boolean;
        } finally {
          this.e.unlock();
        } 
      }
      
      protected Future<Void> d() {
        throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
      }
      
      public boolean isCancelled() {
        this.e.lock();
        try {
          return this.f.isCancelled();
        } finally {
          this.e.unlock();
        } 
      }
    }
    
    public static final class Schedule {
      private final long a;
      
      private final TimeUnit b;
    }
  }
  
  class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
    private final Runnable b;
    
    private final ScheduledExecutorService c;
    
    private final AbstractService d;
    
    private final ReentrantLock e;
    
    @NullableDecl
    private Future<Void> f;
    
    public Void a() throws Exception {
      this.b.run();
      c();
      return null;
    }
    
    public void c() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler;
      //   4: invokevirtual a : ()Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;
      //   7: astore_3
      //   8: aconst_null
      //   9: astore_2
      //   10: aload_0
      //   11: getfield e : Ljava/util/concurrent/locks/ReentrantLock;
      //   14: invokevirtual lock : ()V
      //   17: aload_0
      //   18: getfield f : Ljava/util/concurrent/Future;
      //   21: ifnull -> 38
      //   24: aload_2
      //   25: astore_1
      //   26: aload_0
      //   27: getfield f : Ljava/util/concurrent/Future;
      //   30: invokeinterface isCancelled : ()Z
      //   35: ifne -> 66
      //   38: aload_0
      //   39: aload_0
      //   40: getfield c : Ljava/util/concurrent/ScheduledExecutorService;
      //   43: aload_0
      //   44: aload_3
      //   45: invokestatic a : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)J
      //   48: aload_3
      //   49: invokestatic b : (Lcom/google/common/util/concurrent/AbstractScheduledService$CustomScheduler$Schedule;)Ljava/util/concurrent/TimeUnit;
      //   52: invokeinterface schedule : (Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      //   57: putfield f : Ljava/util/concurrent/Future;
      //   60: aload_2
      //   61: astore_1
      //   62: goto -> 66
      //   65: astore_1
      //   66: aload_0
      //   67: getfield e : Ljava/util/concurrent/locks/ReentrantLock;
      //   70: invokevirtual unlock : ()V
      //   73: aload_1
      //   74: ifnull -> 85
      //   77: aload_0
      //   78: getfield d : Lcom/google/common/util/concurrent/AbstractService;
      //   81: aload_1
      //   82: invokevirtual a : (Ljava/lang/Throwable;)V
      //   85: return
      //   86: astore_1
      //   87: aload_0
      //   88: getfield d : Lcom/google/common/util/concurrent/AbstractService;
      //   91: aload_1
      //   92: invokevirtual a : (Ljava/lang/Throwable;)V
      //   95: return
      // Exception table:
      //   from	to	target	type
      //   0	8	86	finally
      //   17	24	65	finally
      //   26	38	65	finally
      //   38	60	65	finally
    }
    
    public boolean cancel(boolean param1Boolean) {
      this.e.lock();
      try {
        param1Boolean = this.f.cancel(param1Boolean);
        return param1Boolean;
      } finally {
        this.e.unlock();
      } 
    }
    
    protected Future<Void> d() {
      throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
    }
    
    public boolean isCancelled() {
      this.e.lock();
      try {
        return this.f.isCancelled();
      } finally {
        this.e.unlock();
      } 
    }
  }
  
  public static final class Schedule {
    private final long a;
    
    private final TimeUnit b;
  }
  
  public static abstract class Scheduler {
    private Scheduler() {}
    
    abstract Future<?> a(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable);
  }
  
  static final class null extends Scheduler {
    public Future<?> a(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable) {
      return param1ScheduledExecutorService.scheduleWithFixedDelay(param1Runnable, this.a, this.b, this.c);
    }
  }
  
  static final class null extends Scheduler {
    public Future<?> a(AbstractService param1AbstractService, ScheduledExecutorService param1ScheduledExecutorService, Runnable param1Runnable) {
      return param1ScheduledExecutorService.scheduleAtFixedRate(param1Runnable, this.a, this.b, this.c);
    }
  }
  
  final class ServiceDelegate extends AbstractService {
    @NullableDecl
    private volatile Future<?> b;
    
    @NullableDecl
    private volatile ScheduledExecutorService c;
    
    private final ReentrantLock d = new ReentrantLock();
    
    private final Runnable e = new Task(this);
    
    private ServiceDelegate(AbstractScheduledService this$0) {}
    
    protected final void a() {
      this.b.cancel(false);
      this.c.execute(new Runnable(this) {
            public void run() {
              try {
              
              } finally {
                Exception exception = null;
                this.a.a(exception);
              } 
            }
          });
    }
    
    public String toString() {
      return this.a.toString();
    }
    
    class Task implements Runnable {
      Task(AbstractScheduledService.ServiceDelegate this$0) {}
      
      public void run() {
        AbstractScheduledService.ServiceDelegate.a(this.a).lock();
        try {
          boolean bool = AbstractScheduledService.ServiceDelegate.b(this.a).isCancelled();
          if (bool) {
            AbstractScheduledService.ServiceDelegate.a(this.a).unlock();
            return;
          } 
          this.a.a.a();
        } finally {
          Exception exception;
        } 
        AbstractScheduledService.ServiceDelegate.a(this.a).unlock();
      }
    }
  }
  
  class null implements Supplier<String> {
    public String a() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.a.f());
      stringBuilder.append(" ");
      stringBuilder.append(this.a.e());
      return stringBuilder.toString();
    }
  }
  
  class null implements Runnable {
    public void run() {
      AbstractScheduledService.ServiceDelegate.a(this.a).lock();
      try {
        this.a.a.b();
        AbstractScheduledService.ServiceDelegate.a(this.a, this.a.a.d().a(AbstractScheduledService.a(this.a.a), AbstractScheduledService.ServiceDelegate.c(this.a), AbstractScheduledService.ServiceDelegate.d(this.a)));
        this.a.b();
      } finally {
        null = null;
      } 
    }
  }
  
  class null implements Runnable {
    null(AbstractScheduledService this$0) {}
    
    public void run() {
      try {
      
      } finally {
        Exception exception = null;
        this.a.a(exception);
      } 
    }
  }
  
  class Task implements Runnable {
    Task(AbstractScheduledService this$0) {}
    
    public void run() {
      AbstractScheduledService.ServiceDelegate.a(this.a).lock();
      try {
        boolean bool = AbstractScheduledService.ServiceDelegate.b(this.a).isCancelled();
        if (bool) {
          AbstractScheduledService.ServiceDelegate.a(this.a).unlock();
          return;
        } 
        this.a.a.a();
      } finally {
        Exception exception;
      } 
      AbstractScheduledService.ServiceDelegate.a(this.a).unlock();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractScheduledService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */