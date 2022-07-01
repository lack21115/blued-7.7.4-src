package com.qiniu.pili.droid.shortvideo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class PLFadeTransition extends PLTransition {
  private float c;
  
  private float d;
  
  public PLFadeTransition(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2) {
    super(paramLong1, paramLong2);
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  public float a(long paramLong) {
    long l1 = this.b * 1000000L;
    long l2 = this.a;
    long l3 = a();
    if (paramLong >= l1 && paramLong <= l3 * 1000000L) {
      float f1 = Math.abs(this.c - this.d) * (float)(paramLong - l1) / (float)(l2 * 1000000L);
      float f2 = this.c;
      return (f2 < this.d) ? (f2 + f1) : (f2 - f1);
    } 
    return 1.0F;
  }
  
  public Animator a(View paramView) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { this.c, this.d });
    objectAnimator.setDuration(this.a);
    objectAnimator.setStartDelay(this.b);
    return (Animator)objectAnimator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLFadeTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */