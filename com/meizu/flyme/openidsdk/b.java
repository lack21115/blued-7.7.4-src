package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class b {
  public static volatile b g;
  
  public static boolean h;
  
  public OpenId a = new OpenId("udid");
  
  public OpenId b = new OpenId("oaid");
  
  public OpenId c = new OpenId("aaid");
  
  public OpenId d = new OpenId("vaid");
  
  public Boolean e;
  
  public BroadcastReceiver f;
  
  public static ValueData a(Cursor paramCursor) {
    ValueData valueData = new ValueData(null, 0);
    if (paramCursor == null) {
      b("parseValue fail, cursor is null.");
      return valueData;
    } 
    if (paramCursor.isClosed()) {
      b("parseValue fail, cursor is closed.");
      return valueData;
    } 
    paramCursor.moveToFirst();
    int i = paramCursor.getColumnIndex("value");
    if (i >= 0) {
      valueData.a = paramCursor.getString(i);
    } else {
      b("parseValue fail, index < 0.");
    } 
    i = paramCursor.getColumnIndex("code");
    if (i >= 0) {
      valueData.b = paramCursor.getInt(i);
    } else {
      b("parseCode fail, index < 0.");
    } 
    i = paramCursor.getColumnIndex("expired");
    if (i >= 0) {
      valueData.c = paramCursor.getLong(i);
      return valueData;
    } 
    b("parseExpired fail, index < 0.");
    return valueData;
  }
  
  public static final b a() {
    // Byte code:
    //   0: getstatic com/meizu/flyme/openidsdk/b.g : Lcom/meizu/flyme/openidsdk/b;
    //   3: ifnonnull -> 22
    //   6: ldc com/meizu/flyme/openidsdk/b
    //   8: monitorenter
    //   9: new com/meizu/flyme/openidsdk/b
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/meizu/flyme/openidsdk/b.g : Lcom/meizu/flyme/openidsdk/b;
    //   19: ldc com/meizu/flyme/openidsdk/b
    //   21: monitorexit
    //   22: getstatic com/meizu/flyme/openidsdk/b.g : Lcom/meizu/flyme/openidsdk/b;
    //   25: areturn
    //   26: astore_0
    //   27: ldc com/meizu/flyme/openidsdk/b
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   9	22	26	finally
    //   27	30	26	finally
  }
  
  public static void b(String paramString) {
    if (h)
      Log.d("OpenIdManager", paramString); 
  }
  
  public OpenId a(String paramString) {
    return "oaid".equals(paramString) ? this.b : ("vaid".equals(paramString) ? this.d : ("aaid".equals(paramString) ? this.c : ("udid".equals(paramString) ? this.a : null)));
  }
  
  public final String a(Context paramContext, OpenId paramOpenId) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aload_2
    //   4: ifnonnull -> 11
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_2
    //   10: areturn
    //   11: aload_2
    //   12: invokevirtual a : ()Z
    //   15: ifeq -> 23
    //   18: aload_2
    //   19: getfield b : Ljava/lang/String;
    //   22: areturn
    //   23: new java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: ldc 'queryId : '
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: getfield c : Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: invokestatic b : (Ljava/lang/String;)V
    //   48: ldc 'content://com.meizu.flyme.openidsdk/'
    //   50: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   53: astore #4
    //   55: aload_1
    //   56: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   59: aload #4
    //   61: aconst_null
    //   62: aconst_null
    //   63: iconst_1
    //   64: anewarray java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload_2
    //   70: getfield c : Ljava/lang/String;
    //   73: aastore
    //   74: aconst_null
    //   75: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore #4
    //   80: aload #4
    //   82: ifnull -> 327
    //   85: aload #4
    //   87: astore #5
    //   89: aload #4
    //   91: invokestatic a : (Landroid/database/Cursor;)Lcom/meizu/flyme/openidsdk/ValueData;
    //   94: astore #8
    //   96: aload #4
    //   98: astore #5
    //   100: aload #8
    //   102: getfield a : Ljava/lang/String;
    //   105: astore #7
    //   107: aload #7
    //   109: astore #6
    //   111: aload #4
    //   113: astore #5
    //   115: aload_2
    //   116: aload #7
    //   118: invokevirtual a : (Ljava/lang/String;)V
    //   121: aload #7
    //   123: astore #6
    //   125: aload #4
    //   127: astore #5
    //   129: aload_2
    //   130: aload #8
    //   132: getfield c : J
    //   135: invokevirtual a : (J)V
    //   138: aload #7
    //   140: astore #6
    //   142: aload #4
    //   144: astore #5
    //   146: aload_2
    //   147: aload #8
    //   149: getfield b : I
    //   152: invokevirtual a : (I)V
    //   155: aload #7
    //   157: astore #6
    //   159: aload #4
    //   161: astore #5
    //   163: new java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: aload_2
    //   171: getfield c : Ljava/lang/String;
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc ' errorCode : '
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: getfield d : I
    //   186: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: invokestatic b : (Ljava/lang/String;)V
    //   195: aload #7
    //   197: astore_2
    //   198: aload #7
    //   200: astore #6
    //   202: aload #4
    //   204: astore #5
    //   206: aload #8
    //   208: getfield b : I
    //   211: sipush #1000
    //   214: if_icmpeq -> 309
    //   217: aload #7
    //   219: astore #6
    //   221: aload #4
    //   223: astore #5
    //   225: aload_0
    //   226: aload_1
    //   227: invokevirtual a : (Landroid/content/Context;)V
    //   230: aload #7
    //   232: astore_2
    //   233: aload #7
    //   235: astore #6
    //   237: aload #4
    //   239: astore #5
    //   241: aload_0
    //   242: aload_1
    //   243: iconst_0
    //   244: invokevirtual a : (Landroid/content/Context;Z)Z
    //   247: ifne -> 309
    //   250: aload #7
    //   252: astore #6
    //   254: aload #4
    //   256: astore #5
    //   258: aload_0
    //   259: aload_1
    //   260: iconst_1
    //   261: invokevirtual a : (Landroid/content/Context;Z)Z
    //   264: istore_3
    //   265: aload #7
    //   267: astore #6
    //   269: aload #4
    //   271: astore #5
    //   273: new java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial <init> : ()V
    //   280: ldc 'not support, forceQuery isSupported: '
    //   282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: astore_2
    //   286: aload #7
    //   288: astore_1
    //   289: aload_1
    //   290: astore #6
    //   292: aload #4
    //   294: astore #5
    //   296: aload_2
    //   297: iload_3
    //   298: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   301: invokevirtual toString : ()Ljava/lang/String;
    //   304: invokestatic b : (Ljava/lang/String;)V
    //   307: aload_1
    //   308: astore_2
    //   309: aload_2
    //   310: astore_1
    //   311: aload_1
    //   312: astore_2
    //   313: aload #4
    //   315: ifnull -> 9
    //   318: aload #4
    //   320: invokeinterface close : ()V
    //   325: aload_1
    //   326: areturn
    //   327: aload #4
    //   329: astore #5
    //   331: aload_0
    //   332: aload_1
    //   333: iconst_0
    //   334: invokevirtual a : (Landroid/content/Context;Z)Z
    //   337: ifeq -> 454
    //   340: aload #4
    //   342: astore #5
    //   344: aload_0
    //   345: aload_1
    //   346: iconst_1
    //   347: invokevirtual a : (Landroid/content/Context;Z)Z
    //   350: istore_3
    //   351: aload #4
    //   353: astore #5
    //   355: new java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial <init> : ()V
    //   362: ldc 'forceQuery isSupported : '
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: astore_2
    //   368: aload #6
    //   370: astore_1
    //   371: goto -> 289
    //   374: astore_2
    //   375: aconst_null
    //   376: astore #4
    //   378: aconst_null
    //   379: astore_1
    //   380: aload #4
    //   382: astore #5
    //   384: new java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial <init> : ()V
    //   391: ldc 'queryId, Exception : '
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_2
    //   397: invokevirtual getMessage : ()Ljava/lang/String;
    //   400: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual toString : ()Ljava/lang/String;
    //   406: invokestatic b : (Ljava/lang/String;)V
    //   409: aload_1
    //   410: astore_2
    //   411: aload #4
    //   413: ifnull -> 9
    //   416: goto -> 318
    //   419: astore_1
    //   420: aconst_null
    //   421: astore #5
    //   423: aload #5
    //   425: ifnull -> 435
    //   428: aload #5
    //   430: invokeinterface close : ()V
    //   435: aload_1
    //   436: athrow
    //   437: astore_2
    //   438: aconst_null
    //   439: astore_1
    //   440: goto -> 380
    //   443: astore_2
    //   444: aload #6
    //   446: astore_1
    //   447: goto -> 380
    //   450: astore_1
    //   451: goto -> 423
    //   454: aconst_null
    //   455: astore_1
    //   456: goto -> 311
    // Exception table:
    //   from	to	target	type
    //   55	80	374	java/lang/Exception
    //   55	80	419	finally
    //   89	96	437	java/lang/Exception
    //   89	96	450	finally
    //   100	107	437	java/lang/Exception
    //   100	107	450	finally
    //   115	121	443	java/lang/Exception
    //   115	121	450	finally
    //   129	138	443	java/lang/Exception
    //   129	138	450	finally
    //   146	155	443	java/lang/Exception
    //   146	155	450	finally
    //   163	195	443	java/lang/Exception
    //   163	195	450	finally
    //   206	217	443	java/lang/Exception
    //   206	217	450	finally
    //   225	230	443	java/lang/Exception
    //   225	230	450	finally
    //   241	250	443	java/lang/Exception
    //   241	250	450	finally
    //   258	265	443	java/lang/Exception
    //   258	265	450	finally
    //   273	286	443	java/lang/Exception
    //   273	286	450	finally
    //   296	307	443	java/lang/Exception
    //   296	307	450	finally
    //   331	340	437	java/lang/Exception
    //   331	340	450	finally
    //   344	351	437	java/lang/Exception
    //   344	351	450	finally
    //   355	368	437	java/lang/Exception
    //   355	368	450	finally
    //   384	409	450	finally
  }
  
  public final void a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/content/BroadcastReceiver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new android/content/IntentFilter
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 'com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE'
    //   25: invokevirtual addAction : (Ljava/lang/String;)V
    //   28: aload_0
    //   29: new com/meizu/flyme/openidsdk/a
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: putfield f : Landroid/content/BroadcastReceiver;
    //   39: aload_1
    //   40: aload_0
    //   41: getfield f : Landroid/content/BroadcastReceiver;
    //   44: aload_2
    //   45: ldc 'com.meizu.flyme.openid.permission.OPEN_ID_CHANGE'
    //   47: aconst_null
    //   48: invokevirtual registerReceiver : (Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   51: pop
    //   52: goto -> 11
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	52	55	finally
  }
  
  public final boolean a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_0
    //   6: getfield e : Ljava/lang/Boolean;
    //   9: astore #5
    //   11: aload #5
    //   13: ifnull -> 26
    //   16: iload_2
    //   17: ifne -> 26
    //   20: aload #5
    //   22: invokevirtual booleanValue : ()Z
    //   25: ireturn
    //   26: aload_1
    //   27: ifnull -> 41
    //   30: aload_1
    //   31: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   34: astore #5
    //   36: aload #5
    //   38: ifnonnull -> 62
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: ifne -> 76
    //   47: ldc 'is not Supported, for isLegalProvider : false'
    //   49: invokestatic b : (Ljava/lang/String;)V
    //   52: aload_0
    //   53: iconst_0
    //   54: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   57: putfield e : Ljava/lang/Boolean;
    //   60: iconst_0
    //   61: ireturn
    //   62: aload #5
    //   64: ldc 'com.meizu.flyme.openidsdk'
    //   66: iconst_0
    //   67: invokevirtual resolveContentProvider : (Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   70: ifnull -> 41
    //   73: goto -> 43
    //   76: ldc 'content://com.meizu.flyme.openidsdk/'
    //   78: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   81: astore #5
    //   83: aload_1
    //   84: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   87: aload #5
    //   89: aconst_null
    //   90: aconst_null
    //   91: iconst_1
    //   92: anewarray java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: ldc 'supported'
    //   99: aastore
    //   100: aconst_null
    //   101: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull -> 173
    //   109: aload_1
    //   110: astore #4
    //   112: aload_1
    //   113: invokestatic a : (Landroid/database/Cursor;)Lcom/meizu/flyme/openidsdk/ValueData;
    //   116: getfield a : Ljava/lang/String;
    //   119: astore #5
    //   121: aload_1
    //   122: invokeinterface close : ()V
    //   127: aload #5
    //   129: astore_1
    //   130: new java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: ldc 'querySupport, result : '
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: invokestatic b : (Ljava/lang/String;)V
    //   152: aload_0
    //   153: ldc '0'
    //   155: aload_1
    //   156: invokevirtual equals : (Ljava/lang/Object;)Z
    //   159: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   162: putfield e : Ljava/lang/Boolean;
    //   165: aload_0
    //   166: getfield e : Ljava/lang/Boolean;
    //   169: invokevirtual booleanValue : ()Z
    //   172: ireturn
    //   173: aload_1
    //   174: ifnull -> 183
    //   177: aload_1
    //   178: invokeinterface close : ()V
    //   183: aconst_null
    //   184: astore_1
    //   185: goto -> 130
    //   188: astore #5
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore #4
    //   195: new java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial <init> : ()V
    //   202: ldc 'querySupport, Exception : '
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload #5
    //   209: invokevirtual getMessage : ()Ljava/lang/String;
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual toString : ()Ljava/lang/String;
    //   218: invokestatic b : (Ljava/lang/String;)V
    //   221: aload_1
    //   222: ifnull -> 183
    //   225: goto -> 177
    //   228: astore_1
    //   229: aload #4
    //   231: ifnull -> 241
    //   234: aload #4
    //   236: invokeinterface close : ()V
    //   241: aload_1
    //   242: athrow
    //   243: astore #5
    //   245: goto -> 192
    //   248: astore_1
    //   249: goto -> 229
    // Exception table:
    //   from	to	target	type
    //   83	105	188	java/lang/Exception
    //   83	105	228	finally
    //   112	121	243	java/lang/Exception
    //   112	121	248	finally
    //   195	221	248	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\meizu\flyme\openidsdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */