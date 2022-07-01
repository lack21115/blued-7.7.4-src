package com.geetest.onelogin.e.a;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final byte[] b = new byte[] { 48, 48, 48, 48, 48, 48, 48, 48 };
  
  public static String a(String paramString) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    messageDigest.update(paramString.getBytes("GBK"));
    return new String(a(messageDigest.digest()));
  }
  
  public static String a(String paramString1, String paramString2) throws Exception {
    return a(paramString1, paramString2, "UTF-8");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) throws Exception {
    byte[] arrayOfByte;
    int i = paramString1.length() % 8;
    if (i != 0) {
      StringBuffer stringBuffer = new StringBuffer(paramString1);
      for (int j = 0; j < 8 - i; j++)
        stringBuffer.append(' '); 
      arrayOfByte = (new String(stringBuffer)).getBytes(paramString3);
    } else {
      arrayOfByte = arrayOfByte.getBytes(paramString3);
    } 
    return a.a(a(arrayOfByte, paramString2)).replaceAll("[\\n\\r]", "");
  }
  
  public static byte[] a(String paramString, int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws Exception {
    IvParameterSpec ivParameterSpec;
    SecretKey secretKey = b(paramString);
    if (paramArrayOfbyte1 == null) {
      ivParameterSpec = b(b);
    } else {
      ivParameterSpec = b(paramArrayOfbyte1);
    } 
    Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
    cipher.init(paramInt, secretKey, ivParameterSpec);
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) throws Exception {
    return a(paramString, 1, null, paramArrayOfbyte);
  }
  
  public static char[] a(byte[] paramArrayOfbyte) {
    int k = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k) {
      int m = j + 1;
      char[] arrayOfChar1 = a;
      arrayOfChar[j] = arrayOfChar1[(paramArrayOfbyte[i] & 0xF0) >>> 4];
      j = m + 1;
      arrayOfChar[m] = arrayOfChar1[paramArrayOfbyte[i] & 0xF];
      i++;
    } 
    return arrayOfChar;
  }
  
  public static String b(String paramString1, String paramString2) throws Exception {
    return b(paramString1, paramString2, "UTF-8");
  }
  
  public static String b(String paramString1, String paramString2, String paramString3) throws Exception {
    return (new String(b(a.a(paramString1), paramString2), paramString3)).trim();
  }
  
  private static SecretKey b(String paramString) throws Exception {
    return new SecretKeySpec(a(paramString).substring(0, 24).getBytes("GBK"), "DESede");
  }
  
  private static IvParameterSpec b(byte[] paramArrayOfbyte) {
    return new IvParameterSpec(paramArrayOfbyte);
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, String paramString) throws Exception {
    return a(paramString, 2, null, paramArrayOfbyte);
  }
  
  public static class a {
    private static char[] a = new char[] { 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '+', '/' };
    
    private static byte[] b = new byte[] { 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1 };
    
    public static String a(byte[] param1ArrayOfbyte) {
      StringBuffer stringBuffer = new StringBuffer();
      int j = param1ArrayOfbyte.length;
      for (int i = 0; i < j; i = k + 1) {
        int m = i + 1;
        i = param1ArrayOfbyte[i] & 0xFF;
        if (m == j) {
          stringBuffer.append(a[i >>> 2]);
          stringBuffer.append(a[(i & 0x3) << 4]);
          stringBuffer.append("==");
          break;
        } 
        int k = m + 1;
        m = param1ArrayOfbyte[m] & 0xFF;
        if (k == j) {
          stringBuffer.append(a[i >>> 2]);
          stringBuffer.append(a[(i & 0x3) << 4 | (m & 0xF0) >>> 4]);
          stringBuffer.append(a[(m & 0xF) << 2]);
          stringBuffer.append("=");
          break;
        } 
        int n = param1ArrayOfbyte[k] & 0xFF;
        stringBuffer.append(a[i >>> 2]);
        stringBuffer.append(a[(i & 0x3) << 4 | (m & 0xF0) >>> 4]);
        stringBuffer.append(a[(m & 0xF) << 2 | (n & 0xC0) >>> 6]);
        stringBuffer.append(a[n & 0x3F]);
      } 
      return stringBuffer.toString();
    }
    
    public static byte[] a(String param1String) {
      byte[] arrayOfByte = param1String.getBytes();
      int j = arrayOfByte.length;
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(j);
      int i = 0;
      while (i < j) {
        byte b1;
        byte b2;
        int k;
        for (k = i;; k = i) {
          byte[] arrayOfByte1 = b;
          i = k + 1;
          b2 = arrayOfByte1[arrayOfByte[k]];
          if (i >= j || b2 != -1)
            break; 
        } 
        k = i;
        if (b2 == -1)
          break; 
        while (true) {
          byte[] arrayOfByte1 = b;
          i = k + 1;
          b1 = arrayOfByte1[arrayOfByte[k]];
          if (i >= j || b1 != -1)
            break; 
          k = i;
        } 
        if (b1 == -1)
          break; 
        byteArrayOutputStream.write(b2 << 2 | (b1 & 0x30) >>> 4);
        for (k = i;; k = i) {
          i = k + 1;
          k = arrayOfByte[k];
          if (k == 61)
            return byteArrayOutputStream.toByteArray(); 
          b2 = b[k];
          if (i >= j || b2 != -1)
            break; 
        } 
        if (b2 == -1)
          break; 
        byteArrayOutputStream.write((b1 & 0xF) << 4 | (b2 & 0x3C) >>> 2);
        for (k = i;; k = i) {
          i = k + 1;
          k = arrayOfByte[k];
          if (k == 61)
            return byteArrayOutputStream.toByteArray(); 
          k = b[k];
          if (i >= j || k != -1)
            break; 
        } 
        if (k == -1)
          break; 
        byteArrayOutputStream.write(k | (b2 & 0x3) << 6);
      } 
      return byteArrayOutputStream.toByteArray();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */