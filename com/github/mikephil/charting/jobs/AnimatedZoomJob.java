package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
  private static ObjectPool<AnimatedZoomJob> t = ObjectPool.a(8, new AnimatedZoomJob(null, null, null, null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0L));
  
  protected float e;
  
  protected float f;
  
  protected float g;
  
  protected float h;
  
  protected YAxis i;
  
  protected float j;
  
  protected Matrix k = new Matrix();
  
  public AnimatedZoomJob(ViewPortHandler paramViewPortHandler, View paramView, Transformer paramTransformer, YAxis paramYAxis, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, long paramLong) {
    super(paramViewPortHandler, paramFloat2, paramFloat3, paramTransformer, paramView, paramFloat4, paramFloat5, paramLong);
    this.g = paramFloat6;
    this.h = paramFloat7;
    this.e = paramFloat8;
    this.f = paramFloat9;
    this.a.addListener(this);
    this.i = paramYAxis;
    this.j = paramFloat1;
  }
  
  public void a() {}
  
  public ObjectPool.Poolable b() {
    return new AnimatedZoomJob(null, null, null, null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0L);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {
    ((BarLineChartBase)this.q).j();
    this.q.postInvalidate();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    float f1 = this.c;
    float f2 = this.n;
    float f3 = this.c;
    float f4 = this.b;
    float f5 = this.d;
    float f6 = this.o;
    float f7 = this.d;
    float f8 = this.b;
    Matrix matrix = this.k;
    this.m.b(f1 + (f2 - f3) * f4, f5 + (f6 - f7) * f8, matrix);
    this.m.a(matrix, this.q, false);
    f1 = this.i.v / this.m.r();
    f2 = this.j / this.m.q();
    float[] arrayOfFloat = this.l;
    f3 = this.e;
    arrayOfFloat[0] = f3 + (this.g - f2 / 2.0F - f3) * this.b;
    arrayOfFloat = this.l;
    f2 = this.f;
    arrayOfFloat[1] = f2 + (this.h + f1 / 2.0F - f2) * this.b;
    this.p.a(this.l);
    this.m.a(this.l, matrix);
    this.m.a(matrix, this.q, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\jobs\AnimatedZoomJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */