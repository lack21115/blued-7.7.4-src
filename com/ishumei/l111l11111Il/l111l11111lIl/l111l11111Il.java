package com.ishumei.l111l11111Il.l111l11111lIl;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

final class l111l11111Il extends l111l1111l1Il {
  private final byte[] l1111l111111Il;
  
  private int l111l11111lIl = -1;
  
  l111l11111Il(X509Certificate paramX509Certificate, byte[] paramArrayOfbyte) {
    super(paramX509Certificate);
    this.l1111l111111Il = paramArrayOfbyte;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof l111l11111Il))
      return false; 
    try {
      return Arrays.equals(getEncoded(), ((l111l11111Il)paramObject).getEncoded());
    } catch (CertificateEncodingException certificateEncodingException) {
      return false;
    } 
  }
  
  public final byte[] getEncoded() {
    return this.l1111l111111Il;
  }
  
  public final int hashCode() {
    if (this.l111l11111lIl == -1)
      try {
        this.l111l11111lIl = Arrays.hashCode(getEncoded());
      } catch (CertificateEncodingException certificateEncodingException) {
        this.l111l11111lIl = 0;
      }  
    return this.l111l11111lIl;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111lIl\l111l11111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */