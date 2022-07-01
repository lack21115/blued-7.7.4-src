package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class ScaleInAnimation implements BaseAnimation {
  private final float a;
  
  public ScaleInAnimation() {
    this(0.5F);
  }
  
  public ScaleInAnimation(float paramFloat) {
    this.a = paramFloat;
  }
  
  public Animator[] a(View paramView) {
    return (Animator[])new ObjectAnimator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { this.a, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { this.a, 1.0F }) };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\animation\ScaleInAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */