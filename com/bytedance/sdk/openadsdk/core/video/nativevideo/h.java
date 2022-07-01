package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.d.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.video.renderview.a;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class h implements b, a, d.a, e.b, ak.a {
  e A;
  
  d B;
  
  boolean C = true;
  
  a D;
  
  c E;
  
  a F;
  
  a G;
  
  TTDrawFeedAd.DrawVideoListener H;
  
  boolean I = true;
  
  private View J;
  
  private TextView K;
  
  private TextView L;
  
  private final String M = Build.MODEL;
  
  View a;
  
  b b;
  
  ImageView c;
  
  View d;
  
  View e;
  
  ImageView f;
  
  ViewStub g;
  
  View h;
  
  ImageView i;
  
  View j;
  
  RoundImageView k;
  
  TextView l;
  
  TextView m;
  
  TextView n;
  
  ProgressBar o;
  
  ViewStub p;
  
  int q;
  
  int r;
  
  int s;
  
  int t;
  
  boolean u = true;
  
  boolean v;
  
  int w;
  
  EnumSet<b.a> x;
  
  k y;
  
  Context z;
  
  public h(Context paramContext, View paramView, boolean paramBoolean, EnumSet<b.a> paramEnumSet, k paramk, c paramc) {
    this(paramContext, paramView, paramBoolean, paramEnumSet, paramk, paramc, true);
  }
  
  public h(Context paramContext, View paramView, boolean paramBoolean1, EnumSet<b.a> paramEnumSet, k paramk, c paramc, boolean paramBoolean2) {
    if (this instanceof g)
      return; 
    this.z = o.a().getApplicationContext();
    c(paramBoolean2);
    this.a = paramView;
    this.u = paramBoolean1;
    EnumSet<b.a> enumSet = paramEnumSet;
    if (paramEnumSet == null)
      enumSet = EnumSet.noneOf(b.a.class); 
    this.x = enumSet;
    this.E = paramc;
    this.y = paramk;
    c(8);
    a(paramContext, this.a);
    a();
    n();
  }
  
  private boolean A() {
    return ("C8817D".equals(this.M) || "M5".equals(this.M) || "R7t".equals(this.M));
  }
  
  private void b(View paramView, Context paramContext) {
    if (paramView != null && paramContext != null) {
      ViewStub viewStub = this.p;
      if (viewStub != null && viewStub.getParent() != null) {
        if (this.J != null)
          return; 
        this.p.inflate();
        this.J = paramView.findViewById(ab.e(paramContext, "tt_video_ad_cover_center_layout_draw"));
        this.K = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_button_draw"));
        this.L = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_replay"));
      } 
    } 
  }
  
  private int e(int paramInt) {
    if (this.s <= 0 || this.t <= 0)
      return 0; 
    int m = this.z.getResources().getDimensionPixelSize(ab.h(this.z, "tt_video_container_maxheight"));
    int i = this.z.getResources().getDimensionPixelSize(ab.h(this.z, "tt_video_container_minheight"));
    float f = paramInt * 1.0F / this.s;
    int j = (int)(this.t * f);
    if (j > m)
      return m; 
    paramInt = j;
    if (j < i)
      paramInt = i; 
    return paramInt;
  }
  
  private void f(int paramInt) {
    ai.a(this.j, paramInt);
    ai.a(this.J, paramInt);
  }
  
  private boolean y() {
    k k1 = this.y;
    null = true;
    if (k1 != null && k1.e() == 1)
      if (this.y.Q() != 5) {
        if (this.y.Q() == 15)
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  private void z() {
    Context context = this.z;
    if (context != null) {
      if (this.a == null)
        return; 
      View view1 = new View(this, context) {
          private final AtomicBoolean b = new AtomicBoolean(true);
          
          private void a() {
            if (this.b.getAndSet(false) && this.a.D != null)
              this.a.D.a(); 
          }
          
          private void b() {
            if (!this.b.getAndSet(true) && this.a.D != null)
              this.a.D.d(); 
          }
          
          protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            a();
          }
          
          protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            b();
          }
          
          public void onFinishTemporaryDetach() {
            super.onFinishTemporaryDetach();
            a();
          }
          
          protected void onMeasure(int param1Int1, int param1Int2) {
            super.onMeasure(0, 0);
          }
          
          public void onStartTemporaryDetach() {
            super.onStartTemporaryDetach();
            b();
          }
          
          public void onWindowFocusChanged(boolean param1Boolean) {
            super.onWindowFocusChanged(param1Boolean);
            if (this.a.D != null) {
              if (param1Boolean) {
                this.a.D.b();
                return;
              } 
              this.a.D.c();
            } 
          }
        };
      View view2 = this.a;
      if (view2 instanceof ViewGroup)
        ((ViewGroup)view2).addView(view1, 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(0, 0)); 
    } 
  }
  
  void a() {
    this.b.a(this);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.r()) {
              if (this.a.n != null && this.a.n.getVisibility() == 0)
                return; 
              this.a.B.a(this.a, param1View);
            } 
          }
        });
  }
  
  public void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSeekProgress-percent=");
    stringBuilder.append(paramInt);
    t.c("Progress", stringBuilder.toString());
    ai.a((View)this.o, 0);
    this.o.setProgress(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {
    int i = paramInt1;
    if (paramInt1 == -1)
      i = ai.c(this.z); 
    if (i <= 0)
      return; 
    this.q = i;
    if (i() || h() || this.x.contains(b.a.d)) {
      this.r = paramInt2;
    } else {
      this.r = e(i);
    } 
    b(this.q, this.r);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  void a(Context paramContext, View paramView) {
    SSRenderSurfaceView sSRenderSurfaceView;
    long l = System.currentTimeMillis();
    String str = ah.a(paramContext);
    if (str == null)
      str = "0"; 
    int i = Integer.valueOf(str).intValue();
    if (Build.VERSION.SDK_INT != 20 || i >= 1572864) {
      i = 1;
    } else {
      i = 0;
    } 
    if (!A() && i != 0 && com.bytedance.sdk.openadsdk.core.h.c().r() && Build.VERSION.SDK_INT >= 14) {
      SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(this.z);
      t.b("NewLiveViewLayout", "use TextureView......");
    } else {
      sSRenderSurfaceView = new SSRenderSurfaceView(this.z);
      t.b("NewLiveViewLayout", "use SurfaceView......");
    } 
    if (paramView instanceof RelativeLayout) {
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(13);
      ((RelativeLayout)paramView).addView((View)sSRenderSurfaceView, 0, (ViewGroup.LayoutParams)layoutParams);
    } 
    ai.a((View)sSRenderSurfaceView, 8);
    this.b = (b)sSRenderSurfaceView;
    this.c = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_play"));
    this.o = (ProgressBar)paramView.findViewById(ab.e(paramContext, "tt_video_progress"));
    this.d = paramView.findViewById(ab.e(paramContext, "tt_video_loading_retry_layout"));
    this.e = paramView.findViewById(ab.e(paramContext, "tt_video_loading_progress"));
    this.f = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_loading_cover_image"));
    this.g = (ViewStub)paramView.findViewById(ab.e(paramContext, "tt_video_ad_cover"));
    this.p = (ViewStub)paramView.findViewById(ab.e(paramContext, "tt_video_draw_layout_viewStub"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NativeVideoLayout**findViews use time :");
    stringBuilder.append(System.currentTimeMillis() - l);
    t.b("useTime", stringBuilder.toString());
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    this.v = true;
    if (r())
      this.B.a(this, paramSurfaceTexture); 
  }
  
  public void a(Message paramMessage) {}
  
  public void a(SurfaceHolder paramSurfaceHolder) {
    if (paramSurfaceHolder != this.b.getHolder())
      return; 
    this.v = true;
    if (r())
      this.B.a(this, paramSurfaceHolder); 
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
    if (paramSurfaceHolder != this.b.getHolder())
      return; 
    if (r())
      this.B.a(this, paramSurfaceHolder, paramInt1, paramInt2, paramInt3); 
  }
  
  void a(View paramView, Context paramContext) {
    if (paramView != null && paramContext != null) {
      ViewStub viewStub = this.g;
      if (viewStub != null && viewStub.getParent() != null) {
        if (this.h != null)
          return; 
        this.h = this.g.inflate();
        this.i = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_finish_cover_image"));
        this.j = paramView.findViewById(ab.e(paramContext, "tt_video_ad_cover_center_layout"));
        this.k = (RoundImageView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_logo_image"));
        this.l = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_btn_ad_image_tv"));
        this.m = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_name"));
        this.n = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_button"));
      } 
    } 
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(TTDrawFeedAd.DrawVideoListener paramDrawVideoListener) {
    this.H = paramDrawVideoListener;
    a a1 = this.F;
    if (a1 != null)
      a1.a(paramDrawVideoListener); 
  }
  
  public void a(k paramk, WeakReference<Context> paramWeakReference, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_0
    //   6: iconst_0
    //   7: aload_0
    //   8: getfield u : Z
    //   11: invokevirtual a : (ZZ)V
    //   14: aload_0
    //   15: aload_0
    //   16: getfield a : Landroid/view/View;
    //   19: invokestatic a : ()Landroid/content/Context;
    //   22: invokevirtual a : (Landroid/view/View;Landroid/content/Context;)V
    //   25: aload_0
    //   26: getfield h : Landroid/view/View;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull -> 39
    //   34: aload_2
    //   35: iconst_0
    //   36: invokestatic a : (Landroid/view/View;I)V
    //   39: aload_0
    //   40: getfield i : Landroid/widget/ImageView;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull -> 53
    //   48: aload_2
    //   49: iconst_0
    //   50: invokestatic a : (Landroid/view/View;I)V
    //   53: aload_0
    //   54: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   57: invokestatic a : (Lcom/bytedance/sdk/openadsdk/core/d/k;)Z
    //   60: ifeq -> 232
    //   63: aload_0
    //   64: aload_0
    //   65: getfield a : Landroid/view/View;
    //   68: invokestatic a : ()Landroid/content/Context;
    //   71: invokespecial b : (Landroid/view/View;Landroid/content/Context;)V
    //   74: aload_0
    //   75: getfield j : Landroid/view/View;
    //   78: bipush #8
    //   80: invokestatic a : (Landroid/view/View;I)V
    //   83: aload_0
    //   84: getfield i : Landroid/widget/ImageView;
    //   87: iconst_0
    //   88: invokestatic a : (Landroid/view/View;I)V
    //   91: aload_0
    //   92: getfield J : Landroid/view/View;
    //   95: iconst_0
    //   96: invokestatic a : (Landroid/view/View;I)V
    //   99: aload_0
    //   100: getfield K : Landroid/widget/TextView;
    //   103: iconst_0
    //   104: invokestatic a : (Landroid/view/View;I)V
    //   107: aload_0
    //   108: getfield L : Landroid/widget/TextView;
    //   111: iconst_0
    //   112: invokestatic a : (Landroid/view/View;I)V
    //   115: aload_0
    //   116: getfield L : Landroid/widget/TextView;
    //   119: ifnull -> 140
    //   122: invokestatic a : ()Landroid/content/Context;
    //   125: invokestatic c : (Landroid/content/Context;)I
    //   128: ifne -> 140
    //   131: aload_0
    //   132: getfield L : Landroid/widget/TextView;
    //   135: bipush #8
    //   137: invokestatic a : (Landroid/view/View;I)V
    //   140: aload_0
    //   141: getfield h : Landroid/view/View;
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull -> 161
    //   149: aload_2
    //   150: new com/bytedance/sdk/openadsdk/core/video/nativevideo/h$5
    //   153: dup
    //   154: aload_0
    //   155: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;)V
    //   158: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   161: aload_0
    //   162: getfield i : Landroid/widget/ImageView;
    //   165: ifnull -> 300
    //   168: aload_0
    //   169: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull -> 300
    //   177: aload_2
    //   178: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   181: ifnull -> 300
    //   184: aload_0
    //   185: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   188: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   191: invokevirtual f : ()Ljava/lang/String;
    //   194: ifnull -> 300
    //   197: aload_0
    //   198: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   201: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   204: invokevirtual d : ()D
    //   207: d2l
    //   208: aload_0
    //   209: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   212: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   215: invokevirtual g : ()Ljava/lang/String;
    //   218: new com/bytedance/sdk/openadsdk/core/video/nativevideo/h$6
    //   221: dup
    //   222: aload_0
    //   223: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;)V
    //   226: invokestatic a : (JLjava/lang/String;Lcom/bytedance/sdk/openadsdk/core/video/d/b$b;)V
    //   229: goto -> 300
    //   232: aload_0
    //   233: getfield j : Landroid/view/View;
    //   236: iconst_0
    //   237: invokestatic a : (Landroid/view/View;I)V
    //   240: aload_0
    //   241: getfield i : Landroid/widget/ImageView;
    //   244: ifnull -> 300
    //   247: aload_0
    //   248: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull -> 300
    //   256: aload_2
    //   257: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   260: ifnull -> 300
    //   263: aload_0
    //   264: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   267: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   270: invokevirtual f : ()Ljava/lang/String;
    //   273: ifnull -> 300
    //   276: aload_0
    //   277: getfield z : Landroid/content/Context;
    //   280: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/g/e;
    //   283: aload_0
    //   284: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   287: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   290: invokevirtual f : ()Ljava/lang/String;
    //   293: aload_0
    //   294: getfield i : Landroid/widget/ImageView;
    //   297: invokevirtual a : (Ljava/lang/String;Landroid/widget/ImageView;)V
    //   300: aload_1
    //   301: invokevirtual A : ()Ljava/lang/String;
    //   304: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   307: ifne -> 318
    //   310: aload_1
    //   311: invokevirtual A : ()Ljava/lang/String;
    //   314: astore_2
    //   315: goto -> 358
    //   318: aload_1
    //   319: invokevirtual J : ()Ljava/lang/String;
    //   322: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   325: ifne -> 336
    //   328: aload_1
    //   329: invokevirtual J : ()Ljava/lang/String;
    //   332: astore_2
    //   333: goto -> 358
    //   336: aload_1
    //   337: invokevirtual K : ()Ljava/lang/String;
    //   340: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   343: ifne -> 354
    //   346: aload_1
    //   347: invokevirtual K : ()Ljava/lang/String;
    //   350: astore_2
    //   351: goto -> 358
    //   354: ldc_w ''
    //   357: astore_2
    //   358: aload_0
    //   359: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   362: ifnull -> 494
    //   365: aload_0
    //   366: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   369: astore #5
    //   371: aload #5
    //   373: ifnull -> 494
    //   376: aload #5
    //   378: invokevirtual C : ()Lcom/bytedance/sdk/openadsdk/core/d/j;
    //   381: ifnull -> 494
    //   384: aload_0
    //   385: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   388: invokevirtual C : ()Lcom/bytedance/sdk/openadsdk/core/d/j;
    //   391: invokevirtual a : ()Ljava/lang/String;
    //   394: ifnull -> 494
    //   397: aload_0
    //   398: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   401: iconst_0
    //   402: invokestatic a : (Landroid/view/View;I)V
    //   405: aload_0
    //   406: getfield l : Landroid/widget/TextView;
    //   409: iconst_4
    //   410: invokestatic a : (Landroid/view/View;I)V
    //   413: aload_0
    //   414: getfield z : Landroid/content/Context;
    //   417: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/g/e;
    //   420: aload_0
    //   421: getfield y : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   424: invokevirtual C : ()Lcom/bytedance/sdk/openadsdk/core/d/j;
    //   427: invokevirtual a : ()Ljava/lang/String;
    //   430: aload_0
    //   431: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   434: invokevirtual a : (Ljava/lang/String;Landroid/widget/ImageView;)V
    //   437: aload_0
    //   438: invokespecial y : ()Z
    //   441: ifeq -> 469
    //   444: aload_0
    //   445: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   448: aload_0
    //   449: getfield G : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   452: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   455: aload_0
    //   456: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   459: aload_0
    //   460: getfield G : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   463: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   466: goto -> 593
    //   469: aload_0
    //   470: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   473: aload_0
    //   474: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   477: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   480: aload_0
    //   481: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   484: aload_0
    //   485: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   488: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   491: goto -> 593
    //   494: aload_2
    //   495: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   498: ifne -> 593
    //   501: aload_0
    //   502: getfield k : Lcom/bytedance/sdk/openadsdk/core/widget/RoundImageView;
    //   505: iconst_4
    //   506: invokestatic a : (Landroid/view/View;I)V
    //   509: aload_0
    //   510: getfield l : Landroid/widget/TextView;
    //   513: iconst_0
    //   514: invokestatic a : (Landroid/view/View;I)V
    //   517: aload_0
    //   518: getfield l : Landroid/widget/TextView;
    //   521: astore #5
    //   523: aload #5
    //   525: ifnull -> 593
    //   528: aload #5
    //   530: aload_2
    //   531: iconst_0
    //   532: iconst_1
    //   533: invokevirtual substring : (II)Ljava/lang/String;
    //   536: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   539: aload_0
    //   540: invokespecial y : ()Z
    //   543: ifeq -> 571
    //   546: aload_0
    //   547: getfield l : Landroid/widget/TextView;
    //   550: aload_0
    //   551: getfield G : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   554: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   557: aload_0
    //   558: getfield l : Landroid/widget/TextView;
    //   561: aload_0
    //   562: getfield G : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   565: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   568: goto -> 593
    //   571: aload_0
    //   572: getfield l : Landroid/widget/TextView;
    //   575: aload_0
    //   576: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   579: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   582: aload_0
    //   583: getfield l : Landroid/widget/TextView;
    //   586: aload_0
    //   587: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   590: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   593: aload_0
    //   594: getfield m : Landroid/widget/TextView;
    //   597: ifnull -> 615
    //   600: aload_2
    //   601: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   604: ifne -> 615
    //   607: aload_0
    //   608: getfield m : Landroid/widget/TextView;
    //   611: aload_2
    //   612: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   615: aload_0
    //   616: getfield m : Landroid/widget/TextView;
    //   619: iconst_0
    //   620: invokestatic a : (Landroid/view/View;I)V
    //   623: aload_0
    //   624: getfield n : Landroid/widget/TextView;
    //   627: iconst_0
    //   628: invokestatic a : (Landroid/view/View;I)V
    //   631: aload_1
    //   632: invokevirtual B : ()I
    //   635: istore #4
    //   637: iload #4
    //   639: iconst_2
    //   640: if_icmpeq -> 703
    //   643: iload #4
    //   645: iconst_3
    //   646: if_icmpeq -> 703
    //   649: iload #4
    //   651: iconst_4
    //   652: if_icmpeq -> 689
    //   655: iload #4
    //   657: iconst_5
    //   658: if_icmpeq -> 675
    //   661: aload_0
    //   662: getfield z : Landroid/content/Context;
    //   665: ldc_w 'tt_video_mobile_go_detail'
    //   668: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   671: astore_1
    //   672: goto -> 714
    //   675: aload_0
    //   676: getfield z : Landroid/content/Context;
    //   679: ldc_w 'tt_video_dial_phone'
    //   682: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   685: astore_1
    //   686: goto -> 714
    //   689: aload_0
    //   690: getfield z : Landroid/content/Context;
    //   693: ldc_w 'tt_video_download_apk'
    //   696: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   699: astore_1
    //   700: goto -> 714
    //   703: aload_0
    //   704: getfield z : Landroid/content/Context;
    //   707: ldc_w 'tt_video_mobile_go_detail'
    //   710: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   713: astore_1
    //   714: aload_0
    //   715: getfield n : Landroid/widget/TextView;
    //   718: astore_2
    //   719: aload_2
    //   720: ifnull -> 750
    //   723: aload_2
    //   724: aload_1
    //   725: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   728: aload_0
    //   729: getfield n : Landroid/widget/TextView;
    //   732: aload_0
    //   733: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   736: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   739: aload_0
    //   740: getfield n : Landroid/widget/TextView;
    //   743: aload_0
    //   744: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   747: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   750: aload_0
    //   751: getfield K : Landroid/widget/TextView;
    //   754: astore_2
    //   755: aload_2
    //   756: ifnull -> 786
    //   759: aload_2
    //   760: aload_1
    //   761: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   764: aload_0
    //   765: getfield K : Landroid/widget/TextView;
    //   768: aload_0
    //   769: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   772: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   775: aload_0
    //   776: getfield K : Landroid/widget/TextView;
    //   779: aload_0
    //   780: getfield F : Lcom/bytedance/sdk/openadsdk/core/a/a;
    //   783: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   786: aload_0
    //   787: getfield I : Z
    //   790: ifne -> 798
    //   793: aload_0
    //   794: iconst_4
    //   795: invokespecial f : (I)V
    //   798: return
  }
  
  public void a(a parama) {
    if (parama instanceof d) {
      this.B = (d)parama;
      p();
    } 
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    byte b1;
    ProgressBar progressBar = this.o;
    if (paramBoolean1) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    ai.a((View)progressBar, b1);
    ai.a((View)this.c, 8);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    ProgressBar progressBar = this.o;
    byte b1 = 0;
    ai.a((View)progressBar, 0);
    ImageView imageView = this.c;
    if (!paramBoolean1 || this.d.getVisibility() == 0)
      b1 = 8; 
    ai.a((View)imageView, b1);
  }
  
  public boolean a(int paramInt, r paramr) {
    e e1 = this.A;
    return (e1 == null || e1.a(paramInt, paramr));
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture) {
    this.v = false;
    if (r())
      this.B.b(this, paramSurfaceTexture); 
    return true;
  }
  
  public void b() {}
  
  public void b(int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
    if (paramInt1 == -1 || paramInt1 == -2 || paramInt1 > 0)
      layoutParams.width = paramInt1; 
    if (paramInt2 == -1 || paramInt2 == -2 || paramInt2 > 0)
      layoutParams.height = paramInt2; 
    this.a.setLayoutParams(layoutParams);
  }
  
  public void b(SurfaceTexture paramSurfaceTexture) {}
  
  public void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void b(SurfaceHolder paramSurfaceHolder) {
    if (paramSurfaceHolder != this.b.getHolder())
      return; 
    this.v = false;
    if (r())
      this.B.b(this, paramSurfaceHolder); 
  }
  
  public void b(ViewGroup paramViewGroup) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {
    ImageView imageView = this.c;
    if (imageView != null) {
      if (paramBoolean1) {
        imageView.setImageResource(ab.d(this.z, "tt_play_movebar_textpage"));
        return;
      } 
      imageView.setImageResource(ab.d(this.z, "tt_stop_movebar_textpage"));
    } 
  }
  
  public boolean b(int paramInt) {
    return false;
  }
  
  public void c() {}
  
  public void c(int paramInt) {
    this.w = paramInt;
    ai.a(this.a, paramInt);
  }
  
  public void c(int paramInt1, int paramInt2) {
    this.s = paramInt1;
    this.t = paramInt2;
  }
  
  public void c(ViewGroup paramViewGroup) {
    if (paramViewGroup == null)
      return; 
    if (this.a.getParent() != null)
      ((ViewGroup)this.a.getParent()).removeView(this.a); 
    paramViewGroup.addView(this.a);
    c(0);
  }
  
  public void c(boolean paramBoolean) {
    this.C = paramBoolean;
    if (this.C) {
      a a1 = this.F;
      if (a1 != null)
        a1.a(true); 
      a1 = this.G;
      if (a1 != null) {
        a1.a(true);
        return;
      } 
    } else {
      a a1 = this.F;
      if (a1 != null)
        a1.a(false); 
      a1 = this.G;
      if (a1 != null)
        a1.a(false); 
    } 
  }
  
  public void d() {
    ai.e(this.d);
    ai.e(this.e);
    if (this.f != null) {
      k k1 = this.y;
      if (k1 != null && k1.z() != null && this.y.z().f() != null) {
        ai.e((View)this.f);
        e.a(this.z).a(this.y.z().f(), this.f);
      } 
    } 
    if (this.c.getVisibility() == 0)
      ai.a((View)this.c, 8); 
  }
  
  public void d(int paramInt) {
    ai.a(this.a, 0);
    b b1 = this.b;
    if (b1 != null)
      b1.setVisibility(paramInt); 
  }
  
  public void d(boolean paramBoolean) {
    this.I = paramBoolean;
  }
  
  public void e() {
    a(false, this.u);
    v();
  }
  
  public void f() {
    ai.d(this.d);
  }
  
  public void g() {
    this.o.setProgress(0);
    this.o.setSecondaryProgress(0);
    c(8);
    if (x())
      this.b.setVisibility(8); 
    ImageView imageView = this.f;
    if (imageView != null)
      imageView.setImageDrawable(null); 
    c(8);
    ai.a(this.h, 8);
    ai.a((View)this.i, 8);
    ai.a(this.j, 8);
    ai.a((View)this.k, 8);
    ai.a((View)this.l, 8);
    ai.a((View)this.m, 8);
    e e1 = this.A;
    if (e1 != null)
      e1.a(true); 
  }
  
  public boolean h() {
    return false;
  }
  
  public boolean i() {
    return this.u;
  }
  
  public void j() {
    a(true, false);
  }
  
  public boolean k() {
    return this.v;
  }
  
  public void l() {}
  
  public boolean m() {
    e e1 = this.A;
    return (e1 != null && e1.a());
  }
  
  void n() {
    boolean bool;
    String str;
    if (this.C) {
      str = "embeded_ad";
    } else {
      str = "embeded_ad_landingpage";
    } 
    if (ah.a(this.y)) {
      if (this.C) {
        str = "draw_ad";
      } else {
        str = "draw_ad_landingpage";
      } 
      bool = true;
    } else if (ah.c(this.y)) {
      str = "rewarded_video";
      bool = true;
    } else if (ah.d(this.y)) {
      str = "fullscreen_interstitial_ad";
      bool = true;
    } else {
      bool = true;
    } 
    if (this.y.B() == 4) {
      this.D = a.a(this.z, this.y, str);
      this.D.a(2, new a.a(this) {
            public boolean a(int param1Int, k param1k, String param1String1, String param1String2, Object param1Object) {
              if (param1Int != 2)
                return true; 
              if (param1k != null && !TextUtils.isEmpty(param1String1)) {
                if (TextUtils.isEmpty(param1String2))
                  return true; 
                if (param1String2.equals("click_start_play")) {
                  String str;
                  if (this.a.C) {
                    str = "click_start";
                  } else {
                    str = "click_start_detail";
                  } 
                  d.a(this.a.z, this.a.y, param1String1, str, null);
                  return false;
                } 
                if (param1String2.equals("click_open")) {
                  if (this.a.C) {
                    d.q(this.a.z, this.a.y, param1String1, ah.f(this.a.y), null);
                    return false;
                  } 
                  d.p(this.a.z, this.a.y, param1String1, "click_open_detail", null);
                  return false;
                } 
              } 
              return true;
            }
          });
    } 
    z();
    this.F = new a(this.z, this.y, str, bool);
    this.F.b(true);
    if (this.C) {
      this.F.a(true);
    } else {
      this.F.a(false);
    } 
    this.F.a(this.E);
    this.F.c(true);
    a a1 = this.D;
    if (a1 != null) {
      a a2 = this.F;
      if (a2 != null)
        a2.a(a1); 
    } 
    if (y()) {
      this.G = new a(this, this.z, this.y, str, bool) {
          public boolean b() {
            boolean bool1;
            e e = this.a.A;
            boolean bool2 = false;
            if (e != null) {
              null = this.a.A.a();
            } else {
              null = false;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("isVisible=");
            stringBuilder.append(null);
            stringBuilder.append(",mPlayBtn.getVisibility() == VISIBLE->");
            if (this.a.c.getVisibility() == 0) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            stringBuilder.append(bool1);
            t.c("ClickCreativeListener", stringBuilder.toString());
            if (!null) {
              null = bool2;
              return (this.a.c.getVisibility() == 0) ? true : null;
            } 
            return true;
          }
          
          public boolean c() {
            return ((this.a.h != null && this.a.h.getVisibility() == 0) || (this.a.j != null && this.a.j.getVisibility() == 0) || (this.a.k != null && this.a.k.getVisibility() == 0) || (this.a.l != null && this.a.l.getVisibility() == 0));
          }
        };
      this.G.b(true);
      if (this.C) {
        this.G.a(true);
      } else {
        this.G.a(false);
      } 
      this.G.a(this.E);
      this.G.c(true);
      a a2 = this.D;
      if (a2 != null)
        this.G.a(a2); 
      View view = this.a;
      if (view != null) {
        view.setOnClickListener((View.OnClickListener)this.G);
        this.a.setOnTouchListener((View.OnTouchListener)this.G);
      } 
    } 
  }
  
  public b o() {
    return this.b;
  }
  
  void p() {
    if (this.B != null && this.A == null) {
      long l = System.currentTimeMillis();
      this.A = new e();
      this.A.a(this.z, this.a);
      this.A.a(this.B, this);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mVideoTrafficTipLayout use time :");
      stringBuilder.append(System.currentTimeMillis() - l);
      t.b("useTime", stringBuilder.toString());
    } 
  }
  
  public void q() {
    e e1 = this.A;
    if (e1 != null)
      e1.a(false); 
  }
  
  boolean r() {
    if (this.B == null) {
      t.e("NewLiveViewLayout", "callback is null");
      return false;
    } 
    return true;
  }
  
  public View s() {
    return this.a;
  }
  
  public void t() {
    ai.e(this.d);
    ai.e(this.e);
    if (this.c.getVisibility() == 0)
      ai.a((View)this.c, 8); 
  }
  
  public void u() {
    ai.a(this.a, 0);
    b b1 = this.b;
    if (b1 != null) {
      View view = b1.getView();
      if (view instanceof android.view.TextureView) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof ViewGroup) {
          ViewGroup viewGroup = (ViewGroup)viewParent;
          int i = viewGroup.indexOfChild(view);
          viewGroup.removeView(view);
          viewGroup.addView(view, i);
        } 
      } 
      ai.a(view, 8);
      ai.a(view, 0);
    } 
  }
  
  void v() {
    ai.a(this.h, 8);
    ai.a((View)this.i, 8);
    ai.a(this.j, 8);
    ai.a((View)this.k, 8);
    ai.a((View)this.l, 8);
    ai.a((View)this.m, 8);
    ai.a((View)this.n, 8);
  }
  
  public void w() {
    ai.d(this.d);
    ai.d(this.e);
    ImageView imageView = this.f;
    if (imageView != null)
      ai.d((View)imageView); 
  }
  
  boolean x() {
    return (!this.x.contains(b.a.c) || this.u);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\nativevideo\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */