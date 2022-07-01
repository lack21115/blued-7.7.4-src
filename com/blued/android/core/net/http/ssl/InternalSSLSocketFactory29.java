package com.blued.android.core.net.http.ssl;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.blued.android.core.AppInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;

public class InternalSSLSocketFactory29 extends SSLSocketFactory {
  public Socket createSocket() throws IOException {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    try {
      String str = HttpsIPAccessUtils.a(paramString);
      SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(AppInfo.d()));
      paramSocket = sSLCertificateSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
      return paramSocket;
    } finally {
      paramSocket = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createSocket exception: ");
      stringBuilder.append(paramSocket);
    } 
  }
  
  public String[] getDefaultCipherSuites() {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites() {
    return new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\ssl\InternalSSLSocketFactory29.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */