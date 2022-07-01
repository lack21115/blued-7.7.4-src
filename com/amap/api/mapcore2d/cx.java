package com.amap.api.mapcore2d;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cx {
  public static String a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual isFile : ()Z
    //   22: ifeq -> 105
    //   25: aload_0
    //   26: invokevirtual exists : ()Z
    //   29: ifne -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: sipush #2048
    //   37: newarray byte
    //   39: astore_2
    //   40: ldc 'MD5'
    //   42: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: astore_3
    //   46: new java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial <init> : (Ljava/io/File;)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual read : ([B)I
    //   60: istore_1
    //   61: iload_1
    //   62: iconst_m1
    //   63: if_icmpeq -> 76
    //   66: aload_3
    //   67: aload_2
    //   68: iconst_0
    //   69: iload_1
    //   70: invokevirtual update : ([BII)V
    //   73: goto -> 55
    //   76: aload_3
    //   77: invokevirtual digest : ()[B
    //   80: invokestatic e : ([B)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual close : ()V
    //   88: aload_2
    //   89: areturn
    //   90: astore_0
    //   91: aload_0
    //   92: ldc 'MD5'
    //   94: ldc 'gfm'
    //   96: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_2
    //   102: goto -> 110
    //   105: aconst_null
    //   106: areturn
    //   107: astore_2
    //   108: aconst_null
    //   109: astore_0
    //   110: aload_2
    //   111: ldc 'MD5'
    //   113: ldc 'gfm'
    //   115: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: ifnull -> 137
    //   122: aload_0
    //   123: invokevirtual close : ()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aload_0
    //   130: ldc 'MD5'
    //   132: ldc 'gfm'
    //   134: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_2
    //   140: aload_0
    //   141: ifnull -> 160
    //   144: aload_0
    //   145: invokevirtual close : ()V
    //   148: goto -> 160
    //   151: astore_0
    //   152: aload_0
    //   153: ldc 'MD5'
    //   155: ldc 'gfm'
    //   157: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_2
    //   161: athrow
    // Exception table:
    //   from	to	target	type
    //   0	7	107	finally
    //   9	32	107	finally
    //   34	55	107	finally
    //   55	61	101	finally
    //   66	73	101	finally
    //   76	84	101	finally
    //   84	88	90	java/io/IOException
    //   110	118	139	finally
    //   122	126	128	java/io/IOException
    //   144	148	151	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    return db.e(b(paramArrayOfbyte));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    try {
      return messageDigest.digest();
    } finally {
      paramArrayOfbyte = null;
      dl.a((Throwable)paramArrayOfbyte, "MD5", "gmb");
    } 
  }
  
  public static String b(String paramString) {
    return (paramString == null) ? null : db.e(d(paramString));
  }
  
  private static byte[] b(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, "MD5");
  }
  
  public static String c(String paramString) {
    return db.f(e(paramString));
  }
  
  public static byte[] d(String paramString) {
    try {
      return f(paramString);
    } finally {
      paramString = null;
      dl.a((Throwable)paramString, "MD5", "gmb");
    } 
  }
  
  private static byte[] e(String paramString) {
    try {
      return f(paramString);
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  private static byte[] f(String paramString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    if (paramString == null)
      return null; 
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    messageDigest.update(db.a(paramString));
    return messageDigest.digest();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */