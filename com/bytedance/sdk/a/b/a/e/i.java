package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

public final class i {
  long a = 0L;
  
  long b;
  
  final int c;
  
  final g d;
  
  final a e;
  
  final c f = new c(this);
  
  final c g = new c(this);
  
  b h = null;
  
  private final List<c> j;
  
  private List<c> k;
  
  private boolean l;
  
  private final b m;
  
  i(int paramInt, g paramg, boolean paramBoolean1, boolean paramBoolean2, List<c> paramList) {
    if (paramg != null) {
      if (paramList != null) {
        this.c = paramInt;
        this.d = paramg;
        this.b = paramg.m.d();
        this.m = new b(this, paramg.l.d());
        this.e = new a(this);
        this.m.b = paramBoolean2;
        this.e.b = paramBoolean1;
        this.j = paramList;
        return;
      } 
      throw new NullPointerException("requestHeaders == null");
    } 
    throw new NullPointerException("connection == null");
  }
  
  private boolean d(b paramb) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/a/b/a/e/i.i : Z
    //   3: ifne -> 24
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifne -> 16
    //   13: goto -> 24
    //   16: new java/lang/AssertionError
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: athrow
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   30: ifnull -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: getfield m : Lcom/bytedance/sdk/a/b/a/e/i$b;
    //   41: getfield b : Z
    //   44: ifeq -> 61
    //   47: aload_0
    //   48: getfield e : Lcom/bytedance/sdk/a/b/a/e/i$a;
    //   51: getfield b : Z
    //   54: ifeq -> 61
    //   57: aload_0
    //   58: monitorexit
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: aload_1
    //   63: putfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   66: aload_0
    //   67: invokevirtual notifyAll : ()V
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield d : Lcom/bytedance/sdk/a/b/a/e/g;
    //   76: aload_0
    //   77: getfield c : I
    //   80: invokevirtual b : (I)Lcom/bytedance/sdk/a/b/a/e/i;
    //   83: pop
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   26	35	86	finally
    //   37	59	86	finally
    //   61	72	86	finally
    //   87	89	86	finally
  }
  
  public int a() {
    return this.c;
  }
  
  void a(long paramLong) {
    this.b += paramLong;
    if (paramLong > 0L)
      notifyAll(); 
  }
  
  void a(e parame, int paramInt) throws IOException {
    if (i || !Thread.holdsLock(this)) {
      this.m.a(parame, paramInt);
      return;
    } 
    throw new AssertionError();
  }
  
  public void a(b paramb) throws IOException {
    if (!d(paramb))
      return; 
    this.d.b(this.c, paramb);
  }
  
  void a(List<c> paramList) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/a/b/a/e/i.i : Z
    //   3: ifne -> 24
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifne -> 16
    //   13: goto -> 24
    //   16: new java/lang/AssertionError
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: athrow
    //   24: aload_0
    //   25: monitorenter
    //   26: iconst_1
    //   27: istore_2
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield l : Z
    //   33: aload_0
    //   34: getfield k : Ljava/util/List;
    //   37: ifnonnull -> 57
    //   40: aload_0
    //   41: aload_1
    //   42: putfield k : Ljava/util/List;
    //   45: aload_0
    //   46: invokevirtual b : ()Z
    //   49: istore_2
    //   50: aload_0
    //   51: invokevirtual notifyAll : ()V
    //   54: goto -> 97
    //   57: new java/util/ArrayList
    //   60: dup
    //   61: invokespecial <init> : ()V
    //   64: astore_3
    //   65: aload_3
    //   66: aload_0
    //   67: getfield k : Ljava/util/List;
    //   70: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   75: pop
    //   76: aload_3
    //   77: aconst_null
    //   78: invokeinterface add : (Ljava/lang/Object;)Z
    //   83: pop
    //   84: aload_3
    //   85: aload_1
    //   86: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   91: pop
    //   92: aload_0
    //   93: aload_3
    //   94: putfield k : Ljava/util/List;
    //   97: aload_0
    //   98: monitorexit
    //   99: iload_2
    //   100: ifne -> 115
    //   103: aload_0
    //   104: getfield d : Lcom/bytedance/sdk/a/b/a/e/g;
    //   107: aload_0
    //   108: getfield c : I
    //   111: invokevirtual b : (I)Lcom/bytedance/sdk/a/b/a/e/i;
    //   114: pop
    //   115: return
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Exception table:
    //   from	to	target	type
    //   28	54	116	finally
    //   57	97	116	finally
    //   97	99	116	finally
    //   117	119	116	finally
  }
  
  public void b(b paramb) {
    if (!d(paramb))
      return; 
    this.d.a(this.c, paramb);
  }
  
  public boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield m : Lcom/bytedance/sdk/a/b/a/e/i$b;
    //   19: getfield b : Z
    //   22: ifne -> 35
    //   25: aload_0
    //   26: getfield m : Lcom/bytedance/sdk/a/b/a/e/i$b;
    //   29: getfield a : Z
    //   32: ifeq -> 68
    //   35: aload_0
    //   36: getfield e : Lcom/bytedance/sdk/a/b/a/e/i$a;
    //   39: getfield b : Z
    //   42: ifne -> 55
    //   45: aload_0
    //   46: getfield e : Lcom/bytedance/sdk/a/b/a/e/i$a;
    //   49: getfield a : Z
    //   52: ifeq -> 68
    //   55: aload_0
    //   56: getfield l : Z
    //   59: istore_1
    //   60: iload_1
    //   61: ifeq -> 68
    //   64: aload_0
    //   65: monitorexit
    //   66: iconst_0
    //   67: ireturn
    //   68: aload_0
    //   69: monitorexit
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   15	35	72	finally
    //   35	55	72	finally
    //   55	60	72	finally
  }
  
  void c(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   6: ifnonnull -> 18
    //   9: aload_0
    //   10: aload_1
    //   11: putfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   14: aload_0
    //   15: invokevirtual notifyAll : ()V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public boolean c() {
    boolean bool;
    if ((this.c & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    return (this.d.b == bool);
  }
  
  public List<c> d() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual c : ()Z
    //   6: ifeq -> 84
    //   9: aload_0
    //   10: getfield f : Lcom/bytedance/sdk/a/b/a/e/i$c;
    //   13: invokevirtual a : ()V
    //   16: aload_0
    //   17: getfield k : Ljava/util/List;
    //   20: ifnonnull -> 37
    //   23: aload_0
    //   24: getfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   27: ifnonnull -> 37
    //   30: aload_0
    //   31: invokevirtual l : ()V
    //   34: goto -> 16
    //   37: aload_0
    //   38: getfield f : Lcom/bytedance/sdk/a/b/a/e/i$c;
    //   41: invokevirtual h : ()V
    //   44: aload_0
    //   45: getfield k : Ljava/util/List;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull -> 62
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield k : Ljava/util/List;
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: areturn
    //   62: new com/bytedance/sdk/a/b/a/e/o
    //   65: dup
    //   66: aload_0
    //   67: getfield h : Lcom/bytedance/sdk/a/b/a/e/b;
    //   70: invokespecial <init> : (Lcom/bytedance/sdk/a/b/a/e/b;)V
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: getfield f : Lcom/bytedance/sdk/a/b/a/e/i$c;
    //   79: invokevirtual h : ()V
    //   82: aload_1
    //   83: athrow
    //   84: new java/lang/IllegalStateException
    //   87: dup
    //   88: ldc 'servers cannot read response headers'
    //   90: invokespecial <init> : (Ljava/lang/String;)V
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	94	finally
    //   16	34	74	finally
    //   37	49	94	finally
    //   53	58	94	finally
    //   62	74	94	finally
    //   75	84	94	finally
    //   84	94	94	finally
  }
  
  public t e() {
    return (t)this.f;
  }
  
  public t f() {
    return (t)this.g;
  }
  
  public s g() {
    return this.m;
  }
  
  public r h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Z
    //   6: ifne -> 29
    //   9: aload_0
    //   10: invokevirtual c : ()Z
    //   13: ifeq -> 19
    //   16: goto -> 29
    //   19: new java/lang/IllegalStateException
    //   22: dup
    //   23: ldc 'reply before requesting the sink'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield e : Lcom/bytedance/sdk/a/b/a/e/i$a;
    //   35: areturn
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	36	finally
    //   19	29	36	finally
    //   29	31	36	finally
    //   37	39	36	finally
  }
  
  void i() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/a/b/a/e/i.i : Z
    //   3: ifne -> 24
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifne -> 16
    //   13: goto -> 24
    //   16: new java/lang/AssertionError
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: athrow
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield m : Lcom/bytedance/sdk/a/b/a/e/i$b;
    //   30: iconst_1
    //   31: putfield b : Z
    //   34: aload_0
    //   35: invokevirtual b : ()Z
    //   38: istore_1
    //   39: aload_0
    //   40: invokevirtual notifyAll : ()V
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_1
    //   46: ifne -> 61
    //   49: aload_0
    //   50: getfield d : Lcom/bytedance/sdk/a/b/a/e/g;
    //   53: aload_0
    //   54: getfield c : I
    //   57: invokevirtual b : (I)Lcom/bytedance/sdk/a/b/a/e/i;
    //   60: pop
    //   61: return
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   26	45	62	finally
    //   63	65	62	finally
  }
  
  void j() throws IOException {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/a/b/a/e/i.i : Z
    //   3: ifne -> 24
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifne -> 16
    //   13: goto -> 24
    //   16: new java/lang/AssertionError
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: athrow
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield m : Lcom/bytedance/sdk/a/b/a/e/i$b;
    //   30: getfield b : Z
    //   33: ifne -> 115
    //   36: aload_0
    //   37: getfield m : Lcom/bytedance/sdk/a/b/a/e/i$b;
    //   40: getfield a : Z
    //   43: ifeq -> 115
    //   46: aload_0
    //   47: getfield e : Lcom/bytedance/sdk/a/b/a/e/i$a;
    //   50: getfield b : Z
    //   53: ifne -> 110
    //   56: aload_0
    //   57: getfield e : Lcom/bytedance/sdk/a/b/a/e/i$a;
    //   60: getfield a : Z
    //   63: ifeq -> 115
    //   66: goto -> 110
    //   69: aload_0
    //   70: invokevirtual b : ()Z
    //   73: istore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: iload_1
    //   77: ifeq -> 88
    //   80: aload_0
    //   81: getstatic com/bytedance/sdk/a/b/a/e/b.f : Lcom/bytedance/sdk/a/b/a/e/b;
    //   84: invokevirtual a : (Lcom/bytedance/sdk/a/b/a/e/b;)V
    //   87: return
    //   88: iload_2
    //   89: ifne -> 104
    //   92: aload_0
    //   93: getfield d : Lcom/bytedance/sdk/a/b/a/e/g;
    //   96: aload_0
    //   97: getfield c : I
    //   100: invokevirtual b : (I)Lcom/bytedance/sdk/a/b/a/e/i;
    //   103: pop
    //   104: return
    //   105: astore_3
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_3
    //   109: athrow
    //   110: iconst_1
    //   111: istore_1
    //   112: goto -> 69
    //   115: iconst_0
    //   116: istore_1
    //   117: goto -> 69
    // Exception table:
    //   from	to	target	type
    //   26	66	105	finally
    //   69	76	105	finally
    //   106	108	105	finally
  }
  
  void k() throws IOException {
    if (!this.e.a) {
      if (!this.e.b) {
        b b1 = this.h;
        if (b1 == null)
          return; 
        throw new o(b1);
      } 
      throw new IOException("stream finished");
    } 
    throw new IOException("stream closed");
  }
  
  void l() throws InterruptedIOException {
    try {
      wait();
      return;
    } catch (InterruptedException interruptedException) {
      throw new InterruptedIOException();
    } 
  }
  
  final class a implements r {
    boolean a;
    
    boolean b;
    
    private final com.bytedance.sdk.a.a.c e = new com.bytedance.sdk.a.a.c();
    
    a(i this$0) {}
    
    private void a(boolean param1Boolean) throws IOException {
      synchronized (this.d) {
        this.d.g.a();
        try {
          while (this.d.b <= 0L && !this.b && !this.a && this.d.h == null)
            this.d.l(); 
          this.d.g.h();
          this.d.k();
          long l = Math.min(this.d.b, this.e.b());
          i i1 = this.d;
          i1.b -= l;
          this.d.g.a();
        } finally {
          this.d.g.h();
        } 
      } 
    }
    
    public t a() {
      return (t)this.d.g;
    }
    
    public void a_(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (c || !Thread.holdsLock(this.d)) {
        this.e.a_(param1c, param1Long);
        while (this.e.b() >= 16384L)
          a(false); 
        return;
      } 
      throw new AssertionError();
    }
    
    public void close() throws IOException {
      if (c || !Thread.holdsLock(this.d))
        synchronized (this.d) {
          if (this.a)
            return; 
          if (!this.d.e.b)
            if (this.e.b() > 0L) {
              while (this.e.b() > 0L)
                a(true); 
            } else {
              this.d.d.a(this.d.c, true, (com.bytedance.sdk.a.a.c)null, 0L);
            }  
          synchronized (this.d) {
            this.a = true;
            this.d.d.b();
            this.d.j();
            return;
          } 
        }  
      throw new AssertionError();
    }
    
    public void flush() throws IOException {
      if (c || !Thread.holdsLock(this.d))
        synchronized (this.d) {
          this.d.k();
          while (this.e.b() > 0L) {
            a(false);
            this.d.d.b();
          } 
          return;
        }  
      throw new AssertionError();
    }
  }
  
  final class b implements s {
    boolean a;
    
    boolean b;
    
    private final com.bytedance.sdk.a.a.c e = new com.bytedance.sdk.a.a.c();
    
    private final com.bytedance.sdk.a.a.c f = new com.bytedance.sdk.a.a.c();
    
    private final long g;
    
    b(i this$0, long param1Long) {
      this.g = param1Long;
    }
    
    private void b() throws IOException {
      this.d.f.a();
      try {
        while (this.f.b() == 0L && !this.b && !this.a && this.d.h == null)
          this.d.l(); 
        return;
      } finally {
        this.d.f.h();
      } 
    }
    
    private void c() throws IOException {
      if (!this.a) {
        if (this.d.h == null)
          return; 
        throw new o(this.d.h);
      } 
      throw new IOException("stream closed");
    }
    
    public long a(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (param1Long >= 0L)
        synchronized (this.d) {
          b();
          c();
          if (this.f.b() == 0L)
            return -1L; 
          param1Long = this.f.a(param1c, Math.min(param1Long, this.f.b()));
          i i1 = this.d;
          i1.a += param1Long;
          if (this.d.a >= (this.d.d.l.d() / 2)) {
            this.d.d.a(this.d.c, this.d.a);
            this.d.a = 0L;
          } 
          synchronized (this.d.d) {
            g g = this.d.d;
            g.j += param1Long;
            if (this.d.d.j >= (this.d.d.l.d() / 2)) {
              this.d.d.a(0, this.d.d.j);
              this.d.d.j = 0L;
            } 
            return param1Long;
          } 
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public t a() {
      return (t)this.d.f;
    }
    
    void a(e param1e, long param1Long) throws IOException {
      long l = param1Long;
      if (!c)
        if (!Thread.holdsLock(this.d)) {
          l = param1Long;
        } else {
          throw new AssertionError();
        }  
      while (true) {
        if (l > 0L)
          synchronized (this.d) {
            boolean bool1;
            boolean bool = this.b;
            param1Long = this.f.b();
            long l1 = this.g;
            boolean bool2 = true;
            if (param1Long + l > l1) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool1) {
              param1e.h(l);
              this.d.b(b.d);
              return;
            } 
            if (bool) {
              param1e.h(l);
              return;
            } 
            param1Long = param1e.a(this.e, l);
            if (param1Long != -1L) {
              l -= param1Long;
              synchronized (this.d) {
                if (this.f.b() == 0L) {
                  bool1 = bool2;
                } else {
                  bool1 = false;
                } 
                this.f.a((s)this.e);
                if (bool1)
                  this.d.notifyAll(); 
              } 
              continue;
            } 
            throw new EOFException();
          }  
        return;
      } 
    }
    
    public void close() throws IOException {
      synchronized (this.d) {
        this.a = true;
        this.f.r();
        this.d.notifyAll();
        this.d.j();
        return;
      } 
    }
  }
  
  class c extends com.bytedance.sdk.a.a.a {
    c(i this$0) {}
    
    public IOException b(IOException param1IOException) {
      SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
      if (param1IOException != null)
        socketTimeoutException.initCause(param1IOException); 
      return socketTimeoutException;
    }
    
    public void c() {
      this.b.b(b.f);
    }
    
    public void h() throws IOException {
      if (!b())
        return; 
      throw b(null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */