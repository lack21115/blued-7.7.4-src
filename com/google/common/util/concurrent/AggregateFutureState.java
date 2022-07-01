package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
  static {
    try {
      SafeAtomicHelper safeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "b"));
    } finally {
      exception = null;
    } 
    c = synchronizedAtomicHelper;
    if (exception != null)
      d.log(Level.SEVERE, "SafeAtomicHelper is broken!", exception); 
  }
  
  abstract void a(Set<Throwable> paramSet);
  
  final Set<Throwable> b() {
    Set<Throwable> set2 = this.a;
    Set<Throwable> set1 = set2;
    if (set2 == null) {
      set1 = Sets.b();
      a(set1);
      c.a(this, null, set1);
      set1 = this.a;
    } 
    return set1;
  }
  
  final int c() {
    return c.a(this);
  }
  
  final void d() {
    this.a = null;
  }
  
  static {
    Exception exception;
    SynchronizedAtomicHelper synchronizedAtomicHelper;
  }
  
  private static final AtomicHelper c;
  
  private static final Logger d = Logger.getLogger(AggregateFutureState.class.getName());
  
  private volatile Set<Throwable> a;
  
  private volatile int b;
  
  static abstract class AtomicHelper {
    private AtomicHelper() {}
    
    abstract int a(AggregateFutureState param1AggregateFutureState);
    
    abstract void a(AggregateFutureState param1AggregateFutureState, Set<Throwable> param1Set1, Set<Throwable> param1Set2);
  }
  
  static final class SafeAtomicHelper extends AtomicHelper {
    final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> a;
    
    final AtomicIntegerFieldUpdater<AggregateFutureState> b;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> param1AtomicReferenceFieldUpdater, AtomicIntegerFieldUpdater<AggregateFutureState> param1AtomicIntegerFieldUpdater) {
      this.a = param1AtomicReferenceFieldUpdater;
      this.b = param1AtomicIntegerFieldUpdater;
    }
    
    int a(AggregateFutureState param1AggregateFutureState) {
      return this.b.decrementAndGet(param1AggregateFutureState);
    }
    
    void a(AggregateFutureState param1AggregateFutureState, Set<Throwable> param1Set1, Set<Throwable> param1Set2) {
      this.a.compareAndSet(param1AggregateFutureState, param1Set1, param1Set2);
    }
  }
  
  static final class SynchronizedAtomicHelper extends AtomicHelper {
    private SynchronizedAtomicHelper() {}
    
    int a(AggregateFutureState param1AggregateFutureState) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic b : (Lcom/google/common/util/concurrent/AggregateFutureState;)I
      //   6: istore_2
      //   7: aload_1
      //   8: monitorexit
      //   9: iload_2
      //   10: ireturn
      //   11: astore_3
      //   12: aload_1
      //   13: monitorexit
      //   14: aload_3
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	11	finally
      //   12	14	11	finally
    }
    
    void a(AggregateFutureState param1AggregateFutureState, Set<Throwable> param1Set1, Set<Throwable> param1Set2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic a : (Lcom/google/common/util/concurrent/AggregateFutureState;)Ljava/util/Set;
      //   6: aload_2
      //   7: if_acmpne -> 16
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic a : (Lcom/google/common/util/concurrent/AggregateFutureState;Ljava/util/Set;)Ljava/util/Set;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: return
      //   19: astore_2
      //   20: aload_1
      //   21: monitorexit
      //   22: aload_2
      //   23: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	19	finally
      //   16	18	19	finally
      //   20	22	19	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AggregateFutureState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */