package com.airbnb.lottie.model;

import android.graphics.PointF;

public class CubicCurveData {
  private final PointF a = new PointF();
  
  private final PointF b = new PointF();
  
  private final PointF c = new PointF();
  
  public CubicCurveData() {}
  
  public CubicCurveData(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3) {}
  
  public PointF a() {
    return this.a;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.a.set(paramFloat1, paramFloat2);
  }
  
  public PointF b() {
    return this.b;
  }
  
  public void b(float paramFloat1, float paramFloat2) {
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public PointF c() {
    return this.c;
  }
  
  public void c(float paramFloat1, float paramFloat2) {
    this.c.set(paramFloat1, paramFloat2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\CubicCurveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */