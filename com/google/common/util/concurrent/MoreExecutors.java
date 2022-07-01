package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors {
  static Thread a(String paramString, Runnable paramRunnable) {
    Preconditions.a(paramString);
    Preconditions.a(paramRunnable);
    paramRunnable = b().newThread(paramRunnable);
    try {
      paramRunnable.setName(paramString);
      return (Thread)paramRunnable;
    } catch (SecurityException securityException) {
      return (Thread)paramRunnable;
    } 
  }
  
  public static Executor a() {
    return DirectExecutor.a;
  }
  
  static Executor a(Executor paramExecutor, Supplier<String> paramSupplier) {
    Preconditions.a(paramExecutor);
    Preconditions.a(paramSupplier);
    return new Executor(paramExecutor, paramSupplier) {
        public void execute(Runnable param1Runnable) {
          this.a.execute(Callables.a(param1Runnable, this.b));
        }
      };
  }
  
  static Executor a(Executor paramExecutor, AbstractFuture<?> paramAbstractFuture) {
    Preconditions.a(paramExecutor);
    Preconditions.a(paramAbstractFuture);
    return (paramExecutor == a()) ? paramExecutor : new Executor(paramExecutor, paramAbstractFuture) {
        boolean a = true;
        
        public void execute(Runnable param1Runnable) {
          try {
            this.b.execute(new Runnable(this, param1Runnable) {
                  public void run() {
                    this.b.a = false;
                    this.a.run();
                  }
                  
                  public String toString() {
                    return this.a.toString();
                  }
                });
            return;
          } catch (RejectedExecutionException rejectedExecutionException) {
            if (this.a)
              this.c.setException(rejectedExecutionException); 
            return;
          } 
        }
      };
  }
  
  public static ThreadFactory b() {
    if (!c())
      return Executors.defaultThreadFactory(); 
    try {
      return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", illegalAccessException);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", classNotFoundException);
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", noSuchMethodException);
    } catch (InvocationTargetException invocationTargetException) {
      throw Throwables.c(invocationTargetException.getCause());
    } 
  }
  
  private static boolean c() {
    String str = System.getProperty("com.google.appengine.runtime.environment");
    boolean bool = false;
    if (str == null)
      return false; 
    try {
      Class.forName("com.google.appengine.api.utils.SystemProperty");
      Object object = Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]);
      if (object != null)
        bool = true; 
      return bool;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  static class Application {}
  
  class null implements Runnable {
    public void run() {
      try {
        this.a.shutdown();
        this.a.awaitTermination(this.b, this.c);
        return;
      } catch (InterruptedException interruptedException) {
        return;
      } 
    }
  }
  
  static final class DirectExecutorService extends AbstractListeningExecutorService {
    private final Object a = new Object();
    
    private int b = 0;
    
    private boolean c = false;
    
    private void a() {
      synchronized (this.a) {
        if (!this.c) {
          this.b++;
          return;
        } 
        throw new RejectedExecutionException("Executor already shutdown");
      } 
    }
    
    private void b() {
      synchronized (this.a) {
        int i = this.b - 1;
        this.b = i;
        if (i == 0)
          this.a.notifyAll(); 
        return;
      } 
    }
    
    public boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      param1Long = param1TimeUnit.toNanos(param1Long);
      synchronized (this.a) {
        while (true) {
          if (this.c && this.b == 0)
            return true; 
          if (param1Long <= 0L)
            return false; 
          long l = System.nanoTime();
          TimeUnit.NANOSECONDS.timedWait(this.a, param1Long);
          param1Long -= System.nanoTime() - l;
        } 
      } 
    }
    
    public void execute(Runnable param1Runnable) {
      a();
      try {
        param1Runnable.run();
        return;
      } finally {
        b();
      } 
    }
    
    public boolean isShutdown() {
      synchronized (this.a) {
        return this.c;
      } 
    }
    
    public boolean isTerminated() {
      synchronized (this.a) {
        if (this.c && this.b == 0)
          return true; 
      } 
      boolean bool = false;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
      return bool;
    }
    
    public void shutdown() {
      synchronized (this.a) {
        this.c = true;
        if (this.b == 0)
          this.a.notifyAll(); 
        return;
      } 
    }
    
    public List<Runnable> shutdownNow() {
      shutdown();
      return Collections.emptyList();
    }
  }
  
  static class ListeningDecorator extends AbstractListeningExecutorService {
    private final ExecutorService a;
    
    public final boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      return this.a.awaitTermination(param1Long, param1TimeUnit);
    }
    
    public final void execute(Runnable param1Runnable) {
      this.a.execute(param1Runnable);
    }
    
    public final boolean isShutdown() {
      return this.a.isShutdown();
    }
    
    public final boolean isTerminated() {
      return this.a.isTerminated();
    }
    
    public final void shutdown() {
      this.a.shutdown();
    }
    
    public final List<Runnable> shutdownNow() {
      return this.a.shutdownNow();
    }
  }
  
  static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
    final ScheduledExecutorService a;
    
    public ListenableScheduledFuture<?> a(Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
      param1Runnable = new NeverSuccessfulListenableFutureTask(param1Runnable);
      return new ListenableScheduledTask((ListenableFuture<?>)param1Runnable, this.a.scheduleAtFixedRate(param1Runnable, param1Long1, param1Long2, param1TimeUnit));
    }
    
    public ListenableScheduledFuture<?> a(Runnable<?> param1Runnable, long param1Long, TimeUnit param1TimeUnit) {
      param1Runnable = TrustedListenableFutureTask.a(param1Runnable, null);
      return new ListenableScheduledTask((ListenableFuture<?>)param1Runnable, this.a.schedule(param1Runnable, param1Long, param1TimeUnit));
    }
    
    public <V> ListenableScheduledFuture<V> a(Callable<V> param1Callable, long param1Long, TimeUnit param1TimeUnit) {
      TrustedListenableFutureTask<V> trustedListenableFutureTask = TrustedListenableFutureTask.a(param1Callable);
      return new ListenableScheduledTask<V>(trustedListenableFutureTask, this.a.schedule(trustedListenableFutureTask, param1Long, param1TimeUnit));
    }
    
    public ListenableScheduledFuture<?> b(Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
      param1Runnable = new NeverSuccessfulListenableFutureTask(param1Runnable);
      return new ListenableScheduledTask((ListenableFuture<?>)param1Runnable, this.a.scheduleWithFixedDelay(param1Runnable, param1Long1, param1Long2, param1TimeUnit));
    }
    
    static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
      private final ScheduledFuture<?> a;
      
      public ListenableScheduledTask(ListenableFuture<V> param2ListenableFuture, ScheduledFuture<?> param2ScheduledFuture) {
        super(param2ListenableFuture);
        this.a = param2ScheduledFuture;
      }
      
      public int a(Delayed param2Delayed) {
        return this.a.compareTo(param2Delayed);
      }
      
      public boolean cancel(boolean param2Boolean) {
        boolean bool = super.cancel(param2Boolean);
        if (bool)
          this.a.cancel(param2Boolean); 
        return bool;
      }
      
      public long getDelay(TimeUnit param2TimeUnit) {
        return this.a.getDelay(param2TimeUnit);
      }
    }
    
    static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
      private final Runnable a;
      
      public NeverSuccessfulListenableFutureTask(Runnable param2Runnable) {
        this.a = (Runnable)Preconditions.a(param2Runnable);
      }
      
      public void run() {
        try {
          return;
        } finally {
          Exception exception = null;
          setException(exception);
        } 
      }
    }
  }
  
  static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
    private final ScheduledFuture<?> a;
    
    public ListenableScheduledTask(ListenableFuture<V> param1ListenableFuture, ScheduledFuture<?> param1ScheduledFuture) {
      super(param1ListenableFuture);
      this.a = param1ScheduledFuture;
    }
    
    public int a(Delayed param1Delayed) {
      return this.a.compareTo(param1Delayed);
    }
    
    public boolean cancel(boolean param1Boolean) {
      boolean bool = super.cancel(param1Boolean);
      if (bool)
        this.a.cancel(param1Boolean); 
      return bool;
    }
    
    public long getDelay(TimeUnit param1TimeUnit) {
      return this.a.getDelay(param1TimeUnit);
    }
  }
  
  static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
    private final Runnable a;
    
    public NeverSuccessfulListenableFutureTask(Runnable param1Runnable) {
      this.a = (Runnable)Preconditions.a(param1Runnable);
    }
    
    public void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        setException(exception);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\MoreExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */