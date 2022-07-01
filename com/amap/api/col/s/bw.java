package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public final class bw {
  public static final String a = bs.c("SYmFja3Vwcw");
  
  public static final String b = bs.c("SLmFkaXU");
  
  public static final String c = bs.c("JIw");
  
  private static String a(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 9) {
      StorageManager storageManager = (StorageManager)paramContext.getSystemService("storage");
    } else {
      paramContext = null;
    } 
    try {
      int i;
      Class<?> clazz = Class.forName(bs.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
      Method method3 = paramContext.getClass().getMethod(bs.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
      Method method1 = clazz.getMethod(bs.c("ZZ2V0UGF0aA"), new Class[0]);
      Method method2 = clazz.getMethod(bs.c("AaXNSZW1vdmFibGUK"), new Class[0]);
      Object object = method3.invoke(paramContext, new Object[0]);
      int j = Array.getLength(object);
      return null;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bw
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   7: astore_0
    //   8: aload_0
    //   9: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq -> 21
    //   17: ldc com/amap/api/col/s/bw
    //   19: monitorexit
    //   20: return
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #4
    //   30: aload #4
    //   32: aload_1
    //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload #4
    //   39: getstatic com/amap/api/col/s/bw.c : Ljava/lang/String;
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload_2
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload #4
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: astore #5
    //   60: new java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore_1
    //   68: aload_1
    //   69: aload_0
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: getstatic java/io/File.separator : Ljava/lang/String;
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_1
    //   83: getstatic com/amap/api/col/s/bw.a : Ljava/lang/String;
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: new java/io/File
    //   93: dup
    //   94: aload_1
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokespecial <init> : (Ljava/lang/String;)V
    //   101: astore_1
    //   102: new java/io/File
    //   105: dup
    //   106: aload_1
    //   107: getstatic com/amap/api/col/s/bw.b : Ljava/lang/String;
    //   110: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   113: astore #4
    //   115: aconst_null
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_1
    //   120: invokevirtual exists : ()Z
    //   123: ifeq -> 133
    //   126: aload_1
    //   127: invokevirtual isDirectory : ()Z
    //   130: ifeq -> 138
    //   133: aload_1
    //   134: invokevirtual mkdirs : ()Z
    //   137: pop
    //   138: aload #4
    //   140: invokevirtual createNewFile : ()Z
    //   143: pop
    //   144: new java/io/RandomAccessFile
    //   147: dup
    //   148: aload #4
    //   150: ldc 'rws'
    //   152: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   160: astore #4
    //   162: aload #4
    //   164: invokevirtual tryLock : ()Ljava/nio/channels/FileLock;
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull -> 190
    //   172: aload_2
    //   173: astore_0
    //   174: aload #4
    //   176: aload #5
    //   178: ldc 'UTF-8'
    //   180: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   183: invokestatic wrap : ([B)Ljava/nio/ByteBuffer;
    //   186: invokevirtual write : (Ljava/nio/ByteBuffer;)I
    //   189: pop
    //   190: aload_2
    //   191: ifnull -> 201
    //   194: aload_2
    //   195: invokevirtual release : ()V
    //   198: goto -> 201
    //   201: aload #4
    //   203: ifnull -> 211
    //   206: aload #4
    //   208: invokevirtual close : ()V
    //   211: aload_1
    //   212: invokestatic a : (Ljava/io/Closeable;)V
    //   215: ldc com/amap/api/col/s/bw
    //   217: monitorexit
    //   218: return
    //   219: aload_0
    //   220: astore_2
    //   221: aload #4
    //   223: astore_0
    //   224: goto -> 236
    //   227: aconst_null
    //   228: astore_0
    //   229: goto -> 236
    //   232: aconst_null
    //   233: astore_0
    //   234: aload_0
    //   235: astore_1
    //   236: aload_2
    //   237: ifnull -> 247
    //   240: aload_2
    //   241: invokevirtual release : ()V
    //   244: goto -> 247
    //   247: aload_0
    //   248: ifnull -> 255
    //   251: aload_0
    //   252: invokevirtual close : ()V
    //   255: aload_1
    //   256: invokestatic a : (Ljava/io/Closeable;)V
    //   259: ldc com/amap/api/col/s/bw
    //   261: monitorexit
    //   262: return
    //   263: astore_0
    //   264: ldc com/amap/api/col/s/bw
    //   266: monitorexit
    //   267: aload_0
    //   268: athrow
    //   269: astore_0
    //   270: goto -> 232
    //   273: astore_0
    //   274: goto -> 227
    //   277: astore_2
    //   278: goto -> 219
    //   281: astore_0
    //   282: goto -> 201
    //   285: astore_0
    //   286: goto -> 211
    //   289: astore_2
    //   290: goto -> 247
    //   293: astore_0
    //   294: goto -> 255
    // Exception table:
    //   from	to	target	type
    //   3	13	263	finally
    //   21	115	263	finally
    //   119	133	269	finally
    //   133	138	269	finally
    //   138	156	269	finally
    //   156	162	273	finally
    //   162	168	277	finally
    //   174	190	277	finally
    //   194	198	281	java/io/IOException
    //   194	198	263	finally
    //   206	211	285	java/io/IOException
    //   206	211	263	finally
    //   211	215	263	finally
    //   240	244	289	java/io/IOException
    //   240	244	263	finally
    //   251	255	293	java/io/IOException
    //   251	255	263	finally
    //   255	259	263	finally
  }
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */