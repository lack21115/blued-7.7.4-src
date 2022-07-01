package com.geetest.onelogin.e.a;

import java.io.UnsupportedEncodingException;

public class i {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (int j = 0; j < paramArrayOfbyte.length; j++) {
      stringBuilder.append(a[paramArrayOfbyte[j] >> 4 & 0xF]);
      stringBuilder.append(a[paramArrayOfbyte[j] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length / 2;
    byte[] arrayOfByte = new byte[k];
    for (int j = 0; j < k; j++) {
      int m = j * 2;
      int n = Character.digit(arrayOfChar[m], 16);
      n = Character.digit(arrayOfChar[m + 1], 16) | n << 4;
      m = n;
      if (n > 127)
        m = n - 256; 
      arrayOfByte[j] = (byte)m;
    } 
    return arrayOfByte;
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    String str = "";
    for (int j = 0; j < paramArrayOfbyte.length; j++) {
      String str2 = Integer.toHexString(paramArrayOfbyte[j] & 0xFF);
      String str1 = str;
      if (str2.length() == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("0");
        str1 = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public static byte[] b(String paramString) {
    try {
      return paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return new byte[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */