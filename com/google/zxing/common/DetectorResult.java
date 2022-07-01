package com.google.zxing.common;

import com.google.zxing.ResultPoint;

public class DetectorResult {
  private final BitMatrix a;
  
  private final ResultPoint[] b;
  
  public DetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint) {
    this.a = paramBitMatrix;
    this.b = paramArrayOfResultPoint;
  }
  
  public final BitMatrix d() {
    return this.a;
  }
  
  public final ResultPoint[] e() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\DetectorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */