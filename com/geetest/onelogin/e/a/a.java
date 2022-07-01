package com.geetest.onelogin.e.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
  private static final byte[] a = "0000000000000000".getBytes();
  
  private static final char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  public static String a(String paramString1, String paramString2) {
    byte[] arrayOfByte = b(paramString1, paramString2);
    return (arrayOfByte != null) ? i.a(arrayOfByte) : null;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    int j = paramArrayOfbyte.length;
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 3 / 2);
    int i = 0;
    label19: while (true) {
      int k;
      for (k = 0; i <= j - 3; k++) {
        int m = (paramArrayOfbyte[i] & 0xFF) << 16 | (paramArrayOfbyte[i + 1] & 0xFF) << 8 | paramArrayOfbyte[i + 2] & 0xFF;
        stringBuffer.append(b[m >> 18 & 0x3F]);
        stringBuffer.append(b[m >> 12 & 0x3F]);
        stringBuffer.append(b[m >> 6 & 0x3F]);
        stringBuffer.append(b[m & 0x3F]);
        i += 3;
        if (k >= 14) {
          stringBuffer.append(" ");
          continue label19;
        } 
      } 
      k = 0 + j;
      if (i == k - 2) {
        k = paramArrayOfbyte[i];
        i = (paramArrayOfbyte[i + 1] & 0xFF) << 8 | (k & 0xFF) << 16;
        stringBuffer.append(b[i >> 18 & 0x3F]);
        stringBuffer.append(b[i >> 12 & 0x3F]);
        stringBuffer.append(b[i >> 6 & 0x3F]);
        stringBuffer.append("=");
      } else if (i == k - 1) {
        i = (paramArrayOfbyte[i] & 0xFF) << 16;
        stringBuffer.append(b[i >> 18 & 0x3F]);
        stringBuffer.append(b[i >> 12 & 0x3F]);
        stringBuffer.append("==");
      } 
      return stringBuffer.toString();
    } 
  }
  
  public static byte[] b(String paramString1, String paramString2) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      null = paramString1.getBytes("utf-8");
      cipher.init(1, secretKeySpec, ivParameterSpec);
      return cipher.doFinal(null);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String c(String paramString1, String paramString2) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(2, secretKeySpec, ivParameterSpec);
      return new String(cipher.doFinal(i.a(paramString1)));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String d(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
      return a(cipher.doFinal(paramString1.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */