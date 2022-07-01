package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.framework.R;

public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {
  private Animation a;
  
  private Animation b;
  
  private ImageView c;
  
  private final Animation d;
  
  private final Animation e;
  
  public IndicatorLayout(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext);
    int j;
    this.c = new ImageView(paramContext);
    ColorDrawable colorDrawable = new ColorDrawable(0);
    this.c.setImageDrawable((Drawable)colorDrawable);
    int i = getResources().getDimensionPixelSize(R.dimen.indicator_internal_padding);
    this.c.setPadding(i, i, i, i);
    addView((View)this.c);
    if (null.a[paramMode.ordinal()] != 1) {
      j = R.anim.ptr_slide_in_top;
      i = R.anim.ptr_slide_out_top;
    } else {
      j = R.anim.ptr_slide_in_bottom;
      i = R.anim.ptr_slide_out_bottom;
      setBackgroundResource(R.drawable.indicator_bg_bottom);
      this.c.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix matrix = new Matrix();
      matrix.setRotate(180.0F, colorDrawable.getIntrinsicWidth() / 2.0F, colorDrawable.getIntrinsicHeight() / 2.0F);
      this.c.setImageMatrix(matrix);
    } 
    this.a = AnimationUtils.loadAnimation(paramContext, j);
    this.a.setAnimationListener(this);
    this.b = AnimationUtils.loadAnimation(paramContext, i);
    this.b.setAnimationListener(this);
    LinearInterpolator linearInterpolator = new LinearInterpolator();
    this.d = (Animation)new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.d.setInterpolator((Interpolator)linearInterpolator);
    this.d.setDuration(150L);
    this.d.setFillAfter(true);
    this.e = (Animation)new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.e.setInterpolator((Interpolator)linearInterpolator);
    this.e.setDuration(150L);
    this.e.setFillAfter(true);
  }
  
  public final boolean a() {
    Animation animation = getAnimation();
    return (animation != null) ? ((this.a == animation)) : ((getVisibility() == 0));
  }
  
  public void b() {
    startAnimation(this.b);
  }
  
  public void c() {
    this.c.clearAnimation();
    startAnimation(this.a);
  }
  
  public void d() {
    this.c.startAnimation(this.d);
  }
  
  public void e() {
    this.c.startAnimation(this.e);
  }
  
  public void onAnimationEnd(Animation paramAnimation) {
    if (paramAnimation == this.b) {
      this.c.clearAnimation();
      setVisibility(8);
    } else if (paramAnimation == this.a) {
      setVisibility(0);
    } 
    clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {
    setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\IndicatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */