package com.blued.android.core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class AeroGlassUtils {
  static String a = "AeroGlass";
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt) {
    int i1 = paramInt;
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    if (i1 < 1)
      return null; 
    int i5 = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int i = i5 * j;
    int[] arrayOfInt3 = new int[i];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i5);
    stringBuilder.append(" ");
    stringBuilder.append(j);
    stringBuilder.append(" ");
    stringBuilder.append(arrayOfInt3.length);
    Log.e("pix", stringBuilder.toString());
    paramBitmap.getPixels(arrayOfInt3, 0, i5, 0, 0, i5, j);
    int i8 = i5 - 1;
    int k = j - 1;
    int i6 = i1 + i1 + 1;
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[i];
    int[] arrayOfInt6 = new int[i];
    int[] arrayOfInt1 = new int[Math.max(i5, j)];
    i = i6 + 1 >> 1;
    int m = i * i;
    int n = m * 256;
    int[] arrayOfInt2 = new int[n];
    for (i = 0; i < n; i++)
      arrayOfInt2[i] = i / m; 
    int[][] arrayOfInt = (int[][])Array.newInstance(int.class, new int[] { i6, 3 });
    int i7 = i1 + 1;
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    i = k;
    while (i3 < j) {
      int i15 = -i1;
      int i9 = 0;
      int i10 = 0;
      int i11 = 0;
      n = 0;
      m = 0;
      k = 0;
      int i12 = 0;
      int i13 = 0;
      int i14 = 0;
      while (i15 <= i1) {
        int i19 = arrayOfInt3[i4 + Math.min(i8, Math.max(i15, 0))];
        int[] arrayOfInt7 = arrayOfInt[i15 + i1];
        arrayOfInt7[0] = (i19 & 0xFF0000) >> 16;
        arrayOfInt7[1] = (i19 & 0xFF00) >> 8;
        arrayOfInt7[2] = i19 & 0xFF;
        i19 = i7 - Math.abs(i15);
        i9 += arrayOfInt7[0] * i19;
        i10 += arrayOfInt7[1] * i19;
        i11 += arrayOfInt7[2] * i19;
        if (i15 > 0) {
          i12 += arrayOfInt7[0];
          i13 += arrayOfInt7[1];
          i14 += arrayOfInt7[2];
        } else {
          n += arrayOfInt7[0];
          m += arrayOfInt7[1];
          k += arrayOfInt7[2];
        } 
        i15++;
      } 
      int i17 = i1;
      int i18 = 0;
      i15 = i13;
      int i16 = i12;
      i13 = i9;
      i12 = i17;
      for (i9 = i18; i9 < i5; i9++) {
        arrayOfInt4[i4] = arrayOfInt2[i13];
        arrayOfInt5[i4] = arrayOfInt2[i10];
        arrayOfInt6[i4] = arrayOfInt2[i11];
        int[] arrayOfInt7 = arrayOfInt[(i12 - i1 + i6) % i6];
        int i19 = arrayOfInt7[0];
        i18 = arrayOfInt7[1];
        i17 = arrayOfInt7[2];
        if (i3 == 0)
          arrayOfInt1[i9] = Math.min(i9 + i1 + 1, i8); 
        int i20 = arrayOfInt3[i2 + arrayOfInt1[i9]];
        arrayOfInt7[0] = (i20 & 0xFF0000) >> 16;
        arrayOfInt7[1] = (i20 & 0xFF00) >> 8;
        arrayOfInt7[2] = i20 & 0xFF;
        i16 += arrayOfInt7[0];
        i15 += arrayOfInt7[1];
        i14 += arrayOfInt7[2];
        i13 = i13 - n + i16;
        i10 = i10 - m + i15;
        i11 = i11 - k + i14;
        i12 = (i12 + 1) % i6;
        arrayOfInt7 = arrayOfInt[i12 % i6];
        n = n - i19 + arrayOfInt7[0];
        m = m - i18 + arrayOfInt7[1];
        k = k - i17 + arrayOfInt7[2];
        i16 -= arrayOfInt7[0];
        i15 -= arrayOfInt7[1];
        i14 -= arrayOfInt7[2];
        i4++;
      } 
      i2 += i5;
      i3++;
    } 
    i1 = j;
    k = 0;
    j = i;
    i = k;
    while (true) {
      i2 = paramInt;
      if (i < i5) {
        i3 = -i2;
        i4 = i3 * i5;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        n = 0;
        m = 0;
        k = 0;
        int i12 = 0;
        int i14 = 0;
        int i13 = 0;
        while (i3 <= i2) {
          int i19 = Math.max(0, i4) + i;
          int[] arrayOfInt7 = arrayOfInt[i3 + i2];
          arrayOfInt7[0] = arrayOfInt4[i19];
          arrayOfInt7[1] = arrayOfInt5[i19];
          arrayOfInt7[2] = arrayOfInt6[i19];
          int i20 = i7 - Math.abs(i3);
          int i18 = i9 + arrayOfInt4[i19] * i20;
          i10 += arrayOfInt5[i19] * i20;
          i11 += arrayOfInt6[i19] * i20;
          if (i3 > 0) {
            i12 += arrayOfInt7[0];
            i14 += arrayOfInt7[1];
            i13 += arrayOfInt7[2];
          } else {
            n += arrayOfInt7[0];
            m += arrayOfInt7[1];
            k += arrayOfInt7[2];
          } 
          i9 = i4;
          if (i3 < j)
            i9 = i4 + i5; 
          i3++;
          i4 = i9;
          i9 = i18;
        } 
        i3 = i;
        i4 = i14;
        i14 = i13;
        int i17 = 0;
        i13 = i2;
        int i16 = i12;
        i12 = i10;
        int i15 = i9;
        i2 = i4;
        i4 = i16;
        i9 = i13;
        i10 = i11;
        i11 = i12;
        i13 = i15;
        for (i12 = i17; i12 < i1; i12++) {
          arrayOfInt3[i3] = arrayOfInt3[i3] & 0xFF000000 | arrayOfInt2[i13] << 16 | arrayOfInt2[i11] << 8 | arrayOfInt2[i10];
          int[] arrayOfInt7 = arrayOfInt[(i9 - paramInt + i6) % i6];
          i17 = arrayOfInt7[0];
          i16 = arrayOfInt7[1];
          i15 = arrayOfInt7[2];
          if (i == 0)
            arrayOfInt1[i12] = Math.min(i12 + i7, j) * i5; 
          int i18 = arrayOfInt1[i12] + i;
          arrayOfInt7[0] = arrayOfInt4[i18];
          arrayOfInt7[1] = arrayOfInt5[i18];
          arrayOfInt7[2] = arrayOfInt6[i18];
          i4 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          i14 += arrayOfInt7[2];
          i13 = i13 - n + i4;
          i11 = i11 - m + i2;
          i10 = i10 - k + i14;
          i9 = (i9 + 1) % i6;
          arrayOfInt7 = arrayOfInt[i9];
          n = n - i17 + arrayOfInt7[0];
          m = m - i16 + arrayOfInt7[1];
          k = k - i15 + arrayOfInt7[2];
          i4 -= arrayOfInt7[0];
          i2 -= arrayOfInt7[1];
          i14 -= arrayOfInt7[2];
          i3 += i5;
        } 
        i++;
        continue;
      } 
      paramBitmap.setPixels(arrayOfInt3, 0, i5, 0, 0, i5, i1);
      return paramBitmap;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\AeroGlassUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */