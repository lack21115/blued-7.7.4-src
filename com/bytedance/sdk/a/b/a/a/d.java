package com.bytedance.sdk.a.b.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class d implements Closeable, Flushable {
  static final Pattern a;
  
  final com.bytedance.sdk.a.b.a.f.a b;
  
  final int c;
  
  com.bytedance.sdk.a.a.d d;
  
  final LinkedHashMap<String, b> e;
  
  int f;
  
  boolean g;
  
  boolean h;
  
  boolean i;
  
  private long k;
  
  private long l;
  
  private long m;
  
  private final Executor n;
  
  private final Runnable o;
  
  static {
    a = Pattern.compile("[a-z0-9_-]{1,120}");
  }
  
  private void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual b : ()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/lang/IllegalStateException
    //   17: dup
    //   18: ldc 'cache is closed'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	24	24	finally
  }
  
  void a(a parama, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield a : Lcom/bytedance/sdk/a/b/a/a/d$b;
    //   6: astore #10
    //   8: aload #10
    //   10: getfield f : Lcom/bytedance/sdk/a/b/a/a/d$a;
    //   13: aload_1
    //   14: if_acmpne -> 471
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 133
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: getfield e : Z
    //   37: ifne -> 133
    //   40: iconst_0
    //   41: istore_3
    //   42: iload #5
    //   44: istore #4
    //   46: iload_3
    //   47: aload_0
    //   48: getfield c : I
    //   51: if_icmpge -> 133
    //   54: aload_1
    //   55: getfield b : [Z
    //   58: iload_3
    //   59: baload
    //   60: ifeq -> 96
    //   63: aload_0
    //   64: getfield b : Lcom/bytedance/sdk/a/b/a/f/a;
    //   67: aload #10
    //   69: getfield d : [Ljava/io/File;
    //   72: iload_3
    //   73: aaload
    //   74: invokeinterface b : (Ljava/io/File;)Z
    //   79: ifne -> 89
    //   82: aload_1
    //   83: invokevirtual b : ()V
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: istore_3
    //   93: goto -> 42
    //   96: aload_1
    //   97: invokevirtual b : ()V
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: astore_1
    //   108: aload_1
    //   109: ldc 'Newly created entry didn't create value for index '
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_1
    //   116: iload_3
    //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: new java/lang/IllegalStateException
    //   124: dup
    //   125: aload_1
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: invokespecial <init> : (Ljava/lang/String;)V
    //   132: athrow
    //   133: iload #4
    //   135: aload_0
    //   136: getfield c : I
    //   139: if_icmpge -> 253
    //   142: aload #10
    //   144: getfield d : [Ljava/io/File;
    //   147: iload #4
    //   149: aaload
    //   150: astore_1
    //   151: iload_2
    //   152: ifeq -> 240
    //   155: aload_0
    //   156: getfield b : Lcom/bytedance/sdk/a/b/a/f/a;
    //   159: aload_1
    //   160: invokeinterface b : (Ljava/io/File;)Z
    //   165: ifeq -> 484
    //   168: aload #10
    //   170: getfield c : [Ljava/io/File;
    //   173: iload #4
    //   175: aaload
    //   176: astore #11
    //   178: aload_0
    //   179: getfield b : Lcom/bytedance/sdk/a/b/a/f/a;
    //   182: aload_1
    //   183: aload #11
    //   185: invokeinterface a : (Ljava/io/File;Ljava/io/File;)V
    //   190: aload #10
    //   192: getfield b : [J
    //   195: iload #4
    //   197: laload
    //   198: lstore #6
    //   200: aload_0
    //   201: getfield b : Lcom/bytedance/sdk/a/b/a/f/a;
    //   204: aload #11
    //   206: invokeinterface c : (Ljava/io/File;)J
    //   211: lstore #8
    //   213: aload #10
    //   215: getfield b : [J
    //   218: iload #4
    //   220: lload #8
    //   222: lastore
    //   223: aload_0
    //   224: aload_0
    //   225: getfield l : J
    //   228: lload #6
    //   230: lsub
    //   231: lload #8
    //   233: ladd
    //   234: putfield l : J
    //   237: goto -> 484
    //   240: aload_0
    //   241: getfield b : Lcom/bytedance/sdk/a/b/a/f/a;
    //   244: aload_1
    //   245: invokeinterface a : (Ljava/io/File;)V
    //   250: goto -> 484
    //   253: aload_0
    //   254: aload_0
    //   255: getfield f : I
    //   258: iconst_1
    //   259: iadd
    //   260: putfield f : I
    //   263: aload #10
    //   265: aconst_null
    //   266: putfield f : Lcom/bytedance/sdk/a/b/a/a/d$a;
    //   269: aload #10
    //   271: getfield e : Z
    //   274: iload_2
    //   275: ior
    //   276: ifeq -> 368
    //   279: aload #10
    //   281: iconst_1
    //   282: putfield e : Z
    //   285: aload_0
    //   286: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   289: ldc 'CLEAN'
    //   291: invokeinterface b : (Ljava/lang/String;)Lcom/bytedance/sdk/a/a/d;
    //   296: bipush #32
    //   298: invokeinterface i : (I)Lcom/bytedance/sdk/a/a/d;
    //   303: pop
    //   304: aload_0
    //   305: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   308: aload #10
    //   310: getfield a : Ljava/lang/String;
    //   313: invokeinterface b : (Ljava/lang/String;)Lcom/bytedance/sdk/a/a/d;
    //   318: pop
    //   319: aload #10
    //   321: aload_0
    //   322: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   325: invokevirtual a : (Lcom/bytedance/sdk/a/a/d;)V
    //   328: aload_0
    //   329: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   332: bipush #10
    //   334: invokeinterface i : (I)Lcom/bytedance/sdk/a/a/d;
    //   339: pop
    //   340: iload_2
    //   341: ifeq -> 427
    //   344: aload_0
    //   345: getfield m : J
    //   348: lstore #6
    //   350: aload_0
    //   351: lconst_1
    //   352: lload #6
    //   354: ladd
    //   355: putfield m : J
    //   358: aload #10
    //   360: lload #6
    //   362: putfield g : J
    //   365: goto -> 427
    //   368: aload_0
    //   369: getfield e : Ljava/util/LinkedHashMap;
    //   372: aload #10
    //   374: getfield a : Ljava/lang/String;
    //   377: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   380: pop
    //   381: aload_0
    //   382: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   385: ldc 'REMOVE'
    //   387: invokeinterface b : (Ljava/lang/String;)Lcom/bytedance/sdk/a/a/d;
    //   392: bipush #32
    //   394: invokeinterface i : (I)Lcom/bytedance/sdk/a/a/d;
    //   399: pop
    //   400: aload_0
    //   401: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   404: aload #10
    //   406: getfield a : Ljava/lang/String;
    //   409: invokeinterface b : (Ljava/lang/String;)Lcom/bytedance/sdk/a/a/d;
    //   414: pop
    //   415: aload_0
    //   416: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   419: bipush #10
    //   421: invokeinterface i : (I)Lcom/bytedance/sdk/a/a/d;
    //   426: pop
    //   427: aload_0
    //   428: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   431: invokeinterface flush : ()V
    //   436: aload_0
    //   437: getfield l : J
    //   440: aload_0
    //   441: getfield k : J
    //   444: lcmp
    //   445: ifgt -> 455
    //   448: aload_0
    //   449: invokevirtual a : ()Z
    //   452: ifeq -> 468
    //   455: aload_0
    //   456: getfield n : Ljava/util/concurrent/Executor;
    //   459: aload_0
    //   460: getfield o : Ljava/lang/Runnable;
    //   463: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   468: aload_0
    //   469: monitorexit
    //   470: return
    //   471: new java/lang/IllegalStateException
    //   474: dup
    //   475: invokespecial <init> : ()V
    //   478: athrow
    //   479: astore_1
    //   480: aload_0
    //   481: monitorexit
    //   482: aload_1
    //   483: athrow
    //   484: iload #4
    //   486: iconst_1
    //   487: iadd
    //   488: istore #4
    //   490: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   2	17	479	finally
    //   32	40	479	finally
    //   46	86	479	finally
    //   96	133	479	finally
    //   133	151	479	finally
    //   155	237	479	finally
    //   240	250	479	finally
    //   253	340	479	finally
    //   344	365	479	finally
    //   368	427	479	finally
    //   427	455	479	finally
    //   455	468	479	finally
    //   471	479	479	finally
  }
  
  boolean a() {
    int i = this.f;
    return (i >= 2000 && i >= this.e.size());
  }
  
  boolean a(b paramb) throws IOException {
    if (paramb.f != null)
      paramb.f.a(); 
    for (int i = 0; i < this.c; i++) {
      this.b.a(paramb.c[i]);
      this.l -= paramb.b[i];
      paramb.b[i] = 0L;
    } 
    this.f++;
    this.d.b("REMOVE").i(32).b(paramb.a).i(10);
    this.e.remove(paramb.a);
    if (a())
      this.n.execute(this.o); 
    return true;
  }
  
  public boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  void c() throws IOException {
    while (this.l > this.k)
      a(this.e.values().iterator().next()); 
    this.i = false;
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifeq -> 105
    //   9: aload_0
    //   10: getfield h : Z
    //   13: ifeq -> 19
    //   16: goto -> 105
    //   19: aload_0
    //   20: getfield e : Ljava/util/LinkedHashMap;
    //   23: invokevirtual values : ()Ljava/util/Collection;
    //   26: aload_0
    //   27: getfield e : Ljava/util/LinkedHashMap;
    //   30: invokevirtual size : ()I
    //   33: anewarray com/bytedance/sdk/a/b/a/a/d$b
    //   36: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   41: checkcast [Lcom/bytedance/sdk/a/b/a/a/d$b;
    //   44: astore_3
    //   45: aload_3
    //   46: arraylength
    //   47: istore_2
    //   48: iconst_0
    //   49: istore_1
    //   50: iload_1
    //   51: iload_2
    //   52: if_icmpge -> 79
    //   55: aload_3
    //   56: iload_1
    //   57: aaload
    //   58: astore #4
    //   60: aload #4
    //   62: getfield f : Lcom/bytedance/sdk/a/b/a/a/d$a;
    //   65: ifnull -> 118
    //   68: aload #4
    //   70: getfield f : Lcom/bytedance/sdk/a/b/a/a/d$a;
    //   73: invokevirtual b : ()V
    //   76: goto -> 118
    //   79: aload_0
    //   80: invokevirtual c : ()V
    //   83: aload_0
    //   84: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   87: invokeinterface close : ()V
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield d : Lcom/bytedance/sdk/a/a/d;
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield h : Z
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield h : Z
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_3
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: athrow
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -> 50
    // Exception table:
    //   from	to	target	type
    //   2	16	113	finally
    //   19	48	113	finally
    //   60	76	113	finally
    //   79	102	113	finally
    //   105	110	113	finally
  }
  
  public void flush() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial d : ()V
    //   18: aload_0
    //   19: invokevirtual c : ()V
    //   22: aload_0
    //   23: getfield d : Lcom/bytedance/sdk/a/a/d;
    //   26: invokeinterface flush : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public final class a {
    final d.b a;
    
    final boolean[] b;
    
    private boolean d;
    
    void a() {
      if (this.a.f == this) {
        int i = 0;
        while (true) {
          if (i < this.c.c) {
            try {
              this.c.b.a(this.a.d[i]);
            } catch (IOException iOException) {}
            i++;
            continue;
          } 
          this.a.f = null;
          return;
        } 
      } 
    }
    
    public void b() throws IOException {
      synchronized (this.c) {
        if (!this.d) {
          if (this.a.f == this)
            this.c.a(this, false); 
          this.d = true;
          return;
        } 
        throw new IllegalStateException();
      } 
    }
  }
  
  final class b {
    final String a;
    
    final long[] b;
    
    final File[] c;
    
    final File[] d;
    
    boolean e;
    
    d.a f;
    
    long g;
    
    void a(com.bytedance.sdk.a.a.d param1d) throws IOException {
      for (long l : this.b)
        param1d.i(32).l(l); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */