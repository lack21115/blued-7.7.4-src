package com.qiniu.android.dns.util;

import java.io.IOException;

public final class Hex {
  private static final char[] DIGITS_LOWER = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final char[] DIGITS_UPPER = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static byte[] decodeHex(char[] paramArrayOfchar) throws HexDecodeException {
    int i = paramArrayOfchar.length;
    if ((i & 0x1) == 0) {
      byte[] arrayOfByte = new byte[i >> 1];
      int k = 0;
      for (int j = 0; k < i; j++) {
        int m = toDigit(paramArrayOfchar[k], k);
        int n = toDigit(paramArrayOfchar[++k], k);
        k++;
        arrayOfByte[j] = (byte)((m << 4 | n) & 0xFF);
      } 
      return arrayOfByte;
    } 
    throw new HexDecodeException("Odd number of characters.");
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte) {
    return encodeHex(paramArrayOfbyte, true);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte, boolean paramBoolean) {
    char[] arrayOfChar;
    if (paramBoolean) {
      arrayOfChar = DIGITS_LOWER;
    } else {
      arrayOfChar = DIGITS_UPPER;
    } 
    return encodeHex(paramArrayOfbyte, arrayOfChar);
  }
  
  private static char[] encodeHex(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
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
  
  public static String encodeHexString(byte[] paramArrayOfbyte) {
    return new String(encodeHex(paramArrayOfbyte));
  }
  
  protected static int toDigit(char paramChar, int paramInt) throws HexDecodeException {
    int i = Character.digit(paramChar, 16);
    if (i != -1)
      return i; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal hexadecimal character ");
    stringBuilder.append(paramChar);
    stringBuilder.append(" at index ");
    stringBuilder.append(paramInt);
    throw new HexDecodeException(stringBuilder.toString());
  }
  
  public static class HexDecodeException extends IOException {
    public HexDecodeException(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dn\\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */