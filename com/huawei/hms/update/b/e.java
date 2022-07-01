package com.huawei.hms.update.b;

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
    if (!this.a.isEmpty()) {
      ((X509TrustManager)this.a.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    } 
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
    if (!this.a.isEmpty()) {
      ((X509TrustManager)this.a.get(0)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    } 
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public X509Certificate[] getAcceptedIssuers() {
    ArrayList arrayList = new ArrayList();
    Iterator<X509TrustManager> iterator = this.a.iterator();
    while (iterator.hasNext())
      arrayList.addAll(Arrays.asList(((X509TrustManager)iterator.next()).getAcceptedIssuers())); 
    return (X509Certificate[])arrayList.toArray((Object[])new X509Certificate[arrayList.size()]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */