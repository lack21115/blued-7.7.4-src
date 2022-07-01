package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Decoder extends CharsetDecoder {
  private static final Charset charset = Charset.forName("UTF-8");
  
  public UTF8Decoder() {
    super(charset, 1.0F, 1.0F);
  }
  
  private static CoderResult malformed(ByteBuffer paramByteBuffer, int paramInt1, CharBuffer paramCharBuffer, int paramInt2, int paramInt3) {
    paramByteBuffer.position(paramInt1 - paramByteBuffer.arrayOffset());
    CoderResult coderResult = malformedN(paramByteBuffer, paramInt3);
    paramByteBuffer.position(paramInt1);
    paramCharBuffer.position(paramInt2);
    return coderResult;
  }
  
  public static CoderResult malformedN(ByteBuffer paramByteBuffer, int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore #4
    //   5: iconst_1
    //   6: istore_2
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpeq -> 199
    //   12: iload_1
    //   13: iconst_2
    //   14: if_icmpeq -> 194
    //   17: iload_1
    //   18: iconst_3
    //   19: if_icmpeq -> 142
    //   22: iload_1
    //   23: iconst_4
    //   24: if_icmpne -> 134
    //   27: aload_0
    //   28: invokevirtual get : ()B
    //   31: sipush #255
    //   34: iand
    //   35: istore_1
    //   36: aload_0
    //   37: invokevirtual get : ()B
    //   40: sipush #255
    //   43: iand
    //   44: istore_2
    //   45: iload_1
    //   46: sipush #244
    //   49: if_icmpgt -> 129
    //   52: iload_1
    //   53: sipush #240
    //   56: if_icmpne -> 73
    //   59: iload_2
    //   60: sipush #144
    //   63: if_icmplt -> 129
    //   66: iload_2
    //   67: sipush #191
    //   70: if_icmpgt -> 129
    //   73: iload_1
    //   74: sipush #244
    //   77: if_icmpne -> 91
    //   80: iload_2
    //   81: sipush #240
    //   84: iand
    //   85: sipush #128
    //   88: if_icmpne -> 129
    //   91: iload_2
    //   92: sipush #192
    //   95: iand
    //   96: sipush #128
    //   99: if_icmpeq -> 105
    //   102: goto -> 129
    //   105: aload_0
    //   106: invokevirtual get : ()B
    //   109: sipush #192
    //   112: iand
    //   113: sipush #128
    //   116: if_icmpeq -> 124
    //   119: iconst_2
    //   120: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   123: areturn
    //   124: iconst_3
    //   125: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   128: areturn
    //   129: iconst_1
    //   130: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   133: areturn
    //   134: new java/lang/IllegalStateException
    //   137: dup
    //   138: invokespecial <init> : ()V
    //   141: athrow
    //   142: aload_0
    //   143: invokevirtual get : ()B
    //   146: istore_1
    //   147: aload_0
    //   148: invokevirtual get : ()B
    //   151: istore_3
    //   152: iload_1
    //   153: bipush #-32
    //   155: if_icmpne -> 171
    //   158: iload_2
    //   159: istore_1
    //   160: iload_3
    //   161: sipush #224
    //   164: iand
    //   165: sipush #128
    //   168: if_icmpeq -> 189
    //   171: iload_3
    //   172: sipush #192
    //   175: iand
    //   176: sipush #128
    //   179: if_icmpeq -> 187
    //   182: iload_2
    //   183: istore_1
    //   184: goto -> 189
    //   187: iconst_2
    //   188: istore_1
    //   189: iload_1
    //   190: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   193: areturn
    //   194: iconst_1
    //   195: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   198: areturn
    //   199: aload_0
    //   200: invokevirtual get : ()B
    //   203: istore_1
    //   204: iload_1
    //   205: iconst_2
    //   206: ishr
    //   207: bipush #-2
    //   209: if_icmpne -> 262
    //   212: iload_3
    //   213: istore_1
    //   214: aload_0
    //   215: invokevirtual remaining : ()I
    //   218: iconst_4
    //   219: if_icmpge -> 226
    //   222: getstatic java/nio/charset/CoderResult.UNDERFLOW : Ljava/nio/charset/CoderResult;
    //   225: areturn
    //   226: iload_1
    //   227: iconst_5
    //   228: if_icmpge -> 257
    //   231: aload_0
    //   232: invokevirtual get : ()B
    //   235: sipush #192
    //   238: iand
    //   239: sipush #128
    //   242: if_icmpeq -> 250
    //   245: iload_1
    //   246: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   249: areturn
    //   250: iload_1
    //   251: iconst_1
    //   252: iadd
    //   253: istore_1
    //   254: goto -> 226
    //   257: iconst_5
    //   258: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   261: areturn
    //   262: iload_1
    //   263: iconst_1
    //   264: ishr
    //   265: bipush #-2
    //   267: if_icmpne -> 323
    //   270: aload_0
    //   271: invokevirtual remaining : ()I
    //   274: iconst_5
    //   275: if_icmpge -> 282
    //   278: getstatic java/nio/charset/CoderResult.UNDERFLOW : Ljava/nio/charset/CoderResult;
    //   281: areturn
    //   282: iload #4
    //   284: istore_1
    //   285: iload_1
    //   286: bipush #6
    //   288: if_icmpge -> 317
    //   291: aload_0
    //   292: invokevirtual get : ()B
    //   295: sipush #192
    //   298: iand
    //   299: sipush #128
    //   302: if_icmpeq -> 310
    //   305: iload_1
    //   306: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   309: areturn
    //   310: iload_1
    //   311: iconst_1
    //   312: iadd
    //   313: istore_1
    //   314: goto -> 285
    //   317: bipush #6
    //   319: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   322: areturn
    //   323: iconst_1
    //   324: invokestatic malformedForLength : (I)Ljava/nio/charset/CoderResult;
    //   327: areturn
  }
  
  private static CoderResult xflow(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4) {
    paramBuffer1.position(paramInt1);
    paramBuffer2.position(paramInt3);
    return (paramInt4 == 0 || paramInt2 - paramInt1 < paramInt4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
  }
  
  protected CoderResult decodeLoop(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual array : ()[B
    //   4: astore #14
    //   6: aload_1
    //   7: invokevirtual arrayOffset : ()I
    //   10: aload_1
    //   11: invokevirtual position : ()I
    //   14: iadd
    //   15: istore #5
    //   17: aload_1
    //   18: invokevirtual arrayOffset : ()I
    //   21: aload_1
    //   22: invokevirtual limit : ()I
    //   25: iadd
    //   26: istore #9
    //   28: aload_2
    //   29: invokevirtual array : ()[C
    //   32: astore #15
    //   34: aload_2
    //   35: invokevirtual arrayOffset : ()I
    //   38: aload_2
    //   39: invokevirtual position : ()I
    //   42: iadd
    //   43: istore #7
    //   45: aload_2
    //   46: invokevirtual arrayOffset : ()I
    //   49: aload_2
    //   50: invokevirtual limit : ()I
    //   53: iadd
    //   54: istore #10
    //   56: iload #9
    //   58: iload #5
    //   60: isub
    //   61: iload #10
    //   63: iload #7
    //   65: isub
    //   66: invokestatic min : (II)I
    //   69: istore #8
    //   71: iload #7
    //   73: istore_3
    //   74: iload_3
    //   75: istore #6
    //   77: iload #5
    //   79: istore_3
    //   80: iload #6
    //   82: istore #4
    //   84: iload #6
    //   86: iload #8
    //   88: iload #7
    //   90: iadd
    //   91: if_icmpge -> 134
    //   94: iload #5
    //   96: istore_3
    //   97: iload #6
    //   99: istore #4
    //   101: aload #14
    //   103: iload #5
    //   105: baload
    //   106: iflt -> 134
    //   109: aload #15
    //   111: iload #6
    //   113: aload #14
    //   115: iload #5
    //   117: baload
    //   118: i2c
    //   119: castore
    //   120: iload #6
    //   122: iconst_1
    //   123: iadd
    //   124: istore_3
    //   125: iload #5
    //   127: iconst_1
    //   128: iadd
    //   129: istore #5
    //   131: goto -> 74
    //   134: iload_3
    //   135: iload #9
    //   137: if_icmpge -> 757
    //   140: aload #14
    //   142: iload_3
    //   143: baload
    //   144: istore #11
    //   146: iload #11
    //   148: iflt -> 191
    //   151: iload #4
    //   153: iload #10
    //   155: if_icmplt -> 170
    //   158: aload_1
    //   159: iload_3
    //   160: iload #9
    //   162: aload_2
    //   163: iload #4
    //   165: iconst_1
    //   166: invokestatic xflow : (Ljava/nio/Buffer;IILjava/nio/Buffer;II)Ljava/nio/charset/CoderResult;
    //   169: areturn
    //   170: aload #15
    //   172: iload #4
    //   174: iload #11
    //   176: i2c
    //   177: castore
    //   178: iload_3
    //   179: iconst_1
    //   180: iadd
    //   181: istore_3
    //   182: iload #4
    //   184: iconst_1
    //   185: iadd
    //   186: istore #4
    //   188: goto -> 134
    //   191: iconst_1
    //   192: istore #7
    //   194: iconst_1
    //   195: istore #6
    //   197: iconst_1
    //   198: istore #8
    //   200: iload #11
    //   202: iconst_5
    //   203: ishr
    //   204: bipush #-2
    //   206: if_icmpne -> 331
    //   209: iload #9
    //   211: iload_3
    //   212: isub
    //   213: iconst_2
    //   214: if_icmplt -> 319
    //   217: iload #4
    //   219: iload #10
    //   221: if_icmplt -> 227
    //   224: goto -> 319
    //   227: aload #14
    //   229: iload_3
    //   230: iconst_1
    //   231: iadd
    //   232: baload
    //   233: istore #6
    //   235: iload #8
    //   237: istore #5
    //   239: iload #11
    //   241: bipush #30
    //   243: iand
    //   244: ifeq -> 269
    //   247: iload #6
    //   249: sipush #192
    //   252: iand
    //   253: sipush #128
    //   256: if_icmpeq -> 266
    //   259: iload #8
    //   261: istore #5
    //   263: goto -> 269
    //   266: iconst_0
    //   267: istore #5
    //   269: iload #5
    //   271: ifeq -> 284
    //   274: aload_1
    //   275: iload_3
    //   276: aload_2
    //   277: iload #4
    //   279: iconst_2
    //   280: invokestatic malformed : (Ljava/nio/ByteBuffer;ILjava/nio/CharBuffer;II)Ljava/nio/charset/CoderResult;
    //   283: areturn
    //   284: iload #4
    //   286: iconst_1
    //   287: iadd
    //   288: istore #5
    //   290: aload #15
    //   292: iload #4
    //   294: iload #11
    //   296: bipush #6
    //   298: ishl
    //   299: iload #6
    //   301: ixor
    //   302: sipush #3968
    //   305: ixor
    //   306: i2c
    //   307: castore
    //   308: iload_3
    //   309: iconst_2
    //   310: iadd
    //   311: istore_3
    //   312: iload #5
    //   314: istore #4
    //   316: goto -> 134
    //   319: aload_1
    //   320: iload_3
    //   321: iload #9
    //   323: aload_2
    //   324: iload #4
    //   326: iconst_2
    //   327: invokestatic xflow : (Ljava/nio/Buffer;IILjava/nio/Buffer;II)Ljava/nio/charset/CoderResult;
    //   330: areturn
    //   331: iload #11
    //   333: iconst_4
    //   334: ishr
    //   335: bipush #-2
    //   337: if_icmpne -> 503
    //   340: iload #9
    //   342: iload_3
    //   343: isub
    //   344: iconst_3
    //   345: if_icmplt -> 491
    //   348: iload #4
    //   350: iload #10
    //   352: if_icmplt -> 358
    //   355: goto -> 491
    //   358: aload #14
    //   360: iload_3
    //   361: iconst_1
    //   362: iadd
    //   363: baload
    //   364: istore #6
    //   366: aload #14
    //   368: iload_3
    //   369: iconst_2
    //   370: iadd
    //   371: baload
    //   372: istore #8
    //   374: iload #11
    //   376: bipush #-32
    //   378: if_icmpne -> 397
    //   381: iload #7
    //   383: istore #5
    //   385: iload #6
    //   387: sipush #224
    //   390: iand
    //   391: sipush #128
    //   394: if_icmpeq -> 435
    //   397: iload #7
    //   399: istore #5
    //   401: iload #6
    //   403: sipush #192
    //   406: iand
    //   407: sipush #128
    //   410: if_icmpne -> 435
    //   413: iload #8
    //   415: sipush #192
    //   418: iand
    //   419: sipush #128
    //   422: if_icmpeq -> 432
    //   425: iload #7
    //   427: istore #5
    //   429: goto -> 435
    //   432: iconst_0
    //   433: istore #5
    //   435: iload #5
    //   437: ifeq -> 450
    //   440: aload_1
    //   441: iload_3
    //   442: aload_2
    //   443: iload #4
    //   445: iconst_3
    //   446: invokestatic malformed : (Ljava/nio/ByteBuffer;ILjava/nio/CharBuffer;II)Ljava/nio/charset/CoderResult;
    //   449: areturn
    //   450: iload #4
    //   452: iconst_1
    //   453: iadd
    //   454: istore #5
    //   456: aload #15
    //   458: iload #4
    //   460: iload #11
    //   462: bipush #12
    //   464: ishl
    //   465: iload #6
    //   467: bipush #6
    //   469: ishl
    //   470: ixor
    //   471: iload #8
    //   473: ixor
    //   474: sipush #8064
    //   477: ixor
    //   478: i2c
    //   479: castore
    //   480: iload_3
    //   481: iconst_3
    //   482: iadd
    //   483: istore_3
    //   484: iload #5
    //   486: istore #4
    //   488: goto -> 316
    //   491: aload_1
    //   492: iload_3
    //   493: iload #9
    //   495: aload_2
    //   496: iload #4
    //   498: iconst_3
    //   499: invokestatic xflow : (Ljava/nio/Buffer;IILjava/nio/Buffer;II)Ljava/nio/charset/CoderResult;
    //   502: areturn
    //   503: iload #11
    //   505: iconst_3
    //   506: ishr
    //   507: bipush #-2
    //   509: if_icmpne -> 747
    //   512: iload #9
    //   514: iload_3
    //   515: isub
    //   516: iconst_4
    //   517: if_icmplt -> 735
    //   520: iload #10
    //   522: iload #4
    //   524: isub
    //   525: iconst_2
    //   526: if_icmpge -> 532
    //   529: goto -> 735
    //   532: aload #14
    //   534: iload_3
    //   535: iconst_1
    //   536: iadd
    //   537: baload
    //   538: istore #8
    //   540: aload #14
    //   542: iload_3
    //   543: iconst_2
    //   544: iadd
    //   545: baload
    //   546: istore #12
    //   548: aload #14
    //   550: iload_3
    //   551: iconst_3
    //   552: iadd
    //   553: baload
    //   554: istore #13
    //   556: iload #11
    //   558: bipush #7
    //   560: iand
    //   561: bipush #18
    //   563: ishl
    //   564: iload #8
    //   566: bipush #63
    //   568: iand
    //   569: bipush #12
    //   571: ishl
    //   572: ior
    //   573: iload #12
    //   575: bipush #63
    //   577: iand
    //   578: bipush #6
    //   580: ishl
    //   581: ior
    //   582: iload #13
    //   584: bipush #63
    //   586: iand
    //   587: ior
    //   588: istore #7
    //   590: iload #6
    //   592: istore #5
    //   594: iload #8
    //   596: sipush #192
    //   599: iand
    //   600: sipush #128
    //   603: if_icmpne -> 644
    //   606: iload #6
    //   608: istore #5
    //   610: iload #12
    //   612: sipush #192
    //   615: iand
    //   616: sipush #128
    //   619: if_icmpne -> 644
    //   622: iload #13
    //   624: sipush #192
    //   627: iand
    //   628: sipush #128
    //   631: if_icmpeq -> 641
    //   634: iload #6
    //   636: istore #5
    //   638: goto -> 644
    //   641: iconst_0
    //   642: istore #5
    //   644: iload #5
    //   646: ifne -> 725
    //   649: iload #7
    //   651: ldc 65536
    //   653: if_icmplt -> 725
    //   656: iload #7
    //   658: ldc 1114111
    //   660: if_icmple -> 666
    //   663: goto -> 725
    //   666: iload #4
    //   668: iconst_1
    //   669: iadd
    //   670: istore #5
    //   672: iload #7
    //   674: ldc 65536
    //   676: isub
    //   677: istore #6
    //   679: aload #15
    //   681: iload #4
    //   683: iload #6
    //   685: bipush #10
    //   687: ishr
    //   688: sipush #1023
    //   691: iand
    //   692: ldc 55296
    //   694: ior
    //   695: i2c
    //   696: castore
    //   697: iload #5
    //   699: iconst_1
    //   700: iadd
    //   701: istore #4
    //   703: aload #15
    //   705: iload #5
    //   707: iload #6
    //   709: sipush #1023
    //   712: iand
    //   713: ldc 56320
    //   715: ior
    //   716: i2c
    //   717: castore
    //   718: iload_3
    //   719: iconst_4
    //   720: iadd
    //   721: istore_3
    //   722: goto -> 134
    //   725: aload_1
    //   726: iload_3
    //   727: aload_2
    //   728: iload #4
    //   730: iconst_4
    //   731: invokestatic malformed : (Ljava/nio/ByteBuffer;ILjava/nio/CharBuffer;II)Ljava/nio/charset/CoderResult;
    //   734: areturn
    //   735: aload_1
    //   736: iload_3
    //   737: iload #9
    //   739: aload_2
    //   740: iload #4
    //   742: iconst_4
    //   743: invokestatic xflow : (Ljava/nio/Buffer;IILjava/nio/Buffer;II)Ljava/nio/charset/CoderResult;
    //   746: areturn
    //   747: aload_1
    //   748: iload_3
    //   749: aload_2
    //   750: iload #4
    //   752: iconst_1
    //   753: invokestatic malformed : (Ljava/nio/ByteBuffer;ILjava/nio/CharBuffer;II)Ljava/nio/charset/CoderResult;
    //   756: areturn
    //   757: aload_1
    //   758: iload_3
    //   759: iload #9
    //   761: aload_2
    //   762: iload #4
    //   764: iconst_0
    //   765: invokestatic xflow : (Ljava/nio/Buffer;IILjava/nio/Buffer;II)Ljava/nio/charset/CoderResult;
    //   768: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\UTF8Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */