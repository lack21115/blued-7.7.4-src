package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {
  private final int a;
  
  private final int b;
  
  private final int c;
  
  private final int[] d;
  
  public BitMatrix(int paramInt) {
    this(paramInt, paramInt);
  }
  
  public BitMatrix(int paramInt1, int paramInt2) {
    if (paramInt1 > 0 && paramInt2 > 0) {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = (paramInt1 + 31) / 32;
      this.d = new int[this.c * paramInt2];
      return;
    } 
    throw new IllegalArgumentException("Both dimensions must be greater than 0");
  }
  
  private BitMatrix(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramArrayOfint;
  }
  
  private String a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder(this.b * (this.a + 1));
    int i;
    for (i = 0; i < this.b; i++) {
      int j;
      for (j = 0; j < this.a; j++) {
        String str;
        if (a(j, i)) {
          str = paramString1;
        } else {
          str = paramString2;
        } 
        stringBuilder.append(str);
      } 
      stringBuilder.append(paramString3);
    } 
    return stringBuilder.toString();
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray) {
    if (paramBitArray == null || paramBitArray.a() < this.a) {
      paramBitArray = new BitArray(this.a);
    } else {
      paramBitArray.b();
    } 
    int j = this.c;
    for (int i = 0; i < this.c; i++)
      paramBitArray.a(i << 5, this.d[paramInt * j + i]); 
    return paramBitArray;
  }
  
  public String a(String paramString1, String paramString2) {
    return a(paramString1, paramString2, "\n");
  }
  
  public void a() {
    int i = e();
    int j = f();
    BitArray bitArray2 = new BitArray(i);
    BitArray bitArray1 = new BitArray(i);
    for (i = 0; i < (j + 1) / 2; i++) {
      bitArray2 = a(i, bitArray2);
      int k = j - 1 - i;
      bitArray1 = a(k, bitArray1);
      bitArray2.d();
      bitArray1.d();
      b(i, bitArray1);
      b(k, bitArray2);
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt2 >= 0 && paramInt1 >= 0) {
      if (paramInt4 > 0 && paramInt3 > 0) {
        int i = paramInt3 + paramInt1;
        paramInt4 += paramInt2;
        if (paramInt4 <= this.b && i <= this.a) {
          while (paramInt2 < paramInt4) {
            int j = this.c;
            for (paramInt3 = paramInt1; paramInt3 < i; paramInt3++) {
              int[] arrayOfInt = this.d;
              int k = paramInt3 / 32 + j * paramInt2;
              arrayOfInt[k] = arrayOfInt[k] | 1 << (paramInt3 & 0x1F);
            } 
            paramInt2++;
          } 
          return;
        } 
        throw new IllegalArgumentException("The region must fit inside the matrix");
      } 
      throw new IllegalArgumentException("Height and width must be at least 1");
    } 
    throw new IllegalArgumentException("Left and top must be nonnegative");
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    int i = this.c;
    int j = paramInt1 / 32;
    return ((this.d[paramInt2 * i + j] >>> (paramInt1 & 0x1F) & 0x1) != 0);
  }
  
  public void b(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2 * this.c + paramInt1 / 32;
    int[] arrayOfInt = this.d;
    arrayOfInt[paramInt2] = 1 << (paramInt1 & 0x1F) | arrayOfInt[paramInt2];
  }
  
  public void b(int paramInt, BitArray paramBitArray) {
    int[] arrayOfInt1 = paramBitArray.c();
    int[] arrayOfInt2 = this.d;
    int i = this.c;
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, paramInt * i, i);
  }
  
  public int[] b() {
    int j = this.a;
    int n = this.b;
    int k = -1;
    int m = -1;
    int i = 0;
    while (i < this.b) {
      int i1 = m;
      m = k;
      int i2 = 0;
      k = i1;
      while (true) {
        i1 = this.c;
        if (i2 < i1) {
          int i7 = this.d[i1 * i + i2];
          int i5 = j;
          int i6 = m;
          int i3 = n;
          int i4 = k;
          if (i7 != 0) {
            i1 = n;
            if (i < n)
              i1 = i; 
            n = k;
            if (i > k)
              n = i; 
            int i8 = i2 << 5;
            byte b = 31;
            k = j;
            if (i8 < j) {
              for (k = 0; i7 << 31 - k == 0; k++);
              i3 = k + i8;
              k = j;
              if (i3 < j)
                k = i3; 
            } 
            i5 = k;
            i6 = m;
            i3 = i1;
            i4 = n;
            if (i8 + 31 > m) {
              for (j = b; i7 >>> j == 0; j--);
              j = i8 + j;
              i5 = k;
              i6 = m;
              i3 = i1;
              i4 = n;
              if (j > m) {
                i6 = j;
                i4 = n;
                i3 = i1;
                i5 = k;
              } 
            } 
          } 
          i2++;
          j = i5;
          m = i6;
          n = i3;
          k = i4;
          continue;
        } 
        i++;
        i1 = k;
        k = m;
        m = i1;
      } 
    } 
    return (k < j || m < n) ? null : new int[] { j, n, k - j + 1, m - n + 1 };
  }
  
  public void c(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2 * this.c + paramInt1 / 32;
    int[] arrayOfInt = this.d;
    arrayOfInt[paramInt2] = 1 << (paramInt1 & 0x1F) ^ arrayOfInt[paramInt2];
  }
  
  public int[] c() {
    int i = 0;
    while (true) {
      int[] arrayOfInt1 = this.d;
      if (i < arrayOfInt1.length && arrayOfInt1[i] == 0) {
        i++;
        continue;
      } 
      break;
    } 
    int[] arrayOfInt = this.d;
    if (i == arrayOfInt.length)
      return null; 
    int k = this.c;
    int m = i / k;
    int n = arrayOfInt[i];
    int j;
    for (j = 0; n << 31 - j == 0; j++);
    return new int[] { (i % k << 5) + j, m };
  }
  
  public int[] d() {
    int i;
    for (i = this.d.length - 1; i >= 0 && this.d[i] == 0; i--);
    if (i < 0)
      return null; 
    int k = this.c;
    int m = i / k;
    int n = this.d[i];
    int j;
    for (j = 31; n >>> j == 0; j--);
    return new int[] { (i % k << 5) + j, m };
  }
  
  public int e() {
    return this.a;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof BitMatrix))
      return false; 
    paramObject = paramObject;
    return (this.a == ((BitMatrix)paramObject).a && this.b == ((BitMatrix)paramObject).b && this.c == ((BitMatrix)paramObject).c && Arrays.equals(this.d, ((BitMatrix)paramObject).d));
  }
  
  public int f() {
    return this.b;
  }
  
  public BitMatrix g() {
    return new BitMatrix(this.a, this.b, this.c, (int[])this.d.clone());
  }
  
  public int hashCode() {
    int i = this.a;
    return (((i * 31 + i) * 31 + this.b) * 31 + this.c) * 31 + Arrays.hashCode(this.d);
  }
  
  public String toString() {
    return a("X ", "  ");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\BitMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */