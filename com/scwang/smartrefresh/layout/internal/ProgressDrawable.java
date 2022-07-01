package com.scwang.smartrefresh.layout.internal;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;

public class ProgressDrawable extends PaintDrawable implements ValueAnimator.AnimatorUpdateListener, Animatable {
  protected int b = 0;
  
  protected int c = 0;
  
  protected int d = 0;
  
  protected ValueAnimator e = ValueAnimator.ofInt(new int[] { 30, 3600 });
  
  protected Path f = new Path();
  
  public ProgressDrawable() {
    this.e.setDuration(10000L);
    this.e.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.e.setRepeatCount(-1);
    this.e.setRepeatMode(1);
  }
  
  public void draw(Canvas paramCanvas) {
    Rect rect = getBounds();
    int i = rect.width();
    int j = rect.height();
    int k = Math.max(1, i / 20);
    if (this.b != i || this.c != j) {
      this.f.reset();
      Path path = this.f;
      float f4 = (i - k);
      int m = j / 2;
      float f5 = m;
      float f6 = k;
      path.addCircle(f4, f5, f6, Path.Direction.CW);
      path = this.f;
      float f7 = (i - k * 5);
      path.addRect(f7, (m - k), f4, (m + k), Path.Direction.CW);
      this.f.addCircle(f7, f5, f6, Path.Direction.CW);
      this.b = i;
      this.c = j;
    } 
    paramCanvas.save();
    float f1 = this.d;
    float f2 = (i / 2);
    float f3 = (j / 2);
    paramCanvas.rotate(f1, f2, f3);
    for (i = 0; i < 12; i++) {
      this.a.setAlpha((i + 5) * 17);
      paramCanvas.rotate(30.0F, f2, f3);
      paramCanvas.drawPath(this.f, this.a);
    } 
    paramCanvas.restore();
  }
  
  public boolean isRunning() {
    return this.e.isRunning();
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    this.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 30 * 30;
    invalidateSelf();
  }
  
  public void start() {
    if (!this.e.isRunning()) {
      this.e.addUpdateListener(this);
      this.e.start();
    } 
  }
  
  public void stop() {
    if (this.e.isRunning()) {
      this.e.removeAllListeners();
      this.e.removeAllUpdateListeners();
      this.e.cancel();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\internal\ProgressDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */