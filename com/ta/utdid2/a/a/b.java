package com.ta.utdid2.a.a;

import java.io.UnsupportedEncodingException;

public class b {
  public static byte[] decode(String paramString, int paramInt) {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt) {
    return decode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    b b1 = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (b1.a(paramArrayOfbyte, paramInt1, paramInt2, true)) {
      if (b1.a == b1.a.length)
        return (byte[])b1.a; 
      paramArrayOfbyte = new byte[b1.a];
      System.arraycopy(b1.a, 0, paramArrayOfbyte, 0, b1.a);
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
    boolean bool = c.b;
    byte b1 = 2;
    if (bool) {
      paramInt3 = i;
      if (paramInt2 % 3 > 0)
        paramInt3 = i + 4; 
    } else {
      int j = paramInt2 % 3;
      paramInt3 = i;
      if (j != 0)
        if (j != 1) {
          if (j != 2) {
            paramInt3 = i;
          } else {
            paramInt3 = i + 3;
          } 
        } else {
          paramInt3 = i + 2;
        }  
    } 
    i = paramInt3;
    if (c.c) {
      i = paramInt3;
      if (paramInt2 > 0) {
        int j = (paramInt2 - 1) / 57;
        if (c.d != null) {
          i = b1;
        } else {
          i = 1;
        } 
        i = paramInt3 + (j + 1) * i;
      } 
    } 
    c.a = new byte[i];
    c.a(paramArrayOfbyte, paramInt1, paramInt2, true);
    if (a || c.a == i)
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
  
  static abstract class a {
    public int a;
    
    public byte[] a;
  }
  
  static class b extends a {
    private static final int[] a = new int[] { 
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
    
    private static final int[] b = new int[] { 
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
    
    private final int[] c;
    
    private int state;
    
    private int value;
    
    public b(int param1Int, byte[] param1ArrayOfbyte) {
      int[] arrayOfInt;
      this.a = (int[])param1ArrayOfbyte;
      if ((param1Int & 0x8) == 0) {
        arrayOfInt = a;
      } else {
        arrayOfInt = b;
      } 
      this.c = arrayOfInt;
      this.state = 0;
      this.value = 0;
    }
    
    public boolean a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield state : I
      //   4: istore #8
      //   6: iload #8
      //   8: bipush #6
      //   10: if_icmpne -> 15
      //   13: iconst_0
      //   14: ireturn
      //   15: iload_3
      //   16: iload_2
      //   17: iadd
      //   18: istore #10
      //   20: aload_0
      //   21: getfield value : I
      //   24: istore #5
      //   26: aload_0
      //   27: getfield a : [B
      //   30: astore #11
      //   32: aload_0
      //   33: getfield c : [I
      //   36: astore #12
      //   38: iconst_0
      //   39: istore_3
      //   40: iload_2
      //   41: istore #6
      //   43: iload #5
      //   45: istore_2
      //   46: iload #6
      //   48: istore #5
      //   50: iload_2
      //   51: istore #7
      //   53: iload_3
      //   54: istore #6
      //   56: iload #5
      //   58: iload #10
      //   60: if_icmpge -> 620
      //   63: iload #5
      //   65: istore #9
      //   67: iload_2
      //   68: istore #6
      //   70: iload_3
      //   71: istore #7
      //   73: iload #8
      //   75: ifne -> 234
      //   78: iload #5
      //   80: iconst_4
      //   81: iadd
      //   82: istore #7
      //   84: iload #7
      //   86: iload #10
      //   88: if_icmpgt -> 208
      //   91: aload #12
      //   93: aload_1
      //   94: iload #5
      //   96: baload
      //   97: sipush #255
      //   100: iand
      //   101: iaload
      //   102: bipush #18
      //   104: ishl
      //   105: aload #12
      //   107: aload_1
      //   108: iload #5
      //   110: iconst_1
      //   111: iadd
      //   112: baload
      //   113: sipush #255
      //   116: iand
      //   117: iaload
      //   118: bipush #12
      //   120: ishl
      //   121: ior
      //   122: aload #12
      //   124: aload_1
      //   125: iload #5
      //   127: iconst_2
      //   128: iadd
      //   129: baload
      //   130: sipush #255
      //   133: iand
      //   134: iaload
      //   135: bipush #6
      //   137: ishl
      //   138: ior
      //   139: aload #12
      //   141: aload_1
      //   142: iload #5
      //   144: iconst_3
      //   145: iadd
      //   146: baload
      //   147: sipush #255
      //   150: iand
      //   151: iaload
      //   152: ior
      //   153: istore #6
      //   155: iload #6
      //   157: istore_2
      //   158: iload #6
      //   160: iflt -> 208
      //   163: aload #11
      //   165: iload_3
      //   166: iconst_2
      //   167: iadd
      //   168: iload #6
      //   170: i2b
      //   171: bastore
      //   172: aload #11
      //   174: iload_3
      //   175: iconst_1
      //   176: iadd
      //   177: iload #6
      //   179: bipush #8
      //   181: ishr
      //   182: i2b
      //   183: bastore
      //   184: aload #11
      //   186: iload_3
      //   187: iload #6
      //   189: bipush #16
      //   191: ishr
      //   192: i2b
      //   193: bastore
      //   194: iload_3
      //   195: iconst_3
      //   196: iadd
      //   197: istore_3
      //   198: iload #7
      //   200: istore #5
      //   202: iload #6
      //   204: istore_2
      //   205: goto -> 78
      //   208: iload #5
      //   210: istore #9
      //   212: iload_2
      //   213: istore #6
      //   215: iload_3
      //   216: istore #7
      //   218: iload #5
      //   220: iload #10
      //   222: if_icmplt -> 234
      //   225: iload_2
      //   226: istore #7
      //   228: iload_3
      //   229: istore #6
      //   231: goto -> 620
      //   234: aload #12
      //   236: aload_1
      //   237: iload #9
      //   239: baload
      //   240: sipush #255
      //   243: iand
      //   244: iaload
      //   245: istore #5
      //   247: iload #8
      //   249: ifeq -> 561
      //   252: iload #8
      //   254: iconst_1
      //   255: if_icmpeq -> 524
      //   258: iload #8
      //   260: iconst_2
      //   261: if_icmpeq -> 468
      //   264: iload #8
      //   266: iconst_3
      //   267: if_icmpeq -> 349
      //   270: iload #8
      //   272: iconst_4
      //   273: if_icmpeq -> 311
      //   276: iload #8
      //   278: iconst_5
      //   279: if_icmpeq -> 291
      //   282: iload #8
      //   284: istore_2
      //   285: iload #7
      //   287: istore_3
      //   288: goto -> 605
      //   291: iload #8
      //   293: istore_2
      //   294: iload #7
      //   296: istore_3
      //   297: iload #5
      //   299: iconst_m1
      //   300: if_icmpeq -> 605
      //   303: aload_0
      //   304: bipush #6
      //   306: putfield state : I
      //   309: iconst_0
      //   310: ireturn
      //   311: iload #5
      //   313: bipush #-2
      //   315: if_icmpne -> 329
      //   318: iload #8
      //   320: iconst_1
      //   321: iadd
      //   322: istore_2
      //   323: iload #7
      //   325: istore_3
      //   326: goto -> 605
      //   329: iload #8
      //   331: istore_2
      //   332: iload #7
      //   334: istore_3
      //   335: iload #5
      //   337: iconst_m1
      //   338: if_icmpeq -> 605
      //   341: aload_0
      //   342: bipush #6
      //   344: putfield state : I
      //   347: iconst_0
      //   348: ireturn
      //   349: iload #5
      //   351: iflt -> 408
      //   354: iload #5
      //   356: iload #6
      //   358: bipush #6
      //   360: ishl
      //   361: ior
      //   362: istore #6
      //   364: aload #11
      //   366: iload #7
      //   368: iconst_2
      //   369: iadd
      //   370: iload #6
      //   372: i2b
      //   373: bastore
      //   374: aload #11
      //   376: iload #7
      //   378: iconst_1
      //   379: iadd
      //   380: iload #6
      //   382: bipush #8
      //   384: ishr
      //   385: i2b
      //   386: bastore
      //   387: aload #11
      //   389: iload #7
      //   391: iload #6
      //   393: bipush #16
      //   395: ishr
      //   396: i2b
      //   397: bastore
      //   398: iload #7
      //   400: iconst_3
      //   401: iadd
      //   402: istore_3
      //   403: iconst_0
      //   404: istore_2
      //   405: goto -> 605
      //   408: iload #5
      //   410: bipush #-2
      //   412: if_icmpne -> 448
      //   415: aload #11
      //   417: iload #7
      //   419: iconst_1
      //   420: iadd
      //   421: iload #6
      //   423: iconst_2
      //   424: ishr
      //   425: i2b
      //   426: bastore
      //   427: aload #11
      //   429: iload #7
      //   431: iload #6
      //   433: bipush #10
      //   435: ishr
      //   436: i2b
      //   437: bastore
      //   438: iload #7
      //   440: iconst_2
      //   441: iadd
      //   442: istore_3
      //   443: iconst_5
      //   444: istore_2
      //   445: goto -> 605
      //   448: iload #8
      //   450: istore_2
      //   451: iload #7
      //   453: istore_3
      //   454: iload #5
      //   456: iconst_m1
      //   457: if_icmpeq -> 605
      //   460: aload_0
      //   461: bipush #6
      //   463: putfield state : I
      //   466: iconst_0
      //   467: ireturn
      //   468: iload #5
      //   470: iflt -> 476
      //   473: goto -> 529
      //   476: iload #5
      //   478: bipush #-2
      //   480: if_icmpne -> 503
      //   483: aload #11
      //   485: iload #7
      //   487: iload #6
      //   489: iconst_4
      //   490: ishr
      //   491: i2b
      //   492: bastore
      //   493: iload #7
      //   495: iconst_1
      //   496: iadd
      //   497: istore_3
      //   498: iconst_4
      //   499: istore_2
      //   500: goto -> 605
      //   503: iload #8
      //   505: istore_2
      //   506: iload #7
      //   508: istore_3
      //   509: iload #5
      //   511: iconst_m1
      //   512: if_icmpeq -> 605
      //   515: aload_0
      //   516: bipush #6
      //   518: putfield state : I
      //   521: goto -> 309
      //   524: iload #5
      //   526: iflt -> 541
      //   529: iload #5
      //   531: iload #6
      //   533: bipush #6
      //   535: ishl
      //   536: ior
      //   537: istore_2
      //   538: goto -> 569
      //   541: iload #8
      //   543: istore_2
      //   544: iload #7
      //   546: istore_3
      //   547: iload #5
      //   549: iconst_m1
      //   550: if_icmpeq -> 605
      //   553: aload_0
      //   554: bipush #6
      //   556: putfield state : I
      //   559: iconst_0
      //   560: ireturn
      //   561: iload #5
      //   563: iflt -> 585
      //   566: iload #5
      //   568: istore_2
      //   569: iload #8
      //   571: iconst_1
      //   572: iadd
      //   573: istore_3
      //   574: iload_2
      //   575: istore #6
      //   577: iload_3
      //   578: istore_2
      //   579: iload #7
      //   581: istore_3
      //   582: goto -> 605
      //   585: iload #8
      //   587: istore_2
      //   588: iload #7
      //   590: istore_3
      //   591: iload #5
      //   593: iconst_m1
      //   594: if_icmpeq -> 605
      //   597: aload_0
      //   598: bipush #6
      //   600: putfield state : I
      //   603: iconst_0
      //   604: ireturn
      //   605: iload #9
      //   607: iconst_1
      //   608: iadd
      //   609: istore #5
      //   611: iload_2
      //   612: istore #8
      //   614: iload #6
      //   616: istore_2
      //   617: goto -> 50
      //   620: iload #4
      //   622: ifne -> 645
      //   625: aload_0
      //   626: iload #8
      //   628: putfield state : I
      //   631: aload_0
      //   632: iload #7
      //   634: putfield value : I
      //   637: aload_0
      //   638: iload #6
      //   640: putfield a : I
      //   643: iconst_1
      //   644: ireturn
      //   645: iload #6
      //   647: istore_2
      //   648: iload #8
      //   650: ifeq -> 751
      //   653: iload #8
      //   655: iconst_1
      //   656: if_icmpeq -> 742
      //   659: iload #8
      //   661: iconst_2
      //   662: if_icmpeq -> 724
      //   665: iload #8
      //   667: iconst_3
      //   668: if_icmpeq -> 692
      //   671: iload #8
      //   673: iconst_4
      //   674: if_icmpeq -> 683
      //   677: iload #6
      //   679: istore_2
      //   680: goto -> 751
      //   683: aload_0
      //   684: bipush #6
      //   686: putfield state : I
      //   689: goto -> 466
      //   692: iload #6
      //   694: iconst_1
      //   695: iadd
      //   696: istore_3
      //   697: aload #11
      //   699: iload #6
      //   701: iload #7
      //   703: bipush #10
      //   705: ishr
      //   706: i2b
      //   707: bastore
      //   708: iload_3
      //   709: iconst_1
      //   710: iadd
      //   711: istore_2
      //   712: aload #11
      //   714: iload_3
      //   715: iload #7
      //   717: iconst_2
      //   718: ishr
      //   719: i2b
      //   720: bastore
      //   721: goto -> 751
      //   724: aload #11
      //   726: iload #6
      //   728: iload #7
      //   730: iconst_4
      //   731: ishr
      //   732: i2b
      //   733: bastore
      //   734: iload #6
      //   736: iconst_1
      //   737: iadd
      //   738: istore_2
      //   739: goto -> 751
      //   742: aload_0
      //   743: bipush #6
      //   745: putfield state : I
      //   748: goto -> 466
      //   751: aload_0
      //   752: iload #8
      //   754: putfield state : I
      //   757: aload_0
      //   758: iload_2
      //   759: putfield a : I
      //   762: iconst_1
      //   763: ireturn
    }
  }
  
  static class c extends a {
    private static final byte[] b = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47 };
    
    private static final byte[] c = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95 };
    
    int b;
    
    public final boolean b;
    
    public final boolean c;
    
    private int count;
    
    public final boolean d;
    
    private final byte[] d;
    
    private final byte[] e;
    
    public c(int param1Int, byte[] param1ArrayOfbyte) {
      boolean bool;
      boolean bool1;
      this.a = param1ArrayOfbyte;
      boolean bool2 = true;
      if ((param1Int & 0x1) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.b = bool1;
      if ((param1Int & 0x2) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.c = bool1;
      if ((param1Int & 0x4) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.d = bool1;
      if ((param1Int & 0x8) == 0) {
        bool = b;
      } else {
        bool = c;
      } 
      this.e = bool;
      this.d = new byte[2];
      this.b = false;
      if (this.c) {
        param1Int = 19;
      } else {
        param1Int = -1;
      } 
      this.count = param1Int;
    }
    
    public boolean a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield e : [B
      //   4: astore #11
      //   6: aload_0
      //   7: getfield a : [B
      //   10: astore #12
      //   12: aload_0
      //   13: getfield count : I
      //   16: istore #6
      //   18: iload_3
      //   19: iload_2
      //   20: iadd
      //   21: istore #10
      //   23: aload_0
      //   24: getfield b : I
      //   27: istore_3
      //   28: iconst_0
      //   29: istore #9
      //   31: iconst_0
      //   32: istore #8
      //   34: iload_3
      //   35: ifeq -> 183
      //   38: iload_3
      //   39: iconst_1
      //   40: if_icmpeq -> 117
      //   43: iload_3
      //   44: iconst_2
      //   45: if_icmpeq -> 51
      //   48: goto -> 183
      //   51: iload_2
      //   52: iconst_1
      //   53: iadd
      //   54: istore_3
      //   55: iload_3
      //   56: iload #10
      //   58: if_icmpgt -> 183
      //   61: aload_0
      //   62: getfield d : [B
      //   65: astore #13
      //   67: aload #13
      //   69: iconst_0
      //   70: baload
      //   71: istore #5
      //   73: aload #13
      //   75: iconst_1
      //   76: baload
      //   77: istore #7
      //   79: aload_1
      //   80: iload_2
      //   81: baload
      //   82: istore_2
      //   83: aload_0
      //   84: iconst_0
      //   85: putfield b : I
      //   88: iload #7
      //   90: sipush #255
      //   93: iand
      //   94: bipush #8
      //   96: ishl
      //   97: iload #5
      //   99: sipush #255
      //   102: iand
      //   103: bipush #16
      //   105: ishl
      //   106: ior
      //   107: iload_2
      //   108: sipush #255
      //   111: iand
      //   112: ior
      //   113: istore_2
      //   114: goto -> 191
      //   117: iload_2
      //   118: iconst_2
      //   119: iadd
      //   120: iload #10
      //   122: if_icmpgt -> 183
      //   125: aload_0
      //   126: getfield d : [B
      //   129: iconst_0
      //   130: baload
      //   131: istore #5
      //   133: iload_2
      //   134: iconst_1
      //   135: iadd
      //   136: istore #7
      //   138: aload_1
      //   139: iload_2
      //   140: baload
      //   141: istore_2
      //   142: iload #7
      //   144: iconst_1
      //   145: iadd
      //   146: istore_3
      //   147: iload #5
      //   149: sipush #255
      //   152: iand
      //   153: bipush #16
      //   155: ishl
      //   156: iload_2
      //   157: sipush #255
      //   160: iand
      //   161: bipush #8
      //   163: ishl
      //   164: ior
      //   165: aload_1
      //   166: iload #7
      //   168: baload
      //   169: sipush #255
      //   172: iand
      //   173: ior
      //   174: istore_2
      //   175: aload_0
      //   176: iconst_0
      //   177: putfield b : I
      //   180: goto -> 191
      //   183: iconst_m1
      //   184: istore #5
      //   186: iload_2
      //   187: istore_3
      //   188: iload #5
      //   190: istore_2
      //   191: iload_2
      //   192: iconst_m1
      //   193: if_icmpeq -> 306
      //   196: aload #12
      //   198: iconst_0
      //   199: aload #11
      //   201: iload_2
      //   202: bipush #18
      //   204: ishr
      //   205: bipush #63
      //   207: iand
      //   208: baload
      //   209: bastore
      //   210: aload #12
      //   212: iconst_1
      //   213: aload #11
      //   215: iload_2
      //   216: bipush #12
      //   218: ishr
      //   219: bipush #63
      //   221: iand
      //   222: baload
      //   223: bastore
      //   224: aload #12
      //   226: iconst_2
      //   227: aload #11
      //   229: iload_2
      //   230: bipush #6
      //   232: ishr
      //   233: bipush #63
      //   235: iand
      //   236: baload
      //   237: bastore
      //   238: aload #12
      //   240: iconst_3
      //   241: aload #11
      //   243: iload_2
      //   244: bipush #63
      //   246: iand
      //   247: baload
      //   248: bastore
      //   249: iload #6
      //   251: iconst_1
      //   252: isub
      //   253: istore #6
      //   255: iload #6
      //   257: ifne -> 301
      //   260: aload_0
      //   261: getfield d : Z
      //   264: ifeq -> 278
      //   267: iconst_5
      //   268: istore_2
      //   269: aload #12
      //   271: iconst_4
      //   272: bipush #13
      //   274: bastore
      //   275: goto -> 280
      //   278: iconst_4
      //   279: istore_2
      //   280: iload_2
      //   281: iconst_1
      //   282: iadd
      //   283: istore #5
      //   285: aload #12
      //   287: iload_2
      //   288: bipush #10
      //   290: bastore
      //   291: iload #5
      //   293: istore_2
      //   294: bipush #19
      //   296: istore #6
      //   298: goto -> 308
      //   301: iconst_4
      //   302: istore_2
      //   303: goto -> 308
      //   306: iconst_0
      //   307: istore_2
      //   308: iload_3
      //   309: iconst_3
      //   310: iadd
      //   311: istore #5
      //   313: iload #5
      //   315: iload #10
      //   317: if_icmpgt -> 480
      //   320: aload_1
      //   321: iload_3
      //   322: baload
      //   323: istore #7
      //   325: aload_1
      //   326: iload_3
      //   327: iconst_1
      //   328: iadd
      //   329: baload
      //   330: sipush #255
      //   333: iand
      //   334: bipush #8
      //   336: ishl
      //   337: iload #7
      //   339: sipush #255
      //   342: iand
      //   343: bipush #16
      //   345: ishl
      //   346: ior
      //   347: aload_1
      //   348: iload_3
      //   349: iconst_2
      //   350: iadd
      //   351: baload
      //   352: sipush #255
      //   355: iand
      //   356: ior
      //   357: istore_3
      //   358: aload #12
      //   360: iload_2
      //   361: aload #11
      //   363: iload_3
      //   364: bipush #18
      //   366: ishr
      //   367: bipush #63
      //   369: iand
      //   370: baload
      //   371: bastore
      //   372: aload #12
      //   374: iload_2
      //   375: iconst_1
      //   376: iadd
      //   377: aload #11
      //   379: iload_3
      //   380: bipush #12
      //   382: ishr
      //   383: bipush #63
      //   385: iand
      //   386: baload
      //   387: bastore
      //   388: aload #12
      //   390: iload_2
      //   391: iconst_2
      //   392: iadd
      //   393: aload #11
      //   395: iload_3
      //   396: bipush #6
      //   398: ishr
      //   399: bipush #63
      //   401: iand
      //   402: baload
      //   403: bastore
      //   404: aload #12
      //   406: iload_2
      //   407: iconst_3
      //   408: iadd
      //   409: aload #11
      //   411: iload_3
      //   412: bipush #63
      //   414: iand
      //   415: baload
      //   416: bastore
      //   417: iload_2
      //   418: iconst_4
      //   419: iadd
      //   420: istore_2
      //   421: iload #6
      //   423: iconst_1
      //   424: isub
      //   425: istore #6
      //   427: iload #6
      //   429: ifne -> 474
      //   432: aload_0
      //   433: getfield d : Z
      //   436: ifeq -> 454
      //   439: iload_2
      //   440: iconst_1
      //   441: iadd
      //   442: istore_3
      //   443: aload #12
      //   445: iload_2
      //   446: bipush #13
      //   448: bastore
      //   449: iload_3
      //   450: istore_2
      //   451: goto -> 454
      //   454: iload_2
      //   455: iconst_1
      //   456: iadd
      //   457: istore #6
      //   459: aload #12
      //   461: iload_2
      //   462: bipush #10
      //   464: bastore
      //   465: iload #5
      //   467: istore_3
      //   468: iload #6
      //   470: istore_2
      //   471: goto -> 294
      //   474: iload #5
      //   476: istore_3
      //   477: goto -> 308
      //   480: iload #4
      //   482: ifeq -> 1066
      //   485: aload_0
      //   486: getfield b : I
      //   489: istore #5
      //   491: iload_3
      //   492: iload #5
      //   494: isub
      //   495: iload #10
      //   497: iconst_1
      //   498: isub
      //   499: if_icmpne -> 683
      //   502: iload #5
      //   504: ifle -> 521
      //   507: aload_0
      //   508: getfield d : [B
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
      //   546: getfield b : I
      //   549: iload #5
      //   551: isub
      //   552: putfield b : I
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
      //   598: getfield b : Z
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
      //   636: getfield c : Z
      //   639: ifeq -> 1010
      //   642: aload_0
      //   643: getfield d : Z
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
      //   680: goto -> 1010
      //   683: iload_3
      //   684: iload #5
      //   686: isub
      //   687: iload #10
      //   689: iconst_2
      //   690: isub
      //   691: if_icmpne -> 936
      //   694: iload #5
      //   696: iconst_1
      //   697: if_icmple -> 714
      //   700: aload_0
      //   701: getfield d : [B
      //   704: iconst_0
      //   705: baload
      //   706: istore #7
      //   708: iconst_1
      //   709: istore #5
      //   711: goto -> 727
      //   714: aload_1
      //   715: iload_3
      //   716: baload
      //   717: istore #7
      //   719: iload_3
      //   720: iconst_1
      //   721: iadd
      //   722: istore_3
      //   723: iload #9
      //   725: istore #5
      //   727: aload_0
      //   728: getfield b : I
      //   731: ifle -> 758
      //   734: aload_0
      //   735: getfield d : [B
      //   738: astore_1
      //   739: iload #5
      //   741: iconst_1
      //   742: iadd
      //   743: istore #9
      //   745: aload_1
      //   746: iload #5
      //   748: baload
      //   749: istore #8
      //   751: iload #9
      //   753: istore #5
      //   755: goto -> 771
      //   758: iload_3
      //   759: iconst_1
      //   760: iadd
      //   761: istore #9
      //   763: aload_1
      //   764: iload_3
      //   765: baload
      //   766: istore #8
      //   768: iload #9
      //   770: istore_3
      //   771: iload #7
      //   773: sipush #255
      //   776: iand
      //   777: bipush #10
      //   779: ishl
      //   780: iload #8
      //   782: sipush #255
      //   785: iand
      //   786: iconst_2
      //   787: ishl
      //   788: ior
      //   789: istore #7
      //   791: aload_0
      //   792: aload_0
      //   793: getfield b : I
      //   796: iload #5
      //   798: isub
      //   799: putfield b : I
      //   802: iload_2
      //   803: iconst_1
      //   804: iadd
      //   805: istore #5
      //   807: aload #12
      //   809: iload_2
      //   810: aload #11
      //   812: iload #7
      //   814: bipush #12
      //   816: ishr
      //   817: bipush #63
      //   819: iand
      //   820: baload
      //   821: bastore
      //   822: iload #5
      //   824: iconst_1
      //   825: iadd
      //   826: istore #8
      //   828: aload #12
      //   830: iload #5
      //   832: aload #11
      //   834: iload #7
      //   836: bipush #6
      //   838: ishr
      //   839: bipush #63
      //   841: iand
      //   842: baload
      //   843: bastore
      //   844: iload #8
      //   846: iconst_1
      //   847: iadd
      //   848: istore_2
      //   849: aload #12
      //   851: iload #8
      //   853: aload #11
      //   855: iload #7
      //   857: bipush #63
      //   859: iand
      //   860: baload
      //   861: bastore
      //   862: aload_0
      //   863: getfield b : Z
      //   866: ifeq -> 886
      //   869: iload_2
      //   870: iconst_1
      //   871: iadd
      //   872: istore #5
      //   874: aload #12
      //   876: iload_2
      //   877: bipush #61
      //   879: bastore
      //   880: iload #5
      //   882: istore_2
      //   883: goto -> 886
      //   886: iload_2
      //   887: istore #5
      //   889: aload_0
      //   890: getfield c : Z
      //   893: ifeq -> 930
      //   896: iload_2
      //   897: istore #5
      //   899: aload_0
      //   900: getfield d : Z
      //   903: ifeq -> 917
      //   906: aload #12
      //   908: iload_2
      //   909: bipush #13
      //   911: bastore
      //   912: iload_2
      //   913: iconst_1
      //   914: iadd
      //   915: istore #5
      //   917: aload #12
      //   919: iload #5
      //   921: bipush #10
      //   923: bastore
      //   924: iload #5
      //   926: iconst_1
      //   927: iadd
      //   928: istore #5
      //   930: iload_3
      //   931: istore #7
      //   933: goto -> 1010
      //   936: iload_2
      //   937: istore #5
      //   939: iload_3
      //   940: istore #7
      //   942: aload_0
      //   943: getfield c : Z
      //   946: ifeq -> 1010
      //   949: iload_2
      //   950: istore #5
      //   952: iload_3
      //   953: istore #7
      //   955: iload_2
      //   956: ifle -> 1010
      //   959: iload_2
      //   960: istore #5
      //   962: iload_3
      //   963: istore #7
      //   965: iload #6
      //   967: bipush #19
      //   969: if_icmpeq -> 1010
      //   972: aload_0
      //   973: getfield d : Z
      //   976: ifeq -> 996
      //   979: iload_2
      //   980: iconst_1
      //   981: iadd
      //   982: istore #5
      //   984: aload #12
      //   986: iload_2
      //   987: bipush #13
      //   989: bastore
      //   990: iload #5
      //   992: istore_2
      //   993: goto -> 996
      //   996: iload_2
      //   997: iconst_1
      //   998: iadd
      //   999: istore #5
      //   1001: aload #12
      //   1003: iload_2
      //   1004: bipush #10
      //   1006: bastore
      //   1007: iload_3
      //   1008: istore #7
      //   1010: getstatic com/ta/utdid2/a/a/b$c.a : Z
      //   1013: ifne -> 1034
      //   1016: aload_0
      //   1017: getfield b : I
      //   1020: ifne -> 1026
      //   1023: goto -> 1034
      //   1026: new java/lang/AssertionError
      //   1029: dup
      //   1030: invokespecial <init> : ()V
      //   1033: athrow
      //   1034: iload #5
      //   1036: istore #8
      //   1038: getstatic com/ta/utdid2/a/a/b$c.a : Z
      //   1041: ifne -> 1174
      //   1044: iload #7
      //   1046: iload #10
      //   1048: if_icmpne -> 1058
      //   1051: iload #5
      //   1053: istore #8
      //   1055: goto -> 1174
      //   1058: new java/lang/AssertionError
      //   1061: dup
      //   1062: invokespecial <init> : ()V
      //   1065: athrow
      //   1066: iload_3
      //   1067: iload #10
      //   1069: iconst_1
      //   1070: isub
      //   1071: if_icmpne -> 1108
      //   1074: aload_0
      //   1075: getfield d : [B
      //   1078: astore #11
      //   1080: aload_0
      //   1081: getfield b : I
      //   1084: istore #5
      //   1086: aload_0
      //   1087: iload #5
      //   1089: iconst_1
      //   1090: iadd
      //   1091: putfield b : I
      //   1094: aload #11
      //   1096: iload #5
      //   1098: aload_1
      //   1099: iload_3
      //   1100: baload
      //   1101: bastore
      //   1102: iload_2
      //   1103: istore #8
      //   1105: goto -> 1174
      //   1108: iload_2
      //   1109: istore #8
      //   1111: iload_3
      //   1112: iload #10
      //   1114: iconst_2
      //   1115: isub
      //   1116: if_icmpne -> 1174
      //   1119: aload_0
      //   1120: getfield d : [B
      //   1123: astore #11
      //   1125: aload_0
      //   1126: getfield b : I
      //   1129: istore #5
      //   1131: aload_0
      //   1132: iload #5
      //   1134: iconst_1
      //   1135: iadd
      //   1136: putfield b : I
      //   1139: aload #11
      //   1141: iload #5
      //   1143: aload_1
      //   1144: iload_3
      //   1145: baload
      //   1146: bastore
      //   1147: aload_0
      //   1148: getfield b : I
      //   1151: istore #5
      //   1153: aload_0
      //   1154: iload #5
      //   1156: iconst_1
      //   1157: iadd
      //   1158: putfield b : I
      //   1161: aload #11
      //   1163: iload #5
      //   1165: aload_1
      //   1166: iload_3
      //   1167: iconst_1
      //   1168: iadd
      //   1169: baload
      //   1170: bastore
      //   1171: iload_2
      //   1172: istore #8
      //   1174: aload_0
      //   1175: iload #8
      //   1177: putfield a : I
      //   1180: aload_0
      //   1181: iload #6
      //   1183: putfield count : I
      //   1186: iconst_1
      //   1187: ireturn
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */