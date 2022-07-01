package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.b.a;
import com.cmic.sso.sdk.b.b.b;
import org.json.JSONObject;

public class x {
  private static volatile boolean a = false;
  
  public static String a(String paramString) {
    return p.b(paramString, "");
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    if (a) {
      f.a("UmcConfigUtil", "正在获取配置中...");
      return;
    } 
    a = true;
    a.a(paramContext).a(paramBundle.getBoolean("isNeedToGetCert", true), paramBundle, new b() {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            try {
              if ("103000".equals(param1String1))
                x.a(param1JSONObject); 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            x.a(false);
          }
        });
  }
  
  private static void a(JSONObject paramJSONObject, String paramString1, String paramString2, SharedPreferences.Editor paramEditor) {
    if (paramJSONObject.has(paramString1))
      paramEditor.putString(paramString1, paramJSONObject.optString(paramString1, paramString2)); 
  }
  
  public static boolean a() {
    return (System.currentTimeMillis() >= p.b("client_valid", 0L));
  }
  
  private static void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: invokestatic a : ()Landroid/content/SharedPreferences$Editor;
    //   3: astore #9
    //   5: aload #9
    //   7: ldc 'getConfigDate'
    //   9: invokestatic b : ()Ljava/lang/String;
    //   12: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   17: pop
    //   18: aload_0
    //   19: ldc 'client_valid'
    //   21: invokevirtual has : (Ljava/lang/String;)Z
    //   24: ifeq -> 68
    //   27: aload_0
    //   28: ldc 'client_valid'
    //   30: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   36: invokevirtual intValue : ()I
    //   39: i2l
    //   40: lstore_3
    //   41: aload #9
    //   43: ldc 'client_valid'
    //   45: invokestatic currentTimeMillis : ()J
    //   48: lload_3
    //   49: ldc2_w 60
    //   52: lmul
    //   53: ldc2_w 60
    //   56: lmul
    //   57: ldc2_w 1000
    //   60: lmul
    //   61: ladd
    //   62: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   67: pop
    //   68: aload_0
    //   69: ldc 'Configlist'
    //   71: invokevirtual has : (Ljava/lang/String;)Z
    //   74: ifeq -> 1356
    //   77: aload_0
    //   78: ldc 'Configlist'
    //   80: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   83: astore #10
    //   85: aload #10
    //   87: ldc 'CHANGE_HOST'
    //   89: invokevirtual has : (Ljava/lang/String;)Z
    //   92: istore #5
    //   94: iload #5
    //   96: ifeq -> 1421
    //   99: aload #10
    //   101: ldc 'CHANGE_HOST'
    //   103: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   106: astore #8
    //   108: aload #8
    //   110: ldc 'M005'
    //   112: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   115: istore #5
    //   117: iload #5
    //   119: ifeq -> 1395
    //   122: aload #8
    //   124: ldc '&'
    //   126: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   129: astore #6
    //   131: aload #6
    //   133: arraylength
    //   134: istore_2
    //   135: iconst_0
    //   136: istore_1
    //   137: iload_1
    //   138: iload_2
    //   139: if_icmpge -> 1382
    //   142: aload #6
    //   144: iload_1
    //   145: aaload
    //   146: astore_0
    //   147: aload_0
    //   148: ldc 'M005'
    //   150: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   153: ifeq -> 1375
    //   156: goto -> 159
    //   159: aload_0
    //   160: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   163: ifne -> 1387
    //   166: aload_0
    //   167: ldc ','
    //   169: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   172: ifeq -> 211
    //   175: aload_0
    //   176: aload_0
    //   177: ldc '='
    //   179: invokevirtual indexOf : (Ljava/lang/String;)I
    //   182: iconst_1
    //   183: iadd
    //   184: aload_0
    //   185: ldc ','
    //   187: invokevirtual indexOf : (Ljava/lang/String;)I
    //   190: invokevirtual substring : (II)Ljava/lang/String;
    //   193: astore #6
    //   195: aload_0
    //   196: aload_0
    //   197: ldc '='
    //   199: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   202: iconst_1
    //   203: iadd
    //   204: invokevirtual substring : (I)Ljava/lang/String;
    //   207: astore_0
    //   208: goto -> 286
    //   211: aload_0
    //   212: ldc 'https'
    //   214: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   217: ifne -> 267
    //   220: aload_0
    //   221: ldc 'HTTPS'
    //   223: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   226: ifeq -> 232
    //   229: goto -> 267
    //   232: aload_0
    //   233: ldc 'http'
    //   235: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   238: ifne -> 250
    //   241: aload_0
    //   242: ldc 'HTTP'
    //   244: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   247: ifeq -> 1387
    //   250: aload_0
    //   251: aload_0
    //   252: ldc '='
    //   254: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   257: iconst_1
    //   258: iadd
    //   259: invokevirtual substring : (I)Ljava/lang/String;
    //   262: astore #6
    //   264: goto -> 1390
    //   267: aload_0
    //   268: aload_0
    //   269: ldc '='
    //   271: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   274: iconst_1
    //   275: iadd
    //   276: invokevirtual substring : (I)Ljava/lang/String;
    //   279: astore_0
    //   280: aconst_null
    //   281: astore #6
    //   283: goto -> 286
    //   286: new java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial <init> : ()V
    //   293: astore #7
    //   295: aload #7
    //   297: ldc 'HTTP:'
    //   299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload #7
    //   305: aload #6
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #7
    //   313: ldc '||||||||HTTPS:'
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #7
    //   321: aload_0
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: ldc 'UmcConfigUtil'
    //   328: aload #7
    //   330: invokevirtual toString : ()Ljava/lang/String;
    //   333: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload #9
    //   338: ldc 'httpHost'
    //   340: aload #6
    //   342: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   347: pop
    //   348: aload #9
    //   350: ldc 'httpsHost'
    //   352: aload_0
    //   353: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   358: pop
    //   359: aload_0
    //   360: astore #7
    //   362: goto -> 365
    //   365: aload #8
    //   367: ldc 'M007'
    //   369: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   372: ifeq -> 1416
    //   375: aload #8
    //   377: ldc '&'
    //   379: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   382: astore #6
    //   384: aload #6
    //   386: arraylength
    //   387: istore_2
    //   388: iconst_0
    //   389: istore_1
    //   390: iload_1
    //   391: iload_2
    //   392: if_icmpge -> 1408
    //   395: aload #6
    //   397: iload_1
    //   398: aaload
    //   399: astore_0
    //   400: aload_0
    //   401: ldc 'M007'
    //   403: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   406: ifeq -> 1401
    //   409: goto -> 412
    //   412: aload_0
    //   413: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   416: ifne -> 1413
    //   419: aload_0
    //   420: aload_0
    //   421: ldc '='
    //   423: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   426: iconst_1
    //   427: iadd
    //   428: invokevirtual substring : (I)Ljava/lang/String;
    //   431: astore_0
    //   432: goto -> 435
    //   435: new java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial <init> : ()V
    //   442: astore #6
    //   444: aload #6
    //   446: ldc 'HTTPS:'
    //   448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload #6
    //   454: aload_0
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: ldc 'UmcConfigUtil'
    //   461: aload #6
    //   463: invokevirtual toString : ()Ljava/lang/String;
    //   466: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload #9
    //   471: ldc 'logHost'
    //   473: aload_0
    //   474: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   479: pop
    //   480: goto -> 483
    //   483: aload #10
    //   485: ldc 'HOST_CERT_INFO'
    //   487: invokevirtual has : (Ljava/lang/String;)Z
    //   490: ifeq -> 1125
    //   493: aload #10
    //   495: ldc 'HOST_CERT_INFO'
    //   497: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   500: astore #12
    //   502: aload #12
    //   504: ldc '&'
    //   506: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   509: astore #11
    //   511: aload_0
    //   512: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   515: istore #5
    //   517: iload #5
    //   519: ifne -> 1429
    //   522: aload_0
    //   523: ldc ':'
    //   525: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   528: ifeq -> 1429
    //   531: aload_0
    //   532: iconst_0
    //   533: aload_0
    //   534: ldc ':'
    //   536: invokevirtual indexOf : (Ljava/lang/String;)I
    //   539: invokevirtual substring : (II)Ljava/lang/String;
    //   542: astore #6
    //   544: new java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial <init> : ()V
    //   551: astore #8
    //   553: aload #8
    //   555: ldc 'logHostWithoutHost:'
    //   557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload #8
    //   563: aload #6
    //   565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: ldc 'UmcConfigUtil'
    //   571: aload #8
    //   573: invokevirtual toString : ()Ljava/lang/String;
    //   576: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   579: goto -> 582
    //   582: aload_0
    //   583: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   586: ifne -> 1451
    //   589: aload #12
    //   591: aload #6
    //   593: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   596: ifeq -> 1451
    //   599: aload #11
    //   601: arraylength
    //   602: istore_2
    //   603: iconst_0
    //   604: istore_1
    //   605: iload_1
    //   606: iload_2
    //   607: if_icmpge -> 1442
    //   610: aload #11
    //   612: iload_1
    //   613: aaload
    //   614: astore #8
    //   616: aload_0
    //   617: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   620: ifne -> 1435
    //   623: aload #8
    //   625: aload #6
    //   627: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   630: ifeq -> 1435
    //   633: aload #8
    //   635: astore #6
    //   637: goto -> 640
    //   640: aload #6
    //   642: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   645: ifne -> 1448
    //   648: aload #6
    //   650: aload #6
    //   652: ldc ':'
    //   654: invokevirtual indexOf : (Ljava/lang/String;)I
    //   657: iconst_1
    //   658: iadd
    //   659: aload #6
    //   661: ldc ','
    //   663: invokevirtual indexOf : (Ljava/lang/String;)I
    //   666: invokevirtual substring : (II)Ljava/lang/String;
    //   669: astore #6
    //   671: goto -> 674
    //   674: ldc 'UmcConfigUtil'
    //   676: ldc 'log CERT:'
    //   678: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   681: new java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial <init> : ()V
    //   688: astore #8
    //   690: aload #8
    //   692: ldc 'https://'
    //   694: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload #8
    //   700: aload_0
    //   701: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload #8
    //   707: ldc '/log/logReport'
    //   709: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #9
    //   715: aload #8
    //   717: invokevirtual toString : ()Ljava/lang/String;
    //   720: aload #6
    //   722: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   727: pop
    //   728: goto -> 731
    //   731: aload #6
    //   733: astore_0
    //   734: aload #12
    //   736: ldc 'log1.cmpassport.com'
    //   738: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   741: ifeq -> 819
    //   744: aload #11
    //   746: arraylength
    //   747: istore_2
    //   748: iconst_0
    //   749: istore_1
    //   750: iload_1
    //   751: iload_2
    //   752: if_icmpge -> 1464
    //   755: aload #11
    //   757: iload_1
    //   758: aaload
    //   759: astore_0
    //   760: aload_0
    //   761: ldc 'log1.cmpassport.com'
    //   763: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   766: ifeq -> 1457
    //   769: goto -> 772
    //   772: aload_0
    //   773: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   776: ifne -> 1470
    //   779: aload_0
    //   780: aload_0
    //   781: ldc ':'
    //   783: invokevirtual indexOf : (Ljava/lang/String;)I
    //   786: iconst_1
    //   787: iadd
    //   788: aload_0
    //   789: ldc ','
    //   791: invokevirtual indexOf : (Ljava/lang/String;)I
    //   794: invokevirtual substring : (II)Ljava/lang/String;
    //   797: astore_0
    //   798: goto -> 801
    //   801: ldc 'UmcConfigUtil'
    //   803: ldc 'log1 CERT:'
    //   805: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   808: aload #9
    //   810: ldc 'https://log1.cmpassport.com:9443/log/logReport'
    //   812: aload_0
    //   813: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   818: pop
    //   819: aload #7
    //   821: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   824: ifne -> 1473
    //   827: aload #7
    //   829: ldc ':'
    //   831: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   834: ifeq -> 1473
    //   837: aload #7
    //   839: iconst_0
    //   840: aload #7
    //   842: ldc ':'
    //   844: invokevirtual indexOf : (Ljava/lang/String;)I
    //   847: invokevirtual substring : (II)Ljava/lang/String;
    //   850: astore #8
    //   852: new java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial <init> : ()V
    //   859: astore #6
    //   861: aload #6
    //   863: ldc 'httpsHostWithoutPort:'
    //   865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload #6
    //   871: aload #8
    //   873: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: ldc 'UmcConfigUtil'
    //   879: aload #6
    //   881: invokevirtual toString : ()Ljava/lang/String;
    //   884: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   887: goto -> 890
    //   890: aload_0
    //   891: astore #6
    //   893: aload #7
    //   895: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   898: ifne -> 1035
    //   901: aload_0
    //   902: astore #6
    //   904: aload #12
    //   906: aload #8
    //   908: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   911: ifeq -> 1035
    //   914: aload #11
    //   916: arraylength
    //   917: istore_2
    //   918: iconst_0
    //   919: istore_1
    //   920: iload_1
    //   921: iload_2
    //   922: if_icmpge -> 1487
    //   925: aload #11
    //   927: iload_1
    //   928: aaload
    //   929: astore #6
    //   931: aload #7
    //   933: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   936: ifne -> 1480
    //   939: aload #6
    //   941: aload #8
    //   943: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   946: ifeq -> 1480
    //   949: aload #6
    //   951: astore_0
    //   952: goto -> 955
    //   955: aload_0
    //   956: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   959: ifne -> 1490
    //   962: aload_0
    //   963: aload_0
    //   964: ldc ':'
    //   966: invokevirtual indexOf : (Ljava/lang/String;)I
    //   969: iconst_1
    //   970: iadd
    //   971: aload_0
    //   972: ldc ','
    //   974: invokevirtual indexOf : (Ljava/lang/String;)I
    //   977: invokevirtual substring : (II)Ljava/lang/String;
    //   980: astore #6
    //   982: goto -> 985
    //   985: ldc 'UmcConfigUtil'
    //   987: ldc 'httpsHost CERT:'
    //   989: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   992: new java/lang/StringBuilder
    //   995: dup
    //   996: invokespecial <init> : ()V
    //   999: astore_0
    //   1000: aload_0
    //   1001: ldc 'https://'
    //   1003: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: aload_0
    //   1008: aload #7
    //   1010: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: pop
    //   1014: aload_0
    //   1015: ldc '/unisdk/'
    //   1017: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload #9
    //   1023: aload_0
    //   1024: invokevirtual toString : ()Ljava/lang/String;
    //   1027: aload #6
    //   1029: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1034: pop
    //   1035: aload #12
    //   1037: ldc 'onekey.cmpassport.com'
    //   1039: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1042: ifeq -> 1125
    //   1045: aload #11
    //   1047: arraylength
    //   1048: istore_2
    //   1049: iconst_0
    //   1050: istore_1
    //   1051: aload #6
    //   1053: astore_0
    //   1054: iload_1
    //   1055: iload_2
    //   1056: if_icmpge -> 1076
    //   1059: aload #11
    //   1061: iload_1
    //   1062: aaload
    //   1063: astore_0
    //   1064: aload_0
    //   1065: ldc 'onekey.cmpassport.com'
    //   1067: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1070: ifeq -> 1496
    //   1073: goto -> 1076
    //   1076: aload_0
    //   1077: astore #6
    //   1079: aload_0
    //   1080: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1083: ifne -> 1106
    //   1086: aload_0
    //   1087: aload_0
    //   1088: ldc ':'
    //   1090: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1093: iconst_1
    //   1094: iadd
    //   1095: aload_0
    //   1096: ldc ','
    //   1098: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1101: invokevirtual substring : (II)Ljava/lang/String;
    //   1104: astore #6
    //   1106: ldc 'UmcConfigUtil'
    //   1108: ldc 'omekey1 CERT:'
    //   1110: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1113: aload #9
    //   1115: ldc 'https://onekey.cmpassport.com:443/unisdk/'
    //   1117: aload #6
    //   1119: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   1124: pop
    //   1125: aload #10
    //   1127: ldc 'CLOSE_CERT_VERIFY'
    //   1129: ldc '0'
    //   1131: aload #9
    //   1133: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1136: aload #10
    //   1138: ldc 'CLOSE_FRIEND_WAPKS'
    //   1140: ldc '0'
    //   1142: aload #9
    //   1144: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1147: aload #10
    //   1149: ldc 'CLOSE_LOGS_VERSION'
    //   1151: ldc '0'
    //   1153: aload #9
    //   1155: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1158: aload #10
    //   1160: ldc 'CLOSE_IPV4_LIST'
    //   1162: ldc '0'
    //   1164: aload #9
    //   1166: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1169: aload #10
    //   1171: ldc 'CLOSE_IPV6_LIST'
    //   1173: ldc '1'
    //   1175: aload #9
    //   1177: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1180: aload #10
    //   1182: ldc 'CLOSE_M001_SDKVERSION_LIST'
    //   1184: ldc '0'
    //   1186: aload #9
    //   1188: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1191: aload #10
    //   1193: ldc 'CLOSE_M001_APPID_LIST'
    //   1195: ldc '0'
    //   1197: aload #9
    //   1199: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1202: aload #10
    //   1204: ldc 'CLOSE_M005_SDKVERSION_LIST'
    //   1206: ldc '0'
    //   1208: aload #9
    //   1210: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1213: aload #10
    //   1215: ldc 'CLOSE_M005_APPID_LIST'
    //   1217: ldc '0'
    //   1219: aload #9
    //   1221: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V
    //   1224: aload #10
    //   1226: ldc 'LOGS_CONTROL'
    //   1228: invokevirtual has : (Ljava/lang/String;)Z
    //   1231: ifeq -> 1320
    //   1234: aload #10
    //   1236: ldc 'LOGS_CONTROL'
    //   1238: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1241: ldc 'h'
    //   1243: ldc ''
    //   1245: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1248: ldc '&'
    //   1250: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1253: astore_0
    //   1254: aload_0
    //   1255: arraylength
    //   1256: ifle -> 1285
    //   1259: aload_0
    //   1260: iconst_0
    //   1261: aaload
    //   1262: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1265: ifne -> 1285
    //   1268: aload #9
    //   1270: ldc_w 'maxFailedLogTimes'
    //   1273: aload_0
    //   1274: iconst_0
    //   1275: aaload
    //   1276: invokestatic parseInt : (Ljava/lang/String;)I
    //   1279: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1284: pop
    //   1285: iconst_1
    //   1286: aload_0
    //   1287: arraylength
    //   1288: if_icmpge -> 1356
    //   1291: aload_0
    //   1292: iconst_1
    //   1293: aaload
    //   1294: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1297: ifne -> 1356
    //   1300: aload #9
    //   1302: ldc_w 'pauseTime'
    //   1305: aload_0
    //   1306: iconst_1
    //   1307: aaload
    //   1308: invokestatic parseInt : (Ljava/lang/String;)I
    //   1311: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1316: pop
    //   1317: goto -> 1356
    //   1320: aload #9
    //   1322: ldc_w 'maxFailedLogTimes'
    //   1325: iconst_0
    //   1326: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1331: pop
    //   1332: aload #9
    //   1334: ldc_w 'pauseTime'
    //   1337: iconst_0
    //   1338: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1343: pop
    //   1344: goto -> 1356
    //   1347: astore_0
    //   1348: goto -> 1365
    //   1351: astore_0
    //   1352: aload_0
    //   1353: invokevirtual printStackTrace : ()V
    //   1356: aload #9
    //   1358: invokeinterface commit : ()Z
    //   1363: pop
    //   1364: return
    //   1365: aload #9
    //   1367: invokeinterface commit : ()Z
    //   1372: pop
    //   1373: aload_0
    //   1374: athrow
    //   1375: iload_1
    //   1376: iconst_1
    //   1377: iadd
    //   1378: istore_1
    //   1379: goto -> 137
    //   1382: aconst_null
    //   1383: astore_0
    //   1384: goto -> 159
    //   1387: aconst_null
    //   1388: astore #6
    //   1390: aconst_null
    //   1391: astore_0
    //   1392: goto -> 286
    //   1395: aconst_null
    //   1396: astore #7
    //   1398: goto -> 365
    //   1401: iload_1
    //   1402: iconst_1
    //   1403: iadd
    //   1404: istore_1
    //   1405: goto -> 390
    //   1408: aconst_null
    //   1409: astore_0
    //   1410: goto -> 412
    //   1413: goto -> 435
    //   1416: aconst_null
    //   1417: astore_0
    //   1418: goto -> 483
    //   1421: aconst_null
    //   1422: astore_0
    //   1423: aconst_null
    //   1424: astore #7
    //   1426: goto -> 483
    //   1429: aload_0
    //   1430: astore #6
    //   1432: goto -> 582
    //   1435: iload_1
    //   1436: iconst_1
    //   1437: iadd
    //   1438: istore_1
    //   1439: goto -> 605
    //   1442: aconst_null
    //   1443: astore #6
    //   1445: goto -> 640
    //   1448: goto -> 674
    //   1451: aconst_null
    //   1452: astore #6
    //   1454: goto -> 731
    //   1457: iload_1
    //   1458: iconst_1
    //   1459: iadd
    //   1460: istore_1
    //   1461: goto -> 750
    //   1464: aload #6
    //   1466: astore_0
    //   1467: goto -> 772
    //   1470: goto -> 801
    //   1473: aload #7
    //   1475: astore #8
    //   1477: goto -> 890
    //   1480: iload_1
    //   1481: iconst_1
    //   1482: iadd
    //   1483: istore_1
    //   1484: goto -> 920
    //   1487: goto -> 955
    //   1490: aload_0
    //   1491: astore #6
    //   1493: goto -> 985
    //   1496: iload_1
    //   1497: iconst_1
    //   1498: iadd
    //   1499: istore_1
    //   1500: goto -> 1051
    // Exception table:
    //   from	to	target	type
    //   5	68	1351	java/lang/Exception
    //   5	68	1347	finally
    //   68	94	1351	java/lang/Exception
    //   68	94	1347	finally
    //   99	117	1351	java/lang/Exception
    //   99	117	1347	finally
    //   122	135	1351	java/lang/Exception
    //   122	135	1347	finally
    //   147	156	1351	java/lang/Exception
    //   147	156	1347	finally
    //   159	208	1351	java/lang/Exception
    //   159	208	1347	finally
    //   211	229	1351	java/lang/Exception
    //   211	229	1347	finally
    //   232	250	1351	java/lang/Exception
    //   232	250	1347	finally
    //   250	264	1351	java/lang/Exception
    //   250	264	1347	finally
    //   267	280	1351	java/lang/Exception
    //   267	280	1347	finally
    //   286	359	1351	java/lang/Exception
    //   286	359	1347	finally
    //   365	388	1351	java/lang/Exception
    //   365	388	1347	finally
    //   400	409	1351	java/lang/Exception
    //   400	409	1347	finally
    //   412	432	1351	java/lang/Exception
    //   412	432	1347	finally
    //   435	480	1351	java/lang/Exception
    //   435	480	1347	finally
    //   483	517	1351	java/lang/Exception
    //   483	517	1347	finally
    //   522	579	1351	java/lang/Exception
    //   522	579	1347	finally
    //   582	603	1351	java/lang/Exception
    //   582	603	1347	finally
    //   616	633	1351	java/lang/Exception
    //   616	633	1347	finally
    //   640	671	1351	java/lang/Exception
    //   640	671	1347	finally
    //   674	728	1351	java/lang/Exception
    //   674	728	1347	finally
    //   734	748	1351	java/lang/Exception
    //   734	748	1347	finally
    //   760	769	1351	java/lang/Exception
    //   760	769	1347	finally
    //   772	798	1351	java/lang/Exception
    //   772	798	1347	finally
    //   801	819	1351	java/lang/Exception
    //   801	819	1347	finally
    //   819	887	1351	java/lang/Exception
    //   819	887	1347	finally
    //   893	901	1351	java/lang/Exception
    //   893	901	1347	finally
    //   904	918	1351	java/lang/Exception
    //   904	918	1347	finally
    //   931	949	1351	java/lang/Exception
    //   931	949	1347	finally
    //   955	982	1351	java/lang/Exception
    //   955	982	1347	finally
    //   985	1035	1351	java/lang/Exception
    //   985	1035	1347	finally
    //   1035	1049	1351	java/lang/Exception
    //   1035	1049	1347	finally
    //   1064	1073	1351	java/lang/Exception
    //   1064	1073	1347	finally
    //   1079	1106	1351	java/lang/Exception
    //   1079	1106	1347	finally
    //   1106	1125	1351	java/lang/Exception
    //   1106	1125	1347	finally
    //   1125	1285	1351	java/lang/Exception
    //   1125	1285	1347	finally
    //   1285	1317	1351	java/lang/Exception
    //   1285	1317	1347	finally
    //   1320	1344	1351	java/lang/Exception
    //   1320	1344	1347	finally
    //   1352	1356	1347	finally
  }
  
  public static boolean b() {
    return "1".equals(p.b("CLOSE_IPV4_LIST", "0"));
  }
  
  public static boolean c() {
    return "1".equals(p.b("CLOSE_IPV6_LIST", "0"));
  }
  
  public static boolean d() {
    return ("1".equals(p.b("CLOSE_M001_SDKVERSION_LIST", "0")) || "1".equals(p.b("CLOSE_M001_APPID_LIST", "0")) || "1".equals(p.b("CLOSE_M005_APPID_LIST", "0")) || "1".equals(p.b("CLOSE_M005_SDKVERSION_LIST", "0")));
  }
  
  public static String e() {
    String str = p.b("httpHost", (String)null);
    if (TextUtils.isEmpty(str))
      return "http://onekey.cmpassport.com/unisdk/"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append(str);
    stringBuilder.append("/unisdk/");
    return stringBuilder.toString();
  }
  
  public static String f() {
    String str = p.b("httpsHost", (String)null);
    if (TextUtils.isEmpty(str))
      return "https://onekey.cmpassport.com:443/unisdk/"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://");
    stringBuilder.append(str);
    stringBuilder.append("/unisdk/");
    return stringBuilder.toString();
  }
  
  public static String g() {
    String str = p.b("logHost", "");
    if (TextUtils.isEmpty(str))
      return "https://log1.cmpassport.com:9443/log/logReport"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://");
    stringBuilder.append(str);
    stringBuilder.append("/log/logReport");
    return stringBuilder.toString();
  }
  
  public static boolean h() {
    return "1".equals(p.b("CLOSE_CERT_VERIFY", "1"));
  }
  
  public static boolean i() {
    return p.b("CLOSE_FRIEND_WAPKS", "").contains("CU");
  }
  
  public static boolean j() {
    return p.b("CLOSE_FRIEND_WAPKS", "").contains("CT");
  }
  
  public static boolean k() {
    return "1".equals(p.b("CLOSE_LOGS_VERSION", "0"));
  }
  
  public static int l() {
    return p.a("maxFailedLogTimes", 0);
  }
  
  public static int m() {
    return p.a("pauseTime", 0) * 60 * 60 * 1000;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */