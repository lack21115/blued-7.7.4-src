package com.ss.android.socialbase.downloader.l;

import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.i.e;

public class b implements Runnable {
  private static final String a = b.class.getSimpleName();
  
  private com.ss.android.socialbase.downloader.g.b b;
  
  private com.ss.android.socialbase.downloader.g.b c;
  
  private d d;
  
  private final d e;
  
  private c f;
  
  private final e g;
  
  private e h;
  
  private k i;
  
  private volatile boolean j;
  
  private volatile boolean k;
  
  private boolean l = false;
  
  public b(com.ss.android.socialbase.downloader.g.b paramb, d paramd, e parame, e parame1) {
    this(paramb, paramd, parame1);
    this.h = parame;
  }
  
  public b(com.ss.android.socialbase.downloader.g.b paramb, d paramd, e parame) {
    this.c = paramb;
    this.e = paramd;
    if (paramd != null)
      this.f = paramd.a(); 
    this.g = parame;
    this.i = com.ss.android.socialbase.downloader.downloader.b.p();
    this.c.a(this);
  }
  
  private void a(com.ss.android.socialbase.downloader.g.b paramb, long paramLong) {
    com.ss.android.socialbase.downloader.g.b b1;
    if (paramb.d()) {
      b1 = paramb.e();
    } else {
      b1 = paramb;
    } 
    if (b1 != null) {
      if (b1.h())
        this.i.a(b1.k(), b1.b(), paramLong); 
      b1.b(paramLong);
      this.i.a(b1.k(), b1.s(), b1.b(), paramLong);
      return;
    } 
    if (paramb.d())
      this.i.a(paramb.k(), paramb.s(), paramLong); 
  }
  
  private boolean a(com.ss.android.socialbase.downloader.g.b paramb) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual d : ()Z
    //   4: ifeq -> 40
    //   7: aload_1
    //   8: invokevirtual f : ()Z
    //   11: ifeq -> 40
    //   14: aload_1
    //   15: invokevirtual e : ()Lcom/ss/android/socialbase/downloader/g/b;
    //   18: astore #16
    //   20: aload #16
    //   22: ifnull -> 40
    //   25: aload #16
    //   27: invokevirtual s : ()I
    //   30: aload_1
    //   31: invokevirtual s : ()I
    //   34: if_icmpne -> 40
    //   37: goto -> 43
    //   40: aconst_null
    //   41: astore #16
    //   43: aload #16
    //   45: ifnull -> 58
    //   48: aload #16
    //   50: invokevirtual i : ()Z
    //   53: ifeq -> 58
    //   56: iconst_1
    //   57: ireturn
    //   58: aload_1
    //   59: invokevirtual n : ()J
    //   62: lstore_3
    //   63: aload_1
    //   64: invokevirtual p : ()J
    //   67: lstore #7
    //   69: aload_1
    //   70: invokevirtual n : ()J
    //   73: lstore #5
    //   75: aload #16
    //   77: ifnull -> 100
    //   80: aload #16
    //   82: invokevirtual n : ()J
    //   85: lstore #5
    //   87: aload #16
    //   89: invokevirtual n : ()J
    //   92: lstore_3
    //   93: aload #16
    //   95: invokevirtual p : ()J
    //   98: lstore #7
    //   100: lconst_0
    //   101: lstore #11
    //   103: aload_0
    //   104: invokespecial e : ()Z
    //   107: istore #15
    //   109: iload #15
    //   111: ifeq -> 120
    //   114: aload_0
    //   115: invokespecial d : ()V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_0
    //   121: invokespecial c : ()Ljava/lang/String;
    //   124: astore #17
    //   126: aload_0
    //   127: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   130: ifnull -> 1087
    //   133: iconst_1
    //   134: istore #15
    //   136: goto -> 139
    //   139: aload_0
    //   140: iload #15
    //   142: putfield l : Z
    //   145: aload_1
    //   146: aload_0
    //   147: getfield l : Z
    //   150: invokevirtual b : (Z)V
    //   153: aload_0
    //   154: getfield l : Z
    //   157: ifne -> 252
    //   160: aload_0
    //   161: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   164: invokevirtual B : ()Ljava/util/List;
    //   167: astore #18
    //   169: aload_0
    //   170: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   173: invokevirtual ac : ()Ljava/lang/String;
    //   176: astore #19
    //   178: aload #18
    //   180: aload #19
    //   182: lload_3
    //   183: lload #7
    //   185: invokestatic a : (Ljava/util/List;Ljava/lang/String;JJ)Ljava/util/List;
    //   188: astore #18
    //   190: aload #18
    //   192: new com/ss/android/socialbase/downloader/g/e
    //   195: dup
    //   196: ldc 'Chunk-Index'
    //   198: aload_1
    //   199: invokevirtual s : ()I
    //   202: invokestatic valueOf : (I)Ljava/lang/String;
    //   205: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   208: invokeinterface add : (Ljava/lang/Object;)Z
    //   213: pop
    //   214: aload_0
    //   215: aload_0
    //   216: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   219: invokevirtual o : ()Z
    //   222: aload_0
    //   223: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   226: invokevirtual C : ()I
    //   229: aload #17
    //   231: aload #18
    //   233: invokestatic a : (ZILjava/lang/String;Ljava/util/List;)Lcom/ss/android/socialbase/downloader/i/e;
    //   236: putfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   239: goto -> 252
    //   242: astore #17
    //   244: goto -> 322
    //   247: astore #16
    //   249: goto -> 624
    //   252: aload_0
    //   253: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   256: ifnull -> 392
    //   259: aload_0
    //   260: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   263: astore #17
    //   265: aload #17
    //   267: ifnull -> 392
    //   270: aload_0
    //   271: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   274: invokeinterface b : ()I
    //   279: istore_2
    //   280: iload_2
    //   281: sipush #200
    //   284: if_icmplt -> 294
    //   287: iload_2
    //   288: sipush #300
    //   291: if_icmplt -> 392
    //   294: aload_0
    //   295: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   298: aload_0
    //   299: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   302: invokeinterface a : (Lcom/ss/android/socialbase/downloader/i/c;)V
    //   307: goto -> 392
    //   310: astore #17
    //   312: aload #17
    //   314: invokevirtual printStackTrace : ()V
    //   317: goto -> 392
    //   320: astore #17
    //   322: aload #17
    //   324: ldc 'ChunkRunnableConnection'
    //   326: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   329: aload_0
    //   330: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   333: ifnull -> 392
    //   336: aload_0
    //   337: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   340: astore #17
    //   342: aload #17
    //   344: ifnull -> 392
    //   347: aload_0
    //   348: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   351: invokeinterface b : ()I
    //   356: istore_2
    //   357: iload_2
    //   358: sipush #200
    //   361: if_icmplt -> 371
    //   364: iload_2
    //   365: sipush #300
    //   368: if_icmplt -> 392
    //   371: aload_0
    //   372: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   375: aload_0
    //   376: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   379: invokeinterface a : (Lcom/ss/android/socialbase/downloader/i/c;)V
    //   384: goto -> 392
    //   387: astore #17
    //   389: goto -> 312
    //   392: aload_0
    //   393: invokespecial e : ()Z
    //   396: istore #15
    //   398: iload #15
    //   400: ifeq -> 409
    //   403: aload_0
    //   404: invokespecial d : ()V
    //   407: iconst_0
    //   408: ireturn
    //   409: aload_0
    //   410: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   413: ifnull -> 597
    //   416: aload_0
    //   417: getfield l : Z
    //   420: istore #15
    //   422: iload #15
    //   424: ifne -> 491
    //   427: aload_0
    //   428: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   431: invokeinterface b : ()I
    //   436: istore_2
    //   437: iload_2
    //   438: invokestatic b : (I)Z
    //   441: ifeq -> 447
    //   444: goto -> 491
    //   447: new com/ss/android/socialbase/downloader/e/a
    //   450: dup
    //   451: sipush #1002
    //   454: ldc 'Http response error , code is : %s '
    //   456: iconst_1
    //   457: anewarray java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: iload_2
    //   463: invokestatic valueOf : (I)Ljava/lang/String;
    //   466: aastore
    //   467: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   470: invokespecial <init> : (ILjava/lang/String;)V
    //   473: athrow
    //   474: astore #17
    //   476: aload #17
    //   478: ldc 'ChunkRunnableGetResponseCode'
    //   480: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   483: goto -> 491
    //   486: astore #16
    //   488: aload #16
    //   490: athrow
    //   491: aload_0
    //   492: new com/ss/android/socialbase/downloader/downloader/d
    //   495: dup
    //   496: aload_0
    //   497: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   500: aload_0
    //   501: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   504: aload_1
    //   505: aload_0
    //   506: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   509: invokespecial <init> : (Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/i/e;Lcom/ss/android/socialbase/downloader/g/b;Lcom/ss/android/socialbase/downloader/l/e;)V
    //   512: putfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   515: aload #16
    //   517: ifnull -> 577
    //   520: aload #16
    //   522: iconst_0
    //   523: invokevirtual c : (Z)J
    //   526: lstore #13
    //   528: lload #13
    //   530: lstore #9
    //   532: lload #7
    //   534: lconst_0
    //   535: lcmp
    //   536: ifeq -> 558
    //   539: lload #13
    //   541: lstore #9
    //   543: lload #7
    //   545: lload_3
    //   546: lcmp
    //   547: iflt -> 558
    //   550: lload #7
    //   552: lload_3
    //   553: lsub
    //   554: lconst_1
    //   555: ladd
    //   556: lstore #9
    //   558: aload_0
    //   559: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   562: aload #16
    //   564: invokevirtual n : ()J
    //   567: aload #16
    //   569: invokevirtual p : ()J
    //   572: lload #9
    //   574: invokevirtual a : (JJJ)V
    //   577: aload_0
    //   578: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   581: invokevirtual d : ()V
    //   584: aload_0
    //   585: invokespecial d : ()V
    //   588: iconst_1
    //   589: ireturn
    //   590: astore #16
    //   592: iconst_1
    //   593: istore_2
    //   594: goto -> 754
    //   597: new com/ss/android/socialbase/downloader/e/a
    //   600: dup
    //   601: sipush #1022
    //   604: new java/io/IOException
    //   607: dup
    //   608: ldc 'download can't continue, chunk connection is null'
    //   610: invokespecial <init> : (Ljava/lang/String;)V
    //   613: invokespecial <init> : (ILjava/lang/Throwable;)V
    //   616: athrow
    //   617: astore #16
    //   619: goto -> 629
    //   622: astore #16
    //   624: aload #16
    //   626: athrow
    //   627: astore #16
    //   629: aload_0
    //   630: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   633: ifnull -> 694
    //   636: aload_0
    //   637: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   640: astore #17
    //   642: aload #17
    //   644: ifnull -> 694
    //   647: aload_0
    //   648: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   651: invokeinterface b : ()I
    //   656: istore_2
    //   657: iload_2
    //   658: sipush #200
    //   661: if_icmplt -> 671
    //   664: iload_2
    //   665: sipush #300
    //   668: if_icmplt -> 694
    //   671: aload_0
    //   672: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   675: aload_0
    //   676: getfield h : Lcom/ss/android/socialbase/downloader/i/e;
    //   679: invokeinterface a : (Lcom/ss/android/socialbase/downloader/i/c;)V
    //   684: goto -> 694
    //   687: astore #17
    //   689: aload #17
    //   691: invokevirtual printStackTrace : ()V
    //   694: aload #16
    //   696: athrow
    //   697: astore_1
    //   698: goto -> 707
    //   701: astore #16
    //   703: goto -> 752
    //   706: astore_1
    //   707: aload_0
    //   708: invokespecial e : ()Z
    //   711: istore #15
    //   713: iload #15
    //   715: ifeq -> 724
    //   718: aload_0
    //   719: invokespecial d : ()V
    //   722: iconst_1
    //   723: ireturn
    //   724: aload_1
    //   725: ldc 'downloadChunkInner'
    //   727: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;)V
    //   730: goto -> 744
    //   733: astore_1
    //   734: aload_0
    //   735: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   738: aload_1
    //   739: invokeinterface b : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   744: aload_0
    //   745: invokespecial d : ()V
    //   748: iconst_0
    //   749: ireturn
    //   750: astore #16
    //   752: iconst_0
    //   753: istore_2
    //   754: aload_0
    //   755: invokespecial e : ()Z
    //   758: ifeq -> 764
    //   761: goto -> 718
    //   764: aload #16
    //   766: invokestatic b : (Lcom/ss/android/socialbase/downloader/e/a;)Z
    //   769: ifeq -> 790
    //   772: aload_0
    //   773: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   776: aload #16
    //   778: iconst_0
    //   779: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;Z)V
    //   784: aload_0
    //   785: invokespecial d : ()V
    //   788: iconst_0
    //   789: ireturn
    //   790: aload_0
    //   791: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   794: aload #16
    //   796: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;)Z
    //   801: ifeq -> 1003
    //   804: aload #16
    //   806: invokestatic a : (Lcom/ss/android/socialbase/downloader/e/a;)Z
    //   809: ifeq -> 830
    //   812: aload_0
    //   813: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   816: aload #16
    //   818: iconst_1
    //   819: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;Z)V
    //   824: aload_0
    //   825: invokespecial d : ()V
    //   828: iconst_0
    //   829: ireturn
    //   830: lload #11
    //   832: lstore_3
    //   833: iload_2
    //   834: ifeq -> 929
    //   837: aload_0
    //   838: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   841: ifnull -> 912
    //   844: bipush #32
    //   846: invokestatic a : (I)Z
    //   849: ifeq -> 891
    //   852: aload_0
    //   853: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   856: invokevirtual a : ()J
    //   859: aload_0
    //   860: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   863: invokevirtual e : ()J
    //   866: lsub
    //   867: lstore_3
    //   868: lload_3
    //   869: lconst_0
    //   870: lcmp
    //   871: istore_2
    //   872: iload_2
    //   873: ifle -> 1093
    //   876: aload_0
    //   877: aload_1
    //   878: aload_0
    //   879: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   882: invokevirtual e : ()J
    //   885: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/b;J)V
    //   888: goto -> 929
    //   891: aload_0
    //   892: getfield d : Lcom/ss/android/socialbase/downloader/downloader/d;
    //   895: invokevirtual a : ()J
    //   898: lload #5
    //   900: lsub
    //   901: lstore_3
    //   902: aload_0
    //   903: aload_1
    //   904: lload #5
    //   906: invokespecial a : (Lcom/ss/android/socialbase/downloader/g/b;J)V
    //   909: goto -> 929
    //   912: aload_0
    //   913: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   916: aload #16
    //   918: invokeinterface b : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   923: aload_0
    //   924: invokespecial d : ()V
    //   927: iconst_0
    //   928: ireturn
    //   929: bipush #16
    //   931: invokestatic a : (I)Z
    //   934: ifeq -> 955
    //   937: aload_0
    //   938: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   941: aload_1
    //   942: aload #16
    //   944: lload_3
    //   945: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/b;Lcom/ss/android/socialbase/downloader/e/a;J)Lcom/ss/android/socialbase/downloader/e/g;
    //   950: astore #16
    //   952: goto -> 969
    //   955: aload_0
    //   956: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   959: aload #16
    //   961: lload_3
    //   962: invokeinterface a : (Lcom/ss/android/socialbase/downloader/e/a;J)Lcom/ss/android/socialbase/downloader/e/g;
    //   967: astore #16
    //   969: getstatic com/ss/android/socialbase/downloader/e/g.a : Lcom/ss/android/socialbase/downloader/e/g;
    //   972: astore #17
    //   974: aload #16
    //   976: aload #17
    //   978: if_acmpne -> 987
    //   981: aload_0
    //   982: invokespecial d : ()V
    //   985: iconst_0
    //   986: ireturn
    //   987: aload_1
    //   988: iconst_0
    //   989: invokevirtual b : (Z)V
    //   992: aload_0
    //   993: invokespecial d : ()V
    //   996: aload_0
    //   997: invokespecial d : ()V
    //   1000: goto -> 0
    //   1003: aload_0
    //   1004: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   1007: invokevirtual ao : ()Z
    //   1010: ifeq -> 1063
    //   1013: aload_0
    //   1014: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   1017: invokevirtual ap : ()Z
    //   1020: ifne -> 1063
    //   1023: aload_0
    //   1024: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   1027: invokevirtual aV : ()I
    //   1030: iconst_1
    //   1031: if_icmple -> 1063
    //   1034: aload #16
    //   1036: aload_0
    //   1037: getfield f : Lcom/ss/android/socialbase/downloader/g/c;
    //   1040: invokestatic a : (Lcom/ss/android/socialbase/downloader/e/a;Lcom/ss/android/socialbase/downloader/g/c;)Z
    //   1043: ifeq -> 1063
    //   1046: aload_0
    //   1047: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   1050: aload #16
    //   1052: invokeinterface c : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   1057: aload_0
    //   1058: invokespecial d : ()V
    //   1061: iconst_0
    //   1062: ireturn
    //   1063: aload_0
    //   1064: getfield g : Lcom/ss/android/socialbase/downloader/l/e;
    //   1067: aload #16
    //   1069: invokeinterface b : (Lcom/ss/android/socialbase/downloader/e/a;)V
    //   1074: aload_0
    //   1075: invokespecial d : ()V
    //   1078: iconst_0
    //   1079: ireturn
    //   1080: astore_1
    //   1081: aload_0
    //   1082: invokespecial d : ()V
    //   1085: aload_1
    //   1086: athrow
    //   1087: iconst_0
    //   1088: istore #15
    //   1090: goto -> 139
    //   1093: iload_2
    //   1094: ifge -> 929
    //   1097: lload #11
    //   1099: lstore_3
    //   1100: goto -> 929
    // Exception table:
    //   from	to	target	type
    //   103	109	750	com/ss/android/socialbase/downloader/e/a
    //   103	109	706	finally
    //   120	133	750	com/ss/android/socialbase/downloader/e/a
    //   120	133	706	finally
    //   139	153	750	com/ss/android/socialbase/downloader/e/a
    //   139	153	706	finally
    //   153	178	622	com/ss/android/socialbase/downloader/e/a
    //   153	178	320	finally
    //   178	239	247	com/ss/android/socialbase/downloader/e/a
    //   178	239	242	finally
    //   252	265	750	com/ss/android/socialbase/downloader/e/a
    //   252	265	706	finally
    //   270	280	310	finally
    //   294	307	310	finally
    //   312	317	750	com/ss/android/socialbase/downloader/e/a
    //   312	317	706	finally
    //   322	329	617	finally
    //   329	342	750	com/ss/android/socialbase/downloader/e/a
    //   329	342	706	finally
    //   347	357	387	finally
    //   371	384	387	finally
    //   392	398	750	com/ss/android/socialbase/downloader/e/a
    //   392	398	706	finally
    //   409	422	701	com/ss/android/socialbase/downloader/e/a
    //   409	422	697	finally
    //   427	444	486	com/ss/android/socialbase/downloader/e/a
    //   427	444	474	finally
    //   447	474	486	com/ss/android/socialbase/downloader/e/a
    //   447	474	474	finally
    //   476	483	701	com/ss/android/socialbase/downloader/e/a
    //   476	483	697	finally
    //   488	491	701	com/ss/android/socialbase/downloader/e/a
    //   488	491	697	finally
    //   491	515	701	com/ss/android/socialbase/downloader/e/a
    //   491	515	697	finally
    //   520	528	701	com/ss/android/socialbase/downloader/e/a
    //   520	528	697	finally
    //   558	577	701	com/ss/android/socialbase/downloader/e/a
    //   558	577	697	finally
    //   577	584	590	com/ss/android/socialbase/downloader/e/a
    //   577	584	697	finally
    //   597	617	701	com/ss/android/socialbase/downloader/e/a
    //   597	617	697	finally
    //   624	627	627	finally
    //   629	642	701	com/ss/android/socialbase/downloader/e/a
    //   629	642	697	finally
    //   647	657	687	finally
    //   671	684	687	finally
    //   689	694	701	com/ss/android/socialbase/downloader/e/a
    //   689	694	697	finally
    //   694	697	701	com/ss/android/socialbase/downloader/e/a
    //   694	697	697	finally
    //   707	713	1080	finally
    //   724	730	733	com/ss/android/socialbase/downloader/e/a
    //   724	730	1080	finally
    //   734	744	1080	finally
    //   754	761	1080	finally
    //   764	784	1080	finally
    //   790	824	1080	finally
    //   837	868	1080	finally
    //   876	888	1080	finally
    //   891	909	1080	finally
    //   912	923	1080	finally
    //   929	952	1080	finally
    //   955	969	1080	finally
    //   969	974	1080	finally
    //   987	996	1080	finally
    //   1003	1057	1080	finally
    //   1063	1074	1080	finally
  }
  
  private String c() {
    return this.f.I();
  }
  
  private void d() {
    e e1 = this.h;
    if (e1 != null) {
      e1.d();
      this.h = null;
    } 
  }
  
  private boolean e() {
    return (this.j || this.k);
  }
  
  public void a() {
    this.j = true;
    d d1 = this.d;
    if (d1 != null)
      d1.b(); 
  }
  
  public void a(long paramLong1, long paramLong2) {
    d d1 = this.d;
    if (d1 == null)
      return; 
    d1.a(paramLong1, paramLong2);
  }
  
  public void b() {
    this.k = true;
    d d1 = this.d;
    if (d1 != null)
      d1.c(); 
  }
  
  public void run() {
    Process.setThreadPriority(10);
    this.b = this.c;
    try {
      while (true) {
        this.b.a(this);
        if (!a(this.b)) {
          this.b.a(false);
          break;
        } 
        this.b.a(false);
        if (e())
          break; 
        this.b = this.g.a(this.b.s());
        if (!e()) {
          com.ss.android.socialbase.downloader.g.b b2 = this.b;
          if (b2 == null)
            break; 
          try {
            Thread.sleep(50L);
          } finally {
            b2 = null;
          } 
        } 
        break;
      } 
      return;
    } finally {
      com.ss.android.socialbase.downloader.g.b b1 = this.b;
      if (b1 != null)
        b1.a(false); 
      d();
      this.g.a(this);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */