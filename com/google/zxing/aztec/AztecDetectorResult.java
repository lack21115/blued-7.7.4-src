package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult extends DetectorResult {
  private final boolean a;
  
  private final int b;
  
  private final int c;
  
  public AztecDetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint, boolean paramBoolean, int paramInt1, int paramInt2) {
    super(paramBitMatrix, paramArrayOfResultPoint);
    this.a = paramBoolean;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int a() {
    return this.c;
  }
  
  public int b() {
    return this.b;
  }
  
  public boolean c() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\AztecDetectorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */