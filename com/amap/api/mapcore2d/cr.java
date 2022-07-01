package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class cr {
  public static int a = -1;
  
  public static String b = "";
  
  public static a a(Context paramContext, da paramda, String paramString, Map<String, String> paramMap) {
    return a(paramContext, paramda, paramString, paramMap, false);
  }
  
  public static a a(Context paramContext, da paramda, String paramString, Map<String, String> paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: new com/amap/api/mapcore2d/cr$a
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #11
    //   9: aload #11
    //   11: new org/json/JSONObject
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: putfield w : Lorg/json/JSONObject;
    //   21: invokestatic a : ()Lcom/amap/api/mapcore2d/cw;
    //   24: aload_0
    //   25: invokevirtual a : (Landroid/content/Context;)V
    //   28: new com/amap/api/mapcore2d/er
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #9
    //   37: new java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #8
    //   46: aload #8
    //   48: aload_2
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload #8
    //   55: ldc ';14N;'
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #8
    //   63: ldc '15K'
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #8
    //   71: ldc ';'
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #8
    //   79: ldc '16H'
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #8
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: astore #8
    //   92: new com/amap/api/mapcore2d/cr$b
    //   95: dup
    //   96: aload_0
    //   97: aload_1
    //   98: aload #8
    //   100: aload_3
    //   101: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;Ljava/lang/String;Ljava/util/Map;)V
    //   104: astore_2
    //   105: aload #9
    //   107: aload_2
    //   108: aload_2
    //   109: invokevirtual a : ()Z
    //   112: invokevirtual a : (Lcom/amap/api/mapcore2d/ew;Z)Lcom/amap/api/mapcore2d/ey;
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull -> 139
    //   120: aload_2
    //   121: getfield a : [B
    //   124: astore_3
    //   125: goto -> 141
    //   128: astore_3
    //   129: goto -> 356
    //   132: goto -> 382
    //   135: astore_3
    //   136: goto -> 399
    //   139: aconst_null
    //   140: astore_3
    //   141: bipush #16
    //   143: newarray byte
    //   145: astore #10
    //   147: aload_3
    //   148: arraylength
    //   149: bipush #16
    //   151: isub
    //   152: newarray byte
    //   154: astore #9
    //   156: aload_3
    //   157: iconst_0
    //   158: aload #10
    //   160: iconst_0
    //   161: bipush #16
    //   163: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   166: aload_3
    //   167: arraylength
    //   168: istore #5
    //   170: aload_3
    //   171: bipush #16
    //   173: aload #9
    //   175: iconst_0
    //   176: iload #5
    //   178: bipush #16
    //   180: isub
    //   181: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   184: new javax/crypto/spec/SecretKeySpec
    //   187: dup
    //   188: aload #10
    //   190: ldc 'AES'
    //   192: invokespecial <init> : ([BLjava/lang/String;)V
    //   195: astore #10
    //   197: ldc 'AES/CBC/PKCS5Padding'
    //   199: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   202: astore #12
    //   204: aload #12
    //   206: iconst_2
    //   207: aload #10
    //   209: new javax/crypto/spec/IvParameterSpec
    //   212: dup
    //   213: invokestatic c : ()[B
    //   216: invokespecial <init> : ([B)V
    //   219: invokevirtual init : (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   222: aload #12
    //   224: aload #9
    //   226: invokevirtual doFinal : ([B)[B
    //   229: invokestatic a : ([B)Ljava/lang/String;
    //   232: astore #9
    //   234: goto -> 429
    //   237: astore #9
    //   239: goto -> 262
    //   242: astore #9
    //   244: goto -> 273
    //   247: astore #9
    //   249: goto -> 262
    //   252: goto -> 268
    //   255: astore #9
    //   257: goto -> 273
    //   260: astore #9
    //   262: aload_3
    //   263: astore #10
    //   265: goto -> 362
    //   268: goto -> 426
    //   271: astore #9
    //   273: aload_3
    //   274: astore #10
    //   276: goto -> 405
    //   279: astore #9
    //   281: aload_3
    //   282: astore #10
    //   284: goto -> 362
    //   287: goto -> 426
    //   290: astore #9
    //   292: aload_3
    //   293: astore #10
    //   295: goto -> 405
    //   298: goto -> 313
    //   301: astore #9
    //   303: goto -> 329
    //   306: astore_3
    //   307: goto -> 1259
    //   310: aload_2
    //   311: astore #8
    //   313: aload #8
    //   315: astore_2
    //   316: aload #8
    //   318: astore_3
    //   319: new com/amap/api/mapcore2d/cp
    //   322: dup
    //   323: ldc '未知的错误'
    //   325: invokespecial <init> : (Ljava/lang/String;)V
    //   328: athrow
    //   329: aload #8
    //   331: astore_2
    //   332: aload #8
    //   334: astore_3
    //   335: aload #9
    //   337: athrow
    //   338: astore_3
    //   339: aload_2
    //   340: astore #8
    //   342: goto -> 354
    //   345: astore #9
    //   347: goto -> 391
    //   350: astore_3
    //   351: aload_2
    //   352: astore #8
    //   354: aconst_null
    //   355: astore_2
    //   356: aconst_null
    //   357: astore #10
    //   359: aload_3
    //   360: astore #9
    //   362: aload #9
    //   364: ldc 'at'
    //   366: ldc 'lc'
    //   368: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload #10
    //   373: astore_3
    //   374: goto -> 426
    //   377: aload_2
    //   378: astore #8
    //   380: aconst_null
    //   381: astore_2
    //   382: aconst_null
    //   383: astore_3
    //   384: goto -> 426
    //   387: astore #9
    //   389: aload_2
    //   390: astore_3
    //   391: aconst_null
    //   392: astore_2
    //   393: aload_3
    //   394: astore #8
    //   396: aload #9
    //   398: astore_3
    //   399: aconst_null
    //   400: astore #10
    //   402: aload_3
    //   403: astore #9
    //   405: aload #11
    //   407: aload #9
    //   409: invokevirtual a : ()Ljava/lang/String;
    //   412: putfield a : Ljava/lang/String;
    //   415: aload_1
    //   416: ldc '/v3/iasdkauth'
    //   418: aload #9
    //   420: invokestatic a : (Lcom/amap/api/mapcore2d/da;Ljava/lang/String;Lcom/amap/api/mapcore2d/cp;)V
    //   423: aload #10
    //   425: astore_3
    //   426: aconst_null
    //   427: astore #9
    //   429: aload_3
    //   430: ifnonnull -> 436
    //   433: aload #11
    //   435: areturn
    //   436: aload #9
    //   438: astore #10
    //   440: aload #9
    //   442: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   445: ifeq -> 454
    //   448: aload_3
    //   449: invokestatic a : ([B)Ljava/lang/String;
    //   452: astore #10
    //   454: new org/json/JSONObject
    //   457: dup
    //   458: aload #10
    //   460: invokespecial <init> : (Ljava/lang/String;)V
    //   463: astore #10
    //   465: aload #10
    //   467: ldc 'status'
    //   469: invokevirtual has : (Ljava/lang/String;)Z
    //   472: ifeq -> 1211
    //   475: aload #10
    //   477: ldc 'status'
    //   479: invokevirtual getInt : (Ljava/lang/String;)I
    //   482: istore #5
    //   484: iload #5
    //   486: iconst_1
    //   487: if_icmpne -> 497
    //   490: iconst_1
    //   491: putstatic com/amap/api/mapcore2d/cr.a : I
    //   494: goto -> 606
    //   497: iload #5
    //   499: ifne -> 606
    //   502: ldc 'authcsid'
    //   504: astore #9
    //   506: ldc 'authgsid'
    //   508: astore_3
    //   509: aload_2
    //   510: ifnull -> 524
    //   513: aload_2
    //   514: getfield c : Ljava/lang/String;
    //   517: astore #9
    //   519: aload_2
    //   520: getfield d : Ljava/lang/String;
    //   523: astore_3
    //   524: aload_0
    //   525: aload #9
    //   527: aload_3
    //   528: aload #10
    //   530: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   533: iconst_0
    //   534: putstatic com/amap/api/mapcore2d/cr.a : I
    //   537: aload #10
    //   539: ldc 'info'
    //   541: invokevirtual has : (Ljava/lang/String;)Z
    //   544: ifeq -> 557
    //   547: aload #10
    //   549: ldc 'info'
    //   551: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   554: putstatic com/amap/api/mapcore2d/cr.b : Ljava/lang/String;
    //   557: aload #10
    //   559: ldc 'infocode'
    //   561: invokevirtual has : (Ljava/lang/String;)Z
    //   564: ifeq -> 1268
    //   567: aload #10
    //   569: ldc 'infocode'
    //   571: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   574: astore_2
    //   575: goto -> 578
    //   578: aload_1
    //   579: ldc '/v3/iasdkauth'
    //   581: getstatic com/amap/api/mapcore2d/cr.b : Ljava/lang/String;
    //   584: aload_3
    //   585: aload_2
    //   586: invokestatic a : (Lcom/amap/api/mapcore2d/da;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   589: getstatic com/amap/api/mapcore2d/cr.a : I
    //   592: ifne -> 606
    //   595: aload #11
    //   597: getstatic com/amap/api/mapcore2d/cr.b : Ljava/lang/String;
    //   600: putfield a : Ljava/lang/String;
    //   603: aload #11
    //   605: areturn
    //   606: aload #10
    //   608: ldc 'ver'
    //   610: invokevirtual has : (Ljava/lang/String;)Z
    //   613: ifeq -> 640
    //   616: aload #11
    //   618: aload #10
    //   620: ldc 'ver'
    //   622: invokevirtual getInt : (Ljava/lang/String;)I
    //   625: putfield b : I
    //   628: goto -> 640
    //   631: astore_1
    //   632: aload_1
    //   633: ldc 'at'
    //   635: ldc 'lc'
    //   637: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload #10
    //   642: ldc 'result'
    //   644: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   647: ifeq -> 1211
    //   650: new com/amap/api/mapcore2d/cr$a$a
    //   653: dup
    //   654: invokespecial <init> : ()V
    //   657: astore_2
    //   658: aload_2
    //   659: iconst_0
    //   660: putfield a : Z
    //   663: aload_2
    //   664: iconst_0
    //   665: putfield b : Z
    //   668: aload #11
    //   670: aload_2
    //   671: putfield x : Lcom/amap/api/mapcore2d/cr$a$a;
    //   674: aload #10
    //   676: ldc 'result'
    //   678: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   681: astore_1
    //   682: aload #8
    //   684: ldc ';'
    //   686: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   689: astore_3
    //   690: aload_3
    //   691: ifnull -> 763
    //   694: aload_3
    //   695: arraylength
    //   696: ifle -> 763
    //   699: aload_3
    //   700: arraylength
    //   701: istore #6
    //   703: iconst_0
    //   704: istore #5
    //   706: iload #5
    //   708: iload #6
    //   710: if_icmpge -> 763
    //   713: aload_3
    //   714: iload #5
    //   716: aaload
    //   717: astore #8
    //   719: aload_1
    //   720: aload #8
    //   722: invokevirtual has : (Ljava/lang/String;)Z
    //   725: ifeq -> 745
    //   728: aload #11
    //   730: getfield w : Lorg/json/JSONObject;
    //   733: aload #8
    //   735: aload_1
    //   736: aload #8
    //   738: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   741: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   744: pop
    //   745: iload #5
    //   747: iconst_1
    //   748: iadd
    //   749: istore #5
    //   751: goto -> 706
    //   754: astore_3
    //   755: aload_3
    //   756: ldc 'at'
    //   758: ldc 'co'
    //   760: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   763: aload_1
    //   764: ldc '16H'
    //   766: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   769: istore #7
    //   771: iload #7
    //   773: ifeq -> 797
    //   776: aload #11
    //   778: aload_1
    //   779: ldc '16H'
    //   781: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   784: ldc 'able'
    //   786: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   789: iconst_0
    //   790: invokestatic a : (Ljava/lang/String;Z)Z
    //   793: invokestatic a : (Lcom/amap/api/mapcore2d/cr$a;Z)Z
    //   796: pop
    //   797: aload_1
    //   798: ldc_w '11K'
    //   801: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   804: istore #7
    //   806: iload #7
    //   808: ifeq -> 868
    //   811: aload_1
    //   812: ldc_w '11K'
    //   815: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   818: astore_3
    //   819: aload_2
    //   820: aload_3
    //   821: ldc 'able'
    //   823: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   826: iconst_0
    //   827: invokestatic a : (Ljava/lang/String;Z)Z
    //   830: putfield a : Z
    //   833: aload_3
    //   834: ldc_w 'off'
    //   837: invokevirtual has : (Ljava/lang/String;)Z
    //   840: ifeq -> 868
    //   843: aload_2
    //   844: aload_3
    //   845: ldc_w 'off'
    //   848: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   851: putfield c : Lorg/json/JSONObject;
    //   854: goto -> 868
    //   857: astore_2
    //   858: aload_2
    //   859: ldc_w 'AuthConfigManager'
    //   862: ldc_w 'loadException'
    //   865: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload_1
    //   869: ldc_w '001'
    //   872: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   875: ifeq -> 905
    //   878: aload_1
    //   879: ldc_w '001'
    //   882: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   885: astore_2
    //   886: new com/amap/api/mapcore2d/cr$a$d
    //   889: dup
    //   890: invokespecial <init> : ()V
    //   893: astore_3
    //   894: aload_2
    //   895: aload_3
    //   896: invokestatic a : (Lorg/json/JSONObject;Lcom/amap/api/mapcore2d/cr$a$d;)V
    //   899: aload #11
    //   901: aload_3
    //   902: putfield y : Lcom/amap/api/mapcore2d/cr$a$d;
    //   905: aload_1
    //   906: ldc_w '002'
    //   909: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   912: ifeq -> 942
    //   915: aload_1
    //   916: ldc_w '002'
    //   919: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   922: astore_2
    //   923: new com/amap/api/mapcore2d/cr$a$c
    //   926: dup
    //   927: invokespecial <init> : ()V
    //   930: astore_3
    //   931: aload_2
    //   932: aload_3
    //   933: invokestatic a : (Lorg/json/JSONObject;Lcom/amap/api/mapcore2d/cr$a$c;)V
    //   936: aload #11
    //   938: aload_3
    //   939: putfield A : Lcom/amap/api/mapcore2d/cr$a$c;
    //   942: aload_1
    //   943: ldc_w '14S'
    //   946: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   949: ifeq -> 979
    //   952: aload_1
    //   953: ldc_w '14S'
    //   956: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   959: astore_2
    //   960: new com/amap/api/mapcore2d/cr$a$c
    //   963: dup
    //   964: invokespecial <init> : ()V
    //   967: astore_3
    //   968: aload_2
    //   969: aload_3
    //   970: invokestatic a : (Lorg/json/JSONObject;Lcom/amap/api/mapcore2d/cr$a$c;)V
    //   973: aload #11
    //   975: aload_3
    //   976: putfield B : Lcom/amap/api/mapcore2d/cr$a$c;
    //   979: aload #11
    //   981: aload_1
    //   982: invokestatic a : (Lcom/amap/api/mapcore2d/cr$a;Lorg/json/JSONObject;)V
    //   985: aload_1
    //   986: ldc_w '14Z'
    //   989: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   992: ifeq -> 1022
    //   995: aload_1
    //   996: ldc_w '14Z'
    //   999: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1002: astore_2
    //   1003: new com/amap/api/mapcore2d/cr$a$f
    //   1006: dup
    //   1007: invokespecial <init> : ()V
    //   1010: astore_3
    //   1011: aload_2
    //   1012: aload_3
    //   1013: invokestatic a : (Lorg/json/JSONObject;Lcom/amap/api/mapcore2d/cr$a$f;)V
    //   1016: aload #11
    //   1018: aload_3
    //   1019: putfield G : Lcom/amap/api/mapcore2d/cr$a$f;
    //   1022: aload_1
    //   1023: ldc_w '151'
    //   1026: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1029: ifeq -> 1059
    //   1032: aload_1
    //   1033: ldc_w '151'
    //   1036: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1039: astore_2
    //   1040: new com/amap/api/mapcore2d/cr$a$e
    //   1043: dup
    //   1044: invokespecial <init> : ()V
    //   1047: astore_3
    //   1048: aload_2
    //   1049: aload_3
    //   1050: invokestatic a : (Lorg/json/JSONObject;Lcom/amap/api/mapcore2d/cr$a$e;)V
    //   1053: aload #11
    //   1055: aload_3
    //   1056: putfield z : Lcom/amap/api/mapcore2d/cr$a$e;
    //   1059: aload #11
    //   1061: aload_1
    //   1062: invokestatic a : (Lcom/amap/api/mapcore2d/cr$a;Lorg/json/JSONObject;)V
    //   1065: aload_1
    //   1066: ldc_w '14N'
    //   1069: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1072: ifeq -> 1194
    //   1075: aload_1
    //   1076: ldc_w '14N'
    //   1079: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1082: astore_3
    //   1083: new com/amap/api/mapcore2d/cr$a$b
    //   1086: dup
    //   1087: invokespecial <init> : ()V
    //   1090: astore_2
    //   1091: aload_2
    //   1092: aload_3
    //   1093: ldc 'able'
    //   1095: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1098: iconst_0
    //   1099: invokestatic a : (Ljava/lang/String;Z)Z
    //   1102: putfield a : Z
    //   1105: aload_2
    //   1106: aload_3
    //   1107: ldc_w 'url'
    //   1110: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1113: putfield b : Ljava/lang/String;
    //   1116: aload_2
    //   1117: aload_3
    //   1118: ldc_w 'md5'
    //   1121: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1124: putfield c : Ljava/lang/String;
    //   1127: aload_2
    //   1128: getfield a : Z
    //   1131: ifeq -> 1187
    //   1134: invokestatic a : ()Lcom/amap/api/mapcore2d/da;
    //   1137: astore_3
    //   1138: aload_3
    //   1139: ifnull -> 1194
    //   1142: new com/amap/api/mapcore2d/ea
    //   1145: dup
    //   1146: aload_2
    //   1147: getfield b : Ljava/lang/String;
    //   1150: aload_2
    //   1151: getfield c : Ljava/lang/String;
    //   1154: ldc ''
    //   1156: aload #11
    //   1158: invokestatic a : (Lcom/amap/api/mapcore2d/cr$a;)Z
    //   1161: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1164: astore_2
    //   1165: aload_2
    //   1166: iload #4
    //   1168: invokevirtual a : (Z)V
    //   1171: new com/amap/api/mapcore2d/dz
    //   1174: dup
    //   1175: aload_0
    //   1176: aload_2
    //   1177: aload_3
    //   1178: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/ea;Lcom/amap/api/mapcore2d/da;)V
    //   1181: invokevirtual a : ()V
    //   1184: goto -> 1194
    //   1187: aload_0
    //   1188: ldc_w 'aiu'
    //   1191: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   1194: aload_0
    //   1195: aload_1
    //   1196: invokestatic a : (Landroid/content/Context;Lorg/json/JSONObject;)V
    //   1199: aload #11
    //   1201: areturn
    //   1202: astore_0
    //   1203: aload_0
    //   1204: ldc 'at'
    //   1206: ldc 'lc'
    //   1208: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1211: aload #11
    //   1213: areturn
    //   1214: astore_3
    //   1215: goto -> 377
    //   1218: astore_3
    //   1219: goto -> 310
    //   1222: astore_3
    //   1223: goto -> 310
    //   1226: astore_2
    //   1227: goto -> 298
    //   1230: astore_3
    //   1231: goto -> 132
    //   1234: astore #9
    //   1236: goto -> 287
    //   1239: astore #9
    //   1241: goto -> 268
    //   1244: astore #9
    //   1246: goto -> 252
    //   1249: astore #9
    //   1251: goto -> 268
    //   1254: astore_2
    //   1255: goto -> 380
    //   1258: astore_3
    //   1259: aload_3
    //   1260: astore #9
    //   1262: aload_2
    //   1263: astore #8
    //   1265: goto -> 329
    //   1268: ldc ''
    //   1270: astore_2
    //   1271: goto -> 578
    // Exception table:
    //   from	to	target	type
    //   28	37	387	com/amap/api/mapcore2d/cp
    //   28	37	1214	javax/crypto/IllegalBlockSizeException
    //   28	37	350	finally
    //   37	46	1258	com/amap/api/mapcore2d/cp
    //   37	46	1218	finally
    //   46	92	306	com/amap/api/mapcore2d/cp
    //   46	92	1222	finally
    //   92	116	301	com/amap/api/mapcore2d/cp
    //   92	116	1226	finally
    //   120	125	135	com/amap/api/mapcore2d/cp
    //   120	125	1230	javax/crypto/IllegalBlockSizeException
    //   120	125	128	finally
    //   141	147	290	com/amap/api/mapcore2d/cp
    //   141	147	1234	javax/crypto/IllegalBlockSizeException
    //   141	147	279	finally
    //   147	156	271	com/amap/api/mapcore2d/cp
    //   147	156	1239	javax/crypto/IllegalBlockSizeException
    //   147	156	260	finally
    //   156	170	255	com/amap/api/mapcore2d/cp
    //   156	170	1244	javax/crypto/IllegalBlockSizeException
    //   156	170	247	finally
    //   170	234	242	com/amap/api/mapcore2d/cp
    //   170	234	1249	javax/crypto/IllegalBlockSizeException
    //   170	234	237	finally
    //   319	329	345	com/amap/api/mapcore2d/cp
    //   319	329	1254	javax/crypto/IllegalBlockSizeException
    //   319	329	338	finally
    //   335	338	345	com/amap/api/mapcore2d/cp
    //   335	338	1254	javax/crypto/IllegalBlockSizeException
    //   335	338	338	finally
    //   454	484	1202	finally
    //   490	494	1202	finally
    //   513	524	1202	finally
    //   524	557	1202	finally
    //   557	575	1202	finally
    //   578	603	1202	finally
    //   606	628	631	finally
    //   632	640	1202	finally
    //   640	682	1202	finally
    //   682	690	754	finally
    //   694	703	754	finally
    //   719	745	754	finally
    //   755	763	1202	finally
    //   763	771	1202	finally
    //   776	797	1202	finally
    //   797	806	1202	finally
    //   811	854	857	finally
    //   858	868	1202	finally
    //   868	905	1202	finally
    //   905	942	1202	finally
    //   942	979	1202	finally
    //   979	1022	1202	finally
    //   1022	1059	1202	finally
    //   1059	1138	1202	finally
    //   1142	1184	1202	finally
    //   1187	1194	1202	finally
    //   1194	1199	1202	finally
  }
  
  public static String a(JSONObject paramJSONObject, String paramString) throws JSONException {
    String str2 = "";
    if (paramJSONObject == null)
      return ""; 
    String str1 = str2;
    if (paramJSONObject.has(paramString)) {
      str1 = str2;
      if (!paramJSONObject.getString(paramString).equals("[]"))
        str1 = paramJSONObject.optString(paramString); 
    } 
    return str1;
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject) {
    try {
      paramJSONObject = paramJSONObject.getJSONObject("15K");
      boolean bool = a(paramJSONObject.optString("isTargetAble"), false);
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static void a(a parama, JSONObject paramJSONObject) {
    try {
      if (db.a(paramJSONObject, "11B"))
        parama.h = paramJSONObject.getJSONObject("11B"); 
      if (db.a(paramJSONObject, "11C"))
        parama.k = paramJSONObject.getJSONObject("11C"); 
      if (db.a(paramJSONObject, "11I"))
        parama.l = paramJSONObject.getJSONObject("11I"); 
      if (db.a(paramJSONObject, "11H"))
        parama.m = paramJSONObject.getJSONObject("11H"); 
      if (db.a(paramJSONObject, "11E"))
        parama.n = paramJSONObject.getJSONObject("11E"); 
      if (db.a(paramJSONObject, "11F"))
        parama.o = paramJSONObject.getJSONObject("11F"); 
      if (db.a(paramJSONObject, "13A"))
        parama.q = paramJSONObject.getJSONObject("13A"); 
      if (db.a(paramJSONObject, "13J"))
        parama.i = paramJSONObject.getJSONObject("13J"); 
      if (db.a(paramJSONObject, "11G"))
        parama.p = paramJSONObject.getJSONObject("11G"); 
      if (db.a(paramJSONObject, "006"))
        parama.r = paramJSONObject.getJSONObject("006"); 
      if (db.a(paramJSONObject, "010"))
        parama.s = paramJSONObject.getJSONObject("010"); 
      if (db.a(paramJSONObject, "11Z")) {
        JSONObject jSONObject = paramJSONObject.getJSONObject("11Z");
        a.b b = new a.b();
        a(jSONObject, b);
        parama.C = b;
      } 
      if (db.a(paramJSONObject, "135"))
        parama.j = paramJSONObject.getJSONObject("135"); 
      if (db.a(paramJSONObject, "13S"))
        parama.g = paramJSONObject.getJSONObject("13S"); 
      if (db.a(paramJSONObject, "121")) {
        JSONObject jSONObject = paramJSONObject.getJSONObject("121");
        a.b b = new a.b();
        a(jSONObject, b);
        parama.D = b;
      } 
      if (db.a(paramJSONObject, "122")) {
        JSONObject jSONObject = paramJSONObject.getJSONObject("122");
        a.b b = new a.b();
        a(jSONObject, b);
        parama.E = b;
      } 
      if (db.a(paramJSONObject, "123")) {
        JSONObject jSONObject = paramJSONObject.getJSONObject("123");
        a.b b = new a.b();
        a(jSONObject, b);
        parama.F = b;
      } 
      if (db.a(paramJSONObject, "011"))
        parama.c = paramJSONObject.getJSONObject("011"); 
      if (db.a(paramJSONObject, "012"))
        parama.d = paramJSONObject.getJSONObject("012"); 
      if (db.a(paramJSONObject, "013"))
        parama.e = paramJSONObject.getJSONObject("013"); 
      if (db.a(paramJSONObject, "014"))
        parama.f = paramJSONObject.getJSONObject("014"); 
      if (db.a(paramJSONObject, "145"))
        parama.t = paramJSONObject.getJSONObject("145"); 
      if (db.a(paramJSONObject, "14B"))
        parama.u = paramJSONObject.getJSONObject("14B"); 
    } finally {
      parama = null;
    } 
  }
  
  private static void a(JSONObject paramJSONObject, a.b paramb) {
    if (paramb != null)
      try {
        String str2 = a(paramJSONObject, "m");
        String str3 = a(paramJSONObject, "u");
        String str4 = a(paramJSONObject, "v");
        String str5 = a(paramJSONObject, "able");
        String str1 = a(paramJSONObject, "on");
        paramb.c = str2;
        paramb.b = str3;
        paramb.d = str4;
        paramb.a = a(str5, false);
        return;
      } finally {
        paramJSONObject = null;
      }  
  }
  
  private static void a(JSONObject paramJSONObject, a.c paramc) {
    if (paramJSONObject != null)
      try {
        String str2 = a(paramJSONObject, "md5");
        String str1 = a(paramJSONObject, "url");
        paramc.b = str2;
        return;
      } finally {
        paramJSONObject = null;
      }  
  }
  
  private static void a(JSONObject paramJSONObject, a.d paramd) {
    if (paramJSONObject != null)
      try {
        String str2 = a(paramJSONObject, "md5");
        String str3 = a(paramJSONObject, "url");
        String str1 = a(paramJSONObject, "sdkversion");
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
          if (TextUtils.isEmpty(str1))
            return; 
          paramd.a = str3;
          paramd.b = str2;
          return;
        } 
      } finally {
        paramJSONObject = null;
      }  
  }
  
  private static void a(JSONObject paramJSONObject, a.e parame) {
    if (parame != null) {
      if (paramJSONObject == null)
        return; 
      parame.a = a(paramJSONObject.optString("able"), false);
    } 
  }
  
  private static void a(JSONObject paramJSONObject, a.f paramf) {
    if (paramf != null)
      try {
        String str2 = a(paramJSONObject, "md5");
        String str3 = a(paramJSONObject, "md5info");
        String str4 = a(paramJSONObject, "url");
        String str5 = a(paramJSONObject, "able");
        String str6 = a(paramJSONObject, "on");
        String str1 = a(paramJSONObject, "mobileable");
        paramf.e = str2;
        paramf.f = str3;
        paramf.d = str4;
        paramf.a = a(str5, false);
        paramf.b = a(str6, false);
        return;
      } finally {
        paramJSONObject = null;
      }  
  }
  
  public static boolean a(String paramString, boolean paramBoolean) {
    try {
      if (TextUtils.isEmpty(paramString))
        return paramBoolean; 
      String[] arrayOfString = URLDecoder.decode(paramString).split("/");
      return (c % 2 == 1);
    } finally {
      paramString = null;
    } 
  }
  
  public static class a {
    @Deprecated
    public c A;
    
    public c B;
    
    public b C;
    
    public b D;
    
    public b E;
    
    public b F;
    
    public f G;
    
    private boolean H;
    
    public String a;
    
    public int b = -1;
    
    @Deprecated
    public JSONObject c;
    
    @Deprecated
    public JSONObject d;
    
    @Deprecated
    public JSONObject e;
    
    @Deprecated
    public JSONObject f;
    
    @Deprecated
    public JSONObject g;
    
    @Deprecated
    public JSONObject h;
    
    @Deprecated
    public JSONObject i;
    
    @Deprecated
    public JSONObject j;
    
    @Deprecated
    public JSONObject k;
    
    @Deprecated
    public JSONObject l;
    
    @Deprecated
    public JSONObject m;
    
    @Deprecated
    public JSONObject n;
    
    @Deprecated
    public JSONObject o;
    
    @Deprecated
    public JSONObject p;
    
    @Deprecated
    public JSONObject q;
    
    @Deprecated
    public JSONObject r;
    
    @Deprecated
    public JSONObject s;
    
    @Deprecated
    public JSONObject t;
    
    @Deprecated
    public JSONObject u;
    
    @Deprecated
    public JSONObject v;
    
    public JSONObject w;
    
    public a x;
    
    public d y;
    
    public e z;
    
    public boolean a() {
      return this.H;
    }
    
    public static class a {
      public boolean a;
      
      public boolean b;
      
      public JSONObject c;
    }
    
    public static class b {
      public boolean a;
      
      public String b;
      
      public String c;
      
      public String d;
      
      public boolean e;
    }
    
    public static class c {
      public String a;
      
      public String b;
    }
    
    public static class d {
      public String a;
      
      public String b;
      
      public String c;
    }
    
    public static class e {
      public boolean a;
    }
    
    public static class f {
      public boolean a;
      
      public boolean b;
      
      public boolean c;
      
      public String d;
      
      public String e;
      
      public String f;
    }
  }
  
  public static class a {
    public boolean a;
    
    public boolean b;
    
    public JSONObject c;
  }
  
  public static class b {
    public boolean a;
    
    public String b;
    
    public String c;
    
    public String d;
    
    public boolean e;
  }
  
  public static class c {
    public String a;
    
    public String b;
  }
  
  public static class d {
    public String a;
    
    public String b;
    
    public String c;
  }
  
  public static class e {
    public boolean a;
  }
  
  public static class f {
    public boolean a;
    
    public boolean b;
    
    public boolean c;
    
    public String d;
    
    public String e;
    
    public String f;
  }
  
  static class b extends es {
    private String f;
    
    private Map<String, String> g;
    
    private boolean h;
    
    b(Context param1Context, da param1da, String param1String, Map<String, String> param1Map) {
      super(param1Context, param1da);
      boolean bool;
      this.f = param1String;
      this.g = param1Map;
      if (Build.VERSION.SDK_INT != 19) {
        bool = true;
      } else {
        bool = false;
      } 
      this.h = bool;
    }
    
    private Map<String, String> q() {
      String str2 = cu.v(this.a);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = cu.i(this.a); 
      str2 = str1;
      if (!TextUtils.isEmpty(str1))
        str2 = cx.b((new StringBuilder(str1)).reverse().toString()); 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("authkey", this.f);
      hashMap.put("plattype", "android");
      hashMap.put("product", this.b.a());
      hashMap.put("version", this.b.b());
      hashMap.put("output", "json");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Build.VERSION.SDK_INT);
      stringBuilder.append("");
      hashMap.put("androidversion", stringBuilder.toString());
      hashMap.put("deviceId", str2);
      hashMap.put("manufacture", Build.MANUFACTURER);
      Map<String, String> map = this.g;
      if (map != null && !map.isEmpty())
        hashMap.putAll(this.g); 
      hashMap.put("abitype", db.a(this.a));
      hashMap.put("ext", this.b.e());
      return (Map)hashMap;
    }
    
    public boolean a() {
      return this.h;
    }
    
    public byte[] b() {
      return null;
    }
    
    public byte[] c() {
      return db.a(db.a(q()));
    }
    
    protected String d() {
      return "3.0";
    }
    
    public Map<String, String> f() {
      return null;
    }
    
    public String h() {
      return this.h ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */