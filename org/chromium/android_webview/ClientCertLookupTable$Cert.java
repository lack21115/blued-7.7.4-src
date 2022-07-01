package org.chromium.android_webview;

import java.security.PrivateKey;
import java.util.Arrays;

public final class ClientCertLookupTable$Cert {
  byte[][] mCertChain;
  
  PrivateKey mPrivateKey;
  
  public ClientCertLookupTable$Cert(PrivateKey paramPrivateKey, byte[][] paramArrayOfbyte) {
    this.mPrivateKey = paramPrivateKey;
    byte[][] arrayOfByte = new byte[paramArrayOfbyte.length][];
    for (int i = 0; i < paramArrayOfbyte.length; i++)
      arrayOfByte[i] = Arrays.copyOf(paramArrayOfbyte[i], (paramArrayOfbyte[i]).length); 
    this.mCertChain = arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ClientCertLookupTable$Cert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */