package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code93Reader extends OneDReader {
  static final int[] a;
  
  private static final char[] b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
  
  private static final int c;
  
  private final StringBuilder d = new StringBuilder(20);
  
  private final int[] e = new int[6];
  
  static {
    int[] arrayOfInt = new int[48];
    arrayOfInt[0] = 276;
    arrayOfInt[1] = 328;
    arrayOfInt[2] = 324;
    arrayOfInt[3] = 322;
    arrayOfInt[4] = 296;
    arrayOfInt[5] = 292;
    arrayOfInt[6] = 290;
    arrayOfInt[7] = 336;
    arrayOfInt[8] = 274;
    arrayOfInt[9] = 266;
    arrayOfInt[10] = 424;
    arrayOfInt[11] = 420;
    arrayOfInt[12] = 418;
    arrayOfInt[13] = 404;
    arrayOfInt[14] = 402;
    arrayOfInt[15] = 394;
    arrayOfInt[16] = 360;
    arrayOfInt[17] = 356;
    arrayOfInt[18] = 354;
    arrayOfInt[19] = 308;
    arrayOfInt[20] = 282;
    arrayOfInt[21] = 344;
    arrayOfInt[22] = 332;
    arrayOfInt[23] = 326;
    arrayOfInt[24] = 300;
    arrayOfInt[25] = 278;
    arrayOfInt[26] = 436;
    arrayOfInt[27] = 434;
    arrayOfInt[28] = 428;
    arrayOfInt[29] = 422;
    arrayOfInt[30] = 406;
    arrayOfInt[31] = 410;
    arrayOfInt[32] = 364;
    arrayOfInt[33] = 358;
    arrayOfInt[34] = 310;
    arrayOfInt[35] = 314;
    arrayOfInt[36] = 302;
    arrayOfInt[37] = 468;
    arrayOfInt[38] = 466;
    arrayOfInt[39] = 458;
    arrayOfInt[40] = 366;
    arrayOfInt[41] = 374;
    arrayOfInt[42] = 430;
    arrayOfInt[43] = 294;
    arrayOfInt[44] = 474;
    arrayOfInt[45] = 470;
    arrayOfInt[46] = 306;
    arrayOfInt[47] = 350;
    a = arrayOfInt;
    c = arrayOfInt[47];
  }
  
  private static char a(int paramInt) throws NotFoundException {
    int i = 0;
    while (true) {
      int[] arrayOfInt = a;
      if (i < arrayOfInt.length) {
        if (arrayOfInt[i] == paramInt)
          return b[i]; 
        i++;
        continue;
      } 
      throw NotFoundException.a();
    } 
  }
  
  private static int a(int[] paramArrayOfint) {
    int k = paramArrayOfint.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      j += paramArrayOfint[i];
      i++;
    } 
    int m = paramArrayOfint.length;
    k = 0;
    i = 0;
    while (k < m) {
      int n = Math.round(paramArrayOfint[k] * 9.0F / j);
      if (n <= 0 || n > 4)
        return -1; 
      if ((k & 0x1) == 0) {
        int i1;
        for (i1 = 0; i1 < n; i1++)
          i = i << 1 | 0x1; 
      } else {
        i <<= n;
      } 
      k++;
    } 
    return i;
  }
  
  private static String a(CharSequence paramCharSequence) throws FormatException {
    int j = paramCharSequence.length();
    StringBuilder stringBuilder = new StringBuilder(j);
    for (int i = 0; i < j; i++) {
      char c = paramCharSequence.charAt(i);
      if (c >= 'a' && c <= 'd') {
        if (i < j - 1) {
          int k = i + 1;
          i = paramCharSequence.charAt(k);
          switch (c) {
            default:
              c = Character.MIN_VALUE;
              break;
            case 'd':
              if (i >= 65 && i <= 90) {
                i += 32;
              } else {
                throw FormatException.a();
              } 
              c = (char)i;
              break;
            case 'c':
              if (i >= 65 && i <= 79) {
                i -= 32;
              } else {
                if (i == 90) {
                  c = ':';
                  break;
                } 
                throw FormatException.a();
              } 
              c = (char)i;
              break;
            case 'b':
              if (i >= 65 && i <= 69) {
                i -= 38;
              } else if (i >= 70 && i <= 74) {
                i -= 11;
              } else if (i >= 75 && i <= 79) {
                i += 16;
              } else if (i >= 80 && i <= 83) {
                i += 43;
              } else {
                if (i >= 84 && i <= 90) {
                  c = '';
                  break;
                } 
                throw FormatException.a();
              } 
              c = (char)i;
              break;
            case 'a':
              if (i >= 65 && i <= 90) {
                i -= 64;
              } else {
                throw FormatException.a();
              } 
              c = (char)i;
              break;
          } 
          stringBuilder.append(c);
          i = k;
        } else {
          throw FormatException.a();
        } 
      } else {
        stringBuilder.append(c);
      } 
    } 
    return stringBuilder.toString();
  }
  
  private static void a(CharSequence paramCharSequence, int paramInt1, int paramInt2) throws ChecksumException {
    int j = paramInt1 - 1;
    int k = 0;
    int i = 1;
    while (j >= 0) {
      k += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(j)) * i;
      int m = i + 1;
      i = m;
      if (m > paramInt2)
        i = 1; 
      j--;
    } 
    if (paramCharSequence.charAt(paramInt1) == b[k % 47])
      return; 
    throw ChecksumException.a();
  }
  
  private int[] a(BitArray paramBitArray) throws NotFoundException {
    int m = paramBitArray.a();
    int k = paramBitArray.c(0);
    Arrays.fill(this.e, 0);
    int[] arrayOfInt = this.e;
    int n = arrayOfInt.length;
    int i = k;
    boolean bool = false;
    int j = 0;
    while (k < m) {
      int i1;
      if (paramBitArray.a(k) != bool) {
        arrayOfInt[j] = arrayOfInt[j] + 1;
        i1 = i;
      } else {
        if (j == n - 1) {
          if (a(arrayOfInt) == c)
            return new int[] { i, k }; 
          int i3 = i + arrayOfInt[0] + arrayOfInt[1];
          i = j - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i);
          arrayOfInt[i] = 0;
          arrayOfInt[j] = 0;
          i = j - 1;
          j = i3;
        } else {
          int i3 = j + 1;
          j = i;
          i = i3;
        } 
        arrayOfInt[i] = 1;
        int i2 = bool ^ true;
        i1 = j;
        j = i;
      } 
      k++;
      i = i1;
    } 
    throw NotFoundException.a();
  }
  
  private static void b(CharSequence paramCharSequence) throws ChecksumException {
    int i = paramCharSequence.length();
    a(paramCharSequence, i - 2, 20);
    a(paramCharSequence, i - 1, 15);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    int[] arrayOfInt1 = a(paramBitArray);
    int i = paramBitArray.c(arrayOfInt1[1]);
    int j = paramBitArray.a();
    int[] arrayOfInt2 = this.e;
    Arrays.fill(arrayOfInt2, 0);
    StringBuilder stringBuilder = this.d;
    stringBuilder.setLength(0);
    while (true) {
      a(paramBitArray, i, arrayOfInt2);
      int k = a(arrayOfInt2);
      if (k >= 0) {
        char c = a(k);
        stringBuilder.append(c);
        int n = arrayOfInt2.length;
        int m = i;
        for (k = 0; k < n; k++)
          m += arrayOfInt2[k]; 
        n = paramBitArray.c(m);
        if (c == '*') {
          stringBuilder.deleteCharAt(stringBuilder.length() - 1);
          int i1 = arrayOfInt2.length;
          k = 0;
          m = 0;
          while (k < i1) {
            m += arrayOfInt2[k];
            k++;
          } 
          if (n != j && paramBitArray.a(n)) {
            if (stringBuilder.length() >= 2) {
              b(stringBuilder);
              stringBuilder.setLength(stringBuilder.length() - 2);
              String str = a(stringBuilder);
              float f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
              float f2 = i;
              float f3 = m / 2.0F;
              float f4 = paramInt;
              ResultPoint resultPoint1 = new ResultPoint(f1, f4);
              ResultPoint resultPoint2 = new ResultPoint(f2 + f3, f4);
              BarcodeFormat barcodeFormat = BarcodeFormat.d;
              return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
            } 
            throw NotFoundException.a();
          } 
          throw NotFoundException.a();
        } 
        i = n;
        continue;
      } 
      throw NotFoundException.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\Code93Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */