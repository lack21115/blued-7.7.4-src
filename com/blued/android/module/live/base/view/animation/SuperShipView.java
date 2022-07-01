package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

public class SuperShipView extends BaseLiveAnimationView {
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private FrameLayout e;
  
  private ImageView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private ImageView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private ImageView m;
  
  private ImageView n;
  
  private ImageView o;
  
  private TranslateAnimation p;
  
  private Handler q = new Handler();
  
  private AnimationDrawable r;
  
  private AnimationDrawable s;
  
  private AnimationDrawable t;
  
  private AnimationDrawable u;
  
  public SuperShipView(Context paramContext) {
    this.b = paramContext;
    b();
  }
  
  private void a(ImageView paramImageView) {
    int i = 0;
    paramImageView.setVisibility(0);
    this.t = new AnimationDrawable();
    while (i <= 12) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sea_wave1_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.t.addFrame(drawable, 30);
      i++;
    } 
    paramImageView.setImageDrawable((Drawable)this.t);
    this.t.start();
    AppInfo.n().postDelayed(new Runnable(this, paramImageView) {
          public void run() {
            this.a.clearAnimation();
          }
        }4000L);
  }
  
  private void b() {
    this.c = LayoutInflater.from(this.b);
    this.d = this.c.inflate(R.layout.layout_sports_ship_anim, null);
    this.e = (FrameLayout)this.d.findViewById(R.id.ship_root_view);
    this.f = (ImageView)this.d.findViewById(R.id.sea_surface);
    this.g = (ImageView)this.d.findViewById(R.id.ship_smoke);
    this.h = (ImageView)this.d.findViewById(R.id.sea_wave1);
    this.i = (ImageView)this.d.findViewById(R.id.sea_wave1_1);
    this.j = (ImageView)this.d.findViewById(R.id.sea_wave1_2);
    this.k = (ImageView)this.d.findViewById(R.id.sea_wave1_3);
    this.l = (ImageView)this.d.findViewById(R.id.sea_wave2);
    this.m = (ImageView)this.d.findViewById(R.id.sea_wave2_1);
    this.n = (ImageView)this.d.findViewById(R.id.sea_wave2_2);
    this.o = (ImageView)this.d.findViewById(R.id.sea_wave2_3);
  }
  
  private void b(ImageView paramImageView) {
    int i = 0;
    paramImageView.setVisibility(0);
    this.u = new AnimationDrawable();
    while (i <= 8) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sea_wave2_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.u.addFrame(drawable, 100);
      i++;
    } 
    paramImageView.setImageDrawable((Drawable)this.u);
    this.u.start();
    this.q.postDelayed(new Runnable(this, paramImageView) {
          public void run() {
            this.a.setVisibility(8);
            this.a.clearAnimation();
          }
        }800L);
  }
  
  private void c() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(1000L);
    this.d.startAnimation((Animation)alphaAnimation);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            SuperShipView.l(this.a).setVisibility(8);
            SuperShipView.m(this.a).removeCallbacksAndMessages(null);
            SuperShipView.a(this.a, (AnimationDrawable)null);
            SuperShipView.b(this.a, (AnimationDrawable)null);
            SuperShipView.c(this.a, null);
            SuperShipView.d(this.a, null);
            if (this.a.a != null)
              this.a.a.b(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  private void d() {
    ImageView imageView = this.f;
    int i = 0;
    imageView.setVisibility(0);
    this.r = new AnimationDrawable();
    while (i <= 9) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sea_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.r.addFrame(drawable, 300);
      i++;
    } 
    this.f.setBackgroundDrawable((Drawable)this.r);
    this.r.start();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperShipView.n(this.a).clearAnimation();
          }
        },  4000L);
  }
  
  private void e() {
    ImageView imageView = this.g;
    int i = 0;
    imageView.setVisibility(0);
    this.s = new AnimationDrawable();
    while (i <= 14) {
      Resources resources = this.b.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ship_smoke_");
      stringBuilder.append(i);
      int j = resources.getIdentifier(stringBuilder.toString(), "drawable", this.b.getPackageName());
      Drawable drawable = this.b.getResources().getDrawable(j);
      this.s.addFrame(drawable, 150);
      i++;
    } 
    this.g.setImageDrawable((Drawable)this.s);
    this.s.start();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            SuperShipView.o(this.a).clearAnimation();
          }
        },  4000L);
  }
  
  public View a() {
    return this.d;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    this.d.setVisibility(0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(1500L);
    this.p = new TranslateAnimation(2, 0.4F, 2, -0.1F, 2, -0.1F, 2, 0.0F);
    this.p.setInterpolator((Interpolator)new LinearInterpolator());
    this.p.setDuration(4000L);
    this.p.setFillAfter(true);
    this.e.startAnimation((Animation)this.p);
    this.d.startAnimation((Animation)alphaAnimation);
    this.p.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            if (this.a.a != null)
              this.a.a.a(); 
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    SuperShipView.a(this.a.a);
                  }
                },  3000L);
            SuperShipView.b(this.a);
            SuperShipView.c(this.a);
            SuperShipView superShipView = this.a;
            SuperShipView.a(superShipView, SuperShipView.d(superShipView));
            superShipView = this.a;
            SuperShipView.a(superShipView, SuperShipView.e(superShipView));
            superShipView = this.a;
            SuperShipView.a(superShipView, SuperShipView.f(superShipView));
            superShipView = this.a;
            SuperShipView.a(superShipView, SuperShipView.g(superShipView));
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    SuperShipView.b(this.a.a, SuperShipView.h(this.a.a));
                  }
                }700L);
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    SuperShipView.b(this.a.a, SuperShipView.i(this.a.a));
                  }
                }1300L);
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    SuperShipView.b(this.a.a, SuperShipView.j(this.a.a));
                  }
                }1800L);
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    SuperShipView.b(this.a.a, SuperShipView.k(this.a.a));
                  }
                }2000L);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\SuperShipView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */