package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public class HttpManager {
  private static final String BOUNDARY = getBoundry();
  
  private static final int BUFFER_SIZE = 8192;
  
  private static final int CONNECTION_TIMEOUT = 25000;
  
  private static final String END_MP_BOUNDARY;
  
  private static final String HTTP_METHOD_GET = "GET";
  
  private static final String HTTP_METHOD_POST = "POST";
  
  private static final String MP_BOUNDARY;
  
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  
  private static final int SOCKET_TIMEOUT = 20000;
  
  private static final String TAG = "HttpManager";
  
  private static SSLSocketFactory sSSLSocketFactory;
  
  static {
    StringBuilder stringBuilder = new StringBuilder("--");
    stringBuilder.append(BOUNDARY);
    MP_BOUNDARY = stringBuilder.toString();
    stringBuilder = new StringBuilder("--");
    stringBuilder.append(BOUNDARY);
    stringBuilder.append("--");
    END_MP_BOUNDARY = stringBuilder.toString();
  }
  
  public static void buildParams(OutputStream paramOutputStream, WeiboParameters paramWeiboParameters) throws WeiboException {
    try {
      Set<String> set = paramWeiboParameters.keySet();
      Iterator<String> iterator = set.iterator();
      while (true) {
        StringBuilder stringBuilder;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean bool = iterator.hasNext();
        if (!bool) {
          Iterator<String> iterator1 = set.iterator();
          while (true) {
            Bitmap bitmap;
            if (!iterator1.hasNext()) {
              stringBuilder = new StringBuilder("\r\n");
              stringBuilder.append(END_MP_BOUNDARY);
              paramOutputStream.write(stringBuilder.toString().getBytes());
              return;
            } 
            String str1 = iterator1.next();
            Object object = stringBuilder.get(str1);
            bool = object instanceof Bitmap;
            if (bool) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(MP_BOUNDARY);
              stringBuilder1.append("\r\n");
              stringBuilder1.append("content-disposition: form-data; name=\"");
              stringBuilder1.append(str1);
              stringBuilder1.append("\"; filename=\"file\"\r\n");
              stringBuilder1.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
              paramOutputStream.write(stringBuilder1.toString().getBytes());
              bitmap = (Bitmap)object;
              object = new ByteArrayOutputStream();
              bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)object);
              paramOutputStream.write(object.toByteArray());
              paramOutputStream.write("\r\n".getBytes());
              continue;
            } 
            if (object instanceof ByteArrayOutputStream) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(MP_BOUNDARY);
              stringBuilder1.append("\r\n");
              stringBuilder1.append("content-disposition: form-data; name=\"");
              stringBuilder1.append((String)bitmap);
              stringBuilder1.append("\"; filename=\"file\"\r\n");
              stringBuilder1.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
              paramOutputStream.write(stringBuilder1.toString().getBytes());
              byteArrayOutputStream = (ByteArrayOutputStream)object;
              paramOutputStream.write(byteArrayOutputStream.toByteArray());
              paramOutputStream.write("\r\n".getBytes());
              byteArrayOutputStream.close();
            } 
          } 
          break;
        } 
        String str = byteArrayOutputStream.next();
        if (stringBuilder.get(str) instanceof String) {
          StringBuilder stringBuilder1 = new StringBuilder(100);
          stringBuilder1.setLength(0);
          stringBuilder1.append(MP_BOUNDARY);
          stringBuilder1.append("\r\n");
          stringBuilder1.append("content-disposition: form-data; name=\"");
          stringBuilder1.append(str);
          stringBuilder1.append("\"\r\n\r\n");
          stringBuilder1.append(stringBuilder.get(str));
          stringBuilder1.append("\r\n");
          paramOutputStream.write(stringBuilder1.toString().getBytes());
        } 
      } 
    } catch (IOException iOException) {
      throw new WeiboException(iOException);
    } 
  }
  
  private static native String calcOauthSignNative(Context paramContext, String paramString1, String paramString2);
  
  public static String downloadFile(Context paramContext, String paramString1, String paramString2, String paramString3) throws WeiboException {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/net/HttpManager
    //   2: monitorenter
    //   3: new java/io/File
    //   6: dup
    //   7: aload_2
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual exists : ()Z
    //   16: ifne -> 24
    //   19: aload_0
    //   20: invokevirtual mkdirs : ()Z
    //   23: pop
    //   24: new java/io/File
    //   27: dup
    //   28: aload_0
    //   29: aload_3
    //   30: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   33: astore #10
    //   35: aload #10
    //   37: invokevirtual exists : ()Z
    //   40: ifeq -> 54
    //   43: aload #10
    //   45: invokevirtual getPath : ()Ljava/lang/String;
    //   48: astore_0
    //   49: ldc com/sina/weibo/sdk/net/HttpManager
    //   51: monitorexit
    //   52: aload_0
    //   53: areturn
    //   54: aload_1
    //   55: invokestatic isValidUrl : (Ljava/lang/String;)Z
    //   58: ifne -> 67
    //   61: ldc com/sina/weibo/sdk/net/HttpManager
    //   63: monitorexit
    //   64: ldc ''
    //   66: areturn
    //   67: invokestatic getNewHttpClient : ()Lorg/apache/http/client/HttpClient;
    //   70: astore #9
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: aload_3
    //   77: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: astore_0
    //   84: aload_0
    //   85: ldc '_temp'
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: new java/io/File
    //   94: dup
    //   95: aload_2
    //   96: aload_0
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   103: astore_2
    //   104: aload_2
    //   105: invokevirtual exists : ()Z
    //   108: ifeq -> 120
    //   111: aload_2
    //   112: invokevirtual length : ()J
    //   115: lstore #7
    //   117: goto -> 128
    //   120: aload_2
    //   121: invokevirtual createNewFile : ()Z
    //   124: pop
    //   125: lconst_0
    //   126: lstore #7
    //   128: new org/apache/http/client/methods/HttpGet
    //   131: dup
    //   132: aload_1
    //   133: invokespecial <init> : (Ljava/lang/String;)V
    //   136: astore_0
    //   137: new java/lang/StringBuilder
    //   140: dup
    //   141: ldc 'bytes='
    //   143: invokespecial <init> : (Ljava/lang/String;)V
    //   146: astore_1
    //   147: aload_1
    //   148: lload #7
    //   150: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_1
    //   155: ldc '-'
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: ldc 'RANGE'
    //   164: aload_1
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokevirtual setHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload #9
    //   173: aload_0
    //   174: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   179: astore_0
    //   180: aload_0
    //   181: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   186: invokeinterface getStatusCode : ()I
    //   191: istore #4
    //   193: iload #4
    //   195: sipush #206
    //   198: if_icmpne -> 248
    //   201: aload_0
    //   202: ldc 'Content-Range'
    //   204: invokeinterface getHeaders : (Ljava/lang/String;)[Lorg/apache/http/Header;
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull -> 640
    //   214: aload_1
    //   215: arraylength
    //   216: ifeq -> 640
    //   219: aload_1
    //   220: iconst_0
    //   221: aaload
    //   222: invokeinterface getValue : ()Ljava/lang/String;
    //   227: astore_1
    //   228: aload_1
    //   229: aload_1
    //   230: bipush #47
    //   232: invokevirtual indexOf : (I)I
    //   235: iconst_1
    //   236: iadd
    //   237: invokevirtual substring : (I)Ljava/lang/String;
    //   240: invokestatic parseLong : (Ljava/lang/String;)J
    //   243: lstore #5
    //   245: goto -> 291
    //   248: iload #4
    //   250: sipush #200
    //   253: if_icmpne -> 531
    //   256: aload_0
    //   257: ldc_w 'Content-Length'
    //   260: invokeinterface getFirstHeader : (Ljava/lang/String;)Lorg/apache/http/Header;
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull -> 646
    //   270: aload_1
    //   271: invokeinterface getValue : ()Ljava/lang/String;
    //   276: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   279: invokevirtual intValue : ()I
    //   282: i2l
    //   283: lstore #5
    //   285: lconst_0
    //   286: lstore #7
    //   288: goto -> 291
    //   291: aload_0
    //   292: invokeinterface getEntity : ()Lorg/apache/http/HttpEntity;
    //   297: astore_1
    //   298: aload_0
    //   299: ldc_w 'Content-Encoding'
    //   302: invokeinterface getFirstHeader : (Ljava/lang/String;)Lorg/apache/http/Header;
    //   307: astore_0
    //   308: aload_0
    //   309: ifnull -> 348
    //   312: aload_0
    //   313: invokeinterface getValue : ()Ljava/lang/String;
    //   318: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   321: ldc_w 'gzip'
    //   324: invokevirtual indexOf : (Ljava/lang/String;)I
    //   327: iconst_m1
    //   328: if_icmple -> 348
    //   331: new java/util/zip/GZIPInputStream
    //   334: dup
    //   335: aload_1
    //   336: invokeinterface getContent : ()Ljava/io/InputStream;
    //   341: invokespecial <init> : (Ljava/io/InputStream;)V
    //   344: astore_0
    //   345: goto -> 355
    //   348: aload_1
    //   349: invokeinterface getContent : ()Ljava/io/InputStream;
    //   354: astore_0
    //   355: new java/io/RandomAccessFile
    //   358: dup
    //   359: aload_2
    //   360: ldc_w 'rw'
    //   363: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   366: astore_1
    //   367: aload_1
    //   368: lload #7
    //   370: invokevirtual seek : (J)V
    //   373: sipush #1024
    //   376: newarray byte
    //   378: astore_3
    //   379: aload_0
    //   380: aload_3
    //   381: invokevirtual read : ([B)I
    //   384: istore #4
    //   386: iload #4
    //   388: iconst_m1
    //   389: if_icmpne -> 520
    //   392: aload_1
    //   393: invokevirtual close : ()V
    //   396: aload_0
    //   397: invokevirtual close : ()V
    //   400: lload #5
    //   402: lconst_0
    //   403: lcmp
    //   404: ifeq -> 473
    //   407: aload_2
    //   408: invokevirtual length : ()J
    //   411: lload #5
    //   413: lcmp
    //   414: ifge -> 420
    //   417: goto -> 473
    //   420: aload_2
    //   421: aload #10
    //   423: invokevirtual renameTo : (Ljava/io/File;)Z
    //   426: pop
    //   427: aload #10
    //   429: invokevirtual getPath : ()Ljava/lang/String;
    //   432: astore_0
    //   433: aload #9
    //   435: ifnull -> 468
    //   438: aload #9
    //   440: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   445: invokeinterface closeExpiredConnections : ()V
    //   450: aload #9
    //   452: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   457: ldc2_w 300
    //   460: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   463: invokeinterface closeIdleConnections : (JLjava/util/concurrent/TimeUnit;)V
    //   468: ldc com/sina/weibo/sdk/net/HttpManager
    //   470: monitorexit
    //   471: aload_0
    //   472: areturn
    //   473: aload_2
    //   474: invokevirtual delete : ()Z
    //   477: pop
    //   478: aload #9
    //   480: ifnull -> 591
    //   483: aload #9
    //   485: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   490: invokeinterface closeExpiredConnections : ()V
    //   495: aload #9
    //   497: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   502: astore_0
    //   503: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   506: astore_1
    //   507: aload_0
    //   508: ldc2_w 300
    //   511: aload_1
    //   512: invokeinterface closeIdleConnections : (JLjava/util/concurrent/TimeUnit;)V
    //   517: goto -> 591
    //   520: aload_1
    //   521: aload_3
    //   522: iconst_0
    //   523: iload #4
    //   525: invokevirtual write : ([BII)V
    //   528: goto -> 379
    //   531: new com/sina/weibo/sdk/exception/WeiboHttpException
    //   534: dup
    //   535: aload_0
    //   536: invokestatic readRsponse : (Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   539: iload #4
    //   541: invokespecial <init> : (Ljava/lang/String;I)V
    //   544: athrow
    //   545: astore_0
    //   546: goto -> 597
    //   549: astore_0
    //   550: aload_0
    //   551: invokevirtual printStackTrace : ()V
    //   554: aload_2
    //   555: invokevirtual delete : ()Z
    //   558: pop
    //   559: aload #9
    //   561: ifnull -> 591
    //   564: aload #9
    //   566: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   571: invokeinterface closeExpiredConnections : ()V
    //   576: aload #9
    //   578: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   583: astore_0
    //   584: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   587: astore_1
    //   588: goto -> 507
    //   591: ldc com/sina/weibo/sdk/net/HttpManager
    //   593: monitorexit
    //   594: ldc ''
    //   596: areturn
    //   597: aload #9
    //   599: ifnull -> 632
    //   602: aload #9
    //   604: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   609: invokeinterface closeExpiredConnections : ()V
    //   614: aload #9
    //   616: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   621: ldc2_w 300
    //   624: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   627: invokeinterface closeIdleConnections : (JLjava/util/concurrent/TimeUnit;)V
    //   632: aload_0
    //   633: athrow
    //   634: astore_0
    //   635: ldc com/sina/weibo/sdk/net/HttpManager
    //   637: monitorexit
    //   638: aload_0
    //   639: athrow
    //   640: lconst_0
    //   641: lstore #5
    //   643: goto -> 291
    //   646: lconst_0
    //   647: lstore #7
    //   649: lload #7
    //   651: lstore #5
    //   653: goto -> 291
    // Exception table:
    //   from	to	target	type
    //   3	24	634	finally
    //   24	49	634	finally
    //   54	61	634	finally
    //   67	104	634	finally
    //   104	117	549	java/io/IOException
    //   104	117	545	finally
    //   120	125	549	java/io/IOException
    //   120	125	545	finally
    //   128	193	549	java/io/IOException
    //   128	193	545	finally
    //   201	210	549	java/io/IOException
    //   201	210	545	finally
    //   214	245	549	java/io/IOException
    //   214	245	545	finally
    //   256	266	549	java/io/IOException
    //   256	266	545	finally
    //   270	285	549	java/io/IOException
    //   270	285	545	finally
    //   291	308	549	java/io/IOException
    //   291	308	545	finally
    //   312	345	549	java/io/IOException
    //   312	345	545	finally
    //   348	355	549	java/io/IOException
    //   348	355	545	finally
    //   355	379	549	java/io/IOException
    //   355	379	545	finally
    //   379	386	549	java/io/IOException
    //   379	386	545	finally
    //   392	400	549	java/io/IOException
    //   392	400	545	finally
    //   407	417	549	java/io/IOException
    //   407	417	545	finally
    //   420	433	549	java/io/IOException
    //   420	433	545	finally
    //   438	468	634	finally
    //   473	478	549	java/io/IOException
    //   473	478	545	finally
    //   483	507	634	finally
    //   507	517	634	finally
    //   520	528	549	java/io/IOException
    //   520	528	545	finally
    //   531	545	549	java/io/IOException
    //   531	545	545	finally
    //   550	559	545	finally
    //   564	588	634	finally
    //   602	632	634	finally
    //   632	634	634	finally
  }
  
  public static String getBoundry() {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 1;; i++) {
      if (i >= 12)
        return stringBuffer.toString(); 
      long l1 = System.currentTimeMillis() + i;
      long l2 = l1 % 3L;
      if (l2 == 0L) {
        stringBuffer.append((char)(int)l1 % 9);
      } else if (l2 == 1L) {
        stringBuffer.append((char)(int)(l1 % 26L + 65L));
      } else {
        stringBuffer.append((char)(int)(l1 % 26L + 97L));
      } 
    } 
  }
  
  private static Certificate getCertificate(String paramString) throws CertificateException, IOException {
    null = CertificateFactory.getInstance("X.509");
    InputStream inputStream = HttpManager.class.getResourceAsStream(paramString);
    try {
      return null.generateCertificate(inputStream);
    } finally {
      if (inputStream != null)
        inputStream.close(); 
    } 
  }
  
  public static HttpClient getNewHttpClient() {
    try {
      BasicHttpParams basicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)basicHttpParams, "UTF-8");
      SchemeRegistry schemeRegistry = new SchemeRegistry();
      schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
      schemeRegistry.register(new Scheme("https", (SocketFactory)getSSLSocketFactory(), 443));
      ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry);
      HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 25000);
      HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 20000);
      return (HttpClient)new DefaultHttpClient((ClientConnectionManager)threadSafeClientConnManager, (HttpParams)basicHttpParams);
    } catch (Exception exception) {
      return (HttpClient)new DefaultHttpClient();
    } 
  }
  
  private static String getOauthSign(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder = new StringBuilder("");
    if (!TextUtils.isEmpty(paramString1))
      stringBuilder.append(paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      stringBuilder.append(paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      stringBuilder.append(paramString3); 
    return calcOauthSignNative(paramContext, stringBuilder.toString(), paramString4);
  }
  
  private static SSLSocketFactory getSSLSocketFactory() {
    if (sSSLSocketFactory == null)
      try {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        Certificate certificate1 = getCertificate("cacert_cn.cer");
        Certificate certificate2 = getCertificate("cacert_com.cer");
        keyStore.setCertificateEntry("cnca", certificate1);
        keyStore.setCertificateEntry("comca", certificate2);
        sSSLSocketFactory = new SSLSocketFactoryEx(keyStore);
        LogUtil.d("HttpManager", "getSSLSocketFactory noraml !!!!!");
      } catch (Exception exception) {
        exception.printStackTrace();
        sSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        LogUtil.d("HttpManager", "getSSLSocketFactory error default !!!!!");
      }  
    return sSSLSocketFactory;
  }
  
  private static String getTimestamp() {
    return String.valueOf(System.currentTimeMillis() / 1000L);
  }
  
  public static String openRedirectUrl4LocationUri(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) {
    DefaultHttpClient defaultHttpClient2 = null;
    DefaultHttpClient defaultHttpClient3 = null;
    WeiboParameters weiboParameters = null;
    DefaultHttpClient defaultHttpClient1 = defaultHttpClient2;
    try {
      CustomRedirectHandler customRedirectHandler = new CustomRedirectHandler() {
          public void onReceivedException() {}
          
          public boolean shouldRedirectUrl(String param1String) {
            return true;
          }
        };
      defaultHttpClient1 = defaultHttpClient2;
      defaultHttpClient2 = (DefaultHttpClient)getNewHttpClient();
    } catch (IOException iOException) {
    
    } finally {
      paramContext = null;
    } 
    throw new WeiboException(paramContext);
  }
  
  public static String openUrl(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) throws WeiboException {
    String str = readRsponse(requestHttpExecute(paramContext, paramString1, paramString2, paramWeiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("HttpManager", stringBuilder.toString());
    return str;
  }
  
  public static String openUrl4RdirectURL(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) throws WeiboException {
    DefaultHttpClient defaultHttpClient1 = null;
    DefaultHttpClient defaultHttpClient2 = null;
    Context context = null;
    try {
      DefaultHttpClient defaultHttpClient = (DefaultHttpClient)getNewHttpClient();
    } catch (IOException iOException) {
    
    } finally {
      DefaultHttpClient defaultHttpClient;
      paramContext = null;
    } 
    throw new WeiboException(paramContext);
  }
  
  public static String readRsponse(HttpResponse paramHttpResponse) throws WeiboException {
    IOException iOException1;
    IOException iOException2;
    InputStream inputStream2 = null;
    InputStream inputStream1 = null;
    if (paramHttpResponse == null)
      return null; 
    HttpEntity httpEntity = paramHttpResponse.getEntity();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      InputStream inputStream4 = httpEntity.getContent();
      inputStream1 = inputStream4;
      inputStream2 = inputStream4;
      Header header = paramHttpResponse.getFirstHeader("Content-Encoding");
      InputStream inputStream3 = inputStream4;
      if (header != null) {
        inputStream3 = inputStream4;
        inputStream1 = inputStream4;
        inputStream2 = inputStream4;
        if (header.getValue().toLowerCase().indexOf("gzip") > -1) {
          inputStream1 = inputStream4;
          inputStream2 = inputStream4;
          inputStream3 = new GZIPInputStream(inputStream4);
        } 
      } 
      inputStream1 = inputStream3;
      inputStream2 = inputStream3;
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        String str;
        inputStream1 = inputStream3;
        inputStream2 = inputStream3;
        int i = inputStream3.read(arrayOfByte);
        if (i == -1) {
          inputStream1 = inputStream3;
          inputStream2 = inputStream3;
          str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
          inputStream1 = inputStream3;
          inputStream2 = inputStream3;
          StringBuilder stringBuilder = new StringBuilder("readRsponse result : ");
          inputStream1 = inputStream3;
          inputStream2 = inputStream3;
          stringBuilder.append(str);
          inputStream1 = inputStream3;
          inputStream2 = inputStream3;
          LogUtil.d("HttpManager", stringBuilder.toString());
          if (inputStream3 != null)
            try {
              inputStream3.close();
            } catch (IOException null) {
              iOException.printStackTrace();
            }  
          try {
            byteArrayOutputStream.close();
            return str;
          } catch (IOException iOException) {
            iOException.printStackTrace();
            return str;
          } 
        } 
        iOException1 = iOException;
        iOException2 = iOException;
        byteArrayOutputStream.write((byte[])str, 0, i);
      } 
    } catch (IOException iOException) {
      iOException1 = iOException2;
      throw new WeiboException(iOException);
    } finally {}
    if (iOException1 != null)
      try {
        iOException1.close();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    try {
      byteArrayOutputStream.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    throw paramHttpResponse;
  }
  
  private static HttpResponse requestHttpExecute(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) {
    Object object1;
    Object object2;
    IOException iOException1;
    IOException iOException2;
    String str4 = null;
    String str5 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    try {
      object2 = getNewHttpClient();
      str1 = str4;
    } catch (IOException iOException) {
    
    } finally {
      paramString1 = null;
      object2 = null;
    } 
    try {
      paramString1.printStackTrace();
      throw new WeiboException(paramString1);
    } finally {
      paramString1 = null;
    } 
    Context context = paramContext;
    if (context != null)
      try {
        context.close();
      } catch (IOException iOException) {} 
    shutdownHttpClient((HttpClient)object2);
    throw paramString1;
  }
  
  private static void setHttpCommonParam(Context paramContext, WeiboParameters paramWeiboParameters) {
    String str1;
    boolean bool = TextUtils.isEmpty(paramWeiboParameters.getAppKey());
    String str2 = "";
    if (!bool) {
      String str = Utility.getAid(paramContext, paramWeiboParameters.getAppKey());
      str1 = str;
      if (!TextUtils.isEmpty(str)) {
        paramWeiboParameters.put("aid", str);
        str1 = str;
      } 
    } else {
      str1 = "";
    } 
    String str3 = getTimestamp();
    paramWeiboParameters.put("oauth_timestamp", str3);
    Object object1 = paramWeiboParameters.get("access_token");
    Object object3 = paramWeiboParameters.get("refresh_token");
    Object object2 = paramWeiboParameters.get("phone");
    if (object1 != null && object1 instanceof String) {
      object1 = object1;
    } else if (object3 != null && object3 instanceof String) {
      object1 = object3;
    } else {
      object1 = str2;
      if (object2 != null) {
        object1 = str2;
        if (object2 instanceof String)
          object1 = object2; 
      } 
    } 
    paramWeiboParameters.put("oauth_sign", getOauthSign(paramContext, str1, (String)object1, paramWeiboParameters.getAppKey(), str3));
  }
  
  public static void shutdownHttpClient(HttpClient paramHttpClient) {
    if (paramHttpClient != null)
      try {
        paramHttpClient.getConnectionManager().closeExpiredConnections();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  static {
    System.loadLibrary("weibosdkcore");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\HttpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */