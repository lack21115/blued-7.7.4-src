package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.io.IOException;

class ShapeStrokeParser {
  static ShapeStroke a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #14
    //   9: aconst_null
    //   10: astore #12
    //   12: aconst_null
    //   13: astore #5
    //   15: aconst_null
    //   16: astore #11
    //   18: aconst_null
    //   19: astore #10
    //   21: aconst_null
    //   22: astore #9
    //   24: aconst_null
    //   25: astore #8
    //   27: aconst_null
    //   28: astore #7
    //   30: fconst_0
    //   31: fstore_2
    //   32: iconst_0
    //   33: istore #4
    //   35: aload_0
    //   36: invokevirtual hasNext : ()Z
    //   39: ifeq -> 681
    //   42: aload_0
    //   43: invokevirtual nextName : ()Ljava/lang/String;
    //   46: astore #6
    //   48: aload #6
    //   50: invokevirtual hashCode : ()I
    //   53: istore_3
    //   54: iload_3
    //   55: bipush #99
    //   57: if_icmpeq -> 239
    //   60: iload_3
    //   61: bipush #100
    //   63: if_icmpeq -> 223
    //   66: iload_3
    //   67: bipush #111
    //   69: if_icmpeq -> 208
    //   72: iload_3
    //   73: bipush #119
    //   75: if_icmpeq -> 193
    //   78: iload_3
    //   79: sipush #3324
    //   82: if_icmpeq -> 177
    //   85: iload_3
    //   86: sipush #3447
    //   89: if_icmpeq -> 162
    //   92: iload_3
    //   93: sipush #3454
    //   96: if_icmpeq -> 147
    //   99: iload_3
    //   100: sipush #3487
    //   103: if_icmpeq -> 131
    //   106: iload_3
    //   107: sipush #3519
    //   110: if_icmpeq -> 116
    //   113: goto -> 254
    //   116: aload #6
    //   118: ldc 'nm'
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifeq -> 254
    //   126: iconst_0
    //   127: istore_3
    //   128: goto -> 256
    //   131: aload #6
    //   133: ldc 'ml'
    //   135: invokevirtual equals : (Ljava/lang/Object;)Z
    //   138: ifeq -> 254
    //   141: bipush #6
    //   143: istore_3
    //   144: goto -> 256
    //   147: aload #6
    //   149: ldc 'lj'
    //   151: invokevirtual equals : (Ljava/lang/Object;)Z
    //   154: ifeq -> 254
    //   157: iconst_5
    //   158: istore_3
    //   159: goto -> 256
    //   162: aload #6
    //   164: ldc 'lc'
    //   166: invokevirtual equals : (Ljava/lang/Object;)Z
    //   169: ifeq -> 254
    //   172: iconst_4
    //   173: istore_3
    //   174: goto -> 256
    //   177: aload #6
    //   179: ldc 'hd'
    //   181: invokevirtual equals : (Ljava/lang/Object;)Z
    //   184: ifeq -> 254
    //   187: bipush #7
    //   189: istore_3
    //   190: goto -> 256
    //   193: aload #6
    //   195: ldc 'w'
    //   197: invokevirtual equals : (Ljava/lang/Object;)Z
    //   200: ifeq -> 254
    //   203: iconst_2
    //   204: istore_3
    //   205: goto -> 256
    //   208: aload #6
    //   210: ldc 'o'
    //   212: invokevirtual equals : (Ljava/lang/Object;)Z
    //   215: ifeq -> 254
    //   218: iconst_3
    //   219: istore_3
    //   220: goto -> 256
    //   223: aload #6
    //   225: ldc 'd'
    //   227: invokevirtual equals : (Ljava/lang/Object;)Z
    //   230: ifeq -> 254
    //   233: bipush #8
    //   235: istore_3
    //   236: goto -> 256
    //   239: aload #6
    //   241: ldc 'c'
    //   243: invokevirtual equals : (Ljava/lang/Object;)Z
    //   246: ifeq -> 254
    //   249: iconst_1
    //   250: istore_3
    //   251: goto -> 256
    //   254: iconst_m1
    //   255: istore_3
    //   256: iload_3
    //   257: tableswitch default -> 308, 0 -> 672, 1 -> 662, 2 -> 652, 3 -> 642, 4 -> 627, 5 -> 612, 6 -> 603, 7 -> 594, 8 -> 315
    //   308: aload_0
    //   309: invokevirtual skipValue : ()V
    //   312: goto -> 35
    //   315: aload_0
    //   316: invokevirtual beginArray : ()V
    //   319: aload_0
    //   320: invokevirtual hasNext : ()Z
    //   323: ifeq -> 557
    //   326: aload_0
    //   327: invokevirtual beginObject : ()V
    //   330: aconst_null
    //   331: astore #13
    //   333: aconst_null
    //   334: astore #6
    //   336: aload_0
    //   337: invokevirtual hasNext : ()Z
    //   340: ifeq -> 437
    //   343: aload_0
    //   344: invokevirtual nextName : ()Ljava/lang/String;
    //   347: astore #15
    //   349: aload #15
    //   351: invokevirtual hashCode : ()I
    //   354: istore_3
    //   355: iload_3
    //   356: bipush #110
    //   358: if_icmpeq -> 385
    //   361: iload_3
    //   362: bipush #118
    //   364: if_icmpeq -> 370
    //   367: goto -> 400
    //   370: aload #15
    //   372: ldc 'v'
    //   374: invokevirtual equals : (Ljava/lang/Object;)Z
    //   377: ifeq -> 400
    //   380: iconst_1
    //   381: istore_3
    //   382: goto -> 402
    //   385: aload #15
    //   387: ldc 'n'
    //   389: invokevirtual equals : (Ljava/lang/Object;)Z
    //   392: ifeq -> 400
    //   395: iconst_0
    //   396: istore_3
    //   397: goto -> 402
    //   400: iconst_m1
    //   401: istore_3
    //   402: iload_3
    //   403: ifeq -> 428
    //   406: iload_3
    //   407: iconst_1
    //   408: if_icmpeq -> 418
    //   411: aload_0
    //   412: invokevirtual skipValue : ()V
    //   415: goto -> 434
    //   418: aload_0
    //   419: aload_1
    //   420: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   423: astore #6
    //   425: goto -> 434
    //   428: aload_0
    //   429: invokevirtual nextString : ()Ljava/lang/String;
    //   432: astore #13
    //   434: goto -> 336
    //   437: aload_0
    //   438: invokevirtual endObject : ()V
    //   441: aload #13
    //   443: invokevirtual hashCode : ()I
    //   446: istore_3
    //   447: iload_3
    //   448: bipush #100
    //   450: if_icmpeq -> 498
    //   453: iload_3
    //   454: bipush #103
    //   456: if_icmpeq -> 483
    //   459: iload_3
    //   460: bipush #111
    //   462: if_icmpeq -> 468
    //   465: goto -> 513
    //   468: aload #13
    //   470: ldc 'o'
    //   472: invokevirtual equals : (Ljava/lang/Object;)Z
    //   475: ifeq -> 513
    //   478: iconst_0
    //   479: istore_3
    //   480: goto -> 515
    //   483: aload #13
    //   485: ldc 'g'
    //   487: invokevirtual equals : (Ljava/lang/Object;)Z
    //   490: ifeq -> 513
    //   493: iconst_2
    //   494: istore_3
    //   495: goto -> 515
    //   498: aload #13
    //   500: ldc 'd'
    //   502: invokevirtual equals : (Ljava/lang/Object;)Z
    //   505: ifeq -> 513
    //   508: iconst_1
    //   509: istore_3
    //   510: goto -> 515
    //   513: iconst_m1
    //   514: istore_3
    //   515: iload_3
    //   516: ifeq -> 550
    //   519: iload_3
    //   520: iconst_1
    //   521: if_icmpeq -> 532
    //   524: iload_3
    //   525: iconst_2
    //   526: if_icmpeq -> 532
    //   529: goto -> 554
    //   532: aload_1
    //   533: iconst_1
    //   534: invokevirtual a : (Z)V
    //   537: aload #14
    //   539: aload #6
    //   541: invokeinterface add : (Ljava/lang/Object;)Z
    //   546: pop
    //   547: goto -> 554
    //   550: aload #6
    //   552: astore #5
    //   554: goto -> 319
    //   557: aload_0
    //   558: invokevirtual endArray : ()V
    //   561: aload #14
    //   563: invokeinterface size : ()I
    //   568: iconst_1
    //   569: if_icmpne -> 591
    //   572: aload #14
    //   574: aload #14
    //   576: iconst_0
    //   577: invokeinterface get : (I)Ljava/lang/Object;
    //   582: invokeinterface add : (Ljava/lang/Object;)Z
    //   587: pop
    //   588: goto -> 591
    //   591: goto -> 35
    //   594: aload_0
    //   595: invokevirtual nextBoolean : ()Z
    //   598: istore #4
    //   600: goto -> 35
    //   603: aload_0
    //   604: invokevirtual nextDouble : ()D
    //   607: d2f
    //   608: fstore_2
    //   609: goto -> 35
    //   612: invokestatic values : ()[Lcom/airbnb/lottie/model/content/ShapeStroke$LineJoinType;
    //   615: aload_0
    //   616: invokevirtual nextInt : ()I
    //   619: iconst_1
    //   620: isub
    //   621: aaload
    //   622: astore #7
    //   624: goto -> 35
    //   627: invokestatic values : ()[Lcom/airbnb/lottie/model/content/ShapeStroke$LineCapType;
    //   630: aload_0
    //   631: invokevirtual nextInt : ()I
    //   634: iconst_1
    //   635: isub
    //   636: aaload
    //   637: astore #8
    //   639: goto -> 35
    //   642: aload_0
    //   643: aload_1
    //   644: invokestatic b : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;
    //   647: astore #10
    //   649: goto -> 35
    //   652: aload_0
    //   653: aload_1
    //   654: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   657: astore #9
    //   659: goto -> 35
    //   662: aload_0
    //   663: aload_1
    //   664: invokestatic g : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableColorValue;
    //   667: astore #11
    //   669: goto -> 35
    //   672: aload_0
    //   673: invokevirtual nextString : ()Ljava/lang/String;
    //   676: astore #12
    //   678: goto -> 35
    //   681: new com/airbnb/lottie/model/content/ShapeStroke
    //   684: dup
    //   685: aload #12
    //   687: aload #5
    //   689: aload #14
    //   691: aload #11
    //   693: aload #10
    //   695: aload #9
    //   697: aload #8
    //   699: aload #7
    //   701: fload_2
    //   702: iload #4
    //   704: invokespecial <init> : (Ljava/lang/String;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Ljava/util/List;Lcom/airbnb/lottie/model/animatable/AnimatableColorValue;Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/content/ShapeStroke$LineCapType;Lcom/airbnb/lottie/model/content/ShapeStroke$LineJoinType;FZ)V
    //   707: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ShapeStrokeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */