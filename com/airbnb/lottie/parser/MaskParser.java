package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.Mask;
import java.io.IOException;

class MaskParser {
  static Mask a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual beginObject : ()V
    //   4: aconst_null
    //   5: astore #5
    //   7: aconst_null
    //   8: astore #7
    //   10: aload #7
    //   12: astore #6
    //   14: iconst_0
    //   15: istore #4
    //   17: aload_0
    //   18: invokevirtual hasNext : ()Z
    //   21: ifeq -> 359
    //   24: aload_0
    //   25: invokevirtual nextName : ()Ljava/lang/String;
    //   28: astore #8
    //   30: aload #8
    //   32: invokevirtual hashCode : ()I
    //   35: istore_2
    //   36: iconst_m1
    //   37: istore_3
    //   38: iload_2
    //   39: bipush #111
    //   41: if_icmpeq -> 111
    //   44: iload_2
    //   45: sipush #3588
    //   48: if_icmpeq -> 96
    //   51: iload_2
    //   52: ldc 104433
    //   54: if_icmpeq -> 81
    //   57: iload_2
    //   58: ldc 3357091
    //   60: if_icmpeq -> 66
    //   63: goto -> 126
    //   66: aload #8
    //   68: ldc 'mode'
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 126
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -> 128
    //   81: aload #8
    //   83: ldc 'inv'
    //   85: invokevirtual equals : (Ljava/lang/Object;)Z
    //   88: ifeq -> 126
    //   91: iconst_3
    //   92: istore_2
    //   93: goto -> 128
    //   96: aload #8
    //   98: ldc 'pt'
    //   100: invokevirtual equals : (Ljava/lang/Object;)Z
    //   103: ifeq -> 126
    //   106: iconst_1
    //   107: istore_2
    //   108: goto -> 128
    //   111: aload #8
    //   113: ldc 'o'
    //   115: invokevirtual equals : (Ljava/lang/Object;)Z
    //   118: ifeq -> 126
    //   121: iconst_2
    //   122: istore_2
    //   123: goto -> 128
    //   126: iconst_m1
    //   127: istore_2
    //   128: iload_2
    //   129: ifeq -> 183
    //   132: iload_2
    //   133: iconst_1
    //   134: if_icmpeq -> 173
    //   137: iload_2
    //   138: iconst_2
    //   139: if_icmpeq -> 163
    //   142: iload_2
    //   143: iconst_3
    //   144: if_icmpeq -> 154
    //   147: aload_0
    //   148: invokevirtual skipValue : ()V
    //   151: goto -> 17
    //   154: aload_0
    //   155: invokevirtual nextBoolean : ()Z
    //   158: istore #4
    //   160: goto -> 17
    //   163: aload_0
    //   164: aload_1
    //   165: invokestatic b : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;
    //   168: astore #6
    //   170: goto -> 17
    //   173: aload_0
    //   174: aload_1
    //   175: invokestatic e : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;)Lcom/airbnb/lottie/model/animatable/AnimatableShapeValue;
    //   178: astore #7
    //   180: goto -> 17
    //   183: aload_0
    //   184: invokevirtual nextString : ()Ljava/lang/String;
    //   187: astore #5
    //   189: aload #5
    //   191: invokevirtual hashCode : ()I
    //   194: istore_2
    //   195: iload_2
    //   196: bipush #97
    //   198: if_icmpeq -> 252
    //   201: iload_2
    //   202: bipush #105
    //   204: if_icmpeq -> 235
    //   207: iload_2
    //   208: bipush #115
    //   210: if_icmpeq -> 218
    //   213: iload_3
    //   214: istore_2
    //   215: goto -> 266
    //   218: iload_3
    //   219: istore_2
    //   220: aload #5
    //   222: ldc 's'
    //   224: invokevirtual equals : (Ljava/lang/Object;)Z
    //   227: ifeq -> 266
    //   230: iconst_1
    //   231: istore_2
    //   232: goto -> 266
    //   235: iload_3
    //   236: istore_2
    //   237: aload #5
    //   239: ldc 'i'
    //   241: invokevirtual equals : (Ljava/lang/Object;)Z
    //   244: ifeq -> 266
    //   247: iconst_2
    //   248: istore_2
    //   249: goto -> 266
    //   252: iload_3
    //   253: istore_2
    //   254: aload #5
    //   256: ldc 'a'
    //   258: invokevirtual equals : (Ljava/lang/Object;)Z
    //   261: ifeq -> 266
    //   264: iconst_0
    //   265: istore_2
    //   266: iload_2
    //   267: ifeq -> 351
    //   270: iload_2
    //   271: iconst_1
    //   272: if_icmpeq -> 343
    //   275: iload_2
    //   276: iconst_2
    //   277: if_icmpeq -> 329
    //   280: new java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial <init> : ()V
    //   287: astore #5
    //   289: aload #5
    //   291: ldc 'Unknown mask mode '
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #5
    //   299: aload #8
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #5
    //   307: ldc '. Defaulting to Add.'
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #5
    //   315: invokevirtual toString : ()Ljava/lang/String;
    //   318: invokestatic b : (Ljava/lang/String;)V
    //   321: getstatic com/airbnb/lottie/model/content/Mask$MaskMode.a : Lcom/airbnb/lottie/model/content/Mask$MaskMode;
    //   324: astore #5
    //   326: goto -> 17
    //   329: aload_1
    //   330: ldc 'Animation contains intersect masks. They are not supported but will be treated like add masks.'
    //   332: invokevirtual a : (Ljava/lang/String;)V
    //   335: getstatic com/airbnb/lottie/model/content/Mask$MaskMode.c : Lcom/airbnb/lottie/model/content/Mask$MaskMode;
    //   338: astore #5
    //   340: goto -> 17
    //   343: getstatic com/airbnb/lottie/model/content/Mask$MaskMode.b : Lcom/airbnb/lottie/model/content/Mask$MaskMode;
    //   346: astore #5
    //   348: goto -> 17
    //   351: getstatic com/airbnb/lottie/model/content/Mask$MaskMode.a : Lcom/airbnb/lottie/model/content/Mask$MaskMode;
    //   354: astore #5
    //   356: goto -> 17
    //   359: aload_0
    //   360: invokevirtual endObject : ()V
    //   363: new com/airbnb/lottie/model/content/Mask
    //   366: dup
    //   367: aload #5
    //   369: aload #7
    //   371: aload #6
    //   373: iload #4
    //   375: invokespecial <init> : (Lcom/airbnb/lottie/model/content/Mask$MaskMode;Lcom/airbnb/lottie/model/animatable/AnimatableShapeValue;Lcom/airbnb/lottie/model/animatable/AnimatableIntegerValue;Z)V
    //   378: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\MaskParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */