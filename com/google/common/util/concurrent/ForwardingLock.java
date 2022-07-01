package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

abstract class ForwardingLock implements Lock {
  abstract Lock a();
  
  public void lock() {
    a().lock();
  }
  
  public void lockInterruptibly() throws InterruptedException {
    a().lockInterruptibly();
  }
  
  public Condition newCondition() {
    return a().newCondition();
  }
  
  public boolean tryLock() {
    return a().tryLock();
  }
  
  public boolean tryLock(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return a().tryLock(paramLong, paramTimeUnit);
  }
  
  public void unlock() {
    a().unlock();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */