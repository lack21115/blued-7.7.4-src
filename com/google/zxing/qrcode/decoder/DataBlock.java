package com.google.zxing.qrcode.decoder;

final class DataBlock {
  private final int a;
  
  private final byte[] b;
  
  private DataBlock(int paramInt, byte[] paramArrayOfbyte) {
    this.a = paramInt;
    this.b = paramArrayOfbyte;
  }
  
  static DataBlock[] a(byte[] paramArrayOfbyte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel) {
    if (paramArrayOfbyte.length == paramVersion.c()) {
      Version.ECBlocks eCBlocks = paramVersion.a(paramErrorCorrectionLevel);
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
      k = 0;
      for (j = 0; k < m; j = i) {
        Version.ECB eCB = arrayOfECB[k];
        i = j;
        j = 0;
        while (j < eCB.a()) {
          int i3 = eCB.b();
          arrayOfDataBlock[i] = new DataBlock(i3, new byte[eCBlocks.a() + i3]);
          j++;
          i++;
        } 
        k++;
      } 
      k = (arrayOfDataBlock[0]).b.length;
      for (i = arrayOfDataBlock.length - 1; i >= 0 && (arrayOfDataBlock[i]).b.length != k; i--);
      int i1 = i + 1;
      int n = k - eCBlocks.a();
      k = 0;
      i = 0;
      while (k < n) {
        m = 0;
        while (m < j) {
          (arrayOfDataBlock[m]).b[k] = paramArrayOfbyte[i];
          m++;
          i++;
        } 
        k++;
      } 
      m = i1;
      for (k = i; m < j; k++) {
        (arrayOfDataBlock[m]).b[n] = paramArrayOfbyte[k];
        m++;
      } 
      int i2 = (arrayOfDataBlock[0]).b.length;
      for (i = n; i < i2; i++) {
        m = 0;
        while (m < j) {
          if (m < i1) {
            n = i;
          } else {
            n = i + 1;
          } 
          (arrayOfDataBlock[m]).b[n] = paramArrayOfbyte[k];
          m++;
          k++;
        } 
      } 
      return arrayOfDataBlock;
    } 
    throw new IllegalArgumentException();
  }
  
  int a() {
    return this.a;
  }
  
  byte[] b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\DataBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */