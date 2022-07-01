package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bn {
  private static final char[] a = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static final byte[] b = new byte[128];
  
  static {
    int i;
    for (i = 0; i < 128; i++)
      b[i] = -1; 
    for (i = 65; i <= 90; i++)
      b[i] = (byte)(i - 65); 
    for (i = 97; i <= 122; i++)
      b[i] = (byte)(i - 97 + 26); 
    for (i = 48; i <= 57; i++)
      b[i] = (byte)(i - 48 + 52); 
    byte[] arrayOfByte = b;
    arrayOfByte[43] = 62;
    arrayOfByte[47] = 63;
  }
  
  public static String a(String paramString) {
    return bs.a(b(paramString));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance(bs.c("EQUVT"));
    if (keyGenerator == null)
      return null; 
    keyGenerator.init(256);
    byte[] arrayOfByte2 = keyGenerator.generateKey().getEncoded();
    PublicKey publicKey = bs.d();
    if (publicKey == null)
      return null; 
    byte[] arrayOfByte1 = a(arrayOfByte2, publicKey);
    paramArrayOfbyte = a(arrayOfByte2, paramArrayOfbyte);
    arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfbyte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfbyte.length);
    return arrayOfByte2;
  }
  
  static byte[] a(byte[] paramArrayOfbyte, Key paramKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance(bs.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
    cipher.init(1, paramKey);
    return cipher.doFinal(paramArrayOfbyte);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      return c(paramArrayOfbyte1, paramArrayOfbyte2, bs.c());
    } finally {
      paramArrayOfbyte1 = null;
      cd.a((Throwable)paramArrayOfbyte1, "er", "asEn");
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws Exception {
    IvParameterSpec ivParameterSpec = new IvParameterSpec(paramArrayOfbyte3);
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, bs.c("EQUVT"));
    Cipher cipher = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
    cipher.init(2, secretKeySpec, ivParameterSpec);
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    try {
      return d(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      cd.a((Throwable)paramArrayOfbyte, "er", "e64");
    } 
  }
  
  public static byte[] b(String paramString) {
    int i = 0;
    if (paramString == null)
      return new byte[0]; 
    byte[] arrayOfByte = bs.a(paramString);
    int j = arrayOfByte.length;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(j);
    while (i < j) {
      byte b;
      int k;
      for (k = i;; k = i) {
        byte[] arrayOfByte1 = b;
        i = k + 1;
        b = arrayOfByte1[arrayOfByte[k]];
        if (i >= j || b != -1)
          break; 
      } 
      if (b != -1) {
        byte b1;
        for (k = i;; k = i) {
          byte[] arrayOfByte1 = b;
          i = k + 1;
          b1 = arrayOfByte1[arrayOfByte[k]];
          if (i >= j || b1 != -1)
            break; 
        } 
        if (b1 != -1) {
          byteArrayOutputStream.write(b << 2 | (b1 & 0x30) >>> 4);
          for (k = i;; k = i) {
            if (k == j)
              return byteArrayOutputStream.toByteArray(); 
            i = k + 1;
            k = arrayOfByte[k];
            if (k == 61)
              return byteArrayOutputStream.toByteArray(); 
            b = b[k];
            if (i >= j || b != -1)
              break; 
          } 
          if (b != -1) {
            byteArrayOutputStream.write((b1 & 0xF) << 4 | (b & 0x3C) >>> 2);
            for (k = i;; k = i) {
              if (k == j)
                return byteArrayOutputStream.toByteArray(); 
              i = k + 1;
              k = arrayOfByte[k];
              if (k == 61)
                return byteArrayOutputStream.toByteArray(); 
              k = b[k];
              if (i >= j || k != -1)
                break; 
            } 
            if (k != -1)
              byteArrayOutputStream.write(k | (b & 0x3) << 6); 
          } 
        } 
      } 
    } 
    return byteArrayOutputStream.toByteArray();
  }
  
  public static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
    return c(paramArrayOfbyte1, paramArrayOfbyte2, paramArrayOfbyte3);
  }
  
  public static String c(byte[] paramArrayOfbyte) {
    try {
      return d(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      paramArrayOfbyte.printStackTrace();
    } 
  }
  
  private static byte[] c(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    IvParameterSpec ivParameterSpec = new IvParameterSpec(paramArrayOfbyte3);
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, bs.c("EQUVT"));
    Cipher cipher = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
    try {
      cipher.init(1, secretKeySpec, ivParameterSpec);
    } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
      invalidAlgorithmParameterException.printStackTrace();
    } 
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  private static String d(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i = k + 1) {
      int m = i + 1;
      i = paramArrayOfbyte[i] & 0xFF;
      if (m == j) {
        stringBuffer.append(a[i >>> 2]);
        stringBuffer.append(a[(i & 0x3) << 4]);
        stringBuffer.append("==");
        break;
      } 
      int k = m + 1;
      m = paramArrayOfbyte[m] & 0xFF;
      if (k == j) {
        stringBuffer.append(a[i >>> 2]);
        stringBuffer.append(a[(i & 0x3) << 4 | (m & 0xF0) >>> 4]);
        stringBuffer.append(a[(m & 0xF) << 2]);
        stringBuffer.append("=");
        break;
      } 
      int n = paramArrayOfbyte[k] & 0xFF;
      stringBuffer.append(a[i >>> 2]);
      stringBuffer.append(a[(i & 0x3) << 4 | (m & 0xF0) >>> 4]);
      stringBuffer.append(a[(m & 0xF) << 2 | (n & 0xC0) >>> 6]);
      stringBuffer.append(a[n & 0x3F]);
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */