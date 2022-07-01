package com.blued.android.module.player.media.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.R;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.LiveSysNetworkObserver;

public class PLTextureVideoViewINT extends AbsPlayerView implements LiveSysNetworkObserver.ILiveSysNetworkObserver {
  Handler m = new Handler();
  
  Runnable n = new Runnable(this) {
      public void run() {
        if (this.a.d != null && this.a.i.getChildCount() > 0) {
          if (this.a.d.e()) {
            long l1 = this.a.d.getCurrentPosition();
            long l2 = this.a.d.getDuration();
            PLTextureVideoViewINT.a(this.a).a(l1, l2);
          } 
          if (this.a.d.e())
            this.a.m.postDelayed(this.a.n, 100L); 
        } 
      }
    };
  
  private ImageView o;
  
  private ImageView p;
  
  private float q = 1.0F;
  
  private float r = 1.0F;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private OnVideoSizeChangedListener v;
  
  private OnMuteListener w;
  
  private MediaControllerINT x;
  
  private final AbBaseVideoView.OnVideoStatusListener y = new AbBaseVideoView.OnVideoStatusListener(this) {
      public void a() {
        if (this.a.j != null && this.a.j.m) {
          Log.c("PLTextureVideoViewINT", "MEDIA_INFO_BUFFERING_START pause==============");
          AppInfo.n().post(new Runnable(this) {
                public void run() {
                  this.a.e();
                }
              });
          return;
        } 
        AppInfo.n().post(new -$$Lambda$PLTextureVideoViewINT$2$JQhjrfpxXUR7GXiFUj4r0Jc13yU(this));
      }
      
      public void a(int param1Int1, int param1Int2) {
        if (PLTextureVideoViewINT.b(this.a) != null)
          PLTextureVideoViewINT.b(this.a).a(param1Int1, param1Int2); 
      }
      
      public void b() {}
      
      public void c() {
        Log.c("PLTextureVideoViewINT", "MEDIA_INFO_BUFFERING_END");
        if (this.a.j != null && this.a.j.m) {
          Log.c("PLTextureVideoViewINT", "MEDIA_INFO_BUFFERING_END pause==============");
          AppInfo.n().post(new -$$Lambda$PLTextureVideoViewINT$2$F_D4EWX6IjKz5ubClT8djPTKcjs(this));
          return;
        } 
        AppInfo.n().post(new -$$Lambda$PLTextureVideoViewINT$2$wY19g5jqGuj63PhPeG5fJI8G0j8(this));
      }
      
      public void d() {
        Log.c("PLTextureVideoViewINT", "MEDIA_INFO_VIDEO_RENDERING_START");
        if (this.a.j != null && this.a.j.m) {
          Log.c("PLTextureVideoViewINT", "MEDIA_INFO_VIDEO_RENDERING_START pause==============");
          AppInfo.n().post(new -$$Lambda$PLTextureVideoViewINT$2$MS1Q0bCdZq9T-yYP_jHa-MKl1Os(this));
          return;
        } 
        AppInfo.n().post(new -$$Lambda$PLTextureVideoViewINT$2$leKKl-trhDVbRL2tJE4U6IsaZ3s(this));
      }
      
      public void e() {}
    };
  
  public PLTextureVideoViewINT(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PLTextureVideoViewINT(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PLTextureVideoViewINT(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    r();
  }
  
  private void a(View paramView) {
    if (paramView != null) {
      if (paramView.getVisibility() != 0)
        return; 
      AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      alphaAnimation.setFillAfter(false);
      alphaAnimation.setDuration(500L);
      paramView.setAnimation((Animation)alphaAnimation);
      alphaAnimation.start();
      paramView.setVisibility(8);
    } 
  }
  
  private AbBaseVideoView getVideoView() {
    AbBaseVideoView abBaseVideoView2 = this.l.a(this.j.b);
    AbBaseVideoView abBaseVideoView1 = abBaseVideoView2;
    if (abBaseVideoView2 == null)
      abBaseVideoView1 = this.l.a(this.j.b, getContext()); 
    if (abBaseVideoView1 != null) {
      for (ViewParent viewParent = abBaseVideoView1.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
        if (viewParent instanceof PLTextureVideoViewINT) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("insetPlayTextureView has old parent =");
          stringBuilder.append(this.j.b);
          Log.c("PLTextureVideoViewINT", stringBuilder.toString());
          ((PLTextureVideoViewINT)viewParent).k();
          a(abBaseVideoView1);
          break;
        } 
      } 
      if (this.i.getChildCount() == 0) {
        this.d = abBaseVideoView1;
        this.d.a(this.j);
        this.i.addView((View)this.d);
        s();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insetPlayTextureView new mVideoRoot URL");
        stringBuilder.append(this.j.b);
        Log.c("PLTextureVideoViewINT", stringBuilder.toString());
      } else {
        Log.c("PLTextureVideoViewINT", "insetPlayTextureView mVideoRoot.getChildCount() != 0");
      } 
      this.d.a(this.j);
    } 
    return this.d;
  }
  
  private void m() {
    if (this.j == null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("startPlay discard, mPlayConfig = null + ");
      stringBuilder1.append(this);
      Log.c("PLTextureVideoViewINT", stringBuilder1.toString());
      return;
    } 
    if (!b()) {
      Log.d("PLTextureVideoViewINT", "start mVideoRoot.getChildCount() == 0");
      return;
    } 
    if (j()) {
      Log.c("PLTextureVideoViewINT", "start 3");
      return;
    } 
    this.j.m = false;
    this.d.b();
    this.g.setVisibility(8);
    setVisible(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start:");
    stringBuilder.append(this.j.b);
    Log.c("PLTextureVideoViewINT", stringBuilder.toString());
  }
  
  private void n() {
    Context context = getContext();
    if (context != null && context instanceof Activity)
      ((Activity)context).setRequestedOrientation(4); 
  }
  
  private void o() {
    if (b())
      this.d.f(); 
  }
  
  private void p() {
    this.g.setVisibility(8);
    setVisible(0);
    m();
  }
  
  private void q() {
    if (this.j == null)
      return; 
    this.d = getVideoView();
    if (this.d == null)
      return; 
    this.x.setAncherView(this.d);
    this.d.a(this.j);
    this.j.m = false;
    if (this.j.j) {
      this.q = 1.0F;
      this.r = 1.0F;
      this.d.a(1.0F, 1.0F);
    } else {
      this.q = 0.0F;
      this.r = 0.0F;
      this.d.a(0.0F, 0.0F);
    } 
    this.d.b();
    this.m.removeCallbacks(this.n);
    this.m.post(this.n);
  }
  
  private void r() {
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.pl_texture_video_view_international, (ViewGroup)this);
    this.i = (FrameLayout)this.c.findViewById(R.id.video_root);
    this.e = this.c.findViewById(R.id.cover_view);
    this.e.setVisibility(0);
    this.f = (ImageView)this.c.findViewById(R.id.preview);
    this.g = (ImageView)this.c.findViewById(R.id.video_state_icon);
    this.o = (ImageView)this.c.findViewById(R.id.video_screent_icon);
    this.p = (ImageView)this.c.findViewById(R.id.video_voice_icon);
    this.h = this.c.findViewById(R.id.LoadingView);
    this.x = (MediaControllerINT)this.c.findViewById(R.id.seek_lay);
    LiveSysNetworkObserver.a().a(this);
    Log.c("PLTextureVideoViewINT", "init");
  }
  
  private void s() {
    if (this.j != null && b()) {
      this.d.a(true);
      this.d.setOnVideoStatusListener((AbBaseVideoView.OnVideoStatusListener)null);
      this.d.setOnVideoStatusListener(this.y);
      this.q = 0.0F;
      this.r = 0.0F;
      if (this.j.j)
        b(this.j.u); 
    } 
  }
  
  private void setCoverView(ImageView.ScaleType paramScaleType) {
    ImageWrapper imageWrapper;
    this.f.setVisibility(0);
    this.f.setScaleType(paramScaleType);
    if (!TextUtils.isEmpty(this.j.a) && !this.j.a.contains("http")) {
      imageWrapper = ImageLoader.d(null, this.j.a);
    } else {
      imageWrapper = ImageLoader.a(null, this.j.a);
    } 
    imageWrapper.a(R.drawable.video_international_default).a(this.f);
  }
  
  private void setVideoSize(VideoPlayConfig paramVideoPlayConfig) {
    FrameLayout.LayoutParams layoutParams;
    if (this.j == null)
      return; 
    if (this.j.j) {
      layoutParams = new FrameLayout.LayoutParams(-1, -1);
      layoutParams.gravity = 17;
      if (this.j.t) {
        this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        setCoverView(ImageView.ScaleType.FIT_CENTER);
        return;
      } 
      this.f.setVisibility(8);
      return;
    } 
    if (this.j.a() == 0 || this.j.b() == 0) {
      this.j.e = 0;
      this.j.f = 0;
      this.j.a(0);
      this.j.b(0);
      return;
    } 
    this.j.e = ((VideoPlayConfig)layoutParams).e;
    this.j.f = ((VideoPlayConfig)layoutParams).f;
    this.j.b(layoutParams.b());
    this.j.a(layoutParams.a());
  }
  
  private void setVisible(int paramInt) {
    if (paramInt == 0) {
      if (this.s) {
        ImageView imageView = this.o;
        if (imageView != null)
          imageView.setVisibility(paramInt); 
      } 
      if (this.s) {
        ImageView imageView = this.p;
        if (imageView != null) {
          imageView.setVisibility(paramInt);
          return;
        } 
      } 
    } else {
      ImageView imageView = this.o;
      if (imageView != null)
        imageView.setVisibility(paramInt); 
      imageView = this.p;
      if (imageView != null)
        imageView.setVisibility(paramInt); 
    } 
  }
  
  private void t() {
    this.f.setVisibility(0);
    this.h.setVisibility(8);
    this.g.setVisibility(0);
    setVisible(8);
  }
  
  private void u() {
    if (this.g != null)
      this.g.setOnClickListener(new -$$Lambda$PLTextureVideoViewINT$9EAnpc21n-U0PFy-bedF8WZjRa4(this)); 
    ImageView imageView = this.p;
    if (imageView != null)
      imageView.setOnClickListener(new -$$Lambda$PLTextureVideoViewINT$mbGX79NOmkDeuZJweS0bbynwPN8(this)); 
    imageView = this.o;
    if (imageView != null)
      imageView.setOnClickListener(new -$$Lambda$PLTextureVideoViewINT$zJNwlE4HjsbpVk2LuBXqdNxCpJ8(this)); 
    this.c.setOnClickListener(new -$$Lambda$PLTextureVideoViewINT$wKJxSnmLzVQw04JelmLv7KRvbPo(this));
    this.c.setOnLongClickListener(new -$$Lambda$PLTextureVideoViewINT$yHp1Gr6ZyWxoDQLnIcvXjSfQsAo(this));
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      l();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("isVisibleToUser loadVideoWithPlay =  ");
      stringBuilder1.append(this.j.b);
      Log.a("PLTextureVideoViewINT", stringBuilder1.toString());
      return;
    } 
    k();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isVisibleToUser resetLayout =  ");
    stringBuilder.append(this.j.b);
    Log.a("PLTextureVideoViewINT", stringBuilder.toString());
  }
  
  public void b(VideoPlayConfig paramVideoPlayConfig) {
    if (!a(paramVideoPlayConfig))
      return; 
    if (this.j == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("loadVideo:");
    stringBuilder.append(this.j.a());
    stringBuilder.append("  :");
    stringBuilder.append(this.j.b());
    Log.c("PLTextureVideoViewINT", stringBuilder.toString());
    setVideoSize(paramVideoPlayConfig);
    if (paramVideoPlayConfig.t) {
      setCoverView(ImageView.ScaleType.CENTER_CROP);
    } else {
      this.f.setVisibility(8);
    } 
    k();
    u();
  }
  
  public void b(boolean paramBoolean) {
    if (this.j != null)
      this.j.u = paramBoolean; 
    if (this.d != null && !paramBoolean) {
      if (!paramBoolean)
        this.x.setVisibility(0); 
      n();
    } 
  }
  
  public void c() {
    this.q = 0.0F;
    this.r = 0.0F;
    if (b())
      this.d.a(this.q, this.r); 
    ImageView imageView = this.p;
    if (imageView != null)
      imageView.setImageResource(R.drawable.video_international_mute_icon); 
    OnMuteListener onMuteListener = this.w;
    if (onMuteListener != null)
      onMuteListener.a(true); 
  }
  
  public void d() {
    this.q = 1.0F;
    this.r = 1.0F;
    if (b())
      this.d.a(this.q, this.r); 
    ImageView imageView = this.p;
    if (imageView != null)
      imageView.setImageResource(R.drawable.video_international_unmute_icon); 
    OnMuteListener onMuteListener = this.w;
    if (onMuteListener != null)
      onMuteListener.a(false); 
  }
  
  public void e() {
    if (!b())
      return; 
    this.g.setVisibility(0);
    setVisible(8);
    this.h.setVisibility(8);
    if (this.j != null)
      this.j.m = true; 
    this.d.d();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pause :");
    stringBuilder.append(this.j.b);
    Log.c("PLTextureVideoViewINT", stringBuilder.toString());
  }
  
  public void f() {
    if (!b()) {
      l();
      return;
    } 
    if (j()) {
      i();
      return;
    } 
    m();
  }
  
  public void g() {
    e();
  }
  
  public void h() {
    Log.c("PLTextureVideoViewINT", "onDestroy ##########:");
    o();
    if (this.j != null && this.j.g != null)
      this.j.g = null; 
    if (this.j != null && this.j.h != null)
      this.j.h = null; 
    if (this.h != null)
      this.h.setVisibility(8); 
    if (this.w != null)
      this.w = null; 
    if (this.v != null)
      this.v = null; 
    if (b()) {
      this.d.c();
      a(this.d);
    } 
  }
  
  public void i() {
    if (!b()) {
      l();
      return;
    } 
    if (a()) {
      g();
      return;
    } 
    p();
  }
  
  public boolean j() {
    return (this.g.getVisibility() == 0);
  }
  
  public void k() {
    e();
    t();
  }
  
  public void l() {
    this.h.setVisibility(0);
    this.g.setVisibility(8);
    setVisible(0);
    q();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.g.setVisibility(0);
    if (this.f != null)
      this.f.setVisibility(0); 
  }
  
  protected void onDetachedFromWindow() {
    Log.c("PLTextureVideoViewINT", "onDetachedFromWindow");
    if (b())
      this.d.f(); 
    LiveSysNetworkObserver.a().b(this);
    super.onDetachedFromWindow();
  }
  
  public void setConfigInfo(VideoPlayConfig paramVideoPlayConfig) {
    if (paramVideoPlayConfig != null) {
      this.j = paramVideoPlayConfig;
      b(paramVideoPlayConfig.s);
    } 
  }
  
  public void setManageAudioFocus(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void setOnMuteListener(OnMuteListener paramOnMuteListener) {
    this.w = paramOnMuteListener;
  }
  
  public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {
    this.v = paramOnVideoSizeChangedListener;
  }
  
  public void setScreenIconVisible(boolean paramBoolean) {
    this.s = paramBoolean;
  }
  
  public void setVoiceVisible(boolean paramBoolean) {
    this.t = paramBoolean;
  }
  
  public void setVolumeProgress(int paramInt) {}
  
  public static interface OnVideoSizeChangedListener {
    void a(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\view\PLTextureVideoViewINT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */