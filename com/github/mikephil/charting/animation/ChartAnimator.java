package com.github.mikephil.charting.animation;

import android.animation.ValueAnimator;

public class ChartAnimator {
  protected float a = 1.0F;
  
  protected float b = 1.0F;
  
  private ValueAnimator.AnimatorUpdateListener c;
  
  public ChartAnimator() {}
  
  public ChartAnimator(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {
    this.c = paramAnimatorUpdateListener;
  }
  
  public float a() {
    return this.a;
  }
  
  public float b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\animation\ChartAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */