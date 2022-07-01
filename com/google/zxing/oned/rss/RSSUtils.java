package com.google.zxing.oned.rss;

public final class RSSUtils {
  private static int a(int paramInt1, int paramInt2) {
    int n;
    int k = paramInt1 - paramInt2;
    int i = k;
    int j = paramInt2;
    if (k > paramInt2) {
      j = k;
      i = paramInt2;
    } 
    paramInt2 = 1;
    int m = 1;
    k = paramInt1;
    paramInt1 = m;
    while (true) {
      m = paramInt2;
      n = paramInt1;
      if (k > j) {
        n = paramInt2 * k;
        paramInt2 = n;
        m = paramInt1;
        if (paramInt1 <= i) {
          paramInt2 = n / paramInt1;
          m = paramInt1 + 1;
        } 
        k--;
        paramInt1 = m;
        continue;
      } 
      break;
    } 
    while (n <= i) {
      m /= n;
      n++;
    } 
    return m;
  }
  
  public static int a(int[] paramArrayOfint, int paramInt, boolean paramBoolean) {
    int[] arrayOfInt = paramArrayOfint;
    int k = arrayOfInt.length;
    int j = 0;
    int i = 0;
    while (j < k) {
      i += arrayOfInt[j];
      j++;
    } 
    int i1 = arrayOfInt.length;
    int m = 0;
    k = 0;
    j = 0;
    int n = i;
    i = k;
    while (true) {
      int i2 = i1 - 1;
      if (m < i2) {
        int i4 = 1 << m;
        k = j | i4;
        j = i;
        int i3 = 1;
        for (i = k; i3 < paramArrayOfint[m]; i &= i4) {
          int i7 = n - i3;
          int i8 = i1 - m;
          int i6 = i8 - 2;
          int i5 = a(i7 - 1, i6);
          k = i5;
          if (paramBoolean) {
            k = i5;
            if (i == 0) {
              int i9 = i8 - 1;
              k = i5;
              if (i7 - i9 >= i9)
                k = i5 - a(i7 - i8, i6); 
            } 
          } 
          if (i8 - 1 > 1) {
            i5 = i7 - i6;
            i6 = 0;
            while (i5 > paramInt) {
              i6 += a(i7 - i5 - 1, i8 - 3);
              i5--;
            } 
            i5 = k - i6 * (i2 - m);
          } else {
            i5 = k;
            if (i7 > paramInt)
              i5 = k - 1; 
          } 
          j += i5;
          i3++;
        } 
        n -= i3;
        m++;
        k = i;
        i = j;
        j = k;
        continue;
      } 
      return i;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\RSSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */