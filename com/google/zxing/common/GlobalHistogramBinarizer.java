package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer extends Binarizer {
  private static final byte[] a = new byte[0];
  
  private byte[] b = a;
  
  private final int[] c = new int[32];
  
  public GlobalHistogramBinarizer(LuminanceSource paramLuminanceSource) {
    super(paramLuminanceSource);
  }
  
  private static int a(int[] paramArrayOfint) throws NotFoundException {
    int i2 = paramArrayOfint.length;
    int i1 = 0;
    int j = 0;
    int n = 0;
    int m = 0;
    int i = 0;
    while (j < i2) {
      int i3 = n;
      if (paramArrayOfint[j] > n) {
        i3 = paramArrayOfint[j];
        i = j;
      } 
      int i4 = m;
      if (paramArrayOfint[j] > m)
        i4 = paramArrayOfint[j]; 
      j++;
      n = i3;
      m = i4;
    } 
    j = 0;
    n = 0;
    int k = i1;
    while (k < i2) {
      int i3 = k - i;
      i1 = paramArrayOfint[k] * i3 * i3;
      i3 = n;
      if (i1 > n) {
        j = k;
        i3 = i1;
      } 
      k++;
      n = i3;
    } 
    n = j;
    k = i;
    if (i > j) {
      k = j;
      n = i;
    } 
    if (n - k > i2 / 16) {
      i = n - 1;
      i1 = i;
      for (j = -1; i > k; j = i3) {
        int i3 = i - k;
        i2 = i3 * i3 * (n - i) * (m - paramArrayOfint[i]);
        i3 = j;
        if (i2 > j) {
          i1 = i;
          i3 = i2;
        } 
        i--;
      } 
      return i1 << 3;
    } 
    throw NotFoundException.a();
  }
  
  private void a(int paramInt) {
    if (this.b.length < paramInt)
      this.b = new byte[paramInt]; 
    for (paramInt = 0; paramInt < 32; paramInt++)
      this.c[paramInt] = 0; 
  }
  
  public Binarizer a(LuminanceSource paramLuminanceSource) {
    return new GlobalHistogramBinarizer(paramLuminanceSource);
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray) throws NotFoundException {
    LuminanceSource luminanceSource = a();
    int j = luminanceSource.d();
    if (paramBitArray == null || paramBitArray.a() < j) {
      paramBitArray = new BitArray(j);
    } else {
      paramBitArray.b();
    } 
    a(j);
    byte[] arrayOfByte = luminanceSource.a(paramInt, this.b);
    int[] arrayOfInt = this.c;
    int i = 0;
    for (paramInt = 0; paramInt < j; paramInt++) {
      int m = (arrayOfByte[paramInt] & 0xFF) >> 3;
      arrayOfInt[m] = arrayOfInt[m] + 1;
    } 
    int k = a(arrayOfInt);
    if (j < 3) {
      for (paramInt = i; paramInt < j; paramInt++) {
        if ((arrayOfByte[paramInt] & 0xFF) < k)
          paramBitArray.b(paramInt); 
      } 
    } else {
      i = arrayOfByte[0];
      paramInt = arrayOfByte[1] & 0xFF;
      int m = i & 0xFF;
      i = 1;
      while (i < j - 1) {
        int i1 = i + 1;
        int n = arrayOfByte[i1] & 0xFF;
        if (((paramInt << 2) - m - n) / 2 < k)
          paramBitArray.b(i); 
        m = paramInt;
        i = i1;
        paramInt = n;
      } 
    } 
    return paramBitArray;
  }
  
  public BitMatrix b() throws NotFoundException {
    LuminanceSource luminanceSource = a();
    int j = luminanceSource.d();
    int k = luminanceSource.e();
    BitMatrix bitMatrix = new BitMatrix(j, k);
    a(j);
    int[] arrayOfInt = this.c;
    int i;
    for (i = 1; i < 5; i++) {
      byte[] arrayOfByte1 = luminanceSource.a(k * i / 5, this.b);
      int i1 = (j << 2) / 5;
      for (int n = j / 5; n < i1; n++) {
        int i2 = (arrayOfByte1[n] & 0xFF) >> 3;
        arrayOfInt[i2] = arrayOfInt[i2] + 1;
      } 
    } 
    int m = a(arrayOfInt);
    byte[] arrayOfByte = luminanceSource.a();
    for (i = 0; i < k; i++) {
      for (int n = 0; n < j; n++) {
        if ((arrayOfByte[i * j + n] & 0xFF) < m)
          bitMatrix.b(n, i); 
      } 
    } 
    return bitMatrix;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\GlobalHistogramBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */