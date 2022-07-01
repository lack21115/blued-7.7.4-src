package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;

public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.c {
  int a = 1;
  
  boolean b = false;
  
  boolean c = true;
  
  int d;
  
  private ExpressVideoView t;
  
  private a u;
  
  private long v;
  
  private long w;
  
  public NativeExpressVideoView(Context paramContext, k paramk, AdSlot paramAdSlot, String paramString) {
    super(paramContext, paramk, paramAdSlot, paramString);
  }
  
  private void b(m paramm) {
    if (paramm == null)
      return; 
    if (Looper.myLooper() == Looper.getMainLooper()) {
      c(paramm);
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramm) {
          public void run() {
            NativeExpressVideoView.a(this.b, this.a);
          }
        });
  }
  
  private void c(m paramm) {
    if (paramm == null)
      return; 
    double d1 = paramm.d();
    double d2 = paramm.e();
    double d3 = paramm.f();
    double d4 = paramm.g();
    int i = (int)ai.a(this.f, (float)d1);
    int j = (int)ai.a(this.f, (float)d2);
    int k = (int)ai.a(this.f, (float)d3);
    int n = (int)ai.a(this.f, (float)d4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("videoWidth:");
    stringBuilder.append(d3);
    t.b("ExpressView", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("videoHeight:");
    stringBuilder.append(d4);
    t.b("ExpressView", stringBuilder.toString());
    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)this.m.getLayoutParams();
    FrameLayout.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new FrameLayout.LayoutParams(k, n); 
    layoutParams1.width = k;
    layoutParams1.height = n;
    layoutParams1.topMargin = j;
    layoutParams1.leftMargin = i;
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.m.removeAllViews();
    this.m.addView((View)this.t);
    this.t.a(0L, true, false);
    setShowAdInteractionView(false);
  }
  
  private void n() {
    try {
      this.u = new a();
      this.t = new ExpressVideoView(this.f, this.k, this.i);
      this.t.setShouldCheckNetChange(false);
      this.t.setControllerStatusCallBack(new NativeVideoTsView.a(this) {
            public void a(boolean param1Boolean1, long param1Long1, long param1Long2, long param1Long3, boolean param1Boolean2) {
              (NativeExpressVideoView.a(this.a)).a = param1Boolean1;
              (NativeExpressVideoView.a(this.a)).e = param1Long1;
              (NativeExpressVideoView.a(this.a)).f = param1Long2;
              (NativeExpressVideoView.a(this.a)).g = param1Long3;
              (NativeExpressVideoView.a(this.a)).d = param1Boolean2;
            }
          });
      this.t.setVideoAdLoadListener(this);
      this.t.setVideoAdInteractionListener(this);
      boolean bool = "embeded_ad".equals(this.i);
      if (bool) {
        ExpressVideoView expressVideoView = this.t;
        if (this.b) {
          bool = this.j.isAutoPlay();
        } else {
          bool = this.c;
        } 
        expressVideoView.setIsAutoPlay(bool);
      } else if ("splash_ad".equals(this.i)) {
        this.t.setIsAutoPlay(true);
      } else {
        this.t.setIsAutoPlay(this.c);
      } 
      if ("splash_ad".equals(this.i)) {
        this.t.setIsQuiet(true);
      } else {
        this.t.setIsQuiet(o.h().a(this.d));
      } 
      this.t.d();
      return;
    } catch (Exception exception) {
      this.t = null;
      return;
    } 
  }
  
  private void setShowAdInteractionView(boolean paramBoolean) {
    ExpressVideoView expressVideoView = this.t;
    if (expressVideoView != null)
      expressVideoView.setShowAdInteractionView(paramBoolean); 
  }
  
  public void J() {
    t.b("NativeExpressVideoView", "onSkipVideo");
  }
  
  public long K() {
    return this.v;
  }
  
  public int L() {
    return this.t.getNativeVideoController().w() ? 1 : this.a;
  }
  
  public void M() {}
  
  protected void a() {
    this.m = new FrameLayout(this.f);
    this.d = ah.d(this.k.P());
    a(this.d);
    n();
    addView((View)this.m, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    super.a();
    getWebView().setBackgroundColor(0);
  }
  
  void a(int paramInt) {
    paramInt = o.h().c(paramInt);
    if (3 == paramInt) {
      this.b = false;
      this.c = false;
      return;
    } 
    if (1 == paramInt && w.d(this.f)) {
      this.b = false;
      this.c = true;
      return;
    } 
    if (2 == paramInt) {
      if (w.e(this.f) || w.d(this.f)) {
        this.b = false;
        this.c = true;
        return;
      } 
    } else if (4 == paramInt) {
      this.b = true;
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onVideoError,errorCode:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",extraCode:");
    stringBuilder.append(paramInt2);
    t.b("NativeExpressVideoView", stringBuilder.toString());
    if (this.l != null)
      this.l.onVideoError(paramInt1, paramInt2); 
    this.v = this.w;
    this.a = 4;
  }
  
  public void a(int paramInt, i parami) {
    if (paramInt != -1) {
      ExpressVideoView expressVideoView;
      if (parami == null)
        return; 
      if (paramInt == 4 && this.i == "draw_ad") {
        expressVideoView = this.t;
        if (expressVideoView != null)
          expressVideoView.performClick(); 
        return;
      } 
      super.a(paramInt, (i)expressVideoView);
    } 
  }
  
  public void a(long paramLong1, long paramLong2) {
    if (this.l != null)
      this.l.onProgressUpdate(paramLong1, paramLong2); 
    int i = this.a;
    if (i != 5 && i != 3 && paramLong1 > this.v)
      this.a = 2; 
    this.v = paramLong1;
    this.w = paramLong2;
  }
  
  public void a(m paramm) {
    if (paramm != null && paramm.a())
      b(paramm); 
    super.a(paramm);
  }
  
  protected void b() {
    super.b();
    this.h.a(this);
  }
  
  public void c() {
    t.b("NativeExpressVideoView", "onVideoAdContinuePlay");
    if (this.l != null)
      this.l.onVideoAdContinuePlay(); 
    this.n = false;
    this.a = 2;
  }
  
  public void d() {
    t.b("NativeExpressVideoView", "onVideoAdPaused");
    if (this.l != null)
      this.l.onVideoAdPaused(); 
    this.n = true;
    this.a = 3;
  }
  
  public void d(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onChangeVideoState,stateType:");
    stringBuilder.append(paramInt);
    t.b("NativeExpressVideoView", stringBuilder.toString());
    if (paramInt != 1) {
      if (paramInt != 2 && paramInt != 3) {
        if (paramInt != 4) {
          if (paramInt != 5)
            return; 
          this.t.a(0L, true, false);
          return;
        } 
        this.t.getNativeVideoController().l();
        return;
      } 
      this.t.setCanInterruptVideoPlay(true);
      this.t.performClick();
      return;
    } 
    this.t.a(0L, true, false);
  }
  
  public void d_() {
    t.b("NativeExpressVideoView", "onVideoComplete");
    if (this.l != null)
      this.l.onVideoAdComplete(); 
    this.a = 5;
  }
  
  public void e() {
    t.b("NativeExpressVideoView", "onVideoAdStartPlay");
    if (this.l != null)
      this.l.onVideoAdStartPlay(); 
    this.a = 2;
  }
  
  public void e(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onMuteVideo,mute:");
    stringBuilder.append(paramBoolean);
    t.b("NativeExpressVideoView", stringBuilder.toString());
    ExpressVideoView expressVideoView = this.t;
    if (expressVideoView != null && expressVideoView.getNativeVideoController() != null)
      this.t.getNativeVideoController().c(paramBoolean); 
  }
  
  public void f() {
    t.b("NativeExpressVideoView", "onVideoLoad");
    if (this.l != null)
      this.l.onVideoLoad(); 
  }
  
  public a getVideoModel() {
    return this.u;
  }
  
  public void setCanInterruptVideoPlay(boolean paramBoolean) {
    ExpressVideoView expressVideoView = this.t;
    if (expressVideoView != null)
      expressVideoView.setCanInterruptVideoPlay(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\NativeExpressVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */