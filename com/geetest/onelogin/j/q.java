package com.geetest.onelogin.j;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class q implements X509TrustManager {
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {}
  
  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */