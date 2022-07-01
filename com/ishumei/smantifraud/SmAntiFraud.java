package com.ishumei.smantifraud;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l1111l111111Il.l11l1111lIIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.util.Set;

public class SmAntiFraud {
  public static final String AREA_BJ = "bj";
  
  public static final String AREA_FJNY = "fjny";
  
  public static final String AREA_XJP = "xjp";
  
  public static final int SM_AF_ASYN_MODE = 1;
  
  public static final int SM_AF_SYN_MODE = 0;
  
  public static SmOption l1111l111111Il;
  
  private static IServerSmidCallback l111l11111I1l;
  
  private static final String l111l11111lIl = "sm";
  
  public static void create(Context paramContext, SmOption paramSmOption) {
    // Byte code:
    //   0: ldc com/ishumei/smantifraud/SmAntiFraud
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull -> 480
    //   7: aload_1
    //   8: invokevirtual l11l1111I1ll : ()Ljava/lang/String;
    //   11: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   14: ifeq -> 20
    //   17: goto -> 480
    //   20: aload_1
    //   21: invokevirtual l111l1111llIl : ()Ljava/lang/String;
    //   24: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   27: ifeq -> 45
    //   30: ldc 'sm'
    //   32: ldc '8f8a9d93969cb49a86df979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1'
    //   34: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: ldc com/ishumei/smantifraud/SmAntiFraud
    //   43: monitorexit
    //   44: return
    //   45: aload_1
    //   46: invokevirtual l11l11IlIIll : ()Ljava/lang/String;
    //   49: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   52: ifeq -> 66
    //   55: ldc 'sm'
    //   57: ldc '9e8f8fb69bdf979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1'
    //   59: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l1111llIl/l111l11111lIl;
    //   69: invokevirtual l111l11111lIl : ()V
    //   72: aload_0
    //   73: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   76: astore_0
    //   77: aload_0
    //   78: ifnonnull -> 91
    //   81: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l1111llIl/l111l11111lIl;
    //   84: invokevirtual l111l11111I1l : ()V
    //   87: ldc com/ishumei/smantifraud/SmAntiFraud
    //   89: monitorexit
    //   90: return
    //   91: aload_0
    //   92: putstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   95: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l1111l1Il : Ljava/lang/String;
    //   98: ifnonnull -> 143
    //   101: getstatic java/util/Locale.CHINA : Ljava/util/Locale;
    //   104: ldc '%d-%05d'
    //   106: iconst_2
    //   107: anewarray java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: invokestatic currentTimeMillis : ()J
    //   115: invokestatic valueOf : (J)Ljava/lang/Long;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: new java/util/Random
    //   124: dup
    //   125: invokespecial <init> : ()V
    //   128: ldc 100000
    //   130: invokevirtual nextInt : (I)I
    //   133: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   136: aastore
    //   137: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   140: putstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l1111l1Il : Ljava/lang/String;
    //   143: aload_1
    //   144: putstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   147: aload_1
    //   148: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   151: astore_0
    //   152: iconst_m1
    //   153: istore_2
    //   154: aload_0
    //   155: invokevirtual hashCode : ()I
    //   158: istore_3
    //   159: iload_3
    //   160: sipush #3144
    //   163: if_icmpeq -> 209
    //   166: iload_3
    //   167: ldc 118718
    //   169: if_icmpeq -> 195
    //   172: iload_3
    //   173: ldc 3144079
    //   175: if_icmpeq -> 181
    //   178: goto -> 220
    //   181: aload_0
    //   182: ldc 'fjny'
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifeq -> 220
    //   190: iconst_2
    //   191: istore_2
    //   192: goto -> 220
    //   195: aload_0
    //   196: ldc 'xjp'
    //   198: invokevirtual equals : (Ljava/lang/Object;)Z
    //   201: ifeq -> 220
    //   204: iconst_1
    //   205: istore_2
    //   206: goto -> 220
    //   209: aload_0
    //   210: ldc 'bj'
    //   212: invokevirtual equals : (Ljava/lang/Object;)Z
    //   215: ifeq -> 220
    //   218: iconst_0
    //   219: istore_2
    //   220: iload_2
    //   221: ifeq -> 274
    //   224: iload_2
    //   225: iconst_1
    //   226: if_icmpeq -> 267
    //   229: iload_2
    //   230: iconst_2
    //   231: if_icmpeq -> 260
    //   234: iconst_2
    //   235: anewarray java/lang/String
    //   238: astore_0
    //   239: aload_0
    //   240: iconst_0
    //   241: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   244: invokevirtual l11l1111Il1l : ()Ljava/lang/String;
    //   247: aastore
    //   248: aload_0
    //   249: iconst_1
    //   250: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   253: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   256: aastore
    //   257: goto -> 278
    //   260: getstatic com/ishumei/l111l11111lIl/l111l1111llIl.l111l11111I1l : [Ljava/lang/String;
    //   263: astore_0
    //   264: goto -> 278
    //   267: getstatic com/ishumei/l111l11111lIl/l111l1111llIl.l111l11111lIl : [Ljava/lang/String;
    //   270: astore_0
    //   271: goto -> 278
    //   274: getstatic com/ishumei/l111l11111lIl/l111l1111llIl.l1111l111111Il : [Ljava/lang/String;
    //   277: astore_0
    //   278: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   281: astore #4
    //   283: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111llIl;
    //   286: pop
    //   287: aload #4
    //   289: aload_0
    //   290: iconst_0
    //   291: aaload
    //   292: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   295: invokevirtual l11l1111Il1l : ()Ljava/lang/String;
    //   298: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   301: invokevirtual l111l11111I1l : ()Z
    //   304: invokestatic l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   307: invokevirtual setUrl : (Ljava/lang/String;)V
    //   310: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   313: astore #4
    //   315: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111llIl;
    //   318: pop
    //   319: aload #4
    //   321: aload_0
    //   322: iconst_0
    //   323: aaload
    //   324: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   327: invokevirtual l111l1111lIl : ()Ljava/lang/String;
    //   330: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   333: invokevirtual l111l11111I1l : ()Z
    //   336: invokestatic l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   339: invokevirtual setConfUrl : (Ljava/lang/String;)V
    //   342: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   345: aload_0
    //   346: iconst_1
    //   347: aaload
    //   348: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   351: invokevirtual l11l1111I1ll : ()Ljava/lang/String;
    //   354: invokevirtual l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_1
    //   358: invokestatic l1111l111111Il : (Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;)V
    //   361: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l1111l111111Il;
    //   364: aload_1
    //   365: invokevirtual l1111l111111Il : (Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;)V
    //   368: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   371: invokevirtual l111l1111lI1l : ()Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   374: ifnull -> 386
    //   377: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   380: invokevirtual l111l1111lI1l : ()Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   383: putstatic com/ishumei/smantifraud/SmAntiFraud.l111l11111I1l : Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   386: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   389: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   392: astore_0
    //   393: aload_0
    //   394: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   397: ifne -> 436
    //   400: getstatic com/ishumei/smantifraud/SmAntiFraud.l111l11111I1l : Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   403: ifnull -> 436
    //   406: ldc com/ishumei/smantifraud/SmAntiFraud
    //   408: monitorenter
    //   409: invokestatic l111l11111lIl : ()Lcom/ishumei/l111l11111I1l/l1111l111111Il;
    //   412: new com/ishumei/smantifraud/SmAntiFraud$1
    //   415: dup
    //   416: aload_0
    //   417: invokespecial <init> : (Ljava/lang/String;)V
    //   420: iconst_2
    //   421: invokevirtual l1111l111111Il : (Ljava/lang/Runnable;I)V
    //   424: ldc com/ishumei/smantifraud/SmAntiFraud
    //   426: monitorexit
    //   427: goto -> 436
    //   430: astore_0
    //   431: ldc com/ishumei/smantifraud/SmAntiFraud
    //   433: monitorexit
    //   434: aload_0
    //   435: athrow
    //   436: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il;
    //   439: invokevirtual l111l11111lIl : ()Z
    //   442: ifeq -> 451
    //   445: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111llIl;
    //   448: invokevirtual l111l11111lIl : ()V
    //   451: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l1111llIl/l111l11111lIl;
    //   454: invokevirtual l111l11111I1l : ()V
    //   457: ldc com/ishumei/smantifraud/SmAntiFraud
    //   459: monitorexit
    //   460: return
    //   461: astore_0
    //   462: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l1111llIl/l111l11111lIl;
    //   465: invokevirtual l111l11111I1l : ()V
    //   468: aload_0
    //   469: athrow
    //   470: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l1111llIl/l111l11111lIl;
    //   473: invokevirtual l111l11111I1l : ()V
    //   476: ldc com/ishumei/smantifraud/SmAntiFraud
    //   478: monitorexit
    //   479: return
    //   480: ldc 'sm'
    //   482: ldc 'ac92b08f8b969091df9e919bdf908d989e9196859e8b969091df9c908a939bdf91908bdf9d9adf918a9393d1'
    //   484: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   487: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   490: pop
    //   491: ldc com/ishumei/smantifraud/SmAntiFraud
    //   493: monitorexit
    //   494: return
    //   495: astore_0
    //   496: ldc com/ishumei/smantifraud/SmAntiFraud
    //   498: monitorexit
    //   499: aload_0
    //   500: athrow
    //   501: astore_0
    //   502: goto -> 470
    // Exception table:
    //   from	to	target	type
    //   7	17	495	finally
    //   20	41	495	finally
    //   45	66	495	finally
    //   66	77	501	java/lang/Exception
    //   66	77	461	finally
    //   81	87	495	finally
    //   91	143	501	java/lang/Exception
    //   91	143	461	finally
    //   143	152	501	java/lang/Exception
    //   143	152	461	finally
    //   154	159	501	java/lang/Exception
    //   154	159	461	finally
    //   181	190	501	java/lang/Exception
    //   181	190	461	finally
    //   195	204	501	java/lang/Exception
    //   195	204	461	finally
    //   209	218	501	java/lang/Exception
    //   209	218	461	finally
    //   234	257	501	java/lang/Exception
    //   234	257	461	finally
    //   260	264	501	java/lang/Exception
    //   260	264	461	finally
    //   267	271	501	java/lang/Exception
    //   267	271	461	finally
    //   274	278	501	java/lang/Exception
    //   274	278	461	finally
    //   278	386	501	java/lang/Exception
    //   278	386	461	finally
    //   386	409	501	java/lang/Exception
    //   386	409	461	finally
    //   409	427	430	finally
    //   431	434	430	finally
    //   434	436	501	java/lang/Exception
    //   434	436	461	finally
    //   436	451	501	java/lang/Exception
    //   436	451	461	finally
    //   451	457	495	finally
    //   462	470	495	finally
    //   470	476	495	finally
    //   480	491	495	finally
  }
  
  public static String getDeviceId() {
    String str;
    SmOption smOption = l1111l111111Il;
    if (smOption == null) {
      str = "ac92be918b96b98d9e8a9bd19c8d9a9e8b9adf979e8cdf91908bdf9d9a9a91df9c9e93939a9bdf869a8bd1";
    } else if (TextUtils.isEmpty(str.l11l1111I1ll())) {
      str = "908d989e9196859e8b969091df979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1";
    } else if (TextUtils.isEmpty(l1111l111111Il.l111l1111llIl())) {
      str = "8f8a9d93969cb49a86df979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1";
    } else if (TextUtils.isEmpty(l1111l111111Il.l11l11IlIIll())) {
      str = "9e8f8fb69bdf979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1";
    } else {
      return l111l1111llIl.l1111l111111Il().l111l11111I1l();
    } 
    Log.e("sm", l111l1111lI1l.l111l11111Il(str));
    return l111l1111llIl.l1111l111111Il().l111l11111I1l();
  }
  
  public static void getDeviceId(IDeviceIdCallback paramIDeviceIdCallback) {
    if (paramIDeviceIdCallback != null) {
      boolean bool;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        bool = true;
      } else {
        bool = false;
      } 
      l111l1111llIl.l1111l111111Il().l1111l111111Il(paramIDeviceIdCallback, bool);
      return;
    } 
    throw new IllegalArgumentException("callback cannot be null.");
  }
  
  public static String getSDKVersion() {
    return "3.0.6";
  }
  
  public static IServerSmidCallback getServerIdCallback() {
    return l111l11111I1l;
  }
  
  private static void l1111l111111Il(SmOption paramSmOption) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic l111l11111lIl : (Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;)V
    //   4: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   7: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifne -> 54
    //   18: getstatic com/ishumei/smantifraud/SmAntiFraud.l111l11111I1l : Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   21: ifnull -> 54
    //   24: ldc com/ishumei/smantifraud/SmAntiFraud
    //   26: monitorenter
    //   27: invokestatic l111l11111lIl : ()Lcom/ishumei/l111l11111I1l/l1111l111111Il;
    //   30: new com/ishumei/smantifraud/SmAntiFraud$1
    //   33: dup
    //   34: aload_0
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: iconst_2
    //   39: invokevirtual l1111l111111Il : (Ljava/lang/Runnable;I)V
    //   42: ldc com/ishumei/smantifraud/SmAntiFraud
    //   44: monitorexit
    //   45: goto -> 54
    //   48: astore_0
    //   49: ldc com/ishumei/smantifraud/SmAntiFraud
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il;
    //   57: invokevirtual l111l11111lIl : ()Z
    //   60: ifeq -> 69
    //   63: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111llIl;
    //   66: invokevirtual l111l11111lIl : ()V
    //   69: return
    // Exception table:
    //   from	to	target	type
    //   27	45	48	finally
    //   49	52	48	finally
  }
  
  private static void l111l11111lIl(SmOption paramSmOption) {
    // Byte code:
    //   0: aload_0
    //   1: putstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   4: aload_0
    //   5: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual hashCode : ()I
    //   13: istore_1
    //   14: iload_1
    //   15: sipush #3144
    //   18: if_icmpeq -> 64
    //   21: iload_1
    //   22: ldc 118718
    //   24: if_icmpeq -> 50
    //   27: iload_1
    //   28: ldc 3144079
    //   30: if_icmpeq -> 36
    //   33: goto -> 78
    //   36: aload_2
    //   37: ldc 'fjny'
    //   39: invokevirtual equals : (Ljava/lang/Object;)Z
    //   42: ifeq -> 78
    //   45: iconst_2
    //   46: istore_1
    //   47: goto -> 80
    //   50: aload_2
    //   51: ldc 'xjp'
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: ifeq -> 78
    //   59: iconst_1
    //   60: istore_1
    //   61: goto -> 80
    //   64: aload_2
    //   65: ldc 'bj'
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifeq -> 78
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -> 80
    //   78: iconst_m1
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq -> 134
    //   84: iload_1
    //   85: iconst_1
    //   86: if_icmpeq -> 127
    //   89: iload_1
    //   90: iconst_2
    //   91: if_icmpeq -> 120
    //   94: iconst_2
    //   95: anewarray java/lang/String
    //   98: astore_2
    //   99: aload_2
    //   100: iconst_0
    //   101: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   104: invokevirtual l11l1111Il1l : ()Ljava/lang/String;
    //   107: aastore
    //   108: aload_2
    //   109: iconst_1
    //   110: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   113: invokevirtual l111l11111lIl : ()Ljava/lang/String;
    //   116: aastore
    //   117: goto -> 138
    //   120: getstatic com/ishumei/l111l11111lIl/l111l1111llIl.l111l11111I1l : [Ljava/lang/String;
    //   123: astore_2
    //   124: goto -> 138
    //   127: getstatic com/ishumei/l111l11111lIl/l111l1111llIl.l111l11111lIl : [Ljava/lang/String;
    //   130: astore_2
    //   131: goto -> 138
    //   134: getstatic com/ishumei/l111l11111lIl/l111l1111llIl.l1111l111111Il : [Ljava/lang/String;
    //   137: astore_2
    //   138: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   141: astore_3
    //   142: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111llIl;
    //   145: pop
    //   146: aload_3
    //   147: aload_2
    //   148: iconst_0
    //   149: aaload
    //   150: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   153: invokevirtual l11l1111Il1l : ()Ljava/lang/String;
    //   156: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   159: invokevirtual l111l11111I1l : ()Z
    //   162: invokestatic l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   165: invokevirtual setUrl : (Ljava/lang/String;)V
    //   168: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   171: astore_3
    //   172: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l111l1111llIl;
    //   175: pop
    //   176: aload_3
    //   177: aload_2
    //   178: iconst_0
    //   179: aaload
    //   180: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   183: invokevirtual l111l1111lIl : ()Ljava/lang/String;
    //   186: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   189: invokevirtual l111l11111I1l : ()Z
    //   192: invokestatic l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   195: invokevirtual setConfUrl : (Ljava/lang/String;)V
    //   198: invokestatic l1111l111111Il : ()Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   201: aload_2
    //   202: iconst_1
    //   203: aaload
    //   204: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   207: invokevirtual l11l1111I1ll : ()Ljava/lang/String;
    //   210: invokevirtual l1111l111111Il : (Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokestatic l1111l111111Il : (Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;)V
    //   217: invokestatic l1111l111111Il : ()Lcom/ishumei/l111l11111lIl/l1111l111111Il;
    //   220: aload_0
    //   221: invokevirtual l1111l111111Il : (Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;)V
    //   224: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   227: invokevirtual l111l1111lI1l : ()Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   230: ifnull -> 242
    //   233: getstatic com/ishumei/smantifraud/SmAntiFraud.l1111l111111Il : Lcom/ishumei/smantifraud/SmAntiFraud$SmOption;
    //   236: invokevirtual l111l1111lI1l : ()Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   239: putstatic com/ishumei/smantifraud/SmAntiFraud.l111l11111I1l : Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   242: return
  }
  
  public static void registerServerIdCallback(IServerSmidCallback paramIServerSmidCallback) {
    // Byte code:
    //   0: ldc com/ishumei/smantifraud/SmAntiFraud
    //   2: monitorenter
    //   3: aload_0
    //   4: putstatic com/ishumei/smantifraud/SmAntiFraud.l111l11111I1l : Lcom/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback;
    //   7: ldc com/ishumei/smantifraud/SmAntiFraud
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/ishumei/smantifraud/SmAntiFraud
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static void track(String paramString1, String paramString2, MotionEvent paramMotionEvent) {
    l11l1111lIIl.l1111l111111Il().l1111l111111Il(paramString1, paramString2, paramMotionEvent);
  }
  
  public static interface IDeviceIdCallback {
    void onResult(String param1String);
  }
  
  public static interface IServerSmidCallback {
    void onError(int param1Int);
    
    void onSuccess(String param1String);
  }
  
  public static class SmOption {
    private boolean l1111l111111Il = false;
    
    private String l111l11111I1l = "";
    
    private boolean l111l11111Il = true;
    
    private String l111l11111lIl = "";
    
    private boolean l111l1111l1Il = true;
    
    private String l111l1111lI1l = null;
    
    private boolean l111l1111lIl = false;
    
    private String l111l1111llIl = null;
    
    private SmAntiFraud.IServerSmidCallback l11l1111I11l = null;
    
    private Set<String> l11l1111I1l;
    
    private boolean l11l1111I1ll;
    
    private String l11l1111Il = "default";
    
    private String l11l1111Il1l = null;
    
    private byte[] l11l1111Ill;
    
    private boolean l11l1111lIIl = false;
    
    private String l11l111l11Il = "bj";
    
    private boolean l11l11IlIIll = false;
    
    public SmOption() {
      this.l111l1111llIl = "/deviceprofile/v4";
      this.l111l1111lI1l = "/v3/cloudconf";
    }
    
    private boolean l11l111l11Il() {
      return this.l1111l111111Il;
    }
    
    private boolean l11l111l1lll() {
      return this.l11l1111I1ll;
    }
    
    public final String l1111l111111Il() {
      String str2;
      String str1;
      StringBuilder stringBuilder = new StringBuilder();
      boolean bool = this.l111l11111Il;
      String str3 = "1";
      if (bool) {
        str2 = "1";
      } else {
        str2 = "0";
      } 
      stringBuilder.append(str2);
      if (this.l111l1111l1Il) {
        str2 = "1";
      } else {
        str2 = "0";
      } 
      stringBuilder.append(str2);
      if (this.l111l1111lIl) {
        str2 = "1";
      } else {
        str2 = "0";
      } 
      stringBuilder.append(str2);
      if (this.l11l1111lIIl) {
        str2 = "1";
      } else {
        str2 = "0";
      } 
      stringBuilder.append(str2);
      if (SmAntiFraud.l1111l111111Il() != null) {
        str2 = "1";
      } else {
        str2 = "0";
      } 
      stringBuilder.append(str2);
      Set<String> set = this.l11l1111I1l;
      if (set != null && set.size() > 0) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      stringBuilder.append(str1);
      if (this.l11l11IlIIll) {
        str1 = str3;
      } else {
        str1 = "0";
      } 
      stringBuilder.append(str1);
      return stringBuilder.toString();
    }
    
    public final boolean l111l11111I1l() {
      return this.l11l1111lIIl;
    }
    
    public final boolean l111l11111Il() {
      return this.l11l11IlIIll;
    }
    
    public final String l111l11111lIl() {
      return this.l11l111l11Il;
    }
    
    public final byte[] l111l1111l1Il() {
      return this.l11l1111Ill;
    }
    
    public final SmAntiFraud.IServerSmidCallback l111l1111lI1l() {
      return this.l11l1111I11l;
    }
    
    public final String l111l1111lIl() {
      return this.l111l1111lI1l;
    }
    
    public final String l111l1111llIl() {
      return this.l11l1111Il1l;
    }
    
    public final boolean l11l1111I11l() {
      return this.l111l1111l1Il;
    }
    
    public final boolean l11l1111I1l() {
      return this.l111l11111Il;
    }
    
    public final String l11l1111I1ll() {
      return this.l111l11111lIl;
    }
    
    public final String l11l1111Il() {
      return this.l111l11111I1l;
    }
    
    public final String l11l1111Il1l() {
      return this.l111l1111llIl;
    }
    
    public final Set<String> l11l1111Ill() {
      return this.l11l1111I1l;
    }
    
    public final boolean l11l1111lIIl() {
      return this.l111l1111lIl;
    }
    
    public final String l11l11IlIIll() {
      return this.l11l1111Il;
    }
    
    public void setAppId(String param1String) {
      this.l11l1111Il = param1String;
    }
    
    public void setArea(String param1String) {
      this.l11l111l11Il = param1String;
    }
    
    public void setChannel(String param1String) {
      this.l111l11111I1l = param1String;
    }
    
    public void setCheckCrt(boolean param1Boolean) {
      this.l11l11IlIIll = param1Boolean;
    }
    
    public void setCloudConf(boolean param1Boolean) {
      this.l111l1111l1Il = param1Boolean;
    }
    
    public void setConfUrl(String param1String) {
      this.l111l1111lI1l = param1String;
    }
    
    public void setFirst(boolean param1Boolean) {
      this.l11l1111I1ll = param1Boolean;
    }
    
    public void setHttpsCrt(byte[] param1ArrayOfbyte) {
      this.l11l1111Ill = param1ArrayOfbyte;
    }
    
    public void setNotCollect(Set<String> param1Set) {
      this.l11l1111I1l = param1Set;
    }
    
    public void setOrganization(String param1String) {
      this.l111l11111lIl = param1String;
    }
    
    public void setPublicKey(String param1String) {
      this.l11l1111Il1l = param1String;
    }
    
    public void setServerIdCallback(SmAntiFraud.IServerSmidCallback param1IServerSmidCallback) {
      this.l11l1111I11l = param1IServerSmidCallback;
    }
    
    public void setSynMode(boolean param1Boolean) {
      this.l1111l111111Il = param1Boolean;
    }
    
    public void setTransport(boolean param1Boolean) {
      this.l111l11111Il = param1Boolean;
    }
    
    public void setUrl(String param1String) {
      this.l111l1111llIl = param1String;
    }
    
    public void setUsingHttps(boolean param1Boolean) {
      this.l11l1111lIIl = param1Boolean;
    }
    
    public void setUsingMD5(boolean param1Boolean) {
      this.l111l1111lIl = param1Boolean;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\smantifraud\SmAntiFraud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */