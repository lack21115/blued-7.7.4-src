package com.blued.android.core.net.http.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class InternalSSLSocketFactoryDefault extends SSLSocketFactory {
  private final SSLSocketFactory a;
  
  private final SSLContext b;
  
  private final String[] c = new String[] { "TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3" };
  
  public InternalSSLSocketFactoryDefault(SSLContext paramSSLContext) {
    this.b = paramSSLContext;
    this.a = paramSSLContext.getSocketFactory();
  }
  
  private Socket a(Socket paramSocket) {
    if (paramSocket instanceof SSLSocket)
      ((SSLSocket)paramSocket).setEnabledProtocols(this.c); 
    return paramSocket;
  }
  
  public Socket createSocket() throws IOException {
    return a(this.a.createSocket());
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException {
    return a(this.a.createSocket(paramString, paramInt));
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException {
    return a(this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    return a(this.a.createSocket(paramInetAddress, paramInt));
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    return a(this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    return a(this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public String[] getDefaultCipherSuites() {
    return this.a.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites() {
    return this.a.getSupportedCipherSuites();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\ssl\InternalSSLSocketFactoryDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */