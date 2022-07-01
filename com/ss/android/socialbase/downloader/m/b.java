package com.ss.android.socialbase.downloader.m;

import java.io.File;

public class b {
  static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(File paramFile) {
    // Byte code:
    //   0: ldc 'MD5'
    //   2: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/io/File;)V
    //   20: astore_0
    //   21: sipush #8192
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: iconst_0
    //   30: aload_3
    //   31: arraylength
    //   32: invokevirtual read : ([BII)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle -> 50
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: iload_1
    //   44: invokevirtual update : ([BII)V
    //   47: goto -> 27
    //   50: aload_2
    //   51: invokevirtual digest : ()[B
    //   54: invokestatic a : ([B)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_0
    //   59: invokevirtual close : ()V
    //   62: aload_2
    //   63: areturn
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual printStackTrace : ()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_3
    //   72: aload_0
    //   73: astore_2
    //   74: aload_3
    //   75: astore_0
    //   76: goto -> 82
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull -> 98
    //   86: aload_2
    //   87: invokevirtual close : ()V
    //   90: goto -> 98
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual printStackTrace : ()V
    //   98: aload_0
    //   99: athrow
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull -> 117
    //   106: aload_0
    //   107: invokevirtual close : ()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual printStackTrace : ()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: goto -> 100
    //   123: astore_2
    //   124: goto -> 102
    // Exception table:
    //   from	to	target	type
    //   0	6	119	java/lang/Exception
    //   0	6	79	finally
    //   12	21	119	java/lang/Exception
    //   12	21	79	finally
    //   21	27	123	java/lang/Exception
    //   21	27	71	finally
    //   27	36	123	java/lang/Exception
    //   27	36	71	finally
    //   40	47	123	java/lang/Exception
    //   40	47	71	finally
    //   50	58	123	java/lang/Exception
    //   50	58	71	finally
    //   58	62	64	java/io/IOException
    //   86	90	93	java/io/IOException
    //   106	110	112	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return a(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new NullPointerException("bytes is null");
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      if (paramInt1 >= 0 && paramInt1 + paramInt2 <= paramArrayOfbyte.length) {
        int k = paramInt2 * 2;
        char[] arrayOfChar = new char[k];
        int i = 0;
        int j = 0;
        while (i < paramInt2) {
          int m = paramArrayOfbyte[i + paramInt1] & 0xFF;
          int n = j + 1;
          char[] arrayOfChar1 = a;
          arrayOfChar[j] = arrayOfChar1[m >> 4];
          j = n + 1;
          arrayOfChar[n] = arrayOfChar1[m & 0xF];
          i++;
        } 
        return new String(arrayOfChar, 0, k);
      } 
      throw new IndexOutOfBoundsException();
    } 
    throw new NullPointerException("bytes is null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */