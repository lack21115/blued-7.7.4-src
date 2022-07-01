package com.loc;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ac {
  private static WeakReference<ax> a;
  
  private static boolean b = true;
  
  private static WeakReference<bq> c;
  
  private static WeakReference<bq> d;
  
  private static String[] e = new String[10];
  
  private static int f = 0;
  
  private static boolean g = false;
  
  private static int h;
  
  private static t i;
  
  private static t a(String paramString) {
    List<t> list2 = z.a();
    List<t> list1 = list2;
    if (list2 == null)
      list1 = new ArrayList<t>(); 
    if (paramString != null) {
      if ("".equals(paramString))
        return null; 
      for (t t1 : list1) {
        if (z.a(t1.f(), paramString))
          return t1; 
      } 
      if (paramString.contains("com.amap.api.col"))
        try {
          return u.a();
        } catch (j j) {
          j.printStackTrace();
        }  
      if (paramString.contains("com.amap.co") || paramString.contains("com.amap.opensdk.co") || paramString.contains("com.amap.location"))
        try {
          t t1 = u.b();
          t1.a(true);
          return t1;
        } catch (j j) {
          j.printStackTrace();
        }  
    } 
    return null;
  }
  
  private static String a(List<t> paramList) {
    // Byte code:
    //   0: new java/io/File
    //   3: dup
    //   4: ldc '/data/anr/traces.txt'
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: astore #4
    //   11: aload #4
    //   13: invokevirtual exists : ()Z
    //   16: ifne -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new java/io/FileInputStream
    //   24: dup
    //   25: aload #4
    //   27: invokespecial <init> : (Ljava/io/File;)V
    //   30: astore #5
    //   32: aload #5
    //   34: invokevirtual available : ()I
    //   37: istore_1
    //   38: iload_1
    //   39: ldc 1024000
    //   41: if_icmple -> 55
    //   44: aload #5
    //   46: iload_1
    //   47: ldc 1024000
    //   49: isub
    //   50: i2l
    //   51: invokevirtual skip : (J)J
    //   54: pop2
    //   55: new com/loc/ap
    //   58: dup
    //   59: aload #5
    //   61: getstatic com/loc/ao.b : Ljava/nio/charset/Charset;
    //   64: invokespecial <init> : (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   67: astore #6
    //   69: iconst_0
    //   70: istore_1
    //   71: aload #6
    //   73: invokevirtual a : ()Ljava/lang/String;
    //   76: invokevirtual trim : ()Ljava/lang/String;
    //   79: astore #7
    //   81: iload_1
    //   82: istore_2
    //   83: aload #7
    //   85: astore #4
    //   87: aload #7
    //   89: ldc 'pid'
    //   91: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   94: ifeq -> 121
    //   97: aload #7
    //   99: astore #4
    //   101: aload #4
    //   103: ldc '"main"'
    //   105: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   108: ifne -> 498
    //   111: aload #6
    //   113: invokevirtual a : ()Ljava/lang/String;
    //   116: astore #4
    //   118: goto -> 101
    //   121: aload #4
    //   123: ldc ''
    //   125: invokevirtual equals : (Ljava/lang/Object;)Z
    //   128: istore_3
    //   129: iload_3
    //   130: ifeq -> 140
    //   133: iload_2
    //   134: ifeq -> 140
    //   137: goto -> 287
    //   140: iload_2
    //   141: istore_1
    //   142: iload_2
    //   143: ifeq -> 71
    //   146: getstatic com/loc/ac.f : I
    //   149: bipush #9
    //   151: if_icmple -> 158
    //   154: iconst_0
    //   155: putstatic com/loc/ac.f : I
    //   158: getstatic com/loc/ac.e : [Ljava/lang/String;
    //   161: getstatic com/loc/ac.f : I
    //   164: aload #4
    //   166: aastore
    //   167: getstatic com/loc/ac.f : I
    //   170: iconst_1
    //   171: iadd
    //   172: putstatic com/loc/ac.f : I
    //   175: goto -> 189
    //   178: astore #7
    //   180: aload #7
    //   182: ldc 'alg'
    //   184: ldc 'aDa'
    //   186: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   189: getstatic com/loc/ac.h : I
    //   192: iconst_5
    //   193: if_icmpne -> 199
    //   196: goto -> 287
    //   199: getstatic com/loc/ac.g : Z
    //   202: ifne -> 266
    //   205: aload_0
    //   206: invokeinterface iterator : ()Ljava/util/Iterator;
    //   211: astore #7
    //   213: iload_2
    //   214: istore_1
    //   215: aload #7
    //   217: invokeinterface hasNext : ()Z
    //   222: ifeq -> 71
    //   225: aload #7
    //   227: invokeinterface next : ()Ljava/lang/Object;
    //   232: checkcast com/loc/t
    //   235: astore #8
    //   237: aload #8
    //   239: invokevirtual f : ()[Ljava/lang/String;
    //   242: aload #4
    //   244: invokestatic b : ([Ljava/lang/String;Ljava/lang/String;)Z
    //   247: istore_3
    //   248: iload_3
    //   249: putstatic com/loc/ac.g : Z
    //   252: iload_3
    //   253: ifeq -> 213
    //   256: aload #8
    //   258: putstatic com/loc/ac.i : Lcom/loc/t;
    //   261: iload_2
    //   262: istore_1
    //   263: goto -> 71
    //   266: getstatic com/loc/ac.h : I
    //   269: iconst_1
    //   270: iadd
    //   271: putstatic com/loc/ac.h : I
    //   274: iload_2
    //   275: istore_1
    //   276: goto -> 71
    //   279: astore #4
    //   281: aload #6
    //   283: astore_0
    //   284: goto -> 331
    //   287: aload #6
    //   289: invokevirtual close : ()V
    //   292: goto -> 304
    //   295: astore_0
    //   296: aload_0
    //   297: ldc 'alg'
    //   299: ldc 'getA'
    //   301: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload #5
    //   306: invokevirtual close : ()V
    //   309: goto -> 467
    //   312: astore #4
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -> 331
    //   319: aconst_null
    //   320: astore_0
    //   321: goto -> 425
    //   324: astore #4
    //   326: aconst_null
    //   327: astore_0
    //   328: aload_0
    //   329: astore #5
    //   331: aload #4
    //   333: ldc 'alg'
    //   335: ldc 'getA'
    //   337: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload_0
    //   341: ifnull -> 360
    //   344: aload_0
    //   345: invokevirtual close : ()V
    //   348: goto -> 360
    //   351: astore_0
    //   352: aload_0
    //   353: ldc 'alg'
    //   355: ldc 'getA'
    //   357: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload #5
    //   362: ifnull -> 467
    //   365: aload #5
    //   367: invokevirtual close : ()V
    //   370: goto -> 467
    //   373: astore #4
    //   375: aload_0
    //   376: ifnull -> 395
    //   379: aload_0
    //   380: invokevirtual close : ()V
    //   383: goto -> 395
    //   386: astore_0
    //   387: aload_0
    //   388: ldc 'alg'
    //   390: ldc 'getA'
    //   392: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload #5
    //   397: ifnull -> 417
    //   400: aload #5
    //   402: invokevirtual close : ()V
    //   405: goto -> 417
    //   408: astore_0
    //   409: aload_0
    //   410: ldc 'alg'
    //   412: ldc 'getA'
    //   414: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload #4
    //   419: athrow
    //   420: aconst_null
    //   421: astore_0
    //   422: aload_0
    //   423: astore #5
    //   425: aload_0
    //   426: ifnull -> 445
    //   429: aload_0
    //   430: invokevirtual close : ()V
    //   433: goto -> 445
    //   436: astore_0
    //   437: aload_0
    //   438: ldc 'alg'
    //   440: ldc 'getA'
    //   442: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload #5
    //   447: ifnull -> 467
    //   450: aload #5
    //   452: invokevirtual close : ()V
    //   455: goto -> 467
    //   458: astore_0
    //   459: aload_0
    //   460: ldc 'alg'
    //   462: ldc 'getA'
    //   464: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   467: getstatic com/loc/ac.g : Z
    //   470: ifeq -> 477
    //   473: invokestatic b : ()Ljava/lang/String;
    //   476: areturn
    //   477: aconst_null
    //   478: areturn
    //   479: astore_0
    //   480: goto -> 420
    //   483: astore_0
    //   484: goto -> 319
    //   487: astore_0
    //   488: goto -> 287
    //   491: astore_0
    //   492: aload #6
    //   494: astore_0
    //   495: goto -> 425
    //   498: iconst_1
    //   499: istore_2
    //   500: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   0	19	479	java/io/FileNotFoundException
    //   0	19	324	finally
    //   21	32	479	java/io/FileNotFoundException
    //   21	32	324	finally
    //   32	38	483	java/io/FileNotFoundException
    //   32	38	312	finally
    //   44	55	483	java/io/FileNotFoundException
    //   44	55	312	finally
    //   55	69	483	java/io/FileNotFoundException
    //   55	69	312	finally
    //   71	81	487	java/io/EOFException
    //   71	81	491	java/io/FileNotFoundException
    //   71	81	279	finally
    //   87	97	487	java/io/EOFException
    //   87	97	491	java/io/FileNotFoundException
    //   87	97	279	finally
    //   101	118	487	java/io/EOFException
    //   101	118	491	java/io/FileNotFoundException
    //   101	118	279	finally
    //   121	129	487	java/io/EOFException
    //   121	129	491	java/io/FileNotFoundException
    //   121	129	279	finally
    //   146	158	178	finally
    //   158	175	178	finally
    //   180	189	487	java/io/EOFException
    //   180	189	491	java/io/FileNotFoundException
    //   180	189	279	finally
    //   189	196	487	java/io/EOFException
    //   189	196	491	java/io/FileNotFoundException
    //   189	196	279	finally
    //   199	213	487	java/io/EOFException
    //   199	213	491	java/io/FileNotFoundException
    //   199	213	279	finally
    //   215	252	487	java/io/EOFException
    //   215	252	491	java/io/FileNotFoundException
    //   215	252	279	finally
    //   256	261	487	java/io/EOFException
    //   256	261	491	java/io/FileNotFoundException
    //   256	261	279	finally
    //   266	274	487	java/io/EOFException
    //   266	274	491	java/io/FileNotFoundException
    //   266	274	279	finally
    //   287	292	295	finally
    //   304	309	458	finally
    //   331	340	373	finally
    //   344	348	351	finally
    //   365	370	458	finally
    //   379	383	386	finally
    //   400	405	408	finally
    //   429	433	436	finally
    //   450	455	458	finally
  }
  
  static void a(Context paramContext) {
    List<t> list = z.a();
    if (list != null) {
      if (list.size() == 0)
        return; 
      String str = a(list);
      if (str != null && !"".equals(str)) {
        t t1 = i;
        if (t1 == null)
          return; 
        a(paramContext, t1, 2, "ANR", str);
      } 
    } 
  }
  
  private static void a(Context paramContext, bq parambq, String paramString) {
    ab.d().submit(new Runnable(paramContext, paramString, parambq) {
          public final void run() {
            // Byte code:
            //   0: ldc com/loc/ac
            //   2: monitorenter
            //   3: invokestatic a : ()Ljava/lang/ref/WeakReference;
            //   6: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/loc/ax;
            //   9: astore_1
            //   10: aload_0
            //   11: getfield a : Landroid/content/Context;
            //   14: aload_1
            //   15: aload_0
            //   16: getfield b : Ljava/lang/String;
            //   19: sipush #1000
            //   22: ldc 4096000
            //   24: ldc '1'
            //   26: invokestatic a : (Landroid/content/Context;Lcom/loc/ax;Ljava/lang/String;IILjava/lang/String;)V
            //   29: aload_1
            //   30: aload_0
            //   31: getfield c : Lcom/loc/bq;
            //   34: putfield f : Lcom/loc/bq;
            //   37: aload_1
            //   38: getfield g : Lcom/loc/bk;
            //   41: ifnonnull -> 175
            //   44: aload_1
            //   45: new com/loc/bh
            //   48: dup
            //   49: new com/loc/bg
            //   52: dup
            //   53: aload_0
            //   54: getfield a : Landroid/content/Context;
            //   57: new com/loc/bl
            //   60: dup
            //   61: invokespecial <init> : ()V
            //   64: new com/loc/aj
            //   67: dup
            //   68: new com/loc/al
            //   71: dup
            //   72: new com/loc/an
            //   75: dup
            //   76: invokespecial <init> : ()V
            //   79: invokespecial <init> : (Lcom/loc/ak;)V
            //   82: invokespecial <init> : (Lcom/loc/ak;)V
            //   85: ldc 'QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi'
            //   87: bipush #8
            //   89: anewarray java/lang/Object
            //   92: dup
            //   93: iconst_0
            //   94: aload_0
            //   95: getfield a : Landroid/content/Context;
            //   98: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
            //   101: aastore
            //   102: dup
            //   103: iconst_1
            //   104: aload_0
            //   105: getfield a : Landroid/content/Context;
            //   108: invokestatic x : (Landroid/content/Context;)Ljava/lang/String;
            //   111: aastore
            //   112: dup
            //   113: iconst_2
            //   114: aload_0
            //   115: getfield a : Landroid/content/Context;
            //   118: invokestatic w : (Landroid/content/Context;)Ljava/lang/String;
            //   121: aastore
            //   122: dup
            //   123: iconst_3
            //   124: aload_0
            //   125: getfield a : Landroid/content/Context;
            //   128: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
            //   131: aastore
            //   132: dup
            //   133: iconst_4
            //   134: getstatic android/os/Build.MODEL : Ljava/lang/String;
            //   137: aastore
            //   138: dup
            //   139: iconst_5
            //   140: aload_0
            //   141: getfield a : Landroid/content/Context;
            //   144: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
            //   147: aastore
            //   148: dup
            //   149: bipush #6
            //   151: aload_0
            //   152: getfield a : Landroid/content/Context;
            //   155: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
            //   158: aastore
            //   159: dup
            //   160: bipush #7
            //   162: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
            //   165: aastore
            //   166: invokespecial <init> : (Landroid/content/Context;Lcom/loc/bk;Lcom/loc/ak;Ljava/lang/String;[Ljava/lang/Object;)V
            //   169: invokespecial <init> : (Lcom/loc/bk;)V
            //   172: putfield g : Lcom/loc/bk;
            //   175: aload_1
            //   176: ldc 3600000
            //   178: putfield h : I
            //   181: aload_1
            //   182: invokestatic a : (Lcom/loc/ax;)I
            //   185: pop
            //   186: ldc com/loc/ac
            //   188: monitorexit
            //   189: return
            //   190: astore_1
            //   191: ldc com/loc/ac
            //   193: monitorexit
            //   194: aload_1
            //   195: athrow
            //   196: astore_1
            //   197: aload_1
            //   198: ldc 'lg'
            //   200: ldc 'pul'
            //   202: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
            //   205: return
            // Exception table:
            //   from	to	target	type
            //   0	3	196	finally
            //   3	175	190	finally
            //   175	189	190	finally
            //   191	194	190	finally
            //   194	196	196	finally
          }
        });
  }
  
  private static void a(Context paramContext, t paramt, int paramInt, String paramString1, String paramString2) {
    String str2 = u.a(System.currentTimeMillis());
    String str1 = bd.a(paramContext, paramt);
    k.a(paramContext);
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(str1);
    stringBuffer.append(",\"timestamp\":\"");
    stringBuffer.append(str2);
    stringBuffer.append("\",\"et\":\"");
    stringBuffer.append(paramInt);
    stringBuffer.append("\",\"classname\":\"");
    stringBuffer.append(paramString1);
    stringBuffer.append("\",");
    stringBuffer.append("\"detail\":\"");
    stringBuffer.append(paramString2);
    stringBuffer.append("\"");
    paramString1 = stringBuffer.toString();
    if (paramString1 != null) {
      if ("".equals(paramString1))
        return; 
      paramString2 = r.b(paramString2);
      if (paramInt == 1) {
        str1 = z.b;
      } else if (paramInt == 2) {
        str1 = z.d;
      } else if (paramInt == 0) {
        str1 = z.c;
      } else {
        return;
      } 
      ax ax = bd.a(a);
      bd.a(paramContext, ax, str1, 1000, 4096000, "1");
      if (ax.e == null)
        ax.e = new ai(new aj(new al(new an()))); 
      try {
        return;
      } finally {
        paramContext = null;
      } 
    } 
  }
  
  public static void a(Context paramContext, Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {
    String str2 = u.a(paramThrowable);
    t t1 = a(str2);
    if (!a(t1))
      return; 
    str2 = str2.replaceAll("\n", "<br/>");
    String str1 = paramThrowable.toString();
    if (str1 != null) {
      if ("".equals(str1))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      if (paramString1 != null) {
        stringBuilder.append("class:");
        stringBuilder.append(paramString1);
      } 
      if (paramString2 != null) {
        stringBuilder.append(" method:");
        stringBuilder.append(paramString2);
        stringBuilder.append("$<br/>");
      } 
      stringBuilder.append(str2);
      a(paramContext, t1, paramInt, str1, stringBuilder.toString());
    } 
  }
  
  static void a(t paramt, Context paramContext, String paramString1, String paramString2) {
    if (!a(paramt))
      return; 
    if (paramString1 != null) {
      if ("".equals(paramString1))
        return; 
      a(paramContext, paramt, 1, paramString1, paramString2);
    } 
  }
  
  private static boolean a(t paramt) {
    return (paramt != null && paramt.e());
  }
  
  private static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      int j;
    } finally {
      Exception exception = null;
      ab.b(exception, "alg", "gLI");
    } 
    int i;
    for (i = 0; i < f; i++)
      stringBuilder.append(e[i]); 
    return stringBuilder.toString();
  }
  
  static void b(Context paramContext) {
    bo bo = new bo(b);
    b = false;
    a(paramContext, bo, z.c);
  }
  
  static void c(Context paramContext) {
    WeakReference<bq> weakReference = c;
    if (weakReference == null || weakReference.get() == null)
      c = new WeakReference<bq>(new bp(paramContext, 3600000, "hKey", new br(paramContext))); 
    a(paramContext, c.get(), z.d);
  }
  
  static void d(Context paramContext) {
    WeakReference<bq> weakReference = d;
    if (weakReference == null || weakReference.get() == null)
      d = new WeakReference<bq>(new bp(paramContext, 3600000, "gKey", new br(paramContext))); 
    a(paramContext, d.get(), z.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */