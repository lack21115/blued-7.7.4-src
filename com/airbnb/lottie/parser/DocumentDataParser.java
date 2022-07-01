package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.DocumentData;
import java.io.IOException;

public class DocumentDataParser implements ValueParser<DocumentData> {
  public static final DocumentDataParser a = new DocumentDataParser();
  
  public DocumentData a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    // Byte code:
    //   0: getstatic com/airbnb/lottie/model/DocumentData$Justification.c : Lcom/airbnb/lottie/model/DocumentData$Justification;
    //   3: astore #16
    //   5: aload_1
    //   6: invokevirtual beginObject : ()V
    //   9: aconst_null
    //   10: astore #18
    //   12: aload #18
    //   14: astore #17
    //   16: dconst_0
    //   17: dstore #9
    //   19: dload #9
    //   21: dstore_3
    //   22: dload_3
    //   23: dstore #5
    //   25: dload #5
    //   27: dstore #7
    //   29: iconst_0
    //   30: istore #14
    //   32: iconst_0
    //   33: istore #13
    //   35: iconst_0
    //   36: istore #12
    //   38: iconst_1
    //   39: istore #15
    //   41: aload_1
    //   42: invokevirtual hasNext : ()Z
    //   45: ifeq -> 532
    //   48: aload_1
    //   49: invokevirtual nextName : ()Ljava/lang/String;
    //   52: astore #19
    //   54: aload #19
    //   56: invokevirtual hashCode : ()I
    //   59: istore #11
    //   61: iload #11
    //   63: bipush #102
    //   65: if_icmpeq -> 313
    //   68: iload #11
    //   70: bipush #106
    //   72: if_icmpeq -> 297
    //   75: iload #11
    //   77: sipush #3261
    //   80: if_icmpeq -> 280
    //   83: iload #11
    //   85: sipush #3452
    //   88: if_icmpeq -> 264
    //   91: iload #11
    //   93: sipush #3463
    //   96: if_icmpeq -> 247
    //   99: iload #11
    //   101: sipush #3543
    //   104: if_icmpeq -> 230
    //   107: iload #11
    //   109: sipush #3664
    //   112: if_icmpeq -> 213
    //   115: iload #11
    //   117: sipush #3684
    //   120: if_icmpeq -> 196
    //   123: iload #11
    //   125: sipush #3710
    //   128: if_icmpeq -> 180
    //   131: iload #11
    //   133: bipush #115
    //   135: if_icmpeq -> 164
    //   138: iload #11
    //   140: bipush #116
    //   142: if_icmpeq -> 148
    //   145: goto -> 329
    //   148: aload #19
    //   150: ldc 't'
    //   152: invokevirtual equals : (Ljava/lang/Object;)Z
    //   155: ifeq -> 329
    //   158: iconst_0
    //   159: istore #11
    //   161: goto -> 332
    //   164: aload #19
    //   166: ldc 's'
    //   168: invokevirtual equals : (Ljava/lang/Object;)Z
    //   171: ifeq -> 329
    //   174: iconst_2
    //   175: istore #11
    //   177: goto -> 332
    //   180: aload #19
    //   182: ldc 'tr'
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifeq -> 329
    //   190: iconst_4
    //   191: istore #11
    //   193: goto -> 332
    //   196: aload #19
    //   198: ldc 'sw'
    //   200: invokevirtual equals : (Ljava/lang/Object;)Z
    //   203: ifeq -> 329
    //   206: bipush #9
    //   208: istore #11
    //   210: goto -> 332
    //   213: aload #19
    //   215: ldc 'sc'
    //   217: invokevirtual equals : (Ljava/lang/Object;)Z
    //   220: ifeq -> 329
    //   223: bipush #8
    //   225: istore #11
    //   227: goto -> 332
    //   230: aload #19
    //   232: ldc 'of'
    //   234: invokevirtual equals : (Ljava/lang/Object;)Z
    //   237: ifeq -> 329
    //   240: bipush #10
    //   242: istore #11
    //   244: goto -> 332
    //   247: aload #19
    //   249: ldc 'ls'
    //   251: invokevirtual equals : (Ljava/lang/Object;)Z
    //   254: ifeq -> 329
    //   257: bipush #6
    //   259: istore #11
    //   261: goto -> 332
    //   264: aload #19
    //   266: ldc 'lh'
    //   268: invokevirtual equals : (Ljava/lang/Object;)Z
    //   271: ifeq -> 329
    //   274: iconst_5
    //   275: istore #11
    //   277: goto -> 332
    //   280: aload #19
    //   282: ldc 'fc'
    //   284: invokevirtual equals : (Ljava/lang/Object;)Z
    //   287: ifeq -> 329
    //   290: bipush #7
    //   292: istore #11
    //   294: goto -> 332
    //   297: aload #19
    //   299: ldc 'j'
    //   301: invokevirtual equals : (Ljava/lang/Object;)Z
    //   304: ifeq -> 329
    //   307: iconst_3
    //   308: istore #11
    //   310: goto -> 332
    //   313: aload #19
    //   315: ldc 'f'
    //   317: invokevirtual equals : (Ljava/lang/Object;)Z
    //   320: ifeq -> 329
    //   323: iconst_1
    //   324: istore #11
    //   326: goto -> 332
    //   329: iconst_m1
    //   330: istore #11
    //   332: iload #11
    //   334: tableswitch default -> 392, 0 -> 523, 1 -> 514, 2 -> 505, 3 -> 461, 4 -> 452, 5 -> 444, 6 -> 435, 7 -> 426, 8 -> 417, 9 -> 408, 10 -> 399
    //   392: aload_1
    //   393: invokevirtual skipValue : ()V
    //   396: goto -> 41
    //   399: aload_1
    //   400: invokevirtual nextBoolean : ()Z
    //   403: istore #15
    //   405: goto -> 41
    //   408: aload_1
    //   409: invokevirtual nextDouble : ()D
    //   412: dstore #7
    //   414: goto -> 41
    //   417: aload_1
    //   418: invokestatic a : (Landroid/util/JsonReader;)I
    //   421: istore #12
    //   423: goto -> 41
    //   426: aload_1
    //   427: invokestatic a : (Landroid/util/JsonReader;)I
    //   430: istore #13
    //   432: goto -> 41
    //   435: aload_1
    //   436: invokevirtual nextDouble : ()D
    //   439: dstore #5
    //   441: goto -> 41
    //   444: aload_1
    //   445: invokevirtual nextDouble : ()D
    //   448: dstore_3
    //   449: goto -> 41
    //   452: aload_1
    //   453: invokevirtual nextInt : ()I
    //   456: istore #14
    //   458: goto -> 41
    //   461: aload_1
    //   462: invokevirtual nextInt : ()I
    //   465: istore #11
    //   467: iload #11
    //   469: getstatic com/airbnb/lottie/model/DocumentData$Justification.c : Lcom/airbnb/lottie/model/DocumentData$Justification;
    //   472: invokevirtual ordinal : ()I
    //   475: if_icmpgt -> 497
    //   478: iload #11
    //   480: ifge -> 486
    //   483: goto -> 497
    //   486: invokestatic values : ()[Lcom/airbnb/lottie/model/DocumentData$Justification;
    //   489: iload #11
    //   491: aaload
    //   492: astore #16
    //   494: goto -> 502
    //   497: getstatic com/airbnb/lottie/model/DocumentData$Justification.c : Lcom/airbnb/lottie/model/DocumentData$Justification;
    //   500: astore #16
    //   502: goto -> 41
    //   505: aload_1
    //   506: invokevirtual nextDouble : ()D
    //   509: dstore #9
    //   511: goto -> 41
    //   514: aload_1
    //   515: invokevirtual nextString : ()Ljava/lang/String;
    //   518: astore #17
    //   520: goto -> 41
    //   523: aload_1
    //   524: invokevirtual nextString : ()Ljava/lang/String;
    //   527: astore #18
    //   529: goto -> 41
    //   532: aload_1
    //   533: invokevirtual endObject : ()V
    //   536: new com/airbnb/lottie/model/DocumentData
    //   539: dup
    //   540: aload #18
    //   542: aload #17
    //   544: dload #9
    //   546: aload #16
    //   548: iload #14
    //   550: dload_3
    //   551: dload #5
    //   553: iload #13
    //   555: iload #12
    //   557: dload #7
    //   559: iload #15
    //   561: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;DLcom/airbnb/lottie/model/DocumentData$Justification;IDDIIDZ)V
    //   564: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\DocumentDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */