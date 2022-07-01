package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.a;
import java.util.Map;
import java.util.UUID;

public final class v implements Runnable {
  private int a = 2;
  
  private int b = 30000;
  
  private final Context c;
  
  private final int d;
  
  private final byte[] e;
  
  private final a f;
  
  private final a g;
  
  private final s h;
  
  private final u i;
  
  private final int j;
  
  private final t k;
  
  private final t l;
  
  private String m = null;
  
  private final String n;
  
  private final Map<String, String> o;
  
  private int p = 0;
  
  private long q = 0L;
  
  private long r = 0L;
  
  private boolean s = true;
  
  private boolean t = false;
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, Map<String, String> paramMap) {
    this.c = paramContext;
    this.f = a.a(paramContext);
    this.e = paramArrayOfbyte;
    this.g = a.a();
    this.h = s.a(paramContext);
    this.i = u.a();
    this.j = paramInt1;
    this.m = paramString1;
    this.n = paramString2;
    this.k = paramt;
    u u1 = this.i;
    this.l = null;
    this.s = paramBoolean1;
    this.d = paramInt2;
    if (paramInt3 > 0)
      this.a = paramInt3; 
    if (paramInt4 > 0)
      this.b = paramInt4; 
    this.t = paramBoolean2;
    this.o = paramMap;
  }
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, boolean paramBoolean2) {
    this(paramContext, paramInt1, paramInt2, paramArrayOfbyte, paramString1, paramString2, paramt, paramBoolean1, 2, 30000, paramBoolean2, null);
  }
  
  private static String a(String paramString) {
    if (z.a(paramString))
      return paramString; 
    try {
      return String.format("%s?aid=%s", new Object[] { paramString, UUID.randomUUID().toString() });
    } finally {
      Exception exception = null;
      x.a(exception);
    } 
  }
  
  private void a(aq paramaq, boolean paramBoolean, int paramInt1, String paramString, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : I
    //   4: istore #6
    //   6: iload #6
    //   8: sipush #630
    //   11: if_icmpeq -> 53
    //   14: iload #6
    //   16: sipush #640
    //   19: if_icmpeq -> 47
    //   22: iload #6
    //   24: sipush #830
    //   27: if_icmpeq -> 53
    //   30: iload #6
    //   32: sipush #840
    //   35: if_icmpeq -> 47
    //   38: iload #6
    //   40: invokestatic valueOf : (I)Ljava/lang/String;
    //   43: astore_1
    //   44: goto -> 56
    //   47: ldc 'userinfo'
    //   49: astore_1
    //   50: goto -> 56
    //   53: ldc 'crash'
    //   55: astore_1
    //   56: iload_2
    //   57: ifeq -> 77
    //   60: ldc '[Upload] Success: %s'
    //   62: iconst_1
    //   63: anewarray java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -> 120
    //   77: ldc '[Upload] Failed to upload(%d) %s: %s'
    //   79: iconst_3
    //   80: anewarray java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: iload_3
    //   86: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload_1
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: aload #4
    //   98: aastore
    //   99: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   102: pop
    //   103: aload_0
    //   104: getfield s : Z
    //   107: ifeq -> 120
    //   110: aload_0
    //   111: getfield i : Lcom/tencent/bugly/proguard/u;
    //   114: iload #5
    //   116: aconst_null
    //   117: invokevirtual a : (ILcom/tencent/bugly/proguard/aq;)V
    //   120: aload_0
    //   121: getfield q : J
    //   124: aload_0
    //   125: getfield r : J
    //   128: ladd
    //   129: lconst_0
    //   130: lcmp
    //   131: ifle -> 178
    //   134: aload_0
    //   135: getfield i : Lcom/tencent/bugly/proguard/u;
    //   138: aload_0
    //   139: getfield t : Z
    //   142: invokevirtual a : (Z)J
    //   145: lstore #7
    //   147: aload_0
    //   148: getfield q : J
    //   151: lstore #9
    //   153: aload_0
    //   154: getfield r : J
    //   157: lstore #11
    //   159: aload_0
    //   160: getfield i : Lcom/tencent/bugly/proguard/u;
    //   163: lload #7
    //   165: lload #9
    //   167: ladd
    //   168: lload #11
    //   170: ladd
    //   171: aload_0
    //   172: getfield t : Z
    //   175: invokevirtual a : (JZ)V
    //   178: aload_0
    //   179: getfield k : Lcom/tencent/bugly/proguard/t;
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull -> 211
    //   187: aload_0
    //   188: getfield d : I
    //   191: istore_3
    //   192: aload_0
    //   193: getfield q : J
    //   196: lstore #7
    //   198: aload_0
    //   199: getfield r : J
    //   202: lstore #7
    //   204: aload_1
    //   205: iload_2
    //   206: invokeinterface a : (Z)V
    //   211: aload_0
    //   212: getfield l : Lcom/tencent/bugly/proguard/t;
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull -> 244
    //   220: aload_0
    //   221: getfield d : I
    //   224: istore_3
    //   225: aload_0
    //   226: getfield q : J
    //   229: lstore #7
    //   231: aload_0
    //   232: getfield r : J
    //   235: lstore #7
    //   237: aload_1
    //   238: iload_2
    //   239: invokeinterface a : (Z)V
    //   244: return
  }
  
  private static boolean a(aq paramaq, a parama, a parama1) {
    if (paramaq == null) {
      x.d("resp == null!", new Object[0]);
      return false;
    } 
    if (paramaq.a != 0) {
      x.e("resp result error %d", new Object[] { Byte.valueOf(paramaq.a) });
      return false;
    } 
    try {
      boolean bool = z.a(paramaq.d);
      if (!bool && !a.b().i().equals(paramaq.d)) {
        p.a().a(a.a, "gateway", paramaq.d.getBytes("UTF-8"), (o)null, true);
        parama.d(paramaq.d);
      } 
    } finally {
      Exception exception = null;
    } 
    parama.j = paramaq.e;
    if (paramaq.b == 510) {
      if (paramaq.c == null) {
        x.e("[Upload] Strategy data is null. Response cmd: %d", new Object[] { Integer.valueOf(paramaq.b) });
        return false;
      } 
      as as = a.<as>a(paramaq.c, as.class);
      if (as == null) {
        x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", new Object[] { Integer.valueOf(paramaq.b) });
        return false;
      } 
      parama1.a(as);
    } 
    return true;
  }
  
  public final void a(long paramLong) {
    this.p++;
    this.q += paramLong;
  }
  
  public final void b(long paramLong) {
    this.r += paramLong;
  }
  
  public final void run() {
    // Byte code:
    //   0: ldc_w 'Bugly-Version'
    //   3: astore #14
    //   5: iconst_0
    //   6: istore #5
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield p : I
    //   13: aload_0
    //   14: lconst_0
    //   15: putfield q : J
    //   18: aload_0
    //   19: lconst_0
    //   20: putfield r : J
    //   23: aload_0
    //   24: getfield e : [B
    //   27: astore #13
    //   29: aload_0
    //   30: getfield c : Landroid/content/Context;
    //   33: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   36: ifnonnull -> 51
    //   39: aload_0
    //   40: aconst_null
    //   41: iconst_0
    //   42: iconst_0
    //   43: ldc_w 'network is not available'
    //   46: iconst_0
    //   47: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   50: return
    //   51: aload #13
    //   53: ifnull -> 1636
    //   56: aload #13
    //   58: arraylength
    //   59: ifne -> 65
    //   62: goto -> 1636
    //   65: ldc_w '[Upload] Run upload task with cmd: %d'
    //   68: iconst_1
    //   69: anewarray java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield d : I
    //   78: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   81: aastore
    //   82: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   85: pop
    //   86: aload_0
    //   87: getfield c : Landroid/content/Context;
    //   90: ifnull -> 1624
    //   93: aload_0
    //   94: getfield f : Lcom/tencent/bugly/crashreport/common/info/a;
    //   97: ifnull -> 1624
    //   100: aload_0
    //   101: getfield g : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   104: ifnull -> 1624
    //   107: aload_0
    //   108: getfield h : Lcom/tencent/bugly/proguard/s;
    //   111: ifnonnull -> 117
    //   114: goto -> 1624
    //   117: aload_0
    //   118: getfield g : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   121: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   124: astore #15
    //   126: aload #15
    //   128: ifnonnull -> 143
    //   131: aload_0
    //   132: aconst_null
    //   133: iconst_0
    //   134: iconst_0
    //   135: ldc_w 'illegal local strategy'
    //   138: iconst_0
    //   139: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   142: return
    //   143: new java/util/HashMap
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #17
    //   152: aload #17
    //   154: ldc_w 'prodId'
    //   157: aload_0
    //   158: getfield f : Lcom/tencent/bugly/crashreport/common/info/a;
    //   161: invokevirtual f : ()Ljava/lang/String;
    //   164: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: aload #17
    //   172: ldc_w 'bundleId'
    //   175: aload_0
    //   176: getfield f : Lcom/tencent/bugly/crashreport/common/info/a;
    //   179: getfield c : Ljava/lang/String;
    //   182: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: aload #17
    //   190: ldc_w 'appVer'
    //   193: aload_0
    //   194: getfield f : Lcom/tencent/bugly/crashreport/common/info/a;
    //   197: getfield k : Ljava/lang/String;
    //   200: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload_0
    //   207: getfield o : Ljava/util/Map;
    //   210: ifnull -> 224
    //   213: aload #17
    //   215: aload_0
    //   216: getfield o : Ljava/util/Map;
    //   219: invokeinterface putAll : (Ljava/util/Map;)V
    //   224: aload #13
    //   226: astore #16
    //   228: aload_0
    //   229: getfield s : Z
    //   232: ifeq -> 386
    //   235: aload #17
    //   237: ldc_w 'cmd'
    //   240: aload_0
    //   241: getfield d : I
    //   244: invokestatic toString : (I)Ljava/lang/String;
    //   247: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: aload #17
    //   255: ldc_w 'platformId'
    //   258: iconst_1
    //   259: invokestatic toString : (B)Ljava/lang/String;
    //   262: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: aload #17
    //   270: ldc_w 'sdkVer'
    //   273: aload_0
    //   274: getfield f : Lcom/tencent/bugly/crashreport/common/info/a;
    //   277: getfield f : Ljava/lang/String;
    //   280: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: aload #17
    //   288: ldc_w 'strategylastUpdateTime'
    //   291: aload #15
    //   293: getfield p : J
    //   296: invokestatic toString : (J)Ljava/lang/String;
    //   299: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   304: pop
    //   305: aload_0
    //   306: getfield i : Lcom/tencent/bugly/proguard/u;
    //   309: aload #17
    //   311: invokevirtual a : (Ljava/util/Map;)Z
    //   314: ifne -> 329
    //   317: aload_0
    //   318: aconst_null
    //   319: iconst_0
    //   320: iconst_0
    //   321: ldc_w 'failed to add security info to HTTP headers'
    //   324: iconst_0
    //   325: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   328: return
    //   329: aload #13
    //   331: iconst_2
    //   332: invokestatic a : ([BI)[B
    //   335: astore #13
    //   337: aload #13
    //   339: ifnonnull -> 354
    //   342: aload_0
    //   343: aconst_null
    //   344: iconst_0
    //   345: iconst_0
    //   346: ldc_w 'failed to zip request body'
    //   349: iconst_0
    //   350: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   353: return
    //   354: aload_0
    //   355: getfield i : Lcom/tencent/bugly/proguard/u;
    //   358: aload #13
    //   360: invokevirtual a : ([B)[B
    //   363: astore #13
    //   365: aload #13
    //   367: astore #16
    //   369: aload #13
    //   371: ifnonnull -> 386
    //   374: aload_0
    //   375: aconst_null
    //   376: iconst_0
    //   377: iconst_0
    //   378: ldc_w 'failed to encrypt request body'
    //   381: iconst_0
    //   382: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   385: return
    //   386: aload_0
    //   387: getfield i : Lcom/tencent/bugly/proguard/u;
    //   390: aload_0
    //   391: getfield j : I
    //   394: invokestatic currentTimeMillis : ()J
    //   397: invokevirtual a : (IJ)V
    //   400: aload_0
    //   401: getfield k : Lcom/tencent/bugly/proguard/t;
    //   404: ifnull -> 418
    //   407: aload_0
    //   408: getfield k : Lcom/tencent/bugly/proguard/t;
    //   411: astore #13
    //   413: aload_0
    //   414: getfield d : I
    //   417: istore_1
    //   418: aload_0
    //   419: getfield l : Lcom/tencent/bugly/proguard/t;
    //   422: ifnull -> 436
    //   425: aload_0
    //   426: getfield l : Lcom/tencent/bugly/proguard/t;
    //   429: astore #13
    //   431: aload_0
    //   432: getfield d : I
    //   435: istore_1
    //   436: aload_0
    //   437: getfield m : Ljava/lang/String;
    //   440: astore #13
    //   442: iconst_0
    //   443: istore_2
    //   444: iconst_0
    //   445: istore_3
    //   446: iconst_m1
    //   447: istore_1
    //   448: iload_2
    //   449: iconst_1
    //   450: iadd
    //   451: istore #4
    //   453: iload_2
    //   454: aload_0
    //   455: getfield a : I
    //   458: if_icmpge -> 1612
    //   461: aload #13
    //   463: astore #15
    //   465: iload #4
    //   467: iconst_1
    //   468: if_icmple -> 535
    //   471: ldc_w '[Upload] Failed to upload last time, wait and try(%d) again.'
    //   474: iconst_1
    //   475: anewarray java/lang/Object
    //   478: dup
    //   479: iconst_0
    //   480: iload #4
    //   482: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   485: aastore
    //   486: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   489: pop
    //   490: aload_0
    //   491: getfield b : I
    //   494: i2l
    //   495: invokestatic b : (J)V
    //   498: aload #13
    //   500: astore #15
    //   502: iload #4
    //   504: aload_0
    //   505: getfield a : I
    //   508: if_icmpne -> 535
    //   511: ldc_w '[Upload] Use the back-up url at the last time: %s'
    //   514: iconst_1
    //   515: anewarray java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: aload_0
    //   521: getfield n : Ljava/lang/String;
    //   524: aastore
    //   525: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   528: pop
    //   529: aload_0
    //   530: getfield n : Ljava/lang/String;
    //   533: astore #15
    //   535: ldc_w '[Upload] Send %d bytes'
    //   538: iconst_1
    //   539: anewarray java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload #16
    //   546: arraylength
    //   547: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   550: aastore
    //   551: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   554: pop
    //   555: aload #15
    //   557: astore #13
    //   559: aload_0
    //   560: getfield s : Z
    //   563: ifeq -> 573
    //   566: aload #15
    //   568: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   571: astore #13
    //   573: ldc_w '[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).'
    //   576: iconst_4
    //   577: anewarray java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload #13
    //   584: aastore
    //   585: dup
    //   586: iconst_1
    //   587: aload_0
    //   588: getfield d : I
    //   591: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   594: aastore
    //   595: dup
    //   596: iconst_2
    //   597: invokestatic myPid : ()I
    //   600: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   603: aastore
    //   604: dup
    //   605: iconst_3
    //   606: invokestatic myTid : ()I
    //   609: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   612: aastore
    //   613: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   616: pop
    //   617: aload_0
    //   618: getfield h : Lcom/tencent/bugly/proguard/s;
    //   621: aload #13
    //   623: aload #16
    //   625: aload_0
    //   626: aload #17
    //   628: invokevirtual a : (Ljava/lang/String;[BLcom/tencent/bugly/proguard/v;Ljava/util/Map;)[B
    //   631: astore #15
    //   633: aload #15
    //   635: ifnonnull -> 670
    //   638: ldc_w '[Upload] Failed to upload(%d): %s'
    //   641: iconst_2
    //   642: anewarray java/lang/Object
    //   645: dup
    //   646: iconst_0
    //   647: iconst_1
    //   648: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   651: aastore
    //   652: dup
    //   653: iconst_1
    //   654: ldc_w 'Failed to upload for no response!'
    //   657: aastore
    //   658: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: iload #4
    //   664: istore_2
    //   665: iconst_1
    //   666: istore_3
    //   667: goto -> 448
    //   670: aload_0
    //   671: getfield h : Lcom/tencent/bugly/proguard/s;
    //   674: getfield a : Ljava/util/Map;
    //   677: astore #18
    //   679: aload_0
    //   680: getfield s : Z
    //   683: istore #6
    //   685: iload #6
    //   687: ifeq -> 1695
    //   690: aload #18
    //   692: ifnull -> 841
    //   695: aload #18
    //   697: invokeinterface size : ()I
    //   702: ifne -> 708
    //   705: goto -> 841
    //   708: aload #18
    //   710: ldc_w 'status'
    //   713: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   718: istore #6
    //   720: iload #6
    //   722: ifne -> 745
    //   725: ldc_w '[Upload] Headers does not contain %s'
    //   728: iconst_1
    //   729: anewarray java/lang/Object
    //   732: dup
    //   733: iconst_0
    //   734: ldc_w 'status'
    //   737: aastore
    //   738: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   741: pop
    //   742: goto -> 1674
    //   745: aload #18
    //   747: aload #14
    //   749: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   754: ifne -> 776
    //   757: ldc_w '[Upload] Headers does not contain %s'
    //   760: iconst_1
    //   761: anewarray java/lang/Object
    //   764: dup
    //   765: iconst_0
    //   766: aload #14
    //   768: aastore
    //   769: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   772: pop
    //   773: goto -> 1674
    //   776: aload #18
    //   778: aload #14
    //   780: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   785: checkcast java/lang/String
    //   788: astore #19
    //   790: aload #19
    //   792: ldc_w 'bugly'
    //   795: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   798: ifne -> 820
    //   801: ldc_w '[Upload] Bugly version is not valid: %s'
    //   804: iconst_1
    //   805: anewarray java/lang/Object
    //   808: dup
    //   809: iconst_0
    //   810: aload #19
    //   812: aastore
    //   813: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   816: pop
    //   817: goto -> 1674
    //   820: ldc_w '[Upload] Bugly version from headers is: %s'
    //   823: iconst_1
    //   824: anewarray java/lang/Object
    //   827: dup
    //   828: iconst_0
    //   829: aload #19
    //   831: aastore
    //   832: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   835: pop
    //   836: iconst_1
    //   837: istore_2
    //   838: goto -> 855
    //   841: ldc_w '[Upload] Headers is empty.'
    //   844: iconst_0
    //   845: anewarray java/lang/Object
    //   848: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   851: pop
    //   852: goto -> 1674
    //   855: iload_2
    //   856: ifne -> 1008
    //   859: ldc_w '[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).'
    //   862: iconst_2
    //   863: anewarray java/lang/Object
    //   866: dup
    //   867: iconst_0
    //   868: invokestatic myPid : ()I
    //   871: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   874: aastore
    //   875: dup
    //   876: iconst_1
    //   877: invokestatic myTid : ()I
    //   880: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   883: aastore
    //   884: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   887: pop
    //   888: ldc_w '[Upload] Failed to upload(%d): %s'
    //   891: iconst_2
    //   892: anewarray java/lang/Object
    //   895: dup
    //   896: iconst_0
    //   897: iconst_1
    //   898: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   901: aastore
    //   902: dup
    //   903: iconst_1
    //   904: ldc_w '[Upload] Failed to upload for no status header.'
    //   907: aastore
    //   908: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   911: pop
    //   912: aload #18
    //   914: ifnull -> 994
    //   917: aload #18
    //   919: invokeinterface entrySet : ()Ljava/util/Set;
    //   924: invokeinterface iterator : ()Ljava/util/Iterator;
    //   929: astore #15
    //   931: aload #15
    //   933: invokeinterface hasNext : ()Z
    //   938: ifeq -> 994
    //   941: aload #15
    //   943: invokeinterface next : ()Ljava/lang/Object;
    //   948: checkcast java/util/Map$Entry
    //   951: astore #18
    //   953: ldc_w '[key]: %s, [value]: %s'
    //   956: iconst_2
    //   957: anewarray java/lang/Object
    //   960: dup
    //   961: iconst_0
    //   962: aload #18
    //   964: invokeinterface getKey : ()Ljava/lang/Object;
    //   969: aastore
    //   970: dup
    //   971: iconst_1
    //   972: aload #18
    //   974: invokeinterface getValue : ()Ljava/lang/Object;
    //   979: aastore
    //   980: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   983: iconst_0
    //   984: anewarray java/lang/Object
    //   987: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   990: pop
    //   991: goto -> 931
    //   994: ldc_w '[Upload] Failed to upload for no status header.'
    //   997: iconst_0
    //   998: anewarray java/lang/Object
    //   1001: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1004: pop
    //   1005: goto -> 1687
    //   1008: aload #18
    //   1010: ldc_w 'status'
    //   1013: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1018: checkcast java/lang/String
    //   1021: invokestatic parseInt : (Ljava/lang/String;)I
    //   1024: istore_2
    //   1025: ldc_w '[Upload] Status from server is %d (pid=%d | tid=%d).'
    //   1028: iconst_3
    //   1029: anewarray java/lang/Object
    //   1032: dup
    //   1033: iconst_0
    //   1034: iload_2
    //   1035: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1038: aastore
    //   1039: dup
    //   1040: iconst_1
    //   1041: invokestatic myPid : ()I
    //   1044: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_2
    //   1050: invokestatic myTid : ()I
    //   1053: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1056: aastore
    //   1057: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1060: pop
    //   1061: iload_2
    //   1062: istore_1
    //   1063: iload_2
    //   1064: ifeq -> 1297
    //   1067: iload_2
    //   1068: iconst_2
    //   1069: if_icmpne -> 1213
    //   1072: aload_0
    //   1073: getfield q : J
    //   1076: aload_0
    //   1077: getfield r : J
    //   1080: ladd
    //   1081: lconst_0
    //   1082: lcmp
    //   1083: ifle -> 1130
    //   1086: aload_0
    //   1087: getfield i : Lcom/tencent/bugly/proguard/u;
    //   1090: aload_0
    //   1091: getfield t : Z
    //   1094: invokevirtual a : (Z)J
    //   1097: lstore #7
    //   1099: aload_0
    //   1100: getfield q : J
    //   1103: lstore #9
    //   1105: aload_0
    //   1106: getfield r : J
    //   1109: lstore #11
    //   1111: aload_0
    //   1112: getfield i : Lcom/tencent/bugly/proguard/u;
    //   1115: lload #7
    //   1117: lload #9
    //   1119: ladd
    //   1120: lload #11
    //   1122: ladd
    //   1123: aload_0
    //   1124: getfield t : Z
    //   1127: invokevirtual a : (JZ)V
    //   1130: aload_0
    //   1131: getfield i : Lcom/tencent/bugly/proguard/u;
    //   1134: iload_2
    //   1135: aconst_null
    //   1136: invokevirtual a : (ILcom/tencent/bugly/proguard/aq;)V
    //   1139: ldc_w '[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).'
    //   1142: iconst_2
    //   1143: anewarray java/lang/Object
    //   1146: dup
    //   1147: iconst_0
    //   1148: invokestatic myPid : ()I
    //   1151: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1154: aastore
    //   1155: dup
    //   1156: iconst_1
    //   1157: invokestatic myTid : ()I
    //   1160: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1163: aastore
    //   1164: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield i : Lcom/tencent/bugly/proguard/u;
    //   1172: aload_0
    //   1173: getfield j : I
    //   1176: aload_0
    //   1177: getfield d : I
    //   1180: aload_0
    //   1181: getfield e : [B
    //   1184: aload_0
    //   1185: getfield m : Ljava/lang/String;
    //   1188: aload_0
    //   1189: getfield n : Ljava/lang/String;
    //   1192: aload_0
    //   1193: getfield k : Lcom/tencent/bugly/proguard/t;
    //   1196: aload_0
    //   1197: getfield a : I
    //   1200: aload_0
    //   1201: getfield b : I
    //   1204: iconst_1
    //   1205: aload_0
    //   1206: getfield o : Ljava/util/Map;
    //   1209: invokevirtual a : (II[BLjava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/proguard/t;IIZLjava/util/Map;)V
    //   1212: return
    //   1213: new java/lang/StringBuilder
    //   1216: dup
    //   1217: ldc_w 'status of server is '
    //   1220: invokespecial <init> : (Ljava/lang/String;)V
    //   1223: astore #13
    //   1225: aload #13
    //   1227: iload_2
    //   1228: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload_0
    //   1233: aconst_null
    //   1234: iconst_0
    //   1235: iconst_1
    //   1236: aload #13
    //   1238: invokevirtual toString : ()Ljava/lang/String;
    //   1241: iload_2
    //   1242: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1245: return
    //   1246: new java/lang/StringBuilder
    //   1249: dup
    //   1250: ldc_w '[Upload] Failed to upload for format of status header is invalid: '
    //   1253: invokespecial <init> : (Ljava/lang/String;)V
    //   1256: astore #15
    //   1258: aload #15
    //   1260: iload_1
    //   1261: invokestatic toString : (I)Ljava/lang/String;
    //   1264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: ldc_w '[Upload] Failed to upload(%d): %s'
    //   1271: iconst_2
    //   1272: anewarray java/lang/Object
    //   1275: dup
    //   1276: iconst_0
    //   1277: iconst_1
    //   1278: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1281: aastore
    //   1282: dup
    //   1283: iconst_1
    //   1284: aload #15
    //   1286: invokevirtual toString : ()Ljava/lang/String;
    //   1289: aastore
    //   1290: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1293: pop
    //   1294: goto -> 1687
    //   1297: ldc_w '[Upload] Received %d bytes'
    //   1300: iconst_1
    //   1301: anewarray java/lang/Object
    //   1304: dup
    //   1305: iconst_0
    //   1306: aload #15
    //   1308: arraylength
    //   1309: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1312: aastore
    //   1313: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1316: pop
    //   1317: aload #15
    //   1319: astore #13
    //   1321: aload_0
    //   1322: getfield s : Z
    //   1325: ifeq -> 1473
    //   1328: aload #15
    //   1330: arraylength
    //   1331: ifne -> 1416
    //   1334: aload #18
    //   1336: invokeinterface entrySet : ()Ljava/util/Set;
    //   1341: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1346: astore #13
    //   1348: aload #13
    //   1350: invokeinterface hasNext : ()Z
    //   1355: ifeq -> 1404
    //   1358: aload #13
    //   1360: invokeinterface next : ()Ljava/lang/Object;
    //   1365: checkcast java/util/Map$Entry
    //   1368: astore #14
    //   1370: ldc_w '[Upload] HTTP headers from server: key = %s, value = %s'
    //   1373: iconst_2
    //   1374: anewarray java/lang/Object
    //   1377: dup
    //   1378: iconst_0
    //   1379: aload #14
    //   1381: invokeinterface getKey : ()Ljava/lang/Object;
    //   1386: aastore
    //   1387: dup
    //   1388: iconst_1
    //   1389: aload #14
    //   1391: invokeinterface getValue : ()Ljava/lang/Object;
    //   1396: aastore
    //   1397: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1400: pop
    //   1401: goto -> 1348
    //   1404: aload_0
    //   1405: aconst_null
    //   1406: iconst_0
    //   1407: iconst_1
    //   1408: ldc_w 'response data from server is empty'
    //   1411: iconst_0
    //   1412: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1415: return
    //   1416: aload_0
    //   1417: getfield i : Lcom/tencent/bugly/proguard/u;
    //   1420: aload #15
    //   1422: invokevirtual b : ([B)[B
    //   1425: astore #13
    //   1427: aload #13
    //   1429: ifnonnull -> 1444
    //   1432: aload_0
    //   1433: aconst_null
    //   1434: iconst_0
    //   1435: iconst_1
    //   1436: ldc_w 'failed to decrypt response from server'
    //   1439: iconst_0
    //   1440: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1443: return
    //   1444: aload #13
    //   1446: iconst_2
    //   1447: invokestatic b : ([BI)[B
    //   1450: astore #14
    //   1452: aload #14
    //   1454: astore #13
    //   1456: aload #14
    //   1458: ifnonnull -> 1473
    //   1461: aload_0
    //   1462: aconst_null
    //   1463: iconst_0
    //   1464: iconst_1
    //   1465: ldc_w 'failed unzip(Gzip) response from server'
    //   1468: iconst_0
    //   1469: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1472: return
    //   1473: aload #13
    //   1475: aload_0
    //   1476: getfield s : Z
    //   1479: invokestatic a : ([BZ)Lcom/tencent/bugly/proguard/aq;
    //   1482: astore #13
    //   1484: aload #13
    //   1486: ifnonnull -> 1501
    //   1489: aload_0
    //   1490: aconst_null
    //   1491: iconst_0
    //   1492: iconst_1
    //   1493: ldc_w 'failed to decode response package'
    //   1496: iconst_0
    //   1497: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1500: return
    //   1501: aload_0
    //   1502: getfield s : Z
    //   1505: ifeq -> 1518
    //   1508: aload_0
    //   1509: getfield i : Lcom/tencent/bugly/proguard/u;
    //   1512: iload_1
    //   1513: aload #13
    //   1515: invokevirtual a : (ILcom/tencent/bugly/proguard/aq;)V
    //   1518: aload #13
    //   1520: getfield b : I
    //   1523: istore_2
    //   1524: aload #13
    //   1526: getfield c : [B
    //   1529: ifnonnull -> 1538
    //   1532: iload #5
    //   1534: istore_1
    //   1535: goto -> 1545
    //   1538: aload #13
    //   1540: getfield c : [B
    //   1543: arraylength
    //   1544: istore_1
    //   1545: ldc_w '[Upload] Response cmd is: %d, length of sBuffer is: %d'
    //   1548: iconst_2
    //   1549: anewarray java/lang/Object
    //   1552: dup
    //   1553: iconst_0
    //   1554: iload_2
    //   1555: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1558: aastore
    //   1559: dup
    //   1560: iconst_1
    //   1561: iload_1
    //   1562: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1565: aastore
    //   1566: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1569: pop
    //   1570: aload #13
    //   1572: aload_0
    //   1573: getfield f : Lcom/tencent/bugly/crashreport/common/info/a;
    //   1576: aload_0
    //   1577: getfield g : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   1580: invokestatic a : (Lcom/tencent/bugly/proguard/aq;Lcom/tencent/bugly/crashreport/common/info/a;Lcom/tencent/bugly/crashreport/common/strategy/a;)Z
    //   1583: ifne -> 1599
    //   1586: aload_0
    //   1587: aload #13
    //   1589: iconst_0
    //   1590: iconst_2
    //   1591: ldc_w 'failed to process response package'
    //   1594: iconst_0
    //   1595: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1598: return
    //   1599: aload_0
    //   1600: aload #13
    //   1602: iconst_1
    //   1603: iconst_2
    //   1604: ldc_w 'successfully uploaded'
    //   1607: iconst_0
    //   1608: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1611: return
    //   1612: aload_0
    //   1613: aconst_null
    //   1614: iconst_0
    //   1615: iload_3
    //   1616: ldc_w 'failed after many attempts'
    //   1619: iconst_0
    //   1620: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1623: return
    //   1624: aload_0
    //   1625: aconst_null
    //   1626: iconst_0
    //   1627: iconst_0
    //   1628: ldc_w 'illegal access error'
    //   1631: iconst_0
    //   1632: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1635: return
    //   1636: aload_0
    //   1637: aconst_null
    //   1638: iconst_0
    //   1639: iconst_0
    //   1640: ldc_w 'request package is empty!'
    //   1643: iconst_0
    //   1644: invokespecial a : (Lcom/tencent/bugly/proguard/aq;ZILjava/lang/String;I)V
    //   1647: return
    //   1648: astore #13
    //   1650: aload #13
    //   1652: invokestatic a : (Ljava/lang/Throwable;)Z
    //   1655: ifne -> 1663
    //   1658: aload #13
    //   1660: invokevirtual printStackTrace : ()V
    //   1663: return
    //   1664: astore #15
    //   1666: goto -> 1684
    //   1669: astore #15
    //   1671: goto -> 1679
    //   1674: iconst_0
    //   1675: istore_2
    //   1676: goto -> 855
    //   1679: iload_2
    //   1680: istore_1
    //   1681: goto -> 1246
    //   1684: goto -> 1246
    //   1687: iload #4
    //   1689: istore_2
    //   1690: iconst_1
    //   1691: istore_3
    //   1692: goto -> 448
    //   1695: goto -> 1297
    // Exception table:
    //   from	to	target	type
    //   8	50	1648	finally
    //   56	62	1648	finally
    //   65	114	1648	finally
    //   117	126	1648	finally
    //   131	142	1648	finally
    //   143	224	1648	finally
    //   228	328	1648	finally
    //   329	337	1648	finally
    //   342	353	1648	finally
    //   354	365	1648	finally
    //   374	385	1648	finally
    //   386	418	1648	finally
    //   418	436	1648	finally
    //   436	442	1648	finally
    //   453	461	1648	finally
    //   471	498	1648	finally
    //   502	535	1648	finally
    //   535	555	1648	finally
    //   559	573	1648	finally
    //   573	633	1648	finally
    //   638	662	1648	finally
    //   670	685	1648	finally
    //   695	705	1648	finally
    //   708	720	1648	finally
    //   725	742	1648	finally
    //   745	773	1648	finally
    //   776	817	1648	finally
    //   820	836	1648	finally
    //   841	852	1648	finally
    //   859	912	1648	finally
    //   917	931	1648	finally
    //   931	991	1648	finally
    //   994	1005	1648	finally
    //   1008	1025	1664	finally
    //   1025	1061	1669	finally
    //   1072	1130	1648	finally
    //   1130	1212	1648	finally
    //   1213	1245	1648	finally
    //   1246	1294	1648	finally
    //   1297	1317	1648	finally
    //   1321	1348	1648	finally
    //   1348	1401	1648	finally
    //   1404	1415	1648	finally
    //   1416	1427	1648	finally
    //   1432	1443	1648	finally
    //   1444	1452	1648	finally
    //   1461	1472	1648	finally
    //   1473	1484	1648	finally
    //   1489	1500	1648	finally
    //   1501	1518	1648	finally
    //   1518	1532	1648	finally
    //   1538	1545	1648	finally
    //   1545	1598	1648	finally
    //   1599	1611	1648	finally
    //   1612	1623	1648	finally
    //   1624	1635	1648	finally
    //   1636	1647	1648	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */