package com.baidu.idl.license;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class LicenseReader {
  public static final String TAG = "License-SDK";
  
  private static final String URL = "https://aip.baidubce.com/public/2.0/license/face-api/app/querydevicelicense";
  
  private String path;
  
  public String[] get_local_license(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aload_1
    //   4: aload_0
    //   5: getfield path : Ljava/lang/String;
    //   8: invokestatic get_local_license_file_inputstream : (Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore #4
    //   13: aload #4
    //   15: astore_3
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #5
    //   25: aload #4
    //   27: astore_3
    //   28: aload #5
    //   30: ldc 'open license file path '
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #4
    //   38: astore_3
    //   39: aload #5
    //   41: aload_0
    //   42: getfield path : Ljava/lang/String;
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload #4
    //   51: astore_3
    //   52: ldc 'License-SDK'
    //   54: aload #5
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: aload #4
    //   65: ifnonnull -> 98
    //   68: aload #4
    //   70: astore_3
    //   71: ldc 'License-SDK'
    //   73: ldc 'open license file error.'
    //   75: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload #4
    //   81: ifnull -> 96
    //   84: aload #4
    //   86: invokevirtual close : ()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual printStackTrace : ()V
    //   96: aconst_null
    //   97: areturn
    //   98: aload #4
    //   100: astore_3
    //   101: new java/io/BufferedReader
    //   104: dup
    //   105: new java/io/InputStreamReader
    //   108: dup
    //   109: aload #4
    //   111: invokespecial <init> : (Ljava/io/InputStream;)V
    //   114: invokespecial <init> : (Ljava/io/Reader;)V
    //   117: astore #6
    //   119: aload #4
    //   121: astore_3
    //   122: new java/util/ArrayList
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: astore #5
    //   131: aload #4
    //   133: astore_3
    //   134: aload #6
    //   136: invokevirtual readLine : ()Ljava/lang/String;
    //   139: astore #8
    //   141: aload #8
    //   143: ifnull -> 208
    //   146: aload #4
    //   148: astore_3
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial <init> : ()V
    //   156: astore #9
    //   158: aload #4
    //   160: astore_3
    //   161: aload #9
    //   163: ldc 'readLine '
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload #4
    //   171: astore_3
    //   172: aload #9
    //   174: aload #8
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #4
    //   182: astore_3
    //   183: ldc 'License-SDK'
    //   185: aload #9
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   193: pop
    //   194: aload #4
    //   196: astore_3
    //   197: aload #5
    //   199: aload #8
    //   201: invokevirtual add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 131
    //   208: aload #4
    //   210: ifnull -> 226
    //   213: aload #4
    //   215: invokevirtual close : ()V
    //   218: goto -> 226
    //   221: astore_3
    //   222: aload_3
    //   223: invokevirtual printStackTrace : ()V
    //   226: aload #5
    //   228: astore_3
    //   229: goto -> 624
    //   232: astore #6
    //   234: aload #5
    //   236: astore_3
    //   237: aload #4
    //   239: astore #5
    //   241: aload_3
    //   242: astore #4
    //   244: goto -> 334
    //   247: astore #6
    //   249: aload #5
    //   251: astore_3
    //   252: aload #4
    //   254: astore #5
    //   256: aload_3
    //   257: astore #4
    //   259: goto -> 458
    //   262: astore #6
    //   264: aload #5
    //   266: astore_3
    //   267: aload #4
    //   269: astore #5
    //   271: aload_3
    //   272: astore #4
    //   274: goto -> 547
    //   277: astore #6
    //   279: aconst_null
    //   280: astore_3
    //   281: aload #4
    //   283: astore #5
    //   285: aload_3
    //   286: astore #4
    //   288: goto -> 334
    //   291: astore #6
    //   293: aconst_null
    //   294: astore_3
    //   295: aload #4
    //   297: astore #5
    //   299: aload_3
    //   300: astore #4
    //   302: goto -> 458
    //   305: astore #6
    //   307: aconst_null
    //   308: astore_3
    //   309: aload #4
    //   311: astore #5
    //   313: aload_3
    //   314: astore #4
    //   316: goto -> 547
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_3
    //   322: goto -> 743
    //   325: astore #6
    //   327: aconst_null
    //   328: astore #5
    //   330: aload #5
    //   332: astore #4
    //   334: aload #5
    //   336: astore_3
    //   337: new java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial <init> : ()V
    //   344: astore #8
    //   346: aload #5
    //   348: astore_3
    //   349: aload #8
    //   351: ldc 'license file Exception '
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload #5
    //   359: astore_3
    //   360: aload #8
    //   362: aload_0
    //   363: getfield path : Ljava/lang/String;
    //   366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload #5
    //   372: astore_3
    //   373: aload #8
    //   375: ldc ' '
    //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload #5
    //   383: astore_3
    //   384: aload #8
    //   386: aload #6
    //   388: invokevirtual getMessage : ()Ljava/lang/String;
    //   391: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload #5
    //   397: astore_3
    //   398: ldc 'License-SDK'
    //   400: aload #8
    //   402: invokevirtual toString : ()Ljava/lang/String;
    //   405: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   408: pop
    //   409: aload #5
    //   411: astore_3
    //   412: aload #6
    //   414: invokevirtual printStackTrace : ()V
    //   417: aload #4
    //   419: astore_3
    //   420: aload #5
    //   422: ifnull -> 624
    //   425: aload #4
    //   427: astore_3
    //   428: aload #5
    //   430: invokevirtual close : ()V
    //   433: aload #4
    //   435: astore_3
    //   436: goto -> 624
    //   439: astore #4
    //   441: aload #4
    //   443: invokevirtual printStackTrace : ()V
    //   446: goto -> 624
    //   449: astore #6
    //   451: aconst_null
    //   452: astore #5
    //   454: aload #5
    //   456: astore #4
    //   458: aload #5
    //   460: astore_3
    //   461: new java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial <init> : ()V
    //   468: astore #8
    //   470: aload #5
    //   472: astore_3
    //   473: aload #8
    //   475: ldc 'license file IOException '
    //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload #5
    //   483: astore_3
    //   484: aload #8
    //   486: aload_0
    //   487: getfield path : Ljava/lang/String;
    //   490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload #5
    //   496: astore_3
    //   497: ldc 'License-SDK'
    //   499: aload #8
    //   501: invokevirtual toString : ()Ljava/lang/String;
    //   504: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   507: pop
    //   508: aload #5
    //   510: astore_3
    //   511: aload #6
    //   513: invokevirtual printStackTrace : ()V
    //   516: aload #4
    //   518: astore_3
    //   519: aload #5
    //   521: ifnull -> 624
    //   524: aload #4
    //   526: astore_3
    //   527: aload #5
    //   529: invokevirtual close : ()V
    //   532: aload #4
    //   534: astore_3
    //   535: goto -> 624
    //   538: astore #6
    //   540: aconst_null
    //   541: astore #5
    //   543: aload #5
    //   545: astore #4
    //   547: aload #5
    //   549: astore_3
    //   550: new java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial <init> : ()V
    //   557: astore #8
    //   559: aload #5
    //   561: astore_3
    //   562: aload #8
    //   564: ldc 'license file FileNotFoundException '
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #5
    //   572: astore_3
    //   573: aload #8
    //   575: aload_0
    //   576: getfield path : Ljava/lang/String;
    //   579: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload #5
    //   585: astore_3
    //   586: ldc 'License-SDK'
    //   588: aload #8
    //   590: invokevirtual toString : ()Ljava/lang/String;
    //   593: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   596: pop
    //   597: aload #5
    //   599: astore_3
    //   600: aload #6
    //   602: invokevirtual printStackTrace : ()V
    //   605: aload #4
    //   607: astore_3
    //   608: aload #5
    //   610: ifnull -> 624
    //   613: aload #4
    //   615: astore_3
    //   616: aload #5
    //   618: invokevirtual close : ()V
    //   621: aload #4
    //   623: astore_3
    //   624: aload #7
    //   626: astore #4
    //   628: aload_3
    //   629: ifnull -> 739
    //   632: aload #7
    //   634: astore #4
    //   636: aload_3
    //   637: invokevirtual size : ()I
    //   640: ifle -> 739
    //   643: aload_1
    //   644: aload_0
    //   645: getfield path : Ljava/lang/String;
    //   648: aload_3
    //   649: invokestatic write_license_content : (Landroid/content/Context;Ljava/lang/String;Ljava/util/ArrayList;)Z
    //   652: pop
    //   653: aload_3
    //   654: invokevirtual size : ()I
    //   657: anewarray java/lang/String
    //   660: astore_1
    //   661: iconst_0
    //   662: istore_2
    //   663: aload_3
    //   664: invokevirtual iterator : ()Ljava/util/Iterator;
    //   667: astore_3
    //   668: aload_1
    //   669: astore #4
    //   671: aload_3
    //   672: invokeinterface hasNext : ()Z
    //   677: ifeq -> 739
    //   680: aload_3
    //   681: invokeinterface next : ()Ljava/lang/Object;
    //   686: checkcast java/lang/String
    //   689: astore #4
    //   691: aload_1
    //   692: iload_2
    //   693: aload #4
    //   695: aastore
    //   696: new java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial <init> : ()V
    //   703: astore #5
    //   705: aload #5
    //   707: ldc 'license file info ='
    //   709: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #5
    //   715: aload #4
    //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: ldc 'License-SDK'
    //   723: aload #5
    //   725: invokevirtual toString : ()Ljava/lang/String;
    //   728: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   731: pop
    //   732: iload_2
    //   733: iconst_1
    //   734: iadd
    //   735: istore_2
    //   736: goto -> 668
    //   739: aload #4
    //   741: areturn
    //   742: astore_1
    //   743: aload_3
    //   744: ifnull -> 759
    //   747: aload_3
    //   748: invokevirtual close : ()V
    //   751: goto -> 759
    //   754: astore_3
    //   755: aload_3
    //   756: invokevirtual printStackTrace : ()V
    //   759: aload_1
    //   760: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	538	java/io/FileNotFoundException
    //   3	13	449	java/io/IOException
    //   3	13	325	java/lang/Exception
    //   3	13	319	finally
    //   16	25	305	java/io/FileNotFoundException
    //   16	25	291	java/io/IOException
    //   16	25	277	java/lang/Exception
    //   16	25	742	finally
    //   28	36	305	java/io/FileNotFoundException
    //   28	36	291	java/io/IOException
    //   28	36	277	java/lang/Exception
    //   28	36	742	finally
    //   39	49	305	java/io/FileNotFoundException
    //   39	49	291	java/io/IOException
    //   39	49	277	java/lang/Exception
    //   39	49	742	finally
    //   52	63	305	java/io/FileNotFoundException
    //   52	63	291	java/io/IOException
    //   52	63	277	java/lang/Exception
    //   52	63	742	finally
    //   71	79	305	java/io/FileNotFoundException
    //   71	79	291	java/io/IOException
    //   71	79	277	java/lang/Exception
    //   71	79	742	finally
    //   84	89	91	java/io/IOException
    //   101	119	305	java/io/FileNotFoundException
    //   101	119	291	java/io/IOException
    //   101	119	277	java/lang/Exception
    //   101	119	742	finally
    //   122	131	305	java/io/FileNotFoundException
    //   122	131	291	java/io/IOException
    //   122	131	277	java/lang/Exception
    //   122	131	742	finally
    //   134	141	262	java/io/FileNotFoundException
    //   134	141	247	java/io/IOException
    //   134	141	232	java/lang/Exception
    //   134	141	742	finally
    //   149	158	262	java/io/FileNotFoundException
    //   149	158	247	java/io/IOException
    //   149	158	232	java/lang/Exception
    //   149	158	742	finally
    //   161	169	262	java/io/FileNotFoundException
    //   161	169	247	java/io/IOException
    //   161	169	232	java/lang/Exception
    //   161	169	742	finally
    //   172	180	262	java/io/FileNotFoundException
    //   172	180	247	java/io/IOException
    //   172	180	232	java/lang/Exception
    //   172	180	742	finally
    //   183	194	262	java/io/FileNotFoundException
    //   183	194	247	java/io/IOException
    //   183	194	232	java/lang/Exception
    //   183	194	742	finally
    //   197	205	262	java/io/FileNotFoundException
    //   197	205	247	java/io/IOException
    //   197	205	232	java/lang/Exception
    //   197	205	742	finally
    //   213	218	221	java/io/IOException
    //   337	346	742	finally
    //   349	357	742	finally
    //   360	370	742	finally
    //   373	381	742	finally
    //   384	395	742	finally
    //   398	409	742	finally
    //   412	417	742	finally
    //   428	433	439	java/io/IOException
    //   461	470	742	finally
    //   473	481	742	finally
    //   484	494	742	finally
    //   497	508	742	finally
    //   511	516	742	finally
    //   527	532	439	java/io/IOException
    //   550	559	742	finally
    //   562	570	742	finally
    //   573	583	742	finally
    //   586	597	742	finally
    //   600	605	742	finally
    //   616	621	439	java/io/IOException
    //   747	751	754	java/io/IOException
  }
  
  public String[] get_remote_license(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #8
    //   4: iconst_0
    //   5: istore #4
    //   7: aconst_null
    //   8: astore #7
    //   10: aconst_null
    //   11: astore #13
    //   13: ldc ''
    //   15: aload_2
    //   16: invokevirtual equals : (Ljava/lang/Object;)Z
    //   19: ifne -> 1594
    //   22: new org/json/JSONObject
    //   25: dup
    //   26: aload_2
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: astore_1
    //   31: ldc 'sdk_v=%s&query=%s'
    //   33: iconst_2
    //   34: anewarray java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: ldc 'sdk_v'
    //   42: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_1
    //   49: ldc 'query'
    //   51: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   58: astore_2
    //   59: goto -> 62
    //   62: ldc 'License-SDK'
    //   64: ldc 'request get_remote_license =https://aip.baidubce.com/public/2.0/license/face-api/app/querydevicelicense'
    //   66: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   69: pop
    //   70: new java/net/URL
    //   73: dup
    //   74: ldc 'https://aip.baidubce.com/public/2.0/license/face-api/app/querydevicelicense'
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   82: checkcast java/net/HttpURLConnection
    //   85: astore #6
    //   87: ldc 'sun.net.client.defaultConnectTimeout'
    //   89: ldc '8000'
    //   91: invokestatic setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: pop
    //   95: ldc 'sun.net.client.defaultReadTimeout'
    //   97: ldc '8000'
    //   99: invokestatic setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: pop
    //   103: aload #6
    //   105: iconst_1
    //   106: invokevirtual setDoOutput : (Z)V
    //   109: aload #6
    //   111: iconst_1
    //   112: invokevirtual setDoInput : (Z)V
    //   115: aload #6
    //   117: ldc 'POST'
    //   119: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   122: aload #6
    //   124: iconst_0
    //   125: invokevirtual setUseCaches : (Z)V
    //   128: aload #6
    //   130: iconst_1
    //   131: invokevirtual setInstanceFollowRedirects : (Z)V
    //   134: aload #6
    //   136: ldc 'Content-Type'
    //   138: ldc 'application/x-www-form-urlencoded'
    //   140: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload #6
    //   145: invokevirtual connect : ()V
    //   148: aload #6
    //   150: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   153: astore_1
    //   154: aload_1
    //   155: aload_2
    //   156: invokevirtual getBytes : ()[B
    //   159: invokevirtual write : ([B)V
    //   162: aload_1
    //   163: invokevirtual flush : ()V
    //   166: aload_1
    //   167: invokevirtual close : ()V
    //   170: aload #6
    //   172: invokevirtual getResponseCode : ()I
    //   175: istore_3
    //   176: new java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial <init> : ()V
    //   183: astore_2
    //   184: aload_2
    //   185: ldc 'request code '
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: iload_3
    //   193: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: ldc 'License-SDK'
    //   199: aload_2
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   206: pop
    //   207: sipush #200
    //   210: iload_3
    //   211: if_icmpne -> 516
    //   214: aload #6
    //   216: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   219: astore_2
    //   220: sipush #1024
    //   223: newarray byte
    //   225: astore #7
    //   227: new java/io/ByteArrayOutputStream
    //   230: dup
    //   231: invokespecial <init> : ()V
    //   234: astore #5
    //   236: aload_2
    //   237: aload #7
    //   239: invokevirtual read : ([B)I
    //   242: istore_3
    //   243: iload_3
    //   244: iconst_m1
    //   245: if_icmpeq -> 260
    //   248: aload #5
    //   250: aload #7
    //   252: iconst_0
    //   253: iload_3
    //   254: invokevirtual write : ([BII)V
    //   257: goto -> 236
    //   260: new java/lang/String
    //   263: dup
    //   264: aload #5
    //   266: invokevirtual toByteArray : ()[B
    //   269: ldc 'utf-8'
    //   271: invokespecial <init> : ([BLjava/lang/String;)V
    //   274: astore #7
    //   276: aload #5
    //   278: invokevirtual flush : ()V
    //   281: new java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial <init> : ()V
    //   288: astore #8
    //   290: aload #8
    //   292: ldc_w 'request data '
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload #8
    //   301: aload #7
    //   303: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 'License-SDK'
    //   309: aload #8
    //   311: invokevirtual toString : ()Ljava/lang/String;
    //   314: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   317: pop
    //   318: goto -> 525
    //   321: astore #10
    //   323: aload_1
    //   324: astore #9
    //   326: aload #6
    //   328: astore #8
    //   330: aload #7
    //   332: astore_1
    //   333: aload #10
    //   335: astore #7
    //   337: aload #9
    //   339: astore #6
    //   341: goto -> 842
    //   344: astore #10
    //   346: aload_1
    //   347: astore #9
    //   349: aload #6
    //   351: astore #8
    //   353: aload #7
    //   355: astore_1
    //   356: aload #10
    //   358: astore #7
    //   360: aload #9
    //   362: astore #6
    //   364: goto -> 1017
    //   367: astore #10
    //   369: aload_1
    //   370: astore #9
    //   372: aload #6
    //   374: astore #8
    //   376: aload #7
    //   378: astore_1
    //   379: aload #10
    //   381: astore #7
    //   383: aload #9
    //   385: astore #6
    //   387: goto -> 1185
    //   390: astore #7
    //   392: goto -> 415
    //   395: astore #7
    //   397: goto -> 443
    //   400: astore #7
    //   402: goto -> 469
    //   405: astore #7
    //   407: goto -> 495
    //   410: astore #7
    //   412: aconst_null
    //   413: astore #5
    //   415: aload_1
    //   416: astore #9
    //   418: aload #7
    //   420: astore #8
    //   422: aload_2
    //   423: astore_1
    //   424: aload #9
    //   426: astore #7
    //   428: aload #5
    //   430: astore_2
    //   431: aload #8
    //   433: astore #5
    //   435: goto -> 1545
    //   438: astore #7
    //   440: aconst_null
    //   441: astore #5
    //   443: ldc ''
    //   445: astore #10
    //   447: aload_1
    //   448: astore #9
    //   450: aload #6
    //   452: astore #8
    //   454: aload #10
    //   456: astore_1
    //   457: aload #9
    //   459: astore #6
    //   461: goto -> 842
    //   464: astore #7
    //   466: aconst_null
    //   467: astore #5
    //   469: ldc ''
    //   471: astore #10
    //   473: aload_1
    //   474: astore #9
    //   476: aload #6
    //   478: astore #8
    //   480: aload #10
    //   482: astore_1
    //   483: aload #9
    //   485: astore #6
    //   487: goto -> 1017
    //   490: astore #7
    //   492: aconst_null
    //   493: astore #5
    //   495: ldc ''
    //   497: astore #10
    //   499: aload_1
    //   500: astore #9
    //   502: aload #6
    //   504: astore #8
    //   506: aload #10
    //   508: astore_1
    //   509: aload #9
    //   511: astore #6
    //   513: goto -> 1185
    //   516: aconst_null
    //   517: astore_2
    //   518: aload_2
    //   519: astore #5
    //   521: aload #8
    //   523: astore #7
    //   525: aload_1
    //   526: ifnull -> 536
    //   529: aload_1
    //   530: invokevirtual close : ()V
    //   533: goto -> 536
    //   536: aload #5
    //   538: ifnull -> 546
    //   541: aload #5
    //   543: invokevirtual close : ()V
    //   546: aload_2
    //   547: ifnull -> 561
    //   550: aload_2
    //   551: invokevirtual close : ()V
    //   554: goto -> 561
    //   557: aload_1
    //   558: invokevirtual printStackTrace : ()V
    //   561: aload #6
    //   563: ifnull -> 571
    //   566: aload #6
    //   568: invokevirtual disconnect : ()V
    //   571: aload #7
    //   573: astore_2
    //   574: goto -> 1353
    //   577: astore #5
    //   579: aconst_null
    //   580: astore #7
    //   582: aload #7
    //   584: astore_2
    //   585: aload_1
    //   586: astore #8
    //   588: aload #7
    //   590: astore_1
    //   591: aload #8
    //   593: astore #7
    //   595: goto -> 1545
    //   598: astore #7
    //   600: ldc ''
    //   602: astore #10
    //   604: aconst_null
    //   605: astore_2
    //   606: aload_2
    //   607: astore #5
    //   609: aload_1
    //   610: astore #9
    //   612: aload #6
    //   614: astore #8
    //   616: aload #10
    //   618: astore_1
    //   619: aload #9
    //   621: astore #6
    //   623: goto -> 842
    //   626: astore #7
    //   628: ldc ''
    //   630: astore #10
    //   632: aconst_null
    //   633: astore_2
    //   634: aload_2
    //   635: astore #5
    //   637: aload_1
    //   638: astore #9
    //   640: aload #6
    //   642: astore #8
    //   644: aload #10
    //   646: astore_1
    //   647: aload #9
    //   649: astore #6
    //   651: goto -> 1017
    //   654: astore #7
    //   656: ldc ''
    //   658: astore #10
    //   660: aconst_null
    //   661: astore_2
    //   662: aload_2
    //   663: astore #5
    //   665: aload_1
    //   666: astore #9
    //   668: aload #6
    //   670: astore #8
    //   672: aload #10
    //   674: astore_1
    //   675: aload #9
    //   677: astore #6
    //   679: goto -> 1185
    //   682: astore #5
    //   684: aconst_null
    //   685: astore_1
    //   686: aload_1
    //   687: astore_2
    //   688: goto -> 1545
    //   691: astore #7
    //   693: ldc ''
    //   695: astore_1
    //   696: aconst_null
    //   697: astore #9
    //   699: aload #9
    //   701: astore_2
    //   702: aload_2
    //   703: astore #5
    //   705: aload #6
    //   707: astore #8
    //   709: aload #9
    //   711: astore #6
    //   713: goto -> 842
    //   716: astore #7
    //   718: ldc ''
    //   720: astore_1
    //   721: aconst_null
    //   722: astore #9
    //   724: aload #9
    //   726: astore_2
    //   727: aload_2
    //   728: astore #5
    //   730: aload #6
    //   732: astore #8
    //   734: aload #9
    //   736: astore #6
    //   738: goto -> 1017
    //   741: astore #7
    //   743: ldc ''
    //   745: astore_1
    //   746: aconst_null
    //   747: astore #9
    //   749: aload #9
    //   751: astore_2
    //   752: aload_2
    //   753: astore #5
    //   755: aload #6
    //   757: astore #8
    //   759: aload #9
    //   761: astore #6
    //   763: goto -> 1185
    //   766: astore #5
    //   768: aconst_null
    //   769: astore_1
    //   770: aload_1
    //   771: astore #6
    //   773: aload #6
    //   775: astore_2
    //   776: goto -> 1545
    //   779: astore #7
    //   781: ldc ''
    //   783: astore_1
    //   784: aconst_null
    //   785: astore #6
    //   787: aload #6
    //   789: astore_2
    //   790: aload_2
    //   791: astore #8
    //   793: aload #8
    //   795: astore #5
    //   797: goto -> 842
    //   800: astore #7
    //   802: ldc ''
    //   804: astore_1
    //   805: aconst_null
    //   806: astore #6
    //   808: aload #6
    //   810: astore_2
    //   811: aload_2
    //   812: astore #8
    //   814: aload #8
    //   816: astore #5
    //   818: goto -> 1017
    //   821: astore #7
    //   823: ldc ''
    //   825: astore_1
    //   826: aconst_null
    //   827: astore #6
    //   829: aload #6
    //   831: astore_2
    //   832: aload_2
    //   833: astore #8
    //   835: aload #8
    //   837: astore #5
    //   839: goto -> 1185
    //   842: aload_2
    //   843: astore #9
    //   845: aload #8
    //   847: astore #10
    //   849: aload #5
    //   851: astore #11
    //   853: aload #6
    //   855: astore #12
    //   857: new java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial <init> : ()V
    //   864: astore #14
    //   866: aload_2
    //   867: astore #9
    //   869: aload #8
    //   871: astore #10
    //   873: aload #5
    //   875: astore #11
    //   877: aload #6
    //   879: astore #12
    //   881: aload #14
    //   883: ldc_w 'Exception '
    //   886: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload_2
    //   891: astore #9
    //   893: aload #8
    //   895: astore #10
    //   897: aload #5
    //   899: astore #11
    //   901: aload #6
    //   903: astore #12
    //   905: aload #14
    //   907: aload #7
    //   909: invokevirtual getMessage : ()Ljava/lang/String;
    //   912: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: pop
    //   916: aload_2
    //   917: astore #9
    //   919: aload #8
    //   921: astore #10
    //   923: aload #5
    //   925: astore #11
    //   927: aload #6
    //   929: astore #12
    //   931: ldc 'License-SDK'
    //   933: aload #14
    //   935: invokevirtual toString : ()Ljava/lang/String;
    //   938: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   941: pop
    //   942: aload_2
    //   943: astore #9
    //   945: aload #8
    //   947: astore #10
    //   949: aload #5
    //   951: astore #11
    //   953: aload #6
    //   955: astore #12
    //   957: aload #7
    //   959: invokevirtual printStackTrace : ()V
    //   962: aload #6
    //   964: ifnull -> 975
    //   967: aload #6
    //   969: invokevirtual close : ()V
    //   972: goto -> 975
    //   975: aload #5
    //   977: ifnull -> 985
    //   980: aload #5
    //   982: invokevirtual close : ()V
    //   985: aload_2
    //   986: ifnull -> 1000
    //   989: aload_2
    //   990: invokevirtual close : ()V
    //   993: goto -> 1000
    //   996: aload_2
    //   997: invokevirtual printStackTrace : ()V
    //   1000: aload_1
    //   1001: astore_2
    //   1002: aload #8
    //   1004: ifnull -> 1353
    //   1007: aload #8
    //   1009: invokevirtual disconnect : ()V
    //   1012: aload_1
    //   1013: astore_2
    //   1014: goto -> 1353
    //   1017: aload_2
    //   1018: astore #9
    //   1020: aload #8
    //   1022: astore #10
    //   1024: aload #5
    //   1026: astore #11
    //   1028: aload #6
    //   1030: astore #12
    //   1032: new java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial <init> : ()V
    //   1039: astore #14
    //   1041: aload_2
    //   1042: astore #9
    //   1044: aload #8
    //   1046: astore #10
    //   1048: aload #5
    //   1050: astore #11
    //   1052: aload #6
    //   1054: astore #12
    //   1056: aload #14
    //   1058: ldc_w 'IOException '
    //   1061: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload_2
    //   1066: astore #9
    //   1068: aload #8
    //   1070: astore #10
    //   1072: aload #5
    //   1074: astore #11
    //   1076: aload #6
    //   1078: astore #12
    //   1080: aload #14
    //   1082: aload #7
    //   1084: invokevirtual getMessage : ()Ljava/lang/String;
    //   1087: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload_2
    //   1092: astore #9
    //   1094: aload #8
    //   1096: astore #10
    //   1098: aload #5
    //   1100: astore #11
    //   1102: aload #6
    //   1104: astore #12
    //   1106: ldc 'License-SDK'
    //   1108: aload #14
    //   1110: invokevirtual toString : ()Ljava/lang/String;
    //   1113: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1116: pop
    //   1117: aload_2
    //   1118: astore #9
    //   1120: aload #8
    //   1122: astore #10
    //   1124: aload #5
    //   1126: astore #11
    //   1128: aload #6
    //   1130: astore #12
    //   1132: aload #7
    //   1134: invokevirtual printStackTrace : ()V
    //   1137: aload #6
    //   1139: ifnull -> 1150
    //   1142: aload #6
    //   1144: invokevirtual close : ()V
    //   1147: goto -> 1150
    //   1150: aload #5
    //   1152: ifnull -> 1160
    //   1155: aload #5
    //   1157: invokevirtual close : ()V
    //   1160: aload_2
    //   1161: ifnull -> 1175
    //   1164: aload_2
    //   1165: invokevirtual close : ()V
    //   1168: goto -> 1175
    //   1171: aload_2
    //   1172: invokevirtual printStackTrace : ()V
    //   1175: aload_1
    //   1176: astore_2
    //   1177: aload #8
    //   1179: ifnull -> 1353
    //   1182: goto -> 1007
    //   1185: aload_2
    //   1186: astore #9
    //   1188: aload #8
    //   1190: astore #10
    //   1192: aload #5
    //   1194: astore #11
    //   1196: aload #6
    //   1198: astore #12
    //   1200: new java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial <init> : ()V
    //   1207: astore #14
    //   1209: aload_2
    //   1210: astore #9
    //   1212: aload #8
    //   1214: astore #10
    //   1216: aload #5
    //   1218: astore #11
    //   1220: aload #6
    //   1222: astore #12
    //   1224: aload #14
    //   1226: ldc_w 'MalformedURLException '
    //   1229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload_2
    //   1234: astore #9
    //   1236: aload #8
    //   1238: astore #10
    //   1240: aload #5
    //   1242: astore #11
    //   1244: aload #6
    //   1246: astore #12
    //   1248: aload #14
    //   1250: aload #7
    //   1252: invokevirtual getMessage : ()Ljava/lang/String;
    //   1255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: pop
    //   1259: aload_2
    //   1260: astore #9
    //   1262: aload #8
    //   1264: astore #10
    //   1266: aload #5
    //   1268: astore #11
    //   1270: aload #6
    //   1272: astore #12
    //   1274: ldc 'License-SDK'
    //   1276: aload #14
    //   1278: invokevirtual toString : ()Ljava/lang/String;
    //   1281: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1284: pop
    //   1285: aload_2
    //   1286: astore #9
    //   1288: aload #8
    //   1290: astore #10
    //   1292: aload #5
    //   1294: astore #11
    //   1296: aload #6
    //   1298: astore #12
    //   1300: aload #7
    //   1302: invokevirtual printStackTrace : ()V
    //   1305: aload #6
    //   1307: ifnull -> 1318
    //   1310: aload #6
    //   1312: invokevirtual close : ()V
    //   1315: goto -> 1318
    //   1318: aload #5
    //   1320: ifnull -> 1328
    //   1323: aload #5
    //   1325: invokevirtual close : ()V
    //   1328: aload_2
    //   1329: ifnull -> 1343
    //   1332: aload_2
    //   1333: invokevirtual close : ()V
    //   1336: goto -> 1343
    //   1339: aload_2
    //   1340: invokevirtual printStackTrace : ()V
    //   1343: aload_1
    //   1344: astore_2
    //   1345: aload #8
    //   1347: ifnull -> 1353
    //   1350: goto -> 1007
    //   1353: aload_2
    //   1354: invokevirtual length : ()I
    //   1357: ifle -> 1450
    //   1360: new org/json/JSONObject
    //   1363: dup
    //   1364: aload_2
    //   1365: invokespecial <init> : (Ljava/lang/String;)V
    //   1368: astore_1
    //   1369: goto -> 1379
    //   1372: astore_1
    //   1373: aload_1
    //   1374: invokevirtual printStackTrace : ()V
    //   1377: aconst_null
    //   1378: astore_1
    //   1379: aload_1
    //   1380: ifnull -> 1450
    //   1383: aload_1
    //   1384: ldc_w 'result'
    //   1387: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   1390: astore #5
    //   1392: aload #5
    //   1394: ifnull -> 1450
    //   1397: aload #5
    //   1399: invokevirtual length : ()I
    //   1402: ifle -> 1450
    //   1405: new java/util/ArrayList
    //   1408: dup
    //   1409: invokespecial <init> : ()V
    //   1412: astore_2
    //   1413: iconst_0
    //   1414: istore_3
    //   1415: aload_2
    //   1416: astore_1
    //   1417: iload_3
    //   1418: aload #5
    //   1420: invokevirtual length : ()I
    //   1423: if_icmpge -> 1452
    //   1426: aload #5
    //   1428: iload_3
    //   1429: invokevirtual optString : (I)Ljava/lang/String;
    //   1432: astore_1
    //   1433: aload_1
    //   1434: ifnull -> 1443
    //   1437: aload_2
    //   1438: aload_1
    //   1439: invokevirtual add : (Ljava/lang/Object;)Z
    //   1442: pop
    //   1443: iload_3
    //   1444: iconst_1
    //   1445: iadd
    //   1446: istore_3
    //   1447: goto -> 1415
    //   1450: aconst_null
    //   1451: astore_1
    //   1452: aload #13
    //   1454: astore_2
    //   1455: aload_1
    //   1456: ifnull -> 1527
    //   1459: aload #13
    //   1461: astore_2
    //   1462: aload_1
    //   1463: invokevirtual size : ()I
    //   1466: ifle -> 1527
    //   1469: aload_1
    //   1470: invokevirtual size : ()I
    //   1473: anewarray java/lang/String
    //   1476: astore #5
    //   1478: aload_1
    //   1479: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1482: astore_1
    //   1483: iload #4
    //   1485: istore_3
    //   1486: aload #5
    //   1488: astore_2
    //   1489: aload_1
    //   1490: invokeinterface hasNext : ()Z
    //   1495: ifeq -> 1527
    //   1498: aload_1
    //   1499: invokeinterface next : ()Ljava/lang/Object;
    //   1504: checkcast java/lang/String
    //   1507: astore_2
    //   1508: aload #5
    //   1510: iload_3
    //   1511: aload_2
    //   1512: aastore
    //   1513: iload_3
    //   1514: iconst_1
    //   1515: iadd
    //   1516: istore_3
    //   1517: ldc 'License-SDK'
    //   1519: aload_2
    //   1520: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1523: pop
    //   1524: goto -> 1486
    //   1527: aload_2
    //   1528: areturn
    //   1529: astore #5
    //   1531: aload #12
    //   1533: astore #7
    //   1535: aload #11
    //   1537: astore_2
    //   1538: aload #10
    //   1540: astore #6
    //   1542: aload #9
    //   1544: astore_1
    //   1545: aload #7
    //   1547: ifnull -> 1558
    //   1550: aload #7
    //   1552: invokevirtual close : ()V
    //   1555: goto -> 1558
    //   1558: aload_2
    //   1559: ifnull -> 1566
    //   1562: aload_2
    //   1563: invokevirtual close : ()V
    //   1566: aload_1
    //   1567: ifnull -> 1581
    //   1570: aload_1
    //   1571: invokevirtual close : ()V
    //   1574: goto -> 1581
    //   1577: aload_1
    //   1578: invokevirtual printStackTrace : ()V
    //   1581: aload #6
    //   1583: ifnull -> 1591
    //   1586: aload #6
    //   1588: invokevirtual disconnect : ()V
    //   1591: aload #5
    //   1593: athrow
    //   1594: ldc ''
    //   1596: astore_2
    //   1597: goto -> 62
    //   1600: astore_1
    //   1601: goto -> 557
    //   1604: astore_2
    //   1605: goto -> 996
    //   1608: astore_2
    //   1609: goto -> 1171
    //   1612: astore_2
    //   1613: goto -> 1339
    //   1616: astore_1
    //   1617: goto -> 1577
    // Exception table:
    //   from	to	target	type
    //   13	59	821	java/net/MalformedURLException
    //   13	59	800	java/io/IOException
    //   13	59	779	java/lang/Exception
    //   13	59	766	finally
    //   62	87	821	java/net/MalformedURLException
    //   62	87	800	java/io/IOException
    //   62	87	779	java/lang/Exception
    //   62	87	766	finally
    //   87	154	741	java/net/MalformedURLException
    //   87	154	716	java/io/IOException
    //   87	154	691	java/lang/Exception
    //   87	154	682	finally
    //   154	207	654	java/net/MalformedURLException
    //   154	207	626	java/io/IOException
    //   154	207	598	java/lang/Exception
    //   154	207	577	finally
    //   214	220	654	java/net/MalformedURLException
    //   214	220	626	java/io/IOException
    //   214	220	598	java/lang/Exception
    //   214	220	577	finally
    //   220	236	490	java/net/MalformedURLException
    //   220	236	464	java/io/IOException
    //   220	236	438	java/lang/Exception
    //   220	236	410	finally
    //   236	243	405	java/net/MalformedURLException
    //   236	243	400	java/io/IOException
    //   236	243	395	java/lang/Exception
    //   236	243	390	finally
    //   248	257	405	java/net/MalformedURLException
    //   248	257	400	java/io/IOException
    //   248	257	395	java/lang/Exception
    //   248	257	390	finally
    //   260	276	405	java/net/MalformedURLException
    //   260	276	400	java/io/IOException
    //   260	276	395	java/lang/Exception
    //   260	276	390	finally
    //   276	318	367	java/net/MalformedURLException
    //   276	318	344	java/io/IOException
    //   276	318	321	java/lang/Exception
    //   276	318	390	finally
    //   529	533	1600	java/io/IOException
    //   541	546	1600	java/io/IOException
    //   550	554	1600	java/io/IOException
    //   857	866	1529	finally
    //   881	890	1529	finally
    //   905	916	1529	finally
    //   931	942	1529	finally
    //   957	962	1529	finally
    //   967	972	1604	java/io/IOException
    //   980	985	1604	java/io/IOException
    //   989	993	1604	java/io/IOException
    //   1032	1041	1529	finally
    //   1056	1065	1529	finally
    //   1080	1091	1529	finally
    //   1106	1117	1529	finally
    //   1132	1137	1529	finally
    //   1142	1147	1608	java/io/IOException
    //   1155	1160	1608	java/io/IOException
    //   1164	1168	1608	java/io/IOException
    //   1200	1209	1529	finally
    //   1224	1233	1529	finally
    //   1248	1259	1529	finally
    //   1274	1285	1529	finally
    //   1300	1305	1529	finally
    //   1310	1315	1612	java/io/IOException
    //   1323	1328	1612	java/io/IOException
    //   1332	1336	1612	java/io/IOException
    //   1360	1369	1372	org/json/JSONException
    //   1550	1555	1616	java/io/IOException
    //   1562	1566	1616	java/io/IOException
    //   1570	1574	1616	java/io/IOException
  }
  
  public int init(String paramString) {
    this.path = paramString;
    return 0;
  }
  
  public int put_local_license(Context paramContext, String[] paramArrayOfString) {
    File file = paramContext.getDir(this.path, 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("put_local_license =");
    stringBuilder.append(file.getAbsolutePath());
    Log.e("License-SDK", stringBuilder.toString());
    if (file != null)
      file.delete(); 
    if (file != null && !file.exists())
      try {
        file.createNewFile();
      } catch (IOException iOException) {
        Log.e("License-SDK", "IOException");
        iOException.printStackTrace();
      }  
    String[] arrayOfString1 = null;
    String[] arrayOfString2 = null;
    String[] arrayOfString3 = null;
    stringBuilder = null;
    try {
      Exception exception;
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      try {
        int j = paramArrayOfString.length;
        for (int i = 0; i < j; i++) {
          fileOutputStream.write(paramArrayOfString[i].getBytes());
          fileOutputStream.write(10);
        } 
      } catch (FileNotFoundException fileNotFoundException) {
        FileOutputStream fileOutputStream1 = fileOutputStream;
      } catch (IOException iOException) {
        FileNotFoundException fileNotFoundException = (FileNotFoundException)exception;
      } catch (Exception exception1) {
        IOException iOException = (IOException)exception;
      } finally {
        Exception exception1;
        paramArrayOfString = null;
      } 
      return 0;
    } catch (FileNotFoundException fileNotFoundException) {
      paramArrayOfString = arrayOfString3;
      String[] arrayOfString = paramArrayOfString;
      Log.e("License-SDK", "FileNotFoundException");
      arrayOfString = paramArrayOfString;
      fileNotFoundException.printStackTrace();
      if (paramArrayOfString != null)
        paramArrayOfString.close(); 
    } catch (IOException iOException) {
      paramArrayOfString = arrayOfString2;
      String[] arrayOfString = paramArrayOfString;
      Log.e("License-SDK", "IOException");
      arrayOfString = paramArrayOfString;
      iOException.printStackTrace();
      if (paramArrayOfString != null) {
        paramArrayOfString.close();
        return -1;
      } 
    } catch (Exception exception) {
      paramArrayOfString = arrayOfString1;
      String[] arrayOfString = paramArrayOfString;
      Log.e("License-SDK", "Exception");
      arrayOfString = paramArrayOfString;
      exception.printStackTrace();
      if (paramArrayOfString != null)
        paramArrayOfString.close(); 
      return 0;
    } finally {}
    return -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\license\LicenseReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */