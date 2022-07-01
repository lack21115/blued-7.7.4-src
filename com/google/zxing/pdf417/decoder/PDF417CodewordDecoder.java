package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

final class PDF417CodewordDecoder {
  private static final float[][] a = (float[][])Array.newInstance(float.class, new int[] { PDF417Common.a.length, 8 });
  
  static {
    for (int i = 0; i < PDF417Common.a.length; i++) {
      int m = PDF417Common.a[i];
      int j = m & 0x1;
      int k = 0;
      while (k < 8) {
        float f = 0.0F;
        while (true) {
          int n = m & 0x1;
          if (n == j) {
            f++;
            m >>= 1;
            continue;
          } 
          a[i][8 - k - 1] = f / 17.0F;
          k++;
          j = n;
        } 
      } 
    } 
  }
  
  static int a(int[] paramArrayOfint) {
    int i = c(b(paramArrayOfint));
    return (i != -1) ? i : e(paramArrayOfint);
  }
  
  private static int[] b(int[] paramArrayOfint) {
    float f = MathUtils.a(paramArrayOfint);
    int[] arrayOfInt = new int[8];
    int j = 0;
    int k = 0;
    int i;
    for (i = 0; j < 17; i = m) {
      float f1 = f / 34.0F;
      float f2 = j * f / 17.0F;
      int n = k;
      int m = i;
      if ((paramArrayOfint[i] + k) <= f1 + f2) {
        n = k + paramArrayOfint[i];
        m = i + 1;
      } 
      arrayOfInt[m] = arrayOfInt[m] + 1;
      j++;
      k = n;
    } 
    return arrayOfInt;
  }
  
  private static int c(int[] paramArrayOfint) {
    int i = d(paramArrayOfint);
    return (PDF417Common.a(i) == -1) ? -1 : i;
  }
  
  private static int d(int[] paramArrayOfint) {
    long l = 0L;
    for (int i = 0; i < paramArrayOfint.length; i++) {
      for (int j = 0; j < paramArrayOfint[i]; j++) {
        boolean bool = true;
        if (i % 2 != 0)
          bool = false; 
        l = l << 1L | bool;
      } 
    } 
    return (int)l;
  }
  
  private static int e(int[] paramArrayOfint) {
    int j = MathUtils.a(paramArrayOfint);
    float[] arrayOfFloat = new float[8];
    if (j > 1) {
      int k;
      for (k = 0; k < 8; k++)
        arrayOfFloat[k] = paramArrayOfint[k] / j; 
    } 
    j = -1;
    int i = 0;
    float f = Float.MAX_VALUE;
    while (true) {
      float[][] arrayOfFloat1 = a;
      if (i < arrayOfFloat1.length) {
        float f1;
        float[] arrayOfFloat2 = arrayOfFloat1[i];
        int k = 0;
        float f2 = 0.0F;
        while (true) {
          f1 = f2;
          if (k < 8) {
            f1 = arrayOfFloat2[k] - arrayOfFloat[k];
            f2 += f1 * f1;
            f1 = f2;
            if (f2 < f) {
              k++;
              continue;
            } 
          } 
          break;
        } 
        f2 = f;
        if (f1 < f) {
          j = PDF417Common.a[i];
          f2 = f1;
        } 
        i++;
        f = f2;
        continue;
      } 
      return j;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\PDF417CodewordDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */