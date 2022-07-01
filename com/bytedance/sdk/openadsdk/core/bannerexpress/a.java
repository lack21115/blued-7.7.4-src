package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ai;

class a extends FrameLayout {
  private final Context a;
  
  private NativeExpressView b;
  
  private NativeExpressView c;
  
  private k d;
  
  private AdSlot e;
  
  private TTNativeExpressAd.ExpressAdInteractionListener f;
  
  private int g;
  
  private boolean h;
  
  private String i = "banner_ad";
  
  public a(Context paramContext, k paramk, AdSlot paramAdSlot) {
    super(paramContext);
    this.a = paramContext;
    this.d = paramk;
    this.e = paramAdSlot;
    g();
  }
  
  private ObjectAnimator a(NativeExpressView paramNativeExpressView) {
    return ObjectAnimator.ofFloat(paramNativeExpressView, "translationX", new float[] { 0.0F, -getWidth() });
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    int i = (int)ai.a(this.a, paramFloat1);
    int j = (int)ai.a(this.a, paramFloat2);
    ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(i, j); 
    layoutParams1.width = i;
    layoutParams1.height = j;
    setLayoutParams(layoutParams1);
  }
  
  private ObjectAnimator b(NativeExpressView paramNativeExpressView) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramNativeExpressView, "translationX", new float[] { getWidth(), 0.0F });
    objectAnimator.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            a.a(this.a, false);
            a.c(this.a);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {}
        });
    return objectAnimator;
  }
  
  private void g() {
    this.b = new NativeExpressView(this.a, this.d, this.e, this.i);
    addView((View)this.b, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private void h() {
    if (!this.h) {
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.play((Animator)a(this.b)).with((Animator)b(this.c));
      animatorSet.setDuration(this.g).start();
      ai.a((View)this.c, 0);
      this.h = true;
    } 
  }
  
  private void i() {
    NativeExpressView nativeExpressView = this.b;
    this.b = this.c;
    this.c = nativeExpressView;
    nativeExpressView = this.c;
    if (nativeExpressView != null) {
      removeView((View)nativeExpressView);
      this.c.k();
      this.c = null;
    } 
  }
  
  public void a() {
    NativeExpressView nativeExpressView = this.b;
    if (nativeExpressView != null)
      nativeExpressView.h(); 
  }
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  public void a(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {
    this.f = paramExpressAdInteractionListener;
    this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) {
          public void onAdClicked(View param1View, int param1Int) {
            if (a.a(this.a) != null)
              a.a(this.a).onAdClicked((View)this.a, param1Int); 
          }
          
          public void onAdShow(View param1View, int param1Int) {}
          
          public void onRenderFail(View param1View, String param1String, int param1Int) {
            if (a.a(this.a) != null)
              a.a(this.a).onRenderFail((View)this.a, param1String, param1Int); 
          }
          
          public void onRenderSuccess(View param1View, float param1Float1, float param1Float2) {
            if (!(param1View instanceof NativeExpressView) || !((NativeExpressView)param1View).m())
              a.a(this.a, param1Float1, param1Float2); 
            if (a.a(this.a) != null)
              a.a(this.a).onRenderSuccess((View)this.a, param1Float1, param1Float2); 
          }
        });
  }
  
  public void a(k paramk, AdSlot paramAdSlot) {
    this.c = new NativeExpressView(this.a, paramk, paramAdSlot, this.i);
    this.c.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) {
          public void onAdClicked(View param1View, int param1Int) {
            if (a.a(this.a) != null)
              a.a(this.a).onAdClicked((View)this.a, param1Int); 
          }
          
          public void onAdShow(View param1View, int param1Int) {}
          
          public void onRenderFail(View param1View, String param1String, int param1Int) {}
          
          public void onRenderSuccess(View param1View, float param1Float1, float param1Float2) {
            a.a(this.a, param1Float1, param1Float2);
            a.b(this.a);
          }
        });
    ai.a((View)this.c, 8);
    addView((View)this.c, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void b() {
    NativeExpressView nativeExpressView = this.b;
    if (nativeExpressView != null) {
      removeView((View)nativeExpressView);
      this.b.k();
      this.b = null;
    } 
    nativeExpressView = this.c;
    if (nativeExpressView != null) {
      removeView((View)nativeExpressView);
      this.c.k();
      this.c = null;
    } 
  }
  
  public NativeExpressView c() {
    return this.b;
  }
  
  public NativeExpressView d() {
    return this.c;
  }
  
  public void e() {
    NativeExpressView nativeExpressView = this.c;
    if (nativeExpressView != null)
      nativeExpressView.h(); 
  }
  
  public boolean f() {
    return (this.c != null);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\bannerexpress\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */