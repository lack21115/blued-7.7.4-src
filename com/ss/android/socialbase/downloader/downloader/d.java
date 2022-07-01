package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.f;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.impls.k;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.j.a;
import com.ss.android.socialbase.downloader.j.c;
import com.ss.android.socialbase.downloader.j.e;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.l.e;
import com.ss.android.socialbase.downloader.m.c;
import com.ss.android.socialbase.downloader.m.f;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

public class d {
  private static String a = "ResponseHandler";
  
  private final c b;
  
  private final b c;
  
  private final e d;
  
  private k e;
  
  private k f;
  
  private s g;
  
  private f h;
  
  private volatile boolean i;
  
  private volatile boolean j;
  
  private final e k;
  
  private long l;
  
  private long m;
  
  private volatile long n;
  
  private volatile long o;
  
  private final boolean p;
  
  private final a q;
  
  private final a r;
  
  private final boolean s;
  
  private final long t;
  
  private final long u;
  
  private boolean v;
  
  private volatile long w = 0L;
  
  private volatile long x = 0L;
  
  public d(c paramc, e parame, b paramb, e parame1) {
    this.b = paramc;
    this.e = b.p();
    k k1 = this.e;
    if (k1 instanceof com.ss.android.socialbase.downloader.impls.d) {
      com.ss.android.socialbase.downloader.impls.d d1 = (com.ss.android.socialbase.downloader.impls.d)k1;
      this.f = d1.a();
      this.g = d1.e();
    } 
    this.d = parame;
    this.c = paramb;
    this.k = parame1;
    this.l = paramb.n();
    this.m = this.l;
    if (paramb.d()) {
      this.o = paramb.q();
    } else {
      this.o = paramb.c(false);
    } 
    this.n = paramb.p();
    this.r = a.a();
    this.q = a.a(paramc.g());
    int i = this.q.a("sync_strategy", 0);
    boolean bool = true;
    if (i != 1)
      bool = false; 
    this.s = bool;
    if (this.s) {
      long l3 = this.q.a("sync_interval_ms_fg", 5000);
      long l2 = this.q.a("sync_interval_ms_bg", 1000);
      long l1 = l3;
      if (l3 < 500L)
        l1 = 500L; 
      this.t = l1;
      l1 = l2;
      if (l2 < 500L)
        l1 = 500L; 
      this.u = l1;
    } else {
      this.t = 0L;
      this.u = 0L;
    } 
    this.p = c.a(65536);
  }
  
  private c a(InputStream paramInputStream) {
    int i = b.w();
    if (this.q.a("rw_concurrent", 0) == 1 && this.b.aV() == 1 && this.b.ab() > 20971520L) {
      int j = this.q.a("rw_concurrent_max_buffer_count", 4);
      try {
        return (c)new a(paramInputStream, i, j);
      } finally {
        Exception exception = null;
      } 
    } 
    e e1 = new e(paramInputStream, i);
    this.v = false;
    return (c)e1;
  }
  
  private void a(k paramk) {
    b b1;
    if (paramk == null)
      return; 
    n n = null;
    boolean bool = paramk instanceof com.ss.android.socialbase.downloader.c.e;
    if (bool) {
      n n1 = l.a(f.b());
      n = n1;
      if (n1 == null)
        return; 
    } 
    if (this.c.d()) {
      b1 = this.c.e();
    } else {
      b1 = this.c;
    } 
    if (b1 != null) {
      b1.b(this.l);
      if (bool && n != null) {
        n.a(b1.k(), b1.s(), b1.b(), this.l);
      } else {
        paramk.a(b1.k(), b1.s(), b1.b(), this.l);
      } 
      if (b1.h()) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (b1.i()) {
          long l = b1.j();
          bool1 = bool2;
          if (l > this.l) {
            if (bool && n != null) {
              n.a(b1.k(), b1.b(), l);
            } else {
              paramk.a(b1.k(), b1.b(), l);
            } 
            bool1 = true;
          } 
        } 
        if (!bool1) {
          if (bool && n != null) {
            n.a(b1.k(), b1.b(), this.l);
            return;
          } 
          paramk.a(b1.k(), b1.b(), this.l);
          return;
        } 
      } 
    } else if (this.c.d()) {
      if (bool && n != null) {
        n.a(this.c.k(), this.c.s(), this.l);
        return;
      } 
      paramk.a(this.c.k(), this.c.s(), this.l);
    } 
  }
  
  private void a(boolean paramBoolean) {
    long l1 = SystemClock.uptimeMillis();
    long l2 = l1 - this.x;
    if (this.s) {
      long l;
      if (this.r.c()) {
        l = this.t;
      } else {
        l = this.u;
      } 
      if (l2 > l) {
        h();
        this.x = l1;
        return;
      } 
    } else {
      long l3 = this.l;
      long l4 = this.w;
      if (paramBoolean || b(l3 - l4, l2)) {
        h();
        this.x = l1;
      } 
    } 
  }
  
  private boolean b(long paramLong1, long paramLong2) {
    return (paramLong1 > 65536L && paramLong2 > 500L);
  }
  
  private boolean f() {
    return (this.i || this.j);
  }
  
  private void g() {
    if (this.d == null)
      return; 
    ExecutorService executorService = b.k();
    if (executorService != null)
      executorService.execute(new Runnable(this) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
              } 
            }
          }); 
  }
  
  private void h() {
    boolean bool1;
    boolean bool2 = false;
    try {
      this.h.a();
      bool1 = true;
    } catch (Exception exception) {
      bool1 = false;
    } 
    if (bool1) {
      this.b.e(true);
      bool1 = bool2;
      if (this.b.aV() > 1)
        bool1 = true; 
      n n = l.a(f.b());
      if (bool1) {
        a(this.g);
        if (n != null) {
          n.c(this.b);
        } else {
          this.g.a(this.b.g(), this.b.Z());
        } 
      } else if (n != null) {
        n.c(this.b);
      } else {
        this.g.a(this.c.k(), this.l);
      } 
      this.w = this.l;
    } 
  }
  
  public long a() {
    return this.l;
  }
  
  public void a(long paramLong1, long paramLong2) {
    this.n = paramLong1;
    this.o = paramLong2;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {
    this.l = paramLong1;
    this.m = paramLong1;
    this.n = paramLong2;
    this.o = paramLong3;
  }
  
  public void b() {
    if (this.i)
      return; 
    this.i = true;
    g();
  }
  
  public void c() {
    if (this.j)
      return; 
    synchronized (this.k) {
      this.j = true;
      g();
      return;
    } 
  }
  
  public void d() throws a {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial f : ()Z
    //   4: ifne -> 1941
    //   7: aload_0
    //   8: getfield c : Lcom/ss/android/socialbase/downloader/g/b;
    //   11: ifnonnull -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield d : Lcom/ss/android/socialbase/downloader/i/e;
    //   19: invokestatic a : (Lcom/ss/android/socialbase/downloader/i/c;)J
    //   22: lstore_3
    //   23: lload_3
    //   24: lconst_0
    //   25: lcmp
    //   26: ifeq -> 1927
    //   29: aload_0
    //   30: getfield c : Lcom/ss/android/socialbase/downloader/g/b;
    //   33: invokevirtual l : ()J
    //   36: lstore #5
    //   38: aconst_null
    //   39: astore #17
    //   41: aconst_null
    //   42: astore #16
    //   44: aload #16
    //   46: astore #14
    //   48: aload #17
    //   50: astore #15
    //   52: aload_0
    //   53: aload_0
    //   54: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   57: invokevirtual l : ()Ljava/lang/String;
    //   60: aload_0
    //   61: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   64: invokevirtual m : ()Ljava/lang/String;
    //   67: aload_0
    //   68: getfield q : Lcom/ss/android/socialbase/downloader/k/a;
    //   71: ldc_w 'flush_buffer_size_byte'
    //   74: iconst_m1
    //   75: invokevirtual a : (Ljava/lang/String;I)I
    //   78: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)Lcom/ss/android/socialbase/downloader/g/f;
    //   81: putfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   84: aload #16
    //   86: astore #14
    //   88: aload #17
    //   90: astore #15
    //   92: aload_0
    //   93: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   96: aload_0
    //   97: getfield l : J
    //   100: invokevirtual a : (J)V
    //   103: aload #16
    //   105: astore #14
    //   107: aload #17
    //   109: astore #15
    //   111: aload_0
    //   112: getfield d : Lcom/ss/android/socialbase/downloader/i/e;
    //   115: invokeinterface a : ()Ljava/io/InputStream;
    //   120: astore #18
    //   122: aload #18
    //   124: ifnull -> 940
    //   127: aload #16
    //   129: astore #14
    //   131: aload #17
    //   133: astore #15
    //   135: aload_0
    //   136: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   139: invokevirtual Q : ()V
    //   142: aload #16
    //   144: astore #14
    //   146: aload #17
    //   148: astore #15
    //   150: aload_0
    //   151: aload #18
    //   153: invokespecial a : (Ljava/io/InputStream;)Lcom/ss/android/socialbase/downloader/j/c;
    //   156: astore #16
    //   158: aload #16
    //   160: astore #14
    //   162: aload #16
    //   164: astore #15
    //   166: aload_0
    //   167: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   170: aload_0
    //   171: getfield v : Z
    //   174: invokevirtual d : (Z)V
    //   177: aload #16
    //   179: astore #14
    //   181: aload #16
    //   183: astore #15
    //   185: aload_0
    //   186: invokespecial f : ()Z
    //   189: istore #13
    //   191: iload #13
    //   193: ifeq -> 339
    //   196: aload #16
    //   198: ifnull -> 208
    //   201: aload #16
    //   203: invokeinterface b : ()V
    //   208: aload_0
    //   209: getfield p : Z
    //   212: ifeq -> 264
    //   215: aload_0
    //   216: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   219: astore #14
    //   221: aload #14
    //   223: monitorenter
    //   224: aload_0
    //   225: getfield j : Z
    //   228: ifne -> 250
    //   231: aload_0
    //   232: aload_0
    //   233: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   236: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   239: aload_0
    //   240: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   243: ifnull -> 250
    //   246: aload_0
    //   247: invokespecial h : ()V
    //   250: aload #14
    //   252: monitorexit
    //   253: goto -> 283
    //   256: astore #15
    //   258: aload #14
    //   260: monitorexit
    //   261: aload #15
    //   263: athrow
    //   264: aload_0
    //   265: aload_0
    //   266: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   269: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   272: aload_0
    //   273: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   276: ifnull -> 283
    //   279: aload_0
    //   280: invokespecial h : ()V
    //   283: aload_0
    //   284: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   287: astore #14
    //   289: aload #14
    //   291: ifnull -> 307
    //   294: aload #14
    //   296: invokevirtual b : ()V
    //   299: return
    //   300: astore #14
    //   302: aload #14
    //   304: invokevirtual printStackTrace : ()V
    //   307: return
    //   308: astore #14
    //   310: aload_0
    //   311: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   314: astore #15
    //   316: aload #15
    //   318: ifnull -> 336
    //   321: aload #15
    //   323: invokevirtual b : ()V
    //   326: goto -> 336
    //   329: astore #15
    //   331: aload #15
    //   333: invokevirtual printStackTrace : ()V
    //   336: aload #14
    //   338: athrow
    //   339: aload #16
    //   341: astore #14
    //   343: aload #16
    //   345: astore #15
    //   347: aload #16
    //   349: invokeinterface a : ()Lcom/ss/android/socialbase/downloader/j/b;
    //   354: astore #17
    //   356: aload #16
    //   358: astore #14
    //   360: aload #16
    //   362: astore #15
    //   364: aload #17
    //   366: getfield b : I
    //   369: istore_2
    //   370: iload_2
    //   371: iconst_m1
    //   372: if_icmpne -> 378
    //   375: goto -> 758
    //   378: iload_2
    //   379: istore_1
    //   380: aload #16
    //   382: astore #14
    //   384: aload #16
    //   386: astore #15
    //   388: aload_0
    //   389: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   392: invokevirtual V : ()Z
    //   395: ifne -> 479
    //   398: iload_2
    //   399: istore_1
    //   400: aload #16
    //   402: astore #14
    //   404: aload #16
    //   406: astore #15
    //   408: aload_0
    //   409: getfield o : J
    //   412: aload_0
    //   413: getfield l : J
    //   416: aload_0
    //   417: getfield m : J
    //   420: lsub
    //   421: lcmp
    //   422: ifle -> 479
    //   425: iload_2
    //   426: istore_1
    //   427: aload #16
    //   429: astore #14
    //   431: aload #16
    //   433: astore #15
    //   435: aload_0
    //   436: getfield o : J
    //   439: aload_0
    //   440: getfield l : J
    //   443: aload_0
    //   444: getfield m : J
    //   447: lsub
    //   448: iload_2
    //   449: i2l
    //   450: ladd
    //   451: lcmp
    //   452: ifge -> 479
    //   455: aload #16
    //   457: astore #14
    //   459: aload #16
    //   461: astore #15
    //   463: aload_0
    //   464: getfield o : J
    //   467: aload_0
    //   468: getfield l : J
    //   471: aload_0
    //   472: getfield m : J
    //   475: lsub
    //   476: lsub
    //   477: l2i
    //   478: istore_1
    //   479: aload #16
    //   481: astore #14
    //   483: aload #16
    //   485: astore #15
    //   487: aload_0
    //   488: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   491: aload #17
    //   493: getfield a : [B
    //   496: iconst_0
    //   497: iload_1
    //   498: invokevirtual a : ([BII)V
    //   501: aload #16
    //   503: astore #14
    //   505: aload #16
    //   507: astore #15
    //   509: aload #16
    //   511: aload #17
    //   513: invokeinterface a : (Lcom/ss/android/socialbase/downloader/j/b;)V
    //   518: aload #16
    //   520: astore #14
    //   522: aload #16
    //   524: astore #15
    //   526: aload_0
    //   527: getfield l : J
    //   530: lstore #7
    //   532: iload_1
    //   533: i2l
    //   534: lstore #9
    //   536: aload #16
    //   538: astore #14
    //   540: aload #16
    //   542: astore #15
    //   544: aload_0
    //   545: lload #7
    //   547: lload #9
    //   549: ladd
    //   550: putfield l : J
    //   553: aload #16
    //   555: astore #14
    //   557: aload #16
    //   559: astore #15
    //   561: aload_0
    //   562: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   565: astore #17
    //   567: aload #16
    //   569: astore #14
    //   571: aload #16
    //   573: astore #15
    //   575: aload #17
    //   577: monitorenter
    //   578: aload_0
    //   579: getfield p : Z
    //   582: ifeq -> 622
    //   585: aload_0
    //   586: getfield j : Z
    //   589: ifne -> 649
    //   592: aload_0
    //   593: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   596: lload #9
    //   598: invokeinterface a : (J)Z
    //   603: istore #13
    //   605: aload_0
    //   606: aload_0
    //   607: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   610: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   613: aload_0
    //   614: iload #13
    //   616: invokespecial a : (Z)V
    //   619: goto -> 649
    //   622: aload_0
    //   623: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   626: lload #9
    //   628: invokeinterface a : (J)Z
    //   633: istore #13
    //   635: aload_0
    //   636: aload_0
    //   637: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   640: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   643: aload_0
    //   644: iload #13
    //   646: invokespecial a : (Z)V
    //   649: aload #17
    //   651: monitorexit
    //   652: aload #16
    //   654: astore #14
    //   656: aload #16
    //   658: astore #15
    //   660: aload_0
    //   661: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   664: invokevirtual aA : ()Z
    //   667: ifeq -> 908
    //   670: aload #16
    //   672: astore #14
    //   674: aload #16
    //   676: astore #15
    //   678: aload_0
    //   679: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   682: invokevirtual V : ()Z
    //   685: ifne -> 905
    //   688: aload #16
    //   690: astore #14
    //   692: aload #16
    //   694: astore #15
    //   696: aload_0
    //   697: getfield o : J
    //   700: lconst_0
    //   701: lcmp
    //   702: iflt -> 905
    //   705: aload #16
    //   707: astore #14
    //   709: aload #16
    //   711: astore #15
    //   713: aload_0
    //   714: getfield o : J
    //   717: lstore #7
    //   719: aload #16
    //   721: astore #14
    //   723: aload #16
    //   725: astore #15
    //   727: aload_0
    //   728: getfield l : J
    //   731: lstore #9
    //   733: aload #16
    //   735: astore #14
    //   737: aload #16
    //   739: astore #15
    //   741: aload_0
    //   742: getfield m : J
    //   745: lstore #11
    //   747: lload #7
    //   749: lload #9
    //   751: lload #11
    //   753: lsub
    //   754: lcmp
    //   755: ifgt -> 905
    //   758: aload #16
    //   760: ifnull -> 770
    //   763: aload #16
    //   765: invokeinterface b : ()V
    //   770: aload_0
    //   771: getfield p : Z
    //   774: ifeq -> 826
    //   777: aload_0
    //   778: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   781: astore #14
    //   783: aload #14
    //   785: monitorenter
    //   786: aload_0
    //   787: getfield j : Z
    //   790: ifne -> 812
    //   793: aload_0
    //   794: aload_0
    //   795: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   798: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   801: aload_0
    //   802: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   805: ifnull -> 812
    //   808: aload_0
    //   809: invokespecial h : ()V
    //   812: aload #14
    //   814: monitorexit
    //   815: goto -> 845
    //   818: astore #15
    //   820: aload #14
    //   822: monitorexit
    //   823: aload #15
    //   825: athrow
    //   826: aload_0
    //   827: aload_0
    //   828: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   831: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   834: aload_0
    //   835: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   838: ifnull -> 845
    //   841: aload_0
    //   842: invokespecial h : ()V
    //   845: aload_0
    //   846: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   849: astore #14
    //   851: aload #14
    //   853: ifnull -> 1347
    //   856: aload #14
    //   858: invokevirtual b : ()V
    //   861: goto -> 1347
    //   864: astore #14
    //   866: aload #14
    //   868: invokevirtual printStackTrace : ()V
    //   871: goto -> 1347
    //   874: astore #14
    //   876: aload_0
    //   877: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   880: astore #15
    //   882: aload #15
    //   884: ifnull -> 902
    //   887: aload #15
    //   889: invokevirtual b : ()V
    //   892: goto -> 902
    //   895: astore #15
    //   897: aload #15
    //   899: invokevirtual printStackTrace : ()V
    //   902: aload #14
    //   904: athrow
    //   905: goto -> 177
    //   908: aload #16
    //   910: astore #14
    //   912: aload #16
    //   914: astore #15
    //   916: new com/ss/android/socialbase/downloader/e/d
    //   919: dup
    //   920: invokespecial <init> : ()V
    //   923: athrow
    //   924: astore #18
    //   926: aload #17
    //   928: monitorexit
    //   929: aload #16
    //   931: astore #14
    //   933: aload #16
    //   935: astore #15
    //   937: aload #18
    //   939: athrow
    //   940: aload #16
    //   942: astore #14
    //   944: aload #17
    //   946: astore #15
    //   948: new com/ss/android/socialbase/downloader/e/a
    //   951: dup
    //   952: sipush #1042
    //   955: new java/io/IOException
    //   958: dup
    //   959: ldc_w 'inputStream is null'
    //   962: invokespecial <init> : (Ljava/lang/String;)V
    //   965: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   968: athrow
    //   969: astore #18
    //   971: aload #16
    //   973: astore #14
    //   975: aload #17
    //   977: astore #15
    //   979: new com/ss/android/socialbase/downloader/e/a
    //   982: dup
    //   983: sipush #1054
    //   986: aload #18
    //   988: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   991: athrow
    //   992: astore #15
    //   994: aload #14
    //   996: astore #16
    //   998: getstatic com/ss/android/socialbase/downloader/downloader/d.a : Ljava/lang/String;
    //   1001: astore #17
    //   1003: aload #14
    //   1005: astore #16
    //   1007: new java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial <init> : ()V
    //   1014: astore #18
    //   1016: aload #14
    //   1018: astore #16
    //   1020: aload #18
    //   1022: ldc_w 'handleResponse: e = '
    //   1025: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload #14
    //   1031: astore #16
    //   1033: aload #18
    //   1035: aload #15
    //   1037: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload #14
    //   1043: astore #16
    //   1045: aload #17
    //   1047: aload #18
    //   1049: invokevirtual toString : ()Ljava/lang/String;
    //   1052: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1055: aload #14
    //   1057: astore #16
    //   1059: aload_0
    //   1060: invokespecial f : ()Z
    //   1063: istore #13
    //   1065: iload #13
    //   1067: ifeq -> 1213
    //   1070: aload #14
    //   1072: ifnull -> 1082
    //   1075: aload #14
    //   1077: invokeinterface b : ()V
    //   1082: aload_0
    //   1083: getfield p : Z
    //   1086: ifeq -> 1138
    //   1089: aload_0
    //   1090: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   1093: astore #14
    //   1095: aload #14
    //   1097: monitorenter
    //   1098: aload_0
    //   1099: getfield j : Z
    //   1102: ifne -> 1124
    //   1105: aload_0
    //   1106: aload_0
    //   1107: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1110: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1113: aload_0
    //   1114: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1117: ifnull -> 1124
    //   1120: aload_0
    //   1121: invokespecial h : ()V
    //   1124: aload #14
    //   1126: monitorexit
    //   1127: goto -> 1157
    //   1130: astore #15
    //   1132: aload #14
    //   1134: monitorexit
    //   1135: aload #15
    //   1137: athrow
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1143: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1146: aload_0
    //   1147: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1150: ifnull -> 1157
    //   1153: aload_0
    //   1154: invokespecial h : ()V
    //   1157: aload_0
    //   1158: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1161: astore #14
    //   1163: aload #14
    //   1165: ifnull -> 1181
    //   1168: aload #14
    //   1170: invokevirtual b : ()V
    //   1173: return
    //   1174: astore #14
    //   1176: aload #14
    //   1178: invokevirtual printStackTrace : ()V
    //   1181: return
    //   1182: astore #14
    //   1184: aload_0
    //   1185: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1188: astore #15
    //   1190: aload #15
    //   1192: ifnull -> 1210
    //   1195: aload #15
    //   1197: invokevirtual b : ()V
    //   1200: goto -> 1210
    //   1203: astore #15
    //   1205: aload #15
    //   1207: invokevirtual printStackTrace : ()V
    //   1210: aload #14
    //   1212: athrow
    //   1213: aload #14
    //   1215: astore #16
    //   1217: invokestatic a : ()Z
    //   1220: ifeq -> 1232
    //   1223: aload #14
    //   1225: astore #16
    //   1227: aload #15
    //   1229: invokevirtual printStackTrace : ()V
    //   1232: aload #14
    //   1234: astore #16
    //   1236: aload #15
    //   1238: ldc_w 'DownloadResponseHandler'
    //   1241: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1244: aload #14
    //   1246: ifnull -> 1256
    //   1249: aload #14
    //   1251: invokeinterface b : ()V
    //   1256: aload_0
    //   1257: getfield p : Z
    //   1260: ifeq -> 1312
    //   1263: aload_0
    //   1264: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   1267: astore #14
    //   1269: aload #14
    //   1271: monitorenter
    //   1272: aload_0
    //   1273: getfield j : Z
    //   1276: ifne -> 1298
    //   1279: aload_0
    //   1280: aload_0
    //   1281: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1284: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1287: aload_0
    //   1288: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1291: ifnull -> 1298
    //   1294: aload_0
    //   1295: invokespecial h : ()V
    //   1298: aload #14
    //   1300: monitorexit
    //   1301: goto -> 1331
    //   1304: astore #15
    //   1306: aload #14
    //   1308: monitorexit
    //   1309: aload #15
    //   1311: athrow
    //   1312: aload_0
    //   1313: aload_0
    //   1314: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1317: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1320: aload_0
    //   1321: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1324: ifnull -> 1331
    //   1327: aload_0
    //   1328: invokespecial h : ()V
    //   1331: aload_0
    //   1332: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1335: astore #14
    //   1337: aload #14
    //   1339: ifnull -> 1347
    //   1342: aload #14
    //   1344: invokevirtual b : ()V
    //   1347: aload_0
    //   1348: getfield b : Lcom/ss/android/socialbase/downloader/g/c;
    //   1351: invokevirtual V : ()Z
    //   1354: ifeq -> 1358
    //   1357: return
    //   1358: aload_0
    //   1359: getfield l : J
    //   1362: aload_0
    //   1363: getfield m : J
    //   1366: lsub
    //   1367: lstore #7
    //   1369: lload #7
    //   1371: lconst_0
    //   1372: lcmp
    //   1373: iflt -> 1482
    //   1376: aload_0
    //   1377: getfield o : J
    //   1380: lconst_0
    //   1381: lcmp
    //   1382: iflt -> 1482
    //   1385: aload_0
    //   1386: getfield o : J
    //   1389: lload #7
    //   1391: lcmp
    //   1392: ifne -> 1396
    //   1395: return
    //   1396: new com/ss/android/socialbase/downloader/e/a
    //   1399: dup
    //   1400: sipush #1051
    //   1403: ldc_w 'handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d'
    //   1406: bipush #7
    //   1408: anewarray java/lang/Object
    //   1411: dup
    //   1412: iconst_0
    //   1413: lload #7
    //   1415: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1418: aastore
    //   1419: dup
    //   1420: iconst_1
    //   1421: lload_3
    //   1422: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1425: aastore
    //   1426: dup
    //   1427: iconst_2
    //   1428: aload_0
    //   1429: getfield o : J
    //   1432: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1435: aastore
    //   1436: dup
    //   1437: iconst_3
    //   1438: lload #5
    //   1440: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1443: aastore
    //   1444: dup
    //   1445: iconst_4
    //   1446: aload_0
    //   1447: getfield n : J
    //   1450: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1453: aastore
    //   1454: dup
    //   1455: iconst_5
    //   1456: aload_0
    //   1457: getfield l : J
    //   1460: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1463: aastore
    //   1464: dup
    //   1465: bipush #6
    //   1467: aload_0
    //   1468: getfield m : J
    //   1471: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1474: aastore
    //   1475: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1478: invokespecial <init> : (ILjava/lang/String;)V
    //   1481: athrow
    //   1482: return
    //   1483: astore #14
    //   1485: aload_0
    //   1486: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1489: astore #15
    //   1491: aload #15
    //   1493: ifnull -> 1511
    //   1496: aload #15
    //   1498: invokevirtual b : ()V
    //   1501: goto -> 1511
    //   1504: astore #15
    //   1506: aload #15
    //   1508: invokevirtual printStackTrace : ()V
    //   1511: aload #14
    //   1513: athrow
    //   1514: astore #14
    //   1516: aload #15
    //   1518: astore #16
    //   1520: getstatic com/ss/android/socialbase/downloader/downloader/d.a : Ljava/lang/String;
    //   1523: astore #17
    //   1525: aload #15
    //   1527: astore #16
    //   1529: new java/lang/StringBuilder
    //   1532: dup
    //   1533: invokespecial <init> : ()V
    //   1536: astore #18
    //   1538: aload #15
    //   1540: astore #16
    //   1542: aload #18
    //   1544: ldc_w 'handleResponse: BaseException e = '
    //   1547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: pop
    //   1551: aload #15
    //   1553: astore #16
    //   1555: aload #18
    //   1557: aload #14
    //   1559: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: aload #15
    //   1565: astore #16
    //   1567: aload #17
    //   1569: aload #18
    //   1571: invokevirtual toString : ()Ljava/lang/String;
    //   1574: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1577: aload #15
    //   1579: astore #16
    //   1581: aload_0
    //   1582: getfield q : Lcom/ss/android/socialbase/downloader/k/a;
    //   1585: ldc_w 'ignore_base_ex_on_stop_status'
    //   1588: invokevirtual a : (Ljava/lang/String;)Z
    //   1591: ifeq -> 1752
    //   1594: aload #15
    //   1596: astore #16
    //   1598: aload_0
    //   1599: invokespecial f : ()Z
    //   1602: istore #13
    //   1604: iload #13
    //   1606: ifeq -> 1752
    //   1609: aload #15
    //   1611: ifnull -> 1621
    //   1614: aload #15
    //   1616: invokeinterface b : ()V
    //   1621: aload_0
    //   1622: getfield p : Z
    //   1625: ifeq -> 1677
    //   1628: aload_0
    //   1629: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   1632: astore #14
    //   1634: aload #14
    //   1636: monitorenter
    //   1637: aload_0
    //   1638: getfield j : Z
    //   1641: ifne -> 1663
    //   1644: aload_0
    //   1645: aload_0
    //   1646: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1649: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1652: aload_0
    //   1653: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1656: ifnull -> 1663
    //   1659: aload_0
    //   1660: invokespecial h : ()V
    //   1663: aload #14
    //   1665: monitorexit
    //   1666: goto -> 1696
    //   1669: astore #15
    //   1671: aload #14
    //   1673: monitorexit
    //   1674: aload #15
    //   1676: athrow
    //   1677: aload_0
    //   1678: aload_0
    //   1679: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1682: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1685: aload_0
    //   1686: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1689: ifnull -> 1696
    //   1692: aload_0
    //   1693: invokespecial h : ()V
    //   1696: aload_0
    //   1697: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1700: astore #14
    //   1702: aload #14
    //   1704: ifnull -> 1720
    //   1707: aload #14
    //   1709: invokevirtual b : ()V
    //   1712: return
    //   1713: astore #14
    //   1715: aload #14
    //   1717: invokevirtual printStackTrace : ()V
    //   1720: return
    //   1721: astore #14
    //   1723: aload_0
    //   1724: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1727: astore #15
    //   1729: aload #15
    //   1731: ifnull -> 1749
    //   1734: aload #15
    //   1736: invokevirtual b : ()V
    //   1739: goto -> 1749
    //   1742: astore #15
    //   1744: aload #15
    //   1746: invokevirtual printStackTrace : ()V
    //   1749: aload #14
    //   1751: athrow
    //   1752: aload #15
    //   1754: astore #16
    //   1756: invokestatic a : ()Z
    //   1759: ifeq -> 1771
    //   1762: aload #15
    //   1764: astore #16
    //   1766: aload #14
    //   1768: invokevirtual printStackTrace : ()V
    //   1771: aload #15
    //   1773: astore #16
    //   1775: aload #14
    //   1777: athrow
    //   1778: astore #14
    //   1780: aload #16
    //   1782: ifnull -> 1792
    //   1785: aload #16
    //   1787: invokeinterface b : ()V
    //   1792: aload_0
    //   1793: getfield p : Z
    //   1796: ifeq -> 1848
    //   1799: aload_0
    //   1800: getfield k : Lcom/ss/android/socialbase/downloader/l/e;
    //   1803: astore #15
    //   1805: aload #15
    //   1807: monitorenter
    //   1808: aload_0
    //   1809: getfield j : Z
    //   1812: ifne -> 1834
    //   1815: aload_0
    //   1816: aload_0
    //   1817: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1820: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1823: aload_0
    //   1824: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1827: ifnull -> 1834
    //   1830: aload_0
    //   1831: invokespecial h : ()V
    //   1834: aload #15
    //   1836: monitorexit
    //   1837: goto -> 1867
    //   1840: astore #14
    //   1842: aload #15
    //   1844: monitorexit
    //   1845: aload #14
    //   1847: athrow
    //   1848: aload_0
    //   1849: aload_0
    //   1850: getfield f : Lcom/ss/android/socialbase/downloader/impls/k;
    //   1853: invokespecial a : (Lcom/ss/android/socialbase/downloader/downloader/k;)V
    //   1856: aload_0
    //   1857: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1860: ifnull -> 1867
    //   1863: aload_0
    //   1864: invokespecial h : ()V
    //   1867: aload_0
    //   1868: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1871: astore #15
    //   1873: aload #15
    //   1875: ifnull -> 1893
    //   1878: aload #15
    //   1880: invokevirtual b : ()V
    //   1883: goto -> 1893
    //   1886: astore #15
    //   1888: aload #15
    //   1890: invokevirtual printStackTrace : ()V
    //   1893: aload #14
    //   1895: athrow
    //   1896: astore #14
    //   1898: aload_0
    //   1899: getfield h : Lcom/ss/android/socialbase/downloader/g/f;
    //   1902: astore #15
    //   1904: aload #15
    //   1906: ifnull -> 1924
    //   1909: aload #15
    //   1911: invokevirtual b : ()V
    //   1914: goto -> 1924
    //   1917: astore #15
    //   1919: aload #15
    //   1921: invokevirtual printStackTrace : ()V
    //   1924: aload #14
    //   1926: athrow
    //   1927: new com/ss/android/socialbase/downloader/e/f
    //   1930: dup
    //   1931: sipush #1004
    //   1934: ldc_w 'the content-length is 0'
    //   1937: invokespecial <init> : (ILjava/lang/String;)V
    //   1940: athrow
    //   1941: return
    // Exception table:
    //   from	to	target	type
    //   52	84	1514	com/ss/android/socialbase/downloader/e/a
    //   52	84	992	finally
    //   92	103	969	java/io/IOException
    //   92	103	1514	com/ss/android/socialbase/downloader/e/a
    //   92	103	992	finally
    //   111	122	1514	com/ss/android/socialbase/downloader/e/a
    //   111	122	992	finally
    //   135	142	1514	com/ss/android/socialbase/downloader/e/a
    //   135	142	992	finally
    //   150	158	1514	com/ss/android/socialbase/downloader/e/a
    //   150	158	992	finally
    //   166	177	1514	com/ss/android/socialbase/downloader/e/a
    //   166	177	992	finally
    //   185	191	1514	com/ss/android/socialbase/downloader/e/a
    //   185	191	992	finally
    //   208	224	308	finally
    //   224	250	256	finally
    //   250	253	256	finally
    //   258	261	256	finally
    //   261	264	308	finally
    //   264	283	308	finally
    //   294	299	300	java/io/IOException
    //   321	326	329	java/io/IOException
    //   347	356	1514	com/ss/android/socialbase/downloader/e/a
    //   347	356	992	finally
    //   364	370	1514	com/ss/android/socialbase/downloader/e/a
    //   364	370	992	finally
    //   388	398	1514	com/ss/android/socialbase/downloader/e/a
    //   388	398	992	finally
    //   408	425	1514	com/ss/android/socialbase/downloader/e/a
    //   408	425	992	finally
    //   435	455	1514	com/ss/android/socialbase/downloader/e/a
    //   435	455	992	finally
    //   463	479	1514	com/ss/android/socialbase/downloader/e/a
    //   463	479	992	finally
    //   487	501	1514	com/ss/android/socialbase/downloader/e/a
    //   487	501	992	finally
    //   509	518	1514	com/ss/android/socialbase/downloader/e/a
    //   509	518	992	finally
    //   526	532	1514	com/ss/android/socialbase/downloader/e/a
    //   526	532	992	finally
    //   544	553	1514	com/ss/android/socialbase/downloader/e/a
    //   544	553	992	finally
    //   561	567	1514	com/ss/android/socialbase/downloader/e/a
    //   561	567	992	finally
    //   575	578	1514	com/ss/android/socialbase/downloader/e/a
    //   575	578	992	finally
    //   578	619	924	finally
    //   622	649	924	finally
    //   649	652	924	finally
    //   660	670	1514	com/ss/android/socialbase/downloader/e/a
    //   660	670	992	finally
    //   678	688	1514	com/ss/android/socialbase/downloader/e/a
    //   678	688	992	finally
    //   696	705	1514	com/ss/android/socialbase/downloader/e/a
    //   696	705	992	finally
    //   713	719	1514	com/ss/android/socialbase/downloader/e/a
    //   713	719	992	finally
    //   727	733	1514	com/ss/android/socialbase/downloader/e/a
    //   727	733	992	finally
    //   741	747	1514	com/ss/android/socialbase/downloader/e/a
    //   741	747	992	finally
    //   770	786	874	finally
    //   786	812	818	finally
    //   812	815	818	finally
    //   820	823	818	finally
    //   823	826	874	finally
    //   826	845	874	finally
    //   856	861	864	java/io/IOException
    //   887	892	895	java/io/IOException
    //   916	924	1514	com/ss/android/socialbase/downloader/e/a
    //   916	924	992	finally
    //   926	929	924	finally
    //   937	940	1514	com/ss/android/socialbase/downloader/e/a
    //   937	940	992	finally
    //   948	969	1514	com/ss/android/socialbase/downloader/e/a
    //   948	969	992	finally
    //   979	992	1514	com/ss/android/socialbase/downloader/e/a
    //   979	992	992	finally
    //   998	1003	1778	finally
    //   1007	1016	1778	finally
    //   1020	1029	1778	finally
    //   1033	1041	1778	finally
    //   1045	1055	1778	finally
    //   1059	1065	1778	finally
    //   1082	1098	1182	finally
    //   1098	1124	1130	finally
    //   1124	1127	1130	finally
    //   1132	1135	1130	finally
    //   1135	1138	1182	finally
    //   1138	1157	1182	finally
    //   1168	1173	1174	java/io/IOException
    //   1195	1200	1203	java/io/IOException
    //   1217	1223	1778	finally
    //   1227	1232	1778	finally
    //   1236	1244	1778	finally
    //   1256	1272	1483	finally
    //   1272	1298	1304	finally
    //   1298	1301	1304	finally
    //   1306	1309	1304	finally
    //   1309	1312	1483	finally
    //   1312	1331	1483	finally
    //   1342	1347	864	java/io/IOException
    //   1496	1501	1504	java/io/IOException
    //   1520	1525	1778	finally
    //   1529	1538	1778	finally
    //   1542	1551	1778	finally
    //   1555	1563	1778	finally
    //   1567	1577	1778	finally
    //   1581	1594	1778	finally
    //   1598	1604	1778	finally
    //   1621	1637	1721	finally
    //   1637	1663	1669	finally
    //   1663	1666	1669	finally
    //   1671	1674	1669	finally
    //   1674	1677	1721	finally
    //   1677	1696	1721	finally
    //   1707	1712	1713	java/io/IOException
    //   1734	1739	1742	java/io/IOException
    //   1756	1762	1778	finally
    //   1766	1771	1778	finally
    //   1775	1778	1778	finally
    //   1792	1808	1896	finally
    //   1808	1834	1840	finally
    //   1834	1837	1840	finally
    //   1842	1845	1840	finally
    //   1845	1848	1896	finally
    //   1848	1867	1896	finally
    //   1878	1883	1886	java/io/IOException
    //   1909	1914	1917	java/io/IOException
  }
  
  public long e() {
    return this.w;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */