package com.google.zxing.common.reedsolomon;

public final class GenericGF {
  public static final GenericGF a = new GenericGF(4201, 4096, 1);
  
  public static final GenericGF b = new GenericGF(1033, 1024, 1);
  
  public static final GenericGF c = new GenericGF(67, 64, 1);
  
  public static final GenericGF d = new GenericGF(19, 16, 1);
  
  public static final GenericGF e = new GenericGF(285, 256, 0);
  
  public static final GenericGF f;
  
  public static final GenericGF g;
  
  public static final GenericGF h = c;
  
  private final int[] i;
  
  private final int[] j;
  
  private final GenericGFPoly k;
  
  private final GenericGFPoly l;
  
  private final int m;
  
  private final int n;
  
  private final int o;
  
  public GenericGF(int paramInt1, int paramInt2, int paramInt3) {
    this.n = paramInt1;
    this.m = paramInt2;
    this.o = paramInt3;
    this.i = new int[paramInt2];
    this.j = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2) {
      this.i[i] = paramInt3;
      int j = paramInt3 << 1;
      paramInt3 = j;
      if (j >= paramInt2)
        paramInt3 = (j ^ paramInt1) & paramInt2 - 1; 
      i++;
    } 
    for (paramInt1 = 0; paramInt1 < paramInt2 - 1; paramInt1++)
      this.j[this.i[paramInt1]] = paramInt1; 
    this.k = new GenericGFPoly(this, new int[] { 0 });
    this.l = new GenericGFPoly(this, new int[] { 1 });
  }
  
  static int b(int paramInt1, int paramInt2) {
    return paramInt1 ^ paramInt2;
  }
  
  int a(int paramInt) {
    return this.i[paramInt];
  }
  
  GenericGFPoly a() {
    return this.k;
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.k; 
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new GenericGFPoly(this, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  int b(int paramInt) {
    if (paramInt != 0)
      return this.j[paramInt]; 
    throw new IllegalArgumentException();
  }
  
  GenericGFPoly b() {
    return this.l;
  }
  
  public int c() {
    return this.m;
  }
  
  int c(int paramInt) {
    if (paramInt != 0)
      return this.i[this.m - this.j[paramInt] - 1]; 
    throw new ArithmeticException();
  }
  
  int c(int paramInt1, int paramInt2) {
    if (paramInt1 == 0 || paramInt2 == 0)
      return 0; 
    int[] arrayOfInt1 = this.i;
    int[] arrayOfInt2 = this.j;
    return arrayOfInt1[(arrayOfInt2[paramInt1] + arrayOfInt2[paramInt2]) % (this.m - 1)];
  }
  
  public int d() {
    return this.o;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("GF(0x");
    stringBuilder.append(Integer.toHexString(this.n));
    stringBuilder.append(',');
    stringBuilder.append(this.m);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
  
  static {
    GenericGF genericGF = new GenericGF(301, 256, 1);
    f = genericGF;
    g = genericGF;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\reedsolomon\GenericGF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */