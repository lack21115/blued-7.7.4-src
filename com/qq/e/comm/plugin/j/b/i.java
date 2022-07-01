package com.qq.e.comm.plugin.j.b;

import com.qq.e.comm.plugin.j.f;

class i implements c {
  private final long a;
  
  private volatile long b;
  
  private f c;
  
  public i(long paramLong1, long paramLong2) {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public long a() {
    return this.b;
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
    f f1 = this.c;
    if (f1 != null)
      f1.a(a(), b()); 
  }
  
  public void a(f paramf) {
    this.c = paramf;
  }
  
  public long b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */