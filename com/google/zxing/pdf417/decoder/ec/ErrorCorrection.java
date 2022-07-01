package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection {
  private final ModulusGF a = ModulusGF.a;
  
  private int[] a(ModulusPoly paramModulusPoly) throws ChecksumException {
    int k = paramModulusPoly.a();
    int[] arrayOfInt = new int[k];
    int i = 1;
    int j;
    for (j = 0; i < this.a.c() && j < k; j = m) {
      int m = j;
      if (paramModulusPoly.b(i) == 0) {
        arrayOfInt[j] = this.a.c(i);
        m = j + 1;
      } 
      i++;
    } 
    if (j == k)
      return arrayOfInt; 
    throw ChecksumException.a();
  }
  
  private int[] a(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int[] paramArrayOfint) {
    int j = paramModulusPoly2.a();
    int[] arrayOfInt = new int[j];
    int i;
    for (i = 1; i <= j; i++)
      arrayOfInt[j - i] = this.a.d(i, paramModulusPoly2.a(i)); 
    paramModulusPoly2 = new ModulusPoly(this.a, arrayOfInt);
    j = paramArrayOfint.length;
    arrayOfInt = new int[j];
    for (i = 0; i < j; i++) {
      int m = this.a.c(paramArrayOfint[i]);
      int k = this.a.c(0, paramModulusPoly1.b(m));
      m = this.a.c(paramModulusPoly2.b(m));
      arrayOfInt[i] = this.a.d(k, m);
    } 
    return arrayOfInt;
  }
  
  private ModulusPoly[] a(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int paramInt) throws ChecksumException {
    ModulusPoly modulusPoly1 = paramModulusPoly1;
    ModulusPoly modulusPoly2 = paramModulusPoly2;
    if (paramModulusPoly1.a() < paramModulusPoly2.a()) {
      modulusPoly2 = paramModulusPoly1;
      modulusPoly1 = paramModulusPoly2;
    } 
    ModulusPoly modulusPoly3 = this.a.a();
    paramModulusPoly2 = this.a.b();
    paramModulusPoly1 = modulusPoly2;
    modulusPoly2 = modulusPoly3;
    while (true) {
      modulusPoly3 = modulusPoly2;
      modulusPoly2 = modulusPoly1;
      modulusPoly1 = paramModulusPoly1;
      if (modulusPoly1.a() >= paramInt / 2) {
        if (!modulusPoly1.b()) {
          ModulusPoly modulusPoly = this.a.a();
          int i = modulusPoly1.a(modulusPoly1.a());
          i = this.a.c(i);
          paramModulusPoly1 = modulusPoly2;
          modulusPoly2 = modulusPoly;
          while (paramModulusPoly1.a() >= modulusPoly1.a() && !paramModulusPoly1.b()) {
            int j = paramModulusPoly1.a() - modulusPoly1.a();
            int k = this.a.d(paramModulusPoly1.a(paramModulusPoly1.a()), i);
            modulusPoly2 = modulusPoly2.a(this.a.a(j, k));
            paramModulusPoly1 = paramModulusPoly1.b(modulusPoly1.a(j, k));
          } 
          modulusPoly3 = modulusPoly2.c(paramModulusPoly2).b(modulusPoly3).c();
          modulusPoly2 = paramModulusPoly2;
          paramModulusPoly2 = modulusPoly3;
          continue;
        } 
        throw ChecksumException.a();
      } 
      paramInt = paramModulusPoly2.a(0);
      if (paramInt != 0) {
        paramInt = this.a.c(paramInt);
        return new ModulusPoly[] { paramModulusPoly2.c(paramInt), modulusPoly1.c(paramInt) };
      } 
      throw ChecksumException.a();
    } 
  }
  
  public int a(int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2) throws ChecksumException {
    ModulusPoly modulusPoly2 = new ModulusPoly(this.a, paramArrayOfint1);
    int[] arrayOfInt3 = new int[paramInt];
    boolean bool = false;
    int i = paramInt;
    int j = 0;
    while (i > 0) {
      int k = modulusPoly2.b(this.a.a(i));
      arrayOfInt3[paramInt - i] = k;
      if (k != 0)
        j = 1; 
      i--;
    } 
    if (!j)
      return 0; 
    modulusPoly2 = this.a.b();
    if (paramArrayOfint2 != null) {
      j = paramArrayOfint2.length;
      for (i = 0; i < j; i++) {
        int k = paramArrayOfint2[i];
        k = this.a.a(paramArrayOfint1.length - 1 - k);
        ModulusGF modulusGF = this.a;
        modulusPoly2 = modulusPoly2.c(new ModulusPoly(modulusGF, new int[] { modulusGF.c(0, k), 1 }));
      } 
    } 
    ModulusPoly modulusPoly1 = new ModulusPoly(this.a, arrayOfInt3);
    ModulusPoly[] arrayOfModulusPoly = a(this.a.a(paramInt, 1), modulusPoly1, paramInt);
    modulusPoly1 = arrayOfModulusPoly[0];
    ModulusPoly modulusPoly3 = arrayOfModulusPoly[1];
    int[] arrayOfInt2 = a(modulusPoly1);
    int[] arrayOfInt1 = a(modulusPoly3, modulusPoly1, arrayOfInt2);
    paramInt = bool;
    while (paramInt < arrayOfInt2.length) {
      i = paramArrayOfint1.length - 1 - this.a.b(arrayOfInt2[paramInt]);
      if (i >= 0) {
        paramArrayOfint1[i] = this.a.c(paramArrayOfint1[i], arrayOfInt1[paramInt]);
        paramInt++;
        continue;
      } 
      throw ChecksumException.a();
    } 
    return arrayOfInt2.length;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ErrorCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */