package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer {
  private final LuminanceSource a;
  
  public Binarizer(LuminanceSource paramLuminanceSource) {
    this.a = paramLuminanceSource;
  }
  
  public abstract Binarizer a(LuminanceSource paramLuminanceSource);
  
  public final LuminanceSource a() {
    return this.a;
  }
  
  public abstract BitArray a(int paramInt, BitArray paramBitArray) throws NotFoundException;
  
  public abstract BitMatrix b() throws NotFoundException;
  
  public final int c() {
    return this.a.d();
  }
  
  public final int d() {
    return this.a.e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\Binarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */