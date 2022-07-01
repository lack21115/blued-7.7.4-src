package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
  private BitMatrix a;
  
  public HybridBinarizer(LuminanceSource paramLuminanceSource) {
    super(paramLuminanceSource);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 < paramInt2) ? paramInt2 : ((paramInt1 > paramInt3) ? paramInt3 : paramInt1);
  }
  
  private static void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix) {
    int i = paramInt2 * paramInt4 + paramInt1;
    int j = 0;
    while (j < 8) {
      int k;
      for (k = 0; k < 8; k++) {
        if ((paramArrayOfbyte[i + k] & 0xFF) <= paramInt3)
          paramBitMatrix.b(paramInt1 + k, paramInt2 + j); 
      } 
      j++;
      i += paramInt4;
    } 
  }
  
  private static void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfint, BitMatrix paramBitMatrix) {
    int i = paramInt4 - 8;
    int j = paramInt3 - 8;
    for (paramInt4 = 0; paramInt4 < paramInt2; paramInt4++) {
      int k = paramInt4 << 3;
      if (k > i)
        k = i; 
      int n = a(paramInt4, 2, paramInt2 - 3);
      int m;
      for (m = 0; m < paramInt1; m++) {
        int i1 = m << 3;
        if (i1 > j)
          i1 = j; 
        int i4 = a(m, 2, paramInt1 - 3);
        int i2 = -2;
        int i3 = 0;
        while (i2 <= 2) {
          int[] arrayOfInt = paramArrayOfint[n + i2];
          i3 += arrayOfInt[i4 - 2] + arrayOfInt[i4 - 1] + arrayOfInt[i4] + arrayOfInt[i4 + 1] + arrayOfInt[i4 + 2];
          i2++;
        } 
        a(paramArrayOfbyte, i1, k, i3 / 25, paramInt3, paramBitMatrix);
      } 
    } 
  }
  
  private static int[][] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = 8;
    int k = paramInt4 - 8;
    int m = paramInt3 - 8;
    int[][] arrayOfInt = (int[][])Array.newInstance(int.class, new int[] { paramInt2, paramInt1 });
    int j;
    for (j = 0; j < paramInt2; j++) {
      paramInt4 = j << 3;
      int n = paramInt4;
      if (paramInt4 > k)
        n = k; 
      int i1;
      for (i1 = 0; i1 < paramInt1; i1++) {
        int i2 = i1 << 3;
        paramInt4 = i2;
        if (i2 > m)
          paramInt4 = m; 
        i2 = n * paramInt3 + paramInt4;
        int i3 = 0;
        paramInt4 = 0;
        int i4 = 0;
        int i5 = 255;
        while (i3 < i) {
          int i7;
          int i6 = 0;
          while (i6 < i) {
            i = paramArrayOfbyte[i2 + i6] & 0xFF;
            i7 = paramInt4 + i;
            paramInt4 = i5;
            if (i < i5)
              paramInt4 = i; 
            i5 = i4;
            if (i > i4)
              i5 = i; 
            i6++;
            i = 8;
            i4 = i5;
            i5 = paramInt4;
            paramInt4 = i7;
          } 
          if (i4 - i5 > 24) {
            i = i3 + 1;
            i2 += paramInt3;
            i3 = paramInt4;
            paramInt4 = i2;
            i2 = i;
            while (true) {
              i7 = i2;
              i6 = paramInt4;
              i = i3;
              if (i2 < 8) {
                for (i = 0; i < 8; i++)
                  i3 += paramArrayOfbyte[paramInt4 + i] & 0xFF; 
                i2++;
                paramInt4 += paramInt3;
                continue;
              } 
              break;
            } 
          } else {
            i = paramInt4;
            i6 = i2;
            i7 = i3;
          } 
          i3 = 8;
          paramInt4 = i;
          i7++;
          i2 = i6 + paramInt3;
          i = i3;
          i3 = i7;
        } 
        paramInt4 >>= 6;
        if (i4 - i5 <= 24) {
          i2 = i5 / 2;
          paramInt4 = i2;
          if (j > 0) {
            paramInt4 = i2;
            if (i1 > 0) {
              paramInt4 = j - 1;
              i3 = arrayOfInt[paramInt4][i1];
              int[] arrayOfInt1 = arrayOfInt[j];
              i4 = i1 - 1;
              i3 = (i3 + arrayOfInt1[i4] * 2 + arrayOfInt[paramInt4][i4]) / 4;
              paramInt4 = i2;
              if (i5 < i3)
                paramInt4 = i3; 
            } 
          } 
        } 
        arrayOfInt[j][i1] = paramInt4;
      } 
    } 
    return arrayOfInt;
  }
  
  public Binarizer a(LuminanceSource paramLuminanceSource) {
    return new HybridBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix b() throws NotFoundException {
    BitMatrix bitMatrix = this.a;
    if (bitMatrix != null)
      return bitMatrix; 
    LuminanceSource luminanceSource = a();
    int i = luminanceSource.d();
    int j = luminanceSource.e();
    if (i >= 40 && j >= 40) {
      byte[] arrayOfByte = luminanceSource.a();
      int m = i >> 3;
      int k = m;
      if ((i & 0x7) != 0)
        k = m + 1; 
      int n = j >> 3;
      m = n;
      if ((j & 0x7) != 0)
        m = n + 1; 
      int[][] arrayOfInt = a(arrayOfByte, k, m, i, j);
      BitMatrix bitMatrix1 = new BitMatrix(i, j);
      a(arrayOfByte, k, m, i, j, arrayOfInt, bitMatrix1);
      this.a = bitMatrix1;
    } else {
      this.a = super.b();
    } 
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\HybridBinarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */