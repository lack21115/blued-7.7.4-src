package com.alipay.sdk.encrypt;

import com.alipay.sdk.util.c;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class b {
  public static String a(int paramInt, String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "DES");
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(paramInt, secretKeySpec);
      if (paramInt == 2) {
        arrayOfByte = a.a(paramString1);
      } else {
        arrayOfByte = arrayOfByte.getBytes("UTF-8");
      } 
      byte[] arrayOfByte = cipher.doFinal(arrayOfByte);
      return (paramInt == 2) ? new String(arrayOfByte) : a.a(arrayOfByte);
    } catch (Exception exception) {
      c.a(exception);
      return null;
    } 
  }
  
  public static String a(String paramString1, String paramString2) {
    return a(1, paramString1, paramString2);
  }
  
  public static String b(String paramString1, String paramString2) {
    return a(2, paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\encrypt\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */