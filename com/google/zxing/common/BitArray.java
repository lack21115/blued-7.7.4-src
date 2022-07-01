package com.google.zxing.common;

import java.util.Arrays;

public final class BitArray implements Cloneable {
  private int[] a;
  
  private int b;
  
  public BitArray() {
    this.b = 0;
    this.a = new int[1];
  }
  
  public BitArray(int paramInt) {
    this.b = paramInt;
    this.a = e(paramInt);
  }
  
  BitArray(int[] paramArrayOfint, int paramInt) {
    this.a = paramArrayOfint;
    this.b = paramInt;
  }
  
  private static int[] e(int paramInt) {
    return new int[(paramInt + 31) / 32];
  }
  
  public int a() {
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a[paramInt1 / 32] = paramInt2;
  }
  
  public boolean a(int paramInt) {
    return ((1 << (paramInt & 0x1F) & this.a[paramInt / 32]) != 0);
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramInt2 >= paramInt1 && paramInt1 >= 0 && paramInt2 <= this.b) {
      if (paramInt2 == paramInt1)
        return true; 
      int k = paramInt2 - 1;
      int j = paramInt1 / 32;
      int m = k / 32;
      int i;
      for (i = j; i <= m; i++) {
        int n = 31;
        if (i > j) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramInt1 & 0x1F;
        } 
        if (i >= m)
          n = 0x1F & k; 
        n = (2 << n) - (1 << paramInt2);
        int i1 = this.a[i];
        if (paramBoolean) {
          paramInt2 = n;
        } else {
          paramInt2 = 0;
        } 
        if ((i1 & n) != paramInt2)
          return false; 
      } 
      return true;
    } 
    throw new IllegalArgumentException();
  }
  
  public void b() {
    int j = this.a.length;
    for (int i = 0; i < j; i++)
      this.a[i] = 0; 
  }
  
  public void b(int paramInt) {
    int[] arrayOfInt = this.a;
    int i = paramInt / 32;
    arrayOfInt[i] = 1 << (paramInt & 0x1F) | arrayOfInt[i];
  }
  
  public int c(int paramInt) {
    int i = this.b;
    if (paramInt >= i)
      return i; 
    int j = paramInt / 32;
    i = (1 << (paramInt & 0x1F)) - 1 & this.a[j];
    paramInt = j;
    while (i == 0) {
      paramInt++;
      int[] arrayOfInt = this.a;
      if (paramInt == arrayOfInt.length)
        return this.b; 
      i = arrayOfInt[paramInt];
    } 
    paramInt = (paramInt << 5) + Integer.numberOfTrailingZeros(i);
    i = this.b;
    return (paramInt > i) ? i : paramInt;
  }
  
  public int[] c() {
    return this.a;
  }
  
  public int d(int paramInt) {
    int i = this.b;
    if (paramInt >= i)
      return i; 
    int j = paramInt / 32;
    i = (1 << (paramInt & 0x1F)) - 1 & this.a[j];
    paramInt = j;
    while (i == 0) {
      paramInt++;
      int[] arrayOfInt = this.a;
      if (paramInt == arrayOfInt.length)
        return this.b; 
      i = arrayOfInt[paramInt];
    } 
    paramInt = (paramInt << 5) + Integer.numberOfTrailingZeros(i);
    i = this.b;
    return (paramInt > i) ? i : paramInt;
  }
  
  public void d() {
    int[] arrayOfInt = new int[this.a.length];
    int j = (this.b - 1) / 32;
    int k = j + 1;
    int i;
    for (i = 0; i < k; i++) {
      long l = this.a[i];
      l = (l & 0x55555555L) << 1L | l >> 1L & 0x55555555L;
      l = (l & 0x33333333L) << 2L | l >> 2L & 0x33333333L;
      l = (l & 0xF0F0F0FL) << 4L | l >> 4L & 0xF0F0F0FL;
      l = (l & 0xFF00FFL) << 8L | l >> 8L & 0xFF00FFL;
      arrayOfInt[j - i] = (int)((l & 0xFFFFL) << 16L | l >> 16L & 0xFFFFL);
    } 
    i = this.b;
    j = k << 5;
    if (i != j) {
      int m = j - i;
      j = arrayOfInt[0] >>> m;
      for (i = 1; i < k; i++) {
        int n = arrayOfInt[i];
        arrayOfInt[i - 1] = j | n << 32 - m;
        j = n >>> m;
      } 
      arrayOfInt[k - 1] = j;
    } 
    this.a = arrayOfInt;
  }
  
  public BitArray e() {
    return new BitArray((int[])this.a.clone(), this.b);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof BitArray))
      return false; 
    paramObject = paramObject;
    return (this.b == ((BitArray)paramObject).b && Arrays.equals(this.a, ((BitArray)paramObject).a));
  }
  
  public int hashCode() {
    return this.b * 31 + Arrays.hashCode(this.a);
  }
  
  public String toString() {
    int i = this.b;
    StringBuilder stringBuilder = new StringBuilder(i + i / 8 + 1);
    for (i = 0; i < this.b; i++) {
      byte b;
      if ((i & 0x7) == 0)
        stringBuilder.append(' '); 
      if (a(i)) {
        b = 88;
      } else {
        b = 46;
      } 
      stringBuilder.append(b);
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\BitArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */