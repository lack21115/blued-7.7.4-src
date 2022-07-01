package com.blued.android.module.live.base.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

public class SuperPlaneView extends BaseLiveAnimationView {
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private View e;
  
  private ImageView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private FrameLayout i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private TranslateAnimation m;
  
  private TranslateAnimation n;
  
  public SuperPlaneView(Context paramContext) {
    this.b = paramContext;
    e();
  }
  
  private void e() {
    this.c = LayoutInflater.from(this.b);
    this.d = this.c.inflate(R.layout.layout_sports_plane_anim, null);
    this.e = this.d.findViewById(R.id.plane_root_view);
    this.f = (ImageView)this.d.findViewById(R.id.plane_back_propeller);
    this.g = (ImageView)this.d.findViewById(R.id.super_plane);
    this.h = (ImageView)this.d.findViewById(R.id.plane_propeller);
    this.i = (FrameLayout)this.d.findViewById(R.id.cloud_layout);
    this.j = (ImageView)this.d.findViewById(R.id.cloud1);
    this.k = (ImageView)this.d.findViewById(R.id.cloud2);
    this.l = (ImageView)this.d.findViewById(R.id.cloud3);
  }
  
  private void f() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(1000L);
    this.i.startAnimation((Animation)alphaAnimation);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperPlaneView.a(this.a).setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  private void g() {
    this.n = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.3F);
    this.n.setInterpolator((Interpolator)new AccelerateInterpolator());
    this.n.setDuration(1000L);
    this.e.startAnimation((Animation)this.n);
    this.n.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            if (this.a.a != null)
              this.a.a.b(); 
            SuperPlaneView.d(this.a).setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            SuperPlaneView.c(this.a);
          }
        });
  }
  
  public View a() {
    return this.d;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    this.e.setVisibility(0);
    this.m = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, -0.3F, 2, 0.0F);
    this.m.setInterpolator((Interpolator)new DecelerateInterpolator());
    this.m.setDuration(1000L);
    this.m.setFillAfter(true);
    this.e.startAnimation((Animation)this.m);
    this.m.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.c();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            if (this.a.a != null)
              this.a.a.a(); 
            this.a.d();
            this.a.b();
          }
        });
  }
  
  public void b() {
    this.i.setVisibility(0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(2000L);
    TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0F, 2, 1.0F, 2, 0.5F, 2, -0.3F);
    translateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation.setDuration(5500L);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)translateAnimation);
    animationSet.setFillAfter(true);
    this.l.startAnimation((Animation)animationSet);
    translateAnimation = new TranslateAnimation(2, -0.3F, 2, 1.0F, 2, 0.2F, 2, -0.3F);
    translateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation.setDuration(7000L);
    animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)translateAnimation);
    animationSet.setFillAfter(true);
    this.j.startAnimation((Animation)animationSet);
    translateAnimation = new TranslateAnimation(2, -0.8F, 2, 1.0F, 2, 0.4F, 2, -0.3F);
    translateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation.setDuration(12000L);
    animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)translateAnimation);
    animationSet.setFillAfter(true);
    this.k.startAnimation((Animation)animationSet);
  }
  
  public void c() {
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this.e, "translationX", new float[] { 0.0F, 30.0F, -30.0F, 0.0F });
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { 0.0F, -30.0F, -30.0F, 0.0F });
    objectAnimator1.setInterpolator((TimeInterpolator)new LinearInterpolator());
    objectAnimator1.setDuration(2000L);
    objectAnimator2.setInterpolator((TimeInterpolator)new LinearInterpolator());
    objectAnimator2.setDuration(2000L);
    objectAnimator1.start();
    objectAnimator2.start();
    objectAnimator2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            SuperPlaneView.b(this.a);
          }
        });
  }
  
  public void d() {
    RotateAnimation rotateAnimation = new RotateAnimation(0.0F, 1080.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(700L);
    rotateAnimation.setRepeatCount(-1);
    rotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    this.f.startAnimation((Animation)rotateAnimation);
    rotateAnimation = new RotateAnimation(0.0F, 3600.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(5000L);
    rotateAnimation.setRepeatCount(-1);
    rotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    this.h.startAnimation((Animation)rotateAnimation);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\SuperPlaneView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */