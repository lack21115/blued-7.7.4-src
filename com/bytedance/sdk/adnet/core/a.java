package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.f;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.b;
import com.bytedance.sdk.adnet.face.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class a implements b {
  protected static final boolean a = p.a;
  
  protected final IHttpStack b;
  
  protected final b c;
  
  public a(IHttpStack paramIHttpStack) {
    this(paramIHttpStack, new b(4096));
  }
  
  public a(IHttpStack paramIHttpStack, b paramb) {
    this.b = paramIHttpStack;
    this.c = paramb;
  }
  
  private static List<Header> a(List<Header> paramList, com.bytedance.sdk.adnet.face.a.a parama) {
    ArrayList<Header> arrayList = new ArrayList();
    TreeSet<String> treeSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    if (paramList != null && !paramList.isEmpty())
      for (Header header : paramList) {
        treeSet.add(header.a());
        arrayList.add(header);
      }  
    if (parama != null)
      if (parama.i != null) {
        if (!parama.i.isEmpty())
          for (Header header : parama.i) {
            if (!treeSet.contains(header.a()))
              arrayList.add(header); 
          }  
      } else if (!((com.bytedance.sdk.adnet.face.a.a)header).h.isEmpty()) {
        for (Map.Entry entry : ((com.bytedance.sdk.adnet.face.a.a)header).h.entrySet()) {
          if (!treeSet.contains(entry.getKey()))
            arrayList.add(new Header((String)entry.getKey(), (String)entry.getValue())); 
        } 
      }  
    return arrayList;
  }
  
  private Map<String, String> a(com.bytedance.sdk.adnet.face.a.a parama) {
    if (parama == null)
      return Collections.emptyMap(); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (parama.c != null)
      hashMap.put("If-None-Match", parama.c); 
    if (parama.e > 0L)
      hashMap.put("If-Modified-Since", c.a(parama.e)); 
    return (Map)hashMap;
  }
  
  private void a(long paramLong, Request<?> paramRequest, byte[] paramArrayOfbyte, int paramInt) {
    if (a || paramLong > 3000L) {
      String str;
      if (paramArrayOfbyte != null) {
        Integer integer = Integer.valueOf(paramArrayOfbyte.length);
      } else {
        str = "null";
      } 
      p.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), str, Integer.valueOf(paramInt), Integer.valueOf(paramRequest.getRetryPolicy().b()) });
    } 
  }
  
  private static void a(String paramString, Request<?> paramRequest, VAdError paramVAdError) throws VAdError {
    d d = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try {
      d.a(paramVAdError);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    } catch (VAdError vAdError) {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw vAdError;
    } 
  }
  
  private byte[] a(InputStream paramInputStream, int paramInt) throws IOException, f {
    // Byte code:
    //   0: new com/bytedance/sdk/adnet/core/c
    //   3: dup
    //   4: aload_0
    //   5: getfield c : Lcom/bytedance/sdk/adnet/core/b;
    //   8: iload_2
    //   9: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/b;I)V
    //   12: astore #5
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_1
    //   17: ifnull -> 114
    //   20: aload_0
    //   21: getfield c : Lcom/bytedance/sdk/adnet/core/b;
    //   24: sipush #1024
    //   27: invokevirtual a : (I)[B
    //   30: astore #4
    //   32: aload #4
    //   34: astore_3
    //   35: aload_1
    //   36: aload #4
    //   38: invokevirtual read : ([B)I
    //   41: istore_2
    //   42: iload_2
    //   43: iconst_m1
    //   44: if_icmpeq -> 62
    //   47: aload #4
    //   49: astore_3
    //   50: aload #5
    //   52: aload #4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual write : ([BII)V
    //   59: goto -> 32
    //   62: aload #4
    //   64: astore_3
    //   65: aload #5
    //   67: invokevirtual toByteArray : ()[B
    //   70: astore #6
    //   72: aload_1
    //   73: ifnull -> 92
    //   76: aload_1
    //   77: invokevirtual close : ()V
    //   80: goto -> 92
    //   83: ldc 'Error occurred when closing InputStream'
    //   85: iconst_0
    //   86: anewarray java/lang/Object
    //   89: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_0
    //   93: getfield c : Lcom/bytedance/sdk/adnet/core/b;
    //   96: aload #4
    //   98: invokevirtual a : ([B)V
    //   101: aload #5
    //   103: invokevirtual close : ()V
    //   106: aload #6
    //   108: areturn
    //   109: astore #4
    //   111: goto -> 122
    //   114: new com/bytedance/sdk/adnet/err/f
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: athrow
    //   122: aload_1
    //   123: ifnull -> 142
    //   126: aload_1
    //   127: invokevirtual close : ()V
    //   130: goto -> 142
    //   133: ldc 'Error occurred when closing InputStream'
    //   135: iconst_0
    //   136: anewarray java/lang/Object
    //   139: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_0
    //   143: getfield c : Lcom/bytedance/sdk/adnet/core/b;
    //   146: aload_3
    //   147: invokevirtual a : ([B)V
    //   150: aload #5
    //   152: invokevirtual close : ()V
    //   155: aload #4
    //   157: athrow
    //   158: astore_1
    //   159: goto -> 83
    //   162: astore_1
    //   163: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   20	32	109	finally
    //   35	42	109	finally
    //   50	59	109	finally
    //   65	72	109	finally
    //   76	80	158	java/io/IOException
    //   114	122	109	finally
    //   126	130	162	java/io/IOException
  }
  
  public j a(Request<?> paramRequest) throws VAdError {
    // Byte code:
    //   0: invokestatic elapsedRealtime : ()J
    //   3: lstore_3
    //   4: invokestatic emptyList : ()Ljava/util/List;
    //   7: astore #9
    //   9: aconst_null
    //   10: astore #12
    //   12: aconst_null
    //   13: astore #10
    //   15: aconst_null
    //   16: astore #11
    //   18: aconst_null
    //   19: astore #7
    //   21: aload #7
    //   23: astore #8
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual getCacheEntry : ()Lcom/bytedance/sdk/adnet/face/a$a;
    //   30: invokespecial a : (Lcom/bytedance/sdk/adnet/face/a$a;)Ljava/util/Map;
    //   33: astore #13
    //   35: aload #7
    //   37: astore #8
    //   39: aload_0
    //   40: getfield b : Lcom/bytedance/sdk/adnet/face/IHttpStack;
    //   43: aload_1
    //   44: aload #13
    //   46: invokeinterface a : (Lcom/bytedance/sdk/adnet/core/Request;Ljava/util/Map;)Lcom/bytedance/sdk/adnet/core/HttpResponse;
    //   51: astore #7
    //   53: aload #7
    //   55: invokevirtual a : ()I
    //   58: istore_2
    //   59: aload #7
    //   61: invokevirtual b : ()Ljava/util/List;
    //   64: astore #8
    //   66: iload_2
    //   67: sipush #304
    //   70: if_icmpne -> 199
    //   73: aload_1
    //   74: invokevirtual getCacheEntry : ()Lcom/bytedance/sdk/adnet/face/a$a;
    //   77: astore #9
    //   79: aload #9
    //   81: ifnonnull -> 129
    //   84: new com/bytedance/sdk/adnet/core/j
    //   87: dup
    //   88: sipush #304
    //   91: aconst_null
    //   92: iconst_1
    //   93: invokestatic elapsedRealtime : ()J
    //   96: lload_3
    //   97: lsub
    //   98: aload #8
    //   100: invokespecial <init> : (I[BZJLjava/util/List;)V
    //   103: astore #9
    //   105: aload #7
    //   107: ifnull -> 126
    //   110: aload #7
    //   112: invokevirtual d : ()Ljava/io/InputStream;
    //   115: ifnull -> 126
    //   118: aload #7
    //   120: invokevirtual d : ()Ljava/io/InputStream;
    //   123: invokevirtual close : ()V
    //   126: aload #9
    //   128: areturn
    //   129: aload #8
    //   131: aload #9
    //   133: invokestatic a : (Ljava/util/List;Lcom/bytedance/sdk/adnet/face/a$a;)Ljava/util/List;
    //   136: astore #10
    //   138: new com/bytedance/sdk/adnet/core/j
    //   141: dup
    //   142: sipush #304
    //   145: aload #9
    //   147: getfield b : [B
    //   150: iconst_1
    //   151: invokestatic elapsedRealtime : ()J
    //   154: lload_3
    //   155: lsub
    //   156: aload #10
    //   158: invokespecial <init> : (I[BZJLjava/util/List;)V
    //   161: astore #9
    //   163: aload #7
    //   165: ifnull -> 184
    //   168: aload #7
    //   170: invokevirtual d : ()Ljava/io/InputStream;
    //   173: ifnull -> 184
    //   176: aload #7
    //   178: invokevirtual d : ()Ljava/io/InputStream;
    //   181: invokevirtual close : ()V
    //   184: aload #9
    //   186: areturn
    //   187: astore #9
    //   189: aconst_null
    //   190: astore #10
    //   192: aload #8
    //   194: astore #11
    //   196: goto -> 367
    //   199: aload_0
    //   200: aload_1
    //   201: aload #7
    //   203: invokevirtual a : (Lcom/bytedance/sdk/adnet/core/Request;Lcom/bytedance/sdk/adnet/core/HttpResponse;)[B
    //   206: astore #10
    //   208: aload_0
    //   209: invokestatic elapsedRealtime : ()J
    //   212: lload_3
    //   213: lsub
    //   214: aload_1
    //   215: aload #10
    //   217: iload_2
    //   218: invokespecial a : (JLcom/bytedance/sdk/adnet/core/Request;[BI)V
    //   221: iload_2
    //   222: sipush #200
    //   225: if_icmplt -> 283
    //   228: iload_2
    //   229: sipush #299
    //   232: if_icmpgt -> 283
    //   235: invokestatic elapsedRealtime : ()J
    //   238: lstore #5
    //   240: new com/bytedance/sdk/adnet/core/j
    //   243: dup
    //   244: iload_2
    //   245: aload #10
    //   247: iconst_0
    //   248: lload #5
    //   250: lload_3
    //   251: lsub
    //   252: aload #8
    //   254: invokespecial <init> : (I[BZJLjava/util/List;)V
    //   257: astore #9
    //   259: aload #7
    //   261: ifnull -> 280
    //   264: aload #7
    //   266: invokevirtual d : ()Ljava/io/InputStream;
    //   269: ifnull -> 280
    //   272: aload #7
    //   274: invokevirtual d : ()Ljava/io/InputStream;
    //   277: invokevirtual close : ()V
    //   280: aload #9
    //   282: areturn
    //   283: new java/io/IOException
    //   286: dup
    //   287: invokespecial <init> : ()V
    //   290: athrow
    //   291: astore #9
    //   293: goto -> 298
    //   296: astore #9
    //   298: aload #8
    //   300: astore #11
    //   302: goto -> 367
    //   305: astore #9
    //   307: goto -> 324
    //   310: astore_1
    //   311: goto -> 722
    //   314: astore #10
    //   316: aload #9
    //   318: astore #8
    //   320: aload #10
    //   322: astore #9
    //   324: aconst_null
    //   325: astore #10
    //   327: aload #8
    //   329: astore #11
    //   331: goto -> 367
    //   334: astore #9
    //   336: goto -> 625
    //   339: goto -> 684
    //   342: astore_1
    //   343: aload #8
    //   345: astore #7
    //   347: goto -> 722
    //   350: astore #8
    //   352: aconst_null
    //   353: astore #10
    //   355: aload #9
    //   357: astore #11
    //   359: aload #12
    //   361: astore #7
    //   363: aload #8
    //   365: astore #9
    //   367: aload #7
    //   369: ifnull -> 611
    //   372: aload #7
    //   374: astore #8
    //   376: aload #7
    //   378: invokevirtual a : ()I
    //   381: istore_2
    //   382: aload #7
    //   384: astore #8
    //   386: ldc_w 'Unexpected response code %d for %s'
    //   389: iconst_2
    //   390: anewarray java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: iload_2
    //   396: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: aload_1
    //   403: invokevirtual getUrl : ()Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload #10
    //   412: ifnull -> 569
    //   415: aload #7
    //   417: astore #8
    //   419: new com/bytedance/sdk/adnet/core/j
    //   422: dup
    //   423: iload_2
    //   424: aload #10
    //   426: iconst_0
    //   427: invokestatic elapsedRealtime : ()J
    //   430: lload_3
    //   431: lsub
    //   432: aload #11
    //   434: invokespecial <init> : (I[BZJLjava/util/List;)V
    //   437: astore #9
    //   439: iload_2
    //   440: sipush #401
    //   443: if_icmpeq -> 546
    //   446: iload_2
    //   447: sipush #403
    //   450: if_icmpne -> 781
    //   453: goto -> 546
    //   456: aload #7
    //   458: astore #8
    //   460: new com/bytedance/sdk/adnet/err/b
    //   463: dup
    //   464: aload #9
    //   466: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   469: athrow
    //   470: iload_2
    //   471: sipush #500
    //   474: if_icmplt -> 532
    //   477: iload_2
    //   478: sipush #599
    //   481: if_icmpgt -> 532
    //   484: aload #7
    //   486: astore #8
    //   488: aload_1
    //   489: invokevirtual shouldRetryServerErrors : ()Z
    //   492: ifeq -> 518
    //   495: aload #7
    //   497: astore #8
    //   499: ldc_w 'server'
    //   502: aload_1
    //   503: new com/bytedance/sdk/adnet/err/f
    //   506: dup
    //   507: aload #9
    //   509: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   512: invokestatic a : (Ljava/lang/String;Lcom/bytedance/sdk/adnet/core/Request;Lcom/bytedance/sdk/adnet/err/VAdError;)V
    //   515: goto -> 587
    //   518: aload #7
    //   520: astore #8
    //   522: new com/bytedance/sdk/adnet/err/f
    //   525: dup
    //   526: aload #9
    //   528: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   531: athrow
    //   532: aload #7
    //   534: astore #8
    //   536: new com/bytedance/sdk/adnet/err/f
    //   539: dup
    //   540: aload #9
    //   542: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   545: athrow
    //   546: aload #7
    //   548: astore #8
    //   550: ldc_w 'auth'
    //   553: aload_1
    //   554: new com/bytedance/sdk/adnet/err/a
    //   557: dup
    //   558: aload #9
    //   560: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   563: invokestatic a : (Ljava/lang/String;Lcom/bytedance/sdk/adnet/core/Request;Lcom/bytedance/sdk/adnet/err/VAdError;)V
    //   566: goto -> 587
    //   569: aload #7
    //   571: astore #8
    //   573: ldc_w 'network'
    //   576: aload_1
    //   577: new com/bytedance/sdk/adnet/err/c
    //   580: dup
    //   581: invokespecial <init> : ()V
    //   584: invokestatic a : (Ljava/lang/String;Lcom/bytedance/sdk/adnet/core/Request;Lcom/bytedance/sdk/adnet/err/VAdError;)V
    //   587: aload #7
    //   589: ifnull -> 0
    //   592: aload #7
    //   594: invokevirtual d : ()Ljava/io/InputStream;
    //   597: ifnull -> 0
    //   600: aload #7
    //   602: invokevirtual d : ()Ljava/io/InputStream;
    //   605: invokevirtual close : ()V
    //   608: goto -> 0
    //   611: aload #7
    //   613: astore #8
    //   615: new com/bytedance/sdk/adnet/err/d
    //   618: dup
    //   619: aload #9
    //   621: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   624: athrow
    //   625: aload #7
    //   627: astore #8
    //   629: new java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial <init> : ()V
    //   636: astore #10
    //   638: aload #7
    //   640: astore #8
    //   642: aload #10
    //   644: ldc_w 'Bad URL '
    //   647: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload #7
    //   653: astore #8
    //   655: aload #10
    //   657: aload_1
    //   658: invokevirtual getUrl : ()Ljava/lang/String;
    //   661: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload #7
    //   667: astore #8
    //   669: new java/lang/RuntimeException
    //   672: dup
    //   673: aload #10
    //   675: invokevirtual toString : ()Ljava/lang/String;
    //   678: aload #9
    //   680: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   683: athrow
    //   684: aload #7
    //   686: astore #8
    //   688: ldc_w 'socket'
    //   691: aload_1
    //   692: new com/bytedance/sdk/adnet/err/g
    //   695: dup
    //   696: invokespecial <init> : ()V
    //   699: invokestatic a : (Ljava/lang/String;Lcom/bytedance/sdk/adnet/core/Request;Lcom/bytedance/sdk/adnet/err/VAdError;)V
    //   702: aload #7
    //   704: ifnull -> 0
    //   707: aload #7
    //   709: invokevirtual d : ()Ljava/io/InputStream;
    //   712: astore #8
    //   714: aload #8
    //   716: ifnull -> 0
    //   719: goto -> 600
    //   722: aload #7
    //   724: ifnull -> 743
    //   727: aload #7
    //   729: invokevirtual d : ()Ljava/io/InputStream;
    //   732: ifnull -> 743
    //   735: aload #7
    //   737: invokevirtual d : ()Ljava/io/InputStream;
    //   740: invokevirtual close : ()V
    //   743: aload_1
    //   744: athrow
    //   745: astore #7
    //   747: aload #11
    //   749: astore #7
    //   751: goto -> 684
    //   754: astore #8
    //   756: goto -> 339
    //   759: astore_1
    //   760: aload #9
    //   762: areturn
    //   763: astore_1
    //   764: aload #9
    //   766: areturn
    //   767: astore_1
    //   768: aload #9
    //   770: areturn
    //   771: astore #7
    //   773: goto -> 0
    //   776: astore #7
    //   778: goto -> 743
    //   781: iload_2
    //   782: sipush #400
    //   785: if_icmplt -> 470
    //   788: iload_2
    //   789: sipush #499
    //   792: if_icmple -> 456
    //   795: goto -> 470
    //   798: astore #9
    //   800: aload #10
    //   802: astore #7
    //   804: goto -> 625
    // Exception table:
    //   from	to	target	type
    //   25	35	745	java/net/SocketTimeoutException
    //   25	35	798	java/net/MalformedURLException
    //   25	35	350	java/io/IOException
    //   25	35	342	finally
    //   39	53	745	java/net/SocketTimeoutException
    //   39	53	798	java/net/MalformedURLException
    //   39	53	350	java/io/IOException
    //   39	53	342	finally
    //   53	66	754	java/net/SocketTimeoutException
    //   53	66	334	java/net/MalformedURLException
    //   53	66	314	java/io/IOException
    //   53	66	310	finally
    //   73	79	754	java/net/SocketTimeoutException
    //   73	79	334	java/net/MalformedURLException
    //   73	79	187	java/io/IOException
    //   73	79	310	finally
    //   84	105	754	java/net/SocketTimeoutException
    //   84	105	334	java/net/MalformedURLException
    //   84	105	187	java/io/IOException
    //   84	105	310	finally
    //   110	126	759	finally
    //   129	163	754	java/net/SocketTimeoutException
    //   129	163	334	java/net/MalformedURLException
    //   129	163	187	java/io/IOException
    //   129	163	310	finally
    //   168	184	763	finally
    //   199	208	754	java/net/SocketTimeoutException
    //   199	208	334	java/net/MalformedURLException
    //   199	208	305	java/io/IOException
    //   199	208	310	finally
    //   208	221	754	java/net/SocketTimeoutException
    //   208	221	334	java/net/MalformedURLException
    //   208	221	296	java/io/IOException
    //   208	221	310	finally
    //   235	240	754	java/net/SocketTimeoutException
    //   235	240	334	java/net/MalformedURLException
    //   235	240	296	java/io/IOException
    //   235	240	310	finally
    //   240	259	754	java/net/SocketTimeoutException
    //   240	259	334	java/net/MalformedURLException
    //   240	259	291	java/io/IOException
    //   240	259	310	finally
    //   264	280	767	finally
    //   283	291	754	java/net/SocketTimeoutException
    //   283	291	334	java/net/MalformedURLException
    //   283	291	291	java/io/IOException
    //   283	291	310	finally
    //   376	382	342	finally
    //   386	410	342	finally
    //   419	439	342	finally
    //   460	470	342	finally
    //   488	495	342	finally
    //   499	515	342	finally
    //   522	532	342	finally
    //   536	546	342	finally
    //   550	566	342	finally
    //   573	587	342	finally
    //   592	600	771	finally
    //   600	608	771	finally
    //   615	625	342	finally
    //   629	638	342	finally
    //   642	651	342	finally
    //   655	665	342	finally
    //   669	684	342	finally
    //   688	702	342	finally
    //   707	714	771	finally
    //   727	743	776	finally
  }
  
  protected byte[] a(Request<?> paramRequest, HttpResponse paramHttpResponse) throws IOException, f {
    if (paramRequest instanceof c)
      return ((c)paramRequest).a(paramHttpResponse); 
    InputStream inputStream = paramHttpResponse.d();
    return (inputStream != null) ? a(inputStream, paramHttpResponse.c()) : new byte[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */