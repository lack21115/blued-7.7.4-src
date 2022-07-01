package com.qq.e.comm.plugin.ad;

public enum d {
  a(e.a, 240, 38),
  b(e.a, 320, 50),
  c(e.a, 480, 75),
  d(e.a, 640, 100),
  e(e.b, 300, 250),
  f(e.b, 600, 500),
  g(e.c, 72, 72),
  h(e.d, 320, 480),
  i(e.d, 640, 960),
  j(e.e, 1000, 560);
  
  private e k;
  
  private int l;
  
  private int m;
  
  d(e parame, int paramInt1, int paramInt2) {
    this.k = parame;
    this.l = paramInt1;
    this.m = paramInt2;
  }
  
  public int a() {
    return this.l;
  }
  
  public int b() {
    return this.m;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */