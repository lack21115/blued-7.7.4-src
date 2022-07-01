package com.amap.api.mapcore2d;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public class cy {
  private static String a() {
    Exception exception1;
    Exception exception2;
    String str;
    try {
      String str1 = Proxy.getDefaultHost();
    } finally {
      exception1 = null;
      do.c(exception1, "pu", "gdh");
    } 
    return str;
  }
  
  public static String a(String paramString) {
    return db.c(paramString);
  }
  
  public static Proxy a(Context paramContext) {
    try {
      return (Build.VERSION.SDK_INT >= 11) ? a(paramContext, new URI("http://restapi.amap.com")) : b(paramContext);
    } finally {
      paramContext = null;
      do.c((Throwable)paramContext, "pu", "gp");
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
  
  private static boolean a(String paramString, int paramInt) {
    return (paramString != null && paramString.length() > 0 && paramInt != -1);
  }
  
  private static int b() {
    try {
      return Proxy.getDefaultPort();
    } finally {
      Exception exception = null;
      do.c(exception, "pu", "gdp");
    } 
  }
  
  private static Proxy b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic c : (Landroid/content/Context;)Z
    //   4: ifeq -> 764
    //   7: ldc 'content://telephony/carriers/preferapn'
    //   9: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore #8
    //   14: aload_0
    //   15: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   18: astore #9
    //   20: iconst_1
    //   21: istore #6
    //   23: iconst_1
    //   24: istore #5
    //   26: bipush #80
    //   28: istore #4
    //   30: aload #9
    //   32: aload #8
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore #9
    //   43: aload #9
    //   45: ifnull -> 353
    //   48: aload #9
    //   50: invokeinterface moveToFirst : ()Z
    //   55: ifeq -> 353
    //   58: aload #9
    //   60: aload #9
    //   62: ldc 'apn'
    //   64: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   69: invokeinterface getString : (I)Ljava/lang/String;
    //   74: astore #10
    //   76: aload #10
    //   78: astore #8
    //   80: aload #10
    //   82: ifnull -> 95
    //   85: aload #10
    //   87: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   90: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   93: astore #8
    //   95: aload #8
    //   97: ifnull -> 237
    //   100: aload #8
    //   102: ldc 'ctwap'
    //   104: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   107: ifeq -> 237
    //   110: invokestatic a : ()Ljava/lang/String;
    //   113: astore #8
    //   115: invokestatic b : ()I
    //   118: istore_1
    //   119: iload_1
    //   120: istore_2
    //   121: iload_1
    //   122: istore_3
    //   123: aload #8
    //   125: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   128: ifne -> 154
    //   131: iload_1
    //   132: istore_2
    //   133: iload_1
    //   134: istore_3
    //   135: aload #8
    //   137: ldc 'null'
    //   139: invokevirtual equals : (Ljava/lang/Object;)Z
    //   142: istore #7
    //   144: iload #7
    //   146: ifne -> 154
    //   149: iconst_1
    //   150: istore_2
    //   151: goto -> 159
    //   154: aconst_null
    //   155: astore #8
    //   157: iconst_0
    //   158: istore_2
    //   159: iload_2
    //   160: ifne -> 201
    //   163: iload_1
    //   164: istore_2
    //   165: aload #8
    //   167: astore #10
    //   169: iload_1
    //   170: istore_3
    //   171: ldc 'QMTAuMC4wLjIwMA=='
    //   173: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   176: astore #11
    //   178: aload #11
    //   180: astore_0
    //   181: goto -> 204
    //   184: astore #8
    //   186: iload_2
    //   187: istore_1
    //   188: aload #10
    //   190: astore_0
    //   191: goto -> 410
    //   194: astore #10
    //   196: iload_3
    //   197: istore_1
    //   198: goto -> 472
    //   201: aload #8
    //   203: astore_0
    //   204: iload_1
    //   205: iconst_m1
    //   206: if_icmpne -> 215
    //   209: iload #4
    //   211: istore_1
    //   212: goto -> 215
    //   215: goto -> 357
    //   218: astore #8
    //   220: aconst_null
    //   221: astore_0
    //   222: iload_2
    //   223: istore_1
    //   224: goto -> 410
    //   227: astore #10
    //   229: aconst_null
    //   230: astore #8
    //   232: iload_3
    //   233: istore_1
    //   234: goto -> 472
    //   237: aload #8
    //   239: ifnull -> 353
    //   242: aload #8
    //   244: ldc 'wap'
    //   246: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   249: ifeq -> 353
    //   252: invokestatic a : ()Ljava/lang/String;
    //   255: astore #8
    //   257: invokestatic b : ()I
    //   260: istore_1
    //   261: iload_1
    //   262: istore_2
    //   263: iload_1
    //   264: istore_3
    //   265: aload #8
    //   267: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   270: ifne -> 296
    //   273: iload_1
    //   274: istore_2
    //   275: iload_1
    //   276: istore_3
    //   277: aload #8
    //   279: ldc 'null'
    //   281: invokevirtual equals : (Ljava/lang/Object;)Z
    //   284: istore #7
    //   286: iload #7
    //   288: ifne -> 296
    //   291: iconst_1
    //   292: istore_2
    //   293: goto -> 301
    //   296: aconst_null
    //   297: astore #8
    //   299: iconst_0
    //   300: istore_2
    //   301: iload_2
    //   302: ifne -> 326
    //   305: iload_1
    //   306: istore_2
    //   307: aload #8
    //   309: astore #10
    //   311: iload_1
    //   312: istore_3
    //   313: ldc 'QMTAuMC4wLjE3Mg=='
    //   315: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   318: astore #11
    //   320: aload #11
    //   322: astore_0
    //   323: goto -> 329
    //   326: aload #8
    //   328: astore_0
    //   329: iload_1
    //   330: iconst_m1
    //   331: if_icmpne -> 340
    //   334: iload #4
    //   336: istore_1
    //   337: goto -> 215
    //   340: goto -> 357
    //   343: astore #8
    //   345: goto -> 406
    //   348: astore #10
    //   350: goto -> 467
    //   353: aconst_null
    //   354: astore_0
    //   355: iconst_m1
    //   356: istore_1
    //   357: aload_0
    //   358: astore #8
    //   360: iload_1
    //   361: istore_2
    //   362: aload #9
    //   364: ifnull -> 398
    //   367: aload #9
    //   369: invokeinterface close : ()V
    //   374: aload_0
    //   375: astore #8
    //   377: iload_1
    //   378: istore_2
    //   379: goto -> 398
    //   382: astore #8
    //   384: aload #8
    //   386: ldc 'pu'
    //   388: ldc 'gPx2'
    //   390: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   393: iload_1
    //   394: istore_2
    //   395: aload_0
    //   396: astore #8
    //   398: goto -> 692
    //   401: astore #8
    //   403: aconst_null
    //   404: astore #9
    //   406: aconst_null
    //   407: astore_0
    //   408: iconst_m1
    //   409: istore_1
    //   410: aload #9
    //   412: astore #11
    //   414: aload #8
    //   416: ldc 'pu'
    //   418: ldc 'gPx1'
    //   420: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload #9
    //   425: astore #11
    //   427: aload #8
    //   429: invokevirtual printStackTrace : ()V
    //   432: aload_0
    //   433: astore #8
    //   435: iload_1
    //   436: istore_2
    //   437: aload #9
    //   439: ifnull -> 398
    //   442: aload #9
    //   444: invokeinterface close : ()V
    //   449: aload_0
    //   450: astore #8
    //   452: iload_1
    //   453: istore_2
    //   454: goto -> 398
    //   457: astore #8
    //   459: goto -> 384
    //   462: astore #10
    //   464: aconst_null
    //   465: astore #9
    //   467: aconst_null
    //   468: astore #8
    //   470: iconst_m1
    //   471: istore_1
    //   472: aload #9
    //   474: astore #11
    //   476: aload #10
    //   478: ldc 'pu'
    //   480: ldc 'ghp'
    //   482: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload #9
    //   487: astore #11
    //   489: aload_0
    //   490: invokestatic t : (Landroid/content/Context;)Ljava/lang/String;
    //   493: astore_0
    //   494: aload_0
    //   495: ifnull -> 659
    //   498: aload #9
    //   500: astore #11
    //   502: aload_0
    //   503: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   506: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   509: astore #10
    //   511: aload #9
    //   513: astore #11
    //   515: invokestatic a : ()Ljava/lang/String;
    //   518: astore_0
    //   519: aload #9
    //   521: astore #11
    //   523: invokestatic b : ()I
    //   526: istore_2
    //   527: aload #9
    //   529: astore #11
    //   531: aload #10
    //   533: ldc 'ctwap'
    //   535: invokevirtual indexOf : (Ljava/lang/String;)I
    //   538: iconst_m1
    //   539: if_icmpeq -> 589
    //   542: aload #9
    //   544: astore #11
    //   546: aload_0
    //   547: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   550: ifne -> 766
    //   553: aload #9
    //   555: astore #11
    //   557: aload_0
    //   558: ldc 'null'
    //   560: invokevirtual equals : (Ljava/lang/Object;)Z
    //   563: ifne -> 766
    //   566: iload #5
    //   568: istore_1
    //   569: goto -> 572
    //   572: iload_1
    //   573: ifne -> 774
    //   576: aload #9
    //   578: astore #11
    //   580: ldc 'QMTAuMC4wLjIwMA=='
    //   582: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   585: astore_0
    //   586: goto -> 774
    //   589: aload #9
    //   591: astore #11
    //   593: aload #10
    //   595: ldc 'wap'
    //   597: invokevirtual indexOf : (Ljava/lang/String;)I
    //   600: iconst_m1
    //   601: if_icmpeq -> 651
    //   604: aload #9
    //   606: astore #11
    //   608: aload_0
    //   609: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   612: ifne -> 788
    //   615: aload #9
    //   617: astore #11
    //   619: aload_0
    //   620: ldc 'null'
    //   622: invokevirtual equals : (Ljava/lang/Object;)Z
    //   625: ifne -> 788
    //   628: iload #6
    //   630: istore_1
    //   631: goto -> 634
    //   634: iload_1
    //   635: ifne -> 779
    //   638: aload #9
    //   640: astore #11
    //   642: ldc 'QMTAuMC4wLjE3Mg=='
    //   644: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   647: astore_0
    //   648: goto -> 779
    //   651: aload #8
    //   653: astore_0
    //   654: iload_2
    //   655: istore_1
    //   656: goto -> 662
    //   659: aload #8
    //   661: astore_0
    //   662: aload_0
    //   663: astore #8
    //   665: iload_1
    //   666: istore_2
    //   667: aload #9
    //   669: ifnull -> 398
    //   672: aload #9
    //   674: invokeinterface close : ()V
    //   679: aload_0
    //   680: astore #8
    //   682: iload_1
    //   683: istore_2
    //   684: goto -> 398
    //   687: astore #8
    //   689: goto -> 384
    //   692: aload #8
    //   694: iload_2
    //   695: invokestatic a : (Ljava/lang/String;I)Z
    //   698: ifeq -> 764
    //   701: new java/net/Proxy
    //   704: dup
    //   705: getstatic java/net/Proxy$Type.HTTP : Ljava/net/Proxy$Type;
    //   708: aload #8
    //   710: iload_2
    //   711: invokestatic createUnresolved : (Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   714: invokespecial <init> : (Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   717: astore_0
    //   718: aload_0
    //   719: areturn
    //   720: astore_0
    //   721: aload_0
    //   722: ldc 'pu'
    //   724: ldc 'gp2'
    //   726: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   729: aload_0
    //   730: invokevirtual printStackTrace : ()V
    //   733: aconst_null
    //   734: areturn
    //   735: astore_0
    //   736: aload #11
    //   738: ifnull -> 762
    //   741: aload #11
    //   743: invokeinterface close : ()V
    //   748: goto -> 762
    //   751: astore #8
    //   753: aload #8
    //   755: ldc 'pu'
    //   757: ldc 'gPx2'
    //   759: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload_0
    //   763: athrow
    //   764: aconst_null
    //   765: areturn
    //   766: aload #8
    //   768: astore_0
    //   769: iconst_0
    //   770: istore_1
    //   771: goto -> 572
    //   774: iload_2
    //   775: iconst_m1
    //   776: if_icmpne -> 785
    //   779: iload #4
    //   781: istore_1
    //   782: goto -> 662
    //   785: goto -> 654
    //   788: aload #8
    //   790: astore_0
    //   791: iconst_0
    //   792: istore_1
    //   793: goto -> 634
    // Exception table:
    //   from	to	target	type
    //   30	43	462	java/lang/SecurityException
    //   30	43	401	finally
    //   48	76	348	java/lang/SecurityException
    //   48	76	343	finally
    //   85	95	348	java/lang/SecurityException
    //   85	95	343	finally
    //   100	119	348	java/lang/SecurityException
    //   100	119	343	finally
    //   123	131	227	java/lang/SecurityException
    //   123	131	218	finally
    //   135	144	227	java/lang/SecurityException
    //   135	144	218	finally
    //   171	178	194	java/lang/SecurityException
    //   171	178	184	finally
    //   242	261	348	java/lang/SecurityException
    //   242	261	343	finally
    //   265	273	227	java/lang/SecurityException
    //   265	273	218	finally
    //   277	286	227	java/lang/SecurityException
    //   277	286	218	finally
    //   313	320	194	java/lang/SecurityException
    //   313	320	184	finally
    //   367	374	382	finally
    //   414	423	735	finally
    //   427	432	735	finally
    //   442	449	457	finally
    //   476	485	735	finally
    //   489	494	735	finally
    //   502	511	735	finally
    //   515	519	735	finally
    //   523	527	735	finally
    //   531	542	735	finally
    //   546	553	735	finally
    //   557	566	735	finally
    //   580	586	735	finally
    //   593	604	735	finally
    //   608	615	735	finally
    //   619	628	735	finally
    //   642	648	735	finally
    //   672	679	687	finally
    //   692	718	720	finally
    //   741	748	751	finally
  }
  
  private static boolean c(Context paramContext) {
    return (cu.r(paramContext) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */