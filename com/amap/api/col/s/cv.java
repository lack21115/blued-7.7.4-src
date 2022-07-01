package com.amap.api.col.s;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

public final class cv {
  private static SoftReference<SSLContext> k;
  
  private static SoftReference<cw> m;
  
  private int a;
  
  private int b;
  
  private boolean c;
  
  private SSLContext d;
  
  private Proxy e;
  
  private volatile boolean f;
  
  private long g;
  
  private long h;
  
  private String i;
  
  private b j;
  
  private cs.a l;
  
  private String n;
  
  private boolean o;
  
  private String p;
  
  private cv(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield f : Z
    //   9: aload_0
    //   10: ldc2_w -1
    //   13: putfield g : J
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield h : J
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield o : Z
    //   26: aload_0
    //   27: ldc ''
    //   29: putfield p : Ljava/lang/String;
    //   32: aload_0
    //   33: iload_1
    //   34: putfield a : I
    //   37: aload_0
    //   38: iload_2
    //   39: putfield b : I
    //   42: aload_0
    //   43: aload_3
    //   44: putfield e : Ljava/net/Proxy;
    //   47: aload_0
    //   48: invokestatic a : ()Lcom/amap/api/col/s/bo;
    //   51: iload #4
    //   53: invokevirtual b : (Z)Z
    //   56: putfield c : Z
    //   59: invokestatic c : ()V
    //   62: invokestatic b : ()Z
    //   65: ifeq -> 73
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield c : Z
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield l : Lcom/amap/api/col/s/cs$a;
    //   78: aload_0
    //   79: invokestatic randomUUID : ()Ljava/util/UUID;
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: ldc '-'
    //   87: ldc ''
    //   89: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   95: putfield i : Ljava/lang/String;
    //   98: goto -> 110
    //   101: astore_3
    //   102: aload_3
    //   103: ldc 'ht'
    //   105: ldc 'ic'
    //   107: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield c : Z
    //   114: ifeq -> 208
    //   117: getstatic com/amap/api/col/s/cv.k : Ljava/lang/ref/SoftReference;
    //   120: ifnull -> 132
    //   123: getstatic com/amap/api/col/s/cv.k : Ljava/lang/ref/SoftReference;
    //   126: invokevirtual get : ()Ljava/lang/Object;
    //   129: ifnonnull -> 147
    //   132: new java/lang/ref/SoftReference
    //   135: dup
    //   136: ldc 'TLS'
    //   138: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   141: invokespecial <init> : (Ljava/lang/Object;)V
    //   144: putstatic com/amap/api/col/s/cv.k : Ljava/lang/ref/SoftReference;
    //   147: getstatic com/amap/api/col/s/cv.k : Ljava/lang/ref/SoftReference;
    //   150: ifnull -> 166
    //   153: getstatic com/amap/api/col/s/cv.k : Ljava/lang/ref/SoftReference;
    //   156: invokevirtual get : ()Ljava/lang/Object;
    //   159: checkcast javax/net/ssl/SSLContext
    //   162: astore_3
    //   163: goto -> 168
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore #5
    //   171: aload_3
    //   172: ifnonnull -> 182
    //   175: ldc 'TLS'
    //   177: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   180: astore #5
    //   182: aload #5
    //   184: aconst_null
    //   185: aconst_null
    //   186: aconst_null
    //   187: invokevirtual init : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   190: aload_0
    //   191: aload #5
    //   193: putfield d : Ljavax/net/ssl/SSLContext;
    //   196: goto -> 208
    //   199: astore_3
    //   200: aload_3
    //   201: ldc 'ht'
    //   203: ldc 'ne'
    //   205: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: new com/amap/api/col/s/cv$b
    //   212: dup
    //   213: iconst_0
    //   214: invokespecial <init> : (B)V
    //   217: putfield j : Lcom/amap/api/col/s/cv$b;
    //   220: return
    //   221: astore_3
    //   222: goto -> 166
    // Exception table:
    //   from	to	target	type
    //   78	98	101	finally
    //   117	132	221	finally
    //   132	147	221	finally
    //   147	163	221	finally
    //   175	182	199	finally
    //   182	196	199	finally
  }
  
  cv(cy paramcy, boolean paramBoolean) {
    this(paramcy, paramBoolean, (byte)0);
  }
  
  private cv(cy paramcy, boolean paramBoolean, byte paramByte) {
    this(paramcy.g, paramcy.h, paramcy.i, paramBoolean);
    if (paramcy == null)
      return; 
    try {
      return;
    } finally {
      paramcy = null;
      cd.a((Throwable)paramcy, "ht", "pnfr");
    } 
  }
  
  public static int a(cy paramcy) {
    try {
      byte b1;
      if (bj.b())
        return 4; 
      if (paramcy != null && !paramcy.k())
        return 1; 
      boolean bool = bj.a();
      if (!bool) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
    } finally {
      paramcy = null;
    } 
    return 1;
  }
  
  private a a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, Map<String, String> paramMap, boolean paramBoolean2, int paramInt) throws IOException, bh {
    URLConnection uRLConnection1;
    URLConnection uRLConnection2;
    cw cw;
    paramString2 = cu.a(a(paramString1, paramString2, paramInt), this.p);
    b(paramInt);
    Map<String, String> map = paramMap;
    if (paramMap == null)
      map = new HashMap<String, String>(); 
    c c1 = this.j.a();
    this.n = paramString3;
    c c2 = c1;
    if (paramBoolean1) {
      c2 = c1;
      if (!TextUtils.isEmpty(paramString3))
        c2 = this.j.a(paramString3); 
    } 
    if (!paramString2.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.p) && bj.a(this.p)) {
      this.o = true;
      map.put("lct", String.valueOf(bj.c(this.p)));
    } 
    paramString2 = a(cs.a, paramString2, map);
    String str = paramString2;
    if (this.c)
      str = bo.a(paramString2); 
    URL uRL = new URL(str);
    cs.a a1 = this.l;
    if (a1 != null) {
      uRLConnection1 = a1.a();
    } else {
      a1 = null;
    } 
    cs.a a2 = a1;
    if (a1 == null) {
      Proxy proxy = this.e;
      if (proxy != null) {
        uRLConnection2 = uRL.openConnection(proxy);
      } else {
        uRLConnection2 = uRL.openConnection();
      } 
    } 
    if (this.c) {
      uRLConnection1 = uRLConnection2;
      if (bj.f.a) {
        cw = a();
        if (cw != null) {
          uRLConnection1.setSSLSocketFactory(cw);
          cw.a();
        } else {
          uRLConnection1.setSSLSocketFactory(this.d.getSocketFactory());
        } 
      } else {
        uRLConnection1.setSSLSocketFactory(this.d.getSocketFactory());
      } 
      uRLConnection1.setHostnameVerifier(c2);
    } else {
      uRLConnection1 = (HttpURLConnection)cw;
    } 
    if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13)
      uRLConnection1.setRequestProperty("Connection", "close"); 
    a(map, (HttpURLConnection)uRLConnection1);
    if (paramBoolean2) {
      uRLConnection1.setRequestMethod("POST");
      uRLConnection1.setUseCaches(false);
      uRLConnection1.setDoInput(true);
      uRLConnection1.setDoOutput(true);
    } else {
      uRLConnection1.setRequestMethod("GET");
      uRLConnection1.setDoInput(true);
    } 
    return new a((HttpURLConnection)uRLConnection1, paramInt);
  }
  
  private cw a() {
    try {
      cw cw1;
      if (m == null || m.get() == null)
        m = new SoftReference<cw>(new cw(bj.c, this.d)); 
      if (k != null) {
        cw1 = m.get();
      } else {
        cw1 = null;
      } 
      return cw2;
    } finally {
      Exception exception = null;
      cg.c(exception, "ht", "gsf");
    } 
  }
  
  private cz a(a parama, long paramLong) throws bh, IOException {
    // Byte code:
    //   0: ldc ''
    //   2: astore #10
    //   4: aload #10
    //   6: astore #8
    //   8: invokestatic a : ()V
    //   11: aload #10
    //   13: astore #8
    //   15: aload_1
    //   16: getfield a : Ljava/net/HttpURLConnection;
    //   19: astore #13
    //   21: aload #10
    //   23: astore #8
    //   25: aload #13
    //   27: invokevirtual connect : ()V
    //   30: aload #10
    //   32: astore #8
    //   34: aload #13
    //   36: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   39: astore #14
    //   41: aload #10
    //   43: astore #8
    //   45: aload #13
    //   47: invokevirtual getResponseCode : ()I
    //   50: istore #5
    //   52: aload #10
    //   54: astore #8
    //   56: aload #14
    //   58: ifnull -> 312
    //   61: aload #10
    //   63: astore #8
    //   65: aload #14
    //   67: ldc_w 'gsid'
    //   70: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast java/util/List
    //   78: astore #11
    //   80: aload #10
    //   82: astore #9
    //   84: aload #11
    //   86: ifnull -> 124
    //   89: aload #10
    //   91: astore #9
    //   93: aload #10
    //   95: astore #8
    //   97: aload #11
    //   99: invokeinterface size : ()I
    //   104: ifle -> 124
    //   107: aload #10
    //   109: astore #8
    //   111: aload #11
    //   113: iconst_0
    //   114: invokeinterface get : (I)Ljava/lang/Object;
    //   119: checkcast java/lang/String
    //   122: astore #9
    //   124: aload #9
    //   126: astore #8
    //   128: aload_0
    //   129: getfield p : Ljava/lang/String;
    //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   135: ifne -> 312
    //   138: aload_0
    //   139: getfield o : Z
    //   142: ifeq -> 189
    //   145: aload #14
    //   147: ldc_w 'sc'
    //   150: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   155: ifeq -> 173
    //   158: aload_0
    //   159: aload #14
    //   161: iconst_0
    //   162: invokespecial a : (Ljava/util/Map;Z)Z
    //   165: istore #6
    //   167: iconst_1
    //   168: istore #4
    //   170: goto -> 201
    //   173: aload_0
    //   174: getfield p : Ljava/lang/String;
    //   177: invokestatic b : (Ljava/lang/String;)V
    //   180: iconst_0
    //   181: istore #6
    //   183: iconst_0
    //   184: istore #4
    //   186: goto -> 201
    //   189: aload_0
    //   190: aload #14
    //   192: iconst_1
    //   193: invokespecial a : (Ljava/util/Map;Z)Z
    //   196: istore #6
    //   198: iconst_2
    //   199: istore #4
    //   201: iload #6
    //   203: ifeq -> 295
    //   206: aload_0
    //   207: getfield p : Ljava/lang/String;
    //   210: ldc_w 'loc'
    //   213: invokevirtual equals : (Ljava/lang/Object;)Z
    //   216: ifeq -> 267
    //   219: aload_0
    //   220: getfield p : Ljava/lang/String;
    //   223: astore #8
    //   225: iload #4
    //   227: iconst_2
    //   228: if_icmpne -> 1026
    //   231: iconst_1
    //   232: istore #7
    //   234: goto -> 237
    //   237: aload #8
    //   239: iload #7
    //   241: aload #13
    //   243: invokevirtual getURL : ()Ljava/net/URL;
    //   246: invokevirtual getHost : ()Ljava/lang/String;
    //   249: aload #13
    //   251: invokevirtual getURL : ()Ljava/net/URL;
    //   254: invokevirtual getHost : ()Ljava/lang/String;
    //   257: aload_0
    //   258: getfield n : Ljava/lang/String;
    //   261: invokestatic a : (Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   264: goto -> 1038
    //   267: aload_0
    //   268: getfield p : Ljava/lang/String;
    //   271: astore #8
    //   273: iload #4
    //   275: iconst_2
    //   276: if_icmpne -> 1032
    //   279: iconst_1
    //   280: istore #7
    //   282: goto -> 285
    //   285: aload #8
    //   287: iload #7
    //   289: invokestatic b : (Ljava/lang/String;Z)V
    //   292: goto -> 1038
    //   295: iload #4
    //   297: iconst_1
    //   298: if_icmpne -> 1038
    //   301: iconst_0
    //   302: aload_0
    //   303: getfield p : Ljava/lang/String;
    //   306: invokestatic a : (ZLjava/lang/String;)V
    //   309: goto -> 1038
    //   312: iconst_0
    //   313: istore #6
    //   315: aload #8
    //   317: astore #9
    //   319: iload #5
    //   321: sipush #200
    //   324: if_icmpne -> 672
    //   327: aload #9
    //   329: astore #8
    //   331: new java/io/ByteArrayOutputStream
    //   334: dup
    //   335: invokespecial <init> : ()V
    //   338: astore #10
    //   340: aload #13
    //   342: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   345: astore #11
    //   347: new java/io/PushbackInputStream
    //   350: dup
    //   351: aload #11
    //   353: iconst_2
    //   354: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   357: astore #8
    //   359: iconst_2
    //   360: newarray byte
    //   362: astore #12
    //   364: aload #8
    //   366: aload #12
    //   368: invokevirtual read : ([B)I
    //   371: pop
    //   372: aload #8
    //   374: aload #12
    //   376: invokevirtual unread : ([B)V
    //   379: aload #12
    //   381: iconst_0
    //   382: baload
    //   383: bipush #31
    //   385: if_icmpne -> 411
    //   388: aload #12
    //   390: iconst_1
    //   391: baload
    //   392: bipush #-117
    //   394: if_icmpne -> 411
    //   397: new java/util/zip/GZIPInputStream
    //   400: dup
    //   401: aload #8
    //   403: invokespecial <init> : (Ljava/io/InputStream;)V
    //   406: astore #12
    //   408: goto -> 415
    //   411: aload #8
    //   413: astore #12
    //   415: sipush #1024
    //   418: newarray byte
    //   420: astore #15
    //   422: aload #12
    //   424: aload #15
    //   426: invokevirtual read : ([B)I
    //   429: istore #4
    //   431: iload #4
    //   433: iconst_m1
    //   434: if_icmpeq -> 450
    //   437: aload #10
    //   439: aload #15
    //   441: iconst_0
    //   442: iload #4
    //   444: invokevirtual write : ([BII)V
    //   447: goto -> 422
    //   450: invokestatic b : ()V
    //   453: new com/amap/api/col/s/cz
    //   456: dup
    //   457: invokespecial <init> : ()V
    //   460: astore #15
    //   462: aload #15
    //   464: aload #10
    //   466: invokevirtual toByteArray : ()[B
    //   469: putfield a : [B
    //   472: aload #15
    //   474: aload #14
    //   476: putfield b : Ljava/util/Map;
    //   479: aload #15
    //   481: aload_0
    //   482: getfield i : Ljava/lang/String;
    //   485: putfield c : Ljava/lang/String;
    //   488: aload #15
    //   490: aload #9
    //   492: putfield d : Ljava/lang/String;
    //   495: aload #15
    //   497: iload #6
    //   499: putfield e : Z
    //   502: aload #13
    //   504: invokevirtual getURL : ()Ljava/net/URL;
    //   507: aload #15
    //   509: invokestatic a : (Ljava/net/URL;Lcom/amap/api/col/s/cz;)V
    //   512: aload_1
    //   513: iconst_0
    //   514: lload_2
    //   515: invokestatic currentTimeMillis : ()J
    //   518: invokestatic a : (Lcom/amap/api/col/s/cv$a;ZJJ)V
    //   521: aload #10
    //   523: invokevirtual close : ()V
    //   526: goto -> 539
    //   529: astore_1
    //   530: aload_1
    //   531: ldc 'ht'
    //   533: ldc_w 'par'
    //   536: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload #11
    //   541: ifnull -> 562
    //   544: aload #11
    //   546: invokevirtual close : ()V
    //   549: goto -> 562
    //   552: astore_1
    //   553: aload_1
    //   554: ldc 'ht'
    //   556: ldc_w 'par'
    //   559: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   562: aload #8
    //   564: invokevirtual close : ()V
    //   567: goto -> 580
    //   570: astore_1
    //   571: aload_1
    //   572: ldc 'ht'
    //   574: ldc_w 'par'
    //   577: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   580: aload #12
    //   582: invokevirtual close : ()V
    //   585: aload #15
    //   587: areturn
    //   588: astore_1
    //   589: aload_1
    //   590: ldc 'ht'
    //   592: ldc_w 'par'
    //   595: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload #15
    //   600: areturn
    //   601: astore_1
    //   602: aload #11
    //   604: astore #9
    //   606: goto -> 910
    //   609: astore #13
    //   611: aload #11
    //   613: astore_1
    //   614: aload #13
    //   616: astore #11
    //   618: goto -> 843
    //   621: astore_1
    //   622: goto -> 633
    //   625: astore_1
    //   626: goto -> 647
    //   629: astore_1
    //   630: aconst_null
    //   631: astore #8
    //   633: aload #11
    //   635: astore #9
    //   637: aconst_null
    //   638: astore #12
    //   640: goto -> 910
    //   643: astore_1
    //   644: aconst_null
    //   645: astore #8
    //   647: aload #11
    //   649: astore #13
    //   651: aconst_null
    //   652: astore #12
    //   654: aload_1
    //   655: astore #11
    //   657: aload #13
    //   659: astore_1
    //   660: goto -> 843
    //   663: astore_1
    //   664: goto -> 814
    //   667: astore #11
    //   669: goto -> 835
    //   672: aload #9
    //   674: astore #8
    //   676: new java/lang/StringBuilder
    //   679: dup
    //   680: ldc_w '网络异常原因：'
    //   683: invokespecial <init> : (Ljava/lang/String;)V
    //   686: astore_1
    //   687: aload #9
    //   689: astore #8
    //   691: aload_1
    //   692: aload #13
    //   694: invokevirtual getResponseMessage : ()Ljava/lang/String;
    //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload #9
    //   703: astore #8
    //   705: aload_1
    //   706: ldc_w ' 网络异常状态码：'
    //   709: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #9
    //   715: astore #8
    //   717: aload_1
    //   718: iload #5
    //   720: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload #9
    //   726: astore #8
    //   728: aload_1
    //   729: ldc_w '  '
    //   732: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload #9
    //   738: astore #8
    //   740: aload_1
    //   741: aload #9
    //   743: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload #9
    //   749: astore #8
    //   751: aload_1
    //   752: ldc_w ' '
    //   755: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload #9
    //   761: astore #8
    //   763: aload_1
    //   764: aload_0
    //   765: getfield i : Ljava/lang/String;
    //   768: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload #9
    //   774: astore #8
    //   776: new com/amap/api/col/s/bh
    //   779: dup
    //   780: aload_1
    //   781: invokevirtual toString : ()Ljava/lang/String;
    //   784: aload #9
    //   786: aload_0
    //   787: getfield i : Ljava/lang/String;
    //   790: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   793: astore_1
    //   794: aload #9
    //   796: astore #8
    //   798: aload_1
    //   799: iload #5
    //   801: invokevirtual a : (I)V
    //   804: aload #9
    //   806: astore #8
    //   808: aload_1
    //   809: athrow
    //   810: astore_1
    //   811: aconst_null
    //   812: astore #10
    //   814: aconst_null
    //   815: astore #8
    //   817: aconst_null
    //   818: astore #12
    //   820: aconst_null
    //   821: astore #9
    //   823: goto -> 910
    //   826: astore #11
    //   828: aconst_null
    //   829: astore #10
    //   831: aload #8
    //   833: astore #9
    //   835: aconst_null
    //   836: astore #8
    //   838: aconst_null
    //   839: astore #12
    //   841: aconst_null
    //   842: astore_1
    //   843: new com/amap/api/col/s/bh
    //   846: dup
    //   847: ldc_w 'IO 操作异常 - IOException'
    //   850: aload #9
    //   852: aload_0
    //   853: getfield i : Ljava/lang/String;
    //   856: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   859: astore #9
    //   861: aload #11
    //   863: instanceof java/io/InterruptedIOException
    //   866: ifeq -> 899
    //   869: aload #11
    //   871: invokevirtual getMessage : ()Ljava/lang/String;
    //   874: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   877: ifne -> 899
    //   880: aload #11
    //   882: invokevirtual getMessage : ()Ljava/lang/String;
    //   885: ldc_w 'thread interrupted'
    //   888: invokevirtual equals : (Ljava/lang/Object;)Z
    //   891: ifeq -> 899
    //   894: aload #9
    //   896: invokevirtual g : ()V
    //   899: aload #9
    //   901: athrow
    //   902: astore #11
    //   904: aload_1
    //   905: astore #9
    //   907: aload #11
    //   909: astore_1
    //   910: aload #10
    //   912: ifnull -> 935
    //   915: aload #10
    //   917: invokevirtual close : ()V
    //   920: goto -> 935
    //   923: astore #10
    //   925: aload #10
    //   927: ldc 'ht'
    //   929: ldc_w 'par'
    //   932: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   935: aload #9
    //   937: ifnull -> 960
    //   940: aload #9
    //   942: invokevirtual close : ()V
    //   945: goto -> 960
    //   948: astore #9
    //   950: aload #9
    //   952: ldc 'ht'
    //   954: ldc_w 'par'
    //   957: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   960: aload #8
    //   962: ifnull -> 985
    //   965: aload #8
    //   967: invokevirtual close : ()V
    //   970: goto -> 985
    //   973: astore #8
    //   975: aload #8
    //   977: ldc 'ht'
    //   979: ldc_w 'par'
    //   982: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   985: aload #12
    //   987: ifnull -> 1010
    //   990: aload #12
    //   992: invokevirtual close : ()V
    //   995: goto -> 1010
    //   998: astore #8
    //   1000: aload #8
    //   1002: ldc 'ht'
    //   1004: ldc_w 'par'
    //   1007: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1010: aload_1
    //   1011: athrow
    //   1012: astore #8
    //   1014: aload #9
    //   1016: astore #8
    //   1018: goto -> 312
    //   1021: astore #8
    //   1023: goto -> 1038
    //   1026: iconst_0
    //   1027: istore #7
    //   1029: goto -> 237
    //   1032: iconst_0
    //   1033: istore #7
    //   1035: goto -> 285
    //   1038: goto -> 319
    // Exception table:
    //   from	to	target	type
    //   8	11	826	java/io/IOException
    //   8	11	810	finally
    //   15	21	826	java/io/IOException
    //   15	21	810	finally
    //   25	30	826	java/io/IOException
    //   25	30	810	finally
    //   34	41	826	java/io/IOException
    //   34	41	810	finally
    //   45	52	826	java/io/IOException
    //   45	52	810	finally
    //   65	80	826	java/io/IOException
    //   65	80	810	finally
    //   97	107	826	java/io/IOException
    //   97	107	810	finally
    //   111	124	826	java/io/IOException
    //   111	124	810	finally
    //   128	167	1012	finally
    //   173	180	1012	finally
    //   189	198	1012	finally
    //   206	225	1021	finally
    //   237	264	1021	finally
    //   267	273	1021	finally
    //   285	292	1021	finally
    //   301	309	1021	finally
    //   331	340	826	java/io/IOException
    //   331	340	810	finally
    //   340	347	667	java/io/IOException
    //   340	347	663	finally
    //   347	359	643	java/io/IOException
    //   347	359	629	finally
    //   359	379	625	java/io/IOException
    //   359	379	621	finally
    //   397	408	625	java/io/IOException
    //   397	408	621	finally
    //   415	422	609	java/io/IOException
    //   415	422	601	finally
    //   422	431	609	java/io/IOException
    //   422	431	601	finally
    //   437	447	609	java/io/IOException
    //   437	447	601	finally
    //   450	521	609	java/io/IOException
    //   450	521	601	finally
    //   521	526	529	finally
    //   544	549	552	finally
    //   562	567	570	finally
    //   580	585	588	finally
    //   676	687	826	java/io/IOException
    //   676	687	810	finally
    //   691	701	826	java/io/IOException
    //   691	701	810	finally
    //   705	713	826	java/io/IOException
    //   705	713	810	finally
    //   717	724	826	java/io/IOException
    //   717	724	810	finally
    //   728	736	826	java/io/IOException
    //   728	736	810	finally
    //   740	747	826	java/io/IOException
    //   740	747	810	finally
    //   751	759	826	java/io/IOException
    //   751	759	810	finally
    //   763	772	826	java/io/IOException
    //   763	772	810	finally
    //   776	794	826	java/io/IOException
    //   776	794	810	finally
    //   798	804	826	java/io/IOException
    //   798	804	810	finally
    //   808	810	826	java/io/IOException
    //   808	810	810	finally
    //   843	899	902	finally
    //   899	902	902	finally
    //   915	920	923	finally
    //   940	945	948	finally
    //   965	970	973	finally
    //   990	995	998	finally
  }
  
  private String a(int paramInt, String paramString, Map<String, String> paramMap) {
    String str1;
    if (paramInt != 1) {
      str1 = "";
    } else {
      str1 = cs.b;
    } 
    if (TextUtils.isEmpty(str1))
      return paramString; 
    Uri uri = Uri.parse(paramString);
    paramString = uri.getHost();
    String str2 = uri.buildUpon().encodedAuthority(str1).build().toString();
    if (paramMap != null)
      paramMap.put("targetHost", paramString); 
    if (this.c)
      this.j.b(str1); 
    return str2;
  }
  
  private static String a(String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #5
    //   4: aload #5
    //   6: astore_3
    //   7: aload #5
    //   9: astore #4
    //   11: aload_0
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifne -> 245
    //   18: aload #5
    //   20: astore_3
    //   21: aload_0
    //   22: ldc_w '&'
    //   25: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   28: astore #6
    //   30: aload #5
    //   32: astore_3
    //   33: aload #5
    //   35: astore #4
    //   37: aload #6
    //   39: arraylength
    //   40: iconst_1
    //   41: if_icmple -> 245
    //   44: aload #5
    //   46: astore_3
    //   47: aload #6
    //   49: arraylength
    //   50: istore_2
    //   51: iconst_0
    //   52: istore_1
    //   53: ldc ''
    //   55: astore_0
    //   56: iload_1
    //   57: iload_2
    //   58: if_icmpge -> 255
    //   61: aload #6
    //   63: iload_1
    //   64: aaload
    //   65: astore #4
    //   67: aload #5
    //   69: astore_3
    //   70: aload #4
    //   72: ldc_w 'sdkversion'
    //   75: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   78: ifeq -> 84
    //   81: aload #4
    //   83: astore_0
    //   84: aload #5
    //   86: astore_3
    //   87: aload #4
    //   89: ldc_w 'product'
    //   92: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   95: ifeq -> 248
    //   98: aload #4
    //   100: astore #6
    //   102: goto -> 105
    //   105: aload #5
    //   107: astore_3
    //   108: aload #5
    //   110: astore #4
    //   112: aload #6
    //   114: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   117: ifne -> 245
    //   120: aload #5
    //   122: astore_3
    //   123: aload #6
    //   125: ldc_w '='
    //   128: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   131: astore #6
    //   133: aload #5
    //   135: astore_3
    //   136: aload #5
    //   138: astore #4
    //   140: aload #6
    //   142: arraylength
    //   143: iconst_1
    //   144: if_icmple -> 245
    //   147: aload #5
    //   149: astore_3
    //   150: aload #6
    //   152: iconst_1
    //   153: aaload
    //   154: invokevirtual trim : ()Ljava/lang/String;
    //   157: astore #5
    //   159: aload #5
    //   161: astore_3
    //   162: aload #5
    //   164: astore #4
    //   166: aload_0
    //   167: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   170: ifne -> 245
    //   173: aload #5
    //   175: astore_3
    //   176: aload #5
    //   178: astore #4
    //   180: aload #5
    //   182: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   188: ifeq -> 245
    //   191: aload #5
    //   193: astore_3
    //   194: aload_0
    //   195: ldc_w '='
    //   198: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   201: astore_0
    //   202: aload #5
    //   204: astore_3
    //   205: aload #5
    //   207: astore #4
    //   209: aload_0
    //   210: arraylength
    //   211: iconst_1
    //   212: if_icmple -> 245
    //   215: aload #5
    //   217: astore_3
    //   218: aload #5
    //   220: aload_0
    //   221: iconst_1
    //   222: aaload
    //   223: invokevirtual trim : ()Ljava/lang/String;
    //   226: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload #5
    //   231: areturn
    //   232: astore_0
    //   233: aload_0
    //   234: ldc 'ht'
    //   236: ldc_w 'pnfp'
    //   239: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_3
    //   243: astore #4
    //   245: aload #4
    //   247: areturn
    //   248: iload_1
    //   249: iconst_1
    //   250: iadd
    //   251: istore_1
    //   252: goto -> 56
    //   255: ldc ''
    //   257: astore #6
    //   259: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   11	18	232	finally
    //   21	30	232	finally
    //   37	44	232	finally
    //   47	51	232	finally
    //   70	81	232	finally
    //   87	98	232	finally
    //   112	120	232	finally
    //   123	133	232	finally
    //   140	147	232	finally
    //   150	159	232	finally
    //   166	173	232	finally
    //   180	191	232	finally
    //   194	202	232	finally
    //   209	215	232	finally
    //   218	229	232	finally
  }
  
  private static String a(String paramString1, String paramString2, int paramInt) {
    if (paramInt == 2 || paramInt == 4) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (paramInt != 0)
      try {
        return !bool ? paramString2 : paramString1;
      } finally {
        paramString2 = null;
      }  
    return paramString1;
  }
  
  private static String a(String paramString, Map<String, String> paramMap) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    String str = a(paramMap);
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(paramString);
    if (str != null) {
      stringBuffer.append("?");
      stringBuffer.append(str);
    } 
    return stringBuffer.toString();
  }
  
  static String a(Map<String, String> paramMap) {
    if (paramMap != null) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        String str3 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        String str1 = str2;
        if (str2 == null)
          str1 = ""; 
        if (stringBuilder.length() > 0)
          stringBuilder.append("&"); 
        stringBuilder.append(URLEncoder.encode(str3));
        stringBuilder.append("=");
        stringBuilder.append(URLEncoder.encode(str1));
      } 
      return stringBuilder.toString();
    } 
    return null;
  }
  
  private static void a(a parama, boolean paramBoolean, long paramLong1, long paramLong2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #8
    //   3: aload_0
    //   4: getfield a : Ljava/net/HttpURLConnection;
    //   7: invokevirtual getURL : ()Ljava/net/URL;
    //   10: invokevirtual toString : ()Ljava/lang/String;
    //   13: astore #9
    //   15: aload_0
    //   16: getfield b : I
    //   19: istore #6
    //   21: iload #6
    //   23: iconst_3
    //   24: if_icmpne -> 33
    //   27: iconst_1
    //   28: istore #7
    //   30: goto -> 36
    //   33: iconst_0
    //   34: istore #7
    //   36: aload_0
    //   37: getfield b : I
    //   40: iconst_2
    //   41: if_icmpeq -> 56
    //   44: aload_0
    //   45: getfield b : I
    //   48: istore #6
    //   50: iload #6
    //   52: iconst_4
    //   53: if_icmpne -> 59
    //   56: iconst_1
    //   57: istore #8
    //   59: goto -> 71
    //   62: aconst_null
    //   63: astore #9
    //   65: iconst_0
    //   66: istore #7
    //   68: iconst_0
    //   69: istore #8
    //   71: aload #9
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifeq -> 80
    //   79: return
    //   80: aload #9
    //   82: iload #8
    //   84: iload #7
    //   86: iload_1
    //   87: lconst_0
    //   88: lload #4
    //   90: lload_2
    //   91: lsub
    //   92: invokestatic max : (JJ)J
    //   95: invokestatic a : (Ljava/lang/String;ZZZJ)V
    //   98: return
    //   99: astore_0
    //   100: goto -> 62
    //   103: astore_0
    //   104: goto -> 65
    //   107: astore_0
    //   108: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   3	15	99	finally
    //   15	21	103	finally
    //   36	50	107	finally
  }
  
  private void a(Map<String, String> paramMap, HttpURLConnection paramHttpURLConnection) {
    if (paramMap != null)
      for (String str : paramMap.keySet())
        paramHttpURLConnection.addRequestProperty(str, paramMap.get(str));  
    try {
      paramHttpURLConnection.addRequestProperty("csid", this.i);
    } finally {
      paramMap = null;
    } 
    paramHttpURLConnection.setReadTimeout(this.b);
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 2);
  }
  
  private boolean a(Map<String, List<String>> paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_1
    //   4: ldc_w 'sc'
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/util/List
    //   15: astore #7
    //   17: aload #7
    //   19: ifnull -> 194
    //   22: aload #7
    //   24: invokeinterface size : ()I
    //   29: ifle -> 194
    //   32: aload #7
    //   34: iconst_0
    //   35: invokeinterface get : (I)Ljava/lang/Object;
    //   40: checkcast java/lang/String
    //   43: astore #7
    //   45: aload #7
    //   47: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   50: ifne -> 194
    //   53: aload #7
    //   55: ldc_w '#'
    //   58: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   61: ifne -> 67
    //   64: goto -> 189
    //   67: aload #7
    //   69: ldc_w '#'
    //   72: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   75: astore #7
    //   77: aload #7
    //   79: arraylength
    //   80: iconst_1
    //   81: if_icmple -> 194
    //   84: ldc_w '1'
    //   87: aload #7
    //   89: iconst_1
    //   90: aaload
    //   91: invokevirtual equals : (Ljava/lang/Object;)Z
    //   94: ifeq -> 194
    //   97: goto -> 189
    //   100: iload_2
    //   101: ifeq -> 182
    //   104: aload_1
    //   105: ldc 'lct'
    //   107: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   112: ifeq -> 179
    //   115: aload_1
    //   116: ldc 'lct'
    //   118: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast java/util/List
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull -> 179
    //   131: aload_1
    //   132: invokeinterface size : ()I
    //   137: ifle -> 179
    //   140: aload_1
    //   141: iconst_0
    //   142: invokeinterface get : (I)Ljava/lang/Object;
    //   147: checkcast java/lang/String
    //   150: astore_1
    //   151: aload_1
    //   152: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   155: ifne -> 179
    //   158: aload_1
    //   159: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   162: invokevirtual longValue : ()J
    //   165: lstore #5
    //   167: aload_0
    //   168: getfield p : Ljava/lang/String;
    //   171: lload #5
    //   173: invokestatic a : (Ljava/lang/String;J)Z
    //   176: istore_2
    //   177: iload_2
    //   178: ireturn
    //   179: iconst_0
    //   180: istore #4
    //   182: iload #4
    //   184: ireturn
    //   185: astore_1
    //   186: goto -> 179
    //   189: iconst_1
    //   190: istore_3
    //   191: goto -> 196
    //   194: iconst_0
    //   195: istore_3
    //   196: iload_3
    //   197: ifne -> 100
    //   200: iconst_0
    //   201: ireturn
    // Exception table:
    //   from	to	target	type
    //   3	17	185	finally
    //   22	64	185	finally
    //   67	97	185	finally
    //   104	127	185	finally
    //   131	177	185	finally
  }
  
  private static String b(Map<String, String> paramMap) {
    String str = null;
    if (paramMap == null)
      return null; 
    try {
      return str;
    } finally {
      paramMap = null;
      cd.a((Throwable)paramMap, "ht", "pnfh");
    } 
  }
  
  private void b(int paramInt) {
    if (paramInt != 2) {
      if (paramInt != 3)
        return; 
      try {
        this.a = 5000;
        return;
      } finally {
        Exception exception = null;
      } 
    } 
    this.a = Math.max(this.a - 5000, 5000);
    this.b = Math.max(this.b - 5000, 5000);
  }
  
  final cz a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, int paramInt) throws bh {
    // Byte code:
    //   0: aload_1
    //   1: aload #6
    //   3: invokestatic a : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_2
    //   8: aload #6
    //   10: invokestatic a : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   13: astore_2
    //   14: aload_1
    //   15: aload_2
    //   16: aload_0
    //   17: getfield p : Ljava/lang/String;
    //   20: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amap/api/col/s/cz;
    //   23: astore #6
    //   25: aload #6
    //   27: ifnull -> 33
    //   30: aload #6
    //   32: areturn
    //   33: invokestatic currentTimeMillis : ()J
    //   36: lstore #9
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: iload_3
    //   42: aload #4
    //   44: aload #5
    //   46: iconst_0
    //   47: iload #7
    //   49: invokespecial a : (Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;ZI)Lcom/amap/api/col/s/cv$a;
    //   52: astore_1
    //   53: aload_1
    //   54: getfield a : Ljava/net/HttpURLConnection;
    //   57: astore_2
    //   58: aload_0
    //   59: aload_1
    //   60: lload #9
    //   62: invokespecial a : (Lcom/amap/api/col/s/cv$a;J)Lcom/amap/api/col/s/cz;
    //   65: astore #4
    //   67: aload_2
    //   68: ifnull -> 88
    //   71: aload_2
    //   72: invokevirtual disconnect : ()V
    //   75: aload #4
    //   77: areturn
    //   78: astore_1
    //   79: aload_1
    //   80: ldc 'ht'
    //   82: ldc_w 'mgr'
    //   85: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload #4
    //   90: areturn
    //   91: astore #4
    //   93: goto -> 233
    //   96: astore #4
    //   98: goto -> 263
    //   101: goto -> 138
    //   104: goto -> 151
    //   107: goto -> 164
    //   110: goto -> 177
    //   113: goto -> 190
    //   116: goto -> 203
    //   119: goto -> 216
    //   122: astore #4
    //   124: aconst_null
    //   125: astore_2
    //   126: goto -> 233
    //   129: astore #4
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -> 263
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_1
    //   139: astore #4
    //   141: aload_2
    //   142: astore_1
    //   143: aload #4
    //   145: astore_2
    //   146: goto -> 294
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_1
    //   152: astore #4
    //   154: aload_2
    //   155: astore_1
    //   156: aload #4
    //   158: astore_2
    //   159: goto -> 305
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_1
    //   165: astore #4
    //   167: aload_2
    //   168: astore_1
    //   169: aload #4
    //   171: astore_2
    //   172: goto -> 316
    //   175: aconst_null
    //   176: astore_2
    //   177: aload_1
    //   178: astore #4
    //   180: aload_2
    //   181: astore_1
    //   182: aload #4
    //   184: astore_2
    //   185: goto -> 327
    //   188: aconst_null
    //   189: astore_2
    //   190: aload_1
    //   191: astore #4
    //   193: aload_2
    //   194: astore_1
    //   195: aload #4
    //   197: astore_2
    //   198: goto -> 338
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_1
    //   204: astore #4
    //   206: aload_2
    //   207: astore_1
    //   208: aload #4
    //   210: astore_2
    //   211: goto -> 349
    //   214: aconst_null
    //   215: astore_2
    //   216: aload_1
    //   217: astore #4
    //   219: aload_2
    //   220: astore_1
    //   221: aload #4
    //   223: astore_2
    //   224: goto -> 360
    //   227: astore #4
    //   229: aconst_null
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_1
    //   233: aload #4
    //   235: invokevirtual printStackTrace : ()V
    //   238: new com/amap/api/col/s/bh
    //   241: dup
    //   242: ldc_w '未知的错误'
    //   245: invokespecial <init> : (Ljava/lang/String;)V
    //   248: athrow
    //   249: astore #4
    //   251: iconst_1
    //   252: istore #8
    //   254: goto -> 388
    //   257: astore #4
    //   259: aconst_null
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_1
    //   263: aload #4
    //   265: invokevirtual f : ()Z
    //   268: istore_3
    //   269: aload #4
    //   271: athrow
    //   272: astore #4
    //   274: iload_3
    //   275: iconst_1
    //   276: ixor
    //   277: istore #8
    //   279: goto -> 388
    //   282: astore #5
    //   284: aload_1
    //   285: astore #4
    //   287: goto -> 378
    //   290: aconst_null
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_2
    //   294: new com/amap/api/col/s/bh
    //   297: dup
    //   298: ldc_w 'IO 操作异常 - IOException'
    //   301: invokespecial <init> : (Ljava/lang/String;)V
    //   304: athrow
    //   305: new com/amap/api/col/s/bh
    //   308: dup
    //   309: ldc_w '未知的错误'
    //   312: invokespecial <init> : (Ljava/lang/String;)V
    //   315: athrow
    //   316: new com/amap/api/col/s/bh
    //   319: dup
    //   320: ldc_w 'socket 连接超时 - SocketTimeoutException'
    //   323: invokespecial <init> : (Ljava/lang/String;)V
    //   326: athrow
    //   327: new com/amap/api/col/s/bh
    //   330: dup
    //   331: ldc_w 'socket 连接异常 - SocketException'
    //   334: invokespecial <init> : (Ljava/lang/String;)V
    //   337: athrow
    //   338: new com/amap/api/col/s/bh
    //   341: dup
    //   342: ldc_w '未知主机 - UnKnowHostException'
    //   345: invokespecial <init> : (Ljava/lang/String;)V
    //   348: athrow
    //   349: new com/amap/api/col/s/bh
    //   352: dup
    //   353: ldc_w 'url异常 - MalformedURLException'
    //   356: invokespecial <init> : (Ljava/lang/String;)V
    //   359: athrow
    //   360: new com/amap/api/col/s/bh
    //   363: dup
    //   364: ldc_w 'http连接失败 - ConnectionException'
    //   367: invokespecial <init> : (Ljava/lang/String;)V
    //   370: athrow
    //   371: astore #5
    //   373: aload_2
    //   374: astore #4
    //   376: aload_1
    //   377: astore_2
    //   378: iconst_1
    //   379: istore #8
    //   381: aload #4
    //   383: astore_1
    //   384: aload #5
    //   386: astore #4
    //   388: iload #8
    //   390: ifeq -> 408
    //   393: iload #7
    //   395: invokestatic a : (I)V
    //   398: aload_1
    //   399: iconst_1
    //   400: lconst_0
    //   401: lconst_0
    //   402: invokestatic a : (Lcom/amap/api/col/s/cv$a;ZJJ)V
    //   405: goto -> 408
    //   408: aload_2
    //   409: ifnull -> 429
    //   412: aload_2
    //   413: invokevirtual disconnect : ()V
    //   416: goto -> 429
    //   419: astore_1
    //   420: aload_1
    //   421: ldc 'ht'
    //   423: ldc_w 'mgr'
    //   426: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload #4
    //   431: athrow
    //   432: astore_1
    //   433: goto -> 562
    //   436: astore_1
    //   437: goto -> 555
    //   440: astore_1
    //   441: goto -> 548
    //   444: astore_1
    //   445: goto -> 541
    //   448: astore_1
    //   449: goto -> 534
    //   452: astore_1
    //   453: goto -> 527
    //   456: astore_1
    //   457: goto -> 290
    //   460: astore_2
    //   461: goto -> 214
    //   464: astore_2
    //   465: goto -> 201
    //   468: astore_2
    //   469: goto -> 188
    //   472: astore_2
    //   473: goto -> 175
    //   476: astore_2
    //   477: goto -> 162
    //   480: astore_2
    //   481: goto -> 149
    //   484: astore_2
    //   485: goto -> 136
    //   488: astore #4
    //   490: goto -> 119
    //   493: astore #4
    //   495: goto -> 116
    //   498: astore #4
    //   500: goto -> 113
    //   503: astore #4
    //   505: goto -> 110
    //   508: astore #4
    //   510: goto -> 107
    //   513: astore #4
    //   515: goto -> 104
    //   518: astore #4
    //   520: goto -> 101
    //   523: astore_1
    //   524: goto -> 408
    //   527: aconst_null
    //   528: astore_1
    //   529: aconst_null
    //   530: astore_2
    //   531: goto -> 305
    //   534: aconst_null
    //   535: astore_1
    //   536: aconst_null
    //   537: astore_2
    //   538: goto -> 316
    //   541: aconst_null
    //   542: astore_1
    //   543: aconst_null
    //   544: astore_2
    //   545: goto -> 327
    //   548: aconst_null
    //   549: astore_1
    //   550: aconst_null
    //   551: astore_2
    //   552: goto -> 338
    //   555: aconst_null
    //   556: astore_1
    //   557: aconst_null
    //   558: astore_2
    //   559: goto -> 349
    //   562: aconst_null
    //   563: astore_1
    //   564: aconst_null
    //   565: astore_2
    //   566: goto -> 360
    // Exception table:
    //   from	to	target	type
    //   0	25	432	java/net/ConnectException
    //   0	25	436	java/net/MalformedURLException
    //   0	25	440	java/net/UnknownHostException
    //   0	25	444	java/net/SocketException
    //   0	25	448	java/net/SocketTimeoutException
    //   0	25	452	java/io/InterruptedIOException
    //   0	25	456	java/io/IOException
    //   0	25	257	com/amap/api/col/s/bh
    //   0	25	227	finally
    //   33	53	432	java/net/ConnectException
    //   33	53	436	java/net/MalformedURLException
    //   33	53	440	java/net/UnknownHostException
    //   33	53	444	java/net/SocketException
    //   33	53	448	java/net/SocketTimeoutException
    //   33	53	452	java/io/InterruptedIOException
    //   33	53	456	java/io/IOException
    //   33	53	257	com/amap/api/col/s/bh
    //   33	53	227	finally
    //   53	58	460	java/net/ConnectException
    //   53	58	464	java/net/MalformedURLException
    //   53	58	468	java/net/UnknownHostException
    //   53	58	472	java/net/SocketException
    //   53	58	476	java/net/SocketTimeoutException
    //   53	58	480	java/io/InterruptedIOException
    //   53	58	484	java/io/IOException
    //   53	58	129	com/amap/api/col/s/bh
    //   53	58	122	finally
    //   58	67	488	java/net/ConnectException
    //   58	67	493	java/net/MalformedURLException
    //   58	67	498	java/net/UnknownHostException
    //   58	67	503	java/net/SocketException
    //   58	67	508	java/net/SocketTimeoutException
    //   58	67	513	java/io/InterruptedIOException
    //   58	67	518	java/io/IOException
    //   58	67	96	com/amap/api/col/s/bh
    //   58	67	91	finally
    //   71	75	78	finally
    //   233	249	249	finally
    //   263	269	282	finally
    //   269	272	272	finally
    //   294	305	371	finally
    //   305	316	371	finally
    //   316	327	371	finally
    //   327	338	371	finally
    //   338	349	371	finally
    //   349	360	371	finally
    //   360	371	371	finally
    //   393	405	523	finally
    //   412	416	419	finally
  }
  
  final cz a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, Map<String, String> paramMap, byte[] paramArrayOfbyte, int paramInt) throws bh {
    // Byte code:
    //   0: aload_0
    //   1: getfield p : Ljava/lang/String;
    //   4: astore #11
    //   6: aload_1
    //   7: aload_2
    //   8: aload #11
    //   10: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amap/api/col/s/cz;
    //   13: astore #11
    //   15: aload #11
    //   17: ifnull -> 23
    //   20: aload #11
    //   22: areturn
    //   23: invokestatic currentTimeMillis : ()J
    //   26: lstore #9
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: iload_3
    //   32: aload #4
    //   34: aload #5
    //   36: iconst_1
    //   37: iload #7
    //   39: invokespecial a : (Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;ZI)Lcom/amap/api/col/s/cv$a;
    //   42: astore_1
    //   43: aload_1
    //   44: getfield a : Ljava/net/HttpURLConnection;
    //   47: astore_2
    //   48: aload #6
    //   50: ifnull -> 104
    //   53: aload #6
    //   55: arraylength
    //   56: istore #8
    //   58: iload #8
    //   60: ifle -> 104
    //   63: new java/io/DataOutputStream
    //   66: dup
    //   67: aload_2
    //   68: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   71: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   74: astore #5
    //   76: aload #5
    //   78: aload #6
    //   80: invokevirtual write : ([B)V
    //   83: aload #5
    //   85: invokevirtual close : ()V
    //   88: goto -> 104
    //   91: aload #5
    //   93: ifnull -> 101
    //   96: aload #5
    //   98: invokevirtual close : ()V
    //   101: aload #4
    //   103: athrow
    //   104: aload_0
    //   105: aload_1
    //   106: lload #9
    //   108: invokespecial a : (Lcom/amap/api/col/s/cv$a;J)Lcom/amap/api/col/s/cz;
    //   111: astore #4
    //   113: aload_2
    //   114: ifnull -> 134
    //   117: aload_2
    //   118: invokevirtual disconnect : ()V
    //   121: aload #4
    //   123: areturn
    //   124: astore_1
    //   125: aload_1
    //   126: ldc 'ht'
    //   128: ldc_w 'mPt'
    //   131: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload #4
    //   136: areturn
    //   137: astore #6
    //   139: goto -> 319
    //   142: astore #6
    //   144: goto -> 352
    //   147: astore #6
    //   149: aload_1
    //   150: astore #4
    //   152: aload_2
    //   153: astore #5
    //   155: goto -> 411
    //   158: goto -> 439
    //   161: astore #6
    //   163: aload_1
    //   164: astore #4
    //   166: aload_2
    //   167: astore #5
    //   169: goto -> 450
    //   172: astore #6
    //   174: aload_1
    //   175: astore #4
    //   177: aload_2
    //   178: astore #5
    //   180: goto -> 478
    //   183: astore #6
    //   185: aload_1
    //   186: astore #4
    //   188: aload_2
    //   189: astore #5
    //   191: goto -> 506
    //   194: astore #6
    //   196: aload_1
    //   197: astore #4
    //   199: aload_2
    //   200: astore #5
    //   202: goto -> 534
    //   205: astore #6
    //   207: aload_1
    //   208: astore #4
    //   210: aload_2
    //   211: astore #5
    //   213: goto -> 562
    //   216: astore #4
    //   218: goto -> 313
    //   221: astore_2
    //   222: goto -> 672
    //   225: astore_2
    //   226: aload_1
    //   227: astore #4
    //   229: goto -> 259
    //   232: goto -> 686
    //   235: astore_2
    //   236: goto -> 267
    //   239: astore_2
    //   240: goto -> 276
    //   243: astore_2
    //   244: goto -> 285
    //   247: astore_2
    //   248: goto -> 294
    //   251: astore_2
    //   252: goto -> 303
    //   255: astore_2
    //   256: aconst_null
    //   257: astore #4
    //   259: aload_2
    //   260: astore_1
    //   261: goto -> 405
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_1
    //   268: astore #4
    //   270: goto -> 695
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_1
    //   277: astore #4
    //   279: goto -> 708
    //   282: astore_2
    //   283: aconst_null
    //   284: astore_1
    //   285: aload_1
    //   286: astore #4
    //   288: goto -> 721
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_1
    //   294: aload_1
    //   295: astore #4
    //   297: goto -> 734
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: astore #4
    //   306: goto -> 747
    //   309: astore #4
    //   311: aconst_null
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_2
    //   315: aload #4
    //   317: astore #6
    //   319: aload_1
    //   320: astore #5
    //   322: aload_2
    //   323: astore #4
    //   325: aload #6
    //   327: ldc 'ht'
    //   329: ldc_w 'mPt'
    //   332: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload_1
    //   336: astore #5
    //   338: aload_2
    //   339: astore #4
    //   341: new com/amap/api/col/s/bh
    //   344: dup
    //   345: ldc_w '未知的错误'
    //   348: invokespecial <init> : (Ljava/lang/String;)V
    //   351: athrow
    //   352: aload_1
    //   353: astore #5
    //   355: aload_2
    //   356: astore #4
    //   358: aload #6
    //   360: invokevirtual f : ()Z
    //   363: istore_3
    //   364: aload #6
    //   366: ldc 'ht'
    //   368: ldc_w 'mPt'
    //   371: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload #6
    //   376: athrow
    //   377: astore #6
    //   379: iload_3
    //   380: iconst_1
    //   381: ixor
    //   382: istore #8
    //   384: goto -> 595
    //   387: astore #6
    //   389: iconst_1
    //   390: istore #8
    //   392: aload #5
    //   394: astore_1
    //   395: aload #4
    //   397: astore_2
    //   398: goto -> 595
    //   401: astore_1
    //   402: aconst_null
    //   403: astore #4
    //   405: aconst_null
    //   406: astore #5
    //   408: aload_1
    //   409: astore #6
    //   411: aload #4
    //   413: astore_1
    //   414: aload #5
    //   416: astore_2
    //   417: aload #6
    //   419: invokevirtual printStackTrace : ()V
    //   422: aload #4
    //   424: astore_1
    //   425: aload #5
    //   427: astore_2
    //   428: new com/amap/api/col/s/bh
    //   431: dup
    //   432: ldc_w 'IO 操作异常 - IOException'
    //   435: invokespecial <init> : (Ljava/lang/String;)V
    //   438: athrow
    //   439: new com/amap/api/col/s/bh
    //   442: dup
    //   443: ldc_w '未知的错误'
    //   446: invokespecial <init> : (Ljava/lang/String;)V
    //   449: athrow
    //   450: aload #4
    //   452: astore_1
    //   453: aload #5
    //   455: astore_2
    //   456: aload #6
    //   458: invokevirtual printStackTrace : ()V
    //   461: aload #4
    //   463: astore_1
    //   464: aload #5
    //   466: astore_2
    //   467: new com/amap/api/col/s/bh
    //   470: dup
    //   471: ldc_w 'socket 连接超时 - SocketTimeoutException'
    //   474: invokespecial <init> : (Ljava/lang/String;)V
    //   477: athrow
    //   478: aload #4
    //   480: astore_1
    //   481: aload #5
    //   483: astore_2
    //   484: aload #6
    //   486: invokevirtual printStackTrace : ()V
    //   489: aload #4
    //   491: astore_1
    //   492: aload #5
    //   494: astore_2
    //   495: new com/amap/api/col/s/bh
    //   498: dup
    //   499: ldc_w 'socket 连接异常 - SocketException'
    //   502: invokespecial <init> : (Ljava/lang/String;)V
    //   505: athrow
    //   506: aload #4
    //   508: astore_1
    //   509: aload #5
    //   511: astore_2
    //   512: aload #6
    //   514: invokevirtual printStackTrace : ()V
    //   517: aload #4
    //   519: astore_1
    //   520: aload #5
    //   522: astore_2
    //   523: new com/amap/api/col/s/bh
    //   526: dup
    //   527: ldc_w '未知主机 - UnKnowHostException'
    //   530: invokespecial <init> : (Ljava/lang/String;)V
    //   533: athrow
    //   534: aload #4
    //   536: astore_1
    //   537: aload #5
    //   539: astore_2
    //   540: aload #6
    //   542: invokevirtual printStackTrace : ()V
    //   545: aload #4
    //   547: astore_1
    //   548: aload #5
    //   550: astore_2
    //   551: new com/amap/api/col/s/bh
    //   554: dup
    //   555: ldc_w 'url异常 - MalformedURLException'
    //   558: invokespecial <init> : (Ljava/lang/String;)V
    //   561: athrow
    //   562: aload #4
    //   564: astore_1
    //   565: aload #5
    //   567: astore_2
    //   568: aload #6
    //   570: invokevirtual printStackTrace : ()V
    //   573: aload #4
    //   575: astore_1
    //   576: aload #5
    //   578: astore_2
    //   579: new com/amap/api/col/s/bh
    //   582: dup
    //   583: ldc_w 'http连接失败 - ConnectionException'
    //   586: invokespecial <init> : (Ljava/lang/String;)V
    //   589: athrow
    //   590: iconst_1
    //   591: istore #8
    //   593: astore #6
    //   595: iload #8
    //   597: ifeq -> 615
    //   600: iload #7
    //   602: invokestatic a : (I)V
    //   605: aload_1
    //   606: iconst_1
    //   607: lconst_0
    //   608: lconst_0
    //   609: invokestatic a : (Lcom/amap/api/col/s/cv$a;ZJJ)V
    //   612: goto -> 615
    //   615: aload_2
    //   616: ifnull -> 636
    //   619: aload_2
    //   620: invokevirtual disconnect : ()V
    //   623: goto -> 636
    //   626: astore_1
    //   627: aload_1
    //   628: ldc 'ht'
    //   630: ldc_w 'mPt'
    //   633: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload #6
    //   638: athrow
    //   639: astore_1
    //   640: goto -> 684
    //   643: astore_2
    //   644: goto -> 232
    //   647: astore #4
    //   649: goto -> 158
    //   652: astore_1
    //   653: goto -> 615
    //   656: astore #4
    //   658: goto -> 91
    //   661: astore #4
    //   663: aconst_null
    //   664: astore #5
    //   666: goto -> 91
    //   669: astore_2
    //   670: aconst_null
    //   671: astore_1
    //   672: aconst_null
    //   673: astore #4
    //   675: aload_2
    //   676: astore #6
    //   678: aload #4
    //   680: astore_2
    //   681: goto -> 352
    //   684: aconst_null
    //   685: astore_1
    //   686: aconst_null
    //   687: astore_2
    //   688: goto -> 439
    //   691: astore_2
    //   692: aconst_null
    //   693: astore #4
    //   695: aconst_null
    //   696: astore #5
    //   698: aload_2
    //   699: astore #6
    //   701: goto -> 450
    //   704: astore_2
    //   705: aconst_null
    //   706: astore #4
    //   708: aconst_null
    //   709: astore #5
    //   711: aload_2
    //   712: astore #6
    //   714: goto -> 478
    //   717: astore_2
    //   718: aconst_null
    //   719: astore #4
    //   721: aconst_null
    //   722: astore #5
    //   724: aload_2
    //   725: astore #6
    //   727: goto -> 506
    //   730: astore_2
    //   731: aconst_null
    //   732: astore #4
    //   734: aconst_null
    //   735: astore #5
    //   737: aload_2
    //   738: astore #6
    //   740: goto -> 534
    //   743: astore_2
    //   744: aconst_null
    //   745: astore #4
    //   747: aconst_null
    //   748: astore #5
    //   750: aload_2
    //   751: astore #6
    //   753: goto -> 562
    // Exception table:
    //   from	to	target	type
    //   0	6	743	java/net/ConnectException
    //   0	6	730	java/net/MalformedURLException
    //   0	6	717	java/net/UnknownHostException
    //   0	6	704	java/net/SocketException
    //   0	6	691	java/net/SocketTimeoutException
    //   0	6	639	java/io/InterruptedIOException
    //   0	6	401	java/io/IOException
    //   0	6	669	com/amap/api/col/s/bh
    //   0	6	309	finally
    //   6	15	300	java/net/ConnectException
    //   6	15	291	java/net/MalformedURLException
    //   6	15	282	java/net/UnknownHostException
    //   6	15	273	java/net/SocketException
    //   6	15	264	java/net/SocketTimeoutException
    //   6	15	639	java/io/InterruptedIOException
    //   6	15	255	java/io/IOException
    //   6	15	669	com/amap/api/col/s/bh
    //   6	15	309	finally
    //   23	43	300	java/net/ConnectException
    //   23	43	291	java/net/MalformedURLException
    //   23	43	282	java/net/UnknownHostException
    //   23	43	273	java/net/SocketException
    //   23	43	264	java/net/SocketTimeoutException
    //   23	43	639	java/io/InterruptedIOException
    //   23	43	255	java/io/IOException
    //   23	43	669	com/amap/api/col/s/bh
    //   23	43	309	finally
    //   43	48	251	java/net/ConnectException
    //   43	48	247	java/net/MalformedURLException
    //   43	48	243	java/net/UnknownHostException
    //   43	48	239	java/net/SocketException
    //   43	48	235	java/net/SocketTimeoutException
    //   43	48	643	java/io/InterruptedIOException
    //   43	48	225	java/io/IOException
    //   43	48	221	com/amap/api/col/s/bh
    //   43	48	216	finally
    //   53	58	205	java/net/ConnectException
    //   53	58	194	java/net/MalformedURLException
    //   53	58	183	java/net/UnknownHostException
    //   53	58	172	java/net/SocketException
    //   53	58	161	java/net/SocketTimeoutException
    //   53	58	647	java/io/InterruptedIOException
    //   53	58	147	java/io/IOException
    //   53	58	142	com/amap/api/col/s/bh
    //   53	58	137	finally
    //   63	76	661	finally
    //   76	83	656	finally
    //   83	88	205	java/net/ConnectException
    //   83	88	194	java/net/MalformedURLException
    //   83	88	183	java/net/UnknownHostException
    //   83	88	172	java/net/SocketException
    //   83	88	161	java/net/SocketTimeoutException
    //   83	88	647	java/io/InterruptedIOException
    //   83	88	147	java/io/IOException
    //   83	88	142	com/amap/api/col/s/bh
    //   83	88	137	finally
    //   96	101	205	java/net/ConnectException
    //   96	101	194	java/net/MalformedURLException
    //   96	101	183	java/net/UnknownHostException
    //   96	101	172	java/net/SocketException
    //   96	101	161	java/net/SocketTimeoutException
    //   96	101	647	java/io/InterruptedIOException
    //   96	101	147	java/io/IOException
    //   96	101	142	com/amap/api/col/s/bh
    //   96	101	137	finally
    //   101	104	205	java/net/ConnectException
    //   101	104	194	java/net/MalformedURLException
    //   101	104	183	java/net/UnknownHostException
    //   101	104	172	java/net/SocketException
    //   101	104	161	java/net/SocketTimeoutException
    //   101	104	647	java/io/InterruptedIOException
    //   101	104	147	java/io/IOException
    //   101	104	142	com/amap/api/col/s/bh
    //   101	104	137	finally
    //   104	113	205	java/net/ConnectException
    //   104	113	194	java/net/MalformedURLException
    //   104	113	183	java/net/UnknownHostException
    //   104	113	172	java/net/SocketException
    //   104	113	161	java/net/SocketTimeoutException
    //   104	113	647	java/io/InterruptedIOException
    //   104	113	147	java/io/IOException
    //   104	113	142	com/amap/api/col/s/bh
    //   104	113	137	finally
    //   117	121	124	finally
    //   325	335	387	finally
    //   341	352	387	finally
    //   358	364	387	finally
    //   364	377	377	finally
    //   417	422	590	finally
    //   428	439	590	finally
    //   439	450	590	finally
    //   456	461	590	finally
    //   467	478	590	finally
    //   484	489	590	finally
    //   495	506	590	finally
    //   512	517	590	finally
    //   523	534	590	finally
    //   540	545	590	finally
    //   551	562	590	finally
    //   568	573	590	finally
    //   579	590	590	finally
    //   600	612	652	finally
    //   619	623	626	finally
  }
  
  public static final class a {
    public HttpURLConnection a;
    
    public int b;
    
    public a(HttpURLConnection param1HttpURLConnection, int param1Int) {
      this.a = param1HttpURLConnection;
      this.b = param1Int;
    }
  }
  
  static final class b {
    private Vector<cv.c> a = new Vector<cv.c>();
    
    private volatile cv.c b = new cv.c((byte)0);
    
    private b() {}
    
    public final cv.c a() {
      return this.b;
    }
    
    public final cv.c a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return this.b; 
      for (int i = 0; i < this.a.size(); i++) {
        cv.c c2 = this.a.get(i);
        if (c2 != null && c2.a().equals(param1String))
          return c2; 
      } 
      cv.c c1 = new cv.c((byte)0);
      c1.b(param1String);
      this.a.add(c1);
      return c1;
    }
    
    public final void b(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return; 
      this.b.a(param1String);
    }
  }
  
  static final class c implements HostnameVerifier {
    private String a;
    
    private String b;
    
    private c() {}
    
    public final String a() {
      return this.b;
    }
    
    public final void a(String param1String) {
      this.a = param1String;
    }
    
    public final void b(String param1String) {
      this.b = param1String;
    }
    
    public final boolean verify(String param1String, SSLSession param1SSLSession) {
      HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
      return !TextUtils.isEmpty(this.a) ? this.a.equals(param1String) : (!TextUtils.isEmpty(this.b) ? hostnameVerifier.verify(this.b, param1SSLSession) : hostnameVerifier.verify(param1String, param1SSLSession));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */