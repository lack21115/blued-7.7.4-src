package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SecureX509TrustManager implements X509TrustManager {
  private static final String b = SecureX509TrustManager.class.getSimpleName();
  
  protected List<X509TrustManager> a = new ArrayList<X509TrustManager>();
  
  private X509Certificate[] c;
  
  public SecureX509TrustManager(InputStream paramInputStream, String paramString) throws IllegalArgumentException {
    a(paramInputStream, paramString);
  }
  
  public SecureX509TrustManager(InputStream paramInputStream, String paramString, boolean paramBoolean) throws IllegalArgumentException {
    a(paramInputStream, paramString);
    if (paramBoolean)
      a(); 
  }
  
  private void a() {
    g.b(b, "loadSystemCA");
    try {
      KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
      keyStore.load(null, null);
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
      trustManagerFactory.init(keyStore);
      TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
      for (int i = 0; i < arrayOfTrustManager.length; i++) {
        if (arrayOfTrustManager[i] instanceof X509TrustManager)
          this.a.add((X509TrustManager)arrayOfTrustManager[i]); 
      } 
    } catch (KeyStoreException keyStoreException) {
      String str = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadSystemCA: exception : ");
      stringBuilder.append(keyStoreException.getMessage());
      g.d(str, stringBuilder.toString());
    } catch (CertificateException certificateException) {
    
    } catch (IOException iOException) {
    
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
  }
  
  private void a(InputStream paramInputStream, String paramString) {
    if (paramInputStream != null && paramString != null) {
      try {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        KeyStore keyStore = KeyStore.getInstance("bks");
        keyStore.load(paramInputStream, paramString.toCharArray());
        trustManagerFactory.init(keyStore);
        TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
        for (int i = 0; i < arrayOfTrustManager.length; i++) {
          if (arrayOfTrustManager[i] instanceof X509TrustManager)
            this.a.add((X509TrustManager)arrayOfTrustManager[i]); 
        } 
      } catch (KeyStoreException keyStoreException) {
        String str = b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadInputStream: exception : ");
        stringBuilder.append(keyStoreException.getMessage());
        g.d(str, stringBuilder.toString());
      } catch (CertificateException certificateException) {
      
      } catch (IOException iOException) {
      
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      
      } finally {}
      f.a(paramInputStream);
      return;
    } 
    throw new IllegalArgumentException("inputstream or trustPwd is null");
  }
  
  public void a(X509Certificate[] paramArrayOfX509Certificate) {
    this.c = paramArrayOfX509Certificate;
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    g.b(b, "checkClientTrusted: ");
    for (X509TrustManager x509TrustManager : this.a) {
      try {
        x509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      } catch (CertificateException certificateException) {
        String str = b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkServerTrusted CertificateException");
        stringBuilder.append(certificateException.getMessage());
        g.d(str, stringBuilder.toString());
      } 
    } 
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    a(paramArrayOfX509Certificate);
    String str = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkServerTrusted begin ,server ca chain size is : ");
    stringBuilder.append(paramArrayOfX509Certificate.length);
    stringBuilder.append(" ,auth type is : ");
    stringBuilder.append(paramString);
    g.b(str, stringBuilder.toString());
    int j = paramArrayOfX509Certificate.length;
    int i;
    for (i = 0; i < j; i++) {
      X509Certificate x509Certificate = paramArrayOfX509Certificate[i];
      String str1 = b;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("server ca chain: getSubjectDN is :");
      stringBuilder1.append(x509Certificate.getSubjectDN());
      stringBuilder1.append(" , getIssuerDN :");
      stringBuilder1.append(x509Certificate.getIssuerDN());
      g.a(str1, stringBuilder1.toString());
      str1 = b;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("server ca chain is :");
      stringBuilder1.append(x509Certificate);
      g.a(str1, stringBuilder1.toString());
    } 
    int k = this.a.size();
    i = 0;
    while (i < k) {
      try {
        str = b;
        stringBuilder = new StringBuilder();
        stringBuilder.append("check server i : ");
        stringBuilder.append(i);
        g.b(str, stringBuilder.toString());
        X509TrustManager x509TrustManager = this.a.get(i);
        X509Certificate[] arrayOfX509Certificate = x509TrustManager.getAcceptedIssuers();
        if (arrayOfX509Certificate != null) {
          String str2 = b;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("client root ca size is : ");
          stringBuilder2.append(arrayOfX509Certificate.length);
          g.b(str2, stringBuilder2.toString());
          for (j = 0; j < arrayOfX509Certificate.length; j++) {
            str2 = b;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("client root ca getIssuerDN :");
            stringBuilder2.append(arrayOfX509Certificate[j].getIssuerDN());
            g.a(str2, stringBuilder2.toString());
          } 
        } 
        x509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        String str1 = b;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("checkServerTrusted succeed ,root ca issuer is : ");
        stringBuilder1.append(paramArrayOfX509Certificate[paramArrayOfX509Certificate.length - 1].getIssuerDN());
        g.b(str1, stringBuilder1.toString());
        return;
      } catch (CertificateException certificateException) {
        String str1 = b;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("checkServerTrusted error :");
        stringBuilder1.append(certificateException.getMessage());
        stringBuilder1.append(" , time : ");
        stringBuilder1.append(i);
        g.d(str1, stringBuilder1.toString());
        if (i == k - 1) {
          if (paramArrayOfX509Certificate != null && paramArrayOfX509Certificate.length > 0) {
            paramString = b;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("root ca issuer : ");
            stringBuilder2.append(paramArrayOfX509Certificate[paramArrayOfX509Certificate.length - 1].getIssuerDN());
            g.d(paramString, stringBuilder2.toString());
          } 
          throw certificateException;
        } 
        i++;
      } 
    } 
  }
  
  public X509Certificate[] getAcceptedIssuers() {
    try {
      ArrayList arrayList = new ArrayList();
      Iterator<X509TrustManager> iterator = this.a.iterator();
      while (iterator.hasNext())
        arrayList.addAll(Arrays.asList(((X509TrustManager)iterator.next()).getAcceptedIssuers())); 
      return (X509Certificate[])arrayList.toArray((Object[])new X509Certificate[arrayList.size()]);
    } catch (Exception exception) {
      String str = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getAcceptedIssuers exception : ");
      stringBuilder.append(exception.getMessage());
      g.d(str, stringBuilder.toString());
      return new X509Certificate[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\SecureX509TrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */