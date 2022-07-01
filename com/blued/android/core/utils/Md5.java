package com.blued.android.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Md5 {
  protected static char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(File paramFile) throws IOException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = ByteArrayPool.a.a(1024);
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i > 0) {
          messageDigest.update(arrayOfByte, 0, i);
          continue;
        } 
        fileInputStream.close();
        ByteArrayPool.a.a(arrayOfByte);
        return b(messageDigest.digest());
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      return null;
    } 
  }
  
  public static String a(String paramString) {
    if (paramString != null)
      try {
        return a(paramString.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      }  
    return null;
  }
  
  public static String a(String paramString, byte[] paramArrayOfbyte) {
    if (paramString != null && paramArrayOfbyte != null)
      try {
        return a(paramString.getBytes("UTF-8"), paramArrayOfbyte);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      }  
    return null;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte);
      paramArrayOfbyte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < paramArrayOfbyte.length; i++)
        stringBuilder.append(Integer.toHexString(paramArrayOfbyte[i] & 0xFF | 0xFFFFFF00).substring(6)); 
      String str = stringBuilder.toString();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
      return str;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
      return null;
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
    throw paramArrayOfbyte;
  }
  
  private static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuffer stringBuffer = new StringBuffer(paramInt2 * 2);
    for (int i = paramInt1; i < paramInt2 + paramInt1; i++)
      a(paramArrayOfbyte[i], stringBuffer); 
    return stringBuffer.toString();
  }
  
  private static String a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte1);
      messageDigest.update(paramArrayOfbyte2);
      paramArrayOfbyte1 = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < paramArrayOfbyte1.length; i++)
        stringBuilder.append(Integer.toHexString(paramArrayOfbyte1[i] & 0xFF | 0xFFFFFF00).substring(6)); 
      String str = stringBuilder.toString();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
      return str;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
      return null;
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/blued/android/core/utils/Md5}} */
    throw paramArrayOfbyte1;
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer) {
    char[] arrayOfChar = a;
    char c1 = arrayOfChar[(paramByte & 0xF0) >> 4];
    char c2 = arrayOfChar[paramByte & 0xF];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bytes.length = ");
    stringBuilder.append(paramArrayOfbyte.length);
    Log.b("Md5", stringBuilder.toString());
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\Md5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */