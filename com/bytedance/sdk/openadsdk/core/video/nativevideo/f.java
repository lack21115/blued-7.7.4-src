package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f implements c, d, ak.a {
  private boolean A;
  
  private boolean B;
  
  private WeakReference<c.c> C;
  
  private WeakReference<a> D;
  
  private int E;
  
  private int F;
  
  private int G;
  
  private boolean H;
  
  private boolean I;
  
  private final Runnable J;
  
  private final Runnable K;
  
  private final Runnable L;
  
  private int M;
  
  private long N;
  
  private long O;
  
  private long P;
  
  private boolean Q;
  
  private long R;
  
  private final BroadcastReceiver S;
  
  private int T;
  
  private boolean U;
  
  Runnable a;
  
  private h b;
  
  private final WeakReference<ViewGroup> c;
  
  private final ak d = new ak(this);
  
  private long e = 0L;
  
  private long f = 0L;
  
  private d g;
  
  private c.a h;
  
  private long i = 0L;
  
  private long j = 0L;
  
  private long k;
  
  private List<Runnable> l;
  
  private boolean m;
  
  private final WeakReference<Context> n;
  
  private final boolean o;
  
  private boolean p;
  
  private boolean q;
  
  private final k r;
  
  private boolean s;
  
  private boolean t;
  
  private String u;
  
  private WeakReference<e> v;
  
  private long w;
  
  private boolean x;
  
  private boolean y;
  
  private boolean z;
  
  public f(Context paramContext, ViewGroup paramViewGroup, k paramk, String paramString) {
    boolean bool = false;
    this.p = false;
    this.q = false;
    this.s = true;
    this.t = false;
    this.u = "embeded_ad";
    this.w = 0L;
    this.x = false;
    this.y = false;
    this.z = false;
    this.A = false;
    this.B = true;
    this.E = 0;
    this.F = 0;
    this.G = 0;
    this.H = false;
    this.I = true;
    this.J = new Runnable(this) {
        public void run() {
          if (f.b(this.a) != null)
            f.b(this.a).e(); 
        }
      };
    this.K = new Runnable(this) {
        public void run() {
          if (f.h(this.a) != null)
            f.h(this.a).a(); 
        }
      };
    this.L = new Runnable(this) {
        public void run() {
          if (f.b(this.a) != null) {
            if (f.i(this.a) <= 0L)
              f.b(this.a).e(); 
            f.b(this.a).f();
          } 
          f.e(this.a).postDelayed(this, 200L);
        }
      };
    this.M = 0;
    this.N = 0L;
    this.a = new Runnable(this) {
        public void run() {
          if (f.a(this.a) != null) {
            f.a(this.a).a(f.j(this.a), f.k(this.a), false);
            f.a(this.a).w();
            this.a.d(true);
            t.e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
          } 
        }
      };
    this.O = 0L;
    this.P = 0L;
    this.Q = false;
    this.S = new BroadcastReceiver(this) {
        public void onReceive(Context param1Context, Intent param1Intent) {
          String str = param1Intent.getAction();
          if ("android.intent.action.SCREEN_OFF".equals(str)) {
            this.a.h();
            return;
          } 
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
            f.a(this.a, param1Context); 
        }
      };
    this.T = 1;
    this.U = false;
    this.T = w.c(paramContext);
    try {
      this.E = paramViewGroup.getWidth();
      this.F = paramViewGroup.getHeight();
    } finally {
      Exception exception;
    } 
    this.c = new WeakReference<ViewGroup>(paramViewGroup);
    this.u = paramString;
    this.n = new WeakReference<Context>(paramContext);
    this.r = paramk;
    b(paramContext);
    if (Build.VERSION.SDK_INT >= 17)
      bool = true; 
    this.o = bool;
  }
  
  public f(Context paramContext, ViewGroup paramViewGroup, k paramk, String paramString, boolean paramBoolean) {
    boolean bool = false;
    this.p = false;
    this.q = false;
    this.s = true;
    this.t = false;
    this.u = "embeded_ad";
    this.w = 0L;
    this.x = false;
    this.y = false;
    this.z = false;
    this.A = false;
    this.B = true;
    this.E = 0;
    this.F = 0;
    this.G = 0;
    this.H = false;
    this.I = true;
    this.J = new Runnable(this) {
        public void run() {
          if (f.b(this.a) != null)
            f.b(this.a).e(); 
        }
      };
    this.K = new Runnable(this) {
        public void run() {
          if (f.h(this.a) != null)
            f.h(this.a).a(); 
        }
      };
    this.L = new Runnable(this) {
        public void run() {
          if (f.b(this.a) != null) {
            if (f.i(this.a) <= 0L)
              f.b(this.a).e(); 
            f.b(this.a).f();
          } 
          f.e(this.a).postDelayed(this, 200L);
        }
      };
    this.M = 0;
    this.N = 0L;
    this.a = new Runnable(this) {
        public void run() {
          if (f.a(this.a) != null) {
            f.a(this.a).a(f.j(this.a), f.k(this.a), false);
            f.a(this.a).w();
            this.a.d(true);
            t.e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
          } 
        }
      };
    this.O = 0L;
    this.P = 0L;
    this.Q = false;
    this.S = new BroadcastReceiver(this) {
        public void onReceive(Context param1Context, Intent param1Intent) {
          String str = param1Intent.getAction();
          if ("android.intent.action.SCREEN_OFF".equals(str)) {
            this.a.h();
            return;
          } 
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
            f.a(this.a, param1Context); 
        }
      };
    this.T = 1;
    this.U = false;
    this.T = w.c(paramContext);
    b(paramBoolean);
    this.u = paramString;
    try {
      this.E = paramViewGroup.getWidth();
      this.F = paramViewGroup.getHeight();
    } finally {}
    this.c = new WeakReference<ViewGroup>(paramViewGroup);
    this.n = new WeakReference<Context>(paramContext);
    this.r = paramk;
    b(paramContext);
    paramBoolean = bool;
    if (Build.VERSION.SDK_INT >= 17)
      paramBoolean = true; 
    this.o = paramBoolean;
  }
  
  private void A() {
    B();
    this.d.postDelayed(this.L, 800L);
  }
  
  private void B() {
    this.d.removeCallbacks(this.L);
  }
  
  private boolean C() {
    WeakReference<Context> weakReference = this.n;
    return (weakReference != null && weakReference.get() != null);
  }
  
  private void D() {
    List<Runnable> list = this.l;
    if (list != null) {
      if (list.isEmpty())
        return; 
      Iterator<?> iterator = (new ArrayList(this.l)).iterator();
      while (iterator.hasNext())
        ((Runnable)iterator.next()).run(); 
      this.l.clear();
    } 
  }
  
  private void E() {
    d d1 = this.g;
    if (d1 != null) {
      d1.a(false, this.i, this.t ^ true);
      A();
    } 
    if (this.p)
      d.a(this.n.get(), this.r, this.u, "feed_continue", o(), q(), c()); 
  }
  
  private void F() {
    this.P = SystemClock.elapsedRealtime() - this.O;
    if (!this.p) {
      Map map = ah.a(this.P, this.r, t());
      if (this.B) {
        d.j(this.n.get(), this.r, this.u, "feed_auto_play", map);
      } else if (this.i <= 0L) {
        d.j(this.n.get(), this.r, this.u, "feed_play", map);
      } 
      this.p = true;
    } 
  }
  
  private void G() {
    if (this.c.get() != null && !y.a((View)this.c.get(), 20, 0)) {
      t.e("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
      this.b.a(this.r, this.n, false);
      d(true);
      l();
    } 
  }
  
  private void H() {
    t.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
    if (this.c.get() != null && !y.a((View)this.c.get(), 20, 0)) {
      t.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
      d();
    } 
  }
  
  private void I() {
    t.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
    try {
      boolean bool1;
      WeakReference<Context> weakReference = this.n;
      Context context1 = null;
      Context context2 = null;
      boolean bool4 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      if (weakReference == null || this.n.get() == null || J() == null || this.g == null || this.g.a() == null) {
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("[step-1] >>>>> mContextRef=");
        stringBuilder5.append(this.n);
        stringBuilder5.append(",mContextRef.get()=");
        context1 = context2;
        if (this.n != null)
          context1 = this.n.get(); 
        stringBuilder5.append(context1);
        stringBuilder5.append(",getIRenderView() =");
        stringBuilder5.append(J());
        t.b("ChangeVideoSize", stringBuilder5.toString());
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("[step-1] >>>>> mMediaPlayerProxy == null:");
        if (this.g == null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        stringBuilder4.append(bool1);
        return;
      } 
      if ((((Context)this.n.get()).getResources().getConfiguration()).orientation == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("[step-2] >>>>> isVectical=");
      stringBuilder3.append(bool1);
      t.b("ChangeVideoSize", stringBuilder3.toString());
      float f2 = ai.c(this.n.get());
      float f1 = ai.d(this.n.get());
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("[step-3] >>>>> screenWidth=");
      stringBuilder3.append(f2);
      stringBuilder3.append(",screenHeight=");
      stringBuilder3.append(f1);
      t.b("ChangeVideoSize", stringBuilder3.toString());
      MediaPlayer mediaPlayer = this.g.a();
      float f3 = mediaPlayer.getVideoWidth();
      float f4 = mediaPlayer.getVideoHeight();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("[step-4] Get the videoWidth and videoHeight from mediaPlayer , videoHeight=");
      stringBuilder2.append(f4);
      stringBuilder2.append(",videoWidth=");
      stringBuilder2.append(f3);
      t.b("ChangeVideoSize", stringBuilder2.toString());
      int i = f3 cmp f4;
      if (i >= 0) {
        f1 = 0.0F;
        if (f4 > 0.0F && f3 > 0.0F) {
          RelativeLayout.LayoutParams layoutParams;
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("[step-5] >>  videoWidth < videoHeight ->value:>>");
          bool2 = bool3;
          if (i < 0)
            bool2 = true; 
          stringBuilder2.append(bool2);
          stringBuilder2.append(">>, if value is false: continue to perform ....");
          t.b("ChangeVideoSize", stringBuilder2.toString());
          if (bool1)
            f1 = f4 * f2 / f3; 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("[step-6] >>>>> vHeight = (videoHeight * screenWidth) / videoWidth --> calculate the adaptive height , vHeight=");
          stringBuilder2.append(f1);
          t.b("ChangeVideoSize", stringBuilder2.toString());
          if (Float.valueOf(f1).isNaN())
            return; 
          t.b("ChangeVideoSize", "[step-7]  >>>>> vHeight check pass !");
          if (bool1) {
            layoutParams = new RelativeLayout.LayoutParams((int)f2, (int)f1);
            layoutParams.addRule(13);
          } 
          if (layoutParams == null)
            return; 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("[step-8] >>>>> create LayoutParams finish ! >> screenWidth = ");
          stringBuilder2.append(f2);
          return;
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[step-5] >> (videoWidth < videoHeight || videoHeight <= 0 || videoWidth <= 0) ->value:>>");
      return;
    } finally {
      Exception exception = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[step-11] >>>>> changeVideoSize error !!!!! ：");
      stringBuilder.append(exception.toString());
      t.b("ChangeVideoSize", stringBuilder.toString());
    } 
  }
  
  private b J() {
    WeakReference<Context> weakReference = this.n;
    if (weakReference != null && weakReference.get() != null && (((Context)this.n.get()).getResources().getConfiguration()).orientation == 1) {
      h h1 = this.b;
      if (h1 != null)
        return h1.o(); 
    } 
    return null;
  }
  
  private void K() {
    if (!C())
      return; 
    h(this.Q ^ true);
    if (!(this.n.get() instanceof Activity)) {
      t.b("NativeVideoController", "context is not activity, not support this function.");
      return;
    } 
    h h1 = this.b;
    if (h1 != null) {
      h1.b(this.c.get());
      this.b.b(false);
    } 
    a(1);
    WeakReference<e> weakReference = this.v;
    if (weakReference != null) {
      e e = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (weakReference != null)
      weakReference.a(this.Q); 
  }
  
  private void L() {
    h h1 = this.b;
    if (h1 != null) {
      h1.c(0);
      this.b.a(false, false);
      this.b.b(false);
      this.b.b();
      this.b.d();
    } 
  }
  
  private void a(long paramLong1, long paramLong2) {
    this.i = paramLong1;
    this.k = paramLong2;
    this.b.a(paramLong1, paramLong2);
    int i = com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1, paramLong2);
    this.b.a(i);
    try {
      if (this.h != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  private void a(long paramLong, boolean paramBoolean) {
    if (this.g == null)
      return; 
    if (paramBoolean)
      L(); 
    this.g.a(paramLong);
  }
  
  private void a(Context paramContext, int paramInt) {
    if (!C())
      return; 
    if (paramContext == null)
      return; 
    if (this.T == paramInt)
      return; 
    this.T = paramInt;
    if (paramInt != 4 && paramInt != 0)
      this.y = false; 
    if (!this.y && !v())
      d(2); 
    WeakReference<a> weakReference = this.D;
    if (weakReference != null && weakReference.get() != null)
      ((a)this.D.get()).a(this.T); 
  }
  
  private void a(Runnable paramRunnable) {
    if (paramRunnable == null)
      return; 
    if (this.b.k() && this.m) {
      paramRunnable.run();
      return;
    } 
    b(paramRunnable);
  }
  
  private void a(String paramString) {
    t.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
    if (this.g != null) {
      com.bytedance.sdk.openadsdk.core.video.a.a a1 = new com.bytedance.sdk.openadsdk.core.video.a.a();
      a1.a = paramString;
      k k1 = this.r;
      if (k1 != null) {
        if (k1.z() != null)
          a1.d = this.r.z().j(); 
        a1.b = String.valueOf(ah.d(this.r.P()));
      } 
      a1.c = 0;
      this.g.a(a1);
      t.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
    } 
    this.e = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString)) {
      this.b.d(8);
      this.b.d(0);
      a(new Runnable(this) {
            public void run() {
              f.a(this.a, System.currentTimeMillis());
              f.a(this.a).c(0);
              if (f.b(this.a) != null && f.c(this.a) == 0L) {
                f.b(this.a).a(true, 0L, f.d(this.a) ^ true);
              } else if (f.b(this.a) != null) {
                f.b(this.a).a(true, f.c(this.a), f.d(this.a) ^ true);
              } 
              if (f.e(this.a) != null)
                f.e(this.a).postDelayed(f.f(this.a), 100L); 
              f.g(this.a);
            }
          });
    } 
    if (this.s)
      x(); 
  }
  
  private void b(int paramInt) {
    this.M++;
    if (!C())
      return; 
    h h1 = this.b;
    if (h1 == null)
      return; 
    h1.w();
    c.a a1 = this.h;
    if (a1 != null)
      a1.a(this.f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.i, this.k)); 
    this.f = System.currentTimeMillis() - this.e;
    if (!ah.a(this.r) || this.M >= 2)
      this.b.a(this.r, this.n, true); 
    if (!this.q) {
      d.a(this.n.get(), this.r, this.u, "feed_over", o(), 100, c());
      this.q = true;
      long l = this.k;
      a(l, l);
      l = this.k;
      this.i = l;
      this.j = l;
    } 
    if (!this.s && this.Q)
      e(this.b, null); 
    this.z = true;
    if (ah.a(this.r) && this.M < 2)
      g(); 
  }
  
  private void b(int paramInt1, int paramInt2) {
    String str;
    if (this.r == null)
      return; 
    boolean bool = f();
    if (bool) {
      str = "play_error";
    } else {
      str = "play_start_error";
    } 
    Map<String, Long> map = ah.a(this.r, paramInt1, paramInt2, t());
    if (bool) {
      map.put("duration", Long.valueOf(o()));
      map.put("percent", Integer.valueOf(q()));
      map.put("buffers_time", Long.valueOf(n()));
    } 
    d.k(this.n.get(), this.r, this.u, str, map);
  }
  
  private void b(Context paramContext) {
    View view;
    EnumSet<b.a> enumSet = EnumSet.noneOf(b.a.class);
    enumSet.add(b.a.a);
    enumSet.add(b.a.e);
    if (this.s) {
      view = c(paramContext);
    } else {
      view = LayoutInflater.from(paramContext.getApplicationContext()).inflate(ab.f(paramContext, "tt_video_detail_layout"), null, false);
    } 
    if (view == null)
      return; 
    if (this.s) {
      this.b = new h(paramContext, view, true, enumSet, this.r, this, a());
    } else {
      this.b = new g(paramContext, view, true, enumSet, this.r, this, false);
    } 
    this.b.a(this);
  }
  
  private void b(Runnable paramRunnable) {
    if (this.l == null)
      this.l = Collections.synchronizedList(new ArrayList<Runnable>()); 
    this.l.add(paramRunnable);
  }
  
  private View c(Context paramContext) {
    Resources resources = paramContext.getResources();
    RelativeLayout relativeLayout1 = new RelativeLayout(paramContext);
    relativeLayout1.setId(ab.e(paramContext, "tt_root_view"));
    relativeLayout1.setBackgroundColor(-16777216);
    RelativeLayout relativeLayout2 = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
    relativeLayout2.setId(ab.e(paramContext, "tt_video_loading_retry_layout"));
    relativeLayout2.setBackgroundColor(0);
    relativeLayout2.setGravity(17);
    relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    relativeLayout1.addView((View)relativeLayout2);
    ImageView imageView2 = new ImageView(paramContext);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
    imageView2.setId(ab.e(paramContext, "tt_video_loading_cover_image"));
    imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    imageView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    relativeLayout2.addView((View)imageView2);
    ProgressBar progressBar2 = new ProgressBar(paramContext);
    layoutParams5 = new RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 60.0F, resources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 60.0F, resources.getDisplayMetrics()));
    progressBar2.setId(ab.e(paramContext, "tt_video_loading_progress"));
    layoutParams5.addRule(13, -1);
    progressBar2.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    progressBar2.setIndeterminateDrawable(ab.c(paramContext, "tt_video_loading_progress_bar"));
    relativeLayout2.addView((View)progressBar2);
    ImageView imageView1 = new ImageView(paramContext);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    imageView1.setId(ab.e(paramContext, "tt_video_play"));
    layoutParams3.addRule(13, -1);
    imageView1.setScaleType(ImageView.ScaleType.CENTER);
    imageView1.setImageResource(ab.d(paramContext, "tt_play_movebar_textpage"));
    imageView1.setVisibility(8);
    imageView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    relativeLayout1.addView((View)imageView1);
    ProgressBar progressBar1 = new ProgressBar(paramContext, null, ab.g(paramContext, "tt_Widget_ProgressBar_Horizontal"));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 1.5F, resources.getDisplayMetrics()));
    progressBar1.setMax(100);
    progressBar1.setId(ab.e(paramContext, "tt_video_progress"));
    progressBar1.setBackgroundColor(0);
    progressBar1.setIndeterminateDrawable(null);
    progressBar1.setProgressDrawable(ab.c(paramContext, "tt_video_progress_drawable"));
    progressBar1.setVisibility(8);
    layoutParams1.addRule(12, -1);
    progressBar1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    relativeLayout1.addView((View)progressBar1);
    ViewStub viewStub = new ViewStub(paramContext);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    viewStub.setId(ab.e(paramContext, "tt_video_ad_cover"));
    viewStub.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    viewStub.setLayoutResource(ab.f(paramContext, "tt_video_ad_cover_layout"));
    relativeLayout1.addView((View)viewStub);
    viewStub = new ViewStub(paramContext);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13, -1);
    viewStub.setId(ab.e(paramContext, "tt_video_draw_layout_viewStub"));
    viewStub.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    viewStub.setLayoutResource(ab.f(paramContext, "tt_video_draw_btn_layout"));
    relativeLayout1.addView((View)viewStub);
    return (View)relativeLayout1;
  }
  
  private boolean c(int paramInt) {
    return this.b.b(paramInt);
  }
  
  private boolean c(int paramInt1, int paramInt2) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("OnError - Error code: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" Extra code: ");
    stringBuilder.append(paramInt2);
    t.b("TTVideoLandingPageActivity", stringBuilder.toString());
    if (paramInt1 != -1010 && paramInt1 != -1007 && paramInt1 != -1004 && paramInt1 != -110 && paramInt1 != 100 && paramInt1 != 200) {
      bool = false;
    } else {
      bool = true;
    } 
    return (paramInt2 != 1 && paramInt2 != 700 && paramInt2 != 800) ? bool : true;
  }
  
  private void d(Context paramContext) {
    int i = w.c(paramContext);
    a(paramContext, i);
    if (i == 4)
      this.x = false; 
  }
  
  private boolean d(int paramInt) {
    int i = w.c(o.a());
    if (i == 0) {
      h();
      this.x = true;
      h h1 = this.b;
      if (h1 != null)
        h1.a(this.r, this.n, false); 
    } 
    if (i != 4 && i != 0) {
      h h1 = this.b;
      if (h1 != null)
        h1.e(); 
      h();
      this.x = true;
      this.y = false;
      h1 = this.b;
      if (h1 != null) {
        k k1 = this.r;
        if (k1 != null)
          return h1.a(paramInt, k1.z()); 
      } 
    } else if (i == 4) {
      this.x = false;
      h h1 = this.b;
      if (h1 != null)
        h1.q(); 
    } 
    return true;
  }
  
  private void h(boolean paramBoolean) {
    this.Q = paramBoolean;
  }
  
  private boolean z() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("retryCount=");
    stringBuilder.append(this.G);
    t.b("NativeVideoController", stringBuilder.toString());
    int i = this.G;
    boolean bool2 = true;
    if (1 <= i) {
      h h1 = this.b;
      if (h1 != null) {
        h1.w();
        this.b.a(this.r, this.n, false);
      } 
      return false;
    } 
    if (this.g == null)
      return false; 
    this.G = i + 1;
    stringBuilder = new StringBuilder();
    stringBuilder.append("isPlaying=");
    stringBuilder.append(this.g.g());
    stringBuilder.append(",isPaused=");
    stringBuilder.append(this.g.i());
    stringBuilder.append(",isPrepared=");
    stringBuilder.append(this.g.k());
    stringBuilder.append(",isStarted=");
    stringBuilder.append(this.g.h());
    t.b("NativeVideoController", stringBuilder.toString());
    boolean bool1 = bool2;
    if (this.g.g()) {
      bool1 = bool2;
      if (this.g.i()) {
        bool1 = bool2;
        if (this.g.k()) {
          if (!this.g.h())
            return true; 
          bool1 = false;
        } 
      } 
    } 
    return bool1;
  }
  
  public void a(int paramInt) {
    boolean bool;
    if (!C())
      return; 
    if (paramInt == 0 || paramInt == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    Context context = this.n.get();
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
  
  public void a(int paramInt1, int paramInt2) {
    if (paramInt1 != 0) {
      if (paramInt2 == 0)
        return; 
      this.E = paramInt1;
      this.F = paramInt2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("width=");
      stringBuilder.append(paramInt1);
      stringBuilder.append("height=");
      stringBuilder.append(paramInt2);
      t.b("NativeVideoController", stringBuilder.toString());
    } 
  }
  
  public void a(long paramLong) {
    this.i = paramLong;
    paramLong = this.j;
    long l = this.i;
    if (paramLong <= l)
      paramLong = l; 
    this.j = paramLong;
  }
  
  public void a(Context paramContext) {
    int i = w.c(paramContext);
    a(paramContext, i);
    if (i == 4) {
      this.x = false;
      j();
    } 
  }
  
  public void a(Message paramMessage) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   4: ifnull -> 871
    //   7: aload_1
    //   8: ifnull -> 871
    //   11: aload_0
    //   12: getfield n : Ljava/lang/ref/WeakReference;
    //   15: astore #8
    //   17: aload #8
    //   19: ifnull -> 871
    //   22: aload #8
    //   24: invokevirtual get : ()Ljava/lang/Object;
    //   27: ifnonnull -> 31
    //   30: return
    //   31: aload_1
    //   32: getfield what : I
    //   35: istore_2
    //   36: iload_2
    //   37: bipush #108
    //   39: if_icmpeq -> 826
    //   42: iload_2
    //   43: bipush #109
    //   45: if_icmpeq -> 753
    //   48: iload_2
    //   49: sipush #308
    //   52: if_icmpeq -> 731
    //   55: iload_2
    //   56: sipush #309
    //   59: if_icmpeq -> 721
    //   62: iload_2
    //   63: tableswitch default -> 96, 302 -> 712, 303 -> 499, 304 -> 335, 305 -> 251, 306 -> 237
    //   96: iload_2
    //   97: tableswitch default -> 128, 311 -> 232, 312 -> 153, 313 -> 148, 314 -> 129
    //   128: return
    //   129: aload_1
    //   130: getfield obj : Ljava/lang/Object;
    //   133: checkcast java/lang/Boolean
    //   136: invokevirtual booleanValue : ()Z
    //   139: pop
    //   140: aload_0
    //   141: invokestatic elapsedRealtime : ()J
    //   144: putfield O : J
    //   147: return
    //   148: aload_0
    //   149: invokespecial H : ()V
    //   152: return
    //   153: aload_0
    //   154: invokespecial z : ()Z
    //   157: ifeq -> 222
    //   160: ldc_w 'NativeVideoController'
    //   163: ldc_w 'CALLBACK_ON_RETRY_VIDEO_TIME-....重试....'
    //   166: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: invokevirtual l : ()V
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield g : Lcom/bytedance/sdk/openadsdk/core/video/c/d;
    //   178: aload_0
    //   179: aload_0
    //   180: getfield r : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   183: invokevirtual z : ()Lcom/bytedance/sdk/openadsdk/core/d/r;
    //   186: invokevirtual g : ()Ljava/lang/String;
    //   189: aload_0
    //   190: getfield r : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   193: invokevirtual M : ()Ljava/lang/String;
    //   196: aload_0
    //   197: getfield E : I
    //   200: aload_0
    //   201: getfield F : I
    //   204: aconst_null
    //   205: aload_0
    //   206: getfield r : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   209: invokevirtual P : ()Ljava/lang/String;
    //   212: lconst_0
    //   213: aload_0
    //   214: invokevirtual b : ()Z
    //   217: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/lang/String;JZ)Z
    //   220: pop
    //   221: return
    //   222: ldc_w 'NativeVideoController'
    //   225: ldc_w '不满足条件，无法重试'
    //   228: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   231: return
    //   232: aload_0
    //   233: invokespecial I : ()V
    //   236: return
    //   237: aload_0
    //   238: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   241: astore_1
    //   242: aload_1
    //   243: ifnull -> 871
    //   246: aload_1
    //   247: invokevirtual w : ()V
    //   250: return
    //   251: aload_0
    //   252: getfield C : Ljava/lang/ref/WeakReference;
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull -> 282
    //   260: aload_1
    //   261: invokevirtual get : ()Ljava/lang/Object;
    //   264: ifnull -> 282
    //   267: aload_0
    //   268: getfield C : Ljava/lang/ref/WeakReference;
    //   271: invokevirtual get : ()Ljava/lang/Object;
    //   274: checkcast com/bytedance/sdk/openadsdk/core/video/nativevideo/c$c
    //   277: invokeinterface f : ()V
    //   282: aload_0
    //   283: getfield d : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   286: astore_1
    //   287: aload_1
    //   288: ifnull -> 299
    //   291: aload_1
    //   292: aload_0
    //   293: getfield K : Ljava/lang/Runnable;
    //   296: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   299: aload_0
    //   300: getfield o : Z
    //   303: ifne -> 310
    //   306: aload_0
    //   307: invokespecial F : ()V
    //   310: aload_0
    //   311: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   314: astore_1
    //   315: aload_1
    //   316: ifnull -> 323
    //   319: aload_1
    //   320: invokevirtual w : ()V
    //   323: aload_0
    //   324: getfield d : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   327: aload_0
    //   328: getfield a : Ljava/lang/Runnable;
    //   331: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   334: return
    //   335: aload_1
    //   336: getfield arg1 : I
    //   339: istore_2
    //   340: aload_0
    //   341: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   344: astore_1
    //   345: aload_1
    //   346: ifnull -> 421
    //   349: iload_2
    //   350: iconst_3
    //   351: if_icmpeq -> 398
    //   354: iload_2
    //   355: sipush #702
    //   358: if_icmpne -> 364
    //   361: goto -> 398
    //   364: iload_2
    //   365: sipush #701
    //   368: if_icmpne -> 421
    //   371: aload_1
    //   372: invokevirtual t : ()V
    //   375: aload_0
    //   376: getfield d : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   379: aload_0
    //   380: getfield a : Ljava/lang/Runnable;
    //   383: ldc2_w 8000
    //   386: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   389: pop
    //   390: aload_0
    //   391: iconst_1
    //   392: putfield H : Z
    //   395: goto -> 421
    //   398: aload_0
    //   399: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   402: invokevirtual w : ()V
    //   405: aload_0
    //   406: getfield d : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   409: aload_0
    //   410: getfield a : Ljava/lang/Runnable;
    //   413: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   416: aload_0
    //   417: iconst_0
    //   418: putfield H : Z
    //   421: aload_0
    //   422: getfield o : Z
    //   425: ifeq -> 482
    //   428: iload_2
    //   429: iconst_3
    //   430: if_icmpne -> 482
    //   433: aload_0
    //   434: getfield s : Z
    //   437: ifeq -> 471
    //   440: aload_0
    //   441: getfield D : Ljava/lang/ref/WeakReference;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull -> 471
    //   449: aload_1
    //   450: invokevirtual get : ()Ljava/lang/Object;
    //   453: ifnull -> 471
    //   456: aload_0
    //   457: getfield D : Ljava/lang/ref/WeakReference;
    //   460: invokevirtual get : ()Ljava/lang/Object;
    //   463: checkcast com/bytedance/sdk/openadsdk/core/video/nativevideo/f$a
    //   466: invokeinterface e : ()V
    //   471: aload_0
    //   472: getfield d : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   475: aload_0
    //   476: getfield a : Ljava/lang/Runnable;
    //   479: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   482: aload_0
    //   483: getfield o : Z
    //   486: ifeq -> 871
    //   489: iload_2
    //   490: iconst_3
    //   491: if_icmpne -> 871
    //   494: aload_0
    //   495: invokespecial F : ()V
    //   498: return
    //   499: aload_1
    //   500: getfield arg1 : I
    //   503: istore_2
    //   504: aload_1
    //   505: getfield arg2 : I
    //   508: istore_3
    //   509: aload_0
    //   510: iload_2
    //   511: iload_3
    //   512: invokespecial b : (II)V
    //   515: ldc_w 'NativeVideoController'
    //   518: ldc_w 'CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、'
    //   521: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload_0
    //   525: invokevirtual f : ()Z
    //   528: ifeq -> 539
    //   531: iload_3
    //   532: sipush #-1004
    //   535: if_icmpeq -> 539
    //   538: return
    //   539: new java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial <init> : ()V
    //   546: astore_1
    //   547: aload_1
    //   548: ldc_w '出错后 errorcode,extra、、、、、、、'
    //   551: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_1
    //   556: iload_2
    //   557: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_1
    //   562: ldc_w ','
    //   565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload_1
    //   570: iload_3
    //   571: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: ldc_w 'NativeVideoController'
    //   578: aload_1
    //   579: invokevirtual toString : ()Ljava/lang/String;
    //   582: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   585: aload_0
    //   586: iload_2
    //   587: iload_3
    //   588: invokespecial c : (II)Z
    //   591: ifeq -> 628
    //   594: ldc_w 'NativeVideoController'
    //   597: ldc_w '出错后展示结果页、、、、、、、'
    //   600: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_0
    //   604: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   607: aload_0
    //   608: getfield r : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   611: aload_0
    //   612: getfield n : Ljava/lang/ref/WeakReference;
    //   615: iconst_0
    //   616: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/core/d/k;Ljava/lang/ref/WeakReference;Z)V
    //   619: aload_0
    //   620: iconst_1
    //   621: invokevirtual d : (Z)V
    //   624: aload_0
    //   625: invokevirtual l : ()V
    //   628: aload_0
    //   629: getfield b : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/h;
    //   632: astore_1
    //   633: aload_1
    //   634: ifnull -> 641
    //   637: aload_1
    //   638: invokevirtual w : ()V
    //   641: aload_0
    //   642: getfield h : Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c$a;
    //   645: astore_1
    //   646: aload_1
    //   647: ifnull -> 671
    //   650: aload_1
    //   651: aload_0
    //   652: getfield f : J
    //   655: aload_0
    //   656: getfield i : J
    //   659: aload_0
    //   660: getfield k : J
    //   663: invokestatic a : (JJ)I
    //   666: invokeinterface b : (JI)V
    //   671: aload_0
    //   672: getfield C : Ljava/lang/ref/WeakReference;
    //   675: astore_1
    //   676: aload_1
    //   677: ifnull -> 871
    //   680: aload_1
    //   681: invokevirtual get : ()Ljava/lang/Object;
    //   684: ifnull -> 871
    //   687: aload_0
    //   688: invokevirtual f : ()Z
    //   691: ifne -> 871
    //   694: aload_0
    //   695: getfield C : Ljava/lang/ref/WeakReference;
    //   698: invokevirtual get : ()Ljava/lang/Object;
    //   701: checkcast com/bytedance/sdk/openadsdk/core/video/nativevideo/c$c
    //   704: iload_2
    //   705: iload_3
    //   706: invokeinterface a : (II)V
    //   711: return
    //   712: aload_0
    //   713: aload_1
    //   714: getfield what : I
    //   717: invokespecial b : (I)V
    //   720: return
    //   721: ldc_w 'NativeVideoController'
    //   724: ldc_w 'SSMediaPlayerWrapper 释放了。。。。。'
    //   727: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   730: return
    //   731: ldc_w 'NativeVideoController'
    //   734: ldc_w '播放器状态出错 STAT_ERROR 200 、、、、、、、'
    //   737: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   740: aload_0
    //   741: invokespecial G : ()V
    //   744: aload_0
    //   745: sipush #308
    //   748: iconst_0
    //   749: invokespecial b : (II)V
    //   752: return
    //   753: aload_1
    //   754: getfield obj : Ljava/lang/Object;
    //   757: instanceof java/lang/Long
    //   760: ifeq -> 871
    //   763: aload_0
    //   764: aload_1
    //   765: getfield obj : Ljava/lang/Object;
    //   768: checkcast java/lang/Long
    //   771: checkcast java/lang/Long
    //   774: invokevirtual longValue : ()J
    //   777: putfield i : J
    //   780: aload_0
    //   781: getfield j : J
    //   784: lstore #4
    //   786: aload_0
    //   787: getfield i : J
    //   790: lstore #6
    //   792: lload #4
    //   794: lload #6
    //   796: lcmp
    //   797: ifle -> 803
    //   800: goto -> 807
    //   803: lload #6
    //   805: lstore #4
    //   807: aload_0
    //   808: lload #4
    //   810: putfield j : J
    //   813: aload_0
    //   814: aload_0
    //   815: getfield i : J
    //   818: aload_0
    //   819: getfield k : J
    //   822: invokespecial a : (JJ)V
    //   825: return
    //   826: aload_1
    //   827: getfield obj : Ljava/lang/Object;
    //   830: instanceof java/lang/Long
    //   833: ifeq -> 871
    //   836: aload_1
    //   837: getfield obj : Ljava/lang/Object;
    //   840: checkcast java/lang/Long
    //   843: checkcast java/lang/Long
    //   846: invokevirtual longValue : ()J
    //   849: lconst_0
    //   850: lcmp
    //   851: ifle -> 871
    //   854: aload_0
    //   855: aload_1
    //   856: getfield obj : Ljava/lang/Object;
    //   859: checkcast java/lang/Long
    //   862: checkcast java/lang/Long
    //   865: invokevirtual longValue : ()J
    //   868: putfield k : J
    //   871: return
    //   872: astore_1
    //   873: goto -> 140
    // Exception table:
    //   from	to	target	type
    //   129	140	872	finally
  }
  
  public void a(TTDrawFeedAd.DrawVideoListener paramDrawVideoListener) {
    h h1 = this.b;
    if (h1 != null)
      h1.a(paramDrawVideoListener); 
  }
  
  public void a(b paramb, int paramInt) {
    if (this.g == null)
      return; 
    A();
    a(this.R, c(paramInt));
  }
  
  public void a(b paramb, int paramInt, boolean paramBoolean) {
    if (!C())
      return; 
    Context context = this.n.get();
    long l = (long)((float)(paramInt * this.k) * 1.0F / ab.l(context, "tt_video_progress_max"));
    if (this.k > 0L) {
      this.R = (int)l;
    } else {
      this.R = 0L;
    } 
    h h1 = this.b;
    if (h1 != null)
      h1.a(this.R); 
  }
  
  public void a(b paramb, SurfaceTexture paramSurfaceTexture) {
    this.m = true;
    d d1 = this.g;
    if (d1 == null)
      return; 
    d1.a(paramSurfaceTexture);
    D();
  }
  
  public void a(b paramb, SurfaceHolder paramSurfaceHolder) {
    this.m = true;
    d d1 = this.g;
    if (d1 == null)
      return; 
    d1.a(paramSurfaceHolder);
    D();
  }
  
  public void a(b paramb, SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(b paramb, View paramView) {
    if (this.g != null) {
      if (!C())
        return; 
      if (this.g.g()) {
        h();
        this.b.b(true, false);
        this.b.c();
        return;
      } 
      if (!this.g.i()) {
        paramb = this.b;
        if (paramb != null)
          paramb.c(this.c.get()); 
        d(this.i);
        paramb = this.b;
        if (paramb != null) {
          paramb.b(false, false);
          return;
        } 
      } else {
        g(false);
        paramb = this.b;
        if (paramb != null)
          paramb.b(false, false); 
      } 
    } 
  }
  
  public void a(b paramb, View paramView, boolean paramBoolean) {
    K();
  }
  
  public void a(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.s)
      h(); 
    if (paramBoolean1 && !this.s && !e()) {
      this.b.b(f() ^ true, false);
      this.b.a(paramBoolean2, true, false);
    } 
    d d1 = this.g;
    if (d1 != null && d1.g()) {
      this.b.c();
      this.b.b();
      return;
    } 
    this.b.c();
  }
  
  public void a(c.a parama) {
    this.h = parama;
  }
  
  public void a(c.c paramc) {
    this.C = new WeakReference<c.c>(paramc);
  }
  
  public void a(e parame) {
    this.v = new WeakReference<e>(parame);
  }
  
  public void a(a parama) {
    this.D = new WeakReference<a>(parama);
  }
  
  public void a(e.a parama, String paramString) {
    int i = null.a[parama.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        j();
        this.x = false;
        this.y = true;
        return;
      } 
      a(true);
      return;
    } 
    h();
  }
  
  public void a(Map<String, Object> paramMap) {}
  
  public void a(boolean paramBoolean) {
    if (this.s)
      this.N = o(); 
    if (!this.q && this.p)
      if (paramBoolean) {
        d.a(this.n.get(), this.r, this.u, "feed_break", this.N, q(), c());
        this.q = false;
      } else {
        d.a(this.n.get(), this.r, this.u, "feed_pause", this.N, q(), c());
      }  
    l();
  }
  
  public boolean a() {
    return this.s;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<String> paramList, String paramString3, long paramLong, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[video] start NativeVideoController#playVideoUrl and video url is :\r\n");
    stringBuilder.append(paramString1);
    t.b("tag_video_play", stringBuilder.toString());
    if (TextUtils.isEmpty(paramString1)) {
      t.e("tag_video_play", "[video] play video stop , because no video info");
      return false;
    } 
    this.t = paramBoolean;
    this.i = paramLong;
    int i = paramLong cmp 0L;
    if (i <= 0) {
      this.q = false;
      this.p = false;
    } 
    if (i > 0) {
      this.i = paramLong;
      paramLong = this.j;
      long l = this.i;
      if (paramLong <= l)
        paramLong = l; 
      this.j = paramLong;
    } 
    h h1 = this.b;
    if (h1 != null) {
      h1.e();
      if (this.M == 0)
        this.b.d(); 
      this.b.c(paramInt1, paramInt2);
      this.b.c(this.c.get());
      this.b.a(paramInt1, paramInt2);
    } 
    if (this.g == null)
      this.g = new d((Handler)this.d); 
    t.b("tag_video_play", "[video] new MediaPlayer");
    this.f = 0L;
    try {
      a(paramString1);
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[video] invoke NativeVideoController#playVideo cause exception :");
      stringBuilder1.append(exception.toString());
      t.e("tag_video_play", stringBuilder1.toString());
      return false;
    } 
  }
  
  public void b(long paramLong) {
    this.w = paramLong;
  }
  
  public void b(b paramb, int paramInt) {
    if (this.g != null)
      B(); 
    paramb = this.b;
    if (paramb != null)
      paramb.c(); 
  }
  
  public void b(b paramb, SurfaceTexture paramSurfaceTexture) {
    this.m = false;
  }
  
  public void b(b paramb, SurfaceHolder paramSurfaceHolder) {
    this.m = false;
  }
  
  public void b(b paramb, View paramView) {
    b(paramb, paramView, false, false);
  }
  
  public void b(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2) {
    if (!C())
      return; 
    h(this.Q ^ true);
    if (!(this.n.get() instanceof Activity)) {
      t.b("NativeVideoController", "context is not activity, not support this function.");
      return;
    } 
    if (this.Q) {
      boolean bool;
      if (paramBoolean1) {
        bool = true;
      } else {
        bool = false;
      } 
      a(bool);
      paramb = this.b;
      if (paramb != null) {
        paramb.a(this.c.get());
        this.b.b(false);
      } 
    } else {
      a(1);
      paramb = this.b;
      if (paramb != null) {
        paramb.b(this.c.get());
        this.b.b(false);
      } 
    } 
    WeakReference<e> weakReference = this.v;
    if (weakReference != null) {
      e e = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (weakReference != null)
      weakReference.a(this.Q); 
  }
  
  public void b(boolean paramBoolean) {
    this.s = paramBoolean;
    h h1 = this.b;
    if (h1 != null)
      h1.c(paramBoolean); 
  }
  
  public boolean b() {
    return this.t;
  }
  
  protected Map<String, Object> c() {
    return ah.a(this.r, n(), t());
  }
  
  public void c(long paramLong) {
    this.k = paramLong;
  }
  
  public void c(b paramb, View paramView) {
    paramb = this.b;
    if (paramb != null)
      paramb.g(); 
    a(true);
  }
  
  public void c(boolean paramBoolean) {
    this.t = paramBoolean;
    d d1 = this.g;
    if (d1 != null)
      d1.a(paramBoolean); 
  }
  
  public void d() {
    d d1 = this.g;
    if (d1 != null)
      d1.b(); 
  }
  
  public void d(long paramLong) {
    this.i = paramLong;
    paramLong = this.j;
    long l = this.i;
    if (paramLong <= l)
      paramLong = l; 
    this.j = paramLong;
    h h1 = this.b;
    if (h1 != null)
      h1.e(); 
    d d1 = this.g;
    if (d1 != null) {
      d1.a(true, this.i, this.t ^ true);
      A();
    } 
  }
  
  public void d(b paramb, View paramView) {
    if (this.Q) {
      h(false);
      paramb = this.b;
      if (paramb != null)
        paramb.b(this.c.get()); 
      a(1);
      return;
    } 
    a(true);
  }
  
  public void d(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public void e(long paramLong) {
    this.N = paramLong;
  }
  
  public void e(b paramb, View paramView) {
    a(paramb, paramView, false);
  }
  
  public void e(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public boolean e() {
    d d1 = this.g;
    return (d1 == null || d1.l());
  }
  
  public void f(b paramb, View paramView) {}
  
  public void f(boolean paramBoolean) {
    this.I = paramBoolean;
  }
  
  public boolean f() {
    d d1 = this.g;
    return (d1 != null && d1.g());
  }
  
  public void g() {
    if (w.c(o.a()) == 0)
      return; 
    l();
    a(this.r.z().g(), this.r.M(), this.E, this.F, null, this.r.P(), 0L, b());
    d(false);
  }
  
  public void g(boolean paramBoolean) {
    h h1 = this.b;
    if (h1 != null)
      h1.e(); 
    h1 = this.b;
    if (h1 != null && paramBoolean)
      h1.u(); 
    E();
  }
  
  public void h() {
    d d1 = this.g;
    if (d1 != null)
      d1.b(); 
    if (!this.q && this.p) {
      if (b.b()) {
        if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true))
          d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c()); 
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", Boolean.valueOf(true));
        return;
      } 
      if (u.a().b())
        d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c()); 
      u.a().a(true);
    } 
  }
  
  public void i() {
    d d1 = this.g;
    if (d1 != null)
      d1.d(); 
  }
  
  public void j() {
    h h1 = this.b;
    if (h1 != null)
      h1.e(); 
    h1 = this.b;
    if (h1 != null)
      h1.u(); 
    E();
  }
  
  public void k() {
    a(true);
  }
  
  public void l() {
    d d1 = this.g;
    if (d1 != null) {
      d1.c();
      this.g = null;
    } 
    if (!ah.a(this.r) || this.M == 2)
      this.b.a(this.r, this.n, true); 
    ak ak1 = this.d;
    if (ak1 != null) {
      ak1.removeCallbacks(this.L);
      this.d.removeCallbacks(this.K);
      this.d.removeCallbacks(this.J);
      this.d.removeCallbacksAndMessages(null);
    } 
    B();
    List<Runnable> list = this.l;
    if (list != null)
      list.clear(); 
    if (this.s)
      y(); 
  }
  
  public long m() {
    return this.i;
  }
  
  public long n() {
    return (t() == null) ? 0L : t().n();
  }
  
  public long o() {
    d d1 = this.g;
    return (d1 == null) ? 0L : (d1.o() + this.w);
  }
  
  public long p() {
    return 0L;
  }
  
  public int q() {
    return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.j, this.k);
  }
  
  public long r() {
    return this.k;
  }
  
  public boolean s() {
    return this.x;
  }
  
  public d t() {
    return this.g;
  }
  
  public h u() {
    return this.b;
  }
  
  public boolean v() {
    return this.z;
  }
  
  public boolean w() {
    return this.H;
  }
  
  public void x() {
    if (!this.U) {
      if (!this.I)
        return; 
      Context context = o.a().getApplicationContext();
      this.U = true;
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      try {
        context.registerReceiver(this.S, intentFilter);
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  public void y() {
    if (this.U) {
      if (!this.I)
        return; 
      Context context = o.a().getApplicationContext();
      this.U = false;
      try {
        context.unregisterReceiver(this.S);
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  public static interface a {
    void a(int param1Int);
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\nativevideo\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */