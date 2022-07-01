package com.qq.e.comm.plugin.j.b;

import com.qq.e.comm.plugin.j.f;

class g implements d, f {
  private final long a;
  
  private final int b;
  
  private final c[] c;
  
  private f d;
  
  public g(long paramLong, long[] paramArrayOflong1, long[] paramArrayOflong2) {
    this.a = paramLong;
    this.b = paramArrayOflong1.length;
    this.c = new c[this.b];
    int i;
    for (i = 0; i < this.b; i++) {
      this.c[i] = new i(paramArrayOflong1[i], paramArrayOflong2[i]);
      this.c[i].a(this);
    } 
  }
  
  public long a() {
    c[] arrayOfC = this.c;
    int j = arrayOfC.length;
    long l = 0L;
    for (int i = 0; i < j; i++)
      l += arrayOfC[i].a(); 
    return l;
  }
  
  public c a(int paramInt) {
    return (paramInt >= 0 && paramInt < this.b) ? this.c[paramInt] : null;
  }
  
  public void a(long paramLong1, long paramLong2) {
    f f1 = this.d;
    if (f1 != null)
      f1.a(a(), b()); 
  }
  
  public void a(f paramf) {
    this.d = paramf;
  }
  
  public long b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */