package com.google.zxing.pdf417.decoder.ec;

public final class ModulusGF {
  public static final ModulusGF a = new ModulusGF(929, 3);
  
  private final int[] b;
  
  private final int[] c;
  
  private final ModulusPoly d;
  
  private final ModulusPoly e;
  
  private final int f;
  
  private ModulusGF(int paramInt1, int paramInt2) {
    this.f = paramInt1;
    this.b = new int[paramInt1];
    this.c = new int[paramInt1];
    int i = 0;
    int j = 1;
    while (i < paramInt1) {
      this.b[i] = j;
      j = j * paramInt2 % paramInt1;
      i++;
    } 
    for (paramInt2 = 0; paramInt2 < paramInt1 - 1; paramInt2++)
      this.c[this.b[paramInt2]] = paramInt2; 
    this.d = new ModulusPoly(this, new int[] { 0 });
    this.e = new ModulusPoly(this, new int[] { 1 });
  }
  
  int a(int paramInt) {
    return this.b[paramInt];
  }
  
  ModulusPoly a() {
    return this.d;
  }
  
  ModulusPoly a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.d; 
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new ModulusPoly(this, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  int b(int paramInt) {
    if (paramInt != 0)
      return this.c[paramInt]; 
    throw new IllegalArgumentException();
  }
  
  int b(int paramInt1, int paramInt2) {
    return (paramInt1 + paramInt2) % this.f;
  }
  
  ModulusPoly b() {
    return this.e;
  }
  
  int c() {
    return this.f;
  }
  
  int c(int paramInt) {
    if (paramInt != 0)
      return this.b[this.f - this.c[paramInt] - 1]; 
    throw new ArithmeticException();
  }
  
  int c(int paramInt1, int paramInt2) {
    int i = this.f;
    return (paramInt1 + i - paramInt2) % i;
  }
  
  int d(int paramInt1, int paramInt2) {
    if (paramInt1 == 0 || paramInt2 == 0)
      return 0; 
    int[] arrayOfInt1 = this.b;
    int[] arrayOfInt2 = this.c;
    return arrayOfInt1[(arrayOfInt2[paramInt1] + arrayOfInt2[paramInt2]) % (this.f - 1)];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ModulusGF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */