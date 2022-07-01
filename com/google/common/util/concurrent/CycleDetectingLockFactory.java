package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class CycleDetectingLockFactory {
  private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> b = (new MapMaker()).d().g();
  
  private static final Logger c = Logger.getLogger(CycleDetectingLockFactory.class.getName());
  
  private static final ThreadLocal<ArrayList<LockGraphNode>> d = new ThreadLocal<ArrayList<LockGraphNode>>() {
      protected ArrayList<CycleDetectingLockFactory.LockGraphNode> a() {
        return Lists.b(3);
      }
    };
  
  final Policy a;
  
  private void b(CycleDetectingLock paramCycleDetectingLock) {
    if (!paramCycleDetectingLock.b()) {
      ArrayList<LockGraphNode> arrayList = d.get();
      LockGraphNode lockGraphNode = paramCycleDetectingLock.a();
      lockGraphNode.a(this.a, arrayList);
      arrayList.add(lockGraphNode);
    } 
  }
  
  private static void c(CycleDetectingLock paramCycleDetectingLock) {
    if (!paramCycleDetectingLock.b()) {
      ArrayList<LockGraphNode> arrayList = d.get();
      LockGraphNode lockGraphNode = paramCycleDetectingLock.a();
      for (int i = arrayList.size() - 1; i >= 0; i--) {
        if (arrayList.get(i) == lockGraphNode) {
          arrayList.remove(i);
          return;
        } 
      } 
    } 
  }
  
  static interface CycleDetectingLock {
    CycleDetectingLockFactory.LockGraphNode a();
    
    boolean b();
  }
  
  final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
    private final CycleDetectingLockFactory.LockGraphNode b;
    
    public CycleDetectingLockFactory.LockGraphNode a() {
      return this.b;
    }
    
    public boolean b() {
      return isHeldByCurrentThread();
    }
    
    public void lock() {
      CycleDetectingLockFactory.a(this.a, this);
      try {
        super.lock();
        return;
      } finally {
        CycleDetectingLockFactory.a(this);
      } 
    }
    
    public void lockInterruptibly() throws InterruptedException {
      CycleDetectingLockFactory.a(this.a, this);
      try {
        super.lockInterruptibly();
        return;
      } finally {
        CycleDetectingLockFactory.a(this);
      } 
    }
    
    public boolean tryLock() {
      CycleDetectingLockFactory.a(this.a, this);
      try {
        return super.tryLock();
      } finally {
        CycleDetectingLockFactory.a(this);
      } 
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      CycleDetectingLockFactory.a(this.a, this);
      try {
        return super.tryLock(param1Long, param1TimeUnit);
      } finally {
        CycleDetectingLockFactory.a(this);
      } 
    }
    
    public void unlock() {
      try {
        super.unlock();
        return;
      } finally {
        CycleDetectingLockFactory.a(this);
      } 
    }
  }
  
  class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
    final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock a;
    
    public void lock() {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        super.lock();
        return;
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public void lockInterruptibly() throws InterruptedException {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        super.lockInterruptibly();
        return;
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public boolean tryLock() {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        return super.tryLock();
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        return super.tryLock(param1Long, param1TimeUnit);
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public void unlock() {
      try {
        super.unlock();
        return;
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
  }
  
  final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
    private final CycleDetectingLockFactory.CycleDetectingReentrantReadLock a;
    
    private final CycleDetectingLockFactory.CycleDetectingReentrantWriteLock b;
    
    private final CycleDetectingLockFactory.LockGraphNode c;
    
    public CycleDetectingLockFactory.LockGraphNode a() {
      return this.c;
    }
    
    public boolean b() {
      return (isWriteLockedByCurrentThread() || getReadHoldCount() > 0);
    }
    
    public ReentrantReadWriteLock.ReadLock readLock() {
      return this.a;
    }
    
    public ReentrantReadWriteLock.WriteLock writeLock() {
      return this.b;
    }
  }
  
  class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
    final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock a;
    
    public void lock() {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        super.lock();
        return;
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public void lockInterruptibly() throws InterruptedException {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        super.lockInterruptibly();
        return;
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public boolean tryLock() {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        return super.tryLock();
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      CycleDetectingLockFactory.a(this.b, this.a);
      try {
        return super.tryLock(param1Long, param1TimeUnit);
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
    
    public void unlock() {
      try {
        super.unlock();
        return;
      } finally {
        CycleDetectingLockFactory.a(this.a);
      } 
    }
  }
  
  static class ExampleStackTrace extends IllegalStateException {
    static final StackTraceElement[] a = new StackTraceElement[0];
    
    static final ImmutableSet<String> b = ImmutableSet.a(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), CycleDetectingLockFactory.LockGraphNode.class.getName());
    
    ExampleStackTrace(CycleDetectingLockFactory.LockGraphNode param1LockGraphNode1, CycleDetectingLockFactory.LockGraphNode param1LockGraphNode2) {
      super(stringBuilder.toString());
      StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
      int j = arrayOfStackTraceElement.length;
      for (int i = 0; i < j; i++) {
        if (CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(arrayOfStackTraceElement[i].getClassName())) {
          setStackTrace(a);
          return;
        } 
        if (!b.contains(arrayOfStackTraceElement[i].getClassName())) {
          setStackTrace(Arrays.<StackTraceElement>copyOfRange(arrayOfStackTraceElement, i, j));
          return;
        } 
      } 
    }
  }
  
  static class LockGraphNode {
    final Map<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> a;
    
    final Map<LockGraphNode, CycleDetectingLockFactory.PotentialDeadlockException> b;
    
    final String c;
    
    @NullableDecl
    private CycleDetectingLockFactory.ExampleStackTrace a(LockGraphNode param1LockGraphNode, Set<LockGraphNode> param1Set) {
      if (!param1Set.add(this))
        return null; 
      CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = this.a.get(param1LockGraphNode);
      if (exampleStackTrace != null)
        return exampleStackTrace; 
      for (Map.Entry<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> entry : this.a.entrySet()) {
        LockGraphNode lockGraphNode = (LockGraphNode)entry.getKey();
        CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace1 = lockGraphNode.a(param1LockGraphNode, param1Set);
        if (exampleStackTrace1 != null) {
          CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace2 = new CycleDetectingLockFactory.ExampleStackTrace(lockGraphNode, this);
          exampleStackTrace2.setStackTrace(((CycleDetectingLockFactory.ExampleStackTrace)entry.getValue()).getStackTrace());
          exampleStackTrace2.initCause(exampleStackTrace1);
          return exampleStackTrace2;
        } 
      } 
      return null;
    }
    
    String a() {
      return this.c;
    }
    
    void a(CycleDetectingLockFactory.Policy param1Policy, LockGraphNode param1LockGraphNode) {
      boolean bool;
      if (this != param1LockGraphNode) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool, "Attempted to acquire multiple locks with the same rank %s", param1LockGraphNode.a());
      if (this.a.containsKey(param1LockGraphNode))
        return; 
      CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException = this.b.get(param1LockGraphNode);
      if (potentialDeadlockException != null) {
        param1Policy.a(new CycleDetectingLockFactory.PotentialDeadlockException(param1LockGraphNode, this, potentialDeadlockException.a()));
        return;
      } 
      CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = param1LockGraphNode.a(this, Sets.d());
      if (exampleStackTrace == null) {
        this.a.put(param1LockGraphNode, new CycleDetectingLockFactory.ExampleStackTrace(param1LockGraphNode, this));
        return;
      } 
      exampleStackTrace = new CycleDetectingLockFactory.PotentialDeadlockException(param1LockGraphNode, this, exampleStackTrace);
      this.b.put(param1LockGraphNode, exampleStackTrace);
      param1Policy.a((CycleDetectingLockFactory.PotentialDeadlockException)exampleStackTrace);
    }
    
    void a(CycleDetectingLockFactory.Policy param1Policy, List<LockGraphNode> param1List) {
      int j = param1List.size();
      for (int i = 0; i < j; i++)
        a(param1Policy, param1List.get(i)); 
    }
  }
  
  public enum Policies implements Policy {
    a {
      public void a(CycleDetectingLockFactory.PotentialDeadlockException param2PotentialDeadlockException) {
        throw param2PotentialDeadlockException;
      }
    },
    b {
      public void a(CycleDetectingLockFactory.PotentialDeadlockException param2PotentialDeadlockException) {
        CycleDetectingLockFactory.a().log(Level.SEVERE, "Detected potential deadlock", param2PotentialDeadlockException);
      }
    },
    c {
      public void a(CycleDetectingLockFactory.PotentialDeadlockException param2PotentialDeadlockException) {}
    };
  }
  
  enum null {
    public void a(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException) {
      throw param1PotentialDeadlockException;
    }
  }
  
  enum null {
    public void a(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException) {
      CycleDetectingLockFactory.a().log(Level.SEVERE, "Detected potential deadlock", param1PotentialDeadlockException);
    }
  }
  
  enum null {
    public void a(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException) {}
  }
  
  public static interface Policy {
    void a(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException);
  }
  
  public static final class PotentialDeadlockException extends ExampleStackTrace {
    private final CycleDetectingLockFactory.ExampleStackTrace c;
    
    private PotentialDeadlockException(CycleDetectingLockFactory.LockGraphNode param1LockGraphNode1, CycleDetectingLockFactory.LockGraphNode param1LockGraphNode2, CycleDetectingLockFactory.ExampleStackTrace param1ExampleStackTrace) {
      super(param1LockGraphNode1, param1LockGraphNode2);
      this.c = param1ExampleStackTrace;
      initCause(param1ExampleStackTrace);
    }
    
    public CycleDetectingLockFactory.ExampleStackTrace a() {
      return this.c;
    }
    
    public String getMessage() {
      StringBuilder stringBuilder = new StringBuilder(super.getMessage());
      CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = this.c;
      while (exampleStackTrace != null) {
        stringBuilder.append(", ");
        stringBuilder.append(exampleStackTrace.getMessage());
        Throwable throwable = exampleStackTrace.getCause();
      } 
      return stringBuilder.toString();
    }
  }
  
  public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\CycleDetectingLockFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */