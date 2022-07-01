package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.Response;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class WebViewSSLCheckThread extends Thread {
  private static final String a = WebViewSSLCheckThread.class.getSimpleName();
  
  private SSLSocketFactory b;
  
  private HostnameVerifier c;
  
  private SSLSocketFactory d;
  
  private X509HostnameVerifier e;
  
  private SslErrorHandler f;
  
  private String g;
  
  private Callback h;
  
  private Context i;
  
  private void b() {
    g.b(a, "callbackCancel: ");
    Callback callback = this.h;
    if (callback != null) {
      callback.b(this.i, this.g);
      return;
    } 
    if (this.f != null) {
      g.b(a, "callbackCancel 2: ");
      this.f.cancel();
    } 
  }
  
  private void c() {
    g.b(a, "callbackProceed: ");
    Callback callback = this.h;
    if (callback != null) {
      callback.a(this.i, this.g);
      return;
    } 
    SslErrorHandler sslErrorHandler = this.f;
    if (sslErrorHandler != null)
      sslErrorHandler.proceed(); 
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial run : ()V
    //   4: aload_0
    //   5: getfield d : Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   8: ifnull -> 313
    //   11: aload_0
    //   12: getfield e : Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   15: ifnull -> 313
    //   18: aload_0
    //   19: getfield f : Landroid/webkit/SslErrorHandler;
    //   22: ifnull -> 300
    //   25: aload_0
    //   26: getfield g : Ljava/lang/String;
    //   29: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   32: ifeq -> 38
    //   35: goto -> 300
    //   38: aload_0
    //   39: getfield d : Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   42: aload_0
    //   43: getfield e : Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   46: invokevirtual setHostnameVerifier : (Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   49: aload_0
    //   50: getfield d : Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   53: instanceof com/huawei/secure/android/common/ssl/SecureApacheSSLSocketFactory
    //   56: ifeq -> 73
    //   59: aload_0
    //   60: getfield d : Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   63: checkcast com/huawei/secure/android/common/ssl/SecureApacheSSLSocketFactory
    //   66: aload_0
    //   67: getfield i : Landroid/content/Context;
    //   70: invokevirtual a : (Landroid/content/Context;)V
    //   73: new org/apache/http/params/BasicHttpParams
    //   76: dup
    //   77: invokespecial <init> : ()V
    //   80: astore_1
    //   81: aload_1
    //   82: sipush #30000
    //   85: invokestatic setConnectionTimeout : (Lorg/apache/http/params/HttpParams;I)V
    //   88: aload_1
    //   89: sipush #30000
    //   92: invokestatic setSoTimeout : (Lorg/apache/http/params/HttpParams;I)V
    //   95: new org/apache/http/conn/scheme/SchemeRegistry
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore_2
    //   103: aload_2
    //   104: new org/apache/http/conn/scheme/Scheme
    //   107: dup
    //   108: ldc 'https'
    //   110: aload_0
    //   111: getfield d : Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   114: sipush #443
    //   117: invokespecial <init> : (Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   120: invokevirtual register : (Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   123: pop
    //   124: aload_2
    //   125: new org/apache/http/conn/scheme/Scheme
    //   128: dup
    //   129: ldc 'http'
    //   131: invokestatic getSocketFactory : ()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   134: bipush #80
    //   136: invokespecial <init> : (Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   139: invokevirtual register : (Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   142: pop
    //   143: new org/apache/http/impl/client/DefaultHttpClient
    //   146: dup
    //   147: new org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   150: dup
    //   151: aload_1
    //   152: aload_2
    //   153: invokespecial <init> : (Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   156: aload_1
    //   157: invokespecial <init> : (Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   160: astore_1
    //   161: new org/apache/http/client/methods/HttpGet
    //   164: dup
    //   165: invokespecial <init> : ()V
    //   168: astore_2
    //   169: aload_2
    //   170: new java/net/URI
    //   173: dup
    //   174: aload_0
    //   175: getfield g : Ljava/lang/String;
    //   178: invokespecial <init> : (Ljava/lang/String;)V
    //   181: invokevirtual setURI : (Ljava/net/URI;)V
    //   184: aload_1
    //   185: aload_2
    //   186: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   191: astore_1
    //   192: getstatic com/huawei/secure/android/common/ssl/WebViewSSLCheckThread.a : Ljava/lang/String;
    //   195: astore_2
    //   196: new java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial <init> : ()V
    //   203: astore_3
    //   204: aload_3
    //   205: ldc 'status code is : '
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: aload_1
    //   213: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   218: invokeinterface getStatusCode : ()I
    //   223: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual toString : ()Ljava/lang/String;
    //   232: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   235: aconst_null
    //   236: invokestatic a : (Ljava/io/Reader;)V
    //   239: aload_0
    //   240: invokespecial c : ()V
    //   243: return
    //   244: astore_1
    //   245: goto -> 294
    //   248: astore_1
    //   249: getstatic com/huawei/secure/android/common/ssl/WebViewSSLCheckThread.a : Ljava/lang/String;
    //   252: astore_2
    //   253: new java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial <init> : ()V
    //   260: astore_3
    //   261: aload_3
    //   262: ldc 'run: exception : '
    //   264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_3
    //   269: aload_1
    //   270: invokevirtual getMessage : ()Ljava/lang/String;
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_2
    //   278: aload_3
    //   279: invokevirtual toString : ()Ljava/lang/String;
    //   282: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: invokespecial b : ()V
    //   289: aconst_null
    //   290: invokestatic a : (Ljava/io/Reader;)V
    //   293: return
    //   294: aconst_null
    //   295: invokestatic a : (Ljava/io/Reader;)V
    //   298: aload_1
    //   299: athrow
    //   300: getstatic com/huawei/secure/android/common/ssl/WebViewSSLCheckThread.a : Ljava/lang/String;
    //   303: ldc 'sslErrorHandler or url is null'
    //   305: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: invokespecial b : ()V
    //   312: return
    //   313: aload_0
    //   314: getfield b : Ljavax/net/ssl/SSLSocketFactory;
    //   317: ifnull -> 519
    //   320: aload_0
    //   321: getfield c : Ljavax/net/ssl/HostnameVerifier;
    //   324: ifnull -> 519
    //   327: new java/net/URL
    //   330: dup
    //   331: aload_0
    //   332: getfield g : Ljava/lang/String;
    //   335: invokespecial <init> : (Ljava/lang/String;)V
    //   338: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   341: astore_1
    //   342: aload_1
    //   343: instanceof javax/net/ssl/HttpsURLConnection
    //   346: ifeq -> 413
    //   349: aload_1
    //   350: checkcast javax/net/ssl/HttpsURLConnection
    //   353: astore_2
    //   354: aload_2
    //   355: astore_1
    //   356: aload_2
    //   357: aload_0
    //   358: getfield b : Ljavax/net/ssl/SSLSocketFactory;
    //   361: invokevirtual setSSLSocketFactory : (Ljavax/net/ssl/SSLSocketFactory;)V
    //   364: aload_2
    //   365: astore_1
    //   366: aload_2
    //   367: aload_0
    //   368: getfield c : Ljavax/net/ssl/HostnameVerifier;
    //   371: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   374: aload_2
    //   375: astore_1
    //   376: aload_2
    //   377: ldc 'GET'
    //   379: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   382: aload_2
    //   383: astore_1
    //   384: aload_2
    //   385: sipush #10000
    //   388: invokevirtual setConnectTimeout : (I)V
    //   391: aload_2
    //   392: astore_1
    //   393: aload_2
    //   394: sipush #20000
    //   397: invokevirtual setReadTimeout : (I)V
    //   400: aload_2
    //   401: astore_1
    //   402: aload_2
    //   403: invokevirtual connect : ()V
    //   406: goto -> 415
    //   409: astore_3
    //   410: goto -> 439
    //   413: aconst_null
    //   414: astore_2
    //   415: aload_2
    //   416: ifnull -> 423
    //   419: aload_2
    //   420: invokevirtual disconnect : ()V
    //   423: aload_0
    //   424: invokespecial c : ()V
    //   427: return
    //   428: astore_1
    //   429: aconst_null
    //   430: astore_2
    //   431: aload_1
    //   432: astore_3
    //   433: goto -> 509
    //   436: astore_3
    //   437: aconst_null
    //   438: astore_2
    //   439: aload_2
    //   440: astore_1
    //   441: getstatic com/huawei/secure/android/common/ssl/WebViewSSLCheckThread.a : Ljava/lang/String;
    //   444: astore #4
    //   446: aload_2
    //   447: astore_1
    //   448: new java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial <init> : ()V
    //   455: astore #5
    //   457: aload_2
    //   458: astore_1
    //   459: aload #5
    //   461: ldc 'exception : '
    //   463: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload_2
    //   468: astore_1
    //   469: aload #5
    //   471: aload_3
    //   472: invokevirtual getMessage : ()Ljava/lang/String;
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_2
    //   480: astore_1
    //   481: aload #4
    //   483: aload #5
    //   485: invokevirtual toString : ()Ljava/lang/String;
    //   488: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload_2
    //   492: astore_1
    //   493: aload_0
    //   494: invokespecial b : ()V
    //   497: aload_2
    //   498: ifnull -> 505
    //   501: aload_2
    //   502: invokevirtual disconnect : ()V
    //   505: return
    //   506: astore_3
    //   507: aload_1
    //   508: astore_2
    //   509: aload_2
    //   510: ifnull -> 517
    //   513: aload_2
    //   514: invokevirtual disconnect : ()V
    //   517: aload_3
    //   518: athrow
    //   519: aload_0
    //   520: invokespecial b : ()V
    //   523: return
    // Exception table:
    //   from	to	target	type
    //   38	73	248	java/lang/Exception
    //   38	73	244	finally
    //   73	235	248	java/lang/Exception
    //   73	235	244	finally
    //   249	289	244	finally
    //   327	354	436	java/lang/Exception
    //   327	354	428	finally
    //   356	364	409	java/lang/Exception
    //   356	364	506	finally
    //   366	374	409	java/lang/Exception
    //   366	374	506	finally
    //   376	382	409	java/lang/Exception
    //   376	382	506	finally
    //   384	391	409	java/lang/Exception
    //   384	391	506	finally
    //   393	400	409	java/lang/Exception
    //   393	400	506	finally
    //   402	406	409	java/lang/Exception
    //   402	406	506	finally
    //   441	446	506	finally
    //   448	457	506	finally
    //   459	467	506	finally
    //   469	479	506	finally
    //   481	491	506	finally
    //   493	497	506	finally
  }
  
  public static interface Callback {
    void a(Context param1Context, String param1String);
    
    void b(Context param1Context, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\WebViewSSLCheckThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */