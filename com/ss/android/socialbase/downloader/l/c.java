package com.ss.android.socialbase.downloader.l;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.b.j;
import com.ss.android.socialbase.downloader.b.k;
import com.ss.android.socialbase.downloader.d.o;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.d.u;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.e.b;
import com.ss.android.socialbase.downloader.e.d;
import com.ss.android.socialbase.downloader.e.e;
import com.ss.android.socialbase.downloader.e.f;
import com.ss.android.socialbase.downloader.e.g;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.e;
import com.ss.android.socialbase.downloader.impls.q;
import com.ss.android.socialbase.downloader.m.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class c implements e, Runnable {
  private static final String a = c.class.getSimpleName();
  
  private u A;
  
  private p B;
  
  private volatile int C = 5;
  
  private boolean D = false;
  
  private boolean E = false;
  
  private String F;
  
  private long G;
  
  private Future b;
  
  private final d c;
  
  private volatile boolean d = false;
  
  private AtomicInteger e;
  
  private final ArrayList<b> f = new ArrayList<b>();
  
  private volatile d g;
  
  private boolean h;
  
  private boolean i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private final AtomicBoolean m;
  
  private volatile k n = k.a;
  
  private final k o;
  
  private com.ss.android.socialbase.downloader.g.c p;
  
  private i q;
  
  private final i r;
  
  private h s;
  
  private final h t;
  
  private r u;
  
  private final e v;
  
  private AlarmManager w;
  
  private volatile com.ss.android.socialbase.downloader.e.a x;
  
  private e y;
  
  private com.ss.android.socialbase.downloader.i.c z;
  
  public c(d paramd, Handler paramHandler) {
    this.c = paramd;
    if (paramd != null) {
      this.p = paramd.a();
      this.q = paramd.f();
      this.s = paramd.q();
      this.A = paramd.h();
      this.B = paramd.i();
      this.u = a(paramd);
    } 
    h();
    this.o = b.p();
    this.r = b.x();
    this.t = b.z();
    this.v = new e(paramd, paramHandler);
    this.w = b.h();
    this.m = new AtomicBoolean(true);
  }
  
  private void A() throws f {
    if (!this.p.x() || f.a(b.B(), "android.permission.ACCESS_NETWORK_STATE")) {
      if (this.p.aA())
        return; 
      throw new d();
    } 
    throw new f(1019, String.format("download task need permission:%s", new Object[] { "android.permission.ACCESS_NETWORK_STATE" }));
  }
  
  private void B() throws com.ss.android.socialbase.downloader.e.a {
    if (!TextUtils.isEmpty(this.p.k())) {
      if (!TextUtils.isEmpty(this.p.h())) {
        File file = new File(this.p.k());
        if (!file.exists()) {
          if (file.mkdirs())
            return; 
          throw new com.ss.android.socialbase.downloader.e.a(1030, "download savePath directory can not created");
        } 
        if (file.isDirectory())
          return; 
        throw new com.ss.android.socialbase.downloader.e.a(1031, "download savePath is not a directory");
      } 
      throw new com.ss.android.socialbase.downloader.e.a(1029, "download name can not be empty");
    } 
    throw new com.ss.android.socialbase.downloader.e.a(1028, "download savePath can not be empty");
  }
  
  private void C() {
    boolean bool;
    long l = f.e(this.p);
    this.p.a(l);
    if (l > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    this.i = bool;
    if (!this.i) {
      this.o.d(this.p.g());
      f.a(this.p);
    } 
  }
  
  private void D() {
    try {
      this.o.d(this.p.g());
      f.a(this.p);
      this.i = false;
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  private void E() {
    try {
    
    } finally {
      Exception exception = null;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancelAllChunkRunnable: ");
      stringBuilder.append(exception.toString());
    } 
  }
  
  private void F() {
    if (r())
      return; 
    com.ss.android.socialbase.downloader.impls.a a1 = b.t();
    if (a1 != null)
      a1.l(this.p.g()); 
  }
  
  private boolean G() {
    if (this.n != k.f && this.w != null && this.p.aj() && w() > 0L) {
      this.n = k.f;
      return true;
    } 
    return false;
  }
  
  private int a(long paramLong, List<b> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial y : ()Z
    //   4: ifeq -> 164
    //   7: aload_0
    //   8: getfield i : Z
    //   11: ifeq -> 41
    //   14: aload_3
    //   15: ifnull -> 29
    //   18: aload_3
    //   19: invokeinterface size : ()I
    //   24: istore #4
    //   26: goto -> 155
    //   29: aload_0
    //   30: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   33: invokevirtual aV : ()I
    //   36: istore #4
    //   38: goto -> 155
    //   41: aload_0
    //   42: getfield q : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull -> 62
    //   50: aload_3
    //   51: lload_1
    //   52: invokeinterface a : (J)I
    //   57: istore #4
    //   59: goto -> 74
    //   62: aload_0
    //   63: getfield r : Lcom/ss/android/socialbase/downloader/downloader/i;
    //   66: lload_1
    //   67: invokeinterface a : (J)I
    //   72: istore #4
    //   74: invokestatic a : ()Lcom/ss/android/socialbase/downloader/i/g;
    //   77: invokevirtual b : ()Lcom/ss/android/socialbase/downloader/i/h;
    //   80: astore_3
    //   81: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   84: ldc_w 'NetworkQuality is : %s'
    //   87: iconst_1
    //   88: anewarray java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_3
    //   94: invokevirtual name : ()Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   108: aload_3
    //   109: invokevirtual name : ()Ljava/lang/String;
    //   112: invokevirtual e : (Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield s : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   119: astore #6
    //   121: aload #6
    //   123: ifnull -> 141
    //   126: aload #6
    //   128: iload #4
    //   130: aload_3
    //   131: invokeinterface a : (ILcom/ss/android/socialbase/downloader/i/h;)I
    //   136: istore #4
    //   138: goto -> 155
    //   141: aload_0
    //   142: getfield t : Lcom/ss/android/socialbase/downloader/downloader/h;
    //   145: iload #4
    //   147: aload_3
    //   148: invokeinterface a : (ILcom/ss/android/socialbase/downloader/i/h;)I
    //   153: istore #4
    //   155: iload #4
    //   157: istore #5
    //   159: iload #4
    //   161: ifgt -> 167
    //   164: iconst_1
    //   165: istore #5
    //   167: invokestatic a : ()Z
    //   170: ifeq -> 214
    //   173: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   176: ldc_w 'chunk count : %s for %s contentLen:%s'
    //   179: iconst_3
    //   180: anewarray java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: iload #5
    //   187: invokestatic valueOf : (I)Ljava/lang/String;
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: aload_0
    //   194: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   197: invokevirtual h : ()Ljava/lang/String;
    //   200: aastore
    //   201: dup
    //   202: iconst_2
    //   203: lload_1
    //   204: invokestatic valueOf : (J)Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   214: iload #5
    //   216: ireturn
  }
  
  private r a(d paramd) {
    r r1 = paramd.g();
    if (r1 != null)
      return r1; 
    com.ss.android.socialbase.downloader.g.c c1 = paramd.a();
    if (c1 != null) {
      String str = c1.ak();
      if (!TextUtils.isEmpty(str))
        return (r)new q(str); 
    } 
    return b.A();
  }
  
  private b a(b paramb, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual d : ()Z
    //   4: istore #4
    //   6: aconst_null
    //   7: astore #7
    //   9: aconst_null
    //   10: astore #9
    //   12: iload #4
    //   14: ifne -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_1
    //   20: iconst_1
    //   21: invokevirtual c : (Z)J
    //   24: lstore #5
    //   26: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   29: astore #8
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #10
    //   40: aload #10
    //   42: ldc_w 'reuseChunk retainLen:'
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload #10
    //   51: lload #5
    //   53: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #10
    //   59: ldc_w ' chunkIndex:'
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #10
    //   68: iload_2
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #8
    //   75: aload #10
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   83: iconst_0
    //   84: istore_3
    //   85: aload_1
    //   86: invokevirtual f : ()Z
    //   89: ifne -> 181
    //   92: lload #5
    //   94: getstatic com/ss/android/socialbase/downloader/b/e.a : J
    //   97: lcmp
    //   98: ifle -> 181
    //   101: aload_0
    //   102: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   105: invokevirtual p : ()Z
    //   108: ifeq -> 181
    //   111: aload_1
    //   112: aload_0
    //   113: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   116: invokevirtual aV : ()I
    //   119: aload_0
    //   120: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   123: invokevirtual ab : ()J
    //   126: invokevirtual a : (IJ)Ljava/util/List;
    //   129: astore #8
    //   131: aload #8
    //   133: ifnull -> 188
    //   136: aload #8
    //   138: invokeinterface iterator : ()Ljava/util/Iterator;
    //   143: astore #8
    //   145: aload #8
    //   147: invokeinterface hasNext : ()Z
    //   152: ifeq -> 188
    //   155: aload #8
    //   157: invokeinterface next : ()Ljava/lang/Object;
    //   162: checkcast com/ss/android/socialbase/downloader/g/b
    //   165: astore #10
    //   167: aload_0
    //   168: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   171: aload #10
    //   173: invokeinterface b : (Lcom/ss/android/socialbase/downloader/g/b;)V
    //   178: goto -> 145
    //   181: aload_1
    //   182: invokevirtual f : ()Z
    //   185: ifeq -> 190
    //   188: iconst_1
    //   189: istore_3
    //   190: aload #7
    //   192: astore #8
    //   194: iload_3
    //   195: ifeq -> 538
    //   198: aload #7
    //   200: astore #8
    //   202: aload_1
    //   203: invokevirtual f : ()Z
    //   206: ifeq -> 538
    //   209: iconst_1
    //   210: istore_3
    //   211: aload #9
    //   213: astore #7
    //   215: iload_3
    //   216: aload_1
    //   217: invokevirtual g : ()Ljava/util/List;
    //   220: invokeinterface size : ()I
    //   225: if_icmpge -> 386
    //   228: aload_1
    //   229: invokevirtual g : ()Ljava/util/List;
    //   232: iload_3
    //   233: invokeinterface get : (I)Ljava/lang/Object;
    //   238: checkcast com/ss/android/socialbase/downloader/g/b
    //   241: astore #7
    //   243: aload #7
    //   245: ifnull -> 379
    //   248: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   251: astore #8
    //   253: new java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial <init> : ()V
    //   260: astore #10
    //   262: aload #10
    //   264: ldc_w 'check can checkUnCompletedChunk -- chunkIndex:'
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #10
    //   273: aload #7
    //   275: invokevirtual s : ()I
    //   278: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload #10
    //   284: ldc_w ' currentOffset:'
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload #10
    //   293: aload #7
    //   295: invokevirtual n : ()J
    //   298: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #10
    //   304: ldc_w '  startOffset:'
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #10
    //   313: aload #7
    //   315: invokevirtual l : ()J
    //   318: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload #10
    //   324: ldc_w ' contentLen:'
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #10
    //   333: aload #7
    //   335: invokevirtual q : ()J
    //   338: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload #8
    //   344: aload #10
    //   346: invokevirtual toString : ()Ljava/lang/String;
    //   349: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload #7
    //   354: invokevirtual s : ()I
    //   357: iflt -> 376
    //   360: aload #7
    //   362: invokevirtual i : ()Z
    //   365: ifne -> 379
    //   368: aload #7
    //   370: invokevirtual c : ()Z
    //   373: ifne -> 379
    //   376: goto -> 386
    //   379: iload_3
    //   380: iconst_1
    //   381: iadd
    //   382: istore_3
    //   383: goto -> 211
    //   386: aload #7
    //   388: astore #8
    //   390: aload #7
    //   392: ifnull -> 538
    //   395: aload_1
    //   396: invokevirtual n : ()J
    //   399: lstore #5
    //   401: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   404: astore #8
    //   406: new java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial <init> : ()V
    //   413: astore #9
    //   415: aload #9
    //   417: ldc_w 'unComplete chunk '
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload #9
    //   426: aload_1
    //   427: invokevirtual s : ()I
    //   430: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload #9
    //   436: ldc_w ' curOffset:'
    //   439: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload #9
    //   445: lload #5
    //   447: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload #9
    //   453: ldc_w ' reuseChunk chunkIndex:'
    //   456: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload #9
    //   462: iload_2
    //   463: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload #9
    //   469: ldc_w ' for subChunk:'
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload #9
    //   478: aload #7
    //   480: invokevirtual s : ()I
    //   483: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload #8
    //   489: aload #9
    //   491: invokevirtual toString : ()Ljava/lang/String;
    //   494: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload_0
    //   498: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   501: aload #7
    //   503: invokevirtual k : ()I
    //   506: aload #7
    //   508: invokevirtual s : ()I
    //   511: aload #7
    //   513: invokevirtual b : ()I
    //   516: iload_2
    //   517: invokeinterface a : (IIII)V
    //   522: aload #7
    //   524: iload_2
    //   525: invokevirtual c : (I)V
    //   528: aload #7
    //   530: iconst_1
    //   531: invokevirtual a : (Z)V
    //   534: aload #7
    //   536: astore #8
    //   538: aload #8
    //   540: areturn
  }
  
  private List<e> a(b paramb) {
    return f.a(this.p.B(), this.p.ac(), paramb);
  }
  
  private void a(int paramInt, List<b> paramList) throws com.ss.android.socialbase.downloader.e.a {
    if (paramList.size() == paramInt) {
      a(paramList, this.p.ab());
      return;
    } 
    throw new com.ss.android.socialbase.downloader.e.a(1033, new IllegalArgumentException());
  }
  
  private void a(long paramLong, int paramInt) throws com.ss.android.socialbase.downloader.e.a {
    long l2 = paramLong / paramInt;
    int m = this.p.g();
    ArrayList<b> arrayList = new ArrayList();
    int j = 0;
    long l1 = 0L;
    while (j < paramInt) {
      long l;
      if (j == paramInt - 1) {
        l = 0L;
      } else {
        l = l1 + l2 - 1L;
      } 
      b b = (new b.a(m)).a(j).a(l1).e(l1).b(l1).c(l).a();
      arrayList.add(b);
      this.o.a(b);
      l1 += l2;
      j++;
    } 
    this.p.c(paramInt);
    this.o.a(m, paramInt);
    a(arrayList, paramLong);
  }
  
  private void a(long paramLong, String paramString1, String paramString2) throws com.ss.android.socialbase.downloader.e.a {
    // Byte code:
    //   0: lload_1
    //   1: lstore #6
    //   3: lload_1
    //   4: invokestatic b : (J)Z
    //   7: ifeq -> 11
    //   10: return
    //   11: aload_3
    //   12: aload #4
    //   14: iconst_m1
    //   15: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)Lcom/ss/android/socialbase/downloader/g/f;
    //   18: astore #17
    //   20: new java/io/File
    //   23: dup
    //   24: aload_3
    //   25: aload #4
    //   27: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokevirtual length : ()J
    //   33: lstore #14
    //   35: lload #6
    //   37: lload #14
    //   39: lsub
    //   40: lstore #12
    //   42: aload_3
    //   43: invokestatic c : (Ljava/lang/String;)J
    //   46: lstore #10
    //   48: aload_0
    //   49: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   52: invokevirtual g : ()I
    //   55: invokestatic a : (I)Lcom/ss/android/socialbase/downloader/k/a;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 'space_fill_part_download'
    //   63: iconst_0
    //   64: invokevirtual a : (Ljava/lang/String;I)I
    //   67: istore #5
    //   69: iload #5
    //   71: iconst_1
    //   72: if_icmpne -> 454
    //   75: aload_0
    //   76: lconst_0
    //   77: putfield G : J
    //   80: lload #12
    //   82: lstore #8
    //   84: lload #12
    //   86: lconst_0
    //   87: lcmp
    //   88: ifgt -> 108
    //   91: aload_0
    //   92: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   95: invokevirtual ab : ()J
    //   98: aload_0
    //   99: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   102: invokevirtual Z : ()J
    //   105: lsub
    //   106: lstore #8
    //   108: lload #10
    //   110: lload #8
    //   112: lcmp
    //   113: ifge -> 911
    //   116: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   119: astore #4
    //   121: new java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial <init> : ()V
    //   128: astore #18
    //   130: aload #18
    //   132: ldc_w 'checkSpaceOverflow: contentLength = '
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload #18
    //   141: lload_1
    //   142: invokestatic a : (J)D
    //   145: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #18
    //   151: ldc_w 'MB, downloaded = '
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #18
    //   160: lload #14
    //   162: invokestatic a : (J)D
    //   165: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload #18
    //   171: ldc_w 'MB, required = '
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #18
    //   180: lload #8
    //   182: invokestatic a : (J)D
    //   185: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #18
    //   191: ldc_w 'MB, available = '
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #18
    //   200: lload #10
    //   202: invokestatic a : (J)D
    //   205: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #18
    //   211: ldc_w 'MB'
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload #4
    //   220: aload #18
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   228: lload #10
    //   230: lconst_0
    //   231: lcmp
    //   232: istore #5
    //   234: iload #5
    //   236: ifle -> 371
    //   239: aload_3
    //   240: ldc_w 'space_fill_min_keep_mb'
    //   243: bipush #100
    //   245: invokevirtual a : (Ljava/lang/String;I)I
    //   248: istore #5
    //   250: iload #5
    //   252: ifle -> 857
    //   255: lload #10
    //   257: iload #5
    //   259: i2l
    //   260: ldc2_w 1048576
    //   263: lmul
    //   264: lsub
    //   265: lstore #6
    //   267: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   270: astore_3
    //   271: new java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial <init> : ()V
    //   278: astore #4
    //   280: aload #4
    //   282: ldc_w 'checkSpaceOverflow: minKeep = '
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload #4
    //   291: iload #5
    //   293: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #4
    //   299: ldc_w 'MB, canDownload = '
    //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload #4
    //   308: lload #6
    //   310: invokestatic a : (J)D
    //   313: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #4
    //   319: ldc_w 'MB'
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_3
    //   327: aload #4
    //   329: invokevirtual toString : ()Ljava/lang/String;
    //   332: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   335: lload #6
    //   337: lconst_0
    //   338: lcmp
    //   339: ifle -> 359
    //   342: aload_0
    //   343: aload_0
    //   344: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   347: invokevirtual Z : ()J
    //   350: lload #6
    //   352: ladd
    //   353: putfield G : J
    //   356: goto -> 861
    //   359: new com/ss/android/socialbase/downloader/e/e
    //   362: dup
    //   363: lload #10
    //   365: lload #8
    //   367: invokespecial <init> : (JJ)V
    //   370: athrow
    //   371: aload_3
    //   372: ldc_w 'download_when_space_negative'
    //   375: iconst_0
    //   376: invokevirtual a : (Ljava/lang/String;I)I
    //   379: iconst_1
    //   380: if_icmpne -> 392
    //   383: aload #17
    //   385: astore_3
    //   386: iconst_0
    //   387: istore #16
    //   389: goto -> 549
    //   392: new java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial <init> : ()V
    //   399: astore #4
    //   401: aload #4
    //   403: ldc_w 'availableSpace '
    //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: iload #5
    //   412: ifne -> 904
    //   415: ldc_w '='
    //   418: astore_3
    //   419: goto -> 422
    //   422: aload #4
    //   424: aload_3
    //   425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload #4
    //   431: ldc_w ' 0'
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: new com/ss/android/socialbase/downloader/e/a
    //   441: dup
    //   442: sipush #1052
    //   445: aload #4
    //   447: invokevirtual toString : ()Ljava/lang/String;
    //   450: invokespecial <init> : (ILjava/lang/String;)V
    //   453: athrow
    //   454: lload #10
    //   456: lconst_0
    //   457: lcmp
    //   458: istore #5
    //   460: iload #5
    //   462: ifgt -> 535
    //   465: new java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial <init> : ()V
    //   472: astore #4
    //   474: aload #4
    //   476: ldc_w 'availableSpace '
    //   479: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: iload #5
    //   485: ifne -> 922
    //   488: ldc_w '='
    //   491: astore_3
    //   492: goto -> 495
    //   495: aload #4
    //   497: aload_3
    //   498: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload #4
    //   504: ldc_w ' 0'
    //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: new com/ss/android/socialbase/downloader/e/a
    //   514: dup
    //   515: sipush #1052
    //   518: aload #4
    //   520: invokevirtual toString : ()Ljava/lang/String;
    //   523: invokespecial <init> : (ILjava/lang/String;)V
    //   526: athrow
    //   527: astore_3
    //   528: aload #17
    //   530: astore #4
    //   532: goto -> 835
    //   535: lload #10
    //   537: lload #12
    //   539: lcmp
    //   540: iflt -> 810
    //   543: iconst_1
    //   544: istore #16
    //   546: aload #17
    //   548: astore_3
    //   549: aload_3
    //   550: lload_1
    //   551: invokevirtual b : (J)V
    //   554: goto -> 779
    //   557: astore #17
    //   559: aload_3
    //   560: astore #4
    //   562: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   565: astore #18
    //   567: aload_3
    //   568: astore #4
    //   570: new java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial <init> : ()V
    //   577: astore #19
    //   579: aload_3
    //   580: astore #4
    //   582: aload #19
    //   584: ldc_w 'checkSpaceOverflow: setLength1 e = '
    //   587: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_3
    //   592: astore #4
    //   594: aload #19
    //   596: aload #17
    //   598: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_3
    //   603: astore #4
    //   605: aload #19
    //   607: ldc_w ', mustSetLength = '
    //   610: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_3
    //   615: astore #4
    //   617: aload #19
    //   619: iload #16
    //   621: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload_3
    //   626: astore #4
    //   628: aload #18
    //   630: aload #19
    //   632: invokevirtual toString : ()Ljava/lang/String;
    //   635: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   638: lload #6
    //   640: lload_1
    //   641: lcmp
    //   642: ifge -> 774
    //   645: lload #6
    //   647: lconst_0
    //   648: lcmp
    //   649: ifle -> 774
    //   652: lload #6
    //   654: lload #14
    //   656: lcmp
    //   657: ifle -> 774
    //   660: aload_3
    //   661: lload #6
    //   663: invokevirtual b : (J)V
    //   666: goto -> 779
    //   669: astore #17
    //   671: aload_3
    //   672: astore #4
    //   674: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   677: astore #18
    //   679: aload_3
    //   680: astore #4
    //   682: new java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial <init> : ()V
    //   689: astore #19
    //   691: aload_3
    //   692: astore #4
    //   694: aload #19
    //   696: ldc_w 'checkSpaceOverflow: setLength2 ex = '
    //   699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload_3
    //   704: astore #4
    //   706: aload #19
    //   708: aload #17
    //   710: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_3
    //   715: astore #4
    //   717: aload #19
    //   719: ldc_w ', mustSetLength = '
    //   722: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_3
    //   727: astore #4
    //   729: aload #19
    //   731: iload #16
    //   733: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload_3
    //   738: astore #4
    //   740: aload #18
    //   742: aload #19
    //   744: invokevirtual toString : ()Ljava/lang/String;
    //   747: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   750: iload #16
    //   752: ifne -> 758
    //   755: goto -> 779
    //   758: aload_3
    //   759: astore #4
    //   761: new com/ss/android/socialbase/downloader/e/a
    //   764: dup
    //   765: sipush #1040
    //   768: aload #17
    //   770: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   773: athrow
    //   774: iload #16
    //   776: ifne -> 794
    //   779: aload_3
    //   780: ifnull -> 793
    //   783: aload_3
    //   784: invokevirtual b : ()V
    //   787: return
    //   788: astore_3
    //   789: aload_3
    //   790: invokevirtual printStackTrace : ()V
    //   793: return
    //   794: aload_3
    //   795: astore #4
    //   797: new com/ss/android/socialbase/downloader/e/a
    //   800: dup
    //   801: sipush #1040
    //   804: aload #17
    //   806: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   809: athrow
    //   810: aload #17
    //   812: astore #4
    //   814: new com/ss/android/socialbase/downloader/e/e
    //   817: dup
    //   818: lload #10
    //   820: lload #12
    //   822: invokespecial <init> : (JJ)V
    //   825: athrow
    //   826: astore_3
    //   827: goto -> 835
    //   830: astore_3
    //   831: aload #17
    //   833: astore #4
    //   835: aload #4
    //   837: ifnull -> 855
    //   840: aload #4
    //   842: invokevirtual b : ()V
    //   845: goto -> 855
    //   848: astore #4
    //   850: aload #4
    //   852: invokevirtual printStackTrace : ()V
    //   855: aload_3
    //   856: athrow
    //   857: lload #10
    //   859: lstore #6
    //   861: lload_1
    //   862: lstore #8
    //   864: lload #14
    //   866: lload #8
    //   868: lcmp
    //   869: ifge -> 891
    //   872: lload #6
    //   874: lload #14
    //   876: ladd
    //   877: lstore #10
    //   879: lload #10
    //   881: lstore #6
    //   883: lload #10
    //   885: lload #8
    //   887: lcmp
    //   888: ifle -> 895
    //   891: lload #8
    //   893: lstore #6
    //   895: aload #17
    //   897: astore_3
    //   898: iconst_1
    //   899: istore #16
    //   901: goto -> 549
    //   904: ldc_w '<'
    //   907: astore_3
    //   908: goto -> 422
    //   911: goto -> 543
    //   914: astore_3
    //   915: aload #17
    //   917: astore #4
    //   919: goto -> 835
    //   922: ldc_w '<'
    //   925: astore_3
    //   926: goto -> 495
    // Exception table:
    //   from	to	target	type
    //   20	35	830	finally
    //   42	69	830	finally
    //   75	80	914	finally
    //   91	108	914	finally
    //   116	228	914	finally
    //   239	250	914	finally
    //   267	280	914	finally
    //   280	335	527	finally
    //   342	356	527	finally
    //   359	371	527	finally
    //   371	383	527	finally
    //   392	410	527	finally
    //   422	454	527	finally
    //   465	483	527	finally
    //   495	527	527	finally
    //   549	554	557	finally
    //   562	567	826	finally
    //   570	579	826	finally
    //   582	591	826	finally
    //   594	602	826	finally
    //   605	614	826	finally
    //   617	625	826	finally
    //   628	638	826	finally
    //   660	666	669	finally
    //   674	679	826	finally
    //   682	691	826	finally
    //   694	703	826	finally
    //   706	714	826	finally
    //   717	726	826	finally
    //   729	737	826	finally
    //   740	750	826	finally
    //   761	774	826	finally
    //   783	787	788	java/lang/Exception
    //   797	810	826	finally
    //   814	826	826	finally
    //   840	845	848	java/lang/Exception
  }
  
  private void a(b paramb, e parame) throws com.ss.android.socialbase.downloader.e.a {
    paramb.a(this.p.ab() - paramb.n());
    this.p.c(1);
    this.o.a(this.p.g(), 1);
    this.g = new d(this.p, parame, paramb, this);
    p();
  }
  
  private void a(com.ss.android.socialbase.downloader.i.c paramc, long paramLong) throws com.ss.android.socialbase.downloader.e.a, a {
    if (paramc == null)
      return; 
    try {
      int j = paramc.b();
      String str1 = paramc.a("Accept-Ranges");
      String str2 = paramc.a("Content-Type");
      if (TextUtils.isEmpty(this.p.ah()) && !TextUtils.isEmpty(str2))
        this.p.g(str2); 
      this.j = f.a(j, str1);
      this.k = f.a(j);
      this.p.h(this.j);
      String str3 = this.p.ac();
      str2 = paramc.a("Etag");
      boolean bool = a(j, str3, str2);
      str1 = str2;
      if (bool)
        if (paramc instanceof e) {
          str1 = str2;
          if (!TextUtils.isEmpty(str3)) {
            str1 = str2;
            if (str3.equals(str2))
              str1 = ""; 
          } 
          a(str1, "eTag of server file changed");
        } else {
          throw new com.ss.android.socialbase.downloader.e.c(1002, j, "");
        }  
      if (this.j || this.k) {
        if (this.k && paramLong > 0L)
          if (paramc instanceof e) {
            a("", "http head request not support");
          } else {
            throw new com.ss.android.socialbase.downloader.e.a(1004, "isResponseFromBegin but firstOffset > 0");
          }  
        long l = f.a(paramc);
        if (TextUtils.isEmpty(this.p.h())) {
          str2 = f.a(paramc, this.p.j());
        } else {
          str2 = "";
        } 
        if (com.ss.android.socialbase.downloader.m.c.a(8)) {
          this.l = f.c(paramc);
        } else {
          this.l = f.b(l);
        } 
        if (this.l || l != 0L || paramc instanceof e) {
          if (!this.l) {
            String str = paramc.a("Content-Range");
            if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.m.c.a(2)) {
              paramLong = f.a(str);
            } else {
              paramLong += l;
            } 
          } else {
            paramLong = -1L;
          } 
          return;
        } 
        throw new com.ss.android.socialbase.downloader.e.a(1004, "");
      } 
      if (j == 403)
        throw new com.ss.android.socialbase.downloader.e.a(1047, "response code error : 403"); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("response code error : ");
      stringBuilder.append(j);
      throw new com.ss.android.socialbase.downloader.e.c(1004, j, stringBuilder.toString());
    } catch (com.ss.android.socialbase.downloader.e.a a1) {
      throw a1;
    } catch (a a1) {
      throw a1;
    } finally {
      paramc = null;
      f.a((Throwable)paramc, "HandleFirstConnection");
    } 
  }
  
  private void a(String paramString1, String paramString2) throws a {
    this.o.d(this.p.g());
    f.a(this.p);
    this.i = false;
    this.p.h(paramString1);
    this.o.a(this.p);
    throw new a(this, paramString2);
  }
  
  private void a(String paramString, List<e> paramList) throws com.ss.android.socialbase.downloader.e.a, a {
    // Byte code:
    //   0: aload_0
    //   1: getfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   4: ifnull -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore #4
    //   11: aload_0
    //   12: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   15: invokevirtual aV : ()I
    //   18: iconst_1
    //   19: if_icmpne -> 32
    //   22: invokestatic a : ()Lcom/ss/android/socialbase/downloader/i/a/a;
    //   25: aload_1
    //   26: aload_2
    //   27: invokevirtual b : (Ljava/lang/String;Ljava/util/List;)Lcom/ss/android/socialbase/downloader/i/a/d;
    //   30: astore #4
    //   32: aload #4
    //   34: ifnull -> 62
    //   37: aload_0
    //   38: aload_0
    //   39: getfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   42: invokevirtual a : (Lcom/ss/android/socialbase/downloader/i/c;)V
    //   45: aload_0
    //   46: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   49: iconst_2
    //   50: invokevirtual l : (I)V
    //   53: aload_0
    //   54: aload #4
    //   56: putfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   59: goto -> 149
    //   62: aload_0
    //   63: aload_0
    //   64: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   67: invokevirtual o : ()Z
    //   70: aload_0
    //   71: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   74: invokevirtual C : ()I
    //   77: aload_1
    //   78: aload_2
    //   79: invokestatic a : (ZILjava/lang/String;Ljava/util/List;)Lcom/ss/android/socialbase/downloader/i/e;
    //   82: putfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   85: aload_0
    //   86: aload_0
    //   87: getfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   90: invokevirtual a : (Lcom/ss/android/socialbase/downloader/i/c;)V
    //   93: goto -> 149
    //   96: astore_1
    //   97: aload_1
    //   98: invokestatic f : (Ljava/lang/Throwable;)Z
    //   101: istore_3
    //   102: iload_3
    //   103: ifeq -> 119
    //   106: aload_0
    //   107: ldc_w ''
    //   110: ldc_w 'http code 416'
    //   113: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   116: goto -> 85
    //   119: aload_1
    //   120: invokestatic e : (Ljava/lang/Throwable;)Z
    //   123: ifeq -> 139
    //   126: aload_0
    //   127: ldc_w ''
    //   130: ldc_w 'http code 412'
    //   133: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -> 85
    //   139: aload_1
    //   140: ldc_w 'CreateFirstConnection'
    //   143: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   146: goto -> 85
    //   149: aload_0
    //   150: getfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   153: ifnull -> 157
    //   156: return
    //   157: new com/ss/android/socialbase/downloader/e/a
    //   160: dup
    //   161: sipush #1022
    //   164: new java/io/IOException
    //   167: dup
    //   168: ldc_w 'download can't continue, firstConnection is null'
    //   171: invokespecial <init> : (Ljava/lang/String;)V
    //   174: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   177: athrow
    //   178: astore_1
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: aload_0
    //   183: aload_0
    //   184: getfield y : Lcom/ss/android/socialbase/downloader/i/e;
    //   187: invokevirtual a : (Lcom/ss/android/socialbase/downloader/i/c;)V
    //   190: aload_1
    //   191: athrow
    // Exception table:
    //   from	to	target	type
    //   62	85	178	com/ss/android/socialbase/downloader/e/a
    //   62	85	96	finally
    //   97	102	181	finally
    //   106	116	181	finally
    //   119	136	181	finally
    //   139	146	181	finally
    //   179	181	181	finally
  }
  
  private void a(List<String> paramList) {
    if (paramList != null) {
      boolean bool;
      if (paramList.isEmpty())
        return; 
      com.ss.android.socialbase.downloader.g.c c1 = this.p;
      if (this.n == k.g) {
        bool = true;
      } else {
        bool = false;
      } 
      c1.a(paramList, bool);
      com.ss.android.socialbase.downloader.impls.a a1 = b.t();
      if (a1 != null)
        a1.l(this.p.g()); 
    } 
  }
  
  private void a(List<b> paramList, long paramLong) throws com.ss.android.socialbase.downloader.e.a {
    for (b b1 : paramList) {
      long l;
      if (b1 == null)
        continue; 
      if (b1.p() == 0L) {
        l = paramLong - b1.n();
      } else {
        l = b1.p() - b1.n() + 1L;
      } 
      if (l <= 0L)
        continue; 
      b1.a(l);
      if (this.p.S() && this.y != null && (!this.p.U() || this.E)) {
        if (b1.s() == 0) {
          b = new b(b1, this.c, this.y, this);
          this.f.add(b);
          continue;
        } 
        if (b.s() > 0) {
          b = new b((b)b, this.c, this);
          this.f.add(b);
        } 
        continue;
      } 
      b b = new b((b)b, this.c, this);
      this.f.add(b);
    } 
    if (com.ss.android.socialbase.downloader.m.c.a(64)) {
      ArrayList<b> arrayList = new ArrayList(this.f.size());
      for (b b : this.f) {
        if (this.n == k.c) {
          b.b();
          continue;
        } 
        if (this.n == k.b) {
          b.a();
          continue;
        } 
        arrayList.add(b);
      } 
      Runnable runnable = arrayList.remove(0);
      try {
        List list = e.c(arrayList);
        while (runnable != null) {
          boolean bool = r();
          if (bool)
            return; 
          try {
            runnable.run();
          } finally {
            runnable = null;
          } 
        } 
        return;
      } finally {
        runnable = null;
      } 
    } 
    paramList = new ArrayList<b>(this.f.size());
    for (b b : this.f) {
      if (this.n == k.c) {
        b.b();
        continue;
      } 
      if (this.n == k.b) {
        b.a();
        continue;
      } 
      paramList.add(Executors.callable(b));
    } 
    if (r())
      return; 
    try {
      e.b(paramList);
      return;
    } catch (InterruptedException interruptedException) {
      throw new com.ss.android.socialbase.downloader.e.a(1020, interruptedException);
    } 
  }
  
  private boolean a(int paramInt, String paramString1, String paramString2) {
    return (paramInt == 412) ? true : ((!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2) && !paramString1.equals(paramString2) && (this.k || this.j)) ? true : (((paramInt == 201 || paramInt == 416) && this.p.Z() > 0L)));
  }
  
  private b b(long paramLong) {
    return (new b.a(this.p.g())).a(-1).a(0L).e(paramLong).b(paramLong).c(0L).d(this.p.ab() - paramLong).a();
  }
  
  private boolean d(com.ss.android.socialbase.downloader.e.a parama) {
    AtomicInteger atomicInteger = this.e;
    boolean bool = true;
    if (atomicInteger != null) {
      if (atomicInteger.get() <= 0) {
        if (this.p.aJ()) {
          this.e.set(this.p.E());
          this.p.f(this.e.get());
        } else if (parama != null && (parama.a() == 1011 || (parama.getCause() != null && parama.getCause() instanceof javax.net.ssl.SSLHandshakeException)) && this.p.aL()) {
          this.e.set(this.p.D());
          this.p.f(this.e.get());
          this.p.j(true);
        } else {
          b(new com.ss.android.socialbase.downloader.e.a(parama.a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", new Object[] { String.valueOf(this.e), String.valueOf(this.p.D()), parama.b() })));
          return true;
        } 
        bool = false;
      } 
      if (this.n != k.f && bool)
        this.p.f(this.e.decrementAndGet()); 
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("retry for exception, but retain retry time is null, last error is :");
    stringBuilder.append(parama.b());
    b(new com.ss.android.socialbase.downloader.e.a(1043, stringBuilder.toString()));
    return true;
  }
  
  private void h() {
    com.ss.android.socialbase.downloader.g.c c1 = this.p;
    if (c1 == null)
      return; 
    int m = c1.D() - this.p.al();
    int j = m;
    if (m < 0)
      j = 0; 
    AtomicInteger atomicInteger = this.e;
    if (atomicInteger == null) {
      this.e = new AtomicInteger(j);
      return;
    } 
    atomicInteger.set(j);
  }
  
  private boolean i() {
    int j = this.p.q();
    if (j != 1 && !this.p.as()) {
      if (j != -2 && j != -4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The download Task can't start, because its status is not prepare:");
        stringBuilder.append(j);
        b(new com.ss.android.socialbase.downloader.e.a(1000, stringBuilder.toString()));
      } 
      return false;
    } 
    return true;
  }
  
  private void j() throws b {
    // Byte code:
    //   0: aload_0
    //   1: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   4: invokevirtual g : ()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   12: ifnull -> 235
    //   15: sipush #2048
    //   18: invokestatic a : (I)Z
    //   21: ifeq -> 34
    //   24: aload_0
    //   25: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   28: invokeinterface d : ()Z
    //   33: pop
    //   34: aload_0
    //   35: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   38: iload_3
    //   39: invokeinterface b : (I)Lcom/ss/android/socialbase/downloader/g/c;
    //   44: astore #6
    //   46: iconst_1
    //   47: istore_2
    //   48: aload #6
    //   50: ifnull -> 198
    //   53: aload #6
    //   55: invokevirtual aU : ()Z
    //   58: ifeq -> 64
    //   61: goto -> 198
    //   64: aload_0
    //   65: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   68: invokevirtual k : ()Ljava/lang/String;
    //   71: astore #7
    //   73: aload_0
    //   74: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   77: invokevirtual A : ()Ljava/lang/String;
    //   80: astore #8
    //   82: aload_0
    //   83: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   86: aload #6
    //   88: iconst_1
    //   89: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/c;Z)V
    //   92: aload #7
    //   94: aload #6
    //   96: invokevirtual k : ()Ljava/lang/String;
    //   99: invokevirtual equals : (Ljava/lang/Object;)Z
    //   102: istore #5
    //   104: iconst_0
    //   105: istore_1
    //   106: iload #5
    //   108: ifeq -> 138
    //   111: aload #6
    //   113: iconst_0
    //   114: aload #8
    //   116: invokestatic a : (Lcom/ss/android/socialbase/downloader/g/c;ZLjava/lang/String;)Z
    //   119: ifne -> 125
    //   122: goto -> 138
    //   125: new com/ss/android/socialbase/downloader/e/b
    //   128: dup
    //   129: aload #6
    //   131: invokevirtual h : ()Ljava/lang/String;
    //   134: invokespecial <init> : (Ljava/lang/String;)V
    //   137: athrow
    //   138: aload #6
    //   140: invokestatic a : (Lcom/ss/android/socialbase/downloader/g/c;)I
    //   143: istore #4
    //   145: iload #4
    //   147: iload_3
    //   148: if_icmpeq -> 175
    //   151: aload_0
    //   152: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   155: iload_3
    //   156: invokeinterface f : (I)Z
    //   161: pop
    //   162: goto -> 303
    //   165: astore #7
    //   167: aload #7
    //   169: invokevirtual printStackTrace : ()V
    //   172: goto -> 303
    //   175: sipush #4096
    //   178: invokestatic a : (I)Z
    //   181: ifeq -> 308
    //   184: aload #6
    //   186: aload_0
    //   187: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   190: if_acmpeq -> 308
    //   193: iload_2
    //   194: istore_1
    //   195: goto -> 207
    //   198: aload_0
    //   199: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   202: invokevirtual aM : ()V
    //   205: iload_2
    //   206: istore_1
    //   207: iload_1
    //   208: ifeq -> 235
    //   211: aload_0
    //   212: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   215: aload_0
    //   216: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   219: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/c;)Z
    //   224: pop
    //   225: goto -> 235
    //   228: astore #6
    //   230: aload #6
    //   232: invokevirtual printStackTrace : ()V
    //   235: aload_0
    //   236: invokespecial h : ()V
    //   239: return
    //   240: astore #6
    //   242: aload_0
    //   243: getfield c : Lcom/ss/android/socialbase/downloader/g/d;
    //   246: astore #7
    //   248: aload #7
    //   250: ifnull -> 297
    //   253: aload_0
    //   254: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   257: ifnull -> 297
    //   260: aload #7
    //   262: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   265: aload_0
    //   266: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   269: new com/ss/android/socialbase/downloader/e/a
    //   272: dup
    //   273: sipush #1003
    //   276: aload #6
    //   278: ldc_w 'checkTaskCache'
    //   281: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;)Ljava/lang/String;
    //   284: invokespecial <init> : (ILjava/lang/String;)V
    //   287: aload_0
    //   288: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   291: invokevirtual q : ()I
    //   294: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   297: return
    //   298: astore #6
    //   300: aload #6
    //   302: athrow
    //   303: iconst_1
    //   304: istore_1
    //   305: goto -> 175
    //   308: goto -> 207
    // Exception table:
    //   from	to	target	type
    //   0	34	298	com/ss/android/socialbase/downloader/e/b
    //   0	34	240	finally
    //   34	46	298	com/ss/android/socialbase/downloader/e/b
    //   34	46	240	finally
    //   53	61	298	com/ss/android/socialbase/downloader/e/b
    //   53	61	240	finally
    //   64	104	298	com/ss/android/socialbase/downloader/e/b
    //   64	104	240	finally
    //   111	122	298	com/ss/android/socialbase/downloader/e/b
    //   111	122	240	finally
    //   125	138	298	com/ss/android/socialbase/downloader/e/b
    //   125	138	240	finally
    //   138	145	298	com/ss/android/socialbase/downloader/e/b
    //   138	145	240	finally
    //   151	162	165	android/database/sqlite/SQLiteException
    //   151	162	298	com/ss/android/socialbase/downloader/e/b
    //   151	162	240	finally
    //   167	172	298	com/ss/android/socialbase/downloader/e/b
    //   167	172	240	finally
    //   175	193	298	com/ss/android/socialbase/downloader/e/b
    //   175	193	240	finally
    //   198	205	298	com/ss/android/socialbase/downloader/e/b
    //   198	205	240	finally
    //   211	225	228	android/database/sqlite/SQLiteException
    //   211	225	298	com/ss/android/socialbase/downloader/e/b
    //   211	225	240	finally
    //   230	235	298	com/ss/android/socialbase/downloader/e/b
    //   230	235	240	finally
    //   235	239	298	com/ss/android/socialbase/downloader/e/b
    //   235	239	240	finally
  }
  
  private void k() {
    try {
      int j;
      this.n = k.a;
      this.p.L();
      this.p.R();
      try {
        j();
        j = 0;
      } catch (b b) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("file exist ");
        stringBuilder.append(b.c());
        com.ss.android.socialbase.downloader.f.a.b(str, stringBuilder.toString());
        this.F = b.c();
        j = 1;
      } 
      if (!this.D)
        this.v.b(); 
      this.D = false;
      boolean bool = r();
      if (bool)
        return; 
      if (!TextUtils.isEmpty(this.F) && j) {
        if (this.F.equals(this.p.n())) {
          this.n = k.e;
        } else {
          this.n = k.h;
        } 
        return;
      } 
      com.ss.android.socialbase.downloader.i.a.a().b();
      while (true) {
        bool = r();
        if (bool)
          return; 
        try {
          B();
          x();
          A();
          List<b> list = this.o.c(this.p.g());
          C();
          String str = this.p.I();
          bool = r();
          if (bool)
            return; 
          if (this.i) {
            l = f.d(this.p);
          } else {
            l = 0L;
          } 
          b b = b(l);
          List<e> list1 = a(b);
          this.p.l(0);
          if (this.p.aV() == 1) {
            com.ss.android.socialbase.downloader.i.a.c c1 = com.ss.android.socialbase.downloader.i.a.a.a().a(str, list1);
            if (c1 != null) {
              this.z = (com.ss.android.socialbase.downloader.i.c)c1;
              this.p.l(1);
            } 
          } 
          if (this.z == null && !this.E) {
            bool = this.p.U();
            if (bool)
              try {
                this.z = b.a(str, list1);
              } finally {
                Exception exception = null;
              }  
          } 
          if (this.z == null) {
            a(str, list1);
            a((com.ss.android.socialbase.downloader.i.c)this.y, l);
          } else {
            try {
              a(this.z, l);
            } finally {
              Exception exception = null;
              this.E = true;
              a(str, list1);
            } 
          } 
          bool = r();
          if (bool)
            return; 
          long l = this.p.ab();
          a(l, this.p.l(), this.p.m());
          j = a(l, list);
          bool = r();
          if (bool)
            return; 
        } catch (com.ss.android.socialbase.downloader.e.a a1) {
        
        } catch (a a1) {
          String str = a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("downloadInner: retry throwable for ");
          stringBuilder.append(a1.a());
          com.ss.android.socialbase.downloader.f.a.d(str, stringBuilder.toString());
        } finally {
          null = null;
        } 
        o();
        o();
      } 
    } finally {
      l();
    } 
  }
  
  private void l() {
    int j;
    boolean bool1;
    boolean bool2;
    k k1 = this.n;
    k k2 = k.b;
    byte b = 0;
    if (k1 != k2 && this.n != k.c) {
      j = 1;
    } else {
      j = 0;
    } 
    try {
      bool2 = s();
      bool1 = false;
    } catch (Exception exception) {
      if (exception instanceof com.ss.android.socialbase.downloader.e.a) {
        this.v.a((com.ss.android.socialbase.downloader.e.a)exception);
      } else {
        this.v.a(new com.ss.android.socialbase.downloader.e.a(1046, exception));
      } 
      bool2 = true;
      bool1 = true;
    } 
    if (bool2 || bool1) {
      this.m.set(false);
      if (j)
        try {
        
        } finally {
          Exception exception = null;
          exception.printStackTrace();
          x x = this.c.e();
          com.ss.android.socialbase.downloader.g.c c1 = this.p;
          com.ss.android.socialbase.downloader.e.a a1 = new com.ss.android.socialbase.downloader.e.a(1014, f.b(exception, "removeDownloadRunnable"));
          com.ss.android.socialbase.downloader.g.c c2 = this.p;
          j = b;
          if (c2 != null)
            j = c2.q(); 
        }  
      return;
    } 
    this.D = true;
    com.ss.android.socialbase.downloader.f.a.b(a, "jump to restart");
  }
  
  private void m() {
    com.ss.android.socialbase.downloader.i.c c1 = this.z;
    if (c1 != null) {
      c1.c();
      this.z = null;
    } 
  }
  
  private void n() {
    e e1 = this.y;
    if (e1 != null) {
      e1.d();
      this.y = null;
    } 
  }
  
  private void o() {
    m();
    n();
  }
  
  private void p() throws com.ss.android.socialbase.downloader.e.a {
    if (this.g != null) {
      if (this.n == k.c) {
        this.p.b(-4);
        this.g.c();
        return;
      } 
      if (this.n == k.b) {
        this.p.b(-2);
        this.g.b();
        return;
      } 
      this.g.d();
    } 
  }
  
  private boolean q() {
    return (this.n == k.c || this.n == k.b);
  }
  
  private boolean r() {
    if (q() || this.p.q() == -2) {
      if (!q())
        if (this.p.q() == -2) {
          this.n = k.b;
        } else if (this.p.q() == -4) {
          this.n = k.c;
        }  
      return true;
    } 
    return false;
  }
  
  private boolean s() {
    com.ss.android.socialbase.downloader.i.a.a().c();
    if (this.n == k.d) {
      this.v.a(this.x);
      return true;
    } 
    if (this.n == k.c) {
      this.v.c();
      return true;
    } 
    if (this.n == k.b) {
      this.v.d();
      return true;
    } 
    if (this.n == k.e) {
      this.v.g();
      return true;
    } 
    if (this.n == k.h)
      try {
        this.v.a(this.F);
        return true;
      } catch (com.ss.android.socialbase.downloader.e.a a1) {
        this.v.a(a1);
        return true;
      }  
    if (this.n == k.i) {
      this.v.a(this.x, false);
      return false;
    } 
    if (this.n == k.g)
      return true; 
    if (this.n == k.f && !t()) {
      com.ss.android.socialbase.downloader.f.a.b(a, "doTaskStatusHandle retryDelay");
      v();
      return (this.n == k.f);
    } 
    try {
      if (!u())
        return false; 
      return true;
    } finally {
      Exception exception = null;
      b(new com.ss.android.socialbase.downloader.e.a(1008, f.b(exception, "doTaskStatusHandle onComplete")));
    } 
  }
  
  private boolean t() {
    if (this.p.aV() <= 1)
      return (this.p.Z() > 0L && this.p.Z() == this.p.ab()); 
    List list = this.o.c(this.p.g());
    if (list != null) {
      if (list.size() <= 1)
        return false; 
      for (b b : list) {
        if (b == null || !b.i())
          return false; 
      } 
      return true;
    } 
    return false;
  }
  
  private boolean u() {
    if (this.p.aD()) {
      com.ss.android.socialbase.downloader.g.c c1 = this.p;
      c1.c(c1.Z());
    } 
    if (this.p.Z() <= 0L || (!this.p.V() && (this.p.ab() <= 0L || this.p.Z() != this.p.ab()))) {
      this.p.a(b.b);
      this.p.aM();
      this.o.a(this.p);
      this.o.d(this.p.g());
      f.a(this.p);
      return false;
    } 
    return true;
  }
  
  private void v() {
    long l = w();
    try {
      Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
      intent.putExtra("extra_download_id", this.p.g());
      intent.setClass(b.B(), DownloadHandleService.class);
    } finally {
      null = null;
    } 
    this.n = k.f;
    this.p.a(j.b);
    this.o.a(this.p);
  }
  
  private long w() {
    return this.u.a(this.p.G(), this.p.F());
  }
  
  private void x() throws a, com.ss.android.socialbase.downloader.e.a {
    int j = this.p.g();
    int m = b.a(this.p);
    if (!this.p.aI()) {
      com.ss.android.socialbase.downloader.g.c c1 = this.o.b(m);
      if (c1 != null) {
        com.ss.android.socialbase.downloader.impls.a a1 = b.t();
        if (a1 != null && c1.g() != j && c1.a(this.p))
          if (!a1.a(c1.g())) {
            List list = this.o.c(m);
            f.a(this.p);
            this.o.f(m);
            if (c1 != null && c1.aQ()) {
              this.p.a(c1, false);
              this.o.a(this.p);
              if (list != null)
                for (b b : list) {
                  b.b(j);
                  this.o.a(b);
                }  
              throw new a(this, "retry task because id generator changed");
            } 
          } else {
            this.o.f(j);
            throw new com.ss.android.socialbase.downloader.e.a(1025, "another same task is downloading");
          }  
      } 
      return;
    } 
    throw new com.ss.android.socialbase.downloader.e.a(1009, "file has downloaded");
  }
  
  private boolean y() {
    // Byte code:
    //   0: aload_0
    //   1: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   4: astore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: istore_1
    //   9: aload_3
    //   10: ifnull -> 62
    //   13: aload_0
    //   14: getfield i : Z
    //   17: ifeq -> 30
    //   20: iload_2
    //   21: istore_1
    //   22: aload_3
    //   23: invokevirtual aV : ()I
    //   26: iconst_1
    //   27: if_icmple -> 62
    //   30: aload_0
    //   31: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   34: invokevirtual ap : ()Z
    //   37: ifeq -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: iload_2
    //   43: istore_1
    //   44: aload_0
    //   45: getfield j : Z
    //   48: ifeq -> 62
    //   51: iload_2
    //   52: istore_1
    //   53: aload_0
    //   54: getfield l : Z
    //   57: ifne -> 62
    //   60: iconst_1
    //   61: istore_1
    //   62: iload_1
    //   63: ireturn
  }
  
  private void z() throws com.ss.android.socialbase.downloader.e.a {
    long l;
    try {
      l = f.c(this.p.l());
    } catch (com.ss.android.socialbase.downloader.e.a a1) {
      l = 0L;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkSpaceOverflowInProgress: available = ");
    stringBuilder.append(f.a(l));
    stringBuilder.append("MB");
    com.ss.android.socialbase.downloader.f.a.c(str, stringBuilder.toString());
    if (l > 0L) {
      long l1 = this.p.ab() - this.p.Z();
      if (l < l1) {
        int j = com.ss.android.socialbase.downloader.k.a.a(this.p.g()).a("space_fill_min_keep_mb", 100);
        if (j > 0) {
          long l2 = l - j * 1048576L;
          str = a;
          stringBuilder = new StringBuilder();
          stringBuilder.append("checkSpaceOverflowInProgress: minKeep  = ");
          stringBuilder.append(j);
          stringBuilder.append("MB, canDownload = ");
          stringBuilder.append(f.a(l2));
          stringBuilder.append("MB");
          com.ss.android.socialbase.downloader.f.a.c(str, stringBuilder.toString());
          if (l2 > 0L) {
            this.G = this.p.Z() + l2 + 1048576L;
            return;
          } 
          this.G = 0L;
          throw new e(l, l1);
        } 
      } 
    } 
    this.G = 0L;
  }
  
  public g a(com.ss.android.socialbase.downloader.e.a parama, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield x : Lcom/ss/android/socialbase/downloader/e/a;
    //   5: aload_0
    //   6: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   9: lload_2
    //   10: lneg
    //   11: invokevirtual b : (J)V
    //   14: aload_0
    //   15: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   18: aload_0
    //   19: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   22: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/c;)Z
    //   27: pop
    //   28: aload_0
    //   29: invokespecial q : ()Z
    //   32: ifeq -> 39
    //   35: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   38: areturn
    //   39: iconst_1
    //   40: istore #7
    //   42: aload_1
    //   43: ifnull -> 153
    //   46: aload_1
    //   47: invokevirtual a : ()I
    //   50: sipush #1047
    //   53: if_icmpne -> 153
    //   56: aload_0
    //   57: getfield A : Lcom/ss/android/socialbase/downloader/d/u;
    //   60: ifnull -> 141
    //   63: aload_0
    //   64: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   67: invokevirtual am : ()Z
    //   70: ifeq -> 76
    //   73: goto -> 141
    //   76: new com/ss/android/socialbase/downloader/l/c$1
    //   79: dup
    //   80: aload_0
    //   81: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/l/c;)V
    //   84: astore #9
    //   86: aload_0
    //   87: getfield A : Lcom/ss/android/socialbase/downloader/d/u;
    //   90: aload #9
    //   92: invokeinterface a : (Lcom/ss/android/socialbase/downloader/d/t;)Z
    //   97: istore #8
    //   99: aload_0
    //   100: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   103: invokevirtual an : ()V
    //   106: iload #8
    //   108: ifeq -> 396
    //   111: aload #9
    //   113: invokevirtual a : ()Z
    //   116: ifne -> 342
    //   119: aload_0
    //   120: invokespecial E : ()V
    //   123: aload_0
    //   124: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   127: invokevirtual h : ()V
    //   130: aload_0
    //   131: getstatic com/ss/android/socialbase/downloader/b/k.g : Lcom/ss/android/socialbase/downloader/b/k;
    //   134: putfield n : Lcom/ss/android/socialbase/downloader/b/k;
    //   137: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   140: areturn
    //   141: aload_0
    //   142: aload_1
    //   143: invokespecial d : (Lcom/ss/android/socialbase/downloader/e/a;)Z
    //   146: ifeq -> 396
    //   149: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   152: areturn
    //   153: aload_1
    //   154: invokestatic g : (Ljava/lang/Throwable;)Z
    //   157: ifeq -> 384
    //   160: aload_0
    //   161: getfield B : Lcom/ss/android/socialbase/downloader/d/p;
    //   164: ifnonnull -> 176
    //   167: aload_0
    //   168: aload_1
    //   169: invokevirtual b : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   172: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   175: areturn
    //   176: new java/util/concurrent/atomic/AtomicBoolean
    //   179: dup
    //   180: iconst_0
    //   181: invokespecial <init> : (Z)V
    //   184: astore #9
    //   186: new com/ss/android/socialbase/downloader/l/c$2
    //   189: dup
    //   190: aload_0
    //   191: aload #9
    //   193: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/l/c;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   196: astore #10
    //   198: aload_1
    //   199: instanceof com/ss/android/socialbase/downloader/e/e
    //   202: ifeq -> 227
    //   205: aload_1
    //   206: checkcast com/ss/android/socialbase/downloader/e/e
    //   209: astore #11
    //   211: aload #11
    //   213: invokevirtual c : ()J
    //   216: lstore_2
    //   217: aload #11
    //   219: invokevirtual d : ()J
    //   222: lstore #5
    //   224: goto -> 240
    //   227: aload_0
    //   228: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   231: invokevirtual ab : ()J
    //   234: lstore #5
    //   236: ldc2_w -1
    //   239: lstore_2
    //   240: aload_0
    //   241: monitorenter
    //   242: aload_0
    //   243: getfield B : Lcom/ss/android/socialbase/downloader/d/p;
    //   246: lload_2
    //   247: lload #5
    //   249: aload #10
    //   251: invokeinterface a : (JJLcom/ss/android/socialbase/downloader/d/o;)Z
    //   256: ifeq -> 348
    //   259: aload_0
    //   260: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   263: invokevirtual g : ()I
    //   266: invokestatic a : (I)Lcom/ss/android/socialbase/downloader/k/a;
    //   269: ldc_w 'not_delete_when_clean_space'
    //   272: iconst_0
    //   273: invokevirtual b : (Ljava/lang/String;Z)Z
    //   276: ifne -> 284
    //   279: aload_0
    //   280: invokespecial u : ()Z
    //   283: pop
    //   284: aload #9
    //   286: invokevirtual get : ()Z
    //   289: ifne -> 328
    //   292: aload_0
    //   293: getfield n : Lcom/ss/android/socialbase/downloader/b/k;
    //   296: getstatic com/ss/android/socialbase/downloader/b/k.g : Lcom/ss/android/socialbase/downloader/b/k;
    //   299: if_acmpeq -> 320
    //   302: aload_0
    //   303: getstatic com/ss/android/socialbase/downloader/b/k.g : Lcom/ss/android/socialbase/downloader/b/k;
    //   306: putfield n : Lcom/ss/android/socialbase/downloader/b/k;
    //   309: aload_0
    //   310: invokespecial E : ()V
    //   313: aload_0
    //   314: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   317: invokevirtual h : ()V
    //   320: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   323: astore_1
    //   324: aload_0
    //   325: monitorexit
    //   326: aload_1
    //   327: areturn
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_0
    //   331: aload_1
    //   332: invokespecial d : (Lcom/ss/android/socialbase/downloader/e/a;)Z
    //   335: ifeq -> 342
    //   338: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   341: areturn
    //   342: iconst_1
    //   343: istore #4
    //   345: goto -> 399
    //   348: aload_0
    //   349: getfield n : Lcom/ss/android/socialbase/downloader/b/k;
    //   352: getstatic com/ss/android/socialbase/downloader/b/k.g : Lcom/ss/android/socialbase/downloader/b/k;
    //   355: if_acmpne -> 366
    //   358: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   361: astore_1
    //   362: aload_0
    //   363: monitorexit
    //   364: aload_1
    //   365: areturn
    //   366: aload_0
    //   367: aload_1
    //   368: invokevirtual b : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   371: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   374: astore_1
    //   375: aload_0
    //   376: monitorexit
    //   377: aload_1
    //   378: areturn
    //   379: astore_1
    //   380: aload_0
    //   381: monitorexit
    //   382: aload_1
    //   383: athrow
    //   384: aload_0
    //   385: aload_1
    //   386: invokespecial d : (Lcom/ss/android/socialbase/downloader/e/a;)Z
    //   389: ifeq -> 396
    //   392: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   395: areturn
    //   396: iconst_0
    //   397: istore #4
    //   399: iload #4
    //   401: ifne -> 415
    //   404: aload_0
    //   405: invokespecial G : ()Z
    //   408: ifeq -> 415
    //   411: aload_0
    //   412: invokespecial E : ()V
    //   415: aload_0
    //   416: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   419: astore #9
    //   421: aload_0
    //   422: getfield n : Lcom/ss/android/socialbase/downloader/b/k;
    //   425: getstatic com/ss/android/socialbase/downloader/b/k.f : Lcom/ss/android/socialbase/downloader/b/k;
    //   428: if_acmpne -> 434
    //   431: goto -> 437
    //   434: iconst_0
    //   435: istore #7
    //   437: aload #9
    //   439: aload_1
    //   440: iload #7
    //   442: invokevirtual a : (Lcom/ss/android/socialbase/downloader/e/a;Z)V
    //   445: aload_0
    //   446: getfield n : Lcom/ss/android/socialbase/downloader/b/k;
    //   449: getstatic com/ss/android/socialbase/downloader/b/k.f : Lcom/ss/android/socialbase/downloader/b/k;
    //   452: if_acmpne -> 459
    //   455: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   458: areturn
    //   459: getstatic com/ss/android/socialbase/downloader/e/g.b : Lcom/ss/android/socialbase/downloader/e/g;
    //   462: areturn
    // Exception table:
    //   from	to	target	type
    //   242	284	379	finally
    //   284	320	379	finally
    //   320	326	379	finally
    //   328	330	379	finally
    //   348	364	379	finally
    //   366	377	379	finally
    //   380	382	379	finally
  }
  
  public g a(b paramb, com.ss.android.socialbase.downloader.e.a parama, long paramLong) {
    boolean bool;
    if (q())
      return g.a; 
    if (parama != null && (parama.a() == 1047 || f.g((Throwable)parama)))
      return a(parama, paramLong); 
    this.x = parama;
    this.p.b(-paramLong);
    this.o.a(this.p);
    if (d(parama))
      return g.a; 
    e e1 = this.v;
    if (this.n == k.f) {
      bool = true;
    } else {
      bool = false;
    } 
    e1.a(paramb, parama, bool);
    if (this.n != k.f && this.p.aj()) {
      paramLong = w();
      if (paramLong > 0L) {
        StringBuilder stringBuilder;
        String str = a;
      } 
    } 
    return g.b;
  }
  
  public b a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   6: invokevirtual aV : ()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpge -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield o : Lcom/ss/android/socialbase/downloader/downloader/k;
    //   23: aload_0
    //   24: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   27: invokevirtual g : ()I
    //   30: invokeinterface c : (I)Ljava/util/List;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull -> 112
    //   40: aload_3
    //   41: invokeinterface isEmpty : ()Z
    //   46: ifeq -> 121
    //   49: goto -> 112
    //   52: iload_2
    //   53: aload_3
    //   54: invokeinterface size : ()I
    //   59: if_icmpge -> 108
    //   62: aload_3
    //   63: iload_2
    //   64: invokeinterface get : (I)Ljava/lang/Object;
    //   69: checkcast com/ss/android/socialbase/downloader/g/b
    //   72: astore #4
    //   74: aload #4
    //   76: ifnonnull -> 82
    //   79: goto -> 101
    //   82: aload_0
    //   83: aload #4
    //   85: iload_1
    //   86: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/b;I)Lcom/ss/android/socialbase/downloader/g/b;
    //   89: astore #4
    //   91: aload #4
    //   93: ifnull -> 101
    //   96: aload_0
    //   97: monitorexit
    //   98: aload #4
    //   100: areturn
    //   101: iload_2
    //   102: iconst_1
    //   103: iadd
    //   104: istore_2
    //   105: goto -> 52
    //   108: aload_0
    //   109: monitorexit
    //   110: aconst_null
    //   111: areturn
    //   112: aload_0
    //   113: monitorexit
    //   114: aconst_null
    //   115: areturn
    //   116: astore_3
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_3
    //   120: athrow
    //   121: iconst_0
    //   122: istore_2
    //   123: goto -> 52
    // Exception table:
    //   from	to	target	type
    //   2	10	116	finally
    //   19	36	116	finally
    //   40	49	116	finally
    //   52	74	116	finally
    //   82	91	116	finally
  }
  
  public void a() {
    this.n = k.b;
    if (this.g != null) {
      this.g.b();
    } else {
      o();
      this.n = k.b;
      l();
    } 
    try {
    
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(com.ss.android.socialbase.downloader.e.a parama, boolean paramBoolean) {
    com.ss.android.socialbase.downloader.f.a.b(a, "onAllChunkRetryWithReset");
    this.n = k.i;
    this.x = parama;
    E();
    if (paramBoolean) {
      paramBoolean = d(parama);
    } else {
      paramBoolean = false;
    } 
    if (!paramBoolean)
      D(); 
  }
  
  public void a(com.ss.android.socialbase.downloader.i.c paramc) {
    if (paramc != null)
      try {
        int j = paramc.b();
        this.p.e(j);
        return;
      } finally {
        paramc = null;
      }  
  }
  
  public void a(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Z
    //   4: ifne -> 26
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield f : Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual remove : (Ljava/lang/Object;)Z
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    //   26: return
    // Exception table:
    //   from	to	target	type
    //   9	20	21	finally
    //   22	24	21	finally
  }
  
  public void a(Future paramFuture) {
    this.b = paramFuture;
  }
  
  public boolean a(long paramLong) throws com.ss.android.socialbase.downloader.e.a {
    if (this.G > 0L && this.p.Z() > this.G)
      z(); 
    return this.v.a(paramLong);
  }
  
  public boolean a(com.ss.android.socialbase.downloader.e.a parama) {
    if (f.b(parama)) {
      if (this.h && !this.d) {
        f.a(this.p);
        this.d = true;
      } 
      return true;
    } 
    AtomicInteger atomicInteger = this.e;
    return (((atomicInteger != null && atomicInteger.get() > 0) || this.p.aK() || (parama != null && (parama.a() == 1011 || (parama.getCause() != null && parama.getCause() instanceof javax.net.ssl.SSLHandshakeException)) && this.p.aL())) && !(parama instanceof f));
  }
  
  public void b() {
    this.n = k.c;
    if (this.g != null) {
      this.g.c();
    } else {
      o();
      this.n = k.c;
      l();
    } 
    E();
  }
  
  public void b(com.ss.android.socialbase.downloader.e.a parama) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onError:");
    stringBuilder.append(parama.getMessage());
    com.ss.android.socialbase.downloader.f.a.b(str, stringBuilder.toString());
    this.n = k.d;
    this.x = parama;
    E();
  }
  
  public d c() {
    return this.c;
  }
  
  public void c(com.ss.android.socialbase.downloader.e.a parama) {
    com.ss.android.socialbase.downloader.g.c c1 = this.p;
    if (c1 != null)
      c1.l(true); 
    a(parama, false);
  }
  
  public boolean d() {
    return this.m.get();
  }
  
  public int e() {
    com.ss.android.socialbase.downloader.g.c c1 = this.p;
    return (c1 != null) ? c1.g() : 0;
  }
  
  public void f() {
    this.v.a();
  }
  
  public Future g() {
    return this.b;
  }
  
  public void run() {
    // Byte code:
    //   0: bipush #10
    //   2: invokestatic setThreadPriority : (I)V
    //   5: aload_0
    //   6: getfield c : Lcom/ss/android/socialbase/downloader/g/d;
    //   9: invokevirtual c : ()Lcom/ss/android/socialbase/downloader/d/v;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull -> 41
    //   17: aload_3
    //   18: invokeinterface a : ()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq -> 41
    //   28: aload_0
    //   29: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   32: invokevirtual e : ()V
    //   35: return
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual printStackTrace : ()V
    //   41: aload_0
    //   42: invokespecial i : ()Z
    //   45: ifne -> 109
    //   48: aload_0
    //   49: getfield c : Lcom/ss/android/socialbase/downloader/g/d;
    //   52: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/d/x;
    //   55: astore_3
    //   56: aload_0
    //   57: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   60: astore #4
    //   62: new com/ss/android/socialbase/downloader/e/a
    //   65: dup
    //   66: sipush #1003
    //   69: ldc_w 'task status is invalid'
    //   72: invokespecial <init> : (ILjava/lang/String;)V
    //   75: astore #5
    //   77: aload_0
    //   78: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   81: astore #6
    //   83: aload #6
    //   85: ifnull -> 97
    //   88: aload #6
    //   90: invokevirtual q : ()I
    //   93: istore_1
    //   94: goto -> 99
    //   97: iconst_0
    //   98: istore_1
    //   99: aload_3
    //   100: aload #4
    //   102: aload #5
    //   104: iload_1
    //   105: invokestatic a : (Lcom/ss/android/socialbase/downloader/d/x;Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;I)V
    //   108: return
    //   109: aload_0
    //   110: invokespecial k : ()V
    //   113: aload_0
    //   114: getfield D : Z
    //   117: ifne -> 121
    //   120: return
    //   121: aload_0
    //   122: getfield C : I
    //   125: ifle -> 141
    //   128: aload_0
    //   129: aload_0
    //   130: getfield C : I
    //   133: iconst_1
    //   134: isub
    //   135: putfield C : I
    //   138: goto -> 109
    //   141: aload_0
    //   142: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   145: invokevirtual Z : ()J
    //   148: aload_0
    //   149: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   152: invokevirtual ab : ()J
    //   155: lcmp
    //   156: ifeq -> 228
    //   159: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   162: aload_0
    //   163: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   166: invokevirtual d : ()Ljava/lang/String;
    //   169: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   176: astore_3
    //   177: new java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial <init> : ()V
    //   184: astore #4
    //   186: aload #4
    //   188: ldc_w 'current bytes is not equals to total bytes, bytes invalid retry status is : '
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload #4
    //   197: aload_0
    //   198: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   201: invokevirtual aa : ()Lcom/ss/android/socialbase/downloader/b/b;
    //   204: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_3
    //   209: new com/ss/android/socialbase/downloader/e/f
    //   212: dup
    //   213: sipush #1027
    //   216: aload #4
    //   218: invokevirtual toString : ()Ljava/lang/String;
    //   221: invokespecial <init> : (ILjava/lang/String;)V
    //   224: invokevirtual a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   227: return
    //   228: aload_0
    //   229: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   232: invokevirtual Z : ()J
    //   235: lconst_0
    //   236: lcmp
    //   237: ifgt -> 309
    //   240: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   243: aload_0
    //   244: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   247: invokevirtual d : ()Ljava/lang/String;
    //   250: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   257: astore_3
    //   258: new java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial <init> : ()V
    //   265: astore #4
    //   267: aload #4
    //   269: ldc_w 'curBytes is 0, bytes invalid retry status is : '
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload #4
    //   278: aload_0
    //   279: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   282: invokevirtual aa : ()Lcom/ss/android/socialbase/downloader/b/b;
    //   285: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_3
    //   290: new com/ss/android/socialbase/downloader/e/f
    //   293: dup
    //   294: sipush #1026
    //   297: aload #4
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: invokespecial <init> : (ILjava/lang/String;)V
    //   305: invokevirtual a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   308: return
    //   309: aload_0
    //   310: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   313: invokevirtual ab : ()J
    //   316: lconst_0
    //   317: lcmp
    //   318: ifgt -> 109
    //   321: getstatic com/ss/android/socialbase/downloader/l/c.a : Ljava/lang/String;
    //   324: aload_0
    //   325: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   328: invokevirtual d : ()Ljava/lang/String;
    //   331: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_0
    //   335: getfield v : Lcom/ss/android/socialbase/downloader/downloader/e;
    //   338: astore_3
    //   339: new java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial <init> : ()V
    //   346: astore #4
    //   348: aload #4
    //   350: ldc_w 'TotalBytes is 0, bytes invalid retry status is : '
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload #4
    //   359: aload_0
    //   360: getfield p : Lcom/ss/android/socialbase/downloader/g/c;
    //   363: invokevirtual aa : ()Lcom/ss/android/socialbase/downloader/b/b;
    //   366: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_3
    //   371: new com/ss/android/socialbase/downloader/e/f
    //   374: dup
    //   375: sipush #1044
    //   378: aload #4
    //   380: invokevirtual toString : ()Ljava/lang/String;
    //   383: invokespecial <init> : (ILjava/lang/String;)V
    //   386: invokevirtual a : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   389: return
    //   390: astore_3
    //   391: aload_3
    //   392: athrow
    // Exception table:
    //   from	to	target	type
    //   5	13	36	finally
    //   17	24	36	finally
    //   37	41	390	finally
  }
  
  class a extends Throwable {
    private String b;
    
    public a(c this$0, String param1String) {
      super(param1String);
      this.b = param1String;
    }
    
    public String a() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\l\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */