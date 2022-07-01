package com.pgl.sys.a.b;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class b implements X509TrustManager {
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public final X509Certificate[] getAcceptedIssuers() {
    return new X509Certificate[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */