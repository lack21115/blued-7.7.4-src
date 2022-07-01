package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class CodaBarReader extends OneDReader {
  static final char[] a = "0123456789-$:/.+ABCD".toCharArray();
  
  static final int[] b = new int[] { 
      3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 
      12, 24, 69, 81, 84, 21, 26, 41, 11, 14 };
  
  private static final char[] c = new char[] { 'A', 'B', 'C', 'D' };
  
  private final StringBuilder d = new StringBuilder(20);
  
  private int[] e = new int[80];
  
  private int f = 0;
  
  private void a(int paramInt) throws NotFoundException {
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 0;
    arrayOfInt2[2] = 0;
    arrayOfInt2[3] = 0;
    int k = this.d.length() - 1;
    boolean bool = false;
    int j = paramInt;
    int i = 0;
    while (true) {
      int n = b[this.d.charAt(i)];
      int m;
      for (m = 6; m >= 0; m--) {
        int i1 = (m & 0x1) + ((n & 0x1) << 1);
        arrayOfInt1[i1] = arrayOfInt1[i1] + this.e[j + m];
        arrayOfInt2[i1] = arrayOfInt2[i1] + 1;
        n >>= 1;
      } 
      if (i < k) {
        j += 8;
        i++;
        continue;
      } 
      float[] arrayOfFloat1 = new float[4];
      float[] arrayOfFloat2 = new float[4];
      m = 0;
      while (true) {
        i = bool;
        j = paramInt;
        if (m < 2) {
          arrayOfFloat2[m] = 0.0F;
          i = m + 2;
          arrayOfFloat2[i] = (arrayOfInt1[m] / arrayOfInt2[m] + arrayOfInt1[i] / arrayOfInt2[i]) / 2.0F;
          arrayOfFloat1[m] = arrayOfFloat2[i];
          arrayOfFloat1[i] = (arrayOfInt1[i] * 2.0F + 1.5F) / arrayOfInt2[i];
          m++;
          continue;
        } 
        break;
      } 
      while (true) {
        m = b[this.d.charAt(i)];
        paramInt = 6;
        while (paramInt >= 0) {
          n = (paramInt & 0x1) + ((m & 0x1) << 1);
          float f = this.e[j + paramInt];
          if (f >= arrayOfFloat2[n] && f <= arrayOfFloat1[n]) {
            m >>= 1;
            paramInt--;
            continue;
          } 
          throw NotFoundException.a();
        } 
        if (i < k) {
          j += 8;
          i++;
          continue;
        } 
        break;
      } 
      return;
    } 
  }
  
  private void a(BitArray paramBitArray) throws NotFoundException {
    int i = 0;
    this.f = 0;
    int j = paramBitArray.d(0);
    int k = paramBitArray.a();
    if (j < k) {
      boolean bool = true;
      while (j < k) {
        if (paramBitArray.a(j) != bool) {
          i++;
        } else {
          b(i);
          int m = bool ^ true;
          i = 1;
        } 
        j++;
      } 
      b(i);
      return;
    } 
    throw NotFoundException.a();
  }
  
  static boolean a(char[] paramArrayOfchar, char paramChar) {
    if (paramArrayOfchar != null) {
      int j = paramArrayOfchar.length;
      for (int i = 0; i < j; i++) {
        if (paramArrayOfchar[i] == paramChar)
          return true; 
      } 
    } 
    return false;
  }
  
  private int b() throws NotFoundException {
    for (int i = 1; i < this.f; i += 2) {
      int j = c(i);
      if (j != -1 && a(c, a[j])) {
        j = i;
        int k = 0;
        while (j < i + 7) {
          k += this.e[j];
          j++;
        } 
        if (i == 1 || this.e[i - 1] >= k / 2)
          return i; 
      } 
    } 
    throw NotFoundException.a();
  }
  
  private void b(int paramInt) {
    int[] arrayOfInt = this.e;
    int i = this.f;
    arrayOfInt[i] = paramInt;
    this.f = i + 1;
    paramInt = this.f;
    if (paramInt >= arrayOfInt.length) {
      int[] arrayOfInt1 = new int[paramInt << 1];
      System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, paramInt);
      this.e = arrayOfInt1;
    } 
  }
  
  private int c(int paramInt) {
    int i3 = paramInt + 7;
    if (i3 >= this.f)
      return -1; 
    int[] arrayOfInt = this.e;
    int i2 = Integer.MAX_VALUE;
    boolean bool = false;
    int j = paramInt;
    int m = Integer.MAX_VALUE;
    int i;
    for (i = 0; j < i3; i = i6) {
      int i5 = arrayOfInt[j];
      int i4 = m;
      if (i5 < m)
        i4 = i5; 
      int i6 = i;
      if (i5 > i)
        i6 = i5; 
      j += 2;
      m = i4;
    } 
    int i1 = (m + i) / 2;
    i = paramInt + 1;
    j = 0;
    m = i2;
    while (i < i3) {
      int i5 = arrayOfInt[i];
      int i4 = m;
      if (i5 < m)
        i4 = i5; 
      int i6 = j;
      if (i5 > j)
        i6 = i5; 
      i += 2;
      m = i4;
      j = i6;
    } 
    int n = (m + j) / 2;
    j = 0;
    int k = 128;
    i = 0;
    while (true) {
      m = bool;
      if (j < 7) {
        int i4;
        if ((j & 0x1) == 0) {
          i4 = i1;
        } else {
          i4 = n;
        } 
        k >>= 1;
        m = i;
        if (arrayOfInt[paramInt + j] > i4)
          m = i | k; 
        j++;
        i = m;
        continue;
      } 
      break;
    } 
    while (true) {
      arrayOfInt = b;
      if (m < arrayOfInt.length) {
        if (arrayOfInt[m] == i)
          return m; 
        m++;
        continue;
      } 
      return -1;
    } 
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    Arrays.fill(this.e, 0);
    a(paramBitArray);
    int j = b();
    this.d.setLength(0);
    int i = j;
    while (true) {
      int k = c(i);
      if (k != -1) {
        this.d.append((char)k);
        int m = i + 8;
        if (this.d.length() <= 1 || !a(c, a[k])) {
          i = m;
          if (m >= this.f) {
            int[] arrayOfInt = this.e;
            int n = m - 1;
            int i1 = arrayOfInt[n];
            i = -8;
            k = 0;
            while (i < -1) {
              k += this.e[m + i];
              i++;
            } 
            if (m >= this.f || i1 >= k / 2) {
              a(j);
              for (i = 0; i < this.d.length(); i++) {
                StringBuilder stringBuilder = this.d;
                stringBuilder.setCharAt(i, a[stringBuilder.charAt(i)]);
              } 
              char c = this.d.charAt(0);
              if (a(c, c)) {
                StringBuilder stringBuilder = this.d;
                c = stringBuilder.charAt(stringBuilder.length() - 1);
                if (a(c, c)) {
                  if (this.d.length() > 3) {
                    if (paramMap == null || !paramMap.containsKey(DecodeHintType.i)) {
                      stringBuilder = this.d;
                      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                      this.d.deleteCharAt(0);
                    } 
                    k = 0;
                    i = 0;
                    while (k < j) {
                      i += this.e[k];
                      k++;
                    } 
                    float f1 = i;
                    while (j < n) {
                      i += this.e[j];
                      j++;
                    } 
                    float f2 = i;
                    String str = this.d.toString();
                    float f3 = paramInt;
                    ResultPoint resultPoint1 = new ResultPoint(f1, f3);
                    ResultPoint resultPoint2 = new ResultPoint(f2, f3);
                    BarcodeFormat barcodeFormat = BarcodeFormat.b;
                    return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
                  } 
                  throw NotFoundException.a();
                } 
                throw NotFoundException.a();
              } 
              throw NotFoundException.a();
            } 
            throw NotFoundException.a();
          } 
          continue;
        } 
        continue;
      } 
      throw NotFoundException.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\CodaBarReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */