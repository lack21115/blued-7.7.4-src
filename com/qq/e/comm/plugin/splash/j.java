package com.qq.e.comm.plugin.splash;

import java.util.concurrent.atomic.AtomicInteger;

class j {
  private final AtomicInteger a = new AtomicInteger(0);
  
  boolean a() {
    int i = this.a.get();
    return (i == 1 || i == 3 || i == 5) ? false : this.a.compareAndSet(i, 1);
  }
  
  boolean b() {
    return this.a.compareAndSet(1, 2);
  }
  
  boolean c() {
    return this.a.compareAndSet(2, 3);
  }
  
  boolean d() {
    return this.a.compareAndSet(3, 4);
  }
  
  boolean e() {
    int i = this.a.get();
    return (i == 4) ? false : this.a.compareAndSet(i, 4);
  }
  
  boolean f() {
    return this.a.compareAndSet(1, 5);
  }
  
  boolean g() {
    return this.a.compareAndSet(3, 1);
  }
  
  boolean h() {
    return this.a.compareAndSet(3, 2);
  }
  
  boolean i() {
    return (this.a.get() == 1);
  }
  
  boolean j() {
    return (this.a.get() == 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */