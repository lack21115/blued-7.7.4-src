package com.alibaba.mtl.log.e;

import java.util.Map;

public final class e {
  static {
    System.setProperty("http.keepAlive", "true");
  }
  
  public static a a(int paramInt, String paramString, Map<String, Object> paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: new com/alibaba/mtl/log/e/e$a
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: aload_1
    //   10: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   13: ifeq -> 19
    //   16: aload #7
    //   18: areturn
    //   19: new java/net/URL
    //   22: dup
    //   23: aload_1
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   30: checkcast java/net/HttpURLConnection
    //   33: astore #6
    //   35: aload #6
    //   37: ifnull -> 929
    //   40: iload_0
    //   41: iconst_2
    //   42: if_icmpeq -> 50
    //   45: iload_0
    //   46: iconst_3
    //   47: if_icmpne -> 56
    //   50: aload #6
    //   52: iconst_1
    //   53: invokevirtual setDoOutput : (Z)V
    //   56: aload #6
    //   58: iconst_1
    //   59: invokevirtual setDoInput : (Z)V
    //   62: iload_0
    //   63: iconst_2
    //   64: if_icmpeq -> 85
    //   67: iload_0
    //   68: iconst_3
    //   69: if_icmpne -> 75
    //   72: goto -> 85
    //   75: aload #6
    //   77: ldc 'GET'
    //   79: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   82: goto -> 92
    //   85: aload #6
    //   87: ldc 'POST'
    //   89: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   92: aload #6
    //   94: iconst_0
    //   95: invokevirtual setUseCaches : (Z)V
    //   98: aload #6
    //   100: sipush #10000
    //   103: invokevirtual setConnectTimeout : (I)V
    //   106: aload #6
    //   108: ldc 60000
    //   110: invokevirtual setReadTimeout : (I)V
    //   113: aload #6
    //   115: ldc 'Connection'
    //   117: ldc 'close'
    //   119: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   122: iload_3
    //   123: ifeq -> 135
    //   126: aload #6
    //   128: ldc 'Accept-Encoding'
    //   130: ldc 'gzip,deflate'
    //   132: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload #6
    //   137: iconst_1
    //   138: invokevirtual setInstanceFollowRedirects : (Z)V
    //   141: iload_0
    //   142: iconst_2
    //   143: if_icmpeq -> 159
    //   146: iload_0
    //   147: iconst_3
    //   148: if_icmpne -> 154
    //   151: goto -> 159
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -> 569
    //   159: iload_0
    //   160: iconst_2
    //   161: if_icmpne -> 176
    //   164: aload #6
    //   166: ldc 'Content-Type'
    //   168: ldc 'multipart/form-data; boundary=GJircTeP'
    //   170: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -> 190
    //   176: iload_0
    //   177: iconst_3
    //   178: if_icmpne -> 190
    //   181: aload #6
    //   183: ldc 'Content-Type'
    //   185: ldc 'application/x-www-form-urlencoded'
    //   187: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_2
    //   191: ifnull -> 539
    //   194: aload_2
    //   195: invokeinterface size : ()I
    //   200: ifle -> 539
    //   203: new java/io/ByteArrayOutputStream
    //   206: dup
    //   207: invokespecial <init> : ()V
    //   210: astore_1
    //   211: aload_2
    //   212: invokeinterface keySet : ()Ljava/util/Set;
    //   217: astore #8
    //   219: aload #8
    //   221: invokeinterface size : ()I
    //   226: anewarray java/lang/String
    //   229: astore #9
    //   231: aload #8
    //   233: aload #9
    //   235: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   240: pop
    //   241: invokestatic a : ()Lcom/alibaba/mtl/log/e/g;
    //   244: aload #9
    //   246: iconst_1
    //   247: invokevirtual a : ([Ljava/lang/String;Z)[Ljava/lang/String;
    //   250: astore #8
    //   252: aload #8
    //   254: arraylength
    //   255: istore #5
    //   257: iconst_0
    //   258: istore #4
    //   260: iload #4
    //   262: iload #5
    //   264: if_icmpge -> 509
    //   267: aload #8
    //   269: iload #4
    //   271: aaload
    //   272: astore #9
    //   274: iload_0
    //   275: iconst_2
    //   276: if_icmpne -> 354
    //   279: aload_2
    //   280: aload #9
    //   282: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   287: checkcast [B
    //   290: checkcast [B
    //   293: astore #10
    //   295: aload #10
    //   297: ifnull -> 500
    //   300: aload_1
    //   301: ldc '--GJircTeP\\r\\nContent-Disposition: form-data; name="%s"; filename="%s"\\r\\nContent-Type: application/octet-stream \\r\\n\\r\\n'
    //   303: iconst_2
    //   304: anewarray java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload #9
    //   311: aastore
    //   312: dup
    //   313: iconst_1
    //   314: aload #9
    //   316: aastore
    //   317: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   320: invokevirtual getBytes : ()[B
    //   323: invokevirtual write : ([B)V
    //   326: aload_1
    //   327: aload #10
    //   329: invokevirtual write : ([B)V
    //   332: aload_1
    //   333: ldc '\\r\\n'
    //   335: invokevirtual getBytes : ()[B
    //   338: invokevirtual write : ([B)V
    //   341: goto -> 500
    //   344: astore #9
    //   346: aload #9
    //   348: invokevirtual printStackTrace : ()V
    //   351: goto -> 500
    //   354: iload_0
    //   355: iconst_3
    //   356: if_icmpne -> 500
    //   359: aload_2
    //   360: aload #9
    //   362: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast java/lang/String
    //   370: astore #10
    //   372: aload_1
    //   373: invokevirtual size : ()I
    //   376: ifle -> 445
    //   379: new java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial <init> : ()V
    //   386: astore #11
    //   388: aload #11
    //   390: ldc '&'
    //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload #11
    //   398: aload #9
    //   400: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload #11
    //   406: ldc '='
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload #11
    //   414: aload #10
    //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: aload #11
    //   423: invokevirtual toString : ()Ljava/lang/String;
    //   426: invokevirtual getBytes : ()[B
    //   429: invokevirtual write : ([B)V
    //   432: goto -> 500
    //   435: astore #9
    //   437: aload #9
    //   439: invokevirtual printStackTrace : ()V
    //   442: goto -> 500
    //   445: new java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial <init> : ()V
    //   452: astore #11
    //   454: aload #11
    //   456: aload #9
    //   458: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload #11
    //   464: ldc '='
    //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #11
    //   472: aload #10
    //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_1
    //   479: aload #11
    //   481: invokevirtual toString : ()Ljava/lang/String;
    //   484: invokevirtual getBytes : ()[B
    //   487: invokevirtual write : ([B)V
    //   490: goto -> 500
    //   493: astore #9
    //   495: aload #9
    //   497: invokevirtual printStackTrace : ()V
    //   500: iload #4
    //   502: iconst_1
    //   503: iadd
    //   504: istore #4
    //   506: goto -> 260
    //   509: iload_0
    //   510: iconst_2
    //   511: if_icmpne -> 531
    //   514: aload_1
    //   515: ldc '--GJircTeP--\\r\\n'
    //   517: invokevirtual getBytes : ()[B
    //   520: invokevirtual write : ([B)V
    //   523: goto -> 531
    //   526: astore_2
    //   527: aload_2
    //   528: invokevirtual printStackTrace : ()V
    //   531: aload_1
    //   532: invokevirtual toByteArray : ()[B
    //   535: astore_1
    //   536: goto -> 541
    //   539: aconst_null
    //   540: astore_1
    //   541: aload_1
    //   542: ifnull -> 552
    //   545: aload_1
    //   546: arraylength
    //   547: istore #4
    //   549: goto -> 555
    //   552: iconst_0
    //   553: istore #4
    //   555: aload #6
    //   557: ldc 'Content-Length'
    //   559: iload #4
    //   561: invokestatic valueOf : (I)Ljava/lang/String;
    //   564: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   567: aload_1
    //   568: astore_2
    //   569: aload #6
    //   571: invokevirtual connect : ()V
    //   574: iload_0
    //   575: iconst_2
    //   576: if_icmpeq -> 584
    //   579: iload_0
    //   580: iconst_3
    //   581: if_icmpne -> 626
    //   584: aload_2
    //   585: ifnull -> 626
    //   588: aload_2
    //   589: arraylength
    //   590: ifle -> 626
    //   593: new java/io/DataOutputStream
    //   596: dup
    //   597: aload #6
    //   599: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   602: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   605: astore_1
    //   606: aload_1
    //   607: aload_2
    //   608: invokevirtual write : ([B)V
    //   611: aload_1
    //   612: invokevirtual flush : ()V
    //   615: goto -> 628
    //   618: astore_2
    //   619: goto -> 899
    //   622: astore_2
    //   623: goto -> 875
    //   626: aconst_null
    //   627: astore_1
    //   628: aload_1
    //   629: ifnull -> 644
    //   632: aload_1
    //   633: invokevirtual close : ()V
    //   636: goto -> 644
    //   639: astore_1
    //   640: aload_1
    //   641: invokevirtual printStackTrace : ()V
    //   644: aload #7
    //   646: aload #6
    //   648: invokevirtual getResponseCode : ()I
    //   651: putfield E : I
    //   654: goto -> 662
    //   657: astore_1
    //   658: aload_1
    //   659: invokevirtual printStackTrace : ()V
    //   662: new java/io/ByteArrayOutputStream
    //   665: dup
    //   666: invokespecial <init> : ()V
    //   669: astore #8
    //   671: iload_3
    //   672: ifeq -> 704
    //   675: ldc 'gzip'
    //   677: aload #6
    //   679: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   682: invokevirtual equals : (Ljava/lang/Object;)Z
    //   685: ifeq -> 704
    //   688: new java/util/zip/GZIPInputStream
    //   691: dup
    //   692: aload #6
    //   694: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   697: invokespecial <init> : (Ljava/io/InputStream;)V
    //   700: astore_2
    //   701: goto -> 717
    //   704: new java/io/DataInputStream
    //   707: dup
    //   708: aload #6
    //   710: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   713: invokespecial <init> : (Ljava/io/InputStream;)V
    //   716: astore_2
    //   717: aload_2
    //   718: astore_1
    //   719: invokestatic currentTimeMillis : ()J
    //   722: pop2
    //   723: aload_2
    //   724: astore_1
    //   725: sipush #2048
    //   728: newarray byte
    //   730: astore #6
    //   732: aload_2
    //   733: astore_1
    //   734: aload_2
    //   735: aload #6
    //   737: iconst_0
    //   738: sipush #2048
    //   741: invokevirtual read : ([BII)I
    //   744: istore_0
    //   745: iload_0
    //   746: iconst_m1
    //   747: if_icmpeq -> 764
    //   750: aload_2
    //   751: astore_1
    //   752: aload #8
    //   754: aload #6
    //   756: iconst_0
    //   757: iload_0
    //   758: invokevirtual write : ([BII)V
    //   761: goto -> 732
    //   764: aload_2
    //   765: invokevirtual close : ()V
    //   768: goto -> 776
    //   771: astore_1
    //   772: aload_1
    //   773: invokevirtual printStackTrace : ()V
    //   776: aload #8
    //   778: invokevirtual size : ()I
    //   781: ifle -> 929
    //   784: aload #7
    //   786: aload #8
    //   788: invokevirtual toByteArray : ()[B
    //   791: putfield e : [B
    //   794: aload #7
    //   796: areturn
    //   797: astore #6
    //   799: goto -> 813
    //   802: astore_1
    //   803: aconst_null
    //   804: astore #6
    //   806: goto -> 845
    //   809: astore #6
    //   811: aconst_null
    //   812: astore_2
    //   813: aload_2
    //   814: astore_1
    //   815: aload #6
    //   817: invokevirtual printStackTrace : ()V
    //   820: aload_2
    //   821: ifnull -> 836
    //   824: aload_2
    //   825: invokevirtual close : ()V
    //   828: aload #7
    //   830: areturn
    //   831: astore_1
    //   832: aload_1
    //   833: invokevirtual printStackTrace : ()V
    //   836: aload #7
    //   838: areturn
    //   839: astore_2
    //   840: aload_1
    //   841: astore #6
    //   843: aload_2
    //   844: astore_1
    //   845: aload #6
    //   847: ifnull -> 863
    //   850: aload #6
    //   852: invokevirtual close : ()V
    //   855: goto -> 863
    //   858: astore_2
    //   859: aload_2
    //   860: invokevirtual printStackTrace : ()V
    //   863: aload_1
    //   864: athrow
    //   865: astore_1
    //   866: aconst_null
    //   867: astore #6
    //   869: goto -> 904
    //   872: astore_2
    //   873: aconst_null
    //   874: astore_1
    //   875: aload_2
    //   876: invokevirtual printStackTrace : ()V
    //   879: aload_1
    //   880: ifnull -> 895
    //   883: aload_1
    //   884: invokevirtual close : ()V
    //   887: aload #7
    //   889: areturn
    //   890: astore_1
    //   891: aload_1
    //   892: invokevirtual printStackTrace : ()V
    //   895: aload #7
    //   897: areturn
    //   898: astore_2
    //   899: aload_1
    //   900: astore #6
    //   902: aload_2
    //   903: astore_1
    //   904: aload #6
    //   906: ifnull -> 922
    //   909: aload #6
    //   911: invokevirtual close : ()V
    //   914: goto -> 922
    //   917: astore_2
    //   918: aload_2
    //   919: invokevirtual printStackTrace : ()V
    //   922: aload_1
    //   923: athrow
    //   924: astore_1
    //   925: aload_1
    //   926: invokevirtual printStackTrace : ()V
    //   929: aload #7
    //   931: areturn
    //   932: astore_1
    //   933: aload_1
    //   934: invokevirtual printStackTrace : ()V
    //   937: aload #7
    //   939: areturn
    //   940: astore_1
    //   941: aload_1
    //   942: invokevirtual printStackTrace : ()V
    //   945: aload #7
    //   947: areturn
    // Exception table:
    //   from	to	target	type
    //   19	35	940	java/net/MalformedURLException
    //   19	35	932	java/io/IOException
    //   75	82	924	java/net/ProtocolException
    //   85	92	924	java/net/ProtocolException
    //   300	341	344	java/io/IOException
    //   379	432	435	java/io/IOException
    //   445	490	493	java/io/IOException
    //   514	523	526	java/io/IOException
    //   569	574	872	java/lang/Exception
    //   569	574	865	finally
    //   588	606	872	java/lang/Exception
    //   588	606	865	finally
    //   606	615	622	java/lang/Exception
    //   606	615	618	finally
    //   632	636	639	java/io/IOException
    //   644	654	657	java/io/IOException
    //   675	701	809	java/io/IOException
    //   675	701	802	finally
    //   704	717	809	java/io/IOException
    //   704	717	802	finally
    //   719	723	797	java/io/IOException
    //   719	723	839	finally
    //   725	732	797	java/io/IOException
    //   725	732	839	finally
    //   734	745	797	java/io/IOException
    //   734	745	839	finally
    //   752	761	797	java/io/IOException
    //   752	761	839	finally
    //   764	768	771	java/lang/Exception
    //   815	820	839	finally
    //   824	828	831	java/lang/Exception
    //   850	855	858	java/lang/Exception
    //   875	879	898	finally
    //   883	887	890	java/io/IOException
    //   909	914	917	java/io/IOException
  }
  
  public static class a {
    public int E = -1;
    
    public byte[] e = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */