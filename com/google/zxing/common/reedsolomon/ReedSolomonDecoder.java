package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder {
  private final GenericGF a;
  
  public ReedSolomonDecoder(GenericGF paramGenericGF) {
    this.a = paramGenericGF;
  }
  
  private int[] a(GenericGFPoly paramGenericGFPoly) throws ReedSolomonException {
    int k = paramGenericGFPoly.a();
    int j = 0;
    int i = 1;
    if (k == 1)
      return new int[] { paramGenericGFPoly.a(1) }; 
    int[] arrayOfInt = new int[k];
    while (i < this.a.c() && j < k) {
      int m = j;
      if (paramGenericGFPoly.b(i) == 0) {
        arrayOfInt[j] = this.a.c(i);
        m = j + 1;
      } 
      i++;
      j = m;
    } 
    if (j == k)
      return arrayOfInt; 
    throw new ReedSolomonException("Error locator degree does not match number of roots");
  }
  
  private int[] a(GenericGFPoly paramGenericGFPoly, int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    int[] arrayOfInt = new int[j];
    for (int i = 0; i < j; i++) {
      int n = this.a.c(paramArrayOfint[i]);
      int k = 0;
      int m;
      for (m = 1; k < j; m = i1) {
        int i1 = m;
        if (i != k) {
          i1 = this.a.c(paramArrayOfint[k], n);
          if ((i1 & 0x1) == 0) {
            i1 |= 0x1;
          } else {
            i1 &= 0xFFFFFFFE;
          } 
          i1 = this.a.c(m, i1);
        } 
        k++;
      } 
      arrayOfInt[i] = this.a.c(paramGenericGFPoly.b(n), this.a.c(m));
      if (this.a.d() != 0)
        arrayOfInt[i] = this.a.c(arrayOfInt[i], n); 
    } 
    return arrayOfInt;
  }
  
  private GenericGFPoly[] a(GenericGFPoly paramGenericGFPoly1, GenericGFPoly paramGenericGFPoly2, int paramInt) throws ReedSolomonException {
    GenericGFPoly genericGFPoly1 = paramGenericGFPoly1;
    GenericGFPoly genericGFPoly2 = paramGenericGFPoly2;
    if (paramGenericGFPoly1.a() < paramGenericGFPoly2.a()) {
      genericGFPoly2 = paramGenericGFPoly1;
      genericGFPoly1 = paramGenericGFPoly2;
    } 
    GenericGFPoly genericGFPoly3 = this.a.a();
    paramGenericGFPoly2 = this.a.b();
    paramGenericGFPoly1 = genericGFPoly2;
    genericGFPoly2 = genericGFPoly3;
    while (true) {
      genericGFPoly3 = genericGFPoly2;
      genericGFPoly2 = genericGFPoly1;
      genericGFPoly1 = paramGenericGFPoly1;
      if (genericGFPoly1.a() >= paramInt / 2) {
        if (!genericGFPoly1.b()) {
          GenericGFPoly genericGFPoly = this.a.a();
          int i = genericGFPoly1.a(genericGFPoly1.a());
          i = this.a.c(i);
          paramGenericGFPoly1 = genericGFPoly2;
          genericGFPoly2 = genericGFPoly;
          while (paramGenericGFPoly1.a() >= genericGFPoly1.a() && !paramGenericGFPoly1.b()) {
            int j = paramGenericGFPoly1.a() - genericGFPoly1.a();
            int k = this.a.c(paramGenericGFPoly1.a(paramGenericGFPoly1.a()), i);
            genericGFPoly2 = genericGFPoly2.a(this.a.a(j, k));
            paramGenericGFPoly1 = paramGenericGFPoly1.a(genericGFPoly1.a(j, k));
          } 
          genericGFPoly3 = genericGFPoly2.b(paramGenericGFPoly2).a(genericGFPoly3);
          if (paramGenericGFPoly1.a() < genericGFPoly1.a()) {
            genericGFPoly2 = paramGenericGFPoly2;
            paramGenericGFPoly2 = genericGFPoly3;
            continue;
          } 
          throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
        } 
        throw new ReedSolomonException("r_{i-1} was zero");
      } 
      paramInt = paramGenericGFPoly2.a(0);
      if (paramInt != 0) {
        paramInt = this.a.c(paramInt);
        return new GenericGFPoly[] { paramGenericGFPoly2.c(paramInt), genericGFPoly1.c(paramInt) };
      } 
      throw new ReedSolomonException("sigmaTilde(0) was zero");
    } 
  }
  
  public void a(int[] paramArrayOfint, int paramInt) throws ReedSolomonException {
    GenericGFPoly genericGFPoly1 = new GenericGFPoly(this.a, paramArrayOfint);
    int[] arrayOfInt3 = new int[paramInt];
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = true;
    while (i < paramInt) {
      GenericGF genericGF = this.a;
      int j = genericGFPoly1.b(genericGF.a(genericGF.d() + i));
      arrayOfInt3[paramInt - 1 - i] = j;
      if (j != 0)
        bool1 = false; 
      i++;
    } 
    if (bool1)
      return; 
    genericGFPoly1 = new GenericGFPoly(this.a, arrayOfInt3);
    GenericGFPoly[] arrayOfGenericGFPoly = a(this.a.a(paramInt, 1), genericGFPoly1, paramInt);
    genericGFPoly1 = arrayOfGenericGFPoly[0];
    GenericGFPoly genericGFPoly2 = arrayOfGenericGFPoly[1];
    int[] arrayOfInt1 = a(genericGFPoly1);
    int[] arrayOfInt2 = a(genericGFPoly2, arrayOfInt1);
    paramInt = bool2;
    while (paramInt < arrayOfInt1.length) {
      i = paramArrayOfint.length - 1 - this.a.b(arrayOfInt1[paramInt]);
      if (i >= 0) {
        paramArrayOfint[i] = GenericGF.b(paramArrayOfint[i], arrayOfInt2[paramInt]);
        paramInt++;
        continue;
      } 
      throw new ReedSolomonException("Bad error location");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\reedsolomon\ReedSolomonDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */