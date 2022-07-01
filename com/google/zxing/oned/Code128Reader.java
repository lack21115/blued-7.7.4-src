package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class Code128Reader extends OneDReader {
  static final int[][] a;
  
  static {
    int[] arrayOfInt1 = { 2, 2, 2, 1, 2, 2 };
    int[] arrayOfInt2 = { 2, 2, 2, 2, 2, 1 };
    int[] arrayOfInt3 = { 1, 2, 1, 2, 2, 3 };
    int[] arrayOfInt4 = { 1, 3, 1, 2, 2, 2 };
    int[] arrayOfInt5 = { 1, 2, 2, 2, 1, 3 };
    int[] arrayOfInt6 = { 1, 2, 2, 3, 1, 2 };
    int[] arrayOfInt7 = { 2, 3, 1, 2, 1, 2 };
    int[] arrayOfInt8 = { 1, 1, 2, 2, 3, 2 };
    int[] arrayOfInt9 = { 1, 2, 2, 1, 3, 2 };
    int[] arrayOfInt10 = { 1, 2, 3, 1, 2, 2 };
    int[] arrayOfInt11 = { 2, 2, 3, 2, 1, 1 };
    int[] arrayOfInt12 = { 2, 2, 1, 1, 3, 2 };
    int[] arrayOfInt13 = { 2, 1, 3, 2, 1, 2 };
    int[] arrayOfInt14 = { 2, 2, 3, 1, 1, 2 };
    int[] arrayOfInt15 = { 3, 1, 2, 1, 3, 1 };
    int[] arrayOfInt16 = { 3, 1, 1, 2, 2, 2 };
    int[] arrayOfInt17 = { 3, 2, 1, 2, 2, 1 };
    int[] arrayOfInt18 = { 3, 1, 2, 2, 1, 2 };
    int[] arrayOfInt19 = { 2, 1, 2, 1, 2, 3 };
    int[] arrayOfInt20 = { 2, 1, 2, 3, 2, 1 };
    int[] arrayOfInt21 = { 1, 3, 1, 3, 2, 1 };
    int[] arrayOfInt22 = { 1, 1, 2, 3, 1, 3 };
    int[] arrayOfInt23 = { 1, 3, 2, 1, 1, 3 };
    int[] arrayOfInt24 = { 1, 3, 2, 3, 1, 1 };
    int[] arrayOfInt25 = { 2, 1, 1, 3, 1, 3 };
    int[] arrayOfInt26 = { 2, 3, 1, 3, 1, 1 };
    int[] arrayOfInt27 = { 1, 1, 2, 1, 3, 3 };
    int[] arrayOfInt28 = { 1, 1, 2, 3, 3, 1 };
    int[] arrayOfInt29 = { 1, 1, 3, 1, 2, 3 };
    int[] arrayOfInt30 = { 1, 1, 3, 3, 2, 1 };
    int[] arrayOfInt31 = { 3, 1, 3, 1, 2, 1 };
    int[] arrayOfInt32 = { 2, 1, 1, 3, 3, 1 };
    int[] arrayOfInt33 = { 3, 1, 1, 1, 2, 3 };
    int[] arrayOfInt34 = { 3, 1, 1, 3, 2, 1 };
    int[] arrayOfInt35 = { 3, 3, 1, 1, 2, 1 };
    int[] arrayOfInt36 = { 3, 1, 2, 1, 1, 3 };
    int[] arrayOfInt37 = { 3, 1, 2, 3, 1, 1 };
    int[] arrayOfInt38 = { 3, 1, 4, 1, 1, 1 };
    int[] arrayOfInt39 = { 2, 2, 1, 4, 1, 1 };
    int[] arrayOfInt40 = { 4, 3, 1, 1, 1, 1 };
    int[] arrayOfInt41 = { 1, 1, 1, 2, 2, 4 };
    int[] arrayOfInt42 = { 1, 1, 1, 4, 2, 2 };
    int[] arrayOfInt43 = { 1, 4, 1, 2, 2, 1 };
    int[] arrayOfInt44 = { 1, 1, 2, 4, 1, 2 };
    int[] arrayOfInt45 = { 1, 2, 2, 1, 1, 4 };
    int[] arrayOfInt46 = { 1, 2, 2, 4, 1, 1 };
    int[] arrayOfInt47 = { 1, 4, 2, 1, 1, 2 };
    int[] arrayOfInt48 = { 2, 4, 1, 2, 1, 1 };
    int[] arrayOfInt49 = { 2, 2, 1, 1, 1, 4 };
    int[] arrayOfInt50 = { 1, 2, 1, 1, 4, 2 };
    int[] arrayOfInt51 = { 1, 1, 4, 2, 1, 2 };
    int[] arrayOfInt52 = { 1, 2, 4, 1, 1, 2 };
    int[] arrayOfInt53 = { 1, 2, 4, 2, 1, 1 };
    int[] arrayOfInt54 = { 4, 2, 1, 1, 1, 2 };
    int[] arrayOfInt55 = { 4, 1, 2, 1, 2, 1 };
    int[] arrayOfInt56 = { 1, 1, 4, 1, 1, 3 };
    int[] arrayOfInt57 = { 1, 1, 4, 3, 1, 1 };
    int[] arrayOfInt58 = { 4, 1, 1, 1, 1, 3 };
    int[] arrayOfInt59 = { 1, 1, 3, 1, 4, 1 };
    int[] arrayOfInt60 = { 1, 1, 4, 1, 3, 1 };
    int[] arrayOfInt61 = { 2, 1, 1, 4, 1, 2 };
    int[] arrayOfInt62 = { 2, 1, 1, 2, 3, 2 };
    a = new int[][] { 
        { 2, 1, 2, 2, 2, 2 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, { 1, 2, 1, 3, 2, 2 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 1, 3, 2, 2, 1, 2 }, { 2, 2, 1, 2, 1, 3 }, 
        { 2, 2, 1, 3, 1, 2 }, arrayOfInt7, arrayOfInt8, arrayOfInt9, { 1, 2, 2, 2, 3, 1 }, { 1, 1, 3, 2, 2, 2 }, arrayOfInt10, { 1, 2, 3, 2, 2, 1 }, arrayOfInt11, arrayOfInt12, 
        { 2, 2, 1, 2, 3, 1 }, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, { 3, 2, 1, 1, 2, 2 }, arrayOfInt17, arrayOfInt18, { 3, 2, 2, 1, 1, 2 }, { 3, 2, 2, 2, 1, 1 }, 
        arrayOfInt19, arrayOfInt20, { 2, 3, 2, 1, 2, 1 }, { 1, 1, 1, 3, 2, 3 }, { 1, 3, 1, 1, 2, 3 }, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, 
        { 2, 3, 1, 1, 1, 3 }, arrayOfInt26, arrayOfInt27, arrayOfInt28, { 1, 3, 2, 1, 3, 1 }, arrayOfInt29, arrayOfInt30, { 1, 3, 3, 1, 2, 1 }, arrayOfInt31, arrayOfInt32, 
        { 2, 3, 1, 1, 3, 1 }, { 2, 1, 3, 1, 1, 3 }, { 2, 1, 3, 3, 1, 1 }, { 2, 1, 3, 1, 3, 1 }, arrayOfInt33, arrayOfInt34, arrayOfInt35, arrayOfInt36, arrayOfInt37, { 3, 3, 2, 1, 1, 1 }, 
        arrayOfInt38, arrayOfInt39, arrayOfInt40, arrayOfInt41, arrayOfInt42, { 1, 2, 1, 1, 2, 4 }, { 1, 2, 1, 4, 2, 1 }, { 1, 4, 1, 1, 2, 2 }, arrayOfInt43, { 1, 1, 2, 2, 1, 4 }, 
        arrayOfInt44, arrayOfInt45, arrayOfInt46, arrayOfInt47, { 1, 4, 2, 2, 1, 1 }, arrayOfInt48, arrayOfInt49, { 4, 1, 3, 1, 1, 1 }, { 2, 4, 1, 1, 1, 2 }, { 1, 3, 4, 1, 1, 1 }, 
        { 1, 1, 1, 2, 4, 2 }, arrayOfInt50, { 1, 2, 1, 2, 4, 1 }, arrayOfInt51, arrayOfInt52, arrayOfInt53, { 4, 1, 1, 2, 1, 2 }, arrayOfInt54, { 4, 2, 1, 2, 1, 1 }, { 2, 1, 2, 1, 4, 1 }, 
        { 2, 1, 4, 1, 2, 1 }, arrayOfInt55, { 1, 1, 1, 1, 4, 3 }, { 1, 1, 1, 3, 4, 1 }, { 1, 3, 1, 1, 4, 1 }, arrayOfInt56, arrayOfInt57, arrayOfInt58, { 4, 1, 1, 3, 1, 1 }, arrayOfInt59, 
        arrayOfInt60, { 3, 1, 1, 1, 4, 1 }, { 4, 1, 1, 1, 3, 1 }, arrayOfInt61, { 2, 1, 1, 2, 1, 4 }, arrayOfInt62, { 2, 3, 3, 1, 1, 1, 2 } };
  }
  
  private static int a(BitArray paramBitArray, int[] paramArrayOfint, int paramInt) throws NotFoundException {
    a(paramBitArray, paramInt, paramArrayOfint);
    float f = 0.25F;
    int i = -1;
    paramInt = 0;
    while (true) {
      int[][] arrayOfInt = a;
      if (paramInt < arrayOfInt.length) {
        float f2 = a(paramArrayOfint, arrayOfInt[paramInt], 0.7F);
        float f1 = f;
        if (f2 < f) {
          i = paramInt;
          f1 = f2;
        } 
        paramInt++;
        f = f1;
        continue;
      } 
      if (i >= 0)
        return i; 
      throw NotFoundException.a();
    } 
  }
  
  private static int[] a(BitArray paramBitArray) throws NotFoundException {
    int m = paramBitArray.a();
    int j = paramBitArray.c(0);
    int[] arrayOfInt = new int[6];
    int i = j;
    boolean bool = false;
    int k = 0;
    while (j < m) {
      int n;
      if (paramBitArray.a(j) != bool) {
        arrayOfInt[k] = arrayOfInt[k] + 1;
        n = i;
      } else {
        if (k == 5) {
          float f = 0.25F;
          n = 103;
          int i2 = -1;
          while (n <= 105) {
            float f2 = a(arrayOfInt, a[n], 0.7F);
            float f1 = f;
            if (f2 < f) {
              i2 = n;
              f1 = f2;
            } 
            n++;
            f = f1;
          } 
          if (i2 >= 0 && paramBitArray.a(Math.max(0, i - (j - i) / 2), i, false))
            return new int[] { i, j, i2 }; 
          n = i + arrayOfInt[0] + arrayOfInt[1];
          i = k - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i);
          arrayOfInt[i] = 0;
          arrayOfInt[k] = 0;
          i = k - 1;
        } else {
          k++;
          n = i;
          i = k;
        } 
        arrayOfInt[i] = 1;
        int i1 = bool ^ true;
        k = i;
      } 
      j++;
      i = n;
    } 
    throw NotFoundException.a();
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    // Byte code:
    //   0: aload_3
    //   1: ifnull -> 22
    //   4: aload_3
    //   5: getstatic com/google/zxing/DecodeHintType.h : Lcom/google/zxing/DecodeHintType;
    //   8: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   13: ifeq -> 22
    //   16: iconst_1
    //   17: istore #18
    //   19: goto -> 25
    //   22: iconst_0
    //   23: istore #18
    //   25: aload_2
    //   26: invokestatic a : (Lcom/google/zxing/common/BitArray;)[I
    //   29: astore #25
    //   31: aload #25
    //   33: iconst_2
    //   34: iaload
    //   35: istore #15
    //   37: new java/util/ArrayList
    //   40: dup
    //   41: bipush #20
    //   43: invokespecial <init> : (I)V
    //   46: astore_3
    //   47: aload_3
    //   48: iload #15
    //   50: i2b
    //   51: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   54: invokeinterface add : (Ljava/lang/Object;)Z
    //   59: pop
    //   60: iload #15
    //   62: tableswitch default -> 88, 103 -> 106, 104 -> 99, 105 -> 92
    //   88: invokestatic a : ()Lcom/google/zxing/FormatException;
    //   91: athrow
    //   92: bipush #99
    //   94: istore #8
    //   96: goto -> 110
    //   99: bipush #100
    //   101: istore #8
    //   103: goto -> 110
    //   106: bipush #101
    //   108: istore #8
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: bipush #20
    //   116: invokespecial <init> : (I)V
    //   119: astore #24
    //   121: aload #25
    //   123: iconst_0
    //   124: iaload
    //   125: istore #17
    //   127: aload #25
    //   129: iconst_1
    //   130: iaload
    //   131: istore #12
    //   133: bipush #6
    //   135: newarray int
    //   137: astore #26
    //   139: iload #8
    //   141: istore #10
    //   143: iconst_0
    //   144: istore #9
    //   146: iconst_0
    //   147: istore #11
    //   149: iconst_0
    //   150: istore #23
    //   152: iconst_0
    //   153: istore #14
    //   155: iconst_0
    //   156: istore #13
    //   158: iconst_0
    //   159: istore #16
    //   161: iconst_1
    //   162: istore #8
    //   164: iconst_0
    //   165: istore #19
    //   167: iload #13
    //   169: istore #20
    //   171: iload #11
    //   173: ifne -> 1217
    //   176: aload_2
    //   177: aload #26
    //   179: iload #12
    //   181: invokestatic a : (Lcom/google/zxing/common/BitArray;[II)I
    //   184: istore #23
    //   186: aload_3
    //   187: iload #23
    //   189: i2b
    //   190: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   193: invokeinterface add : (Ljava/lang/Object;)Z
    //   198: pop
    //   199: iload #23
    //   201: bipush #106
    //   203: if_icmpeq -> 209
    //   206: iconst_1
    //   207: istore #8
    //   209: iload #15
    //   211: istore #22
    //   213: iload #16
    //   215: istore #21
    //   217: iload #23
    //   219: bipush #106
    //   221: if_icmpeq -> 240
    //   224: iload #16
    //   226: iconst_1
    //   227: iadd
    //   228: istore #21
    //   230: iload #15
    //   232: iload #21
    //   234: iload #23
    //   236: imul
    //   237: iadd
    //   238: istore #22
    //   240: iload #12
    //   242: istore #15
    //   244: iconst_0
    //   245: istore #13
    //   247: iload #13
    //   249: bipush #6
    //   251: if_icmpge -> 273
    //   254: iload #15
    //   256: aload #26
    //   258: iload #13
    //   260: iaload
    //   261: iadd
    //   262: istore #15
    //   264: iload #13
    //   266: iconst_1
    //   267: iadd
    //   268: istore #13
    //   270: goto -> 247
    //   273: iload #23
    //   275: tableswitch default -> 300, 103 -> 335, 104 -> 335, 105 -> 335
    //   300: iload #10
    //   302: tableswitch default -> 328, 99 -> 956, 100 -> 626, 101 -> 339
    //   328: iload #8
    //   330: istore #13
    //   332: goto -> 1129
    //   335: invokestatic a : ()Lcom/google/zxing/FormatException;
    //   338: athrow
    //   339: iload #23
    //   341: bipush #64
    //   343: if_icmpge -> 387
    //   346: iload #9
    //   348: iload #14
    //   350: if_icmpne -> 368
    //   353: aload #24
    //   355: iload #23
    //   357: bipush #32
    //   359: iadd
    //   360: i2c
    //   361: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: goto -> 671
    //   368: aload #24
    //   370: iload #23
    //   372: bipush #32
    //   374: iadd
    //   375: sipush #128
    //   378: iadd
    //   379: i2c
    //   380: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: goto -> 671
    //   387: iload #23
    //   389: bipush #96
    //   391: if_icmpge -> 431
    //   394: iload #9
    //   396: iload #14
    //   398: if_icmpne -> 416
    //   401: aload #24
    //   403: iload #23
    //   405: bipush #64
    //   407: isub
    //   408: i2c
    //   409: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: goto -> 671
    //   416: aload #24
    //   418: iload #23
    //   420: bipush #64
    //   422: iadd
    //   423: i2c
    //   424: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: goto -> 671
    //   431: iload #23
    //   433: bipush #106
    //   435: if_icmpeq -> 441
    //   438: iconst_0
    //   439: istore #8
    //   441: iload #8
    //   443: istore #13
    //   445: iload #23
    //   447: bipush #106
    //   449: if_icmpeq -> 923
    //   452: iload #8
    //   454: istore #16
    //   456: iload #11
    //   458: istore #17
    //   460: iload #8
    //   462: istore #13
    //   464: iload #23
    //   466: tableswitch default -> 508, 96 -> 926, 97 -> 926, 98 -> 619, 99 -> 902, 100 -> 612, 101 -> 578, 102 -> 519
    //   508: iload #11
    //   510: istore #17
    //   512: iload #8
    //   514: istore #13
    //   516: goto -> 926
    //   519: iload #11
    //   521: istore #17
    //   523: iload #8
    //   525: istore #13
    //   527: iload #18
    //   529: ifeq -> 926
    //   532: aload #24
    //   534: invokevirtual length : ()I
    //   537: ifne -> 559
    //   540: aload #24
    //   542: ldc ']C1'
    //   544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: iload #11
    //   550: istore #17
    //   552: iload #8
    //   554: istore #13
    //   556: goto -> 926
    //   559: aload #24
    //   561: bipush #29
    //   563: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: iload #11
    //   569: istore #17
    //   571: iload #8
    //   573: istore #13
    //   575: goto -> 926
    //   578: iload #14
    //   580: ifne -> 591
    //   583: iload #9
    //   585: ifeq -> 591
    //   588: goto -> 851
    //   591: iload #8
    //   593: istore #16
    //   595: iload #14
    //   597: ifeq -> 881
    //   600: iload #8
    //   602: istore #16
    //   604: iload #9
    //   606: ifeq -> 881
    //   609: goto -> 875
    //   612: bipush #100
    //   614: istore #10
    //   616: goto -> 934
    //   619: bipush #100
    //   621: istore #10
    //   623: goto -> 917
    //   626: iload #23
    //   628: bipush #96
    //   630: if_icmpge -> 688
    //   633: iload #9
    //   635: iload #14
    //   637: if_icmpne -> 655
    //   640: aload #24
    //   642: iload #23
    //   644: bipush #32
    //   646: iadd
    //   647: i2c
    //   648: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: goto -> 671
    //   655: aload #24
    //   657: iload #23
    //   659: bipush #32
    //   661: iadd
    //   662: sipush #128
    //   665: iadd
    //   666: i2c
    //   667: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: iconst_0
    //   672: istore #9
    //   674: iconst_0
    //   675: istore #16
    //   677: iload #10
    //   679: istore #13
    //   681: iload #16
    //   683: istore #10
    //   685: goto -> 1148
    //   688: iload #23
    //   690: bipush #106
    //   692: if_icmpeq -> 698
    //   695: iconst_0
    //   696: istore #8
    //   698: iload #8
    //   700: istore #13
    //   702: iload #23
    //   704: bipush #106
    //   706: if_icmpeq -> 923
    //   709: iload #8
    //   711: istore #16
    //   713: iload #11
    //   715: istore #17
    //   717: iload #8
    //   719: istore #13
    //   721: iload #23
    //   723: tableswitch default -> 764, 96 -> 926, 97 -> 926, 98 -> 913, 99 -> 902, 100 -> 841, 101 -> 834, 102 -> 775
    //   764: iload #11
    //   766: istore #17
    //   768: iload #8
    //   770: istore #13
    //   772: goto -> 926
    //   775: iload #11
    //   777: istore #17
    //   779: iload #8
    //   781: istore #13
    //   783: iload #18
    //   785: ifeq -> 926
    //   788: aload #24
    //   790: invokevirtual length : ()I
    //   793: ifne -> 815
    //   796: aload #24
    //   798: ldc ']C1'
    //   800: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: iload #11
    //   806: istore #17
    //   808: iload #8
    //   810: istore #13
    //   812: goto -> 926
    //   815: aload #24
    //   817: bipush #29
    //   819: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: iload #11
    //   825: istore #17
    //   827: iload #8
    //   829: istore #13
    //   831: goto -> 926
    //   834: bipush #101
    //   836: istore #10
    //   838: goto -> 934
    //   841: iload #14
    //   843: ifne -> 857
    //   846: iload #9
    //   848: ifeq -> 857
    //   851: iconst_1
    //   852: istore #14
    //   854: goto -> 671
    //   857: iload #8
    //   859: istore #16
    //   861: iload #14
    //   863: ifeq -> 881
    //   866: iload #8
    //   868: istore #16
    //   870: iload #9
    //   872: ifeq -> 881
    //   875: iconst_0
    //   876: istore #14
    //   878: goto -> 671
    //   881: iconst_0
    //   882: istore #9
    //   884: iconst_1
    //   885: istore #8
    //   887: iload #10
    //   889: istore #13
    //   891: iload #8
    //   893: istore #10
    //   895: iload #16
    //   897: istore #8
    //   899: goto -> 1148
    //   902: bipush #99
    //   904: istore #10
    //   906: iload #16
    //   908: istore #8
    //   910: goto -> 934
    //   913: bipush #101
    //   915: istore #10
    //   917: iconst_1
    //   918: istore #16
    //   920: goto -> 937
    //   923: iconst_1
    //   924: istore #17
    //   926: iload #13
    //   928: istore #8
    //   930: iload #17
    //   932: istore #11
    //   934: iconst_0
    //   935: istore #16
    //   937: iload #9
    //   939: istore #17
    //   941: iload #10
    //   943: istore #13
    //   945: iload #16
    //   947: istore #9
    //   949: iload #17
    //   951: istore #10
    //   953: goto -> 1148
    //   956: iload #23
    //   958: bipush #100
    //   960: if_icmpge -> 993
    //   963: iload #23
    //   965: bipush #10
    //   967: if_icmpge -> 978
    //   970: aload #24
    //   972: bipush #48
    //   974: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload #24
    //   980: iload #23
    //   982: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: iload #8
    //   988: istore #13
    //   990: goto -> 1129
    //   993: iload #23
    //   995: bipush #106
    //   997: if_icmpeq -> 1003
    //   1000: iconst_0
    //   1001: istore #8
    //   1003: iload #23
    //   1005: bipush #106
    //   1007: if_icmpeq -> 1108
    //   1010: iload #23
    //   1012: tableswitch default -> 1040, 100 -> 1101, 101 -> 1094, 102 -> 1047
    //   1040: iload #8
    //   1042: istore #13
    //   1044: goto -> 1129
    //   1047: iload #8
    //   1049: istore #13
    //   1051: iload #18
    //   1053: ifeq -> 1129
    //   1056: aload #24
    //   1058: invokevirtual length : ()I
    //   1061: ifne -> 1079
    //   1064: aload #24
    //   1066: ldc ']C1'
    //   1068: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: iload #8
    //   1074: istore #13
    //   1076: goto -> 1129
    //   1079: aload #24
    //   1081: bipush #29
    //   1083: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: iload #8
    //   1089: istore #13
    //   1091: goto -> 1129
    //   1094: bipush #101
    //   1096: istore #13
    //   1098: goto -> 1137
    //   1101: bipush #100
    //   1103: istore #13
    //   1105: goto -> 1137
    //   1108: iload #9
    //   1110: istore #16
    //   1112: iconst_0
    //   1113: istore #9
    //   1115: iconst_1
    //   1116: istore #11
    //   1118: iload #10
    //   1120: istore #13
    //   1122: iload #16
    //   1124: istore #10
    //   1126: goto -> 1148
    //   1129: iload #13
    //   1131: istore #8
    //   1133: iload #10
    //   1135: istore #13
    //   1137: iconst_0
    //   1138: istore #16
    //   1140: iload #9
    //   1142: istore #10
    //   1144: iload #16
    //   1146: istore #9
    //   1148: iload #19
    //   1150: ifeq -> 1174
    //   1153: iload #13
    //   1155: bipush #101
    //   1157: if_icmpne -> 1167
    //   1160: bipush #100
    //   1162: istore #13
    //   1164: goto -> 1174
    //   1167: bipush #101
    //   1169: istore #13
    //   1171: goto -> 1174
    //   1174: iload #9
    //   1176: istore #19
    //   1178: iload #10
    //   1180: istore #9
    //   1182: iload #12
    //   1184: istore #17
    //   1186: iload #15
    //   1188: istore #12
    //   1190: iload #23
    //   1192: istore #15
    //   1194: iload #13
    //   1196: istore #10
    //   1198: iload #20
    //   1200: istore #23
    //   1202: iload #15
    //   1204: istore #13
    //   1206: iload #22
    //   1208: istore #15
    //   1210: iload #21
    //   1212: istore #16
    //   1214: goto -> 167
    //   1217: aload_2
    //   1218: iload #12
    //   1220: invokevirtual d : (I)I
    //   1223: istore #9
    //   1225: aload_2
    //   1226: iload #9
    //   1228: aload_2
    //   1229: invokevirtual a : ()I
    //   1232: iload #9
    //   1234: iload #17
    //   1236: isub
    //   1237: iconst_2
    //   1238: idiv
    //   1239: iload #9
    //   1241: iadd
    //   1242: invokestatic min : (II)I
    //   1245: iconst_0
    //   1246: invokevirtual a : (IIZ)Z
    //   1249: ifeq -> 1481
    //   1252: iload #15
    //   1254: iload #16
    //   1256: iload #23
    //   1258: imul
    //   1259: isub
    //   1260: bipush #103
    //   1262: irem
    //   1263: iload #23
    //   1265: if_icmpne -> 1477
    //   1268: aload #24
    //   1270: invokevirtual length : ()I
    //   1273: istore #9
    //   1275: iload #9
    //   1277: ifeq -> 1473
    //   1280: iload #9
    //   1282: ifle -> 1324
    //   1285: iload #8
    //   1287: ifeq -> 1324
    //   1290: iload #10
    //   1292: bipush #99
    //   1294: if_icmpne -> 1312
    //   1297: aload #24
    //   1299: iload #9
    //   1301: iconst_2
    //   1302: isub
    //   1303: iload #9
    //   1305: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1308: pop
    //   1309: goto -> 1324
    //   1312: aload #24
    //   1314: iload #9
    //   1316: iconst_1
    //   1317: isub
    //   1318: iload #9
    //   1320: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload #25
    //   1326: iconst_1
    //   1327: iaload
    //   1328: aload #25
    //   1330: iconst_0
    //   1331: iaload
    //   1332: iadd
    //   1333: i2f
    //   1334: fconst_2
    //   1335: fdiv
    //   1336: fstore #4
    //   1338: iload #17
    //   1340: i2f
    //   1341: fstore #5
    //   1343: iload #12
    //   1345: iload #17
    //   1347: isub
    //   1348: i2f
    //   1349: fconst_2
    //   1350: fdiv
    //   1351: fstore #6
    //   1353: aload_3
    //   1354: invokeinterface size : ()I
    //   1359: istore #9
    //   1361: iload #9
    //   1363: newarray byte
    //   1365: astore_2
    //   1366: iconst_0
    //   1367: istore #8
    //   1369: iload #8
    //   1371: iload #9
    //   1373: if_icmpge -> 1403
    //   1376: aload_2
    //   1377: iload #8
    //   1379: aload_3
    //   1380: iload #8
    //   1382: invokeinterface get : (I)Ljava/lang/Object;
    //   1387: checkcast java/lang/Byte
    //   1390: invokevirtual byteValue : ()B
    //   1393: bastore
    //   1394: iload #8
    //   1396: iconst_1
    //   1397: iadd
    //   1398: istore #8
    //   1400: goto -> 1369
    //   1403: aload #24
    //   1405: invokevirtual toString : ()Ljava/lang/String;
    //   1408: astore_3
    //   1409: iload_1
    //   1410: i2f
    //   1411: fstore #7
    //   1413: new com/google/zxing/ResultPoint
    //   1416: dup
    //   1417: fload #4
    //   1419: fload #7
    //   1421: invokespecial <init> : (FF)V
    //   1424: astore #24
    //   1426: new com/google/zxing/ResultPoint
    //   1429: dup
    //   1430: fload #5
    //   1432: fload #6
    //   1434: fadd
    //   1435: fload #7
    //   1437: invokespecial <init> : (FF)V
    //   1440: astore #25
    //   1442: getstatic com/google/zxing/BarcodeFormat.e : Lcom/google/zxing/BarcodeFormat;
    //   1445: astore #26
    //   1447: new com/google/zxing/Result
    //   1450: dup
    //   1451: aload_3
    //   1452: aload_2
    //   1453: iconst_2
    //   1454: anewarray com/google/zxing/ResultPoint
    //   1457: dup
    //   1458: iconst_0
    //   1459: aload #24
    //   1461: aastore
    //   1462: dup
    //   1463: iconst_1
    //   1464: aload #25
    //   1466: aastore
    //   1467: aload #26
    //   1469: invokespecial <init> : (Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V
    //   1472: areturn
    //   1473: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   1476: athrow
    //   1477: invokestatic a : ()Lcom/google/zxing/ChecksumException;
    //   1480: athrow
    //   1481: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   1484: athrow
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\Code128Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */