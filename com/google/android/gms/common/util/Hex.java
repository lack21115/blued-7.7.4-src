package com.google.android.gms.common.util;

public class Hex {
  private static final char[] zza = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  private static final char[] zzb = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String bytesToStringLowercase(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[paramArrayOfbyte.length << 1];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfbyte.length) {
      int k = paramArrayOfbyte[i] & 0xFF;
      int m = j + 1;
      char[] arrayOfChar1 = zzb;
      arrayOfChar[j] = arrayOfChar1[k >>> 4];
      j = m + 1;
      arrayOfChar[m] = arrayOfChar1[k & 0xF];
      i++;
    } 
    return new String(arrayOfChar);
  }
  
  public static String bytesToStringUppercase(byte[] paramArrayOfbyte) {
    return bytesToStringUppercase(paramArrayOfbyte, false);
  }
  
  public static String bytesToStringUppercase(byte[] paramArrayOfbyte, boolean paramBoolean) {
    int j = paramArrayOfbyte.length;
    StringBuilder stringBuilder = new StringBuilder(j << 1);
    for (int i = 0; i < j && (!paramBoolean || i != j - 1 || (paramArrayOfbyte[i] & 0xFF) != 0); i++) {
      stringBuilder.append(zza[(paramArrayOfbyte[i] & 0xF0) >>> 4]);
      stringBuilder.append(zza[paramArrayOfbyte[i] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] stringToBytes(String paramString) throws IllegalArgumentException {
    int i = paramString.length();
    if (i % 2 == 0) {
      byte[] arrayOfByte = new byte[i / 2];
      for (int j = 0; j < i; j = k) {
        int m = j / 2;
        int k = j + 2;
        arrayOfByte[m] = (byte)Integer.parseInt(paramString.substring(j, k), 16);
      } 
      return arrayOfByte;
    } 
    throw new IllegalArgumentException("Hex string has odd number of characters");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */