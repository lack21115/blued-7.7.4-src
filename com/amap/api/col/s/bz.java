package com.amap.api.col.s;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class bz {
  public static PublicKey a(String paramString) throws Exception {
    try {
      byte[] arrayOfByte = bv.a(paramString);
      return KeyFactory.getInstance(bs.c("EUlNB")).generatePublic(new X509EncodedKeySpec(arrayOfByte));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此算法");
    } catch (InvalidKeySpecException invalidKeySpecException) {
      throw new Exception("公钥非法");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥数据为空");
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, PublicKey paramPublicKey) {
    try {
      Cipher cipher = Cipher.getInstance(bs.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
      return cipher.doFinal(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */