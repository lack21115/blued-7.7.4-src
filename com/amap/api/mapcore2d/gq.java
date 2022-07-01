package com.amap.api.mapcore2d;

import android.content.Context;

public final class gq {
  private static gq b;
  
  er a = null;
  
  private Context c = null;
  
  private int d = 0;
  
  private int e = gu.f;
  
  private boolean f = false;
  
  private int g = 0;
  
  private gq(Context paramContext) {
    try {
      cw.a().a(paramContext);
    } finally {
      Exception exception;
    } 
    this.c = paramContext;
    this.a = er.a();
  }
  
  public static gq a(Context paramContext) {
    if (b == null)
      b = new gq(paramContext); 
    return b;
  }
  
  public final ey a(gr paramgr) throws Throwable {
    long l = gy.b();
    if (this.f || gy.e(this.c)) {
      boolean bool1 = true;
      ey = this.a.a(paramgr, bool1);
      this.d = Long.valueOf(gy.b() - l).intValue();
      return ey;
    } 
    boolean bool = false;
    ey ey = this.a.a((ew)ey, bool);
    this.d = Long.valueOf(gy.b() - l).intValue();
    return ey;
  }
  
  public final gr a(Context paramContext, byte[] paramArrayOfbyte, String paramString) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: bipush #16
    //   6: invokespecial <init> : (I)V
    //   9: astore #6
    //   11: new com/amap/api/mapcore2d/gr
    //   14: dup
    //   15: aload_1
    //   16: invokestatic b : ()Lcom/amap/api/mapcore2d/da;
    //   19: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;)V
    //   22: astore #5
    //   24: aload #6
    //   26: ldc 'Content-Type'
    //   28: ldc 'application/octet-stream'
    //   30: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload #6
    //   38: ldc 'Accept-Encoding'
    //   40: ldc 'gzip'
    //   42: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload #6
    //   50: ldc 'gzipped'
    //   52: ldc '1'
    //   54: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload #6
    //   62: ldc 'Connection'
    //   64: ldc 'Keep-Alive'
    //   66: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload #6
    //   74: ldc 'User-Agent'
    //   76: ldc 'AMAP_Location_SDK_Android 4.7.0'
    //   78: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload #6
    //   86: ldc 'KEY'
    //   88: aload_1
    //   89: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   92: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload #6
    //   100: ldc 'enginever'
    //   102: ldc '5.1'
    //   104: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: invokestatic a : ()Ljava/lang/String;
    //   113: astore #7
    //   115: new java/lang/StringBuilder
    //   118: dup
    //   119: ldc 'key='
    //   121: invokespecial <init> : (Ljava/lang/String;)V
    //   124: astore #8
    //   126: aload #8
    //   128: aload_1
    //   129: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_1
    //   137: aload #7
    //   139: aload #8
    //   141: invokevirtual toString : ()Ljava/lang/String;
    //   144: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: astore #8
    //   149: aload #6
    //   151: ldc 'ts'
    //   153: aload #7
    //   155: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload #6
    //   163: ldc 'scode'
    //   165: aload #8
    //   167: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload #6
    //   175: ldc 'encr'
    //   177: ldc '1'
    //   179: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: aload #5
    //   187: aload #6
    //   189: invokevirtual b : (Ljava/util/Map;)V
    //   192: aload #5
    //   194: invokevirtual r : ()V
    //   197: aload #5
    //   199: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   202: ldc 'platform=Android&sdkversion=%s&product=%s&loc_channel=%s'
    //   204: iconst_3
    //   205: anewarray java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: ldc '4.7.0'
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: ldc 'loc'
    //   217: aastore
    //   218: dup
    //   219: iconst_2
    //   220: iconst_3
    //   221: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   224: aastore
    //   225: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   228: invokevirtual a : (Ljava/lang/String;)V
    //   231: aload #5
    //   233: invokevirtual q : ()V
    //   236: aload #5
    //   238: aload_3
    //   239: invokevirtual b : (Ljava/lang/String;)V
    //   242: aload #5
    //   244: aload_2
    //   245: invokestatic a : ([B)[B
    //   248: invokevirtual b : ([B)V
    //   251: aload #5
    //   253: aload_1
    //   254: invokestatic a : (Landroid/content/Context;)Ljava/net/Proxy;
    //   257: invokevirtual a : (Ljava/net/Proxy;)V
    //   260: new java/util/HashMap
    //   263: dup
    //   264: bipush #16
    //   266: invokespecial <init> : (I)V
    //   269: astore #6
    //   271: aload #6
    //   273: ldc 'output'
    //   275: ldc 'bin'
    //   277: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload #6
    //   285: ldc 'policy'
    //   287: ldc '3103'
    //   289: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: aload_0
    //   296: getfield g : I
    //   299: istore #4
    //   301: iload #4
    //   303: ifeq -> 318
    //   306: iload #4
    //   308: iconst_1
    //   309: if_icmpeq -> 437
    //   312: iload #4
    //   314: iconst_2
    //   315: if_icmpeq -> 431
    //   318: aload #6
    //   320: ldc 'custom'
    //   322: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   327: pop
    //   328: goto -> 345
    //   331: aload #6
    //   333: ldc 'custom'
    //   335: aload_2
    //   336: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: goto -> 345
    //   345: aload #5
    //   347: aload #6
    //   349: invokevirtual a : (Ljava/util/Map;)V
    //   352: aload #5
    //   354: aload_0
    //   355: getfield e : I
    //   358: invokevirtual a : (I)V
    //   361: aload #5
    //   363: aload_0
    //   364: getfield e : I
    //   367: invokevirtual b : (I)V
    //   370: aload_0
    //   371: getfield f : Z
    //   374: ifne -> 387
    //   377: aload #5
    //   379: astore_2
    //   380: aload_1
    //   381: invokestatic e : (Landroid/content/Context;)Z
    //   384: ifeq -> 421
    //   387: aload #5
    //   389: astore_2
    //   390: aload_3
    //   391: ldc 'http:'
    //   393: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   396: ifeq -> 421
    //   399: aload #5
    //   401: aload #5
    //   403: invokevirtual h : ()Ljava/lang/String;
    //   406: ldc 'https:'
    //   408: ldc 'https:'
    //   410: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   413: invokevirtual b : (Ljava/lang/String;)V
    //   416: aload #5
    //   418: areturn
    //   419: aconst_null
    //   420: astore_2
    //   421: aload_2
    //   422: areturn
    //   423: astore_1
    //   424: goto -> 419
    //   427: astore_1
    //   428: aload #5
    //   430: areturn
    //   431: ldc 'language:en'
    //   433: astore_2
    //   434: goto -> 331
    //   437: ldc 'language:cn'
    //   439: astore_2
    //   440: goto -> 331
    // Exception table:
    //   from	to	target	type
    //   0	24	423	finally
    //   24	301	427	finally
    //   318	328	427	finally
    //   331	342	427	finally
    //   345	377	427	finally
    //   380	387	427	finally
    //   390	416	427	finally
  }
  
  public final void a(long paramLong, boolean paramBoolean) {
    try {
      this.f = paramBoolean;
      try {
        cw.a().a(paramBoolean);
      } finally {
        Exception exception;
      } 
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "LocNetManager", "setOption");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */