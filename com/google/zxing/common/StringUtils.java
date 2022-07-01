package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils {
  static {
    if ("SJIS".equalsIgnoreCase(a) || "EUC_JP".equalsIgnoreCase(a)) {
      bool = true;
    } else {
      bool = false;
    } 
    b = bool;
  }
  
  public static String a(byte[] paramArrayOfbyte, Map<DecodeHintType, ?> paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: astore #29
    //   3: aload_1
    //   4: ifnull -> 32
    //   7: aload_1
    //   8: getstatic com/google/zxing/DecodeHintType.e : Lcom/google/zxing/DecodeHintType;
    //   11: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   16: ifeq -> 32
    //   19: aload_1
    //   20: getstatic com/google/zxing/DecodeHintType.e : Lcom/google/zxing/DecodeHintType;
    //   23: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual toString : ()Ljava/lang/String;
    //   31: areturn
    //   32: aload #29
    //   34: arraylength
    //   35: istore #27
    //   37: aload #29
    //   39: arraylength
    //   40: istore_2
    //   41: iconst_0
    //   42: istore #6
    //   44: iload_2
    //   45: iconst_3
    //   46: if_icmple -> 82
    //   49: aload #29
    //   51: iconst_0
    //   52: baload
    //   53: bipush #-17
    //   55: if_icmpne -> 82
    //   58: aload #29
    //   60: iconst_1
    //   61: baload
    //   62: bipush #-69
    //   64: if_icmpne -> 82
    //   67: aload #29
    //   69: iconst_2
    //   70: baload
    //   71: bipush #-65
    //   73: if_icmpne -> 82
    //   76: iconst_1
    //   77: istore #12
    //   79: goto -> 85
    //   82: iconst_0
    //   83: istore #12
    //   85: iconst_0
    //   86: istore #14
    //   88: iconst_0
    //   89: istore #13
    //   91: iconst_1
    //   92: istore #24
    //   94: iconst_1
    //   95: istore #5
    //   97: iconst_1
    //   98: istore_3
    //   99: iconst_0
    //   100: istore #8
    //   102: iconst_0
    //   103: istore #7
    //   105: iconst_0
    //   106: istore #25
    //   108: iconst_0
    //   109: istore #23
    //   111: iconst_0
    //   112: istore #22
    //   114: iconst_0
    //   115: istore #4
    //   117: iconst_0
    //   118: istore #10
    //   120: iconst_0
    //   121: istore #17
    //   123: iconst_0
    //   124: istore #15
    //   126: iload #13
    //   128: iload #27
    //   130: if_icmpge -> 816
    //   133: iload #24
    //   135: ifne -> 147
    //   138: iload #5
    //   140: ifne -> 147
    //   143: iload_3
    //   144: ifeq -> 816
    //   147: aload_0
    //   148: iload #13
    //   150: baload
    //   151: sipush #255
    //   154: iand
    //   155: istore #28
    //   157: iload_3
    //   158: istore #16
    //   160: iload #8
    //   162: istore_2
    //   163: iload #25
    //   165: istore #18
    //   167: iload #23
    //   169: istore #19
    //   171: iload #22
    //   173: istore #20
    //   175: iload_3
    //   176: ifeq -> 376
    //   179: iload #8
    //   181: ifle -> 219
    //   184: iload #8
    //   186: istore_2
    //   187: iload #28
    //   189: sipush #128
    //   192: iand
    //   193: ifeq -> 361
    //   196: iload #8
    //   198: iconst_1
    //   199: isub
    //   200: istore_2
    //   201: iload_3
    //   202: istore #16
    //   204: iload #25
    //   206: istore #18
    //   208: iload #23
    //   210: istore #19
    //   212: iload #22
    //   214: istore #20
    //   216: goto -> 376
    //   219: iload_3
    //   220: istore #16
    //   222: iload #8
    //   224: istore_2
    //   225: iload #25
    //   227: istore #18
    //   229: iload #23
    //   231: istore #19
    //   233: iload #22
    //   235: istore #20
    //   237: iload #28
    //   239: sipush #128
    //   242: iand
    //   243: ifeq -> 376
    //   246: iload #8
    //   248: istore_2
    //   249: iload #28
    //   251: bipush #64
    //   253: iand
    //   254: ifeq -> 361
    //   257: iload #8
    //   259: iconst_1
    //   260: iadd
    //   261: istore_2
    //   262: iload #28
    //   264: bipush #32
    //   266: iand
    //   267: ifne -> 290
    //   270: iload #25
    //   272: iconst_1
    //   273: iadd
    //   274: istore #18
    //   276: iload_3
    //   277: istore #16
    //   279: iload #23
    //   281: istore #19
    //   283: iload #22
    //   285: istore #20
    //   287: goto -> 376
    //   290: iload_2
    //   291: iconst_1
    //   292: iadd
    //   293: istore_2
    //   294: iload #28
    //   296: bipush #16
    //   298: iand
    //   299: ifne -> 322
    //   302: iload #23
    //   304: iconst_1
    //   305: iadd
    //   306: istore #19
    //   308: iload_3
    //   309: istore #16
    //   311: iload #25
    //   313: istore #18
    //   315: iload #22
    //   317: istore #20
    //   319: goto -> 376
    //   322: iload_2
    //   323: iconst_1
    //   324: iadd
    //   325: istore #8
    //   327: iload #8
    //   329: istore_2
    //   330: iload #28
    //   332: bipush #8
    //   334: iand
    //   335: ifne -> 361
    //   338: iload #22
    //   340: iconst_1
    //   341: iadd
    //   342: istore #20
    //   344: iload_3
    //   345: istore #16
    //   347: iload #8
    //   349: istore_2
    //   350: iload #25
    //   352: istore #18
    //   354: iload #23
    //   356: istore #19
    //   358: goto -> 376
    //   361: iconst_0
    //   362: istore #16
    //   364: iload #22
    //   366: istore #20
    //   368: iload #23
    //   370: istore #19
    //   372: iload #25
    //   374: istore #18
    //   376: iload #24
    //   378: istore #8
    //   380: iload #10
    //   382: istore #21
    //   384: iload #24
    //   386: ifeq -> 472
    //   389: iload #28
    //   391: bipush #127
    //   393: if_icmple -> 414
    //   396: iload #28
    //   398: sipush #160
    //   401: if_icmpge -> 414
    //   404: iconst_0
    //   405: istore #8
    //   407: iload #10
    //   409: istore #21
    //   411: goto -> 472
    //   414: iload #24
    //   416: istore #8
    //   418: iload #10
    //   420: istore #21
    //   422: iload #28
    //   424: sipush #159
    //   427: if_icmple -> 472
    //   430: iload #28
    //   432: sipush #192
    //   435: if_icmplt -> 462
    //   438: iload #28
    //   440: sipush #215
    //   443: if_icmpeq -> 462
    //   446: iload #24
    //   448: istore #8
    //   450: iload #10
    //   452: istore #21
    //   454: iload #28
    //   456: sipush #247
    //   459: if_icmpne -> 472
    //   462: iload #10
    //   464: iconst_1
    //   465: iadd
    //   466: istore #21
    //   468: iload #24
    //   470: istore #8
    //   472: iload #14
    //   474: istore #22
    //   476: iload #6
    //   478: istore #24
    //   480: iload #5
    //   482: istore #23
    //   484: iload #7
    //   486: istore #10
    //   488: iload #4
    //   490: istore #26
    //   492: iload #17
    //   494: istore #9
    //   496: iload #15
    //   498: istore #11
    //   500: iload #5
    //   502: ifeq -> 753
    //   505: iload #7
    //   507: ifle -> 568
    //   510: iload #28
    //   512: bipush #64
    //   514: if_icmplt -> 726
    //   517: iload #28
    //   519: bipush #127
    //   521: if_icmpeq -> 726
    //   524: iload #28
    //   526: sipush #252
    //   529: if_icmple -> 535
    //   532: goto -> 726
    //   535: iload #7
    //   537: iconst_1
    //   538: isub
    //   539: istore #10
    //   541: iload #14
    //   543: istore #22
    //   545: iload #6
    //   547: istore #24
    //   549: iload #5
    //   551: istore #23
    //   553: iload #4
    //   555: istore #26
    //   557: iload #17
    //   559: istore #9
    //   561: iload #15
    //   563: istore #11
    //   565: goto -> 753
    //   568: iload #28
    //   570: sipush #128
    //   573: if_icmpeq -> 726
    //   576: iload #28
    //   578: sipush #160
    //   581: if_icmpeq -> 726
    //   584: iload #28
    //   586: sipush #239
    //   589: if_icmple -> 595
    //   592: goto -> 726
    //   595: iload #28
    //   597: sipush #160
    //   600: if_icmple -> 659
    //   603: iload #28
    //   605: sipush #224
    //   608: if_icmpge -> 659
    //   611: iload #14
    //   613: iconst_1
    //   614: iadd
    //   615: istore #22
    //   617: iload #15
    //   619: iconst_1
    //   620: iadd
    //   621: istore #11
    //   623: iload #11
    //   625: iload #4
    //   627: if_icmple -> 637
    //   630: iload #11
    //   632: istore #4
    //   634: goto -> 637
    //   637: iconst_0
    //   638: istore #9
    //   640: iload #6
    //   642: istore #24
    //   644: iload #5
    //   646: istore #23
    //   648: iload #7
    //   650: istore #10
    //   652: iload #4
    //   654: istore #26
    //   656: goto -> 753
    //   659: iload #28
    //   661: bipush #127
    //   663: if_icmple -> 695
    //   666: iload #7
    //   668: iconst_1
    //   669: iadd
    //   670: istore #7
    //   672: iload #17
    //   674: iconst_1
    //   675: iadd
    //   676: istore_3
    //   677: iload_3
    //   678: iload #6
    //   680: if_icmple -> 692
    //   683: iload_3
    //   684: istore #6
    //   686: iload #6
    //   688: istore_3
    //   689: goto -> 697
    //   692: goto -> 697
    //   695: iconst_0
    //   696: istore_3
    //   697: iconst_0
    //   698: istore #11
    //   700: iload #14
    //   702: istore #22
    //   704: iload #6
    //   706: istore #24
    //   708: iload #5
    //   710: istore #23
    //   712: iload #7
    //   714: istore #10
    //   716: iload #4
    //   718: istore #26
    //   720: iload_3
    //   721: istore #9
    //   723: goto -> 753
    //   726: iconst_0
    //   727: istore #23
    //   729: iload #15
    //   731: istore #11
    //   733: iload #17
    //   735: istore #9
    //   737: iload #4
    //   739: istore #26
    //   741: iload #7
    //   743: istore #10
    //   745: iload #6
    //   747: istore #24
    //   749: iload #14
    //   751: istore #22
    //   753: iload #13
    //   755: iconst_1
    //   756: iadd
    //   757: istore #13
    //   759: iload #22
    //   761: istore #14
    //   763: iload #24
    //   765: istore #6
    //   767: iload #8
    //   769: istore #24
    //   771: iload #23
    //   773: istore #5
    //   775: iload #16
    //   777: istore_3
    //   778: iload_2
    //   779: istore #8
    //   781: iload #10
    //   783: istore #7
    //   785: iload #18
    //   787: istore #25
    //   789: iload #19
    //   791: istore #23
    //   793: iload #20
    //   795: istore #22
    //   797: iload #26
    //   799: istore #4
    //   801: iload #21
    //   803: istore #10
    //   805: iload #9
    //   807: istore #17
    //   809: iload #11
    //   811: istore #15
    //   813: goto -> 126
    //   816: iload_3
    //   817: istore_2
    //   818: iload_3
    //   819: ifeq -> 831
    //   822: iload_3
    //   823: istore_2
    //   824: iload #8
    //   826: ifle -> 831
    //   829: iconst_0
    //   830: istore_2
    //   831: iload #5
    //   833: istore_3
    //   834: iload #5
    //   836: ifeq -> 849
    //   839: iload #5
    //   841: istore_3
    //   842: iload #7
    //   844: ifle -> 849
    //   847: iconst_0
    //   848: istore_3
    //   849: iload_2
    //   850: ifeq -> 872
    //   853: iload #12
    //   855: ifne -> 869
    //   858: iload #25
    //   860: iload #23
    //   862: iadd
    //   863: iload #22
    //   865: iadd
    //   866: ifle -> 872
    //   869: ldc 'UTF8'
    //   871: areturn
    //   872: iload_3
    //   873: ifeq -> 897
    //   876: getstatic com/google/zxing/common/StringUtils.b : Z
    //   879: ifne -> 894
    //   882: iload #4
    //   884: iconst_3
    //   885: if_icmpge -> 894
    //   888: iload #6
    //   890: iconst_3
    //   891: if_icmplt -> 897
    //   894: ldc 'SJIS'
    //   896: areturn
    //   897: iload #24
    //   899: ifeq -> 934
    //   902: iload_3
    //   903: ifeq -> 934
    //   906: iload #4
    //   908: iconst_2
    //   909: if_icmpne -> 918
    //   912: iload #14
    //   914: iconst_2
    //   915: if_icmpeq -> 928
    //   918: iload #10
    //   920: bipush #10
    //   922: imul
    //   923: iload #27
    //   925: if_icmplt -> 931
    //   928: ldc 'SJIS'
    //   930: areturn
    //   931: ldc 'ISO8859_1'
    //   933: areturn
    //   934: iload #24
    //   936: ifeq -> 942
    //   939: ldc 'ISO8859_1'
    //   941: areturn
    //   942: iload_3
    //   943: ifeq -> 949
    //   946: ldc 'SJIS'
    //   948: areturn
    //   949: iload_2
    //   950: ifeq -> 956
    //   953: ldc 'UTF8'
    //   955: areturn
    //   956: getstatic com/google/zxing/common/StringUtils.a : Ljava/lang/String;
    //   959: areturn
  }
  
  static {
    boolean bool;
  }
  
  private static final String a = Charset.defaultCharset().name();
  
  private static final boolean b;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */