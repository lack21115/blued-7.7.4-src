package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.utils.ah;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static String a() {
    String str = ah.c();
    if (str != null) {
      String str1 = str;
      return (str.length() != 16) ? null : str1;
    } 
    return null;
  }
  
  public static String a(String paramString) {
    return (paramString == null || paramString.length() != 16) ? null : paramString.concat(paramString).substring(8, 24);
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(1, secretKeySpec);
      return Base64.encodeToString(cipher.doFinal(paramString1.getBytes("utf-8")), 0);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, String paramString) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
      cipher.init(1, secretKeySpec);
      return Base64.encodeToString(cipher.doFinal(paramArrayOfbyte), 0);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return null; 
    try {
      byte[] arrayOfByte = Base64.decode(paramString1, 0);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(2, secretKeySpec);
      return new String(cipher.doFinal(arrayOfByte));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */