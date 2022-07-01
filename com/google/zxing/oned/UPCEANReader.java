package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader {
  static final int[] b = new int[] { 1, 1, 1 };
  
  static final int[] c = new int[] { 1, 1, 1, 1, 1 };
  
  static final int[] d = new int[] { 1, 1, 1, 1, 1, 1 };
  
  static final int[][] e;
  
  static final int[][] f = new int[20][];
  
  private final StringBuilder a = new StringBuilder(20);
  
  private final UPCEANExtensionSupport g = new UPCEANExtensionSupport();
  
  private final EANManufacturerOrgSupport h = new EANManufacturerOrgSupport();
  
  static {
    System.arraycopy(e, 0, f, 0, 10);
    while (i < 20) {
      arrayOfInt1 = e[i - 10];
      arrayOfInt2 = new int[arrayOfInt1.length];
      for (int j = 0; j < arrayOfInt1.length; j++)
        arrayOfInt2[j] = arrayOfInt1[arrayOfInt1.length - j - 1]; 
      f[i] = arrayOfInt2;
      i++;
    } 
  }
  
  static int a(BitArray paramBitArray, int[] paramArrayOfint, int paramInt, int[][] paramArrayOfint1) throws NotFoundException {
    a(paramBitArray, paramInt, paramArrayOfint);
    int j = paramArrayOfint1.length;
    float f = 0.48F;
    int i = -1;
    paramInt = 0;
    while (paramInt < j) {
      float f2 = a(paramArrayOfint, paramArrayOfint1[paramInt], 0.7F);
      float f1 = f;
      if (f2 < f) {
        i = paramInt;
        f1 = f2;
      } 
      paramInt++;
      f = f1;
    } 
    if (i >= 0)
      return i; 
    throw NotFoundException.a();
  }
  
  static boolean a(CharSequence paramCharSequence) throws FormatException {
    int i = paramCharSequence.length();
    if (i == 0)
      return false; 
    int j = Character.digit(paramCharSequence.charAt(--i), 10);
    return (b(paramCharSequence.subSequence(0, i)) == j);
  }
  
  static int[] a(BitArray paramBitArray) throws NotFoundException {
    int[] arrayOfInt2 = new int[b.length];
    int[] arrayOfInt1 = null;
    boolean bool = false;
    int i = 0;
    while (!bool) {
      Arrays.fill(arrayOfInt2, 0, b.length, 0);
      arrayOfInt1 = a(paramBitArray, i, false, b, arrayOfInt2);
      int j = arrayOfInt1[0];
      i = arrayOfInt1[1];
      int k = j - i - j;
      if (k >= 0)
        bool = paramBitArray.a(k, j, false); 
    } 
    return arrayOfInt1;
  }
  
  static int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfint) throws NotFoundException {
    return a(paramBitArray, paramInt, paramBoolean, paramArrayOfint, new int[paramArrayOfint.length]);
  }
  
  private static int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfint1, int[] paramArrayOfint2) throws NotFoundException {
    int m = paramBitArray.a();
    if (paramBoolean) {
      paramInt = paramBitArray.d(paramInt);
    } else {
      paramInt = paramBitArray.c(paramInt);
    } 
    int n = paramArrayOfint1.length;
    int i = paramInt;
    int k = 0;
    int j = paramInt;
    paramInt = i;
    i = k;
    while (j < m) {
      if (paramBitArray.a(j) != paramBoolean) {
        paramArrayOfint2[i] = paramArrayOfint2[i] + 1;
        k = paramInt;
      } else {
        if (i == n - 1) {
          if (a(paramArrayOfint2, paramArrayOfint1, 0.7F) < 0.48F)
            return new int[] { paramInt, j }; 
          k = paramInt + paramArrayOfint2[0] + paramArrayOfint2[1];
          paramInt = i - 1;
          System.arraycopy(paramArrayOfint2, 2, paramArrayOfint2, 0, paramInt);
          paramArrayOfint2[paramInt] = 0;
          paramArrayOfint2[i] = 0;
          paramInt = i - 1;
          i = k;
        } else {
          k = i + 1;
          i = paramInt;
          paramInt = k;
        } 
        paramArrayOfint2[paramInt] = 1;
        int i1 = paramBoolean ^ true;
        k = i;
        i = paramInt;
      } 
      j++;
      paramInt = k;
    } 
    throw NotFoundException.a();
  }
  
  static int b(CharSequence paramCharSequence) throws FormatException {
    int k = paramCharSequence.length();
    int i = k - 1;
    int j = 0;
    while (i >= 0) {
      int m = paramCharSequence.charAt(i) - 48;
      if (m >= 0 && m <= 9) {
        j += m;
        i -= 2;
        continue;
      } 
      throw FormatException.a();
    } 
    j *= 3;
    i = k - 2;
    while (i >= 0) {
      k = paramCharSequence.charAt(i) - 48;
      if (k >= 0 && k <= 9) {
        j += k;
        i -= 2;
        continue;
      } 
      throw FormatException.a();
    } 
    return (1000 - j) % 10;
  }
  
  protected abstract int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException;
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    return a(paramInt, paramBitArray, a(paramBitArray), paramMap);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfint, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    ResultPointCallback resultPointCallback;
    BitArray bitArray = null;
    if (paramMap == null) {
      resultPointCallback = null;
    } else {
      resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.j);
    } 
    boolean bool = true;
    if (resultPointCallback != null)
      resultPointCallback.a(new ResultPoint((paramArrayOfint[0] + paramArrayOfint[1]) / 2.0F, paramInt)); 
    StringBuilder stringBuilder = this.a;
    stringBuilder.setLength(0);
    int i = a(paramBitArray, paramArrayOfint, stringBuilder);
    if (resultPointCallback != null)
      resultPointCallback.a(new ResultPoint(i, paramInt)); 
    int[] arrayOfInt = a(paramBitArray, i);
    if (resultPointCallback != null)
      resultPointCallback.a(new ResultPoint((arrayOfInt[0] + arrayOfInt[1]) / 2.0F, paramInt)); 
    i = arrayOfInt[1];
    int j = i - arrayOfInt[0] + i;
    if (j < paramBitArray.a() && paramBitArray.a(i, j, false)) {
      String str = stringBuilder.toString();
      if (str.length() >= 8) {
        if (a(str)) {
          int[] arrayOfInt1;
          float f1 = (paramArrayOfint[1] + paramArrayOfint[0]) / 2.0F;
          float f2 = (arrayOfInt[1] + arrayOfInt[0]) / 2.0F;
          BarcodeFormat barcodeFormat = b();
          float f3 = paramInt;
          Result result = new Result(str, null, new ResultPoint[] { new ResultPoint(f1, f3), new ResultPoint(f2, f3) }barcodeFormat);
          try {
            Result result1 = this.g.a(paramInt, paramBitArray, arrayOfInt[1]);
            result.a(ResultMetadataType.h, result1.a());
            result.a(result1.e());
            result.a(result1.c());
            paramInt = result1.a().length();
          } catch (ReaderException readerException) {
            paramInt = 0;
          } 
          if (paramMap == null) {
            paramBitArray = bitArray;
          } else {
            arrayOfInt1 = (int[])paramMap.get(DecodeHintType.k);
          } 
          if (arrayOfInt1 != null) {
            j = arrayOfInt1.length;
            i = 0;
            while (true) {
              if (i < j) {
                if (paramInt == arrayOfInt1[i]) {
                  paramInt = bool;
                  break;
                } 
                i++;
                continue;
              } 
              paramInt = 0;
              break;
            } 
            if (paramInt == 0)
              throw NotFoundException.a(); 
          } 
          if (barcodeFormat == BarcodeFormat.h || barcodeFormat == BarcodeFormat.o) {
            String str1 = this.h.a(str);
            if (str1 != null)
              result.a(ResultMetadataType.g, str1); 
          } 
          return result;
        } 
        throw ChecksumException.a();
      } 
      throw FormatException.a();
    } 
    throw NotFoundException.a();
  }
  
  boolean a(String paramString) throws FormatException {
    return a(paramString);
  }
  
  int[] a(BitArray paramBitArray, int paramInt) throws NotFoundException {
    return a(paramBitArray, paramInt, false, b);
  }
  
  abstract BarcodeFormat b();
  
  static {
    int i = 10;
    int[] arrayOfInt1 = { 3, 2, 1, 1 };
    int[] arrayOfInt2 = { 2, 1, 2, 2 };
    int[] arrayOfInt3 = { 1, 1, 3, 2 };
    int[] arrayOfInt4 = { 1, 2, 3, 1 };
    int[] arrayOfInt5 = { 1, 1, 1, 4 };
    int[] arrayOfInt6 = { 1, 3, 1, 2 };
    e = new int[][] { arrayOfInt1, { 2, 2, 2, 1 }, arrayOfInt2, { 1, 4, 1, 1 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\UPCEANReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */