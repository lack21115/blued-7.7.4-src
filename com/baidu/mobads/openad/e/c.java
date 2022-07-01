package com.baidu.mobads.openad.e;

import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class c {
  public static void a() {
    // Byte code:
    //   0: new com/baidu/mobads/openad/e/d
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_0
    //   8: invokestatic b : ()V
    //   11: aload_0
    //   12: invokestatic setDefaultHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   15: return
    //   16: astore_0
    //   17: return
    // Exception table:
    //   from	to	target	type
    //   0	15	16	java/lang/Exception
    //   0	15	16	finally
  }
  
  private static void b() {
    a a = new a();
    SSLContext sSLContext = SSLContext.getInstance("SSL");
    sSLContext.init(null, new TrustManager[] { a }, null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
  }
  
  static class a implements TrustManager, X509TrustManager {
    public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
    
    public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
    
    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */