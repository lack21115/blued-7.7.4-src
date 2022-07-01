package com.bytedance.sdk.openadsdk.component.reward.view;

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
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;

public class FullRewardExpressView extends NativeExpressView implements g {
  g a;
  
  FullRewardExpressBackupView b;
  
  public FullRewardExpressView(Context paramContext, k paramk, AdSlot paramAdSlot, String paramString) {
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
            FullRewardExpressView.a(this.b, this.a);
          }
        });
  }
  
  private void c() {
    setBackupListener(new c(this) {
          public boolean a(NativeExpressView param1NativeExpressView, int param1Int) {
            param1NativeExpressView.l();
            this.a.b = new FullRewardExpressBackupView(param1NativeExpressView.getContext());
            this.a.b.a(FullRewardExpressView.a(this.a), param1NativeExpressView, null);
            return true;
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
  }
  
  public void J() {
    t.b("FullRewardExpressView", "onSkipVideo");
    g g1 = this.a;
    if (g1 != null)
      g1.J(); 
  }
  
  public long K() {
    t.b("FullRewardExpressView", "onGetCurrentPlayTime");
    g g1 = this.a;
    return (g1 != null) ? g1.K() : 0L;
  }
  
  public int L() {
    t.b("FullRewardExpressView", "onGetVideoState");
    g g1 = this.a;
    return (g1 != null) ? g1.L() : 0;
  }
  
  public void M() {
    g g1 = this.a;
    if (g1 != null)
      g1.M(); 
  }
  
  public void a() {
    this.o = true;
    this.m = new FrameLayout(this.f);
    addView((View)this.m, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    super.a();
    getWebView().setBackgroundColor(0);
    c();
  }
  
  public void a(int paramInt, i parami) {
    if (paramInt != -1 && parami != null && paramInt == 3)
      M(); 
    super.a(paramInt, parami);
  }
  
  public void a(m paramm) {
    if (paramm != null && paramm.a())
      b(paramm); 
    super.a(paramm);
  }
  
  public void b() {
    super.b();
    this.h.a(this);
  }
  
  public void d(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onChangeVideoState,stateType:");
    stringBuilder.append(paramInt);
    t.b("FullRewardExpressView", stringBuilder.toString());
    g g1 = this.a;
    if (g1 != null)
      g1.d(paramInt); 
  }
  
  public void e(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onMuteVideo,mute:");
    stringBuilder.append(paramBoolean);
    t.b("FullRewardExpressView", stringBuilder.toString());
    g g1 = this.a;
    if (g1 != null)
      g1.e(paramBoolean); 
  }
  
  public FrameLayout getVideoFrameLayout() {
    return m() ? this.b.getVideoContainer() : this.m;
  }
  
  public void setExpressVideoListenerProxy(g paramg) {
    this.a = paramg;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\view\FullRewardExpressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */