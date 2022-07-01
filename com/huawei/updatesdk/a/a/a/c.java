package com.huawei.updatesdk.a.a.a;

import android.os.Build;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class c {
  private static final String[] a = new String[] { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA" };
  
  private static final String[] b = new String[] { "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" };
  
  private static final String[] c = new String[] { 
      "TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", 
      "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV" };
  
  public static SSLContext a() throws NoSuchAlgorithmException {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      String str1 = "TLSv1.3";
      return SSLContext.getInstance(str1);
    } 
    if (i >= 16) {
      String str1 = "TLSv1.2";
      return SSLContext.getInstance(str1);
    } 
    String str = "TLS";
    return SSLContext.getInstance(str);
  }
  
  private static void a(SSLSocket paramSSLSocket) {
    if (paramSSLSocket == null)
      return; 
    if (!d(paramSSLSocket))
      a(paramSSLSocket, c); 
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
  
  private static void b(SSLSocket paramSSLSocket) {
    if (paramSSLSocket == null)
      return; 
    if (Build.VERSION.SDK_INT >= 29)
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.3", "TLSv1.2" }); 
    int i = Build.VERSION.SDK_INT;
    if (i >= 16 && i < 29) {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
      return;
    } 
    if (Build.VERSION.SDK_INT < 16)
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1" }); 
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
  
  public static void c(SSLSocket paramSSLSocket) {
    if (paramSSLSocket == null)
      return; 
    b(paramSSLSocket);
    a(paramSSLSocket);
  }
  
  private static boolean d(SSLSocket paramSSLSocket) {
    return (paramSSLSocket == null) ? false : ((Build.VERSION.SDK_INT > 19) ? b(paramSSLSocket, b) : b(paramSSLSocket, a));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */