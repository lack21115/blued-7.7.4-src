package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.g;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public class c implements X509TrustManager {
  private X509Certificate a;
  
  private List<X509TrustManager> b;
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    g.b("WebViewX509TrustManger", "checkClientTrusted");
    if (!this.b.isEmpty()) {
      ((X509TrustManager)this.b.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    } 
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    g.b("WebViewX509TrustManger", "checkServerTrusted");
    boolean bool = false;
    int i;
    for (i = 0; i < paramArrayOfX509Certificate.length; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkServerTrusted ");
      stringBuilder.append(i);
      stringBuilder.append(" : ");
      stringBuilder.append(paramArrayOfX509Certificate[i].getIssuerDN().getName());
      g.a("WebViewX509TrustManger", stringBuilder.toString());
    } 
    X509Certificate[] arrayOfX509Certificate = new X509Certificate[paramArrayOfX509Certificate.length];
    for (i = 0; i < paramArrayOfX509Certificate.length; i++)
      arrayOfX509Certificate[i] = paramArrayOfX509Certificate[paramArrayOfX509Certificate.length - 1 - i]; 
    certificateException = new CertificateException("CBG root CA CertificateException");
    try {
      boolean bool1 = b.a(this.a, arrayOfX509Certificate);
      bool = bool1;
    } catch (NoSuchProviderException noSuchProviderException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkServerTrusted NoSuchProviderException: ");
      stringBuilder.append(noSuchProviderException.getMessage());
      g.d("WebViewX509TrustManger", stringBuilder.toString());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkServerTrusted NoSuchAlgorithmException: ");
      stringBuilder.append(noSuchAlgorithmException.getMessage());
      g.d("WebViewX509TrustManger", stringBuilder.toString());
    } catch (InvalidKeyException invalidKeyException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkServerTrusted InvalidKeyException: ");
      stringBuilder.append(invalidKeyException.getMessage());
      g.d("WebViewX509TrustManger", stringBuilder.toString());
    } catch (SignatureException signatureException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkServerTrusted SignatureException: ");
      stringBuilder.append(signatureException.getMessage());
      g.d("WebViewX509TrustManger", stringBuilder.toString());
    } catch (CertificateException certificateException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkServerTrusted CertificateException: ");
      stringBuilder.append(certificateException.getMessage());
      g.d("WebViewX509TrustManger", stringBuilder.toString());
    } 
    if (bool)
      return; 
    throw certificateException;
  }
  
  public X509Certificate[] getAcceptedIssuers() {
    try {
      ArrayList arrayList = new ArrayList();
      Iterator<X509TrustManager> iterator = this.b.iterator();
      while (iterator.hasNext())
        arrayList.addAll(Arrays.asList(((X509TrustManager)iterator.next()).getAcceptedIssuers())); 
      return (X509Certificate[])arrayList.toArray((Object[])new X509Certificate[arrayList.size()]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getAcceptedIssuers exception : ");
      stringBuilder.append(exception.getMessage());
      g.d("WebViewX509TrustManger", stringBuilder.toString());
      return new X509Certificate[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */