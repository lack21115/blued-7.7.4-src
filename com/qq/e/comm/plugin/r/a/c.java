package com.qq.e.comm.plugin.r.a;

import android.content.Context;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;

class c {
  public static String a(Context paramContext) {
    File file = c(paramContext, "config");
    if (file != null)
      try {
        String str = a(file);
        if (str != null)
          return com.qq.e.comm.plugin.util.c.b(str); 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  private static String a(File paramFile) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull -> 131
    //   8: aload_0
    //   9: invokevirtual exists : ()Z
    //   12: ifne -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new java/io/BufferedReader
    //   20: dup
    //   21: new java/io/InputStreamReader
    //   24: dup
    //   25: new java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial <init> : (Ljava/io/File;)V
    //   33: ldc 'UTF-8'
    //   35: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial <init> : (Ljava/io/Reader;)V
    //   41: astore_0
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_1
    //   50: aload_0
    //   51: invokevirtual readLine : ()Ljava/lang/String;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull -> 68
    //   59: aload_1
    //   60: aload_2
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -> 50
    //   68: aload_1
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual close : ()V
    //   77: aload_1
    //   78: areturn
    //   79: astore_0
    //   80: ldc 'Exception while close bufferreader'
    //   82: aload_0
    //   83: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_1
    //   87: areturn
    //   88: astore_2
    //   89: aload_0
    //   90: astore_1
    //   91: goto -> 111
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: goto -> 109
    //   102: astore_2
    //   103: goto -> 111
    //   106: astore_0
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: athrow
    //   111: aload_1
    //   112: ifnull -> 129
    //   115: aload_1
    //   116: invokevirtual close : ()V
    //   119: goto -> 129
    //   122: astore_0
    //   123: ldc 'Exception while close bufferreader'
    //   125: aload_0
    //   126: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: athrow
    //   131: aconst_null
    //   132: areturn
    // Exception table:
    //   from	to	target	type
    //   17	42	106	java/io/IOException
    //   17	42	102	finally
    //   42	50	94	java/io/IOException
    //   42	50	88	finally
    //   50	55	94	java/io/IOException
    //   50	55	88	finally
    //   59	65	94	java/io/IOException
    //   59	65	88	finally
    //   68	73	94	java/io/IOException
    //   68	73	88	finally
    //   73	77	79	java/lang/Exception
    //   109	111	102	finally
    //   115	119	122	java/lang/Exception
  }
  
  private static void a(Context paramContext, File paramFile, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore #4
    //   8: aconst_null
    //   9: astore_0
    //   10: new java/io/OutputStreamWriter
    //   13: dup
    //   14: new java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial <init> : (Ljava/io/File;)V
    //   22: ldc 'UTF-8'
    //   24: invokespecial <init> : (Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_2
    //   29: astore_0
    //   30: iload_3
    //   31: ifeq -> 39
    //   34: aload_2
    //   35: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_1
    //   40: aload_0
    //   41: invokevirtual write : (Ljava/lang/String;)V
    //   44: aload_1
    //   45: invokevirtual close : ()V
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: astore_1
    //   54: goto -> 86
    //   57: goto -> 64
    //   60: astore_1
    //   61: goto -> 86
    //   64: aload_1
    //   65: astore_0
    //   66: ldc 'write mediation config to file fail'
    //   68: invokestatic d : (Ljava/lang/String;)V
    //   71: aload_1
    //   72: ifnull -> 85
    //   75: aload_1
    //   76: invokevirtual close : ()V
    //   79: return
    //   80: ldc 'close config writer failed'
    //   82: invokestatic d : (Ljava/lang/String;)V
    //   85: return
    //   86: aload_0
    //   87: ifnull -> 102
    //   90: aload_0
    //   91: invokevirtual close : ()V
    //   94: goto -> 102
    //   97: ldc 'close config writer failed'
    //   99: invokestatic d : (Ljava/lang/String;)V
    //   102: aload_1
    //   103: athrow
    //   104: astore_0
    //   105: aload #4
    //   107: astore_1
    //   108: goto -> 64
    //   111: astore_0
    //   112: goto -> 57
    //   115: astore_0
    //   116: goto -> 80
    //   119: astore_0
    //   120: goto -> 97
    // Exception table:
    //   from	to	target	type
    //   10	28	104	java/lang/Exception
    //   10	28	60	finally
    //   34	39	111	java/lang/Exception
    //   34	39	49	finally
    //   39	44	111	java/lang/Exception
    //   39	44	49	finally
    //   44	48	115	java/lang/Exception
    //   66	71	60	finally
    //   75	79	115	java/lang/Exception
    //   90	94	119	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString) {
    a(paramContext, c(paramContext, "config"), paramString, true);
  }
  
  public static void b(Context paramContext, String paramString) {
    a(paramContext, c(paramContext, "test"), paramString, false);
  }
  
  private static File c(Context paramContext, String paramString) {
    null = paramContext.getDir("e_qq_com_mediation", 0);
    if (!null.exists() && !null.mkdirs()) {
      GDTLogger.w("Create mediation config dir failed!");
    } else {
      File file = new File(null, paramString);
      null = file;
      try {
        if (!file.exists()) {
          null = file;
          if (!file.createNewFile()) {
            GDTLogger.w("Create mediation config file failed!");
          } else {
            return null;
          } 
        } else {
          return null;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        GDTLogger.w("Create mediation config file failed!");
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */