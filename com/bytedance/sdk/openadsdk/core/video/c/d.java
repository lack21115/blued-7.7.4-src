package com.bytedance.sdk.openadsdk.core.video.c;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.a.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class d implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, ak.a {
  private static boolean m = false;
  
  private static final SparseIntArray o = new SparseIntArray();
  
  private c a = null;
  
  private boolean b;
  
  private boolean c;
  
  private boolean d;
  
  private boolean e;
  
  private int f;
  
  private long g;
  
  private final Handler h;
  
  private Handler i;
  
  private ArrayList<Runnable> j;
  
  private int k;
  
  private int l;
  
  private String n;
  
  private boolean p;
  
  private final Object q;
  
  private StringBuilder r;
  
  private boolean s;
  
  private long t;
  
  private long u;
  
  private long v;
  
  private long w;
  
  private boolean x;
  
  public d(Handler paramHandler) {
    this(paramHandler, -1);
  }
  
  public d(Handler paramHandler, int paramInt) {
    boolean bool = false;
    this.b = false;
    this.c = false;
    this.f = 201;
    this.g = -1L;
    this.k = 0;
    this.n = "0";
    this.q = new Object();
    this.r = null;
    this.s = false;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = false;
    this.k = 0;
    this.i = paramHandler;
    HandlerThread handlerThread = new HandlerThread("VideoManager");
    handlerThread.start();
    this.h = (Handler)new ak(handlerThread.getLooper(), this);
    if (Build.VERSION.SDK_INT >= 17)
      bool = true; 
    this.x = bool;
    q();
  }
  
  private int A() {
    AudioManager audioManager = (AudioManager)o.a().getSystemService("audio");
    return (audioManager != null) ? audioManager.getStreamVolume(3) : -1;
  }
  
  private void B() {
    if (m) {
      a(this.l, false);
      m = false;
    } 
  }
  
  private void C() {
    if (this.u <= 0L)
      this.u = System.currentTimeMillis(); 
  }
  
  private void D() {
    if (this.u > 0L) {
      this.t += System.currentTimeMillis() - this.u;
      this.u = 0L;
    } 
  }
  
  private void a(int paramInt, Object paramObject) {
    if (paramInt == 309)
      B(); 
    Handler handler = this.i;
    if (handler != null)
      handler.obtainMessage(paramInt, paramObject).sendToTarget(); 
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      int i = A();
      if (i != paramInt) {
        m = true;
        this.l = i;
      } 
    } 
    AudioManager audioManager = (AudioManager)o.a().getSystemService("audio");
    if (audioManager != null)
      audioManager.setStreamVolume(3, paramInt, 0); 
  }
  
  private void a(Runnable paramRunnable) {
    if (this.j == null)
      this.j = new ArrayList<Runnable>(); 
    this.j.add(paramRunnable);
  }
  
  private void a(String paramString) throws Throwable {
    FileInputStream fileInputStream = new FileInputStream(paramString);
    this.a.a(fileInputStream.getFD());
    fileInputStream.close();
  }
  
  private boolean a(int paramInt1, int paramInt2) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("OnError - Error code: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" Extra code: ");
    stringBuilder.append(paramInt2);
    t.b("SSMediaPlayeWrapper", stringBuilder.toString());
    if (paramInt1 != -1010 && paramInt1 != -1007 && paramInt1 != -1004 && paramInt1 != -110 && paramInt1 != 100 && paramInt1 != 200) {
      bool = false;
    } else {
      bool = true;
    } 
    return (paramInt2 != 1 && paramInt2 != 700 && paramInt2 != 800) ? bool : true;
  }
  
  private void b(int paramInt1, int paramInt2) {
    if (paramInt1 == 701) {
      D();
      this.v = SystemClock.elapsedRealtime();
      return;
    } 
    if (paramInt1 == 702) {
      if (this.u <= 0L)
        this.u = System.currentTimeMillis(); 
      if (this.v > 0L) {
        this.w += SystemClock.elapsedRealtime() - this.v;
        this.v = 0L;
        return;
      } 
    } else if (this.x && paramInt1 == 3 && this.u <= 0L) {
      this.u = System.currentTimeMillis();
    } 
  }
  
  private void b(Runnable paramRunnable) {
    if (paramRunnable == null)
      return; 
    if (!this.e) {
      paramRunnable.run();
      return;
    } 
    a(paramRunnable);
  }
  
  private void b(String paramString) {
    Handler handler = this.h;
    if (handler != null)
      handler.removeMessages(201); 
    synchronized (this.q) {
      if (this.r != null)
        this.r = null; 
      return;
    } 
  }
  
  private void q() {
    if (this.a == null) {
      t.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
      this.a = new b();
      this.n = "0";
      this.a.a(this);
      this.a.a(this);
      this.a.a(this);
      this.a.a(this);
      this.a.a(this);
      this.a.a(this);
      this.a.a(this);
      try {
        this.a.b(this.b);
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  private void r() {
    t.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
    b(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null) {
              d.a(this.a).sendEmptyMessage(104);
              t.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
            } 
          }
        });
  }
  
  private void s() {
    c c1 = this.a;
    if (c1 == null)
      return; 
    try {
      c1.l();
    } finally {
      c1 = null;
    } 
    this.a.a((c.g)null);
    this.a.a((c.a)null);
    this.a.a((c.d)null);
    this.a.a((c.c)null);
    this.a.a((c.e)null);
    this.a.a((c.f)null);
    try {
      return;
    } finally {
      c1 = null;
      t.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", (Throwable)c1);
    } 
  }
  
  private void t() {
    Handler handler = this.h;
    if (handler != null && handler.getLooper() != null)
      try {
        t.b("SSMediaPlayeWrapper", "onDestory............");
        return;
      } finally {
        handler = null;
      }  
  }
  
  private void u() {
    Integer integer = Integer.valueOf(o.get(this.k));
    if (integer == null) {
      o.put(this.k, 1);
      return;
    } 
    o.put(this.k, Integer.valueOf(integer.intValue() + 1).intValue());
  }
  
  private void v() {
    if (!this.x && this.u <= 0L)
      this.u = System.currentTimeMillis(); 
  }
  
  private void w() {
    if (this.d)
      return; 
    this.d = true;
    Iterator<?> iterator = (new ArrayList(this.j)).iterator();
    while (iterator.hasNext())
      ((Runnable)iterator.next()).run(); 
    this.j.clear();
    this.d = false;
  }
  
  private void x() {
    ArrayList<Runnable> arrayList = this.j;
    if (arrayList != null) {
      if (arrayList.isEmpty())
        return; 
      w();
    } 
  }
  
  private void y() {
    ArrayList<Runnable> arrayList = this.j;
    if (arrayList == null || arrayList.isEmpty()) {
      t();
      return;
    } 
    w();
  }
  
  private void z() {
    ArrayList<Runnable> arrayList = this.j;
    if (arrayList != null) {
      if (arrayList.isEmpty())
        return; 
      this.j.clear();
    } 
  }
  
  public MediaPlayer a() throws Throwable {
    c c1 = this.a;
    return (c1 != null) ? ((b)c1).e() : null;
  }
  
  public void a(long paramLong) {
    D();
    int i = this.f;
    if (i == 207 || i == 206 || i == 209)
      b(new Runnable(this, paramLong) {
            public void run() {
              if (d.a(this.b) != null)
                d.a(this.b).obtainMessage(106, Long.valueOf(this.a)).sendToTarget(); 
            }
          }); 
  }
  
  public void a(SurfaceTexture paramSurfaceTexture) {
    b(new Runnable(this, paramSurfaceTexture) {
          public void run() {
            d.b(this.b);
            if (d.a(this.b) != null)
              d.a(this.b).obtainMessage(111, this.a).sendToTarget(); 
          }
        });
  }
  
  public void a(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: istore #4
    //   6: ldc_w 'tag_video_play'
    //   9: ldc_w '[video]  execute , mCurrentState = '
    //   12: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   19: ifnull -> 1253
    //   22: aload_1
    //   23: getfield what : I
    //   26: istore_2
    //   27: iload_2
    //   28: sipush #201
    //   31: if_icmpeq -> 1253
    //   34: lconst_0
    //   35: lstore #7
    //   37: iload_2
    //   38: tableswitch default -> 100, 100 -> 1113, 101 -> 1041, 102 -> 1000, 103 -> 941, 104 -> 854, 105 -> 782, 106 -> 721, 107 -> 378, 108 -> 313, 109 -> 246, 110 -> 180, 111 -> 103
    //   100: goto -> 1253
    //   103: getstatic android/os/Build$VERSION.SDK_INT : I
    //   106: bipush #14
    //   108: if_icmplt -> 136
    //   111: aload_1
    //   112: getfield obj : Ljava/lang/Object;
    //   115: checkcast android/graphics/SurfaceTexture
    //   118: astore_1
    //   119: aload_0
    //   120: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   123: new android/view/Surface
    //   126: dup
    //   127: aload_1
    //   128: invokespecial <init> : (Landroid/graphics/SurfaceTexture;)V
    //   131: invokeinterface a : (Landroid/view/Surface;)V
    //   136: aload_0
    //   137: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   140: iconst_1
    //   141: invokeinterface a : (Z)V
    //   146: aload_0
    //   147: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   150: invokestatic a : ()Landroid/content/Context;
    //   153: bipush #10
    //   155: invokeinterface a : (Landroid/content/Context;I)V
    //   160: aload_0
    //   161: invokespecial x : ()V
    //   164: goto -> 1253
    //   167: astore_1
    //   168: ldc 'SSMediaPlayeWrapper'
    //   170: ldc_w 'OP_SET_SURFACE error: '
    //   173: aload_1
    //   174: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -> 1253
    //   180: aload_1
    //   181: getfield obj : Ljava/lang/Object;
    //   184: checkcast android/view/SurfaceHolder
    //   187: astore_1
    //   188: aload_0
    //   189: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   192: aload_1
    //   193: invokeinterface a : (Landroid/view/SurfaceHolder;)V
    //   198: aload_0
    //   199: getfield k : I
    //   202: iconst_2
    //   203: if_icmpne -> 220
    //   206: aload_0
    //   207: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   210: invokestatic a : ()Landroid/content/Context;
    //   213: bipush #10
    //   215: invokeinterface a : (Landroid/content/Context;I)V
    //   220: aload_0
    //   221: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   224: iconst_1
    //   225: invokeinterface a : (Z)V
    //   230: goto -> 1253
    //   233: astore_1
    //   234: ldc 'SSMediaPlayeWrapper'
    //   236: ldc_w 'OP_SET_DISPLAY error: '
    //   239: aload_1
    //   240: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: goto -> 1253
    //   246: aload_0
    //   247: getfield f : I
    //   250: istore_2
    //   251: iload_2
    //   252: sipush #206
    //   255: if_icmpeq -> 265
    //   258: iload_2
    //   259: sipush #207
    //   262: if_icmpne -> 289
    //   265: aload_0
    //   266: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   269: invokeinterface i : ()J
    //   274: lstore #5
    //   276: goto -> 292
    //   279: astore_1
    //   280: ldc 'SSMediaPlayeWrapper'
    //   282: ldc_w 'OP_REQUEST_CUR_POSITION error: '
    //   285: aload_1
    //   286: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   289: lconst_0
    //   290: lstore #5
    //   292: lload #5
    //   294: lconst_0
    //   295: lcmp
    //   296: ifle -> 1253
    //   299: aload_0
    //   300: bipush #109
    //   302: lload #5
    //   304: invokestatic valueOf : (J)Ljava/lang/Long;
    //   307: invokespecial a : (ILjava/lang/Object;)V
    //   310: goto -> 1253
    //   313: aload_0
    //   314: getfield f : I
    //   317: istore_2
    //   318: iload_2
    //   319: sipush #206
    //   322: if_icmpeq -> 336
    //   325: lload #7
    //   327: lstore #5
    //   329: iload_2
    //   330: sipush #207
    //   333: if_icmpne -> 364
    //   336: aload_0
    //   337: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   340: invokeinterface j : ()J
    //   345: lstore #5
    //   347: goto -> 364
    //   350: astore_1
    //   351: ldc 'SSMediaPlayeWrapper'
    //   353: ldc_w 'OP_REQUEST_DURATION error: '
    //   356: aload_1
    //   357: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: lload #7
    //   362: lstore #5
    //   364: aload_0
    //   365: bipush #108
    //   367: lload #5
    //   369: invokestatic valueOf : (J)Ljava/lang/Long;
    //   372: invokespecial a : (ILjava/lang/Object;)V
    //   375: goto -> 1253
    //   378: aload_0
    //   379: getfield f : I
    //   382: istore_2
    //   383: iload_2
    //   384: sipush #201
    //   387: if_icmpeq -> 397
    //   390: iload_2
    //   391: sipush #203
    //   394: if_icmpne -> 876
    //   397: aload_1
    //   398: getfield obj : Ljava/lang/Object;
    //   401: checkcast com/bytedance/sdk/openadsdk/core/video/a/a
    //   404: astore_1
    //   405: aload_1
    //   406: getfield a : Ljava/lang/String;
    //   409: astore #10
    //   411: aload #10
    //   413: ifnull -> 1291
    //   416: aload #10
    //   418: ldc_w '/'
    //   421: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   424: ifeq -> 1291
    //   427: iconst_1
    //   428: istore #9
    //   430: goto -> 433
    //   433: aload #10
    //   435: ifnull -> 449
    //   438: aload #10
    //   440: ldc_w '/'
    //   443: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   446: ifne -> 457
    //   449: aload_1
    //   450: getfield c : I
    //   453: iconst_1
    //   454: if_icmpne -> 502
    //   457: invokestatic b : ()Z
    //   460: ifeq -> 488
    //   463: aload #10
    //   465: ifnull -> 488
    //   468: aload #10
    //   470: ldc_w '/'
    //   473: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   476: ifeq -> 488
    //   479: aload_0
    //   480: aload #10
    //   482: invokespecial a : (Ljava/lang/String;)V
    //   485: goto -> 673
    //   488: aload_0
    //   489: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   492: aload #10
    //   494: invokeinterface a : (Ljava/lang/String;)V
    //   499: goto -> 673
    //   502: new com/bytedance/sdk/openadsdk/h/f/b
    //   505: dup
    //   506: invokespecial <init> : ()V
    //   509: aload_1
    //   510: getfield a : Ljava/lang/String;
    //   513: invokevirtual a : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/h/f/b;
    //   516: aload_1
    //   517: getfield d : Ljava/lang/String;
    //   520: invokevirtual b : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/h/f/b;
    //   523: astore_1
    //   524: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/h/f/a;
    //   527: aload_1
    //   528: invokevirtual b : (Lcom/bytedance/sdk/openadsdk/h/f/b;)Ljava/lang/String;
    //   531: astore_1
    //   532: new java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial <init> : ()V
    //   539: astore #10
    //   541: aload #10
    //   543: ldc_w '使用Video缓存-OP_SET_DATASOURCE-proxyurl='
    //   546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload #10
    //   552: aload_1
    //   553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: ldc_w 'cache009'
    //   560: aload #10
    //   562: invokevirtual toString : ()Ljava/lang/String;
    //   565: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload_1
    //   569: ifnull -> 1297
    //   572: aload_1
    //   573: ldc_w 'file'
    //   576: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   579: ifeq -> 1297
    //   582: iconst_1
    //   583: istore #9
    //   585: goto -> 588
    //   588: aload_1
    //   589: ifnull -> 663
    //   592: invokestatic b : ()Z
    //   595: ifeq -> 663
    //   598: aload_1
    //   599: ldc_w 'file'
    //   602: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   605: ifeq -> 663
    //   608: aload_1
    //   609: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   612: astore_1
    //   613: new java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial <init> : ()V
    //   620: astore #10
    //   622: aload #10
    //   624: ldc_w '使用uri parse ='
    //   627: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload #10
    //   633: aload_1
    //   634: invokevirtual getPath : ()Ljava/lang/String;
    //   637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: ldc_w 'cache010'
    //   644: aload #10
    //   646: invokevirtual toString : ()Ljava/lang/String;
    //   649: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   652: aload_0
    //   653: aload_1
    //   654: invokevirtual getPath : ()Ljava/lang/String;
    //   657: invokespecial a : (Ljava/lang/String;)V
    //   660: goto -> 673
    //   663: aload_0
    //   664: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   667: aload_1
    //   668: invokeinterface a : (Ljava/lang/String;)V
    //   673: aload_0
    //   674: sipush #202
    //   677: putfield f : I
    //   680: aload_0
    //   681: getfield i : Landroid/os/Handler;
    //   684: ifnull -> 1253
    //   687: aload_0
    //   688: getfield i : Landroid/os/Handler;
    //   691: sipush #314
    //   694: iload #9
    //   696: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   699: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   702: invokevirtual sendToTarget : ()V
    //   705: goto -> 1253
    //   708: astore_1
    //   709: ldc 'SSMediaPlayeWrapper'
    //   711: ldc_w 'OP_SET_DATASOURCE error: '
    //   714: aload_1
    //   715: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   718: goto -> 1253
    //   721: aload_0
    //   722: getfield f : I
    //   725: istore_2
    //   726: iload_2
    //   727: sipush #206
    //   730: if_icmpeq -> 747
    //   733: iload_2
    //   734: sipush #207
    //   737: if_icmpeq -> 747
    //   740: iload_2
    //   741: sipush #209
    //   744: if_icmpne -> 876
    //   747: aload_0
    //   748: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   751: aload_1
    //   752: getfield obj : Ljava/lang/Object;
    //   755: checkcast java/lang/Long
    //   758: invokevirtual longValue : ()J
    //   761: invokeinterface a : (J)V
    //   766: goto -> 1253
    //   769: astore_1
    //   770: ldc 'SSMediaPlayeWrapper'
    //   772: ldc_w 'OP_SEEKTO error: '
    //   775: aload_1
    //   776: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   779: goto -> 1253
    //   782: aload_0
    //   783: getfield f : I
    //   786: istore_2
    //   787: iload_2
    //   788: sipush #205
    //   791: if_icmpeq -> 822
    //   794: iload_2
    //   795: sipush #206
    //   798: if_icmpeq -> 822
    //   801: iload_2
    //   802: sipush #208
    //   805: if_icmpeq -> 822
    //   808: iload_2
    //   809: sipush #207
    //   812: if_icmpeq -> 822
    //   815: iload_2
    //   816: sipush #209
    //   819: if_icmpne -> 876
    //   822: aload_0
    //   823: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   826: invokeinterface g : ()V
    //   831: aload_0
    //   832: sipush #208
    //   835: putfield f : I
    //   838: goto -> 1253
    //   841: astore_1
    //   842: ldc 'SSMediaPlayeWrapper'
    //   844: ldc_w 'OP_STOP error: '
    //   847: aload_1
    //   848: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   851: goto -> 1253
    //   854: aload_0
    //   855: getfield f : I
    //   858: istore_2
    //   859: iload_2
    //   860: sipush #202
    //   863: if_icmpeq -> 881
    //   866: iload_2
    //   867: sipush #208
    //   870: if_icmpne -> 876
    //   873: goto -> 881
    //   876: iconst_1
    //   877: istore_2
    //   878: goto -> 1255
    //   881: aload_0
    //   882: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   885: checkcast com/bytedance/sdk/openadsdk/core/video/c/b
    //   888: invokevirtual e : ()Landroid/media/MediaPlayer;
    //   891: invokevirtual prepareAsync : ()V
    //   894: ldc_w 'tag_video_play'
    //   897: ldc_w '[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !'
    //   900: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload_0
    //   904: getfield i : Landroid/os/Handler;
    //   907: ifnull -> 1253
    //   910: aload_0
    //   911: getfield i : Landroid/os/Handler;
    //   914: sipush #312
    //   917: ldc2_w 10000
    //   920: invokevirtual sendEmptyMessageDelayed : (IJ)Z
    //   923: pop
    //   924: goto -> 1253
    //   927: astore_1
    //   928: ldc_w 'NativeVideoController'
    //   931: ldc_w 'OP_PREPARE_ASYNC error: '
    //   934: aload_1
    //   935: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   938: goto -> 1253
    //   941: aload_0
    //   942: invokespecial s : ()V
    //   945: ldc_w 'tag_video_play'
    //   948: ldc_w '[video] OP_RELEASE execute , releaseMediaplayer !'
    //   951: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   954: goto -> 968
    //   957: astore_1
    //   958: ldc_w 'NativeVideoController'
    //   961: ldc_w 'OP_RELEASE error: '
    //   964: aload_1
    //   965: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   968: aload_0
    //   969: iconst_0
    //   970: putfield e : Z
    //   973: aload_0
    //   974: sipush #309
    //   977: aconst_null
    //   978: invokespecial a : (ILjava/lang/Object;)V
    //   981: aload_0
    //   982: sipush #203
    //   985: putfield f : I
    //   988: aload_0
    //   989: aconst_null
    //   990: putfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   993: aload_0
    //   994: invokespecial y : ()V
    //   997: goto -> 1253
    //   1000: aload_0
    //   1001: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   1004: invokeinterface l : ()V
    //   1009: ldc_w 'tag_video_play'
    //   1012: ldc_w '[video] OP_RELEASE execute , releaseMediaplayer !'
    //   1015: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1018: aload_0
    //   1019: sipush #201
    //   1022: putfield f : I
    //   1025: goto -> 1253
    //   1028: astore_1
    //   1029: ldc 'SSMediaPlayeWrapper'
    //   1031: ldc_w 'OP_RESET error: '
    //   1034: aload_1
    //   1035: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1038: goto -> 1253
    //   1041: aload_0
    //   1042: getfield f : I
    //   1045: istore_2
    //   1046: iload_2
    //   1047: sipush #206
    //   1050: if_icmpeq -> 1067
    //   1053: iload_2
    //   1054: sipush #207
    //   1057: if_icmpeq -> 1067
    //   1060: iload_2
    //   1061: sipush #209
    //   1064: if_icmpne -> 876
    //   1067: aload_0
    //   1068: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   1071: invokeinterface h : ()V
    //   1076: aload_0
    //   1077: sipush #207
    //   1080: putfield f : I
    //   1083: iconst_0
    //   1084: istore_2
    //   1085: aload_0
    //   1086: iconst_0
    //   1087: putfield p : Z
    //   1090: goto -> 1255
    //   1093: astore_1
    //   1094: goto -> 1098
    //   1097: astore_1
    //   1098: iconst_0
    //   1099: istore_2
    //   1100: ldc_w 'NativeVideoController'
    //   1103: ldc_w 'OP_PAUSE error: '
    //   1106: aload_1
    //   1107: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1110: goto -> 1255
    //   1113: iconst_0
    //   1114: istore_3
    //   1115: aload_0
    //   1116: getfield f : I
    //   1119: istore_2
    //   1120: iload_2
    //   1121: sipush #205
    //   1124: if_icmpeq -> 1148
    //   1127: iload_2
    //   1128: sipush #206
    //   1131: if_icmpeq -> 1148
    //   1134: iload_2
    //   1135: sipush #207
    //   1138: if_icmpeq -> 1148
    //   1141: iload_2
    //   1142: sipush #209
    //   1145: if_icmpne -> 876
    //   1148: aload_0
    //   1149: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   1152: invokeinterface f : ()V
    //   1157: ldc_w 'tag_video_play'
    //   1160: ldc_w '[video] OP_START execute , mMediaPlayer real start !'
    //   1163: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1166: aload_0
    //   1167: sipush #206
    //   1170: putfield f : I
    //   1173: aload_0
    //   1174: getfield g : J
    //   1177: lconst_0
    //   1178: lcmp
    //   1179: iflt -> 1202
    //   1182: aload_0
    //   1183: getfield a : Lcom/bytedance/sdk/openadsdk/core/video/c/c;
    //   1186: aload_0
    //   1187: getfield g : J
    //   1190: invokeinterface a : (J)V
    //   1195: aload_0
    //   1196: ldc2_w -1
    //   1199: putfield g : J
    //   1202: iload_3
    //   1203: istore_2
    //   1204: aload_0
    //   1205: getfield i : Landroid/os/Handler;
    //   1208: ifnull -> 1255
    //   1211: aload_0
    //   1212: getfield i : Landroid/os/Handler;
    //   1215: sipush #312
    //   1218: invokevirtual removeMessages : (I)V
    //   1221: aload_0
    //   1222: getfield i : Landroid/os/Handler;
    //   1225: sipush #313
    //   1228: invokevirtual sendEmptyMessage : (I)Z
    //   1231: pop
    //   1232: iload_3
    //   1233: istore_2
    //   1234: goto -> 1255
    //   1237: astore_1
    //   1238: ldc_w 'tag_video_play'
    //   1241: ldc_w 'OP_START error: '
    //   1244: aload_1
    //   1245: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1248: iload_3
    //   1249: istore_2
    //   1250: goto -> 1255
    //   1253: iconst_0
    //   1254: istore_2
    //   1255: iload_2
    //   1256: ifeq -> 1290
    //   1259: aload_0
    //   1260: sipush #200
    //   1263: putfield f : I
    //   1266: aload_0
    //   1267: getfield c : Z
    //   1270: ifne -> 1290
    //   1273: aload_0
    //   1274: sipush #308
    //   1277: iload #4
    //   1279: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1282: invokespecial a : (ILjava/lang/Object;)V
    //   1285: aload_0
    //   1286: iconst_1
    //   1287: putfield c : Z
    //   1290: return
    //   1291: iconst_0
    //   1292: istore #9
    //   1294: goto -> 433
    //   1297: iconst_0
    //   1298: istore #9
    //   1300: goto -> 588
    // Exception table:
    //   from	to	target	type
    //   103	136	167	finally
    //   136	164	167	finally
    //   180	220	233	finally
    //   220	230	233	finally
    //   265	276	279	finally
    //   336	347	350	finally
    //   397	411	708	finally
    //   416	427	708	finally
    //   438	449	708	finally
    //   449	457	708	finally
    //   457	463	708	finally
    //   468	485	708	finally
    //   488	499	708	finally
    //   502	568	708	finally
    //   572	582	708	finally
    //   592	660	708	finally
    //   663	673	708	finally
    //   673	705	708	finally
    //   747	766	769	finally
    //   822	838	841	finally
    //   881	924	927	finally
    //   941	954	957	finally
    //   1000	1025	1028	finally
    //   1067	1083	1097	finally
    //   1085	1090	1093	finally
    //   1148	1202	1237	finally
    //   1204	1232	1237	finally
  }
  
  public void a(SurfaceHolder paramSurfaceHolder) {
    b(new Runnable(this, paramSurfaceHolder) {
          public void run() {
            d.b(this.b);
            if (d.a(this.b) != null)
              d.a(this.b).obtainMessage(110, this.a).sendToTarget(); 
          }
        });
  }
  
  public void a(a parama) {
    b(new Runnable(this, parama) {
          public void run() {
            d.b(this.b);
            if (d.a(this.b) != null)
              d.a(this.b).obtainMessage(107, this.a).sendToTarget(); 
          }
        });
  }
  
  public void a(c paramc) {
    char c1;
    if (!this.b) {
      c1 = 'Ñ';
    } else {
      c1 = 'Î';
    } 
    this.f = c1;
    o.delete(this.k);
    Handler handler = this.i;
    if (handler != null)
      handler.obtainMessage(302).sendToTarget(); 
    b("completion");
    D();
  }
  
  public void a(c paramc, int paramInt) {
    if (this.a != paramc)
      return; 
    Handler handler = this.i;
    if (handler != null)
      handler.obtainMessage(301, Integer.valueOf(paramInt)).sendToTarget(); 
  }
  
  public void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Handler handler = this.i;
    if (handler != null)
      handler.obtainMessage(311, paramInt1, paramInt2).sendToTarget(); 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean)
      try {
        return;
      } finally {
        Exception exception = null;
        t.a("SSMediaPlayeWrapper", "setQuietPlay error: ", exception);
      }  
    this.a.a(1.0F, 1.0F);
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[video] MediaPlayerProxy#start firstSeekToPosition=");
    stringBuilder.append(paramLong);
    stringBuilder.append(",firstPlay :");
    stringBuilder.append(paramBoolean1);
    stringBuilder.append(",isPauseOtherMusicVolume=");
    stringBuilder.append(paramBoolean2);
    t.b("tag_video_play", stringBuilder.toString());
    this.p = false;
    if (!paramBoolean2) {
      if (this.a != null)
        a(true); 
    } else if (this.a != null) {
      a(false);
    } 
    if (paramBoolean1) {
      r();
      this.g = paramLong;
      return;
    } 
    C();
    c c1 = this.a;
    if (c1 != null)
      try {
      
      } finally {
        c1 = null;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[video] MediaPlayerProxy#start  error: getCurrentPosition :");
        stringBuilder1.append(c1.toString());
      }  
    b(new Runnable(this) {
          public void run() {
            d.a(this.a).sendEmptyMessageDelayed(100, 0L);
            t.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
          }
        });
  }
  
  public boolean a(c paramc, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("what=");
    stringBuilder.append(paramInt1);
    stringBuilder.append("extra=");
    stringBuilder.append(paramInt2);
    t.e("SSMediaPlayeWrapper", stringBuilder.toString());
    u();
    this.f = 200;
    Handler handler = this.i;
    if (handler != null)
      handler.obtainMessage(303, paramInt1, paramInt2).sendToTarget(); 
    handler = this.h;
    if (handler != null) {
      handler.removeMessages(108);
      this.h.removeMessages(109);
    } 
    if (!this.c) {
      a(308, Integer.valueOf(paramInt1));
      this.c = true;
    } 
    if (a(paramInt1, paramInt2))
      t(); 
    return true;
  }
  
  public void b() {
    this.h.removeMessages(100);
    this.p = true;
    this.h.sendEmptyMessage(101);
    D();
  }
  
  public void b(c paramc) {
    this.f = 205;
    if (this.p) {
      this.h.post(new Runnable(this) {
            public void run() {
              try {
                d.c(this.a).h();
                return;
              } finally {
                Exception exception = null;
                t.a("SSMediaPlayeWrapper", "onPrepared error: ", exception);
              } 
            }
          });
    } else {
      Handler handler1 = this.h;
      handler1.sendMessage(handler1.obtainMessage(100, -1, -1));
    } 
    o.delete(this.k);
    Handler handler = this.i;
    if (handler != null)
      handler.sendEmptyMessage(305); 
    v();
  }
  
  public boolean b(c paramc, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("what,extra:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",");
    stringBuilder.append(paramInt2);
    t.e("SSMediaPlayeWrapper", stringBuilder.toString());
    if (this.a != paramc)
      return false; 
    Handler handler = this.i;
    if (handler != null) {
      handler.obtainMessage(304, paramInt1, paramInt2).sendToTarget();
      if (paramInt2 == -1004)
        this.i.obtainMessage(303, paramInt1, paramInt2).sendToTarget(); 
    } 
    b(paramInt1, paramInt2);
    return false;
  }
  
  public void c() {
    this.f = 203;
    D();
    z();
    if (this.h != null)
      try {
        b("release");
        this.h.removeCallbacksAndMessages(null);
        if (this.a != null)
          return; 
      } finally {
        Exception exception = null;
        t();
      }  
  }
  
  public void c(c paramc) {
    Handler handler = this.i;
    if (handler != null)
      handler.sendEmptyMessage(306); 
  }
  
  public void d() {
    b(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).sendEmptyMessage(105); 
          }
        });
  }
  
  public void e() {
    Handler handler = this.h;
    if (handler != null)
      handler.obtainMessage(108).sendToTarget(); 
  }
  
  public void f() {
    Handler handler = this.h;
    if (handler != null)
      handler.obtainMessage(109).sendToTarget(); 
  }
  
  public boolean g() {
    return ((this.f == 206 || this.h.hasMessages(100)) && !this.p);
  }
  
  public boolean h() {
    return (k() || g() || i());
  }
  
  public boolean i() {
    return ((this.f == 207 || this.p) && !this.h.hasMessages(100));
  }
  
  public boolean j() {
    return (this.f == 203);
  }
  
  public boolean k() {
    return (this.f == 205);
  }
  
  public boolean l() {
    return (this.f == 209);
  }
  
  public void m() {
    this.t = 0L;
    this.u = System.currentTimeMillis();
  }
  
  public long n() {
    return this.w;
  }
  
  public long o() {
    D();
    return this.t;
  }
  
  public long p() {
    if (this.u > 0L) {
      this.t += System.currentTimeMillis() - this.u;
      this.u = System.currentTimeMillis();
    } 
    return this.t;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */