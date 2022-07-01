package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint {
  private final float a;
  
  private final int b;
  
  FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3) {
    this(paramFloat1, paramFloat2, paramFloat3, 1);
  }
  
  private FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
    this.b = paramInt;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (Math.abs(paramFloat2 - b()) <= paramFloat1 && Math.abs(paramFloat3 - a()) <= paramFloat1) {
      paramFloat1 = Math.abs(paramFloat1 - this.a);
      return (paramFloat1 <= 1.0F || paramFloat1 <= this.a);
    } 
    return false;
  }
  
  FinderPattern b(float paramFloat1, float paramFloat2, float paramFloat3) {
    int i = this.b;
    int j = i + 1;
    float f1 = i;
    float f2 = a();
    float f3 = j;
    return new FinderPattern((f1 * f2 + paramFloat2) / f3, (this.b * b() + paramFloat1) / f3, (this.b * this.a + paramFloat3) / f3, j);
  }
  
  public float c() {
    return this.a;
  }
  
  int d() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\detector\FinderPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */