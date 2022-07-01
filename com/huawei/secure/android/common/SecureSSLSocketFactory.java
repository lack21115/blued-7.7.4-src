package com.huawei.secure.android.common;

import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class SecureSSLSocketFactory extends SSLSocketFactory {
  public static final X509HostnameVerifier a = (X509HostnameVerifier)new BrowserCompatHostnameVerifier();
  
  public static final X509HostnameVerifier b = (X509HostnameVerifier)new StrictHostnameVerifier();
  
  private static volatile SecureSSLSocketFactory c = null;
  
  private SSLContext d;
  
  private void a(Socket paramSocket) {
    paramSocket = paramSocket;
    SSLUtil.d((SSLSocket)paramSocket);
    SSLUtil.a((SSLSocket)paramSocket);
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException {
    Socket socket = this.d.getSocketFactory().createSocket(paramString, paramInt);
    if (socket instanceof SSLSocket)
      a(socket); 
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
    paramSocket = this.d.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if (paramSocket instanceof SSLSocket)
      a(paramSocket); 
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites() {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites() {
    return new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\SecureSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */