package com.bytedance.embedapplog.util;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class f {
  public static String a(String paramString) {
    return a(paramString, "SHA-256");
  }
  
  public static String a(String paramString1, String paramString2) {
    byte[] arrayOfByte = paramString1.getBytes();
    paramString1 = paramString2;
    try {
      if (TextUtils.isEmpty(paramString2))
        paramString1 = "SHA-256"; 
      MessageDigest messageDigest = MessageDigest.getInstance(paramString1);
      messageDigest.update(arrayOfByte);
      return a(messageDigest.digest());
    } catch (NoSuchAlgorithmException|Exception noSuchAlgorithmException) {
      return null;
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    try {
      int i;
      StringBuilder stringBuilder = new StringBuilder();
      int j = paramArrayOfbyte.length;
      return stringBuilder.toString();
    } finally {
      paramArrayOfbyte = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */