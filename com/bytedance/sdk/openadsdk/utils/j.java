package com.bytedance.sdk.openadsdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class j {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(File paramFile) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      if (messageDigest == null)
        return null; 
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      try {
        byte[] arrayOfByte = new byte[8192];
        while (true) {
          int i = fileInputStream.read(arrayOfByte, 0, arrayOfByte.length);
          if (i > 0) {
            messageDigest.update(arrayOfByte, 0, i);
            continue;
          } 
          String str = a(messageDigest.digest());
          try {
            return str;
          } catch (Exception null) {
            return str;
          } 
        } 
      } catch (Exception exception1) {
        return null;
      } finally {
        Exception exception2 = null;
        Exception exception1 = exception;
        exception = exception2;
      } 
      throw exception;
    } catch (Exception exception) {
    
    } finally {
      paramFile = null;
      FileInputStream fileInputStream = null;
    } 
    if (paramFile != null)
      try {
        paramFile.close();
        return null;
      } catch (Exception exception) {
        return null;
      }  
    return null;
  }
  
  public static String a(String paramString) {
    if (paramString != null)
      try {
        if (paramString.length() == 0)
          return null; 
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(paramString.getBytes("UTF-8"));
        return a(messageDigest.digest());
      } catch (Exception exception) {
        return null;
      }  
    return null;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return a(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new NullPointerException("bytes is null");
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      if (paramInt1 >= 0 && paramInt1 + paramInt2 <= paramArrayOfbyte.length) {
        int m = paramInt2 * 2;
        char[] arrayOfChar = new char[m];
        int i = 0;
        int k = 0;
        while (i < paramInt2) {
          int n = paramArrayOfbyte[i + paramInt1] & 0xFF;
          int i1 = k + 1;
          char[] arrayOfChar1 = a;
          arrayOfChar[k] = arrayOfChar1[n >> 4];
          k = i1 + 1;
          arrayOfChar[i1] = arrayOfChar1[n & 0xF];
          i++;
        } 
        return new String(arrayOfChar, 0, m);
      } 
      throw new IndexOutOfBoundsException();
    } 
    throw new NullPointerException("bytes is null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */