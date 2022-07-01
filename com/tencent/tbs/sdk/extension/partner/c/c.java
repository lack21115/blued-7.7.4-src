package com.tencent.tbs.sdk.extension.partner.c;

public class c {
  public static int a = 600;
  
  private static int b;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int a() {
    // Byte code:
    //   0: getstatic com/tencent/tbs/sdk/extension/partner/c/c.b : I
    //   3: istore_0
    //   4: iload_0
    //   5: ifle -> 10
    //   8: iload_0
    //   9: ireturn
    //   10: iconst_0
    //   11: istore_1
    //   12: iconst_0
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: new java/io/FileReader
    //   19: dup
    //   20: ldc '/proc/meminfo'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: astore #4
    //   27: new java/io/BufferedReader
    //   30: dup
    //   31: aload #4
    //   33: sipush #8192
    //   36: invokespecial <init> : (Ljava/io/Reader;I)V
    //   39: astore #7
    //   41: aload #7
    //   43: astore #5
    //   45: aload #4
    //   47: astore #6
    //   49: aload #7
    //   51: invokevirtual readLine : ()Ljava/lang/String;
    //   54: astore #8
    //   56: iload_3
    //   57: istore_0
    //   58: aload #8
    //   60: ifnull -> 183
    //   63: aload #7
    //   65: astore #5
    //   67: aload #4
    //   69: astore #6
    //   71: aload #8
    //   73: ldc 'MemTotal:'
    //   75: invokevirtual indexOf : (Ljava/lang/String;)I
    //   78: istore_0
    //   79: iconst_m1
    //   80: iload_0
    //   81: if_icmpeq -> 41
    //   84: aload #7
    //   86: astore #5
    //   88: aload #4
    //   90: astore #6
    //   92: aload #8
    //   94: iload_0
    //   95: bipush #9
    //   97: iadd
    //   98: invokevirtual substring : (I)Ljava/lang/String;
    //   101: invokevirtual trim : ()Ljava/lang/String;
    //   104: astore #8
    //   106: iload_3
    //   107: istore_0
    //   108: aload #8
    //   110: ifnull -> 183
    //   113: iload_3
    //   114: istore_0
    //   115: aload #7
    //   117: astore #5
    //   119: aload #4
    //   121: astore #6
    //   123: aload #8
    //   125: invokevirtual length : ()I
    //   128: ifeq -> 183
    //   131: iload_3
    //   132: istore_0
    //   133: aload #7
    //   135: astore #5
    //   137: aload #4
    //   139: astore #6
    //   141: aload #8
    //   143: ldc 'k'
    //   145: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   148: ifeq -> 183
    //   151: aload #7
    //   153: astore #5
    //   155: aload #4
    //   157: astore #6
    //   159: aload #8
    //   161: iconst_0
    //   162: aload #8
    //   164: ldc 'k'
    //   166: invokevirtual indexOf : (Ljava/lang/String;)I
    //   169: invokevirtual substring : (II)Ljava/lang/String;
    //   172: invokevirtual trim : ()Ljava/lang/String;
    //   175: invokestatic parseInt : (Ljava/lang/String;)I
    //   178: sipush #1024
    //   181: idiv
    //   182: istore_0
    //   183: aload #7
    //   185: invokevirtual close : ()V
    //   188: goto -> 198
    //   191: astore #5
    //   193: aload #5
    //   195: invokevirtual printStackTrace : ()V
    //   198: iload_0
    //   199: istore_1
    //   200: aload #4
    //   202: invokevirtual close : ()V
    //   205: goto -> 381
    //   208: astore #4
    //   210: aload #4
    //   212: invokevirtual printStackTrace : ()V
    //   215: iload_1
    //   216: istore_0
    //   217: goto -> 381
    //   220: astore #8
    //   222: goto -> 275
    //   225: astore #8
    //   227: goto -> 334
    //   230: astore #6
    //   232: aconst_null
    //   233: astore #5
    //   235: goto -> 399
    //   238: astore #8
    //   240: aconst_null
    //   241: astore #7
    //   243: goto -> 275
    //   246: astore #8
    //   248: aconst_null
    //   249: astore #7
    //   251: goto -> 334
    //   254: astore #6
    //   256: aconst_null
    //   257: astore #4
    //   259: aload #4
    //   261: astore #5
    //   263: goto -> 399
    //   266: astore #8
    //   268: aconst_null
    //   269: astore #4
    //   271: aload #4
    //   273: astore #7
    //   275: aload #7
    //   277: astore #5
    //   279: aload #4
    //   281: astore #6
    //   283: aload #8
    //   285: invokevirtual printStackTrace : ()V
    //   288: aload #7
    //   290: ifnull -> 308
    //   293: aload #7
    //   295: invokevirtual close : ()V
    //   298: goto -> 308
    //   301: astore #5
    //   303: aload #5
    //   305: invokevirtual printStackTrace : ()V
    //   308: iload_2
    //   309: istore_0
    //   310: aload #4
    //   312: ifnull -> 381
    //   315: aload #4
    //   317: invokevirtual close : ()V
    //   320: iload_2
    //   321: istore_0
    //   322: goto -> 381
    //   325: astore #8
    //   327: aconst_null
    //   328: astore #4
    //   330: aload #4
    //   332: astore #7
    //   334: aload #7
    //   336: astore #5
    //   338: aload #4
    //   340: astore #6
    //   342: aload #8
    //   344: invokevirtual printStackTrace : ()V
    //   347: aload #7
    //   349: ifnull -> 367
    //   352: aload #7
    //   354: invokevirtual close : ()V
    //   357: goto -> 367
    //   360: astore #5
    //   362: aload #5
    //   364: invokevirtual printStackTrace : ()V
    //   367: iload_2
    //   368: istore_0
    //   369: aload #4
    //   371: ifnull -> 381
    //   374: aload #4
    //   376: invokevirtual close : ()V
    //   379: iload_2
    //   380: istore_0
    //   381: iload_0
    //   382: putstatic com/tencent/tbs/sdk/extension/partner/c/c.b : I
    //   385: getstatic com/tencent/tbs/sdk/extension/partner/c/c.b : I
    //   388: ireturn
    //   389: astore #7
    //   391: aload #6
    //   393: astore #4
    //   395: aload #7
    //   397: astore #6
    //   399: aload #5
    //   401: ifnull -> 419
    //   404: aload #5
    //   406: invokevirtual close : ()V
    //   409: goto -> 419
    //   412: astore #5
    //   414: aload #5
    //   416: invokevirtual printStackTrace : ()V
    //   419: aload #4
    //   421: ifnull -> 439
    //   424: aload #4
    //   426: invokevirtual close : ()V
    //   429: goto -> 439
    //   432: astore #4
    //   434: aload #4
    //   436: invokevirtual printStackTrace : ()V
    //   439: aload #6
    //   441: athrow
    // Exception table:
    //   from	to	target	type
    //   16	27	325	java/io/IOException
    //   16	27	266	java/lang/Throwable
    //   16	27	254	finally
    //   27	41	246	java/io/IOException
    //   27	41	238	java/lang/Throwable
    //   27	41	230	finally
    //   49	56	225	java/io/IOException
    //   49	56	220	java/lang/Throwable
    //   49	56	389	finally
    //   71	79	225	java/io/IOException
    //   71	79	220	java/lang/Throwable
    //   71	79	389	finally
    //   92	106	225	java/io/IOException
    //   92	106	220	java/lang/Throwable
    //   92	106	389	finally
    //   123	131	225	java/io/IOException
    //   123	131	220	java/lang/Throwable
    //   123	131	389	finally
    //   141	151	225	java/io/IOException
    //   141	151	220	java/lang/Throwable
    //   141	151	389	finally
    //   159	183	225	java/io/IOException
    //   159	183	220	java/lang/Throwable
    //   159	183	389	finally
    //   183	188	191	java/io/IOException
    //   200	205	208	java/io/IOException
    //   283	288	389	finally
    //   293	298	301	java/io/IOException
    //   315	320	208	java/io/IOException
    //   342	347	389	finally
    //   352	357	360	java/io/IOException
    //   374	379	208	java/io/IOException
    //   404	409	412	java/io/IOException
    //   424	429	432	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */