package com.alipay.security.mobile.module.a.a;

import com.alipay.security.mobile.module.a.a;
import java.security.MessageDigest;

public final class b {
  public static String a(String paramString) {
    try {
      if (a.a(paramString))
        return null; 
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < arrayOfByte.length; i++) {
        stringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
      } 
      return stringBuilder.toString();
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */