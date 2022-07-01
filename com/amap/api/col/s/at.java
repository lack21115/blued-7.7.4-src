package com.amap.api.col.s;

public final class at {
  private static int a = 4;
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte1.length == 0)
      return paramArrayOfbyte1; 
    int j = paramArrayOfbyte1.length;
    int k = a;
    byte[] arrayOfByte = new byte[(j / k + 1) * k];
    int i = paramArrayOfbyte1.length;
    boolean bool = false;
    System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, i);
    for (i = j; i < arrayOfByte.length; i++)
      arrayOfByte[i] = (byte)(k - j % k); 
    int[] arrayOfInt2 = a(arrayOfByte);
    int[] arrayOfInt1 = a(paramArrayOfbyte2);
    int m = arrayOfInt2.length - 1;
    if (m > 0) {
      int[] arrayOfInt = arrayOfInt1;
      if (arrayOfInt1.length < 4) {
        arrayOfInt = new int[4];
        System.arraycopy(arrayOfInt1, 0, arrayOfInt, 0, arrayOfInt1.length);
      } 
      i = arrayOfInt2[m];
      j = 52 / (m + 1) + 6;
      for (k = 0; j > 0; k = n) {
        int n = k - 1640531527;
        int i2 = n >>> 2 & 0x3;
        int i1 = 0;
        k = i;
        for (i = i1; i < m; i = i1) {
          i1 = i + 1;
          int i3 = arrayOfInt2[i1];
          int i4 = arrayOfInt2[i];
          k = ((k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4) ^ (i3 ^ n) + (k ^ arrayOfInt[i & 0x3 ^ i2])) + i4;
          arrayOfInt2[i] = k;
        } 
        i1 = arrayOfInt2[0];
        i = arrayOfInt2[m] + ((k >>> 5 ^ i1 << 2) + (i1 >>> 3 ^ k << 4) ^ (i1 ^ n) + (arrayOfInt[i2 ^ i & 0x3] ^ k));
        arrayOfInt2[m] = i;
        j--;
      } 
    } 
    j = arrayOfInt2.length << 2;
    paramArrayOfbyte1 = new byte[j];
    for (i = bool; i < j; i++)
      paramArrayOfbyte1[i] = (byte)(arrayOfInt2[i >>> 2] >>> (i & 0x3) << 3 & 0xFF); 
    return paramArrayOfbyte1;
  }
  
  private static int[] a(byte[] paramArrayOfbyte) {
    int[] arrayOfInt = new int[paramArrayOfbyte.length >>> 2];
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      int k = i >>> 2;
      arrayOfInt[k] = arrayOfInt[k] | (paramArrayOfbyte[i] & 0xFF) << (i & 0x3) << 3;
    } 
    return arrayOfInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */