package com.tencent.tbs.patch.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class StringUtils {
  public static String getRandomString(int paramInt) {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramInt; i++)
      stringBuilder.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62))); 
    return stringBuilder.toString();
  }
  
  public static String getString(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    try {
      return new String(paramArrayOfbyte, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return "";
    } 
  }
  
  public static boolean isBlank(String paramString) {
    return isPresent(paramString) ^ true;
  }
  
  public static boolean isPresent(String paramString) {
    return (paramString != null && paramString.length() > 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\commo\\util\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */