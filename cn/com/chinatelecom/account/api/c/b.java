package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.d.f;
import cn.com.chinatelecom.account.api.d.j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public final class b extends f {
  private static final String b = b.class.getSimpleName();
  
  public b(Context paramContext) {
    super(paramContext);
  }
  
  public h a(String paramString1, String paramString2, int paramInt, g paramg) {
    return a(paramString1) ? b(paramString1, paramString2, paramInt, paramg) : c(paramString1, paramString2, paramInt, paramg);
  }
  
  public h b(String paramString1, String paramString2, int paramInt, g paramg) {
    // Byte code:
    //   0: new cn/com/chinatelecom/account/api/c/h
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #14
    //   9: iconst_0
    //   10: istore #5
    //   12: aconst_null
    //   13: astore #9
    //   15: aconst_null
    //   16: astore #11
    //   18: aconst_null
    //   19: astore #12
    //   21: aconst_null
    //   22: astore #13
    //   24: aconst_null
    //   25: astore #10
    //   27: aload_0
    //   28: getfield a : Landroid/content/Context;
    //   31: invokestatic c : (Landroid/content/Context;)Z
    //   34: istore #7
    //   36: aload_0
    //   37: aload #4
    //   39: getfield f : Z
    //   42: aload #4
    //   44: getfield g : Ljava/lang/String;
    //   47: invokevirtual a : (ZLjava/lang/String;)Z
    //   50: istore #6
    //   52: aload_1
    //   53: astore #8
    //   55: iload #6
    //   57: ifeq -> 76
    //   60: aload_1
    //   61: aload #4
    //   63: getfield h : Ljava/lang/String;
    //   66: aload #4
    //   68: getfield g : Ljava/lang/String;
    //   71: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   74: astore #8
    //   76: aload #4
    //   78: getfield b : I
    //   81: ifle -> 105
    //   84: iload #7
    //   86: ifne -> 105
    //   89: aload_0
    //   90: invokevirtual a : ()Z
    //   93: ifne -> 105
    //   96: aload_0
    //   97: getfield a : Landroid/content/Context;
    //   100: aload #8
    //   102: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload #8
    //   108: aload_2
    //   109: iload_3
    //   110: aload #4
    //   112: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;ILcn/com/chinatelecom/account/api/c/g;)Ljavax/net/ssl/HttpsURLConnection;
    //   115: astore #8
    //   117: aload #8
    //   119: invokevirtual getResponseCode : ()I
    //   122: istore_3
    //   123: iload_3
    //   124: sipush #200
    //   127: if_icmpne -> 350
    //   130: aload #8
    //   132: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   135: astore_1
    //   136: new java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial <init> : ()V
    //   143: astore #9
    //   145: new java/io/BufferedReader
    //   148: dup
    //   149: new java/io/InputStreamReader
    //   152: dup
    //   153: aload_1
    //   154: invokespecial <init> : (Ljava/io/InputStream;)V
    //   157: invokespecial <init> : (Ljava/io/Reader;)V
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual readLine : ()Ljava/lang/String;
    //   165: astore #10
    //   167: aload #10
    //   169: ifnull -> 191
    //   172: aload #9
    //   174: aload #10
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #9
    //   182: ldc '\\n'
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: goto -> 161
    //   191: aload #14
    //   193: iconst_0
    //   194: putfield a : I
    //   197: aload #14
    //   199: aload #9
    //   201: invokevirtual toString : ()Ljava/lang/String;
    //   204: putfield b : Ljava/lang/String;
    //   207: aload #4
    //   209: getfield d : Ljava/lang/String;
    //   212: aload #14
    //   214: getfield b : Ljava/lang/String;
    //   217: aconst_null
    //   218: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_0
    //   222: getfield a : Landroid/content/Context;
    //   225: aload #8
    //   227: iconst_1
    //   228: invokestatic a : (Landroid/content/Context;Ljava/net/HttpURLConnection;Z)Lcn/com/chinatelecom/account/api/c/d;
    //   231: astore #8
    //   233: aload #8
    //   235: ifnull -> 275
    //   238: aload #14
    //   240: aload #8
    //   242: getfield b : Z
    //   245: putfield c : Z
    //   248: aload #14
    //   250: aload #8
    //   252: getfield a : Ljava/lang/String;
    //   255: putfield d : Ljava/lang/String;
    //   258: aload #4
    //   260: getfield d : Ljava/lang/String;
    //   263: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   266: aload #8
    //   268: getfield c : Ljava/lang/String;
    //   271: invokevirtual f : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   274: pop
    //   275: goto -> 666
    //   278: astore #10
    //   280: goto -> 302
    //   283: astore #10
    //   285: goto -> 315
    //   288: astore #10
    //   290: goto -> 328
    //   293: astore #10
    //   295: goto -> 341
    //   298: astore #10
    //   300: aconst_null
    //   301: astore_2
    //   302: aload_1
    //   303: astore #9
    //   305: aload_2
    //   306: astore #8
    //   308: goto -> 747
    //   311: astore #10
    //   313: aconst_null
    //   314: astore_2
    //   315: aload_1
    //   316: astore #9
    //   318: aload_2
    //   319: astore #8
    //   321: goto -> 1115
    //   324: astore #10
    //   326: aconst_null
    //   327: astore_2
    //   328: aload_1
    //   329: astore #9
    //   331: aload_2
    //   332: astore #8
    //   334: goto -> 1483
    //   337: astore #10
    //   339: aconst_null
    //   340: astore_2
    //   341: aload_1
    //   342: astore #9
    //   344: aload_2
    //   345: astore #8
    //   347: goto -> 1852
    //   350: iload_3
    //   351: sipush #302
    //   354: if_icmpne -> 551
    //   357: aload #4
    //   359: getfield b : I
    //   362: bipush #10
    //   364: if_icmpge -> 493
    //   367: aload #4
    //   369: aload #4
    //   371: getfield b : I
    //   374: iconst_1
    //   375: iadd
    //   376: putfield b : I
    //   379: aload #4
    //   381: iconst_0
    //   382: putfield f : Z
    //   385: aload #8
    //   387: ldc 'Location'
    //   389: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   392: astore_1
    //   393: aload #8
    //   395: invokestatic a : (Ljava/net/HttpURLConnection;)Lcn/com/chinatelecom/account/api/c/d;
    //   398: astore_2
    //   399: aload #4
    //   401: getfield d : Ljava/lang/String;
    //   404: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   407: aload_2
    //   408: getfield c : Ljava/lang/String;
    //   411: invokevirtual f : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
    //   414: pop
    //   415: iload #5
    //   417: istore_3
    //   418: aload_2
    //   419: getfield d : Ljava/lang/String;
    //   422: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   425: ifne -> 446
    //   428: aload_2
    //   429: getfield d : Ljava/lang/String;
    //   432: ldc '0'
    //   434: invokevirtual equals : (Ljava/lang/Object;)Z
    //   437: ifeq -> 2243
    //   440: iload #5
    //   442: istore_3
    //   443: goto -> 446
    //   446: getstatic cn/com/chinatelecom/account/api/c/b.b : Ljava/lang/String;
    //   449: astore_2
    //   450: new java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial <init> : ()V
    //   457: astore #8
    //   459: aload #8
    //   461: ldc 'method : '
    //   463: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload #8
    //   469: iload_3
    //   470: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload_2
    //   475: aload #8
    //   477: invokevirtual toString : ()Ljava/lang/String;
    //   480: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload_0
    //   484: aload_1
    //   485: aconst_null
    //   486: iload_3
    //   487: aload #4
    //   489: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;ILcn/com/chinatelecom/account/api/c/g;)Lcn/com/chinatelecom/account/api/c/h;
    //   492: areturn
    //   493: new java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial <init> : ()V
    //   500: astore_1
    //   501: aload_1
    //   502: getstatic cn/com/chinatelecom/account/api/d/j.b : [B
    //   505: invokestatic a : ([B)Ljava/lang/String;
    //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload_1
    //   513: ldc '-Redirect more than 10 times'
    //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #14
    //   521: ldc 80001
    //   523: aload_1
    //   524: invokevirtual toString : ()Ljava/lang/String;
    //   527: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   530: putfield b : Ljava/lang/String;
    //   533: aload #4
    //   535: getfield d : Ljava/lang/String;
    //   538: aload #14
    //   540: getfield b : Ljava/lang/String;
    //   543: ldc 'Redirect more than 10 times'
    //   545: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   548: goto -> 661
    //   551: new java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial <init> : ()V
    //   558: astore_1
    //   559: aload_1
    //   560: getstatic cn/com/chinatelecom/account/api/d/j.c : [B
    //   563: invokestatic a : ([B)Ljava/lang/String;
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload_1
    //   571: ldc '-'
    //   573: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload_1
    //   578: aload #4
    //   580: getfield c : Ljava/lang/String;
    //   583: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_1
    //   588: ldc '-code : '
    //   590: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload_1
    //   595: iload_3
    //   596: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload #14
    //   602: ldc 80002
    //   604: aload_1
    //   605: invokevirtual toString : ()Ljava/lang/String;
    //   608: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   611: putfield b : Ljava/lang/String;
    //   614: new java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial <init> : ()V
    //   621: astore_1
    //   622: aload_1
    //   623: ldc 'response code ：'
    //   625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_1
    //   630: iload_3
    //   631: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_1
    //   636: invokevirtual toString : ()Ljava/lang/String;
    //   639: astore_1
    //   640: aload #4
    //   642: getfield d : Ljava/lang/String;
    //   645: aload #14
    //   647: getfield b : Ljava/lang/String;
    //   650: aload_1
    //   651: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   654: getstatic cn/com/chinatelecom/account/api/c/b.b : Ljava/lang/String;
    //   657: aload_1
    //   658: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   661: aconst_null
    //   662: astore_1
    //   663: aload #10
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull -> 677
    //   670: aload_2
    //   671: invokevirtual close : ()V
    //   674: goto -> 677
    //   677: aload_1
    //   678: ifnull -> 2209
    //   681: aload_1
    //   682: invokevirtual close : ()V
    //   685: aload #14
    //   687: areturn
    //   688: aload_1
    //   689: invokevirtual printStackTrace : ()V
    //   692: aload #14
    //   694: areturn
    //   695: astore #10
    //   697: aconst_null
    //   698: astore #8
    //   700: goto -> 747
    //   703: astore #10
    //   705: aconst_null
    //   706: astore #8
    //   708: aload #11
    //   710: astore #9
    //   712: goto -> 1115
    //   715: astore #10
    //   717: aconst_null
    //   718: astore #8
    //   720: aload #12
    //   722: astore #9
    //   724: goto -> 1483
    //   727: astore #10
    //   729: aconst_null
    //   730: astore #8
    //   732: aload #13
    //   734: astore #9
    //   736: goto -> 1852
    //   739: astore #10
    //   741: aconst_null
    //   742: astore #8
    //   744: iconst_0
    //   745: istore #6
    //   747: aload #9
    //   749: astore_1
    //   750: aload #8
    //   752: astore_2
    //   753: aload #4
    //   755: getfield e : Z
    //   758: ifne -> 778
    //   761: iload #6
    //   763: ifeq -> 778
    //   766: aload #9
    //   768: astore_1
    //   769: aload #8
    //   771: astore_2
    //   772: aload #14
    //   774: iconst_1
    //   775: putfield e : Z
    //   778: aload #9
    //   780: astore_1
    //   781: aload #8
    //   783: astore_2
    //   784: new java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial <init> : ()V
    //   791: astore #11
    //   793: aload #9
    //   795: astore_1
    //   796: aload #8
    //   798: astore_2
    //   799: aload #11
    //   801: getstatic cn/com/chinatelecom/account/api/d/j.b : [B
    //   804: invokestatic a : ([B)Ljava/lang/String;
    //   807: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload #9
    //   813: astore_1
    //   814: aload #8
    //   816: astore_2
    //   817: aload #11
    //   819: ldc '-'
    //   821: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload #9
    //   827: astore_1
    //   828: aload #8
    //   830: astore_2
    //   831: aload #11
    //   833: aload #4
    //   835: getfield c : Ljava/lang/String;
    //   838: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload #9
    //   844: astore_1
    //   845: aload #8
    //   847: astore_2
    //   848: aload #11
    //   850: ldc '-'
    //   852: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload #9
    //   858: astore_1
    //   859: aload #8
    //   861: astore_2
    //   862: aload #11
    //   864: aload #10
    //   866: invokevirtual getMessage : ()Ljava/lang/String;
    //   869: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload #9
    //   875: astore_1
    //   876: aload #8
    //   878: astore_2
    //   879: aload #14
    //   881: ldc 80001
    //   883: aload #11
    //   885: invokevirtual toString : ()Ljava/lang/String;
    //   888: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   891: putfield b : Ljava/lang/String;
    //   894: aload #9
    //   896: astore_1
    //   897: aload #8
    //   899: astore_2
    //   900: new java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial <init> : ()V
    //   907: astore #11
    //   909: aload #9
    //   911: astore_1
    //   912: aload #8
    //   914: astore_2
    //   915: aload #11
    //   917: ldc 'Throwable : '
    //   919: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload #9
    //   925: astore_1
    //   926: aload #8
    //   928: astore_2
    //   929: aload #11
    //   931: aload #10
    //   933: invokevirtual getMessage : ()Ljava/lang/String;
    //   936: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload #9
    //   942: astore_1
    //   943: aload #8
    //   945: astore_2
    //   946: aload #11
    //   948: invokevirtual toString : ()Ljava/lang/String;
    //   951: astore #11
    //   953: aload #9
    //   955: astore_1
    //   956: aload #8
    //   958: astore_2
    //   959: aload #4
    //   961: getfield d : Ljava/lang/String;
    //   964: aload #14
    //   966: getfield b : Ljava/lang/String;
    //   969: aload #11
    //   971: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   974: aload #9
    //   976: astore_1
    //   977: aload #8
    //   979: astore_2
    //   980: getstatic cn/com/chinatelecom/account/api/c/b.b : Ljava/lang/String;
    //   983: astore #11
    //   985: aload #9
    //   987: astore_1
    //   988: aload #8
    //   990: astore_2
    //   991: new java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial <init> : ()V
    //   998: astore #12
    //   1000: aload #9
    //   1002: astore_1
    //   1003: aload #8
    //   1005: astore_2
    //   1006: aload #12
    //   1008: ldc 'Throwable-'
    //   1010: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: pop
    //   1014: aload #9
    //   1016: astore_1
    //   1017: aload #8
    //   1019: astore_2
    //   1020: aload #12
    //   1022: aload #4
    //   1024: getfield c : Ljava/lang/String;
    //   1027: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload #9
    //   1033: astore_1
    //   1034: aload #8
    //   1036: astore_2
    //   1037: aload #12
    //   1039: ldc '-'
    //   1041: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload #9
    //   1047: astore_1
    //   1048: aload #8
    //   1050: astore_2
    //   1051: aload #12
    //   1053: aload #10
    //   1055: invokevirtual getMessage : ()Ljava/lang/String;
    //   1058: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload #9
    //   1064: astore_1
    //   1065: aload #8
    //   1067: astore_2
    //   1068: aload #11
    //   1070: aload #12
    //   1072: invokevirtual toString : ()Ljava/lang/String;
    //   1075: aload #10
    //   1077: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1080: aload #8
    //   1082: ifnull -> 1090
    //   1085: aload #8
    //   1087: invokevirtual close : ()V
    //   1090: aload #9
    //   1092: ifnull -> 2209
    //   1095: aload #9
    //   1097: invokevirtual close : ()V
    //   1100: aload #14
    //   1102: areturn
    //   1103: astore #10
    //   1105: aconst_null
    //   1106: astore #8
    //   1108: iconst_0
    //   1109: istore #6
    //   1111: aload #11
    //   1113: astore #9
    //   1115: aload #9
    //   1117: astore_1
    //   1118: aload #8
    //   1120: astore_2
    //   1121: aload #4
    //   1123: getfield e : Z
    //   1126: ifne -> 1146
    //   1129: iload #6
    //   1131: ifeq -> 1146
    //   1134: aload #9
    //   1136: astore_1
    //   1137: aload #8
    //   1139: astore_2
    //   1140: aload #14
    //   1142: iconst_1
    //   1143: putfield e : Z
    //   1146: aload #9
    //   1148: astore_1
    //   1149: aload #8
    //   1151: astore_2
    //   1152: new java/lang/StringBuilder
    //   1155: dup
    //   1156: invokespecial <init> : ()V
    //   1159: astore #11
    //   1161: aload #9
    //   1163: astore_1
    //   1164: aload #8
    //   1166: astore_2
    //   1167: aload #11
    //   1169: getstatic cn/com/chinatelecom/account/api/d/j.h : [B
    //   1172: invokestatic a : ([B)Ljava/lang/String;
    //   1175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload #9
    //   1181: astore_1
    //   1182: aload #8
    //   1184: astore_2
    //   1185: aload #11
    //   1187: ldc '-'
    //   1189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload #9
    //   1195: astore_1
    //   1196: aload #8
    //   1198: astore_2
    //   1199: aload #11
    //   1201: aload #4
    //   1203: getfield c : Ljava/lang/String;
    //   1206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload #9
    //   1212: astore_1
    //   1213: aload #8
    //   1215: astore_2
    //   1216: aload #11
    //   1218: ldc '-'
    //   1220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: aload #9
    //   1226: astore_1
    //   1227: aload #8
    //   1229: astore_2
    //   1230: aload #11
    //   1232: aload #10
    //   1234: invokevirtual getMessage : ()Ljava/lang/String;
    //   1237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: pop
    //   1241: aload #9
    //   1243: astore_1
    //   1244: aload #8
    //   1246: astore_2
    //   1247: aload #14
    //   1249: ldc 80007
    //   1251: aload #11
    //   1253: invokevirtual toString : ()Ljava/lang/String;
    //   1256: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1259: putfield b : Ljava/lang/String;
    //   1262: aload #9
    //   1264: astore_1
    //   1265: aload #8
    //   1267: astore_2
    //   1268: new java/lang/StringBuilder
    //   1271: dup
    //   1272: invokespecial <init> : ()V
    //   1275: astore #11
    //   1277: aload #9
    //   1279: astore_1
    //   1280: aload #8
    //   1282: astore_2
    //   1283: aload #11
    //   1285: ldc 'IOException : '
    //   1287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload #9
    //   1293: astore_1
    //   1294: aload #8
    //   1296: astore_2
    //   1297: aload #11
    //   1299: aload #10
    //   1301: invokevirtual getMessage : ()Ljava/lang/String;
    //   1304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: aload #9
    //   1310: astore_1
    //   1311: aload #8
    //   1313: astore_2
    //   1314: aload #11
    //   1316: invokevirtual toString : ()Ljava/lang/String;
    //   1319: astore #11
    //   1321: aload #9
    //   1323: astore_1
    //   1324: aload #8
    //   1326: astore_2
    //   1327: aload #4
    //   1329: getfield d : Ljava/lang/String;
    //   1332: aload #14
    //   1334: getfield b : Ljava/lang/String;
    //   1337: aload #11
    //   1339: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1342: aload #9
    //   1344: astore_1
    //   1345: aload #8
    //   1347: astore_2
    //   1348: getstatic cn/com/chinatelecom/account/api/c/b.b : Ljava/lang/String;
    //   1351: astore #11
    //   1353: aload #9
    //   1355: astore_1
    //   1356: aload #8
    //   1358: astore_2
    //   1359: new java/lang/StringBuilder
    //   1362: dup
    //   1363: invokespecial <init> : ()V
    //   1366: astore #12
    //   1368: aload #9
    //   1370: astore_1
    //   1371: aload #8
    //   1373: astore_2
    //   1374: aload #12
    //   1376: ldc 'IOException-'
    //   1378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload #9
    //   1384: astore_1
    //   1385: aload #8
    //   1387: astore_2
    //   1388: aload #12
    //   1390: aload #4
    //   1392: getfield c : Ljava/lang/String;
    //   1395: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload #9
    //   1401: astore_1
    //   1402: aload #8
    //   1404: astore_2
    //   1405: aload #12
    //   1407: ldc '-'
    //   1409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: pop
    //   1413: aload #9
    //   1415: astore_1
    //   1416: aload #8
    //   1418: astore_2
    //   1419: aload #12
    //   1421: aload #10
    //   1423: invokevirtual getMessage : ()Ljava/lang/String;
    //   1426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload #9
    //   1432: astore_1
    //   1433: aload #8
    //   1435: astore_2
    //   1436: aload #11
    //   1438: aload #12
    //   1440: invokevirtual toString : ()Ljava/lang/String;
    //   1443: aload #10
    //   1445: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1448: aload #8
    //   1450: ifnull -> 1458
    //   1453: aload #8
    //   1455: invokevirtual close : ()V
    //   1458: aload #9
    //   1460: ifnull -> 2209
    //   1463: aload #9
    //   1465: invokevirtual close : ()V
    //   1468: aload #14
    //   1470: areturn
    //   1471: astore #10
    //   1473: aconst_null
    //   1474: astore #8
    //   1476: iconst_0
    //   1477: istore #6
    //   1479: aload #12
    //   1481: astore #9
    //   1483: aload #9
    //   1485: astore_1
    //   1486: aload #8
    //   1488: astore_2
    //   1489: aload #4
    //   1491: getfield e : Z
    //   1494: ifne -> 1514
    //   1497: iload #6
    //   1499: ifeq -> 1514
    //   1502: aload #9
    //   1504: astore_1
    //   1505: aload #8
    //   1507: astore_2
    //   1508: aload #14
    //   1510: iconst_1
    //   1511: putfield e : Z
    //   1514: aload #9
    //   1516: astore_1
    //   1517: aload #8
    //   1519: astore_2
    //   1520: new java/lang/StringBuilder
    //   1523: dup
    //   1524: invokespecial <init> : ()V
    //   1527: astore #11
    //   1529: aload #9
    //   1531: astore_1
    //   1532: aload #8
    //   1534: astore_2
    //   1535: aload #11
    //   1537: getstatic cn/com/chinatelecom/account/api/d/j.g : [B
    //   1540: invokestatic a : ([B)Ljava/lang/String;
    //   1543: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: pop
    //   1547: aload #9
    //   1549: astore_1
    //   1550: aload #8
    //   1552: astore_2
    //   1553: aload #11
    //   1555: ldc '-'
    //   1557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: aload #9
    //   1563: astore_1
    //   1564: aload #8
    //   1566: astore_2
    //   1567: aload #11
    //   1569: aload #4
    //   1571: getfield c : Ljava/lang/String;
    //   1574: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: pop
    //   1578: aload #9
    //   1580: astore_1
    //   1581: aload #8
    //   1583: astore_2
    //   1584: aload #11
    //   1586: ldc '-'
    //   1588: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: pop
    //   1592: aload #9
    //   1594: astore_1
    //   1595: aload #8
    //   1597: astore_2
    //   1598: aload #11
    //   1600: aload #10
    //   1602: invokevirtual getMessage : ()Ljava/lang/String;
    //   1605: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: pop
    //   1609: aload #9
    //   1611: astore_1
    //   1612: aload #8
    //   1614: astore_2
    //   1615: aload #14
    //   1617: ldc 80006
    //   1619: aload #11
    //   1621: invokevirtual toString : ()Ljava/lang/String;
    //   1624: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1627: putfield b : Ljava/lang/String;
    //   1630: aload #9
    //   1632: astore_1
    //   1633: aload #8
    //   1635: astore_2
    //   1636: new java/lang/StringBuilder
    //   1639: dup
    //   1640: invokespecial <init> : ()V
    //   1643: astore #11
    //   1645: aload #9
    //   1647: astore_1
    //   1648: aload #8
    //   1650: astore_2
    //   1651: aload #11
    //   1653: ldc 'UnknownHostException : '
    //   1655: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload #9
    //   1661: astore_1
    //   1662: aload #8
    //   1664: astore_2
    //   1665: aload #11
    //   1667: aload #10
    //   1669: invokevirtual getMessage : ()Ljava/lang/String;
    //   1672: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: pop
    //   1676: aload #9
    //   1678: astore_1
    //   1679: aload #8
    //   1681: astore_2
    //   1682: aload #11
    //   1684: invokevirtual toString : ()Ljava/lang/String;
    //   1687: astore #11
    //   1689: aload #9
    //   1691: astore_1
    //   1692: aload #8
    //   1694: astore_2
    //   1695: aload #4
    //   1697: getfield d : Ljava/lang/String;
    //   1700: aload #14
    //   1702: getfield b : Ljava/lang/String;
    //   1705: aload #11
    //   1707: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1710: aload #9
    //   1712: astore_1
    //   1713: aload #8
    //   1715: astore_2
    //   1716: getstatic cn/com/chinatelecom/account/api/c/b.b : Ljava/lang/String;
    //   1719: astore #11
    //   1721: aload #9
    //   1723: astore_1
    //   1724: aload #8
    //   1726: astore_2
    //   1727: new java/lang/StringBuilder
    //   1730: dup
    //   1731: invokespecial <init> : ()V
    //   1734: astore #12
    //   1736: aload #9
    //   1738: astore_1
    //   1739: aload #8
    //   1741: astore_2
    //   1742: aload #12
    //   1744: ldc_w 'UnknownHostException-'
    //   1747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: pop
    //   1751: aload #9
    //   1753: astore_1
    //   1754: aload #8
    //   1756: astore_2
    //   1757: aload #12
    //   1759: aload #4
    //   1761: getfield c : Ljava/lang/String;
    //   1764: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: pop
    //   1768: aload #9
    //   1770: astore_1
    //   1771: aload #8
    //   1773: astore_2
    //   1774: aload #12
    //   1776: ldc '-'
    //   1778: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: pop
    //   1782: aload #9
    //   1784: astore_1
    //   1785: aload #8
    //   1787: astore_2
    //   1788: aload #12
    //   1790: aload #10
    //   1792: invokevirtual getMessage : ()Ljava/lang/String;
    //   1795: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: pop
    //   1799: aload #9
    //   1801: astore_1
    //   1802: aload #8
    //   1804: astore_2
    //   1805: aload #11
    //   1807: aload #12
    //   1809: invokevirtual toString : ()Ljava/lang/String;
    //   1812: aload #10
    //   1814: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1817: aload #8
    //   1819: ifnull -> 1827
    //   1822: aload #8
    //   1824: invokevirtual close : ()V
    //   1827: aload #9
    //   1829: ifnull -> 2209
    //   1832: aload #9
    //   1834: invokevirtual close : ()V
    //   1837: aload #14
    //   1839: areturn
    //   1840: astore #10
    //   1842: aconst_null
    //   1843: astore #8
    //   1845: iconst_0
    //   1846: istore #6
    //   1848: aload #13
    //   1850: astore #9
    //   1852: aload #9
    //   1854: astore_1
    //   1855: aload #8
    //   1857: astore_2
    //   1858: aload #4
    //   1860: getfield e : Z
    //   1863: ifne -> 1883
    //   1866: iload #6
    //   1868: ifeq -> 1883
    //   1871: aload #9
    //   1873: astore_1
    //   1874: aload #8
    //   1876: astore_2
    //   1877: aload #14
    //   1879: iconst_1
    //   1880: putfield e : Z
    //   1883: aload #9
    //   1885: astore_1
    //   1886: aload #8
    //   1888: astore_2
    //   1889: new java/lang/StringBuilder
    //   1892: dup
    //   1893: invokespecial <init> : ()V
    //   1896: astore #11
    //   1898: aload #9
    //   1900: astore_1
    //   1901: aload #8
    //   1903: astore_2
    //   1904: aload #11
    //   1906: getstatic cn/com/chinatelecom/account/api/d/j.f : [B
    //   1909: invokestatic a : ([B)Ljava/lang/String;
    //   1912: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload #9
    //   1918: astore_1
    //   1919: aload #8
    //   1921: astore_2
    //   1922: aload #11
    //   1924: ldc '-'
    //   1926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: pop
    //   1930: aload #9
    //   1932: astore_1
    //   1933: aload #8
    //   1935: astore_2
    //   1936: aload #11
    //   1938: aload #4
    //   1940: getfield c : Ljava/lang/String;
    //   1943: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: pop
    //   1947: aload #9
    //   1949: astore_1
    //   1950: aload #8
    //   1952: astore_2
    //   1953: aload #11
    //   1955: ldc '-'
    //   1957: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: pop
    //   1961: aload #9
    //   1963: astore_1
    //   1964: aload #8
    //   1966: astore_2
    //   1967: aload #11
    //   1969: aload #10
    //   1971: invokevirtual getMessage : ()Ljava/lang/String;
    //   1974: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: pop
    //   1978: aload #9
    //   1980: astore_1
    //   1981: aload #8
    //   1983: astore_2
    //   1984: aload #14
    //   1986: ldc_w 80005
    //   1989: aload #11
    //   1991: invokevirtual toString : ()Ljava/lang/String;
    //   1994: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1997: putfield b : Ljava/lang/String;
    //   2000: aload #9
    //   2002: astore_1
    //   2003: aload #8
    //   2005: astore_2
    //   2006: new java/lang/StringBuilder
    //   2009: dup
    //   2010: invokespecial <init> : ()V
    //   2013: astore #11
    //   2015: aload #9
    //   2017: astore_1
    //   2018: aload #8
    //   2020: astore_2
    //   2021: aload #11
    //   2023: ldc_w 'SocketTimeoutException : '
    //   2026: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: pop
    //   2030: aload #9
    //   2032: astore_1
    //   2033: aload #8
    //   2035: astore_2
    //   2036: aload #11
    //   2038: aload #10
    //   2040: invokevirtual getMessage : ()Ljava/lang/String;
    //   2043: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2046: pop
    //   2047: aload #9
    //   2049: astore_1
    //   2050: aload #8
    //   2052: astore_2
    //   2053: aload #11
    //   2055: invokevirtual toString : ()Ljava/lang/String;
    //   2058: astore #11
    //   2060: aload #9
    //   2062: astore_1
    //   2063: aload #8
    //   2065: astore_2
    //   2066: aload #4
    //   2068: getfield d : Ljava/lang/String;
    //   2071: aload #14
    //   2073: getfield b : Ljava/lang/String;
    //   2076: aload #11
    //   2078: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2081: aload #9
    //   2083: astore_1
    //   2084: aload #8
    //   2086: astore_2
    //   2087: getstatic cn/com/chinatelecom/account/api/c/b.b : Ljava/lang/String;
    //   2090: astore #11
    //   2092: aload #9
    //   2094: astore_1
    //   2095: aload #8
    //   2097: astore_2
    //   2098: new java/lang/StringBuilder
    //   2101: dup
    //   2102: invokespecial <init> : ()V
    //   2105: astore #12
    //   2107: aload #9
    //   2109: astore_1
    //   2110: aload #8
    //   2112: astore_2
    //   2113: aload #12
    //   2115: ldc_w 'STE_'
    //   2118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2121: pop
    //   2122: aload #9
    //   2124: astore_1
    //   2125: aload #8
    //   2127: astore_2
    //   2128: aload #12
    //   2130: aload #4
    //   2132: getfield c : Ljava/lang/String;
    //   2135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: pop
    //   2139: aload #9
    //   2141: astore_1
    //   2142: aload #8
    //   2144: astore_2
    //   2145: aload #12
    //   2147: ldc_w '_'
    //   2150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2153: pop
    //   2154: aload #9
    //   2156: astore_1
    //   2157: aload #8
    //   2159: astore_2
    //   2160: aload #12
    //   2162: aload #10
    //   2164: invokevirtual getMessage : ()Ljava/lang/String;
    //   2167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: pop
    //   2171: aload #9
    //   2173: astore_1
    //   2174: aload #8
    //   2176: astore_2
    //   2177: aload #11
    //   2179: aload #12
    //   2181: invokevirtual toString : ()Ljava/lang/String;
    //   2184: aload #10
    //   2186: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2189: aload #8
    //   2191: ifnull -> 2199
    //   2194: aload #8
    //   2196: invokevirtual close : ()V
    //   2199: aload #9
    //   2201: ifnull -> 2209
    //   2204: aload #9
    //   2206: invokevirtual close : ()V
    //   2209: aload #14
    //   2211: areturn
    //   2212: astore #4
    //   2214: aload_2
    //   2215: ifnull -> 2225
    //   2218: aload_2
    //   2219: invokevirtual close : ()V
    //   2222: goto -> 2225
    //   2225: aload_1
    //   2226: ifnull -> 2240
    //   2229: aload_1
    //   2230: invokevirtual close : ()V
    //   2233: goto -> 2240
    //   2236: aload_1
    //   2237: invokevirtual printStackTrace : ()V
    //   2240: aload #4
    //   2242: athrow
    //   2243: iconst_1
    //   2244: istore_3
    //   2245: goto -> 446
    //   2248: astore_1
    //   2249: goto -> 688
    //   2252: astore_1
    //   2253: goto -> 2236
    // Exception table:
    //   from	to	target	type
    //   27	52	1840	java/net/SocketTimeoutException
    //   27	52	1471	java/net/UnknownHostException
    //   27	52	1103	java/io/IOException
    //   27	52	739	finally
    //   60	76	727	java/net/SocketTimeoutException
    //   60	76	715	java/net/UnknownHostException
    //   60	76	703	java/io/IOException
    //   60	76	695	finally
    //   76	84	727	java/net/SocketTimeoutException
    //   76	84	715	java/net/UnknownHostException
    //   76	84	703	java/io/IOException
    //   76	84	695	finally
    //   89	105	727	java/net/SocketTimeoutException
    //   89	105	715	java/net/UnknownHostException
    //   89	105	703	java/io/IOException
    //   89	105	695	finally
    //   105	123	727	java/net/SocketTimeoutException
    //   105	123	715	java/net/UnknownHostException
    //   105	123	703	java/io/IOException
    //   105	123	695	finally
    //   130	136	727	java/net/SocketTimeoutException
    //   130	136	715	java/net/UnknownHostException
    //   130	136	703	java/io/IOException
    //   130	136	695	finally
    //   136	161	337	java/net/SocketTimeoutException
    //   136	161	324	java/net/UnknownHostException
    //   136	161	311	java/io/IOException
    //   136	161	298	finally
    //   161	167	293	java/net/SocketTimeoutException
    //   161	167	288	java/net/UnknownHostException
    //   161	167	283	java/io/IOException
    //   161	167	278	finally
    //   172	188	293	java/net/SocketTimeoutException
    //   172	188	288	java/net/UnknownHostException
    //   172	188	283	java/io/IOException
    //   172	188	278	finally
    //   191	233	293	java/net/SocketTimeoutException
    //   191	233	288	java/net/UnknownHostException
    //   191	233	283	java/io/IOException
    //   191	233	278	finally
    //   238	275	293	java/net/SocketTimeoutException
    //   238	275	288	java/net/UnknownHostException
    //   238	275	283	java/io/IOException
    //   238	275	278	finally
    //   357	415	727	java/net/SocketTimeoutException
    //   357	415	715	java/net/UnknownHostException
    //   357	415	703	java/io/IOException
    //   357	415	695	finally
    //   418	440	727	java/net/SocketTimeoutException
    //   418	440	715	java/net/UnknownHostException
    //   418	440	703	java/io/IOException
    //   418	440	695	finally
    //   446	493	727	java/net/SocketTimeoutException
    //   446	493	715	java/net/UnknownHostException
    //   446	493	703	java/io/IOException
    //   446	493	695	finally
    //   493	548	727	java/net/SocketTimeoutException
    //   493	548	715	java/net/UnknownHostException
    //   493	548	703	java/io/IOException
    //   493	548	695	finally
    //   551	661	727	java/net/SocketTimeoutException
    //   551	661	715	java/net/UnknownHostException
    //   551	661	703	java/io/IOException
    //   551	661	695	finally
    //   670	674	2248	java/io/IOException
    //   681	685	2248	java/io/IOException
    //   753	761	2212	finally
    //   772	778	2212	finally
    //   784	793	2212	finally
    //   799	811	2212	finally
    //   817	825	2212	finally
    //   831	842	2212	finally
    //   848	856	2212	finally
    //   862	873	2212	finally
    //   879	894	2212	finally
    //   900	909	2212	finally
    //   915	923	2212	finally
    //   929	940	2212	finally
    //   946	953	2212	finally
    //   959	974	2212	finally
    //   980	985	2212	finally
    //   991	1000	2212	finally
    //   1006	1014	2212	finally
    //   1020	1031	2212	finally
    //   1037	1045	2212	finally
    //   1051	1062	2212	finally
    //   1068	1080	2212	finally
    //   1085	1090	2248	java/io/IOException
    //   1095	1100	2248	java/io/IOException
    //   1121	1129	2212	finally
    //   1140	1146	2212	finally
    //   1152	1161	2212	finally
    //   1167	1179	2212	finally
    //   1185	1193	2212	finally
    //   1199	1210	2212	finally
    //   1216	1224	2212	finally
    //   1230	1241	2212	finally
    //   1247	1262	2212	finally
    //   1268	1277	2212	finally
    //   1283	1291	2212	finally
    //   1297	1308	2212	finally
    //   1314	1321	2212	finally
    //   1327	1342	2212	finally
    //   1348	1353	2212	finally
    //   1359	1368	2212	finally
    //   1374	1382	2212	finally
    //   1388	1399	2212	finally
    //   1405	1413	2212	finally
    //   1419	1430	2212	finally
    //   1436	1448	2212	finally
    //   1453	1458	2248	java/io/IOException
    //   1463	1468	2248	java/io/IOException
    //   1489	1497	2212	finally
    //   1508	1514	2212	finally
    //   1520	1529	2212	finally
    //   1535	1547	2212	finally
    //   1553	1561	2212	finally
    //   1567	1578	2212	finally
    //   1584	1592	2212	finally
    //   1598	1609	2212	finally
    //   1615	1630	2212	finally
    //   1636	1645	2212	finally
    //   1651	1659	2212	finally
    //   1665	1676	2212	finally
    //   1682	1689	2212	finally
    //   1695	1710	2212	finally
    //   1716	1721	2212	finally
    //   1727	1736	2212	finally
    //   1742	1751	2212	finally
    //   1757	1768	2212	finally
    //   1774	1782	2212	finally
    //   1788	1799	2212	finally
    //   1805	1817	2212	finally
    //   1822	1827	2248	java/io/IOException
    //   1832	1837	2248	java/io/IOException
    //   1858	1866	2212	finally
    //   1877	1883	2212	finally
    //   1889	1898	2212	finally
    //   1904	1916	2212	finally
    //   1922	1930	2212	finally
    //   1936	1947	2212	finally
    //   1953	1961	2212	finally
    //   1967	1978	2212	finally
    //   1984	2000	2212	finally
    //   2006	2015	2212	finally
    //   2021	2030	2212	finally
    //   2036	2047	2212	finally
    //   2053	2060	2212	finally
    //   2066	2081	2212	finally
    //   2087	2092	2212	finally
    //   2098	2107	2212	finally
    //   2113	2122	2212	finally
    //   2128	2139	2212	finally
    //   2145	2154	2212	finally
    //   2160	2171	2212	finally
    //   2177	2189	2212	finally
    //   2194	2199	2248	java/io/IOException
    //   2204	2209	2248	java/io/IOException
    //   2218	2222	2252	java/io/IOException
    //   2229	2233	2252	java/io/IOException
  }
  
  public h c(String paramString1, String paramString2, int paramInt, g paramg) {
    h h = new h();
    StringBuilder stringBuilder2 = null;
    StringBuilder stringBuilder4 = null;
    StringBuilder stringBuilder5 = null;
    StringBuilder stringBuilder6 = null;
    String str1 = null;
    try {
      HttpURLConnection httpURLConnection = d(paramString1, paramString2, paramInt, paramg);
      paramInt = httpURLConnection.getResponseCode();
    } catch (SocketTimeoutException socketTimeoutException) {
    
    } catch (UnknownHostException unknownHostException) {
      str1 = null;
      stringBuilder2 = stringBuilder5;
      StringBuilder stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4 = new StringBuilder();
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(d.a(j.g));
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append("-");
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(paramg.c);
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append("-");
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(unknownHostException.getMessage());
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      h.b = j.a(80006, stringBuilder4.toString());
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      String str = b;
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder5 = new StringBuilder();
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append("UnknownHostException-");
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append(paramg.c);
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append("-");
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append(unknownHostException.getMessage());
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      CtAuth.warn(str, stringBuilder5.toString(), unknownHostException);
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4 = new StringBuilder();
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append("UnknownHostException ：");
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(unknownHostException.getMessage());
      stringBuilder = stringBuilder2;
      paramString2 = str1;
      str2 = stringBuilder4.toString();
      stringBuilder = stringBuilder2;
    } catch (IOException iOException) {
      str1 = null;
      stringBuilder2 = stringBuilder4;
      StringBuilder stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder4 = new StringBuilder();
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(d.a(j.h));
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append("-");
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(paramg.c);
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append("-");
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder4.append(iOException.getMessage());
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      h.b = j.a(80007, stringBuilder4.toString());
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      String str = b;
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder5 = new StringBuilder();
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append("IOException-");
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append(paramg.c);
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append("-");
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder5.append(iOException.getMessage());
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      CtAuth.warn(str, stringBuilder5.toString(), iOException);
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      StringBuilder stringBuilder8 = new StringBuilder();
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder8.append("IOException ：");
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      stringBuilder8.append(iOException.getMessage());
      stringBuilder7 = stringBuilder2;
      paramString2 = str1;
      str2 = stringBuilder8.toString();
      stringBuilder7 = stringBuilder2;
    } finally {
      Exception exception = null;
      str1 = null;
      StringBuilder stringBuilder = stringBuilder2;
      paramString2 = str1;
    } 
    StringBuilder stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder4 = new StringBuilder();
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder4.append(d.a(j.f));
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder4.append("-");
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder4.append(paramg.c);
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder4.append("-");
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder4.append(str2.getMessage());
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    h.b = j.a(80005, stringBuilder4.toString());
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    String str3 = b;
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder5 = new StringBuilder();
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder5.append("SocketTimeoutException-");
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder5.append(paramg.c);
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder5.append("-");
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder5.append(str2.getMessage());
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    CtAuth.warn(str3, stringBuilder5.toString(), (Throwable)str2);
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder3.append("SocketTimeoutException ：");
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    stringBuilder3.append(str2.getMessage());
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    String str2 = stringBuilder3.toString();
    stringBuilder1 = stringBuilder2;
    paramString2 = str1;
    f.a(paramg.d, h.b, str2);
    if (str1 != null)
      str1.close(); 
    if (stringBuilder2 != null)
      stringBuilder2.close(); 
    return h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */