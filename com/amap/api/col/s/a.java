package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

public abstract class a<T, V> extends bp {
  protected boolean a = true;
  
  protected T b;
  
  protected int c = 1;
  
  protected String d = "";
  
  protected Context e;
  
  protected String f = "";
  
  private int j = 1;
  
  public a(Context paramContext, T paramT) {
    this.e = paramContext;
    this.b = paramT;
    this.c = 1;
    b(ServiceSettings.getInstance().getSoTimeOut());
    a(ServiceSettings.getInstance().getConnectionTimeOut());
  }
  
  private String h() {
    String str = b();
    if (str != null)
      try {
        int i = str.indexOf(".com/");
        int j = str.indexOf("?");
        return (j == -1) ? str.substring(i + 5) : str.substring(i + 5, j);
      } finally {} 
    return null;
  }
  
  private V l() throws AMapException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual d : ()Lcom/amap/api/col/s/ad$b;
    //   4: astore #18
    //   6: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   9: aload #18
    //   11: invokevirtual b : (Lcom/amap/api/col/s/ad$b;)Z
    //   14: istore #8
    //   16: iconst_0
    //   17: istore #4
    //   19: aconst_null
    //   20: astore #14
    //   22: iconst_0
    //   23: istore_2
    //   24: iload #4
    //   26: aload_0
    //   27: getfield c : I
    //   30: if_icmpge -> 1136
    //   33: invokestatic currentTimeMillis : ()J
    //   36: lstore #9
    //   38: aload #14
    //   40: astore #13
    //   42: iload_2
    //   43: istore_3
    //   44: aload #14
    //   46: astore #16
    //   48: iload_2
    //   49: istore #5
    //   51: aload #14
    //   53: astore #17
    //   55: iload_2
    //   56: istore #6
    //   58: invokestatic getInstance : ()Lcom/amap/api/services/core/ServiceSettings;
    //   61: invokevirtual getProtocol : ()I
    //   64: istore #7
    //   66: aload #14
    //   68: astore #13
    //   70: iload_2
    //   71: istore_3
    //   72: aload #14
    //   74: astore #16
    //   76: iload_2
    //   77: istore #5
    //   79: aload #14
    //   81: astore #17
    //   83: iload_2
    //   84: istore #6
    //   86: invokestatic a : ()Lcom/amap/api/col/s/bo;
    //   89: aload_0
    //   90: getfield e : Landroid/content/Context;
    //   93: invokevirtual a : (Landroid/content/Context;)V
    //   96: aload #14
    //   98: astore #13
    //   100: iload_2
    //   101: istore_3
    //   102: aload #14
    //   104: astore #16
    //   106: iload_2
    //   107: istore #5
    //   109: aload #14
    //   111: astore #17
    //   113: iload_2
    //   114: istore #6
    //   116: invokestatic b : ()Lcom/amap/api/col/s/cx;
    //   119: astore #19
    //   121: aload #14
    //   123: astore #15
    //   125: iload_2
    //   126: istore_1
    //   127: iload #8
    //   129: ifeq -> 285
    //   132: aload #14
    //   134: astore #13
    //   136: iload_2
    //   137: istore_3
    //   138: aload #14
    //   140: astore #16
    //   142: iload_2
    //   143: istore #5
    //   145: aload #14
    //   147: astore #17
    //   149: iload_2
    //   150: istore #6
    //   152: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   155: aload #18
    //   157: invokevirtual a : (Lcom/amap/api/col/s/ad$b;)Lcom/amap/api/col/s/ad$c;
    //   160: astore #20
    //   162: aload #14
    //   164: astore #15
    //   166: iload_2
    //   167: istore_1
    //   168: aload #20
    //   170: ifnull -> 285
    //   173: aload #14
    //   175: astore #15
    //   177: iload_2
    //   178: istore_1
    //   179: aload #14
    //   181: astore #13
    //   183: iload_2
    //   184: istore_3
    //   185: aload #14
    //   187: astore #16
    //   189: iload_2
    //   190: istore #5
    //   192: aload #14
    //   194: astore #17
    //   196: iload_2
    //   197: istore #6
    //   199: aload #20
    //   201: getfield a : Ljava/lang/Object;
    //   204: ifnull -> 285
    //   207: aload #14
    //   209: astore #13
    //   211: iload_2
    //   212: istore_3
    //   213: aload #14
    //   215: astore #16
    //   217: iload_2
    //   218: istore #5
    //   220: aload #14
    //   222: astore #17
    //   224: iload_2
    //   225: istore #6
    //   227: aload #20
    //   229: getfield a : Ljava/lang/Object;
    //   232: astore #15
    //   234: aload_0
    //   235: getfield e : Landroid/content/Context;
    //   238: aload #18
    //   240: getfield a : Ljava/lang/String;
    //   243: aload #20
    //   245: getfield b : Z
    //   248: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Z)V
    //   251: iconst_1
    //   252: istore_1
    //   253: goto -> 285
    //   256: astore #14
    //   258: iconst_1
    //   259: istore_2
    //   260: aload #15
    //   262: astore #13
    //   264: goto -> 1114
    //   267: astore #14
    //   269: iconst_1
    //   270: istore_1
    //   271: aload #15
    //   273: astore #16
    //   275: goto -> 656
    //   278: astore #14
    //   280: iconst_1
    //   281: istore_1
    //   282: goto -> 774
    //   285: aload #15
    //   287: astore #14
    //   289: aload #15
    //   291: ifnonnull -> 568
    //   294: iload #7
    //   296: iconst_1
    //   297: if_icmpne -> 387
    //   300: aload #15
    //   302: astore #13
    //   304: iload_1
    //   305: istore_3
    //   306: aload #15
    //   308: astore #16
    //   310: iload_1
    //   311: istore #5
    //   313: aload #15
    //   315: astore #17
    //   317: iload_1
    //   318: istore #6
    //   320: aload_0
    //   321: getfield a : Z
    //   324: ifeq -> 358
    //   327: aload #15
    //   329: astore #13
    //   331: iload_1
    //   332: istore_3
    //   333: aload #15
    //   335: astore #16
    //   337: iload_1
    //   338: istore #5
    //   340: aload #15
    //   342: astore #17
    //   344: iload_1
    //   345: istore #6
    //   347: aload #19
    //   349: aload_0
    //   350: invokevirtual b : (Lcom/amap/api/col/s/cy;)[B
    //   353: astore #14
    //   355: goto -> 478
    //   358: aload #15
    //   360: astore #13
    //   362: iload_1
    //   363: istore_3
    //   364: aload #15
    //   366: astore #16
    //   368: iload_1
    //   369: istore #5
    //   371: aload #15
    //   373: astore #17
    //   375: iload_1
    //   376: istore #6
    //   378: aload_0
    //   379: invokestatic d : (Lcom/amap/api/col/s/cy;)[B
    //   382: astore #14
    //   384: goto -> 478
    //   387: iload #7
    //   389: iconst_2
    //   390: if_icmpne -> 1166
    //   393: aload #15
    //   395: astore #13
    //   397: iload_1
    //   398: istore_3
    //   399: aload #15
    //   401: astore #16
    //   403: iload_1
    //   404: istore #5
    //   406: aload #15
    //   408: astore #17
    //   410: iload_1
    //   411: istore #6
    //   413: aload_0
    //   414: getfield a : Z
    //   417: ifeq -> 449
    //   420: aload #15
    //   422: astore #13
    //   424: iload_1
    //   425: istore_3
    //   426: aload #15
    //   428: astore #16
    //   430: iload_1
    //   431: istore #5
    //   433: aload #15
    //   435: astore #17
    //   437: iload_1
    //   438: istore #6
    //   440: aload_0
    //   441: invokestatic a : (Lcom/amap/api/col/s/cy;)[B
    //   444: astore #14
    //   446: goto -> 478
    //   449: aload #15
    //   451: astore #13
    //   453: iload_1
    //   454: istore_3
    //   455: aload #15
    //   457: astore #16
    //   459: iload_1
    //   460: istore #5
    //   462: aload #15
    //   464: astore #17
    //   466: iload_1
    //   467: istore #6
    //   469: aload_0
    //   470: invokestatic e : (Lcom/amap/api/col/s/cy;)[B
    //   473: astore #14
    //   475: goto -> 478
    //   478: aload #15
    //   480: astore #13
    //   482: iload_1
    //   483: istore_3
    //   484: aload #15
    //   486: astore #16
    //   488: iload_1
    //   489: istore #5
    //   491: aload #15
    //   493: astore #17
    //   495: iload_1
    //   496: istore #6
    //   498: invokestatic currentTimeMillis : ()J
    //   501: lstore #11
    //   503: aload #15
    //   505: astore #13
    //   507: iload_1
    //   508: istore_3
    //   509: aload #15
    //   511: astore #16
    //   513: iload_1
    //   514: istore #5
    //   516: aload #15
    //   518: astore #17
    //   520: iload_1
    //   521: istore #6
    //   523: aload_0
    //   524: aload #14
    //   526: invokevirtual a : ([B)Ljava/lang/Object;
    //   529: astore #14
    //   531: aload #14
    //   533: astore #13
    //   535: iload_1
    //   536: istore_3
    //   537: aload #14
    //   539: astore #16
    //   541: iload_1
    //   542: istore #5
    //   544: aload #14
    //   546: astore #17
    //   548: iload_1
    //   549: istore #6
    //   551: aload_0
    //   552: getfield e : Landroid/content/Context;
    //   555: aload_0
    //   556: invokespecial h : ()Ljava/lang/String;
    //   559: lload #11
    //   561: lload #9
    //   563: lsub
    //   564: iconst_1
    //   565: invokestatic a : (Landroid/content/Context;Ljava/lang/String;JZ)V
    //   568: aload #14
    //   570: astore #13
    //   572: iload_1
    //   573: istore_3
    //   574: aload #14
    //   576: astore #16
    //   578: iload_1
    //   579: istore #5
    //   581: aload #14
    //   583: astore #17
    //   585: iload_1
    //   586: istore #6
    //   588: aload_0
    //   589: getfield c : I
    //   592: istore #7
    //   594: iload #7
    //   596: istore_3
    //   597: aload #14
    //   599: astore #13
    //   601: iload_1
    //   602: istore_2
    //   603: iload #8
    //   605: ifeq -> 895
    //   608: iload #7
    //   610: istore_3
    //   611: aload #14
    //   613: astore #13
    //   615: iload_1
    //   616: istore_2
    //   617: iload_1
    //   618: ifne -> 895
    //   621: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   624: astore #13
    //   626: iload #7
    //   628: istore #4
    //   630: aload #13
    //   632: aload #18
    //   634: aload #14
    //   636: invokevirtual a : (Lcom/amap/api/col/s/ad$b;Ljava/lang/Object;)V
    //   639: iload_1
    //   640: istore_2
    //   641: goto -> 24
    //   644: astore #14
    //   646: iload_3
    //   647: istore_2
    //   648: goto -> 1114
    //   651: astore #14
    //   653: iload #5
    //   655: istore_1
    //   656: aload #16
    //   658: astore #13
    //   660: iload_1
    //   661: istore_3
    //   662: invokestatic currentTimeMillis : ()J
    //   665: lstore #11
    //   667: aload #16
    //   669: astore #13
    //   671: iload_1
    //   672: istore_3
    //   673: aload_0
    //   674: getfield e : Landroid/content/Context;
    //   677: aload_0
    //   678: invokespecial h : ()Ljava/lang/String;
    //   681: lload #11
    //   683: lload #9
    //   685: lsub
    //   686: iconst_0
    //   687: invokestatic a : (Landroid/content/Context;Ljava/lang/String;JZ)V
    //   690: iload #4
    //   692: iconst_1
    //   693: iadd
    //   694: istore #4
    //   696: aload #16
    //   698: astore #13
    //   700: iload_1
    //   701: istore_3
    //   702: aload_0
    //   703: getfield c : I
    //   706: istore_2
    //   707: iload #4
    //   709: iload_2
    //   710: if_icmpge -> 752
    //   713: iload #4
    //   715: istore_3
    //   716: aload #16
    //   718: astore #13
    //   720: iload_1
    //   721: istore_2
    //   722: iload #8
    //   724: ifeq -> 895
    //   727: iload #4
    //   729: istore_3
    //   730: aload #16
    //   732: astore #13
    //   734: iload_1
    //   735: istore_2
    //   736: iload_1
    //   737: ifne -> 895
    //   740: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   743: astore #13
    //   745: aload #16
    //   747: astore #14
    //   749: goto -> 630
    //   752: iload_1
    //   753: istore_2
    //   754: aload #14
    //   756: athrow
    //   757: astore #14
    //   759: aconst_null
    //   760: astore #13
    //   762: goto -> 1114
    //   765: astore #14
    //   767: iload #6
    //   769: istore_1
    //   770: aload #17
    //   772: astore #15
    //   774: aload #15
    //   776: astore #13
    //   778: iload_1
    //   779: istore_3
    //   780: invokestatic currentTimeMillis : ()J
    //   783: lstore #11
    //   785: aload #15
    //   787: astore #13
    //   789: iload_1
    //   790: istore_3
    //   791: aload_0
    //   792: getfield e : Landroid/content/Context;
    //   795: aload_0
    //   796: invokespecial h : ()Ljava/lang/String;
    //   799: lload #11
    //   801: lload #9
    //   803: lsub
    //   804: iconst_0
    //   805: invokestatic a : (Landroid/content/Context;Ljava/lang/String;JZ)V
    //   808: iload #4
    //   810: iconst_1
    //   811: iadd
    //   812: istore #4
    //   814: aload #15
    //   816: astore #13
    //   818: iload_1
    //   819: istore_3
    //   820: aload_0
    //   821: getfield c : I
    //   824: istore_2
    //   825: iload #4
    //   827: iload_2
    //   828: if_icmpge -> 1012
    //   831: aload #15
    //   833: astore #13
    //   835: iload_1
    //   836: istore_3
    //   837: aload_0
    //   838: getfield j : I
    //   841: sipush #1000
    //   844: imul
    //   845: i2l
    //   846: invokestatic sleep : (J)V
    //   849: iload #4
    //   851: istore_3
    //   852: aload #15
    //   854: astore #13
    //   856: iload_1
    //   857: istore_2
    //   858: iload #8
    //   860: ifeq -> 895
    //   863: iload #4
    //   865: istore_3
    //   866: aload #15
    //   868: astore #13
    //   870: iload_1
    //   871: istore_2
    //   872: iload_1
    //   873: ifne -> 895
    //   876: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   879: aload #18
    //   881: aload #15
    //   883: invokevirtual a : (Lcom/amap/api/col/s/ad$b;Ljava/lang/Object;)V
    //   886: iload_1
    //   887: istore_2
    //   888: aload #15
    //   890: astore #13
    //   892: iload #4
    //   894: istore_3
    //   895: iload_3
    //   896: istore #4
    //   898: aload #13
    //   900: astore #14
    //   902: goto -> 24
    //   905: aload #15
    //   907: astore #13
    //   909: iload_1
    //   910: istore_3
    //   911: ldc 'http连接失败 - ConnectionException'
    //   913: aload #14
    //   915: invokevirtual getMessage : ()Ljava/lang/String;
    //   918: invokevirtual equals : (Ljava/lang/Object;)Z
    //   921: ifne -> 990
    //   924: aload #15
    //   926: astore #13
    //   928: iload_1
    //   929: istore_3
    //   930: ldc 'socket 连接异常 - SocketException'
    //   932: aload #14
    //   934: invokevirtual getMessage : ()Ljava/lang/String;
    //   937: invokevirtual equals : (Ljava/lang/Object;)Z
    //   940: ifne -> 990
    //   943: aload #15
    //   945: astore #13
    //   947: iload_1
    //   948: istore_3
    //   949: ldc '服务器连接失败 - UnknownServiceException'
    //   951: aload #14
    //   953: invokevirtual getMessage : ()Ljava/lang/String;
    //   956: invokevirtual equals : (Ljava/lang/Object;)Z
    //   959: ifeq -> 965
    //   962: goto -> 990
    //   965: aload #15
    //   967: astore #13
    //   969: iload_1
    //   970: istore_3
    //   971: new com/amap/api/services/core/AMapException
    //   974: dup
    //   975: aload #14
    //   977: invokevirtual a : ()Ljava/lang/String;
    //   980: iconst_1
    //   981: aload #14
    //   983: invokevirtual c : ()Ljava/lang/String;
    //   986: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;)V
    //   989: athrow
    //   990: aload #15
    //   992: astore #13
    //   994: iload_1
    //   995: istore_3
    //   996: new com/amap/api/services/core/AMapException
    //   999: dup
    //   1000: ldc 'http或socket连接失败 - ConnectionException'
    //   1002: iconst_1
    //   1003: aload #14
    //   1005: invokevirtual c : ()Ljava/lang/String;
    //   1008: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;)V
    //   1011: athrow
    //   1012: iload_1
    //   1013: istore_2
    //   1014: ldc 'http连接失败 - ConnectionException'
    //   1016: aload #14
    //   1018: invokevirtual getMessage : ()Ljava/lang/String;
    //   1021: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1024: ifne -> 1096
    //   1027: iload_1
    //   1028: istore_2
    //   1029: ldc 'socket 连接异常 - SocketException'
    //   1031: aload #14
    //   1033: invokevirtual getMessage : ()Ljava/lang/String;
    //   1036: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1039: ifne -> 1096
    //   1042: iload_1
    //   1043: istore_2
    //   1044: ldc '未知的错误'
    //   1046: aload #14
    //   1048: invokevirtual a : ()Ljava/lang/String;
    //   1051: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1054: ifne -> 1096
    //   1057: iload_1
    //   1058: istore_2
    //   1059: ldc '服务器连接失败 - UnknownServiceException'
    //   1061: aload #14
    //   1063: invokevirtual getMessage : ()Ljava/lang/String;
    //   1066: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1069: ifeq -> 1075
    //   1072: goto -> 1096
    //   1075: iload_1
    //   1076: istore_2
    //   1077: new com/amap/api/services/core/AMapException
    //   1080: dup
    //   1081: aload #14
    //   1083: invokevirtual a : ()Ljava/lang/String;
    //   1086: iconst_1
    //   1087: aload #14
    //   1089: invokevirtual c : ()Ljava/lang/String;
    //   1092: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;)V
    //   1095: athrow
    //   1096: iload_1
    //   1097: istore_2
    //   1098: new com/amap/api/services/core/AMapException
    //   1101: dup
    //   1102: ldc 'http或socket连接失败 - ConnectionException'
    //   1104: iconst_1
    //   1105: aload #14
    //   1107: invokevirtual c : ()Ljava/lang/String;
    //   1110: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;)V
    //   1113: athrow
    //   1114: iload #8
    //   1116: ifeq -> 1133
    //   1119: iload_2
    //   1120: ifne -> 1133
    //   1123: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   1126: aload #18
    //   1128: aload #13
    //   1130: invokevirtual a : (Lcom/amap/api/col/s/ad$b;Ljava/lang/Object;)V
    //   1133: aload #14
    //   1135: athrow
    //   1136: aload #14
    //   1138: areturn
    //   1139: astore #13
    //   1141: aload #13
    //   1143: invokevirtual printStackTrace : ()V
    //   1146: new com/amap/api/services/core/AMapException
    //   1149: dup
    //   1150: ldc '未知错误'
    //   1152: invokespecial <init> : (Ljava/lang/String;)V
    //   1155: athrow
    //   1156: astore #13
    //   1158: aload #13
    //   1160: athrow
    //   1161: astore #13
    //   1163: goto -> 905
    //   1166: aconst_null
    //   1167: astore #14
    //   1169: goto -> 478
    // Exception table:
    //   from	to	target	type
    //   0	16	1156	com/amap/api/services/core/AMapException
    //   0	16	1139	finally
    //   24	38	1156	com/amap/api/services/core/AMapException
    //   24	38	1139	finally
    //   58	66	765	com/amap/api/col/s/bh
    //   58	66	651	com/amap/api/services/core/AMapException
    //   58	66	644	finally
    //   86	96	765	com/amap/api/col/s/bh
    //   86	96	651	com/amap/api/services/core/AMapException
    //   86	96	644	finally
    //   116	121	765	com/amap/api/col/s/bh
    //   116	121	651	com/amap/api/services/core/AMapException
    //   116	121	644	finally
    //   152	162	765	com/amap/api/col/s/bh
    //   152	162	651	com/amap/api/services/core/AMapException
    //   152	162	644	finally
    //   199	207	765	com/amap/api/col/s/bh
    //   199	207	651	com/amap/api/services/core/AMapException
    //   199	207	644	finally
    //   227	234	765	com/amap/api/col/s/bh
    //   227	234	651	com/amap/api/services/core/AMapException
    //   227	234	644	finally
    //   234	251	278	com/amap/api/col/s/bh
    //   234	251	267	com/amap/api/services/core/AMapException
    //   234	251	256	finally
    //   320	327	765	com/amap/api/col/s/bh
    //   320	327	651	com/amap/api/services/core/AMapException
    //   320	327	644	finally
    //   347	355	765	com/amap/api/col/s/bh
    //   347	355	651	com/amap/api/services/core/AMapException
    //   347	355	644	finally
    //   378	384	765	com/amap/api/col/s/bh
    //   378	384	651	com/amap/api/services/core/AMapException
    //   378	384	644	finally
    //   413	420	765	com/amap/api/col/s/bh
    //   413	420	651	com/amap/api/services/core/AMapException
    //   413	420	644	finally
    //   440	446	765	com/amap/api/col/s/bh
    //   440	446	651	com/amap/api/services/core/AMapException
    //   440	446	644	finally
    //   469	475	765	com/amap/api/col/s/bh
    //   469	475	651	com/amap/api/services/core/AMapException
    //   469	475	644	finally
    //   498	503	765	com/amap/api/col/s/bh
    //   498	503	651	com/amap/api/services/core/AMapException
    //   498	503	644	finally
    //   523	531	765	com/amap/api/col/s/bh
    //   523	531	651	com/amap/api/services/core/AMapException
    //   523	531	644	finally
    //   551	568	765	com/amap/api/col/s/bh
    //   551	568	651	com/amap/api/services/core/AMapException
    //   551	568	644	finally
    //   588	594	765	com/amap/api/col/s/bh
    //   588	594	651	com/amap/api/services/core/AMapException
    //   588	594	644	finally
    //   621	626	1156	com/amap/api/services/core/AMapException
    //   621	626	1139	finally
    //   630	639	1156	com/amap/api/services/core/AMapException
    //   630	639	1139	finally
    //   662	667	644	finally
    //   673	690	644	finally
    //   702	707	644	finally
    //   740	745	1156	com/amap/api/services/core/AMapException
    //   740	745	1139	finally
    //   754	757	757	finally
    //   780	785	644	finally
    //   791	808	644	finally
    //   820	825	644	finally
    //   837	849	1161	java/lang/InterruptedException
    //   837	849	644	finally
    //   876	886	1156	com/amap/api/services/core/AMapException
    //   876	886	1139	finally
    //   911	924	644	finally
    //   930	943	644	finally
    //   949	962	644	finally
    //   971	990	644	finally
    //   996	1012	644	finally
    //   1014	1027	757	finally
    //   1029	1042	757	finally
    //   1044	1057	757	finally
    //   1059	1072	757	finally
    //   1077	1096	757	finally
    //   1098	1114	757	finally
    //   1123	1133	1156	com/amap/api/services/core/AMapException
    //   1123	1133	1139	finally
    //   1133	1136	1156	com/amap/api/services/core/AMapException
    //   1133	1136	1139	finally
  }
  
  protected abstract V a(String paramString) throws AMapException;
  
  protected V a(byte[] paramArrayOfbyte) throws AMapException {
    try {
      String str = new String(paramArrayOfbyte, "utf-8");
    } catch (Exception exception) {
      i.a(exception, "ProtocalHandler", "loadData");
      exception = null;
    } 
    if (exception != null) {
      if (exception.equals(""))
        return null; 
      i.b((String)exception);
      return a((String)exception);
    } 
    return null;
  }
  
  protected abstract String a();
  
  public final String c() {
    return "sea";
  }
  
  protected ad.b d() {
    return null;
  }
  
  public Map<String, String> e() {
    return null;
  }
  
  public Map<String, String> f() {
    return null;
  }
  
  public final V n_() throws AMapException {
    if (this.b != null)
      try {
        return l();
      } catch (AMapException aMapException) {
        String str1 = h();
        String str2 = this.f;
        if (str1 != null) {
          String str3;
          String str4 = aMapException.getErrorType();
          if (aMapException.getErrorLevel() == 0) {
            int i = aMapException.getErrorCode();
            if (i == 0) {
              str3 = "4";
            } else {
              int j = (int)Math.pow(10.0D, Math.floor(Math.log10(i)));
              str3 = String.valueOf(i % j + j * 4);
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aMapException.getErrorCode());
            str3 = stringBuilder.toString();
          } 
          if (str3 != null && str3.length() > 0)
            cg.a(h.a(true), str1, str4, str2, str3); 
        } 
        throw aMapException;
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */