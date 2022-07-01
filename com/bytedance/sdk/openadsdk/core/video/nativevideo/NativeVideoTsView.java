package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeVideoTsView extends FrameLayout implements c.a, f.a, ak.a {
  private AtomicBoolean A = new AtomicBoolean(false);
  
  protected final k a;
  
  protected c b;
  
  protected FrameLayout c;
  
  protected boolean d = true;
  
  protected RelativeLayout e;
  
  protected ImageView f;
  
  protected ImageView g;
  
  protected ImageView h;
  
  protected String i = "embeded_ad";
  
  protected int j = 50;
  
  AtomicBoolean k = new AtomicBoolean(false);
  
  boolean l = false;
  
  public a m;
  
  private final Context n;
  
  private ViewGroup o;
  
  private boolean p = true;
  
  private boolean q = false;
  
  private boolean r = true;
  
  private long s;
  
  private final ak t = new ak(this);
  
  private boolean u = false;
  
  private final String v = Build.MODEL;
  
  private ViewStub w;
  
  private c.b x;
  
  private final AtomicBoolean y = new AtomicBoolean(false);
  
  private boolean z = true;
  
  public NativeVideoTsView(Context paramContext, k paramk) {
    this(paramContext, paramk, false);
  }
  
  public NativeVideoTsView(Context paramContext, k paramk, boolean paramBoolean) {
    this(paramContext, paramk, paramBoolean, "embeded_ad");
  }
  
  public NativeVideoTsView(Context paramContext, k paramk, boolean paramBoolean, String paramString) {
    super(paramContext);
    this.i = paramString;
    this.n = paramContext;
    this.a = paramk;
    this.q = paramBoolean;
    setContentDescription("NativeVideoAdView");
    b();
    i();
  }
  
  private View a(Context paramContext) {
    FrameLayout frameLayout1 = new FrameLayout(paramContext);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
    frameLayout1.setId(ab.e(this.n, "tt_native_video_layout"));
    layoutParams2.gravity = 17;
    frameLayout1.setVisibility(8);
    this.o = (ViewGroup)frameLayout1;
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
    frameLayout2.setId(ab.e(this.n, "tt_native_video_frame"));
    layoutParams3.gravity = 17;
    frameLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    frameLayout1.addView((View)frameLayout2);
    this.c = frameLayout2;
    ViewStub viewStub = new ViewStub(paramContext);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    viewStub.setId(ab.e(this.n, "tt_native_video_img_cover_viewStub"));
    viewStub.setLayoutResource(ab.f(this.n, "tt_native_video_img_cover_layout"));
    viewStub.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    frameLayout1.addView((View)viewStub);
    this.w = viewStub;
    return (View)frameLayout1;
  }
  
  private void c(boolean paramBoolean) {
    if (this.a != null) {
      if (this.b == null)
        return; 
      boolean bool = q();
      r();
      if (bool && this.b.v()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("changeVideoStatus---isFromDetailPage()=");
        stringBuilder.append(bool);
        stringBuilder.append("，mNativeVideoController.isPlayComplete()=");
        stringBuilder.append(this.b.v());
        t.b("NativeVideoAdView", stringBuilder.toString());
        b(true);
        d();
        return;
      } 
      if (paramBoolean && !this.b.v() && !this.b.s()) {
        if (this.b.t() != null && this.b.t().i()) {
          if (this.p) {
            if ("ALP-AL00".equals(this.v)) {
              this.b.j();
            } else {
              ((f)this.b).g(bool);
            } 
            c.b b1 = this.x;
            if (b1 != null) {
              b1.c();
              return;
            } 
          } 
        } else if (this.p && this.b.t() == null) {
          if (!this.y.get())
            this.y.set(true); 
          this.A.set(false);
          m();
          return;
        } 
      } else if (this.b.t() != null && this.b.t().g()) {
        this.b.h();
        c.b b1 = this.x;
        if (b1 != null)
          b1.d(); 
      } 
    } 
  }
  
  private void d() {
    a(0L, 0);
    this.x = null;
  }
  
  private void i() {
    addView(a(this.n));
    k();
  }
  
  private void j() {
    if (this instanceof NativeDrawVideoTsView && !this.k.get() && h.c().s() != null) {
      this.h.setImageBitmap(h.c().s());
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
      int i = (int)ai.a(getContext(), this.j);
      layoutParams.width = i;
      layoutParams.height = i;
      this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.k.set(true);
    } 
  }
  
  private void k() {
    this.b = new f(this.n, (ViewGroup)this.c, this.a, this.i, v() ^ true);
    l();
    this.o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            ((f)this.a.b).a(NativeVideoTsView.a(this.a).getWidth(), NativeVideoTsView.a(this.a).getHeight());
            NativeVideoTsView.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        });
  }
  
  private void l() {
    c c1 = this.b;
    if (c1 == null)
      return; 
    c1.e(this.p);
    ((f)this.b).a(this);
    this.b.a(this);
  }
  
  private void m() {
    c c1 = this.b;
    if (c1 == null) {
      k();
    } else if (c1 instanceof f && !v()) {
      ((f)this.b).x();
    } 
    if (this.b != null && this.y.get()) {
      this.y.set(false);
      b();
      if (g()) {
        ai.a((View)this.e, 8);
        ImageView imageView = this.g;
        if (imageView != null)
          ai.a((View)imageView, 8); 
        this.b.a(this.a.z().g(), this.a.M(), this.o.getWidth(), this.o.getHeight(), null, this.a.P(), 0L, u());
        this.b.d(false);
        return;
      } 
      if (this.b.v()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("attachTask-mNativeVideoController.isPlayComplete()=");
        stringBuilder.append(this.b.v());
        t.b("NativeVideoAdView", stringBuilder.toString());
        b(true);
        return;
      } 
      t.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
      f();
      ai.a((View)this.e, 0);
    } 
  }
  
  private void n() {
    this.m = null;
    h();
    o();
  }
  
  private void o() {
    if (!this.y.get()) {
      this.y.set(true);
      c c1 = this.b;
      if (c1 != null)
        c1.a(true); 
    } 
    this.A.set(false);
  }
  
  private void p() {
    c(y.a((View)this, 50, 5));
    this.t.sendEmptyMessageDelayed(1, 500L);
  }
  
  private boolean q() {
    boolean bool1 = v();
    boolean bool = false;
    if (bool1)
      return false; 
    bool1 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || bool1)
      bool = true; 
    return bool;
  }
  
  private void r() {
    if (v())
      return; 
    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.valueOf(false));
    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", Boolean.valueOf(false));
  }
  
  private void s() {
    boolean bool;
    if (this.b == null || v() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      return; 
    boolean bool1 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
    long l1 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0L);
    long l2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.b.o());
    long l3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.b.r());
    this.b.d(bool1);
    this.b.a(l1);
    this.b.b(l2);
    this.b.c(l3);
    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.valueOf(false));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResumeFeedNativeVideoControllerData-isComplete=");
    stringBuilder.append(bool1);
    stringBuilder.append(",position=");
    stringBuilder.append(l1);
    stringBuilder.append(",totalPlayDuration=");
    stringBuilder.append(l2);
    stringBuilder.append(",duration=");
    stringBuilder.append(l3);
    t.e("MultiProcess", stringBuilder.toString());
  }
  
  private boolean t() {
    int i = ah.d(this.a.P());
    return (2 == o.h().c(i));
  }
  
  private boolean u() {
    return this.d;
  }
  
  private boolean v() {
    return this.q;
  }
  
  private void w() {
    ai.d((View)this.g);
    ai.d((View)this.e);
  }
  
  public void a() {}
  
  public void a(int paramInt) {
    b();
  }
  
  public void a(long paramLong, int paramInt) {
    c.b b1 = this.x;
    if (b1 != null)
      b1.d_(); 
  }
  
  public void a(long paramLong1, long paramLong2) {
    c.b b1 = this.x;
    if (b1 != null)
      b1.a(paramLong1, paramLong2); 
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what != 1)
      return; 
    p();
  }
  
  protected void a(boolean paramBoolean) {
    if (this.g == null) {
      this.g = new ImageView(getContext());
      if (h.c().s() != null) {
        this.g.setImageBitmap(h.c().s());
      } else {
        this.g.setImageResource(ab.d(o.a(), "tt_new_play_video"));
      } 
      this.g.setScaleType(ImageView.ScaleType.FIT_XY);
      int i = (int)ai.a(getContext(), this.j);
      int j = (int)ai.a(getContext(), 10.0F);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
      layoutParams.gravity = 17;
      layoutParams.rightMargin = j;
      layoutParams.bottomMargin = j;
      this.o.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (paramBoolean) {
      this.g.setVisibility(0);
      return;
    } 
    this.g.setVisibility(8);
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
    this.o.setVisibility(0);
    if (this.b == null) {
      this.b = new f(this.n, (ViewGroup)this.c, this.a, this.i);
      l();
    } 
    this.s = paramLong;
    if (v()) {
      this.b.b(false);
      boolean bool = this.b.a(this.a.z().g(), this.a.M(), this.o.getWidth(), this.o.getHeight(), null, this.a.P(), paramLong, u());
      int i = paramLong cmp 0L;
      if ((i > 0 && !paramBoolean1 && !paramBoolean2) || (i > 0 && paramBoolean1)) {
        c c1 = this.b;
        if (c1 != null) {
          paramLong = c1.o();
          i = this.b.q();
        } else {
          paramLong = 0L;
          i = 0;
        } 
        Map map = ah.a(this.a, this.b.n(), this.b.t());
        d.a(this.n, this.a, this.i, "feed_continue", paramLong, i, map);
      } 
      return bool;
    } 
    return true;
  }
  
  public void b() {
    k k1 = this.a;
    if (k1 == null)
      return; 
    int i = ah.d(k1.P());
    int j = o.h().c(i);
    if (j != 1) {
      if (j != 2) {
        if (j != 3) {
          if (j == 4)
            this.l = true; 
        } else {
          this.p = false;
        } 
      } else {
        boolean bool;
        if (w.e(this.n) || w.d(this.n)) {
          bool = true;
        } else {
          bool = false;
        } 
        this.p = bool;
      } 
    } else {
      this.p = w.d(this.n);
    } 
    if (!this.q) {
      this.d = o.h().a(i);
    } else {
      this.d = false;
    } 
    if ("splash_ad".equals(this.i)) {
      this.p = true;
      this.d = true;
    } 
    c c1 = this.b;
    if (c1 != null)
      c1.e(this.p); 
  }
  
  public void b(long paramLong, int paramInt) {}
  
  public void b(boolean paramBoolean) {
    c c1 = this.b;
    if (c1 != null) {
      c1.d(paramBoolean);
      h h = this.b.u();
      if (h != null) {
        h.w();
        View view = h.s();
        if (view != null) {
          if (view.getParent() != null)
            ((ViewGroup)view.getParent()).removeView(view); 
          view.setVisibility(0);
          addView(view);
          h.a(this.a, new WeakReference<Context>(this.n), false);
        } 
      } 
    } 
  }
  
  public void c() {
    if (w.c(o.a()) == 0)
      return; 
    if (this.b.t() != null) {
      if (this.b.t().g()) {
        c(false);
        ak ak1 = this.t;
        if (ak1 != null)
          ak1.removeMessages(1); 
        a(true);
        return;
      } 
      if (this.b.t().i()) {
        c(true);
        ak ak1 = this.t;
        if (ak1 != null)
          ak1.sendEmptyMessageDelayed(1, 500L); 
        a(false);
        return;
      } 
    } 
    if (!g() && !this.A.get()) {
      this.A.set(true);
      w();
      this.b.a(this.a.z().g(), this.a.M(), this.o.getWidth(), this.o.getHeight(), null, this.a.P(), this.s, u());
      ak ak1 = this.t;
      if (ak1 != null)
        ak1.sendEmptyMessageDelayed(1, 500L); 
      a(false);
    } 
  }
  
  public void e() {
    c.b b1 = this.x;
    if (b1 != null)
      b1.e(); 
  }
  
  public void f() {
    if (this.n != null) {
      ViewStub viewStub = this.w;
      if (viewStub != null && viewStub.getParent() != null && this.a != null) {
        if (this.e != null)
          return; 
        this.e = (RelativeLayout)this.w.inflate();
        if (this.a.z() != null && this.a.z().f() != null)
          e.a(this.n).a(this.a.z().f(), this.f); 
        this.f = (ImageView)findViewById(ab.e(this.n, "tt_native_video_img_id"));
        this.h = (ImageView)findViewById(ab.e(this.n, "tt_native_video_play"));
        j();
      } 
    } 
  }
  
  public boolean g() {
    return this.p;
  }
  
  public c getNativeVideoController() {
    return this.b;
  }
  
  public void h() {
    c c1 = this.b;
    if (c1 != null) {
      h h = c1.u();
      if (h != null) {
        h.e();
        View view = h.s();
        if (view != null) {
          view.setVisibility(8);
          if (view.getParent() != null)
            ((ViewGroup)view.getParent()).removeView(view); 
        } 
      } 
    } 
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    m();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    n();
  }
  
  public void onFinishTemporaryDetach() {
    super.onFinishTemporaryDetach();
    m();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.q) {
      a a1 = this.m;
      if (a1 != null) {
        c c1 = this.b;
        if (c1 != null)
          a1.a(c1.v(), this.b.r(), this.b.o(), this.b.m(), this.p); 
      } 
    } 
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onStartTemporaryDetach() {
    super.onStartTemporaryDetach();
    n();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    s();
    if (q()) {
      c c1 = this.b;
      if (c1 != null && c1.v()) {
        r();
        ai.a((View)this.e, 8);
        b(true);
        d();
        return;
      } 
    } 
    b();
    if (!v() && g()) {
      c c1 = this.b;
      if (c1 != null && !c1.s()) {
        if (this.t != null) {
          if (paramBoolean) {
            c1 = this.b;
            if (c1 != null && !c1.v()) {
              this.t.obtainMessage(1).sendToTarget();
              return;
            } 
          } 
          this.t.removeMessages(1);
          c(false);
        } 
        return;
      } 
    } 
    if (!g()) {
      if (!paramBoolean) {
        c c1 = this.b;
        if (c1 != null && c1.t() != null && this.b.t().g()) {
          this.t.removeMessages(1);
          c(false);
          return;
        } 
      } 
      if (paramBoolean)
        this.t.obtainMessage(1).sendToTarget(); 
    } 
  }
  
  public void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    s();
    if (this.z) {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.z = bool;
    } 
    if (q()) {
      c c1 = this.b;
      if (c1 != null && c1.v()) {
        r();
        ai.a((View)this.e, 8);
        b(true);
        d();
        return;
      } 
    } 
    b();
    if (!v() && g()) {
      c c1 = this.b;
      if (c1 != null) {
        if (c1.s())
          return; 
        if (this.r) {
          this.b.a(this.a.z().g(), this.a.M(), this.o.getWidth(), this.o.getHeight(), null, this.a.P(), this.s, u());
          this.r = false;
          ai.a((View)this.e, 8);
        } 
        if (paramInt == 0 && this.t != null) {
          c1 = this.b;
          if (c1 != null && !c1.v())
            this.t.obtainMessage(1).sendToTarget(); 
        } 
      } 
    } 
  }
  
  public void setControllerStatusCallBack(a parama) {
    this.m = parama;
  }
  
  public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener paramDrawVideoListener) {
    c c1 = this.b;
    if (c1 != null)
      ((f)c1).a(paramDrawVideoListener); 
  }
  
  public void setIsAutoPlay(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield u : Z
    //   4: ifeq -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield a : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   12: invokevirtual P : ()Ljava/lang/String;
    //   15: invokestatic d : (Ljava/lang/String;)I
    //   18: istore_2
    //   19: invokestatic h : ()Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   22: iload_2
    //   23: invokevirtual c : (I)I
    //   26: istore_2
    //   27: iload_1
    //   28: istore_3
    //   29: iload_1
    //   30: ifeq -> 76
    //   33: iload_1
    //   34: istore_3
    //   35: iload_2
    //   36: iconst_4
    //   37: if_icmpeq -> 76
    //   40: aload_0
    //   41: getfield n : Landroid/content/Context;
    //   44: invokestatic e : (Landroid/content/Context;)Z
    //   47: ifeq -> 62
    //   50: iload_1
    //   51: istore_3
    //   52: aload_0
    //   53: invokespecial t : ()Z
    //   56: ifne -> 76
    //   59: goto -> 74
    //   62: iload_1
    //   63: istore_3
    //   64: aload_0
    //   65: getfield n : Landroid/content/Context;
    //   68: invokestatic d : (Landroid/content/Context;)Z
    //   71: ifne -> 76
    //   74: iconst_0
    //   75: istore_3
    //   76: aload_0
    //   77: iload_3
    //   78: putfield p : Z
    //   81: aload_0
    //   82: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c;
    //   85: astore #4
    //   87: aload #4
    //   89: ifnull -> 103
    //   92: aload #4
    //   94: aload_0
    //   95: getfield p : Z
    //   98: invokeinterface e : (Z)V
    //   103: aload_0
    //   104: getfield p : Z
    //   107: ifne -> 158
    //   110: aload_0
    //   111: invokevirtual f : ()V
    //   114: aload_0
    //   115: getfield e : Landroid/widget/RelativeLayout;
    //   118: astore #4
    //   120: aload #4
    //   122: ifnull -> 167
    //   125: aload #4
    //   127: iconst_0
    //   128: invokestatic a : (Landroid/view/View;I)V
    //   131: aload_0
    //   132: getfield n : Landroid/content/Context;
    //   135: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/g/e;
    //   138: aload_0
    //   139: getfield a : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   142: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   145: invokevirtual f : ()Ljava/lang/String;
    //   148: aload_0
    //   149: getfield f : Landroid/widget/ImageView;
    //   152: invokevirtual a : (Ljava/lang/String;Landroid/widget/ImageView;)V
    //   155: goto -> 167
    //   158: aload_0
    //   159: getfield e : Landroid/widget/RelativeLayout;
    //   162: bipush #8
    //   164: invokestatic a : (Landroid/view/View;I)V
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield u : Z
    //   172: return
  }
  
  public void setIsQuiet(boolean paramBoolean) {
    this.d = paramBoolean;
    c c1 = this.b;
    if (c1 != null)
      c1.c(paramBoolean); 
  }
  
  public void setNativeVideoAdListener(c.a parama) {
    c c1 = this.b;
    if (c1 != null)
      c1.a(parama); 
  }
  
  public void setNativeVideoController(c paramc) {
    this.b = paramc;
  }
  
  public void setVideoAdInteractionListener(c.b paramb) {
    this.x = paramb;
  }
  
  public void setVideoAdLoadListener(c.c paramc) {
    c c1 = this.b;
    if (c1 != null)
      c1.a(paramc); 
  }
  
  public void setVisibility(int paramInt) {
    super.setVisibility(paramInt);
    if (paramInt == 4 || paramInt == 8)
      o(); 
  }
  
  public static interface a {
    void a(boolean param1Boolean1, long param1Long1, long param1Long2, long param1Long3, boolean param1Boolean2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\nativevideo\NativeVideoTsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */