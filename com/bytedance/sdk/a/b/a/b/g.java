package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.c.c;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;

public final class g {
  public final com.bytedance.sdk.a.b.a a;
  
  public final e b;
  
  public final p c;
  
  private f.a e;
  
  private ac f;
  
  private final j g;
  
  private final Object h;
  
  private final f i;
  
  private int j;
  
  private c k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private c o;
  
  public g(j paramj, com.bytedance.sdk.a.b.a parama, e parame, p paramp, Object paramObject) {
    this.g = paramj;
    this.a = parama;
    this.b = parame;
    this.c = paramp;
    this.i = new f(parama, g(), parame, paramp);
    this.h = paramObject;
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   4: astore #14
    //   6: aload #14
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield m : Z
    //   13: ifne -> 602
    //   16: aload_0
    //   17: getfield o : Lcom/bytedance/sdk/a/b/a/c/c;
    //   20: ifnonnull -> 592
    //   23: aload_0
    //   24: getfield n : Z
    //   27: ifne -> 582
    //   30: aload_0
    //   31: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   34: astore #10
    //   36: aload_0
    //   37: invokespecial f : ()Ljava/net/Socket;
    //   40: astore #15
    //   42: aload_0
    //   43: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   46: astore #9
    //   48: aconst_null
    //   49: astore #13
    //   51: aload #9
    //   53: ifnull -> 620
    //   56: aload_0
    //   57: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   60: astore #9
    //   62: aconst_null
    //   63: astore #10
    //   65: goto -> 68
    //   68: aload #10
    //   70: astore #12
    //   72: aload_0
    //   73: getfield l : Z
    //   76: ifne -> 82
    //   79: aconst_null
    //   80: astore #12
    //   82: aload #9
    //   84: ifnonnull -> 626
    //   87: getstatic com/bytedance/sdk/a/b/a/a.a : Lcom/bytedance/sdk/a/b/a/a;
    //   90: aload_0
    //   91: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   94: aload_0
    //   95: getfield a : Lcom/bytedance/sdk/a/b/a;
    //   98: aload_0
    //   99: aconst_null
    //   100: invokevirtual a : (Lcom/bytedance/sdk/a/b/j;Lcom/bytedance/sdk/a/b/a;Lcom/bytedance/sdk/a/b/a/b/g;Lcom/bytedance/sdk/a/b/ac;)Lcom/bytedance/sdk/a/b/a/b/c;
    //   103: pop
    //   104: aload_0
    //   105: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   108: ifnull -> 126
    //   111: aload_0
    //   112: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   115: astore #10
    //   117: aconst_null
    //   118: astore #9
    //   120: iconst_1
    //   121: istore #5
    //   123: goto -> 135
    //   126: aload_0
    //   127: getfield f : Lcom/bytedance/sdk/a/b/ac;
    //   130: astore #11
    //   132: goto -> 629
    //   135: aload #14
    //   137: monitorexit
    //   138: aload #15
    //   140: invokestatic a : (Ljava/net/Socket;)V
    //   143: aload #12
    //   145: ifnull -> 161
    //   148: aload_0
    //   149: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   152: aload_0
    //   153: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   156: aload #12
    //   158: invokevirtual b : (Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/i;)V
    //   161: iload #5
    //   163: ifeq -> 179
    //   166: aload_0
    //   167: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   170: aload_0
    //   171: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   174: aload #10
    //   176: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/i;)V
    //   179: aload #10
    //   181: ifnull -> 187
    //   184: aload #10
    //   186: areturn
    //   187: aload #9
    //   189: ifnonnull -> 228
    //   192: aload_0
    //   193: getfield e : Lcom/bytedance/sdk/a/b/a/b/f$a;
    //   196: astore #11
    //   198: aload #11
    //   200: ifnull -> 211
    //   203: aload #11
    //   205: invokevirtual a : ()Z
    //   208: ifne -> 228
    //   211: aload_0
    //   212: aload_0
    //   213: getfield i : Lcom/bytedance/sdk/a/b/a/b/f;
    //   216: invokevirtual b : ()Lcom/bytedance/sdk/a/b/a/b/f$a;
    //   219: putfield e : Lcom/bytedance/sdk/a/b/a/b/f$a;
    //   222: iconst_1
    //   223: istore #7
    //   225: goto -> 231
    //   228: iconst_0
    //   229: istore #7
    //   231: aload_0
    //   232: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   235: astore #12
    //   237: aload #12
    //   239: monitorenter
    //   240: aload_0
    //   241: getfield n : Z
    //   244: ifne -> 564
    //   247: iload #5
    //   249: istore #6
    //   251: aload #10
    //   253: astore #11
    //   255: iload #7
    //   257: ifeq -> 353
    //   260: aload_0
    //   261: getfield e : Lcom/bytedance/sdk/a/b/a/b/f$a;
    //   264: invokevirtual c : ()Ljava/util/List;
    //   267: astore #14
    //   269: aload #14
    //   271: invokeinterface size : ()I
    //   276: istore #8
    //   278: iconst_0
    //   279: istore #7
    //   281: iload #5
    //   283: istore #6
    //   285: aload #10
    //   287: astore #11
    //   289: iload #7
    //   291: iload #8
    //   293: if_icmpge -> 353
    //   296: aload #14
    //   298: iload #7
    //   300: invokeinterface get : (I)Ljava/lang/Object;
    //   305: checkcast com/bytedance/sdk/a/b/ac
    //   308: astore #15
    //   310: getstatic com/bytedance/sdk/a/b/a/a.a : Lcom/bytedance/sdk/a/b/a/a;
    //   313: aload_0
    //   314: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   317: aload_0
    //   318: getfield a : Lcom/bytedance/sdk/a/b/a;
    //   321: aload_0
    //   322: aload #15
    //   324: invokevirtual a : (Lcom/bytedance/sdk/a/b/j;Lcom/bytedance/sdk/a/b/a;Lcom/bytedance/sdk/a/b/a/b/g;Lcom/bytedance/sdk/a/b/ac;)Lcom/bytedance/sdk/a/b/a/b/c;
    //   327: pop
    //   328: aload_0
    //   329: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   332: ifnull -> 643
    //   335: aload_0
    //   336: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   339: astore #11
    //   341: aload_0
    //   342: aload #15
    //   344: putfield f : Lcom/bytedance/sdk/a/b/ac;
    //   347: iconst_1
    //   348: istore #6
    //   350: goto -> 353
    //   353: aload #11
    //   355: astore #10
    //   357: iload #6
    //   359: ifne -> 413
    //   362: aload #9
    //   364: astore #10
    //   366: aload #9
    //   368: ifnonnull -> 380
    //   371: aload_0
    //   372: getfield e : Lcom/bytedance/sdk/a/b/a/b/f$a;
    //   375: invokevirtual b : ()Lcom/bytedance/sdk/a/b/ac;
    //   378: astore #10
    //   380: aload_0
    //   381: aload #10
    //   383: putfield f : Lcom/bytedance/sdk/a/b/ac;
    //   386: aload_0
    //   387: iconst_0
    //   388: putfield j : I
    //   391: new com/bytedance/sdk/a/b/a/b/c
    //   394: dup
    //   395: aload_0
    //   396: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   399: aload #10
    //   401: invokespecial <init> : (Lcom/bytedance/sdk/a/b/j;Lcom/bytedance/sdk/a/b/ac;)V
    //   404: astore #10
    //   406: aload_0
    //   407: aload #10
    //   409: iconst_0
    //   410: invokevirtual a : (Lcom/bytedance/sdk/a/b/a/b/c;Z)V
    //   413: aload #12
    //   415: monitorexit
    //   416: iload #6
    //   418: ifeq -> 437
    //   421: aload_0
    //   422: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   425: aload_0
    //   426: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   429: aload #10
    //   431: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/i;)V
    //   434: aload #10
    //   436: areturn
    //   437: aload #10
    //   439: iload_1
    //   440: iload_2
    //   441: iload_3
    //   442: iload #4
    //   444: aload_0
    //   445: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   448: aload_0
    //   449: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   452: invokevirtual a : (IIIZLcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/p;)V
    //   455: aload_0
    //   456: invokespecial g : ()Lcom/bytedance/sdk/a/b/a/b/d;
    //   459: aload #10
    //   461: invokevirtual a : ()Lcom/bytedance/sdk/a/b/ac;
    //   464: invokevirtual b : (Lcom/bytedance/sdk/a/b/ac;)V
    //   467: aload_0
    //   468: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   471: astore #12
    //   473: aload #12
    //   475: monitorenter
    //   476: aload_0
    //   477: iconst_1
    //   478: putfield l : Z
    //   481: getstatic com/bytedance/sdk/a/b/a/a.a : Lcom/bytedance/sdk/a/b/a/a;
    //   484: aload_0
    //   485: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   488: aload #10
    //   490: invokevirtual a : (Lcom/bytedance/sdk/a/b/j;Lcom/bytedance/sdk/a/b/a/b/c;)V
    //   493: aload #13
    //   495: astore #11
    //   497: aload #10
    //   499: astore #9
    //   501: aload #10
    //   503: invokevirtual d : ()Z
    //   506: ifeq -> 532
    //   509: getstatic com/bytedance/sdk/a/b/a/a.a : Lcom/bytedance/sdk/a/b/a/a;
    //   512: aload_0
    //   513: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   516: aload_0
    //   517: getfield a : Lcom/bytedance/sdk/a/b/a;
    //   520: aload_0
    //   521: invokevirtual a : (Lcom/bytedance/sdk/a/b/j;Lcom/bytedance/sdk/a/b/a;Lcom/bytedance/sdk/a/b/a/b/g;)Ljava/net/Socket;
    //   524: astore #11
    //   526: aload_0
    //   527: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   530: astore #9
    //   532: aload #12
    //   534: monitorexit
    //   535: aload #11
    //   537: invokestatic a : (Ljava/net/Socket;)V
    //   540: aload_0
    //   541: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   544: aload_0
    //   545: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   548: aload #9
    //   550: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/i;)V
    //   553: aload #9
    //   555: areturn
    //   556: astore #9
    //   558: aload #12
    //   560: monitorexit
    //   561: aload #9
    //   563: athrow
    //   564: new java/io/IOException
    //   567: dup
    //   568: ldc 'Canceled'
    //   570: invokespecial <init> : (Ljava/lang/String;)V
    //   573: athrow
    //   574: astore #9
    //   576: aload #12
    //   578: monitorexit
    //   579: aload #9
    //   581: athrow
    //   582: new java/io/IOException
    //   585: dup
    //   586: ldc 'Canceled'
    //   588: invokespecial <init> : (Ljava/lang/String;)V
    //   591: athrow
    //   592: new java/lang/IllegalStateException
    //   595: dup
    //   596: ldc 'codec != null'
    //   598: invokespecial <init> : (Ljava/lang/String;)V
    //   601: athrow
    //   602: new java/lang/IllegalStateException
    //   605: dup
    //   606: ldc 'released'
    //   608: invokespecial <init> : (Ljava/lang/String;)V
    //   611: athrow
    //   612: astore #9
    //   614: aload #14
    //   616: monitorexit
    //   617: aload #9
    //   619: athrow
    //   620: aconst_null
    //   621: astore #9
    //   623: goto -> 68
    //   626: aconst_null
    //   627: astore #11
    //   629: iconst_0
    //   630: istore #5
    //   632: aload #9
    //   634: astore #10
    //   636: aload #11
    //   638: astore #9
    //   640: goto -> 135
    //   643: iload #7
    //   645: iconst_1
    //   646: iadd
    //   647: istore #7
    //   649: goto -> 281
    // Exception table:
    //   from	to	target	type
    //   9	48	612	finally
    //   56	62	612	finally
    //   72	79	612	finally
    //   87	117	612	finally
    //   126	132	612	finally
    //   135	138	612	finally
    //   240	247	574	finally
    //   260	278	574	finally
    //   296	347	574	finally
    //   371	380	574	finally
    //   380	413	574	finally
    //   413	416	574	finally
    //   476	493	556	finally
    //   501	532	556	finally
    //   532	535	556	finally
    //   558	561	556	finally
    //   564	574	574	finally
    //   576	579	574	finally
    //   582	592	612	finally
    //   592	602	612	finally
    //   602	612	612	finally
    //   614	617	612	finally
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    while (true) {
      null = a(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.g) {
        if (null.b == 0)
          return null; 
        if (!null.a(paramBoolean2)) {
          d();
          continue;
        } 
        return null;
      } 
    } 
  }
  
  private Socket a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (d || Thread.holdsLock(this.g)) {
      if (paramBoolean3)
        this.o = null; 
      if (paramBoolean2)
        this.m = true; 
      c c1 = this.k;
      if (c1 != null) {
        if (paramBoolean1)
          c1.a = true; 
        if (this.o == null && (this.m || this.k.a)) {
          b(this.k);
          if (this.k.d.isEmpty()) {
            this.k.e = System.nanoTime();
            if (com.bytedance.sdk.a.b.a.a.a.b(this.g, this.k)) {
              Socket socket = this.k.b();
              this.k = null;
              return socket;
            } 
          } 
          c1 = null;
          this.k = null;
          return (Socket)c1;
        } 
      } 
      return null;
    } 
    throw new AssertionError();
  }
  
  private void b(c paramc) {
    int k = paramc.d.size();
    for (int i = 0; i < k; i++) {
      if (((Reference<g>)paramc.d.get(i)).get() == this) {
        paramc.d.remove(i);
        return;
      } 
    } 
    throw new IllegalStateException();
  }
  
  private Socket f() {
    if (d || Thread.holdsLock(this.g)) {
      c c1 = this.k;
      return (c1 != null && c1.a) ? a(false, false, true) : null;
    } 
    throw new AssertionError();
  }
  
  private d g() {
    return com.bytedance.sdk.a.b.a.a.a.a(this.g);
  }
  
  public c a() {
    synchronized (this.g) {
      return this.o;
    } 
  }
  
  public c a(v paramv, t.a parama, boolean paramBoolean) {
    int i = parama.b();
    int k = parama.c();
    int m = parama.d();
    boolean bool = paramv.r();
    try {
      null = a(i, k, m, bool, paramBoolean).a(paramv, parama, this);
      synchronized (this.g) {
        this.o = null;
        return null;
      } 
    } catch (IOException iOException) {
      throw new e(iOException);
    } 
  }
  
  public Socket a(c paramc) {
    if (d || Thread.holdsLock(this.g)) {
      if (this.o == null && this.k.d.size() == 1) {
        Reference<g> reference = this.k.d.get(0);
        Socket socket = a(true, false, false);
        this.k = paramc;
        paramc.d.add(reference);
        return socket;
      } 
      throw new IllegalStateException();
    } 
    throw new AssertionError();
  }
  
  public void a(c paramc, boolean paramBoolean) {
    if (d || Thread.holdsLock(this.g)) {
      if (this.k == null) {
        this.k = paramc;
        this.l = paramBoolean;
        paramc.d.add(new a(this, this.h));
        return;
      } 
      throw new IllegalStateException();
    } 
    throw new AssertionError();
  }
  
  public void a(IOException paramIOException) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: instanceof com/bytedance/sdk/a/b/a/e/o
    //   11: ifeq -> 65
    //   14: aload_1
    //   15: checkcast com/bytedance/sdk/a/b/a/e/o
    //   18: astore_1
    //   19: aload_1
    //   20: getfield a : Lcom/bytedance/sdk/a/b/a/e/b;
    //   23: getstatic com/bytedance/sdk/a/b/a/e/b.e : Lcom/bytedance/sdk/a/b/a/e/b;
    //   26: if_acmpne -> 39
    //   29: aload_0
    //   30: aload_0
    //   31: getfield j : I
    //   34: iconst_1
    //   35: iadd
    //   36: putfield j : I
    //   39: aload_1
    //   40: getfield a : Lcom/bytedance/sdk/a/b/a/e/b;
    //   43: getstatic com/bytedance/sdk/a/b/a/e/b.e : Lcom/bytedance/sdk/a/b/a/e/b;
    //   46: if_acmpne -> 57
    //   49: aload_0
    //   50: getfield j : I
    //   53: iconst_1
    //   54: if_icmple -> 195
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield f : Lcom/bytedance/sdk/a/b/ac;
    //   62: goto -> 190
    //   65: aload_0
    //   66: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   69: ifnull -> 195
    //   72: aload_0
    //   73: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   76: invokevirtual d : ()Z
    //   79: ifeq -> 89
    //   82: aload_1
    //   83: instanceof com/bytedance/sdk/a/b/a/e/a
    //   86: ifeq -> 195
    //   89: aload_0
    //   90: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   93: getfield b : I
    //   96: ifne -> 190
    //   99: aload_0
    //   100: getfield f : Lcom/bytedance/sdk/a/b/ac;
    //   103: ifnull -> 122
    //   106: aload_1
    //   107: ifnull -> 122
    //   110: aload_0
    //   111: getfield i : Lcom/bytedance/sdk/a/b/a/b/f;
    //   114: aload_0
    //   115: getfield f : Lcom/bytedance/sdk/a/b/ac;
    //   118: aload_1
    //   119: invokevirtual a : (Lcom/bytedance/sdk/a/b/ac;Ljava/io/IOException;)V
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield f : Lcom/bytedance/sdk/a/b/ac;
    //   127: goto -> 190
    //   130: aload_0
    //   131: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   134: astore_1
    //   135: aload_0
    //   136: iload_2
    //   137: iconst_0
    //   138: iconst_1
    //   139: invokespecial a : (ZZZ)Ljava/net/Socket;
    //   142: astore #4
    //   144: aload_0
    //   145: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   148: ifnonnull -> 200
    //   151: aload_0
    //   152: getfield l : Z
    //   155: ifne -> 161
    //   158: goto -> 200
    //   161: aload_3
    //   162: monitorexit
    //   163: aload #4
    //   165: invokestatic a : (Ljava/net/Socket;)V
    //   168: aload_1
    //   169: ifnull -> 184
    //   172: aload_0
    //   173: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   176: aload_0
    //   177: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   180: aload_1
    //   181: invokevirtual b : (Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/i;)V
    //   184: return
    //   185: astore_1
    //   186: aload_3
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    //   190: iconst_1
    //   191: istore_2
    //   192: goto -> 130
    //   195: iconst_0
    //   196: istore_2
    //   197: goto -> 130
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -> 161
    // Exception table:
    //   from	to	target	type
    //   7	39	185	finally
    //   39	57	185	finally
    //   57	62	185	finally
    //   65	89	185	finally
    //   89	106	185	finally
    //   110	122	185	finally
    //   122	127	185	finally
    //   130	151	185	finally
    //   151	158	185	finally
    //   161	163	185	finally
    //   186	188	185	finally
  }
  
  public void a(boolean paramBoolean, c paramc, long paramLong, IOException paramIOException) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   4: aload_0
    //   5: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   8: lload_3
    //   9: invokevirtual b : (Lcom/bytedance/sdk/a/b/e;J)V
    //   12: aload_0
    //   13: getfield g : Lcom/bytedance/sdk/a/b/j;
    //   16: astore #6
    //   18: aload #6
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnull -> 139
    //   25: aload_2
    //   26: aload_0
    //   27: getfield o : Lcom/bytedance/sdk/a/b/a/c/c;
    //   30: if_acmpne -> 139
    //   33: iload_1
    //   34: ifne -> 52
    //   37: aload_0
    //   38: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   41: astore_2
    //   42: aload_2
    //   43: aload_2
    //   44: getfield b : I
    //   47: iconst_1
    //   48: iadd
    //   49: putfield b : I
    //   52: aload_0
    //   53: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   56: astore_2
    //   57: aload_0
    //   58: iload_1
    //   59: iconst_0
    //   60: iconst_1
    //   61: invokespecial a : (ZZZ)Ljava/net/Socket;
    //   64: astore #7
    //   66: aload_0
    //   67: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   70: ifnull -> 75
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_0
    //   76: getfield m : Z
    //   79: istore_1
    //   80: aload #6
    //   82: monitorexit
    //   83: aload #7
    //   85: invokestatic a : (Ljava/net/Socket;)V
    //   88: aload_2
    //   89: ifnull -> 104
    //   92: aload_0
    //   93: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   96: aload_0
    //   97: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   100: aload_2
    //   101: invokevirtual b : (Lcom/bytedance/sdk/a/b/e;Lcom/bytedance/sdk/a/b/i;)V
    //   104: aload #5
    //   106: ifnull -> 123
    //   109: aload_0
    //   110: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   113: aload_0
    //   114: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   117: aload #5
    //   119: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Ljava/io/IOException;)V
    //   122: return
    //   123: iload_1
    //   124: ifeq -> 138
    //   127: aload_0
    //   128: getfield c : Lcom/bytedance/sdk/a/b/p;
    //   131: aload_0
    //   132: getfield b : Lcom/bytedance/sdk/a/b/e;
    //   135: invokevirtual g : (Lcom/bytedance/sdk/a/b/e;)V
    //   138: return
    //   139: new java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial <init> : ()V
    //   146: astore #5
    //   148: aload #5
    //   150: ldc_w 'expected '
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload #5
    //   159: aload_0
    //   160: getfield o : Lcom/bytedance/sdk/a/b/a/c/c;
    //   163: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload #5
    //   169: ldc_w ' but was '
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #5
    //   178: aload_2
    //   179: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: new java/lang/IllegalStateException
    //   186: dup
    //   187: aload #5
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: invokespecial <init> : (Ljava/lang/String;)V
    //   195: athrow
    //   196: astore_2
    //   197: aload #6
    //   199: monitorexit
    //   200: aload_2
    //   201: athrow
    // Exception table:
    //   from	to	target	type
    //   25	33	196	finally
    //   37	52	196	finally
    //   52	66	196	finally
    //   66	73	196	finally
    //   75	83	196	finally
    //   139	196	196	finally
    //   197	200	196	finally
  }
  
  public c b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Lcom/bytedance/sdk/a/b/a/b/c;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void c() {
    synchronized (this.g) {
      c c1 = this.k;
      Socket socket = a(false, true, false);
      if (this.k != null)
        c1 = null; 
      c.a(socket);
      if (c1 != null)
        this.c.b(this.b, c1); 
      return;
    } 
  }
  
  public void d() {
    synchronized (this.g) {
      c c1 = this.k;
      Socket socket = a(true, false, false);
      if (this.k != null)
        c1 = null; 
      c.a(socket);
      if (c1 != null)
        this.c.b(this.b, c1); 
      return;
    } 
  }
  
  public boolean e() {
    if (this.f == null) {
      f.a a1 = this.e;
      if ((a1 == null || !a1.a()) && !this.i.a())
        return false; 
    } 
    return true;
  }
  
  public String toString() {
    c c1 = b();
    return (c1 != null) ? c1.toString() : this.a.toString();
  }
  
  public static final class a extends WeakReference<g> {
    public final Object a;
    
    a(g param1g, Object param1Object) {
      super(param1g);
      this.a = param1Object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */