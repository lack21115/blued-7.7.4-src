package com.google.zxing.pdf417.detector;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.List;

public final class PDF417DetectorResult {
  private final BitMatrix a;
  
  private final List<ResultPoint[]> b;
  
  public PDF417DetectorResult(BitMatrix paramBitMatrix, List<ResultPoint[]> paramList) {
    this.a = paramBitMatrix;
    this.b = paramList;
  }
  
  public BitMatrix a() {
    return this.a;
  }
  
  public List<ResultPoint[]> b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\detector\PDF417DetectorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */