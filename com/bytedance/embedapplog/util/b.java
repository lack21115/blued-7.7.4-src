package com.bytedance.embedapplog.util;

import java.security.MessageDigest;

public class b {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return a(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new NullPointerException("bytes is null");
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      if (paramInt1 >= 0 && paramInt1 + paramInt2 <= paramArrayOfbyte.length) {
        int k = paramInt2 * 2;
        char[] arrayOfChar = new char[k];
        int i = 0;
        int j = 0;
        while (i < paramInt2) {
          int m = paramArrayOfbyte[i + paramInt1] & 0xFF;
          int n = j + 1;
          char[] arrayOfChar1 = a;
          arrayOfChar[j] = arrayOfChar1[m >> 4];
          j = n + 1;
          arrayOfChar[n] = arrayOfChar1[m & 0xF];
          i++;
        } 
        return new String(arrayOfChar, 0, k);
      } 
      throw new IndexOutOfBoundsException();
    } 
    throw new NullPointerException("bytes is null");
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      try {
        if (paramArrayOfbyte.length == 0)
          return null; 
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(paramArrayOfbyte);
        return a(messageDigest.digest());
      } catch (Exception exception) {
        return null;
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */