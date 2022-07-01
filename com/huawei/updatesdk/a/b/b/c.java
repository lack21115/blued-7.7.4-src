package com.huawei.updatesdk.a.b.b;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.a.d;
import com.huawei.updatesdk.a.a.c.i.b;
import com.huawei.updatesdk.a.b.a.a;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class c {
  private static volatile c a;
  
  public static c a() {
    // Byte code:
    //   0: ldc com/huawei/updatesdk/a/b/b/c
    //   2: monitorenter
    //   3: getstatic com/huawei/updatesdk/a/b/b/c.a : Lcom/huawei/updatesdk/a/b/b/c;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/updatesdk/a/b/b/c
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/updatesdk/a/b/b/c.a : Lcom/huawei/updatesdk/a/b/b/c;
    //   19: getstatic com/huawei/updatesdk/a/b/b/c.a : Lcom/huawei/updatesdk/a/b/b/c;
    //   22: astore_0
    //   23: ldc com/huawei/updatesdk/a/b/b/c
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/huawei/updatesdk/a/b/b/c
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static String b() {
    String str = a.c().b();
    if (TextUtils.isEmpty(str))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("/updatesdk");
    str = stringBuilder.toString();
    File file = new File(str);
    return (!file.exists() && !file.mkdirs()) ? "" : str;
  }
  
  private Proxy c() {
    return b.e(a.c().a()) ? b.a() : null;
  }
  
  public HttpURLConnection a(String paramString) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IllegalAccessException {
    URL uRL = new URL(paramString);
    Proxy proxy = c();
    if (proxy == null) {
      uRLConnection = uRL.openConnection();
    } else {
      uRLConnection = uRLConnection.openConnection(proxy);
    } 
    URLConnection uRLConnection = uRLConnection;
    uRLConnection.setConnectTimeout(7000);
    uRLConnection.setReadTimeout(10000);
    uRLConnection.setUseCaches(false);
    uRLConnection.setDoInput(true);
    uRLConnection.setRequestProperty("Accept-Encoding", "identity");
    uRLConnection.setInstanceFollowRedirects(true);
    if (uRLConnection instanceof HttpsURLConnection) {
      HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRLConnection;
      httpsURLConnection.setSSLSocketFactory((SSLSocketFactory)d.a(a.c().a()));
      httpsURLConnection.setHostnameVerifier((HostnameVerifier)SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    } 
    return (HttpURLConnection)uRLConnection;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */