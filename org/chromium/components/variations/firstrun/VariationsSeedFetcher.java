package org.chromium.components.variations.firstrun;

import java.io.InputStream;
import java.net.HttpURLConnection;
import org.chromium.base.metrics.CachedMetrics;

public class VariationsSeedFetcher {
  private static VariationsSeedFetcher sInstance;
  
  private static final Object sLock;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static VariationsSeedFetcher$SeedInfo downloadContent(VariationsSeedFetcher$VariationsPlatform paramVariationsSeedFetcher$VariationsPlatform, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #12
    //   3: aconst_null
    //   4: astore #13
    //   6: aconst_null
    //   7: astore #14
    //   9: aconst_null
    //   10: astore #15
    //   12: aload #15
    //   14: astore #10
    //   16: invokestatic elapsedRealtime : ()J
    //   19: lstore #5
    //   21: ldc 'https://clientservices.googleapis.com/chrome-variations/seed?osname='
    //   23: astore #11
    //   25: aload #15
    //   27: astore #10
    //   29: getstatic org/chromium/components/variations/firstrun/VariationsSeedFetcher$1.$SwitchMap$org$chromium$components$variations$firstrun$VariationsSeedFetcher$VariationsPlatform : [I
    //   32: aload_0
    //   33: invokevirtual ordinal : ()I
    //   36: iaload
    //   37: tableswitch default -> 799, 1 -> 118, 2 -> 72
    //   60: aload #15
    //   62: astore #10
    //   64: getstatic org/chromium/components/variations/firstrun/VariationsSeedFetcher.$assertionsDisabled : Z
    //   67: istore #9
    //   69: goto -> 802
    //   72: aload #15
    //   74: astore #10
    //   76: new java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial <init> : ()V
    //   83: astore_0
    //   84: aload #15
    //   86: astore #10
    //   88: aload_0
    //   89: ldc 'https://clientservices.googleapis.com/chrome-variations/seed?osname='
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #15
    //   97: astore #10
    //   99: aload_0
    //   100: ldc 'android_webview'
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #15
    //   108: astore #10
    //   110: aload_0
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: astore_0
    //   115: goto -> 164
    //   118: aload #15
    //   120: astore #10
    //   122: new java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: astore_0
    //   130: aload #15
    //   132: astore #10
    //   134: aload_0
    //   135: ldc 'https://clientservices.googleapis.com/chrome-variations/seed?osname='
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload #15
    //   143: astore #10
    //   145: aload_0
    //   146: ldc 'android'
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload #15
    //   154: astore #10
    //   156: aload_0
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: astore_0
    //   161: goto -> 164
    //   164: aload_0
    //   165: astore #11
    //   167: aload_1
    //   168: ifnull -> 243
    //   171: aload_0
    //   172: astore #11
    //   174: aload #15
    //   176: astore #10
    //   178: aload_1
    //   179: invokevirtual isEmpty : ()Z
    //   182: ifne -> 243
    //   185: aload #15
    //   187: astore #10
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore #11
    //   198: aload #15
    //   200: astore #10
    //   202: aload #11
    //   204: aload_0
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #15
    //   211: astore #10
    //   213: aload #11
    //   215: ldc '&restrict='
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #15
    //   223: astore #10
    //   225: aload #11
    //   227: aload_1
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #15
    //   234: astore #10
    //   236: aload #11
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: astore #11
    //   243: aload #11
    //   245: astore_0
    //   246: aload_2
    //   247: ifnull -> 317
    //   250: aload #11
    //   252: astore_0
    //   253: aload #15
    //   255: astore #10
    //   257: aload_2
    //   258: invokevirtual isEmpty : ()Z
    //   261: ifne -> 317
    //   264: aload #15
    //   266: astore #10
    //   268: new java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial <init> : ()V
    //   275: astore_0
    //   276: aload #15
    //   278: astore #10
    //   280: aload_0
    //   281: aload #11
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #15
    //   289: astore #10
    //   291: aload_0
    //   292: ldc '&milestone='
    //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload #15
    //   300: astore #10
    //   302: aload_0
    //   303: aload_2
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload #15
    //   310: astore #10
    //   312: aload_0
    //   313: invokevirtual toString : ()Ljava/lang/String;
    //   316: astore_0
    //   317: aload_0
    //   318: astore_1
    //   319: aload_3
    //   320: ifnull -> 388
    //   323: aload_0
    //   324: astore_1
    //   325: aload #15
    //   327: astore #10
    //   329: aload_3
    //   330: invokevirtual isEmpty : ()Z
    //   333: ifne -> 388
    //   336: aload #15
    //   338: astore #10
    //   340: new java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial <init> : ()V
    //   347: astore_1
    //   348: aload #15
    //   350: astore #10
    //   352: aload_1
    //   353: aload_0
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #15
    //   360: astore #10
    //   362: aload_1
    //   363: ldc '&channel='
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #15
    //   371: astore #10
    //   373: aload_1
    //   374: aload_3
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload #15
    //   381: astore #10
    //   383: aload_1
    //   384: invokevirtual toString : ()Ljava/lang/String;
    //   387: astore_1
    //   388: aload #15
    //   390: astore #10
    //   392: new java/net/URL
    //   395: dup
    //   396: aload_1
    //   397: invokespecial <init> : (Ljava/lang/String;)V
    //   400: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   403: checkcast java/net/HttpURLConnection
    //   406: astore_0
    //   407: aload_0
    //   408: sipush #3000
    //   411: invokevirtual setReadTimeout : (I)V
    //   414: aload_0
    //   415: sipush #1000
    //   418: invokevirtual setConnectTimeout : (I)V
    //   421: aload_0
    //   422: iconst_1
    //   423: invokevirtual setDoInput : (Z)V
    //   426: aload_0
    //   427: ldc 'A-IM'
    //   429: ldc 'gzip'
    //   431: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual connect : ()V
    //   438: aload_0
    //   439: invokevirtual getResponseCode : ()I
    //   442: istore #4
    //   444: iload #4
    //   446: invokestatic recordFetchResultOrCode : (I)V
    //   449: iload #4
    //   451: sipush #200
    //   454: if_icmpne -> 615
    //   457: invokestatic elapsedRealtime : ()J
    //   460: lstore #7
    //   462: new org/chromium/base/metrics/CachedMetrics$TimesHistogramSample
    //   465: dup
    //   466: ldc 'Variations.FirstRun.SeedConnectTime'
    //   468: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   471: invokespecial <init> : (Ljava/lang/String;Ljava/util/concurrent/TimeUnit;)V
    //   474: lload #7
    //   476: lload #5
    //   478: lsub
    //   479: invokevirtual record : (J)V
    //   482: new org/chromium/components/variations/firstrun/VariationsSeedFetcher$SeedInfo
    //   485: dup
    //   486: invokespecial <init> : ()V
    //   489: astore_1
    //   490: aload_1
    //   491: aload_0
    //   492: invokestatic getRawSeed : (Ljava/net/HttpURLConnection;)[B
    //   495: putfield seedData : [B
    //   498: aload_1
    //   499: aload_0
    //   500: ldc 'X-Seed-Signature'
    //   502: invokestatic getHeaderFieldOrEmpty : (Ljava/net/HttpURLConnection;Ljava/lang/String;)Ljava/lang/String;
    //   505: putfield signature : Ljava/lang/String;
    //   508: aload_1
    //   509: aload_0
    //   510: ldc 'X-Country'
    //   512: invokestatic getHeaderFieldOrEmpty : (Ljava/net/HttpURLConnection;Ljava/lang/String;)Ljava/lang/String;
    //   515: putfield country : Ljava/lang/String;
    //   518: aload_1
    //   519: aload_0
    //   520: ldc 'Date'
    //   522: invokestatic getHeaderFieldOrEmpty : (Ljava/net/HttpURLConnection;Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield date : Ljava/lang/String;
    //   528: aload_1
    //   529: aload_0
    //   530: ldc 'IM'
    //   532: invokestatic getHeaderFieldOrEmpty : (Ljava/net/HttpURLConnection;Ljava/lang/String;)Ljava/lang/String;
    //   535: ldc 'gzip'
    //   537: invokevirtual equals : (Ljava/lang/Object;)Z
    //   540: putfield isGzipCompressed : Z
    //   543: invokestatic elapsedRealtime : ()J
    //   546: lload #5
    //   548: lsub
    //   549: lstore #5
    //   551: new java/lang/StringBuilder
    //   554: dup
    //   555: ldc 'Fetched first run seed in '
    //   557: invokespecial <init> : (Ljava/lang/String;)V
    //   560: astore_2
    //   561: aload_2
    //   562: lload #5
    //   564: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload_2
    //   569: ldc ' ms'
    //   571: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: ldc 'VariationsSeedFetch'
    //   577: aload_2
    //   578: invokevirtual toString : ()Ljava/lang/String;
    //   581: iconst_0
    //   582: anewarray java/lang/Object
    //   585: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: new org/chromium/base/metrics/CachedMetrics$TimesHistogramSample
    //   591: dup
    //   592: ldc 'Variations.FirstRun.SeedFetchTime'
    //   594: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   597: invokespecial <init> : (Ljava/lang/String;Ljava/util/concurrent/TimeUnit;)V
    //   600: lload #5
    //   602: invokevirtual record : (J)V
    //   605: aload_0
    //   606: ifnull -> 613
    //   609: aload_0
    //   610: invokevirtual disconnect : ()V
    //   613: aload_1
    //   614: areturn
    //   615: new java/lang/StringBuilder
    //   618: dup
    //   619: ldc 'Non-OK response code = '
    //   621: invokespecial <init> : (Ljava/lang/String;)V
    //   624: astore_1
    //   625: aload_1
    //   626: iload #4
    //   628: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload_1
    //   633: invokevirtual toString : ()Ljava/lang/String;
    //   636: astore_1
    //   637: ldc 'VariationsSeedFetch'
    //   639: aload_1
    //   640: iconst_0
    //   641: anewarray java/lang/Object
    //   644: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   647: new java/io/IOException
    //   650: dup
    //   651: aload_1
    //   652: invokespecial <init> : (Ljava/lang/String;)V
    //   655: athrow
    //   656: astore_1
    //   657: aload_0
    //   658: astore #10
    //   660: goto -> 787
    //   663: astore_1
    //   664: goto -> 695
    //   667: astore_1
    //   668: goto -> 725
    //   671: astore_1
    //   672: goto -> 756
    //   675: aload #15
    //   677: astore #10
    //   679: new java/lang/AssertionError
    //   682: dup
    //   683: invokespecial <init> : ()V
    //   686: athrow
    //   687: astore_1
    //   688: goto -> 787
    //   691: astore_1
    //   692: aload #12
    //   694: astore_0
    //   695: aload_0
    //   696: astore #10
    //   698: iconst_m1
    //   699: invokestatic recordFetchResultOrCode : (I)V
    //   702: aload_0
    //   703: astore #10
    //   705: ldc 'VariationsSeedFetch'
    //   707: ldc 'IOException when fetching variations seed.'
    //   709: iconst_1
    //   710: anewarray java/lang/Object
    //   713: dup
    //   714: iconst_0
    //   715: aload_1
    //   716: aastore
    //   717: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: aload_0
    //   721: astore #10
    //   723: aload_1
    //   724: athrow
    //   725: aload_0
    //   726: astore #10
    //   728: bipush #-3
    //   730: invokestatic recordFetchResultOrCode : (I)V
    //   733: aload_0
    //   734: astore #10
    //   736: ldc 'VariationsSeedFetch'
    //   738: ldc 'UnknownHostException unknown host when fetching variations seed.'
    //   740: iconst_1
    //   741: anewarray java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload_1
    //   747: aastore
    //   748: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: aload_0
    //   752: astore #10
    //   754: aload_1
    //   755: athrow
    //   756: aload_0
    //   757: astore #10
    //   759: bipush #-2
    //   761: invokestatic recordFetchResultOrCode : (I)V
    //   764: aload_0
    //   765: astore #10
    //   767: ldc 'VariationsSeedFetch'
    //   769: ldc 'SocketTimeoutException timeout when fetching variations seed.'
    //   771: iconst_1
    //   772: anewarray java/lang/Object
    //   775: dup
    //   776: iconst_0
    //   777: aload_1
    //   778: aastore
    //   779: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: aload_0
    //   783: astore #10
    //   785: aload_1
    //   786: athrow
    //   787: aload #10
    //   789: ifnull -> 797
    //   792: aload #10
    //   794: invokevirtual disconnect : ()V
    //   797: aload_1
    //   798: athrow
    //   799: goto -> 60
    //   802: iload #9
    //   804: ifeq -> 675
    //   807: aload #11
    //   809: astore_0
    //   810: goto -> 164
    //   813: astore_1
    //   814: aload #13
    //   816: astore_0
    //   817: goto -> 725
    //   820: astore_1
    //   821: aload #14
    //   823: astore_0
    //   824: goto -> 756
    // Exception table:
    //   from	to	target	type
    //   16	21	820	java/net/SocketTimeoutException
    //   16	21	813	java/net/UnknownHostException
    //   16	21	691	java/io/IOException
    //   16	21	687	finally
    //   29	60	820	java/net/SocketTimeoutException
    //   29	60	813	java/net/UnknownHostException
    //   29	60	691	java/io/IOException
    //   29	60	687	finally
    //   64	69	820	java/net/SocketTimeoutException
    //   64	69	813	java/net/UnknownHostException
    //   64	69	691	java/io/IOException
    //   64	69	687	finally
    //   76	84	820	java/net/SocketTimeoutException
    //   76	84	813	java/net/UnknownHostException
    //   76	84	691	java/io/IOException
    //   76	84	687	finally
    //   88	95	820	java/net/SocketTimeoutException
    //   88	95	813	java/net/UnknownHostException
    //   88	95	691	java/io/IOException
    //   88	95	687	finally
    //   99	106	820	java/net/SocketTimeoutException
    //   99	106	813	java/net/UnknownHostException
    //   99	106	691	java/io/IOException
    //   99	106	687	finally
    //   110	115	820	java/net/SocketTimeoutException
    //   110	115	813	java/net/UnknownHostException
    //   110	115	691	java/io/IOException
    //   110	115	687	finally
    //   122	130	820	java/net/SocketTimeoutException
    //   122	130	813	java/net/UnknownHostException
    //   122	130	691	java/io/IOException
    //   122	130	687	finally
    //   134	141	820	java/net/SocketTimeoutException
    //   134	141	813	java/net/UnknownHostException
    //   134	141	691	java/io/IOException
    //   134	141	687	finally
    //   145	152	820	java/net/SocketTimeoutException
    //   145	152	813	java/net/UnknownHostException
    //   145	152	691	java/io/IOException
    //   145	152	687	finally
    //   156	161	820	java/net/SocketTimeoutException
    //   156	161	813	java/net/UnknownHostException
    //   156	161	691	java/io/IOException
    //   156	161	687	finally
    //   178	185	820	java/net/SocketTimeoutException
    //   178	185	813	java/net/UnknownHostException
    //   178	185	691	java/io/IOException
    //   178	185	687	finally
    //   189	198	820	java/net/SocketTimeoutException
    //   189	198	813	java/net/UnknownHostException
    //   189	198	691	java/io/IOException
    //   189	198	687	finally
    //   202	209	820	java/net/SocketTimeoutException
    //   202	209	813	java/net/UnknownHostException
    //   202	209	691	java/io/IOException
    //   202	209	687	finally
    //   213	221	820	java/net/SocketTimeoutException
    //   213	221	813	java/net/UnknownHostException
    //   213	221	691	java/io/IOException
    //   213	221	687	finally
    //   225	232	820	java/net/SocketTimeoutException
    //   225	232	813	java/net/UnknownHostException
    //   225	232	691	java/io/IOException
    //   225	232	687	finally
    //   236	243	820	java/net/SocketTimeoutException
    //   236	243	813	java/net/UnknownHostException
    //   236	243	691	java/io/IOException
    //   236	243	687	finally
    //   257	264	820	java/net/SocketTimeoutException
    //   257	264	813	java/net/UnknownHostException
    //   257	264	691	java/io/IOException
    //   257	264	687	finally
    //   268	276	820	java/net/SocketTimeoutException
    //   268	276	813	java/net/UnknownHostException
    //   268	276	691	java/io/IOException
    //   268	276	687	finally
    //   280	287	820	java/net/SocketTimeoutException
    //   280	287	813	java/net/UnknownHostException
    //   280	287	691	java/io/IOException
    //   280	287	687	finally
    //   291	298	820	java/net/SocketTimeoutException
    //   291	298	813	java/net/UnknownHostException
    //   291	298	691	java/io/IOException
    //   291	298	687	finally
    //   302	308	820	java/net/SocketTimeoutException
    //   302	308	813	java/net/UnknownHostException
    //   302	308	691	java/io/IOException
    //   302	308	687	finally
    //   312	317	820	java/net/SocketTimeoutException
    //   312	317	813	java/net/UnknownHostException
    //   312	317	691	java/io/IOException
    //   312	317	687	finally
    //   329	336	820	java/net/SocketTimeoutException
    //   329	336	813	java/net/UnknownHostException
    //   329	336	691	java/io/IOException
    //   329	336	687	finally
    //   340	348	820	java/net/SocketTimeoutException
    //   340	348	813	java/net/UnknownHostException
    //   340	348	691	java/io/IOException
    //   340	348	687	finally
    //   352	358	820	java/net/SocketTimeoutException
    //   352	358	813	java/net/UnknownHostException
    //   352	358	691	java/io/IOException
    //   352	358	687	finally
    //   362	369	820	java/net/SocketTimeoutException
    //   362	369	813	java/net/UnknownHostException
    //   362	369	691	java/io/IOException
    //   362	369	687	finally
    //   373	379	820	java/net/SocketTimeoutException
    //   373	379	813	java/net/UnknownHostException
    //   373	379	691	java/io/IOException
    //   373	379	687	finally
    //   383	388	820	java/net/SocketTimeoutException
    //   383	388	813	java/net/UnknownHostException
    //   383	388	691	java/io/IOException
    //   383	388	687	finally
    //   392	407	820	java/net/SocketTimeoutException
    //   392	407	813	java/net/UnknownHostException
    //   392	407	691	java/io/IOException
    //   392	407	687	finally
    //   407	449	671	java/net/SocketTimeoutException
    //   407	449	667	java/net/UnknownHostException
    //   407	449	663	java/io/IOException
    //   407	449	656	finally
    //   457	605	671	java/net/SocketTimeoutException
    //   457	605	667	java/net/UnknownHostException
    //   457	605	663	java/io/IOException
    //   457	605	656	finally
    //   615	656	671	java/net/SocketTimeoutException
    //   615	656	667	java/net/UnknownHostException
    //   615	656	663	java/io/IOException
    //   615	656	656	finally
    //   679	687	820	java/net/SocketTimeoutException
    //   679	687	813	java/net/UnknownHostException
    //   679	687	691	java/io/IOException
    //   679	687	687	finally
    //   698	702	687	finally
    //   705	720	687	finally
    //   723	725	687	finally
    //   728	733	687	finally
    //   736	751	687	finally
    //   754	756	687	finally
    //   759	764	687	finally
    //   767	782	687	finally
    //   785	787	687	finally
  }
  
  public static VariationsSeedFetcher get() {
    synchronized (sLock) {
      if (sInstance == null)
        sInstance = new VariationsSeedFetcher(); 
      return sInstance;
    } 
  }
  
  private static String getHeaderFieldOrEmpty(HttpURLConnection paramHttpURLConnection, String paramString) {
    String str = paramHttpURLConnection.getHeaderField(paramString);
    return (str == null) ? "" : str.trim();
  }
  
  private static byte[] getRawSeed(HttpURLConnection paramHttpURLConnection) {
    InputStream inputStream;
    try {
      inputStream = paramHttpURLConnection.getInputStream();
    } finally {
      paramHttpURLConnection = null;
    } 
    if (inputStream != null)
      inputStream.close(); 
    throw paramHttpURLConnection;
  }
  
  private static void recordFetchResultOrCode(int paramInt) {
    (new CachedMetrics.SparseHistogramSample("Variations.FirstRun.SeedFetchResult")).record(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\variations\firstrun\VariationsSeedFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */