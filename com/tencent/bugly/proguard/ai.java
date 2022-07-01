package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class ai implements aj {
  private String a = null;
  
  public final void a(String paramString) {
    if (paramString != null)
      this.a = paramString; 
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) throws Exception {
    if (this.a == null || paramArrayOfbyte == null)
      return null; 
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec dESKeySpec = new DESKeySpec(this.a.getBytes("UTF-8"));
    cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec), new IvParameterSpec(this.a.getBytes("UTF-8")));
    return cipher.doFinal(paramArrayOfbyte);
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) throws Exception, NoSuchAlgorithmException {
    if (this.a == null || paramArrayOfbyte == null)
      return null; 
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec dESKeySpec = new DESKeySpec(this.a.getBytes("UTF-8"));
    cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec), new IvParameterSpec(this.a.getBytes("UTF-8")));
    return cipher.doFinal(paramArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */