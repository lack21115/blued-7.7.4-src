package com.bytedance.tea.crash.f;

import android.os.Handler;

public abstract class a implements Runnable {
  private Handler a;
  
  private final long b;
  
  private final long c;
  
  a(Handler paramHandler, long paramLong1, long paramLong2) {
    this.a = paramHandler;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  void a() {
    if (b() > 0L) {
      this.a.postDelayed(this, b());
      return;
    } 
    this.a.post(this);
  }
  
  void a(long paramLong) {
    if (paramLong > 0L) {
      this.a.postDelayed(this, paramLong);
      return;
    } 
    this.a.post(this);
  }
  
  long b() {
    return this.b;
  }
  
  long c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */