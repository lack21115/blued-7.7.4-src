package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class dn {
  dn c;
  
  byte[] d = null;
  
  dn() {}
  
  dn(dn paramdn) {
    this.c = paramdn;
  }
  
  public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    dn dn1 = this;
    while (true) {
      byte[] arrayOfByte = dn1.a(dn1.d);
      dn1 = dn1.c;
      if (dn1 != null) {
        dn1.d = arrayOfByte;
        continue;
      } 
      return arrayOfByte;
    } 
  }
  
  protected abstract byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public void b(byte[] paramArrayOfbyte) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */