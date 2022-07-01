package com.bytedance.embedapplog.b;

import org.json.JSONObject;

abstract class c {
  boolean a;
  
  boolean b;
  
  boolean c;
  
  boolean d;
  
  c(boolean paramBoolean1, boolean paramBoolean2) {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = false;
  }
  
  c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
  }
  
  String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc 'mounted'
    //   2: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   5: invokevirtual equals : (Ljava/lang/Object;)Z
    //   8: ifne -> 13
    //   11: aload_2
    //   12: areturn
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #5
    //   22: aload #5
    //   24: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   27: invokevirtual getPath : ()Ljava/lang/String;
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #5
    //   36: ldc '/Android/data/com.snssdk.api.embed/cache'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload #5
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: astore #8
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: astore #5
    //   58: aload #5
    //   60: aload #8
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: ldc '/'
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #5
    //   76: aload_1
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload #5
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: astore #9
    //   88: aconst_null
    //   89: astore #7
    //   91: aconst_null
    //   92: astore #5
    //   94: aconst_null
    //   95: astore_1
    //   96: aconst_null
    //   97: astore #6
    //   99: new java/io/File
    //   102: dup
    //   103: aload #8
    //   105: invokespecial <init> : (Ljava/lang/String;)V
    //   108: astore #8
    //   110: aload #8
    //   112: invokevirtual exists : ()Z
    //   115: ifne -> 128
    //   118: aload #8
    //   120: invokevirtual mkdirs : ()Z
    //   123: ifne -> 128
    //   126: aload_2
    //   127: areturn
    //   128: new java/io/File
    //   131: dup
    //   132: aload #9
    //   134: invokespecial <init> : (Ljava/lang/String;)V
    //   137: astore #9
    //   139: new java/io/RandomAccessFile
    //   142: dup
    //   143: aload #9
    //   145: ldc 'rwd'
    //   147: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   150: astore #8
    //   152: aload #5
    //   154: astore_1
    //   155: aload #8
    //   157: astore #5
    //   159: aload #8
    //   161: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   164: invokevirtual lock : ()Ljava/nio/channels/FileLock;
    //   167: astore #7
    //   169: aload #7
    //   171: astore #6
    //   173: aload #7
    //   175: astore_1
    //   176: aload #8
    //   178: astore #5
    //   180: aload #9
    //   182: invokevirtual isFile : ()Z
    //   185: istore #4
    //   187: iload #4
    //   189: ifeq -> 311
    //   192: aload #7
    //   194: astore #6
    //   196: aload #7
    //   198: astore_1
    //   199: aload #8
    //   201: astore #5
    //   203: sipush #129
    //   206: newarray byte
    //   208: astore #9
    //   210: aload #7
    //   212: astore #6
    //   214: aload #7
    //   216: astore_1
    //   217: aload #8
    //   219: astore #5
    //   221: aload #8
    //   223: aload #9
    //   225: iconst_0
    //   226: sipush #129
    //   229: invokevirtual read : ([BII)I
    //   232: istore_3
    //   233: iload_3
    //   234: ifle -> 311
    //   237: iload_3
    //   238: sipush #129
    //   241: if_icmpge -> 311
    //   244: aload #7
    //   246: astore #6
    //   248: aload #7
    //   250: astore_1
    //   251: aload #8
    //   253: astore #5
    //   255: new java/lang/String
    //   258: dup
    //   259: aload #9
    //   261: iconst_0
    //   262: iload_3
    //   263: ldc 'UTF-8'
    //   265: invokespecial <init> : ([BIILjava/lang/String;)V
    //   268: astore #9
    //   270: aload #7
    //   272: astore #6
    //   274: aload #7
    //   276: astore_1
    //   277: aload #8
    //   279: astore #5
    //   281: aload #9
    //   283: invokestatic d : (Ljava/lang/String;)Z
    //   286: istore #4
    //   288: iload #4
    //   290: ifeq -> 311
    //   293: aload #7
    //   295: ifnull -> 303
    //   298: aload #7
    //   300: invokevirtual release : ()V
    //   303: aload #8
    //   305: invokevirtual close : ()V
    //   308: aload #9
    //   310: areturn
    //   311: aload #7
    //   313: astore #6
    //   315: aload #7
    //   317: astore_1
    //   318: aload #8
    //   320: astore #5
    //   322: aload_2
    //   323: ldc 'UTF-8'
    //   325: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   328: astore #9
    //   330: aload #7
    //   332: astore #6
    //   334: aload #7
    //   336: astore_1
    //   337: aload #8
    //   339: astore #5
    //   341: aload #8
    //   343: lconst_0
    //   344: invokevirtual setLength : (J)V
    //   347: aload #7
    //   349: astore #6
    //   351: aload #7
    //   353: astore_1
    //   354: aload #8
    //   356: astore #5
    //   358: aload #8
    //   360: aload #9
    //   362: invokevirtual write : ([B)V
    //   365: aload #7
    //   367: ifnull -> 375
    //   370: aload #7
    //   372: invokevirtual release : ()V
    //   375: aload #8
    //   377: invokevirtual close : ()V
    //   380: aload_2
    //   381: areturn
    //   382: astore #9
    //   384: aload #6
    //   386: astore #7
    //   388: aload #8
    //   390: astore #6
    //   392: goto -> 407
    //   395: astore_2
    //   396: aconst_null
    //   397: astore #5
    //   399: goto -> 501
    //   402: astore #9
    //   404: aconst_null
    //   405: astore #6
    //   407: aload #7
    //   409: astore_1
    //   410: aload #6
    //   412: astore #5
    //   414: getstatic android/os/Build$VERSION.SDK_INT : I
    //   417: bipush #23
    //   419: if_icmplt -> 475
    //   422: aload #7
    //   424: astore_1
    //   425: aload #6
    //   427: astore #5
    //   429: invokestatic b : ()Lcom/bytedance/embedapplog/a/e;
    //   432: getfield a : Landroid/app/Application;
    //   435: ldc 'android.permission.READ_EXTERNAL_STORAGE'
    //   437: invokevirtual checkSelfPermission : (Ljava/lang/String;)I
    //   440: ifne -> 458
    //   443: aload #7
    //   445: astore_1
    //   446: aload #6
    //   448: astore #5
    //   450: aload #9
    //   452: invokestatic a : (Ljava/lang/Throwable;)V
    //   455: goto -> 475
    //   458: aload #7
    //   460: astore_1
    //   461: aload #6
    //   463: astore #5
    //   465: new java/lang/SecurityException
    //   468: dup
    //   469: aload #9
    //   471: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   474: athrow
    //   475: aload #7
    //   477: ifnull -> 488
    //   480: aload #7
    //   482: invokevirtual release : ()V
    //   485: goto -> 488
    //   488: aload #6
    //   490: ifnull -> 498
    //   493: aload #6
    //   495: invokevirtual close : ()V
    //   498: aload_2
    //   499: areturn
    //   500: astore_2
    //   501: aload_1
    //   502: ifnull -> 512
    //   505: aload_1
    //   506: invokevirtual release : ()V
    //   509: goto -> 512
    //   512: aload #5
    //   514: ifnull -> 522
    //   517: aload #5
    //   519: invokevirtual close : ()V
    //   522: aload_2
    //   523: athrow
    //   524: astore_1
    //   525: goto -> 303
    //   528: astore_1
    //   529: aload #9
    //   531: areturn
    //   532: astore_1
    //   533: goto -> 375
    //   536: astore_1
    //   537: aload_2
    //   538: areturn
    //   539: astore_1
    //   540: goto -> 488
    //   543: astore_1
    //   544: aload_2
    //   545: areturn
    //   546: astore_1
    //   547: goto -> 512
    //   550: astore_1
    //   551: goto -> 522
    // Exception table:
    //   from	to	target	type
    //   99	126	402	java/io/IOException
    //   99	126	395	finally
    //   128	152	402	java/io/IOException
    //   128	152	395	finally
    //   159	169	382	java/io/IOException
    //   159	169	500	finally
    //   180	187	382	java/io/IOException
    //   180	187	500	finally
    //   203	210	382	java/io/IOException
    //   203	210	500	finally
    //   221	233	382	java/io/IOException
    //   221	233	500	finally
    //   255	270	382	java/io/IOException
    //   255	270	500	finally
    //   281	288	382	java/io/IOException
    //   281	288	500	finally
    //   298	303	524	java/lang/Exception
    //   303	308	528	java/lang/Exception
    //   322	330	382	java/io/IOException
    //   322	330	500	finally
    //   341	347	382	java/io/IOException
    //   341	347	500	finally
    //   358	365	382	java/io/IOException
    //   358	365	500	finally
    //   370	375	532	java/lang/Exception
    //   375	380	536	java/lang/Exception
    //   414	422	500	finally
    //   429	443	500	finally
    //   450	455	500	finally
    //   465	475	500	finally
    //   480	485	539	java/lang/Exception
    //   493	498	543	java/lang/Exception
    //   505	509	546	java/lang/Exception
    //   517	522	550	java/lang/Exception
  }
  
  protected abstract boolean a(JSONObject paramJSONObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */