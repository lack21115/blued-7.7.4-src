package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import android.util.Log;
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

public class e implements X509TrustManager {
  protected List<X509TrustManager> a = new ArrayList<X509TrustManager>();
  
  public e(Context paramContext) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
    if (paramContext != null) {
      IOException iOException;
      InputStream inputStream2 = null;
      InputStream inputStream1 = inputStream2;
      try {
        int i;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        inputStream1 = inputStream2;
        KeyStore keyStore = KeyStore.getInstance("bks");
        inputStream1 = inputStream2;
        InputStream inputStream = paramContext.getAssets().open("updatesdkcas.bks");
        inputStream1 = inputStream;
        inputStream.reset();
        inputStream1 = inputStream;
        keyStore.load(inputStream, "".toCharArray());
        inputStream1 = inputStream;
        trustManagerFactory.init(keyStore);
        inputStream1 = inputStream;
        TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
      } finally {
        if (iOException != null)
          try {
            iOException.close();
          } catch (IOException iOException1) {
            Log.e("SecureX509TrustManager", "close bks exception");
          }  
      } 
    } 
    throw new IllegalArgumentException("context is null");
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    Log.i("SecureX509TrustManager", "checkClientTrusted: ");
    for (X509TrustManager x509TrustManager : this.a) {
      try {
        x509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      } catch (CertificateException certificateException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkServerTrusted CertificateException");
        stringBuilder.append(certificateException.getMessage());
        Log.e("SecureX509TrustManager", stringBuilder.toString());
      } 
    } 
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    int j = this.a.size();
    int i = 0;
    while (i < j) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkServerTrusted: check server i : ");
        stringBuilder.append(i);
        Log.i("SecureX509TrustManager", stringBuilder.toString());
        ((X509TrustManager)this.a.get(i)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      } catch (CertificateException certificateException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkServerTrusted error :");
        stringBuilder.append(certificateException.getMessage());
        stringBuilder.append(" , time : ");
        stringBuilder.append(i);
        Log.e("SecureX509TrustManager", stringBuilder.toString());
        if (i == j - 1) {
          if (paramArrayOfX509Certificate != null && paramArrayOfX509Certificate.length > 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("root ca issuer : ");
            stringBuilder1.append(paramArrayOfX509Certificate[paramArrayOfX509Certificate.length - 1].getIssuerDN());
            Log.e("SecureX509TrustManager", stringBuilder1.toString());
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
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getAcceptedIssuers exception : ");
      stringBuilder.append(exception.getMessage());
      Log.e("SecureX509TrustManager", stringBuilder.toString());
      return new X509Certificate[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */