package a.a.a.a.a.e;

import java.io.UnsupportedEncodingException;

public final class b {
  public static String a(byte[] paramArrayOfbyte, int paramInt) {
    try {
      return new String(b(paramArrayOfbyte, paramInt), "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    b b2 = new b(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    boolean bool = b2.f;
    byte b1 = 2;
    if (bool) {
      paramInt3 = i;
      if (paramInt2 % 3 > 0)
        paramInt3 = i + 4; 
    } else {
      paramInt3 = paramInt2 % 3;
      if (paramInt3 != 1) {
        if (paramInt3 != 2) {
          paramInt3 = i;
        } else {
          paramInt3 = i + 3;
        } 
      } else {
        paramInt3 = i + 2;
      } 
    } 
    i = paramInt3;
    if (b2.g) {
      i = paramInt3;
      if (paramInt2 > 0) {
        int j = (paramInt2 - 1) / 57;
        if (b2.h) {
          i = b1;
        } else {
          i = 1;
        } 
        i = paramInt3 + (j + 1) * i;
      } 
    } 
    b2.a = new byte[i];
    b2.a(paramArrayOfbyte, paramInt1, paramInt2, true);
    if (a || b2.b == i)
      return b2.a; 
    throw new AssertionError();
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt) {
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static abstract class a {
    public byte[] a;
    
    public int b;
  }
  
  public static class b extends a {
    public static final byte[] c = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47 };
    
    public static final byte[] d = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95 };
    
    public final boolean f;
    
    public final boolean g;
    
    public final boolean h;
    
    public final byte[] i;
    
    public final byte[] j;
    
    public int k;
    
    public int l;
    
    static {
    
    }
    
    public b(int param1Int, byte[] param1ArrayOfbyte) {
      boolean bool1;
      this.a = param1ArrayOfbyte;
      boolean bool2 = true;
      if ((param1Int & 0x1) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.f = bool1;
      if ((param1Int & 0x2) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.g = bool1;
      if ((param1Int & 0x4) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.h = bool1;
      if ((param1Int & 0x8) == 0) {
        param1ArrayOfbyte = c;
      } else {
        param1ArrayOfbyte = d;
      } 
      this.j = param1ArrayOfbyte;
      this.i = new byte[2];
      this.k = 0;
      if (this.g) {
        param1Int = 19;
      } else {
        param1Int = -1;
      } 
      this.l = param1Int;
    }
    
    public boolean a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield j : [B
      //   4: astore #11
      //   6: aload_0
      //   7: getfield a : [B
      //   10: astore #12
      //   12: aload_0
      //   13: getfield l : I
      //   16: istore #6
      //   18: iload_3
      //   19: iload_2
      //   20: iadd
      //   21: istore #10
      //   23: aload_0
      //   24: getfield k : I
      //   27: istore_3
      //   28: iconst_0
      //   29: istore #9
      //   31: iconst_0
      //   32: istore #8
      //   34: iload_3
      //   35: iconst_1
      //   36: if_icmpeq -> 113
      //   39: iload_3
      //   40: iconst_2
      //   41: if_icmpeq -> 47
      //   44: goto -> 179
      //   47: iload_2
      //   48: iconst_1
      //   49: iadd
      //   50: istore_3
      //   51: iload_3
      //   52: iload #10
      //   54: if_icmpgt -> 179
      //   57: aload_0
      //   58: getfield i : [B
      //   61: astore #13
      //   63: aload #13
      //   65: iconst_0
      //   66: baload
      //   67: istore #5
      //   69: aload #13
      //   71: iconst_1
      //   72: baload
      //   73: istore #7
      //   75: aload_1
      //   76: iload_2
      //   77: baload
      //   78: istore_2
      //   79: aload_0
      //   80: iconst_0
      //   81: putfield k : I
      //   84: iload #7
      //   86: sipush #255
      //   89: iand
      //   90: bipush #8
      //   92: ishl
      //   93: iload #5
      //   95: sipush #255
      //   98: iand
      //   99: bipush #16
      //   101: ishl
      //   102: ior
      //   103: iload_2
      //   104: sipush #255
      //   107: iand
      //   108: ior
      //   109: istore_2
      //   110: goto -> 187
      //   113: iload_2
      //   114: iconst_2
      //   115: iadd
      //   116: iload #10
      //   118: if_icmpgt -> 179
      //   121: aload_0
      //   122: getfield i : [B
      //   125: iconst_0
      //   126: baload
      //   127: istore #5
      //   129: iload_2
      //   130: iconst_1
      //   131: iadd
      //   132: istore #7
      //   134: aload_1
      //   135: iload_2
      //   136: baload
      //   137: istore_2
      //   138: iload #7
      //   140: iconst_1
      //   141: iadd
      //   142: istore_3
      //   143: iload #5
      //   145: sipush #255
      //   148: iand
      //   149: bipush #16
      //   151: ishl
      //   152: iload_2
      //   153: sipush #255
      //   156: iand
      //   157: bipush #8
      //   159: ishl
      //   160: ior
      //   161: aload_1
      //   162: iload #7
      //   164: baload
      //   165: sipush #255
      //   168: iand
      //   169: ior
      //   170: istore_2
      //   171: aload_0
      //   172: iconst_0
      //   173: putfield k : I
      //   176: goto -> 187
      //   179: iconst_m1
      //   180: istore #5
      //   182: iload_2
      //   183: istore_3
      //   184: iload #5
      //   186: istore_2
      //   187: iload_2
      //   188: iconst_m1
      //   189: if_icmpeq -> 302
      //   192: aload #12
      //   194: iconst_0
      //   195: aload #11
      //   197: iload_2
      //   198: bipush #18
      //   200: ishr
      //   201: bipush #63
      //   203: iand
      //   204: baload
      //   205: bastore
      //   206: aload #12
      //   208: iconst_1
      //   209: aload #11
      //   211: iload_2
      //   212: bipush #12
      //   214: ishr
      //   215: bipush #63
      //   217: iand
      //   218: baload
      //   219: bastore
      //   220: aload #12
      //   222: iconst_2
      //   223: aload #11
      //   225: iload_2
      //   226: bipush #6
      //   228: ishr
      //   229: bipush #63
      //   231: iand
      //   232: baload
      //   233: bastore
      //   234: aload #12
      //   236: iconst_3
      //   237: aload #11
      //   239: iload_2
      //   240: bipush #63
      //   242: iand
      //   243: baload
      //   244: bastore
      //   245: iload #6
      //   247: iconst_1
      //   248: isub
      //   249: istore #6
      //   251: iload #6
      //   253: ifne -> 297
      //   256: aload_0
      //   257: getfield h : Z
      //   260: ifeq -> 274
      //   263: iconst_5
      //   264: istore_2
      //   265: aload #12
      //   267: iconst_4
      //   268: bipush #13
      //   270: bastore
      //   271: goto -> 276
      //   274: iconst_4
      //   275: istore_2
      //   276: iload_2
      //   277: iconst_1
      //   278: iadd
      //   279: istore #5
      //   281: aload #12
      //   283: iload_2
      //   284: bipush #10
      //   286: bastore
      //   287: iload #5
      //   289: istore_2
      //   290: bipush #19
      //   292: istore #6
      //   294: goto -> 304
      //   297: iconst_4
      //   298: istore_2
      //   299: goto -> 304
      //   302: iconst_0
      //   303: istore_2
      //   304: iload_3
      //   305: iconst_3
      //   306: iadd
      //   307: istore #5
      //   309: iload #5
      //   311: iload #10
      //   313: if_icmpgt -> 476
      //   316: aload_1
      //   317: iload_3
      //   318: baload
      //   319: istore #7
      //   321: aload_1
      //   322: iload_3
      //   323: iconst_1
      //   324: iadd
      //   325: baload
      //   326: sipush #255
      //   329: iand
      //   330: bipush #8
      //   332: ishl
      //   333: iload #7
      //   335: sipush #255
      //   338: iand
      //   339: bipush #16
      //   341: ishl
      //   342: ior
      //   343: aload_1
      //   344: iload_3
      //   345: iconst_2
      //   346: iadd
      //   347: baload
      //   348: sipush #255
      //   351: iand
      //   352: ior
      //   353: istore_3
      //   354: aload #12
      //   356: iload_2
      //   357: aload #11
      //   359: iload_3
      //   360: bipush #18
      //   362: ishr
      //   363: bipush #63
      //   365: iand
      //   366: baload
      //   367: bastore
      //   368: aload #12
      //   370: iload_2
      //   371: iconst_1
      //   372: iadd
      //   373: aload #11
      //   375: iload_3
      //   376: bipush #12
      //   378: ishr
      //   379: bipush #63
      //   381: iand
      //   382: baload
      //   383: bastore
      //   384: aload #12
      //   386: iload_2
      //   387: iconst_2
      //   388: iadd
      //   389: aload #11
      //   391: iload_3
      //   392: bipush #6
      //   394: ishr
      //   395: bipush #63
      //   397: iand
      //   398: baload
      //   399: bastore
      //   400: aload #12
      //   402: iload_2
      //   403: iconst_3
      //   404: iadd
      //   405: aload #11
      //   407: iload_3
      //   408: bipush #63
      //   410: iand
      //   411: baload
      //   412: bastore
      //   413: iload_2
      //   414: iconst_4
      //   415: iadd
      //   416: istore_2
      //   417: iload #6
      //   419: iconst_1
      //   420: isub
      //   421: istore #6
      //   423: iload #6
      //   425: ifne -> 470
      //   428: aload_0
      //   429: getfield h : Z
      //   432: ifeq -> 450
      //   435: iload_2
      //   436: iconst_1
      //   437: iadd
      //   438: istore_3
      //   439: aload #12
      //   441: iload_2
      //   442: bipush #13
      //   444: bastore
      //   445: iload_3
      //   446: istore_2
      //   447: goto -> 450
      //   450: iload_2
      //   451: iconst_1
      //   452: iadd
      //   453: istore #6
      //   455: aload #12
      //   457: iload_2
      //   458: bipush #10
      //   460: bastore
      //   461: iload #5
      //   463: istore_3
      //   464: iload #6
      //   466: istore_2
      //   467: goto -> 290
      //   470: iload #5
      //   472: istore_3
      //   473: goto -> 304
      //   476: iload #4
      //   478: ifeq -> 1069
      //   481: aload_0
      //   482: getfield k : I
      //   485: istore #5
      //   487: iload_3
      //   488: iload #5
      //   490: isub
      //   491: istore #7
      //   493: iload #7
      //   495: iload #10
      //   497: iconst_1
      //   498: isub
      //   499: if_icmpne -> 683
      //   502: iload #5
      //   504: ifle -> 521
      //   507: aload_0
      //   508: getfield i : [B
      //   511: iconst_0
      //   512: baload
      //   513: istore #7
      //   515: iconst_1
      //   516: istore #5
      //   518: goto -> 534
      //   521: aload_1
      //   522: iload_3
      //   523: baload
      //   524: istore #7
      //   526: iload_3
      //   527: iconst_1
      //   528: iadd
      //   529: istore_3
      //   530: iload #8
      //   532: istore #5
      //   534: iload #7
      //   536: sipush #255
      //   539: iand
      //   540: iconst_4
      //   541: ishl
      //   542: istore #7
      //   544: aload_0
      //   545: aload_0
      //   546: getfield k : I
      //   549: iload #5
      //   551: isub
      //   552: putfield k : I
      //   555: iload_2
      //   556: iconst_1
      //   557: iadd
      //   558: istore #8
      //   560: aload #12
      //   562: iload_2
      //   563: aload #11
      //   565: iload #7
      //   567: bipush #6
      //   569: ishr
      //   570: bipush #63
      //   572: iand
      //   573: baload
      //   574: bastore
      //   575: iload #8
      //   577: iconst_1
      //   578: iadd
      //   579: istore #5
      //   581: aload #12
      //   583: iload #8
      //   585: aload #11
      //   587: iload #7
      //   589: bipush #63
      //   591: iand
      //   592: baload
      //   593: bastore
      //   594: iload #5
      //   596: istore_2
      //   597: aload_0
      //   598: getfield f : Z
      //   601: ifeq -> 629
      //   604: iload #5
      //   606: iconst_1
      //   607: iadd
      //   608: istore #7
      //   610: aload #12
      //   612: iload #5
      //   614: bipush #61
      //   616: bastore
      //   617: iload #7
      //   619: iconst_1
      //   620: iadd
      //   621: istore_2
      //   622: aload #12
      //   624: iload #7
      //   626: bipush #61
      //   628: bastore
      //   629: iload_2
      //   630: istore #5
      //   632: iload_3
      //   633: istore #7
      //   635: aload_0
      //   636: getfield g : Z
      //   639: ifeq -> 1013
      //   642: aload_0
      //   643: getfield h : Z
      //   646: ifeq -> 666
      //   649: iload_2
      //   650: iconst_1
      //   651: iadd
      //   652: istore #5
      //   654: aload #12
      //   656: iload_2
      //   657: bipush #13
      //   659: bastore
      //   660: iload #5
      //   662: istore_2
      //   663: goto -> 666
      //   666: iload_2
      //   667: iconst_1
      //   668: iadd
      //   669: istore #5
      //   671: aload #12
      //   673: iload_2
      //   674: bipush #10
      //   676: bastore
      //   677: iload_3
      //   678: istore #7
      //   680: goto -> 1013
      //   683: iload #7
      //   685: iload #10
      //   687: iconst_2
      //   688: isub
      //   689: if_icmpne -> 939
      //   692: iload #5
      //   694: iconst_1
      //   695: if_icmple -> 712
      //   698: aload_0
      //   699: getfield i : [B
      //   702: iconst_0
      //   703: baload
      //   704: istore #7
      //   706: iconst_1
      //   707: istore #5
      //   709: goto -> 725
      //   712: aload_1
      //   713: iload_3
      //   714: baload
      //   715: istore #7
      //   717: iload_3
      //   718: iconst_1
      //   719: iadd
      //   720: istore_3
      //   721: iload #9
      //   723: istore #5
      //   725: aload_0
      //   726: getfield k : I
      //   729: ifle -> 756
      //   732: aload_0
      //   733: getfield i : [B
      //   736: astore_1
      //   737: iload #5
      //   739: iconst_1
      //   740: iadd
      //   741: istore #9
      //   743: aload_1
      //   744: iload #5
      //   746: baload
      //   747: istore #8
      //   749: iload #9
      //   751: istore #5
      //   753: goto -> 769
      //   756: iload_3
      //   757: iconst_1
      //   758: iadd
      //   759: istore #9
      //   761: aload_1
      //   762: iload_3
      //   763: baload
      //   764: istore #8
      //   766: iload #9
      //   768: istore_3
      //   769: iload #7
      //   771: sipush #255
      //   774: iand
      //   775: bipush #10
      //   777: ishl
      //   778: iload #8
      //   780: sipush #255
      //   783: iand
      //   784: iconst_2
      //   785: ishl
      //   786: ior
      //   787: istore #7
      //   789: aload_0
      //   790: aload_0
      //   791: getfield k : I
      //   794: iload #5
      //   796: isub
      //   797: putfield k : I
      //   800: iload_2
      //   801: iconst_1
      //   802: iadd
      //   803: istore #5
      //   805: aload #12
      //   807: iload_2
      //   808: aload #11
      //   810: iload #7
      //   812: bipush #12
      //   814: ishr
      //   815: bipush #63
      //   817: iand
      //   818: baload
      //   819: bastore
      //   820: iload #5
      //   822: iconst_1
      //   823: iadd
      //   824: istore #8
      //   826: aload #12
      //   828: iload #5
      //   830: aload #11
      //   832: iload #7
      //   834: bipush #6
      //   836: ishr
      //   837: bipush #63
      //   839: iand
      //   840: baload
      //   841: bastore
      //   842: iload #8
      //   844: iconst_1
      //   845: iadd
      //   846: istore_2
      //   847: aload #12
      //   849: iload #8
      //   851: aload #11
      //   853: iload #7
      //   855: bipush #63
      //   857: iand
      //   858: baload
      //   859: bastore
      //   860: aload_0
      //   861: getfield f : Z
      //   864: ifeq -> 884
      //   867: iload_2
      //   868: iconst_1
      //   869: iadd
      //   870: istore #5
      //   872: aload #12
      //   874: iload_2
      //   875: bipush #61
      //   877: bastore
      //   878: iload #5
      //   880: istore_2
      //   881: goto -> 884
      //   884: aload_0
      //   885: getfield g : Z
      //   888: ifeq -> 930
      //   891: iload_2
      //   892: istore #5
      //   894: aload_0
      //   895: getfield h : Z
      //   898: ifeq -> 912
      //   901: aload #12
      //   903: iload_2
      //   904: bipush #13
      //   906: bastore
      //   907: iload_2
      //   908: iconst_1
      //   909: iadd
      //   910: istore #5
      //   912: iload #5
      //   914: iconst_1
      //   915: iadd
      //   916: istore_2
      //   917: aload #12
      //   919: iload #5
      //   921: bipush #10
      //   923: bastore
      //   924: iload_2
      //   925: istore #5
      //   927: goto -> 933
      //   930: iload_2
      //   931: istore #5
      //   933: iload_3
      //   934: istore #7
      //   936: goto -> 1013
      //   939: iload_2
      //   940: istore #5
      //   942: iload_3
      //   943: istore #7
      //   945: aload_0
      //   946: getfield g : Z
      //   949: ifeq -> 1013
      //   952: iload_2
      //   953: istore #5
      //   955: iload_3
      //   956: istore #7
      //   958: iload_2
      //   959: ifle -> 1013
      //   962: iload_2
      //   963: istore #5
      //   965: iload_3
      //   966: istore #7
      //   968: iload #6
      //   970: bipush #19
      //   972: if_icmpeq -> 1013
      //   975: aload_0
      //   976: getfield h : Z
      //   979: ifeq -> 999
      //   982: iload_2
      //   983: iconst_1
      //   984: iadd
      //   985: istore #5
      //   987: aload #12
      //   989: iload_2
      //   990: bipush #13
      //   992: bastore
      //   993: iload #5
      //   995: istore_2
      //   996: goto -> 999
      //   999: iload_2
      //   1000: iconst_1
      //   1001: iadd
      //   1002: istore #5
      //   1004: aload #12
      //   1006: iload_2
      //   1007: bipush #10
      //   1009: bastore
      //   1010: iload_3
      //   1011: istore #7
      //   1013: getstatic a/a/a/a/a/e/b$b.e : Z
      //   1016: ifne -> 1037
      //   1019: aload_0
      //   1020: getfield k : I
      //   1023: ifne -> 1029
      //   1026: goto -> 1037
      //   1029: new java/lang/AssertionError
      //   1032: dup
      //   1033: invokespecial <init> : ()V
      //   1036: athrow
      //   1037: iload #5
      //   1039: istore #8
      //   1041: getstatic a/a/a/a/a/e/b$b.e : Z
      //   1044: ifne -> 1175
      //   1047: iload #7
      //   1049: iload #10
      //   1051: if_icmpne -> 1061
      //   1054: iload #5
      //   1056: istore #8
      //   1058: goto -> 1175
      //   1061: new java/lang/AssertionError
      //   1064: dup
      //   1065: invokespecial <init> : ()V
      //   1068: athrow
      //   1069: iload_3
      //   1070: iload #10
      //   1072: iconst_1
      //   1073: isub
      //   1074: if_icmpne -> 1111
      //   1077: aload_0
      //   1078: getfield i : [B
      //   1081: astore #11
      //   1083: aload_0
      //   1084: getfield k : I
      //   1087: istore #5
      //   1089: aload_0
      //   1090: iload #5
      //   1092: iconst_1
      //   1093: iadd
      //   1094: putfield k : I
      //   1097: aload #11
      //   1099: iload #5
      //   1101: aload_1
      //   1102: iload_3
      //   1103: baload
      //   1104: bastore
      //   1105: iload_2
      //   1106: istore #8
      //   1108: goto -> 1175
      //   1111: iload_2
      //   1112: istore #8
      //   1114: iload_3
      //   1115: iload #10
      //   1117: iconst_2
      //   1118: isub
      //   1119: if_icmpne -> 1175
      //   1122: aload_0
      //   1123: getfield i : [B
      //   1126: astore #11
      //   1128: aload_0
      //   1129: getfield k : I
      //   1132: istore #5
      //   1134: iload #5
      //   1136: iconst_1
      //   1137: iadd
      //   1138: istore #7
      //   1140: aload_0
      //   1141: iload #7
      //   1143: putfield k : I
      //   1146: aload #11
      //   1148: iload #5
      //   1150: aload_1
      //   1151: iload_3
      //   1152: baload
      //   1153: bastore
      //   1154: aload_0
      //   1155: iload #7
      //   1157: iconst_1
      //   1158: iadd
      //   1159: putfield k : I
      //   1162: aload #11
      //   1164: iload #7
      //   1166: aload_1
      //   1167: iload_3
      //   1168: iconst_1
      //   1169: iadd
      //   1170: baload
      //   1171: bastore
      //   1172: iload_2
      //   1173: istore #8
      //   1175: aload_0
      //   1176: iload #8
      //   1178: putfield b : I
      //   1181: aload_0
      //   1182: iload #6
      //   1184: putfield l : I
      //   1187: iconst_1
      //   1188: ireturn
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */