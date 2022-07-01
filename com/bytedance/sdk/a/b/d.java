package com.bytedance.sdk.a.b;

import java.util.concurrent.TimeUnit;

public final class d {
  public static final d a = (new a()).a().c();
  
  public static final d b = (new a()).b().a(2147483647, TimeUnit.SECONDS).c();
  
  String c;
  
  private final boolean d;
  
  private final boolean e;
  
  private final int f;
  
  private final int g;
  
  private final boolean h;
  
  private final boolean i;
  
  private final boolean j;
  
  private final int k;
  
  private final int l;
  
  private final boolean m;
  
  private final boolean n;
  
  private final boolean o;
  
  d(a parama) {
    this.d = parama.a;
    this.e = parama.b;
    this.f = parama.c;
    this.g = -1;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = parama.d;
    this.l = parama.e;
    this.m = parama.f;
    this.n = parama.g;
    this.o = parama.h;
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, String paramString) {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
    this.j = paramBoolean5;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramBoolean6;
    this.n = paramBoolean7;
    this.o = paramBoolean8;
    this.c = paramString;
  }
  
  public static d a(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual a : ()I
    //   4: istore #13
    //   6: iconst_0
    //   7: istore #7
    //   9: iconst_1
    //   10: istore_2
    //   11: aconst_null
    //   12: astore #30
    //   14: iconst_0
    //   15: istore #21
    //   17: iconst_0
    //   18: istore #20
    //   20: iconst_m1
    //   21: istore #6
    //   23: iconst_m1
    //   24: istore #5
    //   26: iconst_0
    //   27: istore #19
    //   29: iconst_0
    //   30: istore #18
    //   32: iconst_0
    //   33: istore #17
    //   35: iconst_m1
    //   36: istore #4
    //   38: iconst_m1
    //   39: istore_3
    //   40: iconst_0
    //   41: istore #16
    //   43: iconst_0
    //   44: istore #14
    //   46: iconst_0
    //   47: istore #15
    //   49: aload_0
    //   50: astore #31
    //   52: iload #7
    //   54: iload #13
    //   56: if_icmpge -> 1225
    //   59: aload #31
    //   61: iload #7
    //   63: invokevirtual a : (I)Ljava/lang/String;
    //   66: astore #33
    //   68: aload #31
    //   70: iload #7
    //   72: invokevirtual b : (I)Ljava/lang/String;
    //   75: astore #32
    //   77: aload #33
    //   79: ldc 'Cache-Control'
    //   81: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   84: ifeq -> 102
    //   87: aload #30
    //   89: ifnull -> 95
    //   92: goto -> 165
    //   95: aload #32
    //   97: astore #30
    //   99: goto -> 167
    //   102: iload_2
    //   103: istore #12
    //   105: aload #30
    //   107: astore #31
    //   109: iload #21
    //   111: istore #22
    //   113: iload #20
    //   115: istore #23
    //   117: iload #6
    //   119: istore_1
    //   120: iload #5
    //   122: istore #8
    //   124: iload #19
    //   126: istore #24
    //   128: iload #18
    //   130: istore #25
    //   132: iload #17
    //   134: istore #26
    //   136: iload #4
    //   138: istore #9
    //   140: iload_3
    //   141: istore #10
    //   143: iload #16
    //   145: istore #27
    //   147: iload #14
    //   149: istore #28
    //   151: iload #15
    //   153: istore #29
    //   155: aload #33
    //   157: ldc 'Pragma'
    //   159: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   162: ifeq -> 1163
    //   165: iconst_0
    //   166: istore_2
    //   167: iconst_0
    //   168: istore #11
    //   170: iload_2
    //   171: istore #12
    //   173: aload #30
    //   175: astore #31
    //   177: iload #21
    //   179: istore #22
    //   181: iload #20
    //   183: istore #23
    //   185: iload #6
    //   187: istore_1
    //   188: iload #5
    //   190: istore #8
    //   192: iload #19
    //   194: istore #24
    //   196: iload #18
    //   198: istore #25
    //   200: iload #17
    //   202: istore #26
    //   204: iload #4
    //   206: istore #9
    //   208: iload_3
    //   209: istore #10
    //   211: iload #16
    //   213: istore #27
    //   215: iload #14
    //   217: istore #28
    //   219: iload #15
    //   221: istore #29
    //   223: iload #11
    //   225: aload #32
    //   227: invokevirtual length : ()I
    //   230: if_icmpge -> 1163
    //   233: aload #32
    //   235: iload #11
    //   237: ldc '=,;'
    //   239: invokestatic a : (Ljava/lang/String;ILjava/lang/String;)I
    //   242: istore_1
    //   243: aload #32
    //   245: iload #11
    //   247: iload_1
    //   248: invokevirtual substring : (II)Ljava/lang/String;
    //   251: invokevirtual trim : ()Ljava/lang/String;
    //   254: astore #33
    //   256: iload_1
    //   257: aload #32
    //   259: invokevirtual length : ()I
    //   262: if_icmpeq -> 381
    //   265: aload #32
    //   267: iload_1
    //   268: invokevirtual charAt : (I)C
    //   271: bipush #44
    //   273: if_icmpeq -> 381
    //   276: aload #32
    //   278: iload_1
    //   279: invokevirtual charAt : (I)C
    //   282: bipush #59
    //   284: if_icmpne -> 290
    //   287: goto -> 381
    //   290: aload #32
    //   292: iload_1
    //   293: iconst_1
    //   294: iadd
    //   295: invokestatic a : (Ljava/lang/String;I)I
    //   298: istore #8
    //   300: iload #8
    //   302: aload #32
    //   304: invokevirtual length : ()I
    //   307: if_icmpge -> 355
    //   310: aload #32
    //   312: iload #8
    //   314: invokevirtual charAt : (I)C
    //   317: bipush #34
    //   319: if_icmpne -> 355
    //   322: iload #8
    //   324: iconst_1
    //   325: iadd
    //   326: istore_1
    //   327: aload #32
    //   329: iload_1
    //   330: ldc '"'
    //   332: invokestatic a : (Ljava/lang/String;ILjava/lang/String;)I
    //   335: istore #8
    //   337: aload #32
    //   339: iload_1
    //   340: iload #8
    //   342: invokevirtual substring : (II)Ljava/lang/String;
    //   345: astore #31
    //   347: iload #8
    //   349: iconst_1
    //   350: iadd
    //   351: istore_1
    //   352: goto -> 388
    //   355: aload #32
    //   357: iload #8
    //   359: ldc ',;'
    //   361: invokestatic a : (Ljava/lang/String;ILjava/lang/String;)I
    //   364: istore_1
    //   365: aload #32
    //   367: iload #8
    //   369: iload_1
    //   370: invokevirtual substring : (II)Ljava/lang/String;
    //   373: invokevirtual trim : ()Ljava/lang/String;
    //   376: astore #31
    //   378: goto -> 388
    //   381: iload_1
    //   382: iconst_1
    //   383: iadd
    //   384: istore_1
    //   385: aconst_null
    //   386: astore #31
    //   388: ldc 'no-cache'
    //   390: aload #33
    //   392: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   395: ifeq -> 443
    //   398: iconst_1
    //   399: istore #22
    //   401: iload #20
    //   403: istore #23
    //   405: iload #6
    //   407: istore #8
    //   409: iload #5
    //   411: istore #9
    //   413: iload #19
    //   415: istore #24
    //   417: iload #18
    //   419: istore #25
    //   421: iload #17
    //   423: istore #26
    //   425: iload #4
    //   427: istore #10
    //   429: iload_3
    //   430: istore #12
    //   432: iload #16
    //   434: istore #27
    //   436: iload #14
    //   438: istore #28
    //   440: goto -> 1114
    //   443: ldc 'no-store'
    //   445: aload #33
    //   447: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   450: ifeq -> 498
    //   453: iconst_1
    //   454: istore #23
    //   456: iload #21
    //   458: istore #22
    //   460: iload #6
    //   462: istore #8
    //   464: iload #5
    //   466: istore #9
    //   468: iload #19
    //   470: istore #24
    //   472: iload #18
    //   474: istore #25
    //   476: iload #17
    //   478: istore #26
    //   480: iload #4
    //   482: istore #10
    //   484: iload_3
    //   485: istore #12
    //   487: iload #16
    //   489: istore #27
    //   491: iload #14
    //   493: istore #28
    //   495: goto -> 1114
    //   498: ldc 'max-age'
    //   500: aload #33
    //   502: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   505: ifeq -> 558
    //   508: aload #31
    //   510: iconst_m1
    //   511: invokestatic b : (Ljava/lang/String;I)I
    //   514: istore #8
    //   516: iload #21
    //   518: istore #22
    //   520: iload #20
    //   522: istore #23
    //   524: iload #5
    //   526: istore #9
    //   528: iload #19
    //   530: istore #24
    //   532: iload #18
    //   534: istore #25
    //   536: iload #17
    //   538: istore #26
    //   540: iload #4
    //   542: istore #10
    //   544: iload_3
    //   545: istore #12
    //   547: iload #16
    //   549: istore #27
    //   551: iload #14
    //   553: istore #28
    //   555: goto -> 1114
    //   558: ldc 's-maxage'
    //   560: aload #33
    //   562: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   565: ifeq -> 618
    //   568: aload #31
    //   570: iconst_m1
    //   571: invokestatic b : (Ljava/lang/String;I)I
    //   574: istore #9
    //   576: iload #21
    //   578: istore #22
    //   580: iload #20
    //   582: istore #23
    //   584: iload #6
    //   586: istore #8
    //   588: iload #19
    //   590: istore #24
    //   592: iload #18
    //   594: istore #25
    //   596: iload #17
    //   598: istore #26
    //   600: iload #4
    //   602: istore #10
    //   604: iload_3
    //   605: istore #12
    //   607: iload #16
    //   609: istore #27
    //   611: iload #14
    //   613: istore #28
    //   615: goto -> 1114
    //   618: ldc 'private'
    //   620: aload #33
    //   622: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   625: ifeq -> 673
    //   628: iconst_1
    //   629: istore #24
    //   631: iload #21
    //   633: istore #22
    //   635: iload #20
    //   637: istore #23
    //   639: iload #6
    //   641: istore #8
    //   643: iload #5
    //   645: istore #9
    //   647: iload #18
    //   649: istore #25
    //   651: iload #17
    //   653: istore #26
    //   655: iload #4
    //   657: istore #10
    //   659: iload_3
    //   660: istore #12
    //   662: iload #16
    //   664: istore #27
    //   666: iload #14
    //   668: istore #28
    //   670: goto -> 1114
    //   673: ldc 'public'
    //   675: aload #33
    //   677: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   680: ifeq -> 728
    //   683: iconst_1
    //   684: istore #25
    //   686: iload #21
    //   688: istore #22
    //   690: iload #20
    //   692: istore #23
    //   694: iload #6
    //   696: istore #8
    //   698: iload #5
    //   700: istore #9
    //   702: iload #19
    //   704: istore #24
    //   706: iload #17
    //   708: istore #26
    //   710: iload #4
    //   712: istore #10
    //   714: iload_3
    //   715: istore #12
    //   717: iload #16
    //   719: istore #27
    //   721: iload #14
    //   723: istore #28
    //   725: goto -> 1114
    //   728: ldc 'must-revalidate'
    //   730: aload #33
    //   732: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   735: ifeq -> 783
    //   738: iconst_1
    //   739: istore #26
    //   741: iload #21
    //   743: istore #22
    //   745: iload #20
    //   747: istore #23
    //   749: iload #6
    //   751: istore #8
    //   753: iload #5
    //   755: istore #9
    //   757: iload #19
    //   759: istore #24
    //   761: iload #18
    //   763: istore #25
    //   765: iload #4
    //   767: istore #10
    //   769: iload_3
    //   770: istore #12
    //   772: iload #16
    //   774: istore #27
    //   776: iload #14
    //   778: istore #28
    //   780: goto -> 1114
    //   783: ldc 'max-stale'
    //   785: aload #33
    //   787: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   790: ifeq -> 844
    //   793: aload #31
    //   795: ldc 2147483647
    //   797: invokestatic b : (Ljava/lang/String;I)I
    //   800: istore #10
    //   802: iload #21
    //   804: istore #22
    //   806: iload #20
    //   808: istore #23
    //   810: iload #6
    //   812: istore #8
    //   814: iload #5
    //   816: istore #9
    //   818: iload #19
    //   820: istore #24
    //   822: iload #18
    //   824: istore #25
    //   826: iload #17
    //   828: istore #26
    //   830: iload_3
    //   831: istore #12
    //   833: iload #16
    //   835: istore #27
    //   837: iload #14
    //   839: istore #28
    //   841: goto -> 1114
    //   844: ldc 'min-fresh'
    //   846: aload #33
    //   848: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   851: ifeq -> 905
    //   854: aload #31
    //   856: iconst_m1
    //   857: invokestatic b : (Ljava/lang/String;I)I
    //   860: istore #12
    //   862: iload #21
    //   864: istore #22
    //   866: iload #20
    //   868: istore #23
    //   870: iload #6
    //   872: istore #8
    //   874: iload #5
    //   876: istore #9
    //   878: iload #19
    //   880: istore #24
    //   882: iload #18
    //   884: istore #25
    //   886: iload #17
    //   888: istore #26
    //   890: iload #4
    //   892: istore #10
    //   894: iload #16
    //   896: istore #27
    //   898: iload #14
    //   900: istore #28
    //   902: goto -> 1114
    //   905: ldc 'only-if-cached'
    //   907: aload #33
    //   909: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   912: ifeq -> 960
    //   915: iconst_1
    //   916: istore #27
    //   918: iload #21
    //   920: istore #22
    //   922: iload #20
    //   924: istore #23
    //   926: iload #6
    //   928: istore #8
    //   930: iload #5
    //   932: istore #9
    //   934: iload #19
    //   936: istore #24
    //   938: iload #18
    //   940: istore #25
    //   942: iload #17
    //   944: istore #26
    //   946: iload #4
    //   948: istore #10
    //   950: iload_3
    //   951: istore #12
    //   953: iload #14
    //   955: istore #28
    //   957: goto -> 1114
    //   960: ldc 'no-transform'
    //   962: aload #33
    //   964: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   967: ifeq -> 1015
    //   970: iconst_1
    //   971: istore #28
    //   973: iload #21
    //   975: istore #22
    //   977: iload #20
    //   979: istore #23
    //   981: iload #6
    //   983: istore #8
    //   985: iload #5
    //   987: istore #9
    //   989: iload #19
    //   991: istore #24
    //   993: iload #18
    //   995: istore #25
    //   997: iload #17
    //   999: istore #26
    //   1001: iload #4
    //   1003: istore #10
    //   1005: iload_3
    //   1006: istore #12
    //   1008: iload #16
    //   1010: istore #27
    //   1012: goto -> 1114
    //   1015: iload #21
    //   1017: istore #22
    //   1019: iload #20
    //   1021: istore #23
    //   1023: iload #6
    //   1025: istore #8
    //   1027: iload #5
    //   1029: istore #9
    //   1031: iload #19
    //   1033: istore #24
    //   1035: iload #18
    //   1037: istore #25
    //   1039: iload #17
    //   1041: istore #26
    //   1043: iload #4
    //   1045: istore #10
    //   1047: iload_3
    //   1048: istore #12
    //   1050: iload #16
    //   1052: istore #27
    //   1054: iload #14
    //   1056: istore #28
    //   1058: ldc 'immutable'
    //   1060: aload #33
    //   1062: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   1065: ifeq -> 1114
    //   1068: iconst_1
    //   1069: istore #15
    //   1071: iload #14
    //   1073: istore #28
    //   1075: iload #16
    //   1077: istore #27
    //   1079: iload_3
    //   1080: istore #12
    //   1082: iload #4
    //   1084: istore #10
    //   1086: iload #17
    //   1088: istore #26
    //   1090: iload #18
    //   1092: istore #25
    //   1094: iload #19
    //   1096: istore #24
    //   1098: iload #5
    //   1100: istore #9
    //   1102: iload #6
    //   1104: istore #8
    //   1106: iload #20
    //   1108: istore #23
    //   1110: iload #21
    //   1112: istore #22
    //   1114: iload_1
    //   1115: istore #11
    //   1117: iload #22
    //   1119: istore #21
    //   1121: iload #23
    //   1123: istore #20
    //   1125: iload #8
    //   1127: istore #6
    //   1129: iload #9
    //   1131: istore #5
    //   1133: iload #24
    //   1135: istore #19
    //   1137: iload #25
    //   1139: istore #18
    //   1141: iload #26
    //   1143: istore #17
    //   1145: iload #10
    //   1147: istore #4
    //   1149: iload #12
    //   1151: istore_3
    //   1152: iload #27
    //   1154: istore #16
    //   1156: iload #28
    //   1158: istore #14
    //   1160: goto -> 170
    //   1163: iload #7
    //   1165: iconst_1
    //   1166: iadd
    //   1167: istore #7
    //   1169: iload #12
    //   1171: istore_2
    //   1172: aload #31
    //   1174: astore #30
    //   1176: iload #22
    //   1178: istore #21
    //   1180: iload #23
    //   1182: istore #20
    //   1184: iload_1
    //   1185: istore #6
    //   1187: iload #8
    //   1189: istore #5
    //   1191: iload #24
    //   1193: istore #19
    //   1195: iload #25
    //   1197: istore #18
    //   1199: iload #26
    //   1201: istore #17
    //   1203: iload #9
    //   1205: istore #4
    //   1207: iload #10
    //   1209: istore_3
    //   1210: iload #27
    //   1212: istore #16
    //   1214: iload #28
    //   1216: istore #14
    //   1218: iload #29
    //   1220: istore #15
    //   1222: goto -> 49
    //   1225: iload_2
    //   1226: ifne -> 1235
    //   1229: aconst_null
    //   1230: astore #30
    //   1232: goto -> 1235
    //   1235: new com/bytedance/sdk/a/b/d
    //   1238: dup
    //   1239: iload #21
    //   1241: iload #20
    //   1243: iload #6
    //   1245: iload #5
    //   1247: iload #19
    //   1249: iload #18
    //   1251: iload #17
    //   1253: iload #4
    //   1255: iload_3
    //   1256: iload #16
    //   1258: iload #14
    //   1260: iload #15
    //   1262: aload #30
    //   1264: invokespecial <init> : (ZZIIZZZIIZZZLjava/lang/String;)V
    //   1267: areturn
  }
  
  private String k() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.d)
      stringBuilder.append("no-cache, "); 
    if (this.e)
      stringBuilder.append("no-store, "); 
    if (this.f != -1) {
      stringBuilder.append("max-age=");
      stringBuilder.append(this.f);
      stringBuilder.append(", ");
    } 
    if (this.g != -1) {
      stringBuilder.append("s-maxage=");
      stringBuilder.append(this.g);
      stringBuilder.append(", ");
    } 
    if (this.h)
      stringBuilder.append("private, "); 
    if (this.i)
      stringBuilder.append("public, "); 
    if (this.j)
      stringBuilder.append("must-revalidate, "); 
    if (this.k != -1) {
      stringBuilder.append("max-stale=");
      stringBuilder.append(this.k);
      stringBuilder.append(", ");
    } 
    if (this.l != -1) {
      stringBuilder.append("min-fresh=");
      stringBuilder.append(this.l);
      stringBuilder.append(", ");
    } 
    if (this.m)
      stringBuilder.append("only-if-cached, "); 
    if (this.n)
      stringBuilder.append("no-transform, "); 
    if (this.o)
      stringBuilder.append("immutable, "); 
    if (stringBuilder.length() == 0)
      return ""; 
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    return stringBuilder.toString();
  }
  
  public boolean a() {
    return this.d;
  }
  
  public boolean b() {
    return this.e;
  }
  
  public int c() {
    return this.f;
  }
  
  public boolean d() {
    return this.h;
  }
  
  public boolean e() {
    return this.i;
  }
  
  public boolean f() {
    return this.j;
  }
  
  public int g() {
    return this.k;
  }
  
  public int h() {
    return this.l;
  }
  
  public boolean i() {
    return this.m;
  }
  
  public boolean j() {
    return this.o;
  }
  
  public String toString() {
    String str = this.c;
    if (str != null)
      return str; 
    str = k();
    this.c = str;
    return str;
  }
  
  public static final class a {
    boolean a;
    
    boolean b;
    
    int c = -1;
    
    int d = -1;
    
    int e = -1;
    
    boolean f;
    
    boolean g;
    
    boolean h;
    
    public a a() {
      this.a = true;
      return this;
    }
    
    public a a(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.d = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxStale < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public a b() {
      this.f = true;
      return this;
    }
    
    public d c() {
      return new d(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */