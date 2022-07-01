package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class UPCEReader extends UPCEANReader {
  static final int[][] a;
  
  private static final int[] g = new int[] { 1, 1, 1, 1, 1, 1 };
  
  private final int[] h = new int[4];
  
  static {
    a = new int[][] { { 56, 52, 50, 49, 44, 38, 35, 42, 41, 37 }, { 7, 11, 13, 14, 19, 25, 28, 21, 22, 26 } };
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt) throws NotFoundException {
    for (int i = 0; i <= 1; i++) {
      for (int j = 0; j < 10; j++) {
        if (paramInt == a[i][j]) {
          paramStringBuilder.insert(0, (char)(i + 48));
          paramStringBuilder.append((char)(j + 48));
          return;
        } 
      } 
    } 
    throw NotFoundException.a();
  }
  
  public static String b(String paramString) {
    char[] arrayOfChar = new char[6];
    paramString.getChars(1, 7, arrayOfChar, 0);
    StringBuilder stringBuilder = new StringBuilder(12);
    stringBuilder.append(paramString.charAt(0));
    char c = arrayOfChar[5];
    switch (c) {
      default:
        stringBuilder.append(arrayOfChar, 0, 5);
        stringBuilder.append("0000");
        stringBuilder.append(c);
        break;
      case '4':
        stringBuilder.append(arrayOfChar, 0, 4);
        stringBuilder.append("00000");
        stringBuilder.append(arrayOfChar[4]);
        break;
      case '3':
        stringBuilder.append(arrayOfChar, 0, 3);
        stringBuilder.append("00000");
        stringBuilder.append(arrayOfChar, 3, 2);
        break;
      case '0':
      case '1':
      case '2':
        stringBuilder.append(arrayOfChar, 0, 2);
        stringBuilder.append(c);
        stringBuilder.append("0000");
        stringBuilder.append(arrayOfChar, 2, 3);
        break;
    } 
    if (paramString.length() >= 8)
      stringBuilder.append(paramString.charAt(7)); 
    return stringBuilder.toString();
  }
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int m = paramBitArray.a();
    int i = paramArrayOfint[1];
    int j = 0;
    int k;
    for (k = 0; j < 6 && i < m; k = n) {
      int i1 = a(paramBitArray, arrayOfInt, i, f);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      int n;
      for (n = 0; n < i2; n++)
        i += arrayOfInt[n]; 
      n = k;
      if (i1 >= 10)
        n = 1 << 5 - j | k; 
      j++;
    } 
    a(paramStringBuilder, k);
    return i;
  }
  
  protected boolean a(String paramString) throws FormatException {
    return super.a(b(paramString));
  }
  
  protected int[] a(BitArray paramBitArray, int paramInt) throws NotFoundException {
    return a(paramBitArray, paramInt, true, g);
  }
  
  BarcodeFormat b() {
    return BarcodeFormat.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\UPCEReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */