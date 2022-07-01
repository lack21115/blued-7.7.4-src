package com.huawei.updatesdk.a.a.a;

import android.content.Context;
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

public class d extends SSLSocketFactory {
  private static volatile d b;
  
  private SSLContext a = null;
  
  private d(Context paramContext) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
    this.a = c.a();
    e e = new e(paramContext);
    this.a.init(null, (TrustManager[])new X509TrustManager[] { e }, null);
  }
  
  public static d a(Context paramContext) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
    // Byte code:
    //   0: getstatic com/huawei/updatesdk/a/a/a/d.b : Lcom/huawei/updatesdk/a/a/a/d;
    //   3: ifnonnull -> 38
    //   6: ldc com/huawei/updatesdk/a/a/a/d
    //   8: monitorenter
    //   9: getstatic com/huawei/updatesdk/a/a/a/d.b : Lcom/huawei/updatesdk/a/a/a/d;
    //   12: ifnonnull -> 26
    //   15: new com/huawei/updatesdk/a/a/a/d
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/huawei/updatesdk/a/a/a/d.b : Lcom/huawei/updatesdk/a/a/a/d;
    //   26: ldc com/huawei/updatesdk/a/a/a/d
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/huawei/updatesdk/a/a/a/d
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/huawei/updatesdk/a/a/a/d.b : Lcom/huawei/updatesdk/a/a/a/d;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException {
    Socket socket = this.a.getSocketFactory().createSocket(paramString, paramInt);
    if (socket instanceof SSLSocket)
      c.c((SSLSocket)socket); 
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
    paramSocket = this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if (paramSocket instanceof SSLSocket)
      c.c((SSLSocket)paramSocket); 
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites() {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites() {
    return new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */