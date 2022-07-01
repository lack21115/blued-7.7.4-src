package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import java.io.IOException;

class ContentModelParser {
  static ContentModel a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual beginObject : ()V
    //   4: iconst_2
    //   5: istore #4
    //   7: iconst_2
    //   8: istore_3
    //   9: aload_0
    //   10: invokevirtual hasNext : ()Z
    //   13: istore #5
    //   15: aconst_null
    //   16: astore #7
    //   18: iload #5
    //   20: ifeq -> 116
    //   23: aload_0
    //   24: invokevirtual nextName : ()Ljava/lang/String;
    //   27: astore #6
    //   29: aload #6
    //   31: invokevirtual hashCode : ()I
    //   34: istore_2
    //   35: iload_2
    //   36: bipush #100
    //   38: if_icmpeq -> 66
    //   41: iload_2
    //   42: sipush #3717
    //   45: if_icmpeq -> 51
    //   48: goto -> 81
    //   51: aload #6
    //   53: ldc 'ty'
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 81
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -> 83
    //   66: aload #6
    //   68: ldc 'd'
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 81
    //   76: iconst_1
    //   77: istore_2
    //   78: goto -> 83
    //   81: iconst_m1
    //   82: istore_2
    //   83: iload_2
    //   84: ifeq -> 107
    //   87: iload_2
    //   88: iconst_1
    //   89: if_icmpeq -> 99
    //   92: aload_0
    //   93: invokevirtual skipValue : ()V
    //   96: goto -> 9
    //   99: aload_0
    //   100: invokevirtual nextInt : ()I
    //   103: istore_3
    //   104: goto -> 9
    //   107: aload_0
    //   108: invokevirtual nextString : ()Ljava/lang/String;
    //   111: astore #6
    //   113: goto -> 119
    //   116: aconst_null
    //   117: astore #6
    //   119: aload #6
    //   121: ifnonnull -> 126
    //   124: aconst_null
    //   125: areturn
    //   126: aload #6
    //   128: invokevirtual hashCode : ()I
    //   131: lookupswitch default -> 244, 3239 -> 434, 3270 -> 419, 3295 -> 404, 3307 -> 389, 3308 -> 373, 3488 -> 357, 3633 -> 341, 3646 -> 325, 3669 -> 309, 3679 -> 293, 3681 -> 278, 3705 -> 262, 3710 -> 247
    //   244: goto -> 450
    //   247: aload #6
    //   249: ldc 'tr'
    //   251: invokevirtual equals : (Ljava/lang/Object;)Z
    //   254: ifeq -> 450
    //   257: iconst_5
    //   258: istore_2
    //   259: goto -> 452
    //   262: aload #6
    //   264: ldc 'tm'
    //   266: invokevirtual equals : (Ljava/lang/Object;)Z
    //   269: ifeq -> 450
    //   272: bipush #9
    //   274: istore_2
    //   275: goto -> 452
    //   278: aload #6
    //   280: ldc 'st'
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 450
    //   288: iconst_1
    //   289: istore_2
    //   290: goto -> 452
    //   293: aload #6
    //   295: ldc 'sr'
    //   297: invokevirtual equals : (Ljava/lang/Object;)Z
    //   300: ifeq -> 450
    //   303: bipush #10
    //   305: istore_2
    //   306: goto -> 452
    //   309: aload #6
    //   311: ldc 'sh'
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifeq -> 450
    //   319: bipush #6
    //   321: istore_2
    //   322: goto -> 452
    //   325: aload #6
    //   327: ldc 'rp'
    //   329: invokevirtual equals : (Ljava/lang/Object;)Z
    //   332: ifeq -> 450
    //   335: bipush #12
    //   337: istore_2
    //   338: goto -> 452
    //   341: aload #6
    //   343: ldc 'rc'
    //   345: invokevirtual equals : (Ljava/lang/Object;)Z
    //   348: ifeq -> 450
    //   351: bipush #8
    //   353: istore_2
    //   354: goto -> 452
    //   357: aload #6
    //   359: ldc 'mm'
    //   361: invokevirtual equals : (Ljava/lang/Object;)Z
    //   364: ifeq -> 450
    //   367: bipush #11
    //   369: istore_2
    //   370: goto -> 452
    //   373: aload #6
    //   375: ldc 'gs'
    //   377: invokevirtual equals : (Ljava/lang/Object;)Z
    //   380: ifeq -> 450
    //   383: iload #4
    //   385: istore_2
    //   386: goto -> 452
    //   389: aload #6
    //   391: ldc 'gr'
    //   393: invokevirtual equals : (Ljava/lang/Object;)Z
    //   396: ifeq -> 450
    //   399: iconst_0
    //   400: istore_2
    //   401: goto -> 452
    //   404: aload #6
    //   406: ldc 'gf'
    //   408: invokevirtual equals : (Ljava/lang/Object;)Z
    //   411: ifeq -> 450
    //   414: iconst_4
    //   415: istore_2
    //   416: goto -> 452
    //   419: aload #6
    //   421: ldc 'fl'
    //   423: invokevirtual equals : (Ljava/lang/Object;)Z
    //   426: ifeq -> 450
    //   429: iconst_3
    //   430: istore_2
    //   431: goto -> 452
    //   434: aload #6
    //   436: ldc 'el'
    //   438: invokevirtual equals : (Ljava/lang/Object;)Z
    //   441: ifeq -> 450
    //   444: bipush #7
    //   446: istore_2
    //   447: goto -> 452
    //   450: iconst_m1
    //   451: istore_2
    //   452: iload_2
    //   453: tableswitch default -> 520, 0 -> 673, 1 -> 664, 2 -> 655, 3 -> 646, 4 -> 637, 5 -> 628, 6 -> 619, 7 -> 609, 8 -> 600, 9 -> 591, 10 -> 582, 11 -> 564, 12 -> 555
    //   520: new java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial <init> : ()V
    //   527: astore_1
    //   528: aload_1
    //   529: ldc 'Unknown shape type '
    //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_1
    //   536: aload #6
    //   538: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_1
    //   543: invokevirtual toString : ()Ljava/lang/String;
    //   546: invokestatic b : (Ljava/lang/String;)V
    //   549: aload #7
    //   551: astore_1
    //   552: goto -> 679
    //   555: aload_0
    //   556: aload_1
    //   557: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/Repeater;
    //   560: astore_1
    //   561: goto -> 679
    //   564: aload_0
    //   565: invokestatic a : (Landroid/util/JsonReader;)Lcom/airbnb/lottie/model/content/MergePaths;
    //   568: astore #6
    //   570: aload_1
    //   571: ldc 'Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().'
    //   573: invokevirtual a : (Ljava/lang/String;)V
    //   576: aload #6
    //   578: astore_1
    //   579: goto -> 679
    //   582: aload_0
    //   583: aload_1
    //   584: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/PolystarShape;
    //   587: astore_1
    //   588: goto -> 679
    //   591: aload_0
    //   592: aload_1
    //   593: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/ShapeTrimPath;
    //   596: astore_1
    //   597: goto -> 679
    //   600: aload_0
    //   601: aload_1
    //   602: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/RectangleShape;
    //   605: astore_1
    //   606: goto -> 679
    //   609: aload_0
    //   610: aload_1
    //   611: iload_3
    //   612: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;I)Lcom/airbnb/lottie/model/content/CircleShape;
    //   615: astore_1
    //   616: goto -> 679
    //   619: aload_0
    //   620: aload_1
    //   621: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/ShapePath;
    //   624: astore_1
    //   625: goto -> 679
    //   628: aload_0
    //   629: aload_1
    //   630: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableTransform;
    //   633: astore_1
    //   634: goto -> 679
    //   637: aload_0
    //   638: aload_1
    //   639: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/GradientFill;
    //   642: astore_1
    //   643: goto -> 679
    //   646: aload_0
    //   647: aload_1
    //   648: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/ShapeFill;
    //   651: astore_1
    //   652: goto -> 679
    //   655: aload_0
    //   656: aload_1
    //   657: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/GradientStroke;
    //   660: astore_1
    //   661: goto -> 679
    //   664: aload_0
    //   665: aload_1
    //   666: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/ShapeStroke;
    //   669: astore_1
    //   670: goto -> 679
    //   673: aload_0
    //   674: aload_1
    //   675: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/content/ShapeGroup;
    //   678: astore_1
    //   679: aload_0
    //   680: invokevirtual hasNext : ()Z
    //   683: ifeq -> 693
    //   686: aload_0
    //   687: invokevirtual skipValue : ()V
    //   690: goto -> 679
    //   693: aload_0
    //   694: invokevirtual endObject : ()V
    //   697: aload_1
    //   698: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ContentModelParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */