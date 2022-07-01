package com.amap.api.mapcore2d;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class fo {
  fo c;
  
  byte[] d = null;
  
  fo() {}
  
  fo(fo paramfo) {
    this.c = paramfo;
  }
  
  public byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    byte[] arrayOfByte2 = a(this.d);
    fo fo1 = this.c;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (fo1 != null) {
      fo1.c(arrayOfByte2);
      arrayOfByte1 = this.c.a();
    } 
    return arrayOfByte1;
  }
  
  protected abstract byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public void b(byte[] paramArrayOfbyte) {}
  
  void c(byte[] paramArrayOfbyte) {
    this.d = paramArrayOfbyte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */