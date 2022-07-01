package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;

final class l {
  private final CountDownLatch a = new CountDownLatch(1);
  
  private long b = -1L;
  
  private long c = -1L;
  
  void a() {
    if (this.b == -1L) {
      this.b = System.nanoTime();
      return;
    } 
    throw new IllegalStateException();
  }
  
  void b() {
    if (this.c == -1L && this.b != -1L) {
      this.c = System.nanoTime();
      this.a.countDown();
      return;
    } 
    throw new IllegalStateException();
  }
  
  void c() {
    if (this.c == -1L) {
      long l1 = this.b;
      if (l1 != -1L) {
        this.c = l1 - 1L;
        this.a.countDown();
        return;
      } 
    } 
    throw new IllegalStateException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */