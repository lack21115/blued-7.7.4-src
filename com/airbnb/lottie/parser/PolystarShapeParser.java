package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.PolystarShape;
import java.io.IOException;

class PolystarShapeParser {
  static PolystarShape a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #12
    //   3: aload #12
    //   5: astore #4
    //   7: aload #4
    //   9: astore #5
    //   11: aload #5
    //   13: astore #6
    //   15: aload #6
    //   17: astore #7
    //   19: aload #7
    //   21: astore #8
    //   23: aload #8
    //   25: astore #9
    //   27: aload #9
    //   29: astore #10
    //   31: aload #10
    //   33: astore #11
    //   35: iconst_0
    //   36: istore_3
    //   37: aload_0
    //   38: invokevirtual hasNext : ()Z
    //   41: ifeq -> 450
    //   44: aload_0
    //   45: invokevirtual nextName : ()Ljava/lang/String;
    //   48: astore #13
    //   50: aload #13
    //   52: invokevirtual hashCode : ()I
    //   55: istore_2
    //   56: iload_2
    //   57: bipush #112
    //   59: if_icmpeq -> 266
    //   62: iload_2
    //   63: bipush #114
    //   65: if_icmpeq -> 251
    //   68: iload_2
    //   69: sipush #3324
    //   72: if_icmpeq -> 235
    //   75: iload_2
    //   76: sipush #3519
    //   79: if_icmpeq -> 220
    //   82: iload_2
    //   83: sipush #3588
    //   86: if_icmpeq -> 205
    //   89: iload_2
    //   90: sipush #3686
    //   93: if_icmpeq -> 190
    //   96: iload_2
    //   97: sipush #3369
    //   100: if_icmpeq -> 174
    //   103: iload_2
    //   104: sipush #3370
    //   107: if_icmpeq -> 158
    //   110: iload_2
    //   111: sipush #3555
    //   114: if_icmpeq -> 143
    //   117: iload_2
    //   118: sipush #3556
    //   121: if_icmpeq -> 127
    //   124: goto -> 281
    //   127: aload #13
    //   129: ldc 'os'
    //   131: invokevirtual equals : (Ljava/lang/Object;)Z
    //   134: ifeq -> 281
    //   137: bipush #6
    //   139: istore_2
    //   140: goto -> 283
    //   143: aload #13
    //   145: ldc 'or'
    //   147: invokevirtual equals : (Ljava/lang/Object;)Z
    //   150: ifeq -> 281
    //   153: iconst_5
    //   154: istore_2
    //   155: goto -> 283
    //   158: aload #13
    //   160: ldc 'is'
    //   162: invokevirtual equals : (Ljava/lang/Object;)Z
    //   165: ifeq -> 281
    //   168: bipush #8
    //   170: istore_2
    //   171: goto -> 283
    //   174: aload #13
    //   176: ldc 'ir'
    //   178: invokevirtual equals : (Ljava/lang/Object;)Z
    //   181: ifeq -> 281
    //   184: bipush #7
    //   186: istore_2
    //   187: goto -> 283
    //   190: aload #13
    //   192: ldc 'sy'
    //   194: invokevirtual equals : (Ljava/lang/Object;)Z
    //   197: ifeq -> 281
    //   200: iconst_1
    //   201: istore_2
    //   202: goto -> 283
    //   205: aload #13
    //   207: ldc 'pt'
    //   209: invokevirtual equals : (Ljava/lang/Object;)Z
    //   212: ifeq -> 281
    //   215: iconst_2
    //   216: istore_2
    //   217: goto -> 283
    //   220: aload #13
    //   222: ldc 'nm'
    //   224: invokevirtual equals : (Ljava/lang/Object;)Z
    //   227: ifeq -> 281
    //   230: iconst_0
    //   231: istore_2
    //   232: goto -> 283
    //   235: aload #13
    //   237: ldc 'hd'
    //   239: invokevirtual equals : (Ljava/lang/Object;)Z
    //   242: ifeq -> 281
    //   245: bipush #9
    //   247: istore_2
    //   248: goto -> 283
    //   251: aload #13
    //   253: ldc 'r'
    //   255: invokevirtual equals : (Ljava/lang/Object;)Z
    //   258: ifeq -> 281
    //   261: iconst_4
    //   262: istore_2
    //   263: goto -> 283
    //   266: aload #13
    //   268: ldc 'p'
    //   270: invokevirtual equals : (Ljava/lang/Object;)Z
    //   273: ifeq -> 281
    //   276: iconst_3
    //   277: istore_2
    //   278: goto -> 283
    //   281: iconst_m1
    //   282: istore_2
    //   283: iload_2
    //   284: tableswitch default -> 340, 0 -> 441, 1 -> 429, 2 -> 418, 3 -> 408, 4 -> 397, 5 -> 387, 6 -> 376, 7 -> 366, 8 -> 355, 9 -> 347
    //   340: aload_0
    //   341: invokevirtual skipValue : ()V
    //   344: goto -> 37
    //   347: aload_0
    //   348: invokevirtual nextBoolean : ()Z
    //   351: istore_3
    //   352: goto -> 37
    //   355: aload_0
    //   356: aload_1
    //   357: iconst_0
    //   358: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   361: astore #10
    //   363: goto -> 37
    //   366: aload_0
    //   367: aload_1
    //   368: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   371: astore #8
    //   373: goto -> 37
    //   376: aload_0
    //   377: aload_1
    //   378: iconst_0
    //   379: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   382: astore #11
    //   384: goto -> 37
    //   387: aload_0
    //   388: aload_1
    //   389: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   392: astore #9
    //   394: goto -> 37
    //   397: aload_0
    //   398: aload_1
    //   399: iconst_0
    //   400: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   403: astore #7
    //   405: goto -> 37
    //   408: aload_0
    //   409: aload_1
    //   410: invokestatic b : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableValue;
    //   413: astore #6
    //   415: goto -> 37
    //   418: aload_0
    //   419: aload_1
    //   420: iconst_0
    //   421: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   424: astore #5
    //   426: goto -> 37
    //   429: aload_0
    //   430: invokevirtual nextInt : ()I
    //   433: invokestatic a : (I)Lcom/airbnb/lottie/model/content/PolystarShape$Type;
    //   436: astore #4
    //   438: goto -> 37
    //   441: aload_0
    //   442: invokevirtual nextString : ()Ljava/lang/String;
    //   445: astore #12
    //   447: goto -> 37
    //   450: new com/airbnb/lottie/model/content/PolystarShape
    //   453: dup
    //   454: aload #12
    //   456: aload #4
    //   458: aload #5
    //   460: aload #6
    //   462: aload #7
    //   464: aload #8
    //   466: aload #9
    //   468: aload #10
    //   470: aload #11
    //   472: iload_3
    //   473: invokespecial <init> : (Ljava/lang/String;Lcom/airbnb/lottie/model/content/PolystarShape$Type;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Z)V
    //   476: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\PolystarShapeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */