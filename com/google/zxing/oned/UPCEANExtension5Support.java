package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension5Support {
  private static final int[] a = new int[] { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  
  private final int[] b = new int[4];
  
  private final StringBuilder c = new StringBuilder();
  
  private static int a(int paramInt) throws NotFoundException {
    for (int i = 0; i < 10; i++) {
      if (paramInt == a[i])
        return i; 
    } 
    throw NotFoundException.a();
  }
  
  private int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.b;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int m = paramBitArray.a();
    int i = paramArrayOfint[1];
    int j = 0;
    int k;
    for (k = 0; j < 5 && i < m; k = n) {
      int i1 = UPCEANReader.a(paramBitArray, arrayOfInt, i, UPCEANReader.f);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      int n;
      for (n = 0; n < i2; n++)
        i += arrayOfInt[n]; 
      n = k;
      if (i1 >= 10)
        n = k | 1 << 4 - j; 
      if (j != 4)
        i = paramBitArray.d(paramBitArray.c(i)); 
      j++;
    } 
    if (paramStringBuilder.length() == 5) {
      j = a(k);
      if (a(paramStringBuilder.toString()) == j)
        return i; 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  private static int a(CharSequence paramCharSequence) {
    int k = paramCharSequence.length();
    int i = k - 2;
    int j = 0;
    while (i >= 0) {
      j += paramCharSequence.charAt(i) - 48;
      i -= 2;
    } 
    j *= 3;
    for (i = k - 1; i >= 0; i -= 2)
      j += paramCharSequence.charAt(i) - 48; 
    return j * 3 % 10;
  }
  
  private static Map<ResultMetadataType, Object> a(String paramString) {
    if (paramString.length() != 5)
      return null; 
    paramString = b(paramString);
    if (paramString == null)
      return null; 
    EnumMap<ResultMetadataType, Object> enumMap = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
    enumMap.put(ResultMetadataType.f, paramString);
    return enumMap;
  }
  
  private static String b(String paramString) {
    int i = 0;
    char c = paramString.charAt(0);
    String str = "";
    if (c != '0') {
      if (c != '5') {
        if (c == '9') {
          switch (paramString.hashCode()) {
            default:
              i = -1;
              break;
            case 54395377:
              if (paramString.equals("99991")) {
                i = 1;
                break;
              } 
            case 54395376:
              if (paramString.equals("99990")) {
                i = 2;
                break;
              } 
            case 54118329:
              if (paramString.equals("90000"))
                break; 
          } 
          if (i != 0) {
            if (i != 1) {
              if (i == 2)
                return "Used"; 
            } else {
              return "0.00";
            } 
          } else {
            return null;
          } 
        } 
      } else {
        str = "$";
      } 
    } else {
      str = "£";
    } 
    int j = Integer.parseInt(paramString.substring(1));
    i = j / 100;
    j %= 100;
    if (j < 10) {
      paramString = "0".concat(String.valueOf(j));
    } else {
      paramString = String.valueOf(j);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(String.valueOf(i));
    stringBuilder.append('.');
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfint) throws NotFoundException {
    StringBuilder stringBuilder = this.c;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\UPCEANExtension5Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */