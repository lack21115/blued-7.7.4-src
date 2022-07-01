package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

public final class gj {
  private StringBuilder a = new StringBuilder();
  
  public final gg a(String paramString, Context paramContext, ey paramey) {
    gg gg = new gg("");
    gg.setErrorCode(7);
    try {
      JSONObject jSONObject = new JSONObject(paramString);
    } finally {
      paramString = null;
      StringBuilder stringBuilder1 = this.a;
      StringBuilder stringBuilder2 = new StringBuilder("json exception error:");
      stringBuilder2.append(paramString.getMessage());
      stringBuilder1.append(stringBuilder2.toString());
    } 
    try {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append("#SHA1AndPackage#");
      stringBuilder.append(cq.e(paramContext));
      String str = ((List<String>)paramey.b.get("gsid")).get(0);
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder1 = this.a;
        stringBuilder1.append(" #gsid#");
        stringBuilder1.append(str);
      } 
      str = paramey.c;
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder1 = this.a;
        StringBuilder stringBuilder2 = new StringBuilder(" #csid#");
        stringBuilder2.append(str);
        stringBuilder1.append(stringBuilder2.toString());
      } 
    } finally {}
    gg.setLocationDetail(this.a.toString());
    if (this.a.length() > 0) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.delete(0, stringBuilder.length());
    } 
    return gg;
  }
  
  public final gg a(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload #4
    //   5: astore #5
    //   7: new com/amap/api/mapcore2d/gg
    //   10: dup
    //   11: ldc ''
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: astore #10
    //   18: aload_1
    //   19: ifnonnull -> 85
    //   22: aload #4
    //   24: astore #5
    //   26: aload #10
    //   28: iconst_5
    //   29: invokevirtual setErrorCode : (I)V
    //   32: aload #4
    //   34: astore #5
    //   36: aload_0
    //   37: getfield a : Ljava/lang/StringBuilder;
    //   40: ldc 'byte[] is null'
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: astore #5
    //   50: aload #10
    //   52: aload_0
    //   53: getfield a : Ljava/lang/StringBuilder;
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: invokevirtual setLocationDetail : (Ljava/lang/String;)V
    //   62: aload #4
    //   64: astore #5
    //   66: aload_0
    //   67: getfield a : Ljava/lang/StringBuilder;
    //   70: iconst_0
    //   71: aload_0
    //   72: getfield a : Ljava/lang/StringBuilder;
    //   75: invokevirtual length : ()I
    //   78: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #10
    //   84: areturn
    //   85: aload #4
    //   87: astore #5
    //   89: aload_1
    //   90: invokestatic wrap : ([B)Ljava/nio/ByteBuffer;
    //   93: astore #11
    //   95: aload #11
    //   97: astore #5
    //   99: aload #11
    //   101: invokevirtual get : ()B
    //   104: ifne -> 148
    //   107: aload #11
    //   109: astore #5
    //   111: aload #10
    //   113: aload #11
    //   115: invokevirtual getShort : ()S
    //   118: invokestatic valueOf : (I)Ljava/lang/String;
    //   121: invokevirtual b : (Ljava/lang/String;)V
    //   124: aload #11
    //   126: astore #5
    //   128: aload #11
    //   130: invokevirtual clear : ()Ljava/nio/Buffer;
    //   133: pop
    //   134: aload #11
    //   136: ifnull -> 145
    //   139: aload #11
    //   141: invokevirtual clear : ()Ljava/nio/Buffer;
    //   144: pop
    //   145: aload #10
    //   147: areturn
    //   148: aload #11
    //   150: astore #5
    //   152: aload #10
    //   154: aload #11
    //   156: invokevirtual getInt : ()I
    //   159: i2d
    //   160: ldc2_w 1000000.0
    //   163: ddiv
    //   164: invokestatic a : (D)D
    //   167: invokevirtual setLongitude : (D)V
    //   170: aload #11
    //   172: astore #5
    //   174: aload #10
    //   176: aload #11
    //   178: invokevirtual getInt : ()I
    //   181: i2d
    //   182: ldc2_w 1000000.0
    //   185: ddiv
    //   186: invokestatic a : (D)D
    //   189: invokevirtual setLatitude : (D)V
    //   192: aload #11
    //   194: astore #5
    //   196: aload #10
    //   198: aload #11
    //   200: invokevirtual getShort : ()S
    //   203: i2f
    //   204: invokevirtual setAccuracy : (F)V
    //   207: aload #11
    //   209: astore #5
    //   211: aload #10
    //   213: aload #11
    //   215: invokevirtual get : ()B
    //   218: invokestatic valueOf : (I)Ljava/lang/String;
    //   221: invokevirtual c : (Ljava/lang/String;)V
    //   224: aload #11
    //   226: astore #5
    //   228: aload #10
    //   230: aload #11
    //   232: invokevirtual get : ()B
    //   235: invokestatic valueOf : (I)Ljava/lang/String;
    //   238: invokevirtual d : (Ljava/lang/String;)V
    //   241: aload #11
    //   243: astore #5
    //   245: aload #11
    //   247: invokevirtual get : ()B
    //   250: istore_2
    //   251: iload_2
    //   252: iconst_1
    //   253: if_icmpne -> 1165
    //   256: aload #11
    //   258: astore #5
    //   260: aload #11
    //   262: invokevirtual get : ()B
    //   265: sipush #255
    //   268: iand
    //   269: newarray byte
    //   271: astore_1
    //   272: aload #11
    //   274: astore #5
    //   276: aload #11
    //   278: aload_1
    //   279: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   282: pop
    //   283: aload #10
    //   285: new java/lang/String
    //   288: dup
    //   289: aload_1
    //   290: ldc 'UTF-8'
    //   292: invokespecial <init> : ([BLjava/lang/String;)V
    //   295: invokevirtual setCountry : (Ljava/lang/String;)V
    //   298: aload #11
    //   300: astore #5
    //   302: aload #11
    //   304: invokevirtual get : ()B
    //   307: sipush #255
    //   310: iand
    //   311: newarray byte
    //   313: astore_1
    //   314: aload #11
    //   316: astore #5
    //   318: aload #11
    //   320: aload_1
    //   321: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   324: pop
    //   325: new java/lang/String
    //   328: dup
    //   329: aload_1
    //   330: ldc 'UTF-8'
    //   332: invokespecial <init> : ([BLjava/lang/String;)V
    //   335: astore_1
    //   336: aload #10
    //   338: aload_1
    //   339: invokevirtual setProvince : (Ljava/lang/String;)V
    //   342: goto -> 348
    //   345: ldc ''
    //   347: astore_1
    //   348: aload #11
    //   350: astore #5
    //   352: aload #11
    //   354: invokevirtual get : ()B
    //   357: sipush #255
    //   360: iand
    //   361: newarray byte
    //   363: astore #4
    //   365: aload #11
    //   367: astore #5
    //   369: aload #11
    //   371: aload #4
    //   373: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   376: pop
    //   377: new java/lang/String
    //   380: dup
    //   381: aload #4
    //   383: ldc 'UTF-8'
    //   385: invokespecial <init> : ([BLjava/lang/String;)V
    //   388: astore #4
    //   390: aload #10
    //   392: aload #4
    //   394: invokevirtual setCity : (Ljava/lang/String;)V
    //   397: goto -> 404
    //   400: ldc ''
    //   402: astore #4
    //   404: aload #11
    //   406: astore #5
    //   408: aload #11
    //   410: invokevirtual get : ()B
    //   413: sipush #255
    //   416: iand
    //   417: newarray byte
    //   419: astore #6
    //   421: aload #11
    //   423: astore #5
    //   425: aload #11
    //   427: aload #6
    //   429: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   432: pop
    //   433: new java/lang/String
    //   436: dup
    //   437: aload #6
    //   439: ldc 'UTF-8'
    //   441: invokespecial <init> : ([BLjava/lang/String;)V
    //   444: astore #6
    //   446: aload #10
    //   448: aload #6
    //   450: invokevirtual setDistrict : (Ljava/lang/String;)V
    //   453: goto -> 460
    //   456: ldc ''
    //   458: astore #6
    //   460: aload #11
    //   462: astore #5
    //   464: aload #11
    //   466: invokevirtual get : ()B
    //   469: sipush #255
    //   472: iand
    //   473: newarray byte
    //   475: astore #7
    //   477: aload #11
    //   479: astore #5
    //   481: aload #11
    //   483: aload #7
    //   485: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   488: pop
    //   489: new java/lang/String
    //   492: dup
    //   493: aload #7
    //   495: ldc 'UTF-8'
    //   497: invokespecial <init> : ([BLjava/lang/String;)V
    //   500: astore #7
    //   502: aload #10
    //   504: aload #7
    //   506: invokevirtual setStreet : (Ljava/lang/String;)V
    //   509: aload #10
    //   511: aload #7
    //   513: invokevirtual setRoad : (Ljava/lang/String;)V
    //   516: goto -> 523
    //   519: ldc ''
    //   521: astore #7
    //   523: aload #11
    //   525: astore #5
    //   527: aload #11
    //   529: invokevirtual get : ()B
    //   532: sipush #255
    //   535: iand
    //   536: newarray byte
    //   538: astore #8
    //   540: aload #11
    //   542: astore #5
    //   544: aload #11
    //   546: aload #8
    //   548: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   551: pop
    //   552: aload #10
    //   554: new java/lang/String
    //   557: dup
    //   558: aload #8
    //   560: ldc 'UTF-8'
    //   562: invokespecial <init> : ([BLjava/lang/String;)V
    //   565: invokevirtual setNumber : (Ljava/lang/String;)V
    //   568: aload #11
    //   570: astore #5
    //   572: aload #11
    //   574: invokevirtual get : ()B
    //   577: sipush #255
    //   580: iand
    //   581: newarray byte
    //   583: astore #8
    //   585: aload #11
    //   587: astore #5
    //   589: aload #11
    //   591: aload #8
    //   593: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   596: pop
    //   597: new java/lang/String
    //   600: dup
    //   601: aload #8
    //   603: ldc 'UTF-8'
    //   605: invokespecial <init> : ([BLjava/lang/String;)V
    //   608: astore #8
    //   610: aload #10
    //   612: aload #8
    //   614: invokevirtual setPoiName : (Ljava/lang/String;)V
    //   617: goto -> 624
    //   620: ldc ''
    //   622: astore #8
    //   624: aload #11
    //   626: astore #5
    //   628: aload #11
    //   630: invokevirtual get : ()B
    //   633: sipush #255
    //   636: iand
    //   637: newarray byte
    //   639: astore #9
    //   641: aload #11
    //   643: astore #5
    //   645: aload #11
    //   647: aload #9
    //   649: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   652: pop
    //   653: aload #10
    //   655: new java/lang/String
    //   658: dup
    //   659: aload #9
    //   661: ldc 'UTF-8'
    //   663: invokespecial <init> : ([BLjava/lang/String;)V
    //   666: invokevirtual setAoiName : (Ljava/lang/String;)V
    //   669: aload #11
    //   671: astore #5
    //   673: aload #11
    //   675: invokevirtual get : ()B
    //   678: sipush #255
    //   681: iand
    //   682: newarray byte
    //   684: astore #9
    //   686: aload #11
    //   688: astore #5
    //   690: aload #11
    //   692: aload #9
    //   694: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   697: pop
    //   698: new java/lang/String
    //   701: dup
    //   702: aload #9
    //   704: ldc 'UTF-8'
    //   706: invokespecial <init> : ([BLjava/lang/String;)V
    //   709: astore #9
    //   711: aload #10
    //   713: aload #9
    //   715: invokevirtual setAdCode : (Ljava/lang/String;)V
    //   718: goto -> 725
    //   721: ldc ''
    //   723: astore #9
    //   725: aload #11
    //   727: astore #5
    //   729: aload #11
    //   731: invokevirtual get : ()B
    //   734: sipush #255
    //   737: iand
    //   738: newarray byte
    //   740: astore #12
    //   742: aload #11
    //   744: astore #5
    //   746: aload #11
    //   748: aload #12
    //   750: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   753: pop
    //   754: aload #10
    //   756: new java/lang/String
    //   759: dup
    //   760: aload #12
    //   762: ldc 'UTF-8'
    //   764: invokespecial <init> : ([BLjava/lang/String;)V
    //   767: invokevirtual setCityCode : (Ljava/lang/String;)V
    //   770: aload #11
    //   772: astore #5
    //   774: new java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial <init> : ()V
    //   781: astore #12
    //   783: aload #11
    //   785: astore #5
    //   787: aload_1
    //   788: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   791: istore_3
    //   792: iload_3
    //   793: ifne -> 819
    //   796: aload #11
    //   798: astore #5
    //   800: aload #12
    //   802: aload_1
    //   803: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload #11
    //   809: astore #5
    //   811: aload #12
    //   813: ldc ' '
    //   815: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload #11
    //   821: astore #5
    //   823: aload #4
    //   825: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   828: ifne -> 881
    //   831: aload #11
    //   833: astore #5
    //   835: aload_1
    //   836: ldc '市'
    //   838: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   841: ifeq -> 857
    //   844: aload #11
    //   846: astore #5
    //   848: aload_1
    //   849: aload #4
    //   851: invokevirtual equals : (Ljava/lang/Object;)Z
    //   854: ifne -> 881
    //   857: aload #11
    //   859: astore #5
    //   861: aload #12
    //   863: aload #4
    //   865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload #11
    //   871: astore #5
    //   873: aload #12
    //   875: ldc ' '
    //   877: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload #11
    //   883: astore #5
    //   885: aload #6
    //   887: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   890: ifne -> 917
    //   893: aload #11
    //   895: astore #5
    //   897: aload #12
    //   899: aload #6
    //   901: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload #11
    //   907: astore #5
    //   909: aload #12
    //   911: ldc ' '
    //   913: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload #11
    //   919: astore #5
    //   921: aload #7
    //   923: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   926: ifne -> 953
    //   929: aload #11
    //   931: astore #5
    //   933: aload #12
    //   935: aload #7
    //   937: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload #11
    //   943: astore #5
    //   945: aload #12
    //   947: ldc ' '
    //   949: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload #11
    //   955: astore #5
    //   957: aload #8
    //   959: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   962: ifne -> 1013
    //   965: aload #11
    //   967: astore #5
    //   969: aload #9
    //   971: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   974: ifne -> 989
    //   977: aload #11
    //   979: astore #5
    //   981: aload #12
    //   983: ldc '靠近'
    //   985: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload #11
    //   991: astore #5
    //   993: aload #12
    //   995: aload #8
    //   997: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload #11
    //   1003: astore #5
    //   1005: aload #12
    //   1007: ldc ' '
    //   1009: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload #11
    //   1015: astore #5
    //   1017: new android/os/Bundle
    //   1020: dup
    //   1021: invokespecial <init> : ()V
    //   1024: astore_1
    //   1025: aload #11
    //   1027: astore #5
    //   1029: aload_1
    //   1030: ldc 'citycode'
    //   1032: aload #10
    //   1034: invokevirtual getCityCode : ()Ljava/lang/String;
    //   1037: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1040: aload #11
    //   1042: astore #5
    //   1044: aload_1
    //   1045: ldc 'desc'
    //   1047: aload #12
    //   1049: invokevirtual toString : ()Ljava/lang/String;
    //   1052: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1055: aload #11
    //   1057: astore #5
    //   1059: aload_1
    //   1060: ldc 'adcode'
    //   1062: aload #10
    //   1064: invokevirtual getAdCode : ()Ljava/lang/String;
    //   1067: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1070: aload #11
    //   1072: astore #5
    //   1074: aload #10
    //   1076: aload_1
    //   1077: invokevirtual setExtras : (Landroid/os/Bundle;)V
    //   1080: aload #11
    //   1082: astore #5
    //   1084: aload #10
    //   1086: aload #12
    //   1088: invokevirtual toString : ()Ljava/lang/String;
    //   1091: invokevirtual e : (Ljava/lang/String;)V
    //   1094: aload #11
    //   1096: astore #5
    //   1098: aload #10
    //   1100: invokevirtual getAdCode : ()Ljava/lang/String;
    //   1103: astore_1
    //   1104: aload_1
    //   1105: ifnull -> 1152
    //   1108: aload #11
    //   1110: astore #5
    //   1112: aload_1
    //   1113: invokevirtual trim : ()Ljava/lang/String;
    //   1116: invokevirtual length : ()I
    //   1119: ifle -> 1152
    //   1122: aload #11
    //   1124: astore #5
    //   1126: aload #12
    //   1128: invokevirtual toString : ()Ljava/lang/String;
    //   1131: ldc ' '
    //   1133: ldc ''
    //   1135: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1138: astore_1
    //   1139: aload #11
    //   1141: astore #5
    //   1143: aload #10
    //   1145: aload_1
    //   1146: invokevirtual setAddress : (Ljava/lang/String;)V
    //   1149: goto -> 1165
    //   1152: aload #11
    //   1154: astore #5
    //   1156: aload #12
    //   1158: invokevirtual toString : ()Ljava/lang/String;
    //   1161: astore_1
    //   1162: goto -> 1139
    //   1165: aload #11
    //   1167: astore #5
    //   1169: aload #11
    //   1171: aload #11
    //   1173: invokevirtual get : ()B
    //   1176: sipush #255
    //   1179: iand
    //   1180: newarray byte
    //   1182: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   1185: pop
    //   1186: aload #11
    //   1188: astore #5
    //   1190: aload #11
    //   1192: invokevirtual get : ()B
    //   1195: iconst_1
    //   1196: if_icmpne -> 1229
    //   1199: aload #11
    //   1201: astore #5
    //   1203: aload #11
    //   1205: invokevirtual getInt : ()I
    //   1208: pop
    //   1209: aload #11
    //   1211: astore #5
    //   1213: aload #11
    //   1215: invokevirtual getInt : ()I
    //   1218: pop
    //   1219: aload #11
    //   1221: astore #5
    //   1223: aload #11
    //   1225: invokevirtual getShort : ()S
    //   1228: pop
    //   1229: aload #11
    //   1231: astore #5
    //   1233: aload #11
    //   1235: invokevirtual get : ()B
    //   1238: iconst_1
    //   1239: if_icmpne -> 1326
    //   1242: aload #11
    //   1244: astore #5
    //   1246: aload #11
    //   1248: invokevirtual get : ()B
    //   1251: sipush #255
    //   1254: iand
    //   1255: newarray byte
    //   1257: astore_1
    //   1258: aload #11
    //   1260: astore #5
    //   1262: aload #11
    //   1264: aload_1
    //   1265: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   1268: pop
    //   1269: aload #10
    //   1271: new java/lang/String
    //   1274: dup
    //   1275: aload_1
    //   1276: ldc 'UTF-8'
    //   1278: invokespecial <init> : ([BLjava/lang/String;)V
    //   1281: invokevirtual setBuildingId : (Ljava/lang/String;)V
    //   1284: aload #11
    //   1286: astore #5
    //   1288: aload #11
    //   1290: invokevirtual get : ()B
    //   1293: sipush #255
    //   1296: iand
    //   1297: newarray byte
    //   1299: astore_1
    //   1300: aload #11
    //   1302: astore #5
    //   1304: aload #11
    //   1306: aload_1
    //   1307: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   1310: pop
    //   1311: aload #10
    //   1313: new java/lang/String
    //   1316: dup
    //   1317: aload_1
    //   1318: ldc 'UTF-8'
    //   1320: invokespecial <init> : ([BLjava/lang/String;)V
    //   1323: invokevirtual setFloor : (Ljava/lang/String;)V
    //   1326: aload #11
    //   1328: astore #5
    //   1330: aload #11
    //   1332: invokevirtual get : ()B
    //   1335: iconst_1
    //   1336: if_icmpne -> 1369
    //   1339: aload #11
    //   1341: astore #5
    //   1343: aload #11
    //   1345: invokevirtual get : ()B
    //   1348: pop
    //   1349: aload #11
    //   1351: astore #5
    //   1353: aload #11
    //   1355: invokevirtual getInt : ()I
    //   1358: pop
    //   1359: aload #11
    //   1361: astore #5
    //   1363: aload #11
    //   1365: invokevirtual get : ()B
    //   1368: pop
    //   1369: aload #11
    //   1371: astore #5
    //   1373: aload #11
    //   1375: invokevirtual get : ()B
    //   1378: iconst_1
    //   1379: if_icmpne -> 1396
    //   1382: aload #11
    //   1384: astore #5
    //   1386: aload #10
    //   1388: aload #11
    //   1390: invokevirtual getLong : ()J
    //   1393: invokevirtual setTime : (J)V
    //   1396: aload #11
    //   1398: astore #5
    //   1400: aload #11
    //   1402: invokevirtual getShort : ()S
    //   1405: newarray byte
    //   1407: astore_1
    //   1408: aload #11
    //   1410: astore #5
    //   1412: aload #11
    //   1414: aload_1
    //   1415: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   1418: pop
    //   1419: aload #10
    //   1421: new java/lang/String
    //   1424: dup
    //   1425: aload_1
    //   1426: ldc 'UTF-8'
    //   1428: invokespecial <init> : ([BLjava/lang/String;)V
    //   1431: invokevirtual a : (Ljava/lang/String;)V
    //   1434: goto -> 1437
    //   1437: aload #10
    //   1439: astore_1
    //   1440: aload #11
    //   1442: ifnull -> 1536
    //   1445: aload #11
    //   1447: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1450: pop
    //   1451: aload #10
    //   1453: astore_1
    //   1454: goto -> 1536
    //   1457: astore #4
    //   1459: new com/amap/api/mapcore2d/gg
    //   1462: dup
    //   1463: ldc ''
    //   1465: invokespecial <init> : (Ljava/lang/String;)V
    //   1468: astore_1
    //   1469: aload_1
    //   1470: iconst_5
    //   1471: invokevirtual setErrorCode : (I)V
    //   1474: aload_0
    //   1475: getfield a : Ljava/lang/StringBuilder;
    //   1478: astore #6
    //   1480: new java/lang/StringBuilder
    //   1483: dup
    //   1484: ldc_w 'parser data error:'
    //   1487: invokespecial <init> : (Ljava/lang/String;)V
    //   1490: astore #7
    //   1492: aload #7
    //   1494: aload #4
    //   1496: invokevirtual getMessage : ()Ljava/lang/String;
    //   1499: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: pop
    //   1503: aload #6
    //   1505: aload #7
    //   1507: invokevirtual toString : ()Ljava/lang/String;
    //   1510: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: pop
    //   1514: aload_1
    //   1515: aload_0
    //   1516: getfield a : Ljava/lang/StringBuilder;
    //   1519: invokevirtual toString : ()Ljava/lang/String;
    //   1522: invokevirtual setLocationDetail : (Ljava/lang/String;)V
    //   1525: aload #5
    //   1527: ifnull -> 1536
    //   1530: aload #5
    //   1532: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1535: pop
    //   1536: aload_0
    //   1537: getfield a : Ljava/lang/StringBuilder;
    //   1540: invokevirtual length : ()I
    //   1543: ifle -> 1564
    //   1546: aload_0
    //   1547: getfield a : Ljava/lang/StringBuilder;
    //   1550: astore #4
    //   1552: aload #4
    //   1554: iconst_0
    //   1555: aload #4
    //   1557: invokevirtual length : ()I
    //   1560: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload_1
    //   1565: areturn
    //   1566: astore_1
    //   1567: aload #5
    //   1569: ifnull -> 1578
    //   1572: aload #5
    //   1574: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1577: pop
    //   1578: aload_1
    //   1579: athrow
    //   1580: astore_1
    //   1581: goto -> 298
    //   1584: astore_1
    //   1585: goto -> 345
    //   1588: astore #4
    //   1590: goto -> 348
    //   1593: astore #4
    //   1595: goto -> 400
    //   1598: astore #5
    //   1600: goto -> 404
    //   1603: astore #5
    //   1605: goto -> 456
    //   1608: astore #5
    //   1610: goto -> 460
    //   1613: astore #5
    //   1615: goto -> 519
    //   1618: astore #5
    //   1620: goto -> 523
    //   1623: astore #5
    //   1625: goto -> 568
    //   1628: astore #5
    //   1630: goto -> 620
    //   1633: astore #5
    //   1635: goto -> 624
    //   1638: astore #5
    //   1640: goto -> 669
    //   1643: astore #5
    //   1645: goto -> 721
    //   1648: astore #5
    //   1650: goto -> 725
    //   1653: astore #5
    //   1655: goto -> 770
    //   1658: astore_1
    //   1659: goto -> 1284
    //   1662: astore_1
    //   1663: goto -> 1326
    //   1666: astore_1
    //   1667: goto -> 1437
    // Exception table:
    //   from	to	target	type
    //   7	18	1457	finally
    //   26	32	1457	finally
    //   36	46	1457	finally
    //   50	62	1457	finally
    //   66	82	1457	finally
    //   89	95	1457	finally
    //   99	107	1457	finally
    //   111	124	1457	finally
    //   128	134	1457	finally
    //   152	170	1457	finally
    //   174	192	1457	finally
    //   196	207	1457	finally
    //   211	224	1457	finally
    //   228	241	1457	finally
    //   245	251	1457	finally
    //   260	272	1457	finally
    //   276	283	1457	finally
    //   283	298	1580	finally
    //   302	314	1457	finally
    //   318	325	1457	finally
    //   325	336	1584	finally
    //   336	342	1588	finally
    //   352	365	1457	finally
    //   369	377	1457	finally
    //   377	390	1593	finally
    //   390	397	1598	finally
    //   408	421	1457	finally
    //   425	433	1457	finally
    //   433	446	1603	finally
    //   446	453	1608	finally
    //   464	477	1457	finally
    //   481	489	1457	finally
    //   489	502	1613	finally
    //   502	516	1618	finally
    //   527	540	1457	finally
    //   544	552	1457	finally
    //   552	568	1623	finally
    //   572	585	1457	finally
    //   589	597	1457	finally
    //   597	610	1628	finally
    //   610	617	1633	finally
    //   628	641	1457	finally
    //   645	653	1457	finally
    //   653	669	1638	finally
    //   673	686	1457	finally
    //   690	698	1457	finally
    //   698	711	1643	finally
    //   711	718	1648	finally
    //   729	742	1457	finally
    //   746	754	1457	finally
    //   754	770	1653	finally
    //   774	783	1457	finally
    //   787	792	1457	finally
    //   800	807	1457	finally
    //   811	819	1457	finally
    //   823	831	1457	finally
    //   835	844	1457	finally
    //   848	857	1457	finally
    //   861	869	1457	finally
    //   873	881	1457	finally
    //   885	893	1457	finally
    //   897	905	1457	finally
    //   909	917	1457	finally
    //   921	929	1457	finally
    //   933	941	1457	finally
    //   945	953	1457	finally
    //   957	965	1457	finally
    //   969	977	1457	finally
    //   981	989	1457	finally
    //   993	1001	1457	finally
    //   1005	1013	1457	finally
    //   1017	1025	1457	finally
    //   1029	1040	1457	finally
    //   1044	1055	1457	finally
    //   1059	1070	1457	finally
    //   1074	1080	1457	finally
    //   1084	1094	1457	finally
    //   1098	1104	1457	finally
    //   1112	1122	1457	finally
    //   1126	1139	1457	finally
    //   1143	1149	1457	finally
    //   1156	1162	1457	finally
    //   1169	1186	1457	finally
    //   1190	1199	1457	finally
    //   1203	1209	1457	finally
    //   1213	1219	1457	finally
    //   1223	1229	1457	finally
    //   1233	1242	1457	finally
    //   1246	1258	1457	finally
    //   1262	1269	1457	finally
    //   1269	1284	1658	finally
    //   1288	1300	1457	finally
    //   1304	1311	1457	finally
    //   1311	1326	1662	finally
    //   1330	1339	1457	finally
    //   1343	1349	1457	finally
    //   1353	1359	1457	finally
    //   1363	1369	1457	finally
    //   1373	1382	1457	finally
    //   1386	1396	1457	finally
    //   1400	1408	1457	finally
    //   1412	1419	1457	finally
    //   1419	1434	1666	finally
    //   1459	1525	1566	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */