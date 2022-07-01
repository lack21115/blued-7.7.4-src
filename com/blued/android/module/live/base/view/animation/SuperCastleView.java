package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

public class SuperCastleView extends BaseLiveAnimationView {
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private FrameLayout e;
  
  private ImageView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private FrameLayout i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private ImageView m;
  
  private ImageView n;
  
  private ImageView o;
  
  private ImageView p;
  
  private AnimationDrawable q;
  
  private AnimationDrawable r;
  
  public SuperCastleView(Context paramContext) {
    this.b = paramContext;
    c();
  }
  
  private void a(ImageView paramImageView) {
    int i = 0;
    paramImageView.setVisibility(0);
    this.r = new AnimationDrawable();
    while (i <= 20) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fireworks_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.r.addFrame(drawable, 50);
      i++;
    } 
    this.r.setOneShot(true);
    paramImageView.setImageDrawable((Drawable)this.r);
    this.r.start();
    AppInfo.n().postDelayed(new Runnable(this, paramImageView) {
          public void run() {
            this.a.setVisibility(8);
            this.a.clearAnimation();
            SuperCastleView.b(this.b, null);
          }
        }1050L);
  }
  
  private void c() {
    this.c = LayoutInflater.from(this.b);
    this.d = this.c.inflate(R.layout.layout_sports_castle_anim, null);
    this.e = (FrameLayout)this.d.findViewById(R.id.cloud_layout);
    this.f = (ImageView)this.d.findViewById(R.id.cloud1);
    this.g = (ImageView)this.d.findViewById(R.id.cloud2);
    this.h = (ImageView)this.d.findViewById(R.id.cloud3);
    this.i = (FrameLayout)this.d.findViewById(R.id.castle_root);
    this.j = (ImageView)this.d.findViewById(R.id.super_castle);
    this.k = (ImageView)this.d.findViewById(R.id.castle_flag);
    this.l = (ImageView)this.d.findViewById(R.id.fireworks1);
    this.m = (ImageView)this.d.findViewById(R.id.fireworks2);
    this.n = (ImageView)this.d.findViewById(R.id.fireworks3);
    this.o = (ImageView)this.d.findViewById(R.id.fireworks4);
    this.p = (ImageView)this.d.findViewById(R.id.fireworks5);
  }
  
  private void d() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(1000L);
    this.d.startAnimation((Animation)alphaAnimation);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperCastleView.h(this.a).setVisibility(8);
            SuperCastleView.i(this.a).setVisibility(8);
            if (this.a.a != null)
              this.a.a.b(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  private void e() {
    ImageView imageView = this.k;
    int i = 0;
    imageView.setVisibility(0);
    this.q = new AnimationDrawable();
    while (i <= 23) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("castle_flag_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.q.addFrame(drawable, 50);
      i++;
    } 
    this.k.setImageDrawable((Drawable)this.q);
    this.q.start();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCastleView.j(this.a).clearAnimation();
            SuperCastleView.a(this.a, (AnimationDrawable)null);
          }
        }4000L);
  }
  
  public View a() {
    return this.d;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    this.d.setVisibility(0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(1000L);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 1.05F, 1.0F, 1.05F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(3000L);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)scaleAnimation);
    animationSet.setFillAfter(true);
    this.i.startAnimation((Animation)animationSet);
    animationSet.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperCastleView.b(this.a);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            if (this.a.a != null)
              this.a.a.a(); 
            SuperCastleView.a(this.a);
            this.a.b();
          }
        });
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCastleView superCastleView = this.a;
            SuperCastleView.a(superCastleView, SuperCastleView.c(superCastleView));
          }
        }400L);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCastleView superCastleView = this.a;
            SuperCastleView.a(superCastleView, SuperCastleView.d(superCastleView));
          }
        }1100L);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCastleView superCastleView = this.a;
            SuperCastleView.a(superCastleView, SuperCastleView.e(superCastleView));
          }
        }1700L);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCastleView superCastleView = this.a;
            SuperCastleView.a(superCastleView, SuperCastleView.f(superCastleView));
          }
        }2300L);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperCastleView superCastleView = this.a;
            SuperCastleView.a(superCastleView, SuperCastleView.g(superCastleView));
          }
        }2700L);
  }
  
  public void b() {
    this.e.setVisibility(0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(1000L);
    TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.4F, 2, 0.1F, 2, -0.2F, 2, -0.2F);
    translateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation.setDuration(18000L);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)translateAnimation);
    this.h.startAnimation((Animation)animationSet);
    translateAnimation = new TranslateAnimation(2, 0.3F, 2, 0.4F, 2, -0.3F, 2, -0.3F);
    translateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation.setDuration(10000L);
    animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)translateAnimation);
    this.f.startAnimation((Animation)animationSet);
    translateAnimation = new TranslateAnimation(2, 0.2F, 2, 0.3F, 2, -0.12F, 2, -0.12F);
    translateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
    translateAnimation.setDuration(10000L);
    animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.addAnimation((Animation)translateAnimation);
    this.g.startAnimation((Animation)animationSet);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\SuperCastleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */