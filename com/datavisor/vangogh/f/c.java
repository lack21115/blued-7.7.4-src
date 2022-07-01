package com.datavisor.vangogh.f;

import com.datavisor.vangogh.c.a;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class c {
  public static int a(String paramString1, String paramString2) {
    try {
      FileWriter fileWriter = new FileWriter(new File(paramString1), false);
    } finally {
      paramString2 = null;
    } 
    try {
      d.b(a.a, paramString2.getMessage());
      return -1;
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {} 
    } 
  }
  
  public static boolean a(String paramString) {
    return f.a(paramString) ? false : (new File(paramString)).exists();
  }
  
  public static String b(String paramString1, String paramString2) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: new java/io/File
    //   13: dup
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual exists : ()Z
    //   24: ifne -> 29
    //   27: aconst_null
    //   28: areturn
    //   29: new java/io/BufferedReader
    //   32: dup
    //   33: new java/io/InputStreamReader
    //   36: dup
    //   37: new java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial <init> : (Ljava/io/File;)V
    //   45: ldc 'UTF-8'
    //   47: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: invokespecial <init> : (Ljava/io/Reader;)V
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: aload_1
    //   57: invokevirtual readLine : ()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull -> 76
    //   65: aload_1
    //   66: astore_0
    //   67: aload_3
    //   68: aload_2
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -> 54
    //   76: aload_1
    //   77: astore_0
    //   78: aload_3
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_1
    //   84: invokevirtual close : ()V
    //   87: aload_2
    //   88: areturn
    //   89: astore_2
    //   90: goto -> 102
    //   93: astore_1
    //   94: aload_2
    //   95: astore_0
    //   96: goto -> 120
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: invokestatic a : (Ljava/lang/Throwable;)V
    //   108: aload_1
    //   109: ifnull -> 116
    //   112: aload_1
    //   113: invokevirtual close : ()V
    //   116: ldc ''
    //   118: areturn
    //   119: astore_1
    //   120: aload_0
    //   121: ifnull -> 128
    //   124: aload_0
    //   125: invokevirtual close : ()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_0
    //   131: aload_2
    //   132: areturn
    //   133: astore_0
    //   134: goto -> 116
    //   137: astore_0
    //   138: goto -> 128
    // Exception table:
    //   from	to	target	type
    //   10	27	99	java/io/IOException
    //   10	27	93	finally
    //   29	54	99	java/io/IOException
    //   29	54	93	finally
    //   56	61	89	java/io/IOException
    //   56	61	119	finally
    //   67	73	89	java/io/IOException
    //   67	73	119	finally
    //   78	83	89	java/io/IOException
    //   78	83	119	finally
    //   83	87	130	finally
    //   104	108	119	finally
    //   112	116	133	finally
    //   124	128	137	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */