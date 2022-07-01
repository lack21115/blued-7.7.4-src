package com.amap.api.mapcore2d;

import java.net.Proxy;

public class et {
  private eu a;
  
  private ew b;
  
  public et(ew paramew) {
    this(paramew, 0L, -1L);
  }
  
  public et(ew paramew, long paramLong1, long paramLong2) {
    this(paramew, paramLong1, paramLong2, false);
  }
  
  public et(ew paramew, long paramLong1, long paramLong2, boolean paramBoolean) {
    Proxy proxy;
    this.b = paramew;
    if (paramew.e == null) {
      paramew = null;
    } else {
      proxy = paramew.e;
    } 
    this.a = new eu(this.b.c, this.b.d, proxy, paramBoolean);
    this.a.b(paramLong2);
    this.a.a(paramLong1);
  }
  
  public void a(a parama) {
    this.a.a(this.b.h(), this.b.n(), this.b.m(), this.b.f(), this.b.g(), this.b.a_(), parama);
  }
  
  public static interface a {
    void a(Throwable param1Throwable);
    
    void a(byte[] param1ArrayOfbyte, long param1Long);
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */