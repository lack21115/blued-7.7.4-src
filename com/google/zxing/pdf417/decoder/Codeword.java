package com.google.zxing.pdf417.decoder;

final class Codeword {
  private final int a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private int e = -1;
  
  Codeword(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  boolean a() {
    return a(this.e);
  }
  
  boolean a(int paramInt) {
    return (paramInt != -1 && this.c == paramInt % 3 * 3);
  }
  
  void b() {
    this.e = this.d / 30 * 3 + this.c / 3;
  }
  
  void b(int paramInt) {
    this.e = paramInt;
  }
  
  int c() {
    return this.b - this.a;
  }
  
  int d() {
    return this.a;
  }
  
  int e() {
    return this.b;
  }
  
  int f() {
    return this.c;
  }
  
  int g() {
    return this.d;
  }
  
  int h() {
    return this.e;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append("|");
    stringBuilder.append(this.d);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\Codeword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */