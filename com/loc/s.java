package com.loc;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public final class s {
  private static String a() {
    Exception exception1;
    Exception exception2;
    String str;
    try {
      String str1 = Proxy.getDefaultHost();
    } finally {
      exception1 = null;
      ab.b(exception1, "pu", "gdh");
    } 
    return str;
  }
  
  public static Proxy a(Context paramContext) {
    try {
      return (Build.VERSION.SDK_INT >= 11) ? a(paramContext, new URI("http://restsdk.amap.com")) : b(paramContext);
    } finally {
      paramContext = null;
      ab.b((Throwable)paramContext, "pu", "gp");
    } 
  }
  
  private static Proxy a(Context paramContext, URI paramURI) {
    boolean bool = c(paramContext);
    Context context = null;
    if (bool)
      try {
        List<Proxy> list = ProxySelector.getDefault().select(paramURI);
        paramContext = context;
        return proxy;
      } finally {
        paramContext = null;
      }  
    return null;
  }
  
  private static int b() {
    try {
      return Proxy.getDefaultPort();
    } finally {
      Exception exception = null;
      ab.b(exception, "pu", "gdp");
    } 
  }
  
  private static Proxy b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic c : (Landroid/content/Context;)Z
    //   4: ifeq -> 781
    //   7: ldc 'content://telephony/carriers/preferapn'
    //   9: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore #6
    //   14: aload_0
    //   15: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   18: astore #7
    //   20: iconst_0
    //   21: istore #4
    //   23: aload #7
    //   25: aload #6
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore #7
    //   36: aload #7
    //   38: ifnull -> 346
    //   41: aload #7
    //   43: invokeinterface moveToFirst : ()Z
    //   48: ifeq -> 346
    //   51: aload #7
    //   53: aload #7
    //   55: ldc 'apn'
    //   57: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   62: invokeinterface getString : (I)Ljava/lang/String;
    //   67: astore #8
    //   69: aload #8
    //   71: astore #6
    //   73: aload #8
    //   75: ifnull -> 88
    //   78: aload #8
    //   80: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   83: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   86: astore #6
    //   88: aload #6
    //   90: ifnull -> 230
    //   93: aload #6
    //   95: ldc 'ctwap'
    //   97: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   100: ifeq -> 230
    //   103: invokestatic a : ()Ljava/lang/String;
    //   106: astore #6
    //   108: invokestatic b : ()I
    //   111: istore_1
    //   112: iload_1
    //   113: istore_2
    //   114: iload_1
    //   115: istore_3
    //   116: aload #6
    //   118: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   121: ifne -> 147
    //   124: iload_1
    //   125: istore_2
    //   126: iload_1
    //   127: istore_3
    //   128: aload #6
    //   130: ldc 'null'
    //   132: invokevirtual equals : (Ljava/lang/Object;)Z
    //   135: istore #5
    //   137: iload #5
    //   139: ifne -> 147
    //   142: iconst_1
    //   143: istore_2
    //   144: goto -> 152
    //   147: aconst_null
    //   148: astore #6
    //   150: iconst_0
    //   151: istore_2
    //   152: iload_2
    //   153: ifne -> 194
    //   156: iload_1
    //   157: istore_2
    //   158: aload #6
    //   160: astore #8
    //   162: iload_1
    //   163: istore_3
    //   164: ldc 'QMTAuMC4wLjIwMA=='
    //   166: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   169: astore #9
    //   171: aload #9
    //   173: astore_0
    //   174: goto -> 197
    //   177: astore #6
    //   179: iload_2
    //   180: istore_1
    //   181: aload #8
    //   183: astore_0
    //   184: goto -> 403
    //   187: astore #8
    //   189: iload_3
    //   190: istore_1
    //   191: goto -> 465
    //   194: aload #6
    //   196: astore_0
    //   197: iload_1
    //   198: iconst_m1
    //   199: if_icmpne -> 208
    //   202: bipush #80
    //   204: istore_1
    //   205: goto -> 208
    //   208: goto -> 350
    //   211: astore #6
    //   213: aconst_null
    //   214: astore_0
    //   215: iload_2
    //   216: istore_1
    //   217: goto -> 403
    //   220: astore #8
    //   222: aconst_null
    //   223: astore #6
    //   225: iload_3
    //   226: istore_1
    //   227: goto -> 465
    //   230: aload #6
    //   232: ifnull -> 346
    //   235: aload #6
    //   237: ldc 'wap'
    //   239: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   242: ifeq -> 346
    //   245: invokestatic a : ()Ljava/lang/String;
    //   248: astore #6
    //   250: invokestatic b : ()I
    //   253: istore_1
    //   254: iload_1
    //   255: istore_2
    //   256: iload_1
    //   257: istore_3
    //   258: aload #6
    //   260: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   263: ifne -> 289
    //   266: iload_1
    //   267: istore_2
    //   268: iload_1
    //   269: istore_3
    //   270: aload #6
    //   272: ldc 'null'
    //   274: invokevirtual equals : (Ljava/lang/Object;)Z
    //   277: istore #5
    //   279: iload #5
    //   281: ifne -> 289
    //   284: iconst_1
    //   285: istore_2
    //   286: goto -> 294
    //   289: aconst_null
    //   290: astore #6
    //   292: iconst_0
    //   293: istore_2
    //   294: iload_2
    //   295: ifne -> 319
    //   298: iload_1
    //   299: istore_2
    //   300: aload #6
    //   302: astore #8
    //   304: iload_1
    //   305: istore_3
    //   306: ldc 'QMTAuMC4wLjE3Mg=='
    //   308: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   311: astore #9
    //   313: aload #9
    //   315: astore_0
    //   316: goto -> 322
    //   319: aload #6
    //   321: astore_0
    //   322: iload_1
    //   323: iconst_m1
    //   324: if_icmpne -> 333
    //   327: bipush #80
    //   329: istore_1
    //   330: goto -> 350
    //   333: goto -> 350
    //   336: astore #6
    //   338: goto -> 399
    //   341: astore #8
    //   343: goto -> 460
    //   346: aconst_null
    //   347: astore_0
    //   348: iconst_m1
    //   349: istore_1
    //   350: aload_0
    //   351: astore #6
    //   353: iload_1
    //   354: istore_2
    //   355: aload #7
    //   357: ifnull -> 391
    //   360: aload #7
    //   362: invokeinterface close : ()V
    //   367: aload_0
    //   368: astore #6
    //   370: iload_1
    //   371: istore_2
    //   372: goto -> 391
    //   375: astore #6
    //   377: aload #6
    //   379: ldc 'pu'
    //   381: ldc 'gPx2'
    //   383: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   386: iload_1
    //   387: istore_2
    //   388: aload_0
    //   389: astore #6
    //   391: goto -> 683
    //   394: astore #6
    //   396: aconst_null
    //   397: astore #7
    //   399: aconst_null
    //   400: astore_0
    //   401: iconst_m1
    //   402: istore_1
    //   403: aload #7
    //   405: astore #9
    //   407: aload #6
    //   409: ldc 'pu'
    //   411: ldc 'gPx1'
    //   413: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload #7
    //   418: astore #9
    //   420: aload #6
    //   422: invokevirtual printStackTrace : ()V
    //   425: aload_0
    //   426: astore #6
    //   428: iload_1
    //   429: istore_2
    //   430: aload #7
    //   432: ifnull -> 391
    //   435: aload #7
    //   437: invokeinterface close : ()V
    //   442: aload_0
    //   443: astore #6
    //   445: iload_1
    //   446: istore_2
    //   447: goto -> 391
    //   450: astore #6
    //   452: goto -> 377
    //   455: astore #8
    //   457: aconst_null
    //   458: astore #7
    //   460: aconst_null
    //   461: astore #6
    //   463: iconst_m1
    //   464: istore_1
    //   465: aload #7
    //   467: astore #9
    //   469: aload #8
    //   471: ldc 'pu'
    //   473: ldc 'ghp'
    //   475: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload #7
    //   480: astore #9
    //   482: aload_0
    //   483: invokestatic s : (Landroid/content/Context;)Ljava/lang/String;
    //   486: astore_0
    //   487: aload_0
    //   488: ifnull -> 650
    //   491: aload #7
    //   493: astore #9
    //   495: aload_0
    //   496: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   499: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   502: astore #8
    //   504: aload #7
    //   506: astore #9
    //   508: invokestatic a : ()Ljava/lang/String;
    //   511: astore_0
    //   512: aload #7
    //   514: astore #9
    //   516: invokestatic b : ()I
    //   519: istore_2
    //   520: aload #7
    //   522: astore #9
    //   524: aload #8
    //   526: ldc 'ctwap'
    //   528: invokevirtual indexOf : (Ljava/lang/String;)I
    //   531: iconst_m1
    //   532: if_icmpeq -> 581
    //   535: aload #7
    //   537: astore #9
    //   539: aload_0
    //   540: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   543: ifne -> 783
    //   546: aload #7
    //   548: astore #9
    //   550: aload_0
    //   551: ldc 'null'
    //   553: invokevirtual equals : (Ljava/lang/Object;)Z
    //   556: ifne -> 783
    //   559: iconst_1
    //   560: istore_1
    //   561: goto -> 564
    //   564: iload_1
    //   565: ifne -> 791
    //   568: aload #7
    //   570: astore #9
    //   572: ldc 'QMTAuMC4wLjIwMA=='
    //   574: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   577: astore_0
    //   578: goto -> 791
    //   581: aload #7
    //   583: astore #9
    //   585: aload #8
    //   587: ldc 'wap'
    //   589: invokevirtual indexOf : (Ljava/lang/String;)I
    //   592: iconst_m1
    //   593: if_icmpeq -> 642
    //   596: aload #7
    //   598: astore #9
    //   600: aload_0
    //   601: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   604: ifne -> 805
    //   607: aload #7
    //   609: astore #9
    //   611: aload_0
    //   612: ldc 'null'
    //   614: invokevirtual equals : (Ljava/lang/Object;)Z
    //   617: ifne -> 805
    //   620: iconst_1
    //   621: istore_1
    //   622: goto -> 625
    //   625: iload_1
    //   626: ifne -> 796
    //   629: aload #7
    //   631: astore #9
    //   633: ldc 'QMTAuMC4wLjE3Mg=='
    //   635: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   638: astore_0
    //   639: goto -> 796
    //   642: aload #6
    //   644: astore_0
    //   645: iload_2
    //   646: istore_1
    //   647: goto -> 653
    //   650: aload #6
    //   652: astore_0
    //   653: aload_0
    //   654: astore #6
    //   656: iload_1
    //   657: istore_2
    //   658: aload #7
    //   660: ifnull -> 391
    //   663: aload #7
    //   665: invokeinterface close : ()V
    //   670: aload_0
    //   671: astore #6
    //   673: iload_1
    //   674: istore_2
    //   675: goto -> 391
    //   678: astore #6
    //   680: goto -> 377
    //   683: iload #4
    //   685: istore_1
    //   686: aload #6
    //   688: ifnull -> 715
    //   691: iload #4
    //   693: istore_1
    //   694: aload #6
    //   696: invokevirtual length : ()I
    //   699: ifle -> 715
    //   702: iload #4
    //   704: istore_1
    //   705: iload_2
    //   706: iconst_m1
    //   707: if_icmpeq -> 715
    //   710: iconst_1
    //   711: istore_1
    //   712: goto -> 715
    //   715: iload_1
    //   716: ifeq -> 781
    //   719: new java/net/Proxy
    //   722: dup
    //   723: getstatic java/net/Proxy$Type.HTTP : Ljava/net/Proxy$Type;
    //   726: aload #6
    //   728: iload_2
    //   729: invokestatic createUnresolved : (Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   732: invokespecial <init> : (Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   735: astore_0
    //   736: aload_0
    //   737: areturn
    //   738: aload_0
    //   739: ldc 'pu'
    //   741: ldc 'gp2'
    //   743: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload_0
    //   747: invokevirtual printStackTrace : ()V
    //   750: aconst_null
    //   751: areturn
    //   752: astore_0
    //   753: aload #9
    //   755: ifnull -> 779
    //   758: aload #9
    //   760: invokeinterface close : ()V
    //   765: goto -> 779
    //   768: astore #6
    //   770: aload #6
    //   772: ldc 'pu'
    //   774: ldc 'gPx2'
    //   776: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   779: aload_0
    //   780: athrow
    //   781: aconst_null
    //   782: areturn
    //   783: aload #6
    //   785: astore_0
    //   786: iconst_0
    //   787: istore_1
    //   788: goto -> 564
    //   791: iload_2
    //   792: iconst_m1
    //   793: if_icmpne -> 802
    //   796: bipush #80
    //   798: istore_1
    //   799: goto -> 653
    //   802: goto -> 645
    //   805: aload #6
    //   807: astore_0
    //   808: iconst_0
    //   809: istore_1
    //   810: goto -> 625
    //   813: astore_0
    //   814: goto -> 738
    // Exception table:
    //   from	to	target	type
    //   23	36	455	java/lang/SecurityException
    //   23	36	394	finally
    //   41	69	341	java/lang/SecurityException
    //   41	69	336	finally
    //   78	88	341	java/lang/SecurityException
    //   78	88	336	finally
    //   93	112	341	java/lang/SecurityException
    //   93	112	336	finally
    //   116	124	220	java/lang/SecurityException
    //   116	124	211	finally
    //   128	137	220	java/lang/SecurityException
    //   128	137	211	finally
    //   164	171	187	java/lang/SecurityException
    //   164	171	177	finally
    //   235	254	341	java/lang/SecurityException
    //   235	254	336	finally
    //   258	266	220	java/lang/SecurityException
    //   258	266	211	finally
    //   270	279	220	java/lang/SecurityException
    //   270	279	211	finally
    //   306	313	187	java/lang/SecurityException
    //   306	313	177	finally
    //   360	367	375	finally
    //   407	416	752	finally
    //   420	425	752	finally
    //   435	442	450	finally
    //   469	478	752	finally
    //   482	487	752	finally
    //   495	504	752	finally
    //   508	512	752	finally
    //   516	520	752	finally
    //   524	535	752	finally
    //   539	546	752	finally
    //   550	559	752	finally
    //   572	578	752	finally
    //   585	596	752	finally
    //   600	607	752	finally
    //   611	620	752	finally
    //   633	639	752	finally
    //   663	670	678	finally
    //   694	702	813	finally
    //   719	736	813	finally
    //   758	765	768	finally
  }
  
  private static boolean c(Context paramContext) {
    return (n.q(paramContext) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */