package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader implements Reader {
  public static float a(int[] paramArrayOfint1, int[] paramArrayOfint2, float paramFloat) {
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
  
  protected static void a(BitArray paramBitArray, int paramInt, int[] paramArrayOfint) throws NotFoundException {
    int j = paramArrayOfint.length;
    int i = 0;
    Arrays.fill(paramArrayOfint, 0, j, 0);
    int k = paramBitArray.a();
    if (paramInt < k) {
      int n = paramBitArray.a(paramInt) ^ true;
      int m = paramInt;
      paramInt = i;
      while (true) {
        i = paramInt;
        if (m < k) {
          if (paramBitArray.a(m) != n) {
            paramArrayOfint[paramInt] = paramArrayOfint[paramInt] + 1;
          } else {
            i = ++paramInt;
            if (paramInt != j) {
              paramArrayOfint[paramInt] = 1;
              n ^= 0x1;
            } else {
              break;
            } 
          } 
          m++;
          continue;
        } 
        break;
      } 
      if (i != j) {
        if (i == j - 1 && m == k)
          return; 
        throw NotFoundException.a();
      } 
      return;
    } 
    throw NotFoundException.a();
  }
  
  private Result b(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    int j;
    int k = paramBinaryBitmap.a();
    int m = paramBinaryBitmap.b();
    BitArray bitArray = new BitArray(k);
    if (paramMap != null && paramMap.containsKey(DecodeHintType.d)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      j = 8;
    } else {
      j = 5;
    } 
    int i1 = Math.max(1, m >> j);
    if (i) {
      j = m;
    } else {
      j = 15;
    } 
    int i2 = m / 2;
    int n = 0;
    int i = k;
    k = n;
    label69: while (true) {
      if (k < j) {
        n = k + 1;
        int i3 = n / 2;
        if ((k & 0x1) == 0) {
          k = 1;
        } else {
          k = 0;
        } 
        if (k != 0) {
          k = i3;
        } else {
          k = -i3;
        } 
        i3 = k * i1 + i2;
        if (i3 >= 0 && i3 < m) {
          try {
            BitArray bitArray1 = paramBinaryBitmap.a(i3, bitArray);
            k = 0;
            while (true) {
              if (k < 2) {
                Map<DecodeHintType, ?> map = paramMap;
                if (k == 1) {
                  bitArray1.d();
                  map = paramMap;
                  if (paramMap != null) {
                    map = paramMap;
                    if (paramMap.containsKey(DecodeHintType.j)) {
                      map = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
                      map.putAll(paramMap);
                      map.remove(DecodeHintType.j);
                    } 
                  } 
                } 
                try {
                  Result result = a(i3, bitArray1, map);
                  if (k == 1) {
                    result.a(ResultMetadataType.b, Integer.valueOf(180));
                    ResultPoint[] arrayOfResultPoint = result.c();
                    if (arrayOfResultPoint != null) {
                      float f1 = i;
                      float f2 = arrayOfResultPoint[0].a();
                      try {
                        arrayOfResultPoint[0] = new ResultPoint(f1 - f2 - 1.0F, arrayOfResultPoint[0].b());
                        try {
                          arrayOfResultPoint[1] = new ResultPoint(f1 - arrayOfResultPoint[1].a() - 1.0F, arrayOfResultPoint[1].b());
                          return result;
                        } catch (ReaderException null) {}
                      } catch (ReaderException readerException) {}
                    } else {
                      return (Result)readerException;
                    } 
                  } else {
                    return (Result)readerException;
                  } 
                } catch (ReaderException readerException) {}
                k++;
                paramMap = map;
                continue;
              } 
              bitArray = bitArray1;
              k = n;
              continue label69;
            } 
          } catch (NotFoundException notFoundException) {
            continue;
          } 
          break;
        } 
      } 
      throw NotFoundException.a();
    } 
  }
  
  protected static void b(BitArray paramBitArray, int paramInt, int[] paramArrayOfint) throws NotFoundException {
    int i = paramArrayOfint.length;
    boolean bool = paramBitArray.a(paramInt);
    while (paramInt > 0 && i >= 0) {
      int j = paramInt - 1;
      paramInt = j;
      if (paramBitArray.a(j) != bool) {
        i--;
        int k = bool ^ true;
        paramInt = j;
      } 
    } 
    if (i < 0) {
      a(paramBitArray, paramInt + 1, paramArrayOfint);
      return;
    } 
    throw NotFoundException.a();
  }
  
  public abstract Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException;
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    try {
      return b(paramBinaryBitmap, paramMap);
    } catch (NotFoundException notFoundException) {
      int i;
      ResultPoint[] arrayOfResultPoint;
      boolean bool = false;
      if (paramMap != null && paramMap.containsKey(DecodeHintType.d)) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i && paramBinaryBitmap.d()) {
        paramBinaryBitmap = paramBinaryBitmap.e();
        Result result = b(paramBinaryBitmap, paramMap);
        Map map = result.e();
        int j = 270;
        i = j;
        if (map != null) {
          i = j;
          if (map.containsKey(ResultMetadataType.b))
            i = (((Integer)map.get(ResultMetadataType.b)).intValue() + 270) % 360; 
        } 
        result.a(ResultMetadataType.b, Integer.valueOf(i));
        arrayOfResultPoint = result.c();
        if (arrayOfResultPoint != null) {
          j = paramBinaryBitmap.b();
          for (i = bool; i < arrayOfResultPoint.length; i++)
            arrayOfResultPoint[i] = new ResultPoint(j - arrayOfResultPoint[i].b() - 1.0F, arrayOfResultPoint[i].a()); 
        } 
        return result;
      } 
      throw arrayOfResultPoint;
    } 
  }
  
  public void a() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\OneDReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */