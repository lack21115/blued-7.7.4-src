package com.amap.api.mapcore2d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.ArrayList;

public final class gs {
  protected static String J;
  
  protected static String L;
  
  protected String A = null;
  
  protected String B = null;
  
  protected ArrayList<gm> C = new ArrayList<gm>();
  
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
      gu.a((Throwable)paramString, "Req", "copyContentWithByteLen");
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
    //   27: if_icmpeq -> 154
    //   30: bipush #6
    //   32: anewarray java/lang/String
    //   35: astore #4
    //   37: iconst_0
    //   38: istore_2
    //   39: aload #4
    //   41: astore_3
    //   42: iload_2
    //   43: aload #4
    //   45: arraylength
    //   46: if_icmpge -> 154
    //   49: aload #4
    //   51: iload_2
    //   52: ldc '0'
    //   54: aastore
    //   55: iload_2
    //   56: iconst_1
    //   57: iadd
    //   58: istore_2
    //   59: goto -> 39
    //   62: aload #5
    //   64: astore #4
    //   66: iload_2
    //   67: aload_3
    //   68: arraylength
    //   69: if_icmpge -> 151
    //   72: aload_3
    //   73: iload_2
    //   74: aaload
    //   75: invokevirtual length : ()I
    //   78: iconst_2
    //   79: if_icmple -> 93
    //   82: aload_3
    //   83: iload_2
    //   84: aload_3
    //   85: iload_2
    //   86: aaload
    //   87: iconst_0
    //   88: iconst_2
    //   89: invokevirtual substring : (II)Ljava/lang/String;
    //   92: aastore
    //   93: aload #5
    //   95: iload_2
    //   96: aload_3
    //   97: iload_2
    //   98: aaload
    //   99: bipush #16
    //   101: invokestatic parseInt : (Ljava/lang/String;I)I
    //   104: i2b
    //   105: bastore
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: goto -> 62
    //   113: astore_3
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: ldc 'getMacBa '
    //   120: invokespecial <init> : (Ljava/lang/String;)V
    //   123: astore #4
    //   125: aload #4
    //   127: aload_1
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_3
    //   133: ldc 'Req'
    //   135: aload #4
    //   137: invokevirtual toString : ()Ljava/lang/String;
    //   140: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: ldc '00:00:00:00:00:00'
    //   146: invokespecial a : (Ljava/lang/String;)[B
    //   149: astore #4
    //   151: aload #4
    //   153: areturn
    //   154: iconst_0
    //   155: istore_2
    //   156: goto -> 62
    // Exception table:
    //   from	to	target	type
    //   22	30	113	finally
    //   30	37	113	finally
    //   42	49	113	finally
    //   66	93	113	finally
    //   93	106	113	finally
  }
  
  private String b(String paramString) {
    String str = this.A;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(">");
    if (!str.contains(stringBuilder.toString()))
      return "0"; 
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
  
  private void b() {
    if (TextUtils.isEmpty(this.a))
      this.a = ""; 
    if (TextUtils.isEmpty(this.c))
      this.c = ""; 
    if (TextUtils.isEmpty(this.d))
      this.d = ""; 
    if (TextUtils.isEmpty(this.e))
      this.e = ""; 
    if (TextUtils.isEmpty(this.f))
      this.f = ""; 
    if (TextUtils.isEmpty(this.g))
      this.g = ""; 
    if (TextUtils.isEmpty(this.h))
      this.h = ""; 
    if (TextUtils.isEmpty(this.i))
      this.i = ""; 
    if (TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j)))
      this.j = "0"; 
    if (TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k)))
      this.k = "0"; 
    if (TextUtils.isEmpty(this.l))
      this.l = ""; 
    if (TextUtils.isEmpty(this.m))
      this.m = ""; 
    if (TextUtils.isEmpty(this.n))
      this.n = ""; 
    if (TextUtils.isEmpty(this.o))
      this.o = ""; 
    if (TextUtils.isEmpty(this.p))
      this.p = ""; 
    if (TextUtils.isEmpty(this.q))
      this.q = ""; 
    if (TextUtils.isEmpty(this.r))
      this.r = ""; 
    if (TextUtils.isEmpty(this.s))
      this.s = ""; 
    if (TextUtils.isEmpty(this.t))
      this.t = ""; 
    if (TextUtils.isEmpty(this.u))
      this.u = ""; 
    if (TextUtils.isEmpty(this.v))
      this.v = ""; 
    if (TextUtils.isEmpty(this.w))
      this.w = ""; 
    if (TextUtils.isEmpty(this.x))
      this.x = ""; 
    if (TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y)))
      this.y = "0"; 
    if (!gn.a(this.z))
      this.z = 0; 
    if (TextUtils.isEmpty(this.A))
      this.A = ""; 
    if (TextUtils.isEmpty(this.B))
      this.B = ""; 
    if (TextUtils.isEmpty(this.E))
      this.E = ""; 
    if (TextUtils.isEmpty(this.G))
      this.G = ""; 
    if (TextUtils.isEmpty(this.H))
      this.H = ""; 
    if (TextUtils.isEmpty(J))
      J = ""; 
    if (this.I == null)
      this.I = new byte[0]; 
    if (TextUtils.isEmpty(this.N))
      this.N = ""; 
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, gn paramgn, go paramgo, ConnectivityManager paramConnectivityManager, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   4: astore #17
    //   6: invokestatic f : ()I
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
    //   55: invokevirtual c : ()I
    //   58: istore #11
    //   60: aload #4
    //   62: invokevirtual d : ()I
    //   65: istore #8
    //   67: aload #4
    //   69: invokevirtual e : ()Landroid/telephony/TelephonyManager;
    //   72: astore #15
    //   74: aload #4
    //   76: invokevirtual a : ()Ljava/util/ArrayList;
    //   79: astore #21
    //   81: aload #4
    //   83: invokevirtual b : ()Ljava/util/ArrayList;
    //   86: astore #20
    //   88: aload #5
    //   90: invokevirtual a : ()Ljava/util/ArrayList;
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
    //   114: ifnull -> 237
    //   117: getstatic com/amap/api/mapcore2d/gu.d : Ljava/lang/String;
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifeq -> 152
    //   126: aload_1
    //   127: invokestatic v : (Landroid/content/Context;)Ljava/lang/String;
    //   130: putstatic com/amap/api/mapcore2d/gu.d : Ljava/lang/String;
    //   133: goto -> 152
    //   136: astore #7
    //   138: aload #7
    //   140: ldc_w 'Aps'
    //   143: ldc_w 'getApsReq part4'
    //   146: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -> 152
    //   152: getstatic com/amap/api/mapcore2d/gu.d : Ljava/lang/String;
    //   155: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   158: ifeq -> 175
    //   161: getstatic android/os/Build$VERSION.SDK_INT : I
    //   164: bipush #29
    //   166: if_icmpge -> 175
    //   169: ldc_w '888888888888888'
    //   172: putstatic com/amap/api/mapcore2d/gu.d : Ljava/lang/String;
    //   175: getstatic com/amap/api/mapcore2d/gu.e : Ljava/lang/String;
    //   178: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   181: ifeq -> 211
    //   184: aload #15
    //   186: invokevirtual getSubscriberId : ()Ljava/lang/String;
    //   189: putstatic com/amap/api/mapcore2d/gu.e : Ljava/lang/String;
    //   192: goto -> 211
    //   195: astore #7
    //   197: aload #7
    //   199: ldc_w 'Aps'
    //   202: ldc_w 'getApsReq part2'
    //   205: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   208: goto -> 211
    //   211: getstatic com/amap/api/mapcore2d/gu.e : Ljava/lang/String;
    //   214: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   217: ifeq -> 237
    //   220: getstatic android/os/Build$VERSION.SDK_INT : I
    //   223: bipush #29
    //   225: if_icmpge -> 237
    //   228: ldc_w '888888888888888'
    //   231: putstatic com/amap/api/mapcore2d/gu.e : Ljava/lang/String;
    //   234: goto -> 237
    //   237: aload #6
    //   239: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   242: astore #7
    //   244: goto -> 263
    //   247: astore #7
    //   249: aload #7
    //   251: ldc_w 'Aps'
    //   254: ldc_w 'getApsReq part'
    //   257: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   260: aconst_null
    //   261: astore #7
    //   263: aload #5
    //   265: aload #6
    //   267: invokevirtual a : (Landroid/net/ConnectivityManager;)Z
    //   270: istore_3
    //   271: aload #7
    //   273: invokestatic a : (Landroid/net/NetworkInfo;)I
    //   276: istore #9
    //   278: ldc ''
    //   280: astore #6
    //   282: iload #9
    //   284: iconst_m1
    //   285: if_icmpeq -> 313
    //   288: aload #15
    //   290: invokestatic b : (Landroid/telephony/TelephonyManager;)Ljava/lang/String;
    //   293: astore #15
    //   295: iload_3
    //   296: ifeq -> 306
    //   299: ldc '2'
    //   301: astore #7
    //   303: goto -> 321
    //   306: ldc '1'
    //   308: astore #7
    //   310: goto -> 321
    //   313: ldc ''
    //   315: astore #15
    //   317: aload #15
    //   319: astore #7
    //   321: aload #21
    //   323: invokevirtual isEmpty : ()Z
    //   326: ifne -> 907
    //   329: new java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial <init> : ()V
    //   336: astore #22
    //   338: iload #8
    //   340: iconst_1
    //   341: if_icmpeq -> 609
    //   344: iload #8
    //   346: iconst_2
    //   347: if_icmpeq -> 357
    //   350: ldc ''
    //   352: astore #6
    //   354: goto -> 892
    //   357: aload #21
    //   359: iconst_0
    //   360: invokevirtual get : (I)Ljava/lang/Object;
    //   363: checkcast com/amap/api/mapcore2d/gm
    //   366: astore #6
    //   368: aload #22
    //   370: iconst_0
    //   371: aload #22
    //   373: invokevirtual length : ()I
    //   376: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload #22
    //   382: ldc_w '<mcc>'
    //   385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload #22
    //   391: aload #6
    //   393: getfield a : I
    //   396: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload #22
    //   402: ldc_w '</mcc>'
    //   405: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload #22
    //   411: ldc_w '<sid>'
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload #22
    //   420: aload #6
    //   422: getfield g : I
    //   425: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload #22
    //   431: ldc_w '</sid>'
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload #22
    //   440: ldc_w '<nid>'
    //   443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload #22
    //   449: aload #6
    //   451: getfield h : I
    //   454: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload #22
    //   460: ldc_w '</nid>'
    //   463: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload #22
    //   469: ldc_w '<bid>'
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload #22
    //   478: aload #6
    //   480: getfield i : I
    //   483: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload #22
    //   489: ldc_w '</bid>'
    //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload #6
    //   498: getfield f : I
    //   501: ifle -> 570
    //   504: aload #6
    //   506: getfield e : I
    //   509: ifle -> 570
    //   512: aload #22
    //   514: ldc_w '<lon>'
    //   517: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload #22
    //   523: aload #6
    //   525: getfield f : I
    //   528: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload #22
    //   534: ldc_w '</lon>'
    //   537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload #22
    //   543: ldc_w '<lat>'
    //   546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload #22
    //   552: aload #6
    //   554: getfield e : I
    //   557: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload #22
    //   563: ldc_w '</lat>'
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #22
    //   572: ldc_w '<signal>'
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload #22
    //   581: aload #6
    //   583: getfield j : I
    //   586: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload #22
    //   592: ldc_w '</signal>'
    //   595: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload #22
    //   601: invokevirtual toString : ()Ljava/lang/String;
    //   604: astore #6
    //   606: goto -> 892
    //   609: aload #21
    //   611: iconst_0
    //   612: invokevirtual get : (I)Ljava/lang/Object;
    //   615: checkcast com/amap/api/mapcore2d/gm
    //   618: astore #6
    //   620: aload #22
    //   622: iconst_0
    //   623: aload #22
    //   625: invokevirtual length : ()I
    //   628: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload #22
    //   634: ldc_w '<mcc>'
    //   637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload #22
    //   643: aload #6
    //   645: getfield a : I
    //   648: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload #22
    //   654: ldc_w '</mcc>'
    //   657: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload #22
    //   663: ldc_w '<mnc>'
    //   666: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload #22
    //   672: aload #6
    //   674: getfield b : I
    //   677: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload #22
    //   683: ldc_w '</mnc>'
    //   686: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload #22
    //   692: ldc_w '<lac>'
    //   695: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload #22
    //   701: aload #6
    //   703: getfield c : I
    //   706: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload #22
    //   712: ldc_w '</lac>'
    //   715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload #22
    //   721: ldc_w '<cellid>'
    //   724: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload #22
    //   730: aload #6
    //   732: getfield d : I
    //   735: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload #22
    //   741: ldc_w '</cellid>'
    //   744: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload #22
    //   750: ldc_w '<signal>'
    //   753: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload #22
    //   759: aload #6
    //   761: getfield j : I
    //   764: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload #22
    //   770: ldc_w '</signal>'
    //   773: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: aload #22
    //   779: invokevirtual toString : ()Ljava/lang/String;
    //   782: astore #16
    //   784: iconst_1
    //   785: istore #8
    //   787: aload #16
    //   789: astore #6
    //   791: iload #8
    //   793: aload #21
    //   795: invokevirtual size : ()I
    //   798: if_icmpge -> 892
    //   801: aload #21
    //   803: iload #8
    //   805: invokevirtual get : (I)Ljava/lang/Object;
    //   808: checkcast com/amap/api/mapcore2d/gm
    //   811: astore #6
    //   813: aload #18
    //   815: aload #6
    //   817: getfield c : I
    //   820: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload #18
    //   826: ldc ','
    //   828: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload #18
    //   834: aload #6
    //   836: getfield d : I
    //   839: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload #18
    //   845: ldc ','
    //   847: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload #18
    //   853: aload #6
    //   855: getfield j : I
    //   858: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: iload #8
    //   864: aload #21
    //   866: invokevirtual size : ()I
    //   869: iconst_1
    //   870: isub
    //   871: if_icmpge -> 883
    //   874: aload #18
    //   876: ldc_w '*'
    //   879: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: iload #8
    //   885: iconst_1
    //   886: iadd
    //   887: istore #8
    //   889: goto -> 787
    //   892: aload #22
    //   894: iconst_0
    //   895: aload #22
    //   897: invokevirtual length : ()I
    //   900: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: goto -> 907
    //   907: iload #11
    //   909: iconst_4
    //   910: iand
    //   911: iconst_4
    //   912: if_icmpne -> 943
    //   915: aload #20
    //   917: invokevirtual isEmpty : ()Z
    //   920: ifne -> 943
    //   923: aload_0
    //   924: getfield C : Ljava/util/ArrayList;
    //   927: invokevirtual clear : ()V
    //   930: aload_0
    //   931: getfield C : Ljava/util/ArrayList;
    //   934: aload #20
    //   936: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   939: pop
    //   940: goto -> 950
    //   943: aload_0
    //   944: getfield C : Ljava/util/ArrayList;
    //   947: invokevirtual clear : ()V
    //   950: new java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial <init> : ()V
    //   957: astore #16
    //   959: aload #5
    //   961: invokevirtual e : ()Z
    //   964: ifeq -> 1150
    //   967: iload_3
    //   968: ifeq -> 1116
    //   971: aload #5
    //   973: invokevirtual f : ()Landroid/net/wifi/WifiInfo;
    //   976: astore #20
    //   978: aload #20
    //   980: invokestatic a : (Landroid/net/wifi/WifiInfo;)Z
    //   983: ifeq -> 1116
    //   986: aload #16
    //   988: aload #20
    //   990: invokevirtual getBSSID : ()Ljava/lang/String;
    //   993: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload #16
    //   999: ldc ','
    //   1001: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload #20
    //   1007: invokevirtual getRssi : ()I
    //   1010: istore #9
    //   1012: iload #9
    //   1014: bipush #-128
    //   1016: if_icmpge -> 1025
    //   1019: iconst_0
    //   1020: istore #8
    //   1022: goto -> 1039
    //   1025: iload #9
    //   1027: istore #8
    //   1029: iload #9
    //   1031: bipush #127
    //   1033: if_icmple -> 1039
    //   1036: goto -> 1019
    //   1039: aload #16
    //   1041: iload #8
    //   1043: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload #16
    //   1049: ldc ','
    //   1051: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: aload #20
    //   1057: invokevirtual getSSID : ()Ljava/lang/String;
    //   1060: astore #5
    //   1062: bipush #32
    //   1064: istore #8
    //   1066: aload #20
    //   1068: invokevirtual getSSID : ()Ljava/lang/String;
    //   1071: ldc_w 'UTF-8'
    //   1074: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   1077: arraylength
    //   1078: istore #9
    //   1080: iload #9
    //   1082: istore #8
    //   1084: goto -> 1087
    //   1087: iload #8
    //   1089: bipush #32
    //   1091: if_icmplt -> 1099
    //   1094: ldc_w 'unkwn'
    //   1097: astore #5
    //   1099: aload #16
    //   1101: aload #5
    //   1103: ldc_w '*'
    //   1106: ldc_w '.'
    //   1109: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: pop
    //   1116: aload #19
    //   1118: ifnull -> 1171
    //   1121: aload_0
    //   1122: getfield F : Ljava/util/ArrayList;
    //   1125: astore #5
    //   1127: aload #5
    //   1129: ifnull -> 1171
    //   1132: aload #5
    //   1134: invokevirtual clear : ()V
    //   1137: aload_0
    //   1138: getfield F : Ljava/util/ArrayList;
    //   1141: aload #19
    //   1143: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   1146: pop
    //   1147: goto -> 1171
    //   1150: aload #5
    //   1152: invokevirtual b : ()V
    //   1155: aload_0
    //   1156: getfield F : Ljava/util/ArrayList;
    //   1159: astore #5
    //   1161: aload #5
    //   1163: ifnull -> 1171
    //   1166: aload #5
    //   1168: invokevirtual clear : ()V
    //   1171: aload_0
    //   1172: iconst_0
    //   1173: putfield b : S
    //   1176: iload_2
    //   1177: ifne -> 1191
    //   1180: aload_0
    //   1181: aload_0
    //   1182: getfield b : S
    //   1185: iconst_2
    //   1186: ior
    //   1187: i2s
    //   1188: putfield b : S
    //   1191: aload_0
    //   1192: aload #12
    //   1194: putfield c : Ljava/lang/String;
    //   1197: aload_0
    //   1198: aload #13
    //   1200: putfield d : Ljava/lang/String;
    //   1203: aload_0
    //   1204: invokestatic d : ()Ljava/lang/String;
    //   1207: putfield f : Ljava/lang/String;
    //   1210: new java/lang/StringBuilder
    //   1213: dup
    //   1214: ldc_w 'android'
    //   1217: invokespecial <init> : (Ljava/lang/String;)V
    //   1220: astore #5
    //   1222: aload #5
    //   1224: invokestatic e : ()Ljava/lang/String;
    //   1227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload_0
    //   1232: aload #5
    //   1234: invokevirtual toString : ()Ljava/lang/String;
    //   1237: putfield g : Ljava/lang/String;
    //   1240: aload_0
    //   1241: aload_1
    //   1242: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   1245: putfield h : Ljava/lang/String;
    //   1248: aload_0
    //   1249: aload #14
    //   1251: putfield i : Ljava/lang/String;
    //   1254: aload_0
    //   1255: ldc '0'
    //   1257: putfield j : Ljava/lang/String;
    //   1260: aload_0
    //   1261: ldc '0'
    //   1263: putfield k : Ljava/lang/String;
    //   1266: aload_0
    //   1267: ldc '0'
    //   1269: putfield l : Ljava/lang/String;
    //   1272: aload_0
    //   1273: ldc '0'
    //   1275: putfield m : Ljava/lang/String;
    //   1278: aload_0
    //   1279: ldc '0'
    //   1281: putfield n : Ljava/lang/String;
    //   1284: aload_0
    //   1285: aload #17
    //   1287: putfield o : Ljava/lang/String;
    //   1290: aload_0
    //   1291: getstatic com/amap/api/mapcore2d/gu.d : Ljava/lang/String;
    //   1294: putfield p : Ljava/lang/String;
    //   1297: aload_0
    //   1298: getstatic com/amap/api/mapcore2d/gu.e : Ljava/lang/String;
    //   1301: putfield q : Ljava/lang/String;
    //   1304: aload_0
    //   1305: iload #10
    //   1307: invokestatic valueOf : (I)Ljava/lang/String;
    //   1310: putfield s : Ljava/lang/String;
    //   1313: aload_0
    //   1314: aload_1
    //   1315: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   1318: putfield t : Ljava/lang/String;
    //   1321: aload_0
    //   1322: ldc_w '4.7.0'
    //   1325: putfield v : Ljava/lang/String;
    //   1328: aload_0
    //   1329: aconst_null
    //   1330: putfield w : Ljava/lang/String;
    //   1333: aload_0
    //   1334: ldc ''
    //   1336: putfield u : Ljava/lang/String;
    //   1339: aload_0
    //   1340: aload #15
    //   1342: putfield x : Ljava/lang/String;
    //   1345: aload_0
    //   1346: aload #7
    //   1348: putfield y : Ljava/lang/String;
    //   1351: aload_0
    //   1352: iload #11
    //   1354: putfield z : I
    //   1357: aload_0
    //   1358: aload #6
    //   1360: putfield A : Ljava/lang/String;
    //   1363: aload_0
    //   1364: aload #18
    //   1366: invokevirtual toString : ()Ljava/lang/String;
    //   1369: putfield B : Ljava/lang/String;
    //   1372: aload_0
    //   1373: aload #4
    //   1375: invokevirtual i : ()Ljava/lang/String;
    //   1378: putfield D : Ljava/lang/String;
    //   1381: aload_0
    //   1382: invokestatic i : ()Ljava/lang/String;
    //   1385: putfield G : Ljava/lang/String;
    //   1388: aload_0
    //   1389: aload #16
    //   1391: invokevirtual toString : ()Ljava/lang/String;
    //   1394: putfield E : Ljava/lang/String;
    //   1397: getstatic com/amap/api/mapcore2d/gs.J : Ljava/lang/String;
    //   1400: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1403: ifeq -> 1413
    //   1406: aload_1
    //   1407: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   1410: putstatic com/amap/api/mapcore2d/gs.J : Ljava/lang/String;
    //   1413: getstatic com/amap/api/mapcore2d/gs.L : Ljava/lang/String;
    //   1416: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1419: ifeq -> 1429
    //   1422: aload_1
    //   1423: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   1426: putstatic com/amap/api/mapcore2d/gs.L : Ljava/lang/String;
    //   1429: aload_0
    //   1430: getfield N : Ljava/lang/String;
    //   1433: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1436: ifeq -> 1447
    //   1439: aload_0
    //   1440: aload_1
    //   1441: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   1444: putfield N : Ljava/lang/String;
    //   1447: aload #18
    //   1449: iconst_0
    //   1450: aload #18
    //   1452: invokevirtual length : ()I
    //   1455: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1458: pop
    //   1459: aload #16
    //   1461: iconst_0
    //   1462: aload #16
    //   1464: invokevirtual length : ()I
    //   1467: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: return
    //   1472: astore #7
    //   1474: goto -> 211
    //   1477: astore #20
    //   1479: goto -> 1087
    //   1482: astore #4
    //   1484: goto -> 1413
    //   1487: astore #4
    //   1489: goto -> 1429
    //   1492: astore_1
    //   1493: goto -> 1447
    // Exception table:
    //   from	to	target	type
    //   126	133	136	finally
    //   184	192	1472	java/lang/SecurityException
    //   184	192	195	finally
    //   237	244	247	finally
    //   1066	1080	1477	java/lang/Exception
    //   1397	1413	1482	finally
    //   1413	1429	1487	finally
    //   1429	1447	1492	finally
  }
  
  public final byte[] a() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial b : ()V
    //   4: iconst_2
    //   5: newarray byte
    //   7: astore #15
    //   9: iconst_4
    //   10: newarray byte
    //   12: astore #13
    //   14: aload_0
    //   15: getfield I : [B
    //   18: astore #12
    //   20: sipush #4096
    //   23: istore_3
    //   24: aload #12
    //   26: ifnull -> 39
    //   29: sipush #4096
    //   32: aload #12
    //   34: arraylength
    //   35: iconst_1
    //   36: iadd
    //   37: iadd
    //   38: istore_3
    //   39: aload_0
    //   40: getfield O : [B
    //   43: astore #12
    //   45: aload #12
    //   47: ifnull -> 58
    //   50: iload_3
    //   51: aload_0
    //   52: getfield P : I
    //   55: if_icmple -> 74
    //   58: iload_3
    //   59: newarray byte
    //   61: astore #12
    //   63: aload_0
    //   64: aload #12
    //   66: putfield O : [B
    //   69: aload_0
    //   70: iload_3
    //   71: putfield P : I
    //   74: aload #12
    //   76: iconst_0
    //   77: aload_0
    //   78: getfield a : Ljava/lang/String;
    //   81: invokestatic e : (Ljava/lang/String;)B
    //   84: bastore
    //   85: aload_0
    //   86: getfield b : S
    //   89: aconst_null
    //   90: invokestatic a : (I[B)[B
    //   93: astore #14
    //   95: aload #14
    //   97: iconst_0
    //   98: aload #12
    //   100: iconst_1
    //   101: aload #14
    //   103: arraylength
    //   104: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   107: aload #14
    //   109: arraylength
    //   110: istore_3
    //   111: aload_0
    //   112: getfield c : Ljava/lang/String;
    //   115: aload #12
    //   117: iload_3
    //   118: iconst_1
    //   119: iadd
    //   120: invokestatic a : (Ljava/lang/String;[BI)I
    //   123: istore_3
    //   124: aload_0
    //   125: getfield d : Ljava/lang/String;
    //   128: aload #12
    //   130: iload_3
    //   131: invokestatic a : (Ljava/lang/String;[BI)I
    //   134: istore_3
    //   135: aload_0
    //   136: getfield o : Ljava/lang/String;
    //   139: aload #12
    //   141: iload_3
    //   142: invokestatic a : (Ljava/lang/String;[BI)I
    //   145: istore_3
    //   146: aload_0
    //   147: getfield e : Ljava/lang/String;
    //   150: aload #12
    //   152: iload_3
    //   153: invokestatic a : (Ljava/lang/String;[BI)I
    //   156: istore_3
    //   157: aload_0
    //   158: getfield f : Ljava/lang/String;
    //   161: aload #12
    //   163: iload_3
    //   164: invokestatic a : (Ljava/lang/String;[BI)I
    //   167: istore_3
    //   168: aload_0
    //   169: getfield g : Ljava/lang/String;
    //   172: aload #12
    //   174: iload_3
    //   175: invokestatic a : (Ljava/lang/String;[BI)I
    //   178: istore_3
    //   179: aload_0
    //   180: getfield u : Ljava/lang/String;
    //   183: aload #12
    //   185: iload_3
    //   186: invokestatic a : (Ljava/lang/String;[BI)I
    //   189: istore_3
    //   190: aload_0
    //   191: getfield h : Ljava/lang/String;
    //   194: aload #12
    //   196: iload_3
    //   197: invokestatic a : (Ljava/lang/String;[BI)I
    //   200: istore_3
    //   201: aload_0
    //   202: getfield p : Ljava/lang/String;
    //   205: aload #12
    //   207: iload_3
    //   208: invokestatic a : (Ljava/lang/String;[BI)I
    //   211: istore_3
    //   212: aload_0
    //   213: getfield q : Ljava/lang/String;
    //   216: aload #12
    //   218: iload_3
    //   219: invokestatic a : (Ljava/lang/String;[BI)I
    //   222: istore #4
    //   224: iload #4
    //   226: istore_3
    //   227: aload_0
    //   228: getfield t : Ljava/lang/String;
    //   231: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   234: ifeq -> 249
    //   237: aload #12
    //   239: iload #4
    //   241: iconst_0
    //   242: bastore
    //   243: iload #4
    //   245: istore_3
    //   246: goto -> 330
    //   249: iload #4
    //   251: istore_3
    //   252: aload_0
    //   253: aload_0
    //   254: getfield t : Ljava/lang/String;
    //   257: invokespecial a : (Ljava/lang/String;)[B
    //   260: astore #14
    //   262: iload #4
    //   264: istore_3
    //   265: aload #12
    //   267: iload #4
    //   269: aload #14
    //   271: arraylength
    //   272: i2b
    //   273: bastore
    //   274: iload #4
    //   276: iconst_1
    //   277: iadd
    //   278: istore #4
    //   280: iload #4
    //   282: istore_3
    //   283: aload #14
    //   285: iconst_0
    //   286: aload #12
    //   288: iload #4
    //   290: aload #14
    //   292: arraylength
    //   293: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   296: iload #4
    //   298: istore_3
    //   299: aload #14
    //   301: arraylength
    //   302: istore #5
    //   304: iload #4
    //   306: iload #5
    //   308: iadd
    //   309: istore_3
    //   310: goto -> 334
    //   313: astore #14
    //   315: aload #14
    //   317: ldc 'Req'
    //   319: ldc_w 'buildV4Dot219'
    //   322: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload #12
    //   327: iload_3
    //   328: iconst_0
    //   329: bastore
    //   330: iload_3
    //   331: iconst_1
    //   332: iadd
    //   333: istore_3
    //   334: aload_0
    //   335: getfield v : Ljava/lang/String;
    //   338: aload #12
    //   340: iload_3
    //   341: invokestatic a : (Ljava/lang/String;[BI)I
    //   344: istore_3
    //   345: aload_0
    //   346: getfield w : Ljava/lang/String;
    //   349: aload #12
    //   351: iload_3
    //   352: invokestatic a : (Ljava/lang/String;[BI)I
    //   355: istore_3
    //   356: getstatic com/amap/api/mapcore2d/gs.J : Ljava/lang/String;
    //   359: aload #12
    //   361: iload_3
    //   362: invokestatic a : (Ljava/lang/String;[BI)I
    //   365: istore_3
    //   366: getstatic com/amap/api/mapcore2d/gs.L : Ljava/lang/String;
    //   369: aload #12
    //   371: iload_3
    //   372: invokestatic a : (Ljava/lang/String;[BI)I
    //   375: istore_3
    //   376: aload_0
    //   377: getfield x : Ljava/lang/String;
    //   380: aload #12
    //   382: iload_3
    //   383: invokestatic a : (Ljava/lang/String;[BI)I
    //   386: istore_3
    //   387: aload #12
    //   389: iload_3
    //   390: aload_0
    //   391: getfield y : Ljava/lang/String;
    //   394: invokestatic parseByte : (Ljava/lang/String;)B
    //   397: bastore
    //   398: iload_3
    //   399: iconst_1
    //   400: iadd
    //   401: istore_3
    //   402: aload #12
    //   404: iload_3
    //   405: aload_0
    //   406: getfield j : Ljava/lang/String;
    //   409: invokestatic parseByte : (Ljava/lang/String;)B
    //   412: bastore
    //   413: iload_3
    //   414: iconst_1
    //   415: iadd
    //   416: istore_3
    //   417: aload_0
    //   418: getfield z : I
    //   421: istore #4
    //   423: iload #4
    //   425: iconst_3
    //   426: iand
    //   427: istore #6
    //   429: aload #12
    //   431: iload_3
    //   432: iload #4
    //   434: i2b
    //   435: bastore
    //   436: iload_3
    //   437: iconst_1
    //   438: iadd
    //   439: istore #4
    //   441: iload #6
    //   443: iconst_1
    //   444: if_icmpeq -> 456
    //   447: iload #4
    //   449: istore_3
    //   450: iload #6
    //   452: iconst_2
    //   453: if_icmpne -> 1034
    //   456: aload_0
    //   457: ldc_w 'mcc'
    //   460: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   463: invokestatic b : (Ljava/lang/String;)[B
    //   466: astore #14
    //   468: aload #14
    //   470: iconst_0
    //   471: aload #12
    //   473: iload #4
    //   475: aload #14
    //   477: arraylength
    //   478: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   481: iload #4
    //   483: aload #14
    //   485: arraylength
    //   486: iadd
    //   487: istore #4
    //   489: iload #6
    //   491: iconst_1
    //   492: if_icmpne -> 592
    //   495: aload_0
    //   496: ldc_w 'mnc'
    //   499: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   502: invokestatic b : (Ljava/lang/String;)[B
    //   505: astore #14
    //   507: aload #14
    //   509: iconst_0
    //   510: aload #12
    //   512: iload #4
    //   514: aload #14
    //   516: arraylength
    //   517: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   520: iload #4
    //   522: aload #14
    //   524: arraylength
    //   525: iadd
    //   526: istore_3
    //   527: aload_0
    //   528: ldc 'lac'
    //   530: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   533: invokestatic b : (Ljava/lang/String;)[B
    //   536: astore #14
    //   538: aload #14
    //   540: iconst_0
    //   541: aload #12
    //   543: iload_3
    //   544: aload #14
    //   546: arraylength
    //   547: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   550: iload_3
    //   551: aload #14
    //   553: arraylength
    //   554: iadd
    //   555: istore_3
    //   556: aload_0
    //   557: ldc 'cellid'
    //   559: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   562: invokestatic c : (Ljava/lang/String;)[B
    //   565: astore #14
    //   567: aload #14
    //   569: iconst_0
    //   570: aload #12
    //   572: iload_3
    //   573: aload #14
    //   575: arraylength
    //   576: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   579: aload #14
    //   581: arraylength
    //   582: istore #4
    //   584: iload_3
    //   585: iload #4
    //   587: iadd
    //   588: istore_3
    //   589: goto -> 755
    //   592: iload #4
    //   594: istore_3
    //   595: iload #6
    //   597: iconst_2
    //   598: if_icmpne -> 755
    //   601: aload_0
    //   602: ldc_w 'sid'
    //   605: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   608: invokestatic b : (Ljava/lang/String;)[B
    //   611: astore #14
    //   613: aload #14
    //   615: iconst_0
    //   616: aload #12
    //   618: iload #4
    //   620: aload #14
    //   622: arraylength
    //   623: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   626: iload #4
    //   628: aload #14
    //   630: arraylength
    //   631: iadd
    //   632: istore_3
    //   633: aload_0
    //   634: ldc_w 'nid'
    //   637: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   640: invokestatic b : (Ljava/lang/String;)[B
    //   643: astore #14
    //   645: aload #14
    //   647: iconst_0
    //   648: aload #12
    //   650: iload_3
    //   651: aload #14
    //   653: arraylength
    //   654: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   657: iload_3
    //   658: aload #14
    //   660: arraylength
    //   661: iadd
    //   662: istore_3
    //   663: aload_0
    //   664: ldc_w 'bid'
    //   667: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   670: invokestatic b : (Ljava/lang/String;)[B
    //   673: astore #14
    //   675: aload #14
    //   677: iconst_0
    //   678: aload #12
    //   680: iload_3
    //   681: aload #14
    //   683: arraylength
    //   684: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   687: iload_3
    //   688: aload #14
    //   690: arraylength
    //   691: iadd
    //   692: istore_3
    //   693: aload_0
    //   694: ldc_w 'lon'
    //   697: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   700: invokestatic c : (Ljava/lang/String;)[B
    //   703: astore #14
    //   705: aload #14
    //   707: iconst_0
    //   708: aload #12
    //   710: iload_3
    //   711: aload #14
    //   713: arraylength
    //   714: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   717: iload_3
    //   718: aload #14
    //   720: arraylength
    //   721: iadd
    //   722: istore_3
    //   723: aload_0
    //   724: ldc_w 'lat'
    //   727: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   730: invokestatic c : (Ljava/lang/String;)[B
    //   733: astore #14
    //   735: aload #14
    //   737: iconst_0
    //   738: aload #12
    //   740: iload_3
    //   741: aload #14
    //   743: arraylength
    //   744: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   747: aload #14
    //   749: arraylength
    //   750: istore #4
    //   752: goto -> 584
    //   755: aload_0
    //   756: ldc 'signal'
    //   758: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   761: invokestatic parseInt : (Ljava/lang/String;)I
    //   764: istore #5
    //   766: iload #5
    //   768: bipush #127
    //   770: if_icmple -> 779
    //   773: iconst_0
    //   774: istore #4
    //   776: goto -> 793
    //   779: iload #5
    //   781: istore #4
    //   783: iload #5
    //   785: bipush #-128
    //   787: if_icmpge -> 793
    //   790: goto -> 773
    //   793: aload #12
    //   795: iload_3
    //   796: iload #4
    //   798: i2b
    //   799: bastore
    //   800: iload_3
    //   801: iconst_1
    //   802: iadd
    //   803: istore_3
    //   804: iconst_0
    //   805: aload #15
    //   807: invokestatic a : (I[B)[B
    //   810: astore #14
    //   812: aload #14
    //   814: iconst_0
    //   815: aload #12
    //   817: iload_3
    //   818: aload #14
    //   820: arraylength
    //   821: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   824: iload_3
    //   825: iconst_2
    //   826: iadd
    //   827: istore #4
    //   829: iload #6
    //   831: iconst_1
    //   832: if_icmpne -> 1014
    //   835: aload_0
    //   836: getfield B : Ljava/lang/String;
    //   839: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   842: ifeq -> 854
    //   845: aload #12
    //   847: iload #4
    //   849: iconst_0
    //   850: bastore
    //   851: goto -> 1029
    //   854: aload_0
    //   855: getfield B : Ljava/lang/String;
    //   858: ldc '\*'
    //   860: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   863: arraylength
    //   864: istore #6
    //   866: aload #12
    //   868: iload #4
    //   870: iload #6
    //   872: i2b
    //   873: bastore
    //   874: iload #4
    //   876: iconst_1
    //   877: iadd
    //   878: istore_3
    //   879: iconst_0
    //   880: istore #4
    //   882: iload #4
    //   884: iload #6
    //   886: if_icmpge -> 1011
    //   889: aload_0
    //   890: ldc 'lac'
    //   892: iload #4
    //   894: invokespecial a : (Ljava/lang/String;I)Ljava/lang/String;
    //   897: invokestatic b : (Ljava/lang/String;)[B
    //   900: astore #14
    //   902: aload #14
    //   904: iconst_0
    //   905: aload #12
    //   907: iload_3
    //   908: aload #14
    //   910: arraylength
    //   911: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   914: iload_3
    //   915: aload #14
    //   917: arraylength
    //   918: iadd
    //   919: istore_3
    //   920: aload_0
    //   921: ldc 'cellid'
    //   923: iload #4
    //   925: invokespecial a : (Ljava/lang/String;I)Ljava/lang/String;
    //   928: invokestatic c : (Ljava/lang/String;)[B
    //   931: astore #14
    //   933: aload #14
    //   935: iconst_0
    //   936: aload #12
    //   938: iload_3
    //   939: aload #14
    //   941: arraylength
    //   942: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   945: iload_3
    //   946: aload #14
    //   948: arraylength
    //   949: iadd
    //   950: istore #7
    //   952: aload_0
    //   953: ldc 'signal'
    //   955: iload #4
    //   957: invokespecial a : (Ljava/lang/String;I)Ljava/lang/String;
    //   960: invokestatic parseInt : (Ljava/lang/String;)I
    //   963: istore #5
    //   965: iload #5
    //   967: bipush #127
    //   969: if_icmple -> 977
    //   972: iconst_0
    //   973: istore_3
    //   974: goto -> 990
    //   977: iload #5
    //   979: istore_3
    //   980: iload #5
    //   982: bipush #-128
    //   984: if_icmpge -> 990
    //   987: goto -> 972
    //   990: aload #12
    //   992: iload #7
    //   994: iload_3
    //   995: i2b
    //   996: bastore
    //   997: iload #7
    //   999: iconst_1
    //   1000: iadd
    //   1001: istore_3
    //   1002: iload #4
    //   1004: iconst_1
    //   1005: iadd
    //   1006: istore #4
    //   1008: goto -> 882
    //   1011: goto -> 1034
    //   1014: iload #4
    //   1016: istore_3
    //   1017: iload #6
    //   1019: iconst_2
    //   1020: if_icmpne -> 1034
    //   1023: aload #12
    //   1025: iload #4
    //   1027: iconst_0
    //   1028: bastore
    //   1029: iload #4
    //   1031: iconst_1
    //   1032: iadd
    //   1033: istore_3
    //   1034: aload_0
    //   1035: getfield D : Ljava/lang/String;
    //   1038: astore #14
    //   1040: iload_3
    //   1041: istore #4
    //   1043: aload #14
    //   1045: ifnull -> 1121
    //   1048: iload_3
    //   1049: istore #4
    //   1051: aload_0
    //   1052: getfield z : I
    //   1055: bipush #8
    //   1057: iand
    //   1058: bipush #8
    //   1060: if_icmpne -> 1121
    //   1063: iload_3
    //   1064: istore #4
    //   1066: aload #14
    //   1068: ldc 'GBK'
    //   1070: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   1073: astore #14
    //   1075: iload_3
    //   1076: istore #4
    //   1078: aload #14
    //   1080: arraylength
    //   1081: bipush #60
    //   1083: invokestatic min : (II)I
    //   1086: istore #5
    //   1088: aload #12
    //   1090: iload_3
    //   1091: iload #5
    //   1093: i2b
    //   1094: bastore
    //   1095: iload_3
    //   1096: iconst_1
    //   1097: iadd
    //   1098: istore_3
    //   1099: iload_3
    //   1100: istore #4
    //   1102: aload #14
    //   1104: iconst_0
    //   1105: aload #12
    //   1107: iload_3
    //   1108: iload #5
    //   1110: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1113: iload_3
    //   1114: iload #5
    //   1116: iadd
    //   1117: istore_3
    //   1118: goto -> 1132
    //   1121: aload #12
    //   1123: iload #4
    //   1125: iconst_0
    //   1126: bastore
    //   1127: iload #4
    //   1129: iconst_1
    //   1130: iadd
    //   1131: istore_3
    //   1132: aload_0
    //   1133: getfield C : Ljava/util/ArrayList;
    //   1136: astore #14
    //   1138: aload #14
    //   1140: invokevirtual size : ()I
    //   1143: istore #4
    //   1145: aload_0
    //   1146: getfield z : I
    //   1149: iconst_4
    //   1150: iand
    //   1151: iconst_4
    //   1152: if_icmpne -> 1845
    //   1155: iload #4
    //   1157: ifle -> 1845
    //   1160: iload #4
    //   1162: istore #5
    //   1164: aload #14
    //   1166: iconst_0
    //   1167: invokevirtual get : (I)Ljava/lang/Object;
    //   1170: checkcast com/amap/api/mapcore2d/gm
    //   1173: getfield p : Z
    //   1176: ifne -> 1185
    //   1179: iload #4
    //   1181: iconst_1
    //   1182: isub
    //   1183: istore #5
    //   1185: aload #12
    //   1187: iload_3
    //   1188: iload #5
    //   1190: i2b
    //   1191: bastore
    //   1192: iload_3
    //   1193: iconst_1
    //   1194: iadd
    //   1195: istore_3
    //   1196: iconst_0
    //   1197: istore #6
    //   1199: iload_3
    //   1200: istore #4
    //   1202: iload #6
    //   1204: iload #5
    //   1206: if_icmpge -> 1855
    //   1209: aload #14
    //   1211: iload #6
    //   1213: invokevirtual get : (I)Ljava/lang/Object;
    //   1216: checkcast com/amap/api/mapcore2d/gm
    //   1219: astore #16
    //   1221: iload_3
    //   1222: istore #4
    //   1224: aload #16
    //   1226: getfield p : Z
    //   1229: ifeq -> 1833
    //   1232: aload #16
    //   1234: getfield k : I
    //   1237: iconst_1
    //   1238: if_icmpeq -> 1489
    //   1241: aload #16
    //   1243: getfield k : I
    //   1246: iconst_3
    //   1247: if_icmpeq -> 1489
    //   1250: aload #16
    //   1252: getfield k : I
    //   1255: iconst_4
    //   1256: if_icmpne -> 1262
    //   1259: goto -> 1489
    //   1262: iload_3
    //   1263: istore #4
    //   1265: aload #16
    //   1267: getfield k : I
    //   1270: iconst_2
    //   1271: if_icmpne -> 1647
    //   1274: aload #16
    //   1276: getfield k : I
    //   1279: i2b
    //   1280: istore_2
    //   1281: iload_2
    //   1282: istore_1
    //   1283: aload #16
    //   1285: getfield n : Z
    //   1288: ifeq -> 1297
    //   1291: iload_2
    //   1292: bipush #8
    //   1294: ior
    //   1295: i2b
    //   1296: istore_1
    //   1297: aload #12
    //   1299: iload_3
    //   1300: iload_1
    //   1301: bastore
    //   1302: iload_3
    //   1303: iconst_1
    //   1304: iadd
    //   1305: istore_3
    //   1306: aload #16
    //   1308: getfield a : I
    //   1311: aload #15
    //   1313: invokestatic a : (I[B)[B
    //   1316: astore #17
    //   1318: aload #17
    //   1320: iconst_0
    //   1321: aload #12
    //   1323: iload_3
    //   1324: aload #17
    //   1326: arraylength
    //   1327: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1330: iload_3
    //   1331: aload #17
    //   1333: arraylength
    //   1334: iadd
    //   1335: istore_3
    //   1336: aload #16
    //   1338: getfield g : I
    //   1341: aload #15
    //   1343: invokestatic a : (I[B)[B
    //   1346: astore #17
    //   1348: aload #17
    //   1350: iconst_0
    //   1351: aload #12
    //   1353: iload_3
    //   1354: aload #17
    //   1356: arraylength
    //   1357: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1360: iload_3
    //   1361: aload #17
    //   1363: arraylength
    //   1364: iadd
    //   1365: istore_3
    //   1366: aload #16
    //   1368: getfield h : I
    //   1371: aload #15
    //   1373: invokestatic a : (I[B)[B
    //   1376: astore #17
    //   1378: aload #17
    //   1380: iconst_0
    //   1381: aload #12
    //   1383: iload_3
    //   1384: aload #17
    //   1386: arraylength
    //   1387: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1390: iload_3
    //   1391: aload #17
    //   1393: arraylength
    //   1394: iadd
    //   1395: istore_3
    //   1396: aload #16
    //   1398: getfield i : I
    //   1401: aload #15
    //   1403: invokestatic a : (I[B)[B
    //   1406: astore #17
    //   1408: aload #17
    //   1410: iconst_0
    //   1411: aload #12
    //   1413: iload_3
    //   1414: aload #17
    //   1416: arraylength
    //   1417: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1420: iload_3
    //   1421: aload #17
    //   1423: arraylength
    //   1424: iadd
    //   1425: istore_3
    //   1426: aload #16
    //   1428: getfield f : I
    //   1431: aload #13
    //   1433: invokestatic b : (I[B)[B
    //   1436: astore #17
    //   1438: aload #17
    //   1440: iconst_0
    //   1441: aload #12
    //   1443: iload_3
    //   1444: aload #17
    //   1446: arraylength
    //   1447: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1450: iload_3
    //   1451: aload #17
    //   1453: arraylength
    //   1454: iadd
    //   1455: istore #4
    //   1457: aload #16
    //   1459: getfield e : I
    //   1462: aload #13
    //   1464: invokestatic b : (I[B)[B
    //   1467: astore #17
    //   1469: aload #17
    //   1471: iconst_0
    //   1472: aload #12
    //   1474: iload #4
    //   1476: aload #17
    //   1478: arraylength
    //   1479: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1482: aload #17
    //   1484: arraylength
    //   1485: istore_3
    //   1486: goto -> 1641
    //   1489: aload #16
    //   1491: getfield k : I
    //   1494: i2b
    //   1495: istore_2
    //   1496: iload_2
    //   1497: istore_1
    //   1498: aload #16
    //   1500: getfield n : Z
    //   1503: ifeq -> 1512
    //   1506: iload_2
    //   1507: bipush #8
    //   1509: ior
    //   1510: i2b
    //   1511: istore_1
    //   1512: aload #12
    //   1514: iload_3
    //   1515: iload_1
    //   1516: bastore
    //   1517: iload_3
    //   1518: iconst_1
    //   1519: iadd
    //   1520: istore_3
    //   1521: aload #16
    //   1523: getfield a : I
    //   1526: aload #15
    //   1528: invokestatic a : (I[B)[B
    //   1531: astore #17
    //   1533: aload #17
    //   1535: iconst_0
    //   1536: aload #12
    //   1538: iload_3
    //   1539: aload #17
    //   1541: arraylength
    //   1542: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1545: iload_3
    //   1546: aload #17
    //   1548: arraylength
    //   1549: iadd
    //   1550: istore_3
    //   1551: aload #16
    //   1553: getfield b : I
    //   1556: aload #15
    //   1558: invokestatic a : (I[B)[B
    //   1561: astore #17
    //   1563: aload #17
    //   1565: iconst_0
    //   1566: aload #12
    //   1568: iload_3
    //   1569: aload #17
    //   1571: arraylength
    //   1572: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1575: iload_3
    //   1576: aload #17
    //   1578: arraylength
    //   1579: iadd
    //   1580: istore_3
    //   1581: aload #16
    //   1583: getfield c : I
    //   1586: aload #15
    //   1588: invokestatic a : (I[B)[B
    //   1591: astore #17
    //   1593: aload #17
    //   1595: iconst_0
    //   1596: aload #12
    //   1598: iload_3
    //   1599: aload #17
    //   1601: arraylength
    //   1602: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1605: iload_3
    //   1606: aload #17
    //   1608: arraylength
    //   1609: iadd
    //   1610: istore #4
    //   1612: aload #16
    //   1614: getfield d : I
    //   1617: aload #13
    //   1619: invokestatic b : (I[B)[B
    //   1622: astore #17
    //   1624: aload #17
    //   1626: iconst_0
    //   1627: aload #12
    //   1629: iload #4
    //   1631: aload #17
    //   1633: arraylength
    //   1634: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1637: aload #17
    //   1639: arraylength
    //   1640: istore_3
    //   1641: iload #4
    //   1643: iload_3
    //   1644: iadd
    //   1645: istore #4
    //   1647: aload #16
    //   1649: getfield j : I
    //   1652: istore #7
    //   1654: iload #7
    //   1656: bipush #127
    //   1658: if_icmple -> 1667
    //   1661: bipush #99
    //   1663: istore_3
    //   1664: goto -> 1680
    //   1667: iload #7
    //   1669: istore_3
    //   1670: iload #7
    //   1672: bipush #-128
    //   1674: if_icmpge -> 1680
    //   1677: goto -> 1661
    //   1680: aload #12
    //   1682: iload #4
    //   1684: iload_3
    //   1685: i2b
    //   1686: bastore
    //   1687: iload #4
    //   1689: iconst_1
    //   1690: iadd
    //   1691: istore_3
    //   1692: aload #16
    //   1694: getfield l : S
    //   1697: aload #15
    //   1699: invokestatic a : (I[B)[B
    //   1702: astore #17
    //   1704: aload #17
    //   1706: iconst_0
    //   1707: aload #12
    //   1709: iload_3
    //   1710: aload #17
    //   1712: arraylength
    //   1713: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1716: iload_3
    //   1717: aload #17
    //   1719: arraylength
    //   1720: iadd
    //   1721: istore #7
    //   1723: iload #7
    //   1725: istore #4
    //   1727: ldc_w '5.1'
    //   1730: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   1733: invokevirtual doubleValue : ()D
    //   1736: ldc2_w 5.0
    //   1739: dcmpl
    //   1740: iflt -> 1833
    //   1743: aload #16
    //   1745: getfield k : I
    //   1748: iconst_3
    //   1749: if_icmpeq -> 1767
    //   1752: iload #7
    //   1754: istore_3
    //   1755: aload #16
    //   1757: getfield k : I
    //   1760: iconst_4
    //   1761: if_icmpne -> 1836
    //   1764: goto -> 1767
    //   1767: aload #16
    //   1769: getfield o : I
    //   1772: istore #4
    //   1774: iload #4
    //   1776: istore_3
    //   1777: iload #4
    //   1779: sipush #32767
    //   1782: if_icmple -> 1789
    //   1785: sipush #32767
    //   1788: istore_3
    //   1789: iload_3
    //   1790: istore #4
    //   1792: iload_3
    //   1793: ifge -> 1801
    //   1796: sipush #32767
    //   1799: istore #4
    //   1801: iload #4
    //   1803: aload #15
    //   1805: invokestatic a : (I[B)[B
    //   1808: astore #16
    //   1810: aload #16
    //   1812: iconst_0
    //   1813: aload #12
    //   1815: iload #7
    //   1817: aload #16
    //   1819: arraylength
    //   1820: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1823: iload #7
    //   1825: aload #16
    //   1827: arraylength
    //   1828: iadd
    //   1829: istore_3
    //   1830: goto -> 1836
    //   1833: iload #4
    //   1835: istore_3
    //   1836: iload #6
    //   1838: iconst_1
    //   1839: iadd
    //   1840: istore #6
    //   1842: goto -> 1199
    //   1845: aload #12
    //   1847: iload_3
    //   1848: iconst_0
    //   1849: bastore
    //   1850: iload_3
    //   1851: iconst_1
    //   1852: iadd
    //   1853: istore #4
    //   1855: aload_0
    //   1856: getfield E : Ljava/lang/String;
    //   1859: invokevirtual length : ()I
    //   1862: ifne -> 1881
    //   1865: aload #12
    //   1867: iload #4
    //   1869: iconst_0
    //   1870: bastore
    //   1871: iload #4
    //   1873: istore_3
    //   1874: iload_3
    //   1875: iconst_1
    //   1876: iadd
    //   1877: istore_3
    //   1878: goto -> 2148
    //   1881: aload #12
    //   1883: iload #4
    //   1885: iconst_1
    //   1886: bastore
    //   1887: iload #4
    //   1889: iconst_1
    //   1890: iadd
    //   1891: istore_3
    //   1892: iload_3
    //   1893: istore #4
    //   1895: aload_0
    //   1896: getfield E : Ljava/lang/String;
    //   1899: ldc ','
    //   1901: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1904: astore #13
    //   1906: iload_3
    //   1907: istore #4
    //   1909: aload_0
    //   1910: aload #13
    //   1912: iconst_0
    //   1913: aaload
    //   1914: invokespecial a : (Ljava/lang/String;)[B
    //   1917: astore #14
    //   1919: iload_3
    //   1920: istore #4
    //   1922: aload #14
    //   1924: iconst_0
    //   1925: aload #12
    //   1927: iload_3
    //   1928: aload #14
    //   1930: arraylength
    //   1931: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1934: iload_3
    //   1935: istore #4
    //   1937: aload #14
    //   1939: arraylength
    //   1940: istore #5
    //   1942: iload_3
    //   1943: iload #5
    //   1945: iadd
    //   1946: istore #5
    //   1948: iload #5
    //   1950: istore_3
    //   1951: aload #13
    //   1953: iconst_2
    //   1954: aaload
    //   1955: ldc 'GBK'
    //   1957: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   1960: astore #14
    //   1962: iload #5
    //   1964: istore_3
    //   1965: aload #14
    //   1967: arraylength
    //   1968: istore #6
    //   1970: iload #6
    //   1972: istore #4
    //   1974: iload #6
    //   1976: bipush #127
    //   1978: if_icmple -> 1985
    //   1981: bipush #127
    //   1983: istore #4
    //   1985: aload #12
    //   1987: iload #5
    //   1989: iload #4
    //   1991: i2b
    //   1992: bastore
    //   1993: iload #5
    //   1995: iconst_1
    //   1996: iadd
    //   1997: istore #5
    //   1999: iload #5
    //   2001: istore_3
    //   2002: aload #14
    //   2004: iconst_0
    //   2005: aload #12
    //   2007: iload #5
    //   2009: iload #4
    //   2011: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2014: iload #5
    //   2016: iload #4
    //   2018: iadd
    //   2019: istore_3
    //   2020: goto -> 2047
    //   2023: astore #14
    //   2025: iload_3
    //   2026: istore #4
    //   2028: aload #14
    //   2030: ldc 'Req'
    //   2032: ldc_w 'buildV4Dot214'
    //   2035: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   2038: aload #12
    //   2040: iload_3
    //   2041: iconst_0
    //   2042: bastore
    //   2043: iload_3
    //   2044: iconst_1
    //   2045: iadd
    //   2046: istore_3
    //   2047: iload_3
    //   2048: istore #4
    //   2050: aload #13
    //   2052: iconst_1
    //   2053: aaload
    //   2054: invokestatic parseInt : (Ljava/lang/String;)I
    //   2057: istore #6
    //   2059: iload #6
    //   2061: bipush #127
    //   2063: if_icmple -> 3061
    //   2066: goto -> 3055
    //   2069: iload_3
    //   2070: istore #4
    //   2072: aload #12
    //   2074: iload_3
    //   2075: iload #5
    //   2077: invokestatic valueOf : (I)Ljava/lang/String;
    //   2080: invokestatic parseByte : (Ljava/lang/String;)B
    //   2083: bastore
    //   2084: goto -> 1874
    //   2087: astore #13
    //   2089: aload #13
    //   2091: ldc 'Req'
    //   2093: ldc_w 'buildV4Dot216'
    //   2096: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   2099: aload_0
    //   2100: ldc '00:00:00:00:00:00'
    //   2102: invokespecial a : (Ljava/lang/String;)[B
    //   2105: astore #13
    //   2107: aload #13
    //   2109: iconst_0
    //   2110: aload #12
    //   2112: iload #4
    //   2114: aload #13
    //   2116: arraylength
    //   2117: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2120: iload #4
    //   2122: aload #13
    //   2124: arraylength
    //   2125: iadd
    //   2126: istore_3
    //   2127: aload #12
    //   2129: iload_3
    //   2130: iconst_0
    //   2131: bastore
    //   2132: iload_3
    //   2133: iconst_1
    //   2134: iadd
    //   2135: istore_3
    //   2136: aload #12
    //   2138: iload_3
    //   2139: ldc '0'
    //   2141: invokestatic parseByte : (Ljava/lang/String;)B
    //   2144: bastore
    //   2145: goto -> 1874
    //   2148: aload_0
    //   2149: getfield F : Ljava/util/ArrayList;
    //   2152: astore #13
    //   2154: aload #13
    //   2156: invokevirtual size : ()I
    //   2159: bipush #25
    //   2161: invokestatic min : (II)I
    //   2164: istore #8
    //   2166: iload #8
    //   2168: ifne -> 2183
    //   2171: aload #12
    //   2173: iload_3
    //   2174: iconst_0
    //   2175: bastore
    //   2176: iload_3
    //   2177: iconst_1
    //   2178: iadd
    //   2179: istore_3
    //   2180: goto -> 2553
    //   2183: aload #12
    //   2185: iload_3
    //   2186: iload #8
    //   2188: i2b
    //   2189: bastore
    //   2190: iload_3
    //   2191: iconst_1
    //   2192: iadd
    //   2193: istore_3
    //   2194: invokestatic c : ()I
    //   2197: bipush #17
    //   2199: if_icmplt -> 2208
    //   2202: iconst_1
    //   2203: istore #4
    //   2205: goto -> 2211
    //   2208: iconst_0
    //   2209: istore #4
    //   2211: lconst_0
    //   2212: lstore #9
    //   2214: iload #4
    //   2216: ifeq -> 2228
    //   2219: invokestatic b : ()J
    //   2222: ldc2_w 1000
    //   2225: ldiv
    //   2226: lstore #9
    //   2228: iconst_0
    //   2229: istore #5
    //   2231: iload #5
    //   2233: iload #8
    //   2235: if_icmpge -> 2521
    //   2238: aload #13
    //   2240: iload #5
    //   2242: invokevirtual get : (I)Ljava/lang/Object;
    //   2245: checkcast android/net/wifi/ScanResult
    //   2248: astore #14
    //   2250: aload_0
    //   2251: aload #14
    //   2253: getfield BSSID : Ljava/lang/String;
    //   2256: invokespecial a : (Ljava/lang/String;)[B
    //   2259: astore #16
    //   2261: aload #16
    //   2263: iconst_0
    //   2264: aload #12
    //   2266: iload_3
    //   2267: aload #16
    //   2269: arraylength
    //   2270: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2273: iload_3
    //   2274: aload #16
    //   2276: arraylength
    //   2277: iadd
    //   2278: istore #6
    //   2280: iload #6
    //   2282: istore_3
    //   2283: aload #14
    //   2285: getfield SSID : Ljava/lang/String;
    //   2288: ldc 'GBK'
    //   2290: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   2293: astore #16
    //   2295: iload #6
    //   2297: istore_3
    //   2298: aload #12
    //   2300: iload #6
    //   2302: aload #16
    //   2304: arraylength
    //   2305: i2b
    //   2306: bastore
    //   2307: iload #6
    //   2309: iconst_1
    //   2310: iadd
    //   2311: istore #6
    //   2313: iload #6
    //   2315: istore_3
    //   2316: aload #16
    //   2318: iconst_0
    //   2319: aload #12
    //   2321: iload #6
    //   2323: aload #16
    //   2325: arraylength
    //   2326: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2329: iload #6
    //   2331: istore_3
    //   2332: aload #16
    //   2334: arraylength
    //   2335: istore #7
    //   2337: iload #6
    //   2339: iload #7
    //   2341: iadd
    //   2342: istore #6
    //   2344: goto -> 2357
    //   2347: aload #12
    //   2349: iload_3
    //   2350: iconst_0
    //   2351: bastore
    //   2352: iload_3
    //   2353: iconst_1
    //   2354: iadd
    //   2355: istore #6
    //   2357: aload #14
    //   2359: getfield level : I
    //   2362: istore #7
    //   2364: iload #7
    //   2366: bipush #127
    //   2368: if_icmple -> 2376
    //   2371: iconst_0
    //   2372: istore_3
    //   2373: goto -> 2388
    //   2376: iload #7
    //   2378: istore_3
    //   2379: iload #7
    //   2381: bipush #-128
    //   2383: if_icmpge -> 2388
    //   2386: iconst_0
    //   2387: istore_3
    //   2388: aload #12
    //   2390: iload #6
    //   2392: iload_3
    //   2393: invokestatic valueOf : (I)Ljava/lang/String;
    //   2396: invokestatic parseByte : (Ljava/lang/String;)B
    //   2399: bastore
    //   2400: iload #6
    //   2402: iconst_1
    //   2403: iadd
    //   2404: istore #7
    //   2406: iload #4
    //   2408: ifeq -> 2436
    //   2411: lload #9
    //   2413: aload #14
    //   2415: getfield timestamp : J
    //   2418: ldc2_w 1000000
    //   2421: ldiv
    //   2422: lconst_1
    //   2423: ladd
    //   2424: lsub
    //   2425: l2i
    //   2426: istore #6
    //   2428: iload #6
    //   2430: istore_3
    //   2431: iload #6
    //   2433: ifge -> 2438
    //   2436: iconst_0
    //   2437: istore_3
    //   2438: iload_3
    //   2439: istore #6
    //   2441: iload_3
    //   2442: ldc_w 65535
    //   2445: if_icmple -> 2453
    //   2448: ldc_w 65535
    //   2451: istore #6
    //   2453: iload #6
    //   2455: aload #15
    //   2457: invokestatic a : (I[B)[B
    //   2460: astore #16
    //   2462: aload #16
    //   2464: iconst_0
    //   2465: aload #12
    //   2467: iload #7
    //   2469: aload #16
    //   2471: arraylength
    //   2472: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2475: iload #7
    //   2477: aload #16
    //   2479: arraylength
    //   2480: iadd
    //   2481: istore_3
    //   2482: aload #14
    //   2484: getfield frequency : I
    //   2487: aload #15
    //   2489: invokestatic a : (I[B)[B
    //   2492: astore #14
    //   2494: aload #14
    //   2496: iconst_0
    //   2497: aload #12
    //   2499: iload_3
    //   2500: aload #14
    //   2502: arraylength
    //   2503: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2506: iload_3
    //   2507: aload #14
    //   2509: arraylength
    //   2510: iadd
    //   2511: istore_3
    //   2512: iload #5
    //   2514: iconst_1
    //   2515: iadd
    //   2516: istore #5
    //   2518: goto -> 2231
    //   2521: aload_0
    //   2522: getfield G : Ljava/lang/String;
    //   2525: invokestatic parseInt : (Ljava/lang/String;)I
    //   2528: aload #15
    //   2530: invokestatic a : (I[B)[B
    //   2533: astore #13
    //   2535: aload #13
    //   2537: iconst_0
    //   2538: aload #12
    //   2540: iload_3
    //   2541: aload #13
    //   2543: arraylength
    //   2544: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2547: iload_3
    //   2548: aload #13
    //   2550: arraylength
    //   2551: iadd
    //   2552: istore_3
    //   2553: aload #12
    //   2555: iload_3
    //   2556: iconst_0
    //   2557: bastore
    //   2558: iload_3
    //   2559: iconst_1
    //   2560: iadd
    //   2561: istore #4
    //   2563: iload #4
    //   2565: istore_3
    //   2566: aload_0
    //   2567: getfield H : Ljava/lang/String;
    //   2570: ldc 'GBK'
    //   2572: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   2575: astore #14
    //   2577: iload #4
    //   2579: istore_3
    //   2580: aload #14
    //   2582: astore #13
    //   2584: aload #14
    //   2586: arraylength
    //   2587: bipush #127
    //   2589: if_icmple -> 3075
    //   2592: aconst_null
    //   2593: astore #13
    //   2595: goto -> 3075
    //   2598: iload #4
    //   2600: istore_3
    //   2601: aload #12
    //   2603: iload #4
    //   2605: aload #13
    //   2607: arraylength
    //   2608: i2b
    //   2609: bastore
    //   2610: iload #4
    //   2612: iconst_1
    //   2613: iadd
    //   2614: istore #4
    //   2616: iload #4
    //   2618: istore_3
    //   2619: aload #13
    //   2621: iconst_0
    //   2622: aload #12
    //   2624: iload #4
    //   2626: aload #13
    //   2628: arraylength
    //   2629: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2632: iload #4
    //   2634: istore_3
    //   2635: aload #13
    //   2637: arraylength
    //   2638: istore #5
    //   2640: iload #4
    //   2642: iload #5
    //   2644: iadd
    //   2645: istore_3
    //   2646: goto -> 2658
    //   2649: aload #12
    //   2651: iload_3
    //   2652: iconst_0
    //   2653: bastore
    //   2654: iload_3
    //   2655: iconst_1
    //   2656: iadd
    //   2657: istore_3
    //   2658: iconst_2
    //   2659: newarray byte
    //   2661: astore #13
    //   2663: aload #13
    //   2665: dup
    //   2666: iconst_0
    //   2667: ldc_w 0
    //   2670: bastore
    //   2671: dup
    //   2672: iconst_1
    //   2673: ldc_w 0
    //   2676: bastore
    //   2677: pop
    //   2678: aload_0
    //   2679: getfield K : Ljava/lang/String;
    //   2682: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2685: istore #11
    //   2687: iload #11
    //   2689: ifne -> 2706
    //   2692: aload_0
    //   2693: getfield K : Ljava/lang/String;
    //   2696: invokevirtual length : ()I
    //   2699: aload #15
    //   2701: invokestatic a : (I[B)[B
    //   2704: astore #13
    //   2706: aload #13
    //   2708: iconst_0
    //   2709: aload #12
    //   2711: iload_3
    //   2712: iconst_2
    //   2713: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2716: iload_3
    //   2717: iconst_2
    //   2718: iadd
    //   2719: istore #4
    //   2721: iload #4
    //   2723: istore_3
    //   2724: iload #11
    //   2726: ifne -> 2762
    //   2729: aload_0
    //   2730: getfield K : Ljava/lang/String;
    //   2733: ldc 'GBK'
    //   2735: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   2738: astore #13
    //   2740: aload #13
    //   2742: iconst_0
    //   2743: aload #12
    //   2745: iload #4
    //   2747: aload #13
    //   2749: arraylength
    //   2750: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2753: aload #13
    //   2755: arraylength
    //   2756: istore_3
    //   2757: iload #4
    //   2759: iload_3
    //   2760: iadd
    //   2761: istore_3
    //   2762: goto -> 2769
    //   2765: iload_3
    //   2766: iconst_2
    //   2767: iadd
    //   2768: istore_3
    //   2769: iconst_0
    //   2770: aload #15
    //   2772: invokestatic a : (I[B)[B
    //   2775: iconst_0
    //   2776: aload #12
    //   2778: iload_3
    //   2779: iconst_2
    //   2780: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2783: iload_3
    //   2784: iconst_2
    //   2785: iadd
    //   2786: istore_3
    //   2787: iconst_2
    //   2788: newarray byte
    //   2790: dup
    //   2791: iconst_0
    //   2792: ldc_w 0
    //   2795: bastore
    //   2796: dup
    //   2797: iconst_1
    //   2798: ldc_w 0
    //   2801: bastore
    //   2802: iconst_0
    //   2803: aload #12
    //   2805: iload_3
    //   2806: iconst_2
    //   2807: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2810: iload_3
    //   2811: iconst_2
    //   2812: iadd
    //   2813: istore_3
    //   2814: aload_0
    //   2815: getfield I : [B
    //   2818: astore #13
    //   2820: aload #13
    //   2822: ifnull -> 2833
    //   2825: aload #13
    //   2827: arraylength
    //   2828: istore #4
    //   2830: goto -> 2836
    //   2833: iconst_0
    //   2834: istore #4
    //   2836: iload #4
    //   2838: aconst_null
    //   2839: invokestatic a : (I[B)[B
    //   2842: astore #13
    //   2844: aload #13
    //   2846: iconst_0
    //   2847: aload #12
    //   2849: iload_3
    //   2850: aload #13
    //   2852: arraylength
    //   2853: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2856: iload_3
    //   2857: aload #13
    //   2859: arraylength
    //   2860: iadd
    //   2861: istore #5
    //   2863: iload #5
    //   2865: istore_3
    //   2866: iload #4
    //   2868: ifle -> 2899
    //   2871: aload_0
    //   2872: getfield I : [B
    //   2875: astore #13
    //   2877: aload #13
    //   2879: iconst_0
    //   2880: aload #12
    //   2882: iload #5
    //   2884: aload #13
    //   2886: arraylength
    //   2887: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2890: iload #5
    //   2892: aload_0
    //   2893: getfield I : [B
    //   2896: arraylength
    //   2897: iadd
    //   2898: istore_3
    //   2899: iload_3
    //   2900: istore #4
    //   2902: ldc_w '5.1'
    //   2905: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   2908: invokevirtual doubleValue : ()D
    //   2911: ldc2_w 5.0
    //   2914: dcmpl
    //   2915: iflt -> 2937
    //   2918: aload #12
    //   2920: iload_3
    //   2921: iconst_0
    //   2922: bastore
    //   2923: aload_0
    //   2924: getfield N : Ljava/lang/String;
    //   2927: aload #12
    //   2929: iload_3
    //   2930: iconst_1
    //   2931: iadd
    //   2932: invokestatic a : (Ljava/lang/String;[BI)I
    //   2935: istore #4
    //   2937: iload #4
    //   2939: newarray byte
    //   2941: astore #13
    //   2943: aload #12
    //   2945: iconst_0
    //   2946: aload #13
    //   2948: iconst_0
    //   2949: iload #4
    //   2951: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2954: new java/util/zip/CRC32
    //   2957: dup
    //   2958: invokespecial <init> : ()V
    //   2961: astore #12
    //   2963: aload #12
    //   2965: aload #13
    //   2967: invokevirtual update : ([B)V
    //   2970: aload #12
    //   2972: invokevirtual getValue : ()J
    //   2975: invokestatic a : (J)[B
    //   2978: astore #12
    //   2980: aload #12
    //   2982: arraylength
    //   2983: iload #4
    //   2985: iadd
    //   2986: newarray byte
    //   2988: astore #14
    //   2990: aload #13
    //   2992: iconst_0
    //   2993: aload #14
    //   2995: iconst_0
    //   2996: iload #4
    //   2998: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3001: aload #12
    //   3003: iconst_0
    //   3004: aload #14
    //   3006: iload #4
    //   3008: aload #12
    //   3010: arraylength
    //   3011: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3014: aload #14
    //   3016: areturn
    //   3017: astore #14
    //   3019: goto -> 1121
    //   3022: astore #16
    //   3024: goto -> 2347
    //   3027: astore #13
    //   3029: goto -> 2649
    //   3032: astore #13
    //   3034: goto -> 2765
    //   3037: astore #13
    //   3039: iload #4
    //   3041: istore_3
    //   3042: goto -> 2762
    //   3045: astore #13
    //   3047: goto -> 2783
    //   3050: astore #13
    //   3052: goto -> 2810
    //   3055: iconst_0
    //   3056: istore #5
    //   3058: goto -> 2069
    //   3061: iload #6
    //   3063: istore #5
    //   3065: iload #6
    //   3067: bipush #-128
    //   3069: if_icmpge -> 2069
    //   3072: goto -> 3055
    //   3075: aload #13
    //   3077: ifnonnull -> 2598
    //   3080: aload #12
    //   3082: iload #4
    //   3084: iconst_0
    //   3085: bastore
    //   3086: iload #4
    //   3088: istore_3
    //   3089: goto -> 2654
    // Exception table:
    //   from	to	target	type
    //   227	237	313	finally
    //   252	262	313	finally
    //   265	274	313	finally
    //   283	296	313	finally
    //   299	304	313	finally
    //   1066	1075	3017	java/lang/Exception
    //   1078	1088	3017	java/lang/Exception
    //   1102	1113	3017	java/lang/Exception
    //   1895	1906	2087	finally
    //   1909	1919	2087	finally
    //   1922	1934	2087	finally
    //   1937	1942	2087	finally
    //   1951	1962	2023	finally
    //   1965	1970	2023	finally
    //   2002	2014	2023	finally
    //   2028	2038	2087	finally
    //   2050	2059	2087	finally
    //   2072	2084	2087	finally
    //   2283	2295	3022	java/lang/Exception
    //   2298	2307	3022	java/lang/Exception
    //   2316	2329	3022	java/lang/Exception
    //   2332	2337	3022	java/lang/Exception
    //   2566	2577	3027	finally
    //   2584	2592	3027	finally
    //   2601	2610	3027	finally
    //   2619	2632	3027	finally
    //   2635	2640	3027	finally
    //   2678	2687	3032	finally
    //   2692	2706	3032	finally
    //   2706	2716	3032	finally
    //   2729	2757	3037	finally
    //   2769	2783	3045	finally
    //   2787	2810	3050	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */