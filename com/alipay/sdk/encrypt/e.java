package com.alipay.sdk.encrypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class e {
  private static final String a = "RSA";
  
  public static byte[] a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: ldc 'RSA'
    //   8: aload_1
    //   9: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/security/PublicKey;
    //   12: astore_1
    //   13: ldc 'RSA/ECB/PKCS1Padding'
    //   15: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore #7
    //   20: aload #7
    //   22: iconst_1
    //   23: aload_1
    //   24: invokevirtual init : (ILjava/security/Key;)V
    //   27: aload_0
    //   28: ldc 'UTF-8'
    //   30: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   33: astore #8
    //   35: aload #7
    //   37: invokevirtual getBlockSize : ()I
    //   40: istore #4
    //   42: new java/io/ByteArrayOutputStream
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_1
    //   50: iconst_0
    //   51: istore_2
    //   52: aload_1
    //   53: astore_0
    //   54: iload_2
    //   55: aload #8
    //   57: arraylength
    //   58: if_icmpge -> 107
    //   61: aload_1
    //   62: astore_0
    //   63: aload #8
    //   65: arraylength
    //   66: iload_2
    //   67: isub
    //   68: iload #4
    //   70: if_icmpge -> 193
    //   73: aload_1
    //   74: astore_0
    //   75: aload #8
    //   77: arraylength
    //   78: iload_2
    //   79: isub
    //   80: istore_3
    //   81: goto -> 84
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: aload #7
    //   89: aload #8
    //   91: iload_2
    //   92: iload_3
    //   93: invokevirtual doFinal : ([BII)[B
    //   96: invokevirtual write : ([B)V
    //   99: iload_2
    //   100: iload #4
    //   102: iadd
    //   103: istore_2
    //   104: goto -> 52
    //   107: aload_1
    //   108: astore_0
    //   109: aload_1
    //   110: invokevirtual toByteArray : ()[B
    //   113: astore #5
    //   115: aload #5
    //   117: astore_0
    //   118: aload_1
    //   119: invokevirtual close : ()V
    //   122: aload #5
    //   124: areturn
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic a : (Ljava/lang/Throwable;)V
    //   130: aload_0
    //   131: areturn
    //   132: astore #5
    //   134: goto -> 148
    //   137: astore_0
    //   138: aload #5
    //   140: astore_1
    //   141: goto -> 175
    //   144: astore #5
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: astore_0
    //   150: aload #5
    //   152: invokestatic a : (Ljava/lang/Throwable;)V
    //   155: aload_1
    //   156: ifnull -> 166
    //   159: aload #6
    //   161: astore_0
    //   162: aload_1
    //   163: invokevirtual close : ()V
    //   166: aconst_null
    //   167: areturn
    //   168: astore #5
    //   170: aload_0
    //   171: astore_1
    //   172: aload #5
    //   174: astore_0
    //   175: aload_1
    //   176: ifnull -> 191
    //   179: aload_1
    //   180: invokevirtual close : ()V
    //   183: goto -> 191
    //   186: astore_1
    //   187: aload_1
    //   188: invokestatic a : (Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: athrow
    //   193: iload #4
    //   195: istore_3
    //   196: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   6	50	144	java/lang/Exception
    //   6	50	137	finally
    //   54	61	132	java/lang/Exception
    //   54	61	168	finally
    //   63	73	132	java/lang/Exception
    //   63	73	168	finally
    //   75	81	132	java/lang/Exception
    //   75	81	168	finally
    //   86	99	132	java/lang/Exception
    //   86	99	168	finally
    //   109	115	132	java/lang/Exception
    //   109	115	168	finally
    //   118	122	125	java/io/IOException
    //   150	155	168	finally
    //   162	166	125	java/io/IOException
    //   179	183	186	java/io/IOException
  }
  
  private static PublicKey b(String paramString1, String paramString2) throws NoSuchAlgorithmException, Exception {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(a.a(paramString2));
    return KeyFactory.getInstance(paramString1).generatePublic(x509EncodedKeySpec);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\encrypt\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */