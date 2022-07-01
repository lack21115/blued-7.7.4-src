package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {
  protected boolean C = false;
  
  protected boolean D = false;
  
  protected int E = -7829368;
  
  protected float F = 1.0F;
  
  protected float G = 10.0F;
  
  protected float H = 10.0F;
  
  protected float I = 0.0F;
  
  protected float J = Float.POSITIVE_INFINITY;
  
  private boolean K = true;
  
  private boolean L = true;
  
  private boolean M = false;
  
  private boolean N = false;
  
  private YAxisLabelPosition O = YAxisLabelPosition.a;
  
  private AxisDependency P = AxisDependency.a;
  
  public YAxis() {}
  
  public YAxis(AxisDependency paramAxisDependency) {}
  
  public AxisDependency A() {
    return this.P;
  }
  
  public float B() {
    return this.I;
  }
  
  public float C() {
    return this.J;
  }
  
  public YAxisLabelPosition D() {
    return this.O;
  }
  
  public boolean E() {
    return this.L;
  }
  
  public boolean F() {
    return this.K;
  }
  
  public boolean G() {
    return this.C;
  }
  
  public float H() {
    return this.G;
  }
  
  public float I() {
    return this.H;
  }
  
  public boolean J() {
    return this.D;
  }
  
  public int K() {
    return this.E;
  }
  
  public float L() {
    return this.F;
  }
  
  public boolean M() {
    return (z() && h() && D() == YAxisLabelPosition.a);
  }
  
  public float a(Paint paramPaint) {
    paramPaint.setTextSize(this.A);
    float f3 = Utils.a(paramPaint, p()) + u() * 2.0F;
    float f1 = B();
    float f4 = C();
    float f2 = f1;
    if (f1 > 0.0F)
      f2 = Utils.a(f1); 
    f1 = f4;
    if (f4 > 0.0F) {
      f1 = f4;
      if (f4 != Float.POSITIVE_INFINITY)
        f1 = Utils.a(f4); 
    } 
    if (f1 <= 0.0D)
      f1 = f3; 
    return Math.max(f2, Math.min(f3, f1));
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (Math.abs(paramFloat2 - paramFloat1) == 0.0F) {
      f1 = paramFloat2 + 1.0F;
      f2 = paramFloat1 - 1.0F;
    } 
    paramFloat2 = Math.abs(f1 - f2);
    if (this.r) {
      paramFloat1 = this.u;
    } else {
      paramFloat1 = f2 - paramFloat2 / 100.0F * I();
    } 
    this.u = paramFloat1;
    if (this.s) {
      paramFloat1 = this.t;
    } else {
      paramFloat1 = f1 + paramFloat2 / 100.0F * H();
    } 
    this.t = paramFloat1;
    this.v = Math.abs(this.u - this.t);
  }
  
  public float b(Paint paramPaint) {
    paramPaint.setTextSize(this.A);
    return Utils.b(paramPaint, p()) + v() * 2.0F;
  }
  
  public enum AxisDependency {
    a, b;
  }
  
  public enum YAxisLabelPosition {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\YAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */