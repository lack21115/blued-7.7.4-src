package com.bytedance.sdk.adnet.d;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class h extends SSLSocketFactory {
  public static final X509TrustManager a = new X509TrustManager() {
      public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
      
      public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
      
      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    };
  
  private static final String[] b;
  
  private SSLSocketFactory c;
  
  public h() {
    try {
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      X509TrustManager x509TrustManager = a;
      SecureRandom secureRandom = new SecureRandom();
      sSLContext.init(null, new TrustManager[] { x509TrustManager }, secureRandom);
      this.c = sSLContext.getSocketFactory();
      return;
    } catch (Exception exception) {
      Log.e("TLSSocketFactory", "TLSSocketFactory error: ", exception);
      return;
    } 
  }
  
  private static void a(Socket paramSocket) {
    if (paramSocket instanceof SSLSocket)
      ((SSLSocket)paramSocket).setEnabledProtocols(b); 
  }
  
  public Socket createSocket() throws IOException {
    SSLSocketFactory sSLSocketFactory = this.c;
    if (sSLSocketFactory != null) {
      Socket socket = sSLSocketFactory.createSocket();
      a(socket);
      return socket;
    } 
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException {
    SSLSocketFactory sSLSocketFactory = this.c;
    if (sSLSocketFactory != null) {
      Socket socket = sSLSocketFactory.createSocket(paramString, paramInt);
      a(socket);
      return socket;
    } 
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException {
    SSLSocketFactory sSLSocketFactory = this.c;
    if (sSLSocketFactory != null) {
      Socket socket = sSLSocketFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
      a(socket);
      return socket;
    } 
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    SSLSocketFactory sSLSocketFactory = this.c;
    if (sSLSocketFactory != null) {
      Socket socket = sSLSocketFactory.createSocket(paramInetAddress, paramInt);
      a(socket);
      return socket;
    } 
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    SSLSocketFactory sSLSocketFactory = this.c;
    if (sSLSocketFactory != null) {
      Socket socket = sSLSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
      a(socket);
      return socket;
    } 
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    SSLSocketFactory sSLSocketFactory = this.c;
    if (sSLSocketFactory != null) {
      paramSocket = sSLSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
      a(paramSocket);
      return paramSocket;
    } 
    return null;
  }
  
  public String[] getDefaultCipherSuites() {
    SSLSocketFactory sSLSocketFactory = this.c;
    return (sSLSocketFactory != null) ? sSLSocketFactory.getDefaultCipherSuites() : null;
  }
  
  public String[] getSupportedCipherSuites() {
    SSLSocketFactory sSLSocketFactory = this.c;
    return (sSLSocketFactory != null) ? sSLSocketFactory.getSupportedCipherSuites() : null;
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 26) {
      b = new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" };
    } else if (Build.VERSION.SDK_INT >= 16) {
      b = new String[] { "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" };
    } else {
      b = new String[] { "SSLv3", "TLSv1" };
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */