package com.huawei.secure.android.common;

import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
  public static final X509HostnameVerifier a = (X509HostnameVerifier)new BrowserCompatHostnameVerifier();
  
  public static final X509HostnameVerifier b = (X509HostnameVerifier)new StrictHostnameVerifier();
  
  private static volatile SecureApacheSSLSocketFactory c = null;
  
  private SSLContext d;
  
  private void a(Socket paramSocket) {
    paramSocket = paramSocket;
    SSLUtil.d((SSLSocket)paramSocket);
    SSLUtil.a((SSLSocket)paramSocket);
  }
  
  public Socket createSocket() throws IOException {
    Socket socket = this.d.getSocketFactory().createSocket();
    a(socket);
    return socket;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    paramSocket = this.d.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket);
    return paramSocket;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\SecureApacheSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */