package com.amap.api.mapcore2d;

class by extends e {
  private w c;
  
  private w d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private bz l;
  
  private long m;
  
  private int n;
  
  public by(int paramInt1, int paramInt2, w paramw1, w paramw2, int paramInt3, bz parambz) {
    super(paramInt1, paramInt2);
    this.c = paramw1;
    this.d = paramw2;
    this.e = (int)this.c.e();
    this.f = (int)this.c.f();
    this.l = parambz;
    this.i = (int)Math.abs(paramw2.e() - this.c.e());
    this.j = (int)Math.abs(paramw2.f() - this.c.f());
    this.m = System.currentTimeMillis();
    this.n = paramInt1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 > paramInt1) {
      paramInt3 = paramInt1 + paramInt3;
      paramInt1 = paramInt3;
      if (paramInt3 >= paramInt2) {
        this.k = 0;
      } else {
        return paramInt1;
      } 
    } else {
      paramInt3 = paramInt1 - paramInt3;
      paramInt1 = paramInt3;
      if (paramInt3 <= paramInt2) {
        this.k = 0;
      } else {
        return paramInt1;
      } 
    } 
    return paramInt2;
  }
  
  private void b(int paramInt) {
    long l = System.currentTimeMillis();
    int i = (int)(l - this.m);
    this.m = l;
    float f = i / paramInt;
    this.g = (int)(this.i * f);
    this.h = (int)(this.j * f);
  }
  
  protected void a() {
    b(this.n);
    int i = (int)this.d.e();
    int j = (int)this.d.f();
    if (!f()) {
      this.e = i;
      this.f = j;
      this.l.a(new w(this.f, this.e, false));
      return;
    } 
    this.k++;
    this.e = a(this.e, i, this.g);
    this.f = a(this.f, j, this.h);
    this.l.a(new w(this.f, this.e, false));
    if (this.e == i && this.f == j) {
      a(false);
      b(true);
      g();
    } 
  }
  
  protected void b() {
    this.l.c();
    n.a().b();
  }
  
  protected void c() {
    this.l.c();
    l.a().b();
  }
  
  protected void g() {
    bm.a().b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */