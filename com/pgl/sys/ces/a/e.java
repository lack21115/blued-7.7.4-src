package com.pgl.sys.ces.a;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class e {
  public static String a(Context paramContext) {
    // Byte code:
    //   0: ldc com/pgl/sys/ces/a/e
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore_2
    //   11: aload_2
    //   12: aload_0
    //   13: invokevirtual getFilesDir : ()Ljava/io/File;
    //   16: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc '/'
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: ldc 'cid'
    //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: astore_3
    //   42: new java/io/File
    //   45: dup
    //   46: aload_3
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: invokevirtual exists : ()Z
    //   53: ifeq -> 79
    //   56: aload_3
    //   57: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull -> 79
    //   65: aload_2
    //   66: invokevirtual length : ()I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle -> 79
    //   74: ldc com/pgl/sys/ces/a/e
    //   76: monitorexit
    //   77: aload_2
    //   78: areturn
    //   79: aload_0
    //   80: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   83: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   86: ldc 'cid'
    //   88: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   91: astore_2
    //   92: new java/io/ByteArrayOutputStream
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore_0
    //   100: sipush #4096
    //   103: newarray byte
    //   105: astore #4
    //   107: aload_2
    //   108: aload #4
    //   110: iconst_0
    //   111: sipush #4096
    //   114: invokevirtual read : ([BII)I
    //   117: istore_1
    //   118: iload_1
    //   119: iconst_m1
    //   120: if_icmpeq -> 134
    //   123: aload_0
    //   124: aload #4
    //   126: iconst_0
    //   127: iload_1
    //   128: invokevirtual write : ([BII)V
    //   131: goto -> 107
    //   134: new java/io/FileOutputStream
    //   137: dup
    //   138: aload_3
    //   139: invokespecial <init> : (Ljava/lang/String;)V
    //   142: astore_2
    //   143: aload_2
    //   144: aload_0
    //   145: invokevirtual toByteArray : ()[B
    //   148: invokevirtual write : ([B)V
    //   151: aload_2
    //   152: invokevirtual close : ()V
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore_0
    //   163: aload_0
    //   164: ldc 'chmod 777 '
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_0
    //   171: aload_3
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   183: pop
    //   184: aload_3
    //   185: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   188: astore_2
    //   189: aload_2
    //   190: ifnull -> 202
    //   193: aload_2
    //   194: astore_0
    //   195: aload_2
    //   196: invokevirtual length : ()I
    //   199: ifne -> 246
    //   202: new java/io/RandomAccessFile
    //   205: dup
    //   206: aload_3
    //   207: ldc 'rw'
    //   209: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   212: astore_0
    //   213: aload_0
    //   214: ldc2_w 16
    //   217: invokevirtual seek : (J)V
    //   220: aload_0
    //   221: iconst_1
    //   222: newarray byte
    //   224: dup
    //   225: iconst_0
    //   226: iconst_2
    //   227: bastore
    //   228: invokevirtual write : ([B)V
    //   231: aload_0
    //   232: invokevirtual close : ()V
    //   235: aload_3
    //   236: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   239: astore_0
    //   240: goto -> 246
    //   243: ldc '0[<!>]EXCEPTION[<!>]'
    //   245: astore_0
    //   246: aload_0
    //   247: ifnull -> 259
    //   250: aload_0
    //   251: astore_2
    //   252: aload_0
    //   253: invokevirtual length : ()I
    //   256: ifne -> 262
    //   259: ldc '0[<!>]ERROR[<!>]'
    //   261: astore_2
    //   262: ldc com/pgl/sys/ces/a/e
    //   264: monitorexit
    //   265: aload_2
    //   266: areturn
    //   267: astore_0
    //   268: ldc com/pgl/sys/ces/a/e
    //   270: monitorexit
    //   271: aload_0
    //   272: athrow
    //   273: astore_0
    //   274: goto -> 243
    // Exception table:
    //   from	to	target	type
    //   3	61	273	finally
    //   65	70	273	finally
    //   79	107	273	finally
    //   107	118	273	finally
    //   123	131	273	finally
    //   134	189	273	finally
    //   195	202	273	finally
    //   202	240	273	finally
    //   252	259	267	finally
  }
  
  private static String a(BufferedInputStream paramBufferedInputStream) {
    if (paramBufferedInputStream == null)
      return ""; 
    byte[] arrayOfByte = new byte[4096];
    StringBuilder stringBuilder = new StringBuilder();
    try {
      int i;
      do {
        i = paramBufferedInputStream.read(arrayOfByte);
        if (i <= 0)
          continue; 
        stringBuilder.append(new String(arrayOfByte, 0, i));
      } while (i >= 4096);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return stringBuilder.toString();
  }
  
  private static String a(String paramString) {
    String str = null;
    BufferedOutputStream bufferedOutputStream = null;
    BufferedInputStream bufferedInputStream = null;
    try {
      Exception exception;
    } catch (Exception exception) {
    
    } finally {
      Exception exception = null;
      String str1 = null;
    } 
    Object object = null;
    paramString = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */