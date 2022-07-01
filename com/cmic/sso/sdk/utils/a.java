package com.cmic.sso.sdk.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static String a(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString1.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
      return b.a(cipher.doFinal(paramString2.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, String paramString) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
      return b.a(cipher.doFinal(paramString.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      byte[] arrayOfByte = b.a(paramString2);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString1.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
      return new String(cipher.doFinal(arrayOfByte), "UTF-8");
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String b(byte[] paramArrayOfbyte, String paramString) {
    try {
      byte[] arrayOfByte = b.a(paramString);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
      return new String(cipher.doFinal(arrayOfByte), "UTF-8");
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */