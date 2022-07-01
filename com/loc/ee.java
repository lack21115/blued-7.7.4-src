package com.loc;

import android.content.Context;

public final class ee {
  private static ee b;
  
  aq a = null;
  
  private Context c = null;
  
  private int d = ej.g;
  
  private boolean e = false;
  
  private int f = 0;
  
  private ee(Context paramContext) {
    try {
      p.a().a(paramContext);
    } finally {
      Exception exception;
    } 
    this.c = paramContext;
    this.a = aq.a();
  }
  
  public static ee a(Context paramContext) {
    if (b == null)
      b = new ee(paramContext); 
    return b;
  }
  
  public final int a() {
    return this.d;
  }
  
  public final aw a(ef paramef) throws Throwable {
    if (this.e || ep.k(this.c)) {
      boolean bool1 = true;
      return aq.a(paramef, bool1);
    } 
    boolean bool = false;
    return aq.a(paramef, bool);
  }
  
  public final aw a(ef paramef, int paramInt) throws Throwable {
    if (this.e || ep.k(this.c)) {
      boolean bool1 = true;
      return aq.a(paramef, bool1, paramInt);
    } 
    boolean bool = false;
    return aq.a(paramef, bool, paramInt);
  }
  
  public final ef a(Context paramContext, byte[] paramArrayOfbyte, String paramString1, String paramString2, boolean paramBoolean) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: bipush #16
    //   6: invokespecial <init> : (I)V
    //   9: astore #7
    //   11: new com/loc/ef
    //   14: dup
    //   15: aload_1
    //   16: invokestatic c : ()Lcom/loc/t;
    //   19: invokespecial <init> : (Landroid/content/Context;Lcom/loc/t;)V
    //   22: astore #8
    //   24: aload #7
    //   26: ldc 'Content-Type'
    //   28: ldc 'application/octet-stream'
    //   30: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload #7
    //   38: ldc 'Accept-Encoding'
    //   40: ldc 'gzip'
    //   42: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload #7
    //   50: ldc 'gzipped'
    //   52: ldc '1'
    //   54: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload #7
    //   62: ldc 'Connection'
    //   64: ldc 'Keep-Alive'
    //   66: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload #7
    //   74: ldc 'User-Agent'
    //   76: ldc 'AMAP_Location_SDK_Android 5.2.0'
    //   78: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload #7
    //   86: ldc 'KEY'
    //   88: aload_1
    //   89: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   92: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload #7
    //   100: ldc 'enginever'
    //   102: ldc '5.1'
    //   104: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: invokestatic a : ()Ljava/lang/String;
    //   113: astore #9
    //   115: new java/lang/StringBuilder
    //   118: dup
    //   119: ldc 'key='
    //   121: invokespecial <init> : (Ljava/lang/String;)V
    //   124: astore #10
    //   126: aload #10
    //   128: aload_1
    //   129: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_1
    //   137: aload #9
    //   139: aload #10
    //   141: invokevirtual toString : ()Ljava/lang/String;
    //   144: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: astore #10
    //   149: aload #7
    //   151: ldc 'ts'
    //   153: aload #9
    //   155: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload #7
    //   163: ldc 'scode'
    //   165: aload #10
    //   167: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload #7
    //   175: ldc 'encr'
    //   177: ldc '1'
    //   179: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: aload #8
    //   187: aload #7
    //   189: putfield f : Ljava/util/Map;
    //   192: ldc 'loc'
    //   194: astore #7
    //   196: iload #5
    //   198: ifne -> 205
    //   201: ldc 'locf'
    //   203: astore #7
    //   205: aload #8
    //   207: iconst_1
    //   208: putfield n : Z
    //   211: aload #8
    //   213: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   216: ldc 'platform=Android&sdkversion=%s&product=%s&loc_channel=%s'
    //   218: iconst_3
    //   219: anewarray java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: ldc '5.2.0'
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload #7
    //   231: aastore
    //   232: dup
    //   233: iconst_2
    //   234: iconst_3
    //   235: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   238: aastore
    //   239: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   242: putfield l : Ljava/lang/String;
    //   245: aload #8
    //   247: iload #5
    //   249: putfield k : Z
    //   252: aload #8
    //   254: aload_3
    //   255: putfield g : Ljava/lang/String;
    //   258: aload #8
    //   260: aload #4
    //   262: putfield h : Ljava/lang/String;
    //   265: aload #8
    //   267: aload_2
    //   268: invokestatic a : ([B)[B
    //   271: putfield i : [B
    //   274: aload #8
    //   276: aload_1
    //   277: invokestatic a : (Landroid/content/Context;)Ljava/net/Proxy;
    //   280: invokevirtual a : (Ljava/net/Proxy;)V
    //   283: new java/util/HashMap
    //   286: dup
    //   287: bipush #16
    //   289: invokespecial <init> : (I)V
    //   292: astore #4
    //   294: aload #4
    //   296: ldc 'output'
    //   298: ldc 'bin'
    //   300: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: aload #4
    //   308: ldc 'policy'
    //   310: ldc '3103'
    //   312: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   317: pop
    //   318: aload_0
    //   319: getfield f : I
    //   322: istore #6
    //   324: iload #6
    //   326: ifeq -> 341
    //   329: iload #6
    //   331: iconst_1
    //   332: if_icmpeq -> 460
    //   335: iload #6
    //   337: iconst_2
    //   338: if_icmpeq -> 454
    //   341: aload #4
    //   343: ldc 'custom'
    //   345: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   350: pop
    //   351: goto -> 368
    //   354: aload #4
    //   356: ldc 'custom'
    //   358: aload_2
    //   359: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: goto -> 368
    //   368: aload #8
    //   370: aload #4
    //   372: putfield m : Ljava/util/Map;
    //   375: aload #8
    //   377: aload_0
    //   378: getfield d : I
    //   381: invokevirtual a : (I)V
    //   384: aload #8
    //   386: aload_0
    //   387: getfield d : I
    //   390: invokevirtual b : (I)V
    //   393: aload_0
    //   394: getfield e : Z
    //   397: ifne -> 410
    //   400: aload #8
    //   402: astore_2
    //   403: aload_1
    //   404: invokestatic k : (Landroid/content/Context;)Z
    //   407: ifeq -> 444
    //   410: aload #8
    //   412: astore_2
    //   413: aload_3
    //   414: ldc 'http:'
    //   416: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   419: ifeq -> 444
    //   422: aload #8
    //   424: aload #8
    //   426: invokevirtual c : ()Ljava/lang/String;
    //   429: ldc 'https:'
    //   431: ldc 'https:'
    //   433: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   436: putfield g : Ljava/lang/String;
    //   439: aload #8
    //   441: areturn
    //   442: aconst_null
    //   443: astore_2
    //   444: aload_2
    //   445: areturn
    //   446: astore_1
    //   447: goto -> 442
    //   450: astore_1
    //   451: aload #8
    //   453: areturn
    //   454: ldc 'language:en'
    //   456: astore_2
    //   457: goto -> 354
    //   460: ldc 'language:cn'
    //   462: astore_2
    //   463: goto -> 354
    // Exception table:
    //   from	to	target	type
    //   0	24	446	finally
    //   24	192	450	finally
    //   205	324	450	finally
    //   341	351	450	finally
    //   354	365	450	finally
    //   368	400	450	finally
    //   403	410	450	finally
    //   413	439	450	finally
  }
  
  public final String a(Context paramContext, double paramDouble1, double paramDouble2) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: bipush #16
    //   6: invokespecial <init> : (I)V
    //   9: astore #9
    //   11: new com/loc/ef
    //   14: dup
    //   15: aload_1
    //   16: invokestatic c : ()Lcom/loc/t;
    //   19: invokespecial <init> : (Landroid/content/Context;Lcom/loc/t;)V
    //   22: astore #10
    //   24: aload #9
    //   26: invokeinterface clear : ()V
    //   31: aload #9
    //   33: ldc 'Content-Type'
    //   35: ldc_w 'application/x-www-form-urlencoded'
    //   38: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload #9
    //   46: ldc 'Connection'
    //   48: ldc 'Keep-Alive'
    //   50: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload #9
    //   58: ldc 'User-Agent'
    //   60: ldc 'AMAP_Location_SDK_Android 5.2.0'
    //   62: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: new java/util/HashMap
    //   71: dup
    //   72: bipush #16
    //   74: invokespecial <init> : (I)V
    //   77: astore #11
    //   79: aload #11
    //   81: ldc 'custom'
    //   83: ldc_w '26260A1F00020002'
    //   86: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload #11
    //   94: ldc_w 'key'
    //   97: aload_1
    //   98: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   101: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_0
    //   108: getfield f : I
    //   111: istore #6
    //   113: iload #6
    //   115: ifeq -> 130
    //   118: iload #6
    //   120: iconst_1
    //   121: if_icmpeq -> 539
    //   124: iload #6
    //   126: iconst_2
    //   127: if_icmpeq -> 531
    //   130: aload #11
    //   132: ldc_w 'language'
    //   135: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: goto -> 160
    //   144: aload #11
    //   146: ldc_w 'language'
    //   149: aload #7
    //   151: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: goto -> 160
    //   160: invokestatic a : ()Ljava/lang/String;
    //   163: astore #7
    //   165: aload_1
    //   166: aload #7
    //   168: aload #11
    //   170: invokestatic b : (Ljava/util/Map;)Ljava/lang/String;
    //   173: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   176: astore #8
    //   178: aload #11
    //   180: ldc 'ts'
    //   182: aload #7
    //   184: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: aload #11
    //   192: ldc 'scode'
    //   194: aload #8
    //   196: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: new java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 'output=json&radius=1000&extensions=all&location='
    //   209: invokespecial <init> : (Ljava/lang/String;)V
    //   212: astore #7
    //   214: aload #7
    //   216: dload #4
    //   218: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload #7
    //   224: ldc_w ','
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #7
    //   233: dload_2
    //   234: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload #7
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: ldc_w 'UTF-8'
    //   246: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   249: astore #8
    //   251: new java/io/ByteArrayOutputStream
    //   254: dup
    //   255: invokespecial <init> : ()V
    //   258: astore #7
    //   260: aload #8
    //   262: ifnull -> 283
    //   265: aload #7
    //   267: aload #8
    //   269: arraylength
    //   270: invokestatic a : (I)[B
    //   273: invokevirtual write : ([B)V
    //   276: aload #7
    //   278: aload #8
    //   280: invokevirtual write : ([B)V
    //   283: aload #10
    //   285: aload #7
    //   287: invokevirtual toByteArray : ()[B
    //   290: putfield j : [B
    //   293: aload #7
    //   295: invokevirtual close : ()V
    //   298: goto -> 336
    //   301: astore #7
    //   303: aload #7
    //   305: invokevirtual printStackTrace : ()V
    //   308: goto -> 336
    //   311: astore #8
    //   313: goto -> 321
    //   316: astore #8
    //   318: aconst_null
    //   319: astore #7
    //   321: aload #8
    //   323: invokevirtual printStackTrace : ()V
    //   326: aload #7
    //   328: ifnull -> 336
    //   331: aload #7
    //   333: invokevirtual close : ()V
    //   336: aload #10
    //   338: iconst_0
    //   339: putfield n : Z
    //   342: aload #10
    //   344: iconst_1
    //   345: putfield k : Z
    //   348: aload #10
    //   350: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   353: ldc 'platform=Android&sdkversion=%s&product=%s&loc_channel=%s'
    //   355: iconst_3
    //   356: anewarray java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: ldc '5.2.0'
    //   363: aastore
    //   364: dup
    //   365: iconst_1
    //   366: ldc 'loc'
    //   368: aastore
    //   369: dup
    //   370: iconst_2
    //   371: iconst_3
    //   372: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   375: aastore
    //   376: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   379: putfield l : Ljava/lang/String;
    //   382: aload #10
    //   384: aload #11
    //   386: putfield m : Ljava/util/Map;
    //   389: aload #10
    //   391: aload #9
    //   393: putfield f : Ljava/util/Map;
    //   396: aload #10
    //   398: aload_1
    //   399: invokestatic a : (Landroid/content/Context;)Ljava/net/Proxy;
    //   402: invokevirtual a : (Ljava/net/Proxy;)V
    //   405: aload #10
    //   407: getstatic com/loc/ej.g : I
    //   410: invokevirtual a : (I)V
    //   413: aload #10
    //   415: getstatic com/loc/ej.g : I
    //   418: invokevirtual b : (I)V
    //   421: aload #10
    //   423: ldc_w 'http://dualstack-restsdk.amap.com/v3/geocode/regeo'
    //   426: putfield h : Ljava/lang/String;
    //   429: aload_1
    //   430: invokestatic k : (Landroid/content/Context;)Z
    //   433: ifeq -> 460
    //   436: aload #10
    //   438: ldc_w 'http://restsdk.amap.com/v3/geocode/regeo'
    //   441: ldc 'http:'
    //   443: ldc 'https:'
    //   445: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   448: putfield g : Ljava/lang/String;
    //   451: aload #10
    //   453: invokestatic a : (Lcom/loc/av;)[B
    //   456: astore_1
    //   457: goto -> 474
    //   460: aload #10
    //   462: ldc_w 'http://restsdk.amap.com/v3/geocode/regeo'
    //   465: putfield g : Ljava/lang/String;
    //   468: aload #10
    //   470: invokestatic b : (Lcom/loc/av;)[B
    //   473: astore_1
    //   474: new java/lang/String
    //   477: dup
    //   478: aload_1
    //   479: ldc_w 'utf-8'
    //   482: invokespecial <init> : ([BLjava/lang/String;)V
    //   485: astore_1
    //   486: aload_1
    //   487: areturn
    //   488: astore_1
    //   489: aload_1
    //   490: ldc_w 'LocNetManager'
    //   493: ldc_w 'post'
    //   496: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   499: goto -> 525
    //   502: astore_1
    //   503: aload #7
    //   505: ifnull -> 523
    //   508: aload #7
    //   510: invokevirtual close : ()V
    //   513: goto -> 523
    //   516: astore #7
    //   518: aload #7
    //   520: invokevirtual printStackTrace : ()V
    //   523: aload_1
    //   524: athrow
    //   525: aconst_null
    //   526: areturn
    //   527: astore_1
    //   528: goto -> 525
    //   531: ldc_w 'en'
    //   534: astore #7
    //   536: goto -> 144
    //   539: ldc_w 'zh-CN'
    //   542: astore #7
    //   544: goto -> 144
    // Exception table:
    //   from	to	target	type
    //   0	113	527	finally
    //   130	141	527	finally
    //   144	157	527	finally
    //   160	251	527	finally
    //   251	260	316	finally
    //   265	283	311	finally
    //   283	293	311	finally
    //   293	298	301	java/io/IOException
    //   293	298	527	finally
    //   303	308	527	finally
    //   321	326	502	finally
    //   331	336	301	java/io/IOException
    //   331	336	527	finally
    //   336	421	527	finally
    //   421	457	488	finally
    //   460	474	488	finally
    //   474	486	488	finally
    //   489	499	527	finally
    //   508	513	516	java/io/IOException
    //   508	513	527	finally
    //   518	523	527	finally
    //   523	525	527	finally
  }
  
  public final void a(long paramLong, boolean paramBoolean, int paramInt) {
    try {
      this.e = paramBoolean;
      try {
        p.a().a(paramBoolean);
      } finally {
        Exception exception;
      } 
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "LocNetManager", "setOption");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */