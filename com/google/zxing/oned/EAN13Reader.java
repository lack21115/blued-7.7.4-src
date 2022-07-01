package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN13Reader extends UPCEANReader {
  static final int[] a = new int[] { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  
  private final int[] g = new int[4];
  
  private static void a(StringBuilder paramStringBuilder, int paramInt) throws NotFoundException {
    for (int i = 0; i < 10; i++) {
      if (paramInt == a[i]) {
        paramStringBuilder.insert(0, (char)(i + 48));
        return;
      } 
    } 
    throw NotFoundException.a();
  }
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.g;
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
    i = a(paramBitArray, i, true, c)[1];
    for (j = 0; j < 6 && i < m; j++) {
      paramStringBuilder.append((char)(a(paramBitArray, arrayOfInt, i, e) + 48));
      int n = arrayOfInt.length;
      for (k = 0; k < n; k++)
        i += arrayOfInt[k]; 
    } 
    return i;
  }
  
  BarcodeFormat b() {
    return BarcodeFormat.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\EAN13Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */