package org.chromium.net;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;

public class AndroidCertVerifyResult {
  private final List mCertificateChain;
  
  private final boolean mIsIssuedByKnownRoot;
  
  private final int mStatus;
  
  public AndroidCertVerifyResult(int paramInt) {
    this.mStatus = paramInt;
    this.mIsIssuedByKnownRoot = false;
    this.mCertificateChain = Collections.emptyList();
  }
  
  public AndroidCertVerifyResult(int paramInt, boolean paramBoolean, List<?> paramList) {
    this.mStatus = paramInt;
    this.mIsIssuedByKnownRoot = paramBoolean;
    this.mCertificateChain = new ArrayList(paramList);
  }
  
  @CalledByNative
  public byte[][] getCertificateChainEncoded() {
    byte[][] arrayOfByte = new byte[this.mCertificateChain.size()][];
    int i = 0;
    try {
      while (i < this.mCertificateChain.size()) {
        arrayOfByte[i] = ((X509Certificate)this.mCertificateChain.get(i)).getEncoded();
        i++;
      } 
      return arrayOfByte;
    } catch (CertificateEncodingException certificateEncodingException) {
      return new byte[0][];
    } 
  }
  
  @CalledByNative
  public int getStatus() {
    return this.mStatus;
  }
  
  @CalledByNative
  public boolean isIssuedByKnownRoot() {
    return this.mIsIssuedByKnownRoot;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidCertVerifyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */