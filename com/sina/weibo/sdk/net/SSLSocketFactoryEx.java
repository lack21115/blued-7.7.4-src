package com.sina.weibo.sdk.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SSLSocketFactoryEx extends SSLSocketFactory {
  private static final String TAG = SSLSocketFactoryEx.class.getName();
  
  SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public SSLSocketFactoryEx(KeyStore paramKeyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
    super(paramKeyStore);
    this.sslContext.init(null, new TrustManager[] { new KeyStoresTrustManagerEX(new KeyStore[] { paramKeyStore }, ) }, null);
  }
  
  public Socket createSocket() throws IOException {
    return this.sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException, UnknownHostException {
    return this.sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public static class KeyStoresTrustManagerEX implements X509TrustManager {
    protected ArrayList<X509TrustManager> x509TrustManagers = new ArrayList<X509TrustManager>();
    
    protected KeyStoresTrustManagerEX(KeyStore... param1VarArgs) {
      ArrayList<TrustManagerFactory> arrayList = new ArrayList();
      try {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore)null);
        arrayList.add(trustManagerFactory);
        int j = param1VarArgs.length;
        for (int i = 0;; i++) {
          Iterator<TrustManagerFactory> iterator1;
          if (i >= j) {
            iterator1 = arrayList.iterator();
            while (true) {
              if (!iterator1.hasNext()) {
                if (this.x509TrustManagers.size() != 0)
                  return; 
                throw new RuntimeException("Couldn't find any X509TrustManagers");
              } 
              for (TrustManager trustManager : ((TrustManagerFactory)iterator1.next()).getTrustManagers()) {
                if (trustManager instanceof X509TrustManager)
                  this.x509TrustManagers.add((X509TrustManager)trustManager); 
              } 
            } 
            break;
          } 
          Iterator<TrustManagerFactory> iterator2 = iterator1[i];
          TrustManagerFactory trustManagerFactory1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
          trustManagerFactory1.init((KeyStore)iterator2);
          arrayList.add(trustManagerFactory1);
        } 
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      } 
    }
    
    public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
      ((X509TrustManager)this.x509TrustManagers.get(0)).checkClientTrusted(param1ArrayOfX509Certificate, param1String);
    }
    
    public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
      Iterator<X509TrustManager> iterator = this.x509TrustManagers.iterator();
      while (true) {
        if (iterator.hasNext()) {
          X509TrustManager x509TrustManager = iterator.next();
          try {
            x509TrustManager.checkServerTrusted(param1ArrayOfX509Certificate, param1String);
            return;
          } catch (CertificateException certificateException) {
            continue;
          } 
        } 
        throw new CertificateException();
      } 
    }
    
    public X509Certificate[] getAcceptedIssuers() {
      ArrayList arrayList = new ArrayList();
      Iterator<X509TrustManager> iterator = this.x509TrustManagers.iterator();
      while (true) {
        if (!iterator.hasNext())
          return (X509Certificate[])arrayList.toArray((Object[])new X509Certificate[arrayList.size()]); 
        arrayList.addAll(Arrays.asList(((X509TrustManager)iterator.next()).getAcceptedIssuers()));
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\SSLSocketFactoryEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */