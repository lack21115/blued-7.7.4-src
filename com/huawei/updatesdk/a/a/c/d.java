package com.huawei.updatesdk.a.a.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public abstract class d {
  public static String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore #8
    //   8: aconst_null
    //   9: astore #6
    //   11: aconst_null
    //   12: astore #7
    //   14: iload_3
    //   15: ifeq -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_1
    //   21: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   24: astore #9
    //   26: new java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial <init> : (Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: sipush #1024
    //   40: newarray byte
    //   42: astore #6
    //   44: lconst_0
    //   45: lstore #4
    //   47: aload_1
    //   48: astore_0
    //   49: aload_1
    //   50: aload #6
    //   52: invokevirtual read : ([B)I
    //   55: istore_2
    //   56: iload_2
    //   57: iconst_m1
    //   58: if_icmpeq -> 82
    //   61: aload_1
    //   62: astore_0
    //   63: aload #9
    //   65: aload #6
    //   67: iconst_0
    //   68: iload_2
    //   69: invokevirtual update : ([BII)V
    //   72: lload #4
    //   74: iload_2
    //   75: i2l
    //   76: ladd
    //   77: lstore #4
    //   79: goto -> 47
    //   82: aload_1
    //   83: astore_0
    //   84: aload #7
    //   86: astore #6
    //   88: lload #4
    //   90: lconst_0
    //   91: lcmp
    //   92: ifle -> 109
    //   95: aload_1
    //   96: astore_0
    //   97: aload #9
    //   99: invokevirtual digest : ()[B
    //   102: invokestatic a : ([B)Ljava/lang/String;
    //   105: astore #6
    //   107: aload_1
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual close : ()V
    //   113: aload #6
    //   115: areturn
    //   116: astore #6
    //   118: goto -> 152
    //   121: astore #6
    //   123: goto -> 180
    //   126: astore #6
    //   128: goto -> 208
    //   131: astore #6
    //   133: goto -> 236
    //   136: astore #6
    //   138: goto -> 264
    //   141: astore_0
    //   142: aload #6
    //   144: astore_1
    //   145: goto -> 309
    //   148: astore #6
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_1
    //   153: astore_0
    //   154: ldc 'FileUtil'
    //   156: ldc 'getFileHashData IndexOutOfBoundsException'
    //   158: aload #6
    //   160: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload #8
    //   165: astore #6
    //   167: aload_1
    //   168: ifnull -> 299
    //   171: aload_1
    //   172: astore_0
    //   173: aload #7
    //   175: astore #6
    //   177: goto -> 109
    //   180: aload_1
    //   181: astore_0
    //   182: ldc 'FileUtil'
    //   184: ldc 'getFileHashData IllegalArgumentException'
    //   186: aload #6
    //   188: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload #8
    //   193: astore #6
    //   195: aload_1
    //   196: ifnull -> 299
    //   199: aload_1
    //   200: astore_0
    //   201: aload #7
    //   203: astore #6
    //   205: goto -> 109
    //   208: aload_1
    //   209: astore_0
    //   210: ldc 'FileUtil'
    //   212: ldc 'getFileHashData IOException'
    //   214: aload #6
    //   216: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload #8
    //   221: astore #6
    //   223: aload_1
    //   224: ifnull -> 299
    //   227: aload_1
    //   228: astore_0
    //   229: aload #7
    //   231: astore #6
    //   233: goto -> 109
    //   236: aload_1
    //   237: astore_0
    //   238: ldc 'FileUtil'
    //   240: ldc 'getFileHashData FileNotFoundException'
    //   242: aload #6
    //   244: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload #8
    //   249: astore #6
    //   251: aload_1
    //   252: ifnull -> 299
    //   255: aload_1
    //   256: astore_0
    //   257: aload #7
    //   259: astore #6
    //   261: goto -> 109
    //   264: aload_1
    //   265: astore_0
    //   266: ldc 'FileUtil'
    //   268: ldc 'getFileHashData NoSuchAlgorithmException'
    //   270: aload #6
    //   272: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload #8
    //   277: astore #6
    //   279: aload_1
    //   280: ifnull -> 299
    //   283: aload_1
    //   284: astore_0
    //   285: aload #7
    //   287: astore #6
    //   289: goto -> 109
    //   292: ldc 'FileUtil'
    //   294: ldc 'Close FileInputStream failed!'
    //   296: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload #6
    //   301: areturn
    //   302: astore #6
    //   304: aload_0
    //   305: astore_1
    //   306: aload #6
    //   308: astore_0
    //   309: aload_1
    //   310: ifnull -> 327
    //   313: aload_1
    //   314: invokevirtual close : ()V
    //   317: goto -> 327
    //   320: ldc 'FileUtil'
    //   322: ldc 'Close FileInputStream failed!'
    //   324: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload_0
    //   328: athrow
    //   329: astore_0
    //   330: goto -> 292
    //   333: astore_1
    //   334: goto -> 320
    //   337: astore #6
    //   339: aconst_null
    //   340: astore_1
    //   341: goto -> 180
    //   344: astore #6
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -> 208
    //   351: astore #6
    //   353: aconst_null
    //   354: astore_1
    //   355: goto -> 236
    //   358: astore #6
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -> 264
    // Exception table:
    //   from	to	target	type
    //   20	35	358	java/security/NoSuchAlgorithmException
    //   20	35	351	java/io/FileNotFoundException
    //   20	35	344	java/io/IOException
    //   20	35	337	java/lang/IllegalArgumentException
    //   20	35	148	java/lang/IndexOutOfBoundsException
    //   20	35	141	finally
    //   37	44	136	java/security/NoSuchAlgorithmException
    //   37	44	131	java/io/FileNotFoundException
    //   37	44	126	java/io/IOException
    //   37	44	121	java/lang/IllegalArgumentException
    //   37	44	116	java/lang/IndexOutOfBoundsException
    //   37	44	302	finally
    //   49	56	136	java/security/NoSuchAlgorithmException
    //   49	56	131	java/io/FileNotFoundException
    //   49	56	126	java/io/IOException
    //   49	56	121	java/lang/IllegalArgumentException
    //   49	56	116	java/lang/IndexOutOfBoundsException
    //   49	56	302	finally
    //   63	72	136	java/security/NoSuchAlgorithmException
    //   63	72	131	java/io/FileNotFoundException
    //   63	72	126	java/io/IOException
    //   63	72	121	java/lang/IllegalArgumentException
    //   63	72	116	java/lang/IndexOutOfBoundsException
    //   63	72	302	finally
    //   97	107	136	java/security/NoSuchAlgorithmException
    //   97	107	131	java/io/FileNotFoundException
    //   97	107	126	java/io/IOException
    //   97	107	121	java/lang/IllegalArgumentException
    //   97	107	116	java/lang/IndexOutOfBoundsException
    //   97	107	302	finally
    //   109	113	329	java/io/IOException
    //   154	163	302	finally
    //   182	191	302	finally
    //   210	219	302	finally
    //   238	247	302	finally
    //   266	275	302	finally
    //   313	317	333	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        a.a("FileUtil", "Closeable exception", iOException);
      }  
  }
  
  public static boolean a(File paramFile) {
    if (paramFile == null || !paramFile.exists())
      return true; 
    if (paramFile.isFile())
      return paramFile.delete(); 
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null && arrayOfFile.length > 0) {
      int i = 0;
      int j = arrayOfFile.length;
      while (i < j) {
        a(arrayOfFile[i]);
        i++;
      } 
    } 
    return paramFile.delete();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */