package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.GradientStroke;
import java.io.IOException;

class GradientStrokeParser {
  static GradientStroke a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #19
    //   9: aconst_null
    //   10: astore #14
    //   12: aconst_null
    //   13: astore #13
    //   15: aconst_null
    //   16: astore #11
    //   18: aconst_null
    //   19: astore #12
    //   21: aconst_null
    //   22: astore #10
    //   24: aconst_null
    //   25: astore #9
    //   27: aconst_null
    //   28: astore #7
    //   30: aconst_null
    //   31: astore #6
    //   33: aconst_null
    //   34: astore #15
    //   36: fconst_0
    //   37: fstore_2
    //   38: aconst_null
    //   39: astore #8
    //   41: iconst_0
    //   42: istore #5
    //   44: aload_0
    //   45: invokevirtual hasNext : ()Z
    //   48: ifeq -> 918
    //   51: aload_0
    //   52: invokevirtual nextName : ()Ljava/lang/String;
    //   55: astore #16
    //   57: aload #16
    //   59: invokevirtual hashCode : ()I
    //   62: istore_3
    //   63: iload_3
    //   64: bipush #100
    //   66: if_icmpeq -> 313
    //   69: iload_3
    //   70: bipush #101
    //   72: if_icmpeq -> 298
    //   75: iload_3
    //   76: bipush #103
    //   78: if_icmpeq -> 283
    //   81: iload_3
    //   82: bipush #111
    //   84: if_icmpeq -> 268
    //   87: iload_3
    //   88: bipush #119
    //   90: if_icmpeq -> 252
    //   93: iload_3
    //   94: sipush #3324
    //   97: if_icmpeq -> 236
    //   100: iload_3
    //   101: sipush #3447
    //   104: if_icmpeq -> 220
    //   107: iload_3
    //   108: sipush #3454
    //   111: if_icmpeq -> 204
    //   114: iload_3
    //   115: sipush #3487
    //   118: if_icmpeq -> 188
    //   121: iload_3
    //   122: sipush #3519
    //   125: if_icmpeq -> 173
    //   128: iload_3
    //   129: bipush #115
    //   131: if_icmpeq -> 158
    //   134: iload_3
    //   135: bipush #116
    //   137: if_icmpeq -> 143
    //   140: goto -> 329
    //   143: aload #16
    //   145: ldc 't'
    //   147: invokevirtual equals : (Ljava/lang/Object;)Z
    //   150: ifeq -> 329
    //   153: iconst_3
    //   154: istore_3
    //   155: goto -> 331
    //   158: aload #16
    //   160: ldc 's'
    //   162: invokevirtual equals : (Ljava/lang/Object;)Z
    //   165: ifeq -> 329
    //   168: iconst_4
    //   169: istore_3
    //   170: goto -> 331
    //   173: aload #16
    //   175: ldc 'nm'
    //   177: invokevirtual equals : (Ljava/lang/Object;)Z
    //   180: ifeq -> 329
    //   183: iconst_0
    //   184: istore_3
    //   185: goto -> 331
    //   188: aload #16
    //   190: ldc 'ml'
    //   192: invokevirtual equals : (Ljava/lang/Object;)Z
    //   195: ifeq -> 329
    //   198: bipush #9
    //   200: istore_3
    //   201: goto -> 331
    //   204: aload #16
    //   206: ldc 'lj'
    //   208: invokevirtual equals : (Ljava/lang/Object;)Z
    //   211: ifeq -> 329
    //   214: bipush #8
    //   216: istore_3
    //   217: goto -> 331
    //   220: aload #16
    //   222: ldc 'lc'
    //   224: invokevirtual equals : (Ljava/lang/Object;)Z
    //   227: ifeq -> 329
    //   230: bipush #7
    //   232: istore_3
    //   233: goto -> 331
    //   236: aload #16
    //   238: ldc 'hd'
    //   240: invokevirtual equals : (Ljava/lang/Object;)Z
    //   243: ifeq -> 329
    //   246: bipush #10
    //   248: istore_3
    //   249: goto -> 331
    //   252: aload #16
    //   254: ldc 'w'
    //   256: invokevirtual equals : (Ljava/lang/Object;)Z
    //   259: ifeq -> 329
    //   262: bipush #6
    //   264: istore_3
    //   265: goto -> 331
    //   268: aload #16
    //   270: ldc 'o'
    //   272: invokevirtual equals : (Ljava/lang/Object;)Z
    //   275: ifeq -> 329
    //   278: iconst_2
    //   279: istore_3
    //   280: goto -> 331
    //   283: aload #16
    //   285: ldc 'g'
    //   287: invokevirtual equals : (Ljava/lang/Object;)Z
    //   290: ifeq -> 329
    //   293: iconst_1
    //   294: istore_3
    //   295: goto -> 331
    //   298: aload #16
    //   300: ldc 'e'
    //   302: invokevirtual equals : (Ljava/lang/Object;)Z
    //   305: ifeq -> 329
    //   308: iconst_5
    //   309: istore_3
    //   310: goto -> 331
    //   313: aload #16
    //   315: ldc 'd'
    //   317: invokevirtual equals : (Ljava/lang/Object;)Z
    //   320: ifeq -> 329
    //   323: bipush #11
    //   325: istore_3
    //   326: goto -> 331
    //   329: iconst_m1
    //   330: istore_3
    //   331: iload_3
    //   332: tableswitch default -> 396, 0 -> 898, 1 -> 781, 2 -> 771, 3 -> 731, 4 -> 721, 5 -> 711, 6 -> 693, 7 -> 678, 8 -> 655, 9 -> 646, 10 -> 637, 11 -> 411
    //   396: aload_0
    //   397: invokevirtual skipValue : ()V
    //   400: aload #6
    //   402: astore #16
    //   404: aload #7
    //   406: astore #6
    //   408: goto -> 907
    //   411: aload_0
    //   412: invokevirtual beginArray : ()V
    //   415: aload_0
    //   416: invokevirtual hasNext : ()Z
    //   419: ifeq -> 600
    //   422: aload_0
    //   423: invokevirtual beginObject : ()V
    //   426: aconst_null
    //   427: astore #18
    //   429: aconst_null
    //   430: astore #16
    //   432: aload_0
    //   433: invokevirtual hasNext : ()Z
    //   436: ifeq -> 533
    //   439: aload_0
    //   440: invokevirtual nextName : ()Ljava/lang/String;
    //   443: astore #17
    //   445: aload #17
    //   447: invokevirtual hashCode : ()I
    //   450: istore_3
    //   451: iload_3
    //   452: bipush #110
    //   454: if_icmpeq -> 481
    //   457: iload_3
    //   458: bipush #118
    //   460: if_icmpeq -> 466
    //   463: goto -> 496
    //   466: aload #17
    //   468: ldc 'v'
    //   470: invokevirtual equals : (Ljava/lang/Object;)Z
    //   473: ifeq -> 496
    //   476: iconst_1
    //   477: istore_3
    //   478: goto -> 498
    //   481: aload #17
    //   483: ldc 'n'
    //   485: invokevirtual equals : (Ljava/lang/Object;)Z
    //   488: ifeq -> 496
    //   491: iconst_0
    //   492: istore_3
    //   493: goto -> 498
    //   496: iconst_m1
    //   497: istore_3
    //   498: iload_3
    //   499: ifeq -> 524
    //   502: iload_3
    //   503: iconst_1
    //   504: if_icmpeq -> 514
    //   507: aload_0
    //   508: invokevirtual skipValue : ()V
    //   511: goto -> 530
    //   514: aload_0
    //   515: aload_1
    //   516: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   519: astore #16
    //   521: goto -> 530
    //   524: aload_0
    //   525: invokevirtual nextString : ()Ljava/lang/String;
    //   528: astore #18
    //   530: goto -> 432
    //   533: aload_0
    //   534: invokevirtual endObject : ()V
    //   537: aload #18
    //   539: ldc 'o'
    //   541: invokevirtual equals : (Ljava/lang/Object;)Z
    //   544: ifeq -> 558
    //   547: aload #16
    //   549: astore #17
    //   551: aload #17
    //   553: astore #8
    //   555: goto -> 597
    //   558: aload #18
    //   560: ldc 'd'
    //   562: invokevirtual equals : (Ljava/lang/Object;)Z
    //   565: ifne -> 582
    //   568: aload #8
    //   570: astore #17
    //   572: aload #18
    //   574: ldc 'g'
    //   576: invokevirtual equals : (Ljava/lang/Object;)Z
    //   579: ifeq -> 551
    //   582: aload_1
    //   583: iconst_1
    //   584: invokevirtual a : (Z)V
    //   587: aload #19
    //   589: aload #16
    //   591: invokeinterface add : (Ljava/lang/Object;)Z
    //   596: pop
    //   597: goto -> 415
    //   600: aload_0
    //   601: invokevirtual endArray : ()V
    //   604: aload #19
    //   606: invokeinterface size : ()I
    //   611: iconst_1
    //   612: if_icmpne -> 634
    //   615: aload #19
    //   617: aload #19
    //   619: iconst_0
    //   620: invokeinterface get : (I)Ljava/lang/Object;
    //   625: invokeinterface add : (Ljava/lang/Object;)Z
    //   630: pop
    //   631: goto -> 768
    //   634: goto -> 768
    //   637: aload_0
    //   638: invokevirtual nextBoolean : ()Z
    //   641: istore #5
    //   643: goto -> 400
    //   646: aload_0
    //   647: invokevirtual nextDouble : ()D
    //   650: d2f
    //   651: fstore_2
    //   652: goto -> 400
    //   655: invokestatic values : ()[Lcom/airbnb/lottie/model/content/ShapeStroke$LineJoinType;
    //   658: aload_0
    //   659: invokevirtual nextInt : ()I
    //   662: iconst_1
    //   663: isub
    //   664: aaload
    //   665: astore #15
    //   667: aload #6
    //   669: astore #16
    //   671: aload #7
    //   673: astore #6
    //   675: goto -> 907
    //   678: invokestatic values : ()[Lcom/airbnb/lottie/model/content/ShapeStroke$LineCapType;
    //   681: aload_0
    //   682: invokevirtual nextInt : ()I
    //   685: iconst_1
    //   686: isub
    //   687: aaload
    //   688: astore #6
    //   690: goto -> 778
    //   693: aload_0
    //   694: aload_1
    //   695: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   698: astore #7
    //   700: aload #6
    //   702: astore #16
    //   704: aload #7
    //   706: astore #6
    //   708: goto -> 907
    //   711: aload_0
    //   712: aload_1
    //   713: invokestatic c : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatablePointValue;
    //   716: astore #9
    //   718: goto -> 778
    //   721: aload_0
    //   722: aload_1
    //   723: invokestatic c : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatablePointValue;
    //   726: astore #10
    //   728: goto -> 778
    //   731: aload #6
    //   733: astore #13
    //   735: aload_0
    //   736: invokevirtual nextInt : ()I
    //   739: iconst_1
    //   740: if_icmpne -> 751
    //   743: getstatic com/airbnb/lottie/model/content/GradientType.a : Lcom/airbnb/lottie/model/content/GradientType;
    //   746: astore #6
    //   748: goto -> 756
    //   751: getstatic com/airbnb/lottie/model/content/GradientType.b : Lcom/airbnb/lottie/model/content/GradientType;
    //   754: astore #6
    //   756: aload #6
    //   758: astore #16
    //   760: aload #13
    //   762: astore #6
    //   764: aload #16
    //   766: astore #13
    //   768: goto -> 895
    //   771: aload_0
    //   772: aload_1
    //   773: invokestatic b : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;
    //   776: astore #12
    //   778: goto -> 400
    //   781: aload_0
    //   782: invokevirtual beginObject : ()V
    //   785: iconst_m1
    //   786: istore #4
    //   788: aload_0
    //   789: invokevirtual hasNext : ()Z
    //   792: ifeq -> 891
    //   795: aload_0
    //   796: invokevirtual nextName : ()Ljava/lang/String;
    //   799: astore #16
    //   801: aload #16
    //   803: invokevirtual hashCode : ()I
    //   806: istore_3
    //   807: iload_3
    //   808: bipush #107
    //   810: if_icmpeq -> 837
    //   813: iload_3
    //   814: bipush #112
    //   816: if_icmpeq -> 822
    //   819: goto -> 852
    //   822: aload #16
    //   824: ldc 'p'
    //   826: invokevirtual equals : (Ljava/lang/Object;)Z
    //   829: ifeq -> 852
    //   832: iconst_0
    //   833: istore_3
    //   834: goto -> 854
    //   837: aload #16
    //   839: ldc 'k'
    //   841: invokevirtual equals : (Ljava/lang/Object;)Z
    //   844: ifeq -> 852
    //   847: iconst_1
    //   848: istore_3
    //   849: goto -> 854
    //   852: iconst_m1
    //   853: istore_3
    //   854: iload_3
    //   855: ifeq -> 882
    //   858: iload_3
    //   859: iconst_1
    //   860: if_icmpeq -> 870
    //   863: aload_0
    //   864: invokevirtual skipValue : ()V
    //   867: goto -> 788
    //   870: aload_0
    //   871: aload_1
    //   872: iload #4
    //   874: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;I)Lcom/airbnb/lottie/model/animatable/AnimatableGradientColorValue;
    //   877: astore #11
    //   879: goto -> 788
    //   882: aload_0
    //   883: invokevirtual nextInt : ()I
    //   886: istore #4
    //   888: goto -> 788
    //   891: aload_0
    //   892: invokevirtual endObject : ()V
    //   895: goto -> 400
    //   898: aload_0
    //   899: invokevirtual nextString : ()Ljava/lang/String;
    //   902: astore #14
    //   904: goto -> 400
    //   907: aload #6
    //   909: astore #7
    //   911: aload #16
    //   913: astore #6
    //   915: goto -> 44
    //   918: new com/airbnb/lottie/model/content/GradientStroke
    //   921: dup
    //   922: aload #14
    //   924: aload #13
    //   926: aload #11
    //   928: aload #12
    //   930: aload #10
    //   932: aload #9
    //   934: aload #7
    //   936: aload #6
    //   938: aload #15
    //   940: fload_2
    //   941: aload #19
    //   943: aload #8
    //   945: iload #5
    //   947: invokespecial <init> : (Ljava/lang/String;Lcom/airbnb/lottie/model/content/GradientType;Lcom/airbnb/lottie/model/animatable/AnimatableGradientColorValue;Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;Lcom/airbnb/lottie/model/animatable/AnimatablePointValue;Lcom/airbnb/lottie/model/animatable/AnimatablePointValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/content/ShapeStroke$LineCapType;Lcom/airbnb/lottie/model/content/ShapeStroke$LineJoinType;FLjava/util/List;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Z)V
    //   950: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\GradientStrokeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */