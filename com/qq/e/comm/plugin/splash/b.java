package com.qq.e.comm.plugin.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.a.b;
import com.qq.e.comm.plugin.ac.k;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.s.e;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.plugin.splash.a.b;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.be;
import com.qq.e.comm.plugin.util.bf;
import com.qq.e.comm.plugin.util.f;
import com.qq.e.comm.plugin.util.k;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.Locale;
import yaq.gdtadv;

public class b extends FrameLayout implements NSPVI, f.a, b, h.a {
  private f A;
  
  private boolean B = false;
  
  private boolean C = true;
  
  private long D = 1800000L;
  
  private volatile boolean E = false;
  
  private boolean F = false;
  
  private Runnable G;
  
  private File H;
  
  private volatile b I = b.a;
  
  private volatile b J = b.a;
  
  private File K;
  
  private boolean L;
  
  private int M = 1;
  
  private a N = a.a;
  
  private j O = new j();
  
  private long P;
  
  private long Q;
  
  private long R;
  
  private az S;
  
  private d T;
  
  private r U;
  
  private e V;
  
  private com.qq.e.comm.plugin.ac.c W;
  
  private final String a;
  
  private final String b;
  
  private final m c;
  
  private final h d;
  
  private final com.qq.e.comm.plugin.y.c e = new com.qq.e.comm.plugin.y.c();
  
  private String f;
  
  private f g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private ViewGroup l;
  
  private View m;
  
  private TextView n;
  
  private ADListener o;
  
  private g p;
  
  private f q;
  
  private Bitmap r = null;
  
  private g s;
  
  private int t;
  
  private int u;
  
  private q v = q.a;
  
  private LoadAdParams w;
  
  private View x;
  
  private View y;
  
  private String z;
  
  public b(Context paramContext, String paramString1, String paramString2) {
    this(paramContext, paramString1, paramString2, l.a);
  }
  
  public b(Context paramContext, String paramString1, String paramString2, l paraml) {
    super(paramContext);
    this.a = paramString1;
    this.b = paramString2;
    this.c = new m(paramString2, e.d, null);
    this.f = com.qq.e.comm.plugin.util.a.a(paramString1, paramString2, o.b());
    n();
    this.e.a(paramString2);
    this.d = new h(this.a, this.b, this.c, this.f, paraml, this, this.e);
    this.U = new r(paramContext, true);
  }
  
  private void A() {
    if (this.v == q.b && this.q.c())
      this.q.a(); 
    com.qq.e.comm.plugin.w.a.c.a();
    com.qq.e.comm.plugin.ac.c c1 = this.W;
    if (c1 != null)
      c1.b(); 
    if (this.O.d()) {
      if (this.o != null)
        y.a(new Runnable(this) {
              public void run() {
                b.f(this.a).onADEvent(new ADEvent(1));
              }
            }); 
      k.c(this.P, this.e);
    } 
  }
  
  private void B() {
    az az1 = this.S;
    if (az1 != null)
      az1.c(); 
    this.S = new az(this, this.i, 500L) {
        public void a() {
          GDTLogger.d("开屏计时结束");
          b.a(this.a);
        }
        
        public void a(long param1Long) {
          if (b.r(this.a) == null && b.A(this.a) != null)
            b.A(this.a).setText(String.format("%d", new Object[] { Integer.valueOf(Math.round((float)param1Long / 1000.0F)) })); 
          if (b.f(this.a) != null)
            b.f(this.a).onADEvent(new ADEvent(5, new Object[] { Long.valueOf(param1Long) })); 
        }
      };
    this.S.b();
  }
  
  private View C() {
    ImageView imageView = new ImageView(getContext());
    imageView.setId(4);
    imageView.setImageBitmap(aq.a("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"));
    imageView.setOnClickListener(this.T);
    return (View)imageView;
  }
  
  private void D() {
    if (SDKStatus.getSDKVersionCode() >= 20 && i.h()) {
      FrameLayout.LayoutParams layoutParams;
      View view = this.y;
      if (view == null) {
        SM sM = GDTADManager.getInstance().getSM();
        int i = sM.getInteger("preloadMarkBackgroundRadius", 45);
        int k = sM.getInteger("preloadMarkBackgroundColor", -2147483648);
        int n = sM.getInteger("preloadMarkBackgroundAlpha", 100);
        int i1 = sM.getInteger("preloadMarkTextSize", 14);
        int i2 = sM.getInteger("preloadMarkTextColor", -1);
        String str2 = sM.getString("preloadMarkTextContent");
        int i3 = sM.getInteger("preloadMarkMargin", 16);
        TextView textView = new TextView(getContext());
        textView.setBackgroundDrawable((Drawable)ar.a(i, k, n));
        textView.setTextSize(2, i1);
        textView.setTextColor(i2);
        textView.setPadding(am.a(getContext(), 8), am.a(getContext(), 3), am.a(getContext(), 8), am.a(getContext(), 3));
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = "已 Wi-Fi 预加载"; 
        textView.setText(str1);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 51;
        i = am.a(getContext(), i3);
        layoutParams.setMargins(i, i, i, i);
        addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
        return;
      } 
      layoutParams.setVisibility(0);
      if (this.y.getParent() == null)
        addView(this.y); 
    } 
  }
  
  private void E() {
    f f1 = this.q;
    if (f1 != null) {
      int i = f1.e();
      int k = this.q.f();
      if (k < i) {
        long l = (i - k);
        if (this.m == null) {
          TextView textView = this.n;
          if (textView != null)
            textView.setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(Math.round((float)l / 1000.0F)) })); 
        } 
        ADListener aDListener = this.o;
        if (aDListener != null)
          aDListener.onADEvent(new ADEvent(5, new Object[] { Long.valueOf(l) })); 
        y.a(new Runnable(this) {
              public void run() {
                b.B(this.a);
              }
            },  500L);
      } 
    } 
  }
  
  private View a(String paramString, int paramInt) {
    c c1 = new c(getContext());
    c1.setId(7);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, paramInt);
    layoutParams.gravity = 80;
    c1.setVisibility(4);
    addView((View)c1, (ViewGroup.LayoutParams)layoutParams);
    c1.setOnClickListener(this.T);
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "点击此处查看详情"; 
    c1.a(str);
    return (View)c1;
  }
  
  private View a(boolean paramBoolean) {
    LinearLayout linearLayout = new LinearLayout(getContext());
    linearLayout.setId(2);
    int i = am.a(getContext(), 6);
    int k = am.a(getContext(), 10);
    linearLayout.setPadding(k, i, k, i);
    linearLayout.setOnClickListener(this.T);
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(-16777216);
    gradientDrawable.setCornerRadius(50.0F);
    gradientDrawable.setStroke(am.a(getContext(), 1), -1);
    gradientDrawable.setAlpha(77);
    linearLayout.setBackgroundDrawable((Drawable)gradientDrawable);
    TextView textView = new TextView(getContext());
    textView.setText("跳过");
    textView.setTextSize(2, 14.0F);
    textView.setTextColor(-1);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    if (paramBoolean) {
      this.n = new TextView(getContext());
      this.n.setText(String.format("%d", new Object[] { Integer.valueOf(Math.round(this.i / 1000.0F)) }));
      this.n.setTextSize(2, 14.0F);
      this.n.setTextColor(-1);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.leftMargin = i;
      linearLayout.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
    } 
    return (View)linearLayout;
  }
  
  private void a(int paramInt1, int paramInt2) {
    gdtadv.getVresult(37, 0, new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private static void a(int paramInt1, View paramView1, int paramInt2, View paramView2) {
    if (paramView1 != null && paramView2 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("开屏banner高度:");
      stringBuilder.append(paramInt2);
      GDTLogger.d(stringBuilder.toString());
      AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
      float f1 = paramInt2;
      paramView1.setTranslationY(f1);
      ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { f1, 0.0F });
      long l = 500L;
      objectAnimator2.setDuration(l);
      objectAnimator2.setInterpolator((TimeInterpolator)accelerateDecelerateInterpolator);
      paramView1.setVisibility(0);
      ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(paramView2, "translationY", new float[] { 0.0F, -paramInt2 });
      objectAnimator1.setDuration(l);
      objectAnimator1.setInterpolator((TimeInterpolator)accelerateDecelerateInterpolator);
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.setStartDelay(paramInt1);
      animatorSet.playTogether(new Animator[] { (Animator)objectAnimator2, (Animator)objectAnimator1 });
      animatorSet.start();
    } 
  }
  
  private void a(View paramView) {
    if (paramView != null) {
      AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
      paramView.setAlpha(0.0F);
      ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });
      objectAnimator.setDuration(500L);
      objectAnimator.setInterpolator((TimeInterpolator)accelerateDecelerateInterpolator);
      objectAnimator.setStartDelay(1000L);
      objectAnimator.start();
    } 
  }
  
  private void a(File paramFile) {
    if (this.O.c()) {
      com.qq.e.comm.plugin.y.d d1;
      l.c();
      if (!b((View)this.l)) {
        GDTLogger.e("广告容器处于不可见状态，无法进行曝光上报和计费，请检查您的代码逻辑，保证广告容器可见。");
        b(600);
        d1 = c((View)this.l);
        k.a(4004, this.e, d1);
        return;
      } 
      w();
      x();
      boolean bool = true;
      k.a(Boolean.valueOf(true), 0, this.e);
      ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.l.removeAllViews();
      be.a((View)this);
      this.l.addView((View)this, layoutParams);
      if (this.v == q.b) {
        be.a((View)this.q);
        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams1.gravity = 17;
        addView((View)this.q, (ViewGroup.LayoutParams)layoutParams1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        alphaAnimation.setDuration(i.f());
        alphaAnimation.setFillAfter(true);
        this.q.startAnimation((Animation)alphaAnimation);
      } 
      this.E = false;
      this.T = new d(this);
      setVisibility(0);
      if (this.v == q.a) {
        v();
        B();
      } 
      if (this.x != null) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams1.gravity = 80;
        frameLayout.addView(this.x);
        addView((View)frameLayout, (ViewGroup.LayoutParams)layoutParams1);
        this.x.setOnClickListener(this.T);
      } 
      if (this.x == null)
        bool = false; 
      k.a(bool, this.e);
      this.Q = System.currentTimeMillis();
      ADListener aDListener = this.o;
      if (aDListener != null)
        aDListener.onADEvent(new ADEvent(3)); 
      if (this.v == q.b && d1 != null && d1.exists()) {
        this.q.a(this);
        this.q.a(d1.getAbsolutePath());
        this.q.b();
        if (this.N == a.c) {
          this.q.a(f.c.c);
          k.b(this.v, this.e);
        } 
      } else if (this.v == q.a && d1 != null && d1.exists()) {
        Movie movie = k.b((File)d1);
        if (movie != null) {
          this.p.a(movie);
        } else {
          Bitmap bitmap = this.r;
          if (bitmap != null)
            bitmap.recycle(); 
          this.r = k.a((File)d1, this.p);
          this.p.setImageBitmap(this.r);
          k.b(this.v, this.e);
        } 
        this.p.setScaleType(ImageView.ScaleType.FIT_XY);
      } 
      l.a(this.b);
      b.d();
      GDTLogger.d("开屏广告展示完成");
    } 
  }
  
  private void a(File paramFile, String paramString, long paramLong) {
    StringBuilder stringBuilder;
    int i = (int)(paramFile.length() >> 10L);
    k.a(paramLong, i, paramString, this.e);
    if (paramLong > 0L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("开屏图片下载成功耗时ms:");
      stringBuilder1.append(System.currentTimeMillis() - paramLong);
      stringBuilder1.append(" 大小:");
      stringBuilder1.append(i);
      stringBuilder1.append(" url:");
      stringBuilder1.append(paramString);
      GDTLogger.d(stringBuilder1.toString());
    } 
    if (!this.O.i() || this.g == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("广告图片下载成功时开屏广告已超时或者在展示：");
      stringBuilder.append(this.O);
      GDTLogger.d(stringBuilder.toString());
      return;
    } 
    this.I = b.c;
    k.a(this.J, this.I, this.e, 0, null, paramString, this.g.G());
    this.H = (File)stringBuilder;
    if (this.v == q.a) {
      m();
      return;
    } 
  }
  
  private void a(String paramString) {
    long l = System.currentTimeMillis();
    com.qq.e.comm.plugin.p.a.a().a(paramString, this.p, new com.qq.e.comm.plugin.p.b(this, paramString, l) {
          public void a(String param1String, int param1Int, Exception param1Exception) {
            GDTLogger.d("Splash Load Image Failed");
            b.a(this.c, 406);
            k.a(b.q(this.c), b.k(this.c), b.e(this.c), param1Int, param1Exception, param1String, b.g(this.c).G());
          }
          
          public void a(String param1String, ImageView param1ImageView, e param1e) {
            GDTLogger.d("Splash Load Image Complete");
            k.a(b.q(this.c), b.k(this.c), b.e(this.c), 0, null, this.a, b.g(this.c).G());
            if (!param1e.c()) {
              int i = (int)(param1e.b().length() >> 10L);
              k.a(this.b, i, param1String, b.e(this.c));
            } 
            b.a(this.c, param1e.a());
            b.a(this.c, (File)null);
          }
        });
  }
  
  private void a(String paramString, long paramLong, int paramInt, Exception paramException) {
    StringBuilder stringBuilder1;
    this.I = b.d;
    if (!this.O.i() || this.g == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("广告图片下载失败时开屏广告已超时或者在展示：");
      stringBuilder1.append(this.O);
      GDTLogger.d(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("开屏图片下载失败耗时ms:");
    stringBuilder2.append(System.currentTimeMillis() - paramLong);
    stringBuilder2.append(" url:");
    stringBuilder2.append((String)stringBuilder1);
    GDTLogger.d(stringBuilder2.toString());
    k.a(this.J, this.I, this.e, paramInt, paramException, (String)stringBuilder1, this.g.G());
    if (this.v == q.a) {
      b(406);
      return;
    } 
  }
  
  private void b(int paramInt) {
    if (this.O.e()) {
      k.c(this.P, this.e);
      if (this.o != null)
        y.a(new Runnable(this, paramInt) {
              public void run() {
                b.f(this.b).onADEvent(new ADEvent(2, new Object[] { Integer.valueOf(this.a) }));
              }
            }); 
    } 
    this.E = false;
  }
  
  private void b(File paramFile, String paramString, long paramLong) {
    StringBuilder stringBuilder1;
    if (!this.O.i() || this.g == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("广告视频下载成功时开屏广告已超时或者在展示：");
      stringBuilder1.append(this.O);
      GDTLogger.d(stringBuilder1.toString());
      return;
    } 
    this.J = b.c;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("开屏视频下载成功耗时ms:");
    stringBuilder2.append(paramLong);
    stringBuilder2.append(" 大小:");
    stringBuilder2.append(stringBuilder1.length());
    stringBuilder2.append(" url:");
    stringBuilder2.append(paramString);
    GDTLogger.d(stringBuilder2.toString());
    k.b(this.J, this.I, this.e, 0, null, this.g.o(), paramString);
    if (paramLong > 0L)
      bc.a(paramLong, (int)(stringBuilder1.length() >> 10L), paramString, this.e); 
    this.K = (File)stringBuilder1;
    this.N = a.c;
    m();
  }
  
  private void b(String paramString, long paramLong, int paramInt, Exception paramException) {
    StringBuilder stringBuilder1;
    this.J = b.d;
    if (!this.O.i() || this.g == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("广告视频下载完成时开屏广告已超时或者在展示：");
      stringBuilder1.append(this.O);
      GDTLogger.d(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("开屏视频下载失败耗时:");
    stringBuilder2.append(paramLong);
    stringBuilder2.append(" url:");
    stringBuilder2.append((String)stringBuilder1);
    GDTLogger.d(stringBuilder2.toString());
    if (this.I == b.c) {
      GDTLogger.d("开屏视频转图文成功");
      k.b(this.J, this.I, this.e, paramInt, paramException, null, (String)stringBuilder1);
      this.v = q.a;
      m();
      return;
    } 
    if (this.I == b.b) {
      GDTLogger.d("开屏视频转图文，图文尚在下载中");
      this.v = q.a;
      return;
    } 
    GDTLogger.d("开屏视频转图文失败");
    k.b(this.J, this.I, this.e, paramInt, paramException, this.g.o(), (String)stringBuilder1);
    b(700);
  }
  
  private boolean b(View paramView) {
    bf.a(getContext(), paramView, 50);
    return (paramView != null && paramView.getVisibility() == 0 && paramView.isShown() && paramView.getWindowVisibility() == 0);
  }
  
  private com.qq.e.comm.plugin.y.d c(View paramView) {
    boolean bool;
    if (paramView == null) {
      bool = true;
    } else {
      bool = false;
    } 
    com.qq.e.comm.plugin.y.d d1 = (new com.qq.e.comm.plugin.y.d()).a("vn", Boolean.valueOf(bool));
    if (!bool)
      d1.a("v", Boolean.valueOf(bf.a(getContext(), paramView, 50))).a("vv", Integer.valueOf(paramView.getVisibility())).a("vs", Boolean.valueOf(paramView.isShown())).a("wv", Integer.valueOf(paramView.getWindowVisibility())); 
    return d1;
  }
  
  private void c(int paramInt) {
    if (this.v == q.b) {
      k k = new k(getContext(), this.g.ac(), this.s);
      int i = getHeight();
      k.a(12, am.b(getContext(), i - paramInt) - 12, (ViewGroup)this);
      k.a(this.T);
      k.setId(8);
    } 
  }
  
  private void d(int paramInt) {
    if (l.b())
      return; 
    if (this.q.c())
      this.q.a(); 
    f f1 = this.g;
    if (f1 != null) {
      this.V.a(f1, paramInt, this.v, this.l, this.s);
      ADListener aDListener = this.o;
      if (aDListener != null)
        aDListener.onADEvent(new ADEvent(4)); 
    } 
  }
  
  private void l() {
    if (this.V != null)
      return; 
    this.V = new e(this, (com.qq.e.comm.plugin.c.a.a)new com.qq.e.comm.plugin.c.a.c(this, this.l.getContext()) {
          public void a(int param1Int, com.qq.e.comm.plugin.c.a.b param1b) {
            if (b.c(this.b) != null)
              b.c(this.b).d(); 
            super.a(param1Int, new com.qq.e.comm.plugin.c.a.b(this, param1b) {
                  private void d() {
                    if (b.c(this.b.b) != null)
                      b.c(this.b.b).e(); 
                  }
                  
                  public void a() {
                    this.a.a();
                    d();
                  }
                  
                  public void b() {
                    this.a.b();
                    b.a(this.b.b);
                  }
                  
                  public void c() {
                    this.a.c();
                    d();
                  }
                });
          }
          
          public void a(String param1String, int param1Int) {
            super.a(param1String, param1Int);
            if (!com.qq.e.comm.plugin.a.d.d.b(param1Int))
              b.a(this.b); 
          }
          
          public void a(String param1String, com.qq.e.comm.plugin.c.a.b param1b) {
            Activity activity = f.a(this.a);
            if (activity != null) {
              b.a(this.b, new com.qq.e.comm.plugin.ac.c(activity, param1String, new com.qq.e.comm.plugin.c.a.b(this, param1b) {
                      public void a() {
                        this.a.a();
                        b.a(this.b.b);
                      }
                      
                      public void b() {
                        this.a.b();
                      }
                      
                      public void c() {
                        this.a.c();
                        b.a(this.b.b);
                      }
                    }));
              b.b(this.b).a();
            } 
          }
          
          public void a(boolean param1Boolean) {
            super.a(param1Boolean);
            b.a(this.b);
          }
          
          public BrowserType b(String param1String, com.qq.e.comm.plugin.s.a param1a) {
            BrowserType browserType = super.b(param1String, param1a);
            b.a(this.b);
            return browserType;
          }
        });
  }
  
  private void m() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("广告和资源加载成功，总耗时:");
    stringBuilder.append(System.currentTimeMillis() - this.P);
    GDTLogger.d(stringBuilder.toString());
    if (!this.O.b()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("开屏广告已超时或者在展示：");
      stringBuilder.append(this.O);
      GDTLogger.d(stringBuilder.toString());
      return;
    } 
    this.C = false;
    this.F = false;
    this.g.a(SystemClock.elapsedRealtime());
    this.D = i.a();
    boolean bool = i.b();
    Runnable runnable = new Runnable(this) {
        public void run() {
          if (b.f(this.a) != null && b.g(this.a) != null)
            b.f(this.a).onADEvent(new ADEvent(7, new Object[] { Long.valueOf(b.g(this.a).ao() + b.h(this.a)) })); 
        }
      };
    if (bool) {
      y.b(runnable);
    } else {
      y.a(runnable);
    } 
    if (this.B) {
      this.B = false;
      k.a((Boolean)null, 0, this.e);
      this.E = true;
      s();
    } 
  }
  
  private void n() {
    this.p = new g(getContext());
    addView((View)this.p, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.p.setId(1);
    this.q = new f(getContext().getApplicationContext());
    this.q.a(f.c.b);
    this.q.h();
    this.q.setId(5);
  }
  
  private void o() {
    Runnable runnable = this.G;
    if (runnable == null) {
      this.G = new Runnable(this) {
          public void run() {
            if (b.i(this.a).i() && b.j(this.a) == q.b && b.k(this.a) == b.b.c) {
              GDTLogger.d("开屏视频拉取超时，转图片成功");
              b.a(this.a, q.a);
              b.l(this.a);
              return;
            } 
            if (b.i(this.a).f()) {
              b.m(this.a).d();
              k.a(b.n(this.a), b.k(this.a), b.m(this.a).c(), b.e(this.a));
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("加载开屏广告网络超时，请检查网络状态当前设置的超时时长为：");
              stringBuilder.append(b.n(this.a));
              stringBuilder.append("ms]");
              GDTLogger.e(stringBuilder.toString());
              b.a(this.a, 404);
            } 
          }
        };
    } else {
      y.c(runnable);
    } 
    k.a(this.e);
    this.d.a();
    y.a(this.G, this.h);
  }
  
  private void p() {
    if (!TextUtils.isEmpty(this.g.G())) {
      this.v = q.b;
      r();
    } else {
      this.v = q.a;
    } 
    k.a(this.v, this.e);
    GDTLogger.d("开始下载开屏图片");
    q();
  }
  
  private void q() {
    this.I = b.b;
    String str = this.g.o();
    long l = System.currentTimeMillis();
    com.qq.e.comm.plugin.p.a.a().a(str, new com.qq.e.comm.plugin.p.b(this, str, l) {
          public void a(String param1String, int param1Int, Exception param1Exception) {
            GDTLogger.d("开屏图片下载失败");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Download Failed, code: ");
            stringBuilder.append(param1Int);
            stringBuilder.append(", msg: ");
            stringBuilder.append(param1Exception.getMessage());
            GDTLogger.e(stringBuilder.toString());
            b.a(this.c, this.a, this.b, param1Int, param1Exception);
          }
          
          public void a(String param1String, ImageView param1ImageView, e param1e) {
            b b1;
            String str;
            long l;
            File file = param1e.b();
            if (param1e.c()) {
              b1 = this.c;
              str = this.a;
              l = -1L;
            } else {
              b1 = this.c;
              str = this.a;
              l = this.b;
            } 
            b.a(b1, file, str, l);
            GDTLogger.d("开屏图片下载成功");
          }
        });
  }
  
  private void r() {
    this.J = b.b;
    String str1 = this.g.G();
    File file1 = aj.f();
    String str2 = aj.a(str1);
    File file2 = new File(file1, str2);
    if (file2.exists()) {
      b(file2, str1, -1L);
      return;
    } 
    long l = System.currentTimeMillis();
    com.qq.e.comm.plugin.aa.a.b b1 = (new com.qq.e.comm.plugin.aa.a.b.a()).b(str1).a(file1).a(str2).a();
    com.qq.e.comm.plugin.aa.a.a.a().a(b1, str1, new com.qq.e.comm.plugin.j.a(this, l, str1) {
          public void a() {
            GDTLogger.d("开屏视频开始下载");
          }
          
          public void a(long param1Long1, long param1Long2, int param1Int) {}
          
          public void a(long param1Long, boolean param1Boolean) {
            GDTLogger.d("开屏视频连接成功");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onConnected isRangeSupport: ");
            stringBuilder.append(param1Boolean);
            stringBuilder.append(", total: ");
            stringBuilder.append(param1Long);
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void a(com.qq.e.comm.plugin.j.c param1c) {
            GDTLogger.d("开屏视频下载失败");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Download Failed, code: ");
            stringBuilder.append(param1c.a());
            stringBuilder.append(", msg: ");
            stringBuilder.append(param1c.b());
            GDTLogger.e(stringBuilder.toString());
            b.b(this.c, this.b, System.currentTimeMillis() - this.a, param1c.a(), (Exception)param1c);
          }
          
          public void a(File param1File, long param1Long) {
            param1Long = System.currentTimeMillis();
            long l = this.a;
            GDTLogger.d("开屏视频下载成功");
            b.b(this.c, param1File, this.b, param1Long - l);
          }
          
          public void b() {
            GDTLogger.d("开屏视频下载被暂停");
            b.b(this.c, this.b, System.currentTimeMillis() - this.a, -3, (Exception)null);
          }
          
          public void c() {
            GDTLogger.d("开屏视频下载被取消");
            b.b(this.c, this.b, System.currentTimeMillis() - this.a, -4, (Exception)null);
          }
        });
  }
  
  private void s() {
    l();
    f f1 = this.g;
    if (f1 == null) {
      k.a(Boolean.valueOf(false), 4014, this.e);
      b(4014);
      return;
    } 
    f f2 = this.A;
    if (f2 != null) {
      this.g = f2;
      this.g.q(f1.g());
      if (!this.d.b())
        this.g.b(f1); 
      if (this.g.h() > 0)
        this.i = this.g.h() * 1000; 
      this.z = String.valueOf(i.d());
      this.g.z(this.z);
      int i = this.A.F();
      if (i != 0) {
        if (i != 1) {
          f.a(this.A.F(), this.e);
          return;
        } 
        File file1 = com.qq.e.comm.plugin.u.b.a().a(this.b, this.A.G());
        File file2 = com.qq.e.comm.plugin.u.b.a().a(this.b, this.A.o());
        if (!file1.exists() || (i.e() && !TextUtils.isEmpty(this.A.k()) && !this.A.k().equals(Md5Util.encode(file1)))) {
          i = 0;
        } else {
          i = 1;
        } 
        if (i != 0) {
          this.v = q.b;
          this.N = a.b;
          y.a(new Runnable(this, file1) {
                public void run() {
                  b.a(this.b, this.a);
                }
              });
          f.a(this.e);
          return;
        } 
        if (file2.exists()) {
          y.a(new Runnable(this, file2) {
                public void run() {
                  b.a(this.b, this.a);
                }
              });
          f.a(false, this.e);
          return;
        } 
        a(this.A.o());
        f.a(true, this.e);
        return;
      } 
      File file = com.qq.e.comm.plugin.u.b.a().a(this.b, this.A.o());
      if (file.exists()) {
        y.a(new Runnable(this, file) {
              public void run() {
                b.a(this.b, this.a);
              }
            });
        return;
      } 
      a(this.A.o());
      f.b(this.e);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("开始播放广告type:");
    stringBuilder.append(this.v);
    stringBuilder.append("，广告倒计时为:");
    stringBuilder.append(this.i);
    GDTLogger.d(stringBuilder.toString());
    y.a(new Runnable(this) {
          public void run() {
            b b1;
            File file;
            if (b.j(this.a) == q.a) {
              b1 = this.a;
              file = b.o(b1);
            } else if (b.j(this.a) == q.b) {
              b1 = this.a;
              file = b.p(b1);
            } else {
              return;
            } 
            b.a(b1, file);
          }
        });
  }
  
  private boolean t() {
    boolean bool1 = this.g.L();
    boolean bool = false;
    if (!bool1) {
      if (this.A != null)
        return false; 
      int i = i.i();
      if (i == 0)
        return false; 
      if (i != 1) {
        e e1 = this.g.Z();
        if (com.qq.e.comm.plugin.l.a.a().a(e1, String.valueOf(i), 0) != 1)
          return false; 
      } 
      bool = true;
    } 
    return bool;
  }
  
  private int u() {
    boolean bool = this.g.L();
    int i = 0;
    if (!bool) {
      if (this.A != null)
        return 0; 
      i = i.j();
      if (i < 0 || i > 3) {
        e e1 = this.g.Z();
        return com.qq.e.comm.plugin.l.a.a().a(e1, String.valueOf(i), 0);
      } 
      return i;
    } 
    return i;
  }
  
  private void v() {
    boolean bool1;
    View view3;
    boolean bool = t();
    int k = u();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("开屏skip delay:");
    stringBuilder2.append(bool);
    stringBuilder2.append(" pos:");
    stringBuilder2.append(k);
    stringBuilder2.append(" showVol:");
    int i = 0;
    stringBuilder2.append(false);
    GDTLogger.d(stringBuilder2.toString());
    int n = am.a(getContext(), 12);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams1.setMargins(n, n, n, n);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(am.a(getContext(), 42), am.a(getContext(), 16));
    layoutParams2.setMargins(n, n, n, n);
    View view1 = this.m;
    boolean bool2 = true;
    if (view1 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    k.a(Boolean.valueOf(bool1), this.v, this.e);
    View view2 = C();
    if (!bool1) {
      layoutParams2.gravity = 8388693;
      view3 = view2;
    } else {
      if (k == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      View view = a(bool1);
      if (k == 2) {
        ((FrameLayout.LayoutParams)view3).gravity = 8388659;
      } else {
        if (k == 3) {
          ((FrameLayout.LayoutParams)view3).gravity = 8388693;
          layoutParams2.gravity = 8388659;
          view1 = view;
        } else {
          ((FrameLayout.LayoutParams)view3).gravity = 8388661;
          layoutParams2.gravity = 8388693;
        } 
        addView(view, (ViewGroup.LayoutParams)view3);
        view3 = view1;
      } 
      layoutParams2.gravity = 8388693;
    } 
    addView(view2, (ViewGroup.LayoutParams)layoutParams2);
    k = this.g.aq();
    if (k >= 0 && i.c()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("开屏是否显示动画:");
    stringBuilder1.append(bool1);
    stringBuilder1.append(" 开始时间:");
    stringBuilder1.append(k);
    GDTLogger.d(stringBuilder1.toString());
    if (bool1) {
      i = am.a(getContext(), 60);
      a(k * 1000, a(this.g.n(), i), i, view3);
    } 
    c(i);
  }
  
  private void w() {
    View view = this.m;
    if (view != null)
      view.post(new Runnable(this) {
            public void run() {
              b b1 = this.a;
              if (!b.a(b1, b.r(b1))) {
                GDTLogger.e("跳过按钮处于不可见状态，无法进行曝光上报和计费，请检查您的代码逻辑，保证跳过按钮可见。");
                b.a(this.a, 608);
                b1 = this.a;
                com.qq.e.comm.plugin.y.d d = b.b(b1, b.r(b1));
                k.a(4019, b.e(this.a), d);
                return;
              } 
              int i = am.b(GDTADManager.getInstance().getAppContext(), b.r(this.a).getWidth());
              int j = am.b(GDTADManager.getInstance().getAppContext(), b.r(this.a).getHeight());
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("###跳过按钮物理宽度=");
              stringBuilder2.append(i);
              stringBuilder2.append("dp");
              GDTLogger.d(stringBuilder2.toString());
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("###跳过按钮物理高度=");
              stringBuilder2.append(j);
              stringBuilder2.append("dp");
              GDTLogger.d(stringBuilder2.toString());
              Rect rect = new Rect();
              boolean bool = b.r(this.a).getGlobalVisibleRect(rect);
              int k = am.b(GDTADManager.getInstance().getAppContext(), rect.width());
              int m = am.b(GDTADManager.getInstance().getAppContext(), rect.height());
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("###跳过按钮在屏幕中的可见性=");
              stringBuilder1.append(bool);
              GDTLogger.d(stringBuilder1.toString());
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("###跳过按钮可见宽度=");
              stringBuilder1.append(k);
              stringBuilder1.append("dp");
              GDTLogger.d(stringBuilder1.toString());
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("###跳过按钮可见高度=");
              stringBuilder1.append(m);
              stringBuilder1.append("dp");
              GDTLogger.d(stringBuilder1.toString());
              if (!bool || i < 3 || j < 3 || k < 3 || m < 3) {
                GDTLogger.e("跳过按钮的宽和高都必须 >= 3dp，否则将不进行曝光上报和计费");
                b.a(this.a, 608);
                k.a(4009, b.e(this.a), (com.qq.e.comm.plugin.y.d)null);
              } 
            }
          }); 
  }
  
  private void x() {
    ViewGroup viewGroup = this.l;
    if (viewGroup != null)
      viewGroup.post(new Runnable(this) {
            public void run() {
              char c;
              b b1 = this.a;
              b.b(b1, b.s(b1).getWidth());
              b1 = this.a;
              b.c(b1, b.s(b1).getHeight());
              int i = am.b(GDTADManager.getInstance().getAppContext(), b.t(this.a));
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("###广告容器物理高度=");
              stringBuilder2.append(i);
              stringBuilder2.append("dp");
              GDTLogger.d(stringBuilder2.toString());
              Rect rect = new Rect();
              boolean bool1 = b.s(this.a).getGlobalVisibleRect(rect);
              int j = am.b(GDTADManager.getInstance().getAppContext(), rect.height());
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("###开屏容器在屏幕中的可见性=");
              stringBuilder1.append(bool1);
              GDTLogger.d(stringBuilder1.toString());
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("###开屏容器在屏幕中的可见高度=");
              stringBuilder1.append(j);
              stringBuilder1.append("dp");
              GDTLogger.d(stringBuilder1.toString());
              boolean bool2 = b.k();
              if (bool2) {
                DisplayMetrics displayMetrics = this.a.getContext().getResources().getDisplayMetrics();
                if (displayMetrics.heightPixels > displayMetrics.widthPixels) {
                  c = displayMetrics.heightPixels;
                } else {
                  c = displayMetrics.widthPixels;
                } 
                c = am.b(GDTADManager.getInstance().getAppContext(), c);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("###开屏屏幕高度=");
                stringBuilder.append(c);
                stringBuilder.append("dp");
                GDTLogger.d(stringBuilder.toString());
                c = (int)(c * 0.75D);
              } else {
                c = 'Ɛ';
              } 
              if (!bool1 || i < c || j < c) {
                String str;
                StringBuilder stringBuilder;
                if (bool2) {
                  stringBuilder = new StringBuilder();
                  str = "广告容器的高度必须 >= 手机的高度 * 0.75，否则将不进行曝光上报和计费，当前的高度为：";
                } else {
                  stringBuilder = new StringBuilder();
                  str = "广告容器的高度必须 >= 400dp，否则将不进行曝光上报和计费，当前的高度为：";
                } 
                stringBuilder.append(str);
                stringBuilder.append(j);
                stringBuilder.append("dp");
                GDTLogger.e(stringBuilder.toString());
                b.a(this.a, 606);
                k.a(4005, b.e(this.a), (com.qq.e.comm.plugin.y.d)null);
                return;
              } 
              b.v(this.a).setOnClickListener(b.u(this.a));
              b.w(this.a).setOnClickListener(b.u(this.a));
              if (!b.x(this.a)) {
                b.a(this.a, true);
                com.qq.e.comm.plugin.ad.a.a().a((View)this.a);
                this.a.post(new Runnable(this) {
                      public void run() {
                        b.y(this.a.a);
                      }
                    });
                return;
              } 
            }
          }); 
  }
  
  private static boolean y() {
    return (SDKStatus.getSDKVersionCode() > 1);
  }
  
  private void z() {
    GDTLogger.d("开屏开始曝光");
    com.qq.e.comm.plugin.y.c c1 = this.e;
    byte b3 = 0;
    k.a((Boolean)null, 0, c1, (Exception)null);
    this.s = new g();
    this.s.a(System.currentTimeMillis());
    boolean bool = this.d.b();
    byte b2 = 1;
    byte b1 = b3;
    if (bool) {
      b1 = b3;
      if (!l.a(getContext()))
        b1 = 1; 
    } 
    if (b1) {
      b.b(this.g);
    } else {
      g g1 = this.s;
      ViewGroup viewGroup = this.l;
      b1 = b2;
      if (this.v == q.a)
        b1 = 2; 
      String str = g1.a((View)viewGroup, b1, this.g.x(), "41");
      com.qq.e.comm.plugin.w.d.b b4 = new com.qq.e.comm.plugin.w.d.b(this) {
          public void a() {
            k.a(Boolean.valueOf(true), 0, b.e(this.a), (Exception)null);
          }
          
          public void a(int param1Int, Exception param1Exception) {
            k.a(Boolean.valueOf(false), param1Int, b.e(this.a), param1Exception);
          }
        };
      i.a(str, com.qq.e.comm.plugin.ad.a.a().b((View)this), (com.qq.e.comm.plugin.s.a)this.g, b4);
      this.g.V();
      this.g.W();
      str = this.g.t();
      if (!StringUtil.isEmpty(str))
        ah.a(str); 
    } 
    if (this.o != null)
      y.a(new Runnable(this) {
            public void run() {
              b.f(this.a).onADEvent(new ADEvent(6));
            }
          }); 
  }
  
  public void a() {
    this.R = System.currentTimeMillis();
  }
  
  public void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("广告拉取失败，耗时:");
    stringBuilder.append(System.currentTimeMillis() - this.P);
    GDTLogger.d(stringBuilder.toString());
    if (!this.O.i()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("广告回包时开屏广告已超时或者在展示：");
      stringBuilder.append(this.O);
      GDTLogger.d(stringBuilder.toString());
      return;
    } 
    b(paramInt);
  }
  
  public void a(int paramInt, Exception paramException) {
    GDTLogger.d("开屏视频播放错误");
    k.a(this.g.G(), paramInt, paramException, this.e);
    if (this.N != a.c) {
      A();
      return;
    } 
    a(2, this.M);
    if (!this.L) {
      GDTLogger.d("尝试转图片开屏");
      if (!this.K.delete()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("删除损坏视频文件失败:");
        stringBuilder.append(this.K.getAbsolutePath());
        GDTLogger.d(stringBuilder.toString());
      } 
      this.K = null;
      if (this.I == b.c && this.O.h()) {
        GDTLogger.d("转图片开屏成功");
        this.v = q.a;
        k.a(Boolean.valueOf(false), paramInt, this.e, this.g.G(), paramException);
        a(this.H);
        return;
      } 
      if (this.I == b.b && this.O.g()) {
        GDTLogger.d("图片尚在下载中，等待下载结束");
        this.v = q.a;
        this.B = true;
        return;
      } 
      GDTLogger.d("图片下载错误，失败");
      b(700);
      k.a(null, paramInt, this.e, this.g.G(), paramException);
    } 
  }
  
  public void a(com.qq.e.comm.plugin.ab.a.a parama) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SplashAdView OnADLifeEvent:");
    stringBuilder.append(parama.a());
    GDTLogger.d(stringBuilder.toString());
    int i = null.a[parama.a().ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        A();
        return;
      } 
      az az1 = this.S;
      if (az1 != null) {
        az1.e();
        return;
      } 
    } else {
      az az1 = this.S;
      if (az1 != null)
        az1.d(); 
    } 
  }
  
  public void a(f paramf1, f paramf2) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("广告拉取成功，耗时:");
    stringBuilder2.append(System.currentTimeMillis() - this.P);
    GDTLogger.d(stringBuilder2.toString());
    if (!this.O.i()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("广告回包时开屏广告已超时或者在展示：");
      stringBuilder1.append(this.O);
      GDTLogger.d(stringBuilder1.toString());
      return;
    } 
    this.g = (f)stringBuilder1;
    if (paramf2 != null) {
      this.A = paramf2;
      m();
    } else {
      p();
    } 
    this.e.b(this.g.m()).c(this.g.H());
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("开屏视频开始播放:");
    stringBuilder.append(this.N);
    GDTLogger.d(stringBuilder.toString());
    v();
    if (this.N != a.c) {
      E();
      D();
    } else {
      B();
      this.L = true;
      k.a(Boolean.valueOf(true), 0, this.e, null, null);
    } 
    k.a(this.R, this.e);
    ac.a(this.g.E().optString("video_tracking_url"));
  }
  
  public void c() {
    GDTLogger.d("开屏视频播放结束");
    if (this.N != a.c) {
      A();
      return;
    } 
    a(0, this.M);
  }
  
  public void d() {
    GDTLogger.d("开屏视频stop");
    if (this.N != a.c) {
      A();
      return;
    } 
    a(0, this.M);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    GDTLogger.d("SplashAdView dispatchTouchEvent");
    g g1 = this.s;
    if (g1 != null)
      g1.a((View)this, paramMotionEvent, false); 
    this.U.a(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e() {
    GDTLogger.d("开屏视频暂停播放");
    if (this.N == a.c) {
      a(0, this.M);
      this.M = 2;
    } 
  }
  
  public void f() {}
  
  public void fetchAdOnly() {
    if (this.E || !this.O.a()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("开屏拉取广告接口调用太频繁，之前的广告尚未加载完成或者正在展示isPlaying:");
      stringBuilder1.append(this.E);
      GDTLogger.e(stringBuilder1.toString());
      return;
    } 
    Bitmap bitmap = this.r;
    if (bitmap != null) {
      bitmap.recycle();
      this.r = null;
    } 
    this.A = null;
    this.g = null;
    this.H = null;
    this.I = b.a;
    this.J = b.a;
    this.K = null;
    this.L = false;
    this.M = 1;
    if (l.a(getContext()))
      b.a().b(); 
    this.P = System.currentTimeMillis();
    this.h = i.g();
    this.i = i.b(this.b);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("开始拉取开屏资源广告拉取超时设置:");
    stringBuilder.append(this.h);
    stringBuilder.append(" 广告展示时间:");
    stringBuilder.append(this.i);
    GDTLogger.d(stringBuilder.toString());
    o();
  }
  
  public void fetchAndShowIn(ViewGroup paramViewGroup) {
    if (paramViewGroup == null) {
      GDTLogger.e("Container param for fetchAndShowIn Method should not be null");
      return;
    } 
    this.B = true;
    this.l = paramViewGroup;
    fetchAdOnly();
  }
  
  public int g() {
    f f1 = this.A;
    if (f1 == null) {
      f1 = this.g;
      if (f1 == null)
        return -1; 
    } 
    return f1.O();
  }
  
  public String getAdNetWorkName() {
    return null;
  }
  
  public String getECPMLevel() {
    f f1 = this.A;
    if (f1 == null) {
      f1 = this.g;
      if (f1 == null)
        return ""; 
    } 
    return f1.J();
  }
  
  public int h() {
    f f1 = this.A;
    if (f1 == null) {
      f1 = this.g;
      if (f1 == null)
        return -1; 
    } 
    return f1.I();
  }
  
  public int i() {
    f f1 = this.A;
    if (f1 == null) {
      f1 = this.g;
      if (f1 == null)
        return -1; 
    } 
    return f1.K();
  }
  
  public boolean j() {
    f f1 = this.A;
    if (f1 == null) {
      f1 = this.g;
      if (f1 == null)
        return false; 
    } 
    return f1.L();
  }
  
  protected void onDetachedFromWindow() {
    try {
      super.onDetachedFromWindow();
      GDTLogger.d("onDetachedFromWindow");
      if (this.S != null)
        this.S.c(); 
      if (this.p != null)
        this.p.setImageBitmap((Bitmap)null); 
      if (this.r != null && !this.r.isRecycled()) {
        this.r.recycle();
        this.r = null;
      } 
      if (this.q != null) {
        this.q.clearAnimation();
        this.q.l();
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error during onDetachedFromWindow: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
    } 
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    super.onVisibilityChanged(paramView, paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("开屏容器可见性发生改变:");
    stringBuilder.append(paramInt);
    GDTLogger.d(stringBuilder.toString());
    a a1 = this.N;
    if (paramInt == 0) {
      if (a1 == a.c && !this.q.c()) {
        GDTLogger.d("播放容器可见，播放视频");
        this.q.b();
        return;
      } 
    } else if (a1 == a.c && this.q.c()) {
      GDTLogger.d("播放容器不可见，暂停视频");
      this.q.a();
    } 
  }
  
  public void preload() {
    if (l.a(getContext()))
      b.a().b(); 
    int i = l.b(this.b);
    com.qq.e.comm.plugin.u.b.a().a(e.d, this.a, this.b, this.c, this.f, this.w, i);
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.o = paramADListener;
  }
  
  public void setAdLogoMargin(int paramInt1, int paramInt2) {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void setFetchDelay(int paramInt) {
    String str;
    if (paramInt == 0) {
      GDTLogger.d("开屏超时时长已设为默认值");
      return;
    } 
    if (paramInt < 2000) {
      i.a(2000);
      str = "开屏超时时长取值范围为[2000, 5000]，已将超时时长设为2000ms。";
    } else if (paramInt > 5000) {
      i.a(5000);
      str = "开屏超时时长取值范围为[2000, 5000]，已将超时时长设为5000ms。";
    } else {
      i.a(paramInt);
      return;
    } 
    GDTLogger.w(str, null);
  }
  
  public void setFloatView(View paramView) {
    if (paramView == null)
      return; 
    this.x = paramView;
    this.x.setId(6);
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.w = paramLoadAdParams;
    if (SDKStatus.getSDKVersionCode() >= 50)
      i.a(paramLoadAdParams.getWXAppId()); 
    this.d.a(paramLoadAdParams);
  }
  
  public void setPreloadView(View paramView) {
    if (paramView == null)
      return; 
    this.y = paramView;
  }
  
  public void setSkipView(View paramView) {
    if (paramView == null)
      return; 
    paramView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            k.b(b.d(this.a), b.e(this.a));
            b.a(this.a);
          }
        });
    this.m = paramView;
    k.a((Boolean)null, (q)null, this.e);
  }
  
  public void showAd(ViewGroup paramViewGroup) {
    boolean bool;
    if (paramViewGroup == null) {
      GDTLogger.e("Container param for showAd Method should not be null");
      return;
    } 
    k.a((Boolean)null, 0, this.e);
    if (this.g == null || !this.O.j()) {
      bool = true;
    } else if (this.C) {
      bool = true;
    } else if (SystemClock.elapsedRealtime() > this.g.ao() + this.D) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      k.a(Boolean.valueOf(false), bool, this.e);
      b(bool);
      return;
    } 
    this.l = paramViewGroup;
    this.E = true;
    s();
    this.C = true;
  }
  
  enum a {
    a, b, c;
  }
  
  enum b {
    a, b, c, d;
  }
  
  static class c extends LinearLayout {
    private TextView a;
    
    public c(Context param1Context) {
      super(param1Context);
      a(param1Context);
    }
    
    private void a(Context param1Context) {
      int i = am.a(param1Context, 20);
      int j = am.a(param1Context, 17);
      setBackgroundColor(1711276032);
      setPadding(i, 0, i, 0);
      this.a = new TextView(param1Context);
      this.a.setEllipsize(TextUtils.TruncateAt.END);
      this.a.setMaxLines(1);
      this.a.setTextColor(-1);
      this.a.setTextSize(2, 15.0F);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.gravity = 16;
      layoutParams.weight = 1.17549435E-38F;
      addView((View)this.a, (ViewGroup.LayoutParams)layoutParams);
      ImageView imageView = new ImageView(param1Context);
      layoutParams = new LinearLayout.LayoutParams(j, j);
      imageView.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAACIAAAAiCAYAAAA6RwvCAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAIqADAAQAAAABAAAAIgAAAAACeqFUAAAArklEQVRYCe2YzQmAMAyFiwfBQVzCs0M4ipM4jTia9RUa6CE9xdYILxAigcbXr4H+hGC0GOOc3FjGNhwCFvidfbdVM4yGgA1e2jdioGCEn6USfH8mZqIYra1AhWQ0MIFkVCxIkgzJ1AjU8n/omaMmvmk+k7kQxdIxYh2a/tVrccxc24/6Lk1FRN+zC0VIj5IESQgBiewJkhACEtETPq6cEOLmEu7jWSItEai88lDzALbxpaSUq9D9AAAAAElFTkSuQmCC"));
      layoutParams.gravity = 21;
      addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
    }
    
    public void a(String param1String) {
      if (param1String != null)
        this.a.setText(param1String); 
    }
  }
  
  class d implements View.OnClickListener {
    d(b this$0) {}
    
    public void onClick(View param1View) {
      if (!b.z(this.a).a())
        return; 
      GDTLogger.d("开屏onClick");
      int i = param1View.getId();
      switch (i) {
        default:
          return;
        case 2:
          k.b(b.d(this.a), b.e(this.a));
          b.a(this.a);
          return;
        case 1:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
          break;
      } 
      b.d(this.a, i);
      k.a(Boolean.valueOf(true), false, b.e(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */