package com.qiniu.android.common;

import com.qiniu.android.collect.LogHandler;

public abstract class Zone {
  public abstract void frozenDomain(String paramString);
  
  public abstract void preQuery(LogHandler paramLogHandler, String paramString, QueryHandler paramQueryHandler);
  
  public abstract boolean preQuery(LogHandler paramLogHandler, String paramString);
  
  protected String upHost(ZoneInfo paramZoneInfo, boolean paramBoolean, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: ifnull -> 259
    //   6: aload_1
    //   7: aload_3
    //   8: invokestatic create : (Ljava/lang/String;)Ljava/net/URI;
    //   11: invokevirtual getHost : ()Ljava/lang/String;
    //   14: invokevirtual frozenDomain : (Ljava/lang/String;)V
    //   17: goto -> 259
    //   20: aload_1
    //   21: getfield upDomainsList : Ljava/util/List;
    //   24: invokeinterface size : ()I
    //   29: istore #5
    //   31: aconst_null
    //   32: astore #8
    //   34: iload #4
    //   36: iload #5
    //   38: if_icmpge -> 274
    //   41: aload_1
    //   42: getfield upDomainsList : Ljava/util/List;
    //   45: iload #4
    //   47: invokeinterface get : (I)Ljava/lang/Object;
    //   52: checkcast java/lang/String
    //   55: astore #9
    //   57: aload_1
    //   58: getfield upDomainsMap : Ljava/util/Map;
    //   61: aload #9
    //   63: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast java/lang/Long
    //   71: invokevirtual longValue : ()J
    //   74: lstore #6
    //   76: aload #9
    //   78: astore_3
    //   79: lload #6
    //   81: lconst_0
    //   82: lcmp
    //   83: ifeq -> 105
    //   86: lload #6
    //   88: invokestatic currentTimeMillis : ()J
    //   91: ldc2_w 1000
    //   94: ldiv
    //   95: lcmp
    //   96: ifgt -> 265
    //   99: aload #9
    //   101: astore_3
    //   102: goto -> 105
    //   105: aload_3
    //   106: ifnull -> 127
    //   109: aload_1
    //   110: getfield upDomainsMap : Ljava/util/Map;
    //   113: aload_3
    //   114: lconst_0
    //   115: invokestatic valueOf : (J)Ljava/lang/Long;
    //   118: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: goto -> 205
    //   127: aload_1
    //   128: getfield upDomainsList : Ljava/util/List;
    //   131: invokeinterface iterator : ()Ljava/util/Iterator;
    //   136: astore #9
    //   138: aload #9
    //   140: invokeinterface hasNext : ()Z
    //   145: ifeq -> 179
    //   148: aload #9
    //   150: invokeinterface next : ()Ljava/lang/Object;
    //   155: checkcast java/lang/String
    //   158: astore #10
    //   160: aload_1
    //   161: getfield upDomainsMap : Ljava/util/Map;
    //   164: aload #10
    //   166: lconst_0
    //   167: invokestatic valueOf : (J)Ljava/lang/Long;
    //   170: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -> 138
    //   179: aload_1
    //   180: getfield upDomainsList : Ljava/util/List;
    //   183: invokeinterface size : ()I
    //   188: ifle -> 205
    //   191: aload_1
    //   192: getfield upDomainsList : Ljava/util/List;
    //   195: iconst_0
    //   196: invokeinterface get : (I)Ljava/lang/Object;
    //   201: checkcast java/lang/String
    //   204: astore_3
    //   205: aload #8
    //   207: astore_1
    //   208: aload_3
    //   209: ifnull -> 247
    //   212: iload_2
    //   213: ifeq -> 233
    //   216: ldc 'https://%s'
    //   218: iconst_1
    //   219: anewarray java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_3
    //   225: aastore
    //   226: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   229: astore_1
    //   230: goto -> 247
    //   233: ldc 'http://%s'
    //   235: iconst_1
    //   236: anewarray java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_3
    //   242: aastore
    //   243: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   246: astore_1
    //   247: aload_0
    //   248: monitorexit
    //   249: aload_1
    //   250: areturn
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: goto -> 251
    //   259: iconst_0
    //   260: istore #4
    //   262: goto -> 20
    //   265: iload #4
    //   267: iconst_1
    //   268: iadd
    //   269: istore #4
    //   271: goto -> 20
    //   274: aconst_null
    //   275: astore_3
    //   276: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   6	17	255	finally
    //   20	31	255	finally
    //   41	76	255	finally
    //   86	99	255	finally
    //   109	124	255	finally
    //   127	138	255	finally
    //   138	176	255	finally
    //   179	205	255	finally
    //   216	230	255	finally
    //   233	247	255	finally
  }
  
  public abstract String upHost(String paramString1, boolean paramBoolean, String paramString2);
  
  public static interface QueryHandler {
    void onFailure(int param1Int);
    
    void onSuccess();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\common\Zone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */