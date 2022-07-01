package com.loc;

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

public final class o {
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
    return u.a(b(paramString));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance(u.c("EQUVT"));
    if (keyGenerator == null)
      return null; 
    keyGenerator.init(256);
    byte[] arrayOfByte2 = keyGenerator.generateKey().getEncoded();
    PublicKey publicKey = u.d();
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
    Cipher cipher = Cipher.getInstance(u.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
    cipher.init(1, paramKey);
    return cipher.doFinal(paramArrayOfbyte);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      return c(paramArrayOfbyte1, paramArrayOfbyte2, u.c());
    } finally {
      paramArrayOfbyte1 = null;
      y.a((Throwable)paramArrayOfbyte1, "er", "asEn");
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) throws Exception {
    IvParameterSpec ivParameterSpec = new IvParameterSpec(paramArrayOfbyte3);
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, u.c("EQUVT"));
    Cipher cipher = Cipher.getInstance(u.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
    cipher.init(2, secretKeySpec, ivParameterSpec);
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    try {
      return d(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      y.a((Throwable)paramArrayOfbyte, "er", "e64");
    } 
  }
  
  public static byte[] b(String paramString) {
    int i = 0;
    if (paramString == null)
      return new byte[0]; 
    byte[] arrayOfByte = u.a(paramString);
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
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, u.c("EQUVT"));
    Cipher cipher = Cipher.getInstance(u.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
    try {
      cipher.init(1, secretKeySpec, ivParameterSpec);
    } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
      invalidAlgorithmParameterException.printStackTrace();
    } 
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  private static String d(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload_0
    //   10: arraylength
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_1
    //   14: iload_1
    //   15: iload_2
    //   16: if_icmpge -> 254
    //   19: iload_1
    //   20: iconst_1
    //   21: iadd
    //   22: istore #4
    //   24: aload_0
    //   25: iload_1
    //   26: baload
    //   27: sipush #255
    //   30: iand
    //   31: istore_1
    //   32: iload #4
    //   34: iload_2
    //   35: if_icmpne -> 79
    //   38: aload #6
    //   40: getstatic com/loc/o.a : [C
    //   43: iload_1
    //   44: iconst_2
    //   45: iushr
    //   46: caload
    //   47: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload #6
    //   53: getstatic com/loc/o.a : [C
    //   56: iload_1
    //   57: iconst_3
    //   58: iand
    //   59: iconst_4
    //   60: ishl
    //   61: caload
    //   62: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   65: pop
    //   66: ldc '=='
    //   68: astore_0
    //   69: aload #6
    //   71: aload_0
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   75: pop
    //   76: goto -> 254
    //   79: iload #4
    //   81: iconst_1
    //   82: iadd
    //   83: istore_3
    //   84: aload_0
    //   85: iload #4
    //   87: baload
    //   88: sipush #255
    //   91: iand
    //   92: istore #4
    //   94: iload_3
    //   95: iload_2
    //   96: if_icmpne -> 159
    //   99: aload #6
    //   101: getstatic com/loc/o.a : [C
    //   104: iload_1
    //   105: iconst_2
    //   106: iushr
    //   107: caload
    //   108: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   111: pop
    //   112: aload #6
    //   114: getstatic com/loc/o.a : [C
    //   117: iload_1
    //   118: iconst_3
    //   119: iand
    //   120: iconst_4
    //   121: ishl
    //   122: iload #4
    //   124: sipush #240
    //   127: iand
    //   128: iconst_4
    //   129: iushr
    //   130: ior
    //   131: caload
    //   132: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload #6
    //   138: getstatic com/loc/o.a : [C
    //   141: iload #4
    //   143: bipush #15
    //   145: iand
    //   146: iconst_2
    //   147: ishl
    //   148: caload
    //   149: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   152: pop
    //   153: ldc '='
    //   155: astore_0
    //   156: goto -> 69
    //   159: aload_0
    //   160: iload_3
    //   161: baload
    //   162: sipush #255
    //   165: iand
    //   166: istore #5
    //   168: aload #6
    //   170: getstatic com/loc/o.a : [C
    //   173: iload_1
    //   174: iconst_2
    //   175: iushr
    //   176: caload
    //   177: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   180: pop
    //   181: aload #6
    //   183: getstatic com/loc/o.a : [C
    //   186: iload_1
    //   187: iconst_3
    //   188: iand
    //   189: iconst_4
    //   190: ishl
    //   191: iload #4
    //   193: sipush #240
    //   196: iand
    //   197: iconst_4
    //   198: iushr
    //   199: ior
    //   200: caload
    //   201: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   204: pop
    //   205: aload #6
    //   207: getstatic com/loc/o.a : [C
    //   210: iload #4
    //   212: bipush #15
    //   214: iand
    //   215: iconst_2
    //   216: ishl
    //   217: iload #5
    //   219: sipush #192
    //   222: iand
    //   223: bipush #6
    //   225: iushr
    //   226: ior
    //   227: caload
    //   228: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   231: pop
    //   232: aload #6
    //   234: getstatic com/loc/o.a : [C
    //   237: iload #5
    //   239: bipush #63
    //   241: iand
    //   242: caload
    //   243: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   246: pop
    //   247: iload_3
    //   248: iconst_1
    //   249: iadd
    //   250: istore_1
    //   251: goto -> 14
    //   254: aload #6
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */