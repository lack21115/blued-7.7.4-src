package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
  public static final X509HostnameVerifier a = (X509HostnameVerifier)new BrowserCompatHostnameVerifier();
  
  public static final X509HostnameVerifier b = (X509HostnameVerifier)new StrictHostnameVerifier();
  
  private static final String c = SecureApacheSSLSocketFactory.class.getSimpleName();
  
  private static volatile SecureApacheSSLSocketFactory d = null;
  
  private SSLContext e = SSLUtil.a();
  
  private SSLSocket f = null;
  
  private Context g;
  
  private String[] h;
  
  private X509TrustManager i;
  
  private String[] j;
  
  private String[] k;
  
  private String[] l;
  
  public SecureApacheSSLSocketFactory(KeyStore paramKeyStore, X509TrustManager paramX509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
    super(paramKeyStore);
    b(paramX509TrustManager);
    this.e.init(null, (TrustManager[])new X509TrustManager[] { paramX509TrustManager }, null);
  }
  
  private void a(Socket paramSocket) {
    boolean bool1;
    boolean bool = a.a(this.l);
    boolean bool2 = true;
    if (!bool) {
      g.b(c, "set protocols");
      SSLUtil.c((SSLSocket)paramSocket, this.l);
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (!a.a(this.k) || !a.a(this.j)) {
      g.b(c, "set white cipher or black cipher");
      SSLSocket sSLSocket = (SSLSocket)paramSocket;
      SSLUtil.d(sSLSocket);
      if (!a.a(this.k)) {
        SSLUtil.a(sSLSocket, this.k);
      } else {
        SSLUtil.b(sSLSocket, this.j);
      } 
    } else {
      bool2 = false;
    } 
    if (!bool1) {
      g.b(c, "set default protocols");
      SSLUtil.d((SSLSocket)paramSocket);
    } 
    if (!bool2) {
      g.b(c, "set default cipher suites");
      SSLUtil.a((SSLSocket)paramSocket);
    } 
  }
  
  static void a(X509TrustManager paramX509TrustManager) {
    g.b(c, "sasf update socket factory trust manager");
    try {
      d = new SecureApacheSSLSocketFactory(null, paramX509TrustManager);
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      g.d(c, "NoSuchAlgorithmException");
      return;
    } catch (KeyManagementException keyManagementException) {
      g.d(c, "KeyManagementException");
      return;
    } catch (UnrecoverableKeyException unrecoverableKeyException) {
      g.d(c, "UnrecoverableKeyException");
      return;
    } catch (KeyStoreException keyStoreException) {
      g.d(c, "KeyStoreException");
      return;
    } catch (CertificateException certificateException) {
      g.d(c, "CertificateException");
      return;
    } catch (IOException iOException) {
      g.d(c, "IOException");
      return;
    } 
  }
  
  public void a(Context paramContext) {
    this.g = paramContext.getApplicationContext();
  }
  
  public void b(X509TrustManager paramX509TrustManager) {
    this.i = paramX509TrustManager;
  }
  
  public Socket createSocket() throws IOException {
    g.b(c, "createSocket: ");
    Socket socket = this.e.getSocketFactory().createSocket();
    if (socket instanceof SSLSocket) {
      a(socket);
      this.f = (SSLSocket)socket;
      this.h = (String[])this.f.getEnabledCipherSuites().clone();
    } 
    return socket;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    g.b(c, "createSocket: socket host port autoClose");
    paramSocket = this.e.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if (paramSocket instanceof SSLSocket) {
      a(paramSocket);
      this.f = (SSLSocket)paramSocket;
      this.h = (String[])this.f.getEnabledCipherSuites().clone();
    } 
    return paramSocket;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\SecureApacheSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */