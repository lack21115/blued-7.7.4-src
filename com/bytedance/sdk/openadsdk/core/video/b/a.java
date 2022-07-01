package com.bytedance.sdk.openadsdk.core.video.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.h;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a implements c, d, ak.a {
  private boolean A;
  
  private boolean B;
  
  private WeakReference<e> C;
  
  private int D;
  
  private boolean E;
  
  private boolean F;
  
  private final Runnable G;
  
  private final Runnable H;
  
  private final Runnable I;
  
  private boolean J;
  
  private long K;
  
  private final BroadcastReceiver L;
  
  private int M;
  
  private boolean N;
  
  public final WeakReference<Context> a;
  
  public final k b;
  
  public long c;
  
  protected Map<String, Object> d;
  
  protected long e;
  
  protected long f;
  
  protected boolean g;
  
  public long h;
  
  private h i;
  
  private final ViewGroup j;
  
  private final ak k = new ak(this);
  
  private long l = 0L;
  
  private long m = 0L;
  
  private d n;
  
  private c.a o;
  
  private long p = 0L;
  
  private long q = 0L;
  
  private ArrayList<Runnable> r;
  
  private boolean s;
  
  private final boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private boolean w;
  
  private boolean x;
  
  private long y;
  
  private boolean z;
  
  public a(Context paramContext, ViewGroup paramViewGroup, k paramk) {
    boolean bool = false;
    this.u = false;
    this.v = false;
    this.w = true;
    this.x = false;
    this.y = 0L;
    this.z = false;
    this.A = false;
    this.B = false;
    this.d = null;
    this.e = 0L;
    this.f = 0L;
    this.g = false;
    this.E = false;
    this.F = true;
    this.G = new Runnable(this) {
        public void run() {
          if (a.b(this.a) != null)
            a.b(this.a).e(); 
        }
      };
    this.H = new Runnable(this) {
        public void run() {
          if (a.h(this.a) != null)
            a.h(this.a).a(); 
        }
      };
    this.I = new Runnable(this) {
        public void run() {
          if (a.b(this.a) != null) {
            if (this.a.c <= 0L)
              a.b(this.a).e(); 
            a.b(this.a).f();
          } 
          a.e(this.a).postDelayed(this, 200L);
        }
      };
    this.J = false;
    this.L = new BroadcastReceiver(this) {
        public void onReceive(Context param1Context, Intent param1Intent) {
          String str = param1Intent.getAction();
          if ("android.intent.action.SCREEN_OFF".equals(str)) {
            this.a.h();
            return;
          } 
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
            a.a(this.a, param1Context); 
        }
      };
    this.M = 1;
    this.N = false;
    this.M = w.c(paramContext);
    this.j = paramViewGroup;
    this.a = new WeakReference<Context>(paramContext);
    this.b = paramk;
    a(paramContext);
    this.D = ah.d(this.b.P());
    if (Build.VERSION.SDK_INT >= 17)
      bool = true; 
    this.t = bool;
  }
  
  private void C() {
    int i = a();
    if (i == 2 || i == 1) {
      i = o.h().S() * 1000;
    } else if (i == 3) {
      i = o.h().f(String.valueOf(this.D));
    } else {
      i = 5;
    } 
    this.k.removeCallbacks(this.H);
    this.k.postDelayed(this.H, i);
  }
  
  private void D() {
    E();
    this.k.postDelayed(this.I, 800L);
  }
  
  private void E() {
    this.k.removeCallbacks(this.I);
  }
  
  private boolean F() {
    WeakReference<Context> weakReference = this.a;
    return (weakReference != null && weakReference.get() != null);
  }
  
  private void G() {
    ArrayList<Runnable> arrayList = this.r;
    if (arrayList != null) {
      if (arrayList.isEmpty())
        return; 
      Iterator<?> iterator = (new ArrayList(this.r)).iterator();
      while (iterator.hasNext())
        ((Runnable)iterator.next()).run(); 
      this.r.clear();
    } 
  }
  
  private boolean H() throws Throwable {
    WeakReference<Context> weakReference = this.a;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (weakReference != null) {
      bool1 = bool2;
      if (weakReference.get() != null) {
        bool1 = bool2;
        if (K() != null) {
          d d1 = this.n;
          bool1 = bool2;
          if (d1 != null) {
            bool1 = bool2;
            if (d1.a() != null) {
              k k1 = this.b;
              bool1 = bool2;
              if (k1 != null) {
                bool1 = bool2;
                if (k1.x() == null) {
                  if (this.b.h() == 1)
                    return true; 
                  bool1 = false;
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  private void I() {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #9
    //   9: aload #9
    //   11: ldc_w 'changeVideoSize start.......mMaterialMeta.getAdSlot()='
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload #9
    //   20: aload_0
    //   21: getfield b : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   24: invokevirtual j : ()Lcom/bytedance/sdk/openadsdk/AdSlot;
    //   27: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc_w 'changeVideoSize'
    //   34: aload #9
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: invokespecial H : ()Z
    //   46: ifeq -> 50
    //   49: return
    //   50: ldc_w 'changeVideoSize'
    //   53: ldc_w 'changeVideoSize start check condition complete ... go ..'
    //   56: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokestatic a : ()Landroid/content/Context;
    //   62: invokestatic b : (Landroid/content/Context;)[I
    //   65: astore #9
    //   67: aload_0
    //   68: getfield n : Lcom/bytedance/sdk/openadsdk/core/video/c/d;
    //   71: invokevirtual a : ()Landroid/media/MediaPlayer;
    //   74: astore #10
    //   76: aload_0
    //   77: getfield b : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   80: invokevirtual Q : ()I
    //   83: istore #7
    //   85: iconst_1
    //   86: istore #8
    //   88: iload #7
    //   90: bipush #15
    //   92: if_icmpne -> 733
    //   95: iconst_1
    //   96: istore #7
    //   98: goto -> 101
    //   101: aload #9
    //   103: iconst_0
    //   104: iaload
    //   105: i2f
    //   106: fstore_3
    //   107: aload #9
    //   109: iconst_1
    //   110: iaload
    //   111: i2f
    //   112: fstore #4
    //   114: aload #10
    //   116: invokevirtual getVideoWidth : ()I
    //   119: i2f
    //   120: fstore_2
    //   121: aload #10
    //   123: invokevirtual getVideoHeight : ()I
    //   126: i2f
    //   127: fstore_1
    //   128: iload #7
    //   130: ifeq -> 159
    //   133: fload_2
    //   134: fload_1
    //   135: fcmpl
    //   136: ifle -> 185
    //   139: ldc_w 'changeVideoSize'
    //   142: ldc_w '横转竖屏单独适配.....'
    //   145: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: fload_3
    //   150: fload #4
    //   152: fload_2
    //   153: fload_1
    //   154: iconst_1
    //   155: invokespecial a : (FFFFZ)V
    //   158: return
    //   159: fload_2
    //   160: fload_1
    //   161: fcmpg
    //   162: ifge -> 185
    //   165: ldc_w 'changeVideoSize'
    //   168: ldc_w '竖屏转横单独适配.....'
    //   171: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: fload_3
    //   176: fload #4
    //   178: fload_2
    //   179: fload_1
    //   180: iconst_0
    //   181: invokespecial a : (FFFFZ)V
    //   184: return
    //   185: fload_2
    //   186: fload_1
    //   187: fdiv
    //   188: fstore #5
    //   190: fload_3
    //   191: fload #4
    //   193: fdiv
    //   194: fstore #6
    //   196: new java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial <init> : ()V
    //   203: astore #9
    //   205: aload #9
    //   207: ldc_w 'screenHeight='
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #9
    //   216: fload #4
    //   218: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload #9
    //   224: ldc_w ',screenWidth='
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #9
    //   233: fload_3
    //   234: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc_w 'changeVideoSize'
    //   241: aload #9
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   249: new java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial <init> : ()V
    //   256: astore #9
    //   258: aload #9
    //   260: ldc_w 'videoHeight='
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload #9
    //   269: fload_1
    //   270: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload #9
    //   276: ldc_w ',videoWidth='
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload #9
    //   285: fload_2
    //   286: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc_w 'changeVideoSize'
    //   293: aload #9
    //   295: invokevirtual toString : ()Ljava/lang/String;
    //   298: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   301: new java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial <init> : ()V
    //   308: astore #9
    //   310: aload #9
    //   312: ldc_w '视频宽高比,videoScale='
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #9
    //   321: fload #5
    //   323: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload #9
    //   329: ldc_w ',屏幕宽高比.screenScale='
    //   332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload #9
    //   338: fload #6
    //   340: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #9
    //   346: ldc_w ',VERTICAL_SCALE(9:16)='
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload #9
    //   355: ldc_w 0.5625
    //   358: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload #9
    //   364: ldc_w ',HORIZONTAL_SCALE(16:9) ='
    //   367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload #9
    //   373: ldc_w 1.7777778
    //   376: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: ldc_w 'changeVideoSize'
    //   383: aload #9
    //   385: invokevirtual toString : ()Ljava/lang/String;
    //   388: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   391: iload #7
    //   393: ifeq -> 435
    //   396: fload #6
    //   398: ldc_w 0.5625
    //   401: fcmpg
    //   402: ifge -> 739
    //   405: fload #5
    //   407: ldc_w 0.5625
    //   410: fcmpl
    //   411: ifne -> 739
    //   414: ldc_w 9.0
    //   417: fload #4
    //   419: fmul
    //   420: ldc_w 16.0
    //   423: fdiv
    //   424: fstore_2
    //   425: fload #4
    //   427: fstore_1
    //   428: iload #8
    //   430: istore #7
    //   432: goto -> 472
    //   435: fload #6
    //   437: ldc_w 1.7777778
    //   440: fcmpl
    //   441: ifle -> 739
    //   444: fload #5
    //   446: ldc_w 1.7777778
    //   449: fcmpl
    //   450: ifne -> 739
    //   453: ldc_w 9.0
    //   456: fload_3
    //   457: fmul
    //   458: ldc_w 16.0
    //   461: fdiv
    //   462: fstore_1
    //   463: fload_3
    //   464: fstore_2
    //   465: iload #8
    //   467: istore #7
    //   469: goto -> 472
    //   472: new java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial <init> : ()V
    //   479: astore #9
    //   481: aload #9
    //   483: ldc_w '适配后宽高：videoHeight='
    //   486: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload #9
    //   492: fload_1
    //   493: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload #9
    //   499: ldc_w ',videoWidth='
    //   502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload #9
    //   508: fload_2
    //   509: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: ldc_w 'changeVideoSize'
    //   516: aload #9
    //   518: invokevirtual toString : ()Ljava/lang/String;
    //   521: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   524: iload #7
    //   526: ifne -> 745
    //   529: new java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial <init> : ()V
    //   536: astore #9
    //   538: aload #9
    //   540: ldc_w ' 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight='
    //   543: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload #9
    //   549: fload #4
    //   551: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload #9
    //   557: ldc_w '，videoWidth='
    //   560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload #9
    //   566: fload_3
    //   567: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: ldc_w 'changeVideoSize'
    //   574: aload #9
    //   576: invokevirtual toString : ()Ljava/lang/String;
    //   579: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   582: fload #4
    //   584: fstore_1
    //   585: fload_3
    //   586: fstore_2
    //   587: goto -> 590
    //   590: fload_2
    //   591: f2i
    //   592: istore #7
    //   594: fload_1
    //   595: f2i
    //   596: istore #8
    //   598: new android/widget/RelativeLayout$LayoutParams
    //   601: dup
    //   602: iload #7
    //   604: iload #8
    //   606: invokespecial <init> : (II)V
    //   609: astore #9
    //   611: aload #9
    //   613: bipush #13
    //   615: invokevirtual addRule : (I)V
    //   618: aload_0
    //   619: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   622: ifnull -> 709
    //   625: aload_0
    //   626: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   629: instanceof android/view/TextureView
    //   632: ifeq -> 650
    //   635: aload_0
    //   636: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   639: checkcast android/view/TextureView
    //   642: aload #9
    //   644: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   647: goto -> 672
    //   650: aload_0
    //   651: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   654: instanceof android/view/SurfaceView
    //   657: ifeq -> 672
    //   660: aload_0
    //   661: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   664: checkcast android/view/SurfaceView
    //   667: aload #9
    //   669: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   672: aload_0
    //   673: getfield j : Landroid/view/ViewGroup;
    //   676: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   679: astore #9
    //   681: aload #9
    //   683: ifnull -> 709
    //   686: aload #9
    //   688: iload #8
    //   690: putfield height : I
    //   693: aload #9
    //   695: iload #7
    //   697: putfield width : I
    //   700: aload_0
    //   701: getfield j : Landroid/view/ViewGroup;
    //   704: aload #9
    //   706: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   709: ldc_w 'changeVideoSize'
    //   712: ldc_w 'changeVideoSize .... complete ... end !!!'
    //   715: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   718: return
    //   719: astore #9
    //   721: ldc_w 'changeVideoSize'
    //   724: ldc_w 'changeSize error'
    //   727: aload #9
    //   729: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   732: return
    //   733: iconst_0
    //   734: istore #7
    //   736: goto -> 101
    //   739: iconst_0
    //   740: istore #7
    //   742: goto -> 472
    //   745: goto -> 590
    // Exception table:
    //   from	to	target	type
    //   0	49	719	finally
    //   50	85	719	finally
    //   114	128	719	finally
    //   139	158	719	finally
    //   165	184	719	finally
    //   185	391	719	finally
    //   414	425	719	finally
    //   453	463	719	finally
    //   472	524	719	finally
    //   529	582	719	finally
    //   598	647	719	finally
    //   650	672	719	finally
    //   672	681	719	finally
    //   686	709	719	finally
    //   709	718	719	finally
  }
  
  private void J() {
    try {
      return;
    } finally {
      Exception exception = null;
      t.a("changeVideoSize", "changeSize error", exception);
    } 
  }
  
  private b K() {
    WeakReference<Context> weakReference = this.a;
    if (weakReference != null && weakReference.get() != null) {
      h h1 = this.i;
      if (h1 != null)
        return h1.o(); 
    } 
    return null;
  }
  
  private void L() {
    h h1 = this.i;
    if (h1 != null) {
      h1.c(0);
      this.i.a(false, false);
      this.i.b(false);
      this.i.b();
      this.i.d();
    } 
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: aload #7
    //   11: ldc_w 'screenWidth='
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload #7
    //   20: fload_1
    //   21: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #7
    //   27: ldc_w ',screenHeight='
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #7
    //   36: fload_2
    //   37: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc_w 'changeVideoSize'
    //   44: aload #7
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: new java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial <init> : ()V
    //   59: astore #7
    //   61: aload #7
    //   63: ldc_w 'videoHeight='
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #7
    //   72: fload #4
    //   74: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #7
    //   80: ldc_w ',videoWidth='
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #7
    //   89: fload_3
    //   90: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc_w 'changeVideoSize'
    //   97: aload #7
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: fload_3
    //   106: fconst_0
    //   107: fcmpg
    //   108: ifle -> 122
    //   111: fload #4
    //   113: fstore #6
    //   115: fload #4
    //   117: fconst_0
    //   118: fcmpg
    //   119: ifgt -> 291
    //   122: aload_0
    //   123: getfield b : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   126: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   129: invokevirtual b : ()I
    //   132: i2f
    //   133: fstore_3
    //   134: aload_0
    //   135: getfield b : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   138: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   141: invokevirtual a : ()I
    //   144: i2f
    //   145: fstore #6
    //   147: goto -> 291
    //   150: ldc_w 'changeVideoSize'
    //   153: ldc_w '竖屏模式下按视频宽度计算放大倍数值'
    //   156: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   159: fload #6
    //   161: fload_1
    //   162: fmul
    //   163: fload_3
    //   164: fdiv
    //   165: fstore_2
    //   166: new android/widget/RelativeLayout$LayoutParams
    //   169: dup
    //   170: fload_1
    //   171: f2i
    //   172: fload_2
    //   173: f2i
    //   174: invokespecial <init> : (II)V
    //   177: astore #7
    //   179: aload #7
    //   181: bipush #13
    //   183: invokevirtual addRule : (I)V
    //   186: goto -> 223
    //   189: ldc_w 'changeVideoSize'
    //   192: ldc_w '横屏模式下按视频高度计算放大倍数值'
    //   195: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   198: new android/widget/RelativeLayout$LayoutParams
    //   201: dup
    //   202: fload_3
    //   203: fload_2
    //   204: fmul
    //   205: fload #6
    //   207: fdiv
    //   208: f2i
    //   209: fload_2
    //   210: f2i
    //   211: invokespecial <init> : (II)V
    //   214: astore #7
    //   216: aload #7
    //   218: bipush #13
    //   220: invokevirtual addRule : (I)V
    //   223: aload_0
    //   224: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   227: ifnull -> 290
    //   230: aload_0
    //   231: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   234: instanceof android/view/TextureView
    //   237: ifeq -> 253
    //   240: aload_0
    //   241: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   244: checkcast android/view/TextureView
    //   247: aload #7
    //   249: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   252: return
    //   253: aload_0
    //   254: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   257: instanceof android/view/SurfaceView
    //   260: ifeq -> 290
    //   263: aload_0
    //   264: invokespecial K : ()Lcom/bytedance/sdk/openadsdk/core/video/renderview/b;
    //   267: checkcast android/view/SurfaceView
    //   270: aload #7
    //   272: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   275: return
    //   276: return
    //   277: astore #7
    //   279: ldc_w 'changeVideoSize'
    //   282: ldc_w 'changeSize error'
    //   285: aload #7
    //   287: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: return
    //   291: fload #6
    //   293: fconst_0
    //   294: fcmpg
    //   295: ifle -> 276
    //   298: fload_3
    //   299: fconst_0
    //   300: fcmpg
    //   301: ifgt -> 305
    //   304: return
    //   305: iload #5
    //   307: ifeq -> 318
    //   310: fload_3
    //   311: fload #6
    //   313: fcmpg
    //   314: ifge -> 150
    //   317: return
    //   318: fload_3
    //   319: fload #6
    //   321: fcmpl
    //   322: ifle -> 189
    //   325: return
    // Exception table:
    //   from	to	target	type
    //   0	105	277	finally
    //   122	147	277	finally
    //   150	186	277	finally
    //   189	223	277	finally
    //   223	252	277	finally
    //   253	275	277	finally
  }
  
  private void a(long paramLong1, long paramLong2) {
    this.p = paramLong1;
    this.c = paramLong2;
    this.i.a(paramLong1, paramLong2);
    int i = com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1, paramLong2);
    this.i.a(i);
    try {
      if (this.o != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  private void a(long paramLong, boolean paramBoolean) {
    if (this.n == null)
      return; 
    if (paramBoolean)
      L(); 
    this.n.a(paramLong);
  }
  
  private void a(Context paramContext) {
    EnumSet<b.a> enumSet = EnumSet.noneOf(b.a.class);
    enumSet.add(b.a.a);
    enumSet.add(b.a.e);
    this.i = new h(paramContext.getApplicationContext(), LayoutInflater.from(paramContext.getApplicationContext()).inflate(ab.f(paramContext, "tt_video_play_layout_for_live"), null, false), true, enumSet, this.b, this);
    this.i.a((com.bytedance.sdk.openadsdk.core.video.nativevideo.a)this);
  }
  
  private void a(Runnable paramRunnable) {
    if (paramRunnable == null)
      return; 
    if (this.i.k() && this.s) {
      paramRunnable.run();
      return;
    } 
    b(paramRunnable);
  }
  
  private void a(String paramString) throws Exception {
    if (this.n != null) {
      com.bytedance.sdk.openadsdk.core.video.a.a a1 = new com.bytedance.sdk.openadsdk.core.video.a.a();
      a1.a = paramString;
      k k1 = this.b;
      if (k1 != null) {
        if (k1.z() != null)
          a1.d = this.b.z().j(); 
        a1.b = String.valueOf(ah.d(this.b.P()));
      } 
      a1.c = 1;
      this.n.a(a1);
    } 
    this.l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString)) {
      this.i.d(8);
      this.i.d(0);
      a(new Runnable(this) {
            public void run() {
              a.a(this.a, System.currentTimeMillis());
              a.a(this.a).c(0);
              if (a.b(this.a) != null && a.c(this.a) == 0L) {
                a.b(this.a).a(true, 0L, a.d(this.a) ^ true);
              } else if (a.b(this.a) != null) {
                a.b(this.a).a(true, a.c(this.a), a.d(this.a) ^ true);
              } 
              if (a.e(this.a) != null)
                a.e(this.a).postDelayed(a.f(this.a), 100L); 
              a.g(this.a);
            }
          });
    } 
  }
  
  private void b(int paramInt) {
    if (!F())
      return; 
    if (this.i == null)
      return; 
    this.k.removeCallbacks(this.H);
    this.i.w();
    this.m = System.currentTimeMillis() - this.l;
    c.a a1 = this.o;
    if (a1 != null)
      a1.a(this.m, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.p, this.c)); 
    if (ah.b(this.b))
      this.i.a(this.b, this.a, true); 
    if (!this.v) {
      b();
      this.v = true;
      long l = this.c;
      a(l, l);
      l = this.c;
      this.p = l;
      this.q = l;
    } 
    this.B = true;
  }
  
  private void b(Context paramContext) {
    if (!F())
      return; 
    int i = w.c(paramContext);
    if (this.M == i)
      return; 
    if (!this.A)
      d(2); 
    this.M = i;
  }
  
  private void b(Runnable paramRunnable) {
    if (this.r == null)
      this.r = new ArrayList<Runnable>(); 
    this.r.add(paramRunnable);
  }
  
  private boolean c(int paramInt) {
    return this.i.b(paramInt);
  }
  
  private boolean d(int paramInt) {
    int i = w.c(o.a());
    if (i != 4 && i != 0) {
      h();
      this.z = true;
      this.A = false;
      h h1 = this.i;
      if (h1 != null) {
        k k1 = this.b;
        if (k1 != null)
          return h1.a(paramInt, k1.z()); 
      } 
    } else if (i == 4) {
      this.z = false;
      h h1 = this.i;
      if (h1 != null)
        h1.q(); 
    } 
    return true;
  }
  
  private void g(boolean paramBoolean) {
    this.J = paramBoolean;
  }
  
  protected Map<String, Object> A() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Map<String, Object> map = this.d;
    if (map != null)
      for (Map.Entry<String, Object> entry : map.entrySet())
        hashMap.put(entry.getKey(), entry.getValue());  
    map = ah.a(this.f, this.b, t());
    if (map != null)
      for (Map.Entry<String, Object> entry : map.entrySet())
        hashMap.put(entry.getKey(), entry.getValue());  
    return (Map)hashMap;
  }
  
  protected Map<String, Object> B() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Map<String, Object> map = ah.a(this.b, n(), t());
    if (map != null)
      for (Map.Entry entry : map.entrySet())
        hashMap.put(entry.getKey(), entry.getValue());  
    map = this.d;
    if (map != null)
      for (Map.Entry<String, Object> entry : map.entrySet())
        hashMap.put(entry.getKey(), entry.getValue());  
    return (Map)hashMap;
  }
  
  protected abstract int a();
  
  public void a(int paramInt) {
    boolean bool;
    if (!F())
      return; 
    if (paramInt == 0 || paramInt == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    Context context = this.a.get();
    if (!(context instanceof Activity))
      return; 
    Activity activity = (Activity)context;
    try {
      activity.setRequestedOrientation(paramInt);
    } finally {
      Exception exception;
    } 
    if (!bool) {
      activity.getWindow().setFlags(1024, 1024);
      return;
    } 
    activity.getWindow().clearFlags(1024);
  }
  
  protected abstract void a(int paramInt1, int paramInt2);
  
  public void a(long paramLong) {
    this.p = paramLong;
    paramLong = this.q;
    long l = this.p;
    if (paramLong <= l)
      paramLong = l; 
    this.q = paramLong;
  }
  
  public void a(Message paramMessage) {
    if (this.i != null && paramMessage != null) {
      WeakReference<Context> weakReference = this.a;
      if (weakReference != null) {
        k k1;
        if (weakReference.get() == null)
          return; 
        int i = paramMessage.what;
        if (i != 108) {
          if (i != 109) {
            if (i != 308) {
              if (i != 311) {
                c.a a1;
                if (i != 314) {
                  h h2;
                  ak ak1;
                  h h1;
                  switch (i) {
                    default:
                      return;
                    case 306:
                      this.k.removeCallbacks(this.H);
                      h2 = this.i;
                      if (h2 != null) {
                        h2.w();
                        return;
                      } 
                      return;
                    case 305:
                      ak1 = this.k;
                      if (ak1 != null)
                        ak1.removeCallbacks(this.H); 
                      if (!this.t && !this.u) {
                        this.f = SystemClock.elapsedRealtime() - this.e;
                        f();
                        this.u = true;
                      } 
                      h1 = this.i;
                      if (h1 != null) {
                        h1.w();
                        return;
                      } 
                      return;
                    case 304:
                      i = ((Message)h1).arg1;
                      h1 = this.i;
                      if (h1 != null)
                        if (i == 3 || i == 702) {
                          this.i.w();
                          this.k.removeCallbacks(this.H);
                          this.E = false;
                        } else if (i == 701) {
                          h1.t();
                          C();
                          this.E = true;
                        }  
                      if (this.t && i == 3 && !this.u) {
                        this.f = SystemClock.elapsedRealtime() - this.e;
                        e();
                        this.u = true;
                        return;
                      } 
                      return;
                    case 303:
                      a(((Message)h1).arg1, ((Message)h1).arg2);
                      this.k.removeCallbacks(this.H);
                      h1 = this.i;
                      if (h1 != null)
                        h1.w(); 
                      a1 = this.o;
                      if (a1 != null) {
                        a1.b(this.m, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.p, this.c));
                        return;
                      } 
                      return;
                    case 302:
                      break;
                  } 
                  b(((Message)a1).what);
                  return;
                } 
                try {
                  ((Boolean)((Message)a1).obj).booleanValue();
                } finally {}
                this.e = SystemClock.elapsedRealtime();
                return;
              } 
              k1 = this.b;
              if (k1 != null && k1.f() == 0) {
                J();
                return;
              } 
              I();
              return;
            } 
            a(308, 0);
            return;
          } 
          if (((Message)k1).obj instanceof Long) {
            this.p = ((Long)((Message)k1).obj).longValue();
            long l1 = this.q;
            long l2 = this.p;
            if (l1 <= l2)
              l1 = l2; 
            this.q = l1;
            a(this.p, this.c);
            return;
          } 
        } else if (((Message)k1).obj instanceof Long && ((Long)((Message)k1).obj).longValue() > 0L) {
          this.c = ((Long)((Message)k1).obj).longValue();
        } 
      } 
    } 
  }
  
  public void a(b paramb, int paramInt) {
    if (this.n == null)
      return; 
    D();
    a(this.K, c(paramInt));
  }
  
  public void a(b paramb, int paramInt, boolean paramBoolean) {
    if (!F())
      return; 
    Context context = this.a.get();
    long l = (long)((float)(paramInt * this.c) * 1.0F / ab.l(context, "tt_video_progress_max"));
    if (this.c > 0L) {
      this.K = (int)l;
    } else {
      this.K = 0L;
    } 
    h h1 = this.i;
    if (h1 != null)
      h1.a(this.K); 
  }
  
  public void a(b paramb, SurfaceTexture paramSurfaceTexture) {
    this.s = true;
    d d1 = this.n;
    if (d1 == null)
      return; 
    d1.a(paramSurfaceTexture);
    G();
  }
  
  public void a(b paramb, SurfaceHolder paramSurfaceHolder) {
    this.s = true;
    d d1 = this.n;
    if (d1 == null)
      return; 
    d1.a(paramSurfaceHolder);
    G();
  }
  
  public void a(b paramb, SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(b paramb, View paramView) {
    if (this.n != null) {
      if (!F())
        return; 
      if (this.n.g()) {
        h();
        this.i.b(true, false);
        this.i.c();
        return;
      } 
      if (!this.n.i()) {
        h h1 = this.i;
        if (h1 != null)
          h1.c(this.j); 
        d(this.p);
        h1 = this.i;
        if (h1 != null) {
          h1.b(false, false);
          return;
        } 
      } else {
        j();
        h h1 = this.i;
        if (h1 != null)
          h1.b(false, false); 
      } 
    } 
  }
  
  public void a(b paramb, View paramView, boolean paramBoolean) {}
  
  public void a(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.w)
      h(); 
    if (paramBoolean1 && !this.w && !y()) {
      this.i.b(z() ^ true, false);
      this.i.a(paramBoolean2, true, false);
    } 
    d d1 = this.n;
    if (d1 != null && d1.g()) {
      this.i.c();
      this.i.b();
      return;
    } 
    this.i.c();
  }
  
  public void a(c.a parama) {
    this.o = parama;
  }
  
  public void a(c.c paramc) {}
  
  public void a(e parame) {
    this.C = new WeakReference<e>(parame);
  }
  
  public void a(e.a parama, String paramString) {
    int i = null.a[parama.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        j();
        this.z = false;
        this.A = true;
        return;
      } 
      a(true);
      return;
    } 
    h();
  }
  
  public void a(Map<String, Object> paramMap) {
    this.d = paramMap;
  }
  
  public void a(boolean paramBoolean) {
    k();
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<String> paramList, String paramString3, long paramLong, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("video local url ");
    stringBuilder.append(paramString1);
    t.b("BaseVideoController", stringBuilder.toString());
    if (TextUtils.isEmpty(paramString1)) {
      t.e("BaseVideoController", "No video info");
      return false;
    } 
    this.g = paramString1.startsWith("http") ^ true;
    this.x = paramBoolean;
    if (paramLong > 0L) {
      this.p = paramLong;
      paramLong = this.q;
      long l = this.p;
      if (paramLong <= l)
        paramLong = l; 
      this.q = paramLong;
    } 
    h h1 = this.i;
    if (h1 != null) {
      h1.e();
      this.i.d();
      this.i.c(paramInt1, paramInt2);
      this.i.c(this.j);
    } 
    if (this.n == null)
      this.n = new d((Handler)this.k); 
    this.m = 0L;
    try {
      a(paramString1);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  protected abstract void b();
  
  public void b(long paramLong) {
    this.y = paramLong;
  }
  
  public void b(b paramb, int paramInt) {
    if (this.n != null)
      E(); 
    h h1 = this.i;
    if (h1 != null)
      h1.c(); 
  }
  
  public void b(b paramb, SurfaceTexture paramSurfaceTexture) {
    this.s = false;
  }
  
  public void b(b paramb, SurfaceHolder paramSurfaceHolder) {
    this.s = false;
  }
  
  public void b(b paramb, View paramView) {
    b(paramb, paramView, false, false);
  }
  
  public void b(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2) {
    if (!F())
      return; 
    g(this.J ^ true);
    if (!(this.a.get() instanceof Activity)) {
      t.b("BaseVideoController", "context is not activity, not support this function.");
      return;
    } 
    if (this.J) {
      boolean bool;
      if (paramBoolean1) {
        bool = true;
      } else {
        bool = false;
      } 
      a(bool);
      h h1 = this.i;
      if (h1 != null) {
        h1.a(this.j);
        this.i.b(false);
      } 
    } else {
      a(1);
      h h1 = this.i;
      if (h1 != null) {
        h1.b(this.j);
        this.i.b(false);
      } 
    } 
    WeakReference<e> weakReference = this.C;
    if (weakReference != null) {
      e e = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (weakReference != null)
      weakReference.a(this.J); 
  }
  
  public void b(boolean paramBoolean) {
    this.w = paramBoolean;
    this.i.c(paramBoolean);
  }
  
  protected abstract void c();
  
  public void c(long paramLong) {
    this.c = paramLong;
  }
  
  public void c(b paramb, View paramView) {
    h h1 = this.i;
    if (h1 != null)
      h1.g(); 
    a(true);
  }
  
  public void c(boolean paramBoolean) {
    this.x = paramBoolean;
    d d1 = this.n;
    if (d1 != null)
      d1.a(paramBoolean); 
  }
  
  protected abstract void d();
  
  public void d(long paramLong) {
    this.p = paramLong;
    paramLong = this.q;
    long l = this.p;
    if (paramLong <= l)
      paramLong = l; 
    this.q = paramLong;
    h h1 = this.i;
    if (h1 != null)
      h1.e(); 
    d d1 = this.n;
    if (d1 != null) {
      d1.a(true, this.p, this.x ^ true);
      D();
    } 
  }
  
  public void d(b paramb, View paramView) {
    if (this.J) {
      g(false);
      h h1 = this.i;
      if (h1 != null)
        h1.b(this.j); 
      a(1);
      return;
    } 
    a(true);
  }
  
  public void d(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  protected abstract void e();
  
  public void e(b paramb, View paramView) {
    a(paramb, paramView, false);
  }
  
  public void e(boolean paramBoolean) {}
  
  protected abstract void f();
  
  public void f(b paramb, View paramView) {}
  
  public void f(boolean paramBoolean) {
    this.F = paramBoolean;
  }
  
  public void g() {
    h h1 = this.i;
    if (h1 != null) {
      h1.b();
      this.i.e();
    } 
    h1 = this.i;
    if (h1 != null)
      h1.u(); 
    d(-1L);
    d d1 = this.n;
    if (d1 != null)
      d1.m(); 
  }
  
  public void h() {
    this.h = o();
    d d1 = this.n;
    if (d1 != null)
      d1.b(); 
    if (!this.v && this.u)
      c(); 
  }
  
  public void i() {
    d d1 = this.n;
    if (d1 != null)
      d1.d(); 
  }
  
  public void j() {
    h h1 = this.i;
    if (h1 != null) {
      h1.e();
      this.i.q();
      this.i.u();
    } 
    d d1 = this.n;
    if (d1 != null) {
      d1.a(false, this.p, this.x ^ true);
      D();
    } 
    if (!this.v && this.u)
      d(); 
  }
  
  public void k() {
    d d1 = this.n;
    if (d1 != null) {
      d1.c();
      this.n = null;
    } 
    h h1 = this.i;
    if (h1 != null)
      h1.g(); 
    ak ak1 = this.k;
    if (ak1 != null) {
      ak1.removeCallbacks(this.H);
      this.k.removeCallbacks(this.G);
      this.k.removeCallbacksAndMessages(null);
      E();
    } 
    this.o = null;
  }
  
  public void l() {
    k();
  }
  
  public long m() {
    return this.p;
  }
  
  public long n() {
    return (t() == null) ? 0L : t().n();
  }
  
  public long o() {
    d d1 = this.n;
    return (d1 == null) ? 0L : (d1.o() + this.y);
  }
  
  public long p() {
    d d1 = this.n;
    return (d1 == null) ? 0L : (d1.p() + this.y);
  }
  
  public int q() {
    return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.q, this.c);
  }
  
  public long r() {
    return this.c;
  }
  
  public boolean s() {
    return this.z;
  }
  
  public d t() {
    return this.n;
  }
  
  public h u() {
    return this.i;
  }
  
  public boolean v() {
    return this.B;
  }
  
  public boolean w() {
    return this.E;
  }
  
  public void x() {
    if (!this.v && this.u)
      d(); 
  }
  
  public boolean y() {
    return this.n.l();
  }
  
  public boolean z() {
    d d1 = this.n;
    return (d1 != null && d1.g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */