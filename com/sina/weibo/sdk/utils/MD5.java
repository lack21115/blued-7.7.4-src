package com.sina.weibo.sdk.utils;

import java.security.MessageDigest;

public class MD5 {
  private static final char[] hexDigits = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String hexdigest(String paramString) {
    try {
      return hexdigest(paramString.getBytes());
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String hexdigest(byte[] paramArrayOfbyte) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte);
      paramArrayOfbyte = messageDigest.digest();
      char[] arrayOfChar = new char[32];
      int i = 0;
      int j = 0;
      while (true) {
        if (i >= 16)
          return new String(arrayOfChar); 
        byte b = paramArrayOfbyte[i];
        int k = j + 1;
        arrayOfChar[j] = hexDigits[b >>> 4 & 0xF];
        j = k + 1;
        arrayOfChar[k] = hexDigits[b & 0xF];
        i++;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static void main(String[] paramArrayOfString) {
    System.out.println(hexdigest("c"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */