package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;

public class e {
  public static final String a = "failed";
  
  public static final String b = "scheme_failed";
  
  private Activity c;
  
  private volatile IAlixPay d;
  
  private final Object e = IAlixPay.class;
  
  private boolean f;
  
  private a g;
  
  private final com.alipay.sdk.sys.a h;
  
  private ServiceConnection i = new f(this);
  
  private String j = null;
  
  private IRemoteServiceCallback k = (IRemoteServiceCallback)new h(this);
  
  public e(Activity paramActivity, com.alipay.sdk.sys.a parama, a parama1) {
    this.c = paramActivity;
    this.h = parama;
    this.g = parama1;
  }
  
  private String a(String paramString1, String paramString2, PackageInfo paramPackageInfo) {
    // Byte code:
    //   0: aload_1
    //   1: astore #9
    //   3: aload_3
    //   4: ifnull -> 16
    //   7: aload_3
    //   8: getfield versionCode : I
    //   11: istore #4
    //   13: goto -> 19
    //   16: iconst_0
    //   17: istore #4
    //   19: aload_3
    //   20: ifnull -> 31
    //   23: aload_3
    //   24: getfield versionName : Ljava/lang/String;
    //   27: astore_3
    //   28: goto -> 34
    //   31: ldc ''
    //   33: astore_3
    //   34: ldc 'mspl'
    //   36: ldc 'pay bind or scheme'
    //   38: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield h : Lcom/alipay/sdk/sys/a;
    //   45: astore #10
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #11
    //   56: aload #11
    //   58: aload_2
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #11
    //   65: ldc '|'
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #11
    //   73: aload_3
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #10
    //   80: ldc 'biz'
    //   82: ldc 'PgWltVer'
    //   84: aload #11
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: aload #9
    //   95: aload_2
    //   96: aload_0
    //   97: getfield h : Lcom/alipay/sdk/sys/a;
    //   100: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Lcom/alipay/sdk/sys/a;)Ljava/lang/String;
    //   103: astore_3
    //   104: new java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial <init> : ()V
    //   111: astore #10
    //   113: aload #10
    //   115: ldc 'pay bind result: '
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload #10
    //   123: aload_3
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 'mspl'
    //   130: aload #10
    //   132: invokevirtual toString : ()Ljava/lang/String;
    //   135: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield c : Landroid/app/Activity;
    //   142: astore #10
    //   144: aload_0
    //   145: getfield h : Lcom/alipay/sdk/sys/a;
    //   148: astore #11
    //   150: aload #10
    //   152: aload #11
    //   154: aload #9
    //   156: aload #11
    //   158: getfield p : Ljava/lang/String;
    //   161: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   164: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   167: invokevirtual c : ()Z
    //   170: istore #6
    //   172: ldc 'failed'
    //   174: aload_3
    //   175: invokevirtual equals : (Ljava/lang/Object;)Z
    //   178: ifeq -> 213
    //   181: ldc 'com.eg.android.AlipayGphone'
    //   183: aload_2
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifeq -> 213
    //   190: iload #4
    //   192: bipush #125
    //   194: if_icmple -> 213
    //   197: iload #6
    //   199: ifne -> 213
    //   202: aload_0
    //   203: getfield h : Lcom/alipay/sdk/sys/a;
    //   206: ldc 'biz'
    //   208: ldc 'BSPNotStartByConfig'
    //   210: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   213: ldc 'failed'
    //   215: aload_3
    //   216: invokevirtual equals : (Ljava/lang/Object;)Z
    //   219: ifeq -> 1113
    //   222: ldc 'com.eg.android.AlipayGphone'
    //   224: aload_2
    //   225: invokevirtual equals : (Ljava/lang/Object;)Z
    //   228: ifeq -> 1113
    //   231: iload #4
    //   233: bipush #125
    //   235: if_icmple -> 1113
    //   238: iload #6
    //   240: ifeq -> 1113
    //   243: aload_0
    //   244: getfield c : Landroid/app/Activity;
    //   247: astore #10
    //   249: ldc 'scheme_failed'
    //   251: astore_3
    //   252: aload #10
    //   254: ifnull -> 1111
    //   257: aload_2
    //   258: aload #10
    //   260: aload_0
    //   261: getfield h : Lcom/alipay/sdk/sys/a;
    //   264: invokestatic a : (Ljava/lang/String;Landroid/content/Context;Lcom/alipay/sdk/sys/a;)Z
    //   267: ifne -> 273
    //   270: ldc 'scheme_failed'
    //   272: areturn
    //   273: new java/util/concurrent/CountDownLatch
    //   276: dup
    //   277: iconst_1
    //   278: invokespecial <init> : (I)V
    //   281: astore #14
    //   283: bipush #32
    //   285: invokestatic a : (I)Ljava/lang/String;
    //   288: astore #15
    //   290: invokestatic elapsedRealtime : ()J
    //   293: lstore #7
    //   295: aload_0
    //   296: getfield h : Lcom/alipay/sdk/sys/a;
    //   299: astore_3
    //   300: new java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial <init> : ()V
    //   307: astore #10
    //   309: aload #10
    //   311: aload #15
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #10
    //   319: ldc '|'
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload #10
    //   327: lload #7
    //   329: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_3
    //   334: ldc 'biz'
    //   336: ldc 'BSPStart'
    //   338: aload #10
    //   340: invokevirtual toString : ()Ljava/lang/String;
    //   343: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload_0
    //   347: getfield h : Lcom/alipay/sdk/sys/a;
    //   350: aload #15
    //   352: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)V
    //   355: new com/alipay/sdk/util/g
    //   358: dup
    //   359: aload_0
    //   360: aload #14
    //   362: invokespecial <init> : (Lcom/alipay/sdk/util/e;Ljava/util/concurrent/CountDownLatch;)V
    //   365: astore_3
    //   366: getstatic com/alipay/sdk/app/AlipayResultActivity.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   369: aload #15
    //   371: aload_3
    //   372: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   375: pop
    //   376: aload #9
    //   378: ldc '&'
    //   380: iconst_m1
    //   381: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   384: astore_3
    //   385: aload_3
    //   386: arraylength
    //   387: istore #5
    //   389: iconst_0
    //   390: istore #4
    //   392: aconst_null
    //   393: astore #11
    //   395: iload #4
    //   397: iload #5
    //   399: if_icmpge -> 1130
    //   402: aload_3
    //   403: iload #4
    //   405: aaload
    //   406: astore #13
    //   408: aload #13
    //   410: ldc 'bizcontext='
    //   412: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   415: ifeq -> 1121
    //   418: aload #13
    //   420: aload #13
    //   422: ldc '{'
    //   424: invokevirtual indexOf : (Ljava/lang/String;)I
    //   427: aload #13
    //   429: ldc '}'
    //   431: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   434: iconst_1
    //   435: iadd
    //   436: invokevirtual substring : (II)Ljava/lang/String;
    //   439: astore_3
    //   440: aload #13
    //   442: aload_3
    //   443: invokevirtual indexOf : (Ljava/lang/String;)I
    //   446: istore #4
    //   448: aload #13
    //   450: iconst_0
    //   451: iload #4
    //   453: invokevirtual substring : (II)Ljava/lang/String;
    //   456: astore #12
    //   458: aload #13
    //   460: iload #4
    //   462: aload_3
    //   463: invokevirtual length : ()I
    //   466: iadd
    //   467: invokevirtual substring : (I)Ljava/lang/String;
    //   470: astore #10
    //   472: new org/json/JSONObject
    //   475: dup
    //   476: aload_3
    //   477: invokespecial <init> : (Ljava/lang/String;)V
    //   480: astore #11
    //   482: aload #11
    //   484: ldc 'sc'
    //   486: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   489: ldc 'h5tonative'
    //   491: invokevirtual equals : (Ljava/lang/Object;)Z
    //   494: ifeq -> 510
    //   497: aload #11
    //   499: ldc 'sc'
    //   501: ldc 'h5tonative_scheme'
    //   503: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: goto -> 1115
    //   510: aload #11
    //   512: ldc 'sc'
    //   514: ldc 'h5tonative_sdkscheme'
    //   516: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: goto -> 1115
    //   523: aload_3
    //   524: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   527: ifne -> 610
    //   530: aload #9
    //   532: aload_3
    //   533: invokevirtual indexOf : (Ljava/lang/String;)I
    //   536: aload #9
    //   538: aload_3
    //   539: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   542: if_icmpne -> 599
    //   545: new java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial <init> : ()V
    //   552: astore #13
    //   554: aload #13
    //   556: aload #12
    //   558: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload #13
    //   564: aload #11
    //   566: invokevirtual toString : ()Ljava/lang/String;
    //   569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload #13
    //   575: aload #10
    //   577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload #9
    //   583: aload_3
    //   584: aload #13
    //   586: invokevirtual toString : ()Ljava/lang/String;
    //   589: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   592: astore_3
    //   593: aload_3
    //   594: astore #9
    //   596: goto -> 651
    //   599: new java/lang/RuntimeException
    //   602: dup
    //   603: ldc_w 'multi ctx_args'
    //   606: invokespecial <init> : (Ljava/lang/String;)V
    //   609: athrow
    //   610: new java/lang/RuntimeException
    //   613: dup
    //   614: ldc_w 'empty ctx_args'
    //   617: invokespecial <init> : (Ljava/lang/String;)V
    //   620: athrow
    //   621: astore_1
    //   622: goto -> 1064
    //   625: astore_1
    //   626: goto -> 1080
    //   629: astore_3
    //   630: aload_0
    //   631: getfield h : Lcom/alipay/sdk/sys/a;
    //   634: ldc 'biz'
    //   636: ldc_w 'BSPSCReplaceEx'
    //   639: aload_3
    //   640: aload_1
    //   641: invokevirtual getBytes : ()[B
    //   644: iconst_2
    //   645: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   648: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   651: new org/json/JSONObject
    //   654: dup
    //   655: invokespecial <init> : ()V
    //   658: astore_1
    //   659: aload_1
    //   660: ldc_w 'sourcePid'
    //   663: invokestatic getCallingPid : ()I
    //   666: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   669: pop
    //   670: aload_1
    //   671: ldc_w 'external_info'
    //   674: aload #9
    //   676: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   679: pop
    //   680: aload_1
    //   681: ldc_w 'pkgName'
    //   684: aload_0
    //   685: getfield c : Landroid/app/Activity;
    //   688: invokevirtual getPackageName : ()Ljava/lang/String;
    //   691: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   694: pop
    //   695: aload_1
    //   696: ldc_w 'session'
    //   699: aload #15
    //   701: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   704: pop
    //   705: aload_1
    //   706: invokevirtual toString : ()Ljava/lang/String;
    //   709: ldc_w 'UTF-8'
    //   712: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   715: iconst_2
    //   716: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   719: astore_3
    //   720: new android/net/Uri$Builder
    //   723: dup
    //   724: invokespecial <init> : ()V
    //   727: ldc_w 'alipays'
    //   730: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   733: ldc_w 'platformapi'
    //   736: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   739: ldc_w 'startapp'
    //   742: invokevirtual path : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   745: ldc_w 'appId'
    //   748: ldc_w '20000125'
    //   751: invokevirtual appendQueryParameter : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   754: astore_1
    //   755: aload_1
    //   756: ldc_w 'mqpSchemePay'
    //   759: aload_3
    //   760: invokevirtual appendQueryParameter : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   763: pop
    //   764: aload_0
    //   765: getfield h : Lcom/alipay/sdk/sys/a;
    //   768: invokestatic a : (Lcom/alipay/sdk/sys/a;)Ljava/util/HashMap;
    //   771: astore_3
    //   772: aload_3
    //   773: ldc_w 'ts_scheme'
    //   776: lload #7
    //   778: invokestatic valueOf : (J)Ljava/lang/String;
    //   781: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   786: pop
    //   787: aload_1
    //   788: ldc_w 'mqpLoc'
    //   791: new org/json/JSONObject
    //   794: dup
    //   795: aload_3
    //   796: invokespecial <init> : (Ljava/util/Map;)V
    //   799: invokevirtual toString : ()Ljava/lang/String;
    //   802: invokevirtual appendQueryParameter : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   805: pop
    //   806: goto -> 823
    //   809: astore_3
    //   810: aload_0
    //   811: getfield h : Lcom/alipay/sdk/sys/a;
    //   814: ldc 'biz'
    //   816: ldc_w 'BSPLocEx'
    //   819: aload_3
    //   820: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   823: aload_1
    //   824: invokevirtual build : ()Landroid/net/Uri;
    //   827: invokevirtual toString : ()Ljava/lang/String;
    //   830: astore_1
    //   831: new android/content/Intent
    //   834: dup
    //   835: invokespecial <init> : ()V
    //   838: astore_3
    //   839: aload_3
    //   840: aload_2
    //   841: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   844: pop
    //   845: aload_3
    //   846: ldc_w 268435456
    //   849: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   852: pop
    //   853: aload_3
    //   854: aload_1
    //   855: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   858: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   861: pop
    //   862: aload_0
    //   863: getfield c : Landroid/app/Activity;
    //   866: aload_0
    //   867: getfield h : Lcom/alipay/sdk/sys/a;
    //   870: aload #9
    //   872: aload_0
    //   873: getfield h : Lcom/alipay/sdk/sys/a;
    //   876: getfield p : Ljava/lang/String;
    //   879: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   882: aload_0
    //   883: getfield c : Landroid/app/Activity;
    //   886: aload_3
    //   887: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   890: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   893: aload_0
    //   894: getfield h : Lcom/alipay/sdk/sys/a;
    //   897: aload_0
    //   898: getfield c : Landroid/app/Activity;
    //   901: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   904: invokevirtual a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;)V
    //   907: new java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial <init> : ()V
    //   914: astore_2
    //   915: aload_2
    //   916: ldc_w 'pay scheme waiting '
    //   919: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload_2
    //   924: aload_1
    //   925: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: ldc 'mspl'
    //   931: aload_2
    //   932: invokevirtual toString : ()Ljava/lang/String;
    //   935: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   938: aload #14
    //   940: invokevirtual await : ()V
    //   943: aload_0
    //   944: getfield j : Ljava/lang/String;
    //   947: astore_3
    //   948: aload_0
    //   949: getfield h : Lcom/alipay/sdk/sys/a;
    //   952: aload_3
    //   953: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;)Ljava/util/Map;
    //   956: ldc_w 'resultStatus'
    //   959: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   964: checkcast java/lang/String
    //   967: astore_2
    //   968: aload_2
    //   969: astore_1
    //   970: aload_2
    //   971: ifnonnull -> 999
    //   974: ldc_w 'null'
    //   977: astore_1
    //   978: goto -> 999
    //   981: astore_2
    //   982: ldc_w 'unknown'
    //   985: astore_1
    //   986: aload_0
    //   987: getfield h : Lcom/alipay/sdk/sys/a;
    //   990: ldc 'biz'
    //   992: ldc_w 'BSPStatEx'
    //   995: aload_2
    //   996: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   999: aload_0
    //   1000: getfield h : Lcom/alipay/sdk/sys/a;
    //   1003: astore_2
    //   1004: new java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial <init> : ()V
    //   1011: astore #9
    //   1013: aload #9
    //   1015: ldc_w 'BSPDone-'
    //   1018: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload #9
    //   1024: aload_1
    //   1025: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: aload_2
    //   1030: ldc 'biz'
    //   1032: aload #9
    //   1034: invokevirtual toString : ()Ljava/lang/String;
    //   1037: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   1040: aload_3
    //   1041: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1044: ifeq -> 1062
    //   1047: aload_0
    //   1048: getfield h : Lcom/alipay/sdk/sys/a;
    //   1051: ldc 'biz'
    //   1053: ldc_w 'BSPEmpty'
    //   1056: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   1059: ldc 'scheme_failed'
    //   1061: areturn
    //   1062: aload_3
    //   1063: areturn
    //   1064: aload_0
    //   1065: getfield h : Lcom/alipay/sdk/sys/a;
    //   1068: ldc 'biz'
    //   1070: ldc_w 'BSPEx'
    //   1073: aload_1
    //   1074: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1077: ldc 'scheme_failed'
    //   1079: areturn
    //   1080: aload_0
    //   1081: getfield h : Lcom/alipay/sdk/sys/a;
    //   1084: ldc 'biz'
    //   1086: ldc_w 'BSPWaiting'
    //   1089: aload_1
    //   1090: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1093: getstatic com/alipay/sdk/app/k.g : Lcom/alipay/sdk/app/k;
    //   1096: invokevirtual a : ()I
    //   1099: getstatic com/alipay/sdk/app/k.g : Lcom/alipay/sdk/app/k;
    //   1102: invokevirtual b : ()Ljava/lang/String;
    //   1105: ldc ''
    //   1107: invokestatic a : (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1110: astore_3
    //   1111: aload_3
    //   1112: areturn
    //   1113: aload_3
    //   1114: areturn
    //   1115: aload #13
    //   1117: astore_3
    //   1118: goto -> 523
    //   1121: iload #4
    //   1123: iconst_1
    //   1124: iadd
    //   1125: istore #4
    //   1127: goto -> 392
    //   1130: ldc ''
    //   1132: astore #10
    //   1134: aload #10
    //   1136: astore #12
    //   1138: aconst_null
    //   1139: astore_3
    //   1140: goto -> 523
    // Exception table:
    //   from	to	target	type
    //   376	389	629	java/lang/Exception
    //   376	389	625	java/lang/InterruptedException
    //   376	389	621	finally
    //   408	507	629	java/lang/Exception
    //   408	507	625	java/lang/InterruptedException
    //   408	507	621	finally
    //   510	520	629	java/lang/Exception
    //   510	520	625	java/lang/InterruptedException
    //   510	520	621	finally
    //   523	593	629	java/lang/Exception
    //   523	593	625	java/lang/InterruptedException
    //   523	593	621	finally
    //   599	610	629	java/lang/Exception
    //   599	610	625	java/lang/InterruptedException
    //   599	610	621	finally
    //   610	621	629	java/lang/Exception
    //   610	621	625	java/lang/InterruptedException
    //   610	621	621	finally
    //   630	651	625	java/lang/InterruptedException
    //   630	651	621	finally
    //   651	764	625	java/lang/InterruptedException
    //   651	764	621	finally
    //   764	806	809	finally
    //   810	823	625	java/lang/InterruptedException
    //   810	823	621	finally
    //   823	948	625	java/lang/InterruptedException
    //   823	948	621	finally
    //   948	968	981	finally
    //   986	999	625	java/lang/InterruptedException
    //   986	999	621	finally
    //   999	1059	625	java/lang/InterruptedException
    //   999	1059	621	finally
  }
  
  private String a(String paramString1, String paramString2, com.alipay.sdk.sys.a parama) {
    // Byte code:
    //   0: new android/content/Intent
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #14
    //   9: aload #14
    //   11: aload_2
    //   12: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   15: pop
    //   16: aload #14
    //   18: aload_2
    //   19: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   22: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   25: pop
    //   26: aload_0
    //   27: getfield c : Landroid/app/Activity;
    //   30: aload_2
    //   31: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   34: astore #13
    //   36: invokestatic elapsedRealtime : ()J
    //   39: lstore #5
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #12
    //   50: aload #12
    //   52: ldc ''
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #12
    //   60: lload #5
    //   62: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #12
    //   68: ldc '|'
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: ifnull -> 87
    //   78: aload_1
    //   79: invokevirtual length : ()I
    //   82: istore #4
    //   84: goto -> 90
    //   87: iconst_0
    //   88: istore #4
    //   90: aload #12
    //   92: iload #4
    //   94: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_3
    //   99: ldc 'biz'
    //   101: ldc_w 'PgBindStarting'
    //   104: aload #12
    //   106: invokevirtual toString : ()Ljava/lang/String;
    //   109: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: getfield c : Landroid/app/Activity;
    //   116: aload_3
    //   117: aload_1
    //   118: aload_3
    //   119: getfield p : Ljava/lang/String;
    //   122: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   125: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   128: invokevirtual h : ()Z
    //   131: ifne -> 177
    //   134: aload_0
    //   135: getfield c : Landroid/app/Activity;
    //   138: invokevirtual getApplication : ()Landroid/app/Application;
    //   141: aload #14
    //   143: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
    //   146: astore #12
    //   148: aload #12
    //   150: ifnull -> 1217
    //   153: aload #12
    //   155: invokevirtual getPackageName : ()Ljava/lang/String;
    //   158: astore #12
    //   160: goto -> 163
    //   163: aload_3
    //   164: ldc 'biz'
    //   166: ldc_w 'stSrv'
    //   169: aload #12
    //   171: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -> 205
    //   177: aload_3
    //   178: ldc 'biz'
    //   180: ldc_w 'stSrv'
    //   183: ldc_w 'skipped'
    //   186: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -> 205
    //   192: astore #12
    //   194: aload_3
    //   195: ldc 'biz'
    //   197: ldc_w 'TryStartServiceEx'
    //   200: aload #12
    //   202: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_0
    //   206: getfield c : Landroid/app/Activity;
    //   209: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   212: aload #14
    //   214: aload_0
    //   215: getfield i : Landroid/content/ServiceConnection;
    //   218: iconst_1
    //   219: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   222: istore #11
    //   224: iload #11
    //   226: ifeq -> 1192
    //   229: aload_0
    //   230: getfield e : Ljava/lang/Object;
    //   233: astore #12
    //   235: aload #12
    //   237: monitorenter
    //   238: aload_0
    //   239: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   242: astore #14
    //   244: aload #14
    //   246: ifnonnull -> 279
    //   249: aload_0
    //   250: getfield e : Ljava/lang/Object;
    //   253: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   256: invokevirtual a : ()I
    //   259: i2l
    //   260: invokevirtual wait : (J)V
    //   263: goto -> 279
    //   266: astore #14
    //   268: aload_3
    //   269: ldc 'biz'
    //   271: ldc_w 'BindWaitTimeoutEx'
    //   274: aload #14
    //   276: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload #12
    //   281: monitorexit
    //   282: aload_0
    //   283: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   286: ifnonnull -> 485
    //   289: aload_0
    //   290: getfield c : Landroid/app/Activity;
    //   293: aload_2
    //   294: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   297: astore_2
    //   298: new java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial <init> : ()V
    //   305: astore #12
    //   307: aload #12
    //   309: aload #13
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload #12
    //   317: ldc '|'
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #12
    //   325: aload_2
    //   326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: ldc 'biz'
    //   333: ldc_w 'ClientBindFailed'
    //   336: aload #12
    //   338: invokevirtual toString : ()Ljava/lang/String;
    //   341: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   348: aload_0
    //   349: getfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   352: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   357: goto -> 365
    //   360: astore_2
    //   361: aload_2
    //   362: invokestatic a : (Ljava/lang/Throwable;)V
    //   365: aload_0
    //   366: getfield c : Landroid/app/Activity;
    //   369: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   372: aload_0
    //   373: getfield i : Landroid/content/ServiceConnection;
    //   376: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   379: goto -> 387
    //   382: astore_2
    //   383: aload_2
    //   384: invokestatic a : (Ljava/lang/Throwable;)V
    //   387: new java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial <init> : ()V
    //   394: astore_2
    //   395: aload_2
    //   396: ldc ''
    //   398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_2
    //   403: invokestatic elapsedRealtime : ()J
    //   406: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_3
    //   411: ldc 'biz'
    //   413: ldc_w 'PgBindEnd'
    //   416: aload_2
    //   417: invokevirtual toString : ()Ljava/lang/String;
    //   420: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload_0
    //   424: getfield c : Landroid/app/Activity;
    //   427: aload_3
    //   428: aload_1
    //   429: aload_3
    //   430: getfield p : Ljava/lang/String;
    //   433: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload_0
    //   437: aconst_null
    //   438: putfield g : Lcom/alipay/sdk/util/e$a;
    //   441: aload_0
    //   442: aconst_null
    //   443: putfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   446: aload_0
    //   447: aconst_null
    //   448: putfield i : Landroid/content/ServiceConnection;
    //   451: aload_0
    //   452: aconst_null
    //   453: putfield d : Lcom/alipay/android/app/IAlixPay;
    //   456: aload_0
    //   457: getfield f : Z
    //   460: ifeq -> 482
    //   463: aload_0
    //   464: getfield c : Landroid/app/Activity;
    //   467: astore_1
    //   468: aload_1
    //   469: ifnull -> 482
    //   472: aload_1
    //   473: iconst_0
    //   474: invokevirtual setRequestedOrientation : (I)V
    //   477: aload_0
    //   478: iconst_0
    //   479: putfield f : Z
    //   482: ldc 'failed'
    //   484: areturn
    //   485: invokestatic elapsedRealtime : ()J
    //   488: lstore #7
    //   490: new java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial <init> : ()V
    //   497: astore_2
    //   498: aload_2
    //   499: ldc ''
    //   501: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_2
    //   506: lload #7
    //   508: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload_3
    //   513: ldc 'biz'
    //   515: ldc_w 'PgBinded'
    //   518: aload_2
    //   519: invokevirtual toString : ()Ljava/lang/String;
    //   522: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield g : Lcom/alipay/sdk/util/e$a;
    //   529: ifnull -> 541
    //   532: aload_0
    //   533: getfield g : Lcom/alipay/sdk/util/e$a;
    //   536: invokeinterface a : ()V
    //   541: aload_0
    //   542: getfield c : Landroid/app/Activity;
    //   545: invokevirtual getRequestedOrientation : ()I
    //   548: ifne -> 564
    //   551: aload_0
    //   552: getfield c : Landroid/app/Activity;
    //   555: iconst_1
    //   556: invokevirtual setRequestedOrientation : (I)V
    //   559: aload_0
    //   560: iconst_1
    //   561: putfield f : Z
    //   564: aload_0
    //   565: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   568: invokeinterface getVersion : ()I
    //   573: istore #4
    //   575: goto -> 586
    //   578: astore_2
    //   579: aload_2
    //   580: invokestatic a : (Ljava/lang/Throwable;)V
    //   583: iconst_0
    //   584: istore #4
    //   586: aload_0
    //   587: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   590: aload_0
    //   591: getfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   594: invokeinterface registerCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   599: invokestatic elapsedRealtime : ()J
    //   602: lstore #9
    //   604: new java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial <init> : ()V
    //   611: astore_2
    //   612: aload_2
    //   613: ldc ''
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_2
    //   620: lload #9
    //   622: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_3
    //   627: ldc 'biz'
    //   629: ldc_w 'PgBindPay'
    //   632: aload_2
    //   633: invokevirtual toString : ()Ljava/lang/String;
    //   636: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   639: iload #4
    //   641: iconst_2
    //   642: if_icmplt -> 710
    //   645: aload_3
    //   646: invokestatic a : (Lcom/alipay/sdk/sys/a;)Ljava/util/HashMap;
    //   649: astore_2
    //   650: aload_2
    //   651: ldc_w 'ts_bind'
    //   654: lload #5
    //   656: invokestatic valueOf : (J)Ljava/lang/String;
    //   659: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   664: pop
    //   665: aload_2
    //   666: ldc_w 'ts_bend'
    //   669: lload #7
    //   671: invokestatic valueOf : (J)Ljava/lang/String;
    //   674: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: pop
    //   680: aload_2
    //   681: ldc_w 'ts_pay'
    //   684: lload #9
    //   686: invokestatic valueOf : (J)Ljava/lang/String;
    //   689: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   694: pop
    //   695: aload_0
    //   696: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   699: aload_1
    //   700: aload_2
    //   701: invokeinterface pay02 : (Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   706: astore_2
    //   707: goto -> 721
    //   710: aload_0
    //   711: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   714: aload_1
    //   715: invokeinterface Pay : (Ljava/lang/String;)Ljava/lang/String;
    //   720: astore_2
    //   721: aload_0
    //   722: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   725: aload_0
    //   726: getfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   729: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   734: goto -> 744
    //   737: astore #12
    //   739: aload #12
    //   741: invokestatic a : (Ljava/lang/Throwable;)V
    //   744: aload_0
    //   745: getfield c : Landroid/app/Activity;
    //   748: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   751: aload_0
    //   752: getfield i : Landroid/content/ServiceConnection;
    //   755: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   758: goto -> 768
    //   761: astore #12
    //   763: aload #12
    //   765: invokestatic a : (Ljava/lang/Throwable;)V
    //   768: new java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial <init> : ()V
    //   775: astore #12
    //   777: aload #12
    //   779: ldc ''
    //   781: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: aload #12
    //   787: invokestatic elapsedRealtime : ()J
    //   790: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload_3
    //   795: ldc 'biz'
    //   797: ldc_w 'PgBindEnd'
    //   800: aload #12
    //   802: invokevirtual toString : ()Ljava/lang/String;
    //   805: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   808: aload_0
    //   809: getfield c : Landroid/app/Activity;
    //   812: aload_3
    //   813: aload_1
    //   814: aload_3
    //   815: getfield p : Ljava/lang/String;
    //   818: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload_0
    //   822: aconst_null
    //   823: putfield g : Lcom/alipay/sdk/util/e$a;
    //   826: aload_0
    //   827: aconst_null
    //   828: putfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   831: aload_0
    //   832: aconst_null
    //   833: putfield i : Landroid/content/ServiceConnection;
    //   836: aload_0
    //   837: aconst_null
    //   838: putfield d : Lcom/alipay/android/app/IAlixPay;
    //   841: aload_2
    //   842: astore_1
    //   843: aload_0
    //   844: getfield f : Z
    //   847: ifeq -> 1035
    //   850: aload_0
    //   851: getfield c : Landroid/app/Activity;
    //   854: astore_3
    //   855: aload_2
    //   856: astore_1
    //   857: aload_3
    //   858: ifnull -> 1035
    //   861: aload_3
    //   862: astore_1
    //   863: aload_1
    //   864: iconst_0
    //   865: invokevirtual setRequestedOrientation : (I)V
    //   868: aload_0
    //   869: iconst_0
    //   870: putfield f : Z
    //   873: aload_2
    //   874: areturn
    //   875: astore_2
    //   876: aload_3
    //   877: ldc 'biz'
    //   879: ldc_w 'ClientBindException'
    //   882: aload_2
    //   883: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   886: invokestatic c : ()Ljava/lang/String;
    //   889: astore_2
    //   890: aload_0
    //   891: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   894: aload_0
    //   895: getfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   898: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   903: goto -> 913
    //   906: astore #12
    //   908: aload #12
    //   910: invokestatic a : (Ljava/lang/Throwable;)V
    //   913: aload_0
    //   914: getfield c : Landroid/app/Activity;
    //   917: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   920: aload_0
    //   921: getfield i : Landroid/content/ServiceConnection;
    //   924: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   927: goto -> 937
    //   930: astore #12
    //   932: aload #12
    //   934: invokestatic a : (Ljava/lang/Throwable;)V
    //   937: new java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial <init> : ()V
    //   944: astore #12
    //   946: aload #12
    //   948: ldc ''
    //   950: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload #12
    //   956: invokestatic elapsedRealtime : ()J
    //   959: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload_3
    //   964: ldc 'biz'
    //   966: ldc_w 'PgBindEnd'
    //   969: aload #12
    //   971: invokevirtual toString : ()Ljava/lang/String;
    //   974: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   977: aload_0
    //   978: getfield c : Landroid/app/Activity;
    //   981: aload_3
    //   982: aload_1
    //   983: aload_3
    //   984: getfield p : Ljava/lang/String;
    //   987: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   990: aload_0
    //   991: aconst_null
    //   992: putfield g : Lcom/alipay/sdk/util/e$a;
    //   995: aload_0
    //   996: aconst_null
    //   997: putfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   1000: aload_0
    //   1001: aconst_null
    //   1002: putfield i : Landroid/content/ServiceConnection;
    //   1005: aload_0
    //   1006: aconst_null
    //   1007: putfield d : Lcom/alipay/android/app/IAlixPay;
    //   1010: aload_2
    //   1011: astore_1
    //   1012: aload_0
    //   1013: getfield f : Z
    //   1016: ifeq -> 1035
    //   1019: aload_0
    //   1020: getfield c : Landroid/app/Activity;
    //   1023: astore_3
    //   1024: aload_2
    //   1025: astore_1
    //   1026: aload_3
    //   1027: ifnull -> 1035
    //   1030: aload_3
    //   1031: astore_1
    //   1032: goto -> 863
    //   1035: aload_1
    //   1036: areturn
    //   1037: astore_2
    //   1038: aload_0
    //   1039: getfield d : Lcom/alipay/android/app/IAlixPay;
    //   1042: aload_0
    //   1043: getfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   1046: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   1051: goto -> 1061
    //   1054: astore #12
    //   1056: aload #12
    //   1058: invokestatic a : (Ljava/lang/Throwable;)V
    //   1061: aload_0
    //   1062: getfield c : Landroid/app/Activity;
    //   1065: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   1068: aload_0
    //   1069: getfield i : Landroid/content/ServiceConnection;
    //   1072: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   1075: goto -> 1085
    //   1078: astore #12
    //   1080: aload #12
    //   1082: invokestatic a : (Ljava/lang/Throwable;)V
    //   1085: new java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial <init> : ()V
    //   1092: astore #12
    //   1094: aload #12
    //   1096: ldc ''
    //   1098: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload #12
    //   1104: invokestatic elapsedRealtime : ()J
    //   1107: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload_3
    //   1112: ldc 'biz'
    //   1114: ldc_w 'PgBindEnd'
    //   1117: aload #12
    //   1119: invokevirtual toString : ()Ljava/lang/String;
    //   1122: invokestatic b : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1125: aload_0
    //   1126: getfield c : Landroid/app/Activity;
    //   1129: aload_3
    //   1130: aload_1
    //   1131: aload_3
    //   1132: getfield p : Ljava/lang/String;
    //   1135: invokestatic a : (Landroid/content/Context;Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;)V
    //   1138: aload_0
    //   1139: aconst_null
    //   1140: putfield g : Lcom/alipay/sdk/util/e$a;
    //   1143: aload_0
    //   1144: aconst_null
    //   1145: putfield k : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   1148: aload_0
    //   1149: aconst_null
    //   1150: putfield i : Landroid/content/ServiceConnection;
    //   1153: aload_0
    //   1154: aconst_null
    //   1155: putfield d : Lcom/alipay/android/app/IAlixPay;
    //   1158: aload_0
    //   1159: getfield f : Z
    //   1162: ifeq -> 1184
    //   1165: aload_0
    //   1166: getfield c : Landroid/app/Activity;
    //   1169: astore_1
    //   1170: aload_1
    //   1171: ifnull -> 1184
    //   1174: aload_1
    //   1175: iconst_0
    //   1176: invokevirtual setRequestedOrientation : (I)V
    //   1179: aload_0
    //   1180: iconst_0
    //   1181: putfield f : Z
    //   1184: aload_2
    //   1185: athrow
    //   1186: astore_1
    //   1187: aload #12
    //   1189: monitorexit
    //   1190: aload_1
    //   1191: athrow
    //   1192: new java/lang/Throwable
    //   1195: dup
    //   1196: ldc_w 'bindService fail'
    //   1199: invokespecial <init> : (Ljava/lang/String;)V
    //   1202: athrow
    //   1203: astore_1
    //   1204: aload_3
    //   1205: ldc 'biz'
    //   1207: ldc_w 'ClientBindServiceFailed'
    //   1210: aload_1
    //   1211: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1214: ldc 'failed'
    //   1216: areturn
    //   1217: ldc_w 'null'
    //   1220: astore #12
    //   1222: goto -> 163
    // Exception table:
    //   from	to	target	type
    //   125	148	192	finally
    //   153	160	192	finally
    //   163	174	192	finally
    //   177	189	192	finally
    //   194	205	1203	finally
    //   205	224	1203	finally
    //   238	244	1186	finally
    //   249	263	266	java/lang/InterruptedException
    //   249	263	1186	finally
    //   268	279	1186	finally
    //   279	282	1186	finally
    //   282	344	875	finally
    //   344	357	360	finally
    //   365	379	382	finally
    //   485	541	875	finally
    //   541	564	875	finally
    //   564	575	578	finally
    //   579	583	875	finally
    //   586	639	875	finally
    //   645	707	875	finally
    //   710	721	875	finally
    //   721	734	737	finally
    //   744	758	761	finally
    //   876	890	1037	finally
    //   890	903	906	finally
    //   913	927	930	finally
    //   1038	1051	1054	finally
    //   1061	1075	1078	finally
    //   1187	1190	1186	finally
    //   1192	1203	1203	finally
  }
  
  private void a(n.a parama) throws InterruptedException {
    if (parama == null)
      return; 
    PackageInfo packageInfo = parama.a;
    if (packageInfo == null)
      return; 
    String str = packageInfo.packageName;
    Intent intent = new Intent();
    intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
    try {
      this.c.startActivity(intent);
    } finally {
      str = null;
    } 
  }
  
  private static boolean a(String paramString, Context paramContext, com.alipay.sdk.sys.a parama) {
    try {
      Intent intent = new Intent("android.intent.action.MAIN", null);
      return true;
    } finally {
      paramString = null;
      com.alipay.sdk.app.statistic.a.a(parama, "biz", "BSPDetectFail", (Throwable)paramString);
    } 
  }
  
  public String a(String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #7
    //   4: aconst_null
    //   5: astore #6
    //   7: aconst_null
    //   8: astore_3
    //   9: aload #7
    //   11: astore #4
    //   13: aload #6
    //   15: astore #5
    //   17: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   20: invokevirtual i : ()Ljava/util/List;
    //   23: astore #8
    //   25: aload #7
    //   27: astore #4
    //   29: aload #6
    //   31: astore #5
    //   33: invokestatic j : ()Lcom/alipay/sdk/data/a;
    //   36: getfield a : Z
    //   39: ifeq -> 50
    //   42: aload #8
    //   44: astore_2
    //   45: aload #8
    //   47: ifnonnull -> 62
    //   50: aload #7
    //   52: astore #4
    //   54: aload #6
    //   56: astore #5
    //   58: getstatic com/alipay/sdk/app/i.a : Ljava/util/List;
    //   61: astore_2
    //   62: aload #7
    //   64: astore #4
    //   66: aload #6
    //   68: astore #5
    //   70: aload_0
    //   71: getfield h : Lcom/alipay/sdk/sys/a;
    //   74: aload_0
    //   75: getfield c : Landroid/app/Activity;
    //   78: aload_2
    //   79: invokestatic a : (Lcom/alipay/sdk/sys/a;Landroid/content/Context;Ljava/util/List;)Lcom/alipay/sdk/util/n$a;
    //   82: astore #8
    //   84: aload #8
    //   86: ifnull -> 268
    //   89: aload #7
    //   91: astore #4
    //   93: aload #6
    //   95: astore #5
    //   97: aload #8
    //   99: aload_0
    //   100: getfield h : Lcom/alipay/sdk/sys/a;
    //   103: invokevirtual a : (Lcom/alipay/sdk/sys/a;)Z
    //   106: ifne -> 268
    //   109: aload #7
    //   111: astore #4
    //   113: aload #6
    //   115: astore #5
    //   117: aload #8
    //   119: invokevirtual a : ()Z
    //   122: ifeq -> 128
    //   125: ldc 'failed'
    //   127: areturn
    //   128: aload #7
    //   130: astore #4
    //   132: aload #6
    //   134: astore #5
    //   136: aload #8
    //   138: getfield a : Landroid/content/pm/PackageInfo;
    //   141: invokestatic a : (Landroid/content/pm/PackageInfo;)Z
    //   144: ifeq -> 150
    //   147: ldc 'failed'
    //   149: areturn
    //   150: aload #7
    //   152: astore #4
    //   154: aload #6
    //   156: astore #5
    //   158: aload #8
    //   160: getfield a : Landroid/content/pm/PackageInfo;
    //   163: ifnull -> 213
    //   166: aload #7
    //   168: astore #4
    //   170: aload #6
    //   172: astore #5
    //   174: ldc 'com.eg.android.AlipayGphone'
    //   176: aload #8
    //   178: getfield a : Landroid/content/pm/PackageInfo;
    //   181: getfield packageName : Ljava/lang/String;
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifeq -> 193
    //   190: goto -> 213
    //   193: aload #7
    //   195: astore #4
    //   197: aload #6
    //   199: astore #5
    //   201: aload #8
    //   203: getfield a : Landroid/content/pm/PackageInfo;
    //   206: getfield packageName : Ljava/lang/String;
    //   209: astore_2
    //   210: goto -> 225
    //   213: aload #7
    //   215: astore #4
    //   217: aload #6
    //   219: astore #5
    //   221: invokestatic a : ()Ljava/lang/String;
    //   224: astore_2
    //   225: aload_2
    //   226: astore #4
    //   228: aload #6
    //   230: astore #5
    //   232: aload #8
    //   234: getfield a : Landroid/content/pm/PackageInfo;
    //   237: ifnull -> 253
    //   240: aload_2
    //   241: astore #4
    //   243: aload #6
    //   245: astore #5
    //   247: aload #8
    //   249: getfield a : Landroid/content/pm/PackageInfo;
    //   252: astore_3
    //   253: aload_2
    //   254: astore #4
    //   256: aload_3
    //   257: astore #5
    //   259: aload_0
    //   260: aload #8
    //   262: invokespecial a : (Lcom/alipay/sdk/util/n$a;)V
    //   265: goto -> 291
    //   268: ldc 'failed'
    //   270: areturn
    //   271: astore_2
    //   272: aload_0
    //   273: getfield h : Lcom/alipay/sdk/sys/a;
    //   276: ldc 'biz'
    //   278: ldc_w 'CheckClientSignEx'
    //   281: aload_2
    //   282: invokestatic a : (Lcom/alipay/sdk/sys/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload #5
    //   287: astore_3
    //   288: aload #4
    //   290: astore_2
    //   291: aload_0
    //   292: aload_1
    //   293: aload_2
    //   294: aload_3
    //   295: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/PackageInfo;)Ljava/lang/String;
    //   298: areturn
    // Exception table:
    //   from	to	target	type
    //   17	25	271	finally
    //   33	42	271	finally
    //   58	62	271	finally
    //   70	84	271	finally
    //   97	109	271	finally
    //   117	125	271	finally
    //   136	147	271	finally
    //   158	166	271	finally
    //   174	190	271	finally
    //   201	210	271	finally
    //   221	225	271	finally
    //   232	240	271	finally
    //   247	253	271	finally
    //   259	265	271	finally
  }
  
  public void a() {
    this.c = null;
  }
  
  public static interface a {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */