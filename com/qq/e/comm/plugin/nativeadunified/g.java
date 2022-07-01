package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.nativ.widget.ViewStatusListener;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.aa.b.b;
import com.qq.e.comm.plugin.aa.b.d;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.f;
import com.qq.e.comm.plugin.ad.h;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.l.b;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.bf;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class g implements NativeUnifiedADData, ADEventListener, a, c.a, b, a {
  private boolean A;
  
  private boolean B;
  
  private int C;
  
  private boolean D;
  
  private boolean E;
  
  private boolean F;
  
  private boolean G;
  
  private volatile boolean H;
  
  private boolean I;
  
  private final boolean J;
  
  private volatile b.d K;
  
  private ADListener L;
  
  private b.a M;
  
  private b.c N;
  
  private VideoPreloadListener O;
  
  private final a P;
  
  private final c Q;
  
  private long R;
  
  private boolean S;
  
  private com.qq.e.comm.plugin.c.a.a T;
  
  private f U;
  
  NativeAdContainer a;
  
  boolean b;
  
  final com.qq.e.comm.plugin.ad.g c;
  
  MediaView d;
  
  c e;
  
  volatile f f;
  
  Space g;
  
  int h;
  
  int i;
  
  boolean j;
  
  boolean k;
  
  boolean l;
  
  boolean m;
  
  ImageView n;
  
  r o;
  
  private final i p;
  
  private Context q;
  
  private final h r;
  
  private int s;
  
  private com.qq.e.comm.plugin.ac.a t;
  
  private b.b u;
  
  private long v;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private boolean z;
  
  g(JSONObject paramJSONObject, i parami) {
    boolean bool2;
    boolean bool1 = false;
    this.s = 0;
    this.u = b.b.a;
    this.x = 1;
    this.h = 1;
    this.i = 1;
    this.y = 1;
    this.C = n.a();
    this.D = false;
    this.E = false;
    this.F = true;
    this.G = true;
    this.k = false;
    this.l = false;
    this.I = true;
    this.K = b.d.a;
    this.P = new a(this, Looper.getMainLooper());
    this.S = false;
    String str = parami.c();
    this.r = new h(parami.b(), str, parami.d(), e.l, paramJSONObject);
    h h1 = this.r;
    if (h1.v() && this.r.ah() && b.a(this.r.Z())) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    h1.c(bool2);
    this.c = new com.qq.e.comm.plugin.ad.g();
    this.p = parami;
    SM sM = GDTADManager.getInstance().getSM();
    if (SDKStatus.getSDKVersionCode() >= 70 && sM.getInteger("nativeCheckWindowFocus", 1) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.J = bool2;
    if (sM.getIntegerForPlacement("needVideoDetailPage", str, 1) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.j = bool2;
    this.Q = new c();
    this.Q.a(str);
    this.Q.b(this.r.m());
    this.Q.c(this.r.H());
    l.a().a(this.r.al(), this);
    if (sM.getInteger("nativeUnifiedPreloadVideo", 1) == 1)
      bool1 = true; 
    if (bool1)
      A(); 
  }
  
  private void A() {
    if (t()) {
      this.z = true;
      e(true);
      return;
    } 
    GDTLogger.e("only video AD needs preloadVideo");
  }
  
  private boolean B() {
    File file = aj.d(this.r.G());
    if (file == null || !file.exists())
      return false; 
    this.v = (int)(file.length() >> 10L);
    return true;
  }
  
  private void C() {
    e(false);
  }
  
  private void D() {
    int j;
    if (!N()) {
      this.e.a(0, true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can't play now, auto = ");
      stringBuilder.append(this.C);
      stringBuilder.append(", curr = ");
      stringBuilder.append(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getNameValue());
      GDTLogger.e(stringBuilder.toString());
      return;
    } 
    if (this.x == 0) {
      GDTLogger.d("readyToPlayOnUIThread, but already play");
      return;
    } 
    if (this.u != b.b.e && this.u != b.b.d && this.u != b.b.f && this.u != b.b.g)
      a(b.b.c); 
    if (this.f == null) {
      j = -1;
    } else {
      j = this.f.e();
    } 
    a(8, new Object[] { Integer.valueOf(j) });
    if (!H()) {
      if (E()) {
        this.x = 0;
        e_();
        return;
      } 
      this.P.sendEmptyMessage(3);
    } 
  }
  
  private boolean E() {
    return bf.a(this.q, (View)this.a, 50, this.J);
  }
  
  private void F() {
    MediaView mediaView = this.d;
    if (mediaView == null)
      return; 
    com.qq.e.comm.plugin.ac.a a1 = this.t;
    if (a1 == null) {
      this.t = new com.qq.e.comm.plugin.ac.a(mediaView.getContext());
    } else {
      ViewParent viewParent = a1.getParent();
      if (viewParent != null)
        ((ViewGroup)viewParent).removeView((View)this.t); 
    } 
    this.t.setVisibility(0);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(this.d.getContext().getApplicationContext(), 46), am.a(this.d.getContext().getApplicationContext(), 46));
    layoutParams.gravity = 17;
    this.d.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void G() {
    boolean bool1;
    boolean bool2;
    if (this.d == null) {
      GDTLogger.d("未绑定MediaView组件，不上报视频播放效果！");
      return;
    } 
    b b1 = new b(this.p.d(), e.l, this.p.c());
    if (this.x == 0) {
      bool1 = u();
    } else {
      bool1 = false;
    } 
    if (this.x == 0) {
      bool2 = this.w;
    } else {
      bool2 = false;
    } 
    d.a(this.h, this.i, this.y, this.x, bool1, bool2, this.r.q(), b1, new d.b(this) {
          public void a() {
            GDTLogger.d("NativeAd report video info success");
            if (!StringUtil.isEmpty(g.h(this.a).t()))
              ah.a(g.h(this.a).t()); 
          }
          
          public void a(int param1Int, Exception param1Exception) {
            GDTLogger.e("NativeAd report video info error");
          }
        });
  }
  
  private boolean H() {
    return (this == c.a());
  }
  
  private void I() {
    if (SDKStatus.getSDKVersionCode() <= 10)
      return; 
    if (this.d != null && this.f != null) {
      FrameLayout.LayoutParams layoutParams;
      Space space1 = this.g;
      if (space1 == null) {
        this.g = new Space(this.q.getApplicationContext());
      } else {
        ViewParent viewParent = space1.getParent();
        if (viewParent instanceof ViewGroup)
          ((ViewGroup)viewParent).removeView((View)this.g); 
      } 
      MediaView mediaView = this.d;
      Space space2 = this.g;
      if (this.f == null) {
        layoutParams = new FrameLayout.LayoutParams(1, 1);
      } else {
        layoutParams = new FrameLayout.LayoutParams(this.f.getWidth(), this.f.getHeight());
      } 
      mediaView.addView((View)space2, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private void J() {
    if (SDKStatus.getSDKVersionCode() <= 10)
      return; 
    MediaView mediaView = this.d;
    if (mediaView != null) {
      Space space = this.g;
      if (space != null)
        mediaView.removeView((View)space); 
    } 
  }
  
  private void K() {
    if (this.j) {
      j = 4096;
    } else {
      j = 0;
    } 
    int k = j;
    if (this.k)
      k = j | 0x400; 
    int m = this.C;
    if (m == 1) {
      j = k | 0x100;
    } else {
      j = k;
      if (m == 2)
        j = k | 0x200; 
    } 
    k = j;
    if (this.G)
      k = j | 0x40; 
    int j = k;
    if (this.F)
      j = k | 0x10; 
    k = j;
    if (this.A)
      k = j | 0x4; 
    j = k;
    if (this.z)
      j = k | 0x1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("trackVideoOptionOnExposed ,eventValue : ");
    stringBuilder.append(j);
    stringBuilder.append(" ,Binary : ");
    stringBuilder.append(Integer.toBinaryString(j));
    GDTLogger.d(stringBuilder.toString());
    u.a(30502, j, this.Q);
  }
  
  private void L() {
    G();
    a(12, (Object[])null);
  }
  
  private String M() {
    return this.r.m();
  }
  
  private boolean N() {
    // Byte code:
    //   0: aload_0
    //   1: getfield C : I
    //   4: istore_1
    //   5: iconst_1
    //   6: istore_3
    //   7: iload_1
    //   8: ifne -> 28
    //   11: iload_3
    //   12: istore_2
    //   13: getstatic com/qq/e/comm/managers/status/NetworkType.WIFI : Lcom/qq/e/comm/managers/status/NetworkType;
    //   16: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   19: invokevirtual getDeviceStatus : ()Lcom/qq/e/comm/managers/status/DeviceStatus;
    //   22: invokevirtual getNetworkType : ()Lcom/qq/e/comm/managers/status/NetworkType;
    //   25: if_acmpeq -> 58
    //   28: iload_3
    //   29: istore_2
    //   30: aload_0
    //   31: getfield C : I
    //   34: iconst_1
    //   35: if_icmpeq -> 58
    //   38: iload_3
    //   39: istore_2
    //   40: aload_0
    //   41: getfield D : Z
    //   44: ifne -> 58
    //   47: aload_0
    //   48: getfield E : Z
    //   51: ifeq -> 56
    //   54: iconst_1
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_2
    //   58: iload_2
    //   59: ireturn
  }
  
  private boolean O() {
    int j = getPictureWidth();
    int k = getPictureHeight();
    if (j != 0 && k != 0)
      return false; 
    if (j == 0 && k == 0) {
      j = 3;
    } else if (j == 0) {
      j = 1;
    } else {
      j = 2;
    } 
    u.a(30282, j, this.Q);
    return true;
  }
  
  private void P() {
    int j = null.a[this.u.ordinal()];
    if (j != 1) {
      if (j != 2)
        return; 
      if (!E()) {
        a(b.b.c);
        if (this.f != null)
          this.f.a(); 
      } 
    } else if (E()) {
      this.h = 1;
      e_();
    } 
    this.P.sendEmptyMessageDelayed(3, 500L);
  }
  
  private void a(FrameLayout.LayoutParams paramLayoutParams) {
    this.n = new ImageView(this.q);
    FrameLayout.LayoutParams layoutParams = paramLayoutParams;
    if (paramLayoutParams == null) {
      layoutParams = new FrameLayout.LayoutParams(am.a(this.q, 46), am.a(this.q, 14));
      layoutParams.gravity = 8388693;
    } 
    this.a.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
    h h1 = this.r;
    if (h1 != null)
      com.qq.e.comm.plugin.util.g.a(this.n, h1.C()); 
    this.n.setOnClickListener(new f(this, this.r, this.T, this.q, this.Q));
  }
  
  private void a(VideoOption paramVideoOption) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   3: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull -> 89
    //   11: aload_3
    //   12: ldc_w 'shouldMuteVideo'
    //   15: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   18: astore #4
    //   20: aload #4
    //   22: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   25: ifeq -> 36
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial c : (Lcom/qq/e/ads/cfg/VideoOption;)V
    //   33: goto -> 48
    //   36: aload_0
    //   37: ldc_w '1'
    //   40: aload #4
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: putfield A : Z
    //   48: aload_3
    //   49: ldc_w 'videoAutoPlayPolicy'
    //   52: aload_0
    //   53: invokevirtual p : ()Ljava/lang/String;
    //   56: invokevirtual getStringForPlacement : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   64: ifne -> 94
    //   67: aload_0
    //   68: aload_3
    //   69: invokestatic parseInt : (Ljava/lang/String;)I
    //   72: putfield C : I
    //   75: goto -> 99
    //   78: astore_3
    //   79: aload_3
    //   80: invokevirtual getMessage : ()Ljava/lang/String;
    //   83: invokestatic e : (Ljava/lang/String;)V
    //   86: goto -> 99
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial c : (Lcom/qq/e/ads/cfg/VideoOption;)V
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial b : (Lcom/qq/e/ads/cfg/VideoOption;)V
    //   99: aload_0
    //   100: getfield C : I
    //   103: istore_2
    //   104: iload_2
    //   105: iflt -> 113
    //   108: iload_2
    //   109: iconst_2
    //   110: if_icmple -> 120
    //   113: aload_0
    //   114: invokestatic a : ()I
    //   117: putfield C : I
    //   120: aload_1
    //   121: ifnull -> 171
    //   124: invokestatic getSDKVersionCode : ()I
    //   127: bipush #13
    //   129: if_icmplt -> 171
    //   132: aload_0
    //   133: aload_1
    //   134: invokevirtual isNeedCoverImage : ()Z
    //   137: putfield G : Z
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual isNeedProgressBar : ()Z
    //   145: putfield F : Z
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual isEnableUserControl : ()Z
    //   153: putfield k : Z
    //   156: aload_1
    //   157: invokevirtual isEnableDetailPage : ()Z
    //   160: ifne -> 171
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual isEnableDetailPage : ()Z
    //   168: putfield j : Z
    //   171: aload_1
    //   172: ifnull -> 191
    //   175: invokestatic getSDKVersionCode : ()I
    //   178: bipush #60
    //   180: if_icmplt -> 191
    //   183: aload_0
    //   184: aload_1
    //   185: invokevirtual isDetailPageMuted : ()Z
    //   188: putfield l : Z
    //   191: return
    // Exception table:
    //   from	to	target	type
    //   67	75	78	java/lang/Exception
  }
  
  private void a(NativeAdContainer paramNativeAdContainer) {
    NativeAdContainer nativeAdContainer = this.a;
    if (nativeAdContainer != null)
      nativeAdContainer.setViewStatusListener(null); 
    this.a = paramNativeAdContainer;
    this.a.setViewStatusListener(new ViewStatusListener(this) {
          public void onAttachToWindow() {
            GDTLogger.d("Container has attached to window");
            g.a(this.a);
          }
          
          public void onDetachFromWindow() {
            GDTLogger.d("Container has detached to window");
            this.a.a();
          }
          
          public void onDispatchTouchEvent(MotionEvent param1MotionEvent) {
            this.a.c.a((View)this.a.a, param1MotionEvent, false);
            this.a.o.a(param1MotionEvent);
          }
          
          public void onWindowFocusChanged(boolean param1Boolean) {}
          
          public void onWindowVisibilityChanged(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Container visibility changed visibility: ");
            stringBuilder.append(param1Int);
            GDTLogger.d(stringBuilder.toString());
            if (param1Int == 0) {
              g.a(this.a);
              return;
            } 
            this.a.a();
          }
        });
  }
  
  private void a(List<View> paramList1, List<View> paramList2) {
    if (paramList1 != null && paramList1.size() > 0) {
      Iterator<View> iterator = paramList1.iterator();
      while (iterator.hasNext())
        ((View)iterator.next()).setOnClickListener(new f(this, this.r, this.T, this.q, this.Q)); 
    } 
    if (paramList2 != null && paramList2.size() > 0) {
      Iterator<View> iterator = paramList2.iterator();
      while (iterator.hasNext())
        ((View)iterator.next()).setOnClickListener(new f(this, this.r, this.T, this.q, this.Q, true)); 
    } 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    char c1;
    byte b1;
    if (paramBoolean1) {
      c1 = '癨';
    } else {
      c1 = '癲';
    } 
    if (paramBoolean2)
      c1 = '皐'; 
    if (c.a() != null) {
      GDTLogger.e("只能在视频预览页调用视频播放接口");
      u.a(c1, 1, this.Q);
      return;
    } 
    if (this.f != null && !this.f.c() && E()) {
      if (paramBoolean1) {
        this.E = true;
        if (!B()) {
          C();
          return;
        } 
      } 
      GDTLogger.d("startVideo by developer");
      this.h = 0;
      e_();
      b1 = 2;
    } else {
      GDTLogger.e("NOT Video AD or visible area too small, can't start play");
      b1 = 3;
    } 
    u.a(c1, b1, this.Q);
  }
  
  private f b(View paramView) {
    if (paramView != null) {
      Rect rect = new Rect();
      if (paramView.getGlobalVisibleRect(rect)) {
        int j = paramView.getWidth();
        int k = paramView.getHeight();
        int m = rect.width();
        int n = rect.height();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewWidth=");
        stringBuilder.append(j);
        stringBuilder.append(", ViewHeight=");
        stringBuilder.append(k);
        GDTLogger.d(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("VisibleWidth=");
        stringBuilder.append(m);
        stringBuilder.append(", VisibleHeight=");
        stringBuilder.append(n);
        GDTLogger.d(stringBuilder.toString());
        return new f(true, j, k, m, n, paramView.toString());
      } 
      GDTLogger.d("Ad is not visible.");
    } 
    return null;
  }
  
  private void b(VideoOption paramVideoOption) {
    if (paramVideoOption != null)
      this.C = paramVideoOption.getAutoPlayPolicy(); 
  }
  
  private void c(VideoOption paramVideoOption) {
    boolean bool;
    if (this.B)
      return; 
    if (paramVideoOption != null) {
      bool = paramVideoOption.getAutoPlayMuted();
    } else {
      bool = true;
    } 
    this.A = bool;
  }
  
  private void d(boolean paramBoolean) {
    if (this.d != null && this.f != null) {
      if (paramBoolean) {
        this.f.h();
        return;
      } 
      this.f.i();
    } 
  }
  
  private void e(boolean paramBoolean) {
    boolean bool = B();
    String str = "";
    if (bool) {
      GDTLogger.d("video exists!");
      if (paramBoolean) {
        VideoPreloadListener videoPreloadListener = this.O;
        if (videoPreloadListener != null)
          videoPreloadListener.onVideoCached(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preloadVideo, video already cached, cl : ");
        h h1 = this.r;
        if (h1 != null)
          str = h1.m(); 
        stringBuilder.append(str);
        GDTLogger.d(stringBuilder.toString());
        return;
      } 
      this.K = b.d.d;
      D();
      return;
    } 
    if (this.K == b.d.a) {
      if (!paramBoolean) {
        F();
        c c1 = this.e;
        if (c1 != null)
          c1.post(new Runnable(this) {
                public void run() {
                  if (this.a.e != null)
                    this.a.e.d(); 
                }
              }); 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preloadVideo, cl : ");
        h h1 = this.r;
        if (h1 != null)
          str = h1.m(); 
        stringBuilder.append(str);
        GDTLogger.d(stringBuilder.toString());
      } 
      a(paramBoolean);
    } 
  }
  
  private void f(boolean paramBoolean) {
    byte b1;
    char c1;
    if (paramBoolean) {
      c1 = '發';
    } else {
      c1 = '皆';
    } 
    if (c.a() != null) {
      GDTLogger.e("只能在视频预览页调用视频暂停接口");
      b1 = 1;
    } else if (this.f != null && this.f.c()) {
      GDTLogger.d("pauseVideo by developer");
      this.f.a();
      this.e.a(0L);
      a(b.b.f);
      b1 = 2;
    } else {
      GDTLogger.e("Only Video AD can be paused");
      b1 = 3;
    } 
    u.a(c1, b1, this.Q);
  }
  
  private void v() {
    this.T = (com.qq.e.comm.plugin.c.a.a)new c(this, this.q) {
        public void a(com.qq.e.comm.plugin.s.a param1a) {
          super.a(param1a);
          this.b.a((String)null, false);
        }
        
        public void b(com.qq.e.comm.plugin.s.a param1a) {
          super.b(param1a);
          this.b.a((String)null, false);
        }
        
        public void c(String param1String) {
          super.c(param1String);
          this.b.a(param1String, false);
        }
      };
    this.U = new f(this, this.r, this.T, this.q, this.Q);
  }
  
  private void w() {
    if (t() && this.K == b.d.d)
      this.P.sendEmptyMessage(3); 
    if (!this.b)
      this.P.sendEmptyMessage(1); 
  }
  
  @Deprecated
  private void x() {
    MediaView mediaView = this.d;
    if (mediaView != null)
      mediaView.post(new Runnable(this) {
            public void run() {
              if (this.a.d != null) {
                int i = this.a.d.getWidth();
                int j = (int)(i * 9.0F / 16.0F);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("width = ");
                stringBuilder.append(i);
                stringBuilder.append(", height = ");
                stringBuilder.append(j);
                GDTLogger.d(stringBuilder.toString());
                ViewGroup.LayoutParams layoutParams = this.a.d.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = j;
                this.a.d.setLayoutParams(layoutParams);
              } 
            }
          }); 
  }
  
  private void y() {
    boolean bool;
    if (this.f == null && this.e == null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.d.removeAllViews();
    FrameLayout.LayoutParams layoutParams = z();
    if (this.f == null) {
      this.f = new f(this.q.getApplicationContext());
      this.f.b(true);
      this.f.setFitsSystemWindows(true);
      this.f.setKeepScreenOn(true);
      this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (SDKStatus.getSDKVersionCode() >= 13) {
        this.f.a(getPictureWidth(), getPictureHeight());
        O();
      } 
    } else {
      ViewParent viewParent = this.f.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView((View)this.f); 
    } 
    this.d.addView((View)this.f);
    c c1 = this.e;
    if (c1 == null) {
      this.e = new c(this.q.getApplicationContext(), 1, getImgUrl(), this.F, this.G);
      this.e.setFitsSystemWindows(true);
      this.e.setKeepScreenOn(true);
    } else {
      ViewParent viewParent = c1.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView((View)this.e); 
    } 
    this.f.a((b)this.e);
    this.d.addView((View)this.e);
    com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.d, this.r.o(), this.f);
    com.qq.e.comm.plugin.aa.b.g.a(false);
    this.e.a((d.a)this);
    this.e.c(true);
    this.e.post(new Runnable(this) {
          public void run() {
            if (this.a.e != null)
              this.a.e.a(3000, true); 
          }
        });
    if (bool) {
      a(b.b.a);
      a(5, (Object[])null);
    } 
  }
  
  private FrameLayout.LayoutParams z() {
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    return layoutParams;
  }
  
  d.b a(View paramView, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
    d.c c1;
    int j;
    f f1 = b(paramView);
    int k = GDTADManager.getInstance().getSM().getIntegerForPlacement("download_confirm", paramString1, 0);
    if (this.r.a_() == 48) {
      j = 48;
    } else {
      j = paramInt2;
      if (paramInt2 == -1)
        if (paramBoolean1 && !b.d(this.r)) {
          j = 1;
        } else {
          j = 0;
        }  
    } 
    if (q() == 2) {
      c1 = d.c.b;
    } else {
      c1 = d.c.a;
    } 
    return (new d.b(j, c1)).a(paramInt1).a(paramString2).b(k).a(f1).a(paramBoolean2);
  }
  
  protected void a() {
    GDTLogger.d("Container has detach from window");
    this.P.removeMessages(1);
    this.P.removeMessages(3);
    if (this.f != null && this.f != c.b() && this.f.c()) {
      this.f.a();
      a(b.b.c);
    } 
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
  }
  
  public void a(int paramInt, Exception paramException) {
    GDTLogger.d("onVideoError");
    this.x = 2;
    a(13, new Object[] { Integer.valueOf(701) });
    G();
    l.b(false, this.Q, paramInt);
  }
  
  void a(int paramInt, Object[] paramArrayOfObject) {
    this.P.post(new Runnable(this, paramInt, paramArrayOfObject) {
          public void run() {
            if (g.k(this.c) != null)
              g.k(this.c).onADEvent(new ADEvent(this.a, this.b)); 
          }
        });
  }
  
  void a(View paramView) {
    if (this.b)
      return; 
    l.a((Boolean)null, this.Q, 0);
    com.qq.e.comm.plugin.ad.a.a().a(paramView);
    this.c.a(System.currentTimeMillis());
    paramView.post(new Runnable(this, com.qq.e.comm.plugin.ad.a.a().b(paramView)) {
          public void run() {
            byte b;
            b b1 = new b(g.i(this.b).d(), e.l, g.i(this.b).c());
            String str = g.h(this.b).q();
            if (this.b.t()) {
              g.j(this.b);
              str = i.a(str);
              b = 1;
            } else {
              b = 2;
            } 
            i.a(this.b.c.a((View)this.b.a, b, g.h(this.b).x(), null), this.a, g.h(this.b), b1, str, new d.b(this) {
                  public void a() {
                    if (!StringUtil.isEmpty(g.h(this.a.b).t()))
                      ah.a(g.h(this.a.b).t()); 
                    l.a(Boolean.valueOf(true), g.g(this.a.b), 0);
                  }
                  
                  public void a(int param2Int, Exception param2Exception) {
                    GDTLogger.e("NativeUnifiedAD exposed err");
                    l.a(Boolean.valueOf(false), g.g(this.a.b), param2Int);
                  }
                });
          }
        });
    this.r.V();
    this.r.W();
    a(1, (Object[])null);
    this.b = true;
    if (!t())
      l.b(this.Q); 
  }
  
  void a(View paramView, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramView == null) {
      GDTLogger.e("clicked view is null");
      return;
    } 
    if (!paramBoolean2)
      a(2, new Object[] { "" }); 
    d.a a1 = i.a(this.r);
    d.e e = new d.e(paramString3, e.l, paramString2);
    d.b b1 = a(paramView, paramInt1, paramString2, paramString4, paramBoolean1, paramInt2, paramBoolean3);
    b1.i = com.qq.e.comm.plugin.ad.a.a().b((View)this.a);
    d.a(paramView, a1, e, b1);
  }
  
  public void a(View paramView, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2) {
    a(paramView, paramInt, paramString1, paramString2, paramString3, paramString4, paramBoolean1, -1, paramBoolean2, false);
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean) {
    e.b((new f.a(this.r, paramView)).f(paramBoolean ^ true).a(paramString).a(), this.T);
    if (!paramBoolean)
      a(2, new Object[] { "" }); 
  }
  
  public void a(b.a parama) {
    this.M = parama;
  }
  
  public void a(b.b paramb) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NativeUnifiedADController setMediaStatus: ");
    stringBuilder.append(this.u);
    stringBuilder.append("-->");
    stringBuilder.append(paramb);
    GDTLogger.d(stringBuilder.toString());
    this.u = paramb;
  }
  
  public void a(b.c paramc) {
    this.N = paramc;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    h h1 = this.r;
    if (h1 != null) {
      h1.i(paramInt1);
      if (this.r.z() != null) {
        this.r.z().c(paramInt1);
        this.r.z().a(paramInt2);
        this.r.z().a(paramLong);
      } 
    } 
    this.s = paramInt2;
    a(4, (Object[])null);
    b.a a1 = this.M;
    if (a1 != null)
      a1.a(paramString, paramInt1, paramInt2, paramLong); 
  }
  
  void a(String paramString, boolean paramBoolean) {
    if (c.a() != null) {
      paramString = "广告点击太快";
    } else if (this.d == null) {
      paramString = "未绑定MediaView或广告已被释放！";
    } else {
      if (this.f != null && !this.f.c())
        this.h = 0; 
      I();
      this.d.removeView((View)this.f);
      this.d.removeView((View)this.e);
      c.a(this);
      JSONObject jSONObject = n.a(this.q, this);
      u.a(30292, 1, this.Q, new d(jSONObject));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("landing: ");
      stringBuilder.append(jSONObject.toString());
      GDTLogger.i(stringBuilder.toString());
      c.a((b)this.e);
      c.a(this.f);
      c.a(u());
      c.a(paramBoolean);
      String str = m();
      c.a(a((View)this.a, 0, p(), str, isAppAd(), -1, false));
      c.a(new d.e(o(), e.l, p()));
      this.e.a(true, false);
      this.e.a(true);
      a();
      Intent intent = new Intent();
      Context context = this.q.getApplicationContext();
      intent.setClassName(context.getApplicationContext(), at.b());
      intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
      intent.putExtra("gdt_activity_delegate_name", "detailPage");
      intent.putExtra("antiSpam", str);
      intent.putExtra("detailPageMuted", this.l);
      intent.putExtra("url", paramString);
      intent.addFlags(268435456);
      context.startActivity(intent);
      return;
    } 
    GDTLogger.e(paramString);
  }
  
  public void a(boolean paramBoolean) {
    long l = System.currentTimeMillis();
    File file = aj.f();
    if (file == null) {
      a(3, new Object[] { Integer.valueOf(700) });
      return;
    } 
    String str = this.r.G();
    b b1 = (new b.a()).b(str).a(aj.a(str)).a(file).a();
    com.qq.e.comm.plugin.aa.a.a.a().a(b1, str, new com.qq.e.comm.plugin.j.a(this, l, paramBoolean, str) {
          public void a() {
            GDTLogger.d("onStarted");
            g.a(this.d, b.d.b);
            this.d.a(6, (Object[])null);
          }
          
          public void a(long param1Long1, long param1Long2, int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("downloading[");
            stringBuilder.append(this.d.getTitle());
            stringBuilder.append("] video ---> Progress: ");
            stringBuilder.append(param1Int);
            stringBuilder.append("%");
            GDTLogger.d(stringBuilder.toString());
            if (g.b(this.d)) {
              if (g.c(this.d) != null) {
                g.c(this.d).a(param1Int);
                return;
              } 
            } else {
              Message message = Message.obtain();
              message.what = 4;
              message.arg1 = param1Int;
              g.d(this.d).sendMessage(message);
            } 
          }
          
          public void a(long param1Long, boolean param1Boolean) {
            g.a(this.d, param1Long >> 10L);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onConnected isRangeSupport: ");
            stringBuilder.append(param1Boolean);
            stringBuilder.append(", total: ");
            stringBuilder.append(param1Long);
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void a(c param1c) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Download Failed, code: ");
            stringBuilder.append(param1c.a());
            stringBuilder.append(", msg: ");
            stringBuilder.append(param1c.b());
            GDTLogger.e(stringBuilder.toString());
            Message message = Message.obtain();
            message.what = 7;
            message.obj = Boolean.valueOf(this.b);
            g.d(this.d).sendMessage(message);
            g.d(this.d).sendEmptyMessage(5);
            if (this.d.m)
              l.a(param1c, this.c, g.g(this.d)); 
          }
          
          public void a(File param1File, long param1Long) {
            GDTLogger.d("onCompleted");
            long l = System.currentTimeMillis() - this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("download time: ");
            stringBuilder.append(l);
            stringBuilder.append("ms");
            GDTLogger.d(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("download speed: ");
            stringBuilder.append(g.e(this.d) / l);
            stringBuilder.append("kb/s");
            GDTLogger.d(stringBuilder.toString());
            if (g.f(this.d)) {
              GDTLogger.i("download complete after destroyed");
              return;
            } 
            Message message = Message.obtain();
            message.what = 6;
            message.obj = Boolean.valueOf(this.b);
            g.d(this.d).sendMessage(message);
            bc.a(param1Long, (int)g.e(this.d), this.c, g.g(this.d));
          }
          
          public void b() {
            GDTLogger.i("onPaused");
            g.a(this.d, b.d.c);
          }
          
          public void c() {
            GDTLogger.i("onCanceled");
            g.a(this.d, b.d.e);
            g.d(this.d).sendEmptyMessage(5);
          }
        });
  }
  
  boolean a(View paramView1, View paramView2) {
    if (paramView2 != null && paramView1 != null)
      for (ViewParent viewParent = paramView2.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
        if (viewParent == paramView1)
          return true; 
      }  
    return false;
  }
  
  public void b(boolean paramBoolean) {
    b.b b1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPlayPauseButtonClicked mMediaStatus: ");
    stringBuilder.append(this.u);
    GDTLogger.d(stringBuilder.toString());
    if (!paramBoolean)
      this.h = 0; 
    if (paramBoolean) {
      b1 = b.b.d;
    } else {
      b1 = b.b.b;
    } 
    a(b1);
    if (!H())
      if (this.k) {
        s();
      } else {
        u.a(30192, 3, this.Q);
        this.U.a(false);
      }  
    b.a a1 = this.M;
    if (a1 != null)
      a1.c(); 
  }
  
  public void b_() {
    GDTLogger.d("onVideoReady");
    this.x = 0;
    if (this.d != null && this.f != null) {
      this.w = this.f.e();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("duration = ");
      stringBuilder.append(this.w);
      GDTLogger.d(stringBuilder.toString());
    } 
    a(7, (Object[])null);
  }
  
  public void bindAdToView(Context paramContext, NativeAdContainer paramNativeAdContainer, FrameLayout.LayoutParams paramLayoutParams, List<View> paramList) {
    bindAdToView(paramContext, paramNativeAdContainer, paramLayoutParams, paramList, null);
  }
  
  public void bindAdToView(Context paramContext, NativeAdContainer paramNativeAdContainer, FrameLayout.LayoutParams paramLayoutParams, List<View> paramList1, List<View> paramList2) {
    if (this.o == null)
      l.a(true, 0, this.Q); 
    GDTLogger.d("NativeUnifiedADController bindAdToView");
    ab.a().a(this.p.c());
    if (paramNativeAdContainer == null) {
      GDTLogger.e("NativeAdContainer can't be null when binding ad to view");
      if (this.o == null) {
        l.a(false, 1, this.Q);
        return;
      } 
    } else {
      byte b1;
      if (paramContext == null) {
        GDTLogger.e("Context can't be null when binding ad to view");
        if (this.o == null) {
          b1 = 2;
        } else {
          return;
        } 
      } else if (this.H) {
        GDTLogger.e("NativeUnifiedADData has been destroyed");
        if (this.o == null) {
          b1 = 3;
        } else {
          return;
        } 
      } else {
        this.q = paramContext;
        this.o = new r(this.q);
        v();
        a(paramNativeAdContainer);
        a(paramLayoutParams);
        a(paramList1, paramList2);
        return;
      } 
      l.a(false, b1, this.Q);
      return;
    } 
  }
  
  public void bindCTAViews(List<View> paramList) {
    if (paramList != null && paramList.size() > 0)
      for (int j = 0; j < paramList.size(); j++) {
        View view = paramList.get(j);
        if (view != null)
          view.setOnClickListener(new e(this, this.r, this.T, this.Q)); 
      }  
  }
  
  public void bindMediaView(MediaView paramMediaView, VideoOption paramVideoOption, NativeADMediaListener paramNativeADMediaListener) {
    String str;
    b.d d1;
    boolean bool = this.m;
    this.m = false;
    if (this.z && this.K == b.d.b)
      a(6, (Object[])null); 
    GDTLogger.d("NativeUnifiedADController bindMediaView");
    if (paramMediaView == null) {
      str = "MediaView shouldn't be null！";
    } else if (str.getVisibility() != 0) {
      str = "MediaView should be visible";
    } else if (Build.VERSION.SDK_INT < 16) {
      str = "Native ad don't support Android version below 4.1";
    } else if (!t()) {
      str = "The native ad doesn't contain video";
    } else {
      if (Build.VERSION.SDK_INT >= 11 && !str.isHardwareAccelerated()) {
        GDTLogger.e("Hardware acceleration is off");
        this.I = false;
      } else {
        this.I = true;
      } 
      if (!a((View)this.a, (View)str)) {
        str = "MediaView is not in container";
      } else if (this.H) {
        str = "NativeUnifiedADData has been destroyed";
      } else {
        if (!bool)
          l.c(this.Q); 
        this.m = true;
        this.d = (MediaView)str;
        a(paramVideoOption);
        MediaView mediaView = this.d;
        if (mediaView != null)
          mediaView.setOnClickListener(new f(this, this.r, this.T, this.q, this.Q)); 
        y();
        d(this.A);
        if (!B()) {
          d1 = b.d.a;
        } else {
          d1 = b.d.d;
        } 
        this.K = d1;
        if (this.C == 1 || NetworkType.WIFI == GDTADManager.getInstance().getDeviceStatus().getNetworkType())
          C(); 
        if (SDKStatus.getSDKVersionCode() <= 10) {
          x();
          return;
        } 
        if (SDKStatus.getSDKVersionCode() < 13) {
          this.d.setRatio(getPictureWidth(), getPictureHeight());
          O();
        } 
        return;
      } 
    } 
    GDTLogger.e((String)d1);
  }
  
  void c(boolean paramBoolean) {
    a((String)null, paramBoolean);
  }
  
  public void c_() {
    GDTLogger.d("onVideoStart");
    if (!this.b)
      l(); 
    a(9, (Object[])null);
    b.a a1 = this.M;
    if (a1 != null)
      a1.d(); 
    if (this.R > 0L) {
      bc.b(System.currentTimeMillis() - this.R, (int)this.v, this.r.G(), this.Q);
      l.b(true, this.Q, 0);
      this.R = -1L;
    } 
  }
  
  public boolean d() {
    return this.I;
  }
  
  public void destroy() {
    this.H = true;
    this.P.removeCallbacksAndMessages(null);
    if (this.f != null) {
      this.f.l();
      this.f = null;
    } 
    MediaView mediaView = this.d;
    if (mediaView != null) {
      mediaView.removeAllViews();
      this.d = null;
    } 
    c c1 = this.e;
    if (c1 != null) {
      c1.i();
      this.e.removeAllViews();
      this.e = null;
    } 
    if (this.t != null)
      this.t = null; 
    if (H()) {
      JSONObject jSONObject = n.a(this.q, c.a());
      u.a(30292, 4, this.Q, new d(jSONObject));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("release: ");
      stringBuilder.append(jSONObject.toString());
      GDTLogger.i(stringBuilder.toString());
      c.g();
    } 
    this.q = null;
  }
  
  public com.qq.e.comm.plugin.ad.g e() {
    return this.c;
  }
  
  public void e_() {
    File file = aj.d(this.r.G());
    if (file != null) {
      String str = file.getAbsolutePath();
    } else {
      file = null;
    } 
    if (file == null) {
      GDTLogger.e("Video path is null.");
      return;
    } 
    a(b.b.b);
    if (this.e != null)
      this.P.post(new Runnable(this) {
            public void run() {
              if (this.a.e != null)
                this.a.e.d(); 
            }
          }); 
    if (this.f != null) {
      if (!file.equals(this.f.k()))
        this.f.a((String)file); 
      if (this.R == 0L)
        this.R = System.currentTimeMillis(); 
      this.f.b();
    } 
  }
  
  public boolean equalsAdData(NativeUnifiedADData paramNativeUnifiedADData) {
    boolean bool2 = false;
    if (paramNativeUnifiedADData == null)
      return false; 
    boolean bool1 = bool2;
    if (paramNativeUnifiedADData instanceof NativeUnifiedADDataAdapter) {
      paramNativeUnifiedADData = ((NativeUnifiedADDataAdapter)paramNativeUnifiedADData).getAdData();
      bool1 = bool2;
      if (paramNativeUnifiedADData instanceof g) {
        paramNativeUnifiedADData = paramNativeUnifiedADData;
        if (M() == null) {
          bool1 = bool2;
          if (paramNativeUnifiedADData.M() == null)
            return true; 
        } else {
          bool1 = M().equals(paramNativeUnifiedADData.M());
        } 
      } 
    } 
    return bool1;
  }
  
  public b.d f() {
    return this.K;
  }
  
  public void f_() {
    GDTLogger.d("onVideoComplete");
    L();
    this.y = 3;
    a(b.b.e);
  }
  
  public void g() {
    GDTLogger.d("onVideoResume");
    this.y = 2;
    a(11, (Object[])null);
    b.a a1 = this.M;
    if (a1 != null)
      a1.d(); 
  }
  
  public void g_() {
    byte b1;
    GDTLogger.d("onVideoStop");
    G();
    if (SDKStatus.getSDKVersionCode() < 13) {
      b1 = 12;
    } else {
      b1 = 14;
    } 
    a(b1, (Object[])null);
  }
  
  public int getAdPatternType() {
    return this.r.c();
  }
  
  public double getAppPrice() {
    return this.r.h();
  }
  
  public int getAppScore() {
    return this.r.g();
  }
  
  public int getAppStatus() {
    return this.r.e();
  }
  
  public String getCTAText() {
    return this.r.a();
  }
  
  public String getDesc() {
    return this.r.i();
  }
  
  public long getDownloadCount() {
    return this.r.f();
  }
  
  public int getECPM() {
    return this.r.I();
  }
  
  public String getECPMLevel() {
    return this.r.J();
  }
  
  public String getIconUrl() {
    return this.r.p();
  }
  
  public List<String> getImgList() {
    return this.r.d();
  }
  
  public String getImgUrl() {
    return this.r.o();
  }
  
  public int getMediationPrice() {
    return this.r.K();
  }
  
  public int getPictureHeight() {
    return this.r.ak();
  }
  
  public int getPictureWidth() {
    return this.r.k();
  }
  
  public int getProgress() {
    return this.s;
  }
  
  public String getTitle() {
    return this.r.n();
  }
  
  @Deprecated
  public String getVastContent() {
    return null;
  }
  
  @Deprecated
  public String getVastTag() {
    return null;
  }
  
  public int getVideoCurrentPosition() {
    if (this.f != null)
      return this.f.f(); 
    GDTLogger.e("Only Video AD can getVideoCurrentPosition");
    return -1;
  }
  
  public int getVideoDuration() {
    return (SDKStatus.getSDKVersionCode() < 60) ? ((this.f == null) ? -1 : this.f.e()) : this.r.j();
  }
  
  public b.b h() {
    return this.u;
  }
  
  public void h_() {
    GDTLogger.d("onVideoPause");
    a(10, (Object[])null);
    if (!this.S)
      G(); 
    this.S = false;
  }
  
  public int i() {
    return com.qq.e.comm.plugin.ad.a.a().b((View)this.a);
  }
  
  public void i_() {
    GDTLogger.d("onEnterFSButtonClicked");
    b.a a1 = this.M;
    if (a1 != null)
      a1.a(); 
  }
  
  public boolean isAppAd() {
    return this.r.v();
  }
  
  public boolean isContractAd() {
    return this.r.L();
  }
  
  @Deprecated
  public boolean isSkippable() {
    return false;
  }
  
  public void j() {
    this.M = null;
  }
  
  public void j_() {
    GDTLogger.d("onCloseButtonClicked");
    b.a a1 = this.M;
    if (a1 != null)
      a1.b(); 
  }
  
  public void k() {}
  
  void l() {
    String str;
    MediaView mediaView = this.d;
    if (mediaView == null) {
      str = "未绑定MediaView组件，不上报广告曝光！";
    } else if (!str.getGlobalVisibleRect(new Rect())) {
      str = "MediaView不可见，不上报广告曝光！";
    } else {
      GDTLogger.i("on video ad exposed");
      a((View)this.a);
      return;
    } 
    GDTLogger.e(str);
  }
  
  String m() {
    byte b1;
    this.c.a().b(this.a.getWidth());
    this.c.a().a(this.a.getHeight());
    String str = this.r.x();
    this.c.a().b(str);
    h h1 = this.c.a();
    if (t()) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    h1.c(b1);
    try {
      null = this.c.b();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("anti info:");
      stringBuilder.append(null);
      GDTLogger.d(stringBuilder.toString());
      return URLEncoder.encode(null, "UTF-8");
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get anti failed:");
      stringBuilder.append(exception);
      GDTLogger.w(stringBuilder.toString());
      return null;
    } 
  }
  
  public com.qq.e.comm.plugin.s.a n() {
    return this.r;
  }
  
  public void negativeFeedback() {
    if (!TextUtils.isEmpty(this.r.u()))
      ah.a(this.r.u()); 
  }
  
  String o() {
    return this.p.d();
  }
  
  public void onVideoADExposured(View paramView) {
    GDTLogger.e("onVideoADExposured接口已经废弃，不会执行曝光");
  }
  
  String p() {
    return this.p.c();
  }
  
  public void pauseVideo() {
    f(true);
  }
  
  public void preloadVideo(VideoPreloadListener paramVideoPreloadListener) {
    this.O = paramVideoPreloadListener;
    A();
  }
  
  int q() {
    return this.p.a();
  }
  
  int r() {
    return this.r.O();
  }
  
  @Deprecated
  public void reportVastEvent(ADEvent paramADEvent) {}
  
  public void resume() {
    if (H()) {
      this.S = true;
      this.f = c.b();
      d(this.A);
      this.e = (c)c.c();
      JSONObject jSONObject = n.a(this.q, c.a());
      u.a(30292, 3, this.Q, new d(jSONObject));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("resume: ");
      stringBuilder.append(jSONObject.toString());
      GDTLogger.i(stringBuilder.toString());
      c.g();
      ViewGroup viewGroup2 = (ViewGroup)this.f.getParent();
      if (viewGroup2 != null)
        viewGroup2.removeView((View)this.f); 
      c c1 = this.e;
      if (c1 == null)
        return; 
      ViewGroup viewGroup1 = (ViewGroup)c1.getParent();
      if (viewGroup1 != null)
        viewGroup1.removeView((View)this.e); 
      FrameLayout.LayoutParams layoutParams = z();
      this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.d.addView((View)this.f);
      J();
      this.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.d.addView((View)this.e);
      this.e.c(true);
      this.i = 1;
      if (this.t != null && this.K == b.d.d && this.t.getVisibility() == 0)
        this.t.setVisibility(8); 
      this.e.a(this.F);
      this.e.a(this.G, true);
      u.a(30232, 2, this.Q);
      return;
    } 
    u.a(30232, 1, this.Q);
  }
  
  public void resumeVideo() {
    a(true, false);
  }
  
  void s() {
    this.D = true;
    if (!B()) {
      C();
      return;
    } 
    if (this.f != null && this.e != null) {
      if (this.f.c()) {
        f(false);
      } else {
        a(false, false);
      } 
      a(15, (Object[])null);
      return;
    } 
    GDTLogger.e("VideoView未初始化完成，无法播放或暂停");
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.L = paramADListener;
  }
  
  public void setNativeAdEventListener(NativeADEventListener paramNativeADEventListener) {}
  
  public void setVideoMute(boolean paramBoolean) {
    byte b1;
    if (c.a() != null) {
      GDTLogger.e("只能在视频预览页调用静音设置接口");
      u.a(30372, 1, this.Q);
      return;
    } 
    if (this.f != null) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      if (paramBoolean) {
        str = "mute";
      } else {
        str = "sound";
      } 
      stringBuilder.append(str);
      stringBuilder.append(" by developer");
      GDTLogger.d(stringBuilder.toString());
      d(paramBoolean);
      this.A = paramBoolean;
      b1 = 2;
    } else {
      GDTLogger.e("Only Video AD can be muted");
      b1 = 3;
    } 
    u.a(30372, b1, this.Q);
    this.B = true;
  }
  
  public void startVideo() {
    a(true, false);
  }
  
  public void stopVideo() {
    byte b1;
    if (c.a() != null) {
      GDTLogger.e("只能在视频预览页调用视频停止接口");
      u.a(30362, 1, this.Q);
      return;
    } 
    if (this.f != null && (this.f.c() || this.u == b.b.f || this.u == b.b.d)) {
      this.f.a(true, true);
      this.e.postDelayed(new Runnable(this) {
            public void run() {
              if (this.a.e != null)
                this.a.e.a(0L); 
            }
          },  100L);
      a(b.b.g);
      b1 = 2;
    } else {
      GDTLogger.e("Only Video AD can be stopped");
      b1 = 3;
    } 
    u.a(30362, b1, this.Q);
  }
  
  boolean t() {
    return this.r.ah();
  }
  
  int u() {
    return (this.f != null) ? this.f.f() : 0;
  }
  
  class a extends Handler {
    a(g this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 1) {
        if (i != 3) {
          Object object;
          if (i != 4) {
            if (i != 5) {
              boolean bool = false;
              if (i != 6) {
                if (i != 7)
                  return; 
                object = param1Message.obj;
                if (object instanceof Boolean) {
                  bool = ((Boolean)object).booleanValue();
                } else {
                  bool = false;
                } 
                if (bool && g.p(this.a) != null)
                  g.p(this.a).onVideoCacheFailed(700, "video preload failed"); 
                if (this.a.m) {
                  g.a(this.a, 2);
                  g.a(this.a, b.d.e);
                  g.r(this.a);
                  this.a.a(3, new Object[] { Integer.valueOf(700) });
                  if (g.c(this.a) != null) {
                    g.c(this.a).b();
                    return;
                  } 
                } 
              } else {
                g.a(this.a, b.d.d);
                object = ((Message)object).obj;
                if (object instanceof Boolean)
                  bool = ((Boolean)object).booleanValue(); 
                if (bool && g.p(this.a) != null)
                  g.p(this.a).onVideoCached(); 
                if (this.a.m) {
                  g.q(this.a);
                  if (g.c(this.a) != null) {
                    g.c(this.a).a();
                    return;
                  } 
                } 
              } 
            } else {
              if (g.o(this.a) != null)
                g.o(this.a).setVisibility(8); 
              if (this.a.e != null) {
                this.a.e.c();
                return;
              } 
            } 
          } else if (g.o(this.a) != null) {
            g.o(this.a).a(((Message)object).arg1);
            if (((Message)object).arg1 == 100) {
              g.o(this.a).setVisibility(8);
              return;
            } 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("MSG_CHECK_VIDEO_VISIBILITY, mMediaStatus = ");
          stringBuilder.append(g.m(this.a));
          GDTLogger.d(stringBuilder.toString());
          g.n(this.a);
          return;
        } 
      } else {
        long l;
        if (g.l(this.a)) {
          g g1 = this.a;
          g1.a((View)g1.a);
          return;
        } 
        if (this.a.t()) {
          l = 100L;
        } else {
          l = 1000L;
        } 
        sendEmptyMessageDelayed(1, l);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */