package com.ss.android.socialbase.downloader.i;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class g {
  private static final String a = g.class.getSimpleName();
  
  private final b b = new b(0.05D);
  
  private volatile boolean c = false;
  
  private final AtomicReference<h> d = new AtomicReference<h>(h.e);
  
  private AtomicReference<h> e;
  
  private final ArrayList<b> f = new ArrayList<b>();
  
  private int g;
  
  private g() {}
  
  public static g a() {
    return a.a;
  }
  
  private h a(double paramDouble) {
    return (paramDouble < 0.0D) ? h.e : ((paramDouble < 150.0D) ? h.a : ((paramDouble < 550.0D) ? h.b : ((paramDouble < 2000.0D) ? h.c : h.d)));
  }
  
  private boolean c() {
    if (this.b == null)
      return false; 
    try {
      h h = this.d.get();
      int i = null.a[h.ordinal()];
      double d1 = 2000.0D;
      double d2 = 550.0D;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4)
              return true; 
            d2 = 3.4028234663852886E38D;
          } else {
            d1 = 550.0D;
            d2 = 2000.0D;
          } 
        } else {
          d1 = 150.0D;
        } 
      } else {
        d1 = 0.0D;
        d2 = 150.0D;
      } 
      double d3 = this.b.a();
    } finally {
      Exception exception = null;
    } 
    return false;
  }
  
  private void d() {
    try {
      int i;
      int j = this.f.size();
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(long paramLong1, long paramLong2) {
    /* monitor enter ThisExpression{ObjectType{com/ss/android/socialbase/downloader/i/g}} */
    double d = paramLong1 * 1.0D / paramLong2 * 8.0D;
    if (paramLong2 == 0L || d < 3.0D) {
      /* monitor exit ThisExpression{ObjectType{com/ss/android/socialbase/downloader/i/g}} */
      return;
    } 
    try {
      this.b.a(d);
      h h = b();
      if (this.c) {
        this.g++;
        if (h != this.e.get()) {
          this.c = false;
          this.g = 1;
        } 
        if (this.g >= 5.0D && c()) {
          this.c = false;
          this.g = 1;
          this.d.set(this.e.get());
          d();
        } 
        /* monitor exit ThisExpression{ObjectType{com/ss/android/socialbase/downloader/i/g}} */
        return;
      } 
      if (this.d.get() != h) {
        this.c = true;
        this.e = new AtomicReference<h>(h);
      } 
    } finally {
      Exception exception;
    } 
    /* monitor exit ThisExpression{ObjectType{com/ss/android/socialbase/downloader/i/g}} */
  }
  
  public h b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/ss/android/socialbase/downloader/i/b;
    //   6: ifnonnull -> 17
    //   9: getstatic com/ss/android/socialbase/downloader/i/h.e : Lcom/ss/android/socialbase/downloader/i/h;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: aload_0
    //   19: getfield b : Lcom/ss/android/socialbase/downloader/i/b;
    //   22: invokevirtual a : ()D
    //   25: invokespecial a : (D)Lcom/ss/android/socialbase/downloader/i/h;
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual printStackTrace : ()V
    //   38: getstatic com/ss/android/socialbase/downloader/i/h.e : Lcom/ss/android/socialbase/downloader/i/h;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	46	finally
    //   17	29	33	finally
    //   34	42	46	finally
  }
  
  static class a {
    public static final g a = new g();
  }
  
  public static interface b {
    void a(h param1h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */