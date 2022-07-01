package com.qq.e.comm.plugin.gdtnativead;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.aa.b.d;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ab.a.c;
import com.qq.e.comm.plugin.ab.c;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ab.d.f;
import com.qq.e.comm.plugin.ab.e;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.ad.n;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.gdtnativead.a.b;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ag;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.plugin.util.be;
import com.qq.e.comm.plugin.util.bf;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.util.j;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.a.f;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements View.OnClickListener, NEADVI, a, b, c, f, h.a, b.a, c.a {
  private static final String p = b.c();
  
  private static final String q;
  
  private static final String r;
  
  private int A;
  
  private String B;
  
  private HashMap<String, JSONObject> C;
  
  private String D;
  
  private boolean E = false;
  
  private Boolean F = null;
  
  private f G;
  
  private int H = -2;
  
  private com.qq.e.comm.plugin.ac.a I;
  
  private az J;
  
  private int K = 1;
  
  private int L = 1;
  
  private int M = 1;
  
  private int N = 0;
  
  private int O;
  
  private Rect P = new Rect();
  
  private int Q;
  
  private int R;
  
  private FrameLayout S;
  
  private int T;
  
  private FrameLayout.LayoutParams U;
  
  private FrameLayout.LayoutParams V;
  
  private FrameLayout.LayoutParams W;
  
  private FrameLayout.LayoutParams X;
  
  private Window.Callback Y;
  
  private d Z;
  
  h a;
  
  private Runnable aA = new Runnable(this) {
      public void run() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onContentChanged from view ");
        if (this.a.a != null) {
          object = Integer.valueOf(this.a.a.a().hashCode());
        } else {
          object = null;
        } 
        stringBuilder.append(object);
        GDTLogger.d(stringBuilder.toString());
        h.n(this.a);
      }
    };
  
  private ag.a aB = new ag.a(this) {
      public void a() {
        if (this.a.k == 1)
          return; 
        h.d(this.a, false);
        h.d(this.a, 3);
      }
      
      public void b() {
        if (this.a.k == 1)
          return; 
        h.d(this.a, true);
        h.d(this.a, 4);
      }
      
      public void c() {
        if (this.a.k == 1)
          return; 
        h.d(this.a, true);
        h.d(this.a, 4);
      }
    };
  
  private ag aa;
  
  private RectF ab = new RectF();
  
  private c ac;
  
  private com.qq.e.comm.plugin.ab.d.a ad;
  
  private b ae;
  
  private boolean af = true;
  
  private boolean ag = true;
  
  private int ah = n.a();
  
  private boolean ai = false;
  
  private boolean aj = false;
  
  private boolean ak = false;
  
  private ViewGroup al;
  
  private int am = -1;
  
  private g an;
  
  private int ao = 0;
  
  private String ap;
  
  private boolean aq = false;
  
  private boolean ar = false;
  
  private boolean as = false;
  
  private boolean at = false;
  
  private boolean au = false;
  
  private volatile boolean av = false;
  
  private long aw;
  
  private int ax;
  
  private i ay;
  
  private c az;
  
  ViewGroup b;
  
  JSONObject c;
  
  com.qq.e.comm.plugin.s.a d;
  
  boolean e = false;
  
  boolean f = false;
  
  j g;
  
  Context h;
  
  MediaView i;
  
  a j;
  
  int k = 1;
  
  FrameLayout l;
  
  Context m;
  
  c n = new c();
  
  protected int o;
  
  private String s;
  
  private String t;
  
  private m u;
  
  private final String v;
  
  private final e w;
  
  private ADListener x;
  
  private ADSize y;
  
  private int z;
  
  static {
    String str2 = p;
    String str1 = "1.1.0";
    if (m.a(str2, "1.1.0"))
      str1 = p; 
    q = str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<script src=\"");
    stringBuilder.append(String.format("http://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android03/js-release/%s/native.js", new Object[] { q }));
    stringBuilder.append("\"></script>\n");
    r = stringBuilder.toString();
  }
  
  public h(NEADI paramNEADI, Context paramContext, ViewGroup paramViewGroup, ADSize paramADSize, String paramString1, String paramString2, JSONObject paramJSONObject, HashMap<String, JSONObject> paramHashMap) {
    this.s = paramString1;
    this.t = paramString2;
    this.u = new m(paramString2, e.i, null);
    this.y = paramADSize;
    this.b = paramViewGroup;
    this.v = com.qq.e.comm.plugin.util.a.a(paramString1, paramString2, o.b());
    if (paramNEADI instanceof f) {
      this.G = (f)paramNEADI;
      this.w = this.G.d();
    } else {
      this.w = null;
    } 
    if (X())
      this.af = false; 
    this.C = paramHashMap;
    this.l = new FrameLayout(this, paramContext) {
        public boolean dispatchTouchEvent(MotionEvent param1MotionEvent) {
          h.a(this.a, param1MotionEvent);
          return super.dispatchTouchEvent(param1MotionEvent);
        }
      };
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    paramViewGroup.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
    this.al = paramViewGroup;
    if (this.al instanceof NativeExpressADView && SDKStatus.getSDKVersionCode() >= 120)
      ((NativeExpressADView)this.al).setViewBindStatusListener(new NativeExpressADView.ViewBindStatusListener(this) {
            public void onAttachedToWindow() {
              h.a(this.a);
            }
            
            public void onDetachedFromWindow() {
              h.b(this.a);
            }
            
            public void onFinishTemporaryDetach() {
              h.a(this.a);
            }
            
            public void onStartTemporaryDetach() {
              h.b(this.a);
            }
          }); 
    this.h = paramContext.getApplicationContext();
    this.m = paramContext;
    this.an = new g();
    a(this.h);
    a(paramJSONObject);
    s();
    if (((this.w == e.i && b.b()) || X()) && w())
      preloadVideo(); 
    p();
  }
  
  private void A() {
    if (this.c == null)
      return; 
    com.qq.e.comm.plugin.ad.a.a().a((View)this.l);
    a(5, new Object[] { this.b });
    this.an.a(System.currentTimeMillis());
    this.e = true;
    this.l.post(new Runnable(this) {
          public void run() {
            byte b1;
            String str2 = this.a.d.q();
            String str1 = str2;
            if (this.a.m())
              str1 = i.a(str2); 
            com.qq.e.comm.plugin.w.b b = new com.qq.e.comm.plugin.w.b(this.a.a(), e.i, this.a.b());
            String str3 = this.a.c.optString("customizedpingurl");
            boolean bool = this.a.m();
            byte b2 = 1;
            if (bool && bd.a()) {
              b1 = 1;
            } else {
              b1 = 0;
            } 
            if (this.a.d != null) {
              str2 = this.a.d.x();
            } else {
              str2 = null;
            } 
            g g = h.v(this.a);
            ViewGroup viewGroup = this.a.b;
            if (b1) {
              b1 = b2;
            } else {
              b1 = 2;
            } 
            str2 = g.a((View)viewGroup, b1, str2, null);
            c.a(h.t(this.a), (Boolean)null, this.a.n, 0, (Exception)null);
            i.a(str2, com.qq.e.comm.plugin.ad.a.a().b((View)this.a.l), this.a.d, b, str1, new d.b(this, str3) {
                  public void a() {
                    if (!m.a(this.a))
                      ah.a(this.a); 
                    c.a(h.t(this.b.a), Boolean.valueOf(true), this.b.a.n, 0, (Exception)null);
                  }
                  
                  public void a(int param2Int, Exception param2Exception) {
                    GDTLogger.e("GDT Native Express AD exposure error");
                    c.a(h.t(this.b.a), Boolean.valueOf(false), this.b.a.n, param2Int, param2Exception);
                  }
                });
          }
        });
    this.d.V();
    this.d.W();
  }
  
  private void B() {
    d(false);
    if (this.I == null)
      this.I = new com.qq.e.comm.plugin.ac.a(this.b.getContext()); 
    if (this.i == null)
      return; 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(this.h, 46), am.a(this.h, 46));
    layoutParams.gravity = 17;
    this.i.addView((View)this.I, (ViewGroup.LayoutParams)layoutParams);
    this.i.setBackgroundColor(Color.parseColor("#40000000"));
  }
  
  private void C() {
    if (!this.aq) {
      MediaView mediaView = this.i;
      if (mediaView != null && mediaView.getLayoutParams() != null) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.i.getLayoutParams();
        layoutParams.width = am.a(this.h, (int)(this.ab.right - this.ab.left));
        layoutParams.height = am.a(this.h, (int)(this.ab.bottom - this.ab.top));
        layoutParams.leftMargin = am.a(this.h, (int)this.ab.left);
        layoutParams.topMargin = am.a(this.h, (int)this.ab.top);
        this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
    } 
  }
  
  private void D() {
    if (this.J == null)
      this.J = new az(this, Long.MAX_VALUE, 200L) {
          public void a() {}
          
          public void a(long param1Long) {
            h.e(this.a);
          }
        }; 
    this.J.b();
  }
  
  private void E() {
    az az1 = this.J;
    if (az1 != null)
      az1.d(); 
  }
  
  private void F() {
    az az1 = this.J;
    if (az1 != null)
      az1.e(); 
  }
  
  private void G() {
    az az1 = this.J;
    if (az1 != null)
      az1.c(); 
  }
  
  private void H() {
    a a1 = this.j;
    if (a1 != null && !a1.c()) {
      this.j.setVisibility(0);
      com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.i);
      this.j.b();
      this.M = 0;
    } 
  }
  
  private void I() {
    MediaView mediaView = this.i;
    if (mediaView == null) {
      GDTLogger.w("NativeExpressAD Error: MediaView is not init", null);
      return;
    } 
    mediaView.getGlobalVisibleRect(this.P);
    this.Q = this.i.getWidth();
    this.R = this.i.getHeight();
    Activity activity = bd.a(this.b.getContext());
    if (activity == null) {
      GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
      return;
    } 
    this.U = (FrameLayout.LayoutParams)this.i.getLayoutParams();
    this.Y = activity.getWindow().getCallback();
    this.T = activity.getRequestedOrientation();
  }
  
  private void J() {
    Activity activity = bd.a(this.b.getContext());
    if (activity == null) {
      GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
      return;
    } 
    if (this.Z == null)
      this.Z = new d(this, (Window.Callback)activity) {
          private boolean c = false;
          
          public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) {
            if (param1KeyEvent.getAction() == 0 && param1KeyEvent.getKeyCode() == 4 && param1KeyEvent.getRepeatCount() == 0)
              this.c = true; 
            if (param1KeyEvent.getAction() == 1 && param1KeyEvent.getKeyCode() == 4 && this.c && param1KeyEvent.getRepeatCount() == 0) {
              this.b.l();
              this.c = false;
            } 
            return false;
          }
        }; 
    if (this.X == null) {
      this.X = new FrameLayout.LayoutParams(0, 0);
      this.X.setMargins(0, 0, 0, 0);
      FrameLayout.LayoutParams layoutParams = this.X;
      layoutParams.gravity = 48;
      layoutParams.width = Math.min(am.b(this.h), am.c(this.h));
      layoutParams = this.X;
      layoutParams.height = (int)(layoutParams.width * 0.5625F);
    } 
    if (this.W == null)
      this.W = new FrameLayout.LayoutParams(-1, -1); 
  }
  
  private void K() {
    c c1 = this.ac;
    if (c1 != null && this.i != null && c1.getParent() == null) {
      int k = this.N;
      if (k == 3 || k == 5) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.i.addView((View)this.ac, (ViewGroup.LayoutParams)layoutParams);
        this.ac.d();
      } 
    } 
  }
  
  private void L() {
    b b1 = this.ae;
    if (b1 != null) {
      FrameLayout frameLayout = this.S;
      if (frameLayout != null)
        frameLayout.removeView((View)b1); 
    } 
    com.qq.e.comm.plugin.ab.d.a a1 = this.ad;
    if (a1 != null) {
      FrameLayout frameLayout = this.S;
      if (frameLayout != null)
        frameLayout.removeView(a1.b()); 
    } 
    c c1 = this.ac;
    if (c1 != null && this.i != null && this.N != 3 && c1.getParent() != null)
      this.i.removeView((View)this.ac); 
  }
  
  private void M() {
    c c1 = this.ac;
    if (c1 != null && this.i != null && this.N == 3 && c1.getParent() != null)
      this.i.removeView((View)this.ac); 
  }
  
  private void N() {
    Activity activity = bd.a(this.b.getContext());
    if (activity == null) {
      GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
      return;
    } 
    if (this.aa == null) {
      this.aa = new ag(activity);
      this.aa.a(this.aB);
    } 
    this.aa.a(true);
  }
  
  private void O() {
    ag ag1 = this.aa;
    if (ag1 != null)
      ag1.a(false); 
  }
  
  private void P() {
    this.ar = true;
    if (this.as)
      return; 
    if (this.k != 1) {
      if (d.a(this.c) && !d.b(this.c))
        f.a(new d.a(this.c, null)); 
      Activity activity = bd.a(this.b.getContext());
      if (activity == null) {
        GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
        return;
      } 
      this.aq = false;
      com.qq.e.comm.plugin.aa.b.a.b((ViewGroup)this.i);
      O();
      L();
      activity.getWindow().setCallback(this.Y);
      ViewGroup viewGroup = (ViewGroup)activity.findViewById(16908290);
      if (viewGroup != null) {
        if (Build.VERSION.SDK_INT >= 21 && this.af) {
          ChangeBounds changeBounds = new ChangeBounds();
          changeBounds.setDuration(200L);
          TransitionManager.beginDelayedTransition(viewGroup, (Transition)changeBounds);
          MediaView mediaView = this.i;
          if (mediaView != null)
            mediaView.setLayoutParams((ViewGroup.LayoutParams)this.V); 
          y.a(new Runnable(this, viewGroup, activity) {
                public void run() {
                  h.d(this.c);
                  if (this.c.i != null && h.i(this.c) != null) {
                    this.a.removeView((View)this.c.i);
                    this.c.l.addView((View)this.c.i, (ViewGroup.LayoutParams)h.D(this.c));
                    bd.a((Context)this.b, h.E(this.c));
                    this.a.removeView((View)h.i(this.c));
                    h.F(this.c);
                  } 
                  h h1 = this.c;
                  h.a(h1, 19, new Object[] { h1.b });
                  h.h(this.c);
                  h.e(this.c, false);
                }
              }500L);
        } else {
          E();
          MediaView mediaView = this.i;
          if (mediaView != null) {
            viewGroup.removeView((View)mediaView);
            this.l.addView((View)this.i, (ViewGroup.LayoutParams)this.U);
          } 
          bd.a((Context)activity, this.ao);
          viewGroup.removeView((View)this.S);
          M();
          b(19, new Object[] { this.b });
          F();
          this.ar = false;
        } 
        try {
          activity.setRequestedOrientation(this.T);
        } catch (IllegalStateException illegalStateException) {
          GDTLogger.e("setRequestedOrientation exception", illegalStateException);
        } 
        Q();
        this.k = 1;
        a(10, new Object[] { this.b });
      } 
    } 
  }
  
  private void Q() {
    a a1 = this.j;
    if (a1 == null)
      return; 
    if (this.ag) {
      a1.h();
      return;
    } 
    a1.i();
  }
  
  private void R() {
    // Byte code:
    //   0: aload_0
    //   1: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   4: ifnull -> 281
    //   7: aload_0
    //   8: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield h : Landroid/content/Context;
    //   21: aload_2
    //   22: bipush #50
    //   24: aload_0
    //   25: invokespecial X : ()Z
    //   28: invokestatic a : (Landroid/content/Context;Landroid/view/View;IZ)Z
    //   31: ifne -> 74
    //   34: aload_0
    //   35: getfield N : I
    //   38: iconst_1
    //   39: if_icmpne -> 68
    //   42: invokestatic getSDKVersionCode : ()I
    //   45: bipush #11
    //   47: if_icmplt -> 61
    //   50: aload_0
    //   51: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   54: iconst_0
    //   55: invokevirtual a : (Z)V
    //   58: goto -> 68
    //   61: aload_0
    //   62: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   65: invokevirtual j : ()V
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield aj : Z
    //   73: return
    //   74: aload_0
    //   75: getfield N : I
    //   78: istore_1
    //   79: iload_1
    //   80: ifeq -> 210
    //   83: iload_1
    //   84: iconst_3
    //   85: if_icmpeq -> 183
    //   88: iload_1
    //   89: iconst_4
    //   90: if_icmpeq -> 162
    //   93: iload_1
    //   94: iconst_5
    //   95: if_icmpeq -> 142
    //   98: iload_1
    //   99: bipush #6
    //   101: if_icmpeq -> 107
    //   104: goto -> 258
    //   107: aload_0
    //   108: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   111: invokevirtual c : ()Z
    //   114: ifne -> 258
    //   117: aload_0
    //   118: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   121: iconst_0
    //   122: invokevirtual setVisibility : (I)V
    //   125: aload_0
    //   126: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   129: invokestatic a : (Landroid/view/ViewGroup;)V
    //   132: aload_0
    //   133: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   136: invokevirtual b : ()V
    //   139: goto -> 258
    //   142: aload_0
    //   143: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   146: invokevirtual c : ()Z
    //   149: ifne -> 258
    //   152: aload_0
    //   153: invokespecial w : ()Z
    //   156: ifeq -> 258
    //   159: goto -> 227
    //   162: aload_0
    //   163: getfield k : I
    //   166: iconst_1
    //   167: if_icmpne -> 258
    //   170: aload_0
    //   171: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   174: invokevirtual c : ()Z
    //   177: ifne -> 258
    //   180: goto -> 117
    //   183: aload_0
    //   184: getfield aj : Z
    //   187: ifne -> 258
    //   190: aload_0
    //   191: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   194: invokevirtual c : ()Z
    //   197: ifne -> 258
    //   200: aload_0
    //   201: invokespecial w : ()Z
    //   204: ifeq -> 258
    //   207: goto -> 227
    //   210: aload_0
    //   211: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   214: invokevirtual c : ()Z
    //   217: ifne -> 258
    //   220: aload_0
    //   221: invokespecial w : ()Z
    //   224: ifeq -> 258
    //   227: aload_0
    //   228: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   231: iconst_0
    //   232: invokevirtual setVisibility : (I)V
    //   235: aload_0
    //   236: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   239: invokestatic a : (Landroid/view/ViewGroup;)V
    //   242: aload_0
    //   243: getfield j : Lcom/qq/e/comm/plugin/gdtnativead/h$a;
    //   246: invokevirtual b : ()V
    //   249: aload_0
    //   250: invokespecial y : ()V
    //   253: aload_0
    //   254: iconst_1
    //   255: putfield M : I
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield aj : Z
    //   263: aload_0
    //   264: getfield e : Z
    //   267: ifne -> 281
    //   270: aload_0
    //   271: getfield w : Lcom/qq/e/comm/plugin/ad/e;
    //   274: aload_0
    //   275: getfield n : Lcom/qq/e/comm/plugin/y/c;
    //   278: invokestatic b : (Lcom/qq/e/comm/plugin/ad/e;Lcom/qq/e/comm/plugin/y/c;)V
    //   281: return
  }
  
  private void S() {
    if (bf.a(this.h, (View)this.b, 50) && !this.e) {
      if (this.b.getHeight() <= 1)
        return; 
      A();
      if (!m())
        c.a(this.w, this.n); 
    } 
  }
  
  private void T() {
    boolean bool = m();
    S();
    if (bool)
      R(); 
  }
  
  private void U() {
    boolean bool1;
    boolean bool2;
    com.qq.e.comm.plugin.w.b b1 = new com.qq.e.comm.plugin.w.b(this.v, e.i, this.t);
    if (this.L == 0) {
      bool1 = V();
    } else {
      bool1 = false;
    } 
    if (this.L == 0) {
      bool2 = W();
    } else {
      bool2 = false;
    } 
    String str1 = this.c.optString("apurl");
    String str2 = this.c.optString("customizedpingurl");
    d.a(this.M, this.k, this.K, this.L, bool1, bool2, str1, b1, new d.b(this, str2) {
          public void a() {
            GDTLogger.d("GDTNativeExpressAD report video info success");
            if (!StringUtil.isEmpty(this.a))
              ah.a(this.a); 
          }
          
          public void a(int param1Int, Exception param1Exception) {
            GDTLogger.e("GDTNativeExpressAD report video info error");
          }
        });
  }
  
  private int V() {
    a a1 = this.j;
    return (a1 != null) ? a1.f() : 0;
  }
  
  private int W() {
    return this.O;
  }
  
  private boolean X() {
    return (this.w == e.n);
  }
  
  private static n a(HashMap<String, JSONObject> paramHashMap) {
    JSONObject jSONObject = paramHashMap.get("adinfo");
    n n = null;
    if (jSONObject != null) {
      Object object = jSONObject.opt("adinfo");
    } else {
      jSONObject = null;
    } 
    if (jSONObject instanceof n)
      n = (n)jSONObject; 
    return n;
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2) {
    if (this.ad == null) {
      this.ad = (new e(this.b.getContext(), this.c)).a();
      this.ad.a(this);
    } 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.topMargin = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      this.ad.b().setAlpha(0.0F);
      ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.ad.b(), "alpha", new float[] { 0.0F, 1.0F });
      objectAnimator.setDuration(500L);
      objectAnimator.setStartDelay(700L);
      objectAnimator.start();
    } 
    if (this.ad.b().getParent() != null)
      be.a(this.ad.b()); 
    FrameLayout frameLayout = this.S;
    if (frameLayout != null)
      frameLayout.addView(this.ad.b(), (ViewGroup.LayoutParams)layoutParams); 
    if (paramString1 != null) {
      if (!paramBoolean2 && paramBoolean1) {
        String str = com.qq.e.comm.plugin.w.a.h.a(paramString1);
        paramString2 = null;
        JSONObject jSONObject = this.c;
        if (jSONObject != null)
          paramString2 = d.d(jSONObject).d(); 
        d.a(str, this.d, new j<Pair<Integer, JSONObject>>(this, paramString2, paramString1) {
              public void a(Pair<Integer, JSONObject> param1Pair) {
                if (param1Pair != null && param1Pair.second != null) {
                  String str2 = ((JSONObject)param1Pair.second).optString("clickid");
                  com.qq.e.comm.plugin.w.a.a(str2);
                  com.qq.e.comm.plugin.w.a.a(this.a, str2);
                  String str1 = ((JSONObject)param1Pair.second).optString("dstlink");
                  if (!TextUtils.isEmpty(str1)) {
                    y.a(new Runnable(this, str1) {
                          public void run() {
                            if (h.C(this.b.c) != null)
                              h.C(this.b.c).a(this.a); 
                          }
                        });
                    return;
                  } 
                } 
                y.a(new Runnable(this) {
                      public void run() {
                        if (h.C(this.a.c) != null)
                          h.C(this.a.c).a(this.a.b); 
                      }
                    });
              }
            });
        this.ay.a(str);
        return;
      } 
      if (!paramBoolean2) {
        com.qq.e.comm.plugin.s.a a1 = this.d;
        if (a1 != null) {
          a1.X();
          this.d.Y();
        } 
      } 
      if (!paramBoolean2)
        paramString2 = paramString1; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get url: ");
      stringBuilder.append(paramString2);
      ak.a("gdt_tag_net", stringBuilder.toString());
      this.ad.a(paramString2);
      if (!paramBoolean2)
        this.ay.a(paramString1); 
    } 
  }
  
  private void a(Context paramContext) {
    this.a = (new e(paramContext, this)).a(true).a(this).b(true).c(false).d(false).a(this).a();
  }
  
  private void a(MotionEvent paramMotionEvent) {
    this.an.a((View)this.l, paramMotionEvent, false);
  }
  
  private void a(ADSize paramADSize) {
    int n = paramADSize.getWidth();
    int k = -1;
    if (n <= 0 && paramADSize.getWidth() != -1)
      GDTLogger.w("NativeExpressAD的宽度必须大于0或者为ADSize.FULL_WIDTH，已将广告宽度调整为ADSize.FULL_WIDTH", null); 
    if (paramADSize.getHeight() <= 0 && paramADSize.getHeight() != -2)
      GDTLogger.w("NativeExpressAD的高度必须大于0或者为ADSize.AUTO_HEIGHT，已经广告高度调整为ADSize.AUTO_HEIGHT", null); 
    if (paramADSize.getWidth() > 0)
      k = am.a(this.h, paramADSize.getWidth()); 
    this.z = k;
    if (paramADSize.getHeight() <= 0) {
      k = 1;
    } else {
      k = am.a(this.h, paramADSize.getHeight());
    } 
    this.A = k;
    k = am.b(this.h);
    n = am.c(this.h);
    if (this.z > k)
      this.z = k; 
    if (this.A > n)
      this.A = n; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ExpressADView's width in pixel = ");
    stringBuilder.append(this.z);
    stringBuilder.append(", height in pixel = ");
    stringBuilder.append(this.A);
    GDTLogger.d(stringBuilder.toString());
  }
  
  private void a(JSONObject paramJSONObject) {
    int k = SDKStatus.getSDKVersionCode();
    n n = null;
    JSONObject jSONObject2 = null;
    if (k >= 3) {
      n = a(this.C);
      if (n != null) {
        try {
          String str = n.getProperty("ad_info");
          if (str != null)
            jSONObject2 = new JSONObject(str); 
        } catch (JSONException jSONException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("load ad data failed: ");
          stringBuilder.append(jSONException);
          GDTLogger.e(stringBuilder.toString());
        } 
      } else {
        n = null;
        if (n != null)
          jSONObject2 = new JSONObject((String)n); 
      } 
    } else {
      String str;
      this.c = this.C.get("adinfo");
      jSONObject2 = this.c;
      if (jSONObject2 != null)
        str = jSONObject2.optString("video"); 
      this.B = str;
    } 
    this.d = new com.qq.e.comm.plugin.s.a(this.s, this.t, this.v, e.i);
    this.d.g(this.c);
    this.n.a(this.t);
    JSONObject jSONObject1 = this.c;
    if (jSONObject1 != null) {
      this.n.b(jSONObject1.optString("cl"));
      this.n.b(this.c.optString("traceid"));
    } 
    if (paramJSONObject != null)
      this.D = paramJSONObject.optString("view"); 
    if (m() && bd.a())
      v(); 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    com.qq.e.comm.plugin.aa.a.b b1 = (new com.qq.e.comm.plugin.aa.a.b.a()).b(this.B).a(aj.a(this.B)).a(aj.f()).a();
    com.qq.e.comm.plugin.aa.a.a.a().a(b1, this.B, new com.qq.e.comm.plugin.j.a(this, paramBoolean1, paramBoolean2) {
          public void a() {
            GDTLogger.d("onStarted");
            h.a(this.c, true);
            h h1 = this.c;
            h.a(h1, 12, new Object[] { h1.b });
          }
          
          public void a(long param1Long1, long param1Long2, int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("downloading video ---> Progress: ");
            stringBuilder.append(param1Int);
            stringBuilder.append("%");
            GDTLogger.d(stringBuilder.toString());
            y.a(new Runnable(this, param1Int) {
                  public void run() {
                    if (h.o(this.b.c) != null) {
                      h.o(this.b.c).a(this.a);
                      if (this.a == 100) {
                        h.o(this.b.c).setVisibility(8);
                        if (this.b.c.i != null)
                          this.b.c.i.setBackgroundColor(0); 
                        h.b(this.b.c, true);
                      } 
                    } 
                  }
                });
          }
          
          public void a(long param1Long, boolean param1Boolean) {
            h.a(this.c, (int)(param1Long >> 10L));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onConnected isRangeSupport: ");
            stringBuilder.append(param1Boolean);
            stringBuilder.append(", total: ");
            stringBuilder.append(param1Long);
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void a(c param1c) {
            int i = param1c.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Video download Failed, code: ");
            stringBuilder.append(i);
            stringBuilder.append(", msg: ");
            stringBuilder.append(param1c.b());
            GDTLogger.w(stringBuilder.toString(), null);
            h.a(this.c, false);
            h.b(this.c, 2);
            h.u(this.c);
            if (this.b) {
              h h1 = this.c;
              h.a(h1, 17, new Object[] { h1.b, Integer.valueOf(702) });
            } else {
              h h1 = this.c;
              h.a(h1, 17, new Object[] { h1.b, Integer.valueOf(700) });
            } 
            c.a(h.t(this.c), this.c.n, h.r(this.c), i, (Exception)param1c);
          }
          
          public void a(File param1File, long param1Long) {
            GDTLogger.d("onCompleted");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("download time: ");
            stringBuilder.append(param1Long);
            stringBuilder.append("ms");
            GDTLogger.d(stringBuilder.toString());
            h.a(this.c, false);
            h.b(this.c, true);
            y.a(new Runnable(this) {
                  public void run() {
                    h.b(this.a.c, 0);
                    if (h.p(this.a.c))
                      if (h.q(this.a.c)) {
                        h.l(this.a.c).e();
                      } else {
                        h.a(this.a.c, 21, new Object[] { this.a.c.b });
                      }  
                    File file = aj.d(h.r(this.a.c));
                    if (this.a.c.j != null && file != null) {
                      h.a(this.a.c, System.currentTimeMillis());
                      this.a.c.j.a(file.getAbsolutePath());
                      this.a.c.j.b();
                      h.g(this.a.c);
                      if (this.a.a) {
                        h.c(this.a.c, 1);
                        return;
                      } 
                      h.c(this.a.c, 0);
                    } 
                  }
                });
            bc.a(param1Long, h.s(this.c), h.r(this.c), this.c.n);
          }
          
          public void b() {}
          
          public void c() {
            c.a(h.t(this.c), this.c.n, h.r(this.c), 0, (Exception)null);
          }
        });
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    if (this.ar)
      return; 
    if (this.k == 1) {
      a(20, new Object[] { this.b });
      if (this.i == null)
        f(false); 
      this.aq = true;
      this.i.setVisibility(0);
      this.i.post(new Runnable(this, paramBoolean1, paramBoolean2, paramString) {
            public void run() {
              h.b(this.d, this.a, this.b, this.c);
            }
          });
    } 
  }
  
  private void b(int paramInt) {
    ADSize aDSize = new ADSize(this.y.getWidth(), paramInt);
    ViewGroup.LayoutParams layoutParams = this.a.a().getLayoutParams();
    if (layoutParams == null)
      return; 
    a(aDSize);
    paramInt = layoutParams.height;
    int k = this.A;
    if (paramInt != k) {
      layoutParams.height = k;
      this.a.a().setLayoutParams(layoutParams);
    } 
  }
  
  private void b(int paramInt, Object[] paramArrayOfObject) {
    y.a(new Runnable(this, paramInt, paramArrayOfObject) {
          public void run() {
            if (h.m(this.c) != null)
              h.m(this.c).onADEvent(new ADEvent(this.a, this.b)); 
          }
        });
  }
  
  private void b(com.qq.e.comm.plugin.ab.a.a parama) {
    if (this.F != null)
      return; 
    this.F = Boolean.valueOf(false);
    this.a.a(8);
    a(3, new Object[] { this.b });
    c.a(this.w, this.F, this.n, parama);
  }
  
  private void b(JSONObject paramJSONObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Get AdSpecMeasured params：");
    stringBuilder.append(paramJSONObject.toString());
    stringBuilder.append(", adContentHeightInDp: ");
    stringBuilder.append(this.H);
    stringBuilder.append(", view is ");
    stringBuilder.append(this.a.a().hashCode());
    GDTLogger.d(stringBuilder.toString());
    u.a(50002, 2, this.n, new d(paramJSONObject));
    this.H = paramJSONObject.optInt("contentHeight");
    if (this.y.getHeight() <= 0) {
      u.a(50022, this.H, this.n);
      b(this.H);
    } 
    if (m()) {
      if (!bd.a())
        return; 
      this.ab.left = paramJSONObject.optInt("imgHolderLeft");
      this.ab.top = paramJSONObject.optInt("imgHolderTop");
      this.ab.right = (paramJSONObject.optInt("imgHolderRight") + 1);
      this.ab.bottom = (paramJSONObject.optInt("imgHolderBottom") + 1);
      if (this.i != null) {
        C();
        return;
      } 
      if (w())
        f(true); 
    } 
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    boolean bool;
    this.as = true;
    Activity activity = bd.a(this.b.getContext());
    if (activity == null) {
      GDTLogger.e("Native Express AD constructor must have an Activity Context, or video ad will not be able to enter fullscreen!");
      return;
    } 
    u.a(100372, 0, this.n);
    I();
    J();
    E();
    if (am.b(this.h) > am.c(this.h)) {
      bool = true;
    } else {
      bool = false;
    } 
    ViewGroup viewGroup = (ViewGroup)activity.findViewById(16908290);
    if (viewGroup != null) {
      byte b1;
      if (this.S == null) {
        this.S = new FrameLayout(this.b.getContext());
        this.S.setBackgroundColor(-16777216);
      } 
      be.a((View)this.S);
      viewGroup.addView((View)this.S, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      this.ao = bd.c((Context)activity);
      bd.b((Context)activity);
      this.l.removeView((View)this.i);
      if (Build.VERSION.SDK_INT >= 21 && this.af) {
        if (this.V == null)
          this.V = new FrameLayout.LayoutParams(this.Q, this.R); 
        FrameLayout.LayoutParams layoutParams = this.V;
        layoutParams.width = this.Q;
        layoutParams.height = this.R;
        layoutParams.setMargins(this.P.left, this.P.top, 0, 0);
        be.a((View)this.i);
        viewGroup.addView((View)this.i, (ViewGroup.LayoutParams)this.V);
        com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.i, this.d.o(), this.j);
        y.a(new Runnable(this, viewGroup, bool, activity, paramBoolean1, paramBoolean2, paramString) {
              public void run() {
                h.w(this.g);
                TransitionManager.beginDelayedTransition(this.a);
                if (this.g.i != null) {
                  FrameLayout.LayoutParams layoutParams;
                  MediaView mediaView = this.g.i;
                  if (this.b) {
                    layoutParams = h.x(this.g);
                  } else {
                    layoutParams = h.y(this.g);
                  } 
                  mediaView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                } 
                this.c.getWindow().setCallback(h.z(this.g));
                h.c(this.g, this.d, this.e, this.f);
                h.A(this.g);
                h.B(this.g);
                h.h(this.g);
                if (h.o(this.g) != null && h.o(this.g).getVisibility() == 0)
                  h.o(this.g).bringToFront(); 
                h h1 = this.g;
                h.a(h1, 18, new Object[] { h1.b });
                h.c(this.g, false);
              }
            }500L);
      } else {
        FrameLayout.LayoutParams layoutParams;
        K();
        be.a((View)this.i);
        MediaView mediaView = this.i;
        if (bool) {
          layoutParams = this.W;
        } else {
          layoutParams = this.X;
        } 
        viewGroup.addView((View)mediaView, (ViewGroup.LayoutParams)layoutParams);
        com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.i, this.d.o(), this.j);
        activity.getWindow().setCallback(this.Z);
        c(paramBoolean1, paramBoolean2, paramString);
        N();
        H();
        F();
        com.qq.e.comm.plugin.ac.a a2 = this.I;
        if (a2 != null && a2.getVisibility() == 0)
          this.I.bringToFront(); 
        b(18, new Object[] { this.b });
        this.as = false;
      } 
      a a1 = this.j;
      if (a1 != null)
        if (this.ai) {
          a1.h();
        } else {
          a1.i();
        }  
      if (bool) {
        b1 = 4;
      } else {
        b1 = 3;
      } 
      d(b1);
      a(9, new Object[] { this.b });
    } 
  }
  
  private void c(int paramInt) {
    b b1 = this.ae;
    if (b1 == null) {
      this.ae = new b(this.b.getContext(), this.g, this.c);
      this.ae.a(this);
    } else {
      be.a((View)b1);
    } 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.topMargin = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      this.ae.setAlpha(0.0F);
      ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.ae, "alpha", new float[] { 0.0F, 1.0F });
      objectAnimator.setDuration(500L);
      objectAnimator.setStartDelay(700L);
      objectAnimator.start();
    } 
    FrameLayout frameLayout = this.S;
    if (frameLayout != null)
      frameLayout.addView((View)this.ae, (ViewGroup.LayoutParams)layoutParams); 
    j j1 = this.g;
    if (j1 != null && com.qq.e.comm.plugin.a.e.b.a(j1.h(), this.t))
      c(true); 
  }
  
  private void c(JSONObject paramJSONObject) {
    if (this.F != null)
      return; 
    u.a(50002, 1, this.n);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("renderSuccess view: ");
    stringBuilder.append(this.a.hashCode());
    GDTLogger.d(stringBuilder.toString());
    this.F = Boolean.valueOf(true);
    a(this.y);
    this.l.addView(this.a.a(), new ViewGroup.LayoutParams(this.z, this.A));
    a(4, new Object[] { this.b });
    e(paramJSONObject.optString("traceid"));
    u();
    c.a(this.w, this.F, this.n, (com.qq.e.comm.plugin.ab.a.a)null);
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   4: ifnull -> 57
    //   7: aload_0
    //   8: getfield ac : Lcom/qq/e/comm/plugin/gdtnativead/a/c;
    //   11: astore #6
    //   13: aload #6
    //   15: ifnull -> 57
    //   18: aload #6
    //   20: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   23: ifnonnull -> 57
    //   26: new android/widget/FrameLayout$LayoutParams
    //   29: dup
    //   30: iconst_m1
    //   31: iconst_m1
    //   32: invokespecial <init> : (II)V
    //   35: astore #6
    //   37: aload_0
    //   38: getfield i : Lcom/qq/e/ads/nativ/MediaView;
    //   41: aload_0
    //   42: getfield ac : Lcom/qq/e/comm/plugin/gdtnativead/a/c;
    //   45: aload #6
    //   47: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   50: aload_0
    //   51: getfield ac : Lcom/qq/e/comm/plugin/gdtnativead/a/c;
    //   54: invokevirtual c : ()V
    //   57: aload_0
    //   58: getfield c : Lorg/json/JSONObject;
    //   61: ifnonnull -> 71
    //   64: ldc_w '广告数据出现错误！'
    //   67: invokestatic e : (Ljava/lang/String;)V
    //   70: return
    //   71: aload_0
    //   72: getfield h : Landroid/content/Context;
    //   75: invokestatic b : (Landroid/content/Context;)I
    //   78: aload_0
    //   79: getfield h : Landroid/content/Context;
    //   82: invokestatic c : (Landroid/content/Context;)I
    //   85: invokestatic min : (II)I
    //   88: i2f
    //   89: ldc_w 0.5625
    //   92: fmul
    //   93: f2i
    //   94: istore #4
    //   96: aload_0
    //   97: getfield c : Lorg/json/JSONObject;
    //   100: invokestatic a : (Lorg/json/JSONObject;)Z
    //   103: istore #5
    //   105: aconst_null
    //   106: astore #6
    //   108: iload #5
    //   110: ifeq -> 213
    //   113: aload_0
    //   114: getfield c : Lorg/json/JSONObject;
    //   117: invokestatic b : (Lorg/json/JSONObject;)Z
    //   120: ifeq -> 206
    //   123: aconst_null
    //   124: aload_0
    //   125: getfield c : Lorg/json/JSONObject;
    //   128: aload_0
    //   129: invokevirtual o : ()Ljava/lang/String;
    //   132: invokestatic a : ()Lcom/qq/e/comm/plugin/ad/a;
    //   135: aload_0
    //   136: getfield l : Landroid/widget/FrameLayout;
    //   139: invokevirtual b : (Landroid/view/View;)I
    //   142: invokestatic a : (Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)Ljava/lang/String;
    //   145: astore #7
    //   147: aload_0
    //   148: getfield g : Lcom/qq/e/comm/plugin/ad/j;
    //   151: astore #8
    //   153: aload #7
    //   155: astore #6
    //   157: aload #8
    //   159: ifnull -> 194
    //   162: aload #7
    //   164: astore #6
    //   166: aload #8
    //   168: invokevirtual h : ()I
    //   171: aload_0
    //   172: getfield t : Ljava/lang/String;
    //   175: invokestatic a : (ILjava/lang/String;)Z
    //   178: ifeq -> 194
    //   181: aload #7
    //   183: ldc_w '_autodownload'
    //   186: ldc_w '1'
    //   189: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore #6
    //   194: aload_0
    //   195: iload #4
    //   197: aload #6
    //   199: iload_1
    //   200: iload_2
    //   201: aload_3
    //   202: invokespecial a : (ILjava/lang/String;ZZLjava/lang/String;)V
    //   205: return
    //   206: aload_0
    //   207: iload #4
    //   209: invokespecial c : (I)V
    //   212: return
    //   213: aload_0
    //   214: getfield c : Lorg/json/JSONObject;
    //   217: astore #7
    //   219: aload #7
    //   221: ifnull -> 234
    //   224: aload #7
    //   226: ldc_w 'rl'
    //   229: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   232: astore #6
    //   234: aload #6
    //   236: astore #7
    //   238: aload #6
    //   240: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   243: ifne -> 362
    //   246: aload_0
    //   247: invokevirtual o : ()Ljava/lang/String;
    //   250: astore #8
    //   252: new java/lang/StringBuilder
    //   255: dup
    //   256: aload #6
    //   258: invokespecial <init> : (Ljava/lang/String;)V
    //   261: astore #6
    //   263: aload #6
    //   265: bipush #38
    //   267: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #6
    //   273: ldc_w 's'
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload #6
    //   282: ldc_w '='
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload #6
    //   291: aload #8
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #6
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: astore #6
    //   304: aload #6
    //   306: astore #7
    //   308: aload #6
    //   310: invokestatic a : (Ljava/lang/String;)Z
    //   313: ifeq -> 362
    //   316: ldc_w 'gdt_tag_p'
    //   319: ldc_w 'get P in addFullscreenViews , url = %s'
    //   322: iconst_1
    //   323: anewarray java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: aload #6
    //   330: aastore
    //   331: invokestatic b : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: aload #6
    //   336: aload #8
    //   338: invokestatic a : ()Lcom/qq/e/comm/plugin/ad/a;
    //   341: aload_0
    //   342: getfield l : Landroid/widget/FrameLayout;
    //   345: invokevirtual b : (Landroid/view/View;)I
    //   348: ldc_w 'click'
    //   351: invokestatic a : (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   354: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   357: astore #6
    //   359: goto -> 194
    //   362: aload #7
    //   364: astore #6
    //   366: goto -> 194
  }
  
  private void d(int paramInt) {
    this.k = paramInt;
    c c1 = this.ac;
    if (c1 != null) {
      c1.a(paramInt);
      this.ac.f();
      this.ac.g();
    } 
    if (m()) {
      if (paramInt != 3 && paramInt != 4)
        return; 
      if (paramInt == 3) {
        paramInt = 0;
      } else {
        paramInt = 8;
      } 
      b b1 = this.ae;
      if (b1 != null) {
        b1.setVisibility(paramInt);
        return;
      } 
      com.qq.e.comm.plugin.ab.d.a a1 = this.ad;
      if (a1 != null)
        a1.b().setVisibility(paramInt); 
    } 
  }
  
  private void d(JSONObject paramJSONObject) {
    this.an.b(System.currentTimeMillis());
    this.ay.a(paramJSONObject);
  }
  
  private void d(boolean paramBoolean) {
    y.a(new Runnable(this, paramBoolean) {
          public void run() {
            h h1;
            String str;
            if (this.b.a == null)
              return; 
            if (this.a) {
              this.b.a.a(0);
              h1 = this.b.a;
              str = "mtaid.setPlayIconVisibility(true)";
            } else {
              h1 = this.b.a;
              str = "mtaid.setPlayIconVisibility(false)";
            } 
            h1.b(str);
          }
        });
  }
  
  private void e(String paramString) {
    if (m.a(paramString))
      return; 
    if (d.a(this.c)) {
      this.g = d.d(this.c);
      l.a().a(this.g.d(), this);
      c c1 = d(this.g.d());
      if (c1 != null && c1.o() == 32 && c1.b("progress") > 0) {
        this.g.a(c1.b("progress"));
        this.g.c(c1.o());
      } 
    } 
  }
  
  private void e(boolean paramBoolean) {
    if (t()) {
      File file = aj.d(this.B);
      this.aw = System.currentTimeMillis();
      if (file != null)
        this.j.a(file.getAbsolutePath()); 
      com.qq.e.comm.plugin.ac.a a1 = this.I;
      if (a1 != null)
        a1.setVisibility(8); 
      MediaView mediaView = this.i;
      if (mediaView != null) {
        mediaView.setBackgroundColor(0);
        return;
      } 
    } else {
      B();
      a(paramBoolean, false);
    } 
  }
  
  private void f(boolean paramBoolean) {
    if (this.i == null) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(this.h, (int)(this.ab.right - this.ab.left)), am.a(this.h, (int)(this.ab.bottom - this.ab.top)));
      layoutParams.leftMargin = am.a(this.h, (int)this.ab.left);
      layoutParams.topMargin = am.a(this.h, (int)this.ab.top);
      this.i = new MediaView(this.b.getContext());
      this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.l.addView((View)this.i);
      layoutParams = new FrameLayout.LayoutParams(-1, -1);
      layoutParams.gravity = 17;
      this.j = new a(this, this.b.getContext());
      this.j.setKeepScreenOn(true);
      this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (X())
        this.j.a(this.c.optInt("pic_width"), this.c.optInt("pic_height")); 
      this.i.addView((View)this.j);
      this.i.setOnClickListener(this);
      this.ac = new c(this.b.getContext(), this.k, this.c.optString("img"));
      this.ac.a((d.a)this);
      this.j.a((com.qq.e.comm.plugin.aa.b.b)this.ac);
      if (SDKStatus.getSDKVersionCode() >= 3) {
        n n = a(this.C);
        if (n != null)
          n.a(new b(this.j)); 
      } 
      b(11, new Object[] { this.b });
      if (this.av && X())
        b(12, new Object[] { this.b }); 
      e(paramBoolean);
    } 
  }
  
  private void g(boolean paramBoolean) {
    MediaView mediaView = this.i;
    if (mediaView != null) {
      FrameLayout.LayoutParams layoutParams;
      if (paramBoolean) {
        layoutParams = this.W;
      } else {
        layoutParams = this.X;
      } 
      mediaView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private void p() {
    this.az = new c(this, this.m) {
        public void a(com.qq.e.comm.plugin.s.a param1a) {
          super.a(param1a);
          h.a(this.b, false, true, (String)null);
        }
        
        public void a(boolean param1Boolean) {
          if (param1Boolean) {
            h h1 = this.b;
            h1.a(8, new Object[] { h1.b });
            h1 = this.b;
            h1.a(9, new Object[] { h1.b });
          } 
          super.a(param1Boolean);
        }
        
        public BrowserType b(String param1String, com.qq.e.comm.plugin.s.a param1a) {
          h h1 = this.b;
          h1.a(9, new Object[] { h1.b });
          return super.b(param1String, param1a);
        }
        
        public void c(String param1String) {
          super.c(param1String);
          h.a(this.b, false, true, param1String);
        }
      };
    this.ay = new i(this, (com.qq.e.comm.plugin.c.a.a)this.az);
  }
  
  private void q() {
    if (this.aq)
      return; 
    this.at = false;
    y.a(new Runnable(this) {
          public void run() {
            if (!h.c(this.a)) {
              if (this.a.j != null) {
                ViewParent viewParent = this.a.j.getParent();
                if (viewParent != null)
                  ((ViewGroup)viewParent).removeView((View)this.a.j); 
              } 
              h.d(this.a);
              h.e(this.a);
            } 
          }
        });
  }
  
  private void r() {
    if (this.aq)
      return; 
    this.at = true;
    y.a(new Runnable(this) {
          public void run() {
            if (h.c(this.a)) {
              if (this.a.j != null) {
                if (this.a.j.getParent() == null)
                  this.a.i.addView((View)this.a.j); 
                if (h.f(this.a) == 6)
                  h.g(this.a); 
              } 
              h.h(this.a);
            } 
          }
        });
  }
  
  private void s() {
    ViewGroup viewGroup = this.b;
    if (viewGroup != null)
      viewGroup.setTag(n()); 
  }
  
  private boolean t() {
    File file = aj.d(this.B);
    if (file == null || !file.exists())
      return false; 
    this.ax = (int)(file.length() >> 10L);
    return true;
  }
  
  private void u() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("callJsHeightMeasure view: ");
    stringBuilder.append(this.a.hashCode());
    stringBuilder.append(", renderSuccess: ");
    stringBuilder.append(this.F);
    stringBuilder.append(", webViewWidth: ");
    stringBuilder.append(this.am);
    stringBuilder.append(", adContentHeightInDp: ");
    stringBuilder.append(this.H);
    GDTLogger.d(stringBuilder.toString());
    if (this.F.booleanValue() && this.am > 0)
      y.a(this.aA); 
  }
  
  private void v() {
    JSONObject jSONObject = b.b(b());
    this.ag = jSONObject.optBoolean("autoPlayMuted", true);
    this.ah = jSONObject.optInt("autoPlayPolicy", n.a());
    this.ai = jSONObject.optBoolean("detailPageMuted", false);
  }
  
  private boolean w() {
    int k = this.k;
    boolean bool = false;
    if (k == 3 || k == 4)
      return true; 
    if (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI) {
      k = 1;
    } else {
      k = 0;
    } 
    int n = this.ah;
    return ((n != 0) ? (n == 1 || n != 2) : (k != 0 || t())) ? true : bool;
  }
  
  private void x() {
    h h1 = this.a;
    if (h1 != null)
      h1.b("mtaid.measureAdSpec()"); 
  }
  
  private void y() {
    if (this.k == 1) {
      a a1 = this.j;
      if (a1 == null)
        return; 
      if (this.ag) {
        a1.h();
        return;
      } 
      a1.i();
    } 
  }
  
  private void z() {
    D();
  }
  
  public String a() {
    return this.v;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, Exception paramException) {
    this.L = 2;
    U();
    b(17, new Object[] { this.b, Integer.valueOf(701) });
    c.a(this.w, false, this.n, paramInt, paramException);
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(int paramInt, Object[] paramArrayOfObject) {
    Runnable runnable = new Runnable(this, paramInt, paramArrayOfObject) {
        public void run() {
          if (h.l(this.c) != null && h.l(this.c).h() != null)
            h.l(this.c).h().onADEvent(new ADEvent(this.a, this.b)); 
        }
      };
    if (Looper.getMainLooper() != Looper.myLooper()) {
      y.a(runnable);
      return;
    } 
    runnable.run();
  }
  
  public void a(ValueCallback<Uri> paramValueCallback, Intent paramIntent) {}
  
  public void a(com.qq.e.comm.plugin.ab.a.a parama) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("On AD LifeEvent: ");
    stringBuilder.append(parama.a());
    GDTLogger.d(stringBuilder.toString());
    switch (null.a[parama.a().ordinal()]) {
      default:
        return;
      case 8:
        a(9, new Object[] { this.b });
        return;
      case 7:
        a(8, new Object[] { this.b });
        return;
      case 6:
        a(7, new Object[] { this.b });
        destroy();
        return;
      case 5:
        d(parama.b());
        return;
      case 4:
        b(parama.b());
        return;
      case 3:
        z();
        return;
      case 2:
        b(parama);
        return;
      case 1:
        break;
    } 
    c(parama.b());
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    if (paramString.equals(this.g.d())) {
      if (this.ae == null)
        return; 
      this.g.c(paramInt1);
      this.g.a(paramInt2);
      this.g.a(paramLong);
      if ((paramInt1 == 4 && paramInt2 % 5 == 0) || paramInt1 != 4)
        y.a(new Runnable(this, paramInt2, paramInt1) {
              public void run() {
                if (h.k(this.c) != null)
                  h.k(this.c).a(this.a, this.b); 
              }
            }); 
    } 
  }
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  protected void a(boolean paramBoolean) {
    a(paramBoolean, false, (String)null);
  }
  
  public String b() {
    return this.t;
  }
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean) {
    if (this.N == 3) {
      int k = this.k;
      if (k == 3 || k == 4)
        this.M = 0; 
    } 
  }
  
  public boolean b(ValueCallback<Uri[]> paramValueCallback, Intent paramIntent) {
    return false;
  }
  
  public void b_() {
    this.L = 0;
    if (this.i != null) {
      a a1 = this.j;
      if (a1 != null) {
        this.O = a1.e();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("duration = ");
        stringBuilder.append(this.O);
        GDTLogger.d(stringBuilder.toString());
        com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.i, this.d.o(), this.j);
      } 
    } 
    b(13, new Object[] { this.b, Integer.valueOf(this.O) });
  }
  
  public e c() {
    return e.i;
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean) {
    this.ay.a(paramBoolean);
  }
  
  public void c_() {
    String str;
    this.N = 1;
    JSONObject jSONObject = this.c;
    if (jSONObject != null) {
      jSONObject.optString("edid");
      str = this.c.optString("video_tracking_url");
    } else {
      str = "";
    } 
    GDTLogger.d("call onVideoExpose");
    ac.a(str);
    if (!this.e) {
      u.a(50032, 0, this.n);
      k();
    } 
    a a1 = this.j;
    if (a1 != null && a1.getVisibility() != 0) {
      this.j.setVisibility(0);
      com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.i);
    } 
    b(14, new Object[] { this.b });
    c.a(this.w, true, this.n, 0, (Exception)null);
    if (this.aw != 0L)
      bc.b(System.currentTimeMillis() - this.aw, this.ax, this.B, this.n); 
  }
  
  protected c d(String paramString) {
    c c1;
    List list1 = l.a().d();
    List list2 = null;
    if (list1 == null)
      return null; 
    Iterator<c> iterator = list1.iterator();
    while (true) {
      list1 = list2;
      if (iterator.hasNext()) {
        c1 = iterator.next();
        if (c1.h().equals(paramString))
          break; 
        continue;
      } 
      break;
    } 
    return c1;
  }
  
  public void d_() {
    a(8, new Object[] { this.b });
  }
  
  public void destroy() {
    if (this.ak)
      return; 
    this.ak = true;
    if (this.N == 1)
      U(); 
    G();
    ag ag1 = this.aa;
    if (ag1 != null)
      ag1.a(); 
    if (this.j != null)
      y.a(new Runnable(this) {
            public void run() {
              if (this.a.i != null) {
                this.a.j.l();
                this.a.i.removeAllViews();
                h h1 = this.a;
                h1.i = null;
                h1.j = null;
              } 
              if (h.i(this.a) != null) {
                h.i(this.a).removeAllViews();
                h.a(this.a, (FrameLayout)null);
              } 
              if (h.j(this.a) != null) {
                h.j(this.a).i();
                h.j(this.a).removeAllViews();
                h.a(this.a, (c)null);
              } 
              if (h.k(this.a) != null) {
                h.k(this.a).removeAllViews();
                h.a(this.a, (b)null);
              } 
            }
          }); 
    com.qq.e.comm.plugin.ab.d.a a1 = this.ad;
    if (a1 != null) {
      a1.a();
      this.ad = null;
    } 
    h h1 = this.a;
    if (h1 != null) {
      h1.c();
      this.a = null;
    } 
    j.e().d();
  }
  
  public void f_() {
    this.N = 3;
    U();
    this.K = 3;
    a a1 = this.j;
    if (a1 != null) {
      a1.setVisibility(4);
      if (!this.aq)
        com.qq.e.comm.plugin.aa.b.a.b((ViewGroup)this.i); 
    } 
    if (this.k == 4)
      l(); 
    b(16, new Object[] { this.b });
  }
  
  public void g() {
    this.K = 2;
    this.N = 1;
    b(14, new Object[] { this.b });
  }
  
  public void g_() {
    this.N = 5;
    U();
    a a1 = this.j;
    if (a1 != null) {
      a1.setVisibility(4);
      if (!this.aq)
        com.qq.e.comm.plugin.aa.b.a.b((ViewGroup)this.i); 
    } 
    b(16, new Object[] { this.b });
  }
  
  public void h_() {
    U();
    b(15, new Object[] { this.b });
  }
  
  public void i_() {
    ag ag1 = this.aa;
    if (ag1 != null)
      ag1.b(); 
    u.a(100382, 0, this.n);
  }
  
  public void j() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("webview onLayout: ");
    stringBuilder.append(this.l.hashCode());
    stringBuilder.append(", view width: ");
    h h2 = this.a;
    if (h2 != null) {
      Integer integer = Integer.valueOf(h2.a().getMeasuredWidth());
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    GDTLogger.d(stringBuilder.toString());
    h h1 = this.a;
    if (h1 != null) {
      int k = h1.a().getMeasuredWidth();
      if (k != this.am) {
        this.am = k;
        u();
      } 
    } 
  }
  
  public void j_() {
    l();
  }
  
  protected void k() {
    if (!this.e)
      A(); 
    this.f = true;
  }
  
  public void l() {
    int k = this.k;
    if (k == 4) {
      ag ag1 = this.aa;
      if (ag1 != null) {
        ag1.b();
        return;
      } 
    } else if (k == 3) {
      P();
    } 
  }
  
  protected boolean m() {
    return (this.c != null && !m.a(this.B));
  }
  
  public Point n() {
    JSONObject jSONObject = this.c;
    return (jSONObject != null) ? new Point(jSONObject.optInt("template_width"), this.c.optInt("template_height")) : new Point();
  }
  
  protected String o() {
    String str;
    if (this.a == null) {
      str = "view == null!!";
      GDTLogger.w(str);
      return null;
    } 
    this.an.a().b(this.a.a().getWidth());
    int k = am.a(this.h, this.H);
    this.an.a().a(k);
    JSONObject jSONObject = this.c;
    if (jSONObject != null) {
      str = jSONObject.optString("template_id");
    } else {
      jSONObject = null;
    } 
    this.an.a().b((String)jSONObject);
    com.qq.e.comm.plugin.ad.h h1 = this.an.a();
    if (m()) {
      k = 1;
    } else {
      k = 2;
    } 
    h1.c(k);
    try {
      null = this.an.b();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("anti info:");
      stringBuilder.append(null);
      GDTLogger.d(stringBuilder.toString());
      return URLEncoder.encode(null, "UTF-8");
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get anti failed:");
      stringBuilder.append(exception);
      str = stringBuilder.toString();
    } 
    GDTLogger.w(str);
    return null;
  }
  
  public void onClick(View paramView) {
    d(new JSONObject());
    if (paramView == this.i && this.j != null) {
      int k = this.k;
      if (k == 3 || k == 4)
        this.j.n(); 
    } 
  }
  
  public void preloadVideo() {
    if (!TextUtils.isEmpty(this.B)) {
      if (this.au)
        return; 
      this.au = true;
      boolean bool = t();
      String str = "";
      if (bool) {
        if (X()) {
          this.G.e();
        } else {
          b(21, new Object[] { this.b });
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("preloadVideo, video already cached, cl : ");
        com.qq.e.comm.plugin.s.a a2 = this.d;
        if (a2 != null)
          str = a2.m(); 
        stringBuilder1.append(str);
        GDTLogger.d(stringBuilder1.toString());
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("preloadVideo, cl : ");
      com.qq.e.comm.plugin.s.a a1 = this.d;
      if (a1 != null)
        str = a1.m(); 
      stringBuilder.append(str);
      GDTLogger.d(stringBuilder.toString());
      a(false, true);
    } 
  }
  
  public void render() {
    if (this.w == e.i)
      ab.a().a(this.t); 
    c.a(this.w, (Boolean)null, this.n, (com.qq.e.comm.plugin.ab.a.a)null);
    if (!this.E) {
      h h1 = this.a;
      if (h1 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r);
        stringBuilder.append(this.D);
        h1.a(null, stringBuilder.toString(), "text/html", "UTF-8", null);
        this.E = true;
        return;
      } 
    } 
    c.c(this.w, this.n);
  }
  
  public void reportAdNegative() {
    if (!TextUtils.isEmpty(this.ap)) {
      ah.a(this.ap);
      return;
    } 
    GDTLogger.e("reportAdNegative negativeFeedbackUrl is null");
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.x = paramADListener;
  }
  
  public void setAdSize(ADSize paramADSize) {
    if (this.a == null) {
      GDTLogger.w("Express AD View is null", null);
      return;
    } 
    this.y = paramADSize;
    a(this.y);
    ViewGroup.LayoutParams layoutParams = this.a.a().getLayoutParams();
    if (layoutParams != null) {
      layoutParams.width = this.z;
      layoutParams.height = this.A;
    } else {
      layoutParams = new ViewGroup.LayoutParams(this.z, this.A);
    } 
    this.a.a().setLayoutParams(layoutParams);
    y.a(this.aA);
  }
  
  public void setBrowserType(int paramInt) {
    this.o = paramInt;
  }
  
  class a extends f {
    public a(h this$0, Context param1Context) {
      super(param1Context);
    }
    
    public void a() {
      a(true);
    }
    
    public void a(boolean param1Boolean) {
      super.a();
      if (SDKStatus.getSDKVersionCode() < 11 || param1Boolean) {
        h.e(this.a, 4);
        return;
      } 
      h.e(this.a, 6);
    }
  }
  
  static class b implements AdData.VideoPlayer {
    private WeakReference<f> a;
    
    public b(f param1f) {
      this.a = new WeakReference<f>(param1f);
    }
    
    public int getCurrentPosition() {
      f f = this.a.get();
      return (f != null) ? f.f() : 0;
    }
    
    public int getDuration() {
      f f = this.a.get();
      return (f != null) ? f.e() : 0;
    }
    
    public int getVideoState() {
      f.d d;
      f f = this.a.get();
      if (f == null) {
        d = f.d.a;
      } else {
        d = d.g();
      } 
      return d.ordinal();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */