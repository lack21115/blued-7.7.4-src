package com.alibaba.mtl.log.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j {
  public static char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      stringBuilder.append(a[(paramArrayOfbyte[i] & 0xF0) >>> 4]);
      stringBuilder.append(a[paramArrayOfbyte[i] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      try {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(paramArrayOfbyte);
        return messageDigest.digest();
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        noSuchAlgorithmException.printStackTrace();
      }  
    return null;
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = a(paramArrayOfbyte);
    return (paramArrayOfbyte != null) ? a(paramArrayOfbyte) : "0000000000000000";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */