package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final class FadeProvider implements VisibilityAnimatorProvider {
  private float a = 1.0F;
  
  private static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.setAlpha(TransitionUtils.a(this.b, this.c, this.d, this.e, f));
          }
        });
    return (Animator)valueAnimator;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView) {
    return a(paramView, 0.0F, 1.0F, 0.0F, this.a);
  }
  
  public void a(float paramFloat) {
    this.a = paramFloat;
  }
  
  public Animator b(ViewGroup paramViewGroup, View paramView) {
    return a(paramView, 1.0F, 0.0F, 0.0F, 1.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\FadeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */