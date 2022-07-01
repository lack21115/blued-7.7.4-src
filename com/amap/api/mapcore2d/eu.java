package com.amap.api.mapcore2d;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

public class eu {
  private int a;
  
  private int b;
  
  private boolean c;
  
  private SSLContext d;
  
  private Proxy e;
  
  private volatile boolean f = false;
  
  private long g = -1L;
  
  private long h = 0L;
  
  private String i;
  
  private a j;
  
  private er.a k;
  
  eu(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean) {
    this(paramInt1, paramInt2, paramProxy, paramBoolean, null);
  }
  
  eu(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean, er.a parama) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramProxy;
    this.c = cw.a().b(paramBoolean);
    if (cw.c())
      this.c = false; 
    this.k = parama;
    a();
    if (this.c)
      try {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        this.d = sSLContext;
      } finally {
        paramProxy = null;
      }  
    this.j = new a();
  }
  
  private ey a(HttpURLConnection paramHttpURLConnection, boolean paramBoolean) throws cp, IOException {
    // Byte code:
    //   0: ldc ''
    //   2: astore #5
    //   4: aconst_null
    //   5: astore #8
    //   7: aconst_null
    //   8: astore #9
    //   10: aconst_null
    //   11: astore #11
    //   13: aconst_null
    //   14: astore #10
    //   16: aload #5
    //   18: astore #6
    //   20: aload_1
    //   21: invokevirtual connect : ()V
    //   24: aload #5
    //   26: astore #6
    //   28: aload_1
    //   29: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   32: astore #12
    //   34: aload #5
    //   36: astore #6
    //   38: aload_1
    //   39: invokevirtual getResponseCode : ()I
    //   42: istore_3
    //   43: aload #5
    //   45: astore #4
    //   47: aload #12
    //   49: ifnull -> 114
    //   52: aload #5
    //   54: astore #6
    //   56: aload #12
    //   58: ldc 'gsid'
    //   60: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast java/util/List
    //   68: astore #7
    //   70: aload #5
    //   72: astore #4
    //   74: aload #7
    //   76: ifnull -> 114
    //   79: aload #5
    //   81: astore #4
    //   83: aload #5
    //   85: astore #6
    //   87: aload #7
    //   89: invokeinterface size : ()I
    //   94: ifle -> 114
    //   97: aload #5
    //   99: astore #6
    //   101: aload #7
    //   103: iconst_0
    //   104: invokeinterface get : (I)Ljava/lang/Object;
    //   109: checkcast java/lang/String
    //   112: astore #4
    //   114: iload_3
    //   115: sipush #200
    //   118: if_icmpne -> 545
    //   121: aload #4
    //   123: astore #6
    //   125: new java/io/ByteArrayOutputStream
    //   128: dup
    //   129: invokespecial <init> : ()V
    //   132: astore #5
    //   134: aload_1
    //   135: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   138: astore #6
    //   140: new java/io/PushbackInputStream
    //   143: dup
    //   144: aload #6
    //   146: iconst_2
    //   147: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   150: astore #7
    //   152: aload #10
    //   154: astore #8
    //   156: aload #11
    //   158: astore #9
    //   160: iconst_2
    //   161: newarray byte
    //   163: astore_1
    //   164: aload #10
    //   166: astore #8
    //   168: aload #11
    //   170: astore #9
    //   172: aload #7
    //   174: aload_1
    //   175: invokevirtual read : ([B)I
    //   178: pop
    //   179: aload #10
    //   181: astore #8
    //   183: aload #11
    //   185: astore #9
    //   187: aload #7
    //   189: aload_1
    //   190: invokevirtual unread : ([B)V
    //   193: aload_1
    //   194: iconst_0
    //   195: baload
    //   196: bipush #31
    //   198: if_icmpne -> 851
    //   201: aload_1
    //   202: iconst_1
    //   203: baload
    //   204: bipush #-117
    //   206: if_icmpne -> 851
    //   209: iload_2
    //   210: ifne -> 851
    //   213: aload #10
    //   215: astore #8
    //   217: aload #11
    //   219: astore #9
    //   221: new java/util/zip/GZIPInputStream
    //   224: dup
    //   225: aload #7
    //   227: invokespecial <init> : (Ljava/io/InputStream;)V
    //   230: astore_1
    //   231: goto -> 234
    //   234: aload_1
    //   235: astore #8
    //   237: aload_1
    //   238: astore #9
    //   240: sipush #1024
    //   243: newarray byte
    //   245: astore #10
    //   247: aload_1
    //   248: astore #8
    //   250: aload_1
    //   251: astore #9
    //   253: aload_1
    //   254: aload #10
    //   256: invokevirtual read : ([B)I
    //   259: istore_3
    //   260: iload_3
    //   261: iconst_m1
    //   262: if_icmpeq -> 283
    //   265: aload_1
    //   266: astore #8
    //   268: aload_1
    //   269: astore #9
    //   271: aload #5
    //   273: aload #10
    //   275: iconst_0
    //   276: iload_3
    //   277: invokevirtual write : ([BII)V
    //   280: goto -> 247
    //   283: aload_1
    //   284: astore #8
    //   286: aload_1
    //   287: astore #9
    //   289: invokestatic c : ()V
    //   292: aload_1
    //   293: astore #8
    //   295: aload_1
    //   296: astore #9
    //   298: new com/amap/api/mapcore2d/ey
    //   301: dup
    //   302: invokespecial <init> : ()V
    //   305: astore #10
    //   307: aload_1
    //   308: astore #8
    //   310: aload_1
    //   311: astore #9
    //   313: aload #10
    //   315: aload #5
    //   317: invokevirtual toByteArray : ()[B
    //   320: putfield a : [B
    //   323: aload_1
    //   324: astore #8
    //   326: aload_1
    //   327: astore #9
    //   329: aload #10
    //   331: aload #12
    //   333: putfield b : Ljava/util/Map;
    //   336: aload_1
    //   337: astore #8
    //   339: aload_1
    //   340: astore #9
    //   342: aload #10
    //   344: aload_0
    //   345: getfield i : Ljava/lang/String;
    //   348: putfield c : Ljava/lang/String;
    //   351: aload_1
    //   352: astore #8
    //   354: aload_1
    //   355: astore #9
    //   357: aload #10
    //   359: aload #4
    //   361: putfield d : Ljava/lang/String;
    //   364: aload #5
    //   366: invokevirtual close : ()V
    //   369: goto -> 383
    //   372: astore #4
    //   374: aload #4
    //   376: ldc 'ht'
    //   378: ldc 'par'
    //   380: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload #6
    //   385: ifnull -> 407
    //   388: aload #6
    //   390: invokevirtual close : ()V
    //   393: goto -> 407
    //   396: astore #4
    //   398: aload #4
    //   400: ldc 'ht'
    //   402: ldc 'par'
    //   404: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload #7
    //   409: invokevirtual close : ()V
    //   412: goto -> 426
    //   415: astore #4
    //   417: aload #4
    //   419: ldc 'ht'
    //   421: ldc 'par'
    //   423: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload_1
    //   427: invokevirtual close : ()V
    //   430: aload #10
    //   432: areturn
    //   433: astore_1
    //   434: aload_1
    //   435: ldc 'ht'
    //   437: ldc 'par'
    //   439: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload #10
    //   444: areturn
    //   445: astore #4
    //   447: aload #8
    //   449: astore_1
    //   450: goto -> 466
    //   453: aload #9
    //   455: astore_1
    //   456: goto -> 526
    //   459: astore #4
    //   461: aconst_null
    //   462: astore_1
    //   463: aload_1
    //   464: astore #7
    //   466: aload #6
    //   468: astore #8
    //   470: aload #4
    //   472: astore #6
    //   474: aload #5
    //   476: astore #4
    //   478: aload #7
    //   480: astore #5
    //   482: aload #8
    //   484: astore #7
    //   486: goto -> 740
    //   489: goto -> 521
    //   492: astore #8
    //   494: aconst_null
    //   495: astore #7
    //   497: aload #7
    //   499: astore_1
    //   500: aload_1
    //   501: astore #6
    //   503: aload #5
    //   505: astore #4
    //   507: aload #6
    //   509: astore #5
    //   511: aload #8
    //   513: astore #6
    //   515: goto -> 740
    //   518: aconst_null
    //   519: astore #6
    //   521: aconst_null
    //   522: astore_1
    //   523: aconst_null
    //   524: astore #7
    //   526: aload #4
    //   528: astore #8
    //   530: aload #5
    //   532: astore #4
    //   534: aload #7
    //   536: astore #5
    //   538: aload #6
    //   540: astore #7
    //   542: goto -> 726
    //   545: aload #4
    //   547: astore #6
    //   549: new java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial <init> : ()V
    //   556: astore #5
    //   558: aload #4
    //   560: astore #6
    //   562: aload #5
    //   564: ldc '网络异常原因：'
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #4
    //   572: astore #6
    //   574: aload #5
    //   576: aload_1
    //   577: invokevirtual getResponseMessage : ()Ljava/lang/String;
    //   580: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload #4
    //   586: astore #6
    //   588: aload #5
    //   590: ldc ' 网络异常状态码：'
    //   592: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload #4
    //   598: astore #6
    //   600: aload #5
    //   602: iload_3
    //   603: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload #4
    //   609: astore #6
    //   611: aload #5
    //   613: ldc '  '
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload #4
    //   621: astore #6
    //   623: aload #5
    //   625: aload #4
    //   627: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload #4
    //   633: astore #6
    //   635: aload #5
    //   637: ldc ' '
    //   639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload #4
    //   645: astore #6
    //   647: aload #5
    //   649: aload_0
    //   650: getfield i : Ljava/lang/String;
    //   653: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload #4
    //   659: astore #6
    //   661: new com/amap/api/mapcore2d/cp
    //   664: dup
    //   665: aload #5
    //   667: invokevirtual toString : ()Ljava/lang/String;
    //   670: aload #4
    //   672: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   675: astore_1
    //   676: aload #4
    //   678: astore #6
    //   680: aload_1
    //   681: iload_3
    //   682: invokevirtual a : (I)V
    //   685: aload #4
    //   687: astore #6
    //   689: aload_1
    //   690: athrow
    //   691: astore #6
    //   693: aconst_null
    //   694: astore #7
    //   696: aload #7
    //   698: astore_1
    //   699: aload_1
    //   700: astore #5
    //   702: aload #9
    //   704: astore #4
    //   706: goto -> 740
    //   709: aconst_null
    //   710: astore #7
    //   712: aload #7
    //   714: astore_1
    //   715: aload_1
    //   716: astore #5
    //   718: aload #8
    //   720: astore #4
    //   722: aload #6
    //   724: astore #8
    //   726: new com/amap/api/mapcore2d/cp
    //   729: dup
    //   730: ldc 'IO 操作异常 - IOException'
    //   732: aload #8
    //   734: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   737: athrow
    //   738: astore #6
    //   740: aload #4
    //   742: ifnull -> 764
    //   745: aload #4
    //   747: invokevirtual close : ()V
    //   750: goto -> 764
    //   753: astore #4
    //   755: aload #4
    //   757: ldc 'ht'
    //   759: ldc 'par'
    //   761: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload #7
    //   766: ifnull -> 788
    //   769: aload #7
    //   771: invokevirtual close : ()V
    //   774: goto -> 788
    //   777: astore #4
    //   779: aload #4
    //   781: ldc 'ht'
    //   783: ldc 'par'
    //   785: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   788: aload #5
    //   790: ifnull -> 812
    //   793: aload #5
    //   795: invokevirtual close : ()V
    //   798: goto -> 812
    //   801: astore #4
    //   803: aload #4
    //   805: ldc 'ht'
    //   807: ldc 'par'
    //   809: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   812: aload_1
    //   813: ifnull -> 832
    //   816: aload_1
    //   817: invokevirtual close : ()V
    //   820: goto -> 832
    //   823: astore_1
    //   824: aload_1
    //   825: ldc 'ht'
    //   827: ldc 'par'
    //   829: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   832: aload #6
    //   834: athrow
    //   835: astore_1
    //   836: goto -> 709
    //   839: astore_1
    //   840: goto -> 518
    //   843: astore_1
    //   844: goto -> 489
    //   847: astore_1
    //   848: goto -> 453
    //   851: aload #7
    //   853: astore_1
    //   854: goto -> 234
    // Exception table:
    //   from	to	target	type
    //   20	24	835	java/io/IOException
    //   20	24	691	finally
    //   28	34	835	java/io/IOException
    //   28	34	691	finally
    //   38	43	835	java/io/IOException
    //   38	43	691	finally
    //   56	70	835	java/io/IOException
    //   56	70	691	finally
    //   87	97	835	java/io/IOException
    //   87	97	691	finally
    //   101	114	835	java/io/IOException
    //   101	114	691	finally
    //   125	134	835	java/io/IOException
    //   125	134	691	finally
    //   134	140	839	java/io/IOException
    //   134	140	492	finally
    //   140	152	843	java/io/IOException
    //   140	152	459	finally
    //   160	164	847	java/io/IOException
    //   160	164	445	finally
    //   172	179	847	java/io/IOException
    //   172	179	445	finally
    //   187	193	847	java/io/IOException
    //   187	193	445	finally
    //   221	231	847	java/io/IOException
    //   221	231	445	finally
    //   240	247	847	java/io/IOException
    //   240	247	445	finally
    //   253	260	847	java/io/IOException
    //   253	260	445	finally
    //   271	280	847	java/io/IOException
    //   271	280	445	finally
    //   289	292	847	java/io/IOException
    //   289	292	445	finally
    //   298	307	847	java/io/IOException
    //   298	307	445	finally
    //   313	323	847	java/io/IOException
    //   313	323	445	finally
    //   329	336	847	java/io/IOException
    //   329	336	445	finally
    //   342	351	847	java/io/IOException
    //   342	351	445	finally
    //   357	364	847	java/io/IOException
    //   357	364	445	finally
    //   364	369	372	finally
    //   388	393	396	finally
    //   407	412	415	finally
    //   426	430	433	finally
    //   549	558	835	java/io/IOException
    //   549	558	691	finally
    //   562	570	835	java/io/IOException
    //   562	570	691	finally
    //   574	584	835	java/io/IOException
    //   574	584	691	finally
    //   588	596	835	java/io/IOException
    //   588	596	691	finally
    //   600	607	835	java/io/IOException
    //   600	607	691	finally
    //   611	619	835	java/io/IOException
    //   611	619	691	finally
    //   623	631	835	java/io/IOException
    //   623	631	691	finally
    //   635	643	835	java/io/IOException
    //   635	643	691	finally
    //   647	657	835	java/io/IOException
    //   647	657	691	finally
    //   661	676	835	java/io/IOException
    //   661	676	691	finally
    //   680	685	835	java/io/IOException
    //   680	685	691	finally
    //   689	691	835	java/io/IOException
    //   689	691	691	finally
    //   726	738	738	finally
    //   745	750	753	finally
    //   769	774	777	finally
    //   793	798	801	finally
    //   816	820	823	finally
  }
  
  private String a(int paramInt, String paramString, Map<String, String> paramMap) {
    String str1;
    if (paramInt != 1) {
      str1 = "";
    } else {
      str1 = er.b;
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
  
  private void a() {
    try {
      return;
    } finally {
      Exception exception = null;
      dl.a(exception, "ht", "ic");
    } 
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
  
  ey a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean2) throws cp {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #9
    //   6: aconst_null
    //   7: astore #10
    //   9: aconst_null
    //   10: astore #11
    //   12: aconst_null
    //   13: astore #12
    //   15: aconst_null
    //   16: astore #13
    //   18: aconst_null
    //   19: astore #14
    //   21: aconst_null
    //   22: astore #15
    //   24: aconst_null
    //   25: astore #8
    //   27: aload #5
    //   29: invokestatic a : (Ljava/util/Map;)Ljava/lang/String;
    //   32: astore #5
    //   34: new java/lang/StringBuffer
    //   37: dup
    //   38: invokespecial <init> : ()V
    //   41: astore #16
    //   43: aload #16
    //   45: aload_1
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   49: pop
    //   50: aload #5
    //   52: ifnull -> 72
    //   55: aload #16
    //   57: ldc_w '?'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   63: pop
    //   64: aload #16
    //   66: aload #5
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: pop
    //   72: aload_0
    //   73: aload #16
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: iload_2
    //   79: aload_3
    //   80: aload #4
    //   82: iconst_0
    //   83: invokevirtual a : (Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   86: astore_1
    //   87: aload_0
    //   88: aload_1
    //   89: iload #6
    //   91: invokespecial a : (Ljava/net/HttpURLConnection;Z)Lcom/amap/api/mapcore2d/ey;
    //   94: astore_3
    //   95: aload_1
    //   96: ifnull -> 115
    //   99: aload_1
    //   100: invokevirtual disconnect : ()V
    //   103: aload_3
    //   104: areturn
    //   105: astore_1
    //   106: aload_1
    //   107: ldc 'ht'
    //   109: ldc_w 'mgr'
    //   112: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_3
    //   116: areturn
    //   117: astore #4
    //   119: aload_1
    //   120: astore_3
    //   121: goto -> 133
    //   124: astore_3
    //   125: goto -> 153
    //   128: astore #4
    //   130: aload #8
    //   132: astore_3
    //   133: aload_3
    //   134: astore_1
    //   135: aload #4
    //   137: invokevirtual printStackTrace : ()V
    //   140: aload_3
    //   141: astore_1
    //   142: new com/amap/api/mapcore2d/cp
    //   145: dup
    //   146: ldc_w '未知的错误'
    //   149: invokespecial <init> : (Ljava/lang/String;)V
    //   152: athrow
    //   153: aload_3
    //   154: athrow
    //   155: new com/amap/api/mapcore2d/cp
    //   158: dup
    //   159: ldc 'IO 操作异常 - IOException'
    //   161: invokespecial <init> : (Ljava/lang/String;)V
    //   164: athrow
    //   165: new com/amap/api/mapcore2d/cp
    //   168: dup
    //   169: ldc_w '未知的错误'
    //   172: invokespecial <init> : (Ljava/lang/String;)V
    //   175: athrow
    //   176: new com/amap/api/mapcore2d/cp
    //   179: dup
    //   180: ldc_w 'socket 连接超时 - SocketTimeoutException'
    //   183: invokespecial <init> : (Ljava/lang/String;)V
    //   186: athrow
    //   187: new com/amap/api/mapcore2d/cp
    //   190: dup
    //   191: ldc_w 'socket 连接异常 - SocketException'
    //   194: invokespecial <init> : (Ljava/lang/String;)V
    //   197: athrow
    //   198: new com/amap/api/mapcore2d/cp
    //   201: dup
    //   202: ldc_w '未知主机 - UnKnowHostException'
    //   205: invokespecial <init> : (Ljava/lang/String;)V
    //   208: athrow
    //   209: new com/amap/api/mapcore2d/cp
    //   212: dup
    //   213: ldc_w 'url异常 - MalformedURLException'
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: athrow
    //   220: new com/amap/api/mapcore2d/cp
    //   223: dup
    //   224: ldc_w 'http连接失败 - ConnectionException'
    //   227: invokespecial <init> : (Ljava/lang/String;)V
    //   230: athrow
    //   231: astore_3
    //   232: aload_1
    //   233: ifnull -> 253
    //   236: aload_1
    //   237: invokevirtual disconnect : ()V
    //   240: goto -> 253
    //   243: astore_1
    //   244: aload_1
    //   245: ldc 'ht'
    //   247: ldc_w 'mgr'
    //   250: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_3
    //   254: athrow
    //   255: astore_1
    //   256: goto -> 354
    //   259: astore_1
    //   260: goto -> 348
    //   263: astore_1
    //   264: goto -> 342
    //   267: astore_1
    //   268: goto -> 336
    //   271: astore_1
    //   272: goto -> 330
    //   275: astore_1
    //   276: goto -> 324
    //   279: astore_1
    //   280: goto -> 318
    //   283: astore_3
    //   284: goto -> 220
    //   287: astore_3
    //   288: goto -> 209
    //   291: astore_3
    //   292: goto -> 198
    //   295: astore_3
    //   296: goto -> 187
    //   299: astore_3
    //   300: goto -> 176
    //   303: astore_3
    //   304: goto -> 165
    //   307: astore_3
    //   308: goto -> 155
    //   311: astore_3
    //   312: aload #7
    //   314: astore_1
    //   315: goto -> 153
    //   318: aload #9
    //   320: astore_1
    //   321: goto -> 155
    //   324: aload #10
    //   326: astore_1
    //   327: goto -> 165
    //   330: aload #11
    //   332: astore_1
    //   333: goto -> 176
    //   336: aload #12
    //   338: astore_1
    //   339: goto -> 187
    //   342: aload #13
    //   344: astore_1
    //   345: goto -> 198
    //   348: aload #14
    //   350: astore_1
    //   351: goto -> 209
    //   354: aload #15
    //   356: astore_1
    //   357: goto -> 220
    // Exception table:
    //   from	to	target	type
    //   27	50	255	java/net/ConnectException
    //   27	50	259	java/net/MalformedURLException
    //   27	50	263	java/net/UnknownHostException
    //   27	50	267	java/net/SocketException
    //   27	50	271	java/net/SocketTimeoutException
    //   27	50	275	java/io/InterruptedIOException
    //   27	50	279	java/io/IOException
    //   27	50	311	com/amap/api/mapcore2d/cp
    //   27	50	128	finally
    //   55	72	255	java/net/ConnectException
    //   55	72	259	java/net/MalformedURLException
    //   55	72	263	java/net/UnknownHostException
    //   55	72	267	java/net/SocketException
    //   55	72	271	java/net/SocketTimeoutException
    //   55	72	275	java/io/InterruptedIOException
    //   55	72	279	java/io/IOException
    //   55	72	311	com/amap/api/mapcore2d/cp
    //   55	72	128	finally
    //   72	87	255	java/net/ConnectException
    //   72	87	259	java/net/MalformedURLException
    //   72	87	263	java/net/UnknownHostException
    //   72	87	267	java/net/SocketException
    //   72	87	271	java/net/SocketTimeoutException
    //   72	87	275	java/io/InterruptedIOException
    //   72	87	279	java/io/IOException
    //   72	87	311	com/amap/api/mapcore2d/cp
    //   72	87	128	finally
    //   87	95	283	java/net/ConnectException
    //   87	95	287	java/net/MalformedURLException
    //   87	95	291	java/net/UnknownHostException
    //   87	95	295	java/net/SocketException
    //   87	95	299	java/net/SocketTimeoutException
    //   87	95	303	java/io/InterruptedIOException
    //   87	95	307	java/io/IOException
    //   87	95	124	com/amap/api/mapcore2d/cp
    //   87	95	117	finally
    //   99	103	105	finally
    //   135	140	231	finally
    //   142	153	231	finally
    //   153	155	231	finally
    //   155	165	231	finally
    //   165	176	231	finally
    //   176	187	231	finally
    //   187	198	231	finally
    //   198	209	231	finally
    //   209	220	231	finally
    //   220	231	231	finally
    //   236	240	243	finally
  }
  
  ey a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfbyte, boolean paramBoolean2) throws cp {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #9
    //   6: aconst_null
    //   7: astore #10
    //   9: aconst_null
    //   10: astore #11
    //   12: aconst_null
    //   13: astore #12
    //   15: aconst_null
    //   16: astore #13
    //   18: aconst_null
    //   19: astore #14
    //   21: aconst_null
    //   22: astore #15
    //   24: aconst_null
    //   25: astore #7
    //   27: aload_0
    //   28: aload_1
    //   29: iload_2
    //   30: aload_3
    //   31: aload #4
    //   33: iconst_1
    //   34: invokevirtual a : (Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   37: astore_1
    //   38: aload #5
    //   40: ifnull -> 179
    //   43: aload_1
    //   44: astore #7
    //   46: aload_1
    //   47: astore #8
    //   49: aload_1
    //   50: astore #9
    //   52: aload_1
    //   53: astore #10
    //   55: aload_1
    //   56: astore #11
    //   58: aload_1
    //   59: astore #12
    //   61: aload_1
    //   62: astore #13
    //   64: aload_1
    //   65: astore #14
    //   67: aload_1
    //   68: astore #15
    //   70: aload #5
    //   72: arraylength
    //   73: ifle -> 179
    //   76: aload_1
    //   77: astore #7
    //   79: aload_1
    //   80: astore #8
    //   82: aload_1
    //   83: astore #9
    //   85: aload_1
    //   86: astore #10
    //   88: aload_1
    //   89: astore #11
    //   91: aload_1
    //   92: astore #12
    //   94: aload_1
    //   95: astore #13
    //   97: aload_1
    //   98: astore #14
    //   100: aload_1
    //   101: astore #15
    //   103: new java/io/DataOutputStream
    //   106: dup
    //   107: aload_1
    //   108: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   111: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   114: astore_3
    //   115: aload_1
    //   116: astore #7
    //   118: aload_1
    //   119: astore #8
    //   121: aload_1
    //   122: astore #9
    //   124: aload_1
    //   125: astore #10
    //   127: aload_1
    //   128: astore #11
    //   130: aload_1
    //   131: astore #12
    //   133: aload_1
    //   134: astore #13
    //   136: aload_1
    //   137: astore #14
    //   139: aload_1
    //   140: astore #15
    //   142: aload_3
    //   143: aload #5
    //   145: invokevirtual write : ([B)V
    //   148: aload_1
    //   149: astore #7
    //   151: aload_1
    //   152: astore #8
    //   154: aload_1
    //   155: astore #9
    //   157: aload_1
    //   158: astore #10
    //   160: aload_1
    //   161: astore #11
    //   163: aload_1
    //   164: astore #12
    //   166: aload_1
    //   167: astore #13
    //   169: aload_1
    //   170: astore #14
    //   172: aload_1
    //   173: astore #15
    //   175: aload_3
    //   176: invokevirtual close : ()V
    //   179: aload_0
    //   180: aload_1
    //   181: iload #6
    //   183: invokespecial a : (Ljava/net/HttpURLConnection;Z)Lcom/amap/api/mapcore2d/ey;
    //   186: astore_3
    //   187: aload_1
    //   188: ifnull -> 207
    //   191: aload_1
    //   192: invokevirtual disconnect : ()V
    //   195: aload_3
    //   196: areturn
    //   197: astore_1
    //   198: aload_1
    //   199: ldc 'ht'
    //   201: ldc_w 'mPt'
    //   204: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_3
    //   208: areturn
    //   209: astore_3
    //   210: aload_1
    //   211: astore #7
    //   213: goto -> 266
    //   216: astore_3
    //   217: aload_1
    //   218: astore #9
    //   220: goto -> 292
    //   223: astore_3
    //   224: aload_1
    //   225: astore #10
    //   227: goto -> 309
    //   230: astore_3
    //   231: aload_1
    //   232: astore #11
    //   234: goto -> 340
    //   237: astore_3
    //   238: aload_1
    //   239: astore #12
    //   241: goto -> 361
    //   244: astore_3
    //   245: aload_1
    //   246: astore #13
    //   248: goto -> 382
    //   251: astore_3
    //   252: aload_1
    //   253: astore #14
    //   255: goto -> 403
    //   258: astore_3
    //   259: aload_1
    //   260: astore #15
    //   262: goto -> 424
    //   265: astore_3
    //   266: aload #7
    //   268: astore_1
    //   269: aload_3
    //   270: ldc 'ht'
    //   272: ldc_w 'mPt'
    //   275: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload #7
    //   280: astore_1
    //   281: new com/amap/api/mapcore2d/cp
    //   284: dup
    //   285: ldc_w '未知的错误'
    //   288: invokespecial <init> : (Ljava/lang/String;)V
    //   291: athrow
    //   292: aload #9
    //   294: astore_1
    //   295: aload_3
    //   296: ldc 'ht'
    //   298: ldc_w 'mPt'
    //   301: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload #9
    //   306: astore_1
    //   307: aload_3
    //   308: athrow
    //   309: aload #10
    //   311: astore_1
    //   312: aload_3
    //   313: invokevirtual printStackTrace : ()V
    //   316: aload #10
    //   318: astore_1
    //   319: new com/amap/api/mapcore2d/cp
    //   322: dup
    //   323: ldc 'IO 操作异常 - IOException'
    //   325: invokespecial <init> : (Ljava/lang/String;)V
    //   328: athrow
    //   329: new com/amap/api/mapcore2d/cp
    //   332: dup
    //   333: ldc_w '未知的错误'
    //   336: invokespecial <init> : (Ljava/lang/String;)V
    //   339: athrow
    //   340: aload #11
    //   342: astore_1
    //   343: aload_3
    //   344: invokevirtual printStackTrace : ()V
    //   347: aload #11
    //   349: astore_1
    //   350: new com/amap/api/mapcore2d/cp
    //   353: dup
    //   354: ldc_w 'socket 连接超时 - SocketTimeoutException'
    //   357: invokespecial <init> : (Ljava/lang/String;)V
    //   360: athrow
    //   361: aload #12
    //   363: astore_1
    //   364: aload_3
    //   365: invokevirtual printStackTrace : ()V
    //   368: aload #12
    //   370: astore_1
    //   371: new com/amap/api/mapcore2d/cp
    //   374: dup
    //   375: ldc_w 'socket 连接异常 - SocketException'
    //   378: invokespecial <init> : (Ljava/lang/String;)V
    //   381: athrow
    //   382: aload #13
    //   384: astore_1
    //   385: aload_3
    //   386: invokevirtual printStackTrace : ()V
    //   389: aload #13
    //   391: astore_1
    //   392: new com/amap/api/mapcore2d/cp
    //   395: dup
    //   396: ldc_w '未知主机 - UnKnowHostException'
    //   399: invokespecial <init> : (Ljava/lang/String;)V
    //   402: athrow
    //   403: aload #14
    //   405: astore_1
    //   406: aload_3
    //   407: invokevirtual printStackTrace : ()V
    //   410: aload #14
    //   412: astore_1
    //   413: new com/amap/api/mapcore2d/cp
    //   416: dup
    //   417: ldc_w 'url异常 - MalformedURLException'
    //   420: invokespecial <init> : (Ljava/lang/String;)V
    //   423: athrow
    //   424: aload #15
    //   426: astore_1
    //   427: aload_3
    //   428: invokevirtual printStackTrace : ()V
    //   431: aload #15
    //   433: astore_1
    //   434: new com/amap/api/mapcore2d/cp
    //   437: dup
    //   438: ldc_w 'http连接失败 - ConnectionException'
    //   441: invokespecial <init> : (Ljava/lang/String;)V
    //   444: athrow
    //   445: astore_3
    //   446: aload_1
    //   447: ifnull -> 467
    //   450: aload_1
    //   451: invokevirtual disconnect : ()V
    //   454: goto -> 467
    //   457: astore_1
    //   458: aload_1
    //   459: ldc 'ht'
    //   461: ldc_w 'mPt'
    //   464: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload_3
    //   468: athrow
    //   469: astore_1
    //   470: goto -> 485
    //   473: astore_3
    //   474: goto -> 329
    //   477: astore_3
    //   478: goto -> 292
    //   481: astore_3
    //   482: goto -> 309
    //   485: aload #8
    //   487: astore_1
    //   488: goto -> 329
    //   491: astore_3
    //   492: goto -> 340
    //   495: astore_3
    //   496: goto -> 361
    //   499: astore_3
    //   500: goto -> 382
    //   503: astore_3
    //   504: goto -> 403
    //   507: astore_3
    //   508: goto -> 424
    // Exception table:
    //   from	to	target	type
    //   27	38	507	java/net/ConnectException
    //   27	38	503	java/net/MalformedURLException
    //   27	38	499	java/net/UnknownHostException
    //   27	38	495	java/net/SocketException
    //   27	38	491	java/net/SocketTimeoutException
    //   27	38	469	java/io/InterruptedIOException
    //   27	38	481	java/io/IOException
    //   27	38	477	com/amap/api/mapcore2d/cp
    //   27	38	265	finally
    //   70	76	507	java/net/ConnectException
    //   70	76	503	java/net/MalformedURLException
    //   70	76	499	java/net/UnknownHostException
    //   70	76	495	java/net/SocketException
    //   70	76	491	java/net/SocketTimeoutException
    //   70	76	469	java/io/InterruptedIOException
    //   70	76	481	java/io/IOException
    //   70	76	477	com/amap/api/mapcore2d/cp
    //   70	76	265	finally
    //   103	115	507	java/net/ConnectException
    //   103	115	503	java/net/MalformedURLException
    //   103	115	499	java/net/UnknownHostException
    //   103	115	495	java/net/SocketException
    //   103	115	491	java/net/SocketTimeoutException
    //   103	115	469	java/io/InterruptedIOException
    //   103	115	481	java/io/IOException
    //   103	115	477	com/amap/api/mapcore2d/cp
    //   103	115	265	finally
    //   142	148	507	java/net/ConnectException
    //   142	148	503	java/net/MalformedURLException
    //   142	148	499	java/net/UnknownHostException
    //   142	148	495	java/net/SocketException
    //   142	148	491	java/net/SocketTimeoutException
    //   142	148	469	java/io/InterruptedIOException
    //   142	148	481	java/io/IOException
    //   142	148	477	com/amap/api/mapcore2d/cp
    //   142	148	265	finally
    //   175	179	507	java/net/ConnectException
    //   175	179	503	java/net/MalformedURLException
    //   175	179	499	java/net/UnknownHostException
    //   175	179	495	java/net/SocketException
    //   175	179	491	java/net/SocketTimeoutException
    //   175	179	469	java/io/InterruptedIOException
    //   175	179	481	java/io/IOException
    //   175	179	477	com/amap/api/mapcore2d/cp
    //   175	179	265	finally
    //   179	187	258	java/net/ConnectException
    //   179	187	251	java/net/MalformedURLException
    //   179	187	244	java/net/UnknownHostException
    //   179	187	237	java/net/SocketException
    //   179	187	230	java/net/SocketTimeoutException
    //   179	187	473	java/io/InterruptedIOException
    //   179	187	223	java/io/IOException
    //   179	187	216	com/amap/api/mapcore2d/cp
    //   179	187	209	finally
    //   191	195	197	finally
    //   269	278	445	finally
    //   281	292	445	finally
    //   295	304	445	finally
    //   307	309	445	finally
    //   312	316	445	finally
    //   319	329	445	finally
    //   329	340	445	finally
    //   343	347	445	finally
    //   350	361	445	finally
    //   364	368	445	finally
    //   371	382	445	finally
    //   385	389	445	finally
    //   392	403	445	finally
    //   406	410	445	finally
    //   413	424	445	finally
    //   427	431	445	finally
    //   434	445	445	finally
    //   450	454	457	finally
  }
  
  HttpURLConnection a(String paramString1, boolean paramBoolean1, String paramString2, Map<String, String> paramMap, boolean paramBoolean2) throws IOException {
    URLConnection uRLConnection1;
    URLConnection uRLConnection2;
    cu.b();
    Map<String, String> map = paramMap;
    if (paramMap == null)
      map = new HashMap<String, String>(); 
    b b2 = this.j.a();
    b b1 = b2;
    if (paramBoolean1) {
      b1 = b2;
      if (!TextUtils.isEmpty(paramString2))
        b1 = this.j.a(paramString2); 
    } 
    paramString2 = a(er.a, paramString1, map);
    paramString1 = paramString2;
    if (this.c)
      paramString1 = cw.a(paramString2); 
    URL uRL = new URL(paramString1);
    er.a a1 = this.k;
    if (a1 != null) {
      uRLConnection1 = a1.a(this.e, uRL);
    } else {
      a1 = null;
    } 
    er.a a2 = a1;
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
      uRLConnection2 = uRLConnection1;
      uRLConnection2.setSSLSocketFactory(this.d.getSocketFactory());
      uRLConnection2.setHostnameVerifier(b1);
    } else {
      uRLConnection1 = uRLConnection2;
    } 
    if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13)
      uRLConnection1.setRequestProperty("Connection", "close"); 
    a(map, (HttpURLConnection)uRLConnection1);
    if (paramBoolean2) {
      uRLConnection1.setRequestMethod("POST");
      uRLConnection1.setUseCaches(false);
      uRLConnection1.setDoInput(true);
      uRLConnection1.setDoOutput(true);
      return (HttpURLConnection)uRLConnection1;
    } 
    uRLConnection1.setRequestMethod("GET");
    uRLConnection1.setDoInput(true);
    return (HttpURLConnection)uRLConnection1;
  }
  
  void a(long paramLong) {
    this.h = paramLong;
  }
  
  void a(String paramString1, boolean paramBoolean, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, byte[] paramArrayOfbyte, et.a parama) {
    // Byte code:
    //   0: aload #7
    //   2: ifnonnull -> 6
    //   5: return
    //   6: aconst_null
    //   7: astore #13
    //   9: aconst_null
    //   10: astore #12
    //   12: aload #5
    //   14: invokestatic a : (Ljava/util/Map;)Ljava/lang/String;
    //   17: astore #5
    //   19: new java/lang/StringBuffer
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #14
    //   28: aload #14
    //   30: aload_1
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   34: pop
    //   35: aload #5
    //   37: ifnull -> 57
    //   40: aload #14
    //   42: ldc_w '?'
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   48: pop
    //   49: aload #14
    //   51: aload #5
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   56: pop
    //   57: iconst_1
    //   58: istore #9
    //   60: aload #6
    //   62: ifnull -> 699
    //   65: aload #6
    //   67: arraylength
    //   68: ifle -> 699
    //   71: iconst_1
    //   72: istore #11
    //   74: goto -> 77
    //   77: aload_0
    //   78: aload #14
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: iload_2
    //   84: aload_3
    //   85: aload #4
    //   87: iload #11
    //   89: invokevirtual a : (Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Z)Ljava/net/HttpURLConnection;
    //   92: astore_3
    //   93: aload #12
    //   95: astore_1
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #4
    //   105: aload #12
    //   107: astore_1
    //   108: aload #4
    //   110: ldc_w 'bytes='
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #12
    //   119: astore_1
    //   120: aload #4
    //   122: aload_0
    //   123: getfield h : J
    //   126: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #12
    //   132: astore_1
    //   133: aload #4
    //   135: ldc_w '-'
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload #12
    //   144: astore_1
    //   145: aload_3
    //   146: ldc_w 'RANGE'
    //   149: aload #4
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   157: iload #11
    //   159: ifeq -> 196
    //   162: aload #12
    //   164: astore_1
    //   165: new java/io/DataOutputStream
    //   168: dup
    //   169: aload_3
    //   170: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   173: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   176: astore #4
    //   178: aload #12
    //   180: astore_1
    //   181: aload #4
    //   183: aload #6
    //   185: invokevirtual write : ([B)V
    //   188: aload #12
    //   190: astore_1
    //   191: aload #4
    //   193: invokevirtual close : ()V
    //   196: aload #12
    //   198: astore_1
    //   199: aload_3
    //   200: invokevirtual connect : ()V
    //   203: aload #12
    //   205: astore_1
    //   206: aload_3
    //   207: invokevirtual getResponseCode : ()I
    //   210: istore #10
    //   212: iload #10
    //   214: sipush #200
    //   217: if_icmpeq -> 705
    //   220: iconst_1
    //   221: istore #8
    //   223: goto -> 708
    //   226: iload #8
    //   228: iload #9
    //   230: iand
    //   231: ifeq -> 314
    //   234: aload #12
    //   236: astore_1
    //   237: new java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial <init> : ()V
    //   244: astore #4
    //   246: aload #12
    //   248: astore_1
    //   249: aload #4
    //   251: ldc '网络异常原因：'
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload #12
    //   259: astore_1
    //   260: aload #4
    //   262: aload_3
    //   263: invokevirtual getResponseMessage : ()Ljava/lang/String;
    //   266: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload #12
    //   272: astore_1
    //   273: aload #4
    //   275: ldc ' 网络异常状态码：'
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #12
    //   283: astore_1
    //   284: aload #4
    //   286: iload #10
    //   288: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload #12
    //   294: astore_1
    //   295: aload #7
    //   297: new com/amap/api/mapcore2d/cp
    //   300: dup
    //   301: aload #4
    //   303: invokevirtual toString : ()Ljava/lang/String;
    //   306: invokespecial <init> : (Ljava/lang/String;)V
    //   309: invokeinterface a : (Ljava/lang/Throwable;)V
    //   314: aload #12
    //   316: astore_1
    //   317: aload_3
    //   318: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   321: astore #4
    //   323: aload #4
    //   325: astore_1
    //   326: sipush #1024
    //   329: newarray byte
    //   331: astore #5
    //   333: aload #4
    //   335: astore_1
    //   336: invokestatic interrupted : ()Z
    //   339: ifne -> 486
    //   342: aload #4
    //   344: astore_1
    //   345: aload_0
    //   346: getfield f : Z
    //   349: ifne -> 486
    //   352: aload #4
    //   354: astore_1
    //   355: aload #4
    //   357: aload #5
    //   359: iconst_0
    //   360: sipush #1024
    //   363: invokevirtual read : ([BII)I
    //   366: istore #8
    //   368: iload #8
    //   370: ifle -> 486
    //   373: aload #4
    //   375: astore_1
    //   376: aload_0
    //   377: getfield g : J
    //   380: ldc2_w -1
    //   383: lcmp
    //   384: ifeq -> 402
    //   387: aload #4
    //   389: astore_1
    //   390: aload_0
    //   391: getfield h : J
    //   394: aload_0
    //   395: getfield g : J
    //   398: lcmp
    //   399: ifge -> 486
    //   402: iload #8
    //   404: sipush #1024
    //   407: if_icmpne -> 429
    //   410: aload #4
    //   412: astore_1
    //   413: aload #7
    //   415: aload #5
    //   417: aload_0
    //   418: getfield h : J
    //   421: invokeinterface a : ([BJ)V
    //   426: goto -> 468
    //   429: aload #4
    //   431: astore_1
    //   432: iload #8
    //   434: newarray byte
    //   436: astore #6
    //   438: aload #4
    //   440: astore_1
    //   441: aload #5
    //   443: iconst_0
    //   444: aload #6
    //   446: iconst_0
    //   447: iload #8
    //   449: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   452: aload #4
    //   454: astore_1
    //   455: aload #7
    //   457: aload #6
    //   459: aload_0
    //   460: getfield h : J
    //   463: invokeinterface a : ([BJ)V
    //   468: aload #4
    //   470: astore_1
    //   471: aload_0
    //   472: aload_0
    //   473: getfield h : J
    //   476: iload #8
    //   478: i2l
    //   479: ladd
    //   480: putfield h : J
    //   483: goto -> 333
    //   486: aload #4
    //   488: astore_1
    //   489: aload_0
    //   490: getfield f : Z
    //   493: ifeq -> 509
    //   496: aload #4
    //   498: astore_1
    //   499: aload #7
    //   501: invokeinterface b : ()V
    //   506: goto -> 519
    //   509: aload #4
    //   511: astore_1
    //   512: aload #7
    //   514: invokeinterface c : ()V
    //   519: aload #4
    //   521: ifnull -> 555
    //   524: aload #4
    //   526: invokevirtual close : ()V
    //   529: goto -> 555
    //   532: astore_1
    //   533: aload_1
    //   534: ldc 'ht'
    //   536: ldc_w 'mdr'
    //   539: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   542: goto -> 555
    //   545: astore_1
    //   546: aload_1
    //   547: ldc 'ht'
    //   549: ldc_w 'mdr'
    //   552: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload_3
    //   556: ifnull -> 638
    //   559: aload_3
    //   560: invokevirtual disconnect : ()V
    //   563: return
    //   564: astore #4
    //   566: goto -> 576
    //   569: astore #4
    //   571: aconst_null
    //   572: astore_3
    //   573: aload #13
    //   575: astore_1
    //   576: aload #7
    //   578: aload #4
    //   580: invokeinterface a : (Ljava/lang/Throwable;)V
    //   585: aload_1
    //   586: ifnull -> 619
    //   589: aload_1
    //   590: invokevirtual close : ()V
    //   593: goto -> 619
    //   596: astore_1
    //   597: aload_1
    //   598: ldc 'ht'
    //   600: ldc_w 'mdr'
    //   603: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   606: goto -> 619
    //   609: astore_1
    //   610: aload_1
    //   611: ldc 'ht'
    //   613: ldc_w 'mdr'
    //   616: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload_3
    //   620: ifnull -> 638
    //   623: aload_3
    //   624: invokevirtual disconnect : ()V
    //   627: return
    //   628: astore_1
    //   629: aload_1
    //   630: ldc 'ht'
    //   632: ldc_w 'mdr'
    //   635: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   638: return
    //   639: astore #4
    //   641: aload_1
    //   642: ifnull -> 675
    //   645: aload_1
    //   646: invokevirtual close : ()V
    //   649: goto -> 675
    //   652: astore_1
    //   653: aload_1
    //   654: ldc 'ht'
    //   656: ldc_w 'mdr'
    //   659: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   662: goto -> 675
    //   665: astore_1
    //   666: aload_1
    //   667: ldc 'ht'
    //   669: ldc_w 'mdr'
    //   672: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   675: aload_3
    //   676: ifnull -> 696
    //   679: aload_3
    //   680: invokevirtual disconnect : ()V
    //   683: goto -> 696
    //   686: astore_1
    //   687: aload_1
    //   688: ldc 'ht'
    //   690: ldc_w 'mdr'
    //   693: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   696: aload #4
    //   698: athrow
    //   699: iconst_0
    //   700: istore #11
    //   702: goto -> 77
    //   705: iconst_0
    //   706: istore #8
    //   708: iload #10
    //   710: sipush #206
    //   713: if_icmpeq -> 719
    //   716: goto -> 226
    //   719: iconst_0
    //   720: istore #9
    //   722: goto -> 226
    // Exception table:
    //   from	to	target	type
    //   12	35	569	finally
    //   40	57	569	finally
    //   65	71	569	finally
    //   77	93	569	finally
    //   96	105	564	finally
    //   108	117	564	finally
    //   120	130	564	finally
    //   133	142	564	finally
    //   145	157	564	finally
    //   165	178	564	finally
    //   181	188	564	finally
    //   191	196	564	finally
    //   199	203	564	finally
    //   206	212	564	finally
    //   237	246	564	finally
    //   249	257	564	finally
    //   260	270	564	finally
    //   273	281	564	finally
    //   284	292	564	finally
    //   295	314	564	finally
    //   317	323	564	finally
    //   326	333	564	finally
    //   336	342	564	finally
    //   345	352	564	finally
    //   355	368	564	finally
    //   376	387	564	finally
    //   390	402	564	finally
    //   413	426	564	finally
    //   432	438	564	finally
    //   441	452	564	finally
    //   455	468	564	finally
    //   471	483	564	finally
    //   489	496	564	finally
    //   499	506	564	finally
    //   512	519	564	finally
    //   524	529	545	java/io/IOException
    //   524	529	532	finally
    //   559	563	628	finally
    //   576	585	639	finally
    //   589	593	609	java/io/IOException
    //   589	593	596	finally
    //   623	627	628	finally
    //   645	649	665	java/io/IOException
    //   645	649	652	finally
    //   679	683	686	finally
  }
  
  void b(long paramLong) {
    this.g = paramLong;
  }
  
  static class a {
    private Vector<eu.b> a = new Vector<eu.b>();
    
    private volatile eu.b b = new eu.b();
    
    private a() {}
    
    public eu.b a() {
      return this.b;
    }
    
    public eu.b a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return this.b; 
      for (int i = 0; i < this.a.size(); i++) {
        eu.b b2 = this.a.get(i);
        if (b2 != null && b2.a().equals(param1String))
          return b2; 
      } 
      eu.b b1 = new eu.b();
      b1.b(param1String);
      this.a.add(b1);
      return b1;
    }
    
    public void b(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return; 
      this.b.a(param1String);
    }
  }
  
  static class b implements HostnameVerifier {
    private String a;
    
    private String b;
    
    private b() {}
    
    public String a() {
      return this.b;
    }
    
    public void a(String param1String) {
      this.a = param1String;
    }
    
    public void b(String param1String) {
      this.b = param1String;
    }
    
    public boolean verify(String param1String, SSLSession param1SSLSession) {
      HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
      return !TextUtils.isEmpty(this.a) ? this.a.equals(param1String) : (!TextUtils.isEmpty(this.b) ? hostnameVerifier.verify(this.b, param1SSLSession) : hostnameVerifier.verify(param1String, param1SSLSession));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */