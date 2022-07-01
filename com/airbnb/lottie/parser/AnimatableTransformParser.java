package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class AnimatableTransformParser {
  public static AnimatableTransform a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual peek : ()Landroid/util/JsonToken;
    //   4: getstatic android/util/JsonToken.BEGIN_OBJECT : Landroid/util/JsonToken;
    //   7: if_acmpne -> 15
    //   10: iconst_1
    //   11: istore_3
    //   12: goto -> 17
    //   15: iconst_0
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq -> 25
    //   21: aload_0
    //   22: invokevirtual beginObject : ()V
    //   25: aconst_null
    //   26: astore #7
    //   28: aconst_null
    //   29: astore #9
    //   31: aconst_null
    //   32: astore #8
    //   34: aconst_null
    //   35: astore #6
    //   37: aconst_null
    //   38: astore #5
    //   40: aconst_null
    //   41: astore #4
    //   43: aconst_null
    //   44: astore #12
    //   46: aconst_null
    //   47: astore #11
    //   49: aconst_null
    //   50: astore #10
    //   52: aload_0
    //   53: invokevirtual hasNext : ()Z
    //   56: ifeq -> 606
    //   59: aload_0
    //   60: invokevirtual nextName : ()Ljava/lang/String;
    //   63: astore #13
    //   65: aload #13
    //   67: invokevirtual hashCode : ()I
    //   70: istore_2
    //   71: iload_2
    //   72: bipush #97
    //   74: if_icmpeq -> 278
    //   77: iload_2
    //   78: sipush #3242
    //   81: if_icmpeq -> 262
    //   84: iload_2
    //   85: sipush #3656
    //   88: if_icmpeq -> 247
    //   91: iload_2
    //   92: sipush #3662
    //   95: if_icmpeq -> 231
    //   98: iload_2
    //   99: sipush #3672
    //   102: if_icmpeq -> 215
    //   105: iload_2
    //   106: sipush #3676
    //   109: if_icmpeq -> 199
    //   112: iload_2
    //   113: bipush #111
    //   115: if_icmpeq -> 184
    //   118: iload_2
    //   119: bipush #112
    //   121: if_icmpeq -> 169
    //   124: iload_2
    //   125: bipush #114
    //   127: if_icmpeq -> 154
    //   130: iload_2
    //   131: bipush #115
    //   133: if_icmpeq -> 139
    //   136: goto -> 293
    //   139: aload #13
    //   141: ldc 's'
    //   143: invokevirtual equals : (Ljava/lang/Object;)Z
    //   146: ifeq -> 293
    //   149: iconst_2
    //   150: istore_2
    //   151: goto -> 295
    //   154: aload #13
    //   156: ldc 'r'
    //   158: invokevirtual equals : (Ljava/lang/Object;)Z
    //   161: ifeq -> 293
    //   164: iconst_4
    //   165: istore_2
    //   166: goto -> 295
    //   169: aload #13
    //   171: ldc 'p'
    //   173: invokevirtual equals : (Ljava/lang/Object;)Z
    //   176: ifeq -> 293
    //   179: iconst_1
    //   180: istore_2
    //   181: goto -> 295
    //   184: aload #13
    //   186: ldc 'o'
    //   188: invokevirtual equals : (Ljava/lang/Object;)Z
    //   191: ifeq -> 293
    //   194: iconst_5
    //   195: istore_2
    //   196: goto -> 295
    //   199: aload #13
    //   201: ldc 'so'
    //   203: invokevirtual equals : (Ljava/lang/Object;)Z
    //   206: ifeq -> 293
    //   209: bipush #6
    //   211: istore_2
    //   212: goto -> 295
    //   215: aload #13
    //   217: ldc 'sk'
    //   219: invokevirtual equals : (Ljava/lang/Object;)Z
    //   222: ifeq -> 293
    //   225: bipush #8
    //   227: istore_2
    //   228: goto -> 295
    //   231: aload #13
    //   233: ldc 'sa'
    //   235: invokevirtual equals : (Ljava/lang/Object;)Z
    //   238: ifeq -> 293
    //   241: bipush #9
    //   243: istore_2
    //   244: goto -> 295
    //   247: aload #13
    //   249: ldc 'rz'
    //   251: invokevirtual equals : (Ljava/lang/Object;)Z
    //   254: ifeq -> 293
    //   257: iconst_3
    //   258: istore_2
    //   259: goto -> 295
    //   262: aload #13
    //   264: ldc 'eo'
    //   266: invokevirtual equals : (Ljava/lang/Object;)Z
    //   269: ifeq -> 293
    //   272: bipush #7
    //   274: istore_2
    //   275: goto -> 295
    //   278: aload #13
    //   280: ldc 'a'
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 293
    //   288: iconst_0
    //   289: istore_2
    //   290: goto -> 295
    //   293: iconst_m1
    //   294: istore_2
    //   295: iload_2
    //   296: tableswitch default -> 352, 0 -> 559, 1 -> 549, 2 -> 539, 3 -> 413, 4 -> 419, 5 -> 403, 6 -> 392, 7 -> 381, 8 -> 370, 9 -> 359
    //   352: aload_0
    //   353: invokevirtual skipValue : ()V
    //   356: goto -> 52
    //   359: aload_0
    //   360: aload_1
    //   361: iconst_0
    //   362: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   365: astore #4
    //   367: goto -> 52
    //   370: aload_0
    //   371: aload_1
    //   372: iconst_0
    //   373: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   376: astore #5
    //   378: goto -> 52
    //   381: aload_0
    //   382: aload_1
    //   383: iconst_0
    //   384: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   387: astore #10
    //   389: goto -> 52
    //   392: aload_0
    //   393: aload_1
    //   394: iconst_0
    //   395: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   398: astore #11
    //   400: goto -> 52
    //   403: aload_0
    //   404: aload_1
    //   405: invokestatic b : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;
    //   408: astore #12
    //   410: goto -> 52
    //   413: aload_1
    //   414: ldc 'Lottie doesn't support 3D layers.'
    //   416: invokevirtual a : (Ljava/lang/String;)V
    //   419: aload_0
    //   420: aload_1
    //   421: iconst_0
    //   422: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   425: astore #7
    //   427: aload #7
    //   429: invokevirtual c : ()Ljava/util/List;
    //   432: invokeinterface isEmpty : ()Z
    //   437: ifeq -> 479
    //   440: aload #7
    //   442: invokevirtual c : ()Ljava/util/List;
    //   445: new com/airbnb/lottie/value/Keyframe
    //   448: dup
    //   449: aload_1
    //   450: fconst_0
    //   451: invokestatic valueOf : (F)Ljava/lang/Float;
    //   454: fconst_0
    //   455: invokestatic valueOf : (F)Ljava/lang/Float;
    //   458: aconst_null
    //   459: fconst_0
    //   460: aload_1
    //   461: invokevirtual g : ()F
    //   464: invokestatic valueOf : (F)Ljava/lang/Float;
    //   467: invokespecial <init> : (Lcom/airbnb/lottie/LottieComposition;Ljava/lang/Object;Ljava/lang/Object;Landroid/view/animation/Interpolator;FLjava/lang/Float;)V
    //   470: invokeinterface add : (Ljava/lang/Object;)Z
    //   475: pop
    //   476: goto -> 536
    //   479: aload #7
    //   481: invokevirtual c : ()Ljava/util/List;
    //   484: iconst_0
    //   485: invokeinterface get : (I)Ljava/lang/Object;
    //   490: checkcast com/airbnb/lottie/value/Keyframe
    //   493: getfield a : Ljava/lang/Object;
    //   496: ifnonnull -> 536
    //   499: aload #7
    //   501: invokevirtual c : ()Ljava/util/List;
    //   504: iconst_0
    //   505: new com/airbnb/lottie/value/Keyframe
    //   508: dup
    //   509: aload_1
    //   510: fconst_0
    //   511: invokestatic valueOf : (F)Ljava/lang/Float;
    //   514: fconst_0
    //   515: invokestatic valueOf : (F)Ljava/lang/Float;
    //   518: aconst_null
    //   519: fconst_0
    //   520: aload_1
    //   521: invokevirtual g : ()F
    //   524: invokestatic valueOf : (F)Ljava/lang/Float;
    //   527: invokespecial <init> : (Lcom/airbnb/lottie/LottieComposition;Ljava/lang/Object;Ljava/lang/Object;Landroid/view/animation/Interpolator;FLjava/lang/Float;)V
    //   530: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   535: pop
    //   536: goto -> 52
    //   539: aload_0
    //   540: aload_1
    //   541: invokestatic d : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableScaleValue;
    //   544: astore #6
    //   546: goto -> 52
    //   549: aload_0
    //   550: aload_1
    //   551: invokestatic b : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableValue;
    //   554: astore #8
    //   556: goto -> 52
    //   559: aload_0
    //   560: invokevirtual beginObject : ()V
    //   563: aload_0
    //   564: invokevirtual hasNext : ()Z
    //   567: ifeq -> 599
    //   570: aload_0
    //   571: invokevirtual nextName : ()Ljava/lang/String;
    //   574: ldc 'k'
    //   576: invokevirtual equals : (Ljava/lang/Object;)Z
    //   579: ifeq -> 592
    //   582: aload_0
    //   583: aload_1
    //   584: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatablePathValue;
    //   587: astore #9
    //   589: goto -> 563
    //   592: aload_0
    //   593: invokevirtual skipValue : ()V
    //   596: goto -> 563
    //   599: aload_0
    //   600: invokevirtual endObject : ()V
    //   603: goto -> 52
    //   606: iload_3
    //   607: ifeq -> 614
    //   610: aload_0
    //   611: invokevirtual endObject : ()V
    //   614: aload #9
    //   616: astore_0
    //   617: aload #9
    //   619: invokestatic a : (Lcom/airbnb/lottie/model/animatable/AnimatablePathValue;)Z
    //   622: ifeq -> 627
    //   625: aconst_null
    //   626: astore_0
    //   627: aload #8
    //   629: invokestatic a : (Lcom/airbnb/lottie/model/animatable/AnimatableValue;)Z
    //   632: ifeq -> 640
    //   635: aconst_null
    //   636: astore_1
    //   637: goto -> 643
    //   640: aload #8
    //   642: astore_1
    //   643: aload #7
    //   645: invokestatic a : (Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;)Z
    //   648: ifeq -> 657
    //   651: aconst_null
    //   652: astore #7
    //   654: goto -> 657
    //   657: aload #6
    //   659: invokestatic a : (Lcom/airbnb/lottie/model/animatable/AnimatableScaleValue;)Z
    //   662: ifeq -> 671
    //   665: aconst_null
    //   666: astore #6
    //   668: goto -> 671
    //   671: aload #5
    //   673: invokestatic b : (Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;)Z
    //   676: ifeq -> 685
    //   679: aconst_null
    //   680: astore #5
    //   682: goto -> 685
    //   685: aload #4
    //   687: invokestatic c : (Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;)Z
    //   690: ifeq -> 699
    //   693: aconst_null
    //   694: astore #4
    //   696: goto -> 699
    //   699: new com/airbnb/lottie/model/animatable/AnimatableTransform
    //   702: dup
    //   703: aload_0
    //   704: aload_1
    //   705: aload #6
    //   707: aload #7
    //   709: aload #12
    //   711: aload #11
    //   713: aload #10
    //   715: aload #5
    //   717: aload #4
    //   719: invokespecial <init> : (Lcom/airbnb/lottie/model/animatable/AnimatablePathValue;Lcom/airbnb/lottie/model/animatable/AnimatableValue;Lcom/airbnb/lottie/model/animatable/AnimatableScaleValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;)V
    //   722: areturn
  }
  
  private static boolean a(AnimatableFloatValue paramAnimatableFloatValue) {
    boolean bool = false;
    if (paramAnimatableFloatValue != null) {
      boolean bool1 = bool;
      if (paramAnimatableFloatValue.b()) {
        bool1 = bool;
        if (((Float)((Keyframe)paramAnimatableFloatValue.c().get(0)).a).floatValue() == 0.0F)
          return true; 
      } 
      return bool1;
    } 
    return true;
  }
  
  private static boolean a(AnimatablePathValue paramAnimatablePathValue) {
    boolean bool = false;
    if (paramAnimatablePathValue != null) {
      boolean bool1 = bool;
      if (paramAnimatablePathValue.b()) {
        bool1 = bool;
        if (((PointF)((Keyframe)paramAnimatablePathValue.c().get(0)).a).equals(0.0F, 0.0F))
          return true; 
      } 
      return bool1;
    } 
    return true;
  }
  
  private static boolean a(AnimatableScaleValue paramAnimatableScaleValue) {
    boolean bool = false;
    if (paramAnimatableScaleValue != null) {
      boolean bool1 = bool;
      if (paramAnimatableScaleValue.b()) {
        bool1 = bool;
        if (((ScaleXY)((Keyframe)paramAnimatableScaleValue.c().get(0)).a).b(1.0F, 1.0F))
          return true; 
      } 
      return bool1;
    } 
    return true;
  }
  
  private static boolean a(AnimatableValue<PointF, PointF> paramAnimatableValue) {
    boolean bool = false;
    if (paramAnimatableValue != null) {
      boolean bool1 = bool;
      if (!(paramAnimatableValue instanceof com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue)) {
        bool1 = bool;
        if (paramAnimatableValue.b()) {
          bool1 = bool;
          if (((PointF)((Keyframe)paramAnimatableValue.c().get(0)).a).equals(0.0F, 0.0F))
            return true; 
        } 
      } 
      return bool1;
    } 
    return true;
  }
  
  private static boolean b(AnimatableFloatValue paramAnimatableFloatValue) {
    boolean bool = false;
    if (paramAnimatableFloatValue != null) {
      boolean bool1 = bool;
      if (paramAnimatableFloatValue.b()) {
        bool1 = bool;
        if (((Float)((Keyframe)paramAnimatableFloatValue.c().get(0)).a).floatValue() == 0.0F)
          return true; 
      } 
      return bool1;
    } 
    return true;
  }
  
  private static boolean c(AnimatableFloatValue paramAnimatableFloatValue) {
    boolean bool = false;
    if (paramAnimatableFloatValue != null) {
      boolean bool1 = bool;
      if (paramAnimatableFloatValue.b()) {
        bool1 = bool;
        if (((Float)((Keyframe)paramAnimatableFloatValue.c().get(0)).a).floatValue() == 0.0F)
          return true; 
      } 
      return bool1;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\AnimatableTransformParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */