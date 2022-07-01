package com.baidu.mobads.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class d {
  public static String a(String paramString) {
    try {
      SecretKey secretKey = a();
      return a(Base64.decode(paramString, 0), secretKey);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, SecretKey paramSecretKey) {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(2, paramSecretKey);
    return new String(cipher.doFinal(paramArrayOfbyte), "UTF-8");
  }
  
  public static SecretKey a() {
    return new SecretKeySpec("aaskdffdaaskdffd".getBytes(), "AES");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */