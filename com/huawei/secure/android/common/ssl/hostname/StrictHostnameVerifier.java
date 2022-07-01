package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class StrictHostnameVerifier implements HostnameVerifier {
  public final boolean verify(String paramString, SSLSession paramSSLSession) {
    try {
      X509Certificate x509Certificate = (X509Certificate)paramSSLSession.getPeerCertificates()[0];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verify: certificate is : ");
      stringBuilder.append(x509Certificate.getSubjectDN().getName());
      g.a("", stringBuilder.toString());
      b.a(paramString, x509Certificate, true);
      return true;
    } catch (SSLException sSLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SSLException : ");
      stringBuilder.append(sSLException.getMessage());
      g.d("", stringBuilder.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\hostname\StrictHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */