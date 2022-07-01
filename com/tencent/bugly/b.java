package com.tencent.bugly;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.p;
import java.util.ArrayList;
import java.util.List;

public final class b {
  public static boolean a = true;
  
  public static List<a> b = new ArrayList<a>();
  
  public static boolean c;
  
  private static p d;
  
  private static boolean e;
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/b
    //   2: monitorenter
    //   3: aload_0
    //   4: aconst_null
    //   5: invokestatic a : (Landroid/content/Context;Lcom/tencent/bugly/BuglyStrategy;)V
    //   8: ldc com/tencent/bugly/b
    //   10: monitorexit
    //   11: return
    //   12: astore_0
    //   13: ldc com/tencent/bugly/b
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	12	finally
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: ldc com/tencent/bugly/b
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/b.e : Z
    //   6: ifeq -> 23
    //   9: ldc '[init] initial Multi-times, ignore this.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: ldc com/tencent/bugly/b
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: ifnonnull -> 40
    //   27: getstatic com/tencent/bugly/proguard/x.a : Ljava/lang/String;
    //   30: ldc '[init] context of init() is null, check it.'
    //   32: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: ldc com/tencent/bugly/b
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   44: astore_2
    //   45: aload_2
    //   46: invokestatic a : (Lcom/tencent/bugly/crashreport/common/info/a;)Z
    //   49: ifeq -> 60
    //   52: iconst_0
    //   53: putstatic com/tencent/bugly/b.a : Z
    //   56: ldc com/tencent/bugly/b
    //   58: monitorexit
    //   59: return
    //   60: aload_2
    //   61: invokevirtual f : ()Ljava/lang/String;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnonnull -> 82
    //   69: getstatic com/tencent/bugly/proguard/x.a : Ljava/lang/String;
    //   72: ldc '[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.'
    //   74: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: ldc com/tencent/bugly/b
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: aload_3
    //   84: aload_2
    //   85: getfield v : Z
    //   88: aload_1
    //   89: invokestatic a : (Landroid/content/Context;Ljava/lang/String;ZLcom/tencent/bugly/BuglyStrategy;)V
    //   92: ldc com/tencent/bugly/b
    //   94: monitorexit
    //   95: return
    //   96: astore_0
    //   97: ldc com/tencent/bugly/b
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	96	finally
    //   27	36	96	finally
    //   40	56	96	finally
    //   60	65	96	finally
    //   69	78	96	finally
    //   82	92	96	finally
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: ldc com/tencent/bugly/b
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/b.e : Z
    //   6: ifeq -> 23
    //   9: ldc '[init] initial Multi-times, ignore this.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: ldc com/tencent/bugly/b
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: ifnonnull -> 40
    //   27: getstatic com/tencent/bugly/proguard/x.a : Ljava/lang/String;
    //   30: ldc '[init] context is null, check it.'
    //   32: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: ldc com/tencent/bugly/b
    //   38: monitorexit
    //   39: return
    //   40: aload_1
    //   41: ifnonnull -> 57
    //   44: getstatic com/tencent/bugly/proguard/x.a : Ljava/lang/String;
    //   47: ldc 'init arg 'crashReportAppID' should not be null!'
    //   49: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   52: pop
    //   53: ldc com/tencent/bugly/b
    //   55: monitorexit
    //   56: return
    //   57: iconst_1
    //   58: putstatic com/tencent/bugly/b.e : Z
    //   61: iload_2
    //   62: ifeq -> 153
    //   65: iconst_1
    //   66: putstatic com/tencent/bugly/b.c : Z
    //   69: iconst_1
    //   70: putstatic com/tencent/bugly/proguard/x.b : Z
    //   73: ldc 'Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.'
    //   75: iconst_0
    //   76: anewarray java/lang/Object
    //   79: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   82: pop
    //   83: ldc '--------------------------------------------------------------------------------------------'
    //   85: iconst_0
    //   86: anewarray java/lang/Object
    //   89: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: ldc 'Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: '
    //   95: iconst_0
    //   96: anewarray java/lang/Object
    //   99: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   102: pop
    //   103: ldc '[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;'
    //   105: iconst_0
    //   106: anewarray java/lang/Object
    //   109: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   112: pop
    //   113: ldc '[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.'
    //   115: iconst_0
    //   116: anewarray java/lang/Object
    //   119: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   122: pop
    //   123: ldc '[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.'
    //   125: iconst_0
    //   126: anewarray java/lang/Object
    //   129: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: ldc '--------------------------------------------------------------------------------------------'
    //   135: iconst_0
    //   136: anewarray java/lang/Object
    //   139: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   142: pop
    //   143: ldc '[init] Open debug mode of Bugly.'
    //   145: iconst_0
    //   146: anewarray java/lang/Object
    //   149: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: ldc ' crash report start initializing...'
    //   155: iconst_0
    //   156: anewarray java/lang/Object
    //   159: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   162: pop
    //   163: ldc '[init] Bugly start initializing...'
    //   165: iconst_0
    //   166: anewarray java/lang/Object
    //   169: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: ldc '[init] Bugly complete version: v%s'
    //   175: iconst_1
    //   176: anewarray java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: ldc '3.2.3'
    //   183: aastore
    //   184: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload_0
    //   189: invokestatic a : (Landroid/content/Context;)Landroid/content/Context;
    //   192: astore #8
    //   194: aload #8
    //   196: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   199: astore #11
    //   201: aload #11
    //   203: invokevirtual t : ()Ljava/lang/String;
    //   206: pop
    //   207: aload #8
    //   209: invokestatic a : (Landroid/content/Context;)V
    //   212: aload #8
    //   214: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   217: invokestatic a : (Landroid/content/Context;Ljava/util/List;)Lcom/tencent/bugly/proguard/p;
    //   220: putstatic com/tencent/bugly/b.d : Lcom/tencent/bugly/proguard/p;
    //   223: aload #8
    //   225: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/proguard/u;
    //   228: pop
    //   229: aload #8
    //   231: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   234: invokestatic a : (Landroid/content/Context;Ljava/util/List;)Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   237: astore #9
    //   239: aload #8
    //   241: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/proguard/n;
    //   244: astore #10
    //   246: aload #11
    //   248: invokestatic a : (Lcom/tencent/bugly/crashreport/common/info/a;)Z
    //   251: ifeq -> 262
    //   254: iconst_0
    //   255: putstatic com/tencent/bugly/b.a : Z
    //   258: ldc com/tencent/bugly/b
    //   260: monitorexit
    //   261: return
    //   262: aload #11
    //   264: aload_1
    //   265: invokevirtual a : (Ljava/lang/String;)V
    //   268: ldc '[param] Set APP ID:%s'
    //   270: iconst_1
    //   271: anewarray java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_1
    //   277: aastore
    //   278: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_3
    //   283: ifnull -> 833
    //   286: aload_3
    //   287: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   290: astore_1
    //   291: aload_1
    //   292: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   295: ifne -> 366
    //   298: aload_1
    //   299: astore_0
    //   300: aload_1
    //   301: invokevirtual length : ()I
    //   304: bipush #100
    //   306: if_icmple -> 343
    //   309: aload_1
    //   310: iconst_0
    //   311: bipush #100
    //   313: invokevirtual substring : (II)Ljava/lang/String;
    //   316: astore_0
    //   317: ldc 'appVersion %s length is over limit %d substring to %s'
    //   319: iconst_3
    //   320: anewarray java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload_1
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: bipush #100
    //   331: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: aload_0
    //   338: aastore
    //   339: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   342: pop
    //   343: aload #11
    //   345: aload_0
    //   346: putfield k : Ljava/lang/String;
    //   349: ldc '[param] Set App version: %s'
    //   351: iconst_1
    //   352: anewarray java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: aload_3
    //   358: invokevirtual getAppVersion : ()Ljava/lang/String;
    //   361: aastore
    //   362: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   365: pop
    //   366: aload_3
    //   367: invokevirtual isReplaceOldChannel : ()Z
    //   370: ifeq -> 457
    //   373: aload_3
    //   374: invokevirtual getAppChannel : ()Ljava/lang/String;
    //   377: astore_1
    //   378: aload_1
    //   379: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   382: ifne -> 502
    //   385: aload_1
    //   386: astore_0
    //   387: aload_1
    //   388: invokevirtual length : ()I
    //   391: bipush #100
    //   393: if_icmple -> 430
    //   396: aload_1
    //   397: iconst_0
    //   398: bipush #100
    //   400: invokevirtual substring : (II)Ljava/lang/String;
    //   403: astore_0
    //   404: ldc 'appChannel %s length is over limit %d substring to %s'
    //   406: iconst_3
    //   407: anewarray java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload_1
    //   413: aastore
    //   414: dup
    //   415: iconst_1
    //   416: bipush #100
    //   418: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   421: aastore
    //   422: dup
    //   423: iconst_2
    //   424: aload_0
    //   425: aastore
    //   426: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   429: pop
    //   430: getstatic com/tencent/bugly/b.d : Lcom/tencent/bugly/proguard/p;
    //   433: sipush #556
    //   436: ldc 'app_channel'
    //   438: aload_0
    //   439: invokevirtual getBytes : ()[B
    //   442: aconst_null
    //   443: iconst_0
    //   444: invokevirtual a : (ILjava/lang/String;[BLcom/tencent/bugly/proguard/o;Z)Z
    //   447: pop
    //   448: aload #11
    //   450: aload_0
    //   451: putfield m : Ljava/lang/String;
    //   454: goto -> 502
    //   457: getstatic com/tencent/bugly/b.d : Lcom/tencent/bugly/proguard/p;
    //   460: sipush #556
    //   463: aconst_null
    //   464: iconst_1
    //   465: invokevirtual a : (ILcom/tencent/bugly/proguard/o;Z)Ljava/util/Map;
    //   468: astore_0
    //   469: aload_0
    //   470: ifnull -> 502
    //   473: aload_0
    //   474: ldc 'app_channel'
    //   476: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   481: checkcast [B
    //   484: astore_0
    //   485: aload_0
    //   486: ifnull -> 502
    //   489: aload #11
    //   491: new java/lang/String
    //   494: dup
    //   495: aload_0
    //   496: invokespecial <init> : ([B)V
    //   499: putfield m : Ljava/lang/String;
    //   502: ldc '[param] Set App channel: %s'
    //   504: iconst_1
    //   505: anewarray java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: aload #11
    //   512: getfield m : Ljava/lang/String;
    //   515: aastore
    //   516: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   519: pop
    //   520: goto -> 534
    //   523: astore_0
    //   524: getstatic com/tencent/bugly/b.c : Z
    //   527: ifeq -> 534
    //   530: aload_0
    //   531: invokevirtual printStackTrace : ()V
    //   534: aload_3
    //   535: invokevirtual getAppPackageName : ()Ljava/lang/String;
    //   538: astore_1
    //   539: aload_1
    //   540: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   543: ifne -> 614
    //   546: aload_1
    //   547: astore_0
    //   548: aload_1
    //   549: invokevirtual length : ()I
    //   552: bipush #100
    //   554: if_icmple -> 591
    //   557: aload_1
    //   558: iconst_0
    //   559: bipush #100
    //   561: invokevirtual substring : (II)Ljava/lang/String;
    //   564: astore_0
    //   565: ldc 'appPackageName %s length is over limit %d substring to %s'
    //   567: iconst_3
    //   568: anewarray java/lang/Object
    //   571: dup
    //   572: iconst_0
    //   573: aload_1
    //   574: aastore
    //   575: dup
    //   576: iconst_1
    //   577: bipush #100
    //   579: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   582: aastore
    //   583: dup
    //   584: iconst_2
    //   585: aload_0
    //   586: aastore
    //   587: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   590: pop
    //   591: aload #11
    //   593: aload_0
    //   594: putfield c : Ljava/lang/String;
    //   597: ldc '[param] Set App package: %s'
    //   599: iconst_1
    //   600: anewarray java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload_3
    //   606: invokevirtual getAppPackageName : ()Ljava/lang/String;
    //   609: aastore
    //   610: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   613: pop
    //   614: aload_3
    //   615: invokevirtual getDeviceID : ()Ljava/lang/String;
    //   618: astore_1
    //   619: aload_1
    //   620: ifnull -> 688
    //   623: aload_1
    //   624: astore_0
    //   625: aload_1
    //   626: invokevirtual length : ()I
    //   629: bipush #100
    //   631: if_icmple -> 668
    //   634: aload_1
    //   635: iconst_0
    //   636: bipush #100
    //   638: invokevirtual substring : (II)Ljava/lang/String;
    //   641: astore_0
    //   642: ldc 'deviceId %s length is over limit %d substring to %s'
    //   644: iconst_3
    //   645: anewarray java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: aload_1
    //   651: aastore
    //   652: dup
    //   653: iconst_1
    //   654: bipush #100
    //   656: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   659: aastore
    //   660: dup
    //   661: iconst_2
    //   662: aload_0
    //   663: aastore
    //   664: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   667: pop
    //   668: aload #11
    //   670: aload_0
    //   671: invokevirtual c : (Ljava/lang/String;)V
    //   674: ldc '[param] Set device ID: %s'
    //   676: iconst_1
    //   677: anewarray java/lang/Object
    //   680: dup
    //   681: iconst_0
    //   682: aload_0
    //   683: aastore
    //   684: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   687: pop
    //   688: aload #11
    //   690: aload_3
    //   691: invokevirtual isUploadProcess : ()Z
    //   694: putfield e : Z
    //   697: aload_3
    //   698: invokevirtual isBuglyLogUpload : ()Z
    //   701: putstatic com/tencent/bugly/proguard/y.a : Z
    //   704: goto -> 833
    //   707: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   710: invokeinterface size : ()I
    //   715: istore #5
    //   717: iload #4
    //   719: iload #5
    //   721: if_icmpge -> 786
    //   724: aload #10
    //   726: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   729: iload #4
    //   731: invokeinterface get : (I)Ljava/lang/Object;
    //   736: checkcast com/tencent/bugly/a
    //   739: getfield id : I
    //   742: invokevirtual a : (I)Z
    //   745: ifeq -> 839
    //   748: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   751: iload #4
    //   753: invokeinterface get : (I)Ljava/lang/Object;
    //   758: checkcast com/tencent/bugly/a
    //   761: aload #8
    //   763: iload_2
    //   764: aload_3
    //   765: invokevirtual init : (Landroid/content/Context;ZLcom/tencent/bugly/BuglyStrategy;)V
    //   768: goto -> 839
    //   771: astore_0
    //   772: aload_0
    //   773: invokestatic a : (Ljava/lang/Throwable;)Z
    //   776: ifne -> 839
    //   779: aload_0
    //   780: invokevirtual printStackTrace : ()V
    //   783: goto -> 839
    //   786: aload #8
    //   788: aload_3
    //   789: invokestatic a : (Landroid/content/Context;Lcom/tencent/bugly/BuglyStrategy;)V
    //   792: aload_3
    //   793: ifnull -> 848
    //   796: aload_3
    //   797: invokevirtual getAppReportDelay : ()J
    //   800: lstore #6
    //   802: goto -> 805
    //   805: aload #9
    //   807: lload #6
    //   809: invokevirtual a : (J)V
    //   812: ldc_w '[init] Bugly initialization finished.'
    //   815: iconst_0
    //   816: anewarray java/lang/Object
    //   819: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   822: pop
    //   823: ldc com/tencent/bugly/b
    //   825: monitorexit
    //   826: return
    //   827: astore_0
    //   828: ldc com/tencent/bugly/b
    //   830: monitorexit
    //   831: aload_0
    //   832: athrow
    //   833: iconst_0
    //   834: istore #4
    //   836: goto -> 707
    //   839: iload #4
    //   841: iconst_1
    //   842: iadd
    //   843: istore #4
    //   845: goto -> 707
    //   848: lconst_0
    //   849: lstore #6
    //   851: goto -> 805
    // Exception table:
    //   from	to	target	type
    //   3	19	827	finally
    //   27	36	827	finally
    //   44	53	827	finally
    //   57	61	827	finally
    //   65	153	827	finally
    //   153	258	827	finally
    //   262	282	827	finally
    //   286	298	827	finally
    //   300	343	827	finally
    //   343	366	827	finally
    //   366	385	523	java/lang/Exception
    //   366	385	827	finally
    //   387	430	523	java/lang/Exception
    //   387	430	827	finally
    //   430	454	523	java/lang/Exception
    //   430	454	827	finally
    //   457	469	523	java/lang/Exception
    //   457	469	827	finally
    //   473	485	523	java/lang/Exception
    //   473	485	827	finally
    //   489	502	523	java/lang/Exception
    //   489	502	827	finally
    //   502	520	523	java/lang/Exception
    //   502	520	827	finally
    //   524	534	827	finally
    //   534	546	827	finally
    //   548	591	827	finally
    //   591	614	827	finally
    //   614	619	827	finally
    //   625	668	827	finally
    //   668	688	827	finally
    //   688	704	827	finally
    //   707	717	827	finally
    //   724	768	771	finally
    //   772	783	827	finally
    //   786	792	827	finally
    //   796	802	827	finally
    //   805	823	827	finally
  }
  
  public static void a(a parama) {
    // Byte code:
    //   0: ldc com/tencent/bugly/b
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   6: aload_0
    //   7: invokeinterface contains : (Ljava/lang/Object;)Z
    //   12: ifne -> 25
    //   15: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   18: aload_0
    //   19: invokeinterface add : (Ljava/lang/Object;)Z
    //   24: pop
    //   25: ldc com/tencent/bugly/b
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: ldc com/tencent/bugly/b
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	29	finally
  }
  
  private static boolean a(a parama) {
    List list = parama.p;
    parama.getClass();
    return (list != null && list.contains("bugly"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */