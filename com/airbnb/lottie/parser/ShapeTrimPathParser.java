package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.io.IOException;

class ShapeTrimPathParser {
  static ShapeTrimPath a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aload #8
    //   5: astore #4
    //   7: aload #4
    //   9: astore #5
    //   11: aload #5
    //   13: astore #6
    //   15: aload #6
    //   17: astore #7
    //   19: iconst_0
    //   20: istore_3
    //   21: aload_0
    //   22: invokevirtual hasNext : ()Z
    //   25: ifeq -> 271
    //   28: aload_0
    //   29: invokevirtual nextName : ()Ljava/lang/String;
    //   32: astore #9
    //   34: aload #9
    //   36: invokevirtual hashCode : ()I
    //   39: istore_2
    //   40: iload_2
    //   41: bipush #101
    //   43: if_icmpeq -> 156
    //   46: iload_2
    //   47: bipush #109
    //   49: if_icmpeq -> 141
    //   52: iload_2
    //   53: bipush #111
    //   55: if_icmpeq -> 126
    //   58: iload_2
    //   59: bipush #115
    //   61: if_icmpeq -> 111
    //   64: iload_2
    //   65: sipush #3324
    //   68: if_icmpeq -> 96
    //   71: iload_2
    //   72: sipush #3519
    //   75: if_icmpeq -> 81
    //   78: goto -> 171
    //   81: aload #9
    //   83: ldc 'nm'
    //   85: invokevirtual equals : (Ljava/lang/Object;)Z
    //   88: ifeq -> 171
    //   91: iconst_3
    //   92: istore_2
    //   93: goto -> 173
    //   96: aload #9
    //   98: ldc 'hd'
    //   100: invokevirtual equals : (Ljava/lang/Object;)Z
    //   103: ifeq -> 171
    //   106: iconst_5
    //   107: istore_2
    //   108: goto -> 173
    //   111: aload #9
    //   113: ldc 's'
    //   115: invokevirtual equals : (Ljava/lang/Object;)Z
    //   118: ifeq -> 171
    //   121: iconst_0
    //   122: istore_2
    //   123: goto -> 173
    //   126: aload #9
    //   128: ldc 'o'
    //   130: invokevirtual equals : (Ljava/lang/Object;)Z
    //   133: ifeq -> 171
    //   136: iconst_2
    //   137: istore_2
    //   138: goto -> 173
    //   141: aload #9
    //   143: ldc 'm'
    //   145: invokevirtual equals : (Ljava/lang/Object;)Z
    //   148: ifeq -> 171
    //   151: iconst_4
    //   152: istore_2
    //   153: goto -> 173
    //   156: aload #9
    //   158: ldc 'e'
    //   160: invokevirtual equals : (Ljava/lang/Object;)Z
    //   163: ifeq -> 171
    //   166: iconst_1
    //   167: istore_2
    //   168: goto -> 173
    //   171: iconst_m1
    //   172: istore_2
    //   173: iload_2
    //   174: ifeq -> 260
    //   177: iload_2
    //   178: iconst_1
    //   179: if_icmpeq -> 249
    //   182: iload_2
    //   183: iconst_2
    //   184: if_icmpeq -> 238
    //   187: iload_2
    //   188: iconst_3
    //   189: if_icmpeq -> 229
    //   192: iload_2
    //   193: iconst_4
    //   194: if_icmpeq -> 217
    //   197: iload_2
    //   198: iconst_5
    //   199: if_icmpeq -> 209
    //   202: aload_0
    //   203: invokevirtual skipValue : ()V
    //   206: goto -> 21
    //   209: aload_0
    //   210: invokevirtual nextBoolean : ()Z
    //   213: istore_3
    //   214: goto -> 206
    //   217: aload_0
    //   218: invokevirtual nextInt : ()I
    //   221: invokestatic a : (I)Lcom/airbnb/lottie/model/content/ShapeTrimPath$Type;
    //   224: astore #4
    //   226: goto -> 206
    //   229: aload_0
    //   230: invokevirtual nextString : ()Ljava/lang/String;
    //   233: astore #8
    //   235: goto -> 206
    //   238: aload_0
    //   239: aload_1
    //   240: iconst_0
    //   241: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   244: astore #7
    //   246: goto -> 21
    //   249: aload_0
    //   250: aload_1
    //   251: iconst_0
    //   252: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   255: astore #6
    //   257: goto -> 21
    //   260: aload_0
    //   261: aload_1
    //   262: iconst_0
    //   263: invokestatic a : (Landroid/util/JsonReader;Lcom/airbnb/lottie/LottieComposition;Z)Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;
    //   266: astore #5
    //   268: goto -> 21
    //   271: new com/airbnb/lottie/model/content/ShapeTrimPath
    //   274: dup
    //   275: aload #8
    //   277: aload #4
    //   279: aload #5
    //   281: aload #6
    //   283: aload #7
    //   285: iload_3
    //   286: invokespecial <init> : (Ljava/lang/String;Lcom/airbnb/lottie/model/content/ShapeTrimPath$Type;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Lcom/airbnb/lottie/model/animatable/AnimatableFloatValue;Z)V
    //   289: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ShapeTrimPathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */