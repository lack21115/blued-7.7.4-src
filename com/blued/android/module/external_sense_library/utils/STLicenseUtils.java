package com.blued.android.module.external_sense_library.utils;

import android.content.Context;

public class STLicenseUtils {
  private static boolean a = false;
  
  private static boolean b = false;
  
  public static boolean a(Context paramContext) {
    return (paramContext == null) ? false : a(paramContext, "SenseME.lic");
  }
  
  public static boolean a(Context paramContext, String paramString) {
    return !!a(paramContext, paramString, false);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #9
    //   15: aconst_null
    //   16: astore #4
    //   18: new java/io/InputStreamReader
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   26: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   29: aload_1
    //   30: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   33: invokespecial <init> : (Ljava/io/InputStream;)V
    //   36: astore_1
    //   37: new java/io/BufferedReader
    //   40: dup
    //   41: aload_1
    //   42: invokespecial <init> : (Ljava/io/Reader;)V
    //   45: astore #8
    //   47: aload_1
    //   48: astore #4
    //   50: aload #8
    //   52: astore #6
    //   54: aload #8
    //   56: invokevirtual readLine : ()Ljava/lang/String;
    //   59: astore #5
    //   61: aload #5
    //   63: ifnull -> 99
    //   66: aload_1
    //   67: astore #4
    //   69: aload #8
    //   71: astore #6
    //   73: aload #9
    //   75: aload #5
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: astore #4
    //   84: aload #8
    //   86: astore #6
    //   88: aload #9
    //   90: ldc '\\n'
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: goto -> 47
    //   99: aload_1
    //   100: invokevirtual close : ()V
    //   103: goto -> 111
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual printStackTrace : ()V
    //   111: aload #8
    //   113: invokevirtual close : ()V
    //   116: goto -> 209
    //   119: astore #7
    //   121: aload_1
    //   122: astore #5
    //   124: aload #8
    //   126: astore_1
    //   127: goto -> 161
    //   130: astore_0
    //   131: goto -> 506
    //   134: astore #7
    //   136: aconst_null
    //   137: astore #4
    //   139: aload_1
    //   140: astore #5
    //   142: aload #4
    //   144: astore_1
    //   145: goto -> 161
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -> 506
    //   154: astore #7
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: astore #5
    //   161: aload #5
    //   163: astore #4
    //   165: aload_1
    //   166: astore #6
    //   168: aload #7
    //   170: invokevirtual printStackTrace : ()V
    //   173: aload #5
    //   175: ifnull -> 193
    //   178: aload #5
    //   180: invokevirtual close : ()V
    //   183: goto -> 193
    //   186: astore #4
    //   188: aload #4
    //   190: invokevirtual printStackTrace : ()V
    //   193: aload_1
    //   194: ifnull -> 209
    //   197: aload_1
    //   198: invokevirtual close : ()V
    //   201: goto -> 209
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual printStackTrace : ()V
    //   209: aload #9
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: invokevirtual length : ()I
    //   217: ifne -> 234
    //   220: ldc 'STLicenseUtils'
    //   222: ldc 'read license data error'
    //   224: iconst_0
    //   225: anewarray java/lang/Object
    //   228: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   231: pop
    //   232: iconst_0
    //   233: ireturn
    //   234: aload #9
    //   236: invokevirtual toString : ()Ljava/lang/String;
    //   239: astore #6
    //   241: aload_0
    //   242: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   245: ldc 'activate_code_file'
    //   247: iconst_0
    //   248: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   251: astore #4
    //   253: aload #4
    //   255: ldc 'activate_code'
    //   257: aconst_null
    //   258: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   263: astore #5
    //   265: new java/lang/Integer
    //   268: dup
    //   269: iconst_m1
    //   270: invokespecial <init> : (I)V
    //   273: astore_1
    //   274: aload #5
    //   276: ifnull -> 341
    //   279: aload_0
    //   280: aload #6
    //   282: aload #6
    //   284: invokevirtual length : ()I
    //   287: aload #5
    //   289: aload #5
    //   291: invokevirtual length : ()I
    //   294: invokestatic checkActiveCodeFromBuffer : (Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;I)I
    //   297: ifeq -> 303
    //   300: goto -> 341
    //   303: new java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial <init> : ()V
    //   310: astore_0
    //   311: aload_0
    //   312: ldc 'activeCode: '
    //   314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_0
    //   319: aload #5
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: ldc 'STLicenseUtils'
    //   327: aload_0
    //   328: invokevirtual toString : ()Ljava/lang/String;
    //   331: iconst_0
    //   332: anewarray java/lang/Object
    //   335: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   338: pop
    //   339: iconst_1
    //   340: ireturn
    //   341: new java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial <init> : ()V
    //   348: astore #7
    //   350: aload #7
    //   352: ldc 'activeCode: '
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #5
    //   360: ifnonnull -> 368
    //   363: iconst_1
    //   364: istore_3
    //   365: goto -> 370
    //   368: iconst_0
    //   369: istore_3
    //   370: aload #7
    //   372: iload_3
    //   373: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 'STLicenseUtils'
    //   379: aload #7
    //   381: invokevirtual toString : ()Ljava/lang/String;
    //   384: iconst_0
    //   385: anewarray java/lang/Object
    //   388: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   391: pop
    //   392: iload_2
    //   393: ifeq -> 411
    //   396: aload_0
    //   397: aload #6
    //   399: aload #6
    //   401: invokevirtual length : ()I
    //   404: invokestatic generateActiveCodeFromBufferOnline : (Landroid/content/Context;Ljava/lang/String;I)Ljava/lang/String;
    //   407: astore_0
    //   408: goto -> 423
    //   411: aload_0
    //   412: aload #6
    //   414: aload #6
    //   416: invokevirtual length : ()I
    //   419: invokestatic generateActiveCodeFromBuffer : (Landroid/content/Context;Ljava/lang/String;I)Ljava/lang/String;
    //   422: astore_0
    //   423: aload_0
    //   424: ifnull -> 461
    //   427: aload_0
    //   428: invokevirtual length : ()I
    //   431: ifle -> 461
    //   434: aload #4
    //   436: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   441: astore_1
    //   442: aload_1
    //   443: ldc 'activate_code'
    //   445: aload_0
    //   446: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   451: pop
    //   452: aload_1
    //   453: invokeinterface commit : ()Z
    //   458: pop
    //   459: iconst_1
    //   460: ireturn
    //   461: new java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial <init> : ()V
    //   468: astore_0
    //   469: aload_0
    //   470: ldc 'generate license error: '
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_0
    //   477: aload_1
    //   478: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: ldc 'STLicenseUtils'
    //   484: aload_0
    //   485: invokevirtual toString : ()Ljava/lang/String;
    //   488: iconst_0
    //   489: anewarray java/lang/Object
    //   492: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   495: pop
    //   496: iconst_0
    //   497: ireturn
    //   498: astore_0
    //   499: aload #4
    //   501: astore_1
    //   502: aload #6
    //   504: astore #4
    //   506: aload_1
    //   507: ifnull -> 522
    //   510: aload_1
    //   511: invokevirtual close : ()V
    //   514: goto -> 522
    //   517: astore_1
    //   518: aload_1
    //   519: invokevirtual printStackTrace : ()V
    //   522: aload #4
    //   524: ifnull -> 540
    //   527: aload #4
    //   529: invokevirtual close : ()V
    //   532: goto -> 540
    //   535: astore_1
    //   536: aload_1
    //   537: invokevirtual printStackTrace : ()V
    //   540: aload_0
    //   541: athrow
    // Exception table:
    //   from	to	target	type
    //   18	37	154	java/io/IOException
    //   18	37	148	finally
    //   37	47	134	java/io/IOException
    //   37	47	130	finally
    //   54	61	119	java/io/IOException
    //   54	61	498	finally
    //   73	81	119	java/io/IOException
    //   73	81	498	finally
    //   88	96	119	java/io/IOException
    //   88	96	498	finally
    //   99	103	106	java/io/IOException
    //   111	116	204	java/io/IOException
    //   168	173	498	finally
    //   178	183	186	java/io/IOException
    //   197	201	204	java/io/IOException
    //   510	514	517	java/io/IOException
    //   527	532	535	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\STLicenseUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */