package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class d implements X509TrustManager {
  protected List<X509TrustManager> a = new ArrayList<X509TrustManager>();
  
  public d(Context paramContext, String paramString) {
    if (paramContext != null && paramString != null) {
      InputStream inputStream2 = null;
      InputStream inputStream1 = inputStream2;
      try {
        int i;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        inputStream1 = inputStream2;
        KeyStore keyStore = KeyStore.getInstance("bks");
        inputStream1 = inputStream2;
        InputStream inputStream = paramContext.getAssets().open(paramString);
        inputStream1 = inputStream;
        inputStream.reset();
        inputStream1 = inputStream;
        keyStore.load(inputStream, "".toCharArray());
        inputStream1 = inputStream;
        trustManagerFactory.init(keyStore);
        inputStream1 = inputStream;
        TrustManager[] arrayOfTrustManager = trustManagerFactory.getTrustManagers();
      } finally {
        IoUtils.closeSecure(inputStream1);
      } 
    } 
    throw new IllegalArgumentException("context or trust file is null");
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {
    if (!this.a.isEmpty()) {
      ((X509TrustManager)this.a.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    } 
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {
    if (!this.a.isEmpty()) {
      ((X509TrustManager)this.a.get(0)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    } 
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public X509Certificate[] getAcceptedIssuers() {
    try {
      ArrayList arrayList = new ArrayList();
      Iterator<X509TrustManager> iterator = this.a.iterator();
      while (iterator.hasNext())
        arrayList.addAll(Arrays.asList(((X509TrustManager)iterator.next()).getAcceptedIssuers())); 
      return (X509Certificate[])arrayList.toArray((Object[])new X509Certificate[arrayList.size()]);
    } catch (Exception exception) {
      Logger.w("SecureX509TrustManager", "getAcceptedIssuers exception");
      return new X509Certificate[0];
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */