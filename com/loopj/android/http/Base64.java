package com.loopj.android.http;

import java.io.UnsupportedEncodingException;

public class Base64 {
  public static final int CRLF = 4;
  
  public static final int DEFAULT = 0;
  
  public static final int NO_CLOSE = 16;
  
  public static final int NO_PADDING = 1;
  
  public static final int NO_WRAP = 2;
  
  public static final int URL_SAFE = 8;
  
  public static byte[] decode(String paramString, int paramInt) {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt) {
    return decode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    Decoder decoder = new Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (decoder.process(paramArrayOfbyte, paramInt1, paramInt2, true)) {
      if (decoder.op == decoder.output.length)
        return decoder.output; 
      paramArrayOfbyte = new byte[decoder.op];
      System.arraycopy(decoder.output, 0, paramArrayOfbyte, 0, decoder.op);
      return paramArrayOfbyte;
    } 
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] encode(byte[] paramArrayOfbyte, int paramInt) {
    return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    Encoder encoder = new Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    boolean bool = encoder.do_padding;
    byte b = 2;
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
    if (encoder.do_newline) {
      i = paramInt3;
      if (paramInt2 > 0) {
        int j = (paramInt2 - 1) / 57;
        if (encoder.do_cr) {
          i = b;
        } else {
          i = 1;
        } 
        i = paramInt3 + (j + 1) * i;
      } 
    } 
    encoder.output = new byte[i];
    encoder.process(paramArrayOfbyte, paramInt1, paramInt2, true);
    return encoder.output;
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
  
  static abstract class Coder {
    public int op;
    
    public byte[] output;
    
    public abstract int maxOutputSize(int param1Int);
    
    public abstract boolean process(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean);
  }
  
  static class Decoder extends Coder {
    private static final int[] DECODE = new int[] { 
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
    
    private static final int[] DECODE_WEBSAFE = new int[] { 
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
    
    private static final int EQUALS = -2;
    
    private static final int SKIP = -1;
    
    private final int[] alphabet;
    
    private int state;
    
    private int value;
    
    public Decoder(int param1Int, byte[] param1ArrayOfbyte) {
      int[] arrayOfInt;
      this.output = param1ArrayOfbyte;
      if ((param1Int & 0x8) == 0) {
        arrayOfInt = DECODE;
      } else {
        arrayOfInt = DECODE_WEBSAFE;
      } 
      this.alphabet = arrayOfInt;
      this.state = 0;
      this.value = 0;
    }
    
    public int maxOutputSize(int param1Int) {
      return param1Int * 3 / 4 + 10;
    }
    
    public boolean process(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
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
      //   27: getfield output : [B
      //   30: astore #11
      //   32: aload_0
      //   33: getfield alphabet : [I
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
      //   640: putfield op : I
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
      //   759: putfield op : I
      //   762: iconst_1
      //   763: ireturn
    }
  }
  
  static class Encoder extends Coder {
    private static final byte[] ENCODE = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47 };
    
    private static final byte[] ENCODE_WEBSAFE = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95 };
    
    public static final int LINE_GROUPS = 19;
    
    private final byte[] alphabet;
    
    private int count;
    
    public final boolean do_cr;
    
    public final boolean do_newline;
    
    public final boolean do_padding;
    
    private final byte[] tail;
    
    int tailLen;
    
    public Encoder(int param1Int, byte[] param1ArrayOfbyte) {
      boolean bool1;
      this.output = param1ArrayOfbyte;
      boolean bool2 = true;
      if ((param1Int & 0x1) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.do_padding = bool1;
      if ((param1Int & 0x2) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.do_newline = bool1;
      if ((param1Int & 0x4) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.do_cr = bool1;
      if ((param1Int & 0x8) == 0) {
        param1ArrayOfbyte = ENCODE;
      } else {
        param1ArrayOfbyte = ENCODE_WEBSAFE;
      } 
      this.alphabet = param1ArrayOfbyte;
      this.tail = new byte[2];
      this.tailLen = 0;
      if (this.do_newline) {
        param1Int = 19;
      } else {
        param1Int = -1;
      } 
      this.count = param1Int;
    }
    
    public int maxOutputSize(int param1Int) {
      return param1Int * 8 / 5 + 10;
    }
    
    public boolean process(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield alphabet : [B
      //   4: astore #11
      //   6: aload_0
      //   7: getfield output : [B
      //   10: astore #12
      //   12: aload_0
      //   13: getfield count : I
      //   16: istore #5
      //   18: iload_3
      //   19: iload_2
      //   20: iadd
      //   21: istore #9
      //   23: aload_0
      //   24: getfield tailLen : I
      //   27: istore_3
      //   28: iconst_0
      //   29: istore #8
      //   31: iconst_0
      //   32: istore #7
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
      //   56: iload #9
      //   58: if_icmpgt -> 183
      //   61: aload_0
      //   62: getfield tail : [B
      //   65: astore #13
      //   67: aload #13
      //   69: iconst_0
      //   70: baload
      //   71: istore #6
      //   73: aload #13
      //   75: iconst_1
      //   76: baload
      //   77: istore #10
      //   79: aload_1
      //   80: iload_2
      //   81: baload
      //   82: istore_2
      //   83: aload_0
      //   84: iconst_0
      //   85: putfield tailLen : I
      //   88: iload #10
      //   90: sipush #255
      //   93: iand
      //   94: bipush #8
      //   96: ishl
      //   97: iload #6
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
      //   120: iload #9
      //   122: if_icmpgt -> 183
      //   125: aload_0
      //   126: getfield tail : [B
      //   129: iconst_0
      //   130: baload
      //   131: istore #6
      //   133: iload_2
      //   134: iconst_1
      //   135: iadd
      //   136: istore #10
      //   138: aload_1
      //   139: iload_2
      //   140: baload
      //   141: istore_2
      //   142: iload #10
      //   144: iconst_1
      //   145: iadd
      //   146: istore_3
      //   147: iload #6
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
      //   166: iload #10
      //   168: baload
      //   169: sipush #255
      //   172: iand
      //   173: ior
      //   174: istore_2
      //   175: aload_0
      //   176: iconst_0
      //   177: putfield tailLen : I
      //   180: goto -> 191
      //   183: iconst_m1
      //   184: istore #6
      //   186: iload_2
      //   187: istore_3
      //   188: iload #6
      //   190: istore_2
      //   191: iload_2
      //   192: iconst_m1
      //   193: if_icmpeq -> 312
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
      //   249: iload #5
      //   251: iconst_1
      //   252: isub
      //   253: istore #5
      //   255: iload #5
      //   257: ifne -> 304
      //   260: aload_0
      //   261: getfield do_cr : Z
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
      //   296: istore #5
      //   298: iload_3
      //   299: istore #6
      //   301: goto -> 317
      //   304: iconst_4
      //   305: istore_2
      //   306: iload_3
      //   307: istore #6
      //   309: goto -> 317
      //   312: iconst_0
      //   313: istore_2
      //   314: iload_3
      //   315: istore #6
      //   317: iload #6
      //   319: iconst_3
      //   320: iadd
      //   321: istore_3
      //   322: iload_3
      //   323: iload #9
      //   325: if_icmpgt -> 495
      //   328: aload_1
      //   329: iload #6
      //   331: baload
      //   332: istore #10
      //   334: aload_1
      //   335: iload #6
      //   337: iconst_1
      //   338: iadd
      //   339: baload
      //   340: sipush #255
      //   343: iand
      //   344: bipush #8
      //   346: ishl
      //   347: iload #10
      //   349: sipush #255
      //   352: iand
      //   353: bipush #16
      //   355: ishl
      //   356: ior
      //   357: aload_1
      //   358: iload #6
      //   360: iconst_2
      //   361: iadd
      //   362: baload
      //   363: sipush #255
      //   366: iand
      //   367: ior
      //   368: istore #6
      //   370: aload #12
      //   372: iload_2
      //   373: aload #11
      //   375: iload #6
      //   377: bipush #18
      //   379: ishr
      //   380: bipush #63
      //   382: iand
      //   383: baload
      //   384: bastore
      //   385: aload #12
      //   387: iload_2
      //   388: iconst_1
      //   389: iadd
      //   390: aload #11
      //   392: iload #6
      //   394: bipush #12
      //   396: ishr
      //   397: bipush #63
      //   399: iand
      //   400: baload
      //   401: bastore
      //   402: aload #12
      //   404: iload_2
      //   405: iconst_2
      //   406: iadd
      //   407: aload #11
      //   409: iload #6
      //   411: bipush #6
      //   413: ishr
      //   414: bipush #63
      //   416: iand
      //   417: baload
      //   418: bastore
      //   419: aload #12
      //   421: iload_2
      //   422: iconst_3
      //   423: iadd
      //   424: aload #11
      //   426: iload #6
      //   428: bipush #63
      //   430: iand
      //   431: baload
      //   432: bastore
      //   433: iload_2
      //   434: iconst_4
      //   435: iadd
      //   436: istore_2
      //   437: iload #5
      //   439: iconst_1
      //   440: isub
      //   441: istore #5
      //   443: iload #5
      //   445: ifne -> 489
      //   448: aload_0
      //   449: getfield do_cr : Z
      //   452: ifeq -> 472
      //   455: iload_2
      //   456: iconst_1
      //   457: iadd
      //   458: istore #5
      //   460: aload #12
      //   462: iload_2
      //   463: bipush #13
      //   465: bastore
      //   466: iload #5
      //   468: istore_2
      //   469: goto -> 472
      //   472: iload_2
      //   473: iconst_1
      //   474: iadd
      //   475: istore #5
      //   477: aload #12
      //   479: iload_2
      //   480: bipush #10
      //   482: bastore
      //   483: iload #5
      //   485: istore_2
      //   486: goto -> 294
      //   489: iload_3
      //   490: istore #6
      //   492: goto -> 317
      //   495: iload #4
      //   497: ifeq -> 964
      //   500: aload_0
      //   501: getfield tailLen : I
      //   504: istore_3
      //   505: iload #6
      //   507: iload_3
      //   508: isub
      //   509: iload #9
      //   511: iconst_1
      //   512: isub
      //   513: if_icmpne -> 680
      //   516: iload_3
      //   517: ifle -> 533
      //   520: aload_0
      //   521: getfield tail : [B
      //   524: iconst_0
      //   525: baload
      //   526: istore #6
      //   528: iconst_1
      //   529: istore_3
      //   530: goto -> 542
      //   533: aload_1
      //   534: iload #6
      //   536: baload
      //   537: istore #6
      //   539: iload #7
      //   541: istore_3
      //   542: iload #6
      //   544: sipush #255
      //   547: iand
      //   548: iconst_4
      //   549: ishl
      //   550: istore #6
      //   552: aload_0
      //   553: aload_0
      //   554: getfield tailLen : I
      //   557: iload_3
      //   558: isub
      //   559: putfield tailLen : I
      //   562: iload_2
      //   563: iconst_1
      //   564: iadd
      //   565: istore #7
      //   567: aload #12
      //   569: iload_2
      //   570: aload #11
      //   572: iload #6
      //   574: bipush #6
      //   576: ishr
      //   577: bipush #63
      //   579: iand
      //   580: baload
      //   581: bastore
      //   582: iload #7
      //   584: iconst_1
      //   585: iadd
      //   586: istore_3
      //   587: aload #12
      //   589: iload #7
      //   591: aload #11
      //   593: iload #6
      //   595: bipush #63
      //   597: iand
      //   598: baload
      //   599: bastore
      //   600: iload_3
      //   601: istore_2
      //   602: aload_0
      //   603: getfield do_padding : Z
      //   606: ifeq -> 632
      //   609: iload_3
      //   610: iconst_1
      //   611: iadd
      //   612: istore #6
      //   614: aload #12
      //   616: iload_3
      //   617: bipush #61
      //   619: bastore
      //   620: iload #6
      //   622: iconst_1
      //   623: iadd
      //   624: istore_2
      //   625: aload #12
      //   627: iload #6
      //   629: bipush #61
      //   631: bastore
      //   632: iload_2
      //   633: istore_3
      //   634: aload_0
      //   635: getfield do_newline : Z
      //   638: ifeq -> 1065
      //   641: aload_0
      //   642: getfield do_cr : Z
      //   645: ifeq -> 663
      //   648: iload_2
      //   649: iconst_1
      //   650: iadd
      //   651: istore_3
      //   652: aload #12
      //   654: iload_2
      //   655: bipush #13
      //   657: bastore
      //   658: iload_3
      //   659: istore_2
      //   660: goto -> 663
      //   663: iload_2
      //   664: iconst_1
      //   665: iadd
      //   666: istore_3
      //   667: aload #12
      //   669: iload_2
      //   670: bipush #10
      //   672: bastore
      //   673: iload_3
      //   674: istore_2
      //   675: iload_2
      //   676: istore_3
      //   677: goto -> 1065
      //   680: iload #6
      //   682: iload_3
      //   683: isub
      //   684: iload #9
      //   686: iconst_2
      //   687: isub
      //   688: if_icmpne -> 905
      //   691: iload_3
      //   692: iconst_1
      //   693: if_icmple -> 709
      //   696: aload_0
      //   697: getfield tail : [B
      //   700: iconst_0
      //   701: baload
      //   702: istore #7
      //   704: iconst_1
      //   705: istore_3
      //   706: goto -> 724
      //   709: aload_1
      //   710: iload #6
      //   712: baload
      //   713: istore #7
      //   715: iload #6
      //   717: iconst_1
      //   718: iadd
      //   719: istore #6
      //   721: iload #8
      //   723: istore_3
      //   724: aload_0
      //   725: getfield tailLen : I
      //   728: ifle -> 746
      //   731: aload_0
      //   732: getfield tail : [B
      //   735: iload_3
      //   736: baload
      //   737: istore #6
      //   739: iload_3
      //   740: iconst_1
      //   741: iadd
      //   742: istore_3
      //   743: goto -> 752
      //   746: aload_1
      //   747: iload #6
      //   749: baload
      //   750: istore #6
      //   752: iload #7
      //   754: sipush #255
      //   757: iand
      //   758: bipush #10
      //   760: ishl
      //   761: iload #6
      //   763: sipush #255
      //   766: iand
      //   767: iconst_2
      //   768: ishl
      //   769: ior
      //   770: istore #6
      //   772: aload_0
      //   773: aload_0
      //   774: getfield tailLen : I
      //   777: iload_3
      //   778: isub
      //   779: putfield tailLen : I
      //   782: iload_2
      //   783: iconst_1
      //   784: iadd
      //   785: istore_3
      //   786: aload #12
      //   788: iload_2
      //   789: aload #11
      //   791: iload #6
      //   793: bipush #12
      //   795: ishr
      //   796: bipush #63
      //   798: iand
      //   799: baload
      //   800: bastore
      //   801: iload_3
      //   802: iconst_1
      //   803: iadd
      //   804: istore #7
      //   806: aload #12
      //   808: iload_3
      //   809: aload #11
      //   811: iload #6
      //   813: bipush #6
      //   815: ishr
      //   816: bipush #63
      //   818: iand
      //   819: baload
      //   820: bastore
      //   821: iload #7
      //   823: iconst_1
      //   824: iadd
      //   825: istore_2
      //   826: aload #12
      //   828: iload #7
      //   830: aload #11
      //   832: iload #6
      //   834: bipush #63
      //   836: iand
      //   837: baload
      //   838: bastore
      //   839: aload_0
      //   840: getfield do_padding : Z
      //   843: ifeq -> 861
      //   846: iload_2
      //   847: iconst_1
      //   848: iadd
      //   849: istore_3
      //   850: aload #12
      //   852: iload_2
      //   853: bipush #61
      //   855: bastore
      //   856: iload_3
      //   857: istore_2
      //   858: goto -> 861
      //   861: aload_0
      //   862: getfield do_newline : Z
      //   865: ifeq -> 900
      //   868: iload_2
      //   869: istore_3
      //   870: aload_0
      //   871: getfield do_cr : Z
      //   874: ifeq -> 887
      //   877: aload #12
      //   879: iload_2
      //   880: bipush #13
      //   882: bastore
      //   883: iload_2
      //   884: iconst_1
      //   885: iadd
      //   886: istore_3
      //   887: iload_3
      //   888: iconst_1
      //   889: iadd
      //   890: istore_2
      //   891: aload #12
      //   893: iload_3
      //   894: bipush #10
      //   896: bastore
      //   897: goto -> 675
      //   900: iload_2
      //   901: istore_3
      //   902: goto -> 1065
      //   905: iload_2
      //   906: istore_3
      //   907: aload_0
      //   908: getfield do_newline : Z
      //   911: ifeq -> 1065
      //   914: iload_2
      //   915: istore_3
      //   916: iload_2
      //   917: ifle -> 1065
      //   920: iload_2
      //   921: istore_3
      //   922: iload #5
      //   924: bipush #19
      //   926: if_icmpeq -> 1065
      //   929: aload_0
      //   930: getfield do_cr : Z
      //   933: ifeq -> 951
      //   936: iload_2
      //   937: iconst_1
      //   938: iadd
      //   939: istore_3
      //   940: aload #12
      //   942: iload_2
      //   943: bipush #13
      //   945: bastore
      //   946: iload_3
      //   947: istore_2
      //   948: goto -> 951
      //   951: iload_2
      //   952: iconst_1
      //   953: iadd
      //   954: istore_3
      //   955: aload #12
      //   957: iload_2
      //   958: bipush #10
      //   960: bastore
      //   961: goto -> 1065
      //   964: iload #6
      //   966: iload #9
      //   968: iconst_1
      //   969: isub
      //   970: if_icmpne -> 1004
      //   973: aload_0
      //   974: getfield tail : [B
      //   977: astore #11
      //   979: aload_0
      //   980: getfield tailLen : I
      //   983: istore_3
      //   984: aload_0
      //   985: iload_3
      //   986: iconst_1
      //   987: iadd
      //   988: putfield tailLen : I
      //   991: aload #11
      //   993: iload_3
      //   994: aload_1
      //   995: iload #6
      //   997: baload
      //   998: bastore
      //   999: iload_2
      //   1000: istore_3
      //   1001: goto -> 1065
      //   1004: iload_2
      //   1005: istore_3
      //   1006: iload #6
      //   1008: iload #9
      //   1010: iconst_2
      //   1011: isub
      //   1012: if_icmpne -> 1065
      //   1015: aload_0
      //   1016: getfield tail : [B
      //   1019: astore #11
      //   1021: aload_0
      //   1022: getfield tailLen : I
      //   1025: istore_3
      //   1026: aload_0
      //   1027: iload_3
      //   1028: iconst_1
      //   1029: iadd
      //   1030: putfield tailLen : I
      //   1033: aload #11
      //   1035: iload_3
      //   1036: aload_1
      //   1037: iload #6
      //   1039: baload
      //   1040: bastore
      //   1041: aload_0
      //   1042: getfield tailLen : I
      //   1045: istore_3
      //   1046: aload_0
      //   1047: iload_3
      //   1048: iconst_1
      //   1049: iadd
      //   1050: putfield tailLen : I
      //   1053: aload #11
      //   1055: iload_3
      //   1056: aload_1
      //   1057: iload #6
      //   1059: iconst_1
      //   1060: iadd
      //   1061: baload
      //   1062: bastore
      //   1063: iload_2
      //   1064: istore_3
      //   1065: aload_0
      //   1066: iload_3
      //   1067: putfield op : I
      //   1070: aload_0
      //   1071: iload #5
      //   1073: putfield count : I
      //   1076: iconst_1
      //   1077: ireturn
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */