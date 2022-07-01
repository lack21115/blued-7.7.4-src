package com.loc;

import java.util.List;

public final class bu extends bt {
  public bu() {
    super(2048);
  }
  
  public final byte[] a(dc paramdc, bx.a parama, long paramLong, List<dd> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial a : ()Lcom/loc/bt;
    //   4: pop
    //   5: aload_1
    //   6: getfield k : J
    //   9: lstore #17
    //   11: aload_1
    //   12: getfield c : J
    //   15: lstore #19
    //   17: aload_1
    //   18: getfield e : D
    //   21: ldc2_w 1000000.0
    //   24: dmul
    //   25: d2i
    //   26: istore #10
    //   28: aload_1
    //   29: getfield d : D
    //   32: ldc2_w 1000000.0
    //   35: dmul
    //   36: d2i
    //   37: istore #11
    //   39: aload_1
    //   40: getfield f : D
    //   43: d2i
    //   44: istore #12
    //   46: aload_1
    //   47: getfield i : F
    //   50: f2i
    //   51: istore #13
    //   53: aload_1
    //   54: getfield g : F
    //   57: f2i
    //   58: istore #14
    //   60: aload_1
    //   61: getfield h : F
    //   64: f2i
    //   65: i2s
    //   66: istore #9
    //   68: aload_1
    //   69: getfield l : B
    //   72: istore #6
    //   74: aload_0
    //   75: getfield a : Lcom/loc/bv;
    //   78: lload #19
    //   80: lload #17
    //   82: iload #10
    //   84: iload #11
    //   86: iload #12
    //   88: iload #13
    //   90: iload #14
    //   92: iload #9
    //   94: iload #6
    //   96: invokestatic a : (Lcom/loc/er;JJIIIIISB)I
    //   99: istore #11
    //   101: aload_2
    //   102: ifnull -> 1485
    //   105: aload_2
    //   106: getfield f : Ljava/util/List;
    //   109: ifnull -> 1485
    //   112: aload_2
    //   113: getfield f : Ljava/util/List;
    //   116: invokeinterface size : ()I
    //   121: ifle -> 1485
    //   124: aload_2
    //   125: getfield f : Ljava/util/List;
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull -> 323
    //   133: aload_1
    //   134: invokeinterface size : ()I
    //   139: ifne -> 145
    //   142: goto -> 323
    //   145: aload_1
    //   146: invokeinterface iterator : ()Ljava/util/Iterator;
    //   151: astore_1
    //   152: aload_1
    //   153: invokeinterface hasNext : ()Z
    //   158: ifeq -> 323
    //   161: aload_1
    //   162: invokeinterface next : ()Ljava/lang/Object;
    //   167: checkcast com/loc/cw
    //   170: astore #22
    //   172: aload #22
    //   174: instanceof com/loc/cy
    //   177: ifeq -> 215
    //   180: aload #22
    //   182: checkcast com/loc/cy
    //   185: astore #23
    //   187: aload #23
    //   189: getfield j : I
    //   192: aload #23
    //   194: getfield k : I
    //   197: invokestatic a : (II)J
    //   200: invokestatic a : (J)S
    //   203: istore #10
    //   205: aload #22
    //   207: iload #10
    //   209: putfield g : I
    //   212: goto -> 152
    //   215: aload #22
    //   217: instanceof com/loc/cz
    //   220: ifeq -> 251
    //   223: aload #22
    //   225: checkcast com/loc/cz
    //   228: astore #23
    //   230: aload #23
    //   232: getfield j : I
    //   235: aload #23
    //   237: getfield k : I
    //   240: invokestatic a : (II)J
    //   243: invokestatic a : (J)S
    //   246: istore #10
    //   248: goto -> 205
    //   251: aload #22
    //   253: instanceof com/loc/da
    //   256: ifeq -> 287
    //   259: aload #22
    //   261: checkcast com/loc/da
    //   264: astore #23
    //   266: aload #23
    //   268: getfield j : I
    //   271: aload #23
    //   273: getfield k : I
    //   276: invokestatic a : (II)J
    //   279: invokestatic a : (J)S
    //   282: istore #10
    //   284: goto -> 205
    //   287: aload #22
    //   289: instanceof com/loc/cx
    //   292: ifeq -> 152
    //   295: aload #22
    //   297: checkcast com/loc/cx
    //   300: astore #23
    //   302: aload #23
    //   304: getfield k : I
    //   307: aload #23
    //   309: getfield l : I
    //   312: invokestatic a : (II)J
    //   315: invokestatic a : (J)S
    //   318: istore #10
    //   320: goto -> 205
    //   323: aload_2
    //   324: getfield f : Ljava/util/List;
    //   327: invokeinterface size : ()I
    //   332: istore #13
    //   334: iload #13
    //   336: newarray int
    //   338: astore_1
    //   339: iconst_0
    //   340: istore #14
    //   342: iload #14
    //   344: iload #13
    //   346: if_icmpge -> 811
    //   349: aload_2
    //   350: getfield f : Ljava/util/List;
    //   353: iload #14
    //   355: invokeinterface get : (I)Ljava/lang/Object;
    //   360: checkcast com/loc/cw
    //   363: astore #22
    //   365: aload #22
    //   367: instanceof com/loc/cy
    //   370: ifeq -> 477
    //   373: aload #22
    //   375: checkcast com/loc/cy
    //   378: astore #23
    //   380: aload #23
    //   382: getfield i : Z
    //   385: ifne -> 420
    //   388: aload_0
    //   389: getfield a : Lcom/loc/bv;
    //   392: aload #23
    //   394: getfield j : I
    //   397: aload #23
    //   399: getfield k : I
    //   402: aload #23
    //   404: getfield c : I
    //   407: aload #23
    //   409: getfield l : I
    //   412: invokestatic a : (Lcom/loc/er;IIII)I
    //   415: istore #10
    //   417: goto -> 1435
    //   420: aload_0
    //   421: getfield a : Lcom/loc/bv;
    //   424: aload #23
    //   426: invokevirtual b : ()I
    //   429: aload #23
    //   431: invokevirtual c : ()I
    //   434: aload #23
    //   436: getfield j : I
    //   439: aload #23
    //   441: getfield k : I
    //   444: aload #23
    //   446: getfield c : I
    //   449: aload #23
    //   451: getfield m : I
    //   454: aload #23
    //   456: getfield n : I
    //   459: aload #23
    //   461: getfield d : I
    //   464: aload #23
    //   466: getfield l : I
    //   469: invokestatic a : (Lcom/loc/er;IIIIIIIII)I
    //   472: istore #10
    //   474: goto -> 1435
    //   477: aload #22
    //   479: instanceof com/loc/cz
    //   482: ifeq -> 547
    //   485: aload #22
    //   487: checkcast com/loc/cz
    //   490: astore #23
    //   492: aload_0
    //   493: getfield a : Lcom/loc/bv;
    //   496: aload #23
    //   498: invokevirtual b : ()I
    //   501: aload #23
    //   503: invokevirtual c : ()I
    //   506: aload #23
    //   508: getfield j : I
    //   511: aload #23
    //   513: getfield k : I
    //   516: aload #23
    //   518: getfield l : I
    //   521: aload #23
    //   523: getfield c : I
    //   526: aload #23
    //   528: getfield m : I
    //   531: aload #23
    //   533: getfield d : I
    //   536: invokestatic a : (Lcom/loc/er;IIIIIIII)I
    //   539: istore #10
    //   541: iconst_3
    //   542: istore #6
    //   544: goto -> 729
    //   547: aload #22
    //   549: instanceof com/loc/cx
    //   552: ifeq -> 659
    //   555: aload #22
    //   557: checkcast com/loc/cx
    //   560: astore #23
    //   562: aload #23
    //   564: getfield i : Z
    //   567: ifne -> 612
    //   570: aload_0
    //   571: getfield a : Lcom/loc/bv;
    //   574: aload #23
    //   576: getfield j : I
    //   579: aload #23
    //   581: getfield k : I
    //   584: aload #23
    //   586: getfield l : I
    //   589: aload #23
    //   591: getfield m : I
    //   594: aload #23
    //   596: getfield n : I
    //   599: aload #23
    //   601: getfield c : I
    //   604: invokestatic a : (Lcom/loc/er;IIIIII)I
    //   607: istore #10
    //   609: goto -> 1441
    //   612: aload_0
    //   613: getfield a : Lcom/loc/bv;
    //   616: aload #23
    //   618: getfield j : I
    //   621: aload #23
    //   623: getfield k : I
    //   626: aload #23
    //   628: getfield l : I
    //   631: aload #23
    //   633: getfield m : I
    //   636: aload #23
    //   638: getfield n : I
    //   641: aload #23
    //   643: getfield c : I
    //   646: aload #23
    //   648: getfield d : I
    //   651: invokestatic a : (Lcom/loc/er;IIIIIII)I
    //   654: istore #10
    //   656: goto -> 1441
    //   659: aload #22
    //   661: instanceof com/loc/da
    //   664: ifeq -> 1447
    //   667: aload #22
    //   669: checkcast com/loc/da
    //   672: astore #23
    //   674: aload_0
    //   675: getfield a : Lcom/loc/bv;
    //   678: aload #23
    //   680: invokevirtual b : ()I
    //   683: aload #23
    //   685: invokevirtual c : ()I
    //   688: aload #23
    //   690: getfield j : I
    //   693: aload #23
    //   695: getfield k : I
    //   698: aload #23
    //   700: getfield l : I
    //   703: aload #23
    //   705: getfield c : I
    //   708: aload #23
    //   710: getfield m : I
    //   713: aload #23
    //   715: getfield d : I
    //   718: invokestatic a : (Lcom/loc/er;IIIIIIII)I
    //   721: istore #10
    //   723: iconst_4
    //   724: istore #6
    //   726: goto -> 729
    //   729: iload #11
    //   731: istore #12
    //   733: iload #10
    //   735: iconst_m1
    //   736: if_icmpeq -> 1489
    //   739: aload #22
    //   741: getfield h : Z
    //   744: ifeq -> 1456
    //   747: iconst_1
    //   748: istore #12
    //   750: goto -> 753
    //   753: iload #12
    //   755: i2b
    //   756: istore #7
    //   758: aload #22
    //   760: getfield i : Z
    //   763: ifeq -> 1462
    //   766: iconst_1
    //   767: istore #12
    //   769: goto -> 772
    //   772: iload #12
    //   774: i2b
    //   775: istore #8
    //   777: aload_1
    //   778: iload #14
    //   780: aload_0
    //   781: getfield a : Lcom/loc/bv;
    //   784: iload #7
    //   786: iload #8
    //   788: aload #22
    //   790: getfield g : I
    //   793: i2s
    //   794: iload #6
    //   796: iload #10
    //   798: invokestatic a : (Lcom/loc/er;BBSBI)I
    //   801: iastore
    //   802: iload #14
    //   804: iconst_1
    //   805: iadd
    //   806: istore #14
    //   808: goto -> 342
    //   811: iload #11
    //   813: istore #12
    //   815: aload_0
    //   816: getfield a : Lcom/loc/bv;
    //   819: aload_2
    //   820: getfield b : Ljava/lang/String;
    //   823: invokevirtual a : (Ljava/lang/CharSequence;)I
    //   826: istore #14
    //   828: aload_0
    //   829: getfield a : Lcom/loc/bv;
    //   832: aload_1
    //   833: invokestatic a : (Lcom/loc/er;[I)I
    //   836: istore #15
    //   838: aload_2
    //   839: getfield g : Ljava/util/List;
    //   842: invokeinterface size : ()I
    //   847: istore #16
    //   849: iload #16
    //   851: newarray int
    //   853: astore #22
    //   855: iconst_0
    //   856: istore #13
    //   858: iload #13
    //   860: iload #16
    //   862: if_icmpge -> 1108
    //   865: aload_2
    //   866: getfield g : Ljava/util/List;
    //   869: iload #13
    //   871: invokeinterface get : (I)Ljava/lang/Object;
    //   876: checkcast com/loc/cw
    //   879: astore_1
    //   880: invokestatic elapsedRealtime : ()J
    //   883: aload_1
    //   884: getfield e : J
    //   887: lsub
    //   888: ldc2_w 1000
    //   891: ldiv
    //   892: lstore #19
    //   894: lload #19
    //   896: ldc2_w 32767
    //   899: lcmp
    //   900: ifgt -> 1468
    //   903: lload #19
    //   905: lstore #17
    //   907: lload #19
    //   909: lconst_0
    //   910: lcmp
    //   911: ifge -> 917
    //   914: goto -> 1468
    //   917: aload_1
    //   918: instanceof com/loc/cy
    //   921: ifeq -> 969
    //   924: aload_1
    //   925: checkcast com/loc/cy
    //   928: astore #23
    //   930: aload_0
    //   931: getfield a : Lcom/loc/bv;
    //   934: astore_1
    //   935: aload #23
    //   937: getfield j : I
    //   940: istore #11
    //   942: aload #23
    //   944: getfield k : I
    //   947: istore #10
    //   949: aload_1
    //   950: iload #11
    //   952: iload #10
    //   954: lload #17
    //   956: l2i
    //   957: i2s
    //   958: invokestatic a : (Lcom/loc/er;IIS)I
    //   961: istore #11
    //   963: iconst_1
    //   964: istore #10
    //   966: goto -> 1082
    //   969: aload_1
    //   970: instanceof com/loc/cz
    //   973: ifeq -> 1004
    //   976: aload_1
    //   977: checkcast com/loc/cz
    //   980: astore #23
    //   982: aload_0
    //   983: getfield a : Lcom/loc/bv;
    //   986: astore_1
    //   987: aload #23
    //   989: getfield j : I
    //   992: istore #11
    //   994: aload #23
    //   996: getfield k : I
    //   999: istore #10
    //   1001: goto -> 949
    //   1004: aload_1
    //   1005: instanceof com/loc/cx
    //   1008: ifeq -> 1047
    //   1011: aload_1
    //   1012: checkcast com/loc/cx
    //   1015: astore_1
    //   1016: aload_0
    //   1017: getfield a : Lcom/loc/bv;
    //   1020: aload_1
    //   1021: getfield j : I
    //   1024: aload_1
    //   1025: getfield k : I
    //   1028: aload_1
    //   1029: getfield l : I
    //   1032: lload #17
    //   1034: l2i
    //   1035: i2s
    //   1036: invokestatic a : (Lcom/loc/er;IIIS)I
    //   1039: istore #11
    //   1041: iconst_2
    //   1042: istore #10
    //   1044: goto -> 1082
    //   1047: aload_1
    //   1048: instanceof com/loc/da
    //   1051: ifeq -> 1476
    //   1054: aload_1
    //   1055: checkcast com/loc/da
    //   1058: astore #23
    //   1060: aload_0
    //   1061: getfield a : Lcom/loc/bv;
    //   1064: astore_1
    //   1065: aload #23
    //   1067: getfield j : I
    //   1070: istore #11
    //   1072: aload #23
    //   1074: getfield k : I
    //   1077: istore #10
    //   1079: goto -> 949
    //   1082: aload #22
    //   1084: iload #13
    //   1086: aload_0
    //   1087: getfield a : Lcom/loc/bv;
    //   1090: iload #10
    //   1092: i2b
    //   1093: iload #11
    //   1095: invokestatic a : (Lcom/loc/er;BI)I
    //   1098: iastore
    //   1099: iload #13
    //   1101: iconst_1
    //   1102: iadd
    //   1103: istore #13
    //   1105: goto -> 858
    //   1108: aload_0
    //   1109: getfield a : Lcom/loc/bv;
    //   1112: aload #22
    //   1114: invokestatic b : (Lcom/loc/er;[I)I
    //   1117: istore #10
    //   1119: aload_0
    //   1120: getfield a : Lcom/loc/bv;
    //   1123: iload #14
    //   1125: aload_2
    //   1126: getfield a : B
    //   1129: iload #15
    //   1131: iload #10
    //   1133: invokestatic a : (Lcom/loc/er;IBII)I
    //   1136: istore #10
    //   1138: goto -> 1141
    //   1141: iconst_m1
    //   1142: istore #13
    //   1144: iload #13
    //   1146: istore #11
    //   1148: aload #5
    //   1150: ifnull -> 1356
    //   1153: iload #13
    //   1155: istore #11
    //   1157: aload #5
    //   1159: invokeinterface size : ()I
    //   1164: ifle -> 1356
    //   1167: aload #5
    //   1169: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1174: astore_1
    //   1175: aload_1
    //   1176: invokeinterface hasNext : ()Z
    //   1181: ifeq -> 1208
    //   1184: aload_1
    //   1185: invokeinterface next : ()Ljava/lang/Object;
    //   1190: checkcast com/loc/dd
    //   1193: astore_2
    //   1194: aload_2
    //   1195: aload_2
    //   1196: getfield a : J
    //   1199: invokestatic b : (J)S
    //   1202: putfield g : S
    //   1205: goto -> 1175
    //   1208: aload #5
    //   1210: invokeinterface size : ()I
    //   1215: istore #14
    //   1217: iload #13
    //   1219: istore #11
    //   1221: iload #14
    //   1223: ifle -> 1356
    //   1226: iload #14
    //   1228: newarray int
    //   1230: astore_1
    //   1231: iconst_0
    //   1232: istore #11
    //   1234: iload #11
    //   1236: iload #14
    //   1238: if_icmpge -> 1335
    //   1241: aload #5
    //   1243: iload #11
    //   1245: invokeinterface get : (I)Ljava/lang/Object;
    //   1250: checkcast com/loc/dd
    //   1253: astore_2
    //   1254: aload_0
    //   1255: getfield a : Lcom/loc/bv;
    //   1258: aload_2
    //   1259: getfield b : Ljava/lang/String;
    //   1262: invokevirtual a : (Ljava/lang/CharSequence;)I
    //   1265: istore #13
    //   1267: aload_2
    //   1268: getfield a : J
    //   1271: lload_3
    //   1272: lcmp
    //   1273: ifne -> 1495
    //   1276: aload_2
    //   1277: getfield a : J
    //   1280: ldc2_w -1
    //   1283: lcmp
    //   1284: ifeq -> 1495
    //   1287: iconst_1
    //   1288: istore #21
    //   1290: goto -> 1293
    //   1293: aload_1
    //   1294: iload #11
    //   1296: aload_0
    //   1297: getfield a : Lcom/loc/bv;
    //   1300: iload #21
    //   1302: aload_2
    //   1303: getfield a : J
    //   1306: aload_2
    //   1307: getfield c : I
    //   1310: i2s
    //   1311: iload #13
    //   1313: aload_2
    //   1314: getfield g : S
    //   1317: aload_2
    //   1318: getfield d : I
    //   1321: i2s
    //   1322: invokestatic a : (Lcom/loc/er;ZJSISS)I
    //   1325: iastore
    //   1326: iload #11
    //   1328: iconst_1
    //   1329: iadd
    //   1330: istore #11
    //   1332: goto -> 1234
    //   1335: aload_0
    //   1336: getfield a : Lcom/loc/bv;
    //   1339: aload_1
    //   1340: invokestatic a : (Lcom/loc/er;[I)I
    //   1343: istore #11
    //   1345: aload_0
    //   1346: getfield a : Lcom/loc/bv;
    //   1349: iload #11
    //   1351: invokestatic a : (Lcom/loc/er;I)I
    //   1354: istore #11
    //   1356: aload_0
    //   1357: getfield a : Lcom/loc/bv;
    //   1360: invokestatic a : (Lcom/loc/er;)V
    //   1363: aload_0
    //   1364: getfield a : Lcom/loc/bv;
    //   1367: iload #12
    //   1369: invokestatic a : (Lcom/loc/er;I)V
    //   1372: iload #10
    //   1374: ifle -> 1386
    //   1377: aload_0
    //   1378: getfield a : Lcom/loc/bv;
    //   1381: iload #10
    //   1383: invokestatic c : (Lcom/loc/er;I)V
    //   1386: iload #11
    //   1388: ifle -> 1400
    //   1391: aload_0
    //   1392: getfield a : Lcom/loc/bv;
    //   1395: iload #11
    //   1397: invokestatic b : (Lcom/loc/er;I)V
    //   1400: aload_0
    //   1401: getfield a : Lcom/loc/bv;
    //   1404: invokestatic b : (Lcom/loc/er;)I
    //   1407: istore #10
    //   1409: aload_0
    //   1410: getfield a : Lcom/loc/bv;
    //   1413: iload #10
    //   1415: invokevirtual c : (I)V
    //   1418: aload_0
    //   1419: getfield a : Lcom/loc/bv;
    //   1422: invokevirtual c : ()[B
    //   1425: astore_1
    //   1426: aload_1
    //   1427: areturn
    //   1428: astore_1
    //   1429: aload_1
    //   1430: invokestatic a : (Ljava/lang/Throwable;)V
    //   1433: aconst_null
    //   1434: areturn
    //   1435: iconst_1
    //   1436: istore #6
    //   1438: goto -> 729
    //   1441: iconst_2
    //   1442: istore #6
    //   1444: goto -> 729
    //   1447: iconst_m1
    //   1448: istore #10
    //   1450: iconst_0
    //   1451: istore #6
    //   1453: goto -> 729
    //   1456: iconst_0
    //   1457: istore #12
    //   1459: goto -> 753
    //   1462: iconst_0
    //   1463: istore #12
    //   1465: goto -> 772
    //   1468: ldc2_w 32767
    //   1471: lstore #17
    //   1473: goto -> 917
    //   1476: iconst_0
    //   1477: istore #10
    //   1479: iconst_0
    //   1480: istore #11
    //   1482: goto -> 1082
    //   1485: iload #11
    //   1487: istore #12
    //   1489: iconst_m1
    //   1490: istore #10
    //   1492: goto -> 1141
    //   1495: iconst_0
    //   1496: istore #21
    //   1498: goto -> 1293
    // Exception table:
    //   from	to	target	type
    //   5	101	1428	finally
    //   105	129	1428	finally
    //   133	142	1428	finally
    //   145	152	1428	finally
    //   152	205	1428	finally
    //   205	212	1428	finally
    //   215	248	1428	finally
    //   251	284	1428	finally
    //   287	320	1428	finally
    //   323	339	1428	finally
    //   349	417	1428	finally
    //   420	474	1428	finally
    //   477	541	1428	finally
    //   547	609	1428	finally
    //   612	656	1428	finally
    //   659	723	1428	finally
    //   739	747	1428	finally
    //   758	766	1428	finally
    //   777	802	1428	finally
    //   815	855	1428	finally
    //   865	894	1428	finally
    //   917	949	1428	finally
    //   949	963	1428	finally
    //   969	1001	1428	finally
    //   1004	1041	1428	finally
    //   1047	1079	1428	finally
    //   1082	1099	1428	finally
    //   1108	1138	1428	finally
    //   1157	1175	1428	finally
    //   1175	1205	1428	finally
    //   1208	1217	1428	finally
    //   1226	1231	1428	finally
    //   1241	1287	1428	finally
    //   1293	1326	1428	finally
    //   1335	1356	1428	finally
    //   1356	1372	1428	finally
    //   1377	1386	1428	finally
    //   1391	1400	1428	finally
    //   1400	1426	1428	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */