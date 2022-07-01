package com.bytedance.sdk.openadsdk.component.banner;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;

class d extends FrameLayout {
  private final Context a;
  
  private c b;
  
  private c c;
  
  private ImageView d;
  
  private ImageView e;
  
  private b f;
  
  private int g;
  
  private boolean h;
  
  private boolean i = false;
  
  private boolean j = false;
  
  public d(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    g();
  }
  
  private ObjectAnimator a(c paramc) {
    return ObjectAnimator.ofFloat(paramc, "translationX", new float[] { 0.0F, -getWidth() });
  }
  
  private void a(k paramk) {
    b b1 = this.f;
    if (b1 != null && paramk != null)
      b1.a(paramk); 
  }
  
  private ObjectAnimator b(c paramc) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramc, "translationX", new float[] { getWidth(), 0.0F });
    objectAnimator.addListener(new Animator.AnimatorListener(this, paramc) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            d.a(this.b, false);
            d.b(this.b);
            c c1 = this.a;
            if (c1 != null)
              d.a(this.b, c1.a()); 
            t.b("TTBannerAd", "SLIDE END");
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            t.b("TTBannerAd", "SLIDE START");
          }
        });
    return objectAnimator;
  }
  
  private void g() {
    this.b = new c(this.a);
    addView((View)this.b, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    i();
    h();
  }
  
  private void h() {
    if (this.j)
      return; 
    this.j = true;
    this.d = new ImageView(this.a);
    this.d.setImageResource(ab.d(o.a(), "tt_dislike_icon"));
    this.d.setScaleType(ImageView.ScaleType.FIT_XY);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (d.a(this.a) != null)
              d.a(this.a).showDislikeDialog(); 
          }
        });
    int i = (int)ai.a(this.a, 15.0F);
    int j = (int)ai.a(this.a, 10.0F);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
    layoutParams.gravity = 8388661;
    layoutParams.topMargin = j;
    layoutParams.rightMargin = j;
    addView((View)this.d, (ViewGroup.LayoutParams)layoutParams);
    ai.a((View)this.d, i, i, i, i);
  }
  
  private void i() {
    if (this.i)
      return; 
    this.i = true;
    this.e = new ImageView(this.a);
    this.e.setImageResource(ab.d(o.a(), "tt_ad_logo_small"));
    this.e.setScaleType(ImageView.ScaleType.FIT_XY);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
    layoutParams.gravity = 8388693;
    addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void j() {
    ImageView imageView = this.e;
    if (imageView != null)
      bringChildToFront((View)imageView); 
    imageView = this.d;
    if (imageView != null)
      bringChildToFront((View)imageView); 
  }
  
  private void k() {
    c c1 = this.b;
    this.b = this.c;
    this.c = c1;
    this.c.b();
  }
  
  public void a() {
    this.c = new c(this.a);
    this.c.setVisibility(8);
    addView((View)this.c, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  void a(b paramb) {
    this.f = paramb;
  }
  
  public void addView(View paramView) {
    super.addView(paramView);
    j();
  }
  
  public void addView(View paramView, int paramInt) {
    super.addView(paramView, paramInt);
    j();
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2) {
    super.addView(paramView, paramInt1, paramInt2);
    j();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    j();
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramLayoutParams);
    j();
  }
  
  public c b() {
    return this.b;
  }
  
  public c c() {
    return this.c;
  }
  
  public View d() {
    return (View)this.d;
  }
  
  public void e() {
    if (!this.h) {
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.play((Animator)a(this.b)).with((Animator)b(this.c));
      animatorSet.setDuration(this.g).start();
      this.c.setVisibility(0);
      this.h = true;
    } 
  }
  
  public boolean f() {
    c c1 = this.c;
    return (c1 != null && c1.a() != null);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.i = false;
    this.j = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\banner\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */