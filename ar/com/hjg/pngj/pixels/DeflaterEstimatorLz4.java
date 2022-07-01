package ar.com.hjg.pngj.pixels;

import java.nio.ByteOrder;

public final class DeflaterEstimatorLz4 {
  static final ByteOrder a = ByteOrder.nativeOrder();
  
  static final int b = Math.max(6, 2);
  
  static int a(int paramInt) {
    return paramInt * -1640531535 >>> 19;
  }
  
  static int a(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return paramArrayOfbyte[paramInt + 3] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
  }
  
  static int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    int i = 0;
    while (paramInt2 < paramInt3 && paramArrayOfbyte[paramInt1] == paramArrayOfbyte[paramInt2]) {
      i++;
      paramInt1++;
      paramInt2++;
    } 
    return i;
  }
  
  static int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b = 0;
    int i = paramInt1;
    paramInt1 = b;
    while (i > paramInt3 && paramInt2 > paramInt4) {
      b = paramArrayOfbyte[--i];
      if (b == paramArrayOfbyte[--paramInt2])
        paramInt1++; 
    } 
    return paramInt1;
  }
  
  static int a(short[] paramArrayOfshort, int paramInt) {
    return paramArrayOfshort[paramInt] & 0xFFFF;
  }
  
  static void a(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
    paramArrayOfshort[paramInt1] = (short)paramInt2;
  }
  
  static int b(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  static int b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int j = paramInt1 + paramInt2;
    int k = j - 12;
    if (paramInt2 >= 13) {
      short[] arrayOfShort = new short[8192];
      int n = paramInt1 + 1;
      int m = paramInt1;
      paramInt2 = 0;
      label43: while (true) {
        int i1;
        for (i1 = (1 << b) + 3;; i1++) {
          int i2 = (i1 >>> b) + n;
          if (i2 > k) {
            paramInt1 = m;
            break;
          } 
          int i4 = a(c(paramArrayOfbyte, n));
          int i3 = a(arrayOfShort, i4) + paramInt1;
          a(arrayOfShort, i4, n - paramInt1);
          if (c(paramArrayOfbyte, i3, n)) {
            i2 = a(paramArrayOfbyte, i3, n, paramInt1, m);
            i1 = n - i2;
            n = i3 - i2;
            i2 = i1 - m;
            m = ++paramInt2;
            if (i2 >= 15) {
              m = paramInt2;
              if (i2 > 15)
                m = paramInt2 + (i2 - 15) / 255; 
              m++;
            } 
            m += i2;
            paramInt2 = n;
            n = m;
            m = i1;
            while (true) {
              n += 2;
              m += 4;
              i1 = a(paramArrayOfbyte, paramInt2 + 4, m, j - 5);
              m += i1;
              paramInt2 = n;
              if (i1 >= 15) {
                paramInt2 = n;
                if (i1 >= 270)
                  paramInt2 = n + (i1 - 15) / 255; 
                paramInt2++;
              } 
              if (m > k) {
                paramInt1 = m;
                break;
              } 
              n = m - 2;
              a(arrayOfShort, a(c(paramArrayOfbyte, n)), n - paramInt1);
              n = a(c(paramArrayOfbyte, m));
              i1 = paramInt1 + a(arrayOfShort, n);
              a(arrayOfShort, n, m - paramInt1);
              if (!c(paramArrayOfbyte, m, i1)) {
                i1 = m;
                n = m + 1;
                m = i1;
                continue label43;
              } 
              n = paramInt2 + 1;
              paramInt2 = i1;
            } 
            break;
          } 
          n = i2;
        } 
        break;
      } 
    } else {
      paramInt2 = 0;
    } 
    int i = j - paramInt1;
    paramInt1 = paramInt2;
    if (i >= 270)
      paramInt1 = paramInt2 + (i - 15) / 255; 
    return paramInt1 + 1 + i;
  }
  
  static int c(byte[] paramArrayOfbyte, int paramInt) {
    return (a == ByteOrder.BIG_ENDIAN) ? a(paramArrayOfbyte, paramInt) : b(paramArrayOfbyte, paramInt);
  }
  
  static boolean c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (paramArrayOfbyte[paramInt1] == paramArrayOfbyte[paramInt2] && paramArrayOfbyte[paramInt1 + 1] == paramArrayOfbyte[paramInt2 + 1] && paramArrayOfbyte[paramInt1 + 2] == paramArrayOfbyte[paramInt2 + 2] && paramArrayOfbyte[paramInt1 + 3] == paramArrayOfbyte[paramInt2 + 3]);
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt2 < 10)
      return paramInt2; 
    int i = (paramInt2 + 65546 - 1) / 65546;
    int j = paramInt2 / i;
    if (j < 65546 && j * i <= paramInt2 && i >= 1 && j >= 1) {
      int m = 0;
      int k = paramInt1;
      paramInt1 = paramInt2;
      i = 0;
      while (paramInt1 > 0) {
        int n = paramInt1;
        if (paramInt1 > j)
          n = j; 
        m += b(paramArrayOfbyte, k, n);
        k += n;
        i += n;
        paramInt1 = paramInt2 - i;
      } 
      double d = m / i;
      return (i == paramInt2) ? m : (int)(d * paramInt2 + 0.5D);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("?? ");
    stringBuilder.append(paramInt2);
    throw new RuntimeException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\pixels\DeflaterEstimatorLz4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */