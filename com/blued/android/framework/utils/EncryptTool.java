package com.blued.android.framework.utils;

import com.blued.android.core.Hashids;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptTool {
  public static String a(String paramString) {
    String str2 = "";
    String str1 = str2;
    try {
      long[] arrayOfLong = (new Hashids("1766", 6)).a(paramString);
      int i = 0;
      paramString = str2;
      while (true) {
        str1 = paramString;
        str2 = paramString;
        if (i < arrayOfLong.length) {
          str1 = paramString;
          StringBuilder stringBuilder = new StringBuilder();
          str1 = paramString;
          stringBuilder.append(paramString);
          str1 = paramString;
          stringBuilder.append(Long.toString(arrayOfLong[i]));
          str1 = paramString;
          paramString = stringBuilder.toString();
          i++;
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      str2 = str1;
    } 
    return str2;
  }
  
  public static String b(String paramString) {
    try {
      Long long_ = Long.valueOf(paramString);
      return (new Hashids("1766", 6)).a(new long[] { long_.longValue() });
    } catch (NumberFormatException numberFormatException) {
      numberFormatException.printStackTrace();
      return paramString;
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramString;
    } 
  }
  
  public static String c(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = messageDigest.digest();
    } catch (NoSuchAlgorithmException null) {
      exception.printStackTrace();
      exception = null;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return (exception != null) ? AesCrypto.a((byte[])exception) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\EncryptTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */