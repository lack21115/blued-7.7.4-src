package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

abstract class ForwardingCondition implements Condition {
  abstract Condition a();
  
  public void await() throws InterruptedException {
    a().await();
  }
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return a().await(paramLong, paramTimeUnit);
  }
  
  public long awaitNanos(long paramLong) throws InterruptedException {
    return a().awaitNanos(paramLong);
  }
  
  public void awaitUninterruptibly() {
    a().awaitUninterruptibly();
  }
  
  public boolean awaitUntil(Date paramDate) throws InterruptedException {
    return a().awaitUntil(paramDate);
  }
  
  public void signal() {
    a().signal();
  }
  
  public void signalAll() {
    a().signalAll();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */