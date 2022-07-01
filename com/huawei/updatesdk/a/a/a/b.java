package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import com.huawei.updatesdk.a.a.c.d;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class b {
  private HttpURLConnection a = null;
  
  private HttpURLConnection a(String paramString, Context paramContext) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IllegalAccessException {
    URLConnection uRLConnection;
    URL uRL = new URL(paramString);
    Proxy proxy = com.huawei.updatesdk.a.a.c.i.b.b(paramContext);
    if ("https".equals(uRL.getProtocol())) {
      if (proxy == null) {
        uRLConnection = uRL.openConnection();
      } else {
        uRLConnection = uRL.openConnection((Proxy)uRLConnection);
      } 
      uRLConnection = uRLConnection;
      uRLConnection.setSSLSocketFactory(d.a(paramContext));
      uRLConnection.setHostnameVerifier((HostnameVerifier)SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    } else {
      proxy = null;
    } 
    if ("http".equals(uRL.getProtocol()))
      uRLConnection = uRL.openConnection(); 
    return (HttpURLConnection)uRLConnection;
  }
  
  private byte[] a(byte[] paramArrayOfbyte) {
    DataOutputStream dataOutputStream3 = null;
    DataOutputStream dataOutputStream2 = null;
    DataOutputStream dataOutputStream1 = dataOutputStream2;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      dataOutputStream1 = dataOutputStream2;
      try {
        dataOutputStream2 = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, paramArrayOfbyte.length));
        try {
          dataOutputStream2.write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
          dataOutputStream2.flush();
          ByteArrayOutputStream byteArrayOutputStream1 = byteArrayOutputStream;
        } catch (IOException iOException1) {
          ByteArrayOutputStream byteArrayOutputStream1 = byteArrayOutputStream;
        } finally {
          paramArrayOfbyte = null;
        } 
      } catch (IOException iOException2) {
        dataOutputStream2 = dataOutputStream3;
        IOException iOException1 = iOException;
        iOException = iOException2;
      } 
    } catch (IOException iOException) {
      paramArrayOfbyte = null;
      dataOutputStream2 = dataOutputStream3;
    } finally {}
    dataOutputStream1 = dataOutputStream2;
    com.huawei.updatesdk.a.a.b.a.a.a.a("HttpsUtil", "gzip error!", iOException);
    byte[] arrayOfByte = paramArrayOfbyte;
    if (dataOutputStream2 != null) {
      byte[] arrayOfByte1 = paramArrayOfbyte;
      dataOutputStream2.close();
      arrayOfByte = paramArrayOfbyte;
    } 
    return arrayOfByte.toByteArray();
  }
  
  public a a(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext) throws IOException, CertificateException, IllegalAccessException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    a a = new a();
    byte[] arrayOfByte2 = null;
    String str2 = null;
    String str3 = null;
    try {
      HttpURLConnection httpURLConnection = a(paramString1, paramContext);
      if (httpURLConnection == null) {
        if (httpURLConnection != null)
          httpURLConnection.disconnect(); 
        d.a(null);
        paramString2 = str3;
        return a;
      } 
    } finally {
      paramString2 = null;
    } 
    paramString3 = null;
    String str1 = paramString1;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (str1 != null)
      str1.disconnect(); 
    d.a((Closeable)paramString3);
    d.a((Closeable)arrayOfByte1);
    throw paramString2;
  }
  
  public void a() {
    HttpURLConnection httpURLConnection = this.a;
    if (httpURLConnection != null)
      httpURLConnection.disconnect(); 
  }
  
  public static class a {
    private String a;
    
    private int b;
    
    public int a() {
      return this.b;
    }
    
    public String b() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */