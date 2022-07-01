package com.qiniu.pili.droid.shortvideo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class PLPositionTransition extends PLTransition {
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  public PLPositionTransition(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramLong1, paramLong2);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public float a(long paramLong) {
    long l1 = this.b * 1000000L;
    long l2 = this.a;
    long l3 = a();
    if (paramLong >= l1 && paramLong <= l3 * 1000000L) {
      float f = Math.abs(this.c - this.e) * (float)(paramLong - l1) / (float)(l2 * 1000000L);
      int i = this.c;
      if (i < this.e) {
        f = i + f;
      } else {
        f = i - f;
      } 
      return f / this.g;
    } 
    return 0.0F;
  }
  
  public Animator a(View paramView) {
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { this.c, this.e });
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { this.d, this.f });
    objectAnimator2.setInterpolator((TimeInterpolator)new LinearInterpolator());
    objectAnimator1.setInterpolator((TimeInterpolator)new LinearInterpolator());
    objectAnimator2.setDuration(this.a);
    objectAnimator2.setStartDelay(this.b);
    objectAnimator1.setDuration(this.a);
    objectAnimator1.setStartDelay(this.b);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(new Animator[] { (Animator)objectAnimator2, (Animator)objectAnimator1 });
    return (Animator)animatorSet;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public float b(long paramLong) {
    long l1 = this.b * 1000000L;
    long l2 = this.a;
    long l3 = a();
    if (paramLong >= l1 && paramLong <= l3 * 1000000L) {
      float f = Math.abs(this.d - this.f) * (float)(paramLong - l1) / (float)(l2 * 1000000L);
      int i = this.d;
      if (i < this.f) {
        f = i + f;
      } else {
        f = i - f;
      } 
      return f / this.h;
    } 
    return 0.0F;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLPositionTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */