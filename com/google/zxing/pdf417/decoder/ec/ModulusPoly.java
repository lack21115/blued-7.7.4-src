package com.google.zxing.pdf417.decoder.ec;

final class ModulusPoly {
  private final ModulusGF a;
  
  private final int[] b;
  
  ModulusPoly(ModulusGF paramModulusGF, int[] paramArrayOfint) {
    if (paramArrayOfint.length != 0) {
      this.a = paramModulusGF;
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
  
  ModulusPoly a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.a.a(); 
      int i = this.b.length;
      int[] arrayOfInt = new int[paramInt1 + i];
      for (paramInt1 = 0; paramInt1 < i; paramInt1++)
        arrayOfInt[paramInt1] = this.a.d(this.b[paramInt1], paramInt2); 
      return new ModulusPoly(this.a, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  ModulusPoly a(ModulusPoly paramModulusPoly) {
    if (this.a.equals(paramModulusPoly.a)) {
      if (b())
        return paramModulusPoly; 
      if (paramModulusPoly.b())
        return this; 
      int[] arrayOfInt2 = this.b;
      int[] arrayOfInt4 = paramModulusPoly.b;
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
        arrayOfInt2[i] = this.a.b(arrayOfInt3[i - j], arrayOfInt1[i]); 
      return new ModulusPoly(this.a, arrayOfInt2);
    } 
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
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
      for (paramInt = j; paramInt < m; paramInt++) {
        j = arrayOfInt1[paramInt];
        i = this.a.b(i, j);
      } 
      return i;
    } 
    int[] arrayOfInt = this.b;
    j = arrayOfInt[0];
    int k = arrayOfInt.length;
    while (i < k) {
      ModulusGF modulusGF = this.a;
      j = modulusGF.b(modulusGF.d(paramInt, j), this.b[i]);
      i++;
    } 
    return j;
  }
  
  ModulusPoly b(ModulusPoly paramModulusPoly) {
    if (this.a.equals(paramModulusPoly.a))
      return paramModulusPoly.b() ? this : a(paramModulusPoly.c()); 
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
  }
  
  boolean b() {
    return (this.b[0] == 0);
  }
  
  ModulusPoly c() {
    int j = this.b.length;
    int[] arrayOfInt = new int[j];
    for (int i = 0; i < j; i++)
      arrayOfInt[i] = this.a.c(0, this.b[i]); 
    return new ModulusPoly(this.a, arrayOfInt);
  }
  
  ModulusPoly c(int paramInt) {
    if (paramInt == 0)
      return this.a.a(); 
    if (paramInt == 1)
      return this; 
    int j = this.b.length;
    int[] arrayOfInt = new int[j];
    for (int i = 0; i < j; i++)
      arrayOfInt[i] = this.a.d(this.b[i], paramInt); 
    return new ModulusPoly(this.a, arrayOfInt);
  }
  
  ModulusPoly c(ModulusPoly paramModulusPoly) {
    if (this.a.equals(paramModulusPoly.a)) {
      if (b() || paramModulusPoly.b())
        return this.a.a(); 
      int[] arrayOfInt2 = this.b;
      int j = arrayOfInt2.length;
      int[] arrayOfInt1 = paramModulusPoly.b;
      int k = arrayOfInt1.length;
      int[] arrayOfInt3 = new int[j + k - 1];
      for (int i = 0; i < j; i++) {
        int n = arrayOfInt2[i];
        for (int m = 0; m < k; m++) {
          int i1 = i + m;
          ModulusGF modulusGF = this.a;
          arrayOfInt3[i1] = modulusGF.b(arrayOfInt3[i1], modulusGF.d(n, arrayOfInt1[m]));
        } 
      } 
      return new ModulusPoly(this.a, arrayOfInt3);
    } 
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
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
        if (i == 0 || k != 1)
          stringBuilder.append(k); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ModulusPoly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */