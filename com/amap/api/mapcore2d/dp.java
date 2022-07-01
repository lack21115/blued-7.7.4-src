package com.amap.api.mapcore2d;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class dp {
  private static WeakReference<fa> a;
  
  private static boolean b = true;
  
  private static WeakReference<fu> c;
  
  private static WeakReference<fu> d;
  
  private static String[] e = new String[10];
  
  private static int f = 0;
  
  private static boolean g = false;
  
  private static int h;
  
  private static da i;
  
  static da a(Context paramContext, String paramString) {
    List<da> list2 = dm.c(paramContext);
    List<da> list1 = list2;
    if (list2 == null)
      list1 = new ArrayList<da>(); 
    if (paramString != null) {
      if ("".equals(paramString))
        return null; 
      for (da da1 : list1) {
        if (dm.a(da1.g(), paramString))
          return da1; 
      } 
      if (paramString.contains("com.amap.api.col"))
        try {
          return db.a();
        } catch (cp cp) {
          cp.printStackTrace();
        }  
      if (paramString.contains("com.amap.co") || paramString.contains("com.amap.opensdk.co") || paramString.contains("com.amap.location"))
        try {
          da da1 = db.b();
          da1.a(true);
          return da1;
        } catch (cp cp) {
          cp.printStackTrace();
        }  
    } 
    return null;
  }
  
  private static String a(Throwable paramThrowable) {
    return paramThrowable.toString();
  }
  
  static String a(List<da> paramList) {
    // Byte code:
    //   0: new java/io/File
    //   3: dup
    //   4: ldc '/data/anr/traces.txt'
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual exists : ()Z
    //   14: ifne -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new java/io/FileInputStream
    //   22: dup
    //   23: aload_3
    //   24: invokespecial <init> : (Ljava/io/File;)V
    //   27: astore #4
    //   29: aload #4
    //   31: invokevirtual available : ()I
    //   34: istore_1
    //   35: iload_1
    //   36: ldc 1024000
    //   38: if_icmple -> 52
    //   41: aload #4
    //   43: iload_1
    //   44: ldc 1024000
    //   46: isub
    //   47: i2l
    //   48: invokevirtual skip : (J)J
    //   51: pop2
    //   52: new com/amap/api/mapcore2d/eo
    //   55: dup
    //   56: aload #4
    //   58: getstatic com/amap/api/mapcore2d/ep.a : Ljava/nio/charset/Charset;
    //   61: invokespecial <init> : (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   64: astore #5
    //   66: iconst_0
    //   67: istore_1
    //   68: aload #5
    //   70: invokevirtual a : ()Ljava/lang/String;
    //   73: invokevirtual trim : ()Ljava/lang/String;
    //   76: astore #6
    //   78: iload_1
    //   79: istore_2
    //   80: aload #6
    //   82: astore_3
    //   83: aload #6
    //   85: ldc 'pid'
    //   87: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   90: ifeq -> 114
    //   93: aload #6
    //   95: astore_3
    //   96: aload_3
    //   97: ldc '"main"'
    //   99: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   102: ifne -> 442
    //   105: aload #5
    //   107: invokevirtual a : ()Ljava/lang/String;
    //   110: astore_3
    //   111: goto -> 96
    //   114: aload_3
    //   115: ldc ''
    //   117: invokevirtual equals : (Ljava/lang/Object;)Z
    //   120: ifeq -> 130
    //   123: iload_2
    //   124: ifeq -> 130
    //   127: goto -> 236
    //   130: iload_2
    //   131: istore_1
    //   132: iload_2
    //   133: ifeq -> 68
    //   136: aload_3
    //   137: invokestatic a : (Ljava/lang/String;)V
    //   140: getstatic com/amap/api/mapcore2d/dp.h : I
    //   143: iconst_5
    //   144: if_icmpne -> 150
    //   147: goto -> 236
    //   150: getstatic com/amap/api/mapcore2d/dp.g : Z
    //   153: ifne -> 216
    //   156: aload_0
    //   157: invokeinterface iterator : ()Ljava/util/Iterator;
    //   162: astore #6
    //   164: iload_2
    //   165: istore_1
    //   166: aload #6
    //   168: invokeinterface hasNext : ()Z
    //   173: ifeq -> 68
    //   176: aload #6
    //   178: invokeinterface next : ()Ljava/lang/Object;
    //   183: checkcast com/amap/api/mapcore2d/da
    //   186: astore #7
    //   188: aload #7
    //   190: invokevirtual g : ()[Ljava/lang/String;
    //   193: aload_3
    //   194: invokestatic b : ([Ljava/lang/String;Ljava/lang/String;)Z
    //   197: putstatic com/amap/api/mapcore2d/dp.g : Z
    //   200: getstatic com/amap/api/mapcore2d/dp.g : Z
    //   203: ifeq -> 164
    //   206: aload #7
    //   208: putstatic com/amap/api/mapcore2d/dp.i : Lcom/amap/api/mapcore2d/da;
    //   211: iload_2
    //   212: istore_1
    //   213: goto -> 68
    //   216: getstatic com/amap/api/mapcore2d/dp.h : I
    //   219: iconst_1
    //   220: iadd
    //   221: putstatic com/amap/api/mapcore2d/dp.h : I
    //   224: iload_2
    //   225: istore_1
    //   226: goto -> 68
    //   229: astore_3
    //   230: aload #5
    //   232: astore_0
    //   233: goto -> 290
    //   236: aload #5
    //   238: invokevirtual close : ()V
    //   241: goto -> 253
    //   244: astore_0
    //   245: aload_0
    //   246: ldc 'alg'
    //   248: ldc 'getA'
    //   250: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload #4
    //   255: invokevirtual close : ()V
    //   258: goto -> 411
    //   261: astore_0
    //   262: aload_0
    //   263: ldc 'alg'
    //   265: ldc 'getA'
    //   267: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   270: goto -> 411
    //   273: astore_3
    //   274: aconst_null
    //   275: astore_0
    //   276: goto -> 290
    //   279: aconst_null
    //   280: astore_0
    //   281: goto -> 381
    //   284: astore_3
    //   285: aconst_null
    //   286: astore_0
    //   287: aload_0
    //   288: astore #4
    //   290: aload_3
    //   291: ldc 'alg'
    //   293: ldc 'getA'
    //   295: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_0
    //   299: ifnull -> 318
    //   302: aload_0
    //   303: invokevirtual close : ()V
    //   306: goto -> 318
    //   309: astore_0
    //   310: aload_0
    //   311: ldc 'alg'
    //   313: ldc 'getA'
    //   315: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload #4
    //   320: ifnull -> 411
    //   323: aload #4
    //   325: invokevirtual close : ()V
    //   328: goto -> 411
    //   331: astore_3
    //   332: aload_0
    //   333: ifnull -> 352
    //   336: aload_0
    //   337: invokevirtual close : ()V
    //   340: goto -> 352
    //   343: astore_0
    //   344: aload_0
    //   345: ldc 'alg'
    //   347: ldc 'getA'
    //   349: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload #4
    //   354: ifnull -> 374
    //   357: aload #4
    //   359: invokevirtual close : ()V
    //   362: goto -> 374
    //   365: astore_0
    //   366: aload_0
    //   367: ldc 'alg'
    //   369: ldc 'getA'
    //   371: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_3
    //   375: athrow
    //   376: aconst_null
    //   377: astore_0
    //   378: aload_0
    //   379: astore #4
    //   381: aload_0
    //   382: ifnull -> 401
    //   385: aload_0
    //   386: invokevirtual close : ()V
    //   389: goto -> 401
    //   392: astore_0
    //   393: aload_0
    //   394: ldc 'alg'
    //   396: ldc 'getA'
    //   398: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload #4
    //   403: ifnull -> 411
    //   406: aload #4
    //   408: invokevirtual close : ()V
    //   411: getstatic com/amap/api/mapcore2d/dp.g : Z
    //   414: ifeq -> 421
    //   417: invokestatic b : ()Ljava/lang/String;
    //   420: areturn
    //   421: aconst_null
    //   422: areturn
    //   423: astore_0
    //   424: goto -> 376
    //   427: astore_0
    //   428: goto -> 279
    //   431: astore_0
    //   432: goto -> 236
    //   435: astore_0
    //   436: aload #5
    //   438: astore_0
    //   439: goto -> 381
    //   442: iconst_1
    //   443: istore_2
    //   444: goto -> 114
    // Exception table:
    //   from	to	target	type
    //   0	17	423	java/io/FileNotFoundException
    //   0	17	284	finally
    //   19	29	423	java/io/FileNotFoundException
    //   19	29	284	finally
    //   29	35	427	java/io/FileNotFoundException
    //   29	35	273	finally
    //   41	52	427	java/io/FileNotFoundException
    //   41	52	273	finally
    //   52	66	427	java/io/FileNotFoundException
    //   52	66	273	finally
    //   68	78	431	java/io/EOFException
    //   68	78	435	java/io/FileNotFoundException
    //   68	78	229	finally
    //   83	93	431	java/io/EOFException
    //   83	93	435	java/io/FileNotFoundException
    //   83	93	229	finally
    //   96	111	431	java/io/EOFException
    //   96	111	435	java/io/FileNotFoundException
    //   96	111	229	finally
    //   114	123	431	java/io/EOFException
    //   114	123	435	java/io/FileNotFoundException
    //   114	123	229	finally
    //   136	147	431	java/io/EOFException
    //   136	147	435	java/io/FileNotFoundException
    //   136	147	229	finally
    //   150	164	431	java/io/EOFException
    //   150	164	435	java/io/FileNotFoundException
    //   150	164	229	finally
    //   166	211	431	java/io/EOFException
    //   166	211	435	java/io/FileNotFoundException
    //   166	211	229	finally
    //   216	224	431	java/io/EOFException
    //   216	224	435	java/io/FileNotFoundException
    //   216	224	229	finally
    //   236	241	244	finally
    //   253	258	261	finally
    //   290	298	331	finally
    //   302	306	309	finally
    //   323	328	261	finally
    //   336	340	343	finally
    //   357	362	365	finally
    //   385	389	392	finally
    //   406	411	261	finally
  }
  
  static void a(Context paramContext) {
    List<da> list = dm.c(paramContext);
    if (list != null) {
      if (list.size() == 0)
        return; 
      String str = a(list);
      if (str != null && !"".equals(str)) {
        da da1 = i;
        if (da1 == null)
          return; 
        a(paramContext, da1, 2, "ANR", str);
      } 
    } 
  }
  
  private static void a(Context paramContext, da paramda, int paramInt, String paramString1, String paramString2) {
    String str2 = fh.a();
    String str1 = fh.a(paramContext, paramda);
    paramString1 = fh.a(cq.a(paramContext), str1, str2, paramInt, paramString1, paramString2);
    if (paramString1 != null) {
      if ("".equals(paramString1))
        return; 
      paramString2 = cx.c(paramString2);
      if (paramInt == 1) {
        str1 = dm.b;
      } else if (paramInt == 2) {
        str1 = dm.d;
      } else if (paramInt == 0) {
        str1 = dm.c;
      } else {
        return;
      } 
      a(paramContext, paramString2, str1, paramString1);
    } 
  }
  
  private static void a(Context paramContext, fu paramfu, String paramString) {
    do.d().submit(new Runnable(paramContext, paramString, paramfu) {
          public void run() {
            // Byte code:
            //   0: ldc com/amap/api/mapcore2d/dp
            //   2: monitorenter
            //   3: invokestatic a : ()Ljava/lang/ref/WeakReference;
            //   6: invokestatic a : (Ljava/lang/ref/WeakReference;)Lcom/amap/api/mapcore2d/fa;
            //   9: astore_1
            //   10: aload_0
            //   11: getfield a : Landroid/content/Context;
            //   14: aload_1
            //   15: aload_0
            //   16: getfield b : Ljava/lang/String;
            //   19: sipush #1000
            //   22: ldc 40960
            //   24: ldc '1'
            //   26: invokestatic a : (Landroid/content/Context;Lcom/amap/api/mapcore2d/fa;Ljava/lang/String;IILjava/lang/String;)V
            //   29: aload_1
            //   30: aload_0
            //   31: getfield c : Lcom/amap/api/mapcore2d/fu;
            //   34: putfield f : Lcom/amap/api/mapcore2d/fu;
            //   37: aload_1
            //   38: getfield g : Lcom/amap/api/mapcore2d/fo;
            //   41: ifnonnull -> 164
            //   44: aload_1
            //   45: new com/amap/api/mapcore2d/fl
            //   48: dup
            //   49: new com/amap/api/mapcore2d/fk
            //   52: dup
            //   53: aload_0
            //   54: getfield a : Landroid/content/Context;
            //   57: new com/amap/api/mapcore2d/fp
            //   60: dup
            //   61: invokespecial <init> : ()V
            //   64: new com/amap/api/mapcore2d/de
            //   67: dup
            //   68: new com/amap/api/mapcore2d/dg
            //   71: dup
            //   72: new com/amap/api/mapcore2d/di
            //   75: dup
            //   76: invokespecial <init> : ()V
            //   79: invokespecial <init> : (Lcom/amap/api/mapcore2d/df;)V
            //   82: invokespecial <init> : (Lcom/amap/api/mapcore2d/df;)V
            //   85: ldc 'EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA='
            //   87: bipush #7
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
            //   108: invokestatic v : (Landroid/content/Context;)Ljava/lang/String;
            //   111: aastore
            //   112: dup
            //   113: iconst_2
            //   114: aload_0
            //   115: getfield a : Landroid/content/Context;
            //   118: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
            //   121: aastore
            //   122: dup
            //   123: iconst_3
            //   124: getstatic android/os/Build.MODEL : Ljava/lang/String;
            //   127: aastore
            //   128: dup
            //   129: iconst_4
            //   130: aload_0
            //   131: getfield a : Landroid/content/Context;
            //   134: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
            //   137: aastore
            //   138: dup
            //   139: iconst_5
            //   140: aload_0
            //   141: getfield a : Landroid/content/Context;
            //   144: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
            //   147: aastore
            //   148: dup
            //   149: bipush #6
            //   151: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
            //   154: aastore
            //   155: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/fo;Lcom/amap/api/mapcore2d/df;Ljava/lang/String;[Ljava/lang/Object;)V
            //   158: invokespecial <init> : (Lcom/amap/api/mapcore2d/fo;)V
            //   161: putfield g : Lcom/amap/api/mapcore2d/fo;
            //   164: aload_1
            //   165: ldc 3600000
            //   167: putfield h : I
            //   170: aload_1
            //   171: invokestatic a : (Lcom/amap/api/mapcore2d/fa;)V
            //   174: ldc com/amap/api/mapcore2d/dp
            //   176: monitorexit
            //   177: return
            //   178: astore_1
            //   179: ldc com/amap/api/mapcore2d/dp
            //   181: monitorexit
            //   182: aload_1
            //   183: athrow
            //   184: astore_1
            //   185: aload_1
            //   186: ldc 'lg'
            //   188: ldc 'pul'
            //   190: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
            //   193: return
            // Exception table:
            //   from	to	target	type
            //   0	3	184	finally
            //   3	164	178	finally
            //   164	177	178	finally
            //   179	182	178	finally
            //   182	184	184	finally
          }
        });
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    fa fa = fh.a(a);
    fh.a(paramContext, fa, paramString2, 1000, 40960, "1");
    if (fa.e == null)
      fa.e = new dd(new de(new dg(new di()))); 
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Context paramContext, Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {
    String str2 = db.a(paramThrowable);
    da da1 = a(paramContext, str2);
    if (!a(da1))
      return; 
    str2 = str2.replaceAll("\n", "<br/>");
    String str1 = a(paramThrowable);
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
        stringBuilder.append("$");
        stringBuilder.append("<br/>");
      } 
      stringBuilder.append(str2);
      a(paramContext, da1, paramInt, str1, stringBuilder.toString());
    } 
  }
  
  static void a(da paramda, Context paramContext, String paramString1, String paramString2) {
    if (!a(paramda))
      return; 
    if (paramString1 != null) {
      if ("".equals(paramString1))
        return; 
      a(paramContext, paramda, 0, paramString1, paramString2);
    } 
  }
  
  private static void a(String paramString) {
    try {
      if (f > 9)
        f = 0; 
      return;
    } finally {
      paramString = null;
      do.c((Throwable)paramString, "alg", "aDa");
    } 
  }
  
  private static boolean a(da paramda) {
    return (paramda != null && paramda.f());
  }
  
  private static String b() {
    int i;
    StringBuilder stringBuilder = new StringBuilder();
    try {
      i = f;
    } finally {
      Exception exception = null;
      do.c(exception, "alg", "gLI");
    } 
    return stringBuilder.toString();
  }
  
  static void b(Context paramContext) {
    fs fs = new fs(b);
    b = false;
    a(paramContext, fs, dm.c);
  }
  
  static void b(da paramda, Context paramContext, String paramString1, String paramString2) {
    if (!a(paramda))
      return; 
    if (paramString1 != null) {
      if ("".equals(paramString1))
        return; 
      a(paramContext, paramda, 1, paramString1, paramString2);
    } 
  }
  
  static void c(Context paramContext) {
    WeakReference<fu> weakReference = c;
    if (weakReference == null || weakReference.get() == null)
      c = new WeakReference<fu>(new ft(paramContext, 3600000, "hKey", new fv(paramContext, false))); 
    a(paramContext, c.get(), dm.d);
  }
  
  static void d(Context paramContext) {
    WeakReference<fu> weakReference = d;
    if (weakReference == null || weakReference.get() == null)
      d = new WeakReference<fu>(new ft(paramContext, 3600000, "gKey", new fv(paramContext, false))); 
    a(paramContext, d.get(), dm.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */