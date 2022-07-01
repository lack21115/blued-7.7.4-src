package com.qq.e.comm.plugin.j.b;

import com.qq.e.comm.plugin.j.b.a.a;
import com.qq.e.comm.plugin.j.b.a.b;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class m implements h {
  private final String a;
  
  private final File b;
  
  private final long c;
  
  private final long d;
  
  private final b e;
  
  private int f;
  
  private String g;
  
  private a h;
  
  private AtomicBoolean i = new AtomicBoolean(false);
  
  public m(String paramString, File paramFile, long paramLong1, long paramLong2, b paramb) {
    this.a = paramString;
    this.b = paramFile;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramb;
  }
  
  public int a(c paramc) {
    long l1 = this.c + this.b.length();
    long l2 = this.d - this.b.length();
    if (l2 == 0L) {
      paramc.a(this.b.length());
      return 0;
    } 
    try {
      boolean bool = this.i.get();
      if (bool)
        return 0; 
      this.h = this.e.a(this.a, l1, l2);
    } finally {
      paramc = null;
    } 
    this.h.f();
    return this.f;
  }
  
  public String a() {
    return this.g;
  }
  
  public int b() {
    return this.f;
  }
  
  public void c() {
    this.i.compareAndSet(false, true);
    a a1 = this.h;
    if (a1 != null)
      a1.f(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */