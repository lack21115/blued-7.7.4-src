package com.blued.android.module.live.base.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

public class SuperCarView extends BaseLiveAnimationView {
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private ImageView e;
  
  private ImageView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private ImageView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private TranslateAnimation m;
  
  private TranslateAnimation n;
  
  private AnimationDrawable o;
  
  public SuperCarView(Context paramContext) {
    this.b = paramContext;
    e();
  }
  
  private void a(Interpolator paramInterpolator, long paramLong) {
    RotateAnimation rotateAnimation = new RotateAnimation(0.0F, -1080.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(paramLong);
    rotateAnimation.setInterpolator(paramInterpolator);
    this.f.startAnimation((Animation)rotateAnimation);
    this.g.startAnimation((Animation)rotateAnimation);
  }
  
  private void e() {
    this.c = LayoutInflater.from(this.b);
    this.d = this.c.inflate(R.layout.layout_sports_car_anim, null);
    this.e = (ImageView)this.d.findViewById(R.id.super_car);
    this.f = (ImageView)this.d.findViewById(R.id.super_wheel1);
    this.g = (ImageView)this.d.findViewById(R.id.super_wheel2);
    this.h = (ImageView)this.d.findViewById(R.id.car_flash_light);
    this.i = (ImageView)this.d.findViewById(R.id.car_lightning);
    this.j = (ImageView)this.d.findViewById(R.id.automative_lighting);
    this.l = (ImageView)this.d.findViewById(R.id.car_right_door);
    this.k = (ImageView)this.d.findViewById(R.id.car_left_door);
    this.h.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private void f() {
    this.n = new TranslateAnimation(2, 0.0F, 2, -1.0F, 0, 0.0F, 0, 0.0F);
    this.n.setInterpolator((Interpolator)new AccelerateInterpolator());
    this.n.setDuration(1000L);
    this.d.startAnimation((Animation)this.n);
    this.n.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperCarView.c(this.a).setVisibility(8);
            if (this.a.a != null)
              this.a.a.b(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            SuperCarView.a(this.a, (Interpolator)new AccelerateInterpolator(), 1000L);
          }
        });
  }
  
  private void g() {
    this.h.setVisibility(0);
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this.h, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this.h, "alpha", new float[] { 1.0F, 0.0F });
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playSequentially(new Animator[] { (Animator)objectAnimator1, (Animator)objectAnimator2 });
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            SuperCarView.d(this.a).setVisibility(8);
          }
        });
    animatorSet.setDuration(800L);
    animatorSet.start();
  }
  
  private void h() {
    ImageView imageView = this.i;
    int i = 0;
    imageView.setVisibility(0);
    this.o = new AnimationDrawable();
    while (i <= 36) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("lightning_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.o.addFrame(drawable, 50);
      i++;
    } 
    this.o.setOneShot(true);
    this.i.setImageDrawable((Drawable)this.o);
    this.o.start();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCarView.g(this.a).setVisibility(8);
            SuperCarView.g(this.a).clearAnimation();
            SuperCarView.a(this.a, (AnimationDrawable)null);
          }
        }1800L);
  }
  
  public View a() {
    return this.d;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    this.d.setVisibility(0);
    this.m = new TranslateAnimation(2, 1.0F, 2, 0.0F, 0, 0.0F, 0, 0.0F);
    this.m.setInterpolator((Interpolator)new DecelerateInterpolator());
    this.m.setDuration(1000L);
    this.m.setFillAfter(true);
    this.d.startAnimation((Animation)this.m);
    this.m.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperCarView.a(this.a);
            this.a.c();
            SuperCarView.b(this.a);
            this.a.b();
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    this.a.a.d();
                  }
                },  2000L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            if (this.a.a != null)
              this.a.a.a(); 
            SuperCarView.a(this.a, (Interpolator)new DecelerateInterpolator(), 1000L);
          }
        });
  }
  
  public void b() {
    this.j.setVisibility(0);
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this.j, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this.j, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(this.j, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(this.j, "alpha", new float[] { 1.0F, 0.0F });
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playSequentially(new Animator[] { (Animator)objectAnimator1, (Animator)objectAnimator2, (Animator)objectAnimator3, (Animator)objectAnimator4 });
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            SuperCarView.e(this.a).setVisibility(8);
          }
        });
    animatorSet.setDuration(300L);
    animatorSet.start();
  }
  
  public void c() {
    RotateAnimation rotateAnimation = new RotateAnimation(0.0F, -35.0F, 1, 0.0F, 1, 0.4F);
    rotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    rotateAnimation.setDuration(300L);
    rotateAnimation.setFillAfter(true);
    this.k.startAnimation((Animation)rotateAnimation);
    this.l.startAnimation((Animation)rotateAnimation);
    rotateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void d() {
    RotateAnimation rotateAnimation = new RotateAnimation(-35.0F, 0.0F, 1, 0.0F, 1, 0.4F);
    rotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    rotateAnimation.setDuration(300L);
    rotateAnimation.setFillAfter(true);
    this.k.startAnimation((Animation)rotateAnimation);
    this.l.startAnimation((Animation)rotateAnimation);
    rotateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperCarView.f(this.a);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\SuperCarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */