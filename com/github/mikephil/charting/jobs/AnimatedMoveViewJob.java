package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class AnimatedMoveViewJob extends AnimatedViewPortJob {
  private static ObjectPool<AnimatedMoveViewJob> e = ObjectPool.a(4, new AnimatedMoveViewJob(null, 0.0F, 0.0F, null, null, 0.0F, 0.0F, 0L));
  
  static {
    e.a(0.5F);
  }
  
  public AnimatedMoveViewJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView, float paramFloat3, float paramFloat4, long paramLong) {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView, paramFloat3, paramFloat4, paramLong);
  }
  
  public static void a(AnimatedMoveViewJob paramAnimatedMoveViewJob) {
    e.a(paramAnimatedMoveViewJob);
  }
  
  public void a() {
    a(this);
  }
  
  public ObjectPool.Poolable b() {
    return new AnimatedMoveViewJob(null, 0.0F, 0.0F, null, null, 0.0F, 0.0F, 0L);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    this.l[0] = this.c + (this.n - this.c) * this.b;
    this.l[1] = this.d + (this.o - this.d) * this.b;
    this.p.a(this.l);
    this.m.a(this.l, this.q);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\jobs\AnimatedMoveViewJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */