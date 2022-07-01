package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class bk {
  bk c;
  
  byte[] d = null;
  
  bk() {}
  
  bk(bk parambk) {
    this.c = parambk;
  }
  
  public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    bk bk1 = this;
    while (true) {
      byte[] arrayOfByte = bk1.a(bk1.d);
      bk1 = bk1.c;
      if (bk1 != null) {
        bk1.d = arrayOfByte;
        continue;
      } 
      return arrayOfByte;
    } 
  }
  
  protected abstract byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public void b(byte[] paramArrayOfbyte) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */