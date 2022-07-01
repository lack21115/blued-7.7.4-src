package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern extends ResultPoint {
  private final float a;
  
  AlignmentPattern(float paramFloat1, float paramFloat2, float paramFloat3) {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (Math.abs(paramFloat2 - b()) <= paramFloat1 && Math.abs(paramFloat3 - a()) <= paramFloat1) {
      paramFloat1 = Math.abs(paramFloat1 - this.a);
      return (paramFloat1 <= 1.0F || paramFloat1 <= this.a);
    } 
    return false;
  }
  
  AlignmentPattern b(float paramFloat1, float paramFloat2, float paramFloat3) {
    return new AlignmentPattern((a() + paramFloat2) / 2.0F, (b() + paramFloat1) / 2.0F, (this.a + paramFloat3) / 2.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\detector\AlignmentPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */