package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureSSLSocketFactory extends SSLSocketFactory {
  @Deprecated
  public static final X509HostnameVerifier a = (X509HostnameVerifier)new BrowserCompatHostnameVerifier();
  
  @Deprecated
  public static final X509HostnameVerifier b = (X509HostnameVerifier)new StrictHostnameVerifier();
  
  private static final String c = SecureSSLSocketFactory.class.getSimpleName();
  
  private static volatile SecureSSLSocketFactory d = null;
  
  private SSLContext e = null;
  
  private SSLSocket f = null;
  
  private Context g;
  
  private String[] h;
  
  private X509TrustManager i;
  
  private String[] j;
  
  private String[] k;
  
  private String[] l;
  
  private SecureSSLSocketFactory(Context paramContext) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
    if (paramContext == null) {
      g.d(c, "SecureSSLSocketFactory: context is null");
      return;
    } 
    b(paramContext);
    a(SSLUtil.a());
    this.i = SecureX509SingleInstance.a(paramContext);
    this.e.init(null, (TrustManager[])new X509TrustManager[] { this.i }, null);
  }
  
  public SecureSSLSocketFactory(X509TrustManager paramX509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    this.e = SSLUtil.a();
    b(paramX509TrustManager);
    this.e.init(null, (TrustManager[])new X509TrustManager[] { paramX509TrustManager }, null);
  }
  
  public static SecureSSLSocketFactory a(Context paramContext) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Landroid/content/Context;)V
    //   4: getstatic com/huawei/secure/android/common/ssl/SecureSSLSocketFactory.d : Lcom/huawei/secure/android/common/ssl/SecureSSLSocketFactory;
    //   7: ifnonnull -> 42
    //   10: ldc com/huawei/secure/android/common/ssl/SecureSSLSocketFactory
    //   12: monitorenter
    //   13: getstatic com/huawei/secure/android/common/ssl/SecureSSLSocketFactory.d : Lcom/huawei/secure/android/common/ssl/SecureSSLSocketFactory;
    //   16: ifnonnull -> 30
    //   19: new com/huawei/secure/android/common/ssl/SecureSSLSocketFactory
    //   22: dup
    //   23: aload_0
    //   24: invokespecial <init> : (Landroid/content/Context;)V
    //   27: putstatic com/huawei/secure/android/common/ssl/SecureSSLSocketFactory.d : Lcom/huawei/secure/android/common/ssl/SecureSSLSocketFactory;
    //   30: ldc com/huawei/secure/android/common/ssl/SecureSSLSocketFactory
    //   32: monitorexit
    //   33: goto -> 42
    //   36: astore_0
    //   37: ldc com/huawei/secure/android/common/ssl/SecureSSLSocketFactory
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: getstatic com/huawei/secure/android/common/ssl/SecureSSLSocketFactory.d : Lcom/huawei/secure/android/common/ssl/SecureSSLSocketFactory;
    //   45: getfield g : Landroid/content/Context;
    //   48: ifnonnull -> 62
    //   51: aload_0
    //   52: ifnull -> 62
    //   55: getstatic com/huawei/secure/android/common/ssl/SecureSSLSocketFactory.d : Lcom/huawei/secure/android/common/ssl/SecureSSLSocketFactory;
    //   58: aload_0
    //   59: invokevirtual b : (Landroid/content/Context;)V
    //   62: getstatic com/huawei/secure/android/common/ssl/SecureSSLSocketFactory.d : Lcom/huawei/secure/android/common/ssl/SecureSSLSocketFactory;
    //   65: areturn
    // Exception table:
    //   from	to	target	type
    //   13	30	36	finally
    //   30	33	36	finally
    //   37	40	36	finally
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
    g.b(c, "ssf update socket factory trust manager");
    try {
      d = new SecureSSLSocketFactory(paramX509TrustManager);
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      g.d(c, "NoSuchAlgorithmException");
      return;
    } catch (KeyManagementException keyManagementException) {
      g.d(c, "KeyManagementException");
      return;
    } 
  }
  
  public void a(SSLContext paramSSLContext) {
    this.e = paramSSLContext;
  }
  
  public void b(Context paramContext) {
    this.g = paramContext.getApplicationContext();
  }
  
  public void b(X509TrustManager paramX509TrustManager) {
    this.i = paramX509TrustManager;
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException {
    g.b(c, "createSocket: host , port");
    Socket socket = this.e.getSocketFactory().createSocket(paramString, paramInt);
    if (socket instanceof SSLSocket) {
      a(socket);
      this.f = (SSLSocket)socket;
      this.h = (String[])this.f.getEnabledCipherSuites().clone();
    } 
    return socket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    g.b(c, "createSocket s host port autoClose");
    paramSocket = this.e.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if (paramSocket instanceof SSLSocket) {
      a(paramSocket);
      this.f = (SSLSocket)paramSocket;
      this.h = (String[])this.f.getEnabledCipherSuites().clone();
    } 
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites() {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites() {
    String[] arrayOfString = this.h;
    return (arrayOfString != null) ? arrayOfString : new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\SecureSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */