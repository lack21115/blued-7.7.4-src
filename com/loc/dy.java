package com.loc;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class dy {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final byte[] b = new byte[] { 
      61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 
      74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 
      88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 
      113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 
      103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 
      106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 
      115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 
      73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 
      115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 
      70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 
      119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 
      81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 
      74, 89, 81, 68, 119, 119, 70, 77 };
  
  private static final byte[] c = new byte[] { 
      0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 
      6, 5, 4, 3, 2, 1 };
  
  private static final IvParameterSpec d = new IvParameterSpec(c);
  
  public static String a(String paramString) {
    if (paramString != null)
      try {
        if (paramString.length() == 0)
          return null; 
        String str = a("SHA1", paramString);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        return a("MD5", stringBuilder.toString());
      } finally {
        paramString = null;
      }  
    return null;
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString2 == null)
      return null; 
    try {
      int i;
      byte[] arrayOfByte = r.a(paramString2.getBytes("UTF-8"), paramString1);
      int j = arrayOfByte.length;
      return stringBuilder.toString();
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "Encrypt", "encode");
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) throws Exception {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dl.a((new StringBuilder(new String(b))).reverse().toString().getBytes()));
    PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    Cipher cipher = Cipher.getInstance(u.c("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
    cipher.init(1, publicKey);
    return cipher.doFinal(paramArrayOfbyte);
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    try {
      SecretKeySpec secretKeySpec = b(paramString);
      IvParameterSpec ivParameterSpec = new IvParameterSpec(u.c());
      return cipher.doFinal(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      ej.a((Throwable)paramArrayOfbyte, "Encrypt", "aesEncrypt");
    } 
  }
  
  private static SecretKeySpec b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull -> 9
    //   6: ldc ''
    //   8: astore_1
    //   9: new java/lang/StringBuffer
    //   12: dup
    //   13: bipush #16
    //   15: invokespecial <init> : (I)V
    //   18: astore_0
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual length : ()I
    //   29: bipush #16
    //   31: if_icmpge -> 40
    //   34: ldc '0'
    //   36: astore_1
    //   37: goto -> 19
    //   40: aload_0
    //   41: invokevirtual length : ()I
    //   44: bipush #16
    //   46: if_icmple -> 55
    //   49: aload_0
    //   50: bipush #16
    //   52: invokevirtual setLength : (I)V
    //   55: aload_0
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: ldc 'UTF-8'
    //   61: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   64: astore_0
    //   65: goto -> 79
    //   68: astore_0
    //   69: aload_0
    //   70: ldc 'Encrypt'
    //   72: ldc 'createKey'
    //   74: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   77: aconst_null
    //   78: astore_0
    //   79: new javax/crypto/spec/SecretKeySpec
    //   82: dup
    //   83: aload_0
    //   84: ldc 'AES'
    //   86: invokespecial <init> : ([BLjava/lang/String;)V
    //   89: areturn
    // Exception table:
    //   from	to	target	type
    //   55	65	68	finally
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    int i = 0;
    try {
      byte[] arrayOfByte = new byte[16];
      null = new byte[paramArrayOfbyte.length - 16];
      return cipher.doFinal(null);
    } finally {
      Exception exception = null;
      if (paramArrayOfbyte != null)
        i = paramArrayOfbyte.length; 
      StringBuilder stringBuilder = new StringBuilder("decryptRsponse length = ");
      stringBuilder.append(i);
      ej.a(exception, "Encrypt", stringBuilder.toString());
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, String paramString) {
    try {
      SecretKeySpec secretKeySpec = b(paramString);
      IvParameterSpec ivParameterSpec = new IvParameterSpec(u.c());
      return cipher.doFinal(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      ej.a((Throwable)paramArrayOfbyte, "Encrypt", "aesDecrypt");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */