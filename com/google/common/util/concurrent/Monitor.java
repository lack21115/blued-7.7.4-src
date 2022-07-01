package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Monitor {
  private final boolean a;
  
  private final ReentrantLock b;
  
  private Guard c = null;
  
  public Monitor() {
    this(false);
  }
  
  public Monitor(boolean paramBoolean) {
    this.a = paramBoolean;
    this.b = new ReentrantLock(paramBoolean);
  }
  
  private boolean a(Guard paramGuard) {
    try {
      return paramGuard.a();
    } finally {
      e();
    } 
  }
  
  private void d() {
    for (Guard guard = this.c; guard != null; guard = guard.e) {
      if (a(guard)) {
        guard.c.signal();
        return;
      } 
    } 
  }
  
  private void e() {
    for (Guard guard = this.c; guard != null; guard = guard.e)
      guard.c.signalAll(); 
  }
  
  public void a() {
    this.b.lock();
  }
  
  public void b() {
    ReentrantLock reentrantLock = this.b;
    try {
      if (reentrantLock.getHoldCount() == 1)
        d(); 
      return;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public boolean c() {
    return this.b.isHeldByCurrentThread();
  }
  
  public static abstract class Guard {
    final Monitor b;
    
    final Condition c;
    
    int d = 0;
    
    @NullableDecl
    Guard e;
    
    protected Guard(Monitor param1Monitor) {
      this.b = (Monitor)Preconditions.a(param1Monitor, "monitor");
      this.c = Monitor.a(param1Monitor).newCondition();
    }
    
    public abstract boolean a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Monitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */