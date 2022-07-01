package com.blued.android.module.common.utils;

public class AssetsUtils {
  public static String a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokestatic d : ()Landroid/content/Context;
    //   12: invokevirtual getFilesDir : ()Ljava/io/File;
    //   15: invokevirtual getPath : ()Ljava/lang/String;
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc '/'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: invokespecial <init> : (Ljava/lang/String;)V
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual exists : ()Z
    //   45: ifne -> 53
    //   48: aload_3
    //   49: invokevirtual mkdirs : ()Z
    //   52: pop
    //   53: new java/io/File
    //   56: dup
    //   57: aload_3
    //   58: aload_0
    //   59: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   62: astore #6
    //   64: aload #6
    //   66: invokevirtual exists : ()Z
    //   69: ifeq -> 91
    //   72: iload_1
    //   73: ifeq -> 85
    //   76: aload #6
    //   78: invokevirtual delete : ()Z
    //   81: pop
    //   82: goto -> 91
    //   85: aload #6
    //   87: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   90: areturn
    //   91: invokestatic d : ()Landroid/content/Context;
    //   94: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   97: aload_0
    //   98: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   101: astore_0
    //   102: new java/io/FileOutputStream
    //   105: dup
    //   106: aload #6
    //   108: invokespecial <init> : (Ljava/io/File;)V
    //   111: astore #5
    //   113: aload #5
    //   115: astore_3
    //   116: aload_0
    //   117: astore #4
    //   119: sipush #1024
    //   122: newarray byte
    //   124: astore #7
    //   126: aload #5
    //   128: astore_3
    //   129: aload_0
    //   130: astore #4
    //   132: aload_0
    //   133: aload #7
    //   135: invokevirtual read : ([B)I
    //   138: istore_2
    //   139: iload_2
    //   140: iconst_m1
    //   141: if_icmpeq -> 162
    //   144: aload #5
    //   146: astore_3
    //   147: aload_0
    //   148: astore #4
    //   150: aload #5
    //   152: aload #7
    //   154: iconst_0
    //   155: iload_2
    //   156: invokevirtual write : ([BII)V
    //   159: goto -> 126
    //   162: aload #5
    //   164: astore_3
    //   165: aload_0
    //   166: astore #4
    //   168: aload #5
    //   170: invokevirtual flush : ()V
    //   173: aload #5
    //   175: astore_3
    //   176: aload_0
    //   177: astore #4
    //   179: aload #6
    //   181: invokevirtual exists : ()Z
    //   184: ifeq -> 226
    //   187: aload #5
    //   189: astore_3
    //   190: aload_0
    //   191: astore #4
    //   193: aload #6
    //   195: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   198: astore #6
    //   200: aload_0
    //   201: ifnull -> 211
    //   204: aload_0
    //   205: invokevirtual close : ()V
    //   208: goto -> 211
    //   211: aload #5
    //   213: invokevirtual close : ()V
    //   216: aload #6
    //   218: areturn
    //   219: aload_0
    //   220: invokevirtual printStackTrace : ()V
    //   223: aload #6
    //   225: areturn
    //   226: aload_0
    //   227: ifnull -> 234
    //   230: aload_0
    //   231: invokevirtual close : ()V
    //   234: aload #5
    //   236: invokevirtual close : ()V
    //   239: goto -> 371
    //   242: astore #6
    //   244: goto -> 292
    //   247: astore #6
    //   249: goto -> 332
    //   252: astore #5
    //   254: aconst_null
    //   255: astore_3
    //   256: goto -> 379
    //   259: astore #6
    //   261: aconst_null
    //   262: astore #5
    //   264: goto -> 292
    //   267: astore #6
    //   269: aconst_null
    //   270: astore #5
    //   272: goto -> 332
    //   275: astore #5
    //   277: aconst_null
    //   278: astore_3
    //   279: aload_3
    //   280: astore_0
    //   281: goto -> 379
    //   284: astore #6
    //   286: aconst_null
    //   287: astore #5
    //   289: aload #5
    //   291: astore_0
    //   292: aload #5
    //   294: astore_3
    //   295: aload_0
    //   296: astore #4
    //   298: aload #6
    //   300: invokevirtual printStackTrace : ()V
    //   303: aload_0
    //   304: ifnull -> 311
    //   307: aload_0
    //   308: invokevirtual close : ()V
    //   311: aload #5
    //   313: ifnull -> 371
    //   316: aload #5
    //   318: invokevirtual close : ()V
    //   321: goto -> 371
    //   324: astore #6
    //   326: aconst_null
    //   327: astore #5
    //   329: aload #5
    //   331: astore_0
    //   332: aload #5
    //   334: astore_3
    //   335: aload_0
    //   336: astore #4
    //   338: aload #6
    //   340: invokevirtual printStackTrace : ()V
    //   343: aload_0
    //   344: ifnull -> 354
    //   347: aload_0
    //   348: invokevirtual close : ()V
    //   351: goto -> 354
    //   354: aload #5
    //   356: ifnull -> 371
    //   359: aload #5
    //   361: invokevirtual close : ()V
    //   364: goto -> 371
    //   367: aload_0
    //   368: invokevirtual printStackTrace : ()V
    //   371: ldc ''
    //   373: areturn
    //   374: astore #5
    //   376: aload #4
    //   378: astore_0
    //   379: aload_0
    //   380: ifnull -> 390
    //   383: aload_0
    //   384: invokevirtual close : ()V
    //   387: goto -> 390
    //   390: aload_3
    //   391: ifnull -> 405
    //   394: aload_3
    //   395: invokevirtual close : ()V
    //   398: goto -> 405
    //   401: aload_0
    //   402: invokevirtual printStackTrace : ()V
    //   405: aload #5
    //   407: athrow
    //   408: astore_0
    //   409: goto -> 219
    //   412: astore_0
    //   413: goto -> 367
    //   416: astore_0
    //   417: goto -> 401
    // Exception table:
    //   from	to	target	type
    //   91	102	324	java/io/FileNotFoundException
    //   91	102	284	java/io/IOException
    //   91	102	275	finally
    //   102	113	267	java/io/FileNotFoundException
    //   102	113	259	java/io/IOException
    //   102	113	252	finally
    //   119	126	247	java/io/FileNotFoundException
    //   119	126	242	java/io/IOException
    //   119	126	374	finally
    //   132	139	247	java/io/FileNotFoundException
    //   132	139	242	java/io/IOException
    //   132	139	374	finally
    //   150	159	247	java/io/FileNotFoundException
    //   150	159	242	java/io/IOException
    //   150	159	374	finally
    //   168	173	247	java/io/FileNotFoundException
    //   168	173	242	java/io/IOException
    //   168	173	374	finally
    //   179	187	247	java/io/FileNotFoundException
    //   179	187	242	java/io/IOException
    //   179	187	374	finally
    //   193	200	247	java/io/FileNotFoundException
    //   193	200	242	java/io/IOException
    //   193	200	374	finally
    //   204	208	408	java/io/IOException
    //   211	216	408	java/io/IOException
    //   230	234	412	java/io/IOException
    //   234	239	412	java/io/IOException
    //   298	303	374	finally
    //   307	311	412	java/io/IOException
    //   316	321	412	java/io/IOException
    //   338	343	374	finally
    //   347	351	412	java/io/IOException
    //   359	364	412	java/io/IOException
    //   383	387	416	java/io/IOException
    //   394	398	416	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\AssetsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */