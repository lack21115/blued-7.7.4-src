package com.tencent.tbs.patch.common.util;

import java.io.UnsupportedEncodingException;

public class Base64 {
  public static final int CRLF = 4;
  
  public static final int DEFAULT = 0;
  
  public static final int NO_CLOSE = 16;
  
  public static final int NO_PADDING = 1;
  
  public static final int NO_WRAP = 2;
  
  public static final int URL_SAFE = 8;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static byte[] decode(String paramString, int paramInt) {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt) {
    return decode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    b b = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (b.a(paramArrayOfbyte, paramInt1, paramInt2, true)) {
      if (b.b == b.a.length)
        return b.a; 
      paramArrayOfbyte = new byte[b.b];
      System.arraycopy(b.a, 0, paramArrayOfbyte, 0, b.b);
      return paramArrayOfbyte;
    } 
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] encode(byte[] paramArrayOfbyte, int paramInt) {
    return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    c c = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    if (c.d) {
      paramInt3 = i;
      if (paramInt2 % 3 > 0)
        paramInt3 = i + 4; 
    } else {
      paramInt3 = i;
      switch (paramInt2 % 3) {
        default:
          paramInt3 = i;
          break;
        case 2:
          paramInt3 = i + 3;
          break;
        case 1:
          paramInt3 = i + 2;
          break;
        case 0:
          break;
      } 
    } 
    i = paramInt3;
    if (c.e) {
      i = paramInt3;
      if (paramInt2 > 0) {
        int j = (paramInt2 - 1) / 57;
        if (c.f) {
          i = 2;
        } else {
          i = 1;
        } 
        i = paramInt3 + (j + 1) * i;
      } 
    } 
    c.a = new byte[i];
    c.a(paramArrayOfbyte, paramInt1, paramInt2, true);
    if (a || c.b == i)
      return c.a; 
    throw new AssertionError();
  }
  
  public static String encodeToString(byte[] paramArrayOfbyte, int paramInt) {
    try {
      return new String(encode(paramArrayOfbyte, paramInt), "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  public static String encodeToString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    try {
      return new String(encode(paramArrayOfbyte, paramInt1, paramInt2, paramInt3), "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  static abstract class a {
    public byte[] a;
    
    public int b;
  }
  
  static class b extends a {
    private static final int[] c = new int[] { 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1 };
    
    private static final int[] d = new int[] { 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1 };
    
    private int e;
    
    private int f;
    
    private final int[] g;
    
    static {
      throw new VerifyError("bad dex opcode");
    }
    
    public b(int param1Int, byte[] param1ArrayOfbyte) {
      int[] arrayOfInt;
      this.a = param1ArrayOfbyte;
      if ((param1Int & 0x8) == 0) {
        arrayOfInt = c;
      } else {
        arrayOfInt = d;
      } 
      this.g = arrayOfInt;
      this.e = 0;
      this.f = 0;
    }
    
    public boolean a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield e : I
      //   4: istore #8
      //   6: iload #8
      //   8: bipush #6
      //   10: if_icmpne -> 15
      //   13: iconst_0
      //   14: ireturn
      //   15: iload_3
      //   16: iload_2
      //   17: iadd
      //   18: istore #11
      //   20: aload_0
      //   21: getfield f : I
      //   24: istore #6
      //   26: aload_0
      //   27: getfield a : [B
      //   30: astore #12
      //   32: aload_0
      //   33: getfield g : [I
      //   36: astore #13
      //   38: iconst_0
      //   39: istore_3
      //   40: iload_2
      //   41: istore #5
      //   43: iload #6
      //   45: istore_2
      //   46: iload_2
      //   47: istore #7
      //   49: iload_3
      //   50: istore #6
      //   52: iload #5
      //   54: iload #11
      //   56: if_icmpge -> 665
      //   59: iload_2
      //   60: istore #7
      //   62: iload_3
      //   63: istore #6
      //   65: iload #5
      //   67: istore #9
      //   69: iload #8
      //   71: ifne -> 230
      //   74: iload #5
      //   76: iconst_4
      //   77: iadd
      //   78: istore #7
      //   80: iload #7
      //   82: iload #11
      //   84: if_icmpgt -> 204
      //   87: aload #13
      //   89: aload_1
      //   90: iload #5
      //   92: baload
      //   93: sipush #255
      //   96: iand
      //   97: iaload
      //   98: bipush #18
      //   100: ishl
      //   101: aload #13
      //   103: aload_1
      //   104: iload #5
      //   106: iconst_1
      //   107: iadd
      //   108: baload
      //   109: sipush #255
      //   112: iand
      //   113: iaload
      //   114: bipush #12
      //   116: ishl
      //   117: ior
      //   118: aload #13
      //   120: aload_1
      //   121: iload #5
      //   123: iconst_2
      //   124: iadd
      //   125: baload
      //   126: sipush #255
      //   129: iand
      //   130: iaload
      //   131: bipush #6
      //   133: ishl
      //   134: ior
      //   135: aload #13
      //   137: aload_1
      //   138: iload #5
      //   140: iconst_3
      //   141: iadd
      //   142: baload
      //   143: sipush #255
      //   146: iand
      //   147: iaload
      //   148: ior
      //   149: istore #6
      //   151: iload #6
      //   153: istore_2
      //   154: iload #6
      //   156: iflt -> 204
      //   159: aload #12
      //   161: iload_3
      //   162: iconst_2
      //   163: iadd
      //   164: iload #6
      //   166: i2b
      //   167: bastore
      //   168: aload #12
      //   170: iload_3
      //   171: iconst_1
      //   172: iadd
      //   173: iload #6
      //   175: bipush #8
      //   177: ishr
      //   178: i2b
      //   179: bastore
      //   180: aload #12
      //   182: iload_3
      //   183: iload #6
      //   185: bipush #16
      //   187: ishr
      //   188: i2b
      //   189: bastore
      //   190: iload_3
      //   191: iconst_3
      //   192: iadd
      //   193: istore_3
      //   194: iload #7
      //   196: istore #5
      //   198: iload #6
      //   200: istore_2
      //   201: goto -> 74
      //   204: iload_2
      //   205: istore #7
      //   207: iload_3
      //   208: istore #6
      //   210: iload #5
      //   212: istore #9
      //   214: iload #5
      //   216: iload #11
      //   218: if_icmplt -> 230
      //   221: iload_2
      //   222: istore #7
      //   224: iload_3
      //   225: istore #6
      //   227: goto -> 665
      //   230: aload #13
      //   232: aload_1
      //   233: iload #9
      //   235: baload
      //   236: sipush #255
      //   239: iand
      //   240: iaload
      //   241: istore #10
      //   243: iload #8
      //   245: tableswitch default -> 284, 0 -> 598, 1 -> 557, 2 -> 494, 3 -> 367, 4 -> 321, 5 -> 297
      //   284: iload #8
      //   286: istore_2
      //   287: iload #7
      //   289: istore #5
      //   291: iload #6
      //   293: istore_3
      //   294: goto -> 646
      //   297: iload #8
      //   299: istore_2
      //   300: iload #7
      //   302: istore #5
      //   304: iload #6
      //   306: istore_3
      //   307: iload #10
      //   309: iconst_m1
      //   310: if_icmpeq -> 646
      //   313: aload_0
      //   314: bipush #6
      //   316: putfield e : I
      //   319: iconst_0
      //   320: ireturn
      //   321: iload #10
      //   323: bipush #-2
      //   325: if_icmpne -> 343
      //   328: iload #8
      //   330: iconst_1
      //   331: iadd
      //   332: istore_2
      //   333: iload #7
      //   335: istore #5
      //   337: iload #6
      //   339: istore_3
      //   340: goto -> 646
      //   343: iload #8
      //   345: istore_2
      //   346: iload #7
      //   348: istore #5
      //   350: iload #6
      //   352: istore_3
      //   353: iload #10
      //   355: iconst_m1
      //   356: if_icmpeq -> 646
      //   359: aload_0
      //   360: bipush #6
      //   362: putfield e : I
      //   365: iconst_0
      //   366: ireturn
      //   367: iload #10
      //   369: iflt -> 426
      //   372: iload #10
      //   374: iload #7
      //   376: bipush #6
      //   378: ishl
      //   379: ior
      //   380: istore #5
      //   382: aload #12
      //   384: iload #6
      //   386: iconst_2
      //   387: iadd
      //   388: iload #5
      //   390: i2b
      //   391: bastore
      //   392: aload #12
      //   394: iload #6
      //   396: iconst_1
      //   397: iadd
      //   398: iload #5
      //   400: bipush #8
      //   402: ishr
      //   403: i2b
      //   404: bastore
      //   405: aload #12
      //   407: iload #6
      //   409: iload #5
      //   411: bipush #16
      //   413: ishr
      //   414: i2b
      //   415: bastore
      //   416: iload #6
      //   418: iconst_3
      //   419: iadd
      //   420: istore_3
      //   421: iconst_0
      //   422: istore_2
      //   423: goto -> 646
      //   426: iload #10
      //   428: bipush #-2
      //   430: if_icmpne -> 470
      //   433: aload #12
      //   435: iload #6
      //   437: iconst_1
      //   438: iadd
      //   439: iload #7
      //   441: iconst_2
      //   442: ishr
      //   443: i2b
      //   444: bastore
      //   445: aload #12
      //   447: iload #6
      //   449: iload #7
      //   451: bipush #10
      //   453: ishr
      //   454: i2b
      //   455: bastore
      //   456: iload #6
      //   458: iconst_2
      //   459: iadd
      //   460: istore_3
      //   461: iconst_5
      //   462: istore_2
      //   463: iload #7
      //   465: istore #5
      //   467: goto -> 646
      //   470: iload #8
      //   472: istore_2
      //   473: iload #7
      //   475: istore #5
      //   477: iload #6
      //   479: istore_3
      //   480: iload #10
      //   482: iconst_m1
      //   483: if_icmpeq -> 646
      //   486: aload_0
      //   487: bipush #6
      //   489: putfield e : I
      //   492: iconst_0
      //   493: ireturn
      //   494: iload #10
      //   496: iflt -> 502
      //   499: goto -> 562
      //   502: iload #10
      //   504: bipush #-2
      //   506: if_icmpne -> 533
      //   509: aload #12
      //   511: iload #6
      //   513: iload #7
      //   515: iconst_4
      //   516: ishr
      //   517: i2b
      //   518: bastore
      //   519: iload #6
      //   521: iconst_1
      //   522: iadd
      //   523: istore_3
      //   524: iconst_4
      //   525: istore_2
      //   526: iload #7
      //   528: istore #5
      //   530: goto -> 646
      //   533: iload #8
      //   535: istore_2
      //   536: iload #7
      //   538: istore #5
      //   540: iload #6
      //   542: istore_3
      //   543: iload #10
      //   545: iconst_m1
      //   546: if_icmpeq -> 646
      //   549: aload_0
      //   550: bipush #6
      //   552: putfield e : I
      //   555: iconst_0
      //   556: ireturn
      //   557: iload #10
      //   559: iflt -> 574
      //   562: iload #10
      //   564: iload #7
      //   566: bipush #6
      //   568: ishl
      //   569: ior
      //   570: istore_2
      //   571: goto -> 606
      //   574: iload #8
      //   576: istore_2
      //   577: iload #7
      //   579: istore #5
      //   581: iload #6
      //   583: istore_3
      //   584: iload #10
      //   586: iconst_m1
      //   587: if_icmpeq -> 646
      //   590: aload_0
      //   591: bipush #6
      //   593: putfield e : I
      //   596: iconst_0
      //   597: ireturn
      //   598: iload #10
      //   600: iflt -> 622
      //   603: iload #10
      //   605: istore_2
      //   606: iload #8
      //   608: iconst_1
      //   609: iadd
      //   610: istore_3
      //   611: iload_2
      //   612: istore #5
      //   614: iload_3
      //   615: istore_2
      //   616: iload #6
      //   618: istore_3
      //   619: goto -> 646
      //   622: iload #8
      //   624: istore_2
      //   625: iload #7
      //   627: istore #5
      //   629: iload #6
      //   631: istore_3
      //   632: iload #10
      //   634: iconst_m1
      //   635: if_icmpeq -> 646
      //   638: aload_0
      //   639: bipush #6
      //   641: putfield e : I
      //   644: iconst_0
      //   645: ireturn
      //   646: iload #9
      //   648: iconst_1
      //   649: iadd
      //   650: istore #6
      //   652: iload_2
      //   653: istore #8
      //   655: iload #5
      //   657: istore_2
      //   658: iload #6
      //   660: istore #5
      //   662: goto -> 46
      //   665: iload #4
      //   667: ifne -> 692
      //   670: aload_0
      //   671: iload #8
      //   673: putfield e : I
      //   676: aload_0
      //   677: iload #7
      //   679: putfield f : I
      //   682: iload #6
      //   684: istore_2
      //   685: aload_0
      //   686: iload_2
      //   687: putfield b : I
      //   690: iconst_1
      //   691: ireturn
      //   692: iload #6
      //   694: istore_2
      //   695: iload #8
      //   697: tableswitch default -> 736, 0 -> 808, 1 -> 800, 2 -> 782, 3 -> 750, 4 -> 742, 5 -> 808
      //   736: iload #6
      //   738: istore_2
      //   739: goto -> 808
      //   742: aload_0
      //   743: bipush #6
      //   745: putfield e : I
      //   748: iconst_0
      //   749: ireturn
      //   750: iload #6
      //   752: iconst_1
      //   753: iadd
      //   754: istore_3
      //   755: aload #12
      //   757: iload #6
      //   759: iload #7
      //   761: bipush #10
      //   763: ishr
      //   764: i2b
      //   765: bastore
      //   766: iload_3
      //   767: iconst_1
      //   768: iadd
      //   769: istore_2
      //   770: aload #12
      //   772: iload_3
      //   773: iload #7
      //   775: iconst_2
      //   776: ishr
      //   777: i2b
      //   778: bastore
      //   779: goto -> 808
      //   782: aload #12
      //   784: iload #6
      //   786: iload #7
      //   788: iconst_4
      //   789: ishr
      //   790: i2b
      //   791: bastore
      //   792: iload #6
      //   794: iconst_1
      //   795: iadd
      //   796: istore_2
      //   797: goto -> 808
      //   800: aload_0
      //   801: bipush #6
      //   803: putfield e : I
      //   806: iconst_0
      //   807: ireturn
      //   808: aload_0
      //   809: iload #8
      //   811: putfield e : I
      //   814: goto -> 685
    }
  }
  
  static class c extends a {
    private static final byte[] h;
    
    private static final byte[] i;
    
    int c;
    
    public final boolean d;
    
    public final boolean e;
    
    public final boolean f;
    
    private final byte[] j;
    
    private int k;
    
    private final byte[] l;
    
    static {
      throw new VerifyError("bad dex opcode");
    }
    
    public c(int param1Int, byte[] param1ArrayOfbyte) {
      boolean bool1;
      this.a = param1ArrayOfbyte;
      boolean bool2 = true;
      if ((param1Int & 0x1) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.d = bool1;
      if ((param1Int & 0x2) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.e = bool1;
      if ((param1Int & 0x4) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.f = bool1;
      if ((param1Int & 0x8) == 0) {
        param1ArrayOfbyte = h;
      } else {
        param1ArrayOfbyte = i;
      } 
      this.l = param1ArrayOfbyte;
      this.j = new byte[2];
      this.c = 0;
      if (this.e) {
        param1Int = 19;
      } else {
        param1Int = -1;
      } 
      this.k = param1Int;
    }
    
    public boolean a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield l : [B
      //   4: astore #11
      //   6: aload_0
      //   7: getfield a : [B
      //   10: astore #12
      //   12: aload_0
      //   13: getfield k : I
      //   16: istore #6
      //   18: iload_3
      //   19: iload_2
      //   20: iadd
      //   21: istore #10
      //   23: aload_0
      //   24: getfield c : I
      //   27: istore_3
      //   28: iconst_0
      //   29: istore #9
      //   31: iconst_0
      //   32: istore #8
      //   34: iload_3
      //   35: tableswitch default -> 60, 0 -> 195, 1 -> 129, 2 -> 63
      //   60: goto -> 195
      //   63: iload_2
      //   64: iconst_1
      //   65: iadd
      //   66: istore_3
      //   67: iload_3
      //   68: iload #10
      //   70: if_icmpgt -> 195
      //   73: aload_0
      //   74: getfield j : [B
      //   77: astore #13
      //   79: aload #13
      //   81: iconst_0
      //   82: baload
      //   83: istore #5
      //   85: aload #13
      //   87: iconst_1
      //   88: baload
      //   89: istore #7
      //   91: aload_1
      //   92: iload_2
      //   93: baload
      //   94: istore_2
      //   95: aload_0
      //   96: iconst_0
      //   97: putfield c : I
      //   100: iload #7
      //   102: sipush #255
      //   105: iand
      //   106: bipush #8
      //   108: ishl
      //   109: iload #5
      //   111: sipush #255
      //   114: iand
      //   115: bipush #16
      //   117: ishl
      //   118: ior
      //   119: iload_2
      //   120: sipush #255
      //   123: iand
      //   124: ior
      //   125: istore_2
      //   126: goto -> 203
      //   129: iload_2
      //   130: iconst_2
      //   131: iadd
      //   132: iload #10
      //   134: if_icmpgt -> 195
      //   137: aload_0
      //   138: getfield j : [B
      //   141: iconst_0
      //   142: baload
      //   143: istore #5
      //   145: iload_2
      //   146: iconst_1
      //   147: iadd
      //   148: istore #7
      //   150: aload_1
      //   151: iload_2
      //   152: baload
      //   153: istore_2
      //   154: iload #7
      //   156: iconst_1
      //   157: iadd
      //   158: istore_3
      //   159: iload #5
      //   161: sipush #255
      //   164: iand
      //   165: bipush #16
      //   167: ishl
      //   168: iload_2
      //   169: sipush #255
      //   172: iand
      //   173: bipush #8
      //   175: ishl
      //   176: ior
      //   177: aload_1
      //   178: iload #7
      //   180: baload
      //   181: sipush #255
      //   184: iand
      //   185: ior
      //   186: istore_2
      //   187: aload_0
      //   188: iconst_0
      //   189: putfield c : I
      //   192: goto -> 203
      //   195: iconst_m1
      //   196: istore #5
      //   198: iload_2
      //   199: istore_3
      //   200: iload #5
      //   202: istore_2
      //   203: iload_2
      //   204: iconst_m1
      //   205: if_icmpeq -> 318
      //   208: aload #12
      //   210: iconst_0
      //   211: aload #11
      //   213: iload_2
      //   214: bipush #18
      //   216: ishr
      //   217: bipush #63
      //   219: iand
      //   220: baload
      //   221: bastore
      //   222: aload #12
      //   224: iconst_1
      //   225: aload #11
      //   227: iload_2
      //   228: bipush #12
      //   230: ishr
      //   231: bipush #63
      //   233: iand
      //   234: baload
      //   235: bastore
      //   236: aload #12
      //   238: iconst_2
      //   239: aload #11
      //   241: iload_2
      //   242: bipush #6
      //   244: ishr
      //   245: bipush #63
      //   247: iand
      //   248: baload
      //   249: bastore
      //   250: aload #12
      //   252: iconst_3
      //   253: aload #11
      //   255: iload_2
      //   256: bipush #63
      //   258: iand
      //   259: baload
      //   260: bastore
      //   261: iload #6
      //   263: iconst_1
      //   264: isub
      //   265: istore #6
      //   267: iload #6
      //   269: ifne -> 313
      //   272: aload_0
      //   273: getfield f : Z
      //   276: ifeq -> 290
      //   279: iconst_5
      //   280: istore_2
      //   281: aload #12
      //   283: iconst_4
      //   284: bipush #13
      //   286: bastore
      //   287: goto -> 292
      //   290: iconst_4
      //   291: istore_2
      //   292: iload_2
      //   293: iconst_1
      //   294: iadd
      //   295: istore #5
      //   297: aload #12
      //   299: iload_2
      //   300: bipush #10
      //   302: bastore
      //   303: iload #5
      //   305: istore_2
      //   306: bipush #19
      //   308: istore #6
      //   310: goto -> 320
      //   313: iconst_4
      //   314: istore_2
      //   315: goto -> 320
      //   318: iconst_0
      //   319: istore_2
      //   320: iload_3
      //   321: iconst_3
      //   322: iadd
      //   323: istore #5
      //   325: iload #5
      //   327: iload #10
      //   329: if_icmpgt -> 492
      //   332: aload_1
      //   333: iload_3
      //   334: baload
      //   335: istore #7
      //   337: aload_1
      //   338: iload_3
      //   339: iconst_1
      //   340: iadd
      //   341: baload
      //   342: sipush #255
      //   345: iand
      //   346: bipush #8
      //   348: ishl
      //   349: iload #7
      //   351: sipush #255
      //   354: iand
      //   355: bipush #16
      //   357: ishl
      //   358: ior
      //   359: aload_1
      //   360: iload_3
      //   361: iconst_2
      //   362: iadd
      //   363: baload
      //   364: sipush #255
      //   367: iand
      //   368: ior
      //   369: istore_3
      //   370: aload #12
      //   372: iload_2
      //   373: aload #11
      //   375: iload_3
      //   376: bipush #18
      //   378: ishr
      //   379: bipush #63
      //   381: iand
      //   382: baload
      //   383: bastore
      //   384: aload #12
      //   386: iload_2
      //   387: iconst_1
      //   388: iadd
      //   389: aload #11
      //   391: iload_3
      //   392: bipush #12
      //   394: ishr
      //   395: bipush #63
      //   397: iand
      //   398: baload
      //   399: bastore
      //   400: aload #12
      //   402: iload_2
      //   403: iconst_2
      //   404: iadd
      //   405: aload #11
      //   407: iload_3
      //   408: bipush #6
      //   410: ishr
      //   411: bipush #63
      //   413: iand
      //   414: baload
      //   415: bastore
      //   416: aload #12
      //   418: iload_2
      //   419: iconst_3
      //   420: iadd
      //   421: aload #11
      //   423: iload_3
      //   424: bipush #63
      //   426: iand
      //   427: baload
      //   428: bastore
      //   429: iload_2
      //   430: iconst_4
      //   431: iadd
      //   432: istore_2
      //   433: iload #6
      //   435: iconst_1
      //   436: isub
      //   437: istore #6
      //   439: iload #6
      //   441: ifne -> 486
      //   444: aload_0
      //   445: getfield f : Z
      //   448: ifeq -> 466
      //   451: iload_2
      //   452: iconst_1
      //   453: iadd
      //   454: istore_3
      //   455: aload #12
      //   457: iload_2
      //   458: bipush #13
      //   460: bastore
      //   461: iload_3
      //   462: istore_2
      //   463: goto -> 466
      //   466: iload_2
      //   467: iconst_1
      //   468: iadd
      //   469: istore #6
      //   471: aload #12
      //   473: iload_2
      //   474: bipush #10
      //   476: bastore
      //   477: iload #5
      //   479: istore_3
      //   480: iload #6
      //   482: istore_2
      //   483: goto -> 306
      //   486: iload #5
      //   488: istore_3
      //   489: goto -> 320
      //   492: iload #4
      //   494: ifeq -> 1078
      //   497: aload_0
      //   498: getfield c : I
      //   501: istore #5
      //   503: iload_3
      //   504: iload #5
      //   506: isub
      //   507: iload #10
      //   509: iconst_1
      //   510: isub
      //   511: if_icmpne -> 695
      //   514: iload #5
      //   516: ifle -> 533
      //   519: aload_0
      //   520: getfield j : [B
      //   523: iconst_0
      //   524: baload
      //   525: istore #7
      //   527: iconst_1
      //   528: istore #5
      //   530: goto -> 546
      //   533: aload_1
      //   534: iload_3
      //   535: baload
      //   536: istore #7
      //   538: iload_3
      //   539: iconst_1
      //   540: iadd
      //   541: istore_3
      //   542: iload #8
      //   544: istore #5
      //   546: iload #7
      //   548: sipush #255
      //   551: iand
      //   552: iconst_4
      //   553: ishl
      //   554: istore #7
      //   556: aload_0
      //   557: aload_0
      //   558: getfield c : I
      //   561: iload #5
      //   563: isub
      //   564: putfield c : I
      //   567: iload_2
      //   568: iconst_1
      //   569: iadd
      //   570: istore #8
      //   572: aload #12
      //   574: iload_2
      //   575: aload #11
      //   577: iload #7
      //   579: bipush #6
      //   581: ishr
      //   582: bipush #63
      //   584: iand
      //   585: baload
      //   586: bastore
      //   587: iload #8
      //   589: iconst_1
      //   590: iadd
      //   591: istore #5
      //   593: aload #12
      //   595: iload #8
      //   597: aload #11
      //   599: iload #7
      //   601: bipush #63
      //   603: iand
      //   604: baload
      //   605: bastore
      //   606: iload #5
      //   608: istore_2
      //   609: aload_0
      //   610: getfield d : Z
      //   613: ifeq -> 641
      //   616: iload #5
      //   618: iconst_1
      //   619: iadd
      //   620: istore #7
      //   622: aload #12
      //   624: iload #5
      //   626: bipush #61
      //   628: bastore
      //   629: iload #7
      //   631: iconst_1
      //   632: iadd
      //   633: istore_2
      //   634: aload #12
      //   636: iload #7
      //   638: bipush #61
      //   640: bastore
      //   641: iload_2
      //   642: istore #5
      //   644: iload_3
      //   645: istore #7
      //   647: aload_0
      //   648: getfield e : Z
      //   651: ifeq -> 1022
      //   654: aload_0
      //   655: getfield f : Z
      //   658: ifeq -> 678
      //   661: iload_2
      //   662: iconst_1
      //   663: iadd
      //   664: istore #5
      //   666: aload #12
      //   668: iload_2
      //   669: bipush #13
      //   671: bastore
      //   672: iload #5
      //   674: istore_2
      //   675: goto -> 678
      //   678: iload_2
      //   679: iconst_1
      //   680: iadd
      //   681: istore #5
      //   683: aload #12
      //   685: iload_2
      //   686: bipush #10
      //   688: bastore
      //   689: iload_3
      //   690: istore #7
      //   692: goto -> 1022
      //   695: iload_3
      //   696: iload #5
      //   698: isub
      //   699: iload #10
      //   701: iconst_2
      //   702: isub
      //   703: if_icmpne -> 948
      //   706: iload #5
      //   708: iconst_1
      //   709: if_icmple -> 726
      //   712: aload_0
      //   713: getfield j : [B
      //   716: iconst_0
      //   717: baload
      //   718: istore #7
      //   720: iconst_1
      //   721: istore #5
      //   723: goto -> 739
      //   726: aload_1
      //   727: iload_3
      //   728: baload
      //   729: istore #7
      //   731: iload_3
      //   732: iconst_1
      //   733: iadd
      //   734: istore_3
      //   735: iload #9
      //   737: istore #5
      //   739: aload_0
      //   740: getfield c : I
      //   743: ifle -> 766
      //   746: aload_0
      //   747: getfield j : [B
      //   750: astore_1
      //   751: iload #5
      //   753: iconst_1
      //   754: iadd
      //   755: istore #8
      //   757: aload_1
      //   758: iload #5
      //   760: baload
      //   761: istore #5
      //   763: goto -> 783
      //   766: aload_1
      //   767: iload_3
      //   768: baload
      //   769: istore #9
      //   771: iload #5
      //   773: istore #8
      //   775: iload #9
      //   777: istore #5
      //   779: iload_3
      //   780: iconst_1
      //   781: iadd
      //   782: istore_3
      //   783: iload #7
      //   785: sipush #255
      //   788: iand
      //   789: bipush #10
      //   791: ishl
      //   792: iload #5
      //   794: sipush #255
      //   797: iand
      //   798: iconst_2
      //   799: ishl
      //   800: ior
      //   801: istore #5
      //   803: aload_0
      //   804: aload_0
      //   805: getfield c : I
      //   808: iload #8
      //   810: isub
      //   811: putfield c : I
      //   814: iload_2
      //   815: iconst_1
      //   816: iadd
      //   817: istore #7
      //   819: aload #12
      //   821: iload_2
      //   822: aload #11
      //   824: iload #5
      //   826: bipush #12
      //   828: ishr
      //   829: bipush #63
      //   831: iand
      //   832: baload
      //   833: bastore
      //   834: iload #7
      //   836: iconst_1
      //   837: iadd
      //   838: istore #8
      //   840: aload #12
      //   842: iload #7
      //   844: aload #11
      //   846: iload #5
      //   848: bipush #6
      //   850: ishr
      //   851: bipush #63
      //   853: iand
      //   854: baload
      //   855: bastore
      //   856: iload #8
      //   858: iconst_1
      //   859: iadd
      //   860: istore_2
      //   861: aload #12
      //   863: iload #8
      //   865: aload #11
      //   867: iload #5
      //   869: bipush #63
      //   871: iand
      //   872: baload
      //   873: bastore
      //   874: aload_0
      //   875: getfield d : Z
      //   878: ifeq -> 898
      //   881: iload_2
      //   882: iconst_1
      //   883: iadd
      //   884: istore #5
      //   886: aload #12
      //   888: iload_2
      //   889: bipush #61
      //   891: bastore
      //   892: iload #5
      //   894: istore_2
      //   895: goto -> 898
      //   898: iload_2
      //   899: istore #5
      //   901: aload_0
      //   902: getfield e : Z
      //   905: ifeq -> 942
      //   908: iload_2
      //   909: istore #5
      //   911: aload_0
      //   912: getfield f : Z
      //   915: ifeq -> 929
      //   918: aload #12
      //   920: iload_2
      //   921: bipush #13
      //   923: bastore
      //   924: iload_2
      //   925: iconst_1
      //   926: iadd
      //   927: istore #5
      //   929: aload #12
      //   931: iload #5
      //   933: bipush #10
      //   935: bastore
      //   936: iload #5
      //   938: iconst_1
      //   939: iadd
      //   940: istore #5
      //   942: iload_3
      //   943: istore #7
      //   945: goto -> 1022
      //   948: iload_2
      //   949: istore #5
      //   951: iload_3
      //   952: istore #7
      //   954: aload_0
      //   955: getfield e : Z
      //   958: ifeq -> 1022
      //   961: iload_2
      //   962: istore #5
      //   964: iload_3
      //   965: istore #7
      //   967: iload_2
      //   968: ifle -> 1022
      //   971: iload_2
      //   972: istore #5
      //   974: iload_3
      //   975: istore #7
      //   977: iload #6
      //   979: bipush #19
      //   981: if_icmpeq -> 1022
      //   984: aload_0
      //   985: getfield f : Z
      //   988: ifeq -> 1008
      //   991: iload_2
      //   992: iconst_1
      //   993: iadd
      //   994: istore #5
      //   996: aload #12
      //   998: iload_2
      //   999: bipush #13
      //   1001: bastore
      //   1002: iload #5
      //   1004: istore_2
      //   1005: goto -> 1008
      //   1008: iload_2
      //   1009: iconst_1
      //   1010: iadd
      //   1011: istore #5
      //   1013: aload #12
      //   1015: iload_2
      //   1016: bipush #10
      //   1018: bastore
      //   1019: iload_3
      //   1020: istore #7
      //   1022: getstatic com/tencent/tbs/patch/common/util/Base64$c.g : Z
      //   1025: ifne -> 1046
      //   1028: aload_0
      //   1029: getfield c : I
      //   1032: ifne -> 1038
      //   1035: goto -> 1046
      //   1038: new java/lang/AssertionError
      //   1041: dup
      //   1042: invokespecial <init> : ()V
      //   1045: athrow
      //   1046: iload #5
      //   1048: istore #8
      //   1050: getstatic com/tencent/tbs/patch/common/util/Base64$c.g : Z
      //   1053: ifne -> 1186
      //   1056: iload #7
      //   1058: iload #10
      //   1060: if_icmpne -> 1070
      //   1063: iload #5
      //   1065: istore #8
      //   1067: goto -> 1186
      //   1070: new java/lang/AssertionError
      //   1073: dup
      //   1074: invokespecial <init> : ()V
      //   1077: athrow
      //   1078: iload_3
      //   1079: iload #10
      //   1081: iconst_1
      //   1082: isub
      //   1083: if_icmpne -> 1120
      //   1086: aload_0
      //   1087: getfield j : [B
      //   1090: astore #11
      //   1092: aload_0
      //   1093: getfield c : I
      //   1096: istore #5
      //   1098: aload_0
      //   1099: iload #5
      //   1101: iconst_1
      //   1102: iadd
      //   1103: putfield c : I
      //   1106: aload #11
      //   1108: iload #5
      //   1110: aload_1
      //   1111: iload_3
      //   1112: baload
      //   1113: bastore
      //   1114: iload_2
      //   1115: istore #8
      //   1117: goto -> 1186
      //   1120: iload_2
      //   1121: istore #8
      //   1123: iload_3
      //   1124: iload #10
      //   1126: iconst_2
      //   1127: isub
      //   1128: if_icmpne -> 1186
      //   1131: aload_0
      //   1132: getfield j : [B
      //   1135: astore #11
      //   1137: aload_0
      //   1138: getfield c : I
      //   1141: istore #5
      //   1143: aload_0
      //   1144: iload #5
      //   1146: iconst_1
      //   1147: iadd
      //   1148: putfield c : I
      //   1151: aload #11
      //   1153: iload #5
      //   1155: aload_1
      //   1156: iload_3
      //   1157: baload
      //   1158: bastore
      //   1159: aload_0
      //   1160: getfield c : I
      //   1163: istore #5
      //   1165: aload_0
      //   1166: iload #5
      //   1168: iconst_1
      //   1169: iadd
      //   1170: putfield c : I
      //   1173: aload #11
      //   1175: iload #5
      //   1177: aload_1
      //   1178: iload_3
      //   1179: iconst_1
      //   1180: iadd
      //   1181: baload
      //   1182: bastore
      //   1183: iload_2
      //   1184: istore #8
      //   1186: aload_0
      //   1187: iload #8
      //   1189: putfield b : I
      //   1192: aload_0
      //   1193: iload #6
      //   1195: putfield k : I
      //   1198: iconst_1
      //   1199: ireturn
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\commo\\util\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */