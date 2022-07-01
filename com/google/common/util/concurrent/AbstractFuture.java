package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
  private static final AtomicHelper ATOMIC_HELPER;
  
  private static final boolean GENERATE_CANCELLATION_CAUSES;
  
  private static final Object NULL;
  
  private static final long SPIN_THRESHOLD_NANOS = 1000L;
  
  private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
  
  @NullableDecl
  private volatile Listener listeners;
  
  @NullableDecl
  private volatile Object value;
  
  @NullableDecl
  private volatile Waiter waiters;
  
  static {
    Exception exception2 = null;
    try {
      UnsafeAtomicHelper unsafeAtomicHelper = new UnsafeAtomicHelper();
    } finally {
      exception1 = null;
    } 
    ATOMIC_HELPER = synchronizedHelper;
    if (exception2 != null) {
      log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", exception1);
      log.log(Level.SEVERE, "SafeAtomicHelper is broken!", exception2);
    } 
    NULL = new Object();
  }
  
  private void addDoneString(StringBuilder paramStringBuilder) {
    try {
      Object object = getUninterruptibly(this);
      paramStringBuilder.append("SUCCESS, result=[");
      appendUserObject(paramStringBuilder, object);
      paramStringBuilder.append("]");
      return;
    } catch (ExecutionException executionException) {
      paramStringBuilder.append("FAILURE, cause=[");
      paramStringBuilder.append(executionException.getCause());
      paramStringBuilder.append("]");
      return;
    } catch (CancellationException cancellationException) {
      paramStringBuilder.append("CANCELLED");
      return;
    } catch (RuntimeException runtimeException) {
      paramStringBuilder.append("UNKNOWN, cause=[");
      paramStringBuilder.append(runtimeException.getClass());
      paramStringBuilder.append(" thrown from get()]");
      return;
    } 
  }
  
  private void addPendingString(StringBuilder paramStringBuilder) {
    int i = paramStringBuilder.length();
    paramStringBuilder.append("PENDING");
    Object object = this.value;
    if (object instanceof SetFuture) {
      paramStringBuilder.append(", setFuture=[");
      appendUserObject(paramStringBuilder, ((SetFuture)object).b);
      paramStringBuilder.append("]");
    } else {
      try {
        object = Strings.a(pendingToString());
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception thrown from implementation: ");
        stringBuilder.append(runtimeException.getClass());
        String str = stringBuilder.toString();
      } catch (StackOverflowError stackOverflowError) {}
      if (stackOverflowError != null) {
        paramStringBuilder.append(", info=[");
        paramStringBuilder.append((String)stackOverflowError);
        paramStringBuilder.append("]");
      } 
    } 
    if (isDone()) {
      paramStringBuilder.delete(i, paramStringBuilder.length());
      addDoneString(paramStringBuilder);
    } 
  }
  
  private void appendUserObject(StringBuilder paramStringBuilder, Object paramObject) {
    if (paramObject == this) {
      try {
        paramStringBuilder.append("this future");
        return;
      } catch (RuntimeException runtimeException) {
      
      } catch (StackOverflowError stackOverflowError) {}
    } else {
      paramStringBuilder.append(stackOverflowError);
      return;
    } 
    paramStringBuilder.append("Exception thrown from implementation: ");
    paramStringBuilder.append(stackOverflowError.getClass());
  }
  
  private static CancellationException cancellationExceptionWithCause(@NullableDecl String paramString, @NullableDecl Throwable paramThrowable) {
    CancellationException cancellationException = new CancellationException(paramString);
    cancellationException.initCause(paramThrowable);
    return cancellationException;
  }
  
  private Listener clearListeners(Listener paramListener) {
    while (true) {
      Listener listener = this.listeners;
      if (ATOMIC_HELPER.a(this, listener, Listener.a)) {
        Listener listener1 = paramListener;
        for (paramListener = listener; paramListener != null; paramListener = listener) {
          listener = paramListener.d;
          paramListener.d = listener1;
          listener1 = paramListener;
        } 
        return listener1;
      } 
    } 
  }
  
  private static void complete(AbstractFuture<?> paramAbstractFuture) {
    AbstractFuture abstractFuture1 = null;
    AbstractFuture<?> abstractFuture = paramAbstractFuture;
    paramAbstractFuture = abstractFuture1;
    label17: while (true) {
      abstractFuture.releaseWaiters();
      abstractFuture.afterDone();
      Listener listener = abstractFuture.clearListeners((Listener)paramAbstractFuture);
      while (listener != null) {
        AbstractFuture<V> abstractFuture2;
        Listener listener1 = listener.d;
        Runnable runnable = listener.b;
        if (runnable instanceof SetFuture) {
          runnable = runnable;
          abstractFuture2 = ((SetFuture)runnable).a;
          if (abstractFuture2.value == runnable) {
            Object object = getFutureValue(((SetFuture)runnable).b);
            if (ATOMIC_HELPER.a(abstractFuture2, runnable, object))
              continue label17; 
          } 
        } else {
          executeListener(runnable, ((Listener)abstractFuture2).c);
        } 
        Listener listener2 = listener1;
      } 
      break;
    } 
  }
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor) {
    try {
      paramExecutor.execute(paramRunnable);
      return;
    } catch (RuntimeException runtimeException) {
      Logger logger = log;
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
  
  private V getDoneValue(Object paramObject) throws ExecutionException {
    if (!(paramObject instanceof Cancellation)) {
      if (!(paramObject instanceof Failure)) {
        Object object = paramObject;
        if (paramObject == NULL)
          object = null; 
        return (V)object;
      } 
      throw new ExecutionException(((Failure)paramObject).b);
    } 
    throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)paramObject).d);
  }
  
  private static Object getFutureValue(ListenableFuture<?> paramListenableFuture) {
    Object object;
    if (paramListenableFuture instanceof Trusted) {
      Object object1 = ((AbstractFuture)paramListenableFuture).value;
      object = object1;
      if (object1 instanceof Cancellation) {
        Cancellation cancellation = (Cancellation)object1;
        object = object1;
        if (cancellation.c) {
          if (cancellation.d != null)
            return new Cancellation(false, cancellation.d); 
          object = Cancellation.b;
        } 
      } 
      return object;
    } 
    if (object instanceof InternalFutureFailureAccess) {
      Throwable throwable = InternalFutures.a((InternalFutureFailureAccess)object);
      if (throwable != null)
        return new Failure(throwable); 
    } 
    boolean bool = object.isCancelled();
    if (((GENERATE_CANCELLATION_CAUSES ^ true) & bool) != 0)
      return Cancellation.b; 
    try {
      Object object2 = getUninterruptibly((Future<Object>)object);
      if (bool) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
        return new Cancellation(false, new IllegalArgumentException(stringBuilder.toString()));
      } 
      Object object1 = object2;
      return object1;
    } catch (ExecutionException executionException) {
      return new Failure(executionException.getCause());
    } catch (CancellationException cancellationException) {
      return new Cancellation(false, cancellationException);
    } finally {
      object = null;
    } 
  }
  
  private static <V> V getUninterruptibly(Future<V> paramFuture) throws ExecutionException {
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
  
  private void releaseWaiters() {
    Waiter waiter;
    do {
      waiter = this.waiters;
    } while (!ATOMIC_HELPER.a(this, waiter, Waiter.a));
    while (waiter != null) {
      waiter.a();
      waiter = waiter.c;
    } 
  }
  
  private void removeWaiter(Waiter paramWaiter) {
    paramWaiter.b = null;
    label24: while (true) {
      paramWaiter = this.waiters;
      if (paramWaiter == Waiter.a)
        return; 
      for (Object object = null; paramWaiter != null; object = object1) {
        Object object1;
        Waiter waiter = paramWaiter.c;
        if (paramWaiter.b != null) {
          object1 = paramWaiter;
        } else if (object != null) {
          ((Waiter)object).c = waiter;
          object1 = object;
          if (((Waiter)object).b == null)
            continue label24; 
        } else {
          object1 = object;
          if (!ATOMIC_HELPER.a(this, paramWaiter, waiter))
            continue label24; 
        } 
        paramWaiter = waiter;
      } 
      break;
    } 
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    Preconditions.a(paramRunnable, "Runnable was null.");
    Preconditions.a(paramExecutor, "Executor was null.");
    if (!isDone()) {
      Listener listener = this.listeners;
      if (listener != Listener.a) {
        Listener listener1;
        Listener listener2 = new Listener(paramRunnable, paramExecutor);
        do {
          listener2.d = listener;
          if (ATOMIC_HELPER.a(this, listener, listener2))
            return; 
          listener1 = this.listeners;
          listener = listener1;
        } while (listener1 != Listener.a);
      } 
    } 
    executeListener(paramRunnable, paramExecutor);
  }
  
  protected void afterDone() {}
  
  public boolean cancel(boolean paramBoolean) {
    boolean bool;
    boolean bool1;
    Object object = this.value;
    boolean bool2 = true;
    if (object == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool | object instanceof SetFuture) {
      Cancellation cancellation;
      if (GENERATE_CANCELLATION_CAUSES) {
        cancellation = new Cancellation(paramBoolean, new CancellationException("Future.cancel() was called."));
      } else if (paramBoolean) {
        cancellation = Cancellation.a;
      } else {
        cancellation = Cancellation.b;
      } 
      bool1 = false;
      AbstractFuture<?> abstractFuture = this;
      while (true) {
        while (ATOMIC_HELPER.a(abstractFuture, object, cancellation)) {
          if (paramBoolean)
            abstractFuture.interruptTask(); 
          complete(abstractFuture);
          bool1 = bool2;
          if (object instanceof SetFuture) {
            object = ((SetFuture)object).b;
            if (object instanceof Trusted) {
              abstractFuture = (AbstractFuture)object;
              object = abstractFuture.value;
              if (object == null) {
                bool = true;
              } else {
                bool = false;
              } 
              bool1 = bool2;
              if (bool | object instanceof SetFuture) {
                bool1 = true;
                continue;
              } 
            } else {
              object.cancel(paramBoolean);
              return true;
            } 
          } 
          return bool1;
        } 
        Object object1 = abstractFuture.value;
        object = object1;
        if (!(object1 instanceof SetFuture))
          return bool1; 
      } 
    } else {
      bool1 = false;
    } 
    return bool1;
  }
  
  public V get() throws InterruptedException, ExecutionException {
    if (!Thread.interrupted()) {
      boolean bool;
      Object object = this.value;
      if (object != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if ((bool & (object instanceof SetFuture ^ true)) != 0)
        return getDoneValue(object); 
      object = this.waiters;
      if (object != Waiter.a) {
        Waiter waiter1;
        Waiter waiter2 = new Waiter();
        do {
          waiter2.a((Waiter)object);
          if (ATOMIC_HELPER.a(this, (Waiter)object, waiter2))
            while (true) {
              LockSupport.park(this);
              if (!Thread.interrupted()) {
                object = this.value;
                if (object != null) {
                  bool = true;
                } else {
                  bool = false;
                } 
                if ((bool & (object instanceof SetFuture ^ true)) != 0)
                  return getDoneValue(object); 
                continue;
              } 
              removeWaiter(waiter2);
              throw new InterruptedException();
            }  
          waiter1 = this.waiters;
          object = waiter1;
        } while (waiter1 != Waiter.a);
      } 
      return getDoneValue(this.value);
    } 
    throw new InterruptedException();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException, ExecutionException {
    long l = paramTimeUnit.toNanos(paramLong);
    if (!Thread.interrupted()) {
      boolean bool;
      long l2;
      Object object = this.value;
      if (object != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if ((bool & (object instanceof SetFuture ^ true)) != 0)
        return getDoneValue(object); 
      if (l > 0L) {
        l2 = System.nanoTime() + l;
      } else {
        l2 = 0L;
      } 
      long l1 = l;
      if (l >= 1000L) {
        object = this.waiters;
        if (object != Waiter.a) {
          Waiter waiter = new Waiter();
          label75: while (true) {
            waiter.a((Waiter)object);
            if (ATOMIC_HELPER.a(this, (Waiter)object, waiter))
              while (true) {
                LockSupport.parkNanos(this, l);
                if (!Thread.interrupted()) {
                  object = this.value;
                  if (object != null) {
                    bool = true;
                  } else {
                    bool = false;
                  } 
                  if ((bool & (object instanceof SetFuture ^ true)) != 0)
                    return getDoneValue(object); 
                  l1 = l2 - System.nanoTime();
                  l = l1;
                  if (l1 < 1000L) {
                    removeWaiter(waiter);
                    break;
                  } 
                  continue;
                } 
                removeWaiter(waiter);
                throw new InterruptedException();
              }  
            Waiter waiter1 = this.waiters;
            object = waiter1;
            if (waiter1 == Waiter.a)
              break label75; 
          } 
        } else {
          return getDoneValue(this.value);
        } 
      } 
      while (l1 > 0L) {
        object = this.value;
        if (object != null) {
          bool = true;
        } else {
          bool = false;
        } 
        if ((bool & (object instanceof SetFuture ^ true)) != 0)
          return getDoneValue(object); 
        if (!Thread.interrupted()) {
          l1 = l2 - System.nanoTime();
          continue;
        } 
        throw new InterruptedException();
      } 
      String str2 = toString();
      String str3 = paramTimeUnit.toString().toLowerCase(Locale.ROOT);
      object = new StringBuilder();
      object.append("Waited ");
      object.append(paramLong);
      object.append(" ");
      object.append(paramTimeUnit.toString().toLowerCase(Locale.ROOT));
      String str1 = object.toString();
      object = str1;
      if (l1 + 1000L < 0L) {
        object = new StringBuilder();
        object.append(str1);
        object.append(" (plus ");
        object = object.toString();
        l1 = -l1;
        paramLong = paramTimeUnit.convert(l1, TimeUnit.NANOSECONDS);
        l1 -= paramTimeUnit.toNanos(paramLong);
        int i = paramLong cmp 0L;
        if (i == 0 || l1 > 1000L) {
          bool = true;
        } else {
          bool = false;
        } 
        Object object1 = object;
        if (i > 0) {
          object1 = new StringBuilder();
          object1.append((String)object);
          object1.append(paramLong);
          object1.append(" ");
          object1.append(str3);
          object = object1.toString();
          object1 = object;
          if (bool) {
            object1 = new StringBuilder();
            object1.append((String)object);
            object1.append(",");
            object1 = object1.toString();
          } 
          object = new StringBuilder();
          object.append((String)object1);
          object.append(" ");
          object1 = object.toString();
        } 
        object = object1;
        if (bool) {
          object = new StringBuilder();
          object.append((String)object1);
          object.append(l1);
          object.append(" nanoseconds ");
          object = object.toString();
        } 
        object1 = new StringBuilder();
        object1.append((String)object);
        object1.append("delay)");
        object = object1.toString();
      } 
      if (isDone()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append((String)object);
        stringBuilder1.append(" but future completed as timeout expired");
        throw new TimeoutException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)object);
      stringBuilder.append(" for ");
      stringBuilder.append(str2);
      throw new TimeoutException(stringBuilder.toString());
    } 
    throw new InterruptedException();
  }
  
  protected void interruptTask() {}
  
  public boolean isCancelled() {
    return this.value instanceof Cancellation;
  }
  
  public boolean isDone() {
    boolean bool;
    Object object = this.value;
    if (object != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return (object instanceof SetFuture ^ true) & bool;
  }
  
  final void maybePropagateCancellationTo(@NullableDecl Future<?> paramFuture) {
    boolean bool;
    if (paramFuture != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool & isCancelled())
      paramFuture.cancel(wasInterrupted()); 
  }
  
  @NullableDecl
  protected String pendingToString() {
    if (this instanceof ScheduledFuture) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("remaining delay=[");
      stringBuilder.append(((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS));
      stringBuilder.append(" ms]");
      return stringBuilder.toString();
    } 
    return null;
  }
  
  public boolean set(@NullableDecl V paramV) {
    V v = paramV;
    if (paramV == null)
      v = (V)NULL; 
    if (ATOMIC_HELPER.a(this, (Object)null, v)) {
      complete(this);
      return true;
    } 
    return false;
  }
  
  public boolean setException(Throwable paramThrowable) {
    Failure failure = new Failure((Throwable)Preconditions.a(paramThrowable));
    if (ATOMIC_HELPER.a(this, (Object)null, failure)) {
      complete(this);
      return true;
    } 
    return false;
  }
  
  protected boolean setFuture(ListenableFuture<? extends V> paramListenableFuture) {
    Object object1;
    Preconditions.a(paramListenableFuture);
    Object object3 = this.value;
    Object object2 = object3;
    if (object3 == null) {
      if (paramListenableFuture.isDone()) {
        object1 = getFutureValue(paramListenableFuture);
        if (ATOMIC_HELPER.a(this, (Object)null, object1)) {
          complete(this);
          return true;
        } 
        return false;
      } 
      object2 = new SetFuture(this, (ListenableFuture<?>)object1);
      if (ATOMIC_HELPER.a(this, (Object)null, object2))
        try {
          return true;
        } finally {
          object1 = null;
          try {
            object1 = new Failure((Throwable)object1);
          } finally {
            object1 = null;
          } 
        }  
      object2 = this.value;
    } 
    if (object2 instanceof Cancellation)
      object1.cancel(((Cancellation)object2).c); 
    return false;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[status=");
    if (isCancelled()) {
      stringBuilder.append("CANCELLED");
    } else if (isDone()) {
      addDoneString(stringBuilder);
    } else {
      addPendingString(stringBuilder);
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  @NullableDecl
  public final Throwable tryInternalFastPathGetFailure() {
    if (this instanceof Trusted) {
      Object object = this.value;
      if (object instanceof Failure)
        return ((Failure)object).b; 
    } 
    return null;
  }
  
  protected final boolean wasInterrupted() {
    Object object = this.value;
    return (object instanceof Cancellation && ((Cancellation)object).c);
  }
  
  static {
    boolean bool;
    Exception exception1;
    SynchronizedHelper synchronizedHelper;
    try {
      bool = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    } catch (SecurityException null) {
      bool = false;
    } 
    GENERATE_CANCELLATION_CAUSES = bool;
  }
  
  static abstract class AtomicHelper {
    private AtomicHelper() {}
    
    abstract void a(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2);
    
    abstract void a(AbstractFuture.Waiter param1Waiter, Thread param1Thread);
    
    abstract boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2);
    
    abstract boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2);
    
    abstract boolean a(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2);
  }
  
  static final class Cancellation {
    static final Cancellation a = new Cancellation(true, null);
    
    static final Cancellation b = new Cancellation(false, null);
    
    final boolean c;
    
    @NullableDecl
    final Throwable d;
    
    static {
    
    }
    
    Cancellation(boolean param1Boolean, @NullableDecl Throwable param1Throwable) {
      this.c = param1Boolean;
      this.d = param1Throwable;
    }
    
    static {
      if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
        b = null;
        a = null;
        return;
      } 
    }
  }
  
  static final class Failure {
    static final Failure a = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
          public Throwable fillInStackTrace() {
            /* monitor enter ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
            /* monitor exit ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
            return this;
          }
        });
    
    final Throwable b;
    
    Failure(Throwable param1Throwable) {
      this.b = (Throwable)Preconditions.a(param1Throwable);
    }
  }
  
  static final class null extends Throwable {
    null(String param1String) {
      super(param1String);
    }
    
    public Throwable fillInStackTrace() {
      /* monitor enter ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
      /* monitor exit ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
      return this;
    }
  }
  
  static final class Listener {
    static final Listener a = new Listener(null, null);
    
    final Runnable b;
    
    final Executor c;
    
    @NullableDecl
    Listener d;
    
    Listener(Runnable param1Runnable, Executor param1Executor) {
      this.b = param1Runnable;
      this.c = param1Executor;
    }
  }
  
  static final class SafeAtomicHelper extends AtomicHelper {
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> a;
    
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> b;
    
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> c;
    
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> d;
    
    final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> param1AtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> param1AtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> param1AtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> param1AtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Object> param1AtomicReferenceFieldUpdater4) {
      this.a = param1AtomicReferenceFieldUpdater;
      this.b = param1AtomicReferenceFieldUpdater1;
      this.c = param1AtomicReferenceFieldUpdater2;
      this.d = param1AtomicReferenceFieldUpdater3;
      this.e = param1AtomicReferenceFieldUpdater4;
    }
    
    void a(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      this.b.lazySet(param1Waiter1, param1Waiter2);
    }
    
    void a(AbstractFuture.Waiter param1Waiter, Thread param1Thread) {
      this.a.lazySet(param1Waiter, param1Thread);
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2) {
      return this.d.compareAndSet(param1AbstractFuture, param1Listener1, param1Listener2);
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      return this.c.compareAndSet(param1AbstractFuture, param1Waiter1, param1Waiter2);
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2) {
      return this.e.compareAndSet(param1AbstractFuture, param1Object1, param1Object2);
    }
  }
  
  static final class SetFuture<V> implements Runnable {
    final AbstractFuture<V> a;
    
    final ListenableFuture<? extends V> b;
    
    SetFuture(AbstractFuture<V> param1AbstractFuture, ListenableFuture<? extends V> param1ListenableFuture) {
      this.a = param1AbstractFuture;
      this.b = param1ListenableFuture;
    }
    
    public void run() {
      if (this.a.value != this)
        return; 
      Object object = AbstractFuture.getFutureValue(this.b);
      if (AbstractFuture.ATOMIC_HELPER.a(this.a, this, object))
        AbstractFuture.complete(this.a); 
    }
  }
  
  static final class SynchronizedHelper extends AtomicHelper {
    private SynchronizedHelper() {}
    
    void a(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      param1Waiter1.c = param1Waiter2;
    }
    
    void a(AbstractFuture.Waiter param1Waiter, Thread param1Thread) {
      param1Waiter.b = param1Thread;
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$900 : (Lcom/google/common/util/concurrent/AbstractFuture;)Lcom/google/common/util/concurrent/AbstractFuture$Listener;
      //   6: aload_2
      //   7: if_acmpne -> 20
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$902 : (Lcom/google/common/util/concurrent/AbstractFuture;Lcom/google/common/util/concurrent/AbstractFuture$Listener;)Lcom/google/common/util/concurrent/AbstractFuture$Listener;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   25	27	24	finally
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$800 : (Lcom/google/common/util/concurrent/AbstractFuture;)Lcom/google/common/util/concurrent/AbstractFuture$Waiter;
      //   6: aload_2
      //   7: if_acmpne -> 20
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$802 : (Lcom/google/common/util/concurrent/AbstractFuture;Lcom/google/common/util/concurrent/AbstractFuture$Waiter;)Lcom/google/common/util/concurrent/AbstractFuture$Waiter;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   25	27	24	finally
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$400 : (Lcom/google/common/util/concurrent/AbstractFuture;)Ljava/lang/Object;
      //   6: aload_2
      //   7: if_acmpne -> 20
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$402 : (Lcom/google/common/util/concurrent/AbstractFuture;Ljava/lang/Object;)Ljava/lang/Object;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   25	27	24	finally
    }
  }
  
  static interface Trusted<V> extends ListenableFuture<V> {}
  
  public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
    public final void addListener(Runnable param1Runnable, Executor param1Executor) {
      super.addListener(param1Runnable, param1Executor);
    }
    
    public final boolean cancel(boolean param1Boolean) {
      return super.cancel(param1Boolean);
    }
    
    public final V get() throws InterruptedException, ExecutionException {
      return super.get();
    }
    
    public final V get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
      return super.get(param1Long, param1TimeUnit);
    }
    
    public final boolean isCancelled() {
      return super.isCancelled();
    }
    
    public final boolean isDone() {
      return super.isDone();
    }
  }
  
  static final class UnsafeAtomicHelper extends AtomicHelper {
    static final Unsafe a;
    
    static final long b;
    
    static final long c;
    
    static final long d;
    
    static final long e;
    
    static final long f;
    
    static {
      try {
        Unsafe unsafe = Unsafe.getUnsafe();
        try {
          c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
          b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
          d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
          e = unsafe.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("b"));
          f = unsafe.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("c"));
          a = unsafe;
          return;
        } catch (Exception exception) {
          Throwables.a(exception);
          throw new RuntimeException(exception);
        } 
      } catch (SecurityException securityException) {
        try {
          Unsafe unsafe = AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe a() throws Exception {
                  for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object object = field.get((Object)null);
                    if (Unsafe.class.isInstance(object))
                      return Unsafe.class.cast(object); 
                  } 
                  throw new NoSuchFieldError("the Unsafe");
                }
              });
          try {
            c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
            b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
            d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
            e = unsafe.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("b"));
            f = unsafe.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("c"));
            a = unsafe;
            return;
          } catch (Exception exception) {
            Throwables.a(exception);
            throw new RuntimeException(exception);
          } 
        } catch (PrivilegedActionException privilegedActionException) {
          throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
        } 
      } 
    }
    
    private UnsafeAtomicHelper() {}
    
    void a(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      a.putObject(param1Waiter1, f, param1Waiter2);
    }
    
    void a(AbstractFuture.Waiter param1Waiter, Thread param1Thread) {
      a.putObject(param1Waiter, e, param1Thread);
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2) {
      return a.compareAndSwapObject(param1AbstractFuture, b, param1Listener1, param1Listener2);
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      return a.compareAndSwapObject(param1AbstractFuture, c, param1Waiter1, param1Waiter2);
    }
    
    boolean a(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2) {
      return a.compareAndSwapObject(param1AbstractFuture, d, param1Object1, param1Object2);
    }
  }
  
  static final class null implements PrivilegedExceptionAction<Unsafe> {
    public Unsafe a() throws Exception {
      for (Field field : Unsafe.class.getDeclaredFields()) {
        field.setAccessible(true);
        Object object = field.get((Object)null);
        if (Unsafe.class.isInstance(object))
          return Unsafe.class.cast(object); 
      } 
      throw new NoSuchFieldError("the Unsafe");
    }
  }
  
  static final class Waiter {
    static final Waiter a = new Waiter(false);
    
    @NullableDecl
    volatile Thread b;
    
    @NullableDecl
    volatile Waiter c;
    
    Waiter() {
      AbstractFuture.ATOMIC_HELPER.a(this, Thread.currentThread());
    }
    
    Waiter(boolean param1Boolean) {}
    
    void a() {
      Thread thread = this.b;
      if (thread != null) {
        this.b = null;
        LockSupport.unpark(thread);
      } 
    }
    
    void a(Waiter param1Waiter) {
      AbstractFuture.ATOMIC_HELPER.a(this, param1Waiter);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */