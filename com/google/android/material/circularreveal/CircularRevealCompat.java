package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class CircularRevealCompat {
  public static Animator.AnimatorListener a(CircularRevealWidget paramCircularRevealWidget) {
    return (Animator.AnimatorListener)new AnimatorListenerAdapter(paramCircularRevealWidget) {
        public void onAnimationEnd(Animator param1Animator) {
          this.a.an_();
        }
        
        public void onAnimationStart(Animator param1Animator) {
          this.a.a();
        }
      };
  }
  
  public static Animator a(CircularRevealWidget paramCircularRevealWidget, float paramFloat1, float paramFloat2, float paramFloat3) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofObject(paramCircularRevealWidget, CircularRevealWidget.CircularRevealProperty.a, CircularRevealWidget.CircularRevealEvaluator.a, (Object[])new CircularRevealWidget.RevealInfo[] { new CircularRevealWidget.RevealInfo(paramFloat1, paramFloat2, paramFloat3) });
    if (Build.VERSION.SDK_INT >= 21) {
      CircularRevealWidget.RevealInfo revealInfo = paramCircularRevealWidget.getRevealInfo();
      if (revealInfo != null) {
        float f = revealInfo.c;
        Animator animator = ViewAnimationUtils.createCircularReveal((View)paramCircularRevealWidget, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[] { (Animator)objectAnimator, animator });
        return (Animator)animatorSet;
      } 
      throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    } 
    return (Animator)objectAnimator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\circularreveal\CircularRevealCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */