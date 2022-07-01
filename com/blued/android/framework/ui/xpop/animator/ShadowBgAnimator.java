package com.blued.android.framework.ui.xpop.animator;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;

public class ShadowBgAnimator extends PopupAnimator {
  public ArgbEvaluator a = new ArgbEvaluator();
  
  public int b = 0;
  
  public boolean e = false;
  
  public ShadowBgAnimator() {}
  
  public ShadowBgAnimator(View paramView) {
    super(paramView);
  }
  
  public int a(float paramFloat) {
    return ((Integer)this.a.evaluate(paramFloat, Integer.valueOf(this.b), Integer.valueOf(XPopup.a()))).intValue();
  }
  
  public void a() {
    this.c.setBackgroundColor(this.b);
  }
  
  public void b() {
    long l;
    ValueAnimator valueAnimator = ValueAnimator.ofObject((TypeEvaluator)this.a, new Object[] { Integer.valueOf(this.b), Integer.valueOf(XPopup.a()) });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            this.a.c.setBackgroundColor(((Integer)param1ValueAnimator.getAnimatedValue()).intValue());
          }
        });
    valueAnimator.setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator());
    if (this.e) {
      l = 0L;
    } else {
      l = XPopup.b();
    } 
    valueAnimator.setDuration(l).start();
  }
  
  public void c() {
    long l;
    ValueAnimator valueAnimator = ValueAnimator.ofObject((TypeEvaluator)this.a, new Object[] { Integer.valueOf(XPopup.a()), Integer.valueOf(this.b) });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            this.a.c.setBackgroundColor(((Integer)param1ValueAnimator.getAnimatedValue()).intValue());
          }
        });
    valueAnimator.setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator());
    if (this.e) {
      l = 0L;
    } else {
      l = XPopup.b();
    } 
    valueAnimator.setDuration(l).start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\ShadowBgAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */