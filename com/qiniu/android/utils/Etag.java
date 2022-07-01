package com.qiniu.android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Etag {
  public static String data(byte[] paramArrayOfbyte) {
    return data(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static String data(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: new java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: iload_1
    //   9: iload_2
    //   10: invokespecial <init> : ([BII)V
    //   13: astore #5
    //   15: iload_2
    //   16: i2l
    //   17: lstore_3
    //   18: aload #5
    //   20: astore_0
    //   21: aload #5
    //   23: lload_3
    //   24: invokestatic stream : (Ljava/io/InputStream;J)Ljava/lang/String;
    //   27: astore #6
    //   29: aload #5
    //   31: invokevirtual close : ()V
    //   34: aload #6
    //   36: areturn
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual printStackTrace : ()V
    //   42: aload #6
    //   44: areturn
    //   45: astore #6
    //   47: goto -> 63
    //   50: astore_0
    //   51: aload #6
    //   53: astore #5
    //   55: goto -> 98
    //   58: astore #6
    //   60: aconst_null
    //   61: astore #5
    //   63: aload #5
    //   65: astore_0
    //   66: aload #6
    //   68: invokevirtual printStackTrace : ()V
    //   71: aload #5
    //   73: ifnull -> 88
    //   76: aload #5
    //   78: invokevirtual close : ()V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual printStackTrace : ()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore #6
    //   92: aload_0
    //   93: astore #5
    //   95: aload #6
    //   97: astore_0
    //   98: aload #5
    //   100: ifnull -> 118
    //   103: aload #5
    //   105: invokevirtual close : ()V
    //   108: goto -> 118
    //   111: astore #5
    //   113: aload #5
    //   115: invokevirtual printStackTrace : ()V
    //   118: aload_0
    //   119: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	58	java/io/IOException
    //   3	15	50	finally
    //   21	29	45	java/io/IOException
    //   21	29	90	finally
    //   29	34	37	java/lang/Exception
    //   66	71	90	finally
    //   76	81	83	java/lang/Exception
    //   103	108	111	java/lang/Exception
  }
  
  public static String file(File paramFile) throws IOException {
    FileInputStream fileInputStream = null;
    try {
      FileInputStream fileInputStream1 = new FileInputStream(paramFile);
      try {
        String str = stream(fileInputStream1, paramFile.length());
      } finally {
        paramFile = null;
      } 
    } finally {}
    if (fileInputStream != null)
      try {
        fileInputStream.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    throw paramFile;
  }
  
  public static String file(String paramString) throws IOException {
    return file(new File(paramString));
  }
  
  private static byte[] oneBlock(byte[] paramArrayOfbyte, InputStream paramInputStream, int paramInt) throws IOException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
      int i = paramArrayOfbyte.length;
      while (paramInt != 0) {
        int j;
        if (i > paramInt) {
          j = paramInt;
        } else {
          j = i;
        } 
        paramInputStream.read(paramArrayOfbyte, 0, j);
        messageDigest.update(paramArrayOfbyte, 0, j);
        paramInt -= j;
      } 
      return messageDigest.digest();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      return null;
    } 
  }
  
  private static String resultEncode(byte[][] paramArrayOfbyte) {
    MessageDigest messageDigest1;
    byte b;
    MessageDigest messageDigest2;
    byte[] arrayOfByte1 = paramArrayOfbyte[0];
    int i = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[i + 1];
    if (paramArrayOfbyte.length != 1) {
      try {
        messageDigest2 = MessageDigest.getInstance("sha-1");
        int k = paramArrayOfbyte.length;
        for (int j = 0; j < k; j++)
          messageDigest2.update(paramArrayOfbyte[j]); 
        byte[] arrayOfByte = messageDigest2.digest();
        b = -106;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        noSuchAlgorithmException.printStackTrace();
        return null;
      } 
    } else {
      b = 22;
      messageDigest1 = messageDigest2;
    } 
    arrayOfByte2[0] = b;
    System.arraycopy(messageDigest1, 0, arrayOfByte2, 1, i);
    return UrlSafeBase64.encodeToString(arrayOfByte2);
  }
  
  public static String stream(InputStream paramInputStream, long paramLong) throws IOException {
    if (paramLong == 0L)
      return "Fto5o-5ea0sNMlW_75VgGJCv2AcJ"; 
    byte[] arrayOfByte = new byte[65536];
    byte[][] arrayOfByte1 = new byte[(int)((paramLong + 4194304L - 1L) / 4194304L)][];
    for (int i = 0; i < arrayOfByte1.length; i++) {
      long l2 = paramLong - i * 4194304L;
      long l1 = l2;
      if (l2 > 4194304L)
        l1 = 4194304L; 
      arrayOfByte1[i] = oneBlock(arrayOfByte, paramInputStream, (int)l1);
    } 
    return resultEncode(arrayOfByte1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\Etag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */