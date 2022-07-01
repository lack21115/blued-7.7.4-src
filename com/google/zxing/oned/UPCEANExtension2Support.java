package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension2Support {
  private final int[] a = new int[4];
  
  private final StringBuilder b = new StringBuilder();
  
  private int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int m = paramBitArray.a();
    int i = paramArrayOfint[1];
    int j = 0;
    int k;
    for (k = 0; j < 2 && i < m; k = n) {
      int i1 = UPCEANReader.a(paramBitArray, arrayOfInt, i, UPCEANReader.f);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      int n;
      for (n = 0; n < i2; n++)
        i += arrayOfInt[n]; 
      n = k;
      if (i1 >= 10)
        n = 1 << 1 - j | k; 
      if (j != 1)
        i = paramBitArray.d(paramBitArray.c(i)); 
      j++;
    } 
    if (paramStringBuilder.length() == 2) {
      if (Integer.parseInt(paramStringBuilder.toString()) % 4 == k)
        return i; 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  private static Map<ResultMetadataType, Object> a(String paramString) {
    if (paramString.length() != 2)
      return null; 
    EnumMap<ResultMetadataType, Object> enumMap = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
    enumMap.put(ResultMetadataType.e, Integer.valueOf(paramString));
    return enumMap;
  }
  
  Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfint) throws NotFoundException {
    StringBuilder stringBuilder = this.b;
    stringBuilder.setLength(0);
    int i = a(paramBitArray, paramArrayOfint, stringBuilder);
    String str = stringBuilder.toString();
    Map<ResultMetadataType, Object> map = a(str);
    float f1 = (paramArrayOfint[0] + paramArrayOfint[1]) / 2.0F;
    float f2 = paramInt;
    ResultPoint resultPoint1 = new ResultPoint(f1, f2);
    ResultPoint resultPoint2 = new ResultPoint(i, f2);
    BarcodeFormat barcodeFormat = BarcodeFormat.q;
    Result result = new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
    if (map != null)
      result.a(map); 
    return result;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\UPCEANExtension2Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */