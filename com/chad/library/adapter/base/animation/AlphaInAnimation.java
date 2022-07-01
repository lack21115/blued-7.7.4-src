package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class AlphaInAnimation implements BaseAnimation {
  private final float a;
  
  public AlphaInAnimation() {
    this(0.0F);
  }
  
  public AlphaInAnimation(float paramFloat) {
    this.a = paramFloat;
  }
  
  public Animator[] a(View paramView) {
    return new Animator[] { (Animator)ObjectAnimator.ofFloat(paramView, "alpha", new float[] { this.a, 1.0F }) };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\animation\AlphaInAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */