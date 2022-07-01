package com.bytedance.sdk.a.a;

import java.io.UnsupportedEncodingException;

final class b {
  private static final byte[] a = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] b = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  public static String a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, a);
  }
  
  private static String a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    byte[] arrayOfByte = new byte[(paramArrayOfbyte1.length + 2) / 3 * 4];
    int k = paramArrayOfbyte1.length - paramArrayOfbyte1.length % 3;
    int i = 0;
    int j = 0;
    while (i < k) {
      int m = j + 1;
      arrayOfByte[j] = paramArrayOfbyte2[(paramArrayOfbyte1[i] & 0xFF) >> 2];
      j = m + 1;
      byte b1 = paramArrayOfbyte1[i];
      int n = i + 1;
      arrayOfByte[m] = paramArrayOfbyte2[(b1 & 0x3) << 4 | (paramArrayOfbyte1[n] & 0xFF) >> 4];
      m = j + 1;
      b1 = paramArrayOfbyte1[n];
      n = i + 2;
      arrayOfByte[j] = paramArrayOfbyte2[(b1 & 0xF) << 2 | (paramArrayOfbyte1[n] & 0xFF) >> 6];
      j = m + 1;
      arrayOfByte[m] = paramArrayOfbyte2[paramArrayOfbyte1[n] & 0x3F];
      i += 3;
    } 
    i = paramArrayOfbyte1.length % 3;
    if (i != 1) {
      if (i == 2) {
        i = j + 1;
        arrayOfByte[j] = paramArrayOfbyte2[(paramArrayOfbyte1[k] & 0xFF) >> 2];
        j = i + 1;
        byte b1 = paramArrayOfbyte1[k];
        arrayOfByte[i] = paramArrayOfbyte2[(paramArrayOfbyte1[++k] & 0xFF) >> 4 | (b1 & 0x3) << 4];
        arrayOfByte[j] = paramArrayOfbyte2[(paramArrayOfbyte1[k] & 0xF) << 2];
        arrayOfByte[j + 1] = 61;
      } 
    } else {
      i = j + 1;
      arrayOfByte[j] = paramArrayOfbyte2[(paramArrayOfbyte1[k] & 0xFF) >> 2];
      j = i + 1;
      arrayOfByte[i] = paramArrayOfbyte2[(paramArrayOfbyte1[k] & 0x3) << 4];
      arrayOfByte[j] = 61;
      arrayOfByte[j + 1] = 61;
    } 
    try {
      return new String(arrayOfByte, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */