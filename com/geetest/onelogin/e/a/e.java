package com.geetest.onelogin.e.a;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class e {
  public static String a(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "HmacSHA256");
      Mac mac = Mac.getInstance("HmacSHA256");
      mac.init(secretKeySpec);
      return a(mac.doFinal(paramString1.getBytes()));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    String str = "";
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str2 = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      String str1 = str;
      if (str2.length() == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("0");
        str1 = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      str = stringBuilder.toString();
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */