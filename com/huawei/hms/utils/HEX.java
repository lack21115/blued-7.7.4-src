package com.huawei.hms.utils;

public final class HEX {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final char[] b = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  private static char[] a(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
    int k = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k) {
      int m = j + 1;
      arrayOfChar[j] = paramArrayOfchar[(paramArrayOfbyte[i] & 0xF0) >>> 4];
      j = m + 1;
      arrayOfChar[m] = paramArrayOfchar[paramArrayOfbyte[i] & 0xF];
      i++;
    } 
    return arrayOfChar;
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte) {
    return encodeHex(paramArrayOfbyte, false);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte, boolean paramBoolean) {
    char[] arrayOfChar;
    if (paramBoolean) {
      arrayOfChar = b;
    } else {
      arrayOfChar = a;
    } 
    return a(paramArrayOfbyte, arrayOfChar);
  }
  
  public static String encodeHexString(byte[] paramArrayOfbyte, boolean paramBoolean) {
    return new String(encodeHex(paramArrayOfbyte, paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\HEX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */