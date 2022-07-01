package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class c extends SSLSocketFactory {
  public static final X509HostnameVerifier a = (X509HostnameVerifier)new BrowserCompatHostnameVerifier();
  
  public static final X509HostnameVerifier b = (X509HostnameVerifier)new StrictHostnameVerifier();
  
  private static volatile c c = null;
  
  private static String[] d = null;
  
  private SSLContext e = null;
  
  private Context f;
  
  private c(Context paramContext, String paramString) {
    this.f = paramContext;
    this.e = b.a();
    d d = new d(this.f, paramString);
    this.e.init(null, (TrustManager[])new X509TrustManager[] { d }, null);
  }
  
  public static c a(Context paramContext, String paramString) {
    // Byte code:
    //   0: getstatic com/huawei/hms/framework/network/grs/d/b/c.c : Lcom/huawei/hms/framework/network/grs/d/b/c;
    //   3: ifnonnull -> 39
    //   6: ldc com/huawei/hms/framework/network/grs/d/b/c
    //   8: monitorenter
    //   9: getstatic com/huawei/hms/framework/network/grs/d/b/c.c : Lcom/huawei/hms/framework/network/grs/d/b/c;
    //   12: ifnonnull -> 27
    //   15: new com/huawei/hms/framework/network/grs/d/b/c
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   24: putstatic com/huawei/hms/framework/network/grs/d/b/c.c : Lcom/huawei/hms/framework/network/grs/d/b/c;
    //   27: ldc com/huawei/hms/framework/network/grs/d/b/c
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/huawei/hms/framework/network/grs/d/b/c
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/huawei/hms/framework/network/grs/d/b/c.c : Lcom/huawei/hms/framework/network/grs/d/b/c;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  public Socket createSocket(String paramString, int paramInt) {
    Socket socket = this.e.getSocketFactory().createSocket(paramString, paramInt);
    if (socket instanceof SSLSocket)
      b.d((SSLSocket)socket); 
    return socket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) {
    paramSocket = this.e.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if (paramSocket instanceof SSLSocket)
      b.d((SSLSocket)paramSocket); 
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites() {
    String[] arrayOfString = d;
    return (arrayOfString != null) ? (String[])arrayOfString.clone() : new String[0];
  }
  
  public String[] getSupportedCipherSuites() {
    return new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */