package com.loc;

public class dl {
  public static byte[] a(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    b b = new b(new byte[i * 3 / 4]);
    if (b.a(paramArrayOfbyte, i)) {
      if (b.b == b.a.length)
        return b.a; 
      paramArrayOfbyte = new byte[b.b];
      System.arraycopy(b.a, 0, paramArrayOfbyte, 0, b.b);
      return paramArrayOfbyte;
    } 
    throw new IllegalArgumentException("bad base-64");
  }
  
  static abstract class a {
    public byte[] a;
    
    public int b;
  }
  
  static final class b extends a {
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
    
    public b(byte[] param1ArrayOfbyte) {
      this.a = param1ArrayOfbyte;
      this.g = c;
      this.e = 0;
      this.f = 0;
    }
    
    public final boolean a(byte[] param1ArrayOfbyte, int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: getfield e : I
      //   4: istore #5
      //   6: iload #5
      //   8: bipush #6
      //   10: if_icmpne -> 15
      //   13: iconst_0
      //   14: ireturn
      //   15: iload_2
      //   16: iconst_0
      //   17: iadd
      //   18: istore #9
      //   20: aload_0
      //   21: getfield f : I
      //   24: istore #4
      //   26: aload_0
      //   27: getfield a : [B
      //   30: astore #10
      //   32: aload_0
      //   33: getfield g : [I
      //   36: astore #11
      //   38: iconst_0
      //   39: istore_3
      //   40: iconst_0
      //   41: istore_2
      //   42: iload_3
      //   43: istore #7
      //   45: iload #4
      //   47: istore #8
      //   49: iload_2
      //   50: iload #9
      //   52: if_icmpge -> 580
      //   55: iload_2
      //   56: istore #8
      //   58: iload_3
      //   59: istore #7
      //   61: iload #4
      //   63: istore #6
      //   65: iload #5
      //   67: ifne -> 227
      //   70: iload_2
      //   71: iconst_4
      //   72: iadd
      //   73: istore #7
      //   75: iload #4
      //   77: istore #6
      //   79: iload #7
      //   81: iload #9
      //   83: if_icmpgt -> 208
      //   86: aload #11
      //   88: aload_1
      //   89: iload_2
      //   90: baload
      //   91: sipush #255
      //   94: iand
      //   95: iaload
      //   96: istore #4
      //   98: aload #11
      //   100: aload_1
      //   101: iload_2
      //   102: iconst_1
      //   103: iadd
      //   104: baload
      //   105: sipush #255
      //   108: iand
      //   109: iaload
      //   110: istore #6
      //   112: aload #11
      //   114: aload_1
      //   115: iload_2
      //   116: iconst_2
      //   117: iadd
      //   118: baload
      //   119: sipush #255
      //   122: iand
      //   123: iaload
      //   124: istore #8
      //   126: aload #11
      //   128: aload_1
      //   129: iload_2
      //   130: iconst_3
      //   131: iadd
      //   132: baload
      //   133: sipush #255
      //   136: iand
      //   137: iaload
      //   138: iload #6
      //   140: bipush #12
      //   142: ishl
      //   143: iload #4
      //   145: bipush #18
      //   147: ishl
      //   148: ior
      //   149: iload #8
      //   151: bipush #6
      //   153: ishl
      //   154: ior
      //   155: ior
      //   156: istore #4
      //   158: iload #4
      //   160: istore #6
      //   162: iload #4
      //   164: iflt -> 208
      //   167: aload #10
      //   169: iload_3
      //   170: iconst_2
      //   171: iadd
      //   172: iload #4
      //   174: i2b
      //   175: bastore
      //   176: aload #10
      //   178: iload_3
      //   179: iconst_1
      //   180: iadd
      //   181: iload #4
      //   183: bipush #8
      //   185: ishr
      //   186: i2b
      //   187: bastore
      //   188: aload #10
      //   190: iload_3
      //   191: iload #4
      //   193: bipush #16
      //   195: ishr
      //   196: i2b
      //   197: bastore
      //   198: iload_3
      //   199: iconst_3
      //   200: iadd
      //   201: istore_3
      //   202: iload #7
      //   204: istore_2
      //   205: goto -> 70
      //   208: iload_3
      //   209: istore #7
      //   211: iload #6
      //   213: istore #8
      //   215: iload_2
      //   216: iload #9
      //   218: if_icmpge -> 580
      //   221: iload_3
      //   222: istore #7
      //   224: iload_2
      //   225: istore #8
      //   227: iload #8
      //   229: iconst_1
      //   230: iadd
      //   231: istore_2
      //   232: aload #11
      //   234: aload_1
      //   235: iload #8
      //   237: baload
      //   238: sipush #255
      //   241: iand
      //   242: iaload
      //   243: istore_3
      //   244: iload #5
      //   246: ifeq -> 541
      //   249: iload #5
      //   251: iconst_1
      //   252: if_icmpeq -> 502
      //   255: iload #5
      //   257: iconst_2
      //   258: if_icmpeq -> 452
      //   261: iload #5
      //   263: iconst_3
      //   264: if_icmpeq -> 333
      //   267: iload #5
      //   269: iconst_4
      //   270: if_icmpeq -> 303
      //   273: iload #5
      //   275: iconst_5
      //   276: if_icmpeq -> 286
      //   279: iload #6
      //   281: istore #4
      //   283: goto -> 574
      //   286: iload #6
      //   288: istore #4
      //   290: iload_3
      //   291: iconst_m1
      //   292: if_icmpeq -> 574
      //   295: aload_0
      //   296: bipush #6
      //   298: putfield e : I
      //   301: iconst_0
      //   302: ireturn
      //   303: iload_3
      //   304: bipush #-2
      //   306: if_icmpne -> 316
      //   309: iload #6
      //   311: istore #4
      //   313: goto -> 515
      //   316: iload #6
      //   318: istore #4
      //   320: iload_3
      //   321: iconst_m1
      //   322: if_icmpeq -> 574
      //   325: aload_0
      //   326: bipush #6
      //   328: putfield e : I
      //   331: iconst_0
      //   332: ireturn
      //   333: iload_3
      //   334: iflt -> 391
      //   337: iload #6
      //   339: bipush #6
      //   341: ishl
      //   342: iload_3
      //   343: ior
      //   344: istore #4
      //   346: aload #10
      //   348: iload #7
      //   350: iconst_2
      //   351: iadd
      //   352: iload #4
      //   354: i2b
      //   355: bastore
      //   356: aload #10
      //   358: iload #7
      //   360: iconst_1
      //   361: iadd
      //   362: iload #4
      //   364: bipush #8
      //   366: ishr
      //   367: i2b
      //   368: bastore
      //   369: aload #10
      //   371: iload #7
      //   373: iload #4
      //   375: bipush #16
      //   377: ishr
      //   378: i2b
      //   379: bastore
      //   380: iload #7
      //   382: iconst_3
      //   383: iadd
      //   384: istore_3
      //   385: iconst_0
      //   386: istore #5
      //   388: goto -> 42
      //   391: iload_3
      //   392: bipush #-2
      //   394: if_icmpne -> 435
      //   397: aload #10
      //   399: iload #7
      //   401: iconst_1
      //   402: iadd
      //   403: iload #6
      //   405: iconst_2
      //   406: ishr
      //   407: i2b
      //   408: bastore
      //   409: aload #10
      //   411: iload #7
      //   413: iload #6
      //   415: bipush #10
      //   417: ishr
      //   418: i2b
      //   419: bastore
      //   420: iload #7
      //   422: iconst_2
      //   423: iadd
      //   424: istore_3
      //   425: iconst_5
      //   426: istore #5
      //   428: iload #6
      //   430: istore #4
      //   432: goto -> 42
      //   435: iload #6
      //   437: istore #4
      //   439: iload_3
      //   440: iconst_m1
      //   441: if_icmpeq -> 574
      //   444: aload_0
      //   445: bipush #6
      //   447: putfield e : I
      //   450: iconst_0
      //   451: ireturn
      //   452: iload_3
      //   453: iflt -> 459
      //   456: goto -> 506
      //   459: iload_3
      //   460: bipush #-2
      //   462: if_icmpne -> 490
      //   465: aload #10
      //   467: iload #7
      //   469: iload #6
      //   471: iconst_4
      //   472: ishr
      //   473: i2b
      //   474: bastore
      //   475: iload #7
      //   477: iconst_1
      //   478: iadd
      //   479: istore_3
      //   480: iconst_4
      //   481: istore #5
      //   483: iload #6
      //   485: istore #4
      //   487: goto -> 42
      //   490: iload #6
      //   492: istore #4
      //   494: iload_3
      //   495: iconst_m1
      //   496: if_icmpeq -> 574
      //   499: goto -> 295
      //   502: iload_3
      //   503: iflt -> 524
      //   506: iload #6
      //   508: bipush #6
      //   510: ishl
      //   511: iload_3
      //   512: ior
      //   513: istore #4
      //   515: iload #5
      //   517: iconst_1
      //   518: iadd
      //   519: istore #5
      //   521: goto -> 574
      //   524: iload #6
      //   526: istore #4
      //   528: iload_3
      //   529: iconst_m1
      //   530: if_icmpeq -> 574
      //   533: aload_0
      //   534: bipush #6
      //   536: putfield e : I
      //   539: iconst_0
      //   540: ireturn
      //   541: iload_3
      //   542: iflt -> 557
      //   545: iload #5
      //   547: iconst_1
      //   548: iadd
      //   549: istore #5
      //   551: iload_3
      //   552: istore #4
      //   554: goto -> 574
      //   557: iload #6
      //   559: istore #4
      //   561: iload_3
      //   562: iconst_m1
      //   563: if_icmpeq -> 574
      //   566: aload_0
      //   567: bipush #6
      //   569: putfield e : I
      //   572: iconst_0
      //   573: ireturn
      //   574: iload #7
      //   576: istore_3
      //   577: goto -> 42
      //   580: iload #7
      //   582: istore_2
      //   583: iload #5
      //   585: ifeq -> 665
      //   588: iload #5
      //   590: iconst_1
      //   591: if_icmpeq -> 444
      //   594: iload #5
      //   596: iconst_2
      //   597: if_icmpeq -> 650
      //   600: iload #5
      //   602: iconst_3
      //   603: if_icmpeq -> 618
      //   606: iload #5
      //   608: iconst_4
      //   609: if_icmpeq -> 444
      //   612: iload #7
      //   614: istore_2
      //   615: goto -> 665
      //   618: iload #7
      //   620: iconst_1
      //   621: iadd
      //   622: istore_3
      //   623: aload #10
      //   625: iload #7
      //   627: iload #8
      //   629: bipush #10
      //   631: ishr
      //   632: i2b
      //   633: bastore
      //   634: iload_3
      //   635: iconst_1
      //   636: iadd
      //   637: istore_2
      //   638: aload #10
      //   640: iload_3
      //   641: iload #8
      //   643: iconst_2
      //   644: ishr
      //   645: i2b
      //   646: bastore
      //   647: goto -> 665
      //   650: aload #10
      //   652: iload #7
      //   654: iload #8
      //   656: iconst_4
      //   657: ishr
      //   658: i2b
      //   659: bastore
      //   660: iload #7
      //   662: iconst_1
      //   663: iadd
      //   664: istore_2
      //   665: aload_0
      //   666: iload #5
      //   668: putfield e : I
      //   671: aload_0
      //   672: iload_2
      //   673: putfield b : I
      //   676: iconst_1
      //   677: ireturn
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */