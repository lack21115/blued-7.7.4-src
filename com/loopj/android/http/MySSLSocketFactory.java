package com.loopj.android.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory extends SSLSocketFactory {
  SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public MySSLSocketFactory(KeyStore paramKeyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
    super(paramKeyStore);
    X509TrustManager x509TrustManager = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
        
        public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
        
        public X509Certificate[] getAcceptedIssuers() {
          return null;
        }
      };
    this.sslContext.init(null, new TrustManager[] { x509TrustManager }, null);
  }
  
  public static SSLSocketFactory getFixedSocketFactory() {
    try {
      return mySSLSocketFactory;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public static KeyStore getKeystore() {
    Exception exception;
    KeyStore keyStore = null;
    try {
      KeyStore keyStore1 = KeyStore.getInstance(KeyStore.getDefaultType());
      try {
        return keyStore1;
      } finally {
        exception = null;
      } 
    } finally {}
    exception.printStackTrace();
    return keyStore;
  }
  
  public static KeyStore getKeystoreOfCA(InputStream paramInputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 'X.509'
    //   4: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   7: astore_3
    //   8: new java/io/BufferedInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial <init> : (Ljava/io/InputStream;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: aload_3
    //   20: aload_1
    //   21: invokevirtual generateCertificate : (Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: astore_2
    //   25: aload_1
    //   26: invokevirtual close : ()V
    //   29: aload_2
    //   30: astore_0
    //   31: goto -> 81
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual printStackTrace : ()V
    //   39: aload_2
    //   40: astore_0
    //   41: goto -> 81
    //   44: astore_2
    //   45: goto -> 57
    //   48: astore_0
    //   49: aload_2
    //   50: astore_1
    //   51: goto -> 127
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: invokevirtual printStackTrace : ()V
    //   63: aload_1
    //   64: ifnull -> 79
    //   67: aload_1
    //   68: invokevirtual close : ()V
    //   71: goto -> 79
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual printStackTrace : ()V
    //   79: aconst_null
    //   80: astore_0
    //   81: invokestatic getDefaultType : ()Ljava/lang/String;
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyStore;
    //   89: astore_1
    //   90: aload_1
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual load : (Ljava/io/InputStream;[C)V
    //   96: aload_1
    //   97: ldc 'ca'
    //   99: aload_0
    //   100: invokevirtual setCertificateEntry : (Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   103: aload_1
    //   104: areturn
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: astore_1
    //   110: goto -> 116
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_1
    //   117: invokevirtual printStackTrace : ()V
    //   120: aload_0
    //   121: areturn
    //   122: astore_2
    //   123: aload_0
    //   124: astore_1
    //   125: aload_2
    //   126: astore_0
    //   127: aload_1
    //   128: ifnull -> 143
    //   131: aload_1
    //   132: invokevirtual close : ()V
    //   135: goto -> 143
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual printStackTrace : ()V
    //   143: aload_0
    //   144: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	54	java/security/cert/CertificateException
    //   2	17	48	finally
    //   19	25	44	java/security/cert/CertificateException
    //   19	25	122	finally
    //   25	29	34	java/io/IOException
    //   59	63	122	finally
    //   67	71	74	java/io/IOException
    //   85	90	113	java/lang/Exception
    //   90	103	105	java/lang/Exception
    //   131	135	138	java/io/IOException
  }
  
  public static DefaultHttpClient getNewHttpClient(KeyStore paramKeyStore) {
    try {
      MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(paramKeyStore);
      SchemeRegistry schemeRegistry = new SchemeRegistry();
      schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
      schemeRegistry.register(new Scheme("https", (SocketFactory)mySSLSocketFactory, 443));
      BasicHttpParams basicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)basicHttpParams, "UTF-8");
      return new DefaultHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams);
    } catch (Exception exception) {
      return new DefaultHttpClient();
    } 
  }
  
  public Socket createSocket() throws IOException {
    return this.sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    return this.sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public void fixHttpsURLConnection() {
    HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\MySSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */