package com.huawei.agconnect.config.a;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class e {
  public static SecretKey a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4) throws NoSuchAlgorithmException, InvalidKeySpecException {
    if (paramArrayOfbyte1.length == 16 && paramArrayOfbyte2.length == 16 && paramArrayOfbyte3.length == 16) {
      String str = c.a(a(paramArrayOfbyte1, paramArrayOfbyte2, paramArrayOfbyte3));
      return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), paramArrayOfbyte4, 5000, 128)).getEncoded(), "AES");
    } 
    throw new IllegalArgumentException("invalid data for generating the key.");
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramArrayOfbyte != null) {
      for (int i = 0; i < paramArrayOfbyte.length; i++) {
        if (paramInt < 0) {
          paramArrayOfbyte[i] = (byte)(paramArrayOfbyte[i] << -paramInt);
        } else {
          paramArrayOfbyte[i] = (byte)(paramArrayOfbyte[i] >> paramInt);
        } 
      } 
      return paramArrayOfbyte;
    } 
    throw new NullPointerException("bytes must not be null.");
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte1 != null && paramArrayOfbyte2 != null) {
      if (paramArrayOfbyte1.length == paramArrayOfbyte2.length) {
        byte[] arrayOfByte = new byte[paramArrayOfbyte1.length];
        for (int i = 0; i < paramArrayOfbyte1.length; i++)
          arrayOfByte[i] = (byte)(paramArrayOfbyte1[i] ^ paramArrayOfbyte2[i]); 
        return arrayOfByte;
      } 
      throw new IllegalArgumentException("left and right must be the same length.");
    } 
    throw new NullPointerException("left or right must not be null.");
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    return a(a(a(a(paramArrayOfbyte1, -4), paramArrayOfbyte2), 6), paramArrayOfbyte3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */