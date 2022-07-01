package com.ishumei.l111l1111llIl;

import android.os.Build;
import android.util.Base64;
import java.io.IOException;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class l1111l111111Il {
  private static String l1111l111111Il(String paramString, byte[] paramArrayOfbyte) {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec(paramString.getBytes());
      SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
      Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
      cipher.init(1, secretKey);
      return Base64.encodeToString(cipher.doFinal(paramArrayOfbyte), 0);
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  public static String l1111l111111Il(String paramString, byte[] paramArrayOfbyte, int paramInt) {
    try {
      return new String(l111l11111lIl(paramString, paramArrayOfbyte, paramInt), "utf-8");
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  private static Key l1111l111111Il(String paramString) {
    SecureRandom secureRandom;
    KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
    if (Build.VERSION.SDK_INT >= 17) {
      secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
    } else {
      secureRandom = SecureRandom.getInstance("SHA1PRNG");
    } 
    secureRandom.setSeed(paramString.getBytes("utf-8"));
    keyGenerator.init(64, secureRandom);
    return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "DES");
  }
  
  private static byte[] l111l11111I1l(String paramString, byte[] paramArrayOfbyte) {
    try {
      Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
      cipher.init(2, new SecretKeySpec(paramString.getBytes("utf-8"), "DES"));
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  private static String l111l11111lIl(String paramString, byte[] paramArrayOfbyte) {
    try {
      return new String(l111l11111I1l(paramString, paramArrayOfbyte), "utf-8");
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  public static byte[] l111l11111lIl(String paramString, byte[] paramArrayOfbyte, int paramInt) {
    try {
      Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
      cipher.init(2, new SecretKeySpec(paramString.getBytes("utf-8"), "DES"));
      byte[] arrayOfByte = cipher.doFinal(paramArrayOfbyte);
      paramArrayOfbyte = new byte[paramInt];
      System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 0, paramInt);
      return paramArrayOfbyte;
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */