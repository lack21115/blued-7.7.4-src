package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

public class EncryptUtil {
  private static boolean a = false;
  
  private static boolean b = true;
  
  private static boolean a() {
    return (Build.VERSION.SDK_INT >= 26);
  }
  
  public static byte[] a(int paramInt) {
    if (!a || !a())
      try {
        SecureRandom secureRandom = new SecureRandom();
        byte[] arrayOfByte = new byte[paramInt];
        secureRandom.nextBytes(arrayOfByte);
        return arrayOfByte;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("generate secure random error");
        stringBuilder.append(exception.getMessage());
        b.c("EncryptUtil", stringBuilder.toString());
        return new byte[0];
      }  
    return c(paramInt);
  }
  
  public static String b(int paramInt) {
    return HexUtil.a(a(paramInt));
  }
  
  private static SecureRandom b() {
    try {
      SecureRandom secureRandom = SecureRandom.getInstanceStrong();
      AESEngine aESEngine = new AESEngine();
      byte[] arrayOfByte = new byte[32];
      return (SecureRandom)(new SP800SecureRandomBuilder(secureRandom, true)).setEntropyBitsRequired(384).buildCTR((BlockCipher)aESEngine, 256, arrayOfByte, false);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } finally {
      Exception exception = null;
    } 
    return new SecureRandom();
  }
  
  private static byte[] c(int paramInt) {
    b.a("EncryptUtil", "generateSecureRandomNew ");
    SecureRandom secureRandom = b();
    if (secureRandom == null)
      return new byte[0]; 
    byte[] arrayOfByte = new byte[paramInt];
    secureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encryp\\utils\EncryptUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */