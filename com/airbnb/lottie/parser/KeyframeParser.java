package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

class KeyframeParser {
  private static final Interpolator a = (Interpolator)new LinearInterpolator();
  
  private static SparseArrayCompat<WeakReference<Interpolator>> b;
  
  private static SparseArrayCompat<WeakReference<Interpolator>> a() {
    if (b == null)
      b = new SparseArrayCompat(); 
    return b;
  }
  
  private static <T> Keyframe<T> a(JsonReader paramJsonReader, float paramFloat, ValueParser<T> paramValueParser) throws IOException {
    return new Keyframe(paramValueParser.b(paramJsonReader, paramFloat));
  }
  
  static <T> Keyframe<T> a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser<T> paramValueParser, boolean paramBoolean) throws IOException {
    return paramBoolean ? a(paramLottieComposition, paramJsonReader, paramFloat, paramValueParser) : a(paramJsonReader, paramFloat, paramValueParser);
  }
  
  private static <T> Keyframe<T> a(LottieComposition paramLottieComposition, JsonReader paramJsonReader, float paramFloat, ValueParser<T> paramValueParser) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual beginObject : ()V
    //   4: iconst_0
    //   5: istore #8
    //   7: aconst_null
    //   8: astore #15
    //   10: aconst_null
    //   11: astore #14
    //   13: aconst_null
    //   14: astore #10
    //   16: aconst_null
    //   17: astore #11
    //   19: fconst_0
    //   20: fstore #4
    //   22: aconst_null
    //   23: astore #13
    //   25: aconst_null
    //   26: astore #12
    //   28: aload_1
    //   29: invokevirtual hasNext : ()Z
    //   32: ifeq -> 400
    //   35: aload_1
    //   36: invokevirtual nextName : ()Ljava/lang/String;
    //   39: astore #16
    //   41: aload #16
    //   43: invokevirtual hashCode : ()I
    //   46: istore #7
    //   48: iconst_1
    //   49: istore #9
    //   51: iload #7
    //   53: bipush #101
    //   55: if_icmpeq -> 226
    //   58: iload #7
    //   60: bipush #111
    //   62: if_icmpeq -> 210
    //   65: iload #7
    //   67: sipush #3701
    //   70: if_icmpeq -> 193
    //   73: iload #7
    //   75: sipush #3707
    //   78: if_icmpeq -> 176
    //   81: iload #7
    //   83: bipush #104
    //   85: if_icmpeq -> 160
    //   88: iload #7
    //   90: bipush #105
    //   92: if_icmpeq -> 144
    //   95: iload #7
    //   97: bipush #115
    //   99: if_icmpeq -> 128
    //   102: iload #7
    //   104: bipush #116
    //   106: if_icmpeq -> 112
    //   109: goto -> 242
    //   112: aload #16
    //   114: ldc 't'
    //   116: invokevirtual equals : (Ljava/lang/Object;)Z
    //   119: ifeq -> 242
    //   122: iconst_0
    //   123: istore #7
    //   125: goto -> 245
    //   128: aload #16
    //   130: ldc 's'
    //   132: invokevirtual equals : (Ljava/lang/Object;)Z
    //   135: ifeq -> 242
    //   138: iconst_1
    //   139: istore #7
    //   141: goto -> 245
    //   144: aload #16
    //   146: ldc 'i'
    //   148: invokevirtual equals : (Ljava/lang/Object;)Z
    //   151: ifeq -> 242
    //   154: iconst_4
    //   155: istore #7
    //   157: goto -> 245
    //   160: aload #16
    //   162: ldc 'h'
    //   164: invokevirtual equals : (Ljava/lang/Object;)Z
    //   167: ifeq -> 242
    //   170: iconst_5
    //   171: istore #7
    //   173: goto -> 245
    //   176: aload #16
    //   178: ldc 'to'
    //   180: invokevirtual equals : (Ljava/lang/Object;)Z
    //   183: ifeq -> 242
    //   186: bipush #6
    //   188: istore #7
    //   190: goto -> 245
    //   193: aload #16
    //   195: ldc 'ti'
    //   197: invokevirtual equals : (Ljava/lang/Object;)Z
    //   200: ifeq -> 242
    //   203: bipush #7
    //   205: istore #7
    //   207: goto -> 245
    //   210: aload #16
    //   212: ldc 'o'
    //   214: invokevirtual equals : (Ljava/lang/Object;)Z
    //   217: ifeq -> 242
    //   220: iconst_3
    //   221: istore #7
    //   223: goto -> 245
    //   226: aload #16
    //   228: ldc 'e'
    //   230: invokevirtual equals : (Ljava/lang/Object;)Z
    //   233: ifeq -> 242
    //   236: iconst_2
    //   237: istore #7
    //   239: goto -> 245
    //   242: iconst_m1
    //   243: istore #7
    //   245: iload #7
    //   247: tableswitch default -> 292, 0 -> 390, 1 -> 377, 2 -> 364, 3 -> 354, 4 -> 344, 5 -> 319, 6 -> 309, 7 -> 299
    //   292: aload_1
    //   293: invokevirtual skipValue : ()V
    //   296: goto -> 28
    //   299: aload_1
    //   300: fload_2
    //   301: invokestatic b : (Landroid/util/JsonReader;F)Landroid/graphics/PointF;
    //   304: astore #12
    //   306: goto -> 28
    //   309: aload_1
    //   310: fload_2
    //   311: invokestatic b : (Landroid/util/JsonReader;F)Landroid/graphics/PointF;
    //   314: astore #13
    //   316: goto -> 28
    //   319: aload_1
    //   320: invokevirtual nextInt : ()I
    //   323: iconst_1
    //   324: if_icmpne -> 334
    //   327: iload #9
    //   329: istore #7
    //   331: goto -> 337
    //   334: iconst_0
    //   335: istore #7
    //   337: iload #7
    //   339: istore #8
    //   341: goto -> 28
    //   344: aload_1
    //   345: fload_2
    //   346: invokestatic b : (Landroid/util/JsonReader;F)Landroid/graphics/PointF;
    //   349: astore #14
    //   351: goto -> 28
    //   354: aload_1
    //   355: fload_2
    //   356: invokestatic b : (Landroid/util/JsonReader;F)Landroid/graphics/PointF;
    //   359: astore #15
    //   361: goto -> 28
    //   364: aload_3
    //   365: aload_1
    //   366: fload_2
    //   367: invokeinterface b : (Landroid/util/JsonReader;F)Ljava/lang/Object;
    //   372: astore #10
    //   374: goto -> 28
    //   377: aload_3
    //   378: aload_1
    //   379: fload_2
    //   380: invokeinterface b : (Landroid/util/JsonReader;F)Ljava/lang/Object;
    //   385: astore #11
    //   387: goto -> 28
    //   390: aload_1
    //   391: invokevirtual nextDouble : ()D
    //   394: d2f
    //   395: fstore #4
    //   397: goto -> 28
    //   400: aload_1
    //   401: invokevirtual endObject : ()V
    //   404: iload #8
    //   406: ifeq -> 419
    //   409: getstatic com/airbnb/lottie/parser/KeyframeParser.a : Landroid/view/animation/Interpolator;
    //   412: astore_3
    //   413: aload #11
    //   415: astore_1
    //   416: goto -> 619
    //   419: aload #15
    //   421: ifnull -> 612
    //   424: aload #14
    //   426: ifnull -> 612
    //   429: aload #15
    //   431: getfield x : F
    //   434: fstore #5
    //   436: fload_2
    //   437: fneg
    //   438: fstore #6
    //   440: aload #15
    //   442: fload #5
    //   444: fload #6
    //   446: fload_2
    //   447: invokestatic b : (FFF)F
    //   450: putfield x : F
    //   453: aload #15
    //   455: aload #15
    //   457: getfield y : F
    //   460: ldc -100.0
    //   462: ldc 100.0
    //   464: invokestatic b : (FFF)F
    //   467: putfield y : F
    //   470: aload #14
    //   472: aload #14
    //   474: getfield x : F
    //   477: fload #6
    //   479: fload_2
    //   480: invokestatic b : (FFF)F
    //   483: putfield x : F
    //   486: aload #14
    //   488: aload #14
    //   490: getfield y : F
    //   493: ldc -100.0
    //   495: ldc 100.0
    //   497: invokestatic b : (FFF)F
    //   500: putfield y : F
    //   503: aload #15
    //   505: getfield x : F
    //   508: aload #15
    //   510: getfield y : F
    //   513: aload #14
    //   515: getfield x : F
    //   518: aload #14
    //   520: getfield y : F
    //   523: invokestatic a : (FFFF)I
    //   526: istore #7
    //   528: iload #7
    //   530: invokestatic a : (I)Ljava/lang/ref/WeakReference;
    //   533: astore_3
    //   534: aload_3
    //   535: ifnull -> 549
    //   538: aload_3
    //   539: invokevirtual get : ()Ljava/lang/Object;
    //   542: checkcast android/view/animation/Interpolator
    //   545: astore_1
    //   546: goto -> 551
    //   549: aconst_null
    //   550: astore_1
    //   551: aload_3
    //   552: ifnull -> 561
    //   555: aload_1
    //   556: astore_3
    //   557: aload_1
    //   558: ifnonnull -> 606
    //   561: aload #15
    //   563: getfield x : F
    //   566: fload_2
    //   567: fdiv
    //   568: aload #15
    //   570: getfield y : F
    //   573: fload_2
    //   574: fdiv
    //   575: aload #14
    //   577: getfield x : F
    //   580: fload_2
    //   581: fdiv
    //   582: aload #14
    //   584: getfield y : F
    //   587: fload_2
    //   588: fdiv
    //   589: invokestatic create : (FFFF)Landroid/view/animation/Interpolator;
    //   592: astore_3
    //   593: iload #7
    //   595: new java/lang/ref/WeakReference
    //   598: dup
    //   599: aload_3
    //   600: invokespecial <init> : (Ljava/lang/Object;)V
    //   603: invokestatic a : (ILjava/lang/ref/WeakReference;)V
    //   606: aload #10
    //   608: astore_1
    //   609: goto -> 619
    //   612: getstatic com/airbnb/lottie/parser/KeyframeParser.a : Landroid/view/animation/Interpolator;
    //   615: astore_3
    //   616: aload #10
    //   618: astore_1
    //   619: new com/airbnb/lottie/value/Keyframe
    //   622: dup
    //   623: aload_0
    //   624: aload #11
    //   626: aload_1
    //   627: aload_3
    //   628: fload #4
    //   630: aconst_null
    //   631: invokespecial <init> : (Lcom/airbnb/lottie/LottieComposition;Ljava/lang/Object;Ljava/lang/Object;Landroid/view/animation/Interpolator;FLjava/lang/Float;)V
    //   634: astore_0
    //   635: aload_0
    //   636: aload #13
    //   638: putfield f : Landroid/graphics/PointF;
    //   641: aload_0
    //   642: aload #12
    //   644: putfield g : Landroid/graphics/PointF;
    //   647: aload_0
    //   648: areturn
    //   649: astore_1
    //   650: goto -> 606
    // Exception table:
    //   from	to	target	type
    //   593	606	649	java/lang/ArrayIndexOutOfBoundsException
  }
  
  private static WeakReference<Interpolator> a(int paramInt) {
    // Byte code:
    //   0: ldc com/airbnb/lottie/parser/KeyframeParser
    //   2: monitorenter
    //   3: invokestatic a : ()Landroidx/collection/SparseArrayCompat;
    //   6: iload_0
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast java/lang/ref/WeakReference
    //   13: astore_1
    //   14: ldc com/airbnb/lottie/parser/KeyframeParser
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: ldc com/airbnb/lottie/parser/KeyframeParser
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	19	finally
    //   20	23	19	finally
  }
  
  private static void a(int paramInt, WeakReference<Interpolator> paramWeakReference) {
    // Byte code:
    //   0: ldc com/airbnb/lottie/parser/KeyframeParser
    //   2: monitorenter
    //   3: getstatic com/airbnb/lottie/parser/KeyframeParser.b : Landroidx/collection/SparseArrayCompat;
    //   6: iload_0
    //   7: aload_1
    //   8: invokevirtual put : (ILjava/lang/Object;)V
    //   11: ldc com/airbnb/lottie/parser/KeyframeParser
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: ldc com/airbnb/lottie/parser/KeyframeParser
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	15	finally
    //   16	19	15	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\KeyframeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */