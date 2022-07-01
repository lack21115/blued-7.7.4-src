package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class f {
  private static String a = "DESede/CBC/PKCS5Padding";
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    try {
      return a.a(a(paramString1, paramString2.getBytes(), paramString3));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static byte[] a(String paramString1, byte[] paramArrayOfbyte, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString1.getBytes(), "DESede");
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(1, secretKeySpec, new IvParameterSpec(d.a(cipher, paramString2)));
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String b(String paramString1, String paramString2, String paramString3) {
    try {
      return new String(b(paramString1, a.a(paramString2), paramString3));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static byte[] b(String paramString1, byte[] paramArrayOfbyte, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString1.getBytes(), "DESede");
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(2, secretKeySpec, new IvParameterSpec(d.a(cipher, paramString2)));
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\encrypt\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */