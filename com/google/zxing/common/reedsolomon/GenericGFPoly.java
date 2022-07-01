package com.google.zxing.common.reedsolomon;

final class GenericGFPoly {
  private final GenericGF a;
  
  private final int[] b;
  
  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfint) {
    if (paramArrayOfint.length != 0) {
      this.a = paramGenericGF;
      int i = paramArrayOfint.length;
      if (i > 1 && paramArrayOfint[0] == 0) {
        int j;
        for (j = 1; j < i && paramArrayOfint[j] == 0; j++);
        if (j == i) {
          this.b = new int[] { 0 };
          return;
        } 
        this.b = new int[i - j];
        int[] arrayOfInt = this.b;
        System.arraycopy(paramArrayOfint, j, arrayOfInt, 0, arrayOfInt.length);
        return;
      } 
      this.b = paramArrayOfint;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  int a() {
    return this.b.length - 1;
  }
  
  int a(int paramInt) {
    int[] arrayOfInt = this.b;
    return arrayOfInt[arrayOfInt.length - 1 - paramInt];
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.a.a(); 
      int i = this.b.length;
      int[] arrayOfInt = new int[paramInt1 + i];
      for (paramInt1 = 0; paramInt1 < i; paramInt1++)
        arrayOfInt[paramInt1] = this.a.c(this.b[paramInt1], paramInt2); 
      return new GenericGFPoly(this.a, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  GenericGFPoly a(GenericGFPoly paramGenericGFPoly) {
    if (this.a.equals(paramGenericGFPoly.a)) {
      if (b())
        return paramGenericGFPoly; 
      if (paramGenericGFPoly.b())
        return this; 
      int[] arrayOfInt2 = this.b;
      int[] arrayOfInt4 = paramGenericGFPoly.b;
      int[] arrayOfInt3 = arrayOfInt2;
      int[] arrayOfInt1 = arrayOfInt4;
      if (arrayOfInt2.length > arrayOfInt4.length) {
        arrayOfInt3 = arrayOfInt4;
        arrayOfInt1 = arrayOfInt2;
      } 
      arrayOfInt2 = new int[arrayOfInt1.length];
      int j = arrayOfInt1.length - arrayOfInt3.length;
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, j);
      for (int i = j; i < arrayOfInt1.length; i++)
        arrayOfInt2[i] = GenericGF.b(arrayOfInt3[i - j], arrayOfInt1[i]); 
      return new GenericGFPoly(this.a, arrayOfInt2);
    } 
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  int b(int paramInt) {
    int j = 0;
    if (paramInt == 0)
      return a(0); 
    int i = 1;
    if (paramInt == 1) {
      int[] arrayOfInt1 = this.b;
      int m = arrayOfInt1.length;
      i = 0;
      for (paramInt = j; paramInt < m; paramInt++)
        i = GenericGF.b(i, arrayOfInt1[paramInt]); 
      return i;
    } 
    int[] arrayOfInt = this.b;
    j = arrayOfInt[0];
    int k = arrayOfInt.length;
    while (i < k) {
      j = GenericGF.b(this.a.c(paramInt, j), this.b[i]);
      i++;
    } 
    return j;
  }
  
  GenericGFPoly b(GenericGFPoly paramGenericGFPoly) {
    if (this.a.equals(paramGenericGFPoly.a)) {
      if (b() || paramGenericGFPoly.b())
        return this.a.a(); 
      int[] arrayOfInt2 = this.b;
      int j = arrayOfInt2.length;
      int[] arrayOfInt1 = paramGenericGFPoly.b;
      int k = arrayOfInt1.length;
      int[] arrayOfInt3 = new int[j + k - 1];
      for (int i = 0; i < j; i++) {
        int n = arrayOfInt2[i];
        for (int m = 0; m < k; m++) {
          int i1 = i + m;
          arrayOfInt3[i1] = GenericGF.b(arrayOfInt3[i1], this.a.c(n, arrayOfInt1[m]));
        } 
      } 
      return new GenericGFPoly(this.a, arrayOfInt3);
    } 
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  boolean b() {
    return (this.b[0] == 0);
  }
  
  GenericGFPoly c(int paramInt) {
    if (paramInt == 0)
      return this.a.a(); 
    if (paramInt == 1)
      return this; 
    int j = this.b.length;
    int[] arrayOfInt = new int[j];
    for (int i = 0; i < j; i++)
      arrayOfInt[i] = this.a.c(this.b[i], paramInt); 
    return new GenericGFPoly(this.a, arrayOfInt);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(a() * 8);
    for (int i = a(); i >= 0; i--) {
      int j = a(i);
      if (j != 0) {
        int k;
        if (j < 0) {
          stringBuilder.append(" - ");
          k = -j;
        } else {
          k = j;
          if (stringBuilder.length() > 0) {
            stringBuilder.append(" + ");
            k = j;
          } 
        } 
        if (i == 0 || k != 1) {
          k = this.a.b(k);
          if (k == 0) {
            stringBuilder.append('1');
          } else if (k == 1) {
            stringBuilder.append('a');
          } else {
            stringBuilder.append("a^");
            stringBuilder.append(k);
          } 
        } 
        if (i != 0)
          if (i == 1) {
            stringBuilder.append('x');
          } else {
            stringBuilder.append("x^");
            stringBuilder.append(i);
          }  
      } 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\reedsolomon\GenericGFPoly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */