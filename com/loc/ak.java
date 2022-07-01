package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public abstract class ak {
  ak a;
  
  ak() {}
  
  ak(ak paramak) {
    this.a = paramak;
  }
  
  protected abstract byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
  
  public final byte[] b(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    ak ak1 = this.a;
    byte[] arrayOfByte = paramArrayOfbyte;
    if (ak1 != null)
      arrayOfByte = ak1.b(paramArrayOfbyte); 
    return a(arrayOfByte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */