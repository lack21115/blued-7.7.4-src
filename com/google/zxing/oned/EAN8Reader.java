package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN8Reader extends UPCEANReader {
  private final int[] a = new int[4];
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int k = paramBitArray.a();
    int i = paramArrayOfint[1];
    int j;
    for (j = 0; j < 4 && i < k; j++) {
      paramStringBuilder.append((char)(a(paramBitArray, arrayOfInt, i, e) + 48));
      int n = arrayOfInt.length;
      int m;
      for (m = 0; m < n; m++)
        i += arrayOfInt[m]; 
    } 
    i = a(paramBitArray, i, true, c)[1];
    for (j = 0; j < 4 && i < k; j++) {
      paramStringBuilder.append((char)(a(paramBitArray, arrayOfInt, i, e) + 48));
      int n = arrayOfInt.length;
      int m;
      for (m = 0; m < n; m++)
        i += arrayOfInt[m]; 
    } 
    return i;
  }
  
  BarcodeFormat b() {
    return BarcodeFormat.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\EAN8Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */