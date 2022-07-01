package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class q implements Callable<u> {
  private static final HttpRequestRetryHandler e = new ad();
  
  protected l a;
  
  protected Context b;
  
  protected o c;
  
  String d;
  
  private HttpUriRequest f;
  
  private HttpContext g = (HttpContext)new BasicHttpContext();
  
  private CookieStore h = (CookieStore)new BasicCookieStore();
  
  private CookieManager i;
  
  private AbstractHttpEntity j;
  
  private HttpHost k;
  
  private URL l;
  
  private int m = 0;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private String p = null;
  
  private String q;
  
  public q(l paraml, o paramo) {
    this.a = paraml;
    this.b = this.a.a;
    this.c = paramo;
  }
  
  private static long a(String[] paramArrayOfString) {
    int i = 0;
    while (true) {
      if (i < paramArrayOfString.length) {
        if ("max-age".equalsIgnoreCase(paramArrayOfString[i])) {
          int j = i + 1;
          if (paramArrayOfString[j] != null)
            try {
              return Long.parseLong(paramArrayOfString[j]);
            } catch (Exception exception) {} 
        } 
        i++;
        continue;
      } 
      return 0L;
    } 
  }
  
  private static HttpUrlHeader a(HttpResponse paramHttpResponse) {
    HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
    for (Header header : paramHttpResponse.getAllHeaders())
      httpUrlHeader.setHead(header.getName(), header.getValue()); 
    return httpUrlHeader;
  }
  
  private u a(HttpResponse paramHttpResponse, int paramInt, String paramString) {
    p p;
    (new StringBuilder("开始handle，handleResponse-1,")).append(Thread.currentThread().getId());
    HttpEntity httpEntity = paramHttpResponse.getEntity();
    Header header = null;
    if (httpEntity != null && paramHttpResponse.getStatusLine().getStatusCode() == 200) {
      (new StringBuilder("200，开始处理，handleResponse-2,threadid = ")).append(Thread.currentThread().getId());
      try {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      } finally {
        paramString = null;
      } 
      if (paramHttpResponse != null)
        try {
          paramHttpResponse.close();
        } catch (IOException iOException) {
          throw new RuntimeException("ArrayOutputStream close error!", iOException.getCause());
        }  
      throw paramString;
    } 
    if (p == null)
      iOException.getStatusLine().getStatusCode(); 
    return null;
  }
  
  private static HashMap<String, String> a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : paramString.split(";")) {
      String[] arrayOfString;
      if (str.indexOf('=') == -1) {
        arrayOfString = new String[2];
        arrayOfString[0] = "Content-Type";
        arrayOfString[1] = str;
      } else {
        arrayOfString = str.split("=");
      } 
      hashMap.put(arrayOfString[0], arrayOfString[1]);
    } 
    return (HashMap)hashMap;
  }
  
  private void a(HttpEntity paramHttpEntity, OutputStream paramOutputStream) {
    InputStream inputStream = b.a(paramHttpEntity);
    paramHttpEntity.getContentLength();
    try {
      byte[] arrayOfByte = new byte[2048];
      while (true) {
        int i = inputStream.read(arrayOfByte);
        if (i != -1 && !this.c.h()) {
          paramOutputStream.write(arrayOfByte, 0, i);
          if (this.c.f() != null);
          continue;
        } 
        break;
      } 
      paramOutputStream.flush();
      r.a(inputStream);
      return;
    } catch (Exception exception) {
      exception.getCause();
      StringBuilder stringBuilder = new StringBuilder("HttpWorker Request Error!");
      stringBuilder.append(exception.getLocalizedMessage());
      throw new IOException(stringBuilder.toString());
    } finally {}
    r.a(inputStream);
    throw paramHttpEntity;
  }
  
  private static long b(HttpResponse paramHttpResponse) {
    Header header2 = paramHttpResponse.getFirstHeader("Cache-Control");
    if (header2 != null) {
      String[] arrayOfString = header2.getValue().split("=");
      if (arrayOfString.length >= 2)
        try {
          return a(arrayOfString);
        } catch (NumberFormatException numberFormatException) {} 
    } 
    Header header1 = paramHttpResponse.getFirstHeader("Expires");
    return (header1 != null) ? (b.b(header1.getValue()) - System.currentTimeMillis()) : 0L;
  }
  
  private URI b() {
    String str1 = this.c.a();
    String str2 = this.d;
    if (str2 != null)
      str1 = str2; 
    if (str1 != null)
      return new URI(str1); 
    throw new RuntimeException("url should not be null");
  }
  
  private HttpUriRequest c() {
    HttpUriRequest httpUriRequest = this.f;
    if (httpUriRequest != null)
      return httpUriRequest; 
    if (this.j == null) {
      byte[] arrayOfByte = this.c.b();
      String str = this.c.b("gzip");
      if (arrayOfByte != null) {
        if (TextUtils.equals(str, "true")) {
          this.j = b.a(arrayOfByte);
        } else {
          this.j = (AbstractHttpEntity)new ByteArrayEntity(arrayOfByte);
        } 
        this.j.setContentType(this.c.c());
      } 
    } 
    AbstractHttpEntity abstractHttpEntity = this.j;
    if (abstractHttpEntity != null) {
      HttpPost httpPost = new HttpPost(b());
      httpPost.setEntity((HttpEntity)abstractHttpEntity);
      this.f = (HttpUriRequest)httpPost;
    } else {
      this.f = (HttpUriRequest)new HttpGet(b());
    } 
    return this.f;
  }
  
  private u d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: ldc_w 'connectivity'
    //   7: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast android/net/ConnectivityManager
    //   13: invokevirtual getAllNetworkInfo : ()[Landroid/net/NetworkInfo;
    //   16: astore #8
    //   18: iconst_1
    //   19: istore_2
    //   20: aload #8
    //   22: ifnonnull -> 28
    //   25: goto -> 1687
    //   28: aload #8
    //   30: arraylength
    //   31: istore_3
    //   32: iconst_0
    //   33: istore_1
    //   34: iload_1
    //   35: iload_3
    //   36: if_icmpge -> 1687
    //   39: aload #8
    //   41: iload_1
    //   42: aaload
    //   43: astore #9
    //   45: aload #9
    //   47: ifnull -> 1692
    //   50: aload #9
    //   52: invokevirtual isAvailable : ()Z
    //   55: ifeq -> 1692
    //   58: aload #9
    //   60: invokevirtual isConnectedOrConnecting : ()Z
    //   63: ifeq -> 1692
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -> 71
    //   71: iload_1
    //   72: ifeq -> 923
    //   75: aload_0
    //   76: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   79: invokevirtual d : ()Ljava/util/ArrayList;
    //   82: astore #8
    //   84: aload #8
    //   86: ifnull -> 140
    //   89: aload #8
    //   91: invokevirtual isEmpty : ()Z
    //   94: ifne -> 140
    //   97: aload #8
    //   99: invokevirtual iterator : ()Ljava/util/Iterator;
    //   102: astore #8
    //   104: aload #8
    //   106: invokeinterface hasNext : ()Z
    //   111: ifeq -> 140
    //   114: aload #8
    //   116: invokeinterface next : ()Ljava/lang/Object;
    //   121: checkcast org/apache/http/Header
    //   124: astore #9
    //   126: aload_0
    //   127: invokespecial c : ()Lorg/apache/http/client/methods/HttpUriRequest;
    //   130: aload #9
    //   132: invokeinterface addHeader : (Lorg/apache/http/Header;)V
    //   137: goto -> 104
    //   140: aload_0
    //   141: invokespecial c : ()Lorg/apache/http/client/methods/HttpUriRequest;
    //   144: invokestatic a : (Lorg/apache/http/HttpRequest;)V
    //   147: aload_0
    //   148: invokespecial c : ()Lorg/apache/http/client/methods/HttpUriRequest;
    //   151: invokestatic b : (Lorg/apache/http/HttpRequest;)V
    //   154: aload_0
    //   155: invokespecial c : ()Lorg/apache/http/client/methods/HttpUriRequest;
    //   158: ldc_w 'cookie'
    //   161: aload_0
    //   162: invokespecial i : ()Landroid/webkit/CookieManager;
    //   165: aload_0
    //   166: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   169: invokevirtual a : ()Ljava/lang/String;
    //   172: invokevirtual getCookie : (Ljava/lang/String;)Ljava/lang/String;
    //   175: invokeinterface addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield g : Lorg/apache/http/protocol/HttpContext;
    //   184: ldc_w 'http.cookie-store'
    //   187: aload_0
    //   188: getfield h : Lorg/apache/http/client/CookieStore;
    //   191: invokeinterface setAttribute : (Ljava/lang/String;Ljava/lang/Object;)V
    //   196: aload_0
    //   197: getfield a : Lcom/alipay/android/phone/mrpc/core/l;
    //   200: invokevirtual a : ()Lcom/alipay/android/phone/mrpc/core/b;
    //   203: getstatic com/alipay/android/phone/mrpc/core/q.e : Lorg/apache/http/client/HttpRequestRetryHandler;
    //   206: invokevirtual a : (Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   209: invokestatic currentTimeMillis : ()J
    //   212: lstore #4
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: ldc_w 'By Http/Https to request. operationType='
    //   221: invokespecial <init> : (Ljava/lang/String;)V
    //   224: astore #8
    //   226: aload #8
    //   228: aload_0
    //   229: invokespecial f : ()Ljava/lang/String;
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload #8
    //   238: ldc_w ' url='
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #8
    //   247: aload_0
    //   248: getfield f : Lorg/apache/http/client/methods/HttpUriRequest;
    //   251: invokeinterface getURI : ()Ljava/net/URI;
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_0
    //   264: getfield a : Lcom/alipay/android/phone/mrpc/core/l;
    //   267: invokevirtual a : ()Lcom/alipay/android/phone/mrpc/core/b;
    //   270: invokevirtual getParams : ()Lorg/apache/http/params/HttpParams;
    //   273: astore #10
    //   275: aload_0
    //   276: getfield b : Landroid/content/Context;
    //   279: ldc_w 'connectivity'
    //   282: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   285: checkcast android/net/ConnectivityManager
    //   288: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   291: astore #8
    //   293: aconst_null
    //   294: astore #9
    //   296: aload #8
    //   298: ifnull -> 1699
    //   301: aload #8
    //   303: invokevirtual isAvailable : ()Z
    //   306: ifeq -> 1699
    //   309: invokestatic getDefaultHost : ()Ljava/lang/String;
    //   312: astore #8
    //   314: invokestatic getDefaultPort : ()I
    //   317: istore_1
    //   318: aload #8
    //   320: ifnull -> 1699
    //   323: new org/apache/http/HttpHost
    //   326: dup
    //   327: aload #8
    //   329: iload_1
    //   330: invokespecial <init> : (Ljava/lang/String;I)V
    //   333: astore #8
    //   335: goto -> 338
    //   338: aload #8
    //   340: ifnull -> 1705
    //   343: aload #8
    //   345: invokevirtual getHostName : ()Ljava/lang/String;
    //   348: ldc_w '127.0.0.1'
    //   351: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   354: ifeq -> 1705
    //   357: aload #8
    //   359: invokevirtual getPort : ()I
    //   362: sipush #8087
    //   365: if_icmpne -> 1705
    //   368: aload #9
    //   370: astore #8
    //   372: goto -> 375
    //   375: aload #10
    //   377: ldc_w 'http.route.default-proxy'
    //   380: aload #8
    //   382: invokeinterface setParameter : (Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;
    //   387: pop
    //   388: aload_0
    //   389: getfield k : Lorg/apache/http/HttpHost;
    //   392: ifnull -> 404
    //   395: aload_0
    //   396: getfield k : Lorg/apache/http/HttpHost;
    //   399: astore #8
    //   401: goto -> 438
    //   404: aload_0
    //   405: invokespecial h : ()Ljava/net/URL;
    //   408: astore #8
    //   410: aload_0
    //   411: new org/apache/http/HttpHost
    //   414: dup
    //   415: aload #8
    //   417: invokevirtual getHost : ()Ljava/lang/String;
    //   420: aload_0
    //   421: invokespecial g : ()I
    //   424: aload #8
    //   426: invokevirtual getProtocol : ()Ljava/lang/String;
    //   429: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;)V
    //   432: putfield k : Lorg/apache/http/HttpHost;
    //   435: goto -> 395
    //   438: aload_0
    //   439: invokespecial g : ()I
    //   442: bipush #80
    //   444: if_icmpne -> 463
    //   447: new org/apache/http/HttpHost
    //   450: dup
    //   451: aload_0
    //   452: invokespecial h : ()Ljava/net/URL;
    //   455: invokevirtual getHost : ()Ljava/lang/String;
    //   458: invokespecial <init> : (Ljava/lang/String;)V
    //   461: astore #8
    //   463: aload_0
    //   464: getfield a : Lcom/alipay/android/phone/mrpc/core/l;
    //   467: invokevirtual a : ()Lcom/alipay/android/phone/mrpc/core/b;
    //   470: aload #8
    //   472: aload_0
    //   473: getfield f : Lorg/apache/http/client/methods/HttpUriRequest;
    //   476: aload_0
    //   477: getfield g : Lorg/apache/http/protocol/HttpContext;
    //   480: invokevirtual execute : (Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   483: astore #9
    //   485: invokestatic currentTimeMillis : ()J
    //   488: lstore #6
    //   490: aload_0
    //   491: getfield a : Lcom/alipay/android/phone/mrpc/core/l;
    //   494: lload #6
    //   496: lload #4
    //   498: lsub
    //   499: invokevirtual b : (J)V
    //   502: aload_0
    //   503: getfield h : Lorg/apache/http/client/CookieStore;
    //   506: invokeinterface getCookies : ()Ljava/util/List;
    //   511: astore #8
    //   513: aload_0
    //   514: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   517: invokevirtual e : ()Z
    //   520: ifeq -> 530
    //   523: aload_0
    //   524: invokespecial i : ()Landroid/webkit/CookieManager;
    //   527: invokevirtual removeAllCookie : ()V
    //   530: aload #8
    //   532: invokeinterface isEmpty : ()Z
    //   537: ifne -> 704
    //   540: aload #8
    //   542: invokeinterface iterator : ()Ljava/util/Iterator;
    //   547: astore #10
    //   549: aload #10
    //   551: invokeinterface hasNext : ()Z
    //   556: ifeq -> 704
    //   559: aload #10
    //   561: invokeinterface next : ()Ljava/lang/Object;
    //   566: checkcast org/apache/http/cookie/Cookie
    //   569: astore #8
    //   571: aload #8
    //   573: invokeinterface getDomain : ()Ljava/lang/String;
    //   578: ifnull -> 549
    //   581: new java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial <init> : ()V
    //   588: astore #11
    //   590: aload #11
    //   592: aload #8
    //   594: invokeinterface getName : ()Ljava/lang/String;
    //   599: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload #11
    //   605: ldc '='
    //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload #11
    //   613: aload #8
    //   615: invokeinterface getValue : ()Ljava/lang/String;
    //   620: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload #11
    //   626: ldc_w '; domain='
    //   629: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload #11
    //   635: aload #8
    //   637: invokeinterface getDomain : ()Ljava/lang/String;
    //   642: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload #8
    //   648: invokeinterface isSecure : ()Z
    //   653: ifeq -> 1708
    //   656: ldc_w '; Secure'
    //   659: astore #8
    //   661: goto -> 664
    //   664: aload #11
    //   666: aload #8
    //   668: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload #11
    //   674: invokevirtual toString : ()Ljava/lang/String;
    //   677: astore #8
    //   679: aload_0
    //   680: invokespecial i : ()Landroid/webkit/CookieManager;
    //   683: aload_0
    //   684: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   687: invokevirtual a : ()Ljava/lang/String;
    //   690: aload #8
    //   692: invokevirtual setCookie : (Ljava/lang/String;Ljava/lang/String;)V
    //   695: invokestatic getInstance : ()Landroid/webkit/CookieSyncManager;
    //   698: invokevirtual sync : ()V
    //   701: goto -> 549
    //   704: aload #9
    //   706: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   711: invokeinterface getStatusCode : ()I
    //   716: istore_3
    //   717: aload #9
    //   719: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   724: invokeinterface getReasonPhrase : ()Ljava/lang/String;
    //   729: astore #8
    //   731: iload_3
    //   732: sipush #200
    //   735: if_icmpeq -> 785
    //   738: iload_3
    //   739: sipush #304
    //   742: if_icmpne -> 1716
    //   745: iload_2
    //   746: istore_1
    //   747: goto -> 1718
    //   750: new com/alipay/android/phone/mrpc/core/HttpException
    //   753: dup
    //   754: aload #9
    //   756: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   761: invokeinterface getStatusCode : ()I
    //   766: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   769: aload #9
    //   771: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   776: invokeinterface getReasonPhrase : ()Ljava/lang/String;
    //   781: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   784: athrow
    //   785: aload_0
    //   786: aload #9
    //   788: iload_3
    //   789: aload #8
    //   791: invokespecial a : (Lorg/apache/http/HttpResponse;ILjava/lang/String;)Lcom/alipay/android/phone/mrpc/core/u;
    //   794: astore #8
    //   796: aload #8
    //   798: ifnull -> 1725
    //   801: aload #8
    //   803: invokevirtual b : ()[B
    //   806: ifnull -> 1725
    //   809: aload #8
    //   811: invokevirtual b : ()[B
    //   814: arraylength
    //   815: i2l
    //   816: lstore #4
    //   818: goto -> 821
    //   821: lload #4
    //   823: ldc2_w -1
    //   826: lcmp
    //   827: ifne -> 860
    //   830: aload #8
    //   832: instanceof com/alipay/android/phone/mrpc/core/p
    //   835: ifeq -> 860
    //   838: aload #8
    //   840: checkcast com/alipay/android/phone/mrpc/core/p
    //   843: astore #9
    //   845: aload #9
    //   847: invokevirtual a : ()Lcom/alipay/android/phone/mrpc/core/HttpUrlHeader;
    //   850: ldc_w 'Content-Length'
    //   853: invokevirtual getHead : (Ljava/lang/String;)Ljava/lang/String;
    //   856: invokestatic parseLong : (Ljava/lang/String;)J
    //   859: pop2
    //   860: aload_0
    //   861: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   864: invokevirtual a : ()Ljava/lang/String;
    //   867: astore #9
    //   869: aload #9
    //   871: ifnull -> 1733
    //   874: aload_0
    //   875: invokespecial f : ()Ljava/lang/String;
    //   878: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   881: ifne -> 1733
    //   884: new java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial <init> : ()V
    //   891: astore #10
    //   893: aload #10
    //   895: aload #9
    //   897: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload #10
    //   903: ldc_w '#'
    //   906: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload #10
    //   912: aload_0
    //   913: invokespecial f : ()Ljava/lang/String;
    //   916: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload #8
    //   922: areturn
    //   923: new com/alipay/android/phone/mrpc/core/HttpException
    //   926: dup
    //   927: iconst_1
    //   928: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   931: ldc_w 'The network is not available'
    //   934: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   937: athrow
    //   938: astore #8
    //   940: aload_0
    //   941: invokespecial e : ()V
    //   944: aload_0
    //   945: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   948: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   951: ifnull -> 967
    //   954: new java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial <init> : ()V
    //   961: aload #8
    //   963: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: new com/alipay/android/phone/mrpc/core/HttpException
    //   970: dup
    //   971: iconst_0
    //   972: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   975: aload #8
    //   977: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   980: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   983: athrow
    //   984: astore #8
    //   986: aload_0
    //   987: invokespecial e : ()V
    //   990: aload_0
    //   991: getfield m : I
    //   994: istore_1
    //   995: iload_1
    //   996: ifgt -> 1009
    //   999: aload_0
    //   1000: iload_1
    //   1001: iconst_1
    //   1002: iadd
    //   1003: putfield m : I
    //   1006: goto -> 0
    //   1009: new java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial <init> : ()V
    //   1016: aload #8
    //   1018: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: new com/alipay/android/phone/mrpc/core/HttpException
    //   1025: dup
    //   1026: iconst_0
    //   1027: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1030: aload #8
    //   1032: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1035: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1038: athrow
    //   1039: astore #8
    //   1041: aload_0
    //   1042: invokespecial e : ()V
    //   1045: aload_0
    //   1046: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1049: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1052: ifnull -> 1068
    //   1055: new java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial <init> : ()V
    //   1062: aload #8
    //   1064: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: new java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial <init> : ()V
    //   1075: aload #8
    //   1077: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: new com/alipay/android/phone/mrpc/core/HttpException
    //   1084: dup
    //   1085: bipush #6
    //   1087: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1090: aload #8
    //   1092: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1095: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1098: athrow
    //   1099: astore #8
    //   1101: aload_0
    //   1102: invokespecial e : ()V
    //   1105: aload_0
    //   1106: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1109: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1112: ifnull -> 1128
    //   1115: new java/lang/StringBuilder
    //   1118: dup
    //   1119: invokespecial <init> : ()V
    //   1122: aload #8
    //   1124: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: new java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial <init> : ()V
    //   1135: aload #8
    //   1137: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: new com/alipay/android/phone/mrpc/core/HttpException
    //   1144: dup
    //   1145: bipush #9
    //   1147: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1150: aload #8
    //   1152: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1155: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1158: athrow
    //   1159: astore #8
    //   1161: aload_0
    //   1162: invokespecial e : ()V
    //   1165: aload_0
    //   1166: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1169: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1172: ifnull -> 1188
    //   1175: new java/lang/StringBuilder
    //   1178: dup
    //   1179: invokespecial <init> : ()V
    //   1182: aload #8
    //   1184: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: new com/alipay/android/phone/mrpc/core/HttpException
    //   1191: dup
    //   1192: bipush #8
    //   1194: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1197: aload #8
    //   1199: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1202: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1205: athrow
    //   1206: astore #8
    //   1208: aload_0
    //   1209: invokespecial e : ()V
    //   1212: aload_0
    //   1213: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1216: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1219: ifnull -> 1235
    //   1222: new java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial <init> : ()V
    //   1229: aload #8
    //   1231: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: new java/lang/StringBuilder
    //   1238: dup
    //   1239: invokespecial <init> : ()V
    //   1242: aload #8
    //   1244: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: new com/alipay/android/phone/mrpc/core/HttpException
    //   1251: dup
    //   1252: iconst_5
    //   1253: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1256: aload #8
    //   1258: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1261: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1264: athrow
    //   1265: astore #8
    //   1267: aload_0
    //   1268: invokespecial e : ()V
    //   1271: aload_0
    //   1272: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1275: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1278: ifnull -> 1294
    //   1281: new java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial <init> : ()V
    //   1288: aload #8
    //   1290: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: new java/lang/StringBuilder
    //   1297: dup
    //   1298: invokespecial <init> : ()V
    //   1301: aload #8
    //   1303: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: new com/alipay/android/phone/mrpc/core/HttpException
    //   1310: dup
    //   1311: iconst_4
    //   1312: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1315: aload #8
    //   1317: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1320: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1323: athrow
    //   1324: astore #8
    //   1326: aload_0
    //   1327: invokespecial e : ()V
    //   1330: aload_0
    //   1331: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1334: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1337: ifnull -> 1353
    //   1340: new java/lang/StringBuilder
    //   1343: dup
    //   1344: invokespecial <init> : ()V
    //   1347: aload #8
    //   1349: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1352: pop
    //   1353: new java/lang/StringBuilder
    //   1356: dup
    //   1357: invokespecial <init> : ()V
    //   1360: aload #8
    //   1362: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: new com/alipay/android/phone/mrpc/core/HttpException
    //   1369: dup
    //   1370: iconst_3
    //   1371: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1374: aload #8
    //   1376: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1379: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1382: athrow
    //   1383: astore #8
    //   1385: aload_0
    //   1386: invokespecial e : ()V
    //   1389: aload_0
    //   1390: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1393: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1396: ifnull -> 1412
    //   1399: new java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial <init> : ()V
    //   1406: aload #8
    //   1408: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1411: pop
    //   1412: new java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial <init> : ()V
    //   1419: aload #8
    //   1421: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1424: pop
    //   1425: new com/alipay/android/phone/mrpc/core/HttpException
    //   1428: dup
    //   1429: iconst_3
    //   1430: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1433: aload #8
    //   1435: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1438: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1441: athrow
    //   1442: astore #8
    //   1444: aload_0
    //   1445: invokespecial e : ()V
    //   1448: aload_0
    //   1449: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1452: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1455: ifnull -> 1471
    //   1458: new java/lang/StringBuilder
    //   1461: dup
    //   1462: invokespecial <init> : ()V
    //   1465: aload #8
    //   1467: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: new java/lang/StringBuilder
    //   1474: dup
    //   1475: invokespecial <init> : ()V
    //   1478: aload #8
    //   1480: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: new com/alipay/android/phone/mrpc/core/HttpException
    //   1487: dup
    //   1488: bipush #6
    //   1490: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1493: aload #8
    //   1495: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1498: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1501: athrow
    //   1502: astore #8
    //   1504: aload_0
    //   1505: invokespecial e : ()V
    //   1508: aload_0
    //   1509: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1512: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1515: ifnull -> 1531
    //   1518: new java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial <init> : ()V
    //   1525: aload #8
    //   1527: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1530: pop
    //   1531: new java/lang/StringBuilder
    //   1534: dup
    //   1535: invokespecial <init> : ()V
    //   1538: aload #8
    //   1540: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: new com/alipay/android/phone/mrpc/core/HttpException
    //   1547: dup
    //   1548: iconst_2
    //   1549: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1552: aload #8
    //   1554: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1557: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1560: athrow
    //   1561: astore #8
    //   1563: aload_0
    //   1564: invokespecial e : ()V
    //   1567: aload_0
    //   1568: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1571: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1574: ifnull -> 1590
    //   1577: new java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial <init> : ()V
    //   1584: aload #8
    //   1586: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1589: pop
    //   1590: new java/lang/StringBuilder
    //   1593: dup
    //   1594: invokespecial <init> : ()V
    //   1597: aload #8
    //   1599: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: new com/alipay/android/phone/mrpc/core/HttpException
    //   1606: dup
    //   1607: iconst_2
    //   1608: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1611: aload #8
    //   1613: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1616: invokespecial <init> : (Ljava/lang/Integer;Ljava/lang/String;)V
    //   1619: athrow
    //   1620: astore #8
    //   1622: new java/lang/RuntimeException
    //   1625: dup
    //   1626: ldc_w 'Url parser error!'
    //   1629: aload #8
    //   1631: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   1634: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1637: athrow
    //   1638: astore #8
    //   1640: aload_0
    //   1641: invokespecial e : ()V
    //   1644: aload_0
    //   1645: getfield c : Lcom/alipay/android/phone/mrpc/core/o;
    //   1648: invokevirtual f : ()Lcom/alipay/android/phone/mrpc/core/ac;
    //   1651: ifnull -> 1666
    //   1654: aload #8
    //   1656: invokevirtual getCode : ()I
    //   1659: pop
    //   1660: aload #8
    //   1662: invokevirtual getMsg : ()Ljava/lang/String;
    //   1665: pop
    //   1666: new java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial <init> : ()V
    //   1673: aload #8
    //   1675: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: aload #8
    //   1681: athrow
    //   1682: astore #9
    //   1684: goto -> 860
    //   1687: iconst_0
    //   1688: istore_1
    //   1689: goto -> 71
    //   1692: iload_1
    //   1693: iconst_1
    //   1694: iadd
    //   1695: istore_1
    //   1696: goto -> 34
    //   1699: aconst_null
    //   1700: astore #8
    //   1702: goto -> 338
    //   1705: goto -> 375
    //   1708: ldc_w ''
    //   1711: astore #8
    //   1713: goto -> 664
    //   1716: iconst_0
    //   1717: istore_1
    //   1718: iload_1
    //   1719: ifeq -> 750
    //   1722: goto -> 785
    //   1725: ldc2_w -1
    //   1728: lstore #4
    //   1730: goto -> 821
    //   1733: aload #8
    //   1735: areturn
    // Exception table:
    //   from	to	target	type
    //   0	18	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   0	18	1620	java/net/URISyntaxException
    //   0	18	1561	javax/net/ssl/SSLHandshakeException
    //   0	18	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   0	18	1442	javax/net/ssl/SSLException
    //   0	18	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   0	18	1324	org/apache/http/conn/ConnectTimeoutException
    //   0	18	1265	java/net/SocketTimeoutException
    //   0	18	1206	org/apache/http/NoHttpResponseException
    //   0	18	1159	org/apache/http/conn/HttpHostConnectException
    //   0	18	1099	java/net/UnknownHostException
    //   0	18	1039	java/io/IOException
    //   0	18	984	java/lang/NullPointerException
    //   0	18	938	java/lang/Exception
    //   28	32	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   28	32	1620	java/net/URISyntaxException
    //   28	32	1561	javax/net/ssl/SSLHandshakeException
    //   28	32	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   28	32	1442	javax/net/ssl/SSLException
    //   28	32	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   28	32	1324	org/apache/http/conn/ConnectTimeoutException
    //   28	32	1265	java/net/SocketTimeoutException
    //   28	32	1206	org/apache/http/NoHttpResponseException
    //   28	32	1159	org/apache/http/conn/HttpHostConnectException
    //   28	32	1099	java/net/UnknownHostException
    //   28	32	1039	java/io/IOException
    //   28	32	984	java/lang/NullPointerException
    //   28	32	938	java/lang/Exception
    //   50	66	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   50	66	1620	java/net/URISyntaxException
    //   50	66	1561	javax/net/ssl/SSLHandshakeException
    //   50	66	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   50	66	1442	javax/net/ssl/SSLException
    //   50	66	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   50	66	1324	org/apache/http/conn/ConnectTimeoutException
    //   50	66	1265	java/net/SocketTimeoutException
    //   50	66	1206	org/apache/http/NoHttpResponseException
    //   50	66	1159	org/apache/http/conn/HttpHostConnectException
    //   50	66	1099	java/net/UnknownHostException
    //   50	66	1039	java/io/IOException
    //   50	66	984	java/lang/NullPointerException
    //   50	66	938	java/lang/Exception
    //   75	84	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   75	84	1620	java/net/URISyntaxException
    //   75	84	1561	javax/net/ssl/SSLHandshakeException
    //   75	84	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   75	84	1442	javax/net/ssl/SSLException
    //   75	84	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   75	84	1324	org/apache/http/conn/ConnectTimeoutException
    //   75	84	1265	java/net/SocketTimeoutException
    //   75	84	1206	org/apache/http/NoHttpResponseException
    //   75	84	1159	org/apache/http/conn/HttpHostConnectException
    //   75	84	1099	java/net/UnknownHostException
    //   75	84	1039	java/io/IOException
    //   75	84	984	java/lang/NullPointerException
    //   75	84	938	java/lang/Exception
    //   89	104	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   89	104	1620	java/net/URISyntaxException
    //   89	104	1561	javax/net/ssl/SSLHandshakeException
    //   89	104	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   89	104	1442	javax/net/ssl/SSLException
    //   89	104	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   89	104	1324	org/apache/http/conn/ConnectTimeoutException
    //   89	104	1265	java/net/SocketTimeoutException
    //   89	104	1206	org/apache/http/NoHttpResponseException
    //   89	104	1159	org/apache/http/conn/HttpHostConnectException
    //   89	104	1099	java/net/UnknownHostException
    //   89	104	1039	java/io/IOException
    //   89	104	984	java/lang/NullPointerException
    //   89	104	938	java/lang/Exception
    //   104	137	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   104	137	1620	java/net/URISyntaxException
    //   104	137	1561	javax/net/ssl/SSLHandshakeException
    //   104	137	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   104	137	1442	javax/net/ssl/SSLException
    //   104	137	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   104	137	1324	org/apache/http/conn/ConnectTimeoutException
    //   104	137	1265	java/net/SocketTimeoutException
    //   104	137	1206	org/apache/http/NoHttpResponseException
    //   104	137	1159	org/apache/http/conn/HttpHostConnectException
    //   104	137	1099	java/net/UnknownHostException
    //   104	137	1039	java/io/IOException
    //   104	137	984	java/lang/NullPointerException
    //   104	137	938	java/lang/Exception
    //   140	293	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   140	293	1620	java/net/URISyntaxException
    //   140	293	1561	javax/net/ssl/SSLHandshakeException
    //   140	293	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   140	293	1442	javax/net/ssl/SSLException
    //   140	293	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   140	293	1324	org/apache/http/conn/ConnectTimeoutException
    //   140	293	1265	java/net/SocketTimeoutException
    //   140	293	1206	org/apache/http/NoHttpResponseException
    //   140	293	1159	org/apache/http/conn/HttpHostConnectException
    //   140	293	1099	java/net/UnknownHostException
    //   140	293	1039	java/io/IOException
    //   140	293	984	java/lang/NullPointerException
    //   140	293	938	java/lang/Exception
    //   301	318	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   301	318	1620	java/net/URISyntaxException
    //   301	318	1561	javax/net/ssl/SSLHandshakeException
    //   301	318	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   301	318	1442	javax/net/ssl/SSLException
    //   301	318	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   301	318	1324	org/apache/http/conn/ConnectTimeoutException
    //   301	318	1265	java/net/SocketTimeoutException
    //   301	318	1206	org/apache/http/NoHttpResponseException
    //   301	318	1159	org/apache/http/conn/HttpHostConnectException
    //   301	318	1099	java/net/UnknownHostException
    //   301	318	1039	java/io/IOException
    //   301	318	984	java/lang/NullPointerException
    //   301	318	938	java/lang/Exception
    //   323	335	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   323	335	1620	java/net/URISyntaxException
    //   323	335	1561	javax/net/ssl/SSLHandshakeException
    //   323	335	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   323	335	1442	javax/net/ssl/SSLException
    //   323	335	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   323	335	1324	org/apache/http/conn/ConnectTimeoutException
    //   323	335	1265	java/net/SocketTimeoutException
    //   323	335	1206	org/apache/http/NoHttpResponseException
    //   323	335	1159	org/apache/http/conn/HttpHostConnectException
    //   323	335	1099	java/net/UnknownHostException
    //   323	335	1039	java/io/IOException
    //   323	335	984	java/lang/NullPointerException
    //   323	335	938	java/lang/Exception
    //   343	368	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   343	368	1620	java/net/URISyntaxException
    //   343	368	1561	javax/net/ssl/SSLHandshakeException
    //   343	368	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   343	368	1442	javax/net/ssl/SSLException
    //   343	368	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   343	368	1324	org/apache/http/conn/ConnectTimeoutException
    //   343	368	1265	java/net/SocketTimeoutException
    //   343	368	1206	org/apache/http/NoHttpResponseException
    //   343	368	1159	org/apache/http/conn/HttpHostConnectException
    //   343	368	1099	java/net/UnknownHostException
    //   343	368	1039	java/io/IOException
    //   343	368	984	java/lang/NullPointerException
    //   343	368	938	java/lang/Exception
    //   375	395	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   375	395	1620	java/net/URISyntaxException
    //   375	395	1561	javax/net/ssl/SSLHandshakeException
    //   375	395	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   375	395	1442	javax/net/ssl/SSLException
    //   375	395	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   375	395	1324	org/apache/http/conn/ConnectTimeoutException
    //   375	395	1265	java/net/SocketTimeoutException
    //   375	395	1206	org/apache/http/NoHttpResponseException
    //   375	395	1159	org/apache/http/conn/HttpHostConnectException
    //   375	395	1099	java/net/UnknownHostException
    //   375	395	1039	java/io/IOException
    //   375	395	984	java/lang/NullPointerException
    //   375	395	938	java/lang/Exception
    //   395	401	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   395	401	1620	java/net/URISyntaxException
    //   395	401	1561	javax/net/ssl/SSLHandshakeException
    //   395	401	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   395	401	1442	javax/net/ssl/SSLException
    //   395	401	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   395	401	1324	org/apache/http/conn/ConnectTimeoutException
    //   395	401	1265	java/net/SocketTimeoutException
    //   395	401	1206	org/apache/http/NoHttpResponseException
    //   395	401	1159	org/apache/http/conn/HttpHostConnectException
    //   395	401	1099	java/net/UnknownHostException
    //   395	401	1039	java/io/IOException
    //   395	401	984	java/lang/NullPointerException
    //   395	401	938	java/lang/Exception
    //   404	435	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   404	435	1620	java/net/URISyntaxException
    //   404	435	1561	javax/net/ssl/SSLHandshakeException
    //   404	435	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   404	435	1442	javax/net/ssl/SSLException
    //   404	435	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   404	435	1324	org/apache/http/conn/ConnectTimeoutException
    //   404	435	1265	java/net/SocketTimeoutException
    //   404	435	1206	org/apache/http/NoHttpResponseException
    //   404	435	1159	org/apache/http/conn/HttpHostConnectException
    //   404	435	1099	java/net/UnknownHostException
    //   404	435	1039	java/io/IOException
    //   404	435	984	java/lang/NullPointerException
    //   404	435	938	java/lang/Exception
    //   438	463	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   438	463	1620	java/net/URISyntaxException
    //   438	463	1561	javax/net/ssl/SSLHandshakeException
    //   438	463	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   438	463	1442	javax/net/ssl/SSLException
    //   438	463	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   438	463	1324	org/apache/http/conn/ConnectTimeoutException
    //   438	463	1265	java/net/SocketTimeoutException
    //   438	463	1206	org/apache/http/NoHttpResponseException
    //   438	463	1159	org/apache/http/conn/HttpHostConnectException
    //   438	463	1099	java/net/UnknownHostException
    //   438	463	1039	java/io/IOException
    //   438	463	984	java/lang/NullPointerException
    //   438	463	938	java/lang/Exception
    //   463	530	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   463	530	1620	java/net/URISyntaxException
    //   463	530	1561	javax/net/ssl/SSLHandshakeException
    //   463	530	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   463	530	1442	javax/net/ssl/SSLException
    //   463	530	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   463	530	1324	org/apache/http/conn/ConnectTimeoutException
    //   463	530	1265	java/net/SocketTimeoutException
    //   463	530	1206	org/apache/http/NoHttpResponseException
    //   463	530	1159	org/apache/http/conn/HttpHostConnectException
    //   463	530	1099	java/net/UnknownHostException
    //   463	530	1039	java/io/IOException
    //   463	530	984	java/lang/NullPointerException
    //   463	530	938	java/lang/Exception
    //   530	549	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   530	549	1620	java/net/URISyntaxException
    //   530	549	1561	javax/net/ssl/SSLHandshakeException
    //   530	549	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   530	549	1442	javax/net/ssl/SSLException
    //   530	549	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   530	549	1324	org/apache/http/conn/ConnectTimeoutException
    //   530	549	1265	java/net/SocketTimeoutException
    //   530	549	1206	org/apache/http/NoHttpResponseException
    //   530	549	1159	org/apache/http/conn/HttpHostConnectException
    //   530	549	1099	java/net/UnknownHostException
    //   530	549	1039	java/io/IOException
    //   530	549	984	java/lang/NullPointerException
    //   530	549	938	java/lang/Exception
    //   549	656	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   549	656	1620	java/net/URISyntaxException
    //   549	656	1561	javax/net/ssl/SSLHandshakeException
    //   549	656	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   549	656	1442	javax/net/ssl/SSLException
    //   549	656	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   549	656	1324	org/apache/http/conn/ConnectTimeoutException
    //   549	656	1265	java/net/SocketTimeoutException
    //   549	656	1206	org/apache/http/NoHttpResponseException
    //   549	656	1159	org/apache/http/conn/HttpHostConnectException
    //   549	656	1099	java/net/UnknownHostException
    //   549	656	1039	java/io/IOException
    //   549	656	984	java/lang/NullPointerException
    //   549	656	938	java/lang/Exception
    //   664	701	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   664	701	1620	java/net/URISyntaxException
    //   664	701	1561	javax/net/ssl/SSLHandshakeException
    //   664	701	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   664	701	1442	javax/net/ssl/SSLException
    //   664	701	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   664	701	1324	org/apache/http/conn/ConnectTimeoutException
    //   664	701	1265	java/net/SocketTimeoutException
    //   664	701	1206	org/apache/http/NoHttpResponseException
    //   664	701	1159	org/apache/http/conn/HttpHostConnectException
    //   664	701	1099	java/net/UnknownHostException
    //   664	701	1039	java/io/IOException
    //   664	701	984	java/lang/NullPointerException
    //   664	701	938	java/lang/Exception
    //   704	731	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   704	731	1620	java/net/URISyntaxException
    //   704	731	1561	javax/net/ssl/SSLHandshakeException
    //   704	731	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   704	731	1442	javax/net/ssl/SSLException
    //   704	731	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   704	731	1324	org/apache/http/conn/ConnectTimeoutException
    //   704	731	1265	java/net/SocketTimeoutException
    //   704	731	1206	org/apache/http/NoHttpResponseException
    //   704	731	1159	org/apache/http/conn/HttpHostConnectException
    //   704	731	1099	java/net/UnknownHostException
    //   704	731	1039	java/io/IOException
    //   704	731	984	java/lang/NullPointerException
    //   704	731	938	java/lang/Exception
    //   750	785	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   750	785	1620	java/net/URISyntaxException
    //   750	785	1561	javax/net/ssl/SSLHandshakeException
    //   750	785	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   750	785	1442	javax/net/ssl/SSLException
    //   750	785	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   750	785	1324	org/apache/http/conn/ConnectTimeoutException
    //   750	785	1265	java/net/SocketTimeoutException
    //   750	785	1206	org/apache/http/NoHttpResponseException
    //   750	785	1159	org/apache/http/conn/HttpHostConnectException
    //   750	785	1099	java/net/UnknownHostException
    //   750	785	1039	java/io/IOException
    //   750	785	984	java/lang/NullPointerException
    //   750	785	938	java/lang/Exception
    //   785	796	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   785	796	1620	java/net/URISyntaxException
    //   785	796	1561	javax/net/ssl/SSLHandshakeException
    //   785	796	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   785	796	1442	javax/net/ssl/SSLException
    //   785	796	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   785	796	1324	org/apache/http/conn/ConnectTimeoutException
    //   785	796	1265	java/net/SocketTimeoutException
    //   785	796	1206	org/apache/http/NoHttpResponseException
    //   785	796	1159	org/apache/http/conn/HttpHostConnectException
    //   785	796	1099	java/net/UnknownHostException
    //   785	796	1039	java/io/IOException
    //   785	796	984	java/lang/NullPointerException
    //   785	796	938	java/lang/Exception
    //   801	818	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   801	818	1620	java/net/URISyntaxException
    //   801	818	1561	javax/net/ssl/SSLHandshakeException
    //   801	818	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   801	818	1442	javax/net/ssl/SSLException
    //   801	818	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   801	818	1324	org/apache/http/conn/ConnectTimeoutException
    //   801	818	1265	java/net/SocketTimeoutException
    //   801	818	1206	org/apache/http/NoHttpResponseException
    //   801	818	1159	org/apache/http/conn/HttpHostConnectException
    //   801	818	1099	java/net/UnknownHostException
    //   801	818	1039	java/io/IOException
    //   801	818	984	java/lang/NullPointerException
    //   801	818	938	java/lang/Exception
    //   830	845	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   830	845	1620	java/net/URISyntaxException
    //   830	845	1561	javax/net/ssl/SSLHandshakeException
    //   830	845	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   830	845	1442	javax/net/ssl/SSLException
    //   830	845	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   830	845	1324	org/apache/http/conn/ConnectTimeoutException
    //   830	845	1265	java/net/SocketTimeoutException
    //   830	845	1206	org/apache/http/NoHttpResponseException
    //   830	845	1159	org/apache/http/conn/HttpHostConnectException
    //   830	845	1099	java/net/UnknownHostException
    //   830	845	1039	java/io/IOException
    //   830	845	984	java/lang/NullPointerException
    //   830	845	938	java/lang/Exception
    //   845	860	1682	java/lang/Exception
    //   845	860	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   845	860	1620	java/net/URISyntaxException
    //   845	860	1561	javax/net/ssl/SSLHandshakeException
    //   845	860	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   845	860	1442	javax/net/ssl/SSLException
    //   845	860	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   845	860	1324	org/apache/http/conn/ConnectTimeoutException
    //   845	860	1265	java/net/SocketTimeoutException
    //   845	860	1206	org/apache/http/NoHttpResponseException
    //   845	860	1159	org/apache/http/conn/HttpHostConnectException
    //   845	860	1099	java/net/UnknownHostException
    //   845	860	1039	java/io/IOException
    //   845	860	984	java/lang/NullPointerException
    //   860	869	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   860	869	1620	java/net/URISyntaxException
    //   860	869	1561	javax/net/ssl/SSLHandshakeException
    //   860	869	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   860	869	1442	javax/net/ssl/SSLException
    //   860	869	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   860	869	1324	org/apache/http/conn/ConnectTimeoutException
    //   860	869	1265	java/net/SocketTimeoutException
    //   860	869	1206	org/apache/http/NoHttpResponseException
    //   860	869	1159	org/apache/http/conn/HttpHostConnectException
    //   860	869	1099	java/net/UnknownHostException
    //   860	869	1039	java/io/IOException
    //   860	869	984	java/lang/NullPointerException
    //   860	869	938	java/lang/Exception
    //   874	920	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   874	920	1620	java/net/URISyntaxException
    //   874	920	1561	javax/net/ssl/SSLHandshakeException
    //   874	920	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   874	920	1442	javax/net/ssl/SSLException
    //   874	920	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   874	920	1324	org/apache/http/conn/ConnectTimeoutException
    //   874	920	1265	java/net/SocketTimeoutException
    //   874	920	1206	org/apache/http/NoHttpResponseException
    //   874	920	1159	org/apache/http/conn/HttpHostConnectException
    //   874	920	1099	java/net/UnknownHostException
    //   874	920	1039	java/io/IOException
    //   874	920	984	java/lang/NullPointerException
    //   874	920	938	java/lang/Exception
    //   923	938	1638	com/alipay/android/phone/mrpc/core/HttpException
    //   923	938	1620	java/net/URISyntaxException
    //   923	938	1561	javax/net/ssl/SSLHandshakeException
    //   923	938	1502	javax/net/ssl/SSLPeerUnverifiedException
    //   923	938	1442	javax/net/ssl/SSLException
    //   923	938	1383	org/apache/http/conn/ConnectionPoolTimeoutException
    //   923	938	1324	org/apache/http/conn/ConnectTimeoutException
    //   923	938	1265	java/net/SocketTimeoutException
    //   923	938	1206	org/apache/http/NoHttpResponseException
    //   923	938	1159	org/apache/http/conn/HttpHostConnectException
    //   923	938	1099	java/net/UnknownHostException
    //   923	938	1039	java/io/IOException
    //   923	938	984	java/lang/NullPointerException
    //   923	938	938	java/lang/Exception
  }
  
  private void e() {
    HttpUriRequest httpUriRequest = this.f;
    if (httpUriRequest != null)
      httpUriRequest.abort(); 
  }
  
  private String f() {
    if (!TextUtils.isEmpty(this.q))
      return this.q; 
    this.q = this.c.b("operationType");
    return this.q;
  }
  
  private int g() {
    URL uRL = h();
    return (uRL.getPort() == -1) ? uRL.getDefaultPort() : uRL.getPort();
  }
  
  private URL h() {
    URL uRL = this.l;
    if (uRL != null)
      return uRL; 
    this.l = new URL(this.c.a());
    return this.l;
  }
  
  private CookieManager i() {
    CookieManager cookieManager = this.i;
    if (cookieManager != null)
      return cookieManager; 
    this.i = CookieManager.getInstance();
    return this.i;
  }
  
  public final o a() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */