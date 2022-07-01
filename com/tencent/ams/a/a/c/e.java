package com.tencent.ams.a.a.c;

import com.tencent.ams.a.a.b.g;
import java.io.InputStream;
import java.util.regex.Pattern;

public class e {
  public static g a(InputStream paramInputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic newPullParser : ()Lorg/xmlpull/v1/XmlPullParser;
    //   5: astore #13
    //   7: aload #13
    //   9: aload_0
    //   10: ldc 'UTF-8'
    //   12: invokeinterface setInput : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   17: aload #13
    //   19: invokeinterface getEventType : ()I
    //   24: istore_1
    //   25: aconst_null
    //   26: astore_2
    //   27: aload_2
    //   28: astore_3
    //   29: aload_3
    //   30: astore #4
    //   32: aload #4
    //   34: astore #6
    //   36: iload_1
    //   37: iconst_1
    //   38: if_icmpeq -> 1588
    //   41: iload_1
    //   42: ifeq -> 1530
    //   45: aload_2
    //   46: astore #8
    //   48: aload_3
    //   49: astore #9
    //   51: aload #4
    //   53: astore #10
    //   55: aload #6
    //   57: astore #11
    //   59: iload_1
    //   60: iconst_1
    //   61: if_icmpeq -> 1553
    //   64: iload_1
    //   65: iconst_2
    //   66: if_icmpeq -> 257
    //   69: iload_1
    //   70: iconst_3
    //   71: if_icmpeq -> 91
    //   74: aload_2
    //   75: astore #8
    //   77: aload_3
    //   78: astore #9
    //   80: aload #4
    //   82: astore #10
    //   84: aload #6
    //   86: astore #11
    //   88: goto -> 1553
    //   91: aload_2
    //   92: astore #5
    //   94: aload #13
    //   96: invokeinterface getName : ()Ljava/lang/String;
    //   101: astore #7
    //   103: aload_2
    //   104: astore #5
    //   106: ldc 'company'
    //   108: aload #7
    //   110: invokevirtual equals : (Ljava/lang/Object;)Z
    //   113: ifeq -> 147
    //   116: aload_2
    //   117: astore #5
    //   119: aload_2
    //   120: getfield b : Ljava/util/List;
    //   123: aload #6
    //   125: invokeinterface add : (Ljava/lang/Object;)Z
    //   130: pop
    //   131: aconst_null
    //   132: astore #11
    //   134: aload_2
    //   135: astore #8
    //   137: aload_3
    //   138: astore #9
    //   140: aload #4
    //   142: astore #10
    //   144: goto -> 1553
    //   147: aload_2
    //   148: astore #5
    //   150: ldc 'argument'
    //   152: aload #7
    //   154: invokevirtual equals : (Ljava/lang/Object;)Z
    //   157: ifeq -> 195
    //   160: aload_2
    //   161: astore #5
    //   163: aload #6
    //   165: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   168: getfield a : Ljava/util/List;
    //   171: aload #4
    //   173: invokeinterface add : (Ljava/lang/Object;)Z
    //   178: pop
    //   179: aconst_null
    //   180: astore #10
    //   182: aload_2
    //   183: astore #8
    //   185: aload_3
    //   186: astore #9
    //   188: aload #6
    //   190: astore #11
    //   192: goto -> 1553
    //   195: aload_2
    //   196: astore #8
    //   198: aload_3
    //   199: astore #9
    //   201: aload #4
    //   203: astore #10
    //   205: aload #6
    //   207: astore #11
    //   209: aload_2
    //   210: astore #5
    //   212: ldc 'event'
    //   214: aload #7
    //   216: invokevirtual equals : (Ljava/lang/Object;)Z
    //   219: ifeq -> 1553
    //   222: aload_2
    //   223: astore #5
    //   225: aload #6
    //   227: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   230: getfield b : Ljava/util/List;
    //   233: aload_3
    //   234: invokeinterface add : (Ljava/lang/Object;)Z
    //   239: pop
    //   240: aconst_null
    //   241: astore #9
    //   243: aload_2
    //   244: astore #8
    //   246: aload #4
    //   248: astore #10
    //   250: aload #6
    //   252: astore #11
    //   254: goto -> 1553
    //   257: aload_2
    //   258: astore #5
    //   260: aload #13
    //   262: invokeinterface getName : ()Ljava/lang/String;
    //   267: astore #14
    //   269: aload_2
    //   270: astore #5
    //   272: ldc 'offlineCache'
    //   274: aload #14
    //   276: invokevirtual equals : (Ljava/lang/Object;)Z
    //   279: ifeq -> 296
    //   282: aload_2
    //   283: astore #5
    //   285: aload_2
    //   286: new com/tencent/ams/a/a/b/f
    //   289: dup
    //   290: invokespecial <init> : ()V
    //   293: putfield a : Lcom/tencent/ams/a/a/b/f;
    //   296: aload_2
    //   297: astore #5
    //   299: aload_2
    //   300: getfield a : Lcom/tencent/ams/a/a/b/f;
    //   303: ifnull -> 396
    //   306: aload_2
    //   307: astore #5
    //   309: ldc 'length'
    //   311: aload #14
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifeq -> 336
    //   319: aload_2
    //   320: astore #5
    //   322: aload_2
    //   323: getfield a : Lcom/tencent/ams/a/a/b/f;
    //   326: aload #13
    //   328: invokeinterface nextText : ()Ljava/lang/String;
    //   333: putfield a : Ljava/lang/String;
    //   336: aload_2
    //   337: astore #5
    //   339: ldc 'queueExpirationSecs'
    //   341: aload #14
    //   343: invokevirtual equals : (Ljava/lang/Object;)Z
    //   346: ifeq -> 366
    //   349: aload_2
    //   350: astore #5
    //   352: aload_2
    //   353: getfield a : Lcom/tencent/ams/a/a/b/f;
    //   356: aload #13
    //   358: invokeinterface nextText : ()Ljava/lang/String;
    //   363: putfield b : Ljava/lang/String;
    //   366: aload_2
    //   367: astore #5
    //   369: ldc 'timeout'
    //   371: aload #14
    //   373: invokevirtual equals : (Ljava/lang/Object;)Z
    //   376: ifeq -> 396
    //   379: aload_2
    //   380: astore #5
    //   382: aload_2
    //   383: getfield a : Lcom/tencent/ams/a/a/b/f;
    //   386: aload #13
    //   388: invokeinterface nextText : ()Ljava/lang/String;
    //   393: putfield c : Ljava/lang/String;
    //   396: aload_2
    //   397: astore #5
    //   399: ldc 'companies'
    //   401: aload #14
    //   403: invokevirtual equals : (Ljava/lang/Object;)Z
    //   406: ifeq -> 423
    //   409: aload_2
    //   410: astore #5
    //   412: aload_2
    //   413: new java/util/ArrayList
    //   416: dup
    //   417: invokespecial <init> : ()V
    //   420: putfield b : Ljava/util/List;
    //   423: aload #6
    //   425: astore #7
    //   427: aload_2
    //   428: astore #5
    //   430: aload_2
    //   431: getfield b : Ljava/util/List;
    //   434: ifnull -> 466
    //   437: aload #6
    //   439: astore #7
    //   441: aload_2
    //   442: astore #5
    //   444: ldc 'company'
    //   446: aload #14
    //   448: invokevirtual equals : (Ljava/lang/Object;)Z
    //   451: ifeq -> 466
    //   454: aload_2
    //   455: astore #5
    //   457: new com/tencent/ams/a/a/b/b
    //   460: dup
    //   461: invokespecial <init> : ()V
    //   464: astore #7
    //   466: aload_2
    //   467: astore #8
    //   469: aload_3
    //   470: astore #9
    //   472: aload #4
    //   474: astore #10
    //   476: aload #7
    //   478: astore #11
    //   480: aload #7
    //   482: ifnull -> 1553
    //   485: aload_2
    //   486: astore #5
    //   488: ldc 'name'
    //   490: aload #14
    //   492: invokevirtual equals : (Ljava/lang/Object;)Z
    //   495: ifeq -> 524
    //   498: aload_2
    //   499: astore #5
    //   501: aload #7
    //   503: getfield a : Ljava/lang/String;
    //   506: ifnonnull -> 524
    //   509: aload_2
    //   510: astore #5
    //   512: aload #7
    //   514: aload #13
    //   516: invokeinterface nextText : ()Ljava/lang/String;
    //   521: putfield a : Ljava/lang/String;
    //   524: aload_2
    //   525: astore #5
    //   527: ldc 'encryptType'
    //   529: aload #14
    //   531: invokevirtual equals : (Ljava/lang/Object;)Z
    //   534: ifeq -> 573
    //   537: aload_2
    //   538: astore #5
    //   540: aload #13
    //   542: invokeinterface nextText : ()Ljava/lang/String;
    //   547: astore #6
    //   549: aload_2
    //   550: astore #5
    //   552: aload #6
    //   554: invokestatic a : (Ljava/lang/String;)Z
    //   557: ifeq -> 573
    //   560: aload_2
    //   561: astore #5
    //   563: aload #7
    //   565: aload #6
    //   567: invokestatic parseInt : (Ljava/lang/String;)I
    //   570: putfield i : I
    //   573: aload_2
    //   574: astore #5
    //   576: ldc 'domain'
    //   578: aload #14
    //   580: invokevirtual equals : (Ljava/lang/Object;)Z
    //   583: ifeq -> 601
    //   586: aload_2
    //   587: astore #5
    //   589: aload #7
    //   591: new com/tencent/ams/a/a/b/d
    //   594: dup
    //   595: invokespecial <init> : ()V
    //   598: putfield b : Lcom/tencent/ams/a/a/b/d;
    //   601: aload_2
    //   602: astore #5
    //   604: aload #7
    //   606: getfield b : Lcom/tencent/ams/a/a/b/d;
    //   609: ifnull -> 643
    //   612: aload_2
    //   613: astore #5
    //   615: ldc 'url'
    //   617: aload #14
    //   619: invokevirtual equals : (Ljava/lang/Object;)Z
    //   622: ifeq -> 643
    //   625: aload_2
    //   626: astore #5
    //   628: aload #7
    //   630: getfield b : Lcom/tencent/ams/a/a/b/d;
    //   633: aload #13
    //   635: invokeinterface nextText : ()Ljava/lang/String;
    //   640: putfield a : Ljava/lang/String;
    //   643: aload_2
    //   644: astore #5
    //   646: ldc 'signature'
    //   648: aload #14
    //   650: invokevirtual equals : (Ljava/lang/Object;)Z
    //   653: ifeq -> 671
    //   656: aload_2
    //   657: astore #5
    //   659: aload #7
    //   661: new com/tencent/ams/a/a/b/h
    //   664: dup
    //   665: invokespecial <init> : ()V
    //   668: putfield c : Lcom/tencent/ams/a/a/b/h;
    //   671: aload_2
    //   672: astore #5
    //   674: aload #7
    //   676: getfield c : Lcom/tencent/ams/a/a/b/h;
    //   679: ifnull -> 744
    //   682: aload_2
    //   683: astore #5
    //   685: ldc 'publicKey'
    //   687: aload #14
    //   689: invokevirtual equals : (Ljava/lang/Object;)Z
    //   692: ifeq -> 713
    //   695: aload_2
    //   696: astore #5
    //   698: aload #7
    //   700: getfield c : Lcom/tencent/ams/a/a/b/h;
    //   703: aload #13
    //   705: invokeinterface nextText : ()Ljava/lang/String;
    //   710: putfield a : Ljava/lang/String;
    //   713: aload_2
    //   714: astore #5
    //   716: ldc 'paramKey'
    //   718: aload #14
    //   720: invokevirtual equals : (Ljava/lang/Object;)Z
    //   723: ifeq -> 744
    //   726: aload_2
    //   727: astore #5
    //   729: aload #7
    //   731: getfield c : Lcom/tencent/ams/a/a/b/h;
    //   734: aload #13
    //   736: invokeinterface nextText : ()Ljava/lang/String;
    //   741: putfield b : Ljava/lang/String;
    //   744: aload_2
    //   745: astore #5
    //   747: ldc 'switch'
    //   749: aload #14
    //   751: invokevirtual equals : (Ljava/lang/Object;)Z
    //   754: ifeq -> 772
    //   757: aload_2
    //   758: astore #5
    //   760: aload #7
    //   762: new com/tencent/ams/a/a/b/i
    //   765: dup
    //   766: invokespecial <init> : ()V
    //   769: putfield d : Lcom/tencent/ams/a/a/b/i;
    //   772: aload_2
    //   773: astore #5
    //   775: aload #7
    //   777: getfield d : Lcom/tencent/ams/a/a/b/i;
    //   780: ifnull -> 971
    //   783: aload_2
    //   784: astore #5
    //   786: ldc 'isTrackLocation'
    //   788: aload #14
    //   790: invokevirtual equals : (Ljava/lang/Object;)Z
    //   793: ifeq -> 817
    //   796: aload_2
    //   797: astore #5
    //   799: aload #7
    //   801: getfield d : Lcom/tencent/ams/a/a/b/i;
    //   804: aload #13
    //   806: invokeinterface nextText : ()Ljava/lang/String;
    //   811: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   814: putfield a : Z
    //   817: aload_2
    //   818: astore #5
    //   820: ldc 'offlineCacheExpiration'
    //   822: aload #14
    //   824: invokevirtual equals : (Ljava/lang/Object;)Z
    //   827: ifeq -> 848
    //   830: aload_2
    //   831: astore #5
    //   833: aload #7
    //   835: getfield d : Lcom/tencent/ams/a/a/b/i;
    //   838: aload #13
    //   840: invokeinterface nextText : ()Ljava/lang/String;
    //   845: putfield b : Ljava/lang/String;
    //   848: aload_2
    //   849: astore #5
    //   851: ldc 'encrypt'
    //   853: aload #14
    //   855: invokevirtual equals : (Ljava/lang/Object;)Z
    //   858: ifeq -> 879
    //   861: aload_2
    //   862: astore #5
    //   864: aload #7
    //   866: getfield d : Lcom/tencent/ams/a/a/b/i;
    //   869: new java/util/HashMap
    //   872: dup
    //   873: invokespecial <init> : ()V
    //   876: putfield c : Ljava/util/Map;
    //   879: aload_2
    //   880: astore #5
    //   882: aload #7
    //   884: getfield d : Lcom/tencent/ams/a/a/b/i;
    //   887: getfield c : Ljava/util/Map;
    //   890: ifnull -> 971
    //   893: aload_2
    //   894: astore #5
    //   896: ldc 'MAC'
    //   898: aload #14
    //   900: invokevirtual equals : (Ljava/lang/Object;)Z
    //   903: ifne -> 945
    //   906: aload_2
    //   907: astore #5
    //   909: ldc 'IDA'
    //   911: aload #14
    //   913: invokevirtual equals : (Ljava/lang/Object;)Z
    //   916: ifne -> 945
    //   919: aload_2
    //   920: astore #5
    //   922: ldc 'IMEI'
    //   924: aload #14
    //   926: invokevirtual equals : (Ljava/lang/Object;)Z
    //   929: ifne -> 945
    //   932: aload_2
    //   933: astore #5
    //   935: ldc 'ANDROID'
    //   937: aload #14
    //   939: invokevirtual equals : (Ljava/lang/Object;)Z
    //   942: ifeq -> 971
    //   945: aload_2
    //   946: astore #5
    //   948: aload #7
    //   950: getfield d : Lcom/tencent/ams/a/a/b/i;
    //   953: getfield c : Ljava/util/Map;
    //   956: aload #14
    //   958: aload #13
    //   960: invokeinterface nextText : ()Ljava/lang/String;
    //   965: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   970: pop
    //   971: aload_2
    //   972: astore #5
    //   974: ldc 'config'
    //   976: aload #14
    //   978: invokevirtual equals : (Ljava/lang/Object;)Z
    //   981: ifeq -> 999
    //   984: aload_2
    //   985: astore #5
    //   987: aload #7
    //   989: new com/tencent/ams/a/a/b/c
    //   992: dup
    //   993: invokespecial <init> : ()V
    //   996: putfield e : Lcom/tencent/ams/a/a/b/c;
    //   999: aload_3
    //   1000: astore #6
    //   1002: aload #4
    //   1004: astore #12
    //   1006: aload_2
    //   1007: astore #5
    //   1009: aload #7
    //   1011: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   1014: ifnull -> 1410
    //   1017: aload_2
    //   1018: astore #5
    //   1020: ldc 'arguments'
    //   1022: aload #14
    //   1024: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1027: ifeq -> 1048
    //   1030: aload_2
    //   1031: astore #5
    //   1033: aload #7
    //   1035: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   1038: new java/util/ArrayList
    //   1041: dup
    //   1042: invokespecial <init> : ()V
    //   1045: putfield a : Ljava/util/List;
    //   1048: aload #4
    //   1050: astore #8
    //   1052: aload_2
    //   1053: astore #5
    //   1055: aload #7
    //   1057: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   1060: getfield a : Ljava/util/List;
    //   1063: ifnull -> 1095
    //   1066: aload #4
    //   1068: astore #8
    //   1070: aload_2
    //   1071: astore #5
    //   1073: ldc 'argument'
    //   1075: aload #14
    //   1077: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1080: ifeq -> 1095
    //   1083: aload_2
    //   1084: astore #5
    //   1086: new com/tencent/ams/a/a/b/a
    //   1089: dup
    //   1090: invokespecial <init> : ()V
    //   1093: astore #8
    //   1095: aload #8
    //   1097: ifnull -> 1218
    //   1100: aload_2
    //   1101: astore #5
    //   1103: ldc 'key'
    //   1105: aload #14
    //   1107: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1110: ifeq -> 1128
    //   1113: aload_2
    //   1114: astore #5
    //   1116: aload #8
    //   1118: aload #13
    //   1120: invokeinterface nextText : ()Ljava/lang/String;
    //   1125: putfield a : Ljava/lang/String;
    //   1128: aload_2
    //   1129: astore #5
    //   1131: ldc 'value'
    //   1133: aload #14
    //   1135: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1138: ifeq -> 1156
    //   1141: aload_2
    //   1142: astore #5
    //   1144: aload #8
    //   1146: aload #13
    //   1148: invokeinterface nextText : ()Ljava/lang/String;
    //   1153: putfield b : Ljava/lang/String;
    //   1156: aload_2
    //   1157: astore #5
    //   1159: ldc 'urlEncode'
    //   1161: aload #14
    //   1163: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1166: ifeq -> 1187
    //   1169: aload_2
    //   1170: astore #5
    //   1172: aload #8
    //   1174: aload #13
    //   1176: invokeinterface nextText : ()Ljava/lang/String;
    //   1181: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   1184: putfield c : Z
    //   1187: aload_2
    //   1188: astore #5
    //   1190: ldc 'isRequired'
    //   1192: aload #14
    //   1194: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1197: ifeq -> 1218
    //   1200: aload_2
    //   1201: astore #5
    //   1203: aload #8
    //   1205: aload #13
    //   1207: invokeinterface nextText : ()Ljava/lang/String;
    //   1212: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   1215: putfield d : Z
    //   1218: aload_2
    //   1219: astore #5
    //   1221: ldc 'events'
    //   1223: aload #14
    //   1225: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1228: ifeq -> 1249
    //   1231: aload_2
    //   1232: astore #5
    //   1234: aload #7
    //   1236: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   1239: new java/util/ArrayList
    //   1242: dup
    //   1243: invokespecial <init> : ()V
    //   1246: putfield b : Ljava/util/List;
    //   1249: aload_3
    //   1250: astore #4
    //   1252: aload_2
    //   1253: astore #5
    //   1255: aload #7
    //   1257: getfield e : Lcom/tencent/ams/a/a/b/c;
    //   1260: getfield b : Ljava/util/List;
    //   1263: ifnull -> 1294
    //   1266: aload_3
    //   1267: astore #4
    //   1269: aload_2
    //   1270: astore #5
    //   1272: ldc 'event'
    //   1274: aload #14
    //   1276: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1279: ifeq -> 1294
    //   1282: aload_2
    //   1283: astore #5
    //   1285: new com/tencent/ams/a/a/b/e
    //   1288: dup
    //   1289: invokespecial <init> : ()V
    //   1292: astore #4
    //   1294: aload #4
    //   1296: astore #6
    //   1298: aload #8
    //   1300: astore #12
    //   1302: aload #4
    //   1304: ifnull -> 1410
    //   1307: aload_2
    //   1308: astore #5
    //   1310: ldc 'key'
    //   1312: aload #14
    //   1314: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1317: ifeq -> 1335
    //   1320: aload_2
    //   1321: astore #5
    //   1323: aload #4
    //   1325: aload #13
    //   1327: invokeinterface nextText : ()Ljava/lang/String;
    //   1332: putfield a : Ljava/lang/String;
    //   1335: aload_2
    //   1336: astore #5
    //   1338: ldc 'value'
    //   1340: aload #14
    //   1342: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1345: ifeq -> 1363
    //   1348: aload_2
    //   1349: astore #5
    //   1351: aload #4
    //   1353: aload #13
    //   1355: invokeinterface nextText : ()Ljava/lang/String;
    //   1360: putfield b : Ljava/lang/String;
    //   1363: aload #4
    //   1365: astore #6
    //   1367: aload #8
    //   1369: astore #12
    //   1371: aload_2
    //   1372: astore #5
    //   1374: ldc 'urlEncode'
    //   1376: aload #14
    //   1378: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1381: ifeq -> 1410
    //   1384: aload_2
    //   1385: astore #5
    //   1387: aload #4
    //   1389: aload #13
    //   1391: invokeinterface nextText : ()Ljava/lang/String;
    //   1396: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   1399: putfield c : Z
    //   1402: aload #8
    //   1404: astore #12
    //   1406: aload #4
    //   1408: astore #6
    //   1410: aload_2
    //   1411: astore #5
    //   1413: ldc 'separator'
    //   1415: aload #14
    //   1417: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1420: ifeq -> 1438
    //   1423: aload_2
    //   1424: astore #5
    //   1426: aload #7
    //   1428: aload #13
    //   1430: invokeinterface nextText : ()Ljava/lang/String;
    //   1435: putfield f : Ljava/lang/String;
    //   1438: aload_2
    //   1439: astore #5
    //   1441: ldc 'equalizer'
    //   1443: aload #14
    //   1445: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1448: ifeq -> 1466
    //   1451: aload_2
    //   1452: astore #5
    //   1454: aload #7
    //   1456: aload #13
    //   1458: invokeinterface nextText : ()Ljava/lang/String;
    //   1463: putfield g : Ljava/lang/String;
    //   1466: aload_2
    //   1467: astore #8
    //   1469: aload #6
    //   1471: astore #9
    //   1473: aload #12
    //   1475: astore #10
    //   1477: aload #7
    //   1479: astore #11
    //   1481: aload_2
    //   1482: astore #5
    //   1484: ldc 'timeStampUseSecond'
    //   1486: aload #14
    //   1488: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1491: ifeq -> 1553
    //   1494: aload_2
    //   1495: astore #5
    //   1497: aload #7
    //   1499: aload #13
    //   1501: invokeinterface nextText : ()Ljava/lang/String;
    //   1506: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   1509: putfield h : Z
    //   1512: aload_2
    //   1513: astore #8
    //   1515: aload #6
    //   1517: astore #9
    //   1519: aload #12
    //   1521: astore #10
    //   1523: aload #7
    //   1525: astore #11
    //   1527: goto -> 1553
    //   1530: aload_2
    //   1531: astore #5
    //   1533: new com/tencent/ams/a/a/b/g
    //   1536: dup
    //   1537: invokespecial <init> : ()V
    //   1540: astore #8
    //   1542: aload #6
    //   1544: astore #11
    //   1546: aload #4
    //   1548: astore #10
    //   1550: aload_3
    //   1551: astore #9
    //   1553: aload #8
    //   1555: astore #5
    //   1557: aload #13
    //   1559: invokeinterface next : ()I
    //   1564: istore_1
    //   1565: aload #8
    //   1567: astore_2
    //   1568: aload #9
    //   1570: astore_3
    //   1571: aload #10
    //   1573: astore #4
    //   1575: aload #11
    //   1577: astore #6
    //   1579: goto -> 36
    //   1582: aload #5
    //   1584: astore_2
    //   1585: goto -> 1600
    //   1588: aload_2
    //   1589: astore_3
    //   1590: aload_0
    //   1591: ifnull -> 1609
    //   1594: aload_0
    //   1595: invokevirtual close : ()V
    //   1598: aload_2
    //   1599: areturn
    //   1600: aload_2
    //   1601: astore_3
    //   1602: aload_0
    //   1603: ifnull -> 1609
    //   1606: goto -> 1594
    //   1609: aload_3
    //   1610: areturn
    //   1611: astore_3
    //   1612: goto -> 1600
    //   1615: astore_2
    //   1616: goto -> 1582
    //   1619: astore_0
    //   1620: aload_2
    //   1621: areturn
    // Exception table:
    //   from	to	target	type
    //   2	25	1611	finally
    //   94	103	1615	finally
    //   106	116	1615	finally
    //   119	131	1615	finally
    //   150	160	1615	finally
    //   163	179	1615	finally
    //   212	222	1615	finally
    //   225	240	1615	finally
    //   260	269	1615	finally
    //   272	282	1615	finally
    //   285	296	1615	finally
    //   299	306	1615	finally
    //   309	319	1615	finally
    //   322	336	1615	finally
    //   339	349	1615	finally
    //   352	366	1615	finally
    //   369	379	1615	finally
    //   382	396	1615	finally
    //   399	409	1615	finally
    //   412	423	1615	finally
    //   430	437	1615	finally
    //   444	454	1615	finally
    //   457	466	1615	finally
    //   488	498	1615	finally
    //   501	509	1615	finally
    //   512	524	1615	finally
    //   527	537	1615	finally
    //   540	549	1615	finally
    //   552	560	1615	finally
    //   563	573	1615	finally
    //   576	586	1615	finally
    //   589	601	1615	finally
    //   604	612	1615	finally
    //   615	625	1615	finally
    //   628	643	1615	finally
    //   646	656	1615	finally
    //   659	671	1615	finally
    //   674	682	1615	finally
    //   685	695	1615	finally
    //   698	713	1615	finally
    //   716	726	1615	finally
    //   729	744	1615	finally
    //   747	757	1615	finally
    //   760	772	1615	finally
    //   775	783	1615	finally
    //   786	796	1615	finally
    //   799	817	1615	finally
    //   820	830	1615	finally
    //   833	848	1615	finally
    //   851	861	1615	finally
    //   864	879	1615	finally
    //   882	893	1615	finally
    //   896	906	1615	finally
    //   909	919	1615	finally
    //   922	932	1615	finally
    //   935	945	1615	finally
    //   948	971	1615	finally
    //   974	984	1615	finally
    //   987	999	1615	finally
    //   1009	1017	1615	finally
    //   1020	1030	1615	finally
    //   1033	1048	1615	finally
    //   1055	1066	1615	finally
    //   1073	1083	1615	finally
    //   1086	1095	1615	finally
    //   1103	1113	1615	finally
    //   1116	1128	1615	finally
    //   1131	1141	1615	finally
    //   1144	1156	1615	finally
    //   1159	1169	1615	finally
    //   1172	1187	1615	finally
    //   1190	1200	1615	finally
    //   1203	1218	1615	finally
    //   1221	1231	1615	finally
    //   1234	1249	1615	finally
    //   1255	1266	1615	finally
    //   1272	1282	1615	finally
    //   1285	1294	1615	finally
    //   1310	1320	1615	finally
    //   1323	1335	1615	finally
    //   1338	1348	1615	finally
    //   1351	1363	1615	finally
    //   1374	1384	1615	finally
    //   1387	1402	1615	finally
    //   1413	1423	1615	finally
    //   1426	1438	1615	finally
    //   1441	1451	1615	finally
    //   1454	1466	1615	finally
    //   1484	1494	1615	finally
    //   1497	1512	1615	finally
    //   1533	1542	1615	finally
    //   1557	1565	1615	finally
    //   1594	1598	1619	finally
  }
  
  public static boolean a(String paramString) {
    return (paramString == null || "".equals(paramString)) ? false : Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */