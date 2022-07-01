package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Striped<L> {
  private static final Supplier<ReadWriteLock> a = new Supplier<ReadWriteLock>() {
      public ReadWriteLock a() {
        return new ReentrantReadWriteLock();
      }
    };
  
  private static final Supplier<ReadWriteLock> b = new Supplier<ReadWriteLock>() {
      public ReadWriteLock a() {
        return new Striped.WeakSafeReadWriteLock();
      }
    };
  
  static class CompactStriped<L> extends PowerOfTwoStriped<L> {}
  
  static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {}
  
  static class PaddedLock extends ReentrantLock {
    PaddedLock() {
      super(false);
    }
  }
  
  static class PaddedSemaphore extends Semaphore {
    PaddedSemaphore(int param1Int) {
      super(param1Int, false);
    }
  }
  
  static abstract class PowerOfTwoStriped<L> extends Striped<L> {}
  
  static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
    static final class ArrayReference<L> extends WeakReference<L> {}
  }
  
  static final class ArrayReference<L> extends WeakReference<L> {}
  
  static final class WeakSafeCondition extends ForwardingCondition {
    private final Condition a;
    
    private final Striped.WeakSafeReadWriteLock b;
    
    WeakSafeCondition(Condition param1Condition, Striped.WeakSafeReadWriteLock param1WeakSafeReadWriteLock) {
      this.a = param1Condition;
      this.b = param1WeakSafeReadWriteLock;
    }
    
    Condition a() {
      return this.a;
    }
  }
  
  static final class WeakSafeLock extends ForwardingLock {
    private final Lock a;
    
    private final Striped.WeakSafeReadWriteLock b;
    
    WeakSafeLock(Lock param1Lock, Striped.WeakSafeReadWriteLock param1WeakSafeReadWriteLock) {
      this.a = param1Lock;
      this.b = param1WeakSafeReadWriteLock;
    }
    
    Lock a() {
      return this.a;
    }
    
    public Condition newCondition() {
      return new Striped.WeakSafeCondition(this.a.newCondition(), this.b);
    }
  }
  
  static final class WeakSafeReadWriteLock implements ReadWriteLock {
    private final ReadWriteLock a = new ReentrantReadWriteLock();
    
    public Lock readLock() {
      return new Striped.WeakSafeLock(this.a.readLock(), this);
    }
    
    public Lock writeLock() {
      return new Striped.WeakSafeLock(this.a.writeLock(), this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Striped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */