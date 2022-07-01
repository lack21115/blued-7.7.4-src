package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
  private static final int[] a = new int[] { 0, 4, 1, 5 };
  
  private static final int[] b = new int[] { 6, 2, 7, 3 };
  
  private static final int[] c = new int[] { 8, 1, 1, 1, 1, 1, 1, 3 };
  
  private static final int[] d = new int[] { 7, 1, 1, 3, 1, 1, 1, 2, 1 };
  
  private static float a(int[] paramArrayOfint1, int[] paramArrayOfint2, float paramFloat) {
    int m = paramArrayOfint1.length;
    boolean bool = false;
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < m) {
      k += paramArrayOfint1[j];
      i += paramArrayOfint2[j];
      j++;
    } 
    if (k < i)
      return Float.POSITIVE_INFINITY; 
    float f2 = k;
    float f3 = f2 / i;
    float f1 = 0.0F;
    for (i = bool; i < m; i++) {
      j = paramArrayOfint1[i];
      float f4 = paramArrayOfint2[i] * f3;
      float f5 = j;
      if (f5 > f4) {
        f4 = f5 - f4;
      } else {
        f4 -= f5;
      } 
      if (f4 > paramFloat * f3)
        return Float.POSITIVE_INFINITY; 
      f1 += f4;
    } 
    return f1 / f2;
  }
  
  public static PDF417DetectorResult a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean) throws NotFoundException {
    BitMatrix bitMatrix2 = paramBinaryBitmap.c();
    List<ResultPoint[]> list2 = a(paramBoolean, bitMatrix2);
    BitMatrix bitMatrix1 = bitMatrix2;
    List<ResultPoint[]> list1 = list2;
    if (list2.isEmpty()) {
      bitMatrix1 = bitMatrix2.g();
      bitMatrix1.a();
      list1 = a(paramBoolean, bitMatrix1);
    } 
    return new PDF417DetectorResult(bitMatrix1, list1);
  }
  
  private static List<ResultPoint[]> a(boolean paramBoolean, BitMatrix paramBitMatrix) {
    ArrayList<ResultPoint[]> arrayList = new ArrayList();
    int i = 0;
    label31: while (true) {
      int j = 0;
      boolean bool = false;
      while (i < paramBitMatrix.f()) {
        ResultPoint[] arrayOfResultPoint = a(paramBitMatrix, i, j);
        if (arrayOfResultPoint[0] == null && arrayOfResultPoint[3] == null) {
          if (bool) {
            for (ResultPoint[] arrayOfResultPoint1 : arrayList) {
              j = i;
              if (arrayOfResultPoint1[1] != null)
                j = (int)Math.max(i, arrayOfResultPoint1[1].b()); 
              i = j;
              if (arrayOfResultPoint1[3] != null)
                i = Math.max(j, (int)arrayOfResultPoint1[3].b()); 
            } 
            i += 5;
            continue label31;
          } 
          break;
        } 
        arrayList.add(arrayOfResultPoint);
        if (paramBoolean) {
          float f;
          if (arrayOfResultPoint[2] != null) {
            i = (int)arrayOfResultPoint[2].a();
            f = arrayOfResultPoint[2].b();
          } else {
            i = (int)arrayOfResultPoint[4].a();
            f = arrayOfResultPoint[4].b();
          } 
          int k = (int)f;
          j = i;
          bool = true;
          i = k;
        } 
      } 
      break;
    } 
    return (List<ResultPoint[]>)arrayList;
  }
  
  private static void a(ResultPoint[] paramArrayOfResultPoint1, ResultPoint[] paramArrayOfResultPoint2, int[] paramArrayOfint) {
    for (int i = 0; i < paramArrayOfint.length; i++)
      paramArrayOfResultPoint1[paramArrayOfint[i]] = paramArrayOfResultPoint2[i]; 
  }
  
  private static int[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    Arrays.fill(paramArrayOfint2, 0, paramArrayOfint2.length, 0);
    int i;
    for (i = 0; paramBitMatrix.a(paramInt1, paramInt2) && paramInt1 > 0 && i < 3; i++)
      paramInt1--; 
    int m = paramArrayOfint1.length;
    int k = paramInt1;
    i = 0;
    int j = paramInt1;
    paramInt1 = k;
    while (j < paramInt3) {
      if (paramBitMatrix.a(j, paramInt2) != paramBoolean) {
        paramArrayOfint2[i] = paramArrayOfint2[i] + 1;
      } else {
        if (i == m - 1) {
          if (a(paramArrayOfint2, paramArrayOfint1, 0.8F) < 0.42F)
            return new int[] { paramInt1, j }; 
          paramInt1 += paramArrayOfint2[0] + paramArrayOfint2[1];
          k = i - 1;
          System.arraycopy(paramArrayOfint2, 2, paramArrayOfint2, 0, k);
          paramArrayOfint2[k] = 0;
          paramArrayOfint2[i] = 0;
          i--;
        } else {
          i++;
        } 
        paramArrayOfint2[i] = 1;
        int n = paramBoolean ^ true;
      } 
      j++;
    } 
    return (i == m - 1 && a(paramArrayOfint2, paramArrayOfint1, 0.8F) < 0.42F) ? new int[] { paramInt1, j - 1 } : null;
  }
  
  private static ResultPoint[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2) {
    int i = paramBitMatrix.f();
    int j = paramBitMatrix.e();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[8];
    a(arrayOfResultPoint, a(paramBitMatrix, i, j, paramInt1, paramInt2, c), a);
    if (arrayOfResultPoint[4] != null) {
      paramInt2 = (int)arrayOfResultPoint[4].a();
      paramInt1 = (int)arrayOfResultPoint[4].b();
    } 
    a(arrayOfResultPoint, a(paramBitMatrix, i, j, paramInt1, paramInt2, d), b);
    return arrayOfResultPoint;
  }
  
  private static ResultPoint[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    int i;
    ResultPoint[] arrayOfResultPoint = new ResultPoint[4];
    int[] arrayOfInt = new int[paramArrayOfint.length];
    while (true) {
      if (paramInt3 < paramInt1) {
        int[] arrayOfInt1 = a(paramBitMatrix, paramInt4, paramInt3, paramInt2, false, paramArrayOfint, arrayOfInt);
        if (arrayOfInt1 != null) {
          int k = paramInt3;
          while (true) {
            paramInt3 = k;
            if (k > 0) {
              int[] arrayOfInt2 = a(paramBitMatrix, paramInt4, --k, paramInt2, false, paramArrayOfint, arrayOfInt);
              if (arrayOfInt2 != null) {
                arrayOfInt1 = arrayOfInt2;
                continue;
              } 
              paramInt3 = k + 1;
            } 
            break;
          } 
          float f1 = arrayOfInt1[0];
          float f2 = paramInt3;
          arrayOfResultPoint[0] = new ResultPoint(f1, f2);
          arrayOfResultPoint[1] = new ResultPoint(arrayOfInt1[1], f2);
          k = 1;
          paramInt4 = paramInt3;
          break;
        } 
        paramInt3 += 5;
        continue;
      } 
      i = 0;
      paramInt4 = paramInt3;
      break;
    } 
    paramInt3 = paramInt4 + 1;
    int j = paramInt3;
    if (i) {
      int[] arrayOfInt1 = { (int)arrayOfResultPoint[0].a(), (int)arrayOfResultPoint[1].a() };
      j = 0;
      i = paramInt3;
      paramInt3 = j;
      while (i < paramInt1) {
        int k = arrayOfInt1[0];
        j = paramInt3;
        int[] arrayOfInt2 = a(paramBitMatrix, k, i, paramInt2, false, paramArrayOfint, arrayOfInt);
        if (arrayOfInt2 != null && Math.abs(arrayOfInt1[0] - arrayOfInt2[0]) < 5 && Math.abs(arrayOfInt1[1] - arrayOfInt2[1]) < 5) {
          arrayOfInt1 = arrayOfInt2;
          paramInt3 = 0;
        } else if (j <= 25) {
          paramInt3 = j + 1;
        } else {
          break;
        } 
        i++;
      } 
      j = i - paramInt3 + 1;
      float f1 = arrayOfInt1[0];
      float f2 = j;
      arrayOfResultPoint[2] = new ResultPoint(f1, f2);
      arrayOfResultPoint[3] = new ResultPoint(arrayOfInt1[1], f2);
    } 
    if (j - paramInt4 < 10)
      Arrays.fill((Object[])arrayOfResultPoint, (Object)null); 
    return arrayOfResultPoint;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */