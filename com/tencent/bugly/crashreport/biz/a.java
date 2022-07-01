package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

public final class a {
  private Context a;
  
  private long b;
  
  private int c;
  
  private boolean d = true;
  
  public a(Context paramContext, boolean paramBoolean) {
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean) {
    if (paramUserInfoBean == null)
      return null; 
    try {
      ContentValues contentValues = new ContentValues();
      if (paramUserInfoBean.a > 0L)
        contentValues.put("_id", Long.valueOf(paramUserInfoBean.a)); 
      contentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
      contentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
      contentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
      return contentValues;
    } finally {
      paramUserInfoBean = null;
      if (!x.a((Throwable)paramUserInfoBean))
        paramUserInfoBean.printStackTrace(); 
    } 
  }
  
  private static UserInfoBean a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null)
        return null; 
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      return userInfoBean;
    } finally {
      paramCursor = null;
      if (!x.a((Throwable)paramCursor))
        paramCursor.printStackTrace(); 
    } 
  }
  
  private static void a(List<UserInfoBean> paramList) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < paramList.size() && i < 50; i++) {
        UserInfoBean userInfoBean = paramList.get(i);
        stringBuilder.append(" or _id");
        stringBuilder.append(" = ");
        stringBuilder.append(userInfoBean.a);
      } 
      String str2 = stringBuilder.toString();
      String str1 = str2;
      if (str2.length() > 0)
        str1 = str2.substring(4); 
      stringBuilder.setLength(0);
      try {
        return;
      } finally {
        str1 = null;
      } 
    } 
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: istore #5
    //   8: iload #5
    //   10: ifne -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   19: astore #8
    //   21: aload #8
    //   23: ifnonnull -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   32: astore #6
    //   34: aload #6
    //   36: ifnonnull -> 42
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload #6
    //   44: invokevirtual b : ()Z
    //   47: ifeq -> 68
    //   50: aload #8
    //   52: sipush #1001
    //   55: invokevirtual b : (I)Z
    //   58: istore #5
    //   60: iload #5
    //   62: ifne -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: getfield a : Landroid/content/Context;
    //   72: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   75: getfield d : Ljava/lang/String;
    //   78: astore #6
    //   80: new java/util/ArrayList
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: astore #9
    //   89: aload_0
    //   90: aload #6
    //   92: invokevirtual a : (Ljava/lang/String;)Ljava/util/List;
    //   95: astore #7
    //   97: aload #7
    //   99: ifnull -> 413
    //   102: aload #7
    //   104: invokeinterface size : ()I
    //   109: bipush #20
    //   111: isub
    //   112: istore #4
    //   114: iload #4
    //   116: ifle -> 256
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: aload #7
    //   124: invokeinterface size : ()I
    //   129: iconst_1
    //   130: isub
    //   131: if_icmpge -> 732
    //   134: iload_1
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: iload_2
    //   139: istore_3
    //   140: iload_3
    //   141: aload #7
    //   143: invokeinterface size : ()I
    //   148: if_icmpge -> 727
    //   151: aload #7
    //   153: iload_1
    //   154: invokeinterface get : (I)Ljava/lang/Object;
    //   159: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   162: getfield e : J
    //   165: aload #7
    //   167: iload_3
    //   168: invokeinterface get : (I)Ljava/lang/Object;
    //   173: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   176: getfield e : J
    //   179: lcmp
    //   180: ifle -> 720
    //   183: aload #7
    //   185: iload_1
    //   186: invokeinterface get : (I)Ljava/lang/Object;
    //   191: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   194: astore #6
    //   196: aload #7
    //   198: iload_1
    //   199: aload #7
    //   201: iload_3
    //   202: invokeinterface get : (I)Ljava/lang/Object;
    //   207: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload #7
    //   215: iload_3
    //   216: aload #6
    //   218: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   223: pop
    //   224: goto -> 720
    //   227: iload_1
    //   228: iload #4
    //   230: if_icmpge -> 256
    //   233: aload #9
    //   235: aload #7
    //   237: iload_1
    //   238: invokeinterface get : (I)Ljava/lang/Object;
    //   243: invokeinterface add : (Ljava/lang/Object;)Z
    //   248: pop
    //   249: iload_1
    //   250: iconst_1
    //   251: iadd
    //   252: istore_1
    //   253: goto -> 227
    //   256: aload #7
    //   258: invokeinterface iterator : ()Ljava/util/Iterator;
    //   263: astore #6
    //   265: iconst_0
    //   266: istore_1
    //   267: aload #6
    //   269: invokeinterface hasNext : ()Z
    //   274: ifeq -> 376
    //   277: aload #6
    //   279: invokeinterface next : ()Ljava/lang/Object;
    //   284: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   287: astore #10
    //   289: aload #10
    //   291: getfield f : J
    //   294: ldc2_w -1
    //   297: lcmp
    //   298: ifeq -> 330
    //   301: aload #6
    //   303: invokeinterface remove : ()V
    //   308: aload #10
    //   310: getfield e : J
    //   313: invokestatic b : ()J
    //   316: lcmp
    //   317: ifge -> 330
    //   320: aload #9
    //   322: aload #10
    //   324: invokeinterface add : (Ljava/lang/Object;)Z
    //   329: pop
    //   330: aload #10
    //   332: getfield e : J
    //   335: invokestatic currentTimeMillis : ()J
    //   338: ldc2_w 600000
    //   341: lsub
    //   342: lcmp
    //   343: ifle -> 267
    //   346: aload #10
    //   348: getfield b : I
    //   351: iconst_1
    //   352: if_icmpeq -> 737
    //   355: aload #10
    //   357: getfield b : I
    //   360: iconst_4
    //   361: if_icmpeq -> 737
    //   364: aload #10
    //   366: getfield b : I
    //   369: iconst_3
    //   370: if_icmpne -> 267
    //   373: goto -> 737
    //   376: aload #7
    //   378: astore #6
    //   380: iload_1
    //   381: bipush #15
    //   383: if_icmple -> 744
    //   386: ldc_w '[UserInfo] Upload user info too many times in 10 min: %d'
    //   389: iconst_1
    //   390: anewarray java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: iload_1
    //   396: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   399: aastore
    //   400: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   403: pop
    //   404: iconst_0
    //   405: istore_1
    //   406: aload #7
    //   408: astore #6
    //   410: goto -> 425
    //   413: new java/util/ArrayList
    //   416: dup
    //   417: invokespecial <init> : ()V
    //   420: astore #6
    //   422: goto -> 744
    //   425: aload #9
    //   427: invokeinterface size : ()I
    //   432: ifle -> 440
    //   435: aload #9
    //   437: invokestatic a : (Ljava/util/List;)V
    //   440: iload_1
    //   441: ifeq -> 699
    //   444: aload #6
    //   446: invokeinterface size : ()I
    //   451: ifne -> 457
    //   454: goto -> 699
    //   457: ldc_w '[UserInfo] Upload user info(size: %d)'
    //   460: iconst_1
    //   461: anewarray java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload #6
    //   468: invokeinterface size : ()I
    //   473: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   476: aastore
    //   477: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   480: pop
    //   481: aload_0
    //   482: getfield c : I
    //   485: iconst_1
    //   486: if_icmpne -> 749
    //   489: iconst_1
    //   490: istore_1
    //   491: goto -> 494
    //   494: aload #6
    //   496: iload_1
    //   497: invokestatic a : (Ljava/util/List;I)Lcom/tencent/bugly/proguard/au;
    //   500: astore #7
    //   502: aload #7
    //   504: ifnonnull -> 521
    //   507: ldc_w '[UserInfo] Failed to create UserInfoPackage.'
    //   510: iconst_0
    //   511: anewarray java/lang/Object
    //   514: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   517: pop
    //   518: aload_0
    //   519: monitorexit
    //   520: return
    //   521: aload #7
    //   523: invokestatic a : (Lcom/tencent/bugly/proguard/k;)[B
    //   526: astore #7
    //   528: aload #7
    //   530: ifnonnull -> 547
    //   533: ldc_w '[UserInfo] Failed to encode data.'
    //   536: iconst_0
    //   537: anewarray java/lang/Object
    //   540: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   543: pop
    //   544: aload_0
    //   545: monitorexit
    //   546: return
    //   547: aload #8
    //   549: getfield a : Z
    //   552: ifeq -> 754
    //   555: sipush #840
    //   558: istore_1
    //   559: goto -> 562
    //   562: aload_0
    //   563: getfield a : Landroid/content/Context;
    //   566: iload_1
    //   567: aload #7
    //   569: invokestatic a : (Landroid/content/Context;I[B)Lcom/tencent/bugly/proguard/ap;
    //   572: astore #9
    //   574: aload #9
    //   576: ifnonnull -> 593
    //   579: ldc_w '[UserInfo] Request package is null.'
    //   582: iconst_0
    //   583: anewarray java/lang/Object
    //   586: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   589: pop
    //   590: aload_0
    //   591: monitorexit
    //   592: return
    //   593: new com/tencent/bugly/crashreport/biz/a$1
    //   596: dup
    //   597: aload_0
    //   598: aload #6
    //   600: invokespecial <init> : (Lcom/tencent/bugly/crashreport/biz/a;Ljava/util/List;)V
    //   603: astore #10
    //   605: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   608: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   611: astore #6
    //   613: aload #8
    //   615: getfield a : Z
    //   618: ifeq -> 631
    //   621: aload #6
    //   623: getfield r : Ljava/lang/String;
    //   626: astore #6
    //   628: goto -> 638
    //   631: aload #6
    //   633: getfield t : Ljava/lang/String;
    //   636: astore #6
    //   638: aload #8
    //   640: getfield a : Z
    //   643: ifeq -> 654
    //   646: getstatic com/tencent/bugly/crashreport/common/strategy/StrategyBean.b : Ljava/lang/String;
    //   649: astore #7
    //   651: goto -> 659
    //   654: getstatic com/tencent/bugly/crashreport/common/strategy/StrategyBean.a : Ljava/lang/String;
    //   657: astore #7
    //   659: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   662: astore #8
    //   664: aload_0
    //   665: getfield c : I
    //   668: iconst_1
    //   669: if_icmpne -> 761
    //   672: iconst_1
    //   673: istore #5
    //   675: goto -> 678
    //   678: aload #8
    //   680: sipush #1001
    //   683: aload #9
    //   685: aload #6
    //   687: aload #7
    //   689: aload #10
    //   691: iload #5
    //   693: invokevirtual a : (ILcom/tencent/bugly/proguard/ap;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/proguard/t;Z)V
    //   696: aload_0
    //   697: monitorexit
    //   698: return
    //   699: ldc_w '[UserInfo] There is no user info in local database.'
    //   702: iconst_0
    //   703: anewarray java/lang/Object
    //   706: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_0
    //   711: monitorexit
    //   712: return
    //   713: astore #6
    //   715: aload_0
    //   716: monitorexit
    //   717: aload #6
    //   719: athrow
    //   720: iload_3
    //   721: iconst_1
    //   722: iadd
    //   723: istore_3
    //   724: goto -> 140
    //   727: iload_2
    //   728: istore_1
    //   729: goto -> 121
    //   732: iconst_0
    //   733: istore_1
    //   734: goto -> 227
    //   737: iload_1
    //   738: iconst_1
    //   739: iadd
    //   740: istore_1
    //   741: goto -> 267
    //   744: iconst_1
    //   745: istore_1
    //   746: goto -> 425
    //   749: iconst_2
    //   750: istore_1
    //   751: goto -> 494
    //   754: sipush #640
    //   757: istore_1
    //   758: goto -> 562
    //   761: iconst_0
    //   762: istore #5
    //   764: goto -> 678
    // Exception table:
    //   from	to	target	type
    //   2	8	713	finally
    //   16	21	713	finally
    //   29	34	713	finally
    //   42	60	713	finally
    //   68	97	713	finally
    //   102	114	713	finally
    //   121	134	713	finally
    //   140	224	713	finally
    //   233	249	713	finally
    //   256	265	713	finally
    //   267	330	713	finally
    //   330	373	713	finally
    //   386	404	713	finally
    //   413	422	713	finally
    //   425	440	713	finally
    //   444	454	713	finally
    //   457	489	713	finally
    //   494	502	713	finally
    //   507	518	713	finally
    //   521	528	713	finally
    //   533	544	713	finally
    //   547	555	713	finally
    //   562	574	713	finally
    //   579	590	713	finally
    //   593	628	713	finally
    //   631	638	713	finally
    //   638	651	713	finally
    //   654	659	713	finally
    //   659	672	713	finally
    //   678	696	713	finally
    //   699	710	713	finally
  }
  
  public final List<UserInfoBean> a(String paramString) {
    try {
      if (z.a(paramString)) {
        paramString = null;
      } else {
        StringBuilder stringBuilder = new StringBuilder("_pc = '");
        stringBuilder.append(paramString);
        stringBuilder.append("'");
        paramString = stringBuilder.toString();
      } 
      Cursor cursor = p.a().a("t_ui", null, paramString, null, null, true);
      if (cursor == null)
        return null; 
    } finally {
      null = null;
    } 
    try {
      if (!x.a(null))
        null.printStackTrace(); 
      return null;
    } finally {
      if (paramString != null)
        paramString.close(); 
    } 
  }
  
  public final void a() {
    this.b = z.b() + 86400000L;
    w.a().a(new b(this), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong) {
    com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
    boolean bool = false;
    if (a2 != null && !(a2.c()).h && paramInt != 1 && paramInt != 3) {
      x.e("UserInfo is disable", new Object[0]);
      return;
    } 
    if (paramInt == 1 || paramInt == 3)
      this.c++; 
    com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
    UserInfoBean userInfoBean = new UserInfoBean();
    userInfoBean.b = paramInt;
    userInfoBean.c = a1.d;
    userInfoBean.d = a1.g();
    userInfoBean.e = System.currentTimeMillis();
    userInfoBean.f = -1L;
    userInfoBean.n = a1.k;
    if (paramInt == 1)
      bool = true; 
    userInfoBean.o = bool;
    userInfoBean.l = a1.a();
    userInfoBean.m = a1.q;
    userInfoBean.g = a1.r;
    userInfoBean.h = a1.s;
    userInfoBean.i = a1.t;
    userInfoBean.k = a1.u;
    userInfoBean.r = a1.B();
    userInfoBean.s = a1.G();
    userInfoBean.p = a1.H();
    userInfoBean.q = a1.I();
    w.a().a(new a(this, userInfoBean, paramBoolean), 0L);
  }
  
  public final void b() {
    w w = w.a();
    if (w != null)
      w.a(new Runnable(this) {
            public final void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                x.a(exception);
              } 
            }
          }); 
  }
  
  final class a implements Runnable {
    private boolean a;
    
    private UserInfoBean b;
    
    public a(a this$0, UserInfoBean param1UserInfoBean, boolean param1Boolean) {
      this.b = param1UserInfoBean;
      this.a = param1Boolean;
    }
    
    public final void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        if (!x.a(exception))
          exception.printStackTrace(); 
      } 
    }
  }
  
  final class b implements Runnable {
    b(a this$0) {}
    
    public final void run() {
      long l = System.currentTimeMillis();
      if (l < a.b(this.a)) {
        w.a().a(new b(this.a), a.b(this.a) - l + 5000L);
        return;
      } 
      this.a.a(3, false, 0L);
      this.a.a();
    }
  }
  
  final class c implements Runnable {
    private long a = 21600000L;
    
    public c(a this$0, long param1Long) {
      this.a = param1Long;
    }
    
    public final void run() {
      a a1 = this.b;
      w w = w.a();
      if (w != null)
        w.a(new Runnable(a1) {
              public final void run() {
                try {
                  return;
                } finally {
                  Exception exception = null;
                  x.a(exception);
                } 
              }
            }); 
      a1 = this.b;
      long l = this.a;
      w.a().a(new c(a1, l), l);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\biz\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */