package com.blued.android.module.common.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class CubicInterpolator implements Interpolator {
  private int a = 0;
  
  private final PointF b = new PointF();
  
  private final PointF c = new PointF();
  
  public CubicInterpolator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    PointF pointF = this.b;
    pointF.x = paramFloat1;
    pointF.y = paramFloat2;
    pointF = this.c;
    pointF.x = paramFloat3;
    pointF.y = paramFloat4;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    double d1 = 1.0D - paramDouble1;
    double d2 = paramDouble1 * paramDouble1;
    double d3 = d1 * d1;
    return d3 * d1 * paramDouble2 + d3 * 3.0D * paramDouble1 * paramDouble3 + d1 * 3.0D * d2 * paramDouble4 + d2 * paramDouble1 * paramDouble5;
  }
  
  public float getInterpolation(float paramFloat) {
    int i = this.a;
    float f = paramFloat;
    while (i < 4096) {
      f = i * 1.0F / 4096.0F;
      if (a(f, 0.0D, this.b.x, this.c.x, 1.0D) >= paramFloat) {
        this.a = i;
        break;
      } 
      i++;
    } 
    double d2 = a(f, 0.0D, this.b.y, this.c.y, 1.0D);
    double d1 = d2;
    if (d2 > 0.999D) {
      d1 = 1.0D;
      this.a = 0;
    } 
    return (float)d1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\CubicInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */