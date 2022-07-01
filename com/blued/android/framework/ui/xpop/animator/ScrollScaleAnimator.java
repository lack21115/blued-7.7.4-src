package com.blued.android.framework.ui.xpop.animator;

import android.animation.IntEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

public class ScrollScaleAnimator extends PopupAnimator {
  public boolean a = false;
  
  private IntEvaluator b = new IntEvaluator();
  
  private int e;
  
  private int f;
  
  private float g = 0.0F;
  
  private float h = 0.0F;
  
  public ScrollScaleAnimator(View paramView, PopupAnimation paramPopupAnimation) {
    super(paramView, paramPopupAnimation);
  }
  
  private void d() {
    switch (null.a[this.d.ordinal()]) {
      default:
        return;
      case 8:
        this.c.setPivotX(0.0F);
        this.c.setPivotY(this.c.getMeasuredHeight());
        this.e = this.c.getMeasuredWidth();
        this.f = -this.c.getMeasuredHeight();
        return;
      case 7:
        this.c.setPivotX((this.c.getMeasuredWidth() / 2));
        this.c.setPivotY(this.c.getMeasuredHeight());
        this.f = -this.c.getMeasuredHeight();
        return;
      case 6:
        this.c.setPivotX(this.c.getMeasuredWidth());
        this.c.setPivotY(this.c.getMeasuredHeight());
        this.e = -this.c.getMeasuredWidth();
        this.f = -this.c.getMeasuredHeight();
        return;
      case 5:
        this.c.setPivotX(this.c.getMeasuredWidth());
        this.c.setPivotY((this.c.getMeasuredHeight() / 2));
        this.e = -this.c.getMeasuredWidth();
        return;
      case 4:
        this.c.setPivotX(this.c.getMeasuredWidth());
        this.c.setPivotY(0.0F);
        this.e = -this.c.getMeasuredWidth();
        this.f = this.c.getMeasuredHeight();
        return;
      case 3:
        this.c.setPivotX((this.c.getMeasuredWidth() / 2));
        this.c.setPivotY(0.0F);
        this.f = this.c.getMeasuredHeight();
        return;
      case 2:
        this.c.setPivotX(0.0F);
        this.c.setPivotY(0.0F);
        this.e = this.c.getMeasuredWidth();
        this.f = this.c.getMeasuredHeight();
        return;
      case 1:
        break;
    } 
    this.c.setPivotX(0.0F);
    this.c.setPivotY((this.c.getMeasuredHeight() / 2));
    this.e = this.c.getMeasuredWidth();
    this.f = 0;
  }
  
  public void a() {
    this.c.setAlpha(this.g);
    this.c.setScaleX(this.h);
    if (!this.a)
      this.c.setScaleY(this.h); 
    this.c.post(new Runnable(this) {
          public void run() {
            ScrollScaleAnimator.a(this.a);
            this.a.c.scrollTo(ScrollScaleAnimator.b(this.a), ScrollScaleAnimator.c(this.a));
          }
        });
  }
  
  public void b() {
    this.c.post(new Runnable(this) {
          public void run() {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                  public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                    float f = param2ValueAnimator.getAnimatedFraction();
                    this.a.a.c.setAlpha(f);
                    View view = this.a.a.c;
                    IntEvaluator intEvaluator = ScrollScaleAnimator.d(this.a.a);
                    int i = ScrollScaleAnimator.b(this.a.a);
                    Integer integer = Integer.valueOf(0);
                    view.scrollTo(intEvaluator.evaluate(f, Integer.valueOf(i), integer).intValue(), ScrollScaleAnimator.d(this.a.a).evaluate(f, Integer.valueOf(ScrollScaleAnimator.c(this.a.a)), integer).intValue());
                    this.a.a.c.setScaleX(f);
                    if (!this.a.a.a)
                      this.a.a.c.setScaleY(f); 
                  }
                });
            valueAnimator.setDuration(XPopup.b()).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator());
            valueAnimator.start();
          }
        });
  }
  
  public void c() {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f1 = param1ValueAnimator.getAnimatedFraction();
            View view = this.a.c;
            float f2 = 1.0F - f1;
            view.setAlpha(f2);
            view = this.a.c;
            IntEvaluator intEvaluator = ScrollScaleAnimator.d(this.a);
            Integer integer = Integer.valueOf(0);
            view.scrollTo(intEvaluator.evaluate(f1, integer, Integer.valueOf(ScrollScaleAnimator.b(this.a))).intValue(), ScrollScaleAnimator.d(this.a).evaluate(f1, integer, Integer.valueOf(ScrollScaleAnimator.c(this.a))).intValue());
            this.a.c.setScaleX(f2);
            if (!this.a.a)
              this.a.c.setScaleY(f2); 
          }
        });
    valueAnimator.setDuration(XPopup.b()).setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator());
    valueAnimator.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\ScrollScaleAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */