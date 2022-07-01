package com.huawei.hms.update.b;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

final class f extends SSLSocketFactory {
  private static final String[] a = new String[] { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA" };
  
  private static final String[] b = new String[] { "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" };
  
  private static final String[] c = new String[] { 
      "TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", 
      "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  
  private static final Object d = new Object();
  
  private static SocketFactory e;
  
  private final SSLContext f;
  
  private Context g;
  
  private f(Context paramContext) throws NoSuchAlgorithmException, KeyManagementException, CertificateException, KeyStoreException, IOException {
    this.g = paramContext;
    this.f = SSLContext.getInstance("TLSv1.2");
    e e = new e(this.g);
    this.f.init(null, (TrustManager[])new X509TrustManager[] { e }, null);
  }
  
  public static SocketFactory a(Context paramContext) {
    synchronized (d) {
      if (e == null)
        e = new f(paramContext); 
      return e;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to new TLSSocketFactory instance.");
    stringBuilder.append(paramContext.getMessage());
    HMSLog.e("TLSSocketFactory", stringBuilder.toString());
    SocketFactory socketFactory = SSLSocketFactory.getDefault();
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_1} */
    return socketFactory;
  }
  
  private void a(Socket paramSocket) {
    if (paramSocket instanceof SSLSocket) {
      paramSocket = paramSocket;
      c((SSLSocket)paramSocket);
      b((SSLSocket)paramSocket);
    } 
  }
  
  private static void a(SSLSocket paramSSLSocket, String[] paramArrayOfString) {
    if (paramSSLSocket != null) {
      if (paramArrayOfString == null)
        return; 
      String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
      ArrayList<String> arrayList = new ArrayList();
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        String str1 = arrayOfString[i];
        String str2 = str1.toUpperCase(Locale.ENGLISH);
        int m = paramArrayOfString.length;
        int k = 0;
        while (true) {
          if (k < m) {
            if (str2.contains(paramArrayOfString[k].toUpperCase(Locale.ENGLISH))) {
              k = 1;
              break;
            } 
            k++;
            continue;
          } 
          k = 0;
          break;
        } 
        if (k == 0)
          arrayList.add(str1); 
      } 
      if (!arrayList.isEmpty())
        paramSSLSocket.setEnabledCipherSuites(arrayList.<String>toArray(new String[arrayList.size()])); 
    } 
  }
  
  private static boolean a(SSLSocket paramSSLSocket) {
    return (paramSSLSocket == null) ? false : ((Build.VERSION.SDK_INT > 19) ? b(paramSSLSocket, b) : b(paramSSLSocket, a));
  }
  
  private static void b(SSLSocket paramSSLSocket) {
    if (paramSSLSocket == null)
      return; 
    if (!a(paramSSLSocket))
      a(paramSSLSocket, c); 
  }
  
  private static boolean b(SSLSocket paramSSLSocket, String[] paramArrayOfString) {
    if (paramSSLSocket == null)
      return false; 
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    ArrayList<String> arrayList = new ArrayList();
    List<String> list = Arrays.asList(paramArrayOfString);
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = arrayOfString[i];
      if (list.contains(str.toUpperCase(Locale.ENGLISH)))
        arrayList.add(str); 
    } 
    if (!arrayList.isEmpty()) {
      paramSSLSocket.setEnabledCipherSuites(arrayList.<String>toArray(new String[arrayList.size()]));
      return true;
    } 
    return false;
  }
  
  private void c(SSLSocket paramSSLSocket) {
    paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException {
    Socket socket = this.f.getSocketFactory().createSocket(paramString, paramInt);
    a(socket);
    return socket;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException {
    Socket socket = this.f.getSocketFactory().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    a(socket);
    return socket;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    Socket socket = this.f.getSocketFactory().createSocket(paramInetAddress, paramInt);
    a(socket);
    return socket;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    Socket socket = this.f.getSocketFactory().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    a(socket);
    return socket;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    paramSocket = this.f.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */