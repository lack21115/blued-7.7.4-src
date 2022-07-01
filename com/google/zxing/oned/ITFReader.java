package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader extends OneDReader {
  private static final int[] a = new int[] { 6, 8, 10, 12, 14 };
  
  private static final int[] c = new int[] { 1, 1, 1, 1 };
  
  private static final int[][] d = new int[][] { { 1, 1, 2 }, { 1, 1, 3 } };
  
  private static final int[][] e;
  
  private int b = -1;
  
  static {
    int[] arrayOfInt1 = { 1, 2, 1, 1, 2 };
    int[] arrayOfInt2 = { 1, 2, 2, 1, 1 };
    int[] arrayOfInt3 = { 1, 1, 1, 2, 2 };
    int[] arrayOfInt4 = { 2, 1, 1, 2, 1 };
    int[] arrayOfInt5 = { 3, 1, 1, 1, 3 };
    int[] arrayOfInt6 = { 3, 3, 1, 1, 1 };
    int[] arrayOfInt7 = { 1, 1, 3, 1, 3 };
    int[] arrayOfInt8 = { 3, 1, 3, 1, 1 };
    int[] arrayOfInt9 = { 1, 1, 1, 3, 3 };
    int[] arrayOfInt10 = { 1, 3, 1, 3, 1 };
    e = new int[][] { 
        { 1, 1, 2, 2, 1 }, { 2, 1, 1, 1, 2 }, arrayOfInt1, { 2, 2, 1, 1, 1 }, { 1, 1, 2, 1, 2 }, { 2, 1, 2, 1, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 1, 2, 1, 2, 1 }, 
        { 1, 1, 3, 3, 1 }, arrayOfInt5, { 1, 3, 1, 1, 3 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 1, 3, 3, 1, 1 }, arrayOfInt9, { 3, 1, 1, 3, 1 }, arrayOfInt10 };
  }
  
  private static int a(int[] paramArrayOfint) throws NotFoundException {
    int k = e.length;
    int i = 0;
    int j = -1;
    for (float f = 0.38F; i < k; f = f1) {
      float f1;
      float f2 = a(paramArrayOfint, e[i], 0.5F);
      if (f2 < f) {
        j = i;
        f1 = f2;
      } else {
        f1 = f;
        if (f2 == f) {
          j = -1;
          f1 = f;
        } 
      } 
      i++;
    } 
    if (j >= 0)
      return j % 10; 
    throw NotFoundException.a();
  }
  
  private void a(BitArray paramBitArray, int paramInt) throws NotFoundException {
    int i = this.b * 10;
    if (i >= paramInt)
      i = paramInt; 
    while (i > 0 && --paramInt >= 0 && !paramBitArray.a(paramInt)) {
      i--;
      paramInt--;
    } 
    if (i == 0)
      return; 
    throw NotFoundException.a();
  }
  
  private static void a(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    label16: while (paramInt1 < paramInt2) {
      a(paramBitArray, paramInt1, arrayOfInt1);
      boolean bool = false;
      int i;
      for (i = 0; i < 5; i++) {
        int k = i * 2;
        arrayOfInt2[i] = arrayOfInt1[k];
        arrayOfInt3[i] = arrayOfInt1[k + 1];
      } 
      paramStringBuilder.append((char)(a(arrayOfInt2) + 48));
      paramStringBuilder.append((char)(a(arrayOfInt3) + 48));
      int j = paramInt1;
      i = bool;
      while (true) {
        paramInt1 = j;
        if (i < 10) {
          j += arrayOfInt1[i];
          i++;
          continue;
        } 
        continue label16;
      } 
    } 
  }
  
  private int[] a(BitArray paramBitArray) throws NotFoundException {
    int[] arrayOfInt = c(paramBitArray, b(paramBitArray), c);
    this.b = (arrayOfInt[1] - arrayOfInt[0]) / 4;
    a(paramBitArray, arrayOfInt[0]);
    return arrayOfInt;
  }
  
  private static int b(BitArray paramBitArray) throws NotFoundException {
    int i = paramBitArray.a();
    int j = paramBitArray.c(0);
    if (j != i)
      return j; 
    throw NotFoundException.a();
  }
  
  private int[] c(BitArray paramBitArray) throws NotFoundException {
    paramBitArray.d();
    try {
      int[] arrayOfInt;
      int i = b(paramBitArray);
      try {
        arrayOfInt = c(paramBitArray, i, d[0]);
      } catch (NotFoundException notFoundException) {
        arrayOfInt = c(paramBitArray, i, d[1]);
      } 
      a(paramBitArray, arrayOfInt[0]);
      i = arrayOfInt[0];
      arrayOfInt[0] = paramBitArray.a() - arrayOfInt[1];
      arrayOfInt[1] = paramBitArray.a() - i;
      return arrayOfInt;
    } finally {
      paramBitArray.d();
    } 
  }
  
  private static int[] c(BitArray paramBitArray, int paramInt, int[] paramArrayOfint) throws NotFoundException {
    int m = paramArrayOfint.length;
    int[] arrayOfInt = new int[m];
    int n = paramBitArray.a();
    int i = paramInt;
    boolean bool = false;
    int k = 0;
    int j = paramInt;
    paramInt = i;
    i = k;
    while (j < n) {
      if (paramBitArray.a(j) != bool) {
        arrayOfInt[i] = arrayOfInt[i] + 1;
        k = paramInt;
      } else {
        if (i == m - 1) {
          if (a(arrayOfInt, paramArrayOfint, 0.5F) < 0.38F)
            return new int[] { paramInt, j }; 
          k = paramInt + arrayOfInt[0] + arrayOfInt[1];
          paramInt = i - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, paramInt);
          arrayOfInt[paramInt] = 0;
          arrayOfInt[i] = 0;
          paramInt = i - 1;
          i = k;
        } else {
          k = i + 1;
          i = paramInt;
          paramInt = k;
        } 
        arrayOfInt[paramInt] = 1;
        int i1 = bool ^ true;
        k = i;
        i = paramInt;
      } 
      j++;
      paramInt = k;
    } 
    throw NotFoundException.a();
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws FormatException, NotFoundException {
    int[] arrayOfInt1;
    int[] arrayOfInt3 = a(paramBitArray);
    int[] arrayOfInt2 = c(paramBitArray);
    StringBuilder stringBuilder = new StringBuilder(20);
    a(paramBitArray, arrayOfInt3[1], arrayOfInt2[0], stringBuilder);
    String str = stringBuilder.toString();
    if (paramMap != null) {
      int[] arrayOfInt = (int[])paramMap.get(DecodeHintType.f);
    } else {
      paramBitArray = null;
    } 
    BitArray bitArray = paramBitArray;
    if (paramBitArray == null)
      arrayOfInt1 = a; 
    int m = str.length();
    int n = arrayOfInt1.length;
    int i = 0;
    int j = 0;
    while (true) {
      if (i < n) {
        int i2 = arrayOfInt1[i];
        if (m == i2) {
          i = 1;
          break;
        } 
        int i1 = j;
        if (i2 > j)
          i1 = i2; 
        i++;
        j = i1;
        continue;
      } 
      i = 0;
      break;
    } 
    int k = i;
    if (i == 0) {
      k = i;
      if (m > j)
        k = 1; 
    } 
    if (k != 0) {
      float f1 = arrayOfInt3[1];
      float f2 = paramInt;
      ResultPoint resultPoint1 = new ResultPoint(f1, f2);
      ResultPoint resultPoint2 = new ResultPoint(arrayOfInt2[0], f2);
      BarcodeFormat barcodeFormat = BarcodeFormat.i;
      return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
    } 
    throw FormatException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\ITFReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */