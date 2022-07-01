package com.qq.e.comm.util;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class Md5Util {
  private static final String[] a = new String[] { 
      "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
      "a", "b", "c", "d", "e", "f" };
  
  public static String byteArrayToHexString(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      int j = b;
      if (b < 0)
        j = b + 256; 
      int k = j / 16;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a[k]);
      stringBuilder.append(a[j % 16]);
      stringBuffer.append(stringBuilder.toString());
    } 
    return stringBuffer.toString();
  }
  
  public static String encode(File paramFile) {
    String str = "";
    if (paramFile == null)
      return ""; 
    Exception exception = null;
    byte[] arrayOfByte = null;
    try {
      byte[] arrayOfByte1;
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      try {
        arrayOfByte = new byte[1024];
        while (true) {
          int i = fileInputStream.read(arrayOfByte);
          if (i > 0) {
            messageDigest.update(arrayOfByte, 0, i);
            continue;
          } 
          String str1 = byteArrayToHexString(messageDigest.digest());
          str = str1;
          try {
            return str1;
          } catch (Exception exception1) {
            return str;
          } 
        } 
      } catch (Exception exception2) {
        return "";
      } finally {
        arrayOfByte = null;
        Exception exception2 = exception1;
        arrayOfByte1 = arrayOfByte;
      } 
      throw arrayOfByte1;
    } catch (Exception exception1) {
    
    } finally {
      paramFile = null;
      byte[] arrayOfByte1 = arrayOfByte;
    } 
    if (paramFile != null)
      paramFile.close(); 
    return "";
  }
  
  public static String encode(String paramString) {
    try {
      paramString = new String(paramString);
      try {
        return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
      } catch (Exception exception) {
        return paramString;
      } 
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String encodeBase64String(String paramString) {
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    try {
      return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(arrayOfByte));
    } catch (Exception exception) {
      GDTLogger.e("Exception while md5 base64String", exception);
      return null;
    } 
  }
  
  public static byte[] hexStringtoByteArray(String paramString) {
    if (paramString.length() % 2 != 0)
      return null; 
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; i < paramString.length() - 1; i += 2) {
      char c1 = paramString.charAt(i);
      char c2 = paramString.charAt(i + 1);
      int j = Character.toLowerCase(c1);
      int k = Character.toLowerCase(c2);
      if (j <= 57) {
        j = j - 48;
      } else {
        j = j - 97 + 10;
      } 
      if (k <= 57) {
        k = k - 48;
      } else {
        k = k - 97 + 10;
      } 
      k = (j << 4) + k;
      j = k;
      if (k > 127)
        j = k - 256; 
      j = (byte)j;
      arrayOfByte[i / 2] = (byte)j;
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\Md5Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */