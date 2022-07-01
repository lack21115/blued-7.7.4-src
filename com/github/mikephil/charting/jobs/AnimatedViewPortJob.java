package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AnimatedViewPortJob extends ViewPortJob implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
  protected ObjectAnimator a;
  
  protected float b;
  
  protected float c;
  
  protected float d;
  
  public AnimatedViewPortJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView, float paramFloat3, float paramFloat4, long paramLong) {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView);
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.a = ObjectAnimator.ofFloat(this, "phase", new float[] { 0.0F, 1.0F });
    this.a.setDuration(paramLong);
    this.a.addUpdateListener(this);
    this.a.addListener(this);
  }
  
  public abstract void a();
  
  public void onAnimationCancel(Animator paramAnimator) {
    try {
      a();
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
  
  public void onAnimationEnd(Animator paramAnimator) {
    try {
      a();
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
  
  public void run() {
    this.a.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\jobs\AnimatedViewPortJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */