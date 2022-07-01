package com.tencent.tbs.sdk.extension.partner.b.a;

import java.io.File;

public class b {
  public static String a(File paramFile) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 'MD5'
    //   4: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore_2
    //   8: goto -> 34
    //   11: astore_0
    //   12: aload_3
    //   13: astore_2
    //   14: goto -> 113
    //   17: aconst_null
    //   18: astore_0
    //   19: goto -> 131
    //   22: aconst_null
    //   23: astore_0
    //   24: goto -> 148
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual printStackTrace : ()V
    //   32: aconst_null
    //   33: astore_2
    //   34: new java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial <init> : (Ljava/io/File;)V
    //   42: astore_0
    //   43: sipush #8192
    //   46: newarray byte
    //   48: astore_3
    //   49: aload_2
    //   50: ifnull -> 95
    //   53: aload_0
    //   54: aload_3
    //   55: invokevirtual read : ([B)I
    //   58: istore_1
    //   59: iload_1
    //   60: iconst_m1
    //   61: if_icmpeq -> 74
    //   64: aload_2
    //   65: aload_3
    //   66: iconst_0
    //   67: iload_1
    //   68: invokevirtual update : ([BII)V
    //   71: goto -> 53
    //   74: aload_2
    //   75: invokevirtual digest : ()[B
    //   78: invokestatic a : ([B)Ljava/lang/String;
    //   81: astore_2
    //   82: aload_0
    //   83: invokevirtual close : ()V
    //   86: aload_2
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual printStackTrace : ()V
    //   93: aload_2
    //   94: areturn
    //   95: aload_0
    //   96: invokevirtual close : ()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual printStackTrace : ()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_3
    //   109: aload_0
    //   110: astore_2
    //   111: aload_3
    //   112: astore_0
    //   113: aload_2
    //   114: ifnull -> 129
    //   117: aload_2
    //   118: invokevirtual close : ()V
    //   121: goto -> 129
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual printStackTrace : ()V
    //   129: aload_0
    //   130: athrow
    //   131: aload_0
    //   132: ifnull -> 146
    //   135: aload_0
    //   136: invokevirtual close : ()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual printStackTrace : ()V
    //   146: aconst_null
    //   147: areturn
    //   148: aload_0
    //   149: ifnull -> 163
    //   152: aload_0
    //   153: invokevirtual close : ()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual printStackTrace : ()V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: goto -> 22
    //   169: astore_0
    //   170: goto -> 17
    //   173: astore_2
    //   174: goto -> 148
    //   177: astore_2
    //   178: goto -> 131
    // Exception table:
    //   from	to	target	type
    //   2	8	27	java/security/NoSuchAlgorithmException
    //   2	8	165	java/io/FileNotFoundException
    //   2	8	169	java/io/IOException
    //   2	8	11	finally
    //   28	32	165	java/io/FileNotFoundException
    //   28	32	169	java/io/IOException
    //   28	32	11	finally
    //   34	43	165	java/io/FileNotFoundException
    //   34	43	169	java/io/IOException
    //   34	43	11	finally
    //   43	49	173	java/io/FileNotFoundException
    //   43	49	177	java/io/IOException
    //   43	49	108	finally
    //   53	59	173	java/io/FileNotFoundException
    //   53	59	177	java/io/IOException
    //   53	59	108	finally
    //   64	71	173	java/io/FileNotFoundException
    //   64	71	177	java/io/IOException
    //   64	71	108	finally
    //   74	82	173	java/io/FileNotFoundException
    //   74	82	177	java/io/IOException
    //   74	82	108	finally
    //   82	86	88	java/io/IOException
    //   95	99	101	java/io/IOException
    //   117	121	124	java/io/IOException
    //   135	139	141	java/io/IOException
    //   152	156	158	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */