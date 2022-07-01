package com.google.zxing.datamatrix.decoder;

final class DataBlock {
  private final int a;
  
  private final byte[] b;
  
  private DataBlock(int paramInt, byte[] paramArrayOfbyte) {
    this.a = paramInt;
    this.b = paramArrayOfbyte;
  }
  
  static DataBlock[] a(byte[] paramArrayOfbyte, Version paramVersion) {
    Version.ECBlocks eCBlocks = paramVersion.g();
    Version.ECB[] arrayOfECB = eCBlocks.b();
    int k = arrayOfECB.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      j += arrayOfECB[i].a();
      i++;
    } 
    DataBlock[] arrayOfDataBlock = new DataBlock[j];
    int m = arrayOfECB.length;
    j = 0;
    i = 0;
    while (j < m) {
      Version.ECB eCB = arrayOfECB[j];
      k = 0;
      while (k < eCB.a()) {
        int i4 = eCB.b();
        arrayOfDataBlock[i] = new DataBlock(i4, new byte[eCBlocks.a() + i4]);
        k++;
        i++;
      } 
      j++;
    } 
    int i1 = (arrayOfDataBlock[0]).b.length - eCBlocks.a();
    int i2 = i1 - 1;
    k = 0;
    j = 0;
    while (k < i2) {
      m = 0;
      while (m < i) {
        (arrayOfDataBlock[m]).b[k] = paramArrayOfbyte[j];
        m++;
        j++;
      } 
      k++;
    } 
    if (paramVersion.a() == 24) {
      m = 1;
    } else {
      m = 0;
    } 
    if (m != 0) {
      k = 8;
    } else {
      k = i;
    } 
    int n = 0;
    while (n < k) {
      (arrayOfDataBlock[n]).b[i2] = paramArrayOfbyte[j];
      n++;
      j++;
    } 
    int i3 = (arrayOfDataBlock[0]).b.length;
    n = j;
    for (j = i1; j < i3; j++) {
      k = 0;
      while (k < i) {
        if (m != 0) {
          i1 = (k + 8) % i;
        } else {
          i1 = k;
        } 
        if (m != 0 && i1 > 7) {
          i2 = j - 1;
        } else {
          i2 = j;
        } 
        (arrayOfDataBlock[i1]).b[i2] = paramArrayOfbyte[n];
        k++;
        n++;
      } 
    } 
    if (n == paramArrayOfbyte.length)
      return arrayOfDataBlock; 
    throw new IllegalArgumentException();
  }
  
  int a() {
    return this.a;
  }
  
  byte[] b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\decoder\DataBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */