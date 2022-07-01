package com.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.ArrayList;

public final class eh {
  protected static String J;
  
  protected static String L;
  
  protected String A = null;
  
  protected String B = null;
  
  protected ArrayList<dv> C = new ArrayList<dv>();
  
  protected String D = null;
  
  protected String E = null;
  
  protected ArrayList<ScanResult> F = new ArrayList<ScanResult>();
  
  protected String G = null;
  
  protected String H = null;
  
  protected byte[] I = null;
  
  protected String K = null;
  
  protected String M = null;
  
  protected String N = null;
  
  private byte[] O = null;
  
  private int P = 0;
  
  public String a = "1";
  
  protected short b = 0;
  
  protected String c = null;
  
  protected String d = null;
  
  protected String e = null;
  
  protected String f = null;
  
  protected String g = null;
  
  public String h = null;
  
  public String i = null;
  
  protected String j = null;
  
  protected String k = null;
  
  protected String l = null;
  
  protected String m = null;
  
  protected String n = null;
  
  protected String o = null;
  
  protected String p = null;
  
  protected String q = null;
  
  protected String r = null;
  
  protected String s = null;
  
  protected String t = null;
  
  protected String u = null;
  
  protected String v = null;
  
  protected String w = null;
  
  protected String x = null;
  
  protected String y = null;
  
  protected int z = 0;
  
  private static int a(String paramString, byte[] paramArrayOfbyte, int paramInt) {
    int i = paramInt;
    try {
    
    } finally {
      paramString = null;
      ej.a((Throwable)paramString, "Req", "copyContentWithByteLen");
      paramArrayOfbyte[i] = 0;
    } 
    return paramInt + 1;
  }
  
  private String a(String paramString, int paramInt) {
    String[] arrayOfString = this.B.split("\\*")[paramInt].split(",");
    return "lac".equals(paramString) ? arrayOfString[0] : ("cellid".equals(paramString) ? arrayOfString[1] : ("signal".equals(paramString) ? arrayOfString[2] : null));
  }
  
  private byte[] a(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ldc ':'
    //   3: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   6: astore #4
    //   8: bipush #6
    //   10: newarray byte
    //   12: astore #5
    //   14: aload #4
    //   16: ifnull -> 30
    //   19: aload #4
    //   21: astore_3
    //   22: aload #4
    //   24: arraylength
    //   25: bipush #6
    //   27: if_icmpeq -> 156
    //   30: bipush #6
    //   32: anewarray java/lang/String
    //   35: astore #4
    //   37: iconst_0
    //   38: istore_2
    //   39: goto -> 134
    //   42: aload #5
    //   44: astore #4
    //   46: iload_2
    //   47: aload_3
    //   48: arraylength
    //   49: if_icmpge -> 131
    //   52: aload_3
    //   53: iload_2
    //   54: aaload
    //   55: invokevirtual length : ()I
    //   58: iconst_2
    //   59: if_icmple -> 73
    //   62: aload_3
    //   63: iload_2
    //   64: aload_3
    //   65: iload_2
    //   66: aaload
    //   67: iconst_0
    //   68: iconst_2
    //   69: invokevirtual substring : (II)Ljava/lang/String;
    //   72: aastore
    //   73: aload #5
    //   75: iload_2
    //   76: aload_3
    //   77: iload_2
    //   78: aaload
    //   79: bipush #16
    //   81: invokestatic parseInt : (Ljava/lang/String;I)I
    //   84: i2b
    //   85: bastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -> 42
    //   93: astore_3
    //   94: new java/lang/StringBuilder
    //   97: dup
    //   98: ldc 'getMacBa '
    //   100: invokespecial <init> : (Ljava/lang/String;)V
    //   103: astore #4
    //   105: aload #4
    //   107: aload_1
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: ldc 'Req'
    //   115: aload #4
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_0
    //   124: ldc '00:00:00:00:00:00'
    //   126: invokespecial a : (Ljava/lang/String;)[B
    //   129: astore #4
    //   131: aload #4
    //   133: areturn
    //   134: aload #4
    //   136: astore_3
    //   137: iload_2
    //   138: bipush #6
    //   140: if_icmpge -> 156
    //   143: aload #4
    //   145: iload_2
    //   146: ldc '0'
    //   148: aastore
    //   149: iload_2
    //   150: iconst_1
    //   151: iadd
    //   152: istore_2
    //   153: goto -> 134
    //   156: iconst_0
    //   157: istore_2
    //   158: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   22	30	93	finally
    //   30	37	93	finally
    //   46	73	93	finally
    //   73	86	93	finally
  }
  
  private String b(String paramString) {
    if (!TextUtils.isEmpty(this.A)) {
      String str = this.A;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(">");
      if (str.contains(stringBuilder.toString())) {
        str = this.A;
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(">");
        int i = str.indexOf(stringBuilder.toString());
        str = this.A;
        stringBuilder = new StringBuilder("</");
        stringBuilder.append(paramString);
        int j = str.indexOf(stringBuilder.toString());
        return this.A.substring(i + paramString.length() + 1, j);
      } 
    } 
    return "0";
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, dw paramdw, dx paramdx, ConnectivityManager paramConnectivityManager, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   4: astore #17
    //   6: invokestatic d : ()I
    //   9: istore #10
    //   11: aload_0
    //   12: aload #7
    //   14: putfield K : Ljava/lang/String;
    //   17: iload_3
    //   18: ifne -> 34
    //   21: ldc_w 'UC_nlp_20131029'
    //   24: astore #12
    //   26: ldc_w 'BKZCHMBBSSUK7U8GLUKHBB56CCFF78U'
    //   29: astore #13
    //   31: goto -> 44
    //   34: ldc_w 'api_serverSDK_130905'
    //   37: astore #12
    //   39: ldc_w 'S128DF1572465B890OE3F7A13167KLEI'
    //   42: astore #13
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #18
    //   53: aload #4
    //   55: invokevirtual e : ()I
    //   58: istore #11
    //   60: aload #4
    //   62: invokevirtual f : ()I
    //   65: istore #8
    //   67: aload #4
    //   69: invokevirtual g : ()Landroid/telephony/TelephonyManager;
    //   72: astore #15
    //   74: aload #4
    //   76: invokevirtual b : ()Ljava/util/ArrayList;
    //   79: astore #21
    //   81: aload #4
    //   83: invokevirtual c : ()Ljava/util/ArrayList;
    //   86: astore #20
    //   88: aload #5
    //   90: invokevirtual e : ()Ljava/util/ArrayList;
    //   93: astore #19
    //   95: iload #8
    //   97: iconst_2
    //   98: if_icmpne -> 108
    //   101: ldc '1'
    //   103: astore #14
    //   105: goto -> 112
    //   108: ldc '0'
    //   110: astore #14
    //   112: aload #15
    //   114: ifnull -> 236
    //   117: getstatic com/loc/ej.e : Ljava/lang/String;
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifeq -> 152
    //   126: aload_1
    //   127: invokestatic x : (Landroid/content/Context;)Ljava/lang/String;
    //   130: putstatic com/loc/ej.e : Ljava/lang/String;
    //   133: goto -> 152
    //   136: astore #7
    //   138: aload #7
    //   140: ldc_w 'Aps'
    //   143: ldc_w 'getApsReq part4'
    //   146: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -> 152
    //   152: getstatic com/loc/ej.e : Ljava/lang/String;
    //   155: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   158: ifeq -> 175
    //   161: getstatic android/os/Build$VERSION.SDK_INT : I
    //   164: bipush #29
    //   166: if_icmpge -> 175
    //   169: ldc_w '888888888888888'
    //   172: putstatic com/loc/ej.e : Ljava/lang/String;
    //   175: getstatic com/loc/ej.f : Ljava/lang/String;
    //   178: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   181: ifeq -> 210
    //   184: aload_1
    //   185: invokestatic A : (Landroid/content/Context;)Ljava/lang/String;
    //   188: putstatic com/loc/ej.f : Ljava/lang/String;
    //   191: goto -> 210
    //   194: astore #7
    //   196: aload #7
    //   198: ldc_w 'Aps'
    //   201: ldc_w 'getApsReq part2'
    //   204: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   207: goto -> 210
    //   210: getstatic com/loc/ej.f : Ljava/lang/String;
    //   213: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   216: ifeq -> 236
    //   219: getstatic android/os/Build$VERSION.SDK_INT : I
    //   222: bipush #29
    //   224: if_icmpge -> 236
    //   227: ldc_w '888888888888888'
    //   230: putstatic com/loc/ej.f : Ljava/lang/String;
    //   233: goto -> 236
    //   236: aload #6
    //   238: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   241: astore #7
    //   243: goto -> 262
    //   246: astore #7
    //   248: aload #7
    //   250: ldc_w 'Aps'
    //   253: ldc_w 'getApsReq part'
    //   256: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   259: aconst_null
    //   260: astore #7
    //   262: aload #5
    //   264: aload #6
    //   266: invokevirtual a : (Landroid/net/ConnectivityManager;)Z
    //   269: istore_3
    //   270: aload #7
    //   272: invokestatic a : (Landroid/net/NetworkInfo;)I
    //   275: istore #9
    //   277: ldc_w ''
    //   280: astore #6
    //   282: iload #9
    //   284: iconst_m1
    //   285: if_icmpeq -> 314
    //   288: aload #15
    //   290: invokestatic b : (Landroid/telephony/TelephonyManager;)Ljava/lang/String;
    //   293: astore #15
    //   295: iload_3
    //   296: ifeq -> 307
    //   299: ldc_w '2'
    //   302: astore #7
    //   304: goto -> 323
    //   307: ldc '1'
    //   309: astore #7
    //   311: goto -> 323
    //   314: ldc_w ''
    //   317: astore #15
    //   319: aload #15
    //   321: astore #7
    //   323: aload #21
    //   325: invokevirtual isEmpty : ()Z
    //   328: ifne -> 910
    //   331: new java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial <init> : ()V
    //   338: astore #22
    //   340: iload #8
    //   342: iconst_1
    //   343: if_icmpeq -> 612
    //   346: iload #8
    //   348: iconst_2
    //   349: if_icmpeq -> 360
    //   352: ldc_w ''
    //   355: astore #6
    //   357: goto -> 895
    //   360: aload #21
    //   362: iconst_0
    //   363: invokevirtual get : (I)Ljava/lang/Object;
    //   366: checkcast com/loc/dv
    //   369: astore #6
    //   371: aload #22
    //   373: iconst_0
    //   374: aload #22
    //   376: invokevirtual length : ()I
    //   379: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #22
    //   385: ldc_w '<mcc>'
    //   388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload #22
    //   394: aload #6
    //   396: getfield a : I
    //   399: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload #22
    //   405: ldc_w '</mcc>'
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload #22
    //   414: ldc_w '<sid>'
    //   417: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload #22
    //   423: aload #6
    //   425: getfield g : I
    //   428: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload #22
    //   434: ldc_w '</sid>'
    //   437: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload #22
    //   443: ldc_w '<nid>'
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload #22
    //   452: aload #6
    //   454: getfield h : I
    //   457: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload #22
    //   463: ldc_w '</nid>'
    //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #22
    //   472: ldc_w '<bid>'
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload #22
    //   481: aload #6
    //   483: getfield i : I
    //   486: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload #22
    //   492: ldc_w '</bid>'
    //   495: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload #6
    //   501: getfield f : I
    //   504: ifle -> 573
    //   507: aload #6
    //   509: getfield e : I
    //   512: ifle -> 573
    //   515: aload #22
    //   517: ldc_w '<lon>'
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload #22
    //   526: aload #6
    //   528: getfield f : I
    //   531: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload #22
    //   537: ldc_w '</lon>'
    //   540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload #22
    //   546: ldc_w '<lat>'
    //   549: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload #22
    //   555: aload #6
    //   557: getfield e : I
    //   560: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload #22
    //   566: ldc_w '</lat>'
    //   569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload #22
    //   575: ldc_w '<signal>'
    //   578: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload #22
    //   584: aload #6
    //   586: getfield j : I
    //   589: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload #22
    //   595: ldc_w '</signal>'
    //   598: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload #22
    //   604: invokevirtual toString : ()Ljava/lang/String;
    //   607: astore #6
    //   609: goto -> 895
    //   612: aload #21
    //   614: iconst_0
    //   615: invokevirtual get : (I)Ljava/lang/Object;
    //   618: checkcast com/loc/dv
    //   621: astore #6
    //   623: aload #22
    //   625: iconst_0
    //   626: aload #22
    //   628: invokevirtual length : ()I
    //   631: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload #22
    //   637: ldc_w '<mcc>'
    //   640: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload #22
    //   646: aload #6
    //   648: getfield a : I
    //   651: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload #22
    //   657: ldc_w '</mcc>'
    //   660: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload #22
    //   666: ldc_w '<mnc>'
    //   669: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload #22
    //   675: aload #6
    //   677: getfield b : I
    //   680: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload #22
    //   686: ldc_w '</mnc>'
    //   689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload #22
    //   695: ldc_w '<lac>'
    //   698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload #22
    //   704: aload #6
    //   706: getfield c : I
    //   709: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #22
    //   715: ldc_w '</lac>'
    //   718: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload #22
    //   724: ldc_w '<cellid>'
    //   727: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload #22
    //   733: aload #6
    //   735: getfield d : I
    //   738: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload #22
    //   744: ldc_w '</cellid>'
    //   747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload #22
    //   753: ldc_w '<signal>'
    //   756: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload #22
    //   762: aload #6
    //   764: getfield j : I
    //   767: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload #22
    //   773: ldc_w '</signal>'
    //   776: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload #22
    //   782: invokevirtual toString : ()Ljava/lang/String;
    //   785: astore #16
    //   787: iconst_1
    //   788: istore #8
    //   790: aload #16
    //   792: astore #6
    //   794: iload #8
    //   796: aload #21
    //   798: invokevirtual size : ()I
    //   801: if_icmpge -> 895
    //   804: aload #21
    //   806: iload #8
    //   808: invokevirtual get : (I)Ljava/lang/Object;
    //   811: checkcast com/loc/dv
    //   814: astore #6
    //   816: aload #18
    //   818: aload #6
    //   820: getfield c : I
    //   823: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload #18
    //   829: ldc ','
    //   831: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload #18
    //   837: aload #6
    //   839: getfield d : I
    //   842: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload #18
    //   848: ldc ','
    //   850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload #18
    //   856: aload #6
    //   858: getfield j : I
    //   861: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: iload #8
    //   867: aload #21
    //   869: invokevirtual size : ()I
    //   872: iconst_1
    //   873: isub
    //   874: if_icmpge -> 886
    //   877: aload #18
    //   879: ldc_w '*'
    //   882: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: iload #8
    //   888: iconst_1
    //   889: iadd
    //   890: istore #8
    //   892: goto -> 790
    //   895: aload #22
    //   897: iconst_0
    //   898: aload #22
    //   900: invokevirtual length : ()I
    //   903: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: goto -> 910
    //   910: iload #11
    //   912: iconst_4
    //   913: iand
    //   914: iconst_4
    //   915: if_icmpne -> 946
    //   918: aload #20
    //   920: invokevirtual isEmpty : ()Z
    //   923: ifne -> 946
    //   926: aload_0
    //   927: getfield C : Ljava/util/ArrayList;
    //   930: invokevirtual clear : ()V
    //   933: aload_0
    //   934: getfield C : Ljava/util/ArrayList;
    //   937: aload #20
    //   939: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   942: pop
    //   943: goto -> 953
    //   946: aload_0
    //   947: getfield C : Ljava/util/ArrayList;
    //   950: invokevirtual clear : ()V
    //   953: new java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial <init> : ()V
    //   960: astore #16
    //   962: aload #5
    //   964: getfield q : Z
    //   967: ifeq -> 1153
    //   970: iload_3
    //   971: ifeq -> 1119
    //   974: aload #5
    //   976: invokevirtual k : ()Landroid/net/wifi/WifiInfo;
    //   979: astore #20
    //   981: aload #20
    //   983: invokestatic a : (Landroid/net/wifi/WifiInfo;)Z
    //   986: ifeq -> 1119
    //   989: aload #16
    //   991: aload #20
    //   993: invokevirtual getBSSID : ()Ljava/lang/String;
    //   996: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload #16
    //   1002: ldc ','
    //   1004: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: aload #20
    //   1010: invokevirtual getRssi : ()I
    //   1013: istore #9
    //   1015: iload #9
    //   1017: bipush #-128
    //   1019: if_icmpge -> 1028
    //   1022: iconst_0
    //   1023: istore #8
    //   1025: goto -> 1042
    //   1028: iload #9
    //   1030: istore #8
    //   1032: iload #9
    //   1034: bipush #127
    //   1036: if_icmple -> 1042
    //   1039: goto -> 1022
    //   1042: aload #16
    //   1044: iload #8
    //   1046: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload #16
    //   1052: ldc ','
    //   1054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload #20
    //   1060: invokevirtual getSSID : ()Ljava/lang/String;
    //   1063: astore #5
    //   1065: bipush #32
    //   1067: istore #8
    //   1069: aload #20
    //   1071: invokevirtual getSSID : ()Ljava/lang/String;
    //   1074: ldc_w 'UTF-8'
    //   1077: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   1080: arraylength
    //   1081: istore #9
    //   1083: iload #9
    //   1085: istore #8
    //   1087: goto -> 1090
    //   1090: iload #8
    //   1092: bipush #32
    //   1094: if_icmplt -> 1102
    //   1097: ldc_w 'unkwn'
    //   1100: astore #5
    //   1102: aload #16
    //   1104: aload #5
    //   1106: ldc_w '*'
    //   1109: ldc_w '.'
    //   1112: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload #19
    //   1121: ifnull -> 1174
    //   1124: aload_0
    //   1125: getfield F : Ljava/util/ArrayList;
    //   1128: astore #5
    //   1130: aload #5
    //   1132: ifnull -> 1174
    //   1135: aload #5
    //   1137: invokevirtual clear : ()V
    //   1140: aload_0
    //   1141: getfield F : Ljava/util/ArrayList;
    //   1144: aload #19
    //   1146: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   1149: pop
    //   1150: goto -> 1174
    //   1153: aload #5
    //   1155: invokevirtual g : ()V
    //   1158: aload_0
    //   1159: getfield F : Ljava/util/ArrayList;
    //   1162: astore #5
    //   1164: aload #5
    //   1166: ifnull -> 1174
    //   1169: aload #5
    //   1171: invokevirtual clear : ()V
    //   1174: aload_0
    //   1175: iconst_0
    //   1176: putfield b : S
    //   1179: iload_2
    //   1180: ifne -> 1194
    //   1183: aload_0
    //   1184: aload_0
    //   1185: getfield b : S
    //   1188: iconst_2
    //   1189: ior
    //   1190: i2s
    //   1191: putfield b : S
    //   1194: aload_0
    //   1195: aload #12
    //   1197: putfield c : Ljava/lang/String;
    //   1200: aload_0
    //   1201: aload #13
    //   1203: putfield d : Ljava/lang/String;
    //   1206: aload_0
    //   1207: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   1210: putfield f : Ljava/lang/String;
    //   1213: new java/lang/StringBuilder
    //   1216: dup
    //   1217: ldc_w 'android'
    //   1220: invokespecial <init> : (Ljava/lang/String;)V
    //   1223: astore #5
    //   1225: aload #5
    //   1227: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   1230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: pop
    //   1234: aload_0
    //   1235: aload #5
    //   1237: invokevirtual toString : ()Ljava/lang/String;
    //   1240: putfield g : Ljava/lang/String;
    //   1243: aload_0
    //   1244: aload_1
    //   1245: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   1248: putfield h : Ljava/lang/String;
    //   1251: aload_0
    //   1252: aload #14
    //   1254: putfield i : Ljava/lang/String;
    //   1257: aload_0
    //   1258: ldc '0'
    //   1260: putfield j : Ljava/lang/String;
    //   1263: aload_0
    //   1264: ldc '0'
    //   1266: putfield k : Ljava/lang/String;
    //   1269: aload_0
    //   1270: ldc '0'
    //   1272: putfield l : Ljava/lang/String;
    //   1275: aload_0
    //   1276: ldc '0'
    //   1278: putfield m : Ljava/lang/String;
    //   1281: aload_0
    //   1282: ldc '0'
    //   1284: putfield n : Ljava/lang/String;
    //   1287: aload_0
    //   1288: aload #17
    //   1290: putfield o : Ljava/lang/String;
    //   1293: aload_0
    //   1294: getstatic com/loc/ej.e : Ljava/lang/String;
    //   1297: putfield p : Ljava/lang/String;
    //   1300: aload_0
    //   1301: getstatic com/loc/ej.f : Ljava/lang/String;
    //   1304: putfield q : Ljava/lang/String;
    //   1307: aload_0
    //   1308: iload #10
    //   1310: invokestatic valueOf : (I)Ljava/lang/String;
    //   1313: putfield s : Ljava/lang/String;
    //   1316: aload_0
    //   1317: aload_1
    //   1318: invokestatic j : (Landroid/content/Context;)Ljava/lang/String;
    //   1321: putfield t : Ljava/lang/String;
    //   1324: aload_0
    //   1325: ldc_w '5.2.0'
    //   1328: putfield v : Ljava/lang/String;
    //   1331: aload_0
    //   1332: aconst_null
    //   1333: putfield w : Ljava/lang/String;
    //   1336: aload_0
    //   1337: ldc_w ''
    //   1340: putfield u : Ljava/lang/String;
    //   1343: aload_0
    //   1344: aload #15
    //   1346: putfield x : Ljava/lang/String;
    //   1349: aload_0
    //   1350: aload #7
    //   1352: putfield y : Ljava/lang/String;
    //   1355: aload_0
    //   1356: iload #11
    //   1358: putfield z : I
    //   1361: aload_0
    //   1362: aload #6
    //   1364: putfield A : Ljava/lang/String;
    //   1367: aload_0
    //   1368: aload #18
    //   1370: invokevirtual toString : ()Ljava/lang/String;
    //   1373: putfield B : Ljava/lang/String;
    //   1376: aload_0
    //   1377: aload #4
    //   1379: invokevirtual l : ()Ljava/lang/String;
    //   1382: putfield D : Ljava/lang/String;
    //   1385: aload_0
    //   1386: invokestatic o : ()Ljava/lang/String;
    //   1389: putfield G : Ljava/lang/String;
    //   1392: aload_0
    //   1393: aload #16
    //   1395: invokevirtual toString : ()Ljava/lang/String;
    //   1398: putfield E : Ljava/lang/String;
    //   1401: getstatic com/loc/eh.J : Ljava/lang/String;
    //   1404: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1407: ifeq -> 1417
    //   1410: aload_1
    //   1411: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   1414: putstatic com/loc/eh.J : Ljava/lang/String;
    //   1417: getstatic com/loc/eh.L : Ljava/lang/String;
    //   1420: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1423: ifeq -> 1433
    //   1426: aload_1
    //   1427: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   1430: putstatic com/loc/eh.L : Ljava/lang/String;
    //   1433: aload_0
    //   1434: getfield N : Ljava/lang/String;
    //   1437: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1440: ifeq -> 1451
    //   1443: aload_0
    //   1444: aload_1
    //   1445: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   1448: putfield N : Ljava/lang/String;
    //   1451: aload #18
    //   1453: iconst_0
    //   1454: aload #18
    //   1456: invokevirtual length : ()I
    //   1459: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1462: pop
    //   1463: aload #16
    //   1465: iconst_0
    //   1466: aload #16
    //   1468: invokevirtual length : ()I
    //   1471: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1474: pop
    //   1475: return
    //   1476: astore #7
    //   1478: goto -> 210
    //   1481: astore #20
    //   1483: goto -> 1090
    //   1486: astore #4
    //   1488: goto -> 1417
    //   1491: astore #4
    //   1493: goto -> 1433
    //   1496: astore_1
    //   1497: goto -> 1451
    // Exception table:
    //   from	to	target	type
    //   126	133	136	finally
    //   184	191	1476	java/lang/SecurityException
    //   184	191	194	finally
    //   236	243	246	finally
    //   1069	1083	1481	java/lang/Exception
    //   1401	1417	1486	finally
    //   1417	1433	1491	finally
    //   1433	1451	1496	finally
  }
  
  public final byte[] a() {
    // Byte code:
    //   0: bipush #28
    //   2: anewarray java/lang/String
    //   5: astore #12
    //   7: aload #12
    //   9: iconst_0
    //   10: aload_0
    //   11: getfield a : Ljava/lang/String;
    //   14: aastore
    //   15: aload #12
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield c : Ljava/lang/String;
    //   22: aastore
    //   23: aload #12
    //   25: iconst_2
    //   26: aload_0
    //   27: getfield d : Ljava/lang/String;
    //   30: aastore
    //   31: aload #12
    //   33: iconst_3
    //   34: aload_0
    //   35: getfield e : Ljava/lang/String;
    //   38: aastore
    //   39: aload #12
    //   41: iconst_4
    //   42: aload_0
    //   43: getfield f : Ljava/lang/String;
    //   46: aastore
    //   47: aload #12
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield g : Ljava/lang/String;
    //   54: aastore
    //   55: aload #12
    //   57: bipush #6
    //   59: aload_0
    //   60: getfield h : Ljava/lang/String;
    //   63: aastore
    //   64: aload #12
    //   66: bipush #7
    //   68: aload_0
    //   69: getfield i : Ljava/lang/String;
    //   72: aastore
    //   73: aload #12
    //   75: bipush #8
    //   77: aload_0
    //   78: getfield l : Ljava/lang/String;
    //   81: aastore
    //   82: aload #12
    //   84: bipush #9
    //   86: aload_0
    //   87: getfield m : Ljava/lang/String;
    //   90: aastore
    //   91: aload #12
    //   93: bipush #10
    //   95: aload_0
    //   96: getfield n : Ljava/lang/String;
    //   99: aastore
    //   100: aload #12
    //   102: bipush #11
    //   104: aload_0
    //   105: getfield o : Ljava/lang/String;
    //   108: aastore
    //   109: aload #12
    //   111: bipush #12
    //   113: aload_0
    //   114: getfield p : Ljava/lang/String;
    //   117: aastore
    //   118: aload #12
    //   120: bipush #13
    //   122: aload_0
    //   123: getfield q : Ljava/lang/String;
    //   126: aastore
    //   127: aload #12
    //   129: bipush #14
    //   131: aload_0
    //   132: getfield r : Ljava/lang/String;
    //   135: aastore
    //   136: aload #12
    //   138: bipush #15
    //   140: aload_0
    //   141: getfield s : Ljava/lang/String;
    //   144: aastore
    //   145: aload #12
    //   147: bipush #16
    //   149: aload_0
    //   150: getfield t : Ljava/lang/String;
    //   153: aastore
    //   154: aload #12
    //   156: bipush #17
    //   158: aload_0
    //   159: getfield u : Ljava/lang/String;
    //   162: aastore
    //   163: aload #12
    //   165: bipush #18
    //   167: aload_0
    //   168: getfield v : Ljava/lang/String;
    //   171: aastore
    //   172: aload #12
    //   174: bipush #19
    //   176: aload_0
    //   177: getfield w : Ljava/lang/String;
    //   180: aastore
    //   181: aload #12
    //   183: bipush #20
    //   185: aload_0
    //   186: getfield x : Ljava/lang/String;
    //   189: aastore
    //   190: aload #12
    //   192: bipush #21
    //   194: aload_0
    //   195: getfield A : Ljava/lang/String;
    //   198: aastore
    //   199: aload #12
    //   201: bipush #22
    //   203: aload_0
    //   204: getfield B : Ljava/lang/String;
    //   207: aastore
    //   208: aload #12
    //   210: bipush #23
    //   212: aload_0
    //   213: getfield E : Ljava/lang/String;
    //   216: aastore
    //   217: aload #12
    //   219: bipush #24
    //   221: aload_0
    //   222: getfield G : Ljava/lang/String;
    //   225: aastore
    //   226: aload #12
    //   228: bipush #25
    //   230: aload_0
    //   231: getfield H : Ljava/lang/String;
    //   234: aastore
    //   235: aload #12
    //   237: bipush #26
    //   239: getstatic com/loc/eh.J : Ljava/lang/String;
    //   242: aastore
    //   243: aload #12
    //   245: bipush #27
    //   247: aload_0
    //   248: getfield N : Ljava/lang/String;
    //   251: aastore
    //   252: iconst_0
    //   253: istore_3
    //   254: iload_3
    //   255: bipush #28
    //   257: if_icmpge -> 284
    //   260: aload #12
    //   262: iload_3
    //   263: aaload
    //   264: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   267: ifeq -> 277
    //   270: aload #12
    //   272: iload_3
    //   273: ldc_w ''
    //   276: aastore
    //   277: iload_3
    //   278: iconst_1
    //   279: iadd
    //   280: istore_3
    //   281: goto -> 254
    //   284: aload_0
    //   285: getfield j : Ljava/lang/String;
    //   288: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   291: ifeq -> 303
    //   294: aload_0
    //   295: ldc '0'
    //   297: putfield j : Ljava/lang/String;
    //   300: goto -> 331
    //   303: ldc '0'
    //   305: aload_0
    //   306: getfield j : Ljava/lang/String;
    //   309: invokevirtual equals : (Ljava/lang/Object;)Z
    //   312: ifne -> 331
    //   315: ldc_w '2'
    //   318: aload_0
    //   319: getfield j : Ljava/lang/String;
    //   322: invokevirtual equals : (Ljava/lang/Object;)Z
    //   325: ifne -> 331
    //   328: goto -> 294
    //   331: aload_0
    //   332: getfield k : Ljava/lang/String;
    //   335: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   338: ifeq -> 350
    //   341: aload_0
    //   342: ldc '0'
    //   344: putfield k : Ljava/lang/String;
    //   347: goto -> 377
    //   350: ldc '0'
    //   352: aload_0
    //   353: getfield k : Ljava/lang/String;
    //   356: invokevirtual equals : (Ljava/lang/Object;)Z
    //   359: ifne -> 377
    //   362: ldc '1'
    //   364: aload_0
    //   365: getfield k : Ljava/lang/String;
    //   368: invokevirtual equals : (Ljava/lang/Object;)Z
    //   371: ifne -> 377
    //   374: goto -> 341
    //   377: aload_0
    //   378: getfield y : Ljava/lang/String;
    //   381: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   384: ifeq -> 396
    //   387: aload_0
    //   388: ldc '0'
    //   390: putfield y : Ljava/lang/String;
    //   393: goto -> 424
    //   396: ldc '1'
    //   398: aload_0
    //   399: getfield y : Ljava/lang/String;
    //   402: invokevirtual equals : (Ljava/lang/Object;)Z
    //   405: ifne -> 424
    //   408: ldc_w '2'
    //   411: aload_0
    //   412: getfield y : Ljava/lang/String;
    //   415: invokevirtual equals : (Ljava/lang/Object;)Z
    //   418: ifne -> 424
    //   421: goto -> 387
    //   424: aload_0
    //   425: getfield z : I
    //   428: invokestatic a : (I)Z
    //   431: ifne -> 439
    //   434: aload_0
    //   435: iconst_0
    //   436: putfield z : I
    //   439: aload_0
    //   440: getfield I : [B
    //   443: ifnonnull -> 453
    //   446: aload_0
    //   447: iconst_0
    //   448: newarray byte
    //   450: putfield I : [B
    //   453: iconst_2
    //   454: newarray byte
    //   456: astore #15
    //   458: iconst_4
    //   459: newarray byte
    //   461: astore #13
    //   463: sipush #4096
    //   466: istore_3
    //   467: aload_0
    //   468: getfield I : [B
    //   471: astore #12
    //   473: aload #12
    //   475: ifnull -> 488
    //   478: aload #12
    //   480: arraylength
    //   481: iconst_1
    //   482: iadd
    //   483: sipush #4096
    //   486: iadd
    //   487: istore_3
    //   488: aload_0
    //   489: getfield O : [B
    //   492: astore #12
    //   494: aload #12
    //   496: ifnull -> 507
    //   499: iload_3
    //   500: aload_0
    //   501: getfield P : I
    //   504: if_icmple -> 523
    //   507: iload_3
    //   508: newarray byte
    //   510: astore #12
    //   512: aload_0
    //   513: aload #12
    //   515: putfield O : [B
    //   518: aload_0
    //   519: iload_3
    //   520: putfield P : I
    //   523: aload #12
    //   525: iconst_0
    //   526: aload_0
    //   527: getfield a : Ljava/lang/String;
    //   530: invokestatic i : (Ljava/lang/String;)B
    //   533: bastore
    //   534: aload_0
    //   535: getfield b : S
    //   538: aconst_null
    //   539: invokestatic a : (I[B)[B
    //   542: astore #14
    //   544: aload #14
    //   546: iconst_0
    //   547: aload #12
    //   549: iconst_1
    //   550: aload #14
    //   552: arraylength
    //   553: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   556: aload #14
    //   558: arraylength
    //   559: istore_3
    //   560: aload_0
    //   561: getfield c : Ljava/lang/String;
    //   564: aload #12
    //   566: iload_3
    //   567: iconst_1
    //   568: iadd
    //   569: invokestatic a : (Ljava/lang/String;[BI)I
    //   572: istore_3
    //   573: aload_0
    //   574: getfield d : Ljava/lang/String;
    //   577: aload #12
    //   579: iload_3
    //   580: invokestatic a : (Ljava/lang/String;[BI)I
    //   583: istore_3
    //   584: aload_0
    //   585: getfield o : Ljava/lang/String;
    //   588: aload #12
    //   590: iload_3
    //   591: invokestatic a : (Ljava/lang/String;[BI)I
    //   594: istore_3
    //   595: aload_0
    //   596: getfield e : Ljava/lang/String;
    //   599: aload #12
    //   601: iload_3
    //   602: invokestatic a : (Ljava/lang/String;[BI)I
    //   605: istore_3
    //   606: aload_0
    //   607: getfield f : Ljava/lang/String;
    //   610: aload #12
    //   612: iload_3
    //   613: invokestatic a : (Ljava/lang/String;[BI)I
    //   616: istore_3
    //   617: aload_0
    //   618: getfield g : Ljava/lang/String;
    //   621: aload #12
    //   623: iload_3
    //   624: invokestatic a : (Ljava/lang/String;[BI)I
    //   627: istore_3
    //   628: aload_0
    //   629: getfield u : Ljava/lang/String;
    //   632: aload #12
    //   634: iload_3
    //   635: invokestatic a : (Ljava/lang/String;[BI)I
    //   638: istore_3
    //   639: aload_0
    //   640: getfield h : Ljava/lang/String;
    //   643: aload #12
    //   645: iload_3
    //   646: invokestatic a : (Ljava/lang/String;[BI)I
    //   649: istore_3
    //   650: aload_0
    //   651: getfield p : Ljava/lang/String;
    //   654: aload #12
    //   656: iload_3
    //   657: invokestatic a : (Ljava/lang/String;[BI)I
    //   660: istore_3
    //   661: aload_0
    //   662: getfield q : Ljava/lang/String;
    //   665: aload #12
    //   667: iload_3
    //   668: invokestatic a : (Ljava/lang/String;[BI)I
    //   671: istore #4
    //   673: iload #4
    //   675: istore_3
    //   676: aload_0
    //   677: getfield t : Ljava/lang/String;
    //   680: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   683: ifeq -> 698
    //   686: aload #12
    //   688: iload #4
    //   690: iconst_0
    //   691: bastore
    //   692: iload #4
    //   694: istore_3
    //   695: goto -> 779
    //   698: iload #4
    //   700: istore_3
    //   701: aload_0
    //   702: aload_0
    //   703: getfield t : Ljava/lang/String;
    //   706: invokespecial a : (Ljava/lang/String;)[B
    //   709: astore #14
    //   711: iload #4
    //   713: istore_3
    //   714: aload #12
    //   716: iload #4
    //   718: aload #14
    //   720: arraylength
    //   721: i2b
    //   722: bastore
    //   723: iload #4
    //   725: iconst_1
    //   726: iadd
    //   727: istore #4
    //   729: iload #4
    //   731: istore_3
    //   732: aload #14
    //   734: iconst_0
    //   735: aload #12
    //   737: iload #4
    //   739: aload #14
    //   741: arraylength
    //   742: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   745: iload #4
    //   747: istore_3
    //   748: aload #14
    //   750: arraylength
    //   751: istore #5
    //   753: iload #4
    //   755: iload #5
    //   757: iadd
    //   758: istore_3
    //   759: goto -> 783
    //   762: astore #14
    //   764: aload #14
    //   766: ldc 'Req'
    //   768: ldc_w 'buildV4Dot219'
    //   771: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   774: aload #12
    //   776: iload_3
    //   777: iconst_0
    //   778: bastore
    //   779: iload_3
    //   780: iconst_1
    //   781: iadd
    //   782: istore_3
    //   783: aload_0
    //   784: getfield v : Ljava/lang/String;
    //   787: aload #12
    //   789: iload_3
    //   790: invokestatic a : (Ljava/lang/String;[BI)I
    //   793: istore_3
    //   794: aload_0
    //   795: getfield w : Ljava/lang/String;
    //   798: aload #12
    //   800: iload_3
    //   801: invokestatic a : (Ljava/lang/String;[BI)I
    //   804: istore_3
    //   805: getstatic com/loc/eh.J : Ljava/lang/String;
    //   808: aload #12
    //   810: iload_3
    //   811: invokestatic a : (Ljava/lang/String;[BI)I
    //   814: istore_3
    //   815: getstatic com/loc/eh.L : Ljava/lang/String;
    //   818: aload #12
    //   820: iload_3
    //   821: invokestatic a : (Ljava/lang/String;[BI)I
    //   824: istore_3
    //   825: aload_0
    //   826: getfield x : Ljava/lang/String;
    //   829: aload #12
    //   831: iload_3
    //   832: invokestatic a : (Ljava/lang/String;[BI)I
    //   835: istore_3
    //   836: aload #12
    //   838: iload_3
    //   839: aload_0
    //   840: getfield y : Ljava/lang/String;
    //   843: invokestatic parseByte : (Ljava/lang/String;)B
    //   846: bastore
    //   847: iload_3
    //   848: iconst_1
    //   849: iadd
    //   850: istore_3
    //   851: aload #12
    //   853: iload_3
    //   854: aload_0
    //   855: getfield j : Ljava/lang/String;
    //   858: invokestatic parseByte : (Ljava/lang/String;)B
    //   861: bastore
    //   862: iload_3
    //   863: iconst_1
    //   864: iadd
    //   865: istore_3
    //   866: aload_0
    //   867: getfield z : I
    //   870: istore #4
    //   872: iload #4
    //   874: iconst_3
    //   875: iand
    //   876: istore #6
    //   878: aload #12
    //   880: iload_3
    //   881: iload #4
    //   883: i2b
    //   884: bastore
    //   885: iload_3
    //   886: iconst_1
    //   887: iadd
    //   888: istore #4
    //   890: iload #6
    //   892: iconst_1
    //   893: if_icmpeq -> 905
    //   896: iload #4
    //   898: istore_3
    //   899: iload #6
    //   901: iconst_2
    //   902: if_icmpne -> 1483
    //   905: aload_0
    //   906: ldc_w 'mcc'
    //   909: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   912: invokestatic b : (Ljava/lang/String;)[B
    //   915: astore #14
    //   917: aload #14
    //   919: iconst_0
    //   920: aload #12
    //   922: iload #4
    //   924: aload #14
    //   926: arraylength
    //   927: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   930: iload #4
    //   932: aload #14
    //   934: arraylength
    //   935: iadd
    //   936: istore #4
    //   938: iload #6
    //   940: iconst_1
    //   941: if_icmpne -> 1041
    //   944: aload_0
    //   945: ldc_w 'mnc'
    //   948: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   951: invokestatic b : (Ljava/lang/String;)[B
    //   954: astore #14
    //   956: aload #14
    //   958: iconst_0
    //   959: aload #12
    //   961: iload #4
    //   963: aload #14
    //   965: arraylength
    //   966: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   969: iload #4
    //   971: aload #14
    //   973: arraylength
    //   974: iadd
    //   975: istore_3
    //   976: aload_0
    //   977: ldc 'lac'
    //   979: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   982: invokestatic b : (Ljava/lang/String;)[B
    //   985: astore #14
    //   987: aload #14
    //   989: iconst_0
    //   990: aload #12
    //   992: iload_3
    //   993: aload #14
    //   995: arraylength
    //   996: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   999: iload_3
    //   1000: aload #14
    //   1002: arraylength
    //   1003: iadd
    //   1004: istore_3
    //   1005: aload_0
    //   1006: ldc 'cellid'
    //   1008: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1011: invokestatic c : (Ljava/lang/String;)[B
    //   1014: astore #14
    //   1016: aload #14
    //   1018: iconst_0
    //   1019: aload #12
    //   1021: iload_3
    //   1022: aload #14
    //   1024: arraylength
    //   1025: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1028: aload #14
    //   1030: arraylength
    //   1031: istore #4
    //   1033: iload_3
    //   1034: iload #4
    //   1036: iadd
    //   1037: istore_3
    //   1038: goto -> 1204
    //   1041: iload #4
    //   1043: istore_3
    //   1044: iload #6
    //   1046: iconst_2
    //   1047: if_icmpne -> 1204
    //   1050: aload_0
    //   1051: ldc_w 'sid'
    //   1054: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1057: invokestatic b : (Ljava/lang/String;)[B
    //   1060: astore #14
    //   1062: aload #14
    //   1064: iconst_0
    //   1065: aload #12
    //   1067: iload #4
    //   1069: aload #14
    //   1071: arraylength
    //   1072: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1075: iload #4
    //   1077: aload #14
    //   1079: arraylength
    //   1080: iadd
    //   1081: istore_3
    //   1082: aload_0
    //   1083: ldc_w 'nid'
    //   1086: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1089: invokestatic b : (Ljava/lang/String;)[B
    //   1092: astore #14
    //   1094: aload #14
    //   1096: iconst_0
    //   1097: aload #12
    //   1099: iload_3
    //   1100: aload #14
    //   1102: arraylength
    //   1103: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1106: iload_3
    //   1107: aload #14
    //   1109: arraylength
    //   1110: iadd
    //   1111: istore_3
    //   1112: aload_0
    //   1113: ldc_w 'bid'
    //   1116: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1119: invokestatic b : (Ljava/lang/String;)[B
    //   1122: astore #14
    //   1124: aload #14
    //   1126: iconst_0
    //   1127: aload #12
    //   1129: iload_3
    //   1130: aload #14
    //   1132: arraylength
    //   1133: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1136: iload_3
    //   1137: aload #14
    //   1139: arraylength
    //   1140: iadd
    //   1141: istore_3
    //   1142: aload_0
    //   1143: ldc_w 'lon'
    //   1146: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1149: invokestatic c : (Ljava/lang/String;)[B
    //   1152: astore #14
    //   1154: aload #14
    //   1156: iconst_0
    //   1157: aload #12
    //   1159: iload_3
    //   1160: aload #14
    //   1162: arraylength
    //   1163: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1166: iload_3
    //   1167: aload #14
    //   1169: arraylength
    //   1170: iadd
    //   1171: istore_3
    //   1172: aload_0
    //   1173: ldc_w 'lat'
    //   1176: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1179: invokestatic c : (Ljava/lang/String;)[B
    //   1182: astore #14
    //   1184: aload #14
    //   1186: iconst_0
    //   1187: aload #12
    //   1189: iload_3
    //   1190: aload #14
    //   1192: arraylength
    //   1193: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1196: aload #14
    //   1198: arraylength
    //   1199: istore #4
    //   1201: goto -> 1033
    //   1204: aload_0
    //   1205: ldc 'signal'
    //   1207: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   1210: invokestatic parseInt : (Ljava/lang/String;)I
    //   1213: istore #5
    //   1215: iload #5
    //   1217: bipush #127
    //   1219: if_icmple -> 1228
    //   1222: iconst_0
    //   1223: istore #4
    //   1225: goto -> 1242
    //   1228: iload #5
    //   1230: istore #4
    //   1232: iload #5
    //   1234: bipush #-128
    //   1236: if_icmpge -> 1242
    //   1239: goto -> 1222
    //   1242: aload #12
    //   1244: iload_3
    //   1245: iload #4
    //   1247: i2b
    //   1248: bastore
    //   1249: iload_3
    //   1250: iconst_1
    //   1251: iadd
    //   1252: istore_3
    //   1253: iconst_0
    //   1254: aload #15
    //   1256: invokestatic a : (I[B)[B
    //   1259: astore #14
    //   1261: aload #14
    //   1263: iconst_0
    //   1264: aload #12
    //   1266: iload_3
    //   1267: aload #14
    //   1269: arraylength
    //   1270: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1273: iload_3
    //   1274: iconst_2
    //   1275: iadd
    //   1276: istore #4
    //   1278: iload #6
    //   1280: iconst_1
    //   1281: if_icmpne -> 1463
    //   1284: aload_0
    //   1285: getfield B : Ljava/lang/String;
    //   1288: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1291: ifeq -> 1303
    //   1294: aload #12
    //   1296: iload #4
    //   1298: iconst_0
    //   1299: bastore
    //   1300: goto -> 1478
    //   1303: aload_0
    //   1304: getfield B : Ljava/lang/String;
    //   1307: ldc '\*'
    //   1309: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1312: arraylength
    //   1313: istore #6
    //   1315: aload #12
    //   1317: iload #4
    //   1319: iload #6
    //   1321: i2b
    //   1322: bastore
    //   1323: iload #4
    //   1325: iconst_1
    //   1326: iadd
    //   1327: istore_3
    //   1328: iconst_0
    //   1329: istore #4
    //   1331: iload #4
    //   1333: iload #6
    //   1335: if_icmpge -> 1460
    //   1338: aload_0
    //   1339: ldc 'lac'
    //   1341: iload #4
    //   1343: invokespecial a : (Ljava/lang/String;I)Ljava/lang/String;
    //   1346: invokestatic b : (Ljava/lang/String;)[B
    //   1349: astore #14
    //   1351: aload #14
    //   1353: iconst_0
    //   1354: aload #12
    //   1356: iload_3
    //   1357: aload #14
    //   1359: arraylength
    //   1360: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1363: iload_3
    //   1364: aload #14
    //   1366: arraylength
    //   1367: iadd
    //   1368: istore_3
    //   1369: aload_0
    //   1370: ldc 'cellid'
    //   1372: iload #4
    //   1374: invokespecial a : (Ljava/lang/String;I)Ljava/lang/String;
    //   1377: invokestatic c : (Ljava/lang/String;)[B
    //   1380: astore #14
    //   1382: aload #14
    //   1384: iconst_0
    //   1385: aload #12
    //   1387: iload_3
    //   1388: aload #14
    //   1390: arraylength
    //   1391: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1394: iload_3
    //   1395: aload #14
    //   1397: arraylength
    //   1398: iadd
    //   1399: istore #7
    //   1401: aload_0
    //   1402: ldc 'signal'
    //   1404: iload #4
    //   1406: invokespecial a : (Ljava/lang/String;I)Ljava/lang/String;
    //   1409: invokestatic parseInt : (Ljava/lang/String;)I
    //   1412: istore #5
    //   1414: iload #5
    //   1416: bipush #127
    //   1418: if_icmple -> 1426
    //   1421: iconst_0
    //   1422: istore_3
    //   1423: goto -> 1439
    //   1426: iload #5
    //   1428: istore_3
    //   1429: iload #5
    //   1431: bipush #-128
    //   1433: if_icmpge -> 1439
    //   1436: goto -> 1421
    //   1439: aload #12
    //   1441: iload #7
    //   1443: iload_3
    //   1444: i2b
    //   1445: bastore
    //   1446: iload #7
    //   1448: iconst_1
    //   1449: iadd
    //   1450: istore_3
    //   1451: iload #4
    //   1453: iconst_1
    //   1454: iadd
    //   1455: istore #4
    //   1457: goto -> 1331
    //   1460: goto -> 1483
    //   1463: iload #4
    //   1465: istore_3
    //   1466: iload #6
    //   1468: iconst_2
    //   1469: if_icmpne -> 1483
    //   1472: aload #12
    //   1474: iload #4
    //   1476: iconst_0
    //   1477: bastore
    //   1478: iload #4
    //   1480: iconst_1
    //   1481: iadd
    //   1482: istore_3
    //   1483: aload_0
    //   1484: getfield D : Ljava/lang/String;
    //   1487: astore #14
    //   1489: iload_3
    //   1490: istore #4
    //   1492: aload #14
    //   1494: ifnull -> 1570
    //   1497: iload_3
    //   1498: istore #4
    //   1500: aload_0
    //   1501: getfield z : I
    //   1504: bipush #8
    //   1506: iand
    //   1507: bipush #8
    //   1509: if_icmpne -> 1570
    //   1512: iload_3
    //   1513: istore #4
    //   1515: aload #14
    //   1517: ldc 'GBK'
    //   1519: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   1522: astore #14
    //   1524: iload_3
    //   1525: istore #4
    //   1527: aload #14
    //   1529: arraylength
    //   1530: bipush #60
    //   1532: invokestatic min : (II)I
    //   1535: istore #5
    //   1537: aload #12
    //   1539: iload_3
    //   1540: iload #5
    //   1542: i2b
    //   1543: bastore
    //   1544: iload_3
    //   1545: iconst_1
    //   1546: iadd
    //   1547: istore_3
    //   1548: iload_3
    //   1549: istore #4
    //   1551: aload #14
    //   1553: iconst_0
    //   1554: aload #12
    //   1556: iload_3
    //   1557: iload #5
    //   1559: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1562: iload_3
    //   1563: iload #5
    //   1565: iadd
    //   1566: istore_3
    //   1567: goto -> 1581
    //   1570: aload #12
    //   1572: iload #4
    //   1574: iconst_0
    //   1575: bastore
    //   1576: iload #4
    //   1578: iconst_1
    //   1579: iadd
    //   1580: istore_3
    //   1581: aload_0
    //   1582: getfield C : Ljava/util/ArrayList;
    //   1585: astore #14
    //   1587: aload #14
    //   1589: invokevirtual size : ()I
    //   1592: istore #4
    //   1594: aload_0
    //   1595: getfield z : I
    //   1598: iconst_4
    //   1599: iand
    //   1600: iconst_4
    //   1601: if_icmpne -> 2296
    //   1604: iload #4
    //   1606: ifle -> 2296
    //   1609: iload #4
    //   1611: istore #5
    //   1613: aload #14
    //   1615: iconst_0
    //   1616: invokevirtual get : (I)Ljava/lang/Object;
    //   1619: checkcast com/loc/dv
    //   1622: getfield p : Z
    //   1625: ifne -> 1634
    //   1628: iload #4
    //   1630: iconst_1
    //   1631: isub
    //   1632: istore #5
    //   1634: aload #12
    //   1636: iload_3
    //   1637: iload #5
    //   1639: i2b
    //   1640: bastore
    //   1641: iload_3
    //   1642: iconst_1
    //   1643: iadd
    //   1644: istore_3
    //   1645: iconst_0
    //   1646: istore #6
    //   1648: iload_3
    //   1649: istore #4
    //   1651: iload #6
    //   1653: iload #5
    //   1655: if_icmpge -> 2306
    //   1658: aload #14
    //   1660: iload #6
    //   1662: invokevirtual get : (I)Ljava/lang/Object;
    //   1665: checkcast com/loc/dv
    //   1668: astore #16
    //   1670: iload_3
    //   1671: istore #4
    //   1673: aload #16
    //   1675: getfield p : Z
    //   1678: ifeq -> 2284
    //   1681: aload #16
    //   1683: getfield k : I
    //   1686: iconst_1
    //   1687: if_icmpeq -> 1938
    //   1690: aload #16
    //   1692: getfield k : I
    //   1695: iconst_3
    //   1696: if_icmpeq -> 1938
    //   1699: aload #16
    //   1701: getfield k : I
    //   1704: iconst_4
    //   1705: if_icmpne -> 1711
    //   1708: goto -> 1938
    //   1711: iload_3
    //   1712: istore #4
    //   1714: aload #16
    //   1716: getfield k : I
    //   1719: iconst_2
    //   1720: if_icmpne -> 2096
    //   1723: aload #16
    //   1725: getfield k : I
    //   1728: i2b
    //   1729: istore_2
    //   1730: iload_2
    //   1731: istore_1
    //   1732: aload #16
    //   1734: getfield n : Z
    //   1737: ifeq -> 1746
    //   1740: iload_2
    //   1741: bipush #8
    //   1743: ior
    //   1744: i2b
    //   1745: istore_1
    //   1746: aload #12
    //   1748: iload_3
    //   1749: iload_1
    //   1750: bastore
    //   1751: iload_3
    //   1752: iconst_1
    //   1753: iadd
    //   1754: istore_3
    //   1755: aload #16
    //   1757: getfield a : I
    //   1760: aload #15
    //   1762: invokestatic a : (I[B)[B
    //   1765: astore #17
    //   1767: aload #17
    //   1769: iconst_0
    //   1770: aload #12
    //   1772: iload_3
    //   1773: aload #17
    //   1775: arraylength
    //   1776: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1779: iload_3
    //   1780: aload #17
    //   1782: arraylength
    //   1783: iadd
    //   1784: istore_3
    //   1785: aload #16
    //   1787: getfield g : I
    //   1790: aload #15
    //   1792: invokestatic a : (I[B)[B
    //   1795: astore #17
    //   1797: aload #17
    //   1799: iconst_0
    //   1800: aload #12
    //   1802: iload_3
    //   1803: aload #17
    //   1805: arraylength
    //   1806: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1809: iload_3
    //   1810: aload #17
    //   1812: arraylength
    //   1813: iadd
    //   1814: istore_3
    //   1815: aload #16
    //   1817: getfield h : I
    //   1820: aload #15
    //   1822: invokestatic a : (I[B)[B
    //   1825: astore #17
    //   1827: aload #17
    //   1829: iconst_0
    //   1830: aload #12
    //   1832: iload_3
    //   1833: aload #17
    //   1835: arraylength
    //   1836: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1839: iload_3
    //   1840: aload #17
    //   1842: arraylength
    //   1843: iadd
    //   1844: istore_3
    //   1845: aload #16
    //   1847: getfield i : I
    //   1850: aload #15
    //   1852: invokestatic a : (I[B)[B
    //   1855: astore #17
    //   1857: aload #17
    //   1859: iconst_0
    //   1860: aload #12
    //   1862: iload_3
    //   1863: aload #17
    //   1865: arraylength
    //   1866: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1869: iload_3
    //   1870: aload #17
    //   1872: arraylength
    //   1873: iadd
    //   1874: istore_3
    //   1875: aload #16
    //   1877: getfield f : I
    //   1880: aload #13
    //   1882: invokestatic b : (I[B)[B
    //   1885: astore #17
    //   1887: aload #17
    //   1889: iconst_0
    //   1890: aload #12
    //   1892: iload_3
    //   1893: aload #17
    //   1895: arraylength
    //   1896: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1899: iload_3
    //   1900: aload #17
    //   1902: arraylength
    //   1903: iadd
    //   1904: istore #4
    //   1906: aload #16
    //   1908: getfield e : I
    //   1911: aload #13
    //   1913: invokestatic b : (I[B)[B
    //   1916: astore #17
    //   1918: aload #17
    //   1920: iconst_0
    //   1921: aload #12
    //   1923: iload #4
    //   1925: aload #17
    //   1927: arraylength
    //   1928: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1931: aload #17
    //   1933: arraylength
    //   1934: istore_3
    //   1935: goto -> 2090
    //   1938: aload #16
    //   1940: getfield k : I
    //   1943: i2b
    //   1944: istore_2
    //   1945: iload_2
    //   1946: istore_1
    //   1947: aload #16
    //   1949: getfield n : Z
    //   1952: ifeq -> 1961
    //   1955: iload_2
    //   1956: bipush #8
    //   1958: ior
    //   1959: i2b
    //   1960: istore_1
    //   1961: aload #12
    //   1963: iload_3
    //   1964: iload_1
    //   1965: bastore
    //   1966: iload_3
    //   1967: iconst_1
    //   1968: iadd
    //   1969: istore_3
    //   1970: aload #16
    //   1972: getfield a : I
    //   1975: aload #15
    //   1977: invokestatic a : (I[B)[B
    //   1980: astore #17
    //   1982: aload #17
    //   1984: iconst_0
    //   1985: aload #12
    //   1987: iload_3
    //   1988: aload #17
    //   1990: arraylength
    //   1991: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1994: iload_3
    //   1995: aload #17
    //   1997: arraylength
    //   1998: iadd
    //   1999: istore_3
    //   2000: aload #16
    //   2002: getfield b : I
    //   2005: aload #15
    //   2007: invokestatic a : (I[B)[B
    //   2010: astore #17
    //   2012: aload #17
    //   2014: iconst_0
    //   2015: aload #12
    //   2017: iload_3
    //   2018: aload #17
    //   2020: arraylength
    //   2021: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2024: iload_3
    //   2025: aload #17
    //   2027: arraylength
    //   2028: iadd
    //   2029: istore_3
    //   2030: aload #16
    //   2032: getfield c : I
    //   2035: aload #15
    //   2037: invokestatic a : (I[B)[B
    //   2040: astore #17
    //   2042: aload #17
    //   2044: iconst_0
    //   2045: aload #12
    //   2047: iload_3
    //   2048: aload #17
    //   2050: arraylength
    //   2051: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2054: iload_3
    //   2055: aload #17
    //   2057: arraylength
    //   2058: iadd
    //   2059: istore #4
    //   2061: aload #16
    //   2063: getfield d : I
    //   2066: aload #13
    //   2068: invokestatic b : (I[B)[B
    //   2071: astore #17
    //   2073: aload #17
    //   2075: iconst_0
    //   2076: aload #12
    //   2078: iload #4
    //   2080: aload #17
    //   2082: arraylength
    //   2083: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2086: aload #17
    //   2088: arraylength
    //   2089: istore_3
    //   2090: iload #4
    //   2092: iload_3
    //   2093: iadd
    //   2094: istore #4
    //   2096: aload #16
    //   2098: getfield j : I
    //   2101: istore #7
    //   2103: iload #7
    //   2105: bipush #127
    //   2107: if_icmple -> 2116
    //   2110: bipush #99
    //   2112: istore_3
    //   2113: goto -> 2129
    //   2116: iload #7
    //   2118: istore_3
    //   2119: iload #7
    //   2121: bipush #-128
    //   2123: if_icmpge -> 2129
    //   2126: goto -> 2110
    //   2129: aload #12
    //   2131: iload #4
    //   2133: iload_3
    //   2134: i2b
    //   2135: bastore
    //   2136: iload #4
    //   2138: iconst_1
    //   2139: iadd
    //   2140: istore_3
    //   2141: aload #16
    //   2143: getfield l : S
    //   2146: aload #15
    //   2148: invokestatic a : (I[B)[B
    //   2151: astore #17
    //   2153: aload #17
    //   2155: iconst_0
    //   2156: aload #12
    //   2158: iload_3
    //   2159: aload #17
    //   2161: arraylength
    //   2162: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2165: iload_3
    //   2166: aload #17
    //   2168: arraylength
    //   2169: iadd
    //   2170: istore #7
    //   2172: iload #7
    //   2174: istore #4
    //   2176: ldc_w '5.1'
    //   2179: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   2182: invokevirtual doubleValue : ()D
    //   2185: ldc2_w 5.0
    //   2188: dcmpl
    //   2189: iflt -> 2284
    //   2192: aload #16
    //   2194: getfield k : I
    //   2197: iconst_3
    //   2198: if_icmpeq -> 2216
    //   2201: iload #7
    //   2203: istore_3
    //   2204: aload #16
    //   2206: getfield k : I
    //   2209: iconst_4
    //   2210: if_icmpne -> 2287
    //   2213: goto -> 2216
    //   2216: aload #16
    //   2218: getfield o : I
    //   2221: istore #8
    //   2223: sipush #32767
    //   2226: istore #4
    //   2228: iload #8
    //   2230: istore_3
    //   2231: iload #8
    //   2233: sipush #32767
    //   2236: if_icmple -> 2243
    //   2239: sipush #32767
    //   2242: istore_3
    //   2243: iload_3
    //   2244: ifge -> 2253
    //   2247: iload #4
    //   2249: istore_3
    //   2250: goto -> 2253
    //   2253: iload_3
    //   2254: aload #15
    //   2256: invokestatic a : (I[B)[B
    //   2259: astore #16
    //   2261: aload #16
    //   2263: iconst_0
    //   2264: aload #12
    //   2266: iload #7
    //   2268: aload #16
    //   2270: arraylength
    //   2271: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2274: iload #7
    //   2276: aload #16
    //   2278: arraylength
    //   2279: iadd
    //   2280: istore_3
    //   2281: goto -> 2287
    //   2284: iload #4
    //   2286: istore_3
    //   2287: iload #6
    //   2289: iconst_1
    //   2290: iadd
    //   2291: istore #6
    //   2293: goto -> 1648
    //   2296: aload #12
    //   2298: iload_3
    //   2299: iconst_0
    //   2300: bastore
    //   2301: iload_3
    //   2302: iconst_1
    //   2303: iadd
    //   2304: istore #4
    //   2306: aload_0
    //   2307: getfield E : Ljava/lang/String;
    //   2310: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2313: ifne -> 2596
    //   2316: aload_0
    //   2317: getfield E : Ljava/lang/String;
    //   2320: invokevirtual length : ()I
    //   2323: ifne -> 2329
    //   2326: goto -> 2596
    //   2329: aload #12
    //   2331: iload #4
    //   2333: iconst_1
    //   2334: bastore
    //   2335: iload #4
    //   2337: iconst_1
    //   2338: iadd
    //   2339: istore_3
    //   2340: iload_3
    //   2341: istore #4
    //   2343: aload_0
    //   2344: getfield E : Ljava/lang/String;
    //   2347: ldc ','
    //   2349: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   2352: astore #13
    //   2354: iload_3
    //   2355: istore #4
    //   2357: aload_0
    //   2358: aload #13
    //   2360: iconst_0
    //   2361: aaload
    //   2362: invokespecial a : (Ljava/lang/String;)[B
    //   2365: astore #14
    //   2367: iload_3
    //   2368: istore #4
    //   2370: aload #14
    //   2372: iconst_0
    //   2373: aload #12
    //   2375: iload_3
    //   2376: aload #14
    //   2378: arraylength
    //   2379: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2382: iload_3
    //   2383: istore #4
    //   2385: aload #14
    //   2387: arraylength
    //   2388: istore #5
    //   2390: iload_3
    //   2391: iload #5
    //   2393: iadd
    //   2394: istore #5
    //   2396: iload #5
    //   2398: istore_3
    //   2399: aload #13
    //   2401: iconst_2
    //   2402: aaload
    //   2403: ldc 'GBK'
    //   2405: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   2408: astore #14
    //   2410: iload #5
    //   2412: istore_3
    //   2413: aload #14
    //   2415: arraylength
    //   2416: istore #6
    //   2418: iload #6
    //   2420: istore #4
    //   2422: iload #6
    //   2424: bipush #127
    //   2426: if_icmple -> 2433
    //   2429: bipush #127
    //   2431: istore #4
    //   2433: aload #12
    //   2435: iload #5
    //   2437: iload #4
    //   2439: i2b
    //   2440: bastore
    //   2441: iload #5
    //   2443: iconst_1
    //   2444: iadd
    //   2445: istore #5
    //   2447: iload #5
    //   2449: istore_3
    //   2450: aload #14
    //   2452: iconst_0
    //   2453: aload #12
    //   2455: iload #5
    //   2457: iload #4
    //   2459: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2462: iload #5
    //   2464: iload #4
    //   2466: iadd
    //   2467: istore_3
    //   2468: goto -> 2495
    //   2471: astore #14
    //   2473: iload_3
    //   2474: istore #4
    //   2476: aload #14
    //   2478: ldc 'Req'
    //   2480: ldc_w 'buildV4Dot214'
    //   2483: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   2486: aload #12
    //   2488: iload_3
    //   2489: iconst_0
    //   2490: bastore
    //   2491: iload_3
    //   2492: iconst_1
    //   2493: iadd
    //   2494: istore_3
    //   2495: iload_3
    //   2496: istore #4
    //   2498: aload #13
    //   2500: iconst_1
    //   2501: aaload
    //   2502: invokestatic parseInt : (Ljava/lang/String;)I
    //   2505: istore #6
    //   2507: iload #6
    //   2509: bipush #127
    //   2511: if_icmple -> 3520
    //   2514: goto -> 3514
    //   2517: iload_3
    //   2518: istore #4
    //   2520: aload #12
    //   2522: iload_3
    //   2523: iload #5
    //   2525: invokestatic valueOf : (I)Ljava/lang/String;
    //   2528: invokestatic parseByte : (Ljava/lang/String;)B
    //   2531: bastore
    //   2532: goto -> 2605
    //   2535: astore #13
    //   2537: aload #13
    //   2539: ldc 'Req'
    //   2541: ldc_w 'buildV4Dot216'
    //   2544: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   2547: aload_0
    //   2548: ldc '00:00:00:00:00:00'
    //   2550: invokespecial a : (Ljava/lang/String;)[B
    //   2553: astore #13
    //   2555: aload #13
    //   2557: iconst_0
    //   2558: aload #12
    //   2560: iload #4
    //   2562: aload #13
    //   2564: arraylength
    //   2565: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2568: iload #4
    //   2570: aload #13
    //   2572: arraylength
    //   2573: iadd
    //   2574: istore_3
    //   2575: aload #12
    //   2577: iload_3
    //   2578: iconst_0
    //   2579: bastore
    //   2580: iload_3
    //   2581: iconst_1
    //   2582: iadd
    //   2583: istore_3
    //   2584: aload #12
    //   2586: iload_3
    //   2587: ldc '0'
    //   2589: invokestatic parseByte : (Ljava/lang/String;)B
    //   2592: bastore
    //   2593: goto -> 2605
    //   2596: aload #12
    //   2598: iload #4
    //   2600: iconst_0
    //   2601: bastore
    //   2602: iload #4
    //   2604: istore_3
    //   2605: iload_3
    //   2606: iconst_1
    //   2607: iadd
    //   2608: istore_3
    //   2609: aload_0
    //   2610: getfield F : Ljava/util/ArrayList;
    //   2613: astore #13
    //   2615: aload #13
    //   2617: invokevirtual size : ()I
    //   2620: bipush #25
    //   2622: invokestatic min : (II)I
    //   2625: istore #8
    //   2627: iload #8
    //   2629: ifne -> 2644
    //   2632: aload #12
    //   2634: iload_3
    //   2635: iconst_0
    //   2636: bastore
    //   2637: iload_3
    //   2638: iconst_1
    //   2639: iadd
    //   2640: istore_3
    //   2641: goto -> 3014
    //   2644: aload #12
    //   2646: iload_3
    //   2647: iload #8
    //   2649: i2b
    //   2650: bastore
    //   2651: iload_3
    //   2652: iconst_1
    //   2653: iadd
    //   2654: istore_3
    //   2655: invokestatic c : ()I
    //   2658: bipush #17
    //   2660: if_icmplt -> 2669
    //   2663: iconst_1
    //   2664: istore #4
    //   2666: goto -> 2672
    //   2669: iconst_0
    //   2670: istore #4
    //   2672: lconst_0
    //   2673: lstore #9
    //   2675: iload #4
    //   2677: ifeq -> 2689
    //   2680: invokestatic b : ()J
    //   2683: ldc2_w 1000
    //   2686: ldiv
    //   2687: lstore #9
    //   2689: iconst_0
    //   2690: istore #5
    //   2692: iload #5
    //   2694: iload #8
    //   2696: if_icmpge -> 2982
    //   2699: aload #13
    //   2701: iload #5
    //   2703: invokevirtual get : (I)Ljava/lang/Object;
    //   2706: checkcast android/net/wifi/ScanResult
    //   2709: astore #14
    //   2711: aload_0
    //   2712: aload #14
    //   2714: getfield BSSID : Ljava/lang/String;
    //   2717: invokespecial a : (Ljava/lang/String;)[B
    //   2720: astore #16
    //   2722: aload #16
    //   2724: iconst_0
    //   2725: aload #12
    //   2727: iload_3
    //   2728: aload #16
    //   2730: arraylength
    //   2731: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2734: iload_3
    //   2735: aload #16
    //   2737: arraylength
    //   2738: iadd
    //   2739: istore #6
    //   2741: iload #6
    //   2743: istore_3
    //   2744: aload #14
    //   2746: getfield SSID : Ljava/lang/String;
    //   2749: ldc 'GBK'
    //   2751: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   2754: astore #16
    //   2756: iload #6
    //   2758: istore_3
    //   2759: aload #12
    //   2761: iload #6
    //   2763: aload #16
    //   2765: arraylength
    //   2766: i2b
    //   2767: bastore
    //   2768: iload #6
    //   2770: iconst_1
    //   2771: iadd
    //   2772: istore #6
    //   2774: iload #6
    //   2776: istore_3
    //   2777: aload #16
    //   2779: iconst_0
    //   2780: aload #12
    //   2782: iload #6
    //   2784: aload #16
    //   2786: arraylength
    //   2787: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2790: iload #6
    //   2792: istore_3
    //   2793: aload #16
    //   2795: arraylength
    //   2796: istore #7
    //   2798: iload #6
    //   2800: iload #7
    //   2802: iadd
    //   2803: istore_3
    //   2804: goto -> 2816
    //   2807: aload #12
    //   2809: iload_3
    //   2810: iconst_0
    //   2811: bastore
    //   2812: iload_3
    //   2813: iconst_1
    //   2814: iadd
    //   2815: istore_3
    //   2816: aload #14
    //   2818: getfield level : I
    //   2821: istore #7
    //   2823: iload #7
    //   2825: bipush #127
    //   2827: if_icmple -> 2836
    //   2830: iconst_0
    //   2831: istore #6
    //   2833: goto -> 2850
    //   2836: iload #7
    //   2838: istore #6
    //   2840: iload #7
    //   2842: bipush #-128
    //   2844: if_icmpge -> 2850
    //   2847: goto -> 2830
    //   2850: aload #12
    //   2852: iload_3
    //   2853: iload #6
    //   2855: invokestatic valueOf : (I)Ljava/lang/String;
    //   2858: invokestatic parseByte : (Ljava/lang/String;)B
    //   2861: bastore
    //   2862: iload_3
    //   2863: iconst_1
    //   2864: iadd
    //   2865: istore #7
    //   2867: iload #4
    //   2869: ifeq -> 2897
    //   2872: lload #9
    //   2874: aload #14
    //   2876: getfield timestamp : J
    //   2879: ldc2_w 1000000
    //   2882: ldiv
    //   2883: lconst_1
    //   2884: ladd
    //   2885: lsub
    //   2886: l2i
    //   2887: istore #6
    //   2889: iload #6
    //   2891: istore_3
    //   2892: iload #6
    //   2894: ifge -> 2899
    //   2897: iconst_0
    //   2898: istore_3
    //   2899: iload_3
    //   2900: istore #6
    //   2902: iload_3
    //   2903: ldc_w 65535
    //   2906: if_icmple -> 2914
    //   2909: ldc_w 65535
    //   2912: istore #6
    //   2914: iload #6
    //   2916: aload #15
    //   2918: invokestatic a : (I[B)[B
    //   2921: astore #16
    //   2923: aload #16
    //   2925: iconst_0
    //   2926: aload #12
    //   2928: iload #7
    //   2930: aload #16
    //   2932: arraylength
    //   2933: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2936: iload #7
    //   2938: aload #16
    //   2940: arraylength
    //   2941: iadd
    //   2942: istore_3
    //   2943: aload #14
    //   2945: getfield frequency : I
    //   2948: aload #15
    //   2950: invokestatic a : (I[B)[B
    //   2953: astore #14
    //   2955: aload #14
    //   2957: iconst_0
    //   2958: aload #12
    //   2960: iload_3
    //   2961: aload #14
    //   2963: arraylength
    //   2964: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2967: iload_3
    //   2968: aload #14
    //   2970: arraylength
    //   2971: iadd
    //   2972: istore_3
    //   2973: iload #5
    //   2975: iconst_1
    //   2976: iadd
    //   2977: istore #5
    //   2979: goto -> 2692
    //   2982: aload_0
    //   2983: getfield G : Ljava/lang/String;
    //   2986: invokestatic parseInt : (Ljava/lang/String;)I
    //   2989: aload #15
    //   2991: invokestatic a : (I[B)[B
    //   2994: astore #13
    //   2996: aload #13
    //   2998: iconst_0
    //   2999: aload #12
    //   3001: iload_3
    //   3002: aload #13
    //   3004: arraylength
    //   3005: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3008: iload_3
    //   3009: aload #13
    //   3011: arraylength
    //   3012: iadd
    //   3013: istore_3
    //   3014: aload #12
    //   3016: iload_3
    //   3017: iconst_0
    //   3018: bastore
    //   3019: iload_3
    //   3020: iconst_1
    //   3021: iadd
    //   3022: istore #4
    //   3024: iload #4
    //   3026: istore_3
    //   3027: aload_0
    //   3028: getfield H : Ljava/lang/String;
    //   3031: ldc 'GBK'
    //   3033: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   3036: astore #14
    //   3038: iload #4
    //   3040: istore_3
    //   3041: aload #14
    //   3043: astore #13
    //   3045: aload #14
    //   3047: arraylength
    //   3048: bipush #127
    //   3050: if_icmple -> 3534
    //   3053: aconst_null
    //   3054: astore #13
    //   3056: goto -> 3534
    //   3059: iload #4
    //   3061: istore_3
    //   3062: aload #12
    //   3064: iload #4
    //   3066: aload #13
    //   3068: arraylength
    //   3069: i2b
    //   3070: bastore
    //   3071: iload #4
    //   3073: iconst_1
    //   3074: iadd
    //   3075: istore #4
    //   3077: iload #4
    //   3079: istore_3
    //   3080: aload #13
    //   3082: iconst_0
    //   3083: aload #12
    //   3085: iload #4
    //   3087: aload #13
    //   3089: arraylength
    //   3090: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3093: iload #4
    //   3095: istore_3
    //   3096: aload #13
    //   3098: arraylength
    //   3099: istore #5
    //   3101: iload #4
    //   3103: iload #5
    //   3105: iadd
    //   3106: istore_3
    //   3107: goto -> 3119
    //   3110: aload #12
    //   3112: iload_3
    //   3113: iconst_0
    //   3114: bastore
    //   3115: iload_3
    //   3116: iconst_1
    //   3117: iadd
    //   3118: istore_3
    //   3119: iconst_2
    //   3120: newarray byte
    //   3122: astore #13
    //   3124: aload #13
    //   3126: dup
    //   3127: iconst_0
    //   3128: ldc_w 0
    //   3131: bastore
    //   3132: dup
    //   3133: iconst_1
    //   3134: ldc_w 0
    //   3137: bastore
    //   3138: pop
    //   3139: aload_0
    //   3140: getfield K : Ljava/lang/String;
    //   3143: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   3146: istore #11
    //   3148: iload #11
    //   3150: ifne -> 3167
    //   3153: aload_0
    //   3154: getfield K : Ljava/lang/String;
    //   3157: invokevirtual length : ()I
    //   3160: aload #15
    //   3162: invokestatic a : (I[B)[B
    //   3165: astore #13
    //   3167: aload #13
    //   3169: iconst_0
    //   3170: aload #12
    //   3172: iload_3
    //   3173: iconst_2
    //   3174: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3177: iload_3
    //   3178: iconst_2
    //   3179: iadd
    //   3180: istore #4
    //   3182: iload #4
    //   3184: istore_3
    //   3185: iload #11
    //   3187: ifne -> 3223
    //   3190: aload_0
    //   3191: getfield K : Ljava/lang/String;
    //   3194: ldc 'GBK'
    //   3196: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   3199: astore #13
    //   3201: aload #13
    //   3203: iconst_0
    //   3204: aload #12
    //   3206: iload #4
    //   3208: aload #13
    //   3210: arraylength
    //   3211: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3214: aload #13
    //   3216: arraylength
    //   3217: istore_3
    //   3218: iload #4
    //   3220: iload_3
    //   3221: iadd
    //   3222: istore_3
    //   3223: goto -> 3230
    //   3226: iload_3
    //   3227: iconst_2
    //   3228: iadd
    //   3229: istore_3
    //   3230: iconst_0
    //   3231: aload #15
    //   3233: invokestatic a : (I[B)[B
    //   3236: iconst_0
    //   3237: aload #12
    //   3239: iload_3
    //   3240: iconst_2
    //   3241: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3244: iload_3
    //   3245: iconst_2
    //   3246: iadd
    //   3247: istore_3
    //   3248: iconst_2
    //   3249: newarray byte
    //   3251: dup
    //   3252: iconst_0
    //   3253: ldc_w 0
    //   3256: bastore
    //   3257: dup
    //   3258: iconst_1
    //   3259: ldc_w 0
    //   3262: bastore
    //   3263: iconst_0
    //   3264: aload #12
    //   3266: iload_3
    //   3267: iconst_2
    //   3268: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3271: iload_3
    //   3272: iconst_2
    //   3273: iadd
    //   3274: istore_3
    //   3275: aload_0
    //   3276: getfield I : [B
    //   3279: astore #13
    //   3281: aload #13
    //   3283: ifnull -> 3294
    //   3286: aload #13
    //   3288: arraylength
    //   3289: istore #4
    //   3291: goto -> 3297
    //   3294: iconst_0
    //   3295: istore #4
    //   3297: iload #4
    //   3299: aconst_null
    //   3300: invokestatic a : (I[B)[B
    //   3303: astore #13
    //   3305: aload #13
    //   3307: iconst_0
    //   3308: aload #12
    //   3310: iload_3
    //   3311: aload #13
    //   3313: arraylength
    //   3314: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3317: iload_3
    //   3318: aload #13
    //   3320: arraylength
    //   3321: iadd
    //   3322: istore #5
    //   3324: iload #5
    //   3326: istore_3
    //   3327: iload #4
    //   3329: ifle -> 3360
    //   3332: aload_0
    //   3333: getfield I : [B
    //   3336: astore #13
    //   3338: aload #13
    //   3340: iconst_0
    //   3341: aload #12
    //   3343: iload #5
    //   3345: aload #13
    //   3347: arraylength
    //   3348: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3351: iload #5
    //   3353: aload_0
    //   3354: getfield I : [B
    //   3357: arraylength
    //   3358: iadd
    //   3359: istore_3
    //   3360: iload_3
    //   3361: istore #4
    //   3363: ldc_w '5.1'
    //   3366: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   3369: invokevirtual doubleValue : ()D
    //   3372: ldc2_w 5.0
    //   3375: dcmpl
    //   3376: iflt -> 3398
    //   3379: aload #12
    //   3381: iload_3
    //   3382: iconst_0
    //   3383: bastore
    //   3384: aload_0
    //   3385: getfield N : Ljava/lang/String;
    //   3388: aload #12
    //   3390: iload_3
    //   3391: iconst_1
    //   3392: iadd
    //   3393: invokestatic a : (Ljava/lang/String;[BI)I
    //   3396: istore #4
    //   3398: iload #4
    //   3400: newarray byte
    //   3402: astore #13
    //   3404: aload #12
    //   3406: iconst_0
    //   3407: aload #13
    //   3409: iconst_0
    //   3410: iload #4
    //   3412: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3415: new java/util/zip/CRC32
    //   3418: dup
    //   3419: invokespecial <init> : ()V
    //   3422: astore #12
    //   3424: aload #12
    //   3426: aload #13
    //   3428: invokevirtual update : ([B)V
    //   3431: aload #12
    //   3433: invokevirtual getValue : ()J
    //   3436: invokestatic a : (J)[B
    //   3439: astore #12
    //   3441: iload #4
    //   3443: bipush #8
    //   3445: iadd
    //   3446: newarray byte
    //   3448: astore #14
    //   3450: aload #13
    //   3452: iconst_0
    //   3453: aload #14
    //   3455: iconst_0
    //   3456: iload #4
    //   3458: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3461: aload #12
    //   3463: iconst_0
    //   3464: aload #14
    //   3466: iload #4
    //   3468: bipush #8
    //   3470: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3473: aload #14
    //   3475: areturn
    //   3476: astore #14
    //   3478: goto -> 1570
    //   3481: astore #16
    //   3483: goto -> 2807
    //   3486: astore #13
    //   3488: goto -> 3110
    //   3491: astore #13
    //   3493: goto -> 3226
    //   3496: astore #13
    //   3498: iload #4
    //   3500: istore_3
    //   3501: goto -> 3223
    //   3504: astore #13
    //   3506: goto -> 3244
    //   3509: astore #13
    //   3511: goto -> 3271
    //   3514: iconst_0
    //   3515: istore #5
    //   3517: goto -> 2517
    //   3520: iload #6
    //   3522: istore #5
    //   3524: iload #6
    //   3526: bipush #-128
    //   3528: if_icmpge -> 2517
    //   3531: goto -> 3514
    //   3534: aload #13
    //   3536: ifnonnull -> 3059
    //   3539: aload #12
    //   3541: iload #4
    //   3543: iconst_0
    //   3544: bastore
    //   3545: iload #4
    //   3547: istore_3
    //   3548: goto -> 3115
    // Exception table:
    //   from	to	target	type
    //   676	686	762	finally
    //   701	711	762	finally
    //   714	723	762	finally
    //   732	745	762	finally
    //   748	753	762	finally
    //   1515	1524	3476	java/lang/Exception
    //   1527	1537	3476	java/lang/Exception
    //   1551	1562	3476	java/lang/Exception
    //   2343	2354	2535	finally
    //   2357	2367	2535	finally
    //   2370	2382	2535	finally
    //   2385	2390	2535	finally
    //   2399	2410	2471	finally
    //   2413	2418	2471	finally
    //   2450	2462	2471	finally
    //   2476	2486	2535	finally
    //   2498	2507	2535	finally
    //   2520	2532	2535	finally
    //   2744	2756	3481	java/lang/Exception
    //   2759	2768	3481	java/lang/Exception
    //   2777	2790	3481	java/lang/Exception
    //   2793	2798	3481	java/lang/Exception
    //   3027	3038	3486	finally
    //   3045	3053	3486	finally
    //   3062	3071	3486	finally
    //   3080	3093	3486	finally
    //   3096	3101	3486	finally
    //   3139	3148	3491	finally
    //   3153	3167	3491	finally
    //   3167	3177	3491	finally
    //   3190	3218	3496	finally
    //   3230	3244	3504	finally
    //   3248	3271	3509	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */