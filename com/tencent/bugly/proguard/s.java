package com.tencent.bugly.proguard;

import android.content.Context;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class s {
  private static s b;
  
  public Map<String, String> a = null;
  
  private Context c;
  
  private s(Context paramContext) {
    this.c = paramContext;
  }
  
  public static s a(Context paramContext) {
    if (b == null)
      b = new s(paramContext); 
    return b;
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2) {
    try {
      HttpURLConnection httpURLConnection;
      URL uRL = new URL(paramString2);
      if (a.b() != null) {
        httpURLConnection = (HttpURLConnection)uRL.openConnection(a.b());
      } else if (httpURLConnection != null && httpURLConnection.toLowerCase(Locale.US).contains("wap")) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
        HttpURLConnection httpURLConnection1 = (HttpURLConnection)uRL.openConnection(new Proxy(Proxy.Type.HTTP, inetSocketAddress));
      } else {
        httpURLConnection = (HttpURLConnection)uRL.openConnection();
      } 
      httpURLConnection.setConnectTimeout(30000);
      httpURLConnection.setReadTimeout(10000);
      httpURLConnection.setDoOutput(true);
      httpURLConnection.setDoInput(true);
      httpURLConnection.setRequestMethod("POST");
      return httpURLConnection;
    } finally {
      paramString1 = null;
      if (!x.a((Throwable)paramString1))
        paramString1.printStackTrace(); 
    } 
  }
  
  private HttpURLConnection a(String paramString1, byte[] paramArrayOfbyte, String paramString2, Map<String, String> paramMap) {
    if (paramString1 == null) {
      x.e("destUrl is null.", new Object[0]);
      return null;
    } 
    HttpURLConnection httpURLConnection = a(paramString2, paramString1);
    if (httpURLConnection == null) {
      x.e("Failed to get HttpURLConnection object.", new Object[0]);
      return null;
    } 
    try {
      httpURLConnection.setRequestProperty("wup_version", "3.0");
      if (paramMap != null && paramMap.size() > 0)
        for (Map.Entry<String, String> entry : paramMap.entrySet())
          httpURLConnection.setRequestProperty((String)entry.getKey(), URLEncoder.encode((String)entry.getValue(), "utf-8"));  
      httpURLConnection.setRequestProperty("A37", URLEncoder.encode(paramString2, "utf-8"));
      httpURLConnection.setRequestProperty("A38", URLEncoder.encode(paramString2, "utf-8"));
      return httpURLConnection;
    } finally {
      httpURLConnection = null;
      if (!x.a((Throwable)httpURLConnection))
        httpURLConnection.printStackTrace(); 
      x.e("Failed to upload, please check your network.", new Object[0]);
    } 
  }
  
  private static Map<String, String> a(HttpURLConnection paramHttpURLConnection) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Map<String, List<String>> map = paramHttpURLConnection.getHeaderFields();
    if (map == null || map.size() == 0)
      return null; 
    for (String str : map.keySet()) {
      List list = map.get(str);
      if (list.size() > 0)
        hashMap.put(str, list.get(0)); 
    } 
    return (Map)hashMap;
  }
  
  private static byte[] b(HttpURLConnection paramHttpURLConnection) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   14: invokespecial <init> : (Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: new java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_2
    //   26: sipush #1024
    //   29: newarray byte
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual read : ([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: ifle -> 52
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual write : ([BII)V
    //   49: goto -> 32
    //   52: aload_2
    //   53: invokevirtual flush : ()V
    //   56: aload_2
    //   57: invokevirtual toByteArray : ()[B
    //   60: astore_2
    //   61: aload_0
    //   62: invokevirtual close : ()V
    //   65: aload_2
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual printStackTrace : ()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: goto -> 81
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_2
    //   82: invokestatic a : (Ljava/lang/Throwable;)Z
    //   85: ifne -> 92
    //   88: aload_2
    //   89: invokevirtual printStackTrace : ()V
    //   92: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   95: iconst_1
    //   96: invokevirtual b : (Z)V
    //   99: aload_0
    //   100: ifnull -> 114
    //   103: aload_0
    //   104: invokevirtual close : ()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual printStackTrace : ()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_2
    //   117: aload_0
    //   118: ifnull -> 133
    //   121: aload_0
    //   122: invokevirtual close : ()V
    //   125: goto -> 133
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual printStackTrace : ()V
    //   133: aload_2
    //   134: athrow
    // Exception table:
    //   from	to	target	type
    //   6	18	78	finally
    //   18	32	74	finally
    //   32	38	74	finally
    //   42	49	74	finally
    //   52	61	74	finally
    //   61	65	67	finally
    //   81	92	116	finally
    //   92	99	116	finally
    //   103	107	109	finally
    //   121	125	128	finally
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfbyte, v paramv, Map<String, String> paramMap) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #16
    //   3: iconst_0
    //   4: istore #8
    //   6: aload_1
    //   7: ifnonnull -> 23
    //   10: ldc_w 'Failed for no URL.'
    //   13: iconst_0
    //   14: anewarray java/lang/Object
    //   17: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   20: pop
    //   21: aconst_null
    //   22: areturn
    //   23: aload_2
    //   24: ifnonnull -> 33
    //   27: lconst_0
    //   28: lstore #10
    //   30: goto -> 38
    //   33: aload_2
    //   34: arraylength
    //   35: i2l
    //   36: lstore #10
    //   38: ldc_w 'request: %s, send: %d (pid=%d | tid=%d)'
    //   41: iconst_4
    //   42: anewarray java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: lload #10
    //   53: invokestatic valueOf : (J)Ljava/lang/Long;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: invokestatic myPid : ()I
    //   62: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: invokestatic myTid : ()I
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: iconst_0
    //   80: istore #5
    //   82: iconst_0
    //   83: istore #6
    //   85: iconst_0
    //   86: istore #7
    //   88: iload #5
    //   90: ifgt -> 703
    //   93: iload #6
    //   95: ifgt -> 703
    //   98: iload #7
    //   100: ifeq -> 109
    //   103: iconst_0
    //   104: istore #7
    //   106: goto -> 179
    //   109: iload #5
    //   111: iconst_1
    //   112: iadd
    //   113: istore #5
    //   115: iload #5
    //   117: iconst_1
    //   118: if_icmple -> 179
    //   121: new java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 'try time: '
    //   128: invokespecial <init> : (Ljava/lang/String;)V
    //   131: astore #17
    //   133: aload #17
    //   135: iload #5
    //   137: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload #17
    //   143: invokevirtual toString : ()Ljava/lang/String;
    //   146: iload #8
    //   148: anewarray java/lang/Object
    //   151: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   154: pop
    //   155: new java/util/Random
    //   158: dup
    //   159: invokestatic currentTimeMillis : ()J
    //   162: invokespecial <init> : (J)V
    //   165: sipush #10000
    //   168: invokevirtual nextInt : (I)I
    //   171: i2l
    //   172: ldc2_w 10000
    //   175: ladd
    //   176: invokestatic sleep : (J)V
    //   179: aload_0
    //   180: getfield c : Landroid/content/Context;
    //   183: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   186: astore #17
    //   188: aload #17
    //   190: ifnonnull -> 208
    //   193: ldc_w 'Failed to request for network not avail'
    //   196: iload #8
    //   198: anewarray java/lang/Object
    //   201: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 88
    //   208: aload_3
    //   209: lload #10
    //   211: invokevirtual a : (J)V
    //   214: aload_0
    //   215: aload_1
    //   216: aload_2
    //   217: aload #17
    //   219: aload #4
    //   221: invokespecial a : (Ljava/lang/String;[BLjava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   224: astore #18
    //   226: aload #18
    //   228: ifnull -> 680
    //   231: aload #18
    //   233: invokevirtual getResponseCode : ()I
    //   236: istore #9
    //   238: iload #9
    //   240: sipush #200
    //   243: if_icmpne -> 308
    //   246: aload_0
    //   247: aload #18
    //   249: invokestatic a : (Ljava/net/HttpURLConnection;)Ljava/util/Map;
    //   252: putfield a : Ljava/util/Map;
    //   255: aload #18
    //   257: invokestatic b : (Ljava/net/HttpURLConnection;)[B
    //   260: astore #16
    //   262: aload #16
    //   264: ifnonnull -> 273
    //   267: lconst_0
    //   268: lstore #12
    //   270: goto -> 279
    //   273: aload #16
    //   275: arraylength
    //   276: i2l
    //   277: lstore #12
    //   279: aload_3
    //   280: lload #12
    //   282: invokevirtual b : (J)V
    //   285: aload #18
    //   287: invokevirtual disconnect : ()V
    //   290: aload #16
    //   292: areturn
    //   293: astore_1
    //   294: aload_1
    //   295: invokestatic a : (Ljava/lang/Throwable;)Z
    //   298: ifne -> 305
    //   301: aload_1
    //   302: invokevirtual printStackTrace : ()V
    //   305: aload #16
    //   307: areturn
    //   308: iload #9
    //   310: sipush #301
    //   313: if_icmpeq -> 349
    //   316: iload #9
    //   318: sipush #302
    //   321: if_icmpeq -> 349
    //   324: iload #9
    //   326: sipush #303
    //   329: if_icmpeq -> 349
    //   332: iload #9
    //   334: sipush #307
    //   337: if_icmpne -> 343
    //   340: goto -> 349
    //   343: iconst_0
    //   344: istore #8
    //   346: goto -> 352
    //   349: iconst_1
    //   350: istore #8
    //   352: iload #8
    //   354: ifeq -> 509
    //   357: aload #18
    //   359: ldc_w 'Location'
    //   362: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   365: astore #16
    //   367: aload #16
    //   369: ifnonnull -> 435
    //   372: new java/lang/StringBuilder
    //   375: dup
    //   376: ldc_w 'Failed to redirect: %d'
    //   379: invokespecial <init> : (Ljava/lang/String;)V
    //   382: astore #16
    //   384: aload #16
    //   386: iload #9
    //   388: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload #16
    //   394: invokevirtual toString : ()Ljava/lang/String;
    //   397: iconst_0
    //   398: anewarray java/lang/Object
    //   401: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   404: pop
    //   405: aload #18
    //   407: invokevirtual disconnect : ()V
    //   410: aconst_null
    //   411: areturn
    //   412: astore_1
    //   413: aload_1
    //   414: invokestatic a : (Ljava/lang/Throwable;)Z
    //   417: ifne -> 410
    //   420: aload_1
    //   421: invokevirtual printStackTrace : ()V
    //   424: goto -> 410
    //   427: astore #16
    //   429: iconst_1
    //   430: istore #7
    //   432: goto -> 616
    //   435: iload #6
    //   437: iconst_1
    //   438: iadd
    //   439: istore #6
    //   441: ldc_w 'redirect code: %d ,to:%s'
    //   444: iconst_2
    //   445: anewarray java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: iload #9
    //   452: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload #16
    //   460: aastore
    //   461: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   464: pop
    //   465: aload #16
    //   467: astore_1
    //   468: iconst_0
    //   469: istore #5
    //   471: iconst_1
    //   472: istore #7
    //   474: goto -> 509
    //   477: astore_1
    //   478: goto -> 485
    //   481: astore_1
    //   482: goto -> 485
    //   485: aload #16
    //   487: astore #17
    //   489: iconst_0
    //   490: istore #5
    //   492: aload_1
    //   493: astore #16
    //   495: aload #17
    //   497: astore_1
    //   498: goto -> 503
    //   501: astore #16
    //   503: iconst_1
    //   504: istore #7
    //   506: goto -> 616
    //   509: new java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 'response code '
    //   516: invokespecial <init> : (Ljava/lang/String;)V
    //   519: astore #16
    //   521: aload #16
    //   523: iload #9
    //   525: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload #16
    //   531: invokevirtual toString : ()Ljava/lang/String;
    //   534: iconst_0
    //   535: anewarray java/lang/Object
    //   538: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   541: pop
    //   542: aload #18
    //   544: invokevirtual getContentLength : ()I
    //   547: istore #8
    //   549: iload #8
    //   551: i2l
    //   552: lstore #14
    //   554: lload #14
    //   556: lstore #12
    //   558: lload #14
    //   560: lconst_0
    //   561: lcmp
    //   562: ifge -> 568
    //   565: lconst_0
    //   566: lstore #12
    //   568: aload_3
    //   569: lload #12
    //   571: invokevirtual b : (J)V
    //   574: aload #18
    //   576: invokevirtual disconnect : ()V
    //   579: goto -> 597
    //   582: astore #16
    //   584: aload #16
    //   586: invokestatic a : (Ljava/lang/Throwable;)Z
    //   589: ifne -> 597
    //   592: aload #16
    //   594: invokevirtual printStackTrace : ()V
    //   597: goto -> 652
    //   600: astore #16
    //   602: goto -> 607
    //   605: astore #16
    //   607: goto -> 616
    //   610: astore_1
    //   611: goto -> 658
    //   614: astore #16
    //   616: aload #16
    //   618: invokestatic a : (Ljava/lang/Throwable;)Z
    //   621: ifne -> 629
    //   624: aload #16
    //   626: invokevirtual printStackTrace : ()V
    //   629: aload #18
    //   631: invokevirtual disconnect : ()V
    //   634: goto -> 652
    //   637: astore #16
    //   639: aload #16
    //   641: invokestatic a : (Ljava/lang/Throwable;)Z
    //   644: ifne -> 652
    //   647: aload #16
    //   649: invokevirtual printStackTrace : ()V
    //   652: iconst_0
    //   653: istore #8
    //   655: goto -> 697
    //   658: aload #18
    //   660: invokevirtual disconnect : ()V
    //   663: goto -> 678
    //   666: astore_2
    //   667: aload_2
    //   668: invokestatic a : (Ljava/lang/Throwable;)Z
    //   671: ifne -> 678
    //   674: aload_2
    //   675: invokevirtual printStackTrace : ()V
    //   678: aload_1
    //   679: athrow
    //   680: ldc_w 'Failed to execute post.'
    //   683: iload #8
    //   685: anewarray java/lang/Object
    //   688: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   691: pop
    //   692: aload_3
    //   693: lconst_0
    //   694: invokevirtual b : (J)V
    //   697: aconst_null
    //   698: astore #16
    //   700: goto -> 205
    //   703: aload #16
    //   705: areturn
    // Exception table:
    //   from	to	target	type
    //   231	238	614	java/io/IOException
    //   231	238	610	finally
    //   246	262	614	java/io/IOException
    //   246	262	610	finally
    //   273	279	614	java/io/IOException
    //   273	279	610	finally
    //   279	285	614	java/io/IOException
    //   279	285	610	finally
    //   285	290	293	finally
    //   357	367	501	java/io/IOException
    //   357	367	610	finally
    //   372	405	427	java/io/IOException
    //   372	405	610	finally
    //   405	410	412	finally
    //   441	465	477	java/io/IOException
    //   441	465	610	finally
    //   509	549	605	java/io/IOException
    //   509	549	610	finally
    //   568	574	600	java/io/IOException
    //   568	574	610	finally
    //   574	579	582	finally
    //   616	629	610	finally
    //   629	634	637	finally
    //   658	663	666	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */