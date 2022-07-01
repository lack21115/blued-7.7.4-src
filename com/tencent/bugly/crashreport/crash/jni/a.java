package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public final class a implements NativeExceptionHandler {
  private final Context a;
  
  private final b b;
  
  private final com.tencent.bugly.crashreport.common.info.a c;
  
  private final com.tencent.bugly.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1) {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7) {
    x.a("Native Crash Happen v1", new Object[0]);
    handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString) {
    // Byte code:
    //   0: ldc 'Native Crash Happen v2'
    //   2: iconst_0
    //   3: anewarray java/lang/Object
    //   6: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload #9
    //   12: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   15: astore #21
    //   17: ldc 'UNKNOWN'
    //   19: astore #9
    //   21: iload #11
    //   23: ifle -> 85
    //   26: new java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore #9
    //   35: aload #9
    //   37: aload #7
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #9
    //   45: ldc '('
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #9
    //   53: aload #12
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #9
    //   61: ldc ')'
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload #9
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: astore #9
    //   74: ldc 'UNKNOWN'
    //   76: astore #16
    //   78: ldc 'KERNEL'
    //   80: astore #12
    //   82: goto -> 167
    //   85: iload #13
    //   87: ifle -> 103
    //   90: aload_0
    //   91: getfield a : Landroid/content/Context;
    //   94: astore #9
    //   96: iload #13
    //   98: invokestatic a : (I)Ljava/lang/String;
    //   101: astore #9
    //   103: aload #9
    //   105: iload #13
    //   107: invokestatic valueOf : (I)Ljava/lang/String;
    //   110: invokevirtual equals : (Ljava/lang/Object;)Z
    //   113: ifne -> 1049
    //   116: new java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial <init> : ()V
    //   123: astore #16
    //   125: aload #16
    //   127: aload #9
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload #16
    //   135: ldc '('
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload #16
    //   143: iload #13
    //   145: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #16
    //   151: ldc ')'
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload #16
    //   159: invokevirtual toString : ()Ljava/lang/String;
    //   162: astore #9
    //   164: goto -> 1049
    //   167: new java/util/HashMap
    //   170: dup
    //   171: invokespecial <init> : ()V
    //   174: astore #22
    //   176: aload #18
    //   178: ifnull -> 276
    //   181: iconst_0
    //   182: istore_1
    //   183: iload_1
    //   184: aload #18
    //   186: arraylength
    //   187: if_icmpge -> 286
    //   190: aload #18
    //   192: iload_1
    //   193: aaload
    //   194: astore #7
    //   196: aload #7
    //   198: ifnull -> 1060
    //   201: ldc 'Extra message[%d]: %s'
    //   203: iconst_2
    //   204: anewarray java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: iload_1
    //   210: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: aload #7
    //   218: aastore
    //   219: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   222: pop
    //   223: aload #7
    //   225: ldc '='
    //   227: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   230: astore #23
    //   232: aload #23
    //   234: arraylength
    //   235: iconst_2
    //   236: if_icmpne -> 258
    //   239: aload #22
    //   241: aload #23
    //   243: iconst_0
    //   244: aaload
    //   245: aload #23
    //   247: iconst_1
    //   248: aaload
    //   249: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: goto -> 1060
    //   258: ldc 'bad extraMsg %s'
    //   260: iconst_1
    //   261: anewarray java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload #7
    //   268: aastore
    //   269: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   272: pop
    //   273: goto -> 1060
    //   276: ldc 'not found extraMsg'
    //   278: iconst_0
    //   279: anewarray java/lang/Object
    //   282: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload #22
    //   288: ldc 'HasPendingException'
    //   290: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   295: checkcast java/lang/String
    //   298: astore #7
    //   300: aload #7
    //   302: ifnull -> 1067
    //   305: aload #7
    //   307: ldc 'true'
    //   309: invokevirtual equals : (Ljava/lang/Object;)Z
    //   312: ifeq -> 1067
    //   315: ldc 'Native crash happened with a Java pending exception.'
    //   317: iconst_0
    //   318: anewarray java/lang/Object
    //   321: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   324: pop
    //   325: iconst_1
    //   326: istore #19
    //   328: goto -> 331
    //   331: aload #22
    //   333: ldc 'ExceptionProcessName'
    //   335: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   340: checkcast java/lang/String
    //   343: astore #18
    //   345: aload #18
    //   347: ifnull -> 379
    //   350: aload #18
    //   352: invokevirtual length : ()I
    //   355: ifne -> 361
    //   358: goto -> 379
    //   361: ldc 'Name of crash process: %s'
    //   363: iconst_1
    //   364: anewarray java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload #18
    //   371: aastore
    //   372: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   375: pop
    //   376: goto -> 388
    //   379: aload_0
    //   380: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   383: getfield d : Ljava/lang/String;
    //   386: astore #18
    //   388: aload #22
    //   390: ldc 'ExceptionThreadName'
    //   392: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast java/lang/String
    //   400: astore #7
    //   402: aload #7
    //   404: ifnull -> 593
    //   407: aload #7
    //   409: invokevirtual length : ()I
    //   412: ifne -> 418
    //   415: goto -> 593
    //   418: ldc 'Name of crash thread: %s'
    //   420: iconst_1
    //   421: anewarray java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: aload #7
    //   428: aastore
    //   429: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   432: pop
    //   433: invokestatic getAllStackTraces : ()Ljava/util/Map;
    //   436: invokeinterface keySet : ()Ljava/util/Set;
    //   441: invokeinterface iterator : ()Ljava/util/Iterator;
    //   446: astore #24
    //   448: aload #24
    //   450: invokeinterface hasNext : ()Z
    //   455: ifeq -> 1073
    //   458: aload #24
    //   460: invokeinterface next : ()Ljava/lang/Object;
    //   465: checkcast java/lang/Thread
    //   468: astore #23
    //   470: aload #23
    //   472: invokevirtual getName : ()Ljava/lang/String;
    //   475: aload #7
    //   477: invokevirtual equals : (Ljava/lang/Object;)Z
    //   480: ifeq -> 448
    //   483: new java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial <init> : ()V
    //   490: astore #24
    //   492: aload #24
    //   494: aload #7
    //   496: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload #24
    //   502: ldc '('
    //   504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload #24
    //   510: aload #23
    //   512: invokevirtual getId : ()J
    //   515: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #24
    //   521: ldc ')'
    //   523: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload #24
    //   529: invokevirtual toString : ()Ljava/lang/String;
    //   532: astore #7
    //   534: iconst_1
    //   535: istore_1
    //   536: goto -> 539
    //   539: iload_1
    //   540: ifne -> 1078
    //   543: new java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial <init> : ()V
    //   550: astore #23
    //   552: aload #23
    //   554: aload #7
    //   556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload #23
    //   562: ldc '('
    //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload #23
    //   570: iload_2
    //   571: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload #23
    //   577: ldc ')'
    //   579: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload #23
    //   585: invokevirtual toString : ()Ljava/lang/String;
    //   588: astore #7
    //   590: goto -> 1081
    //   593: invokestatic currentThread : ()Ljava/lang/Thread;
    //   596: astore #7
    //   598: new java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial <init> : ()V
    //   605: astore #23
    //   607: aload #23
    //   609: aload #7
    //   611: invokevirtual getName : ()Ljava/lang/String;
    //   614: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload #23
    //   620: ldc '('
    //   622: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload #23
    //   628: aload #7
    //   630: invokevirtual getId : ()J
    //   633: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload #23
    //   639: ldc ')'
    //   641: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload #23
    //   647: invokevirtual toString : ()Ljava/lang/String;
    //   650: astore #7
    //   652: goto -> 1081
    //   655: lload #5
    //   657: ldc2_w 1000
    //   660: ldiv
    //   661: lstore #5
    //   663: aload #22
    //   665: ldc 'SysLogPath'
    //   667: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   672: checkcast java/lang/String
    //   675: astore #23
    //   677: aload #22
    //   679: ldc 'JniLogPath'
    //   681: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   686: checkcast java/lang/String
    //   689: astore #22
    //   691: aload_0
    //   692: getfield d : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   695: invokevirtual b : ()Z
    //   698: ifne -> 711
    //   701: ldc 'no remote but still store!'
    //   703: iconst_0
    //   704: anewarray java/lang/Object
    //   707: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   710: pop
    //   711: aload_0
    //   712: getfield d : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   715: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   718: getfield g : Z
    //   721: istore #20
    //   723: iload #20
    //   725: ifne -> 825
    //   728: aload_0
    //   729: getfield d : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   732: invokevirtual b : ()Z
    //   735: ifeq -> 825
    //   738: ldc 'crash report was closed by remote , will not upload to Bugly , print local for helpful!'
    //   740: iconst_0
    //   741: anewarray java/lang/Object
    //   744: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   747: pop
    //   748: invokestatic a : ()Ljava/lang/String;
    //   751: astore #12
    //   753: new java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial <init> : ()V
    //   760: astore #16
    //   762: aload #16
    //   764: aload #9
    //   766: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload #16
    //   772: ldc '\\n'
    //   774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload #16
    //   780: aload #8
    //   782: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload #16
    //   788: ldc '\\n'
    //   790: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload #16
    //   796: aload #21
    //   798: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: ldc 'NATIVE_CRASH'
    //   804: aload #12
    //   806: aload #18
    //   808: aload #7
    //   810: aload #16
    //   812: invokevirtual toString : ()Ljava/lang/String;
    //   815: aconst_null
    //   816: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   819: aload #10
    //   821: invokestatic b : (Ljava/lang/String;)V
    //   824: return
    //   825: aload_0
    //   826: aload #18
    //   828: aload #7
    //   830: lload_3
    //   831: ldc2_w 1000
    //   834: lmul
    //   835: lload #5
    //   837: ladd
    //   838: aload #9
    //   840: aload #8
    //   842: aload #21
    //   844: aload #12
    //   846: aload #16
    //   848: aload #10
    //   850: aload #23
    //   852: aload #22
    //   854: aload #17
    //   856: aconst_null
    //   857: aconst_null
    //   858: iconst_1
    //   859: iload #19
    //   861: invokevirtual packageCrashDatas : (Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;ZZ)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   864: astore #10
    //   866: aload #10
    //   868: ifnonnull -> 882
    //   871: ldc 'pkg crash datas fail!'
    //   873: iconst_0
    //   874: anewarray java/lang/Object
    //   877: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   880: pop
    //   881: return
    //   882: iconst_0
    //   883: istore_1
    //   884: invokestatic a : ()Ljava/lang/String;
    //   887: astore #12
    //   889: new java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial <init> : ()V
    //   896: astore #16
    //   898: aload #16
    //   900: aload #9
    //   902: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload #16
    //   908: ldc '\\n'
    //   910: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload #16
    //   916: aload #8
    //   918: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload #16
    //   924: ldc '\\n'
    //   926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload #16
    //   932: aload #21
    //   934: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: ldc 'NATIVE_CRASH'
    //   940: aload #12
    //   942: aload #18
    //   944: aload #7
    //   946: aload #16
    //   948: invokevirtual toString : ()Ljava/lang/String;
    //   951: aload #10
    //   953: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   956: aload_0
    //   957: getfield b : Lcom/tencent/bugly/crashreport/crash/b;
    //   960: aload #10
    //   962: invokevirtual b : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   965: ifne -> 970
    //   968: iconst_1
    //   969: istore_1
    //   970: aconst_null
    //   971: astore #7
    //   973: invokestatic getInstance : ()Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   976: astore #8
    //   978: aload #8
    //   980: ifnull -> 990
    //   983: aload #8
    //   985: invokevirtual getDumpFilePath : ()Ljava/lang/String;
    //   988: astore #7
    //   990: iconst_1
    //   991: aload #7
    //   993: invokestatic a : (ZLjava/lang/String;)V
    //   996: iload_1
    //   997: ifeq -> 1013
    //   1000: aload_0
    //   1001: getfield b : Lcom/tencent/bugly/crashreport/crash/b;
    //   1004: aload #10
    //   1006: ldc2_w 3000
    //   1009: iconst_1
    //   1010: invokevirtual a : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   1013: aload_0
    //   1014: getfield b : Lcom/tencent/bugly/crashreport/crash/b;
    //   1017: aload #10
    //   1019: invokevirtual c : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1022: return
    //   1023: astore #7
    //   1025: goto -> 1035
    //   1028: astore #7
    //   1030: goto -> 1035
    //   1033: astore #7
    //   1035: aload #7
    //   1037: invokestatic a : (Ljava/lang/Throwable;)Z
    //   1040: ifne -> 1048
    //   1043: aload #7
    //   1045: invokevirtual printStackTrace : ()V
    //   1048: return
    //   1049: aload #9
    //   1051: astore #16
    //   1053: aload #7
    //   1055: astore #9
    //   1057: goto -> 167
    //   1060: iload_1
    //   1061: iconst_1
    //   1062: iadd
    //   1063: istore_1
    //   1064: goto -> 183
    //   1067: iconst_0
    //   1068: istore #19
    //   1070: goto -> 331
    //   1073: iconst_0
    //   1074: istore_1
    //   1075: goto -> 539
    //   1078: goto -> 655
    //   1081: goto -> 655
    // Exception table:
    //   from	to	target	type
    //   10	17	1033	finally
    //   26	74	1033	finally
    //   90	103	1033	finally
    //   103	164	1033	finally
    //   167	176	1033	finally
    //   183	190	1033	finally
    //   201	255	1033	finally
    //   258	273	1033	finally
    //   276	286	1033	finally
    //   286	300	1033	finally
    //   305	325	1033	finally
    //   331	345	1033	finally
    //   350	358	1033	finally
    //   361	376	1033	finally
    //   379	388	1033	finally
    //   388	402	1033	finally
    //   407	415	1033	finally
    //   418	448	1033	finally
    //   448	534	1033	finally
    //   543	590	1033	finally
    //   593	652	1033	finally
    //   655	711	1033	finally
    //   711	723	1033	finally
    //   728	824	1033	finally
    //   825	866	1028	finally
    //   871	881	1028	finally
    //   884	956	1028	finally
    //   956	968	1023	finally
    //   973	978	1023	finally
    //   983	990	1023	finally
    //   990	996	1023	finally
    //   1000	1013	1023	finally
    //   1013	1022	1023	finally
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfbyte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2) {
    paramBoolean2 = c.a().k();
    if (paramBoolean2)
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]); 
    CrashDetailBean crashDetailBean = new CrashDetailBean();
    crashDetailBean.b = 1;
    crashDetailBean.e = this.c.h();
    crashDetailBean.f = this.c.k;
    crashDetailBean.g = this.c.w();
    crashDetailBean.m = this.c.g();
    crashDetailBean.n = paramString3;
    String str = "";
    if (paramBoolean2) {
      paramString3 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      paramString3 = "";
    } 
    crashDetailBean.o = paramString3;
    crashDetailBean.p = paramString4;
    if (paramString5 == null)
      paramString5 = str; 
    crashDetailBean.q = paramString5;
    crashDetailBean.r = paramLong;
    crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
    crashDetailBean.A = paramString1;
    crashDetailBean.B = paramString2;
    crashDetailBean.I = this.c.y();
    crashDetailBean.h = this.c.v();
    crashDetailBean.i = this.c.J();
    crashDetailBean.v = paramString8;
    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
    if (nativeCrashHandler != null) {
      String str1 = nativeCrashHandler.getDumpFilePath();
    } else {
      nativeCrashHandler = null;
    } 
    paramString3 = b.a((String)nativeCrashHandler, paramString8);
    if (!z.a(paramString3))
      crashDetailBean.V = paramString3; 
    crashDetailBean.W = b.b((String)nativeCrashHandler);
    crashDetailBean.w = b.a(paramString9, c.e, null, false);
    crashDetailBean.x = b.a(paramString10, c.e, null, true);
    crashDetailBean.J = paramString7;
    crashDetailBean.K = paramString6;
    crashDetailBean.L = paramString11;
    crashDetailBean.F = this.c.p();
    crashDetailBean.G = this.c.o();
    crashDetailBean.H = this.c.q();
    if (paramBoolean1) {
      crashDetailBean.C = b.k();
      crashDetailBean.D = b.i();
      crashDetailBean.E = b.m();
      if (crashDetailBean.w == null)
        crashDetailBean.w = z.a(this.a, c.e, null); 
      crashDetailBean.y = y.a();
      crashDetailBean.M = this.c.a;
      crashDetailBean.N = this.c.a();
      crashDetailBean.z = z.a(c.f, false);
      int i = crashDetailBean.q.indexOf("java:\n");
      if (i > 0) {
        i += 6;
        if (i < crashDetailBean.q.length()) {
          String str1 = crashDetailBean.q.substring(i, crashDetailBean.q.length() - 1);
          if (str1.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B)) {
            paramString3 = (String)crashDetailBean.z.get(crashDetailBean.B);
            int j = paramString3.indexOf(str1);
            if (j > 0) {
              str1 = paramString3.substring(j);
              crashDetailBean.z.put(crashDetailBean.B, str1);
              crashDetailBean.q = crashDetailBean.q.substring(0, i);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(crashDetailBean.q);
              stringBuilder.append(str1);
              crashDetailBean.q = stringBuilder.toString();
            } 
          } 
        } 
      } 
      if (paramString1 == null)
        crashDetailBean.A = this.c.d; 
      this.b.d(crashDetailBean);
      crashDetailBean.Q = this.c.H();
      crashDetailBean.R = this.c.I();
      crashDetailBean.S = this.c.B();
      crashDetailBean.T = this.c.G();
      return crashDetailBean;
    } 
    crashDetailBean.C = -1L;
    crashDetailBean.D = -1L;
    crashDetailBean.E = -1L;
    if (crashDetailBean.w == null)
      crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc."; 
    crashDetailBean.M = -1L;
    crashDetailBean.Q = -1;
    crashDetailBean.R = -1;
    crashDetailBean.S = paramMap;
    crashDetailBean.T = this.c.G();
    crashDetailBean.z = null;
    if (paramString1 == null)
      crashDetailBean.A = "unknown(record)"; 
    if (paramArrayOfbyte != null)
      crashDetailBean.y = paramArrayOfbyte; 
    return crashDetailBean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */