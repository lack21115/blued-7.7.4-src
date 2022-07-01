package com.ss.android.socialbase.downloader.j;

import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.m.f;
import java.io.InputStream;
import java.util.concurrent.Future;

public class a implements c {
  private final InputStream a;
  
  private final int b;
  
  private final int c;
  
  private final Object d = new Object();
  
  private final Object e = new Object();
  
  private b f;
  
  private b g;
  
  private b h;
  
  private b i;
  
  private b j;
  
  private b k;
  
  private volatile boolean l;
  
  private volatile boolean m;
  
  private volatile Throwable n;
  
  private volatile Future o;
  
  private int p;
  
  private final Runnable q = new Runnable(this) {
      public void run() {
        // Byte code:
        //   0: bipush #10
        //   2: invokestatic setThreadPriority : (I)V
        //   5: aload_0
        //   6: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   9: invokestatic a : (Lcom/ss/android/socialbase/downloader/j/a;)Lcom/ss/android/socialbase/downloader/j/b;
        //   12: astore_2
        //   13: aload_2
        //   14: aload_0
        //   15: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   18: invokestatic b : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/io/InputStream;
        //   21: aload_2
        //   22: getfield a : [B
        //   25: invokevirtual read : ([B)I
        //   28: putfield b : I
        //   31: aload_0
        //   32: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   35: aload_2
        //   36: invokestatic a : (Lcom/ss/android/socialbase/downloader/j/a;Lcom/ss/android/socialbase/downloader/j/b;)V
        //   39: aload_2
        //   40: getfield b : I
        //   43: istore_1
        //   44: iload_1
        //   45: iconst_m1
        //   46: if_icmpne -> 5
        //   49: aload_0
        //   50: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   53: invokestatic c : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/lang/Object;
        //   56: astore_2
        //   57: aload_2
        //   58: monitorenter
        //   59: aload_0
        //   60: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   63: iconst_1
        //   64: invokestatic a : (Lcom/ss/android/socialbase/downloader/j/a;Z)Z
        //   67: pop
        //   68: aload_0
        //   69: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   72: invokestatic c : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/lang/Object;
        //   75: invokevirtual notify : ()V
        //   78: aload_2
        //   79: monitorexit
        //   80: aload_0
        //   81: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   84: astore_2
        //   85: aload_2
        //   86: invokestatic b : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/io/InputStream;
        //   89: invokevirtual close : ()V
        //   92: return
        //   93: astore_3
        //   94: aload_2
        //   95: monitorexit
        //   96: aload_3
        //   97: athrow
        //   98: astore_2
        //   99: aload_0
        //   100: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   103: aload_2
        //   104: invokestatic a : (Lcom/ss/android/socialbase/downloader/j/a;Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   107: pop
        //   108: aload_2
        //   109: invokevirtual printStackTrace : ()V
        //   112: aload_0
        //   113: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   116: invokestatic c : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/lang/Object;
        //   119: astore_2
        //   120: aload_2
        //   121: monitorenter
        //   122: aload_0
        //   123: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   126: iconst_1
        //   127: invokestatic a : (Lcom/ss/android/socialbase/downloader/j/a;Z)Z
        //   130: pop
        //   131: aload_0
        //   132: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   135: invokestatic c : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/lang/Object;
        //   138: invokevirtual notify : ()V
        //   141: aload_2
        //   142: monitorexit
        //   143: aload_0
        //   144: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   147: astore_2
        //   148: goto -> 85
        //   151: astore_3
        //   152: aload_2
        //   153: monitorexit
        //   154: aload_3
        //   155: athrow
        //   156: astore_2
        //   157: aload_0
        //   158: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   161: invokestatic c : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/lang/Object;
        //   164: astore_3
        //   165: aload_3
        //   166: monitorenter
        //   167: aload_0
        //   168: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   171: iconst_1
        //   172: invokestatic a : (Lcom/ss/android/socialbase/downloader/j/a;Z)Z
        //   175: pop
        //   176: aload_0
        //   177: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   180: invokestatic c : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/lang/Object;
        //   183: invokevirtual notify : ()V
        //   186: aload_3
        //   187: monitorexit
        //   188: aload_0
        //   189: getfield a : Lcom/ss/android/socialbase/downloader/j/a;
        //   192: invokestatic b : (Lcom/ss/android/socialbase/downloader/j/a;)Ljava/io/InputStream;
        //   195: invokevirtual close : ()V
        //   198: aload_2
        //   199: athrow
        //   200: astore_2
        //   201: aload_3
        //   202: monitorexit
        //   203: aload_2
        //   204: athrow
        //   205: astore_2
        //   206: return
        //   207: astore_3
        //   208: goto -> 198
        // Exception table:
        //   from	to	target	type
        //   5	44	98	finally
        //   59	80	93	finally
        //   80	85	205	finally
        //   85	92	205	finally
        //   94	96	93	finally
        //   99	112	156	finally
        //   122	143	151	finally
        //   143	148	205	finally
        //   152	154	151	finally
        //   167	188	200	finally
        //   188	198	207	finally
        //   201	203	200	finally
      }
    };
  
  public a(InputStream paramInputStream, int paramInt1, int paramInt2) throws Throwable {
    this.a = paramInputStream;
    this.b = paramInt1;
    paramInt1 = 64;
    if (paramInt2 < 1) {
      paramInt1 = 1;
    } else if (paramInt2 <= 64) {
      paramInt1 = paramInt2;
    } 
    this.c = paramInt1;
    c();
  }
  
  private void b(b paramb) {
    synchronized (this.d) {
      b b1 = this.g;
      if (b1 == null) {
        this.g = paramb;
        this.f = paramb;
        this.d.notify();
      } else {
        b1.c = paramb;
        this.g = paramb;
      } 
      return;
    } 
  }
  
  private void c() throws Throwable {
    this.o = b.l().submit(this.q);
  }
  
  private void c(b paramb) {
    synchronized (this.e) {
      b b1 = this.j;
      if (b1 == null) {
        this.j = paramb;
        this.i = paramb;
        this.e.notify();
      } else {
        b1.c = paramb;
        this.j = paramb;
      } 
      return;
    } 
  }
  
  private b d() throws d, InterruptedException {
    null = this.h;
    if (null != null) {
      if (!this.l) {
        this.h = null.c;
        null.c = null;
        return null;
      } 
      throw new d();
    } 
    synchronized (this.d) {
      if (!this.l) {
        b b1 = this.f;
        null = b1;
        if (b1 == null) {
          null = b1;
          if (this.p < this.c) {
            this.p++;
            null = new b(this.b);
            return null;
          } 
        } 
        while (null == null) {
          this.d.wait();
          if (!this.l) {
            null = this.f;
            continue;
          } 
          throw new d();
        } 
        this.h = null.c;
        this.g = null;
        this.f = null;
        null.c = null;
        return null;
      } 
      throw new d();
    } 
  }
  
  private b e() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
    null = this.k;
    if (null != null) {
      this.k = null.c;
      null.c = null;
      return null;
    } 
    synchronized (this.e) {
      b b1 = this.i;
      null = b1;
      if (b1 == null)
        do {
          if (this.m)
            f(); 
          this.e.wait();
          null = this.i;
        } while (null == null); 
      this.k = null.c;
      this.j = null;
      this.i = null;
      null.c = null;
      return null;
    } 
  }
  
  private void f() throws com.ss.android.socialbase.downloader.e.a {
    Throwable throwable = this.n;
    if (throwable != null) {
      if (throwable instanceof d)
        throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!"); 
      f.a(throwable, "async_read");
    } 
    throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
  }
  
  public b a() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
    return e();
  }
  
  public void a(b paramb) {
    b(paramb);
  }
  
  public void b() {
    synchronized (this.d) {
      this.l = true;
      this.d.notify();
      null = this.o;
      if (null != null) {
        try {
          null.cancel(true);
        } finally {}
        this.o = null;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */