package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class eg {
  private StringBuilder a = new StringBuilder();
  
  private AMapLocationClientOption b = new AMapLocationClientOption();
  
  private void a(ds paramds, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      stringBuilder.append(paramString1);
      stringBuilder.append(" ");
    } 
    if (!TextUtils.isEmpty(paramString2) && ((this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) ? !paramString2.equals(paramString1) : (!paramString1.contains("市") || !paramString1.equals(paramString2)))) {
      stringBuilder.append(paramString2);
      stringBuilder.append(" ");
    } 
    if (!TextUtils.isEmpty(paramString3)) {
      stringBuilder.append(paramString3);
      stringBuilder.append(" ");
    } 
    if (!TextUtils.isEmpty(paramString4)) {
      stringBuilder.append(paramString4);
      stringBuilder.append(" ");
    } 
    if (!TextUtils.isEmpty(paramString5)) {
      stringBuilder.append(paramString5);
      stringBuilder.append(" ");
    } 
    if (!TextUtils.isEmpty(paramString6)) {
      StringBuilder stringBuilder1;
      if (!TextUtils.isEmpty(paramString7) && this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
        stringBuilder.append("靠近");
        stringBuilder.append(paramString6);
        stringBuilder.append(" ");
        stringBuilder1 = new StringBuilder("在");
        stringBuilder1.append(paramString6);
        stringBuilder1.append("附近");
      } else {
        stringBuilder1 = new StringBuilder("Near ");
        stringBuilder1.append(paramString6);
        stringBuilder.append(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder("Near ");
        stringBuilder1.append(paramString6);
      } 
      paramds.setDescription(stringBuilder1.toString());
    } 
    Bundle bundle = new Bundle();
    bundle.putString("citycode", paramds.getCityCode());
    bundle.putString("desc", stringBuilder.toString());
    bundle.putString("adcode", paramds.getAdCode());
    paramds.setExtras(bundle);
    paramds.g(stringBuilder.toString());
    String str = paramds.getAdCode();
    if (str != null && str.trim().length() > 0 && this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
      str = stringBuilder.toString().replace(" ", "");
    } else {
      str = stringBuilder.toString();
    } 
    paramds.setAddress(str);
  }
  
  private static String b(String paramString) {
    String str = paramString;
    if ("[]".equals(paramString))
      str = ""; 
    return str;
  }
  
  public final ds a(ds paramds, byte[] paramArrayOfbyte, dm paramdm) {
    // Byte code:
    //   0: aload_1
    //   1: astore #6
    //   3: aload_2
    //   4: ifnonnull -> 60
    //   7: aload #6
    //   9: iconst_5
    //   10: invokevirtual setErrorCode : (I)V
    //   13: aload_3
    //   14: ldc '#0504'
    //   16: invokevirtual f : (Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield a : Ljava/lang/StringBuilder;
    //   23: ldc 'binaryResult is null#0504'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload #6
    //   31: aload_0
    //   32: getfield a : Ljava/lang/StringBuilder;
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: invokevirtual setLocationDetail : (Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield a : Ljava/lang/StringBuilder;
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield a : Ljava/lang/StringBuilder;
    //   50: invokevirtual length : ()I
    //   53: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #6
    //   59: areturn
    //   60: aload_2
    //   61: invokestatic wrap : ([B)Ljava/nio/ByteBuffer;
    //   64: astore_2
    //   65: aload_2
    //   66: invokevirtual get : ()B
    //   69: ifne -> 101
    //   72: aload #6
    //   74: aload_2
    //   75: invokevirtual getShort : ()S
    //   78: invokestatic valueOf : (I)Ljava/lang/String;
    //   81: invokevirtual b : (Ljava/lang/String;)V
    //   84: aload_2
    //   85: invokevirtual clear : ()Ljava/nio/Buffer;
    //   88: pop
    //   89: aload_2
    //   90: ifnull -> 98
    //   93: aload_2
    //   94: invokevirtual clear : ()Ljava/nio/Buffer;
    //   97: pop
    //   98: aload #6
    //   100: areturn
    //   101: aload #6
    //   103: aload_2
    //   104: invokevirtual getInt : ()I
    //   107: i2d
    //   108: ldc2_w 1000000.0
    //   111: ddiv
    //   112: invokestatic a : (D)D
    //   115: invokevirtual setLongitude : (D)V
    //   118: aload #6
    //   120: aload_2
    //   121: invokevirtual getInt : ()I
    //   124: i2d
    //   125: ldc2_w 1000000.0
    //   128: ddiv
    //   129: invokestatic a : (D)D
    //   132: invokevirtual setLatitude : (D)V
    //   135: aload #6
    //   137: aload_2
    //   138: invokevirtual getShort : ()S
    //   141: i2f
    //   142: invokevirtual setAccuracy : (F)V
    //   145: aload #6
    //   147: aload_2
    //   148: invokevirtual get : ()B
    //   151: invokestatic valueOf : (I)Ljava/lang/String;
    //   154: invokevirtual c : (Ljava/lang/String;)V
    //   157: aload #6
    //   159: aload_2
    //   160: invokevirtual get : ()B
    //   163: invokestatic valueOf : (I)Ljava/lang/String;
    //   166: invokevirtual d : (Ljava/lang/String;)V
    //   169: aload_2
    //   170: invokevirtual get : ()B
    //   173: istore #4
    //   175: iload #4
    //   177: iconst_1
    //   178: if_icmpne -> 1213
    //   181: aload_2
    //   182: invokevirtual get : ()B
    //   185: sipush #255
    //   188: iand
    //   189: newarray byte
    //   191: astore #7
    //   193: aload_2
    //   194: aload #7
    //   196: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   199: pop
    //   200: aload #6
    //   202: new java/lang/String
    //   205: dup
    //   206: aload #7
    //   208: ldc 'UTF-8'
    //   210: invokespecial <init> : ([BLjava/lang/String;)V
    //   213: invokevirtual setCountry : (Ljava/lang/String;)V
    //   216: aload_2
    //   217: invokevirtual get : ()B
    //   220: sipush #255
    //   223: iand
    //   224: newarray byte
    //   226: astore #7
    //   228: aload_2
    //   229: aload #7
    //   231: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   234: pop
    //   235: new java/lang/String
    //   238: dup
    //   239: aload #7
    //   241: ldc 'UTF-8'
    //   243: invokespecial <init> : ([BLjava/lang/String;)V
    //   246: astore #7
    //   248: aload #6
    //   250: aload #7
    //   252: invokevirtual setProvince : (Ljava/lang/String;)V
    //   255: goto -> 262
    //   258: ldc ''
    //   260: astore #7
    //   262: aload_2
    //   263: invokevirtual get : ()B
    //   266: sipush #255
    //   269: iand
    //   270: newarray byte
    //   272: astore #8
    //   274: aload_2
    //   275: aload #8
    //   277: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   280: pop
    //   281: new java/lang/String
    //   284: dup
    //   285: aload #8
    //   287: ldc 'UTF-8'
    //   289: invokespecial <init> : ([BLjava/lang/String;)V
    //   292: astore #8
    //   294: aload #6
    //   296: aload #8
    //   298: invokevirtual setCity : (Ljava/lang/String;)V
    //   301: goto -> 308
    //   304: ldc ''
    //   306: astore #8
    //   308: aload_2
    //   309: invokevirtual get : ()B
    //   312: sipush #255
    //   315: iand
    //   316: newarray byte
    //   318: astore #9
    //   320: aload_2
    //   321: aload #9
    //   323: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   326: pop
    //   327: new java/lang/String
    //   330: dup
    //   331: aload #9
    //   333: ldc 'UTF-8'
    //   335: invokespecial <init> : ([BLjava/lang/String;)V
    //   338: astore #9
    //   340: aload #6
    //   342: aload #9
    //   344: invokevirtual setDistrict : (Ljava/lang/String;)V
    //   347: goto -> 354
    //   350: ldc ''
    //   352: astore #9
    //   354: aload_2
    //   355: invokevirtual get : ()B
    //   358: sipush #255
    //   361: iand
    //   362: newarray byte
    //   364: astore #10
    //   366: aload_2
    //   367: aload #10
    //   369: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   372: pop
    //   373: new java/lang/String
    //   376: dup
    //   377: aload #10
    //   379: ldc 'UTF-8'
    //   381: invokespecial <init> : ([BLjava/lang/String;)V
    //   384: astore #10
    //   386: aload #6
    //   388: aload #10
    //   390: invokevirtual setStreet : (Ljava/lang/String;)V
    //   393: aload #6
    //   395: aload #10
    //   397: invokevirtual setRoad : (Ljava/lang/String;)V
    //   400: goto -> 407
    //   403: ldc ''
    //   405: astore #10
    //   407: aload_2
    //   408: invokevirtual get : ()B
    //   411: sipush #255
    //   414: iand
    //   415: newarray byte
    //   417: astore #11
    //   419: aload_2
    //   420: aload #11
    //   422: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   425: pop
    //   426: new java/lang/String
    //   429: dup
    //   430: aload #11
    //   432: ldc 'UTF-8'
    //   434: invokespecial <init> : ([BLjava/lang/String;)V
    //   437: astore #11
    //   439: aload #6
    //   441: aload #11
    //   443: invokevirtual setNumber : (Ljava/lang/String;)V
    //   446: goto -> 453
    //   449: ldc ''
    //   451: astore #11
    //   453: aload_2
    //   454: invokevirtual get : ()B
    //   457: sipush #255
    //   460: iand
    //   461: newarray byte
    //   463: astore #12
    //   465: aload_2
    //   466: aload #12
    //   468: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   471: pop
    //   472: new java/lang/String
    //   475: dup
    //   476: aload #12
    //   478: ldc 'UTF-8'
    //   480: invokespecial <init> : ([BLjava/lang/String;)V
    //   483: astore #12
    //   485: aload #6
    //   487: aload #12
    //   489: invokevirtual setPoiName : (Ljava/lang/String;)V
    //   492: goto -> 499
    //   495: ldc ''
    //   497: astore #12
    //   499: aload_2
    //   500: invokevirtual get : ()B
    //   503: sipush #255
    //   506: iand
    //   507: newarray byte
    //   509: astore #13
    //   511: aload_2
    //   512: aload #13
    //   514: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   517: pop
    //   518: aload #6
    //   520: new java/lang/String
    //   523: dup
    //   524: aload #13
    //   526: ldc 'UTF-8'
    //   528: invokespecial <init> : ([BLjava/lang/String;)V
    //   531: invokevirtual setAoiName : (Ljava/lang/String;)V
    //   534: aload_2
    //   535: invokevirtual get : ()B
    //   538: sipush #255
    //   541: iand
    //   542: newarray byte
    //   544: astore #13
    //   546: aload_2
    //   547: aload #13
    //   549: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   552: pop
    //   553: new java/lang/String
    //   556: dup
    //   557: aload #13
    //   559: ldc 'UTF-8'
    //   561: invokespecial <init> : ([BLjava/lang/String;)V
    //   564: astore #13
    //   566: aload #6
    //   568: aload #13
    //   570: invokevirtual setAdCode : (Ljava/lang/String;)V
    //   573: goto -> 580
    //   576: ldc ''
    //   578: astore #13
    //   580: aload_2
    //   581: invokevirtual get : ()B
    //   584: sipush #255
    //   587: iand
    //   588: newarray byte
    //   590: astore #14
    //   592: aload_2
    //   593: aload #14
    //   595: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   598: pop
    //   599: aload #6
    //   601: new java/lang/String
    //   604: dup
    //   605: aload #14
    //   607: ldc 'UTF-8'
    //   609: invokespecial <init> : ([BLjava/lang/String;)V
    //   612: invokevirtual setCityCode : (Ljava/lang/String;)V
    //   615: aload_0
    //   616: aload_1
    //   617: aload #7
    //   619: aload #8
    //   621: aload #9
    //   623: aload #10
    //   625: aload #11
    //   627: aload #12
    //   629: aload #13
    //   631: invokespecial a : (Lcom/loc/ds;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   634: goto -> 637
    //   637: aload_2
    //   638: astore #7
    //   640: aload #7
    //   642: invokevirtual get : ()B
    //   645: sipush #255
    //   648: iand
    //   649: newarray byte
    //   651: astore #8
    //   653: aload #7
    //   655: astore_2
    //   656: aload_2
    //   657: aload #8
    //   659: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   662: pop
    //   663: aload_2
    //   664: invokevirtual get : ()B
    //   667: iconst_1
    //   668: if_icmpne -> 686
    //   671: aload_2
    //   672: invokevirtual getInt : ()I
    //   675: pop
    //   676: aload_2
    //   677: invokevirtual getInt : ()I
    //   680: pop
    //   681: aload_2
    //   682: invokevirtual getShort : ()S
    //   685: pop
    //   686: aload_2
    //   687: invokevirtual get : ()B
    //   690: iconst_1
    //   691: if_icmpne -> 764
    //   694: aload_2
    //   695: invokevirtual get : ()B
    //   698: sipush #255
    //   701: iand
    //   702: newarray byte
    //   704: astore #7
    //   706: aload_2
    //   707: aload #7
    //   709: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   712: pop
    //   713: aload #6
    //   715: new java/lang/String
    //   718: dup
    //   719: aload #7
    //   721: ldc 'UTF-8'
    //   723: invokespecial <init> : ([BLjava/lang/String;)V
    //   726: invokevirtual setBuildingId : (Ljava/lang/String;)V
    //   729: aload_2
    //   730: invokevirtual get : ()B
    //   733: sipush #255
    //   736: iand
    //   737: newarray byte
    //   739: astore #7
    //   741: aload_2
    //   742: aload #7
    //   744: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   747: pop
    //   748: aload #6
    //   750: new java/lang/String
    //   753: dup
    //   754: aload #7
    //   756: ldc 'UTF-8'
    //   758: invokespecial <init> : ([BLjava/lang/String;)V
    //   761: invokevirtual setFloor : (Ljava/lang/String;)V
    //   764: aload_2
    //   765: invokevirtual get : ()B
    //   768: iconst_1
    //   769: if_icmpne -> 787
    //   772: aload_2
    //   773: invokevirtual get : ()B
    //   776: pop
    //   777: aload_2
    //   778: invokevirtual getInt : ()I
    //   781: pop
    //   782: aload_2
    //   783: invokevirtual get : ()B
    //   786: pop
    //   787: aload_2
    //   788: invokevirtual get : ()B
    //   791: iconst_1
    //   792: if_icmpne -> 804
    //   795: aload #6
    //   797: aload_2
    //   798: invokevirtual getLong : ()J
    //   801: invokevirtual setTime : (J)V
    //   804: aload_2
    //   805: invokevirtual getShort : ()S
    //   808: istore #4
    //   810: iload #4
    //   812: ifle -> 854
    //   815: iload #4
    //   817: newarray byte
    //   819: astore #7
    //   821: aload_2
    //   822: aload #7
    //   824: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   827: pop
    //   828: aload #7
    //   830: arraylength
    //   831: ifle -> 854
    //   834: aload #6
    //   836: new java/lang/String
    //   839: dup
    //   840: aload #7
    //   842: iconst_0
    //   843: invokestatic decode : ([BI)[B
    //   846: ldc 'UTF-8'
    //   848: invokespecial <init> : ([BLjava/lang/String;)V
    //   851: invokevirtual a : (Ljava/lang/String;)V
    //   854: aload_2
    //   855: invokevirtual getShort : ()S
    //   858: istore #4
    //   860: iload #4
    //   862: ifle -> 874
    //   865: aload_2
    //   866: iload #4
    //   868: newarray byte
    //   870: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
    //   873: pop
    //   874: ldc_w '5.1'
    //   877: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   880: invokevirtual doubleValue : ()D
    //   883: ldc2_w 5.1
    //   886: dcmpl
    //   887: iflt -> 936
    //   890: aload_2
    //   891: invokevirtual getShort : ()S
    //   894: istore #5
    //   896: ldc_w '-1'
    //   899: aload_1
    //   900: invokevirtual d : ()Ljava/lang/String;
    //   903: invokevirtual equals : (Ljava/lang/Object;)Z
    //   906: ifne -> 1231
    //   909: iload #5
    //   911: iconst_m1
    //   912: if_icmpne -> 1216
    //   915: iconst_0
    //   916: istore #4
    //   918: goto -> 921
    //   921: aload #6
    //   923: iload #4
    //   925: invokevirtual setConScenario : (I)V
    //   928: goto -> 931
    //   931: aload_2
    //   932: invokevirtual get : ()B
    //   935: pop
    //   936: aload #6
    //   938: astore_1
    //   939: aload_2
    //   940: ifnull -> 1070
    //   943: aload_2
    //   944: invokevirtual clear : ()Ljava/nio/Buffer;
    //   947: pop
    //   948: aload #6
    //   950: astore_1
    //   951: goto -> 1070
    //   954: astore_1
    //   955: goto -> 969
    //   958: astore_1
    //   959: goto -> 969
    //   962: astore_1
    //   963: goto -> 969
    //   966: astore_1
    //   967: aconst_null
    //   968: astore_2
    //   969: new com/loc/ds
    //   972: dup
    //   973: ldc ''
    //   975: invokespecial <init> : (Ljava/lang/String;)V
    //   978: astore #6
    //   980: aload #6
    //   982: iconst_5
    //   983: invokevirtual setErrorCode : (I)V
    //   986: aload_3
    //   987: ldc_w '#0505'
    //   990: invokevirtual f : (Ljava/lang/String;)V
    //   993: aload_0
    //   994: getfield a : Ljava/lang/StringBuilder;
    //   997: astore_3
    //   998: new java/lang/StringBuilder
    //   1001: dup
    //   1002: ldc_w 'parser data error:'
    //   1005: invokespecial <init> : (Ljava/lang/String;)V
    //   1008: astore #7
    //   1010: aload #7
    //   1012: aload_1
    //   1013: invokevirtual getMessage : ()Ljava/lang/String;
    //   1016: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload #7
    //   1022: ldc_w '#0505'
    //   1025: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload_3
    //   1030: aload #7
    //   1032: invokevirtual toString : ()Ljava/lang/String;
    //   1035: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aconst_null
    //   1040: sipush #2054
    //   1043: invokestatic a : (Ljava/lang/String;I)V
    //   1046: aload #6
    //   1048: aload_0
    //   1049: getfield a : Ljava/lang/StringBuilder;
    //   1052: invokevirtual toString : ()Ljava/lang/String;
    //   1055: invokevirtual setLocationDetail : (Ljava/lang/String;)V
    //   1058: aload_2
    //   1059: ifnull -> 1067
    //   1062: aload_2
    //   1063: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1066: pop
    //   1067: aload #6
    //   1069: astore_1
    //   1070: aload_0
    //   1071: getfield a : Ljava/lang/StringBuilder;
    //   1074: invokevirtual length : ()I
    //   1077: ifle -> 1095
    //   1080: aload_0
    //   1081: getfield a : Ljava/lang/StringBuilder;
    //   1084: astore_2
    //   1085: aload_2
    //   1086: iconst_0
    //   1087: aload_2
    //   1088: invokevirtual length : ()I
    //   1091: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload_1
    //   1096: areturn
    //   1097: astore_1
    //   1098: aload_2
    //   1099: ifnull -> 1107
    //   1102: aload_2
    //   1103: invokevirtual clear : ()Ljava/nio/Buffer;
    //   1106: pop
    //   1107: aload_1
    //   1108: athrow
    //   1109: astore #7
    //   1111: goto -> 216
    //   1114: astore #7
    //   1116: goto -> 258
    //   1119: astore #8
    //   1121: goto -> 262
    //   1124: astore #8
    //   1126: goto -> 304
    //   1129: astore #9
    //   1131: goto -> 308
    //   1134: astore #9
    //   1136: goto -> 350
    //   1139: astore #10
    //   1141: goto -> 354
    //   1144: astore #10
    //   1146: goto -> 403
    //   1149: astore #11
    //   1151: goto -> 407
    //   1154: astore #11
    //   1156: goto -> 449
    //   1159: astore #12
    //   1161: goto -> 453
    //   1164: astore #12
    //   1166: goto -> 495
    //   1169: astore #13
    //   1171: goto -> 499
    //   1174: astore #13
    //   1176: goto -> 534
    //   1179: astore #13
    //   1181: goto -> 576
    //   1184: astore #14
    //   1186: goto -> 580
    //   1189: astore #14
    //   1191: goto -> 615
    //   1194: astore #7
    //   1196: goto -> 729
    //   1199: astore #7
    //   1201: goto -> 764
    //   1204: astore #7
    //   1206: goto -> 854
    //   1209: astore_1
    //   1210: goto -> 959
    //   1213: goto -> 637
    //   1216: iload #5
    //   1218: istore #4
    //   1220: iload #5
    //   1222: ifne -> 921
    //   1225: iconst_m1
    //   1226: istore #4
    //   1228: goto -> 921
    //   1231: iload #5
    //   1233: istore #4
    //   1235: iload #5
    //   1237: bipush #101
    //   1239: if_icmpne -> 921
    //   1242: bipush #100
    //   1244: istore #4
    //   1246: goto -> 921
    // Exception table:
    //   from	to	target	type
    //   7	57	966	finally
    //   60	65	966	finally
    //   65	89	962	finally
    //   101	175	962	finally
    //   181	200	1209	finally
    //   200	216	1109	finally
    //   216	235	1209	finally
    //   235	248	1114	finally
    //   248	255	1119	finally
    //   262	281	1209	finally
    //   281	294	1124	finally
    //   294	301	1129	finally
    //   308	327	1209	finally
    //   327	340	1134	finally
    //   340	347	1139	finally
    //   354	373	1209	finally
    //   373	386	1144	finally
    //   386	400	1149	finally
    //   407	426	1209	finally
    //   426	439	1154	finally
    //   439	446	1159	finally
    //   453	472	1209	finally
    //   472	485	1164	finally
    //   485	492	1169	finally
    //   499	518	1209	finally
    //   518	534	1174	finally
    //   534	553	1209	finally
    //   553	566	1179	finally
    //   566	573	1184	finally
    //   580	599	1209	finally
    //   599	615	1189	finally
    //   615	634	958	finally
    //   640	653	958	finally
    //   656	686	954	finally
    //   686	713	954	finally
    //   713	729	1194	finally
    //   729	748	954	finally
    //   748	764	1199	finally
    //   764	787	954	finally
    //   787	804	954	finally
    //   804	810	954	finally
    //   815	828	954	finally
    //   828	854	1204	finally
    //   854	860	954	finally
    //   865	874	954	finally
    //   874	909	954	finally
    //   921	928	954	finally
    //   931	936	954	finally
    //   969	1058	1097	finally
  }
  
  public final ds a(String paramString) {
    try {
      ds ds = new ds("");
      JSONObject jSONObject2 = (new JSONObject(paramString)).optJSONObject("regeocode");
      JSONObject jSONObject1 = jSONObject2.optJSONObject("addressComponent");
      ds.setCountry(b(jSONObject1.optString("country")));
      String str1 = b(jSONObject1.optString("province"));
      ds.setProvince(str1);
      String str2 = b(jSONObject1.optString("citycode"));
      ds.setCityCode(str2);
      paramString = jSONObject1.optString("city");
      if (str2.endsWith("010") || str2.endsWith("021") || str2.endsWith("022") || str2.endsWith("023")) {
        if (str1 != null && str1.length() > 0) {
          ds.setCity(str1);
          paramString = str1;
        } 
      } else {
        paramString = b(paramString);
        ds.setCity(paramString);
      } 
      if (TextUtils.isEmpty(paramString)) {
        ds.setCity(str1);
        paramString = str1;
      } 
      str2 = b(jSONObject1.optString("district"));
      ds.setDistrict(str2);
      String str3 = b(jSONObject1.optString("adcode"));
      ds.setAdCode(str3);
      jSONObject1 = jSONObject1.optJSONObject("streetNumber");
      String str4 = b(jSONObject1.optString("street"));
      ds.setStreet(str4);
      ds.setRoad(str4);
      String str5 = b(jSONObject1.optString("number"));
      ds.setNumber(str5);
      JSONArray jSONArray1 = jSONObject2.optJSONArray("pois");
      int i = jSONArray1.length();
      if (i > 0) {
        String str = b(jSONArray1.getJSONObject(0).optString("name"));
        ds.setPoiName(str);
      } else {
        jSONArray1 = null;
      } 
      JSONArray jSONArray2 = jSONObject2.optJSONArray("aois");
      if (jSONArray2.length() > 0)
        ds.setAoiName(b(jSONArray2.getJSONObject(0).optString("name"))); 
      return ds;
    } finally {
      paramString = null;
    } 
  }
  
  public final ds a(String paramString, Context paramContext, aw paramaw, dm paramdm) {
    ds ds = new ds("");
    ds.setErrorCode(7);
    StringBuffer stringBuffer = new StringBuffer();
    try {
      stringBuffer.append("#SHA1AndPackage#");
      stringBuffer.append(k.e(paramContext));
      String str = ((List<String>)paramaw.b.get("gsid")).get(0);
      if (!TextUtils.isEmpty(str)) {
        stringBuffer.append("#gsid#");
        stringBuffer.append(str);
      } 
      str = paramaw.c;
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder = new StringBuilder("#csid#");
        stringBuilder.append(str);
        stringBuffer.append(stringBuilder.toString());
      } 
    } finally {}
    try {
    
    } finally {
      paramString = null;
      paramdm.f("#0703");
      StringBuilder stringBuilder = this.a;
      stringBuilder.append("json exception error:");
      stringBuilder.append(paramString.getMessage());
      stringBuilder.append(stringBuffer);
      stringBuilder.append("#0703");
    } 
    ds.setLocationDetail(this.a.toString());
    if (this.a.length() > 0) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.delete(0, stringBuilder.length());
    } 
    return ds;
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption) {
    if (paramAMapLocationClientOption == null) {
      this.b = new AMapLocationClientOption();
      return;
    } 
    this.b = paramAMapLocationClientOption;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */