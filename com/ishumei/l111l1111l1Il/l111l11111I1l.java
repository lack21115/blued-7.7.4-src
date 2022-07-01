package com.ishumei.l111l1111l1Il;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class l111l11111I1l {
  private static final String l1111l111111Il = "sm";
  
  private static final String l111l11111I1l = "Content-Type";
  
  private static final String l111l11111Il = "application/octet-stream";
  
  private static final String l111l11111lIl = "Content-Length";
  
  private static final String l111l1111l1Il = "Connection";
  
  private static String l111l1111lI1l = "POST";
  
  private static final String l111l1111llIl = "Close";
  
  private int l111l1111lIl;
  
  private int l11l1111I11l;
  
  private int l11l1111I1l;
  
  private long l11l1111I1ll;
  
  private SSLContext l11l1111Il = null;
  
  private TrustManager[] l11l1111Il1l = null;
  
  private KeyStore l11l1111Ill = null;
  
  private ArrayList<String> l11l1111lIIl = new ArrayList<String>();
  
  private String l1111l111111Il(byte[] paramArrayOfbyte, Map<String, String> paramMap, String paramString, boolean paramBoolean) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
      String str1;
      InputStream inputStream1;
      String str2;
      InputStream inputStream2 = null;
      try {
      
      } finally {
        paramMap = null;
        paramString = null;
        str1 = paramString;
        String str = str1;
        str2 = str1;
        str1 = str;
      } 
      l111l1111lIl.l1111l111111Il(inputStream1);
      l111l1111lIl.l1111l111111Il((Closeable)paramString);
      l111l1111lIl.l1111l111111Il((Closeable)str1);
      l111l1111lIl.l1111l111111Il((HttpURLConnection)str2);
      throw paramMap;
    } 
    throw new IOException("data is null");
  }
  
  private void l1111l111111Il(byte[] paramArrayOfbyte, Map<String, String> paramMap, String paramString, l1111l111111Il<?> paraml1111l111111Il) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 525
    //   4: aload_1
    //   5: arraylength
    //   6: ifeq -> 525
    //   9: aload #4
    //   11: ifnull -> 34
    //   14: aload #4
    //   16: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   19: ifnonnull -> 34
    //   22: aload #4
    //   24: new com/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: putfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   34: aconst_null
    //   35: astore #7
    //   37: aconst_null
    //   38: astore #10
    //   40: aload #4
    //   42: ifnull -> 536
    //   45: aload #4
    //   47: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   50: getfield l111l11111Il : I
    //   53: ifle -> 536
    //   56: iconst_1
    //   57: istore #5
    //   59: goto -> 62
    //   62: aload_3
    //   63: invokestatic l111l1111lI1l : (Ljava/lang/String;)Ljava/lang/String;
    //   66: astore #8
    //   68: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l1111l111111Il/l1111l111111Il;
    //   71: aload #8
    //   73: iload #5
    //   75: invokevirtual l1111l111111Il : (Ljava/lang/String;Z)Ljava/lang/String;
    //   78: astore #9
    //   80: aload #9
    //   82: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   85: ifeq -> 101
    //   88: new java/net/URL
    //   91: dup
    //   92: aload_3
    //   93: invokespecial <init> : (Ljava/lang/String;)V
    //   96: astore #6
    //   98: goto -> 140
    //   101: new java/net/URL
    //   104: dup
    //   105: getstatic android/util/Patterns.DOMAIN_NAME : Ljava/util/regex/Pattern;
    //   108: aload_3
    //   109: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   112: aload #9
    //   114: invokevirtual replaceFirst : (Ljava/lang/String;)Ljava/lang/String;
    //   117: invokespecial <init> : (Ljava/lang/String;)V
    //   120: astore #6
    //   122: aload #4
    //   124: ifnull -> 542
    //   127: aload #4
    //   129: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   132: aload #9
    //   134: putfield l11l1111I1l : Ljava/lang/String;
    //   137: goto -> 542
    //   140: aload #6
    //   142: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   145: checkcast java/net/HttpURLConnection
    //   148: astore #6
    //   150: aload_0
    //   151: getfield l111l1111lIl : I
    //   154: ifne -> 204
    //   157: aload #6
    //   159: checkcast javax/net/ssl/HttpsURLConnection
    //   162: new com/ishumei/l111l1111l1Il/l111l11111I1l$2
    //   165: dup
    //   166: aload_0
    //   167: aload #8
    //   169: invokespecial <init> : (Lcom/ishumei/l111l1111l1Il/l111l11111I1l;Ljava/lang/String;)V
    //   172: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   175: aload_0
    //   176: getfield l11l1111Il1l : [Ljavax/net/ssl/TrustManager;
    //   179: ifnull -> 204
    //   182: aload_0
    //   183: getfield l11l1111Il : Ljavax/net/ssl/SSLContext;
    //   186: ifnull -> 204
    //   189: aload #6
    //   191: checkcast javax/net/ssl/HttpsURLConnection
    //   194: aload_0
    //   195: getfield l11l1111Il : Ljavax/net/ssl/SSLContext;
    //   198: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   201: invokevirtual setSSLSocketFactory : (Ljavax/net/ssl/SSLSocketFactory;)V
    //   204: aload #6
    //   206: iconst_1
    //   207: invokevirtual setDoInput : (Z)V
    //   210: aload #6
    //   212: iconst_1
    //   213: invokevirtual setDoOutput : (Z)V
    //   216: aload #6
    //   218: iconst_0
    //   219: invokevirtual setUseCaches : (Z)V
    //   222: aload #6
    //   224: iconst_1
    //   225: invokevirtual setInstanceFollowRedirects : (Z)V
    //   228: aload #6
    //   230: getstatic com/ishumei/l111l1111l1Il/l111l11111I1l.l111l1111lI1l : Ljava/lang/String;
    //   233: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   236: aload #6
    //   238: ldc 'Content-Type'
    //   240: ldc 'application/octet-stream'
    //   242: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload #6
    //   247: ldc 'Connection'
    //   249: ldc 'Close'
    //   251: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload #6
    //   256: aload_0
    //   257: getfield l11l1111I11l : I
    //   260: invokevirtual setConnectTimeout : (I)V
    //   263: aload #6
    //   265: aload_0
    //   266: getfield l11l1111I1l : I
    //   269: invokevirtual setReadTimeout : (I)V
    //   272: aload #6
    //   274: aload_1
    //   275: arraylength
    //   276: invokevirtual setFixedLengthStreamingMode : (I)V
    //   279: aload_2
    //   280: ifnull -> 346
    //   283: aload_2
    //   284: invokeinterface entrySet : ()Ljava/util/Set;
    //   289: invokeinterface iterator : ()Ljava/util/Iterator;
    //   294: astore #8
    //   296: aload #8
    //   298: invokeinterface hasNext : ()Z
    //   303: ifeq -> 346
    //   306: aload #8
    //   308: invokeinterface next : ()Ljava/lang/Object;
    //   313: checkcast java/util/Map$Entry
    //   316: astore #9
    //   318: aload #6
    //   320: aload #9
    //   322: invokeinterface getKey : ()Ljava/lang/Object;
    //   327: checkcast java/lang/String
    //   330: aload #9
    //   332: invokeinterface getValue : ()Ljava/lang/Object;
    //   337: checkcast java/lang/String
    //   340: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   343: goto -> 296
    //   346: aload #6
    //   348: invokevirtual connect : ()V
    //   351: aload #6
    //   353: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   356: astore #9
    //   358: aload #9
    //   360: aload_1
    //   361: invokevirtual write : ([B)V
    //   364: aload #9
    //   366: invokevirtual flush : ()V
    //   369: aload #9
    //   371: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
    //   374: goto -> 467
    //   377: astore_2
    //   378: aload #9
    //   380: astore_1
    //   381: goto -> 519
    //   384: astore #7
    //   386: aload #6
    //   388: astore #8
    //   390: aload #9
    //   392: astore #6
    //   394: goto -> 429
    //   397: astore #7
    //   399: aconst_null
    //   400: astore #9
    //   402: aload #6
    //   404: astore #8
    //   406: aload #9
    //   408: astore #6
    //   410: goto -> 429
    //   413: astore_2
    //   414: aload #7
    //   416: astore_1
    //   417: goto -> 519
    //   420: astore #7
    //   422: aconst_null
    //   423: astore #6
    //   425: aload #6
    //   427: astore #8
    //   429: aload #8
    //   431: invokestatic l1111l111111Il : (Ljava/net/HttpURLConnection;)V
    //   434: aload #7
    //   436: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   439: pop
    //   440: aload #4
    //   442: ifnull -> 458
    //   445: aload #4
    //   447: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   450: aload #7
    //   452: invokevirtual toString : ()Ljava/lang/String;
    //   455: putfield l11l1111lIIl : Ljava/lang/String;
    //   458: aload #6
    //   460: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
    //   463: aload #10
    //   465: astore #6
    //   467: aload #4
    //   469: ifnull -> 514
    //   472: aload #4
    //   474: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   477: aload #6
    //   479: putfield l1111l111111Il : Ljava/net/HttpURLConnection;
    //   482: aload #4
    //   484: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   487: aload_1
    //   488: putfield l111l11111lIl : [B
    //   491: aload #4
    //   493: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   496: aload_2
    //   497: putfield l111l11111I1l : Ljava/util/Map;
    //   500: aload #4
    //   502: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
    //   505: aload_3
    //   506: putfield l11l1111I11l : Ljava/lang/String;
    //   509: aload #4
    //   511: invokevirtual l1111l111111Il : ()V
    //   514: return
    //   515: astore_2
    //   516: aload #6
    //   518: astore_1
    //   519: aload_1
    //   520: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
    //   523: aload_2
    //   524: athrow
    //   525: new java/io/IOException
    //   528: dup
    //   529: ldc_w 'data is null'
    //   532: invokespecial <init> : (Ljava/lang/String;)V
    //   535: athrow
    //   536: iconst_0
    //   537: istore #5
    //   539: goto -> 62
    //   542: goto -> 140
    // Exception table:
    //   from	to	target	type
    //   45	56	420	java/lang/Exception
    //   45	56	413	finally
    //   62	98	420	java/lang/Exception
    //   62	98	413	finally
    //   101	122	420	java/lang/Exception
    //   101	122	413	finally
    //   127	137	420	java/lang/Exception
    //   127	137	413	finally
    //   140	150	420	java/lang/Exception
    //   140	150	413	finally
    //   150	204	397	java/lang/Exception
    //   150	204	413	finally
    //   204	279	397	java/lang/Exception
    //   204	279	413	finally
    //   283	296	397	java/lang/Exception
    //   283	296	413	finally
    //   296	343	397	java/lang/Exception
    //   296	343	413	finally
    //   346	358	397	java/lang/Exception
    //   346	358	413	finally
    //   358	369	384	java/lang/Exception
    //   358	369	377	finally
    //   429	440	515	finally
    //   445	458	515	finally
  }
  
  public final l111l11111I1l l1111l111111Il(l1111l111111Il paraml1111l111111Il) {
    if (paraml1111l111111Il == null)
      return null; 
    int j = (paraml1111l111111Il.l111l1111llIl()).length;
    this.l111l1111lIl = paraml1111l111111Il.l111l11111Il();
    int i;
    for (i = 0; i < 3; i++)
      this.l11l1111lIIl.add(paraml1111l111111Il.l111l1111l1Il()); 
    for (i = 0; i < j; i++) {
      for (int k = 0; k < 2; k++)
        this.l11l1111lIIl.add(paraml1111l111111Il.l111l1111llIl()[i]); 
    } 
    this.l11l1111I11l = paraml1111l111111Il.l111l11111lIl() * 1000;
    this.l11l1111I1l = paraml1111l111111Il.l111l11111I1l() * 1000;
    this.l11l1111I1ll = (paraml1111l111111Il.l111l1111lIl() * 1000);
    if (1 == this.l111l1111lIl)
      return this; 
    try {
      if (paraml1111l111111Il.l1111l111111Il()) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paraml1111l111111Il.l111l1111lI1l());
        Certificate certificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null);
        keyStore.setCertificateEntry("smfp", certificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        this.l11l1111Il1l = trustManagerFactory.getTrustManagers();
        this.l11l1111Il = SSLContext.getInstance("SSL");
        this.l11l1111Il.init(null, this.l11l1111Il1l, null);
      } 
      return this;
    } catch (Exception exception) {
      this.l11l1111Il = null;
      this.l11l1111Il1l = null;
      return this;
    } 
  }
  
  public final String l1111l111111Il(byte[] paramArrayOfbyte, Map<String, String> paramMap) {
    int j = this.l11l1111lIIl.size();
    int i = 0;
    while (i < this.l11l1111lIIl.size()) {
      boolean bool;
      int k = i % j;
      String str = this.l11l1111lIIl.get(k);
      if (++i > 1) {
        bool = true;
      } else {
        bool = false;
      } 
      try {
        return l1111l111111Il(paramArrayOfbyte, (Map<String, String>)null, str, bool);
      } catch (Exception exception) {
        this.l11l1111lIIl.get(k);
        Log.getStackTraceString(exception);
      } 
    } 
    throw new Exception("all retry have fail");
  }
  
  public final String l1111l111111Il(byte[] paramArrayOfbyte, Map<String, String> paramMap, String paramString) {
    return l1111l111111Il(paramArrayOfbyte, (Map<String, String>)null, paramString, false);
  }
  
  public final void l1111l111111Il(byte[] paramArrayOfbyte, boolean paramBoolean, Map<String, String> paramMap, l1111l111111Il<?> paraml1111l111111Il) {
    if (paraml1111l111111Il != null)
      try {
        int i;
        com.ishumei.l111l11111lIl.l111l11111lIl l111l11111lIl = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
        if (l111l11111lIl == null) {
          i = 2;
        } else {
          i = l111l11111lIl.l111l1111l1Il();
        } 
        if (paraml1111l111111Il.l111l11111lIl == null)
          paraml1111l111111Il.l111l11111lIl = new l111l11111lIl(); 
        paraml1111l111111Il.l111l11111lIl.l111l11111Il = 0;
        paraml1111l111111Il.l111l11111lIl.l111l11111lIl = paramArrayOfbyte;
        paraml1111l111111Il.l111l11111lIl.l111l11111I1l = null;
        paraml1111l111111Il.l111l11111lIl.l111l1111lI1l = true;
        paraml1111l111111Il.l111l11111lIl.l111l1111l1Il = paraml1111l111111Il;
        paraml1111l111111Il.l111l11111lIl.l111l1111lIl = Math.min(i, this.l11l1111lIIl.size());
        paraml1111l111111Il.l111l11111lIl.l11l1111I11l = this.l11l1111lIIl.get(0);
        paraml1111l111111Il.l111l11111lIl.l11l1111I1ll = paramBoolean;
        paraml1111l111111Il.l111l11111lIl.l111l1111llIl = new com.ishumei.l111l11111I1l.l111l11111lIl<l111l11111lIl>(this, true, com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(), true, this.l11l1111I1ll, false) {
            public final void run() {
              l111l11111I1l.l111l11111lIl l111l11111lIl1 = (l111l11111I1l.l111l11111lIl)this.l1111l111111Il;
              if (l111l11111lIl1 != null)
                try {
                  if (l111l11111lIl1.l111l11111Il >= l111l11111I1l.l1111l111111Il(this.l111l11111lIl).size())
                    return; 
                  l111l11111I1l.l1111l111111Il(this.l111l11111lIl, l111l11111lIl1.l111l11111lIl, l111l11111lIl1.l111l11111I1l, l111l11111I1l.l1111l111111Il(this.l111l11111lIl).get(l111l11111lIl1.l111l11111Il), l111l11111lIl1.l111l1111l1Il);
                  return;
                } catch (Exception exception) {
                  Log.getStackTraceString(exception);
                  return;
                }  
              throw new Exception("sessionCache is null");
            }
          };
        paraml1111l111111Il.l111l11111lIl.l111l1111llIl.l1111l111111Il = paraml1111l111111Il.l111l11111lIl;
        l1111l111111Il(paramArrayOfbyte, (Map<String, String>)null, this.l11l1111lIIl.get(0), paraml1111l111111Il);
        return;
      } catch (Exception exception) {
        Log.getStackTraceString(exception);
        return;
      }  
    l1111l111111Il((byte[])exception, (Map<String, String>)null, this.l11l1111lIIl.get(0), paraml1111l111111Il);
  }
  
  public static abstract class l1111l111111Il<T> extends com.ishumei.l111l11111I1l.l111l11111lIl<T> {
    private static int l111l11111I1l = 0;
    
    private static int l111l11111Il = 1;
    
    private static int l111l1111l1Il = 2;
    
    private static int l111l1111llIl = 3;
    
    protected l111l11111I1l.l111l11111lIl l111l11111lIl = null;
    
    public l1111l111111Il(boolean param1Boolean, int param1Int) {
      super(param1Boolean, param1Int);
    }
    
    private l1111l111111Il(boolean param1Boolean1, int param1Int, boolean param1Boolean2) {
      super(param1Boolean1, param1Int, param1Boolean2);
    }
    
    private l1111l111111Il(boolean param1Boolean1, int param1Int, boolean param1Boolean2, long param1Long, boolean param1Boolean3) {
      super(param1Boolean1, param1Int, param1Boolean2, param1Long, param1Boolean3);
    }
    
    public abstract void l1111l111111Il(String param1String);
    
    public boolean l1111l111111Il(String param1String, int param1Int) {
      if (this.l111l11111lIl.l111l1111lI1l && this.l111l11111lIl.l111l11111Il + 1 < this.l111l11111lIl.l111l1111lIl) {
        l111l11111I1l.l111l11111lIl l111l11111lIl1 = this.l111l11111lIl;
        l111l11111lIl1.l111l11111Il++;
        l111l1111lIl.l1111l111111Il(this.l111l11111lIl.l1111l111111Il);
        l111l11111lIl1 = this.l111l11111lIl;
        l111l11111lIl1.l1111l111111Il = null;
        l111l11111lIl1.l111l1111llIl.l1111l111111Il();
        return false;
      } 
      return true;
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   4: getfield l11l1111lIIl : Ljava/lang/String;
      //   7: ifnull -> 32
      //   10: aload_0
      //   11: aload_0
      //   12: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   15: getfield l11l1111lIIl : Ljava/lang/String;
      //   18: iconst_1
      //   19: invokevirtual l1111l111111Il : (Ljava/lang/String;I)Z
      //   22: pop
      //   23: aload_0
      //   24: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   27: aconst_null
      //   28: putfield l11l1111lIIl : Ljava/lang/String;
      //   31: return
      //   32: aload_0
      //   33: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   36: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   39: ifnonnull -> 51
      //   42: aload_0
      //   43: ldc 'HttpUrlConnection is null'
      //   45: iconst_0
      //   46: invokevirtual l1111l111111Il : (Ljava/lang/String;I)Z
      //   49: pop
      //   50: return
      //   51: aload_0
      //   52: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   55: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   58: invokevirtual getResponseCode : ()I
      //   61: istore_1
      //   62: iload_1
      //   63: sipush #200
      //   66: if_icmpeq -> 96
      //   69: new java/lang/StringBuilder
      //   72: dup
      //   73: ldc 'responseCode: '
      //   75: invokespecial <init> : (Ljava/lang/String;)V
      //   78: astore_2
      //   79: aload_2
      //   80: iload_1
      //   81: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   84: pop
      //   85: aload_0
      //   86: aload_2
      //   87: invokevirtual toString : ()Ljava/lang/String;
      //   90: iconst_2
      //   91: invokevirtual l1111l111111Il : (Ljava/lang/String;I)Z
      //   94: pop
      //   95: return
      //   96: aload_0
      //   97: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   100: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   103: invokevirtual getInputStream : ()Ljava/io/InputStream;
      //   106: astore_2
      //   107: new java/io/BufferedReader
      //   110: dup
      //   111: new java/io/InputStreamReader
      //   114: dup
      //   115: aload_2
      //   116: invokespecial <init> : (Ljava/io/InputStream;)V
      //   119: invokespecial <init> : (Ljava/io/Reader;)V
      //   122: astore #7
      //   124: aload_2
      //   125: astore_3
      //   126: aload #7
      //   128: astore #4
      //   130: new java/lang/StringBuilder
      //   133: dup
      //   134: invokespecial <init> : ()V
      //   137: astore #5
      //   139: aload_2
      //   140: astore_3
      //   141: aload #7
      //   143: astore #4
      //   145: aload #7
      //   147: invokevirtual readLine : ()Ljava/lang/String;
      //   150: astore #6
      //   152: aload #6
      //   154: ifnull -> 174
      //   157: aload_2
      //   158: astore_3
      //   159: aload #7
      //   161: astore #4
      //   163: aload #5
      //   165: aload #6
      //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: pop
      //   171: goto -> 139
      //   174: aload_2
      //   175: astore_3
      //   176: aload #7
      //   178: astore #4
      //   180: aload_0
      //   181: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   184: getfield l11l1111I1l : Ljava/lang/String;
      //   187: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   190: ifne -> 222
      //   193: aload_2
      //   194: astore_3
      //   195: aload #7
      //   197: astore #4
      //   199: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l1111l111111Il/l1111l111111Il;
      //   202: aload_0
      //   203: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   206: getfield l11l1111I11l : Ljava/lang/String;
      //   209: invokestatic l111l1111lI1l : (Ljava/lang/String;)Ljava/lang/String;
      //   212: aload_0
      //   213: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   216: getfield l11l1111I1l : Ljava/lang/String;
      //   219: invokevirtual l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;)V
      //   222: aload_2
      //   223: astore_3
      //   224: aload #7
      //   226: astore #4
      //   228: aload_0
      //   229: aload #5
      //   231: invokevirtual toString : ()Ljava/lang/String;
      //   234: invokevirtual l1111l111111Il : (Ljava/lang/String;)V
      //   237: aload_2
      //   238: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
      //   241: aload #7
      //   243: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
      //   246: aload_0
      //   247: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   250: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   253: invokestatic l1111l111111Il : (Ljava/net/HttpURLConnection;)V
      //   256: return
      //   257: astore #6
      //   259: aload_2
      //   260: astore #5
      //   262: aload #7
      //   264: astore_2
      //   265: goto -> 306
      //   268: astore #4
      //   270: aconst_null
      //   271: astore #5
      //   273: goto -> 396
      //   276: astore #6
      //   278: aconst_null
      //   279: astore_3
      //   280: aload_2
      //   281: astore #5
      //   283: aload_3
      //   284: astore_2
      //   285: goto -> 306
      //   288: astore #4
      //   290: aconst_null
      //   291: astore #5
      //   293: aload #5
      //   295: astore_2
      //   296: goto -> 396
      //   299: astore #6
      //   301: aconst_null
      //   302: astore_2
      //   303: aload_2
      //   304: astore #5
      //   306: aload #5
      //   308: astore_3
      //   309: aload_2
      //   310: astore #4
      //   312: aload #6
      //   314: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
      //   317: pop
      //   318: aload #5
      //   320: astore_3
      //   321: aload_2
      //   322: astore #4
      //   324: new java/lang/StringBuilder
      //   327: dup
      //   328: ldc 'response content err: '
      //   330: invokespecial <init> : (Ljava/lang/String;)V
      //   333: astore #7
      //   335: aload #5
      //   337: astore_3
      //   338: aload_2
      //   339: astore #4
      //   341: aload #7
      //   343: aload #6
      //   345: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   348: pop
      //   349: aload #5
      //   351: astore_3
      //   352: aload_2
      //   353: astore #4
      //   355: aload_0
      //   356: aload #7
      //   358: invokevirtual toString : ()Ljava/lang/String;
      //   361: iconst_3
      //   362: invokevirtual l1111l111111Il : (Ljava/lang/String;I)Z
      //   365: pop
      //   366: aload #5
      //   368: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
      //   371: aload_2
      //   372: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
      //   375: aload_0
      //   376: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   379: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   382: invokestatic l1111l111111Il : (Ljava/net/HttpURLConnection;)V
      //   385: return
      //   386: astore_2
      //   387: aload #4
      //   389: astore #5
      //   391: aload_2
      //   392: astore #4
      //   394: aload_3
      //   395: astore_2
      //   396: aload_2
      //   397: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
      //   400: aload #5
      //   402: invokestatic l1111l111111Il : (Ljava/io/Closeable;)V
      //   405: aload_0
      //   406: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   409: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   412: invokestatic l1111l111111Il : (Ljava/net/HttpURLConnection;)V
      //   415: aload #4
      //   417: athrow
      //   418: astore_2
      //   419: aload_0
      //   420: getfield l111l11111lIl : Lcom/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl;
      //   423: getfield l1111l111111Il : Ljava/net/HttpURLConnection;
      //   426: invokestatic l1111l111111Il : (Ljava/net/HttpURLConnection;)V
      //   429: aload_2
      //   430: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
      //   433: pop
      //   434: aload_0
      //   435: aload_2
      //   436: invokevirtual getMessage : ()Ljava/lang/String;
      //   439: iconst_2
      //   440: invokevirtual l1111l111111Il : (Ljava/lang/String;I)Z
      //   443: pop
      //   444: return
      // Exception table:
      //   from	to	target	type
      //   51	62	418	java/lang/Exception
      //   96	107	299	java/lang/Exception
      //   96	107	288	finally
      //   107	124	276	java/lang/Exception
      //   107	124	268	finally
      //   130	139	257	java/lang/Exception
      //   130	139	386	finally
      //   145	152	257	java/lang/Exception
      //   145	152	386	finally
      //   163	171	257	java/lang/Exception
      //   163	171	386	finally
      //   180	193	257	java/lang/Exception
      //   180	193	386	finally
      //   199	222	257	java/lang/Exception
      //   199	222	386	finally
      //   228	237	257	java/lang/Exception
      //   228	237	386	finally
      //   312	318	386	finally
      //   324	335	386	finally
      //   341	349	386	finally
      //   355	366	386	finally
    }
  }
  
  public static final class l111l11111lIl {
    HttpURLConnection l1111l111111Il = null;
    
    Map<String, String> l111l11111I1l = null;
    
    public int l111l11111Il = -1;
    
    public byte[] l111l11111lIl = null;
    
    l111l11111I1l.l1111l111111Il l111l1111l1Il = null;
    
    boolean l111l1111lI1l = false;
    
    public int l111l1111lIl = 0;
    
    com.ishumei.l111l11111I1l.l111l11111lIl<l111l11111lIl> l111l1111llIl = null;
    
    public String l11l1111I11l;
    
    String l11l1111I1l;
    
    public boolean l11l1111I1ll;
    
    String l11l1111lIIl = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111l1Il\l111l11111I1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */