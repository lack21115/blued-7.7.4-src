package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

public class eb {
  static String a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    stringBuilder.append(File.separator);
    stringBuilder.append("pngex");
    return stringBuilder.toString();
  }
  
  static String a(Context paramContext, dt paramdt, da paramda) {
    List<ee> list = paramdt.b(ee.b(paramda.a(), "copy"), ee.class);
    if (list != null) {
      if (list.size() == 0)
        return null; 
      eh.a(list);
      for (int i = 0; i < list.size(); i++) {
        ee ee = list.get(i);
        if (eh.a(paramContext, paramdt, ee.a(), paramda)) {
          try {
            return ee.e();
          } finally {
            ee = null;
          } 
        } else {
          c(paramContext, paramdt, ee.a());
        } 
      } 
    } 
    return null;
  }
  
  public static String a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a(paramContext));
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  static String a(Context paramContext, String paramString1, String paramString2) {
    String str = cu.v(paramContext);
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append(paramString2);
    stringBuilder2.append(str);
    stringBuilder1.append(cx.b(stringBuilder2.toString()));
    stringBuilder1.append(".jar");
    return stringBuilder1.toString();
  }
  
  static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(".o");
    return stringBuilder.toString();
  }
  
  static void a(Context paramContext, da paramda) {
    // Byte code:
    //   0: invokestatic b : ()Lcom/amap/api/mapcore2d/eg;
    //   3: aload_1
    //   4: invokevirtual a : (Lcom/amap/api/mapcore2d/da;)Lcom/amap/api/mapcore2d/eg$a;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull -> 35
    //   12: aload_2
    //   13: getfield a : Z
    //   16: ifeq -> 35
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_2
    //   22: invokevirtual wait : ()V
    //   25: aload_2
    //   26: monitorexit
    //   27: goto -> 35
    //   30: astore_0
    //   31: aload_2
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    //   35: aload_2
    //   36: iconst_1
    //   37: putfield b : Z
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual a : ()Ljava/lang/String;
    //   45: aload_1
    //   46: invokevirtual b : ()Ljava/lang/String;
    //   49: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore #4
    //   54: aload #4
    //   56: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   59: ifeq -> 63
    //   62: return
    //   63: new java/io/File
    //   66: dup
    //   67: aload #4
    //   69: invokespecial <init> : (Ljava/lang/String;)V
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual getParentFile : ()Ljava/io/File;
    //   77: astore #5
    //   79: aload_3
    //   80: invokevirtual exists : ()Z
    //   83: ifne -> 112
    //   86: aload #5
    //   88: ifnull -> 169
    //   91: aload #5
    //   93: invokevirtual exists : ()Z
    //   96: ifeq -> 169
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual a : ()Ljava/lang/String;
    //   104: aload_1
    //   105: invokevirtual b : ()Ljava/lang/String;
    //   108: invokestatic c : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   111: return
    //   112: aload_0
    //   113: aload_3
    //   114: invokevirtual getName : ()Ljava/lang/String;
    //   117: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   120: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   123: astore #5
    //   125: aload #4
    //   127: aload #5
    //   129: iconst_0
    //   130: invokestatic loadDex : (Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    //   133: astore #4
    //   135: aload #4
    //   137: ifnull -> 153
    //   140: aload #4
    //   142: invokevirtual close : ()V
    //   145: aload_0
    //   146: aload_3
    //   147: aload #5
    //   149: aload_1
    //   150: invokestatic a : (Landroid/content/Context;Ljava/io/File;Ljava/lang/String;Lcom/amap/api/mapcore2d/da;)V
    //   153: aload_2
    //   154: iconst_0
    //   155: putfield b : Z
    //   158: return
    //   159: astore_0
    //   160: aload_0
    //   161: ldc 'BaseLoader'
    //   163: ldc 'getInstanceByThread()'
    //   165: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   168: return
    //   169: return
    // Exception table:
    //   from	to	target	type
    //   0	8	159	finally
    //   12	21	159	finally
    //   21	27	30	finally
    //   31	33	30	finally
    //   33	35	159	finally
    //   35	62	159	finally
    //   63	86	159	finally
    //   91	111	159	finally
    //   112	135	159	finally
    //   140	153	159	finally
    //   153	158	159	finally
  }
  
  static void a(Context paramContext, dt paramdt, da paramda, String paramString1, String paramString2) throws Throwable {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aload_2
    //   4: invokevirtual a : ()Ljava/lang/String;
    //   7: astore #10
    //   9: invokestatic b : ()Lcom/amap/api/mapcore2d/eg;
    //   12: aload_2
    //   13: invokevirtual a : (Lcom/amap/api/mapcore2d/da;)Lcom/amap/api/mapcore2d/eg$a;
    //   16: astore #7
    //   18: aload #7
    //   20: ifnull -> 51
    //   23: aload #7
    //   25: getfield a : Z
    //   28: ifeq -> 51
    //   31: aload #7
    //   33: monitorenter
    //   34: aload #7
    //   36: invokevirtual wait : ()V
    //   39: aload #7
    //   41: monitorexit
    //   42: goto -> 51
    //   45: astore_0
    //   46: aload #7
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    //   51: aload #7
    //   53: iconst_1
    //   54: putfield b : Z
    //   57: aload_0
    //   58: aload #10
    //   60: aload_2
    //   61: invokevirtual b : ()Ljava/lang/String;
    //   64: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: astore #11
    //   69: aload_0
    //   70: aload_1
    //   71: aload #11
    //   73: invokestatic a : (Landroid/content/Context;Lcom/amap/api/mapcore2d/dt;Ljava/lang/String;)V
    //   76: new java/io/FileInputStream
    //   79: dup
    //   80: new java/io/File
    //   83: dup
    //   84: aload_3
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: invokespecial <init> : (Ljava/io/File;)V
    //   91: astore #9
    //   93: aload #9
    //   95: bipush #32
    //   97: newarray byte
    //   99: invokevirtual read : ([B)I
    //   102: pop
    //   103: new java/io/File
    //   106: dup
    //   107: aload_0
    //   108: aload #10
    //   110: aload_2
    //   111: invokevirtual b : ()Ljava/lang/String;
    //   114: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: invokespecial <init> : (Ljava/lang/String;)V
    //   120: astore_0
    //   121: new java/io/RandomAccessFile
    //   124: dup
    //   125: aload_0
    //   126: ldc 'rw'
    //   128: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   131: astore_3
    //   132: sipush #1024
    //   135: newarray byte
    //   137: astore #8
    //   139: iconst_0
    //   140: istore #5
    //   142: aload #9
    //   144: aload #8
    //   146: invokevirtual read : ([B)I
    //   149: istore #6
    //   151: iload #6
    //   153: ifle -> 213
    //   156: iload #6
    //   158: sipush #1024
    //   161: if_icmpne -> 180
    //   164: aload_3
    //   165: iload #5
    //   167: i2l
    //   168: invokevirtual seek : (J)V
    //   171: aload_3
    //   172: aload #8
    //   174: invokevirtual write : ([B)V
    //   177: goto -> 382
    //   180: iload #6
    //   182: newarray byte
    //   184: astore #12
    //   186: aload #8
    //   188: iconst_0
    //   189: aload #12
    //   191: iconst_0
    //   192: iload #6
    //   194: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   197: aload_3
    //   198: iload #5
    //   200: i2l
    //   201: invokevirtual seek : (J)V
    //   204: aload_3
    //   205: aload #12
    //   207: invokevirtual write : ([B)V
    //   210: goto -> 382
    //   213: new com/amap/api/mapcore2d/ee$a
    //   216: dup
    //   217: aload #11
    //   219: aload_0
    //   220: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   223: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   226: aload #10
    //   228: aload_2
    //   229: invokevirtual b : ()Ljava/lang/String;
    //   232: aload #4
    //   234: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   237: ldc 'used'
    //   239: invokevirtual a : (Ljava/lang/String;)Lcom/amap/api/mapcore2d/ee$a;
    //   242: invokevirtual a : ()Lcom/amap/api/mapcore2d/ee;
    //   245: astore_0
    //   246: aload_1
    //   247: aload_0
    //   248: aload_0
    //   249: invokevirtual a : ()Ljava/lang/String;
    //   252: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic a : (Lcom/amap/api/mapcore2d/dt;Lcom/amap/api/mapcore2d/ee;Ljava/lang/String;)V
    //   258: aload #9
    //   260: invokestatic a : (Ljava/io/Closeable;)V
    //   263: goto -> 271
    //   266: astore_0
    //   267: aload_0
    //   268: invokevirtual printStackTrace : ()V
    //   271: aload_3
    //   272: invokestatic a : (Ljava/io/Closeable;)V
    //   275: goto -> 283
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual printStackTrace : ()V
    //   283: aload #7
    //   285: ifnull -> 294
    //   288: aload #7
    //   290: iconst_0
    //   291: putfield b : Z
    //   294: return
    //   295: astore_0
    //   296: aload #7
    //   298: astore_2
    //   299: aload #9
    //   301: astore_1
    //   302: goto -> 338
    //   305: astore_0
    //   306: aload #8
    //   308: astore_3
    //   309: aload #7
    //   311: astore_2
    //   312: aload #9
    //   314: astore_1
    //   315: goto -> 338
    //   318: astore_0
    //   319: aconst_null
    //   320: astore_1
    //   321: aload #8
    //   323: astore_3
    //   324: aload #7
    //   326: astore_2
    //   327: goto -> 338
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_2
    //   333: aload_2
    //   334: astore_1
    //   335: aload #8
    //   337: astore_3
    //   338: aload_0
    //   339: athrow
    //   340: astore_0
    //   341: aload_1
    //   342: invokestatic a : (Ljava/io/Closeable;)V
    //   345: goto -> 353
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual printStackTrace : ()V
    //   353: aload_3
    //   354: invokestatic a : (Ljava/io/Closeable;)V
    //   357: goto -> 365
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual printStackTrace : ()V
    //   365: aload_2
    //   366: ifnull -> 374
    //   369: aload_2
    //   370: iconst_0
    //   371: putfield b : Z
    //   374: aload_0
    //   375: athrow
    //   376: astore_0
    //   377: return
    //   378: astore_1
    //   379: goto -> 374
    //   382: iload #5
    //   384: iload #6
    //   386: iadd
    //   387: istore #5
    //   389: goto -> 142
    // Exception table:
    //   from	to	target	type
    //   3	18	330	finally
    //   23	34	318	finally
    //   34	42	45	finally
    //   46	49	45	finally
    //   49	51	318	finally
    //   51	93	318	finally
    //   93	132	305	finally
    //   132	139	295	finally
    //   142	151	295	finally
    //   164	177	295	finally
    //   180	210	295	finally
    //   213	258	295	finally
    //   258	263	266	finally
    //   271	275	278	finally
    //   288	294	376	finally
    //   338	340	340	finally
    //   341	345	348	finally
    //   353	357	360	finally
    //   369	374	378	finally
  }
  
  static void a(Context paramContext, dt paramdt, String paramString) {
    c(paramContext, paramdt, a(paramString));
    c(paramContext, paramdt, paramString);
  }
  
  static void a(Context paramContext, File paramFile, da paramda) {
    File file = paramFile.getParentFile();
    if (!paramFile.exists() && file != null && file.exists())
      c(paramContext, paramda.a(), paramda.b()); 
  }
  
  private static void a(Context paramContext, File paramFile, String paramString, da paramda) {
    dt dt = new dt(paramContext, ed.c());
    ee ee = a.a(dt, paramFile.getName());
    if (ee != null) {
      String str = ee.e();
    } else {
      ee = null;
    } 
    paramFile = new File(paramString);
    if (!TextUtils.isEmpty((CharSequence)ee) && paramFile.exists()) {
      paramString = cx.a(paramString);
      String str = paramFile.getName();
      a.a(dt, (new ee.a(str, paramString, paramda.a(), paramda.b(), (String)ee)).a("useod").a(), ee.b(str));
    } 
  }
  
  static void a(dt paramdt, Context paramContext, String paramString) {
    List<ee> list = a.a(paramdt, paramString, "used");
    if (list != null && list.size() > 0)
      for (ee ee : list) {
        if (ee != null && ee.c().equals(paramString)) {
          a(paramContext, paramdt, ee.a());
          List<ee> list1 = paramdt.b(ee.a(paramString, ee.e()), ee.class);
          if (list1 != null && list1.size() > 0) {
            ee ee1 = list1.get(0);
            ee1.c("errorstatus");
            a.a(paramdt, ee1, ee.b(ee1.a()));
            File file = new File(a(paramContext, ee1.a()));
            if (file.exists())
              file.delete(); 
          } 
        } 
      }  
  }
  
  static String b(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, a(paramContext, paramString1, paramString2));
  }
  
  static void b(Context paramContext, String paramString) {
    dt dt = new dt(paramContext, ed.c());
    List<ee> list = a.a(dt, paramString, "copy");
    eh.a(list);
    if (list != null) {
      int j = list.size();
      int i = 1;
      if (j > 1) {
        j = list.size();
        while (i < j) {
          c(paramContext, dt, ((ee)list.get(i)).a());
          i++;
        } 
      } 
    } 
  }
  
  private static void c(Context paramContext, dt paramdt, String paramString) {
    File file = new File(a(paramContext, paramString));
    if (file.exists())
      file.delete(); 
    paramdt.a(ee.b(paramString), ee.class);
  }
  
  static void c(Context paramContext, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static class a {
    static ee a(dt param1dt, String param1String) {
      List<ee> list = param1dt.b(ee.b(param1String), ee.class);
      return (list != null && list.size() > 0) ? list.get(0) : null;
    }
    
    public static List<ee> a(dt param1dt, String param1String1, String param1String2) {
      return param1dt.b(ee.b(param1String1, param1String2), ee.class);
    }
    
    public static void a(dt param1dt, ee param1ee, String param1String) {
      param1dt.a(param1ee, param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */