package com.amap.api.mapcore2d;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class df {
  df a;
  
  df() {}
  
  df(df paramdf) {
    this.a = paramdf;
  }
  
  private byte[] c(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    df df1 = this.a;
    byte[] arrayOfByte = paramArrayOfbyte;
    if (df1 != null)
      arrayOfByte = df1.b(paramArrayOfbyte); 
    return arrayOfByte;
  }
  
  protected abstract byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public byte[] b(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    return a(c(paramArrayOfbyte));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */