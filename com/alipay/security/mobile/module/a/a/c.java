package com.alipay.security.mobile.module.a.a;

import com.alipay.security.mobile.module.a.a;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class c {
  private static String a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";
  
  public static String a() {
    String str = new String();
    for (int i = 0; i < a.length() - 1; i += 4) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(a.charAt(i));
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      PBEKeySpec pBEKeySpec = a(paramString1);
      byte[] arrayOfByte1 = paramString2.getBytes();
      byte[] arrayOfByte3 = b();
      SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(pBEKeySpec).getEncoded(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(1, secretKeySpec, new IvParameterSpec(arrayOfByte3));
      byte[] arrayOfByte2 = pBEKeySpec.getSalt();
      ByteBuffer byteBuffer = ByteBuffer.allocate(arrayOfByte2.length + cipher.getOutputSize(arrayOfByte1.length));
      byteBuffer.put(arrayOfByte2);
      cipher.doFinal(ByteBuffer.wrap(arrayOfByte1), byteBuffer);
      return a(byteBuffer.array());
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      stringBuffer.append("0123456789ABCDEF".charAt(b >> 4 & 0xF));
      stringBuffer.append("0123456789ABCDEF".charAt(b & 0xF));
    } 
    return stringBuffer.toString();
  }
  
  private static PBEKeySpec a(String paramString) {
    Class<?> clazz = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
    Object object = clazz.newInstance();
    byte[] arrayOfByte = new byte[16];
    Method method = clazz.getMethod("nextBytes", new Class[] { arrayOfByte.getClass() });
    method.setAccessible(true);
    method.invoke(object, new Object[] { arrayOfByte });
    return new PBEKeySpec(paramString.toCharArray(), arrayOfByte, 10, 128);
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      PBEKeySpec pBEKeySpec = a(paramString1);
      int j = paramString2.length() / 2;
      byte[] arrayOfByte1 = new byte[j];
      for (int i = 0; i < j; i++) {
        int k = i * 2;
        arrayOfByte1[i] = Integer.valueOf(paramString2.substring(k, k + 2), 16).byteValue();
      } 
      byte[] arrayOfByte2 = b();
      if (arrayOfByte1.length <= 16) {
        arrayOfByte1 = null;
      } else {
        pBEKeySpec = new PBEKeySpec(pBEKeySpec.getPassword(), Arrays.copyOf(arrayOfByte1, 16), 10, 128);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(pBEKeySpec).getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(arrayOfByte2));
        arrayOfByte1 = cipher.doFinal(arrayOfByte1, 16, arrayOfByte1.length - 16);
      } 
      if (arrayOfByte1 != null) {
        String str = new String(arrayOfByte1);
        if (a.c(str))
          return str; 
      } else {
        throw new Exception();
      } 
      return null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static byte[] b() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < 48; i += 2)
        stringBuilder.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i)); 
      return a.a(stringBuilder.toString());
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */