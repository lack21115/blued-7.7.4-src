package com.cmic.sso.sdk.utils;

import android.text.TextUtils;
import java.security.MessageDigest;

public class h {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      byte[] arrayOfByte = paramString.getBytes("utf-8");
      return a(arrayOfByte);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.reset();
      messageDigest.update(paramArrayOfbyte);
      return b(messageDigest.digest());
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length * 2];
    int k = paramArrayOfbyte.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      byte b = paramArrayOfbyte[i];
      int m = j + 1;
      char[] arrayOfChar1 = a;
      arrayOfChar[j] = arrayOfChar1[b >>> 4 & 0xF];
      j = m + 1;
      arrayOfChar[m] = arrayOfChar1[b & 0xF];
      i++;
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */