package com.google.zxing.pdf417.decoder;

final class BarcodeMetadata {
  private final int a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  BarcodeMetadata(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramInt1;
    this.b = paramInt4;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt2 + paramInt3;
  }
  
  int a() {
    return this.a;
  }
  
  int b() {
    return this.b;
  }
  
  int c() {
    return this.e;
  }
  
  int d() {
    return this.c;
  }
  
  int e() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\BarcodeMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */