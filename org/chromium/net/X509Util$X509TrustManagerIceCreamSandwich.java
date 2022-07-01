package org.chromium.net;

import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.X509TrustManager;

final class X509Util$X509TrustManagerIceCreamSandwich implements X509Util$X509TrustManagerImplementation {
  private final X509TrustManager mTrustManager;
  
  public X509Util$X509TrustManagerIceCreamSandwich(X509TrustManager paramX509TrustManager) {
    this.mTrustManager = paramX509TrustManager;
  }
  
  public final List checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2) {
    this.mTrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString1);
    return Collections.emptyList();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\X509Util$X509TrustManagerIceCreamSandwich.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */