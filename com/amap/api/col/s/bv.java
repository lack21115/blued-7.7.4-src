package com.amap.api.col.s;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class bv {
  private static final byte[] b = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] c = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
      -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] d = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  private static final byte[] e = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
      -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] f = new byte[] { 
      45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
      57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
      74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
      84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
      99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
      109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
      119, 120, 121, 122 };
  
  private static final byte[] g = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
      3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
      -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
      16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
      26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
      36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
      41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
      51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
      61, 62, 63, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9 };
  
  public static String a(byte[] paramArrayOfbyte) {
    try {
      String str = a(paramArrayOfbyte, paramArrayOfbyte.length);
    } catch (IOException iOException) {
      if (a) {
        iOException = null;
      } else {
        throw new AssertionError(iOException.getMessage());
      } 
    } 
    if (!a) {
      if (iOException != null)
        return (String)iOException; 
      throw new AssertionError();
    } 
    return (String)iOException;
  }
  
  private static String a(byte[] paramArrayOfbyte, int paramInt) throws IOException {
    if (paramArrayOfbyte != null) {
      if (paramInt >= 0) {
        if (paramInt + 0 <= paramArrayOfbyte.length) {
          int j = paramInt / 3;
          int i = 4;
          if (paramInt % 3 <= 0)
            i = 0; 
          byte[] arrayOfByte = new byte[j * 4 + i];
          j = 0;
          for (i = 0; j < paramInt - 2; i += 4) {
            a(paramArrayOfbyte, j + 0, 3, arrayOfByte, i);
            j += 3;
          } 
          int k = i;
          if (j < paramInt) {
            a(paramArrayOfbyte, j + 0, paramInt - j, arrayOfByte, i);
            k = i + 4;
          } 
          if (k <= arrayOfByte.length - 1) {
            paramArrayOfbyte = new byte[k];
            System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 0, k);
          } else {
            paramArrayOfbyte = arrayOfByte;
          } 
          try {
            return new String(paramArrayOfbyte, "US-ASCII");
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(paramArrayOfbyte);
          } 
        } 
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfbyte.length) }));
      } 
      throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(paramInt)));
    } 
    throw new NullPointerException("Cannot serialize a null array.");
  }
  
  public static byte[] a(String paramString) throws IOException {
    return b(paramString);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3) {
    boolean bool1;
    boolean bool2;
    byte[] arrayOfByte = b;
    int i = 0;
    if (paramInt2 > 0) {
      bool1 = paramArrayOfbyte1[paramInt1] << 24 >>> 8;
    } else {
      bool1 = false;
    } 
    if (paramInt2 > 1) {
      bool2 = paramArrayOfbyte1[paramInt1 + 1] << 24 >>> 16;
    } else {
      bool2 = false;
    } 
    if (paramInt2 > 2)
      i = paramArrayOfbyte1[paramInt1 + 2] << 24 >>> 24; 
    paramInt1 = bool1 | bool2 | i;
    if (paramInt2 != 1) {
      if (paramInt2 != 2) {
        if (paramInt2 != 3)
          return paramArrayOfbyte2; 
        paramArrayOfbyte2[paramInt3] = arrayOfByte[paramInt1 >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[paramInt1 >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = arrayOfByte[paramInt1 >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = arrayOfByte[paramInt1 & 0x3F];
        return paramArrayOfbyte2;
      } 
      paramArrayOfbyte2[paramInt3] = arrayOfByte[paramInt1 >>> 18];
      paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[paramInt1 >>> 12 & 0x3F];
      paramArrayOfbyte2[paramInt3 + 2] = arrayOfByte[paramInt1 >>> 6 & 0x3F];
      paramArrayOfbyte2[paramInt3 + 3] = 61;
      return paramArrayOfbyte2;
    } 
    paramArrayOfbyte2[paramInt3] = arrayOfByte[paramInt1 >>> 18];
    paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[paramInt1 >>> 12 & 0x3F];
    paramArrayOfbyte2[paramInt3 + 2] = 61;
    paramArrayOfbyte2[paramInt3 + 3] = 61;
    return paramArrayOfbyte2;
  }
  
  private static byte[] b(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 259
    //   4: aload_0
    //   5: ldc 'US-ASCII'
    //   7: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: goto -> 21
    //   16: aload_0
    //   17: invokevirtual getBytes : ()[B
    //   20: astore_0
    //   21: aload_0
    //   22: aload_0
    //   23: arraylength
    //   24: invokestatic b : ([BI)[B
    //   27: astore #7
    //   29: aload #7
    //   31: arraylength
    //   32: iconst_4
    //   33: if_icmplt -> 256
    //   36: ldc 35615
    //   38: aload #7
    //   40: iconst_0
    //   41: baload
    //   42: sipush #255
    //   45: iand
    //   46: aload #7
    //   48: iconst_1
    //   49: baload
    //   50: bipush #8
    //   52: ishl
    //   53: ldc 65280
    //   55: iand
    //   56: ior
    //   57: if_icmpne -> 256
    //   60: sipush #2048
    //   63: newarray byte
    //   65: astore #6
    //   67: aconst_null
    //   68: astore_3
    //   69: aconst_null
    //   70: astore #5
    //   72: new java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #4
    //   81: new java/io/ByteArrayInputStream
    //   84: dup
    //   85: aload #7
    //   87: invokespecial <init> : ([B)V
    //   90: astore_0
    //   91: new java/util/zip/GZIPInputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial <init> : (Ljava/io/InputStream;)V
    //   99: astore_2
    //   100: aload_2
    //   101: aload #6
    //   103: invokevirtual read : ([B)I
    //   106: istore_1
    //   107: iload_1
    //   108: iflt -> 123
    //   111: aload #4
    //   113: aload #6
    //   115: iconst_0
    //   116: iload_1
    //   117: invokevirtual write : ([BII)V
    //   120: goto -> 100
    //   123: aload #4
    //   125: invokevirtual toByteArray : ()[B
    //   128: astore #8
    //   130: aload_0
    //   131: astore #6
    //   133: aload_2
    //   134: astore #5
    //   136: aload #8
    //   138: astore_3
    //   139: aload #4
    //   141: invokevirtual close : ()V
    //   144: aload #8
    //   146: astore_3
    //   147: aload_2
    //   148: invokevirtual close : ()V
    //   151: aload_0
    //   152: invokevirtual close : ()V
    //   155: aload_3
    //   156: areturn
    //   157: astore_3
    //   158: goto -> 233
    //   161: astore_3
    //   162: goto -> 186
    //   165: astore_2
    //   166: goto -> 241
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -> 186
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -> 241
    //   181: astore_3
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: astore_2
    //   186: goto -> 208
    //   189: astore_2
    //   190: aconst_null
    //   191: astore #4
    //   193: aload #4
    //   195: astore_0
    //   196: goto -> 241
    //   199: astore_3
    //   200: aconst_null
    //   201: astore_0
    //   202: aload_0
    //   203: astore_2
    //   204: aload #5
    //   206: astore #4
    //   208: aload_3
    //   209: invokevirtual printStackTrace : ()V
    //   212: aload_0
    //   213: astore #6
    //   215: aload_2
    //   216: astore #5
    //   218: aload #7
    //   220: astore_3
    //   221: aload #4
    //   223: invokevirtual close : ()V
    //   226: aload #7
    //   228: astore_3
    //   229: goto -> 147
    //   232: astore_3
    //   233: aload_2
    //   234: astore #5
    //   236: aload_3
    //   237: astore_2
    //   238: aload #5
    //   240: astore_3
    //   241: aload #4
    //   243: invokevirtual close : ()V
    //   246: aload_3
    //   247: invokevirtual close : ()V
    //   250: aload_0
    //   251: invokevirtual close : ()V
    //   254: aload_2
    //   255: athrow
    //   256: aload #7
    //   258: areturn
    //   259: new java/lang/NullPointerException
    //   262: dup
    //   263: ldc_w 'Input string was null.'
    //   266: invokespecial <init> : (Ljava/lang/String;)V
    //   269: athrow
    //   270: astore_2
    //   271: goto -> 16
    //   274: astore_0
    //   275: aload #6
    //   277: astore_0
    //   278: aload #5
    //   280: astore_2
    //   281: goto -> 147
    //   284: astore_2
    //   285: goto -> 151
    //   288: astore_0
    //   289: aload_3
    //   290: areturn
    //   291: astore #4
    //   293: goto -> 246
    //   296: astore_3
    //   297: goto -> 250
    //   300: astore_0
    //   301: goto -> 254
    // Exception table:
    //   from	to	target	type
    //   4	11	270	java/io/UnsupportedEncodingException
    //   72	81	199	java/io/IOException
    //   72	81	189	finally
    //   81	91	181	java/io/IOException
    //   81	91	175	finally
    //   91	100	169	java/io/IOException
    //   91	100	165	finally
    //   100	107	161	java/io/IOException
    //   100	107	157	finally
    //   111	120	161	java/io/IOException
    //   111	120	157	finally
    //   123	130	161	java/io/IOException
    //   123	130	157	finally
    //   139	144	274	java/lang/Exception
    //   147	151	284	java/lang/Exception
    //   151	155	288	java/lang/Exception
    //   208	212	232	finally
    //   221	226	274	java/lang/Exception
    //   241	246	291	java/lang/Exception
    //   246	250	296	java/lang/Exception
    //   250	254	300	java/lang/Exception
  }
  
  private static byte[] b(byte[] paramArrayOfbyte, int paramInt) throws IOException {
    if (paramArrayOfbyte != null) {
      int i = paramInt + 0;
      if (i <= paramArrayOfbyte.length) {
        if (paramInt == 0)
          return new byte[0]; 
        if (paramInt >= 4) {
          int m;
          byte[] arrayOfByte2 = c;
          byte[] arrayOfByte1 = new byte[paramInt * 3 / 4];
          byte[] arrayOfByte3 = new byte[4];
          int j = 0;
          int k = 0;
          paramInt = 0;
          while (true) {
            m = paramInt;
            if (j < i) {
              byte b = arrayOfByte2[paramArrayOfbyte[j] & 0xFF];
              if (b >= -5) {
                int n = k;
                m = paramInt;
                if (b >= -1) {
                  n = k + 1;
                  arrayOfByte3[k] = paramArrayOfbyte[j];
                  if (n > 3) {
                    if (paramInt >= 0) {
                      n = paramInt + 2;
                      if (n < arrayOfByte1.length) {
                        byte[] arrayOfByte = c;
                        if (arrayOfByte3[2] == 61) {
                          arrayOfByte1[paramInt] = (byte)(((arrayOfByte[arrayOfByte3[0]] & 0xFF) << 18 | (arrayOfByte[arrayOfByte3[1]] & 0xFF) << 12) >>> 16);
                          n = 1;
                        } else if (arrayOfByte3[3] == 61) {
                          n = (arrayOfByte[arrayOfByte3[0]] & 0xFF) << 18 | (arrayOfByte[arrayOfByte3[1]] & 0xFF) << 12 | (arrayOfByte[arrayOfByte3[2]] & 0xFF) << 6;
                          arrayOfByte1[paramInt] = (byte)(n >>> 16);
                          arrayOfByte1[paramInt + 1] = (byte)(n >>> 8);
                          n = 2;
                        } else {
                          k = arrayOfByte[arrayOfByte3[0]];
                          m = arrayOfByte[arrayOfByte3[1]];
                          b = arrayOfByte[arrayOfByte3[2]];
                          k = arrayOfByte[arrayOfByte3[3]] & 0xFF | (k & 0xFF) << 18 | (m & 0xFF) << 12 | (b & 0xFF) << 6;
                          arrayOfByte1[paramInt] = (byte)(k >> 16);
                          arrayOfByte1[paramInt + 1] = (byte)(k >> 8);
                          arrayOfByte1[n] = (byte)k;
                          n = 3;
                        } 
                        m = paramInt + n;
                        if (paramArrayOfbyte[j] == 61)
                          break; 
                        n = 0;
                      } else {
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(arrayOfByte1.length), Integer.valueOf(paramInt) }));
                      } 
                    } else {
                      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(arrayOfByte1.length), Integer.valueOf(paramInt) }));
                    } 
                  } else {
                    m = paramInt;
                  } 
                } 
                j++;
                k = n;
                paramInt = m;
                continue;
              } 
              throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[] { Integer.valueOf(paramArrayOfbyte[j] & 0xFF), Integer.valueOf(j) }));
            } 
            break;
          } 
          paramArrayOfbyte = new byte[m];
          System.arraycopy(arrayOfByte1, 0, paramArrayOfbyte, 0, m);
          return paramArrayOfbyte;
        } 
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(paramInt)));
      } 
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(0), Integer.valueOf(paramInt) }));
    } 
    throw new NullPointerException("Cannot decode null source array.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */