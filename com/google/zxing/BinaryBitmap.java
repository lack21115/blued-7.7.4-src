package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap {
  private final Binarizer a;
  
  private BitMatrix b;
  
  public BinaryBitmap(Binarizer paramBinarizer) {
    if (paramBinarizer != null) {
      this.a = paramBinarizer;
      return;
    } 
    throw new IllegalArgumentException("Binarizer must be non-null.");
  }
  
  public int a() {
    return this.a.c();
  }
  
  public BinaryBitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    LuminanceSource luminanceSource = this.a.a().a(paramInt1, paramInt2, paramInt3, paramInt4);
    return new BinaryBitmap(this.a.a(luminanceSource));
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray) throws NotFoundException {
    return this.a.a(paramInt, paramBitArray);
  }
  
  public int b() {
    return this.a.d();
  }
  
  public BitMatrix c() throws NotFoundException {
    if (this.b == null)
      this.b = this.a.b(); 
    return this.b;
  }
  
  public boolean d() {
    return this.a.a().b();
  }
  
  public BinaryBitmap e() {
    LuminanceSource luminanceSource = this.a.a().c();
    return new BinaryBitmap(this.a.a(luminanceSource));
  }
  
  public String toString() {
    try {
      return c().toString();
    } catch (NotFoundException notFoundException) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\BinaryBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */