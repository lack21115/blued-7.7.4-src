package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSFCompatiableSystemCA extends SSLSocketFactory {
  private static final String a = SSFCompatiableSystemCA.class.getSimpleName();
  
  private static volatile SSFCompatiableSystemCA b = null;
  
  private SSLContext c = null;
  
  private SSLSocket d = null;
  
  private String[] e;
  
  private X509TrustManager f;
  
  private String[] g;
  
  private String[] h;
  
  private String[] i;
  
  public SSFCompatiableSystemCA(X509TrustManager paramX509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    this.c = SSLUtil.a();
    b(paramX509TrustManager);
    this.c.init(null, (TrustManager[])new X509TrustManager[] { paramX509TrustManager }, null);
  }
  
  private void a(Socket paramSocket) {
    boolean bool1;
    boolean bool = a.a(this.i);
    boolean bool2 = true;
    if (!bool) {
      g.b(a, "set protocols");
      SSLUtil.c((SSLSocket)paramSocket, this.i);
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (!a.a(this.h) || !a.a(this.g)) {
      g.b(a, "set white cipher or black cipher");
      SSLSocket sSLSocket = (SSLSocket)paramSocket;
      SSLUtil.d(sSLSocket);
      if (!a.a(this.h)) {
        SSLUtil.a(sSLSocket, this.h);
      } else {
        SSLUtil.b(sSLSocket, this.g);
      } 
    } else {
      bool2 = false;
    } 
    if (!bool1) {
      g.b(a, "set default protocols");
      SSLUtil.d((SSLSocket)paramSocket);
    } 
    if (!bool2) {
      g.b(a, "set default cipher suites");
      SSLUtil.a((SSLSocket)paramSocket);
    } 
  }
  
  static void a(X509TrustManager paramX509TrustManager) {
    g.b(a, "ssfc update socket factory trust manager");
    try {
      b = new SSFCompatiableSystemCA(paramX509TrustManager);
      return;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      g.d(a, "NoSuchAlgorithmException");
      return;
    } catch (KeyManagementException keyManagementException) {
      g.d(a, "KeyManagementException");
      return;
    } 
  }
  
  public void b(X509TrustManager paramX509TrustManager) {
    this.f = paramX509TrustManager;
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException {
    g.b(a, "createSocket: host , port");
    Socket socket = this.c.getSocketFactory().createSocket(paramString, paramInt);
    if (socket instanceof SSLSocket) {
      a(socket);
      this.d = (SSLSocket)socket;
      this.e = (String[])this.d.getEnabledCipherSuites().clone();
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
    g.b(a, "createSocket: s , host , port , autoClose");
    paramSocket = this.c.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if (paramSocket instanceof SSLSocket) {
      a(paramSocket);
      this.d = (SSLSocket)paramSocket;
      this.e = (String[])this.d.getEnabledCipherSuites().clone();
    } 
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites() {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites() {
    String[] arrayOfString = this.e;
    return (arrayOfString != null) ? arrayOfString : new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\SSFCompatiableSystemCA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */