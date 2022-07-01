package com.pgl.sys.a;

import android.content.Context;
import com.pgl.sys.a.a.a;

public class b implements Runnable {
  private a a;
  
  private Context b;
  
  b(Context paramContext, a parama) {
    this.a = parama;
    this.b = paramContext;
  }
  
  public void run() {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore #8
    //   5: invokestatic b : ()Ljava/lang/String;
    //   8: astore #11
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore #12
    //   19: aload #12
    //   21: aload #11
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload #12
    //   29: ldc '/v1/getInfoPgl'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #12
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: astore #11
    //   42: invokestatic a : ()Lcom/pgl/sys/ces/b;
    //   45: getfield a : Z
    //   48: istore #10
    //   50: lconst_0
    //   51: lstore #6
    //   53: iload #10
    //   55: ifeq -> 546
    //   58: invokestatic getInstance : ()Ljava/util/Calendar;
    //   61: invokevirtual getTimeInMillis : ()J
    //   64: lstore #4
    //   66: goto -> 69
    //   69: sipush #301
    //   72: aload_0
    //   73: getfield b : Landroid/content/Context;
    //   76: aconst_null
    //   77: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast [B
    //   83: checkcast [B
    //   86: astore #12
    //   88: invokestatic a : ()Lcom/pgl/sys/ces/b;
    //   91: getfield a : Z
    //   94: ifeq -> 105
    //   97: invokestatic getInstance : ()Ljava/util/Calendar;
    //   100: invokevirtual getTimeInMillis : ()J
    //   103: lstore #6
    //   105: invokestatic a : ()Lcom/pgl/sys/ces/b;
    //   108: getfield a : Z
    //   111: ifeq -> 153
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore #13
    //   123: aload #13
    //   125: ldc '[Efficient] selas : '
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #13
    //   133: lload #6
    //   135: lload #4
    //   137: lsub
    //   138: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 'CZL_Efficient'
    //   144: aload #13
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: aload #12
    //   155: ifnull -> 416
    //   158: aload #12
    //   160: arraylength
    //   161: ifle -> 416
    //   164: new java/util/HashMap
    //   167: dup
    //   168: invokespecial <init> : ()V
    //   171: astore #13
    //   173: aload #13
    //   175: ldc 'os'
    //   177: ldc 'android'
    //   179: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: new java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial <init> : ()V
    //   192: astore #14
    //   194: aload #14
    //   196: getstatic com/pgl/sys/a/a.c : Ljava/lang/String;
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #14
    //   205: ldc ''
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #13
    //   213: ldc 'app_key'
    //   215: aload #14
    //   217: invokevirtual toString : ()Ljava/lang/String;
    //   220: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: pop
    //   226: aload #13
    //   228: ldc 'version'
    //   230: ldc '1.0.3'
    //   232: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload #13
    //   240: ldc 'version_code'
    //   242: ldc '4'
    //   244: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload #13
    //   252: ldc 'time'
    //   254: lload #8
    //   256: invokestatic valueOf : (J)Ljava/lang/String;
    //   259: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: iconst_0
    //   266: istore_2
    //   267: iconst_0
    //   268: istore_1
    //   269: iload_1
    //   270: istore_3
    //   271: iload_2
    //   272: iconst_3
    //   273: if_icmpge -> 395
    //   276: new org/json/JSONObject
    //   279: dup
    //   280: aload #11
    //   282: aload #13
    //   284: aload #12
    //   286: invokestatic a : (Ljava/lang/String;Ljava/util/Map;[B)Ljava/lang/String;
    //   289: invokespecial <init> : (Ljava/lang/String;)V
    //   292: astore #14
    //   294: aload #14
    //   296: ldc 'code'
    //   298: invokevirtual getInt : (Ljava/lang/String;)I
    //   301: istore_1
    //   302: iload_1
    //   303: sipush #500
    //   306: if_icmpne -> 327
    //   309: iload_2
    //   310: iconst_1
    //   311: iadd
    //   312: istore_2
    //   313: iload_2
    //   314: iconst_3
    //   315: imul
    //   316: sipush #1000
    //   319: imul
    //   320: i2l
    //   321: invokestatic a : (J)V
    //   324: goto -> 269
    //   327: iload_1
    //   328: sipush #200
    //   331: if_icmpne -> 353
    //   334: iconst_1
    //   335: putstatic com/pgl/sys/a/a.b : Z
    //   338: aload #14
    //   340: ldc 'token_id'
    //   342: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   345: putstatic com/pgl/sys/a/a.d : Ljava/lang/String;
    //   348: iload_1
    //   349: istore_3
    //   350: goto -> 395
    //   353: iload_1
    //   354: istore_3
    //   355: iload_1
    //   356: sipush #202
    //   359: if_icmpne -> 395
    //   362: iconst_1
    //   363: putstatic com/pgl/sys/a/a.b : Z
    //   366: aload #14
    //   368: ldc 'token_id'
    //   370: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   373: astore #11
    //   375: aload #11
    //   377: putstatic com/pgl/sys/a/a.d : Ljava/lang/String;
    //   380: sipush #302
    //   383: aload_0
    //   384: getfield b : Landroid/content/Context;
    //   387: aload #11
    //   389: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   392: pop
    //   393: iload_1
    //   394: istore_3
    //   395: iload_3
    //   396: putstatic com/pgl/sys/a/a.a : I
    //   399: invokestatic a : ()Lcom/pgl/sys/ces/b;
    //   402: astore #11
    //   404: new java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial <init> : ()V
    //   411: astore #12
    //   413: goto -> 446
    //   416: new java/lang/NullPointerException
    //   419: dup
    //   420: ldc 'NullPointerException'
    //   422: invokespecial <init> : (Ljava/lang/String;)V
    //   425: athrow
    //   426: sipush #500
    //   429: putstatic com/pgl/sys/a/a.a : I
    //   432: invokestatic a : ()Lcom/pgl/sys/ces/b;
    //   435: astore #11
    //   437: new java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial <init> : ()V
    //   444: astore #12
    //   446: aload #12
    //   448: ldc 'SS-'
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload #12
    //   456: getstatic com/pgl/sys/a/a.a : I
    //   459: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload #11
    //   465: aload #12
    //   467: invokevirtual toString : ()Ljava/lang/String;
    //   470: invokevirtual reportNow : (Ljava/lang/String;)V
    //   473: aload_0
    //   474: getfield a : Lcom/pgl/sys/a/a/a;
    //   477: astore #11
    //   479: aload #11
    //   481: ifnull -> 494
    //   484: aload #11
    //   486: invokestatic a : ()Ljava/lang/String;
    //   489: invokeinterface a : (Ljava/lang/String;)V
    //   494: return
    //   495: astore #11
    //   497: invokestatic a : ()Lcom/pgl/sys/ces/b;
    //   500: astore #12
    //   502: new java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial <init> : ()V
    //   509: astore #13
    //   511: aload #13
    //   513: ldc 'SS-'
    //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #13
    //   521: getstatic com/pgl/sys/a/a.a : I
    //   524: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload #12
    //   530: aload #13
    //   532: invokevirtual toString : ()Ljava/lang/String;
    //   535: invokevirtual reportNow : (Ljava/lang/String;)V
    //   538: aload #11
    //   540: athrow
    //   541: astore #11
    //   543: goto -> 426
    //   546: lconst_0
    //   547: lstore #4
    //   549: goto -> 69
    // Exception table:
    //   from	to	target	type
    //   10	50	541	finally
    //   58	66	541	finally
    //   69	88	541	finally
    //   88	105	541	finally
    //   105	153	541	finally
    //   158	265	541	finally
    //   276	302	541	finally
    //   313	324	541	finally
    //   334	348	541	finally
    //   362	393	541	finally
    //   395	399	541	finally
    //   416	426	541	finally
    //   426	432	495	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */