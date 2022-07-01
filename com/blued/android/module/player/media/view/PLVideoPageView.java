package com.blued.android.module.player.media.view;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.player.media.R;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;

public class PLVideoPageView extends AbsPlayerView {
  public static String m = "PLVideoPageView";
  
  private Runnable A = new Runnable(this) {
      public void run() {
        if (this.a.d != null && this.a.i.getChildCount() > 0) {
          PLVideoPageView.a(this.a);
          if (this.a.a())
            PLVideoPageView.c(this.a).postDelayed(PLVideoPageView.b(this.a), 100L); 
        } 
      }
    };
  
  private AbBaseVideoView.OnVideoStatusListener B = new AbBaseVideoView.OnVideoStatusListener(this) {
      public void a() {
        AppInfo.n().post(new -$$Lambda$PLVideoPageView$2$v24oAdDvN7hPItfNEBttGWQOkaM(this));
      }
      
      public void a(int param1Int1, int param1Int2) {}
      
      public void b() {
        AppInfo.n().post(new -$$Lambda$PLVideoPageView$2$mGt7s2OJTygs5fQkjupNzga55_k(this));
      }
      
      public void c() {
        AppInfo.n().post(new Runnable(this) {
              public void run() {
                Log.c(PLVideoPageView.m, "onBufferEnd ***");
                if (this.a.a.j != null && this.a.a.j.m) {
                  PLVideoPageView.d(this.a.a);
                  return;
                } 
                PLVideoPageView.e(this.a.a);
                PLVideoPageView.c(this.a.a).removeCallbacks(PLVideoPageView.b(this.a.a));
                PLVideoPageView.c(this.a.a).post(PLVideoPageView.b(this.a.a));
                if (PLVideoPageView.f(this.a.a) != null)
                  PLVideoPageView.f(this.a.a).b(); 
              }
            });
      }
      
      public void d() {
        AppInfo.n().post(new -$$Lambda$PLVideoPageView$2$Us-BsfVpYB8EC-cnc1BgxW7eJJw(this));
      }
    };
  
  Runnable n = new Runnable(this) {
      public void run() {
        PLVideoPageView.h(this.a).setVisibility(8);
      }
    };
  
  private TextView o;
  
  private SeekBar p;
  
  private SeekBar q;
  
  private long r = 0L;
  
  private long s = 0L;
  
  private long t = 0L;
  
  private long u;
  
  private long v;
  
  private boolean w = false;
  
  private boolean x;
  
  private OnPLVideoListener y;
  
  private Handler z = new Handler();
  
  public PLVideoPageView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PLVideoPageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    u();
  }
  
  private void a(long paramLong) {
    /* monitor enter ThisExpression{ObjectType{com/blued/android/module/player/media/view/PLVideoPageView}} */
    try {
      if (this.t > paramLong)
        StatisticsProxy.a().a(2, this.j.i, (int)(this.s / 1000L)); 
      this.t = paramLong;
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {
      Exception exception;
    } 
    /* monitor exit ThisExpression{ObjectType{com/blued/android/module/player/media/view/PLVideoPageView}} */
  }
  
  private void a(View paramView, int paramInt) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setFillAfter(false);
    alphaAnimation.setDuration(paramInt);
    paramView.setAnimation((Animation)alphaAnimation);
    alphaAnimation.start();
    paramView.setVisibility(8);
  }
  
  private void l() {
    if (this.d == null || this.j == null) {
      Log.d(m, "start mVideoView == null");
      return;
    } 
    if (!b()) {
      Log.d(m, "start mVideoRoot.getChildCount() == 0");
      return;
    } 
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startPlay: url = ");
    stringBuilder.append(this.j.b);
    Log.c(str, stringBuilder.toString());
    o();
    this.j.m = false;
    OnPLVideoListener onPLVideoListener = this.y;
    if (onPLVideoListener != null)
      onPLVideoListener.c(); 
    this.z.removeCallbacks(this.A);
    this.z.post(this.A);
    this.d.setOnVideoStatusListener(null);
    this.d.setOnVideoStatusListener(this.B);
    this.d.b();
  }
  
  private void m() {
    Log.c(m, "onPausePlay");
    n();
    p();
  }
  
  private void n() {
    if (this.j != null) {
      if (this.j.m)
        return; 
      this.z.removeCallbacks(this.A);
      if (this.i.getChildCount() == 0) {
        String str1 = m;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("onPausePlay mVideoRoot.getChildCount() == 0 id=");
        stringBuilder1.append(this.i.getId());
        Log.c(str1, stringBuilder1.toString());
        return;
      } 
      String str = m;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pause url");
      stringBuilder.append(this.j.b);
      Log.c(str, stringBuilder.toString());
      this.j.m = true;
      if (b())
        this.d.d(); 
      OnPLVideoListener onPLVideoListener = this.y;
      if (onPLVideoListener != null)
        onPLVideoListener.bc_(); 
    } 
  }
  
  private void o() {
    t();
    if (this.j != null && !this.j.j && !a())
      this.h.setVisibility(0); 
    this.o.setVisibility(8);
    if (this.y != null && !a()) {
      this.y.a(0L, 0L);
      this.y.bd_();
    } 
  }
  
  private void p() {
    s();
    if (this.j != null && !this.j.j)
      this.h.setVisibility(8); 
    OnPLVideoListener onPLVideoListener = this.y;
    if (onPLVideoListener != null)
      onPLVideoListener.b(); 
  }
  
  private AbBaseVideoView q() {
    Log.c(m, "initVideoView");
    return b(this.j.b);
  }
  
  private void r() {
    if (!b()) {
      this.d = q();
    } else {
      this.l.a(getPlayUrl(), this.d);
    } 
    if (this.i.getChildCount() == 0) {
      this.i.addView((View)this.d);
      String str = m;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("insetPlayTextureView new mVideoRoot URL = ");
      stringBuilder.append(this.j.b);
      Log.c(str, stringBuilder.toString());
    } else {
      Log.c(m, "insetPlayTextureView mVideoRoot.getChildCount() != 0");
    } 
    this.d.a(this.j);
    this.d.a(true);
    post(new -$$Lambda$PLVideoPageView$nn7OL-1Wzb_TPpOhGUCwuXB2Bm0(this));
  }
  
  private void s() {
    this.g.setVisibility(0);
  }
  
  private void t() {
    this.g.setVisibility(8);
  }
  
  private void u() {
    this.a = AppInfo.d();
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.pl_texture_video_view_new, (ViewGroup)this);
    this.i = (FrameLayout)this.c.findViewById(R.id.video_root);
    this.p = (SeekBar)this.c.findViewById(R.id.pl_seek_bar);
    this.o = (TextView)this.c.findViewById(R.id.pl_tip);
    if (StatusBarHelper.a()) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
      layoutParams.topMargin += StatusBarHelper.a(this.a);
      this.o.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    this.q = (SeekBar)this.c.findViewById(R.id.volume_bar);
    this.e = this.c.findViewById(R.id.cover_view);
    this.e.setVisibility(0);
    this.f = (ImageView)this.c.findViewById(R.id.preview);
    this.g = (ImageView)this.c.findViewById(R.id.video_state_icon);
    this.h = this.c.findViewById(R.id.LoadingView);
    this.p.setMax(1000);
    this.p.setPadding(0, 0, 0, 0);
    this.p.setVisibility(4);
    this.q.setMax(15);
    this.q.setProgress(10);
    this.q.setPadding(0, 0, 0, 0);
    this.q.setVisibility(4);
  }
  
  private void v() {
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onRenderingStart mVideoPlayConfig.mIsPause ");
    stringBuilder.append(this.j.m);
    Log.c(str, stringBuilder.toString());
    if (this.j != null && this.j.m) {
      m();
      return;
    } 
    t();
    if (this.f != null && this.f.getVisibility() == 0)
      a((View)this.f, 300); 
    this.z.removeCallbacks(this.A);
    this.z.post(this.A);
    if (this.h != null && this.h.getVisibility() == 0)
      this.h.setVisibility(8); 
    if (this.j != null && this.j.o)
      k(); 
    OnPLVideoListener onPLVideoListener = this.y;
    if (onPLVideoListener != null && !this.x) {
      this.x = true;
      onPLVideoListener.b();
      if (b())
        this.y.g_((int)(this.d.getDuration() / 1000L)); 
    } 
  }
  
  private void w() {
    this.f.setVisibility(0);
    this.g.setVisibility(0);
    OnPLVideoListener onPLVideoListener = this.y;
    if (onPLVideoListener != null)
      onPLVideoListener.b(); 
  }
  
  private void x() {
    if (a()) {
      long l1 = this.d.getCurrentPosition();
      long l2 = this.d.getDuration();
      this.r = l1;
      this.s = l2;
      a(l1);
      if (this.j != null && this.j.j) {
        SeekBar seekBar = this.p;
        if (seekBar != null && seekBar.getVisibility() == 0 && l2 > 0L) {
          long l4 = (long)((float)l1 / (float)l2 * 1000.0F);
          long l5 = this.v;
          long l3 = l4;
          if (l5 > l4) {
            l3 = l4;
            if (l5 != 1000L) {
              l3 = l4;
              if (l5 > 900L)
                l3 = 1000L; 
            } 
          } 
          this.p.setProgress((int)l3);
          this.v = l3;
        } 
      } 
      OnPLVideoListener onPLVideoListener = this.y;
      if (onPLVideoListener != null)
        onPLVideoListener.a(l1, l2); 
    } 
  }
  
  public void a(long paramLong, int paramInt, OnSeekListener paramOnSeekListener) {
    if (!b()) {
      Log.d(m, "seekTo discard, mVideoView = null");
      return;
    } 
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("seekTo: time = ");
    stringBuilder.append(paramLong);
    stringBuilder.append(", duration = ");
    stringBuilder.append(this.s);
    Log.c(str, stringBuilder.toString());
    this.u = paramLong;
    this.d.a(this.u);
    if (paramOnSeekListener != null)
      this.d.setSeekListener(paramOnSeekListener); 
  }
  
  public void a(boolean paramBoolean) {
    Log.c(m, "onVisibleToUser");
    if (this.j != null && this.j.q) {
      if (!paramBoolean) {
        g();
        return;
      } 
    } else {
      if (paramBoolean) {
        l();
        return;
      } 
      j();
    } 
  }
  
  public void b(VideoPlayConfig paramVideoPlayConfig) {
    String str2 = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("loadVideoSource: url = ");
    stringBuilder.append(paramVideoPlayConfig.b);
    Log.c(str2, stringBuilder.toString());
    if (!a(paramVideoPlayConfig))
      return; 
    this.c.setOnClickListener(new -$$Lambda$PLVideoPageView$jz2Wb-owqo7i_s3Fgsj_pruhZ3c(this));
    this.c.setOnLongClickListener(new -$$Lambda$PLVideoPageView$aeh22Jy6tESvagwyAzXbH9-teUg(this));
    if (this.j.j)
      Utils.a(this.j); 
    String str1 = String.format("%s", new Object[] { Long.valueOf(this.j.c / 1024L) });
    this.o.setText(String.format(this.a.getResources().getString(R.string.short_video_size_tip), new Object[] { str1 }));
    if (this.j.e != 0 && this.j.f != 0) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.j.e, this.j.f);
      layoutParams.gravity = 17;
      this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    if (!TextUtils.isEmpty(this.j.a)) {
      ImageWrapper imageWrapper;
      if (!this.j.a.contains("http")) {
        imageWrapper = ImageLoader.d(null, this.j.a);
      } else {
        imageWrapper = ImageLoader.a(null, this.j.a);
      } 
      imageWrapper.a(R.drawable.defaultpicture).a(this.f);
      this.f.setVisibility(0);
    } else {
      this.f.setVisibility(8);
      this.f.setImageResource(R.drawable.defaultpicture);
    } 
    if (this.j.m)
      p(); 
    this.x = false;
  }
  
  public void c() {
    if (this.j == null) {
      String str1 = m;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("startPlay discard, mPlayConfig = null + ");
      stringBuilder1.append(this);
      Log.c(str1, stringBuilder1.toString());
      return;
    } 
    if (TextUtils.isEmpty(this.j.b)) {
      Log.e(m, "error: onStartPlay video url is empty");
      return;
    } 
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startPlay() url = ");
    stringBuilder.append(this.j.b);
    Log.c(str, stringBuilder.toString());
    r();
    if (this.j.n) {
      this.p.setVisibility(0);
      this.p.setProgress(0);
    } 
    l();
  }
  
  public void d() {
    if (this.j == null)
      return; 
    if (this.j.m) {
      this.w = false;
      if (this.d == null || this.i.getChildCount() == 0) {
        c();
        return;
      } 
      l();
      return;
    } 
    this.w = true;
    m();
  }
  
  public void e() {
    if (!b())
      return; 
    if (!TextUtils.isEmpty(this.j.i) && this.r >= 3000L)
      try {
        StatisticsProxy.a().a(2, this.j.i, (int)(this.r / 1000L));
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.x = false;
    this.d.f();
  }
  
  public void f() {
    if (this.j == null)
      return; 
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResume");
    stringBuilder.append(this.j.b);
    Log.c(str, stringBuilder.toString());
    if (!this.w && !this.j.q && this.j.m) {
      if (b()) {
        l();
        this.h.setVisibility(8);
        return;
      } 
      c();
    } 
  }
  
  public void g() {
    if (this.j == null)
      return; 
    if (this.j.q) {
      j();
      if (this.d != null)
        this.d.c(); 
      this.i.removeAllViews();
      Log.c(m, "onPauseDrop mVideoRoot.removeAllViews");
      return;
    } 
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPause ");
    stringBuilder.append(this.j.b);
    Log.c(str, stringBuilder.toString());
    m();
  }
  
  public long getPlayTime() {
    return this.r;
  }
  
  public String getPlayUrl() {
    return (this.j != null) ? this.j.b : "";
  }
  
  public long getTotalTime() {
    return this.s;
  }
  
  public String getVideoUrl() {
    return (this.j != null) ? this.j.b : null;
  }
  
  public void h() {
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onDestroy ##########:");
    stringBuilder.append(this);
    Log.c(str, stringBuilder.toString());
    e();
    this.y = null;
    if (this.j != null) {
      if (this.j.g != null)
        this.j.g = null; 
      if (this.j.h != null)
        this.j.h = null; 
    } 
    if (this.h != null)
      this.h.setVisibility(8); 
    if (this.d != null)
      this.d.c(); 
    a(this.d);
  }
  
  public boolean i() {
    return (this.g.getVisibility() == 0);
  }
  
  public void j() {
    Log.b(m, "resetLayout");
    m();
    w();
  }
  
  public void k() {
    if (this.j == null)
      return; 
    if (!this.j.j) {
      j();
      return;
    } 
    if (this.j.o) {
      long l;
      if (b()) {
        l = this.d.getDuration();
      } else {
        l = 0L;
      } 
      if (this.j.c > 0L && l > 16000L) {
        String str = m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video size is :");
        stringBuilder.append(this.j.c);
        stringBuilder.append("  totalDuration:");
        stringBuilder.append(l);
        Log.c(str, stringBuilder.toString());
        this.o.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                Animation animation = AnimationUtils.loadAnimation(this.a.a, R.anim.push_up_out);
                animation.setAnimationListener(new Animation.AnimationListener(this) {
                      public void onAnimationEnd(Animation param2Animation) {
                        PLVideoPageView.i(this.a.a).setVisibility(8);
                      }
                      
                      public void onAnimationRepeat(Animation param2Animation) {}
                      
                      public void onAnimationStart(Animation param2Animation) {}
                    });
                PLVideoPageView.i(this.a).startAnimation(animation);
              }
            }3000L);
        return;
      } 
      Log.c(m, "video size is 0");
    } 
  }
  
  protected void onAttachedToWindow() {
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onAttachedToWindow: ");
    stringBuilder.append(this);
    Log.c(str, stringBuilder.toString());
    super.onAttachedToWindow();
    s();
    if (this.f != null)
      this.f.setVisibility(0); 
  }
  
  protected void onDetachedFromWindow() {
    String str = m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onDetachedFromWindow url = ");
    stringBuilder.append(getPlayUrl());
    stringBuilder.append(", ");
    stringBuilder.append(this);
    Log.c(str, stringBuilder.toString());
    if (b())
      this.d.f(); 
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
  }
  
  public void setOnPLVideoListener(OnPLVideoListener paramOnPLVideoListener) {
    this.y = paramOnPLVideoListener;
  }
  
  @Deprecated
  public void setPauseDrop(boolean paramBoolean) {
    if (this.j != null)
      this.j.q = paramBoolean; 
  }
  
  public void setVolumeProgress(int paramInt) {
    this.q.setProgress(paramInt);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setFillAfter(false);
    alphaAnimation.setDuration(1000L);
    this.q.setAnimation((Animation)alphaAnimation);
    alphaAnimation.start();
    this.q.setVisibility(0);
    AppInfo.n().removeCallbacks(this.n);
    AppInfo.n().postDelayed(this.n, 1000L);
  }
  
  public static interface OnPLVideoListener {
    void a(long param1Long1, long param1Long2);
    
    void b();
    
    void bc_();
    
    void bd_();
    
    void c();
    
    void g_(int param1Int);
  }
  
  public static interface OnSeekListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\view\PLVideoPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */